package org.eclipse.xtext.testlanguages.backtracking.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper.UnorderedGroupState;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.testlanguages.backtracking.services.BeeLangTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalBeeLangTestLanguageParser extends AbstractInternalAntlrParser {
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


        public InternalBeeLangTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBeeLangTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[257+1];
             
             
        }
        

    public String[] getTokenNames() { return InternalBeeLangTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBeeLangTestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

     	private BeeLangTestLanguageGrammarAccess grammarAccess;

        public InternalBeeLangTestLanguageParser(TokenStream input, BeeLangTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected BeeLangTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalBeeLangTestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;
        int entryRuleModel_StartIndex = input.index();
        EObject iv_ruleModel = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return current; }
            // InternalBeeLangTestLanguage.g:72:46: (iv_ruleModel= ruleModel EOF )
            // InternalBeeLangTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, entryRuleModel_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalBeeLangTestLanguage.g:79:1: ruleModel returns [EObject current=null] : ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;
        int ruleModel_StartIndex = input.index();
        EObject lv_units_0_0 = null;

        EObject lv_functions_1_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return current; }
            // InternalBeeLangTestLanguage.g:85:2: ( ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* ) )
            // InternalBeeLangTestLanguage.g:86:2: ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* )
            {
            // InternalBeeLangTestLanguage.g:86:2: ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* )
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

                if ( (synpred2_InternalBeeLangTestLanguage()) ) {
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
                    // InternalBeeLangTestLanguage.g:87:3: ( (lv_units_0_0= ruleUnit ) )*
                    {
                    // InternalBeeLangTestLanguage.g:87:3: ( (lv_units_0_0= ruleUnit ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==RULE_DOCUMENTATION||LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalBeeLangTestLanguage.g:88:4: (lv_units_0_0= ruleUnit )
                    	    {
                    	    // InternalBeeLangTestLanguage.g:88:4: (lv_units_0_0= ruleUnit )
                    	    // InternalBeeLangTestLanguage.g:89:5: lv_units_0_0= ruleUnit
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					newCompositeNode(grammarAccess.getModelAccess().getUnitsUnitParserRuleCall_0_0());
                    	      				
                    	    }
                    	    pushFollow(FOLLOW_3);
                    	    lv_units_0_0=ruleUnit();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					if (current==null) {
                    	      						current = createModelElementForParent(grammarAccess.getModelRule());
                    	      					}
                    	      					add(
                    	      						current,
                    	      						"units",
                    	      						lv_units_0_0,
                    	      						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Unit");
                    	      					afterParserOrEnumRuleCall();
                    	      				
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
                    // InternalBeeLangTestLanguage.g:107:3: ( (lv_functions_1_0= ruleFunction ) )*
                    {
                    // InternalBeeLangTestLanguage.g:107:3: ( (lv_functions_1_0= ruleFunction ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>=RULE_DOCUMENTATION && LA2_0<=RULE_ID)||(LA2_0>=33 && LA2_0<=34)) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalBeeLangTestLanguage.g:108:4: (lv_functions_1_0= ruleFunction )
                    	    {
                    	    // InternalBeeLangTestLanguage.g:108:4: (lv_functions_1_0= ruleFunction )
                    	    // InternalBeeLangTestLanguage.g:109:5: lv_functions_1_0= ruleFunction
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					newCompositeNode(grammarAccess.getModelAccess().getFunctionsFunctionParserRuleCall_1_0());
                    	      				
                    	    }
                    	    pushFollow(FOLLOW_4);
                    	    lv_functions_1_0=ruleFunction();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					if (current==null) {
                    	      						current = createModelElementForParent(grammarAccess.getModelRule());
                    	      					}
                    	      					add(
                    	      						current,
                    	      						"functions",
                    	      						lv_functions_1_0,
                    	      						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Function");
                    	      					afterParserOrEnumRuleCall();
                    	      				
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, ruleModel_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleUnit"
    // InternalBeeLangTestLanguage.g:130:1: entryRuleUnit returns [EObject current=null] : iv_ruleUnit= ruleUnit EOF ;
    public final EObject entryRuleUnit() throws RecognitionException {
        EObject current = null;
        int entryRuleUnit_StartIndex = input.index();
        EObject iv_ruleUnit = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getUnitAccess().getUnorderedGroup_7()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return current; }
            // InternalBeeLangTestLanguage.g:134:2: (iv_ruleUnit= ruleUnit EOF )
            // InternalBeeLangTestLanguage.g:135:2: iv_ruleUnit= ruleUnit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnitRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, entryRuleUnit_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleUnit"


    // $ANTLR start "ruleUnit"
    // InternalBeeLangTestLanguage.g:144:1: ruleUnit returns [EObject current=null] : ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' ) ;
    public final EObject ruleUnit() throws RecognitionException {
        EObject current = null;
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
        EObject lv_implements_7_0 = null;

        EObject lv_implements_9_0 = null;

        AntlrDatatypeRuleToken lv_sourceLocation_14_0 = null;

        AntlrDatatypeRuleToken lv_outputLocation_18_0 = null;

        EObject lv_providedCapabilities_22_0 = null;

        EObject lv_requiredCapabilities_26_0 = null;

        EObject lv_metaRequiredCapabilities_31_0 = null;

        EObject lv_functions_33_0 = null;



        	enterRule();
        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getUnitAccess().getUnorderedGroup_7()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return current; }
            // InternalBeeLangTestLanguage.g:153:2: ( ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' ) )
            // InternalBeeLangTestLanguage.g:154:2: ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' )
            {
            // InternalBeeLangTestLanguage.g:154:2: ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' )
            // InternalBeeLangTestLanguage.g:155:3: () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}'
            {
            // InternalBeeLangTestLanguage.g:155:3: ()
            // InternalBeeLangTestLanguage.g:156:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getUnitAccess().getUnitAction_0(),
              					current);
              			
            }

            }

            // InternalBeeLangTestLanguage.g:165:3: ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_DOCUMENTATION) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:166:4: (lv_documentation_1_0= RULE_DOCUMENTATION )
                    {
                    // InternalBeeLangTestLanguage.g:166:4: (lv_documentation_1_0= RULE_DOCUMENTATION )
                    // InternalBeeLangTestLanguage.g:167:5: lv_documentation_1_0= RULE_DOCUMENTATION
                    {
                    lv_documentation_1_0=(Token)match(input,RULE_DOCUMENTATION,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_documentation_1_0, grammarAccess.getUnitAccess().getDocumentationDOCUMENTATIONTerminalRuleCall_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getUnitRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"documentation",
                      						lv_documentation_1_0,
                      						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.DOCUMENTATION");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,13,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getUnitAccess().getUnitKeyword_2());
              		
            }
            // InternalBeeLangTestLanguage.g:187:3: ( (lv_name_3_0= RULE_ID ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:188:4: (lv_name_3_0= RULE_ID )
                    {
                    // InternalBeeLangTestLanguage.g:188:4: (lv_name_3_0= RULE_ID )
                    // InternalBeeLangTestLanguage.g:189:5: lv_name_3_0= RULE_ID
                    {
                    lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_name_3_0, grammarAccess.getUnitAccess().getNameIDTerminalRuleCall_3_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getUnitRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"name",
                      						lv_name_3_0,
                      						"org.eclipse.xtext.common.Terminals.ID");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalBeeLangTestLanguage.g:205:3: (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:206:4: otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,14,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getUnitAccess().getVersionKeyword_4_0());
                      			
                    }
                    // InternalBeeLangTestLanguage.g:210:4: ( (lv_version_5_0= RULE_ID ) )
                    // InternalBeeLangTestLanguage.g:211:5: (lv_version_5_0= RULE_ID )
                    {
                    // InternalBeeLangTestLanguage.g:211:5: (lv_version_5_0= RULE_ID )
                    // InternalBeeLangTestLanguage.g:212:6: lv_version_5_0= RULE_ID
                    {
                    lv_version_5_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_version_5_0, grammarAccess.getUnitAccess().getVersionIDTerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getUnitRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"version",
                      							lv_version_5_0,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalBeeLangTestLanguage.g:229:3: (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:230:4: otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )*
                    {
                    otherlv_6=(Token)match(input,15,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getUnitAccess().getImplementsKeyword_5_0());
                      			
                    }
                    // InternalBeeLangTestLanguage.g:234:4: ( (lv_implements_7_0= ruleSimpleTypeRef ) )
                    // InternalBeeLangTestLanguage.g:235:5: (lv_implements_7_0= ruleSimpleTypeRef )
                    {
                    // InternalBeeLangTestLanguage.g:235:5: (lv_implements_7_0= ruleSimpleTypeRef )
                    // InternalBeeLangTestLanguage.g:236:6: lv_implements_7_0= ruleSimpleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnitAccess().getImplementsSimpleTypeRefParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_10);
                    lv_implements_7_0=ruleSimpleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnitRule());
                      						}
                      						add(
                      							current,
                      							"implements",
                      							lv_implements_7_0,
                      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.SimpleTypeRef");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalBeeLangTestLanguage.g:253:4: (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==16) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalBeeLangTestLanguage.g:254:5: otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) )
                    	    {
                    	    otherlv_8=(Token)match(input,16,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_8, grammarAccess.getUnitAccess().getCommaKeyword_5_2_0());
                    	      				
                    	    }
                    	    // InternalBeeLangTestLanguage.g:258:5: ( (lv_implements_9_0= ruleSimpleTypeRef ) )
                    	    // InternalBeeLangTestLanguage.g:259:6: (lv_implements_9_0= ruleSimpleTypeRef )
                    	    {
                    	    // InternalBeeLangTestLanguage.g:259:6: (lv_implements_9_0= ruleSimpleTypeRef )
                    	    // InternalBeeLangTestLanguage.g:260:7: lv_implements_9_0= ruleSimpleTypeRef
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getUnitAccess().getImplementsSimpleTypeRefParserRuleCall_5_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_10);
                    	    lv_implements_9_0=ruleSimpleTypeRef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getUnitRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"implements",
                    	      								lv_implements_9_0,
                    	      								"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.SimpleTypeRef");
                    	      							afterParserOrEnumRuleCall();
                    	      						
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

            otherlv_10=(Token)match(input,17,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getUnitAccess().getLeftCurlyBracketKeyword_6());
              		
            }
            // InternalBeeLangTestLanguage.g:283:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) )
            // InternalBeeLangTestLanguage.g:284:4: ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) )
            {
            // InternalBeeLangTestLanguage.g:284:4: ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) )
            // InternalBeeLangTestLanguage.g:285:5: ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getUnitAccess().getUnorderedGroup_7());
            // InternalBeeLangTestLanguage.g:288:5: ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* )
            // InternalBeeLangTestLanguage.g:289:6: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )*
            {
            // InternalBeeLangTestLanguage.g:289:6: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )*
            loop13:
            do {
                int alt13=7;
                alt13 = dfa13.predict(input);
                switch (alt13) {
            	case 1 :
            	    // InternalBeeLangTestLanguage.g:290:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:290:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
            	    // InternalBeeLangTestLanguage.g:291:5: {...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0)");
            	    }
            	    // InternalBeeLangTestLanguage.g:291:101: ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
            	    // InternalBeeLangTestLanguage.g:292:6: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0);
            	    // InternalBeeLangTestLanguage.g:295:9: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
            	    // InternalBeeLangTestLanguage.g:295:10: {...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    }
            	    // InternalBeeLangTestLanguage.g:295:19: (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
            	    // InternalBeeLangTestLanguage.g:295:20: otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';'
            	    {
            	    otherlv_12=(Token)match(input,18,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_12, grammarAccess.getUnitAccess().getSourceKeyword_7_0_0());
            	      								
            	    }
            	    otherlv_13=(Token)match(input,19,FOLLOW_13); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_13, grammarAccess.getUnitAccess().getColonKeyword_7_0_1());
            	      								
            	    }
            	    // InternalBeeLangTestLanguage.g:303:9: ( (lv_sourceLocation_14_0= rulePath ) )
            	    // InternalBeeLangTestLanguage.g:304:10: (lv_sourceLocation_14_0= rulePath )
            	    {
            	    // InternalBeeLangTestLanguage.g:304:10: (lv_sourceLocation_14_0= rulePath )
            	    // InternalBeeLangTestLanguage.g:305:11: lv_sourceLocation_14_0= rulePath
            	    {
            	    if ( state.backtracking==0 ) {

            	      											newCompositeNode(grammarAccess.getUnitAccess().getSourceLocationPathParserRuleCall_7_0_2_0());
            	      										
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_sourceLocation_14_0=rulePath();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      											if (current==null) {
            	      												current = createModelElementForParent(grammarAccess.getUnitRule());
            	      											}
            	      											set(
            	      												current,
            	      												"sourceLocation",
            	      												lv_sourceLocation_14_0,
            	      												"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Path");
            	      											afterParserOrEnumRuleCall();
            	      										
            	    }

            	    }


            	    }

            	    otherlv_15=(Token)match(input,20,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_15, grammarAccess.getUnitAccess().getSemicolonKeyword_7_0_3());
            	      								
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnitAccess().getUnorderedGroup_7());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalBeeLangTestLanguage.g:332:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:332:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
            	    // InternalBeeLangTestLanguage.g:333:5: {...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1)");
            	    }
            	    // InternalBeeLangTestLanguage.g:333:101: ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
            	    // InternalBeeLangTestLanguage.g:334:6: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1);
            	    // InternalBeeLangTestLanguage.g:337:9: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
            	    // InternalBeeLangTestLanguage.g:337:10: {...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    }
            	    // InternalBeeLangTestLanguage.g:337:19: (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
            	    // InternalBeeLangTestLanguage.g:337:20: otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';'
            	    {
            	    otherlv_16=(Token)match(input,21,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_16, grammarAccess.getUnitAccess().getOutputKeyword_7_1_0());
            	      								
            	    }
            	    otherlv_17=(Token)match(input,19,FOLLOW_13); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_17, grammarAccess.getUnitAccess().getColonKeyword_7_1_1());
            	      								
            	    }
            	    // InternalBeeLangTestLanguage.g:345:9: ( (lv_outputLocation_18_0= rulePath ) )
            	    // InternalBeeLangTestLanguage.g:346:10: (lv_outputLocation_18_0= rulePath )
            	    {
            	    // InternalBeeLangTestLanguage.g:346:10: (lv_outputLocation_18_0= rulePath )
            	    // InternalBeeLangTestLanguage.g:347:11: lv_outputLocation_18_0= rulePath
            	    {
            	    if ( state.backtracking==0 ) {

            	      											newCompositeNode(grammarAccess.getUnitAccess().getOutputLocationPathParserRuleCall_7_1_2_0());
            	      										
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_outputLocation_18_0=rulePath();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      											if (current==null) {
            	      												current = createModelElementForParent(grammarAccess.getUnitRule());
            	      											}
            	      											set(
            	      												current,
            	      												"outputLocation",
            	      												lv_outputLocation_18_0,
            	      												"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Path");
            	      											afterParserOrEnumRuleCall();
            	      										
            	    }

            	    }


            	    }

            	    otherlv_19=(Token)match(input,20,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_19, grammarAccess.getUnitAccess().getSemicolonKeyword_7_1_3());
            	      								
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnitAccess().getUnorderedGroup_7());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalBeeLangTestLanguage.g:374:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:374:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
            	    // InternalBeeLangTestLanguage.g:375:5: {...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2)");
            	    }
            	    // InternalBeeLangTestLanguage.g:375:101: ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
            	    // InternalBeeLangTestLanguage.g:376:6: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2);
            	    // InternalBeeLangTestLanguage.g:379:9: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==22) ) {
            	            int LA9_2 = input.LA(2);

            	            if ( ((synpred11_InternalBeeLangTestLanguage()&&(true))) ) {
            	                alt9=1;
            	            }


            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // InternalBeeLangTestLanguage.g:379:10: {...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // InternalBeeLangTestLanguage.g:379:19: (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
            	    	    // InternalBeeLangTestLanguage.g:379:20: otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';'
            	    	    {
            	    	    otherlv_20=(Token)match(input,22,FOLLOW_12); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_20, grammarAccess.getUnitAccess().getProvidesKeyword_7_2_0());
            	    	      								
            	    	    }
            	    	    otherlv_21=(Token)match(input,19,FOLLOW_15); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_21, grammarAccess.getUnitAccess().getColonKeyword_7_2_1());
            	    	      								
            	    	    }
            	    	    // InternalBeeLangTestLanguage.g:387:9: ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) )
            	    	    // InternalBeeLangTestLanguage.g:388:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
            	    	    {
            	    	    // InternalBeeLangTestLanguage.g:388:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
            	    	    // InternalBeeLangTestLanguage.g:389:11: lv_providedCapabilities_22_0= ruleProvidedCapability
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      											newCompositeNode(grammarAccess.getUnitAccess().getProvidedCapabilitiesProvidedCapabilityParserRuleCall_7_2_2_0());
            	    	      										
            	    	    }
            	    	    pushFollow(FOLLOW_14);
            	    	    lv_providedCapabilities_22_0=ruleProvidedCapability();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      											if (current==null) {
            	    	      												current = createModelElementForParent(grammarAccess.getUnitRule());
            	    	      											}
            	    	      											add(
            	    	      												current,
            	    	      												"providedCapabilities",
            	    	      												lv_providedCapabilities_22_0,
            	    	      												"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ProvidedCapability");
            	    	      											afterParserOrEnumRuleCall();
            	    	      										
            	    	    }

            	    	    }


            	    	    }

            	    	    otherlv_23=(Token)match(input,20,FOLLOW_11); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_23, grammarAccess.getUnitAccess().getSemicolonKeyword_7_2_3());
            	    	      								
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
            	    // InternalBeeLangTestLanguage.g:416:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:416:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
            	    // InternalBeeLangTestLanguage.g:417:5: {...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3)");
            	    }
            	    // InternalBeeLangTestLanguage.g:417:101: ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
            	    // InternalBeeLangTestLanguage.g:418:6: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3);
            	    // InternalBeeLangTestLanguage.g:421:9: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
            	    int cnt10=0;
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==23) ) {
            	            int LA10_2 = input.LA(2);

            	            if ( ((synpred13_InternalBeeLangTestLanguage()&&(true))) ) {
            	                alt10=1;
            	            }


            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // InternalBeeLangTestLanguage.g:421:10: {...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // InternalBeeLangTestLanguage.g:421:19: (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
            	    	    // InternalBeeLangTestLanguage.g:421:20: otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';'
            	    	    {
            	    	    otherlv_24=(Token)match(input,23,FOLLOW_12); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_24, grammarAccess.getUnitAccess().getRequiresKeyword_7_3_0());
            	    	      								
            	    	    }
            	    	    otherlv_25=(Token)match(input,19,FOLLOW_15); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_25, grammarAccess.getUnitAccess().getColonKeyword_7_3_1());
            	    	      								
            	    	    }
            	    	    // InternalBeeLangTestLanguage.g:429:9: ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) )
            	    	    // InternalBeeLangTestLanguage.g:430:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
            	    	    {
            	    	    // InternalBeeLangTestLanguage.g:430:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
            	    	    // InternalBeeLangTestLanguage.g:431:11: lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      											newCompositeNode(grammarAccess.getUnitAccess().getRequiredCapabilitiesAliasedRequiredCapabilityParserRuleCall_7_3_2_0());
            	    	      										
            	    	    }
            	    	    pushFollow(FOLLOW_14);
            	    	    lv_requiredCapabilities_26_0=ruleAliasedRequiredCapability();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      											if (current==null) {
            	    	      												current = createModelElementForParent(grammarAccess.getUnitRule());
            	    	      											}
            	    	      											add(
            	    	      												current,
            	    	      												"requiredCapabilities",
            	    	      												lv_requiredCapabilities_26_0,
            	    	      												"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.AliasedRequiredCapability");
            	    	      											afterParserOrEnumRuleCall();
            	    	      										
            	    	    }

            	    	    }


            	    	    }

            	    	    otherlv_27=(Token)match(input,20,FOLLOW_11); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_27, grammarAccess.getUnitAccess().getSemicolonKeyword_7_3_3());
            	    	      								
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
            	    // InternalBeeLangTestLanguage.g:458:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:458:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
            	    // InternalBeeLangTestLanguage.g:459:5: {...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4)");
            	    }
            	    // InternalBeeLangTestLanguage.g:459:101: ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
            	    // InternalBeeLangTestLanguage.g:460:6: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4);
            	    // InternalBeeLangTestLanguage.g:463:9: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
            	    int cnt11=0;
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( (LA11_0==23) ) {
            	            int LA11_2 = input.LA(2);

            	            if ( ((synpred15_InternalBeeLangTestLanguage()&&(true))) ) {
            	                alt11=1;
            	            }


            	        }


            	        switch (alt11) {
            	    	case 1 :
            	    	    // InternalBeeLangTestLanguage.g:463:10: {...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // InternalBeeLangTestLanguage.g:463:19: (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
            	    	    // InternalBeeLangTestLanguage.g:463:20: otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';'
            	    	    {
            	    	    otherlv_28=(Token)match(input,23,FOLLOW_16); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_28, grammarAccess.getUnitAccess().getRequiresKeyword_7_4_0());
            	    	      								
            	    	    }
            	    	    otherlv_29=(Token)match(input,24,FOLLOW_12); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_29, grammarAccess.getUnitAccess().getEnvKeyword_7_4_1());
            	    	      								
            	    	    }
            	    	    otherlv_30=(Token)match(input,19,FOLLOW_15); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_30, grammarAccess.getUnitAccess().getColonKeyword_7_4_2());
            	    	      								
            	    	    }
            	    	    // InternalBeeLangTestLanguage.g:475:9: ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) )
            	    	    // InternalBeeLangTestLanguage.g:476:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
            	    	    {
            	    	    // InternalBeeLangTestLanguage.g:476:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
            	    	    // InternalBeeLangTestLanguage.g:477:11: lv_metaRequiredCapabilities_31_0= ruleRequiredCapability
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      											newCompositeNode(grammarAccess.getUnitAccess().getMetaRequiredCapabilitiesRequiredCapabilityParserRuleCall_7_4_3_0());
            	    	      										
            	    	    }
            	    	    pushFollow(FOLLOW_14);
            	    	    lv_metaRequiredCapabilities_31_0=ruleRequiredCapability();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      											if (current==null) {
            	    	      												current = createModelElementForParent(grammarAccess.getUnitRule());
            	    	      											}
            	    	      											add(
            	    	      												current,
            	    	      												"metaRequiredCapabilities",
            	    	      												lv_metaRequiredCapabilities_31_0,
            	    	      												"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.RequiredCapability");
            	    	      											afterParserOrEnumRuleCall();
            	    	      										
            	    	    }

            	    	    }


            	    	    }

            	    	    otherlv_32=(Token)match(input,20,FOLLOW_11); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_32, grammarAccess.getUnitAccess().getSemicolonKeyword_7_4_4());
            	    	      								
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
            	    // InternalBeeLangTestLanguage.g:504:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:504:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
            	    // InternalBeeLangTestLanguage.g:505:5: {...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5)");
            	    }
            	    // InternalBeeLangTestLanguage.g:505:101: ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
            	    // InternalBeeLangTestLanguage.g:506:6: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5);
            	    // InternalBeeLangTestLanguage.g:509:9: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
            	    int cnt12=0;
            	    loop12:
            	    do {
            	        int alt12=2;
            	        switch ( input.LA(1) ) {
            	        case RULE_DOCUMENTATION:
            	            {
            	            int LA12_2 = input.LA(2);

            	            if ( ((synpred17_InternalBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;
            	        case RULE_ID:
            	            {
            	            int LA12_3 = input.LA(2);

            	            if ( ((synpred17_InternalBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;
            	        case 33:
            	            {
            	            int LA12_4 = input.LA(2);

            	            if ( ((synpred17_InternalBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;
            	        case 34:
            	            {
            	            int LA12_5 = input.LA(2);

            	            if ( ((synpred17_InternalBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;

            	        }

            	        switch (alt12) {
            	    	case 1 :
            	    	    // InternalBeeLangTestLanguage.g:509:10: {...}? => ( (lv_functions_33_0= ruleFunction ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // InternalBeeLangTestLanguage.g:509:19: ( (lv_functions_33_0= ruleFunction ) )
            	    	    // InternalBeeLangTestLanguage.g:509:20: (lv_functions_33_0= ruleFunction )
            	    	    {
            	    	    // InternalBeeLangTestLanguage.g:509:20: (lv_functions_33_0= ruleFunction )
            	    	    // InternalBeeLangTestLanguage.g:510:10: lv_functions_33_0= ruleFunction
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      										newCompositeNode(grammarAccess.getUnitAccess().getFunctionsFunctionParserRuleCall_7_5_0());
            	    	      									
            	    	    }
            	    	    pushFollow(FOLLOW_11);
            	    	    lv_functions_33_0=ruleFunction();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      										if (current==null) {
            	    	      											current = createModelElementForParent(grammarAccess.getUnitRule());
            	    	      										}
            	    	      										add(
            	    	      											current,
            	    	      											"functions",
            	    	      											lv_functions_33_0,
            	    	      											"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Function");
            	    	      										afterParserOrEnumRuleCall();
            	    	      									
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

            otherlv_34=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_34, grammarAccess.getUnitAccess().getRightCurlyBracketKeyword_8());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, ruleUnit_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleUnit"


    // $ANTLR start "entryRuleProvidedCapability"
    // InternalBeeLangTestLanguage.g:550:1: entryRuleProvidedCapability returns [EObject current=null] : iv_ruleProvidedCapability= ruleProvidedCapability EOF ;
    public final EObject entryRuleProvidedCapability() throws RecognitionException {
        EObject current = null;
        int entryRuleProvidedCapability_StartIndex = input.index();
        EObject iv_ruleProvidedCapability = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return current; }
            // InternalBeeLangTestLanguage.g:554:2: (iv_ruleProvidedCapability= ruleProvidedCapability EOF )
            // InternalBeeLangTestLanguage.g:555:2: iv_ruleProvidedCapability= ruleProvidedCapability EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProvidedCapabilityRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, entryRuleProvidedCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleProvidedCapability"


    // $ANTLR start "ruleProvidedCapability"
    // InternalBeeLangTestLanguage.g:564:1: ruleProvidedCapability returns [EObject current=null] : ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? ) ;
    public final EObject ruleProvidedCapability() throws RecognitionException {
        EObject current = null;
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
        EObject lv_condExpr_7_0 = null;



        	enterRule();
        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return current; }
            // InternalBeeLangTestLanguage.g:573:2: ( ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? ) )
            // InternalBeeLangTestLanguage.g:574:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? )
            {
            // InternalBeeLangTestLanguage.g:574:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? )
            // InternalBeeLangTestLanguage.g:575:3: () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )?
            {
            // InternalBeeLangTestLanguage.g:575:3: ()
            // InternalBeeLangTestLanguage.g:576:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getProvidedCapabilityAccess().getProvidedCapabilityAction_0(),
              					current);
              			
            }

            }

            // InternalBeeLangTestLanguage.g:585:3: ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' )
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
                    // InternalBeeLangTestLanguage.g:586:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    {
                    // InternalBeeLangTestLanguage.g:586:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    // InternalBeeLangTestLanguage.g:587:5: (lv_nameSpace_1_0= RULE_ID )
                    {
                    // InternalBeeLangTestLanguage.g:587:5: (lv_nameSpace_1_0= RULE_ID )
                    // InternalBeeLangTestLanguage.g:588:6: lv_nameSpace_1_0= RULE_ID
                    {
                    lv_nameSpace_1_0=(Token)match(input,RULE_ID,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_nameSpace_1_0, grammarAccess.getProvidedCapabilityAccess().getNameSpaceIDTerminalRuleCall_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getProvidedCapabilityRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"nameSpace",
                      							lv_nameSpace_1_0,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBeeLangTestLanguage.g:605:4: otherlv_2= 'unit'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getProvidedCapabilityAccess().getUnitKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalBeeLangTestLanguage.g:610:3: (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==17) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:611:4: otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}'
                    {
                    otherlv_3=(Token)match(input,17,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getProvidedCapabilityAccess().getLeftCurlyBracketKeyword_2_0());
                      			
                    }
                    // InternalBeeLangTestLanguage.g:615:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) )
                    // InternalBeeLangTestLanguage.g:616:5: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) )
                    {
                    // InternalBeeLangTestLanguage.g:616:5: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) )
                    // InternalBeeLangTestLanguage.g:617:6: ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?)
                    {
                    getUnorderedGroupHelper().enter(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1());
                    // InternalBeeLangTestLanguage.g:620:6: ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?)
                    // InternalBeeLangTestLanguage.g:621:7: ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?
                    {
                    // InternalBeeLangTestLanguage.g:621:7: ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+
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
                    	    // InternalBeeLangTestLanguage.g:622:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
                    	    {
                    	    // InternalBeeLangTestLanguage.g:622:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
                    	    // InternalBeeLangTestLanguage.g:623:6: {...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0)");
                    	    }
                    	    // InternalBeeLangTestLanguage.g:623:118: ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
                    	    // InternalBeeLangTestLanguage.g:624:7: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0);
                    	    // InternalBeeLangTestLanguage.g:627:10: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
                    	    // InternalBeeLangTestLanguage.g:627:11: {...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "true");
                    	    }
                    	    // InternalBeeLangTestLanguage.g:627:20: (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
                    	    // InternalBeeLangTestLanguage.g:627:21: otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';'
                    	    {
                    	    otherlv_5=(Token)match(input,26,FOLLOW_12); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_5, grammarAccess.getProvidedCapabilityAccess().getWhenKeyword_2_1_0_0());
                    	      									
                    	    }
                    	    otherlv_6=(Token)match(input,19,FOLLOW_19); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_6, grammarAccess.getProvidedCapabilityAccess().getColonKeyword_2_1_0_1());
                    	      									
                    	    }
                    	    // InternalBeeLangTestLanguage.g:635:10: ( (lv_condExpr_7_0= ruleExpression ) )
                    	    // InternalBeeLangTestLanguage.g:636:11: (lv_condExpr_7_0= ruleExpression )
                    	    {
                    	    // InternalBeeLangTestLanguage.g:636:11: (lv_condExpr_7_0= ruleExpression )
                    	    // InternalBeeLangTestLanguage.g:637:12: lv_condExpr_7_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      												newCompositeNode(grammarAccess.getProvidedCapabilityAccess().getCondExprExpressionParserRuleCall_2_1_0_2_0());
                    	      											
                    	    }
                    	    pushFollow(FOLLOW_14);
                    	    lv_condExpr_7_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      												if (current==null) {
                    	      													current = createModelElementForParent(grammarAccess.getProvidedCapabilityRule());
                    	      												}
                    	      												set(
                    	      													current,
                    	      													"condExpr",
                    	      													lv_condExpr_7_0,
                    	      													"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
                    	      												afterParserOrEnumRuleCall();
                    	      											
                    	    }

                    	    }


                    	    }

                    	    otherlv_8=(Token)match(input,20,FOLLOW_20); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_8, grammarAccess.getProvidedCapabilityAccess().getSemicolonKeyword_2_1_0_3());
                    	      									
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBeeLangTestLanguage.g:664:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
                    	    {
                    	    // InternalBeeLangTestLanguage.g:664:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
                    	    // InternalBeeLangTestLanguage.g:665:6: {...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1)");
                    	    }
                    	    // InternalBeeLangTestLanguage.g:665:118: ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
                    	    // InternalBeeLangTestLanguage.g:666:7: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1);
                    	    // InternalBeeLangTestLanguage.g:669:10: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
                    	    // InternalBeeLangTestLanguage.g:669:11: {...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "true");
                    	    }
                    	    // InternalBeeLangTestLanguage.g:669:20: (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
                    	    // InternalBeeLangTestLanguage.g:669:21: otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';'
                    	    {
                    	    otherlv_9=(Token)match(input,27,FOLLOW_12); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_9, grammarAccess.getProvidedCapabilityAccess().getNameKeyword_2_1_1_0());
                    	      									
                    	    }
                    	    otherlv_10=(Token)match(input,19,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_10, grammarAccess.getProvidedCapabilityAccess().getColonKeyword_2_1_1_1());
                    	      									
                    	    }
                    	    // InternalBeeLangTestLanguage.g:677:10: ( (lv_name_11_0= RULE_ID ) )
                    	    // InternalBeeLangTestLanguage.g:678:11: (lv_name_11_0= RULE_ID )
                    	    {
                    	    // InternalBeeLangTestLanguage.g:678:11: (lv_name_11_0= RULE_ID )
                    	    // InternalBeeLangTestLanguage.g:679:12: lv_name_11_0= RULE_ID
                    	    {
                    	    lv_name_11_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      												newLeafNode(lv_name_11_0, grammarAccess.getProvidedCapabilityAccess().getNameIDTerminalRuleCall_2_1_1_2_0());
                    	      											
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      												if (current==null) {
                    	      													current = createModelElement(grammarAccess.getProvidedCapabilityRule());
                    	      												}
                    	      												setWithLastConsumed(
                    	      													current,
                    	      													"name",
                    	      													lv_name_11_0,
                    	      													"org.eclipse.xtext.common.Terminals.ID");
                    	      											
                    	    }

                    	    }


                    	    }

                    	    otherlv_12=(Token)match(input,20,FOLLOW_20); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_12, grammarAccess.getProvidedCapabilityAccess().getSemicolonKeyword_2_1_1_3());
                    	      									
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // InternalBeeLangTestLanguage.g:705:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
                    	    {
                    	    // InternalBeeLangTestLanguage.g:705:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
                    	    // InternalBeeLangTestLanguage.g:706:6: {...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2)");
                    	    }
                    	    // InternalBeeLangTestLanguage.g:706:118: ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
                    	    // InternalBeeLangTestLanguage.g:707:7: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2);
                    	    // InternalBeeLangTestLanguage.g:710:10: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
                    	    // InternalBeeLangTestLanguage.g:710:11: {...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "true");
                    	    }
                    	    // InternalBeeLangTestLanguage.g:710:20: (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
                    	    // InternalBeeLangTestLanguage.g:710:21: otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';'
                    	    {
                    	    otherlv_13=(Token)match(input,14,FOLLOW_12); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_13, grammarAccess.getProvidedCapabilityAccess().getVersionKeyword_2_1_2_0());
                    	      									
                    	    }
                    	    otherlv_14=(Token)match(input,19,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_14, grammarAccess.getProvidedCapabilityAccess().getColonKeyword_2_1_2_1());
                    	      									
                    	    }
                    	    // InternalBeeLangTestLanguage.g:718:10: ( (lv_version_15_0= RULE_ID ) )
                    	    // InternalBeeLangTestLanguage.g:719:11: (lv_version_15_0= RULE_ID )
                    	    {
                    	    // InternalBeeLangTestLanguage.g:719:11: (lv_version_15_0= RULE_ID )
                    	    // InternalBeeLangTestLanguage.g:720:12: lv_version_15_0= RULE_ID
                    	    {
                    	    lv_version_15_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      												newLeafNode(lv_version_15_0, grammarAccess.getProvidedCapabilityAccess().getVersionIDTerminalRuleCall_2_1_2_2_0());
                    	      											
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      												if (current==null) {
                    	      													current = createModelElement(grammarAccess.getProvidedCapabilityRule());
                    	      												}
                    	      												setWithLastConsumed(
                    	      													current,
                    	      													"version",
                    	      													lv_version_15_0,
                    	      													"org.eclipse.xtext.common.Terminals.ID");
                    	      											
                    	    }

                    	    }


                    	    }

                    	    otherlv_16=(Token)match(input,20,FOLLOW_20); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_16, grammarAccess.getProvidedCapabilityAccess().getSemicolonKeyword_2_1_2_3());
                    	      									
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

                    otherlv_17=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_17, grammarAccess.getProvidedCapabilityAccess().getRightCurlyBracketKeyword_2_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, ruleProvidedCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleProvidedCapability"


    // $ANTLR start "entryRuleAliasedRequiredCapability"
    // InternalBeeLangTestLanguage.g:766:1: entryRuleAliasedRequiredCapability returns [EObject current=null] : iv_ruleAliasedRequiredCapability= ruleAliasedRequiredCapability EOF ;
    public final EObject entryRuleAliasedRequiredCapability() throws RecognitionException {
        EObject current = null;
        int entryRuleAliasedRequiredCapability_StartIndex = input.index();
        EObject iv_ruleAliasedRequiredCapability = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return current; }
            // InternalBeeLangTestLanguage.g:770:2: (iv_ruleAliasedRequiredCapability= ruleAliasedRequiredCapability EOF )
            // InternalBeeLangTestLanguage.g:771:2: iv_ruleAliasedRequiredCapability= ruleAliasedRequiredCapability EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAliasedRequiredCapabilityRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, entryRuleAliasedRequiredCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleAliasedRequiredCapability"


    // $ANTLR start "ruleAliasedRequiredCapability"
    // InternalBeeLangTestLanguage.g:780:1: ruleAliasedRequiredCapability returns [EObject current=null] : ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) ) ;
    public final EObject ruleAliasedRequiredCapability() throws RecognitionException {
        EObject current = null;
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
        EObject lv_condExpr_9_0 = null;



        	enterRule();
        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return current; }
            // InternalBeeLangTestLanguage.g:789:2: ( ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) ) )
            // InternalBeeLangTestLanguage.g:790:2: ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) )
            {
            // InternalBeeLangTestLanguage.g:790:2: ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) )
            // InternalBeeLangTestLanguage.g:791:3: ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' )
            {
            // InternalBeeLangTestLanguage.g:791:3: ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' )
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
                    // InternalBeeLangTestLanguage.g:792:4: ( (lv_nameSpace_0_0= RULE_ID ) )
                    {
                    // InternalBeeLangTestLanguage.g:792:4: ( (lv_nameSpace_0_0= RULE_ID ) )
                    // InternalBeeLangTestLanguage.g:793:5: (lv_nameSpace_0_0= RULE_ID )
                    {
                    // InternalBeeLangTestLanguage.g:793:5: (lv_nameSpace_0_0= RULE_ID )
                    // InternalBeeLangTestLanguage.g:794:6: lv_nameSpace_0_0= RULE_ID
                    {
                    lv_nameSpace_0_0=(Token)match(input,RULE_ID,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_nameSpace_0_0, grammarAccess.getAliasedRequiredCapabilityAccess().getNameSpaceIDTerminalRuleCall_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAliasedRequiredCapabilityRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"nameSpace",
                      							lv_nameSpace_0_0,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBeeLangTestLanguage.g:811:4: otherlv_1= 'unit'
                    {
                    otherlv_1=(Token)match(input,13,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getAliasedRequiredCapabilityAccess().getUnitKeyword_0_1());
                      			
                    }

                    }
                    break;

            }

            // InternalBeeLangTestLanguage.g:816:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalBeeLangTestLanguage.g:817:4: (lv_name_2_0= RULE_ID )
            {
            // InternalBeeLangTestLanguage.g:817:4: (lv_name_2_0= RULE_ID )
            // InternalBeeLangTestLanguage.g:818:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getAliasedRequiredCapabilityAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAliasedRequiredCapabilityRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_2_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalBeeLangTestLanguage.g:834:3: (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==28) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:835:4: otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,28,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getAliasedRequiredCapabilityAccess().getAsKeyword_2_0());
                      			
                    }
                    // InternalBeeLangTestLanguage.g:839:4: ( (lv_alias_4_0= RULE_ID ) )
                    // InternalBeeLangTestLanguage.g:840:5: (lv_alias_4_0= RULE_ID )
                    {
                    // InternalBeeLangTestLanguage.g:840:5: (lv_alias_4_0= RULE_ID )
                    // InternalBeeLangTestLanguage.g:841:6: lv_alias_4_0= RULE_ID
                    {
                    lv_alias_4_0=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_alias_4_0, grammarAccess.getAliasedRequiredCapabilityAccess().getAliasIDTerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAliasedRequiredCapabilityRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"alias",
                      							lv_alias_4_0,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalBeeLangTestLanguage.g:858:3: (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' )
            // InternalBeeLangTestLanguage.g:859:4: otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}'
            {
            otherlv_5=(Token)match(input,17,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_5, grammarAccess.getAliasedRequiredCapabilityAccess().getLeftCurlyBracketKeyword_3_0());
              			
            }
            // InternalBeeLangTestLanguage.g:863:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) )
            // InternalBeeLangTestLanguage.g:864:5: ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) )
            {
            // InternalBeeLangTestLanguage.g:864:5: ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) )
            // InternalBeeLangTestLanguage.g:865:6: ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());
            // InternalBeeLangTestLanguage.g:868:6: ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* )
            // InternalBeeLangTestLanguage.g:869:7: ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )*
            {
            // InternalBeeLangTestLanguage.g:869:7: ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )*
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
            	    // InternalBeeLangTestLanguage.g:870:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:870:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
            	    // InternalBeeLangTestLanguage.g:871:6: {...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
            	    }
            	    // InternalBeeLangTestLanguage.g:871:125: ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
            	    // InternalBeeLangTestLanguage.g:872:7: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
            	    // InternalBeeLangTestLanguage.g:875:10: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
            	    // InternalBeeLangTestLanguage.g:875:11: {...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // InternalBeeLangTestLanguage.g:875:20: (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
            	    // InternalBeeLangTestLanguage.g:875:21: otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';'
            	    {
            	    otherlv_7=(Token)match(input,26,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_7, grammarAccess.getAliasedRequiredCapabilityAccess().getWhenKeyword_3_1_0_0());
            	      									
            	    }
            	    otherlv_8=(Token)match(input,19,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_8, grammarAccess.getAliasedRequiredCapabilityAccess().getColonKeyword_3_1_0_1());
            	      									
            	    }
            	    // InternalBeeLangTestLanguage.g:883:10: ( (lv_condExpr_9_0= ruleExpression ) )
            	    // InternalBeeLangTestLanguage.g:884:11: (lv_condExpr_9_0= ruleExpression )
            	    {
            	    // InternalBeeLangTestLanguage.g:884:11: (lv_condExpr_9_0= ruleExpression )
            	    // InternalBeeLangTestLanguage.g:885:12: lv_condExpr_9_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      												newCompositeNode(grammarAccess.getAliasedRequiredCapabilityAccess().getCondExprExpressionParserRuleCall_3_1_0_2_0());
            	      											
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_condExpr_9_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												if (current==null) {
            	      													current = createModelElementForParent(grammarAccess.getAliasedRequiredCapabilityRule());
            	      												}
            	      												set(
            	      													current,
            	      													"condExpr",
            	      													lv_condExpr_9_0,
            	      													"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
            	      												afterParserOrEnumRuleCall();
            	      											
            	    }

            	    }


            	    }

            	    otherlv_10=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_10, grammarAccess.getAliasedRequiredCapabilityAccess().getSemicolonKeyword_3_1_0_3());
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalBeeLangTestLanguage.g:912:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:912:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
            	    // InternalBeeLangTestLanguage.g:913:6: {...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
            	    }
            	    // InternalBeeLangTestLanguage.g:913:125: ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
            	    // InternalBeeLangTestLanguage.g:914:7: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
            	    // InternalBeeLangTestLanguage.g:917:10: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
            	    // InternalBeeLangTestLanguage.g:917:11: {...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // InternalBeeLangTestLanguage.g:917:20: ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
            	    // InternalBeeLangTestLanguage.g:917:21: ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';'
            	    {
            	    // InternalBeeLangTestLanguage.g:917:21: ( (lv_greedy_11_0= 'greedy' ) )
            	    // InternalBeeLangTestLanguage.g:918:11: (lv_greedy_11_0= 'greedy' )
            	    {
            	    // InternalBeeLangTestLanguage.g:918:11: (lv_greedy_11_0= 'greedy' )
            	    // InternalBeeLangTestLanguage.g:919:12: lv_greedy_11_0= 'greedy'
            	    {
            	    lv_greedy_11_0=(Token)match(input,29,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												newLeafNode(lv_greedy_11_0, grammarAccess.getAliasedRequiredCapabilityAccess().getGreedyGreedyKeyword_3_1_1_0_0());
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												if (current==null) {
            	      													current = createModelElement(grammarAccess.getAliasedRequiredCapabilityRule());
            	      												}
            	      												setWithLastConsumed(current, "greedy", true, "greedy");
            	      											
            	    }

            	    }


            	    }

            	    otherlv_12=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_12, grammarAccess.getAliasedRequiredCapabilityAccess().getSemicolonKeyword_3_1_1_1());
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalBeeLangTestLanguage.g:941:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:941:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
            	    // InternalBeeLangTestLanguage.g:942:6: {...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
            	    }
            	    // InternalBeeLangTestLanguage.g:942:125: ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
            	    // InternalBeeLangTestLanguage.g:943:7: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
            	    // InternalBeeLangTestLanguage.g:946:10: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
            	    // InternalBeeLangTestLanguage.g:946:11: {...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // InternalBeeLangTestLanguage.g:946:20: (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
            	    // InternalBeeLangTestLanguage.g:946:21: otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';'
            	    {
            	    otherlv_13=(Token)match(input,30,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_13, grammarAccess.getAliasedRequiredCapabilityAccess().getRequiresMinKeyword_3_1_2_0());
            	      									
            	    }
            	    otherlv_14=(Token)match(input,19,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_14, grammarAccess.getAliasedRequiredCapabilityAccess().getColonKeyword_3_1_2_1());
            	      									
            	    }
            	    // InternalBeeLangTestLanguage.g:954:10: ( (lv_min_15_0= RULE_INT ) )
            	    // InternalBeeLangTestLanguage.g:955:11: (lv_min_15_0= RULE_INT )
            	    {
            	    // InternalBeeLangTestLanguage.g:955:11: (lv_min_15_0= RULE_INT )
            	    // InternalBeeLangTestLanguage.g:956:12: lv_min_15_0= RULE_INT
            	    {
            	    lv_min_15_0=(Token)match(input,RULE_INT,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												newLeafNode(lv_min_15_0, grammarAccess.getAliasedRequiredCapabilityAccess().getMinINTTerminalRuleCall_3_1_2_2_0());
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												if (current==null) {
            	      													current = createModelElement(grammarAccess.getAliasedRequiredCapabilityRule());
            	      												}
            	      												setWithLastConsumed(
            	      													current,
            	      													"min",
            	      													lv_min_15_0,
            	      													"org.eclipse.xtext.common.Terminals.INT");
            	      											
            	    }

            	    }


            	    }

            	    otherlv_16=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_16, grammarAccess.getAliasedRequiredCapabilityAccess().getSemicolonKeyword_3_1_2_3());
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalBeeLangTestLanguage.g:982:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:982:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
            	    // InternalBeeLangTestLanguage.g:983:6: {...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
            	    }
            	    // InternalBeeLangTestLanguage.g:983:125: ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
            	    // InternalBeeLangTestLanguage.g:984:7: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
            	    // InternalBeeLangTestLanguage.g:987:10: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
            	    // InternalBeeLangTestLanguage.g:987:11: {...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // InternalBeeLangTestLanguage.g:987:20: (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
            	    // InternalBeeLangTestLanguage.g:987:21: otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';'
            	    {
            	    otherlv_17=(Token)match(input,31,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_17, grammarAccess.getAliasedRequiredCapabilityAccess().getRequiresMaxKeyword_3_1_3_0());
            	      									
            	    }
            	    otherlv_18=(Token)match(input,19,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_18, grammarAccess.getAliasedRequiredCapabilityAccess().getColonKeyword_3_1_3_1());
            	      									
            	    }
            	    // InternalBeeLangTestLanguage.g:995:10: ( (lv_max_19_0= RULE_INT ) )
            	    // InternalBeeLangTestLanguage.g:996:11: (lv_max_19_0= RULE_INT )
            	    {
            	    // InternalBeeLangTestLanguage.g:996:11: (lv_max_19_0= RULE_INT )
            	    // InternalBeeLangTestLanguage.g:997:12: lv_max_19_0= RULE_INT
            	    {
            	    lv_max_19_0=(Token)match(input,RULE_INT,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												newLeafNode(lv_max_19_0, grammarAccess.getAliasedRequiredCapabilityAccess().getMaxINTTerminalRuleCall_3_1_3_2_0());
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												if (current==null) {
            	      													current = createModelElement(grammarAccess.getAliasedRequiredCapabilityRule());
            	      												}
            	      												setWithLastConsumed(
            	      													current,
            	      													"max",
            	      													lv_max_19_0,
            	      													"org.eclipse.xtext.common.Terminals.INT");
            	      											
            	    }

            	    }


            	    }

            	    otherlv_20=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_20, grammarAccess.getAliasedRequiredCapabilityAccess().getSemicolonKeyword_3_1_3_3());
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalBeeLangTestLanguage.g:1023:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:1023:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
            	    // InternalBeeLangTestLanguage.g:1024:6: {...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
            	    }
            	    // InternalBeeLangTestLanguage.g:1024:125: ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
            	    // InternalBeeLangTestLanguage.g:1025:7: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
            	    // InternalBeeLangTestLanguage.g:1028:10: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
            	    // InternalBeeLangTestLanguage.g:1028:11: {...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // InternalBeeLangTestLanguage.g:1028:20: (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
            	    // InternalBeeLangTestLanguage.g:1028:21: otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';'
            	    {
            	    otherlv_21=(Token)match(input,14,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_21, grammarAccess.getAliasedRequiredCapabilityAccess().getVersionKeyword_3_1_4_0());
            	      									
            	    }
            	    otherlv_22=(Token)match(input,19,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_22, grammarAccess.getAliasedRequiredCapabilityAccess().getColonKeyword_3_1_4_1());
            	      									
            	    }
            	    // InternalBeeLangTestLanguage.g:1036:10: ( (lv_versionRange_23_0= RULE_ID ) )
            	    // InternalBeeLangTestLanguage.g:1037:11: (lv_versionRange_23_0= RULE_ID )
            	    {
            	    // InternalBeeLangTestLanguage.g:1037:11: (lv_versionRange_23_0= RULE_ID )
            	    // InternalBeeLangTestLanguage.g:1038:12: lv_versionRange_23_0= RULE_ID
            	    {
            	    lv_versionRange_23_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												newLeafNode(lv_versionRange_23_0, grammarAccess.getAliasedRequiredCapabilityAccess().getVersionRangeIDTerminalRuleCall_3_1_4_2_0());
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												if (current==null) {
            	      													current = createModelElement(grammarAccess.getAliasedRequiredCapabilityRule());
            	      												}
            	      												setWithLastConsumed(
            	      													current,
            	      													"versionRange",
            	      													lv_versionRange_23_0,
            	      													"org.eclipse.xtext.common.Terminals.ID");
            	      											
            	    }

            	    }


            	    }

            	    otherlv_24=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_24, grammarAccess.getAliasedRequiredCapabilityAccess().getSemicolonKeyword_3_1_4_3());
            	      									
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

            otherlv_25=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_25, grammarAccess.getAliasedRequiredCapabilityAccess().getRightCurlyBracketKeyword_3_2());
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, ruleAliasedRequiredCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleAliasedRequiredCapability"


    // $ANTLR start "entryRuleRequiredCapability"
    // InternalBeeLangTestLanguage.g:1083:1: entryRuleRequiredCapability returns [EObject current=null] : iv_ruleRequiredCapability= ruleRequiredCapability EOF ;
    public final EObject entryRuleRequiredCapability() throws RecognitionException {
        EObject current = null;
        int entryRuleRequiredCapability_StartIndex = input.index();
        EObject iv_ruleRequiredCapability = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return current; }
            // InternalBeeLangTestLanguage.g:1087:2: (iv_ruleRequiredCapability= ruleRequiredCapability EOF )
            // InternalBeeLangTestLanguage.g:1088:2: iv_ruleRequiredCapability= ruleRequiredCapability EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRequiredCapabilityRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, entryRuleRequiredCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleRequiredCapability"


    // $ANTLR start "ruleRequiredCapability"
    // InternalBeeLangTestLanguage.g:1097:1: ruleRequiredCapability returns [EObject current=null] : ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) ) ;
    public final EObject ruleRequiredCapability() throws RecognitionException {
        EObject current = null;
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
        EObject lv_condExpr_8_0 = null;



        	enterRule();
        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return current; }
            // InternalBeeLangTestLanguage.g:1106:2: ( ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) ) )
            // InternalBeeLangTestLanguage.g:1107:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) )
            {
            // InternalBeeLangTestLanguage.g:1107:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) )
            // InternalBeeLangTestLanguage.g:1108:3: () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' )
            {
            // InternalBeeLangTestLanguage.g:1108:3: ()
            // InternalBeeLangTestLanguage.g:1109:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRequiredCapabilityAccess().getRequiredCapabilityAction_0(),
              					current);
              			
            }

            }

            // InternalBeeLangTestLanguage.g:1118:3: ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' )
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
                    // InternalBeeLangTestLanguage.g:1119:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    {
                    // InternalBeeLangTestLanguage.g:1119:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    // InternalBeeLangTestLanguage.g:1120:5: (lv_nameSpace_1_0= RULE_ID )
                    {
                    // InternalBeeLangTestLanguage.g:1120:5: (lv_nameSpace_1_0= RULE_ID )
                    // InternalBeeLangTestLanguage.g:1121:6: lv_nameSpace_1_0= RULE_ID
                    {
                    lv_nameSpace_1_0=(Token)match(input,RULE_ID,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_nameSpace_1_0, grammarAccess.getRequiredCapabilityAccess().getNameSpaceIDTerminalRuleCall_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getRequiredCapabilityRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"nameSpace",
                      							lv_nameSpace_1_0,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBeeLangTestLanguage.g:1138:4: otherlv_2= 'unit'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getRequiredCapabilityAccess().getUnitKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalBeeLangTestLanguage.g:1143:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalBeeLangTestLanguage.g:1144:4: (lv_name_3_0= RULE_ID )
            {
            // InternalBeeLangTestLanguage.g:1144:4: (lv_name_3_0= RULE_ID )
            // InternalBeeLangTestLanguage.g:1145:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_3_0, grammarAccess.getRequiredCapabilityAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRequiredCapabilityRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_3_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalBeeLangTestLanguage.g:1161:3: (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' )
            // InternalBeeLangTestLanguage.g:1162:4: otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}'
            {
            otherlv_4=(Token)match(input,17,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_4, grammarAccess.getRequiredCapabilityAccess().getLeftCurlyBracketKeyword_3_0());
              			
            }
            // InternalBeeLangTestLanguage.g:1166:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) )
            // InternalBeeLangTestLanguage.g:1167:5: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) )
            {
            // InternalBeeLangTestLanguage.g:1167:5: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) )
            // InternalBeeLangTestLanguage.g:1168:6: ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());
            // InternalBeeLangTestLanguage.g:1171:6: ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* )
            // InternalBeeLangTestLanguage.g:1172:7: ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )*
            {
            // InternalBeeLangTestLanguage.g:1172:7: ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )*
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
            	    // InternalBeeLangTestLanguage.g:1173:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:1173:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
            	    // InternalBeeLangTestLanguage.g:1174:6: {...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
            	    }
            	    // InternalBeeLangTestLanguage.g:1174:118: ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
            	    // InternalBeeLangTestLanguage.g:1175:7: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
            	    // InternalBeeLangTestLanguage.g:1178:10: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
            	    // InternalBeeLangTestLanguage.g:1178:11: {...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // InternalBeeLangTestLanguage.g:1178:20: (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
            	    // InternalBeeLangTestLanguage.g:1178:21: otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';'
            	    {
            	    otherlv_6=(Token)match(input,26,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_6, grammarAccess.getRequiredCapabilityAccess().getWhenKeyword_3_1_0_0());
            	      									
            	    }
            	    otherlv_7=(Token)match(input,19,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_7, grammarAccess.getRequiredCapabilityAccess().getColonKeyword_3_1_0_1());
            	      									
            	    }
            	    // InternalBeeLangTestLanguage.g:1186:10: ( (lv_condExpr_8_0= ruleExpression ) )
            	    // InternalBeeLangTestLanguage.g:1187:11: (lv_condExpr_8_0= ruleExpression )
            	    {
            	    // InternalBeeLangTestLanguage.g:1187:11: (lv_condExpr_8_0= ruleExpression )
            	    // InternalBeeLangTestLanguage.g:1188:12: lv_condExpr_8_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      												newCompositeNode(grammarAccess.getRequiredCapabilityAccess().getCondExprExpressionParserRuleCall_3_1_0_2_0());
            	      											
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_condExpr_8_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												if (current==null) {
            	      													current = createModelElementForParent(grammarAccess.getRequiredCapabilityRule());
            	      												}
            	      												set(
            	      													current,
            	      													"condExpr",
            	      													lv_condExpr_8_0,
            	      													"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
            	      												afterParserOrEnumRuleCall();
            	      											
            	    }

            	    }


            	    }

            	    otherlv_9=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_9, grammarAccess.getRequiredCapabilityAccess().getSemicolonKeyword_3_1_0_3());
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalBeeLangTestLanguage.g:1215:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:1215:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
            	    // InternalBeeLangTestLanguage.g:1216:6: {...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
            	    }
            	    // InternalBeeLangTestLanguage.g:1216:118: ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
            	    // InternalBeeLangTestLanguage.g:1217:7: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
            	    // InternalBeeLangTestLanguage.g:1220:10: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
            	    // InternalBeeLangTestLanguage.g:1220:11: {...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // InternalBeeLangTestLanguage.g:1220:20: ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
            	    // InternalBeeLangTestLanguage.g:1220:21: ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';'
            	    {
            	    // InternalBeeLangTestLanguage.g:1220:21: ( (lv_greedy_10_0= 'greedy' ) )
            	    // InternalBeeLangTestLanguage.g:1221:11: (lv_greedy_10_0= 'greedy' )
            	    {
            	    // InternalBeeLangTestLanguage.g:1221:11: (lv_greedy_10_0= 'greedy' )
            	    // InternalBeeLangTestLanguage.g:1222:12: lv_greedy_10_0= 'greedy'
            	    {
            	    lv_greedy_10_0=(Token)match(input,29,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												newLeafNode(lv_greedy_10_0, grammarAccess.getRequiredCapabilityAccess().getGreedyGreedyKeyword_3_1_1_0_0());
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												if (current==null) {
            	      													current = createModelElement(grammarAccess.getRequiredCapabilityRule());
            	      												}
            	      												setWithLastConsumed(current, "greedy", true, "greedy");
            	      											
            	    }

            	    }


            	    }

            	    otherlv_11=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_11, grammarAccess.getRequiredCapabilityAccess().getSemicolonKeyword_3_1_1_1());
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalBeeLangTestLanguage.g:1244:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:1244:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
            	    // InternalBeeLangTestLanguage.g:1245:6: {...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
            	    }
            	    // InternalBeeLangTestLanguage.g:1245:118: ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
            	    // InternalBeeLangTestLanguage.g:1246:7: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
            	    // InternalBeeLangTestLanguage.g:1249:10: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
            	    // InternalBeeLangTestLanguage.g:1249:11: {...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // InternalBeeLangTestLanguage.g:1249:20: (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
            	    // InternalBeeLangTestLanguage.g:1249:21: otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';'
            	    {
            	    otherlv_12=(Token)match(input,30,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_12, grammarAccess.getRequiredCapabilityAccess().getRequiresMinKeyword_3_1_2_0());
            	      									
            	    }
            	    otherlv_13=(Token)match(input,19,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_13, grammarAccess.getRequiredCapabilityAccess().getColonKeyword_3_1_2_1());
            	      									
            	    }
            	    // InternalBeeLangTestLanguage.g:1257:10: ( (lv_min_14_0= RULE_INT ) )
            	    // InternalBeeLangTestLanguage.g:1258:11: (lv_min_14_0= RULE_INT )
            	    {
            	    // InternalBeeLangTestLanguage.g:1258:11: (lv_min_14_0= RULE_INT )
            	    // InternalBeeLangTestLanguage.g:1259:12: lv_min_14_0= RULE_INT
            	    {
            	    lv_min_14_0=(Token)match(input,RULE_INT,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												newLeafNode(lv_min_14_0, grammarAccess.getRequiredCapabilityAccess().getMinINTTerminalRuleCall_3_1_2_2_0());
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												if (current==null) {
            	      													current = createModelElement(grammarAccess.getRequiredCapabilityRule());
            	      												}
            	      												setWithLastConsumed(
            	      													current,
            	      													"min",
            	      													lv_min_14_0,
            	      													"org.eclipse.xtext.common.Terminals.INT");
            	      											
            	    }

            	    }


            	    }

            	    otherlv_15=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_15, grammarAccess.getRequiredCapabilityAccess().getSemicolonKeyword_3_1_2_3());
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalBeeLangTestLanguage.g:1285:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:1285:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
            	    // InternalBeeLangTestLanguage.g:1286:6: {...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
            	    }
            	    // InternalBeeLangTestLanguage.g:1286:118: ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
            	    // InternalBeeLangTestLanguage.g:1287:7: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
            	    // InternalBeeLangTestLanguage.g:1290:10: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
            	    // InternalBeeLangTestLanguage.g:1290:11: {...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // InternalBeeLangTestLanguage.g:1290:20: (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
            	    // InternalBeeLangTestLanguage.g:1290:21: otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';'
            	    {
            	    otherlv_16=(Token)match(input,31,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_16, grammarAccess.getRequiredCapabilityAccess().getRequiresMaxKeyword_3_1_3_0());
            	      									
            	    }
            	    otherlv_17=(Token)match(input,19,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_17, grammarAccess.getRequiredCapabilityAccess().getColonKeyword_3_1_3_1());
            	      									
            	    }
            	    // InternalBeeLangTestLanguage.g:1298:10: ( (lv_max_18_0= RULE_INT ) )
            	    // InternalBeeLangTestLanguage.g:1299:11: (lv_max_18_0= RULE_INT )
            	    {
            	    // InternalBeeLangTestLanguage.g:1299:11: (lv_max_18_0= RULE_INT )
            	    // InternalBeeLangTestLanguage.g:1300:12: lv_max_18_0= RULE_INT
            	    {
            	    lv_max_18_0=(Token)match(input,RULE_INT,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												newLeafNode(lv_max_18_0, grammarAccess.getRequiredCapabilityAccess().getMaxINTTerminalRuleCall_3_1_3_2_0());
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												if (current==null) {
            	      													current = createModelElement(grammarAccess.getRequiredCapabilityRule());
            	      												}
            	      												setWithLastConsumed(
            	      													current,
            	      													"max",
            	      													lv_max_18_0,
            	      													"org.eclipse.xtext.common.Terminals.INT");
            	      											
            	    }

            	    }


            	    }

            	    otherlv_19=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_19, grammarAccess.getRequiredCapabilityAccess().getSemicolonKeyword_3_1_3_3());
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalBeeLangTestLanguage.g:1326:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:1326:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
            	    // InternalBeeLangTestLanguage.g:1327:6: {...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
            	    }
            	    // InternalBeeLangTestLanguage.g:1327:118: ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
            	    // InternalBeeLangTestLanguage.g:1328:7: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
            	    // InternalBeeLangTestLanguage.g:1331:10: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
            	    // InternalBeeLangTestLanguage.g:1331:11: {...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // InternalBeeLangTestLanguage.g:1331:20: (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
            	    // InternalBeeLangTestLanguage.g:1331:21: otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';'
            	    {
            	    otherlv_20=(Token)match(input,14,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_20, grammarAccess.getRequiredCapabilityAccess().getVersionKeyword_3_1_4_0());
            	      									
            	    }
            	    otherlv_21=(Token)match(input,19,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_21, grammarAccess.getRequiredCapabilityAccess().getColonKeyword_3_1_4_1());
            	      									
            	    }
            	    // InternalBeeLangTestLanguage.g:1339:10: ( (lv_versionRange_22_0= RULE_ID ) )
            	    // InternalBeeLangTestLanguage.g:1340:11: (lv_versionRange_22_0= RULE_ID )
            	    {
            	    // InternalBeeLangTestLanguage.g:1340:11: (lv_versionRange_22_0= RULE_ID )
            	    // InternalBeeLangTestLanguage.g:1341:12: lv_versionRange_22_0= RULE_ID
            	    {
            	    lv_versionRange_22_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												newLeafNode(lv_versionRange_22_0, grammarAccess.getRequiredCapabilityAccess().getVersionRangeIDTerminalRuleCall_3_1_4_2_0());
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												if (current==null) {
            	      													current = createModelElement(grammarAccess.getRequiredCapabilityRule());
            	      												}
            	      												setWithLastConsumed(
            	      													current,
            	      													"versionRange",
            	      													lv_versionRange_22_0,
            	      													"org.eclipse.xtext.common.Terminals.ID");
            	      											
            	    }

            	    }


            	    }

            	    otherlv_23=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_23, grammarAccess.getRequiredCapabilityAccess().getSemicolonKeyword_3_1_4_3());
            	      									
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

            otherlv_24=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_24, grammarAccess.getRequiredCapabilityAccess().getRightCurlyBracketKeyword_3_2());
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, ruleRequiredCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleRequiredCapability"


    // $ANTLR start "entryRulePath"
    // InternalBeeLangTestLanguage.g:1386:1: entryRulePath returns [String current=null] : iv_rulePath= rulePath EOF ;
    public final String entryRulePath() throws RecognitionException {
        String current = null;
        int entryRulePath_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_rulePath = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return current; }
            // InternalBeeLangTestLanguage.g:1388:2: (iv_rulePath= rulePath EOF )
            // InternalBeeLangTestLanguage.g:1389:2: iv_rulePath= rulePath EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePath=rulePath();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePath.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, entryRulePath_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRulePath"


    // $ANTLR start "rulePath"
    // InternalBeeLangTestLanguage.g:1398:1: rulePath returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | ( (kw= '/' )? this_QID_2= ruleQID (kw= '/' this_QID_4= ruleQID )* (kw= '/' )? ) ) ;
    public final AntlrDatatypeRuleToken rulePath() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int rulePath_StartIndex = input.index();
        Token this_STRING_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_QID_2 = null;

        AntlrDatatypeRuleToken this_QID_4 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return current; }
            // InternalBeeLangTestLanguage.g:1405:2: ( (this_STRING_0= RULE_STRING | ( (kw= '/' )? this_QID_2= ruleQID (kw= '/' this_QID_4= ruleQID )* (kw= '/' )? ) ) )
            // InternalBeeLangTestLanguage.g:1406:2: (this_STRING_0= RULE_STRING | ( (kw= '/' )? this_QID_2= ruleQID (kw= '/' this_QID_4= ruleQID )* (kw= '/' )? ) )
            {
            // InternalBeeLangTestLanguage.g:1406:2: (this_STRING_0= RULE_STRING | ( (kw= '/' )? this_QID_2= ruleQID (kw= '/' this_QID_4= ruleQID )* (kw= '/' )? ) )
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
                    // InternalBeeLangTestLanguage.g:1407:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_STRING_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_STRING_0, grammarAccess.getPathAccess().getSTRINGTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBeeLangTestLanguage.g:1415:3: ( (kw= '/' )? this_QID_2= ruleQID (kw= '/' this_QID_4= ruleQID )* (kw= '/' )? )
                    {
                    // InternalBeeLangTestLanguage.g:1415:3: ( (kw= '/' )? this_QID_2= ruleQID (kw= '/' this_QID_4= ruleQID )* (kw= '/' )? )
                    // InternalBeeLangTestLanguage.g:1416:4: (kw= '/' )? this_QID_2= ruleQID (kw= '/' this_QID_4= ruleQID )* (kw= '/' )?
                    {
                    // InternalBeeLangTestLanguage.g:1416:4: (kw= '/' )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==32) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalBeeLangTestLanguage.g:1417:5: kw= '/'
                            {
                            kw=(Token)match(input,32,FOLLOW_13); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getPathAccess().getSolidusKeyword_1_0());
                              				
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPathAccess().getQIDParserRuleCall_1_1());
                      			
                    }
                    pushFollow(FOLLOW_25);
                    this_QID_2=ruleQID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_QID_2);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalBeeLangTestLanguage.g:1433:4: (kw= '/' this_QID_4= ruleQID )*
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
                    	    // InternalBeeLangTestLanguage.g:1434:5: kw= '/' this_QID_4= ruleQID
                    	    {
                    	    kw=(Token)match(input,32,FOLLOW_13); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					current.merge(kw);
                    	      					newLeafNode(kw, grammarAccess.getPathAccess().getSolidusKeyword_1_2_0());
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					newCompositeNode(grammarAccess.getPathAccess().getQIDParserRuleCall_1_2_1());
                    	      				
                    	    }
                    	    pushFollow(FOLLOW_25);
                    	    this_QID_4=ruleQID();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					current.merge(this_QID_4);
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					afterParserOrEnumRuleCall();
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    // InternalBeeLangTestLanguage.g:1450:4: (kw= '/' )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==32) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalBeeLangTestLanguage.g:1451:5: kw= '/'
                            {
                            kw=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getPathAccess().getSolidusKeyword_1_3());
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, rulePath_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "rulePath"


    // $ANTLR start "entryRuleParameterList"
    // InternalBeeLangTestLanguage.g:1465:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;
        int entryRuleParameterList_StartIndex = input.index();
        EObject iv_ruleParameterList = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return current; }
            // InternalBeeLangTestLanguage.g:1465:54: (iv_ruleParameterList= ruleParameterList EOF )
            // InternalBeeLangTestLanguage.g:1466:2: iv_ruleParameterList= ruleParameterList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterListRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, entryRuleParameterList_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterList"


    // $ANTLR start "ruleParameterList"
    // InternalBeeLangTestLanguage.g:1472:1: ruleParameterList returns [EObject current=null] : ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;
        int ruleParameterList_StartIndex = input.index();
        Token otherlv_1=null;
        EObject lv_parameters_0_0 = null;

        EObject lv_parameters_2_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return current; }
            // InternalBeeLangTestLanguage.g:1478:2: ( ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* ) )
            // InternalBeeLangTestLanguage.g:1479:2: ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* )
            {
            // InternalBeeLangTestLanguage.g:1479:2: ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* )
            // InternalBeeLangTestLanguage.g:1480:3: ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )*
            {
            // InternalBeeLangTestLanguage.g:1480:3: ( (lv_parameters_0_0= ruleFirstParameter ) )
            // InternalBeeLangTestLanguage.g:1481:4: (lv_parameters_0_0= ruleFirstParameter )
            {
            // InternalBeeLangTestLanguage.g:1481:4: (lv_parameters_0_0= ruleFirstParameter )
            // InternalBeeLangTestLanguage.g:1482:5: lv_parameters_0_0= ruleFirstParameter
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterListAccess().getParametersFirstParameterParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_26);
            lv_parameters_0_0=ruleFirstParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterListRule());
              					}
              					add(
              						current,
              						"parameters",
              						lv_parameters_0_0,
              						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.FirstParameter");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBeeLangTestLanguage.g:1499:3: (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==16) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalBeeLangTestLanguage.g:1500:4: otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) )
            	    {
            	    otherlv_1=(Token)match(input,16,FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalBeeLangTestLanguage.g:1504:4: ( (lv_parameters_2_0= ruleFirstParameter ) )
            	    // InternalBeeLangTestLanguage.g:1505:5: (lv_parameters_2_0= ruleFirstParameter )
            	    {
            	    // InternalBeeLangTestLanguage.g:1505:5: (lv_parameters_2_0= ruleFirstParameter )
            	    // InternalBeeLangTestLanguage.g:1506:6: lv_parameters_2_0= ruleFirstParameter
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getParameterListAccess().getParametersFirstParameterParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_26);
            	    lv_parameters_2_0=ruleFirstParameter();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getParameterListRule());
            	      						}
            	      						add(
            	      							current,
            	      							"parameters",
            	      							lv_parameters_2_0,
            	      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.FirstParameter");
            	      						afterParserOrEnumRuleCall();
            	      					
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, ruleParameterList_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleParameterList"


    // $ANTLR start "entryRuleFirstParameter"
    // InternalBeeLangTestLanguage.g:1528:1: entryRuleFirstParameter returns [EObject current=null] : iv_ruleFirstParameter= ruleFirstParameter EOF ;
    public final EObject entryRuleFirstParameter() throws RecognitionException {
        EObject current = null;
        int entryRuleFirstParameter_StartIndex = input.index();
        EObject iv_ruleFirstParameter = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return current; }
            // InternalBeeLangTestLanguage.g:1528:55: (iv_ruleFirstParameter= ruleFirstParameter EOF )
            // InternalBeeLangTestLanguage.g:1529:2: iv_ruleFirstParameter= ruleFirstParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFirstParameterRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, entryRuleFirstParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleFirstParameter"


    // $ANTLR start "ruleFirstParameter"
    // InternalBeeLangTestLanguage.g:1535:1: ruleFirstParameter returns [EObject current=null] : (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter ) ;
    public final EObject ruleFirstParameter() throws RecognitionException {
        EObject current = null;
        int ruleFirstParameter_StartIndex = input.index();
        EObject this_ClosureParameter_0 = null;

        EObject this_Parameter_1 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return current; }
            // InternalBeeLangTestLanguage.g:1541:2: ( (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter ) )
            // InternalBeeLangTestLanguage.g:1542:2: (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter )
            {
            // InternalBeeLangTestLanguage.g:1542:2: (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter )
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:1543:3: this_ClosureParameter_0= ruleClosureParameter
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFirstParameterAccess().getClosureParameterParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ClosureParameter_0=ruleClosureParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ClosureParameter_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBeeLangTestLanguage.g:1555:3: this_Parameter_1= ruleParameter
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFirstParameterAccess().getParameterParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Parameter_1=ruleParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Parameter_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, ruleFirstParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleFirstParameter"


    // $ANTLR start "entryRuleParameter"
    // InternalBeeLangTestLanguage.g:1570:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;
        int entryRuleParameter_StartIndex = input.index();
        EObject iv_ruleParameter = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return current; }
            // InternalBeeLangTestLanguage.g:1570:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalBeeLangTestLanguage.g:1571:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, entryRuleParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalBeeLangTestLanguage.g:1577:1: ruleParameter returns [EObject current=null] : ( (lv_expr_0_0= ruleExpression ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;
        int ruleParameter_StartIndex = input.index();
        EObject lv_expr_0_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return current; }
            // InternalBeeLangTestLanguage.g:1583:2: ( ( (lv_expr_0_0= ruleExpression ) ) )
            // InternalBeeLangTestLanguage.g:1584:2: ( (lv_expr_0_0= ruleExpression ) )
            {
            // InternalBeeLangTestLanguage.g:1584:2: ( (lv_expr_0_0= ruleExpression ) )
            // InternalBeeLangTestLanguage.g:1585:3: (lv_expr_0_0= ruleExpression )
            {
            // InternalBeeLangTestLanguage.g:1585:3: (lv_expr_0_0= ruleExpression )
            // InternalBeeLangTestLanguage.g:1586:4: lv_expr_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getParameterAccess().getExprExpressionParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_expr_0_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getParameterRule());
              				}
              				set(
              					current,
              					"expr",
              					lv_expr_0_0,
              					"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, ruleParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleClosureParameter"
    // InternalBeeLangTestLanguage.g:1606:1: entryRuleClosureParameter returns [EObject current=null] : iv_ruleClosureParameter= ruleClosureParameter EOF ;
    public final EObject entryRuleClosureParameter() throws RecognitionException {
        EObject current = null;
        int entryRuleClosureParameter_StartIndex = input.index();
        EObject iv_ruleClosureParameter = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return current; }
            // InternalBeeLangTestLanguage.g:1606:57: (iv_ruleClosureParameter= ruleClosureParameter EOF )
            // InternalBeeLangTestLanguage.g:1607:2: iv_ruleClosureParameter= ruleClosureParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClosureParameterRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, entryRuleClosureParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleClosureParameter"


    // $ANTLR start "ruleClosureParameter"
    // InternalBeeLangTestLanguage.g:1613:1: ruleClosureParameter returns [EObject current=null] : ( (lv_expr_0_0= ruleClosureExpression ) ) ;
    public final EObject ruleClosureParameter() throws RecognitionException {
        EObject current = null;
        int ruleClosureParameter_StartIndex = input.index();
        EObject lv_expr_0_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return current; }
            // InternalBeeLangTestLanguage.g:1619:2: ( ( (lv_expr_0_0= ruleClosureExpression ) ) )
            // InternalBeeLangTestLanguage.g:1620:2: ( (lv_expr_0_0= ruleClosureExpression ) )
            {
            // InternalBeeLangTestLanguage.g:1620:2: ( (lv_expr_0_0= ruleClosureExpression ) )
            // InternalBeeLangTestLanguage.g:1621:3: (lv_expr_0_0= ruleClosureExpression )
            {
            // InternalBeeLangTestLanguage.g:1621:3: (lv_expr_0_0= ruleClosureExpression )
            // InternalBeeLangTestLanguage.g:1622:4: lv_expr_0_0= ruleClosureExpression
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getClosureParameterAccess().getExprClosureExpressionParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_expr_0_0=ruleClosureExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getClosureParameterRule());
              				}
              				set(
              					current,
              					"expr",
              					lv_expr_0_0,
              					"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ClosureExpression");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, ruleClosureParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleClosureParameter"


    // $ANTLR start "entryRuleParameterDeclaration"
    // InternalBeeLangTestLanguage.g:1642:1: entryRuleParameterDeclaration returns [EObject current=null] : iv_ruleParameterDeclaration= ruleParameterDeclaration EOF ;
    public final EObject entryRuleParameterDeclaration() throws RecognitionException {
        EObject current = null;
        int entryRuleParameterDeclaration_StartIndex = input.index();
        EObject iv_ruleParameterDeclaration = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return current; }
            // InternalBeeLangTestLanguage.g:1642:61: (iv_ruleParameterDeclaration= ruleParameterDeclaration EOF )
            // InternalBeeLangTestLanguage.g:1643:2: iv_ruleParameterDeclaration= ruleParameterDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterDeclarationRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, entryRuleParameterDeclaration_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterDeclaration"


    // $ANTLR start "ruleParameterDeclaration"
    // InternalBeeLangTestLanguage.g:1649:1: ruleParameterDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleParameterDeclaration() throws RecognitionException {
        EObject current = null;
        int ruleParameterDeclaration_StartIndex = input.index();
        Token lv_name_1_0=null;
        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return current; }
            // InternalBeeLangTestLanguage.g:1655:2: ( ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalBeeLangTestLanguage.g:1656:2: ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalBeeLangTestLanguage.g:1656:2: ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) )
            // InternalBeeLangTestLanguage.g:1657:3: ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalBeeLangTestLanguage.g:1657:3: ( (lv_type_0_0= ruleTypeRef ) )?
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
                    // InternalBeeLangTestLanguage.g:1658:4: (lv_type_0_0= ruleTypeRef )
                    {
                    // InternalBeeLangTestLanguage.g:1658:4: (lv_type_0_0= ruleTypeRef )
                    // InternalBeeLangTestLanguage.g:1659:5: lv_type_0_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getParameterDeclarationAccess().getTypeTypeRefParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_8);
                    lv_type_0_0=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getParameterDeclarationRule());
                      					}
                      					set(
                      						current,
                      						"type",
                      						lv_type_0_0,
                      						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.TypeRef");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalBeeLangTestLanguage.g:1676:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalBeeLangTestLanguage.g:1677:4: (lv_name_1_0= RULE_ID )
            {
            // InternalBeeLangTestLanguage.g:1677:4: (lv_name_1_0= RULE_ID )
            // InternalBeeLangTestLanguage.g:1678:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getParameterDeclarationAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getParameterDeclarationRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 22, ruleParameterDeclaration_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleParameterDeclaration"


    // $ANTLR start "entryRuleFunction"
    // InternalBeeLangTestLanguage.g:1698:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;
        int entryRuleFunction_StartIndex = input.index();
        EObject iv_ruleFunction = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return current; }
            // InternalBeeLangTestLanguage.g:1698:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalBeeLangTestLanguage.g:1699:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, entryRuleFunction_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalBeeLangTestLanguage.g:1705:1: ruleFunction returns [EObject current=null] : ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;
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
        EObject lv_returnType_4_0 = null;

        EObject lv_parameters_7_0 = null;

        EObject lv_parameters_9_0 = null;

        EObject lv_parameters_12_0 = null;

        EObject lv_parameters_14_0 = null;

        EObject lv_guard_17_0 = null;

        EObject lv_funcExpr_19_0 = null;

        EObject lv_funcExpr_21_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return current; }
            // InternalBeeLangTestLanguage.g:1711:2: ( ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) ) )
            // InternalBeeLangTestLanguage.g:1712:2: ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) )
            {
            // InternalBeeLangTestLanguage.g:1712:2: ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) )
            // InternalBeeLangTestLanguage.g:1713:3: ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) )
            {
            // InternalBeeLangTestLanguage.g:1713:3: ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_DOCUMENTATION) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:1714:4: (lv_documentation_0_0= RULE_DOCUMENTATION )
                    {
                    // InternalBeeLangTestLanguage.g:1714:4: (lv_documentation_0_0= RULE_DOCUMENTATION )
                    // InternalBeeLangTestLanguage.g:1715:5: lv_documentation_0_0= RULE_DOCUMENTATION
                    {
                    lv_documentation_0_0=(Token)match(input,RULE_DOCUMENTATION,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_documentation_0_0, grammarAccess.getFunctionAccess().getDocumentationDOCUMENTATIONTerminalRuleCall_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFunctionRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"documentation",
                      						lv_documentation_0_0,
                      						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.DOCUMENTATION");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalBeeLangTestLanguage.g:1731:3: ( (lv_visibility_1_0= RULE_ID ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:1732:4: (lv_visibility_1_0= RULE_ID )
                    {
                    // InternalBeeLangTestLanguage.g:1732:4: (lv_visibility_1_0= RULE_ID )
                    // InternalBeeLangTestLanguage.g:1733:5: lv_visibility_1_0= RULE_ID
                    {
                    lv_visibility_1_0=(Token)match(input,RULE_ID,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_visibility_1_0, grammarAccess.getFunctionAccess().getVisibilityIDTerminalRuleCall_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFunctionRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"visibility",
                      						lv_visibility_1_0,
                      						"org.eclipse.xtext.common.Terminals.ID");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalBeeLangTestLanguage.g:1749:3: ( (lv_final_2_0= 'final' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==33) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:1750:4: (lv_final_2_0= 'final' )
                    {
                    // InternalBeeLangTestLanguage.g:1750:4: (lv_final_2_0= 'final' )
                    // InternalBeeLangTestLanguage.g:1751:5: lv_final_2_0= 'final'
                    {
                    lv_final_2_0=(Token)match(input,33,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_final_2_0, grammarAccess.getFunctionAccess().getFinalFinalKeyword_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFunctionRule());
                      					}
                      					setWithLastConsumed(current, "final", true, "final");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,34,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getFunctionAccess().getFunctionKeyword_3());
              		
            }
            // InternalBeeLangTestLanguage.g:1767:3: ( (lv_returnType_4_0= ruleTypeRef ) )?
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
                    // InternalBeeLangTestLanguage.g:1768:4: (lv_returnType_4_0= ruleTypeRef )
                    {
                    // InternalBeeLangTestLanguage.g:1768:4: (lv_returnType_4_0= ruleTypeRef )
                    // InternalBeeLangTestLanguage.g:1769:5: lv_returnType_4_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFunctionAccess().getReturnTypeTypeRefParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_8);
                    lv_returnType_4_0=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getFunctionRule());
                      					}
                      					set(
                      						current,
                      						"returnType",
                      						lv_returnType_4_0,
                      						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.TypeRef");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalBeeLangTestLanguage.g:1786:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalBeeLangTestLanguage.g:1787:4: (lv_name_5_0= RULE_ID )
            {
            // InternalBeeLangTestLanguage.g:1787:4: (lv_name_5_0= RULE_ID )
            // InternalBeeLangTestLanguage.g:1788:5: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_5_0, grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_5_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFunctionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_5_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalBeeLangTestLanguage.g:1804:3: (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==35) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:1805:4: otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')'
                    {
                    otherlv_6=(Token)match(input,35,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_6_0());
                      			
                    }
                    // InternalBeeLangTestLanguage.g:1809:4: ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )?
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
                            // InternalBeeLangTestLanguage.g:1810:5: ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? )
                            {
                            // InternalBeeLangTestLanguage.g:1810:5: ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? )
                            // InternalBeeLangTestLanguage.g:1811:6: ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )?
                            {
                            // InternalBeeLangTestLanguage.g:1811:6: ( (lv_parameters_7_0= ruleParameterDeclaration ) )
                            // InternalBeeLangTestLanguage.g:1812:7: (lv_parameters_7_0= ruleParameterDeclaration )
                            {
                            // InternalBeeLangTestLanguage.g:1812:7: (lv_parameters_7_0= ruleParameterDeclaration )
                            // InternalBeeLangTestLanguage.g:1813:8: lv_parameters_7_0= ruleParameterDeclaration
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getFunctionAccess().getParametersParameterDeclarationParserRuleCall_6_1_0_0_0());
                              							
                            }
                            pushFollow(FOLLOW_34);
                            lv_parameters_7_0=ruleParameterDeclaration();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getFunctionRule());
                              								}
                              								add(
                              									current,
                              									"parameters",
                              									lv_parameters_7_0,
                              									"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterDeclaration");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }

                            // InternalBeeLangTestLanguage.g:1830:6: (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )*
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
                            	    // InternalBeeLangTestLanguage.g:1831:7: otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) )
                            	    {
                            	    otherlv_8=(Token)match(input,16,FOLLOW_35); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							newLeafNode(otherlv_8, grammarAccess.getFunctionAccess().getCommaKeyword_6_1_0_1_0());
                            	      						
                            	    }
                            	    // InternalBeeLangTestLanguage.g:1835:7: ( (lv_parameters_9_0= ruleParameterDeclaration ) )
                            	    // InternalBeeLangTestLanguage.g:1836:8: (lv_parameters_9_0= ruleParameterDeclaration )
                            	    {
                            	    // InternalBeeLangTestLanguage.g:1836:8: (lv_parameters_9_0= ruleParameterDeclaration )
                            	    // InternalBeeLangTestLanguage.g:1837:9: lv_parameters_9_0= ruleParameterDeclaration
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									newCompositeNode(grammarAccess.getFunctionAccess().getParametersParameterDeclarationParserRuleCall_6_1_0_1_1_0());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_34);
                            	    lv_parameters_9_0=ruleParameterDeclaration();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      									if (current==null) {
                            	      										current = createModelElementForParent(grammarAccess.getFunctionRule());
                            	      									}
                            	      									add(
                            	      										current,
                            	      										"parameters",
                            	      										lv_parameters_9_0,
                            	      										"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterDeclaration");
                            	      									afterParserOrEnumRuleCall();
                            	      								
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop33;
                                }
                            } while (true);

                            // InternalBeeLangTestLanguage.g:1855:6: (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )?
                            int alt34=2;
                            int LA34_0 = input.LA(1);

                            if ( (LA34_0==16) ) {
                                alt34=1;
                            }
                            switch (alt34) {
                                case 1 :
                                    // InternalBeeLangTestLanguage.g:1856:7: otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                                    {
                                    otherlv_10=(Token)match(input,16,FOLLOW_36); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							newLeafNode(otherlv_10, grammarAccess.getFunctionAccess().getCommaKeyword_6_1_0_2_0());
                                      						
                                    }
                                    // InternalBeeLangTestLanguage.g:1860:7: ( (lv_varArgs_11_0= '...' ) )
                                    // InternalBeeLangTestLanguage.g:1861:8: (lv_varArgs_11_0= '...' )
                                    {
                                    // InternalBeeLangTestLanguage.g:1861:8: (lv_varArgs_11_0= '...' )
                                    // InternalBeeLangTestLanguage.g:1862:9: lv_varArgs_11_0= '...'
                                    {
                                    lv_varArgs_11_0=(Token)match(input,36,FOLLOW_35); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									newLeafNode(lv_varArgs_11_0, grammarAccess.getFunctionAccess().getVarArgsFullStopFullStopFullStopKeyword_6_1_0_2_1_0());
                                      								
                                    }
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElement(grammarAccess.getFunctionRule());
                                      									}
                                      									setWithLastConsumed(current, "varArgs", true, "...");
                                      								
                                    }

                                    }


                                    }

                                    // InternalBeeLangTestLanguage.g:1874:7: ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                                    // InternalBeeLangTestLanguage.g:1875:8: (lv_parameters_12_0= ruleParameterDeclaration )
                                    {
                                    // InternalBeeLangTestLanguage.g:1875:8: (lv_parameters_12_0= ruleParameterDeclaration )
                                    // InternalBeeLangTestLanguage.g:1876:9: lv_parameters_12_0= ruleParameterDeclaration
                                    {
                                    if ( state.backtracking==0 ) {

                                      									newCompositeNode(grammarAccess.getFunctionAccess().getParametersParameterDeclarationParserRuleCall_6_1_0_2_2_0());
                                      								
                                    }
                                    pushFollow(FOLLOW_37);
                                    lv_parameters_12_0=ruleParameterDeclaration();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElementForParent(grammarAccess.getFunctionRule());
                                      									}
                                      									add(
                                      										current,
                                      										"parameters",
                                      										lv_parameters_12_0,
                                      										"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterDeclaration");
                                      									afterParserOrEnumRuleCall();
                                      								
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
                            // InternalBeeLangTestLanguage.g:1896:5: ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) )
                            {
                            // InternalBeeLangTestLanguage.g:1896:5: ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) )
                            // InternalBeeLangTestLanguage.g:1897:6: ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) )
                            {
                            // InternalBeeLangTestLanguage.g:1897:6: ( (lv_varArgs_13_0= '...' ) )
                            // InternalBeeLangTestLanguage.g:1898:7: (lv_varArgs_13_0= '...' )
                            {
                            // InternalBeeLangTestLanguage.g:1898:7: (lv_varArgs_13_0= '...' )
                            // InternalBeeLangTestLanguage.g:1899:8: lv_varArgs_13_0= '...'
                            {
                            lv_varArgs_13_0=(Token)match(input,36,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_varArgs_13_0, grammarAccess.getFunctionAccess().getVarArgsFullStopFullStopFullStopKeyword_6_1_1_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getFunctionRule());
                              								}
                              								setWithLastConsumed(current, "varArgs", true, "...");
                              							
                            }

                            }


                            }

                            // InternalBeeLangTestLanguage.g:1911:6: ( (lv_parameters_14_0= ruleParameterDeclaration ) )
                            // InternalBeeLangTestLanguage.g:1912:7: (lv_parameters_14_0= ruleParameterDeclaration )
                            {
                            // InternalBeeLangTestLanguage.g:1912:7: (lv_parameters_14_0= ruleParameterDeclaration )
                            // InternalBeeLangTestLanguage.g:1913:8: lv_parameters_14_0= ruleParameterDeclaration
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getFunctionAccess().getParametersParameterDeclarationParserRuleCall_6_1_1_1_0());
                              							
                            }
                            pushFollow(FOLLOW_37);
                            lv_parameters_14_0=ruleParameterDeclaration();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getFunctionRule());
                              								}
                              								add(
                              									current,
                              									"parameters",
                              									lv_parameters_14_0,
                              									"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterDeclaration");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }


                            }
                            break;

                    }

                    otherlv_15=(Token)match(input,37,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_6_2());
                      			
                    }

                    }
                    break;

            }

            // InternalBeeLangTestLanguage.g:1937:3: (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==26) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:1938:4: otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) )
                    {
                    otherlv_16=(Token)match(input,26,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_16, grammarAccess.getFunctionAccess().getWhenKeyword_7_0());
                      			
                    }
                    // InternalBeeLangTestLanguage.g:1942:4: ( (lv_guard_17_0= ruleGuardExpression ) )
                    // InternalBeeLangTestLanguage.g:1943:5: (lv_guard_17_0= ruleGuardExpression )
                    {
                    // InternalBeeLangTestLanguage.g:1943:5: (lv_guard_17_0= ruleGuardExpression )
                    // InternalBeeLangTestLanguage.g:1944:6: lv_guard_17_0= ruleGuardExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionAccess().getGuardGuardExpressionParserRuleCall_7_1_0());
                      					
                    }
                    pushFollow(FOLLOW_39);
                    lv_guard_17_0=ruleGuardExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionRule());
                      						}
                      						set(
                      							current,
                      							"guard",
                      							lv_guard_17_0,
                      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.GuardExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalBeeLangTestLanguage.g:1962:3: ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) )
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
                    // InternalBeeLangTestLanguage.g:1963:4: (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' )
                    {
                    // InternalBeeLangTestLanguage.g:1963:4: (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' )
                    // InternalBeeLangTestLanguage.g:1964:5: otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';'
                    {
                    otherlv_18=(Token)match(input,19,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_18, grammarAccess.getFunctionAccess().getColonKeyword_8_0_0());
                      				
                    }
                    // InternalBeeLangTestLanguage.g:1968:5: ( (lv_funcExpr_19_0= ruleExpression ) )
                    // InternalBeeLangTestLanguage.g:1969:6: (lv_funcExpr_19_0= ruleExpression )
                    {
                    // InternalBeeLangTestLanguage.g:1969:6: (lv_funcExpr_19_0= ruleExpression )
                    // InternalBeeLangTestLanguage.g:1970:7: lv_funcExpr_19_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getFunctionAccess().getFuncExprExpressionParserRuleCall_8_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_14);
                    lv_funcExpr_19_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getFunctionRule());
                      							}
                      							set(
                      								current,
                      								"funcExpr",
                      								lv_funcExpr_19_0,
                      								"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_20=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_20, grammarAccess.getFunctionAccess().getSemicolonKeyword_8_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBeeLangTestLanguage.g:1993:4: ( (lv_funcExpr_21_0= ruleBlockExpression ) )
                    {
                    // InternalBeeLangTestLanguage.g:1993:4: ( (lv_funcExpr_21_0= ruleBlockExpression ) )
                    // InternalBeeLangTestLanguage.g:1994:5: (lv_funcExpr_21_0= ruleBlockExpression )
                    {
                    // InternalBeeLangTestLanguage.g:1994:5: (lv_funcExpr_21_0= ruleBlockExpression )
                    // InternalBeeLangTestLanguage.g:1995:6: lv_funcExpr_21_0= ruleBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionAccess().getFuncExprBlockExpressionParserRuleCall_8_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_funcExpr_21_0=ruleBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionRule());
                      						}
                      						set(
                      							current,
                      							"funcExpr",
                      							lv_funcExpr_21_0,
                      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.BlockExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 24, ruleFunction_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleGuardExpression"
    // InternalBeeLangTestLanguage.g:2017:1: entryRuleGuardExpression returns [EObject current=null] : iv_ruleGuardExpression= ruleGuardExpression EOF ;
    public final EObject entryRuleGuardExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleGuardExpression_StartIndex = input.index();
        EObject iv_ruleGuardExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return current; }
            // InternalBeeLangTestLanguage.g:2017:56: (iv_ruleGuardExpression= ruleGuardExpression EOF )
            // InternalBeeLangTestLanguage.g:2018:2: iv_ruleGuardExpression= ruleGuardExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGuardExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, entryRuleGuardExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleGuardExpression"


    // $ANTLR start "ruleGuardExpression"
    // InternalBeeLangTestLanguage.g:2024:1: ruleGuardExpression returns [EObject current=null] : ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) ) ;
    public final EObject ruleGuardExpression() throws RecognitionException {
        EObject current = null;
        int ruleGuardExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_guardExpr_1_0 = null;

        EObject lv_guardExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return current; }
            // InternalBeeLangTestLanguage.g:2030:2: ( ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) ) )
            // InternalBeeLangTestLanguage.g:2031:2: ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) )
            {
            // InternalBeeLangTestLanguage.g:2031:2: ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) )
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
                    // InternalBeeLangTestLanguage.g:2032:3: (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' )
                    {
                    // InternalBeeLangTestLanguage.g:2032:3: (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' )
                    // InternalBeeLangTestLanguage.g:2033:4: otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';'
                    {
                    otherlv_0=(Token)match(input,19,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getGuardExpressionAccess().getColonKeyword_0_0());
                      			
                    }
                    // InternalBeeLangTestLanguage.g:2037:4: ( (lv_guardExpr_1_0= ruleExpression ) )
                    // InternalBeeLangTestLanguage.g:2038:5: (lv_guardExpr_1_0= ruleExpression )
                    {
                    // InternalBeeLangTestLanguage.g:2038:5: (lv_guardExpr_1_0= ruleExpression )
                    // InternalBeeLangTestLanguage.g:2039:6: lv_guardExpr_1_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getGuardExpressionAccess().getGuardExprExpressionParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_14);
                    lv_guardExpr_1_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getGuardExpressionRule());
                      						}
                      						set(
                      							current,
                      							"guardExpr",
                      							lv_guardExpr_1_0,
                      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getGuardExpressionAccess().getSemicolonKeyword_0_2());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBeeLangTestLanguage.g:2062:3: ( (lv_guardExpr_3_0= ruleBlockExpression ) )
                    {
                    // InternalBeeLangTestLanguage.g:2062:3: ( (lv_guardExpr_3_0= ruleBlockExpression ) )
                    // InternalBeeLangTestLanguage.g:2063:4: (lv_guardExpr_3_0= ruleBlockExpression )
                    {
                    // InternalBeeLangTestLanguage.g:2063:4: (lv_guardExpr_3_0= ruleBlockExpression )
                    // InternalBeeLangTestLanguage.g:2064:5: lv_guardExpr_3_0= ruleBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getGuardExpressionAccess().getGuardExprBlockExpressionParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_guardExpr_3_0=ruleBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getGuardExpressionRule());
                      					}
                      					set(
                      						current,
                      						"guardExpr",
                      						lv_guardExpr_3_0,
                      						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.BlockExpression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 26, ruleGuardExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleGuardExpression"


    // $ANTLR start "entryRuleAssignmentOperator"
    // InternalBeeLangTestLanguage.g:2085:1: entryRuleAssignmentOperator returns [String current=null] : iv_ruleAssignmentOperator= ruleAssignmentOperator EOF ;
    public final String entryRuleAssignmentOperator() throws RecognitionException {
        String current = null;
        int entryRuleAssignmentOperator_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleAssignmentOperator = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return current; }
            // InternalBeeLangTestLanguage.g:2085:58: (iv_ruleAssignmentOperator= ruleAssignmentOperator EOF )
            // InternalBeeLangTestLanguage.g:2086:2: iv_ruleAssignmentOperator= ruleAssignmentOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignmentOperator=ruleAssignmentOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentOperator.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, entryRuleAssignmentOperator_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentOperator"


    // $ANTLR start "ruleAssignmentOperator"
    // InternalBeeLangTestLanguage.g:2092:1: ruleAssignmentOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' ) ;
    public final AntlrDatatypeRuleToken ruleAssignmentOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleAssignmentOperator_StartIndex = input.index();
        Token kw=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return current; }
            // InternalBeeLangTestLanguage.g:2098:2: ( (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' ) )
            // InternalBeeLangTestLanguage.g:2099:2: (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' )
            {
            // InternalBeeLangTestLanguage.g:2099:2: (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' )
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
                    // InternalBeeLangTestLanguage.g:2100:3: kw= '='
                    {
                    kw=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBeeLangTestLanguage.g:2106:3: kw= '+='
                    {
                    kw=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getPlusSignEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBeeLangTestLanguage.g:2112:3: kw= '-='
                    {
                    kw=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getHyphenMinusEqualsSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalBeeLangTestLanguage.g:2118:3: kw= '*='
                    {
                    kw=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getAsteriskEqualsSignKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalBeeLangTestLanguage.g:2124:3: kw= '/='
                    {
                    kw=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getSolidusEqualsSignKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalBeeLangTestLanguage.g:2130:3: kw= '%='
                    {
                    kw=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getPercentSignEqualsSignKeyword_5());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 28, ruleAssignmentOperator_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentOperator"


    // $ANTLR start "entryRuleRelationalOperator"
    // InternalBeeLangTestLanguage.g:2139:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;
        int entryRuleRelationalOperator_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return current; }
            // InternalBeeLangTestLanguage.g:2139:58: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // InternalBeeLangTestLanguage.g:2140:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRelationalOperator=ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, entryRuleRelationalOperator_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalOperator"


    // $ANTLR start "ruleRelationalOperator"
    // InternalBeeLangTestLanguage.g:2146:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleRelationalOperator_StartIndex = input.index();
        Token kw=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return current; }
            // InternalBeeLangTestLanguage.g:2152:2: ( (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // InternalBeeLangTestLanguage.g:2153:2: (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // InternalBeeLangTestLanguage.g:2153:2: (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
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
                    // InternalBeeLangTestLanguage.g:2154:3: kw= '~='
                    {
                    kw=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getTildeEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBeeLangTestLanguage.g:2160:3: kw= '=='
                    {
                    kw=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getEqualsSignEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBeeLangTestLanguage.g:2166:3: kw= '==='
                    {
                    kw=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getEqualsSignEqualsSignEqualsSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalBeeLangTestLanguage.g:2172:3: kw= '!='
                    {
                    kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getExclamationMarkEqualsSignKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalBeeLangTestLanguage.g:2178:3: kw= '!=='
                    {
                    kw=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getExclamationMarkEqualsSignEqualsSignKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalBeeLangTestLanguage.g:2184:3: kw= '>='
                    {
                    kw=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalBeeLangTestLanguage.g:2190:3: kw= '<='
                    {
                    kw=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignEqualsSignKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalBeeLangTestLanguage.g:2196:3: kw= '>'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalBeeLangTestLanguage.g:2202:3: kw= '<'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_8());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 30, ruleRelationalOperator_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleRelationalOperator"


    // $ANTLR start "entryRuleTopLevelExpression"
    // InternalBeeLangTestLanguage.g:2211:1: entryRuleTopLevelExpression returns [EObject current=null] : iv_ruleTopLevelExpression= ruleTopLevelExpression EOF ;
    public final EObject entryRuleTopLevelExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleTopLevelExpression_StartIndex = input.index();
        EObject iv_ruleTopLevelExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return current; }
            // InternalBeeLangTestLanguage.g:2211:59: (iv_ruleTopLevelExpression= ruleTopLevelExpression EOF )
            // InternalBeeLangTestLanguage.g:2212:2: iv_ruleTopLevelExpression= ruleTopLevelExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTopLevelExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 31, entryRuleTopLevelExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTopLevelExpression"


    // $ANTLR start "ruleTopLevelExpression"
    // InternalBeeLangTestLanguage.g:2218:1: ruleTopLevelExpression returns [EObject current=null] : (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression ) ;
    public final EObject ruleTopLevelExpression() throws RecognitionException {
        EObject current = null;
        int ruleTopLevelExpression_StartIndex = input.index();
        EObject this_VarDeclaration_0 = null;

        EObject this_ValDeclaration_1 = null;

        EObject this_AssignmentExpression_2 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return current; }
            // InternalBeeLangTestLanguage.g:2224:2: ( (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression ) )
            // InternalBeeLangTestLanguage.g:2225:2: (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression )
            {
            // InternalBeeLangTestLanguage.g:2225:2: (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression )
            int alt42=3;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:2226:3: this_VarDeclaration_0= ruleVarDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTopLevelExpressionAccess().getVarDeclarationParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_VarDeclaration_0=ruleVarDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VarDeclaration_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBeeLangTestLanguage.g:2238:3: this_ValDeclaration_1= ruleValDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTopLevelExpressionAccess().getValDeclarationParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ValDeclaration_1=ruleValDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ValDeclaration_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBeeLangTestLanguage.g:2250:3: this_AssignmentExpression_2= ruleAssignmentExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTopLevelExpressionAccess().getAssignmentExpressionParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AssignmentExpression_2=ruleAssignmentExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AssignmentExpression_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 32, ruleTopLevelExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTopLevelExpression"


    // $ANTLR start "entryRuleExpression"
    // InternalBeeLangTestLanguage.g:2265:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleExpression_StartIndex = input.index();
        EObject iv_ruleExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return current; }
            // InternalBeeLangTestLanguage.g:2265:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalBeeLangTestLanguage.g:2266:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 33, entryRuleExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalBeeLangTestLanguage.g:2272:1: ruleExpression returns [EObject current=null] : this_AssignmentExpression_0= ruleAssignmentExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;
        int ruleExpression_StartIndex = input.index();
        EObject this_AssignmentExpression_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return current; }
            // InternalBeeLangTestLanguage.g:2278:2: (this_AssignmentExpression_0= ruleAssignmentExpression )
            // InternalBeeLangTestLanguage.g:2279:2: this_AssignmentExpression_0= ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getExpressionAccess().getAssignmentExpressionParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_AssignmentExpression_0=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_AssignmentExpression_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 34, ruleExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAssignmentExpression"
    // InternalBeeLangTestLanguage.g:2293:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleAssignmentExpression_StartIndex = input.index();
        EObject iv_ruleAssignmentExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return current; }
            // InternalBeeLangTestLanguage.g:2293:61: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // InternalBeeLangTestLanguage.g:2294:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 35, entryRuleAssignmentExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentExpression"


    // $ANTLR start "ruleAssignmentExpression"
    // InternalBeeLangTestLanguage.g:2300:1: ruleAssignmentExpression returns [EObject current=null] : (this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;
        int ruleAssignmentExpression_StartIndex = input.index();
        EObject this_CachedExpression_0 = null;

        AntlrDatatypeRuleToken lv_functionName_2_0 = null;

        EObject lv_rightExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return current; }
            // InternalBeeLangTestLanguage.g:2306:2: ( (this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? ) )
            // InternalBeeLangTestLanguage.g:2307:2: (this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? )
            {
            // InternalBeeLangTestLanguage.g:2307:2: (this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? )
            // InternalBeeLangTestLanguage.g:2308:3: this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getCachedExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_40);
            this_CachedExpression_0=ruleCachedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CachedExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBeeLangTestLanguage.g:2319:3: ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )?
            int alt43=2;
            switch ( input.LA(1) ) {
                case 38:
                    {
                    int LA43_1 = input.LA(2);

                    if ( (synpred71_InternalBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 39:
                    {
                    int LA43_2 = input.LA(2);

                    if ( (synpred71_InternalBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 40:
                    {
                    int LA43_3 = input.LA(2);

                    if ( (synpred71_InternalBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 41:
                    {
                    int LA43_4 = input.LA(2);

                    if ( (synpred71_InternalBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 42:
                    {
                    int LA43_5 = input.LA(2);

                    if ( (synpred71_InternalBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 43:
                    {
                    int LA43_6 = input.LA(2);

                    if ( (synpred71_InternalBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
            }

            switch (alt43) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:2320:4: () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
                    {
                    // InternalBeeLangTestLanguage.g:2320:4: ()
                    // InternalBeeLangTestLanguage.g:2321:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionLeftExprAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalBeeLangTestLanguage.g:2330:4: ( (lv_functionName_2_0= ruleAssignmentOperator ) )
                    // InternalBeeLangTestLanguage.g:2331:5: (lv_functionName_2_0= ruleAssignmentOperator )
                    {
                    // InternalBeeLangTestLanguage.g:2331:5: (lv_functionName_2_0= ruleAssignmentOperator )
                    // InternalBeeLangTestLanguage.g:2332:6: lv_functionName_2_0= ruleAssignmentOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getFunctionNameAssignmentOperatorParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_19);
                    lv_functionName_2_0=ruleAssignmentOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						set(
                      							current,
                      							"functionName",
                      							lv_functionName_2_0,
                      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.AssignmentOperator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalBeeLangTestLanguage.g:2349:4: ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
                    // InternalBeeLangTestLanguage.g:2350:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
                    {
                    // InternalBeeLangTestLanguage.g:2350:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
                    // InternalBeeLangTestLanguage.g:2351:6: lv_rightExpr_3_0= ruleAssignmentExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRightExprAssignmentExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_rightExpr_3_0=ruleAssignmentExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						set(
                      							current,
                      							"rightExpr",
                      							lv_rightExpr_3_0,
                      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.AssignmentExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 36, ruleAssignmentExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentExpression"


    // $ANTLR start "entryRuleVarDeclaration"
    // InternalBeeLangTestLanguage.g:2373:1: entryRuleVarDeclaration returns [EObject current=null] : iv_ruleVarDeclaration= ruleVarDeclaration EOF ;
    public final EObject entryRuleVarDeclaration() throws RecognitionException {
        EObject current = null;
        int entryRuleVarDeclaration_StartIndex = input.index();
        EObject iv_ruleVarDeclaration = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return current; }
            // InternalBeeLangTestLanguage.g:2373:55: (iv_ruleVarDeclaration= ruleVarDeclaration EOF )
            // InternalBeeLangTestLanguage.g:2374:2: iv_ruleVarDeclaration= ruleVarDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarDeclarationRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 37, entryRuleVarDeclaration_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleVarDeclaration"


    // $ANTLR start "ruleVarDeclaration"
    // InternalBeeLangTestLanguage.g:2380:1: ruleVarDeclaration returns [EObject current=null] : ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVarDeclaration() throws RecognitionException {
        EObject current = null;
        int ruleVarDeclaration_StartIndex = input.index();
        Token lv_final_1_0=null;
        Token otherlv_2=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        EObject lv_type_3_0 = null;

        EObject lv_valueExpr_6_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return current; }
            // InternalBeeLangTestLanguage.g:2386:2: ( ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? ) )
            // InternalBeeLangTestLanguage.g:2387:2: ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? )
            {
            // InternalBeeLangTestLanguage.g:2387:2: ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? )
            // InternalBeeLangTestLanguage.g:2388:3: () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )?
            {
            // InternalBeeLangTestLanguage.g:2388:3: ()
            // InternalBeeLangTestLanguage.g:2389:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVarDeclarationAccess().getDefValueAction_0(),
              					current);
              			
            }

            }

            // InternalBeeLangTestLanguage.g:2398:3: ( (lv_final_1_0= 'final' ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==33) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:2399:4: (lv_final_1_0= 'final' )
                    {
                    // InternalBeeLangTestLanguage.g:2399:4: (lv_final_1_0= 'final' )
                    // InternalBeeLangTestLanguage.g:2400:5: lv_final_1_0= 'final'
                    {
                    lv_final_1_0=(Token)match(input,33,FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_final_1_0, grammarAccess.getVarDeclarationAccess().getFinalFinalKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getVarDeclarationRule());
                      					}
                      					setWithLastConsumed(current, "final", true, "final");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalBeeLangTestLanguage.g:2412:3: ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) )
            // InternalBeeLangTestLanguage.g:2413:4: (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) )
            {
            // InternalBeeLangTestLanguage.g:2413:4: (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) )
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
                    // InternalBeeLangTestLanguage.g:2414:5: otherlv_2= 'var'
                    {
                    otherlv_2=(Token)match(input,53,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getVarDeclarationAccess().getVarKeyword_2_0_0());
                      				
                    }

                    }
                    break;
                case 2 :
                    // InternalBeeLangTestLanguage.g:2419:5: ( (lv_type_3_0= ruleTypeRef ) )
                    {
                    // InternalBeeLangTestLanguage.g:2419:5: ( (lv_type_3_0= ruleTypeRef ) )
                    // InternalBeeLangTestLanguage.g:2420:6: (lv_type_3_0= ruleTypeRef )
                    {
                    // InternalBeeLangTestLanguage.g:2420:6: (lv_type_3_0= ruleTypeRef )
                    // InternalBeeLangTestLanguage.g:2421:7: lv_type_3_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getVarDeclarationAccess().getTypeTypeRefParserRuleCall_2_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_8);
                    lv_type_3_0=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getVarDeclarationRule());
                      							}
                      							set(
                      								current,
                      								"type",
                      								lv_type_3_0,
                      								"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.TypeRef");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalBeeLangTestLanguage.g:2439:4: ( (lv_name_4_0= RULE_ID ) )
            // InternalBeeLangTestLanguage.g:2440:5: (lv_name_4_0= RULE_ID )
            {
            // InternalBeeLangTestLanguage.g:2440:5: (lv_name_4_0= RULE_ID )
            // InternalBeeLangTestLanguage.g:2441:6: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						newLeafNode(lv_name_4_0, grammarAccess.getVarDeclarationAccess().getNameIDTerminalRuleCall_2_1_0());
              					
            }
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElement(grammarAccess.getVarDeclarationRule());
              						}
              						setWithLastConsumed(
              							current,
              							"name",
              							lv_name_4_0,
              							"org.eclipse.xtext.common.Terminals.ID");
              					
            }

            }


            }


            }

            // InternalBeeLangTestLanguage.g:2458:3: (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==38) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:2459:4: otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) )
                    {
                    otherlv_5=(Token)match(input,38,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getVarDeclarationAccess().getEqualsSignKeyword_3_0());
                      			
                    }
                    // InternalBeeLangTestLanguage.g:2463:4: ( (lv_valueExpr_6_0= ruleExpression ) )
                    // InternalBeeLangTestLanguage.g:2464:5: (lv_valueExpr_6_0= ruleExpression )
                    {
                    // InternalBeeLangTestLanguage.g:2464:5: (lv_valueExpr_6_0= ruleExpression )
                    // InternalBeeLangTestLanguage.g:2465:6: lv_valueExpr_6_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getVarDeclarationAccess().getValueExprExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_valueExpr_6_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getVarDeclarationRule());
                      						}
                      						set(
                      							current,
                      							"valueExpr",
                      							lv_valueExpr_6_0,
                      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 38, ruleVarDeclaration_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleVarDeclaration"


    // $ANTLR start "entryRuleValDeclaration"
    // InternalBeeLangTestLanguage.g:2487:1: entryRuleValDeclaration returns [EObject current=null] : iv_ruleValDeclaration= ruleValDeclaration EOF ;
    public final EObject entryRuleValDeclaration() throws RecognitionException {
        EObject current = null;
        int entryRuleValDeclaration_StartIndex = input.index();
        EObject iv_ruleValDeclaration = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return current; }
            // InternalBeeLangTestLanguage.g:2487:55: (iv_ruleValDeclaration= ruleValDeclaration EOF )
            // InternalBeeLangTestLanguage.g:2488:2: iv_ruleValDeclaration= ruleValDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValDeclarationRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 39, entryRuleValDeclaration_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleValDeclaration"


    // $ANTLR start "ruleValDeclaration"
    // InternalBeeLangTestLanguage.g:2494:1: ruleValDeclaration returns [EObject current=null] : ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) ) ;
    public final EObject ruleValDeclaration() throws RecognitionException {
        EObject current = null;
        int ruleValDeclaration_StartIndex = input.index();
        Token lv_final_1_0=null;
        Token lv_immutable_2_0=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        EObject lv_type_3_0 = null;

        EObject lv_valueExpr_6_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return current; }
            // InternalBeeLangTestLanguage.g:2500:2: ( ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) ) )
            // InternalBeeLangTestLanguage.g:2501:2: ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )
            {
            // InternalBeeLangTestLanguage.g:2501:2: ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )
            // InternalBeeLangTestLanguage.g:2502:3: () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) )
            {
            // InternalBeeLangTestLanguage.g:2502:3: ()
            // InternalBeeLangTestLanguage.g:2503:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getValDeclarationAccess().getDefValueAction_0(),
              					current);
              			
            }

            }

            // InternalBeeLangTestLanguage.g:2512:3: ( (lv_final_1_0= 'final' ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==33) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:2513:4: (lv_final_1_0= 'final' )
                    {
                    // InternalBeeLangTestLanguage.g:2513:4: (lv_final_1_0= 'final' )
                    // InternalBeeLangTestLanguage.g:2514:5: lv_final_1_0= 'final'
                    {
                    lv_final_1_0=(Token)match(input,33,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_final_1_0, grammarAccess.getValDeclarationAccess().getFinalFinalKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getValDeclarationRule());
                      					}
                      					setWithLastConsumed(current, "final", true, "final");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalBeeLangTestLanguage.g:2526:3: ( (lv_immutable_2_0= 'val' ) )
            // InternalBeeLangTestLanguage.g:2527:4: (lv_immutable_2_0= 'val' )
            {
            // InternalBeeLangTestLanguage.g:2527:4: (lv_immutable_2_0= 'val' )
            // InternalBeeLangTestLanguage.g:2528:5: lv_immutable_2_0= 'val'
            {
            lv_immutable_2_0=(Token)match(input,54,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_immutable_2_0, grammarAccess.getValDeclarationAccess().getImmutableValKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getValDeclarationRule());
              					}
              					setWithLastConsumed(current, "immutable", true, "val");
              				
            }

            }


            }

            // InternalBeeLangTestLanguage.g:2540:3: ( (lv_type_3_0= ruleTypeRef ) )?
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
                    // InternalBeeLangTestLanguage.g:2541:4: (lv_type_3_0= ruleTypeRef )
                    {
                    // InternalBeeLangTestLanguage.g:2541:4: (lv_type_3_0= ruleTypeRef )
                    // InternalBeeLangTestLanguage.g:2542:5: lv_type_3_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getValDeclarationAccess().getTypeTypeRefParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_8);
                    lv_type_3_0=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getValDeclarationRule());
                      					}
                      					set(
                      						current,
                      						"type",
                      						lv_type_3_0,
                      						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.TypeRef");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalBeeLangTestLanguage.g:2559:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalBeeLangTestLanguage.g:2560:4: (lv_name_4_0= RULE_ID )
            {
            // InternalBeeLangTestLanguage.g:2560:4: (lv_name_4_0= RULE_ID )
            // InternalBeeLangTestLanguage.g:2561:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_4_0, grammarAccess.getValDeclarationAccess().getNameIDTerminalRuleCall_4_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getValDeclarationRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_4_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_5=(Token)match(input,38,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getValDeclarationAccess().getEqualsSignKeyword_5());
              		
            }
            // InternalBeeLangTestLanguage.g:2581:3: ( (lv_valueExpr_6_0= ruleExpression ) )
            // InternalBeeLangTestLanguage.g:2582:4: (lv_valueExpr_6_0= ruleExpression )
            {
            // InternalBeeLangTestLanguage.g:2582:4: (lv_valueExpr_6_0= ruleExpression )
            // InternalBeeLangTestLanguage.g:2583:5: lv_valueExpr_6_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getValDeclarationAccess().getValueExprExpressionParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_valueExpr_6_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getValDeclarationRule());
              					}
              					set(
              						current,
              						"valueExpr",
              						lv_valueExpr_6_0,
              						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 40, ruleValDeclaration_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleValDeclaration"


    // $ANTLR start "entryRuleTypeRef"
    // InternalBeeLangTestLanguage.g:2604:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;
        int entryRuleTypeRef_StartIndex = input.index();
        EObject iv_ruleTypeRef = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return current; }
            // InternalBeeLangTestLanguage.g:2604:48: (iv_ruleTypeRef= ruleTypeRef EOF )
            // InternalBeeLangTestLanguage.g:2605:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRefRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 41, entryRuleTypeRef_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // InternalBeeLangTestLanguage.g:2611:1: ruleTypeRef returns [EObject current=null] : (this_ClosureTypeRef_0= ruleClosureTypeRef | this_SimpleTypeRef_1= ruleSimpleTypeRef ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;
        int ruleTypeRef_StartIndex = input.index();
        EObject this_ClosureTypeRef_0 = null;

        EObject this_SimpleTypeRef_1 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return current; }
            // InternalBeeLangTestLanguage.g:2617:2: ( (this_ClosureTypeRef_0= ruleClosureTypeRef | this_SimpleTypeRef_1= ruleSimpleTypeRef ) )
            // InternalBeeLangTestLanguage.g:2618:2: (this_ClosureTypeRef_0= ruleClosureTypeRef | this_SimpleTypeRef_1= ruleSimpleTypeRef )
            {
            // InternalBeeLangTestLanguage.g:2618:2: (this_ClosureTypeRef_0= ruleClosureTypeRef | this_SimpleTypeRef_1= ruleSimpleTypeRef )
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
                    // InternalBeeLangTestLanguage.g:2619:3: this_ClosureTypeRef_0= ruleClosureTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRefAccess().getClosureTypeRefParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ClosureTypeRef_0=ruleClosureTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ClosureTypeRef_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBeeLangTestLanguage.g:2631:3: this_SimpleTypeRef_1= ruleSimpleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRefAccess().getSimpleTypeRefParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SimpleTypeRef_1=ruleSimpleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SimpleTypeRef_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 42, ruleTypeRef_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleSimpleTypeRef"
    // InternalBeeLangTestLanguage.g:2646:1: entryRuleSimpleTypeRef returns [EObject current=null] : iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF ;
    public final EObject entryRuleSimpleTypeRef() throws RecognitionException {
        EObject current = null;
        int entryRuleSimpleTypeRef_StartIndex = input.index();
        EObject iv_ruleSimpleTypeRef = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return current; }
            // InternalBeeLangTestLanguage.g:2646:54: (iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF )
            // InternalBeeLangTestLanguage.g:2647:2: iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpleTypeRefRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 43, entryRuleSimpleTypeRef_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleTypeRef"


    // $ANTLR start "ruleSimpleTypeRef"
    // InternalBeeLangTestLanguage.g:2653:1: ruleSimpleTypeRef returns [EObject current=null] : ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleSimpleTypeRef() throws RecognitionException {
        EObject current = null;
        int ruleSimpleTypeRef_StartIndex = input.index();
        Token lv_rawType_0_0=null;
        Token otherlv_1=null;
        Token lv_actualArgumentsList_2_0=null;
        Token otherlv_3=null;
        Token lv_actualArgumentsList_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return current; }
            // InternalBeeLangTestLanguage.g:2659:2: ( ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? ) )
            // InternalBeeLangTestLanguage.g:2660:2: ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? )
            {
            // InternalBeeLangTestLanguage.g:2660:2: ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? )
            // InternalBeeLangTestLanguage.g:2661:3: ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )?
            {
            // InternalBeeLangTestLanguage.g:2661:3: ( (lv_rawType_0_0= RULE_ID ) )
            // InternalBeeLangTestLanguage.g:2662:4: (lv_rawType_0_0= RULE_ID )
            {
            // InternalBeeLangTestLanguage.g:2662:4: (lv_rawType_0_0= RULE_ID )
            // InternalBeeLangTestLanguage.g:2663:5: lv_rawType_0_0= RULE_ID
            {
            lv_rawType_0_0=(Token)match(input,RULE_ID,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_rawType_0_0, grammarAccess.getSimpleTypeRefAccess().getRawTypeIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSimpleTypeRefRule());
              					}
              					setWithLastConsumed(
              						current,
              						"rawType",
              						lv_rawType_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalBeeLangTestLanguage.g:2679:3: (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==52) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:2680:4: otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>'
                    {
                    otherlv_1=(Token)match(input,52,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getSimpleTypeRefAccess().getLessThanSignKeyword_1_0());
                      			
                    }
                    // InternalBeeLangTestLanguage.g:2684:4: ( (lv_actualArgumentsList_2_0= RULE_ID ) )
                    // InternalBeeLangTestLanguage.g:2685:5: (lv_actualArgumentsList_2_0= RULE_ID )
                    {
                    // InternalBeeLangTestLanguage.g:2685:5: (lv_actualArgumentsList_2_0= RULE_ID )
                    // InternalBeeLangTestLanguage.g:2686:6: lv_actualArgumentsList_2_0= RULE_ID
                    {
                    lv_actualArgumentsList_2_0=(Token)match(input,RULE_ID,FOLLOW_46); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_actualArgumentsList_2_0, grammarAccess.getSimpleTypeRefAccess().getActualArgumentsListIDTerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getSimpleTypeRefRule());
                      						}
                      						addWithLastConsumed(
                      							current,
                      							"actualArgumentsList",
                      							lv_actualArgumentsList_2_0,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }

                    // InternalBeeLangTestLanguage.g:2702:4: (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==16) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // InternalBeeLangTestLanguage.g:2703:5: otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) )
                    	    {
                    	    otherlv_3=(Token)match(input,16,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getSimpleTypeRefAccess().getCommaKeyword_1_2_0());
                    	      				
                    	    }
                    	    // InternalBeeLangTestLanguage.g:2707:5: ( (lv_actualArgumentsList_4_0= RULE_ID ) )
                    	    // InternalBeeLangTestLanguage.g:2708:6: (lv_actualArgumentsList_4_0= RULE_ID )
                    	    {
                    	    // InternalBeeLangTestLanguage.g:2708:6: (lv_actualArgumentsList_4_0= RULE_ID )
                    	    // InternalBeeLangTestLanguage.g:2709:7: lv_actualArgumentsList_4_0= RULE_ID
                    	    {
                    	    lv_actualArgumentsList_4_0=(Token)match(input,RULE_ID,FOLLOW_46); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(lv_actualArgumentsList_4_0, grammarAccess.getSimpleTypeRefAccess().getActualArgumentsListIDTerminalRuleCall_1_2_1_0());
                    	      						
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getSimpleTypeRefRule());
                    	      							}
                    	      							addWithLastConsumed(
                    	      								current,
                    	      								"actualArgumentsList",
                    	      								lv_actualArgumentsList_4_0,
                    	      								"org.eclipse.xtext.common.Terminals.ID");
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop50;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getSimpleTypeRefAccess().getGreaterThanSignKeyword_1_3());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 44, ruleSimpleTypeRef_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleSimpleTypeRef"


    // $ANTLR start "entryRuleClosureTypeRef"
    // InternalBeeLangTestLanguage.g:2735:1: entryRuleClosureTypeRef returns [EObject current=null] : iv_ruleClosureTypeRef= ruleClosureTypeRef EOF ;
    public final EObject entryRuleClosureTypeRef() throws RecognitionException {
        EObject current = null;
        int entryRuleClosureTypeRef_StartIndex = input.index();
        EObject iv_ruleClosureTypeRef = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return current; }
            // InternalBeeLangTestLanguage.g:2735:55: (iv_ruleClosureTypeRef= ruleClosureTypeRef EOF )
            // InternalBeeLangTestLanguage.g:2736:2: iv_ruleClosureTypeRef= ruleClosureTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClosureTypeRefRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 45, entryRuleClosureTypeRef_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleClosureTypeRef"


    // $ANTLR start "ruleClosureTypeRef"
    // InternalBeeLangTestLanguage.g:2742:1: ruleClosureTypeRef returns [EObject current=null] : (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) ) ;
    public final EObject ruleClosureTypeRef() throws RecognitionException {
        EObject current = null;
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


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return current; }
            // InternalBeeLangTestLanguage.g:2748:2: ( (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) ) )
            // InternalBeeLangTestLanguage.g:2749:2: (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) )
            {
            // InternalBeeLangTestLanguage.g:2749:2: (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) )
            // InternalBeeLangTestLanguage.g:2750:3: otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getClosureTypeRefAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalBeeLangTestLanguage.g:2754:3: ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )?
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
                    // InternalBeeLangTestLanguage.g:2755:4: ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? )
                    {
                    // InternalBeeLangTestLanguage.g:2755:4: ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? )
                    // InternalBeeLangTestLanguage.g:2756:5: ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )?
                    {
                    // InternalBeeLangTestLanguage.g:2756:5: ( (lv_parameterTypes_1_0= RULE_ID ) )
                    // InternalBeeLangTestLanguage.g:2757:6: (lv_parameterTypes_1_0= RULE_ID )
                    {
                    // InternalBeeLangTestLanguage.g:2757:6: (lv_parameterTypes_1_0= RULE_ID )
                    // InternalBeeLangTestLanguage.g:2758:7: lv_parameterTypes_1_0= RULE_ID
                    {
                    lv_parameterTypes_1_0=(Token)match(input,RULE_ID,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_parameterTypes_1_0, grammarAccess.getClosureTypeRefAccess().getParameterTypesIDTerminalRuleCall_1_0_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getClosureTypeRefRule());
                      							}
                      							addWithLastConsumed(
                      								current,
                      								"parameterTypes",
                      								lv_parameterTypes_1_0,
                      								"org.eclipse.xtext.common.Terminals.ID");
                      						
                    }

                    }


                    }

                    // InternalBeeLangTestLanguage.g:2774:5: (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )*
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
                    	    // InternalBeeLangTestLanguage.g:2775:6: otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,16,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_2, grammarAccess.getClosureTypeRefAccess().getCommaKeyword_1_0_1_0());
                    	      					
                    	    }
                    	    // InternalBeeLangTestLanguage.g:2779:6: ( (lv_parameterTypes_3_0= RULE_ID ) )
                    	    // InternalBeeLangTestLanguage.g:2780:7: (lv_parameterTypes_3_0= RULE_ID )
                    	    {
                    	    // InternalBeeLangTestLanguage.g:2780:7: (lv_parameterTypes_3_0= RULE_ID )
                    	    // InternalBeeLangTestLanguage.g:2781:8: lv_parameterTypes_3_0= RULE_ID
                    	    {
                    	    lv_parameterTypes_3_0=(Token)match(input,RULE_ID,FOLLOW_34); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								newLeafNode(lv_parameterTypes_3_0, grammarAccess.getClosureTypeRefAccess().getParameterTypesIDTerminalRuleCall_1_0_1_1_0());
                    	      							
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElement(grammarAccess.getClosureTypeRefRule());
                    	      								}
                    	      								addWithLastConsumed(
                    	      									current,
                    	      									"parameterTypes",
                    	      									lv_parameterTypes_3_0,
                    	      									"org.eclipse.xtext.common.Terminals.ID");
                    	      							
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);

                    // InternalBeeLangTestLanguage.g:2798:5: (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==16) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // InternalBeeLangTestLanguage.g:2799:6: otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) )
                            {
                            otherlv_4=(Token)match(input,16,FOLLOW_36); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_4, grammarAccess.getClosureTypeRefAccess().getCommaKeyword_1_0_2_0());
                              					
                            }
                            // InternalBeeLangTestLanguage.g:2803:6: ( (lv_varArgs_5_0= '...' ) )
                            // InternalBeeLangTestLanguage.g:2804:7: (lv_varArgs_5_0= '...' )
                            {
                            // InternalBeeLangTestLanguage.g:2804:7: (lv_varArgs_5_0= '...' )
                            // InternalBeeLangTestLanguage.g:2805:8: lv_varArgs_5_0= '...'
                            {
                            lv_varArgs_5_0=(Token)match(input,36,FOLLOW_8); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_varArgs_5_0, grammarAccess.getClosureTypeRefAccess().getVarArgsFullStopFullStopFullStopKeyword_1_0_2_1_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getClosureTypeRefRule());
                              								}
                              								setWithLastConsumed(current, "varArgs", true, "...");
                              							
                            }

                            }


                            }

                            // InternalBeeLangTestLanguage.g:2817:6: ( (lv_parameterTypes_6_0= RULE_ID ) )
                            // InternalBeeLangTestLanguage.g:2818:7: (lv_parameterTypes_6_0= RULE_ID )
                            {
                            // InternalBeeLangTestLanguage.g:2818:7: (lv_parameterTypes_6_0= RULE_ID )
                            // InternalBeeLangTestLanguage.g:2819:8: lv_parameterTypes_6_0= RULE_ID
                            {
                            lv_parameterTypes_6_0=(Token)match(input,RULE_ID,FOLLOW_37); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_parameterTypes_6_0, grammarAccess.getClosureTypeRefAccess().getParameterTypesIDTerminalRuleCall_1_0_2_2_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getClosureTypeRefRule());
                              								}
                              								addWithLastConsumed(
                              									current,
                              									"parameterTypes",
                              									lv_parameterTypes_6_0,
                              									"org.eclipse.xtext.common.Terminals.ID");
                              							
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
                    // InternalBeeLangTestLanguage.g:2838:4: ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) )
                    {
                    // InternalBeeLangTestLanguage.g:2838:4: ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) )
                    // InternalBeeLangTestLanguage.g:2839:5: ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) )
                    {
                    // InternalBeeLangTestLanguage.g:2839:5: ( (lv_varArgs_7_0= '...' ) )
                    // InternalBeeLangTestLanguage.g:2840:6: (lv_varArgs_7_0= '...' )
                    {
                    // InternalBeeLangTestLanguage.g:2840:6: (lv_varArgs_7_0= '...' )
                    // InternalBeeLangTestLanguage.g:2841:7: lv_varArgs_7_0= '...'
                    {
                    lv_varArgs_7_0=(Token)match(input,36,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_varArgs_7_0, grammarAccess.getClosureTypeRefAccess().getVarArgsFullStopFullStopFullStopKeyword_1_1_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getClosureTypeRefRule());
                      							}
                      							setWithLastConsumed(current, "varArgs", true, "...");
                      						
                    }

                    }


                    }

                    // InternalBeeLangTestLanguage.g:2853:5: ( (lv_parameterTypes_8_0= RULE_ID ) )
                    // InternalBeeLangTestLanguage.g:2854:6: (lv_parameterTypes_8_0= RULE_ID )
                    {
                    // InternalBeeLangTestLanguage.g:2854:6: (lv_parameterTypes_8_0= RULE_ID )
                    // InternalBeeLangTestLanguage.g:2855:7: lv_parameterTypes_8_0= RULE_ID
                    {
                    lv_parameterTypes_8_0=(Token)match(input,RULE_ID,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_parameterTypes_8_0, grammarAccess.getClosureTypeRefAccess().getParameterTypesIDTerminalRuleCall_1_1_1_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getClosureTypeRefRule());
                      							}
                      							addWithLastConsumed(
                      								current,
                      								"parameterTypes",
                      								lv_parameterTypes_8_0,
                      								"org.eclipse.xtext.common.Terminals.ID");
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,37,FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getClosureTypeRefAccess().getRightParenthesisKeyword_2());
              		
            }
            otherlv_10=(Token)match(input,55,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getClosureTypeRefAccess().getEqualsSignGreaterThanSignKeyword_3());
              		
            }
            // InternalBeeLangTestLanguage.g:2881:3: ( (lv_returnType_11_0= RULE_ID ) )
            // InternalBeeLangTestLanguage.g:2882:4: (lv_returnType_11_0= RULE_ID )
            {
            // InternalBeeLangTestLanguage.g:2882:4: (lv_returnType_11_0= RULE_ID )
            // InternalBeeLangTestLanguage.g:2883:5: lv_returnType_11_0= RULE_ID
            {
            lv_returnType_11_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_returnType_11_0, grammarAccess.getClosureTypeRefAccess().getReturnTypeIDTerminalRuleCall_4_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getClosureTypeRefRule());
              					}
              					setWithLastConsumed(
              						current,
              						"returnType",
              						lv_returnType_11_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 46, ruleClosureTypeRef_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleClosureTypeRef"


    // $ANTLR start "entryRuleCachedExpression"
    // InternalBeeLangTestLanguage.g:2903:1: entryRuleCachedExpression returns [EObject current=null] : iv_ruleCachedExpression= ruleCachedExpression EOF ;
    public final EObject entryRuleCachedExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleCachedExpression_StartIndex = input.index();
        EObject iv_ruleCachedExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return current; }
            // InternalBeeLangTestLanguage.g:2903:57: (iv_ruleCachedExpression= ruleCachedExpression EOF )
            // InternalBeeLangTestLanguage.g:2904:2: iv_ruleCachedExpression= ruleCachedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCachedExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 47, entryRuleCachedExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleCachedExpression"


    // $ANTLR start "ruleCachedExpression"
    // InternalBeeLangTestLanguage.g:2910:1: ruleCachedExpression returns [EObject current=null] : ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | this_OrExpression_3= ruleOrExpression ) ;
    public final EObject ruleCachedExpression() throws RecognitionException {
        EObject current = null;
        int ruleCachedExpression_StartIndex = input.index();
        Token otherlv_1=null;
        EObject lv_expr_2_0 = null;

        EObject this_OrExpression_3 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return current; }
            // InternalBeeLangTestLanguage.g:2916:2: ( ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | this_OrExpression_3= ruleOrExpression ) )
            // InternalBeeLangTestLanguage.g:2917:2: ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | this_OrExpression_3= ruleOrExpression )
            {
            // InternalBeeLangTestLanguage.g:2917:2: ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | this_OrExpression_3= ruleOrExpression )
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
                    // InternalBeeLangTestLanguage.g:2918:3: ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) )
                    {
                    // InternalBeeLangTestLanguage.g:2918:3: ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) )
                    // InternalBeeLangTestLanguage.g:2919:4: () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) )
                    {
                    // InternalBeeLangTestLanguage.g:2919:4: ()
                    // InternalBeeLangTestLanguage.g:2920:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getCachedExpressionAccess().getCachedExpressionAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,56,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCachedExpressionAccess().getCachedKeyword_0_1());
                      			
                    }
                    // InternalBeeLangTestLanguage.g:2933:4: ( (lv_expr_2_0= ruleOrExpression ) )
                    // InternalBeeLangTestLanguage.g:2934:5: (lv_expr_2_0= ruleOrExpression )
                    {
                    // InternalBeeLangTestLanguage.g:2934:5: (lv_expr_2_0= ruleOrExpression )
                    // InternalBeeLangTestLanguage.g:2935:6: lv_expr_2_0= ruleOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCachedExpressionAccess().getExprOrExpressionParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expr_2_0=ruleOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCachedExpressionRule());
                      						}
                      						set(
                      							current,
                      							"expr",
                      							lv_expr_2_0,
                      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.OrExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBeeLangTestLanguage.g:2954:3: this_OrExpression_3= ruleOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCachedExpressionAccess().getOrExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_OrExpression_3=ruleOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_OrExpression_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 48, ruleCachedExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleCachedExpression"


    // $ANTLR start "entryRuleOrExpression"
    // InternalBeeLangTestLanguage.g:2969:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleOrExpression_StartIndex = input.index();
        EObject iv_ruleOrExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return current; }
            // InternalBeeLangTestLanguage.g:2969:53: (iv_ruleOrExpression= ruleOrExpression EOF )
            // InternalBeeLangTestLanguage.g:2970:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 49, entryRuleOrExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // InternalBeeLangTestLanguage.g:2976:1: ruleOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;
        int ruleOrExpression_StartIndex = input.index();
        Token otherlv_2=null;
        EObject this_AndExpression_0 = null;

        EObject lv_rightExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return current; }
            // InternalBeeLangTestLanguage.g:2982:2: ( (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* ) )
            // InternalBeeLangTestLanguage.g:2983:2: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* )
            {
            // InternalBeeLangTestLanguage.g:2983:2: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* )
            // InternalBeeLangTestLanguage.g:2984:3: this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_49);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBeeLangTestLanguage.g:2995:3: ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==57) ) {
                    int LA56_2 = input.LA(2);

                    if ( (synpred85_InternalBeeLangTestLanguage()) ) {
                        alt56=1;
                    }


                }


                switch (alt56) {
            	case 1 :
            	    // InternalBeeLangTestLanguage.g:2996:4: () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:2996:4: ()
            	    // InternalBeeLangTestLanguage.g:2997:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getOrExpressionAccess().getOrExpressionLeftExprAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,57,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_1());
            	      			
            	    }
            	    // InternalBeeLangTestLanguage.g:3010:4: ( (lv_rightExpr_3_0= ruleAndExpression ) )
            	    // InternalBeeLangTestLanguage.g:3011:5: (lv_rightExpr_3_0= ruleAndExpression )
            	    {
            	    // InternalBeeLangTestLanguage.g:3011:5: (lv_rightExpr_3_0= ruleAndExpression )
            	    // InternalBeeLangTestLanguage.g:3012:6: lv_rightExpr_3_0= ruleAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrExpressionAccess().getRightExprAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_49);
            	    lv_rightExpr_3_0=ruleAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightExpr",
            	      							lv_rightExpr_3_0,
            	      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.AndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 50, ruleOrExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleAndExpression"
    // InternalBeeLangTestLanguage.g:3034:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleAndExpression_StartIndex = input.index();
        EObject iv_ruleAndExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return current; }
            // InternalBeeLangTestLanguage.g:3034:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalBeeLangTestLanguage.g:3035:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 51, entryRuleAndExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalBeeLangTestLanguage.g:3041:1: ruleAndExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;
        int ruleAndExpression_StartIndex = input.index();
        Token otherlv_2=null;
        EObject this_RelationalExpression_0 = null;

        EObject lv_rightExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return current; }
            // InternalBeeLangTestLanguage.g:3047:2: ( (this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* ) )
            // InternalBeeLangTestLanguage.g:3048:2: (this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* )
            {
            // InternalBeeLangTestLanguage.g:3048:2: (this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* )
            // InternalBeeLangTestLanguage.g:3049:3: this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndExpressionAccess().getRelationalExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_50);
            this_RelationalExpression_0=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RelationalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBeeLangTestLanguage.g:3060:3: ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==58) ) {
                    int LA57_2 = input.LA(2);

                    if ( (synpred86_InternalBeeLangTestLanguage()) ) {
                        alt57=1;
                    }


                }


                switch (alt57) {
            	case 1 :
            	    // InternalBeeLangTestLanguage.g:3061:4: () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:3061:4: ()
            	    // InternalBeeLangTestLanguage.g:3062:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAndExpressionAccess().getAndExpressionLeftExprAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,58,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAndExpressionAccess().getAmpersandAmpersandKeyword_1_1());
            	      			
            	    }
            	    // InternalBeeLangTestLanguage.g:3075:4: ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
            	    // InternalBeeLangTestLanguage.g:3076:5: (lv_rightExpr_3_0= ruleRelationalExpression )
            	    {
            	    // InternalBeeLangTestLanguage.g:3076:5: (lv_rightExpr_3_0= ruleRelationalExpression )
            	    // InternalBeeLangTestLanguage.g:3077:6: lv_rightExpr_3_0= ruleRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndExpressionAccess().getRightExprRelationalExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_50);
            	    lv_rightExpr_3_0=ruleRelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightExpr",
            	      							lv_rightExpr_3_0,
            	      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.RelationalExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 52, ruleAndExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleRelationalExpression"
    // InternalBeeLangTestLanguage.g:3099:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleRelationalExpression_StartIndex = input.index();
        EObject iv_ruleRelationalExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return current; }
            // InternalBeeLangTestLanguage.g:3099:61: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalBeeLangTestLanguage.g:3100:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 53, entryRuleRelationalExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // InternalBeeLangTestLanguage.g:3106:1: ruleRelationalExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;
        int ruleRelationalExpression_StartIndex = input.index();
        EObject this_AdditiveExpression_0 = null;

        AntlrDatatypeRuleToken lv_functionName_2_0 = null;

        EObject lv_rightExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return current; }
            // InternalBeeLangTestLanguage.g:3112:2: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* ) )
            // InternalBeeLangTestLanguage.g:3113:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalBeeLangTestLanguage.g:3113:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* )
            // InternalBeeLangTestLanguage.g:3114:3: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_51);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AdditiveExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBeeLangTestLanguage.g:3125:3: ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )*
            loop58:
            do {
                int alt58=2;
                alt58 = dfa58.predict(input);
                switch (alt58) {
            	case 1 :
            	    // InternalBeeLangTestLanguage.g:3126:4: () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:3126:4: ()
            	    // InternalBeeLangTestLanguage.g:3127:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getRelationalExpressionAccess().getBinaryOpExpressionLeftExprAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalBeeLangTestLanguage.g:3136:4: ( (lv_functionName_2_0= ruleRelationalOperator ) )
            	    // InternalBeeLangTestLanguage.g:3137:5: (lv_functionName_2_0= ruleRelationalOperator )
            	    {
            	    // InternalBeeLangTestLanguage.g:3137:5: (lv_functionName_2_0= ruleRelationalOperator )
            	    // InternalBeeLangTestLanguage.g:3138:6: lv_functionName_2_0= ruleRelationalOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getFunctionNameRelationalOperatorParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_19);
            	    lv_functionName_2_0=ruleRelationalOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"functionName",
            	      							lv_functionName_2_0,
            	      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.RelationalOperator");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalBeeLangTestLanguage.g:3155:4: ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
            	    // InternalBeeLangTestLanguage.g:3156:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
            	    {
            	    // InternalBeeLangTestLanguage.g:3156:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
            	    // InternalBeeLangTestLanguage.g:3157:6: lv_rightExpr_3_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightExprAdditiveExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_51);
            	    lv_rightExpr_3_0=ruleAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightExpr",
            	      							lv_rightExpr_3_0,
            	      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.AdditiveExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 54, ruleRelationalExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalBeeLangTestLanguage.g:3179:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleAdditiveExpression_StartIndex = input.index();
        EObject iv_ruleAdditiveExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return current; }
            // InternalBeeLangTestLanguage.g:3179:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalBeeLangTestLanguage.g:3180:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 55, entryRuleAdditiveExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // InternalBeeLangTestLanguage.g:3186:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;
        int ruleAdditiveExpression_StartIndex = input.index();
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        EObject this_MultiplicativeExpression_0 = null;

        EObject lv_rightExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return current; }
            // InternalBeeLangTestLanguage.g:3192:2: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* ) )
            // InternalBeeLangTestLanguage.g:3193:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* )
            {
            // InternalBeeLangTestLanguage.g:3193:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* )
            // InternalBeeLangTestLanguage.g:3194:3: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_52);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MultiplicativeExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBeeLangTestLanguage.g:3205:3: ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==59) ) {
                    int LA60_2 = input.LA(2);

                    if ( (synpred89_InternalBeeLangTestLanguage()) ) {
                        alt60=1;
                    }


                }
                else if ( (LA60_0==60) ) {
                    int LA60_3 = input.LA(2);

                    if ( (synpred89_InternalBeeLangTestLanguage()) ) {
                        alt60=1;
                    }


                }


                switch (alt60) {
            	case 1 :
            	    // InternalBeeLangTestLanguage.g:3206:4: () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:3206:4: ()
            	    // InternalBeeLangTestLanguage.g:3207:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAdditiveExpressionAccess().getBinaryOpExpressionLeftExprAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalBeeLangTestLanguage.g:3216:4: ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) )
            	    // InternalBeeLangTestLanguage.g:3217:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:3217:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
            	    // InternalBeeLangTestLanguage.g:3218:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
            	    {
            	    // InternalBeeLangTestLanguage.g:3218:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
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
            	            // InternalBeeLangTestLanguage.g:3219:7: lv_functionName_2_1= '+'
            	            {
            	            lv_functionName_2_1=(Token)match(input,59,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_functionName_2_1, grammarAccess.getAdditiveExpressionAccess().getFunctionNamePlusSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAdditiveExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "functionName", lv_functionName_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalBeeLangTestLanguage.g:3230:7: lv_functionName_2_2= '-'
            	            {
            	            lv_functionName_2_2=(Token)match(input,60,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_functionName_2_2, grammarAccess.getAdditiveExpressionAccess().getFunctionNameHyphenMinusKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAdditiveExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "functionName", lv_functionName_2_2, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalBeeLangTestLanguage.g:3243:4: ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
            	    // InternalBeeLangTestLanguage.g:3244:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
            	    {
            	    // InternalBeeLangTestLanguage.g:3244:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
            	    // InternalBeeLangTestLanguage.g:3245:6: lv_rightExpr_3_0= ruleMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightExprMultiplicativeExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_52);
            	    lv_rightExpr_3_0=ruleMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightExpr",
            	      							lv_rightExpr_3_0,
            	      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.MultiplicativeExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 56, ruleAdditiveExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // InternalBeeLangTestLanguage.g:3267:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleMultiplicativeExpression_StartIndex = input.index();
        EObject iv_ruleMultiplicativeExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return current; }
            // InternalBeeLangTestLanguage.g:3267:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalBeeLangTestLanguage.g:3268:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 57, entryRuleMultiplicativeExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // InternalBeeLangTestLanguage.g:3274:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;
        int ruleMultiplicativeExpression_StartIndex = input.index();
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        Token lv_functionName_2_3=null;
        EObject this_SetExpression_0 = null;

        EObject lv_rightExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return current; }
            // InternalBeeLangTestLanguage.g:3280:2: ( (this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* ) )
            // InternalBeeLangTestLanguage.g:3281:2: (this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* )
            {
            // InternalBeeLangTestLanguage.g:3281:2: (this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* )
            // InternalBeeLangTestLanguage.g:3282:3: this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getSetExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_53);
            this_SetExpression_0=ruleSetExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_SetExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBeeLangTestLanguage.g:3293:3: ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )*
            loop62:
            do {
                int alt62=2;
                switch ( input.LA(1) ) {
                case 61:
                    {
                    int LA62_2 = input.LA(2);

                    if ( (synpred92_InternalBeeLangTestLanguage()) ) {
                        alt62=1;
                    }


                    }
                    break;
                case 32:
                    {
                    int LA62_3 = input.LA(2);

                    if ( (synpred92_InternalBeeLangTestLanguage()) ) {
                        alt62=1;
                    }


                    }
                    break;
                case 62:
                    {
                    int LA62_4 = input.LA(2);

                    if ( (synpred92_InternalBeeLangTestLanguage()) ) {
                        alt62=1;
                    }


                    }
                    break;

                }

                switch (alt62) {
            	case 1 :
            	    // InternalBeeLangTestLanguage.g:3294:4: () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:3294:4: ()
            	    // InternalBeeLangTestLanguage.g:3295:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getMultiplicativeExpressionAccess().getBinaryOpExpressionLeftExprAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalBeeLangTestLanguage.g:3304:4: ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) )
            	    // InternalBeeLangTestLanguage.g:3305:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:3305:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
            	    // InternalBeeLangTestLanguage.g:3306:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
            	    {
            	    // InternalBeeLangTestLanguage.g:3306:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
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
            	            // InternalBeeLangTestLanguage.g:3307:7: lv_functionName_2_1= '*'
            	            {
            	            lv_functionName_2_1=(Token)match(input,61,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_functionName_2_1, grammarAccess.getMultiplicativeExpressionAccess().getFunctionNameAsteriskKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "functionName", lv_functionName_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalBeeLangTestLanguage.g:3318:7: lv_functionName_2_2= '/'
            	            {
            	            lv_functionName_2_2=(Token)match(input,32,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_functionName_2_2, grammarAccess.getMultiplicativeExpressionAccess().getFunctionNameSolidusKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "functionName", lv_functionName_2_2, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // InternalBeeLangTestLanguage.g:3329:7: lv_functionName_2_3= '%'
            	            {
            	            lv_functionName_2_3=(Token)match(input,62,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_functionName_2_3, grammarAccess.getMultiplicativeExpressionAccess().getFunctionNamePercentSignKeyword_1_1_0_2());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "functionName", lv_functionName_2_3, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalBeeLangTestLanguage.g:3342:4: ( (lv_rightExpr_3_0= ruleSetExpression ) )
            	    // InternalBeeLangTestLanguage.g:3343:5: (lv_rightExpr_3_0= ruleSetExpression )
            	    {
            	    // InternalBeeLangTestLanguage.g:3343:5: (lv_rightExpr_3_0= ruleSetExpression )
            	    // InternalBeeLangTestLanguage.g:3344:6: lv_rightExpr_3_0= ruleSetExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightExprSetExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_53);
            	    lv_rightExpr_3_0=ruleSetExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightExpr",
            	      							lv_rightExpr_3_0,
            	      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.SetExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 58, ruleMultiplicativeExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleSetExpression"
    // InternalBeeLangTestLanguage.g:3366:1: entryRuleSetExpression returns [EObject current=null] : iv_ruleSetExpression= ruleSetExpression EOF ;
    public final EObject entryRuleSetExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleSetExpression_StartIndex = input.index();
        EObject iv_ruleSetExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return current; }
            // InternalBeeLangTestLanguage.g:3366:54: (iv_ruleSetExpression= ruleSetExpression EOF )
            // InternalBeeLangTestLanguage.g:3367:2: iv_ruleSetExpression= ruleSetExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSetExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 59, entryRuleSetExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleSetExpression"


    // $ANTLR start "ruleSetExpression"
    // InternalBeeLangTestLanguage.g:3373:1: ruleSetExpression returns [EObject current=null] : (this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* ) ;
    public final EObject ruleSetExpression() throws RecognitionException {
        EObject current = null;
        int ruleSetExpression_StartIndex = input.index();
        Token lv_functionName_2_0=null;
        EObject this_UnaryOrInfixExpression_0 = null;

        EObject lv_rightExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return current; }
            // InternalBeeLangTestLanguage.g:3379:2: ( (this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* ) )
            // InternalBeeLangTestLanguage.g:3380:2: (this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* )
            {
            // InternalBeeLangTestLanguage.g:3380:2: (this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* )
            // InternalBeeLangTestLanguage.g:3381:3: this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getSetExpressionAccess().getUnaryOrInfixExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_54);
            this_UnaryOrInfixExpression_0=ruleUnaryOrInfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_UnaryOrInfixExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBeeLangTestLanguage.g:3392:3: ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==63) ) {
                    int LA63_2 = input.LA(2);

                    if ( (synpred93_InternalBeeLangTestLanguage()) ) {
                        alt63=1;
                    }


                }


                switch (alt63) {
            	case 1 :
            	    // InternalBeeLangTestLanguage.g:3393:4: () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:3393:4: ()
            	    // InternalBeeLangTestLanguage.g:3394:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getSetExpressionAccess().getBinaryOpExpressionLeftExprAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalBeeLangTestLanguage.g:3403:4: ( (lv_functionName_2_0= '..' ) )
            	    // InternalBeeLangTestLanguage.g:3404:5: (lv_functionName_2_0= '..' )
            	    {
            	    // InternalBeeLangTestLanguage.g:3404:5: (lv_functionName_2_0= '..' )
            	    // InternalBeeLangTestLanguage.g:3405:6: lv_functionName_2_0= '..'
            	    {
            	    lv_functionName_2_0=(Token)match(input,63,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_functionName_2_0, grammarAccess.getSetExpressionAccess().getFunctionNameFullStopFullStopKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getSetExpressionRule());
            	      						}
            	      						setWithLastConsumed(current, "functionName", lv_functionName_2_0, "..");
            	      					
            	    }

            	    }


            	    }

            	    // InternalBeeLangTestLanguage.g:3417:4: ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
            	    // InternalBeeLangTestLanguage.g:3418:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
            	    {
            	    // InternalBeeLangTestLanguage.g:3418:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
            	    // InternalBeeLangTestLanguage.g:3419:6: lv_rightExpr_3_0= ruleUnaryOrInfixExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getSetExpressionAccess().getRightExprUnaryOrInfixExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_54);
            	    lv_rightExpr_3_0=ruleUnaryOrInfixExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getSetExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightExpr",
            	      							lv_rightExpr_3_0,
            	      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.UnaryOrInfixExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 60, ruleSetExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleSetExpression"


    // $ANTLR start "entryRuleUnaryOrInfixExpression"
    // InternalBeeLangTestLanguage.g:3441:1: entryRuleUnaryOrInfixExpression returns [EObject current=null] : iv_ruleUnaryOrInfixExpression= ruleUnaryOrInfixExpression EOF ;
    public final EObject entryRuleUnaryOrInfixExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleUnaryOrInfixExpression_StartIndex = input.index();
        EObject iv_ruleUnaryOrInfixExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return current; }
            // InternalBeeLangTestLanguage.g:3441:63: (iv_ruleUnaryOrInfixExpression= ruleUnaryOrInfixExpression EOF )
            // InternalBeeLangTestLanguage.g:3442:2: iv_ruleUnaryOrInfixExpression= ruleUnaryOrInfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOrInfixExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 61, entryRuleUnaryOrInfixExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryOrInfixExpression"


    // $ANTLR start "ruleUnaryOrInfixExpression"
    // InternalBeeLangTestLanguage.g:3448:1: ruleUnaryOrInfixExpression returns [EObject current=null] : (this_PostopExpression_0= rulePostopExpression | this_UnaryExpression_1= ruleUnaryExpression | this_PreopExpression_2= rulePreopExpression ) ;
    public final EObject ruleUnaryOrInfixExpression() throws RecognitionException {
        EObject current = null;
        int ruleUnaryOrInfixExpression_StartIndex = input.index();
        EObject this_PostopExpression_0 = null;

        EObject this_UnaryExpression_1 = null;

        EObject this_PreopExpression_2 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return current; }
            // InternalBeeLangTestLanguage.g:3454:2: ( (this_PostopExpression_0= rulePostopExpression | this_UnaryExpression_1= ruleUnaryExpression | this_PreopExpression_2= rulePreopExpression ) )
            // InternalBeeLangTestLanguage.g:3455:2: (this_PostopExpression_0= rulePostopExpression | this_UnaryExpression_1= ruleUnaryExpression | this_PreopExpression_2= rulePreopExpression )
            {
            // InternalBeeLangTestLanguage.g:3455:2: (this_PostopExpression_0= rulePostopExpression | this_UnaryExpression_1= ruleUnaryExpression | this_PreopExpression_2= rulePreopExpression )
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
                    // InternalBeeLangTestLanguage.g:3456:3: this_PostopExpression_0= rulePostopExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryOrInfixExpressionAccess().getPostopExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PostopExpression_0=rulePostopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PostopExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBeeLangTestLanguage.g:3468:3: this_UnaryExpression_1= ruleUnaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryOrInfixExpressionAccess().getUnaryExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_UnaryExpression_1=ruleUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_UnaryExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBeeLangTestLanguage.g:3480:3: this_PreopExpression_2= rulePreopExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryOrInfixExpressionAccess().getPreopExpressionParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PreopExpression_2=rulePreopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PreopExpression_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 62, ruleUnaryOrInfixExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOrInfixExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // InternalBeeLangTestLanguage.g:3495:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleUnaryExpression_StartIndex = input.index();
        EObject iv_ruleUnaryExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return current; }
            // InternalBeeLangTestLanguage.g:3495:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalBeeLangTestLanguage.g:3496:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 63, entryRuleUnaryExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // InternalBeeLangTestLanguage.g:3502:1: ruleUnaryExpression returns [EObject current=null] : ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;
        int ruleUnaryExpression_StartIndex = input.index();
        Token lv_functionName_1_1=null;
        Token lv_functionName_1_2=null;
        EObject lv_expr_2_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return current; }
            // InternalBeeLangTestLanguage.g:3508:2: ( ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) )
            // InternalBeeLangTestLanguage.g:3509:2: ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            {
            // InternalBeeLangTestLanguage.g:3509:2: ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            // InternalBeeLangTestLanguage.g:3510:3: () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) )
            {
            // InternalBeeLangTestLanguage.g:3510:3: ()
            // InternalBeeLangTestLanguage.g:3511:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getUnaryExpressionAccess().getUnaryOpExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalBeeLangTestLanguage.g:3520:3: ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) )
            // InternalBeeLangTestLanguage.g:3521:4: ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) )
            {
            // InternalBeeLangTestLanguage.g:3521:4: ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) )
            // InternalBeeLangTestLanguage.g:3522:5: (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' )
            {
            // InternalBeeLangTestLanguage.g:3522:5: (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' )
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
                    // InternalBeeLangTestLanguage.g:3523:6: lv_functionName_1_1= '!'
                    {
                    lv_functionName_1_1=(Token)match(input,64,FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_functionName_1_1, grammarAccess.getUnaryExpressionAccess().getFunctionNameExclamationMarkKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getUnaryExpressionRule());
                      						}
                      						setWithLastConsumed(current, "functionName", lv_functionName_1_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalBeeLangTestLanguage.g:3534:6: lv_functionName_1_2= '-'
                    {
                    lv_functionName_1_2=(Token)match(input,60,FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_functionName_1_2, grammarAccess.getUnaryExpressionAccess().getFunctionNameHyphenMinusKeyword_1_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getUnaryExpressionRule());
                      						}
                      						setWithLastConsumed(current, "functionName", lv_functionName_1_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalBeeLangTestLanguage.g:3547:3: ( (lv_expr_2_0= ruleInfixExpression ) )
            // InternalBeeLangTestLanguage.g:3548:4: (lv_expr_2_0= ruleInfixExpression )
            {
            // InternalBeeLangTestLanguage.g:3548:4: (lv_expr_2_0= ruleInfixExpression )
            // InternalBeeLangTestLanguage.g:3549:5: lv_expr_2_0= ruleInfixExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExprInfixExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expr_2_0=ruleInfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_2_0,
              						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.InfixExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 64, ruleUnaryExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRulePreopExpression"
    // InternalBeeLangTestLanguage.g:3570:1: entryRulePreopExpression returns [EObject current=null] : iv_rulePreopExpression= rulePreopExpression EOF ;
    public final EObject entryRulePreopExpression() throws RecognitionException {
        EObject current = null;
        int entryRulePreopExpression_StartIndex = input.index();
        EObject iv_rulePreopExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return current; }
            // InternalBeeLangTestLanguage.g:3570:56: (iv_rulePreopExpression= rulePreopExpression EOF )
            // InternalBeeLangTestLanguage.g:3571:2: iv_rulePreopExpression= rulePreopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPreopExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 65, entryRulePreopExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRulePreopExpression"


    // $ANTLR start "rulePreopExpression"
    // InternalBeeLangTestLanguage.g:3577:1: rulePreopExpression returns [EObject current=null] : ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) ;
    public final EObject rulePreopExpression() throws RecognitionException {
        EObject current = null;
        int rulePreopExpression_StartIndex = input.index();
        Token lv_functionName_1_1=null;
        Token lv_functionName_1_2=null;
        EObject lv_expr_2_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return current; }
            // InternalBeeLangTestLanguage.g:3583:2: ( ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) )
            // InternalBeeLangTestLanguage.g:3584:2: ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            {
            // InternalBeeLangTestLanguage.g:3584:2: ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            // InternalBeeLangTestLanguage.g:3585:3: () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) )
            {
            // InternalBeeLangTestLanguage.g:3585:3: ()
            // InternalBeeLangTestLanguage.g:3586:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPreopExpressionAccess().getUnaryPreOpExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalBeeLangTestLanguage.g:3595:3: ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) )
            // InternalBeeLangTestLanguage.g:3596:4: ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) )
            {
            // InternalBeeLangTestLanguage.g:3596:4: ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) )
            // InternalBeeLangTestLanguage.g:3597:5: (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' )
            {
            // InternalBeeLangTestLanguage.g:3597:5: (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' )
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
                    // InternalBeeLangTestLanguage.g:3598:6: lv_functionName_1_1= '++'
                    {
                    lv_functionName_1_1=(Token)match(input,65,FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_functionName_1_1, grammarAccess.getPreopExpressionAccess().getFunctionNamePlusSignPlusSignKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPreopExpressionRule());
                      						}
                      						setWithLastConsumed(current, "functionName", lv_functionName_1_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalBeeLangTestLanguage.g:3609:6: lv_functionName_1_2= '--'
                    {
                    lv_functionName_1_2=(Token)match(input,66,FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_functionName_1_2, grammarAccess.getPreopExpressionAccess().getFunctionNameHyphenMinusHyphenMinusKeyword_1_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPreopExpressionRule());
                      						}
                      						setWithLastConsumed(current, "functionName", lv_functionName_1_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalBeeLangTestLanguage.g:3622:3: ( (lv_expr_2_0= ruleInfixExpression ) )
            // InternalBeeLangTestLanguage.g:3623:4: (lv_expr_2_0= ruleInfixExpression )
            {
            // InternalBeeLangTestLanguage.g:3623:4: (lv_expr_2_0= ruleInfixExpression )
            // InternalBeeLangTestLanguage.g:3624:5: lv_expr_2_0= ruleInfixExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPreopExpressionAccess().getExprInfixExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expr_2_0=ruleInfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPreopExpressionRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_2_0,
              						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.InfixExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 66, rulePreopExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "rulePreopExpression"


    // $ANTLR start "entryRulePostopExpression"
    // InternalBeeLangTestLanguage.g:3645:1: entryRulePostopExpression returns [EObject current=null] : iv_rulePostopExpression= rulePostopExpression EOF ;
    public final EObject entryRulePostopExpression() throws RecognitionException {
        EObject current = null;
        int entryRulePostopExpression_StartIndex = input.index();
        EObject iv_rulePostopExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return current; }
            // InternalBeeLangTestLanguage.g:3645:57: (iv_rulePostopExpression= rulePostopExpression EOF )
            // InternalBeeLangTestLanguage.g:3646:2: iv_rulePostopExpression= rulePostopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostopExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 67, entryRulePostopExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRulePostopExpression"


    // $ANTLR start "rulePostopExpression"
    // InternalBeeLangTestLanguage.g:3652:1: rulePostopExpression returns [EObject current=null] : (this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? ) ;
    public final EObject rulePostopExpression() throws RecognitionException {
        EObject current = null;
        int rulePostopExpression_StartIndex = input.index();
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        EObject this_InfixExpression_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return current; }
            // InternalBeeLangTestLanguage.g:3658:2: ( (this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? ) )
            // InternalBeeLangTestLanguage.g:3659:2: (this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? )
            {
            // InternalBeeLangTestLanguage.g:3659:2: (this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? )
            // InternalBeeLangTestLanguage.g:3660:3: this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )?
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPostopExpressionAccess().getInfixExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_56);
            this_InfixExpression_0=ruleInfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_InfixExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBeeLangTestLanguage.g:3671:3: ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==66) ) {
                int LA68_1 = input.LA(2);

                if ( (synpred99_InternalBeeLangTestLanguage()) ) {
                    alt68=1;
                }
            }
            else if ( (LA68_0==65) ) {
                int LA68_2 = input.LA(2);

                if ( (synpred99_InternalBeeLangTestLanguage()) ) {
                    alt68=1;
                }
            }
            switch (alt68) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:3672:4: () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
                    {
                    // InternalBeeLangTestLanguage.g:3672:4: ()
                    // InternalBeeLangTestLanguage.g:3673:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getPostopExpressionAccess().getUnaryPostOpExpressionExprAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalBeeLangTestLanguage.g:3682:4: ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
                    // InternalBeeLangTestLanguage.g:3683:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
                    {
                    // InternalBeeLangTestLanguage.g:3683:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
                    // InternalBeeLangTestLanguage.g:3684:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
                    {
                    // InternalBeeLangTestLanguage.g:3684:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
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
                            // InternalBeeLangTestLanguage.g:3685:7: lv_functionName_2_1= '--'
                            {
                            lv_functionName_2_1=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_functionName_2_1, grammarAccess.getPostopExpressionAccess().getFunctionNameHyphenMinusHyphenMinusKeyword_1_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getPostopExpressionRule());
                              							}
                              							setWithLastConsumed(current, "functionName", lv_functionName_2_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalBeeLangTestLanguage.g:3696:7: lv_functionName_2_2= '++'
                            {
                            lv_functionName_2_2=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_functionName_2_2, grammarAccess.getPostopExpressionAccess().getFunctionNamePlusSignPlusSignKeyword_1_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getPostopExpressionRule());
                              							}
                              							setWithLastConsumed(current, "functionName", lv_functionName_2_2, null);
                              						
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 68, rulePostopExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "rulePostopExpression"


    // $ANTLR start "entryRuleInfixExpression"
    // InternalBeeLangTestLanguage.g:3714:1: entryRuleInfixExpression returns [EObject current=null] : iv_ruleInfixExpression= ruleInfixExpression EOF ;
    public final EObject entryRuleInfixExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleInfixExpression_StartIndex = input.index();
        EObject iv_ruleInfixExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return current; }
            // InternalBeeLangTestLanguage.g:3714:56: (iv_ruleInfixExpression= ruleInfixExpression EOF )
            // InternalBeeLangTestLanguage.g:3715:2: iv_ruleInfixExpression= ruleInfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfixExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 69, entryRuleInfixExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleInfixExpression"


    // $ANTLR start "ruleInfixExpression"
    // InternalBeeLangTestLanguage.g:3721:1: ruleInfixExpression returns [EObject current=null] : (this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* ) ;
    public final EObject ruleInfixExpression() throws RecognitionException {
        EObject current = null;
        int ruleInfixExpression_StartIndex = input.index();
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token lv_featureName_13_0=null;
        EObject this_CallExpression_0 = null;

        EObject lv_parameterList_5_0 = null;

        EObject lv_indexExpr_9_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return current; }
            // InternalBeeLangTestLanguage.g:3727:2: ( (this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* ) )
            // InternalBeeLangTestLanguage.g:3728:2: (this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* )
            {
            // InternalBeeLangTestLanguage.g:3728:2: (this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* )
            // InternalBeeLangTestLanguage.g:3729:3: this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getInfixExpressionAccess().getCallExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_57);
            this_CallExpression_0=ruleCallExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CallExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBeeLangTestLanguage.g:3740:3: ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )*
            loop70:
            do {
                int alt70=4;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==67) ) {
                    int LA70_2 = input.LA(2);

                    if ( (synpred101_InternalBeeLangTestLanguage()) ) {
                        alt70=1;
                    }
                    else if ( (synpred103_InternalBeeLangTestLanguage()) ) {
                        alt70=3;
                    }


                }
                else if ( (LA70_0==68) ) {
                    int LA70_3 = input.LA(2);

                    if ( (synpred102_InternalBeeLangTestLanguage()) ) {
                        alt70=2;
                    }


                }


                switch (alt70) {
            	case 1 :
            	    // InternalBeeLangTestLanguage.g:3741:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
            	    {
            	    // InternalBeeLangTestLanguage.g:3741:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
            	    // InternalBeeLangTestLanguage.g:3742:5: () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')'
            	    {
            	    // InternalBeeLangTestLanguage.g:3742:5: ()
            	    // InternalBeeLangTestLanguage.g:3743:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getInfixExpressionAccess().getCallFeatureFuncExprAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    otherlv_2=(Token)match(input,67,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_2, grammarAccess.getInfixExpressionAccess().getFullStopKeyword_1_0_1());
            	      				
            	    }
            	    // InternalBeeLangTestLanguage.g:3756:5: ( (lv_name_3_0= RULE_ID ) )
            	    // InternalBeeLangTestLanguage.g:3757:6: (lv_name_3_0= RULE_ID )
            	    {
            	    // InternalBeeLangTestLanguage.g:3757:6: (lv_name_3_0= RULE_ID )
            	    // InternalBeeLangTestLanguage.g:3758:7: lv_name_3_0= RULE_ID
            	    {
            	    lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_58); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							newLeafNode(lv_name_3_0, grammarAccess.getInfixExpressionAccess().getNameIDTerminalRuleCall_1_0_2_0());
            	      						
            	    }
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElement(grammarAccess.getInfixExpressionRule());
            	      							}
            	      							setWithLastConsumed(
            	      								current,
            	      								"name",
            	      								lv_name_3_0,
            	      								"org.eclipse.xtext.common.Terminals.ID");
            	      						
            	    }

            	    }


            	    }

            	    otherlv_4=(Token)match(input,35,FOLLOW_59); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_4, grammarAccess.getInfixExpressionAccess().getLeftParenthesisKeyword_1_0_3());
            	      				
            	    }
            	    // InternalBeeLangTestLanguage.g:3778:5: ( (lv_parameterList_5_0= ruleParameterList ) )?
            	    int alt69=2;
            	    int LA69_0 = input.LA(1);

            	    if ( (LA69_0==RULE_ID||LA69_0==RULE_STRING||LA69_0==13||(LA69_0>=17 && LA69_0<=18)||LA69_0==21||(LA69_0>=35 && LA69_0<=36)||LA69_0==52||LA69_0==56||LA69_0==60||(LA69_0>=64 && LA69_0<=66)||LA69_0==70||(LA69_0>=72 && LA69_0<=77)) ) {
            	        alt69=1;
            	    }
            	    switch (alt69) {
            	        case 1 :
            	            // InternalBeeLangTestLanguage.g:3779:6: (lv_parameterList_5_0= ruleParameterList )
            	            {
            	            // InternalBeeLangTestLanguage.g:3779:6: (lv_parameterList_5_0= ruleParameterList )
            	            // InternalBeeLangTestLanguage.g:3780:7: lv_parameterList_5_0= ruleParameterList
            	            {
            	            if ( state.backtracking==0 ) {

            	              							newCompositeNode(grammarAccess.getInfixExpressionAccess().getParameterListParameterListParserRuleCall_1_0_4_0());
            	              						
            	            }
            	            pushFollow(FOLLOW_37);
            	            lv_parameterList_5_0=ruleParameterList();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElementForParent(grammarAccess.getInfixExpressionRule());
            	              							}
            	              							set(
            	              								current,
            	              								"parameterList",
            	              								lv_parameterList_5_0,
            	              								"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterList");
            	              							afterParserOrEnumRuleCall();
            	              						
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    otherlv_6=(Token)match(input,37,FOLLOW_57); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_6, grammarAccess.getInfixExpressionAccess().getRightParenthesisKeyword_1_0_5());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalBeeLangTestLanguage.g:3803:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
            	    {
            	    // InternalBeeLangTestLanguage.g:3803:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
            	    // InternalBeeLangTestLanguage.g:3804:5: () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']'
            	    {
            	    // InternalBeeLangTestLanguage.g:3804:5: ()
            	    // InternalBeeLangTestLanguage.g:3805:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getInfixExpressionAccess().getAtExpressionObjExprAction_1_1_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    otherlv_8=(Token)match(input,68,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_8, grammarAccess.getInfixExpressionAccess().getLeftSquareBracketKeyword_1_1_1());
            	      				
            	    }
            	    // InternalBeeLangTestLanguage.g:3818:5: ( (lv_indexExpr_9_0= ruleExpression ) )
            	    // InternalBeeLangTestLanguage.g:3819:6: (lv_indexExpr_9_0= ruleExpression )
            	    {
            	    // InternalBeeLangTestLanguage.g:3819:6: (lv_indexExpr_9_0= ruleExpression )
            	    // InternalBeeLangTestLanguage.g:3820:7: lv_indexExpr_9_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getInfixExpressionAccess().getIndexExprExpressionParserRuleCall_1_1_2_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_60);
            	    lv_indexExpr_9_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getInfixExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"indexExpr",
            	      								lv_indexExpr_9_0,
            	      								"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }

            	    otherlv_10=(Token)match(input,69,FOLLOW_57); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_10, grammarAccess.getInfixExpressionAccess().getRightSquareBracketKeyword_1_1_3());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalBeeLangTestLanguage.g:3843:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:3843:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
            	    // InternalBeeLangTestLanguage.g:3844:5: () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) )
            	    {
            	    // InternalBeeLangTestLanguage.g:3844:5: ()
            	    // InternalBeeLangTestLanguage.g:3845:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getInfixExpressionAccess().getFeatureExpressionObjExprAction_1_2_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    otherlv_12=(Token)match(input,67,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_12, grammarAccess.getInfixExpressionAccess().getFullStopKeyword_1_2_1());
            	      				
            	    }
            	    // InternalBeeLangTestLanguage.g:3858:5: ( (lv_featureName_13_0= RULE_ID ) )
            	    // InternalBeeLangTestLanguage.g:3859:6: (lv_featureName_13_0= RULE_ID )
            	    {
            	    // InternalBeeLangTestLanguage.g:3859:6: (lv_featureName_13_0= RULE_ID )
            	    // InternalBeeLangTestLanguage.g:3860:7: lv_featureName_13_0= RULE_ID
            	    {
            	    lv_featureName_13_0=(Token)match(input,RULE_ID,FOLLOW_57); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							newLeafNode(lv_featureName_13_0, grammarAccess.getInfixExpressionAccess().getFeatureNameIDTerminalRuleCall_1_2_2_0());
            	      						
            	    }
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElement(grammarAccess.getInfixExpressionRule());
            	      							}
            	      							setWithLastConsumed(
            	      								current,
            	      								"featureName",
            	      								lv_featureName_13_0,
            	      								"org.eclipse.xtext.common.Terminals.ID");
            	      						
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 70, ruleInfixExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleInfixExpression"


    // $ANTLR start "entryRuleCallExpression"
    // InternalBeeLangTestLanguage.g:3882:1: entryRuleCallExpression returns [EObject current=null] : iv_ruleCallExpression= ruleCallExpression EOF ;
    public final EObject entryRuleCallExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleCallExpression_StartIndex = input.index();
        EObject iv_ruleCallExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return current; }
            // InternalBeeLangTestLanguage.g:3882:55: (iv_ruleCallExpression= ruleCallExpression EOF )
            // InternalBeeLangTestLanguage.g:3883:2: iv_ruleCallExpression= ruleCallExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 71, entryRuleCallExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleCallExpression"


    // $ANTLR start "ruleCallExpression"
    // InternalBeeLangTestLanguage.g:3889:1: ruleCallExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* ) ;
    public final EObject ruleCallExpression() throws RecognitionException {
        EObject current = null;
        int ruleCallExpression_StartIndex = input.index();
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_parameterList_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return current; }
            // InternalBeeLangTestLanguage.g:3895:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* ) )
            // InternalBeeLangTestLanguage.g:3896:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* )
            {
            // InternalBeeLangTestLanguage.g:3896:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* )
            // InternalBeeLangTestLanguage.g:3897:3: this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getCallExpressionAccess().getPrimaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_61);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrimaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBeeLangTestLanguage.g:3908:3: ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==35) ) {
                    int LA72_2 = input.LA(2);

                    if ( (synpred105_InternalBeeLangTestLanguage()) ) {
                        alt72=1;
                    }


                }


                switch (alt72) {
            	case 1 :
            	    // InternalBeeLangTestLanguage.g:3909:4: () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')'
            	    {
            	    // InternalBeeLangTestLanguage.g:3909:4: ()
            	    // InternalBeeLangTestLanguage.g:3910:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getCallExpressionAccess().getCallFunctionFuncExprAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,35,FOLLOW_59); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getCallExpressionAccess().getLeftParenthesisKeyword_1_1());
            	      			
            	    }
            	    // InternalBeeLangTestLanguage.g:3923:4: ( (lv_parameterList_3_0= ruleParameterList ) )?
            	    int alt71=2;
            	    int LA71_0 = input.LA(1);

            	    if ( (LA71_0==RULE_ID||LA71_0==RULE_STRING||LA71_0==13||(LA71_0>=17 && LA71_0<=18)||LA71_0==21||(LA71_0>=35 && LA71_0<=36)||LA71_0==52||LA71_0==56||LA71_0==60||(LA71_0>=64 && LA71_0<=66)||LA71_0==70||(LA71_0>=72 && LA71_0<=77)) ) {
            	        alt71=1;
            	    }
            	    switch (alt71) {
            	        case 1 :
            	            // InternalBeeLangTestLanguage.g:3924:5: (lv_parameterList_3_0= ruleParameterList )
            	            {
            	            // InternalBeeLangTestLanguage.g:3924:5: (lv_parameterList_3_0= ruleParameterList )
            	            // InternalBeeLangTestLanguage.g:3925:6: lv_parameterList_3_0= ruleParameterList
            	            {
            	            if ( state.backtracking==0 ) {

            	              						newCompositeNode(grammarAccess.getCallExpressionAccess().getParameterListParameterListParserRuleCall_1_2_0());
            	              					
            	            }
            	            pushFollow(FOLLOW_37);
            	            lv_parameterList_3_0=ruleParameterList();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						if (current==null) {
            	              							current = createModelElementForParent(grammarAccess.getCallExpressionRule());
            	              						}
            	              						set(
            	              							current,
            	              							"parameterList",
            	              							lv_parameterList_3_0,
            	              							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterList");
            	              						afterParserOrEnumRuleCall();
            	              					
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    otherlv_4=(Token)match(input,37,FOLLOW_61); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getCallExpressionAccess().getRightParenthesisKeyword_1_3());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 72, ruleCallExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleCallExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalBeeLangTestLanguage.g:3951:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;
        int entryRulePrimaryExpression_StartIndex = input.index();
        EObject iv_rulePrimaryExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return current; }
            // InternalBeeLangTestLanguage.g:3951:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalBeeLangTestLanguage.g:3952:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 73, entryRulePrimaryExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalBeeLangTestLanguage.g:3958:1: rulePrimaryExpression returns [EObject current=null] : (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;
        int rulePrimaryExpression_StartIndex = input.index();
        EObject this_FeatureCall_0 = null;

        EObject this_ConstructorCallExpression_1 = null;

        EObject this_Value_2 = null;

        EObject this_Literal_3 = null;

        EObject this_KeywordVariables_4 = null;

        EObject this_ParanthesizedExpression_5 = null;

        EObject this_BlockExpression_6 = null;

        EObject this_WithExpression_7 = null;

        EObject this_WithContextExpression_8 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return current; }
            // InternalBeeLangTestLanguage.g:3964:2: ( (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression ) )
            // InternalBeeLangTestLanguage.g:3965:2: (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression )
            {
            // InternalBeeLangTestLanguage.g:3965:2: (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression )
            int alt73=9;
            alt73 = dfa73.predict(input);
            switch (alt73) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:3966:3: this_FeatureCall_0= ruleFeatureCall
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFeatureCallParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FeatureCall_0=ruleFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FeatureCall_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBeeLangTestLanguage.g:3978:3: this_ConstructorCallExpression_1= ruleConstructorCallExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getConstructorCallExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ConstructorCallExpression_1=ruleConstructorCallExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ConstructorCallExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBeeLangTestLanguage.g:3990:3: this_Value_2= ruleValue
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getValueParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Value_2=ruleValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Value_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalBeeLangTestLanguage.g:4002:3: this_Literal_3= ruleLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Literal_3=ruleLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Literal_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalBeeLangTestLanguage.g:4014:3: this_KeywordVariables_4= ruleKeywordVariables
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getKeywordVariablesParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_KeywordVariables_4=ruleKeywordVariables();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_KeywordVariables_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalBeeLangTestLanguage.g:4026:3: this_ParanthesizedExpression_5= ruleParanthesizedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getParanthesizedExpressionParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParanthesizedExpression_5=ruleParanthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParanthesizedExpression_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalBeeLangTestLanguage.g:4038:3: this_BlockExpression_6= ruleBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getBlockExpressionParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BlockExpression_6=ruleBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BlockExpression_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalBeeLangTestLanguage.g:4050:3: this_WithExpression_7= ruleWithExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getWithExpressionParserRuleCall_7());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_WithExpression_7=ruleWithExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_WithExpression_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalBeeLangTestLanguage.g:4062:3: this_WithContextExpression_8= ruleWithContextExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getWithContextExpressionParserRuleCall_8());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_WithContextExpression_8=ruleWithContextExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_WithContextExpression_8;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 74, rulePrimaryExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleWithExpression"
    // InternalBeeLangTestLanguage.g:4077:1: entryRuleWithExpression returns [EObject current=null] : iv_ruleWithExpression= ruleWithExpression EOF ;
    public final EObject entryRuleWithExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleWithExpression_StartIndex = input.index();
        EObject iv_ruleWithExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return current; }
            // InternalBeeLangTestLanguage.g:4077:55: (iv_ruleWithExpression= ruleWithExpression EOF )
            // InternalBeeLangTestLanguage.g:4078:2: iv_ruleWithExpression= ruleWithExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWithExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 75, entryRuleWithExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleWithExpression"


    // $ANTLR start "ruleWithExpression"
    // InternalBeeLangTestLanguage.g:4084:1: ruleWithExpression returns [EObject current=null] : (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) ) ;
    public final EObject ruleWithExpression() throws RecognitionException {
        EObject current = null;
        int ruleWithExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token lv_referencedAdvice_1_0=null;
        Token otherlv_2=null;
        Token lv_referencedAdvice_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_funcExpr_5_0 = null;

        EObject lv_funcExpr_7_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return current; }
            // InternalBeeLangTestLanguage.g:4090:2: ( (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) ) )
            // InternalBeeLangTestLanguage.g:4091:2: (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) )
            {
            // InternalBeeLangTestLanguage.g:4091:2: (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) )
            // InternalBeeLangTestLanguage.g:4092:3: otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) )
            {
            otherlv_0=(Token)match(input,70,FOLLOW_62); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getWithExpressionAccess().getWithKeyword_0());
              		
            }
            // InternalBeeLangTestLanguage.g:4096:3: ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==RULE_ID) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:4097:4: ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )*
                    {
                    // InternalBeeLangTestLanguage.g:4097:4: ( (lv_referencedAdvice_1_0= RULE_ID ) )
                    // InternalBeeLangTestLanguage.g:4098:5: (lv_referencedAdvice_1_0= RULE_ID )
                    {
                    // InternalBeeLangTestLanguage.g:4098:5: (lv_referencedAdvice_1_0= RULE_ID )
                    // InternalBeeLangTestLanguage.g:4099:6: lv_referencedAdvice_1_0= RULE_ID
                    {
                    lv_referencedAdvice_1_0=(Token)match(input,RULE_ID,FOLLOW_63); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_referencedAdvice_1_0, grammarAccess.getWithExpressionAccess().getReferencedAdviceIDTerminalRuleCall_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getWithExpressionRule());
                      						}
                      						addWithLastConsumed(
                      							current,
                      							"referencedAdvice",
                      							lv_referencedAdvice_1_0,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }

                    // InternalBeeLangTestLanguage.g:4115:4: (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )*
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( (LA74_0==16) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // InternalBeeLangTestLanguage.g:4116:5: otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,16,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_2, grammarAccess.getWithExpressionAccess().getCommaKeyword_1_1_0());
                    	      				
                    	    }
                    	    // InternalBeeLangTestLanguage.g:4120:5: ( (lv_referencedAdvice_3_0= RULE_ID ) )
                    	    // InternalBeeLangTestLanguage.g:4121:6: (lv_referencedAdvice_3_0= RULE_ID )
                    	    {
                    	    // InternalBeeLangTestLanguage.g:4121:6: (lv_referencedAdvice_3_0= RULE_ID )
                    	    // InternalBeeLangTestLanguage.g:4122:7: lv_referencedAdvice_3_0= RULE_ID
                    	    {
                    	    lv_referencedAdvice_3_0=(Token)match(input,RULE_ID,FOLLOW_63); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(lv_referencedAdvice_3_0, grammarAccess.getWithExpressionAccess().getReferencedAdviceIDTerminalRuleCall_1_1_1_0());
                    	      						
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getWithExpressionRule());
                    	      							}
                    	      							addWithLastConsumed(
                    	      								current,
                    	      								"referencedAdvice",
                    	      								lv_referencedAdvice_3_0,
                    	      								"org.eclipse.xtext.common.Terminals.ID");
                    	      						
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

            // InternalBeeLangTestLanguage.g:4140:3: ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) )
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
                    // InternalBeeLangTestLanguage.g:4141:4: (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) )
                    {
                    // InternalBeeLangTestLanguage.g:4141:4: (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) )
                    // InternalBeeLangTestLanguage.g:4142:5: otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) )
                    {
                    otherlv_4=(Token)match(input,19,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getWithExpressionAccess().getColonKeyword_2_0_0());
                      				
                    }
                    // InternalBeeLangTestLanguage.g:4146:5: ( (lv_funcExpr_5_0= ruleExpression ) )
                    // InternalBeeLangTestLanguage.g:4147:6: (lv_funcExpr_5_0= ruleExpression )
                    {
                    // InternalBeeLangTestLanguage.g:4147:6: (lv_funcExpr_5_0= ruleExpression )
                    // InternalBeeLangTestLanguage.g:4148:7: lv_funcExpr_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getWithExpressionAccess().getFuncExprExpressionParserRuleCall_2_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    lv_funcExpr_5_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getWithExpressionRule());
                      							}
                      							set(
                      								current,
                      								"funcExpr",
                      								lv_funcExpr_5_0,
                      								"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBeeLangTestLanguage.g:4167:4: (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' )
                    {
                    // InternalBeeLangTestLanguage.g:4167:4: (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' )
                    // InternalBeeLangTestLanguage.g:4168:5: otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}'
                    {
                    otherlv_6=(Token)match(input,17,FOLLOW_64); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getWithExpressionAccess().getLeftCurlyBracketKeyword_2_1_0());
                      				
                    }
                    // InternalBeeLangTestLanguage.g:4172:5: ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) )
                    // InternalBeeLangTestLanguage.g:4173:6: (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets )
                    {
                    // InternalBeeLangTestLanguage.g:4173:6: (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets )
                    // InternalBeeLangTestLanguage.g:4174:7: lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getWithExpressionAccess().getFuncExprBlockExpressionWithoutBracketsParserRuleCall_2_1_1_0());
                      						
                    }
                    pushFollow(FOLLOW_65);
                    lv_funcExpr_7_0=ruleBlockExpressionWithoutBrackets();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getWithExpressionRule());
                      							}
                      							set(
                      								current,
                      								"funcExpr",
                      								lv_funcExpr_7_0,
                      								"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.BlockExpressionWithoutBrackets");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_8=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_8, grammarAccess.getWithExpressionAccess().getRightCurlyBracketKeyword_2_1_2());
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 76, ruleWithExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleWithExpression"


    // $ANTLR start "entryRuleWithContextExpression"
    // InternalBeeLangTestLanguage.g:4201:1: entryRuleWithContextExpression returns [EObject current=null] : iv_ruleWithContextExpression= ruleWithContextExpression EOF ;
    public final EObject entryRuleWithContextExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleWithContextExpression_StartIndex = input.index();
        EObject iv_ruleWithContextExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return current; }
            // InternalBeeLangTestLanguage.g:4201:62: (iv_ruleWithContextExpression= ruleWithContextExpression EOF )
            // InternalBeeLangTestLanguage.g:4202:2: iv_ruleWithContextExpression= ruleWithContextExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWithContextExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 77, entryRuleWithContextExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleWithContextExpression"


    // $ANTLR start "ruleWithContextExpression"
    // InternalBeeLangTestLanguage.g:4208:1: ruleWithContextExpression returns [EObject current=null] : (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) ) ;
    public final EObject ruleWithContextExpression() throws RecognitionException {
        EObject current = null;
        int ruleWithContextExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_alias_4_0=null;
        EObject lv_expr_2_0 = null;

        EObject lv_contextBlock_5_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return current; }
            // InternalBeeLangTestLanguage.g:4214:2: ( (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) ) )
            // InternalBeeLangTestLanguage.g:4215:2: (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) )
            {
            // InternalBeeLangTestLanguage.g:4215:2: (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) )
            // InternalBeeLangTestLanguage.g:4216:3: otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) )
            {
            otherlv_0=(Token)match(input,70,FOLLOW_66); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getWithContextExpressionAccess().getWithKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,71,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getWithContextExpressionAccess().getContextKeyword_1());
              		
            }
            // InternalBeeLangTestLanguage.g:4224:3: ( (lv_expr_2_0= ruleExpression ) )
            // InternalBeeLangTestLanguage.g:4225:4: (lv_expr_2_0= ruleExpression )
            {
            // InternalBeeLangTestLanguage.g:4225:4: (lv_expr_2_0= ruleExpression )
            // InternalBeeLangTestLanguage.g:4226:5: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getWithContextExpressionAccess().getExprExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_21);
            lv_expr_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getWithContextExpressionRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_2_0,
              						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBeeLangTestLanguage.g:4243:3: (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==28) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:4244:4: otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,28,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getWithContextExpressionAccess().getAsKeyword_3_0());
                      			
                    }
                    // InternalBeeLangTestLanguage.g:4248:4: ( (lv_alias_4_0= RULE_ID ) )
                    // InternalBeeLangTestLanguage.g:4249:5: (lv_alias_4_0= RULE_ID )
                    {
                    // InternalBeeLangTestLanguage.g:4249:5: (lv_alias_4_0= RULE_ID )
                    // InternalBeeLangTestLanguage.g:4250:6: lv_alias_4_0= RULE_ID
                    {
                    lv_alias_4_0=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_alias_4_0, grammarAccess.getWithContextExpressionAccess().getAliasIDTerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getWithContextExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"alias",
                      							lv_alias_4_0,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalBeeLangTestLanguage.g:4267:3: ( (lv_contextBlock_5_0= ruleBlockExpression ) )
            // InternalBeeLangTestLanguage.g:4268:4: (lv_contextBlock_5_0= ruleBlockExpression )
            {
            // InternalBeeLangTestLanguage.g:4268:4: (lv_contextBlock_5_0= ruleBlockExpression )
            // InternalBeeLangTestLanguage.g:4269:5: lv_contextBlock_5_0= ruleBlockExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getWithContextExpressionAccess().getContextBlockBlockExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_contextBlock_5_0=ruleBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getWithContextExpressionRule());
              					}
              					set(
              						current,
              						"contextBlock",
              						lv_contextBlock_5_0,
              						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.BlockExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 78, ruleWithContextExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleWithContextExpression"


    // $ANTLR start "entryRuleBlockExpression"
    // InternalBeeLangTestLanguage.g:4290:1: entryRuleBlockExpression returns [EObject current=null] : iv_ruleBlockExpression= ruleBlockExpression EOF ;
    public final EObject entryRuleBlockExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleBlockExpression_StartIndex = input.index();
        EObject iv_ruleBlockExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return current; }
            // InternalBeeLangTestLanguage.g:4290:56: (iv_ruleBlockExpression= ruleBlockExpression EOF )
            // InternalBeeLangTestLanguage.g:4291:2: iv_ruleBlockExpression= ruleBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlockExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 79, entryRuleBlockExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleBlockExpression"


    // $ANTLR start "ruleBlockExpression"
    // InternalBeeLangTestLanguage.g:4297:1: ruleBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' ) ;
    public final EObject ruleBlockExpression() throws RecognitionException {
        EObject current = null;
        int ruleBlockExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 80) ) { return current; }
            // InternalBeeLangTestLanguage.g:4303:2: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' ) )
            // InternalBeeLangTestLanguage.g:4304:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' )
            {
            // InternalBeeLangTestLanguage.g:4304:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' )
            // InternalBeeLangTestLanguage.g:4305:3: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}'
            {
            // InternalBeeLangTestLanguage.g:4305:3: ()
            // InternalBeeLangTestLanguage.g:4306:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBlockExpressionAccess().getChainedExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,17,FOLLOW_67); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalBeeLangTestLanguage.g:4319:3: ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==RULE_ID||LA78_0==RULE_STRING||LA78_0==13||(LA78_0>=17 && LA78_0<=18)||LA78_0==21||LA78_0==33||LA78_0==35||(LA78_0>=53 && LA78_0<=54)||LA78_0==56||LA78_0==60||(LA78_0>=64 && LA78_0<=66)||LA78_0==70||(LA78_0>=72 && LA78_0<=76)) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalBeeLangTestLanguage.g:4320:4: ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';'
            	    {
            	    // InternalBeeLangTestLanguage.g:4320:4: ( (lv_expressions_2_0= ruleTopLevelExpression ) )
            	    // InternalBeeLangTestLanguage.g:4321:5: (lv_expressions_2_0= ruleTopLevelExpression )
            	    {
            	    // InternalBeeLangTestLanguage.g:4321:5: (lv_expressions_2_0= ruleTopLevelExpression )
            	    // InternalBeeLangTestLanguage.g:4322:6: lv_expressions_2_0= ruleTopLevelExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBlockExpressionAccess().getExpressionsTopLevelExpressionParserRuleCall_2_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_expressions_2_0=ruleTopLevelExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBlockExpressionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"expressions",
            	      							lv_expressions_2_0,
            	      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.TopLevelExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    otherlv_3=(Token)match(input,20,FOLLOW_67); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getBlockExpressionAccess().getSemicolonKeyword_2_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);

            otherlv_4=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getBlockExpressionAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 80, ruleBlockExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleBlockExpression"


    // $ANTLR start "entryRuleValue"
    // InternalBeeLangTestLanguage.g:4352:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;
        int entryRuleValue_StartIndex = input.index();
        EObject iv_ruleValue = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 81) ) { return current; }
            // InternalBeeLangTestLanguage.g:4352:46: (iv_ruleValue= ruleValue EOF )
            // InternalBeeLangTestLanguage.g:4353:2: iv_ruleValue= ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 81, entryRuleValue_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalBeeLangTestLanguage.g:4359:1: ruleValue returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;
        int ruleValue_StartIndex = input.index();
        Token lv_name_1_0=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 82) ) { return current; }
            // InternalBeeLangTestLanguage.g:4365:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalBeeLangTestLanguage.g:4366:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalBeeLangTestLanguage.g:4366:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalBeeLangTestLanguage.g:4367:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalBeeLangTestLanguage.g:4367:3: ()
            // InternalBeeLangTestLanguage.g:4368:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getValueAccess().getVariableExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalBeeLangTestLanguage.g:4377:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalBeeLangTestLanguage.g:4378:4: (lv_name_1_0= RULE_ID )
            {
            // InternalBeeLangTestLanguage.g:4378:4: (lv_name_1_0= RULE_ID )
            // InternalBeeLangTestLanguage.g:4379:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getValueAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getValueRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 82, ruleValue_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleKeywordVariables"
    // InternalBeeLangTestLanguage.g:4399:1: entryRuleKeywordVariables returns [EObject current=null] : iv_ruleKeywordVariables= ruleKeywordVariables EOF ;
    public final EObject entryRuleKeywordVariables() throws RecognitionException {
        EObject current = null;
        int entryRuleKeywordVariables_StartIndex = input.index();
        EObject iv_ruleKeywordVariables = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 83) ) { return current; }
            // InternalBeeLangTestLanguage.g:4399:57: (iv_ruleKeywordVariables= ruleKeywordVariables EOF )
            // InternalBeeLangTestLanguage.g:4400:2: iv_ruleKeywordVariables= ruleKeywordVariables EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getKeywordVariablesRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 83, entryRuleKeywordVariables_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordVariables"


    // $ANTLR start "ruleKeywordVariables"
    // InternalBeeLangTestLanguage.g:4406:1: ruleKeywordVariables returns [EObject current=null] : ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) ) ;
    public final EObject ruleKeywordVariables() throws RecognitionException {
        EObject current = null;
        int ruleKeywordVariables_StartIndex = input.index();
        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token lv_name_1_3=null;
        Token lv_name_1_4=null;
        Token lv_name_1_5=null;
        Token lv_name_1_6=null;
        Token lv_name_1_7=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 84) ) { return current; }
            // InternalBeeLangTestLanguage.g:4412:2: ( ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) ) )
            // InternalBeeLangTestLanguage.g:4413:2: ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) )
            {
            // InternalBeeLangTestLanguage.g:4413:2: ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) )
            // InternalBeeLangTestLanguage.g:4414:3: () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) )
            {
            // InternalBeeLangTestLanguage.g:4414:3: ()
            // InternalBeeLangTestLanguage.g:4415:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getKeywordVariablesAccess().getVariableExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalBeeLangTestLanguage.g:4424:3: ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) )
            // InternalBeeLangTestLanguage.g:4425:4: ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) )
            {
            // InternalBeeLangTestLanguage.g:4425:4: ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) )
            // InternalBeeLangTestLanguage.g:4426:5: (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' )
            {
            // InternalBeeLangTestLanguage.g:4426:5: (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' )
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
                    // InternalBeeLangTestLanguage.g:4427:6: lv_name_1_1= 'input'
                    {
                    lv_name_1_1=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_1_1, grammarAccess.getKeywordVariablesAccess().getNameInputKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getKeywordVariablesRule());
                      						}
                      						setWithLastConsumed(current, "name", lv_name_1_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalBeeLangTestLanguage.g:4438:6: lv_name_1_2= 'output'
                    {
                    lv_name_1_2=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_1_2, grammarAccess.getKeywordVariablesAccess().getNameOutputKeyword_1_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getKeywordVariablesRule());
                      						}
                      						setWithLastConsumed(current, "name", lv_name_1_2, null);
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalBeeLangTestLanguage.g:4449:6: lv_name_1_3= 'source'
                    {
                    lv_name_1_3=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_1_3, grammarAccess.getKeywordVariablesAccess().getNameSourceKeyword_1_0_2());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getKeywordVariablesRule());
                      						}
                      						setWithLastConsumed(current, "name", lv_name_1_3, null);
                      					
                    }

                    }
                    break;
                case 4 :
                    // InternalBeeLangTestLanguage.g:4460:6: lv_name_1_4= 'properties'
                    {
                    lv_name_1_4=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_1_4, grammarAccess.getKeywordVariablesAccess().getNamePropertiesKeyword_1_0_3());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getKeywordVariablesRule());
                      						}
                      						setWithLastConsumed(current, "name", lv_name_1_4, null);
                      					
                    }

                    }
                    break;
                case 5 :
                    // InternalBeeLangTestLanguage.g:4471:6: lv_name_1_5= 'builder'
                    {
                    lv_name_1_5=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_1_5, grammarAccess.getKeywordVariablesAccess().getNameBuilderKeyword_1_0_4());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getKeywordVariablesRule());
                      						}
                      						setWithLastConsumed(current, "name", lv_name_1_5, null);
                      					
                    }

                    }
                    break;
                case 6 :
                    // InternalBeeLangTestLanguage.g:4482:6: lv_name_1_6= 'unit'
                    {
                    lv_name_1_6=(Token)match(input,13,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_1_6, grammarAccess.getKeywordVariablesAccess().getNameUnitKeyword_1_0_5());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getKeywordVariablesRule());
                      						}
                      						setWithLastConsumed(current, "name", lv_name_1_6, null);
                      					
                    }

                    }
                    break;
                case 7 :
                    // InternalBeeLangTestLanguage.g:4493:6: lv_name_1_7= 'this'
                    {
                    lv_name_1_7=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_1_7, grammarAccess.getKeywordVariablesAccess().getNameThisKeyword_1_0_6());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getKeywordVariablesRule());
                      						}
                      						setWithLastConsumed(current, "name", lv_name_1_7, null);
                      					
                    }

                    }
                    break;

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 84, ruleKeywordVariables_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleKeywordVariables"


    // $ANTLR start "entryRuleFeatureCall"
    // InternalBeeLangTestLanguage.g:4510:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;
        int entryRuleFeatureCall_StartIndex = input.index();
        EObject iv_ruleFeatureCall = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 85) ) { return current; }
            // InternalBeeLangTestLanguage.g:4510:52: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // InternalBeeLangTestLanguage.g:4511:2: iv_ruleFeatureCall= ruleFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureCallRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 85, entryRuleFeatureCall_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureCall"


    // $ANTLR start "ruleFeatureCall"
    // InternalBeeLangTestLanguage.g:4517:1: ruleFeatureCall returns [EObject current=null] : this_OperationCall_0= ruleOperationCall ;
    public final EObject ruleFeatureCall() throws RecognitionException {
        EObject current = null;
        int ruleFeatureCall_StartIndex = input.index();
        EObject this_OperationCall_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 86) ) { return current; }
            // InternalBeeLangTestLanguage.g:4523:2: (this_OperationCall_0= ruleOperationCall )
            // InternalBeeLangTestLanguage.g:4524:2: this_OperationCall_0= ruleOperationCall
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getFeatureCallAccess().getOperationCallParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_OperationCall_0=ruleOperationCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_OperationCall_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 86, ruleFeatureCall_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleFeatureCall"


    // $ANTLR start "entryRuleOperationCall"
    // InternalBeeLangTestLanguage.g:4538:1: entryRuleOperationCall returns [EObject current=null] : iv_ruleOperationCall= ruleOperationCall EOF ;
    public final EObject entryRuleOperationCall() throws RecognitionException {
        EObject current = null;
        int entryRuleOperationCall_StartIndex = input.index();
        EObject iv_ruleOperationCall = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 87) ) { return current; }
            // InternalBeeLangTestLanguage.g:4538:54: (iv_ruleOperationCall= ruleOperationCall EOF )
            // InternalBeeLangTestLanguage.g:4539:2: iv_ruleOperationCall= ruleOperationCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOperationCallRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 87, entryRuleOperationCall_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleOperationCall"


    // $ANTLR start "ruleOperationCall"
    // InternalBeeLangTestLanguage.g:4545:1: ruleOperationCall returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' ) ;
    public final EObject ruleOperationCall() throws RecognitionException {
        EObject current = null;
        int ruleOperationCall_StartIndex = input.index();
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_parameterList_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 88) ) { return current; }
            // InternalBeeLangTestLanguage.g:4551:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' ) )
            // InternalBeeLangTestLanguage.g:4552:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )
            {
            // InternalBeeLangTestLanguage.g:4552:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )
            // InternalBeeLangTestLanguage.g:4553:3: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')'
            {
            // InternalBeeLangTestLanguage.g:4553:3: ()
            // InternalBeeLangTestLanguage.g:4554:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getOperationCallAccess().getCallNamedFunctionAction_0(),
              					current);
              			
            }

            }

            // InternalBeeLangTestLanguage.g:4563:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalBeeLangTestLanguage.g:4564:4: (lv_name_1_0= RULE_ID )
            {
            // InternalBeeLangTestLanguage.g:4564:4: (lv_name_1_0= RULE_ID )
            // InternalBeeLangTestLanguage.g:4565:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_58); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getOperationCallAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getOperationCallRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,35,FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getOperationCallAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalBeeLangTestLanguage.g:4585:3: ( (lv_parameterList_3_0= ruleParameterList ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_ID||LA80_0==RULE_STRING||LA80_0==13||(LA80_0>=17 && LA80_0<=18)||LA80_0==21||(LA80_0>=35 && LA80_0<=36)||LA80_0==52||LA80_0==56||LA80_0==60||(LA80_0>=64 && LA80_0<=66)||LA80_0==70||(LA80_0>=72 && LA80_0<=77)) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:4586:4: (lv_parameterList_3_0= ruleParameterList )
                    {
                    // InternalBeeLangTestLanguage.g:4586:4: (lv_parameterList_3_0= ruleParameterList )
                    // InternalBeeLangTestLanguage.g:4587:5: lv_parameterList_3_0= ruleParameterList
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getOperationCallAccess().getParameterListParameterListParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_37);
                    lv_parameterList_3_0=ruleParameterList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getOperationCallRule());
                      					}
                      					set(
                      						current,
                      						"parameterList",
                      						lv_parameterList_3_0,
                      						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterList");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getOperationCallAccess().getRightParenthesisKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 88, ruleOperationCall_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleOperationCall"


    // $ANTLR start "entryRuleConstructorCallExpression"
    // InternalBeeLangTestLanguage.g:4612:1: entryRuleConstructorCallExpression returns [EObject current=null] : iv_ruleConstructorCallExpression= ruleConstructorCallExpression EOF ;
    public final EObject entryRuleConstructorCallExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleConstructorCallExpression_StartIndex = input.index();
        EObject iv_ruleConstructorCallExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 89) ) { return current; }
            // InternalBeeLangTestLanguage.g:4612:66: (iv_ruleConstructorCallExpression= ruleConstructorCallExpression EOF )
            // InternalBeeLangTestLanguage.g:4613:2: iv_ruleConstructorCallExpression= ruleConstructorCallExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstructorCallExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 89, entryRuleConstructorCallExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleConstructorCallExpression"


    // $ANTLR start "ruleConstructorCallExpression"
    // InternalBeeLangTestLanguage.g:4619:1: ruleConstructorCallExpression returns [EObject current=null] : ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? ) ;
    public final EObject ruleConstructorCallExpression() throws RecognitionException {
        EObject current = null;
        int ruleConstructorCallExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token lv_typeExpr_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_alias_7_0=null;
        EObject lv_parameterList_4_0 = null;

        EObject lv_contextBlock_8_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 90) ) { return current; }
            // InternalBeeLangTestLanguage.g:4625:2: ( ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? ) )
            // InternalBeeLangTestLanguage.g:4626:2: ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? )
            {
            // InternalBeeLangTestLanguage.g:4626:2: ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? )
            // InternalBeeLangTestLanguage.g:4627:3: () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )?
            {
            // InternalBeeLangTestLanguage.g:4627:3: ()
            // InternalBeeLangTestLanguage.g:4628:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getConstructorCallExpressionAccess().getCreateExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,76,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getConstructorCallExpressionAccess().getNewKeyword_1());
              		
            }
            // InternalBeeLangTestLanguage.g:4641:3: ( (lv_typeExpr_2_0= RULE_ID ) )
            // InternalBeeLangTestLanguage.g:4642:4: (lv_typeExpr_2_0= RULE_ID )
            {
            // InternalBeeLangTestLanguage.g:4642:4: (lv_typeExpr_2_0= RULE_ID )
            // InternalBeeLangTestLanguage.g:4643:5: lv_typeExpr_2_0= RULE_ID
            {
            lv_typeExpr_2_0=(Token)match(input,RULE_ID,FOLLOW_68); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_typeExpr_2_0, grammarAccess.getConstructorCallExpressionAccess().getTypeExprIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getConstructorCallExpressionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"typeExpr",
              						lv_typeExpr_2_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalBeeLangTestLanguage.g:4659:3: (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )?
            int alt82=2;
            alt82 = dfa82.predict(input);
            switch (alt82) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:4660:4: otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,35,FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getConstructorCallExpressionAccess().getLeftParenthesisKeyword_3_0());
                      			
                    }
                    // InternalBeeLangTestLanguage.g:4664:4: ( (lv_parameterList_4_0= ruleParameterList ) )?
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==RULE_ID||LA81_0==RULE_STRING||LA81_0==13||(LA81_0>=17 && LA81_0<=18)||LA81_0==21||(LA81_0>=35 && LA81_0<=36)||LA81_0==52||LA81_0==56||LA81_0==60||(LA81_0>=64 && LA81_0<=66)||LA81_0==70||(LA81_0>=72 && LA81_0<=77)) ) {
                        alt81=1;
                    }
                    switch (alt81) {
                        case 1 :
                            // InternalBeeLangTestLanguage.g:4665:5: (lv_parameterList_4_0= ruleParameterList )
                            {
                            // InternalBeeLangTestLanguage.g:4665:5: (lv_parameterList_4_0= ruleParameterList )
                            // InternalBeeLangTestLanguage.g:4666:6: lv_parameterList_4_0= ruleParameterList
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getConstructorCallExpressionAccess().getParameterListParameterListParserRuleCall_3_1_0());
                              					
                            }
                            pushFollow(FOLLOW_37);
                            lv_parameterList_4_0=ruleParameterList();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getConstructorCallExpressionRule());
                              						}
                              						set(
                              							current,
                              							"parameterList",
                              							lv_parameterList_4_0,
                              							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterList");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,37,FOLLOW_69); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getConstructorCallExpressionAccess().getRightParenthesisKeyword_3_2());
                      			
                    }

                    }
                    break;

            }

            // InternalBeeLangTestLanguage.g:4688:3: (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==28) ) {
                int LA83_1 = input.LA(2);

                if ( (LA83_1==RULE_ID) ) {
                    int LA83_3 = input.LA(3);

                    if ( (synpred128_InternalBeeLangTestLanguage()) ) {
                        alt83=1;
                    }
                }
            }
            switch (alt83) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:4689:4: otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,28,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getConstructorCallExpressionAccess().getAsKeyword_4_0());
                      			
                    }
                    // InternalBeeLangTestLanguage.g:4693:4: ( (lv_alias_7_0= RULE_ID ) )
                    // InternalBeeLangTestLanguage.g:4694:5: (lv_alias_7_0= RULE_ID )
                    {
                    // InternalBeeLangTestLanguage.g:4694:5: (lv_alias_7_0= RULE_ID )
                    // InternalBeeLangTestLanguage.g:4695:6: lv_alias_7_0= RULE_ID
                    {
                    lv_alias_7_0=(Token)match(input,RULE_ID,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_alias_7_0, grammarAccess.getConstructorCallExpressionAccess().getAliasIDTerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getConstructorCallExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"alias",
                      							lv_alias_7_0,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalBeeLangTestLanguage.g:4712:3: ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )?
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
                    // InternalBeeLangTestLanguage.g:4713:4: (lv_contextBlock_8_0= ruleInitializationBlockExpression )
                    {
                    // InternalBeeLangTestLanguage.g:4713:4: (lv_contextBlock_8_0= ruleInitializationBlockExpression )
                    // InternalBeeLangTestLanguage.g:4714:5: lv_contextBlock_8_0= ruleInitializationBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getConstructorCallExpressionAccess().getContextBlockInitializationBlockExpressionParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_contextBlock_8_0=ruleInitializationBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getConstructorCallExpressionRule());
                      					}
                      					set(
                      						current,
                      						"contextBlock",
                      						lv_contextBlock_8_0,
                      						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.InitializationBlockExpression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 90, ruleConstructorCallExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleConstructorCallExpression"


    // $ANTLR start "entryRuleInitializationBlockExpression"
    // InternalBeeLangTestLanguage.g:4735:1: entryRuleInitializationBlockExpression returns [EObject current=null] : iv_ruleInitializationBlockExpression= ruleInitializationBlockExpression EOF ;
    public final EObject entryRuleInitializationBlockExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleInitializationBlockExpression_StartIndex = input.index();
        EObject iv_ruleInitializationBlockExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 91) ) { return current; }
            // InternalBeeLangTestLanguage.g:4735:70: (iv_ruleInitializationBlockExpression= ruleInitializationBlockExpression EOF )
            // InternalBeeLangTestLanguage.g:4736:2: iv_ruleInitializationBlockExpression= ruleInitializationBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInitializationBlockExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 91, entryRuleInitializationBlockExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleInitializationBlockExpression"


    // $ANTLR start "ruleInitializationBlockExpression"
    // InternalBeeLangTestLanguage.g:4742:1: ruleInitializationBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' ) ;
    public final EObject ruleInitializationBlockExpression() throws RecognitionException {
        EObject current = null;
        int ruleInitializationBlockExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 92) ) { return current; }
            // InternalBeeLangTestLanguage.g:4748:2: ( ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' ) )
            // InternalBeeLangTestLanguage.g:4749:2: ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' )
            {
            // InternalBeeLangTestLanguage.g:4749:2: ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' )
            // InternalBeeLangTestLanguage.g:4750:3: () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}'
            {
            // InternalBeeLangTestLanguage.g:4750:3: ()
            // InternalBeeLangTestLanguage.g:4751:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getInitializationBlockExpressionAccess().getChainedExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInitializationBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalBeeLangTestLanguage.g:4764:3: ( (lv_expressions_2_0= ruleInitializationExpression ) )
            // InternalBeeLangTestLanguage.g:4765:4: (lv_expressions_2_0= ruleInitializationExpression )
            {
            // InternalBeeLangTestLanguage.g:4765:4: (lv_expressions_2_0= ruleInitializationExpression )
            // InternalBeeLangTestLanguage.g:4766:5: lv_expressions_2_0= ruleInitializationExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInitializationBlockExpressionAccess().getExpressionsInitializationExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_14);
            lv_expressions_2_0=ruleInitializationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getInitializationBlockExpressionRule());
              					}
              					add(
              						current,
              						"expressions",
              						lv_expressions_2_0,
              						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.InitializationExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_65); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getInitializationBlockExpressionAccess().getSemicolonKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getInitializationBlockExpressionAccess().getRightCurlyBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 92, ruleInitializationBlockExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleInitializationBlockExpression"


    // $ANTLR start "entryRuleInitializationExpression"
    // InternalBeeLangTestLanguage.g:4795:1: entryRuleInitializationExpression returns [EObject current=null] : iv_ruleInitializationExpression= ruleInitializationExpression EOF ;
    public final EObject entryRuleInitializationExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleInitializationExpression_StartIndex = input.index();
        EObject iv_ruleInitializationExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 93) ) { return current; }
            // InternalBeeLangTestLanguage.g:4795:65: (iv_ruleInitializationExpression= ruleInitializationExpression EOF )
            // InternalBeeLangTestLanguage.g:4796:2: iv_ruleInitializationExpression= ruleInitializationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInitializationExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 93, entryRuleInitializationExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleInitializationExpression"


    // $ANTLR start "ruleInitializationExpression"
    // InternalBeeLangTestLanguage.g:4802:1: ruleInitializationExpression returns [EObject current=null] : ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) ) ;
    public final EObject ruleInitializationExpression() throws RecognitionException {
        EObject current = null;
        int ruleInitializationExpression_StartIndex = input.index();
        Token lv_functionName_2_0=null;
        EObject lv_leftExpr_1_0 = null;

        EObject lv_rightExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 94) ) { return current; }
            // InternalBeeLangTestLanguage.g:4808:2: ( ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) ) )
            // InternalBeeLangTestLanguage.g:4809:2: ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) )
            {
            // InternalBeeLangTestLanguage.g:4809:2: ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) )
            // InternalBeeLangTestLanguage.g:4810:3: () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) )
            {
            // InternalBeeLangTestLanguage.g:4810:3: ()
            // InternalBeeLangTestLanguage.g:4811:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getInitializationExpressionAccess().getAssignmentExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalBeeLangTestLanguage.g:4820:3: ( (lv_leftExpr_1_0= ruleFeatureOfThis ) )
            // InternalBeeLangTestLanguage.g:4821:4: (lv_leftExpr_1_0= ruleFeatureOfThis )
            {
            // InternalBeeLangTestLanguage.g:4821:4: (lv_leftExpr_1_0= ruleFeatureOfThis )
            // InternalBeeLangTestLanguage.g:4822:5: lv_leftExpr_1_0= ruleFeatureOfThis
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInitializationExpressionAccess().getLeftExprFeatureOfThisParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_12);
            lv_leftExpr_1_0=ruleFeatureOfThis();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getInitializationExpressionRule());
              					}
              					set(
              						current,
              						"leftExpr",
              						lv_leftExpr_1_0,
              						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.FeatureOfThis");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBeeLangTestLanguage.g:4839:3: ( (lv_functionName_2_0= ':' ) )
            // InternalBeeLangTestLanguage.g:4840:4: (lv_functionName_2_0= ':' )
            {
            // InternalBeeLangTestLanguage.g:4840:4: (lv_functionName_2_0= ':' )
            // InternalBeeLangTestLanguage.g:4841:5: lv_functionName_2_0= ':'
            {
            lv_functionName_2_0=(Token)match(input,19,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_functionName_2_0, grammarAccess.getInitializationExpressionAccess().getFunctionNameColonKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getInitializationExpressionRule());
              					}
              					setWithLastConsumed(current, "functionName", lv_functionName_2_0, ":");
              				
            }

            }


            }

            // InternalBeeLangTestLanguage.g:4853:3: ( (lv_rightExpr_3_0= ruleExpression ) )
            // InternalBeeLangTestLanguage.g:4854:4: (lv_rightExpr_3_0= ruleExpression )
            {
            // InternalBeeLangTestLanguage.g:4854:4: (lv_rightExpr_3_0= ruleExpression )
            // InternalBeeLangTestLanguage.g:4855:5: lv_rightExpr_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInitializationExpressionAccess().getRightExprExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_rightExpr_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getInitializationExpressionRule());
              					}
              					set(
              						current,
              						"rightExpr",
              						lv_rightExpr_3_0,
              						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 94, ruleInitializationExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleInitializationExpression"


    // $ANTLR start "entryRuleFeatureOfThis"
    // InternalBeeLangTestLanguage.g:4876:1: entryRuleFeatureOfThis returns [EObject current=null] : iv_ruleFeatureOfThis= ruleFeatureOfThis EOF ;
    public final EObject entryRuleFeatureOfThis() throws RecognitionException {
        EObject current = null;
        int entryRuleFeatureOfThis_StartIndex = input.index();
        EObject iv_ruleFeatureOfThis = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 95) ) { return current; }
            // InternalBeeLangTestLanguage.g:4876:54: (iv_ruleFeatureOfThis= ruleFeatureOfThis EOF )
            // InternalBeeLangTestLanguage.g:4877:2: iv_ruleFeatureOfThis= ruleFeatureOfThis EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureOfThisRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 95, entryRuleFeatureOfThis_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureOfThis"


    // $ANTLR start "ruleFeatureOfThis"
    // InternalBeeLangTestLanguage.g:4883:1: ruleFeatureOfThis returns [EObject current=null] : ( () ( (lv_featureName_1_0= RULE_ID ) ) ) ;
    public final EObject ruleFeatureOfThis() throws RecognitionException {
        EObject current = null;
        int ruleFeatureOfThis_StartIndex = input.index();
        Token lv_featureName_1_0=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 96) ) { return current; }
            // InternalBeeLangTestLanguage.g:4889:2: ( ( () ( (lv_featureName_1_0= RULE_ID ) ) ) )
            // InternalBeeLangTestLanguage.g:4890:2: ( () ( (lv_featureName_1_0= RULE_ID ) ) )
            {
            // InternalBeeLangTestLanguage.g:4890:2: ( () ( (lv_featureName_1_0= RULE_ID ) ) )
            // InternalBeeLangTestLanguage.g:4891:3: () ( (lv_featureName_1_0= RULE_ID ) )
            {
            // InternalBeeLangTestLanguage.g:4891:3: ()
            // InternalBeeLangTestLanguage.g:4892:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFeatureOfThisAccess().getFeatureExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalBeeLangTestLanguage.g:4901:3: ( (lv_featureName_1_0= RULE_ID ) )
            // InternalBeeLangTestLanguage.g:4902:4: (lv_featureName_1_0= RULE_ID )
            {
            // InternalBeeLangTestLanguage.g:4902:4: (lv_featureName_1_0= RULE_ID )
            // InternalBeeLangTestLanguage.g:4903:5: lv_featureName_1_0= RULE_ID
            {
            lv_featureName_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_featureName_1_0, grammarAccess.getFeatureOfThisAccess().getFeatureNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFeatureOfThisRule());
              					}
              					setWithLastConsumed(
              						current,
              						"featureName",
              						lv_featureName_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 96, ruleFeatureOfThis_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleFeatureOfThis"


    // $ANTLR start "entryRuleLiteral"
    // InternalBeeLangTestLanguage.g:4923:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;
        int entryRuleLiteral_StartIndex = input.index();
        EObject iv_ruleLiteral = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 97) ) { return current; }
            // InternalBeeLangTestLanguage.g:4923:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalBeeLangTestLanguage.g:4924:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 97, entryRuleLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalBeeLangTestLanguage.g:4930:1: ruleLiteral returns [EObject current=null] : (this_ValueLiteral_0= ruleValueLiteral | this_LiteralFunction_1= ruleLiteralFunction ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;
        int ruleLiteral_StartIndex = input.index();
        EObject this_ValueLiteral_0 = null;

        EObject this_LiteralFunction_1 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 98) ) { return current; }
            // InternalBeeLangTestLanguage.g:4936:2: ( (this_ValueLiteral_0= ruleValueLiteral | this_LiteralFunction_1= ruleLiteralFunction ) )
            // InternalBeeLangTestLanguage.g:4937:2: (this_ValueLiteral_0= ruleValueLiteral | this_LiteralFunction_1= ruleLiteralFunction )
            {
            // InternalBeeLangTestLanguage.g:4937:2: (this_ValueLiteral_0= ruleValueLiteral | this_LiteralFunction_1= ruleLiteralFunction )
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
                    // InternalBeeLangTestLanguage.g:4938:3: this_ValueLiteral_0= ruleValueLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getValueLiteralParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ValueLiteral_0=ruleValueLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ValueLiteral_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBeeLangTestLanguage.g:4950:3: this_LiteralFunction_1= ruleLiteralFunction
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getLiteralFunctionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LiteralFunction_1=ruleLiteralFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralFunction_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 98, ruleLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleLiteralFunction"
    // InternalBeeLangTestLanguage.g:4965:1: entryRuleLiteralFunction returns [EObject current=null] : iv_ruleLiteralFunction= ruleLiteralFunction EOF ;
    public final EObject entryRuleLiteralFunction() throws RecognitionException {
        EObject current = null;
        int entryRuleLiteralFunction_StartIndex = input.index();
        EObject iv_ruleLiteralFunction = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 99) ) { return current; }
            // InternalBeeLangTestLanguage.g:4965:56: (iv_ruleLiteralFunction= ruleLiteralFunction EOF )
            // InternalBeeLangTestLanguage.g:4966:2: iv_ruleLiteralFunction= ruleLiteralFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralFunctionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 99, entryRuleLiteralFunction_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralFunction"


    // $ANTLR start "ruleLiteralFunction"
    // InternalBeeLangTestLanguage.g:4972:1: ruleLiteralFunction returns [EObject current=null] : (otherlv_0= '{' this_ClosureExpression_1= ruleClosureExpression otherlv_2= '}' ) ;
    public final EObject ruleLiteralFunction() throws RecognitionException {
        EObject current = null;
        int ruleLiteralFunction_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_ClosureExpression_1 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 100) ) { return current; }
            // InternalBeeLangTestLanguage.g:4978:2: ( (otherlv_0= '{' this_ClosureExpression_1= ruleClosureExpression otherlv_2= '}' ) )
            // InternalBeeLangTestLanguage.g:4979:2: (otherlv_0= '{' this_ClosureExpression_1= ruleClosureExpression otherlv_2= '}' )
            {
            // InternalBeeLangTestLanguage.g:4979:2: (otherlv_0= '{' this_ClosureExpression_1= ruleClosureExpression otherlv_2= '}' )
            // InternalBeeLangTestLanguage.g:4980:3: otherlv_0= '{' this_ClosureExpression_1= ruleClosureExpression otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_70); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLiteralFunctionAccess().getLeftCurlyBracketKeyword_0());
              		
            }
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLiteralFunctionAccess().getClosureExpressionParserRuleCall_1());
              		
            }
            pushFollow(FOLLOW_65);
            this_ClosureExpression_1=ruleClosureExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ClosureExpression_1;
              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_2=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getLiteralFunctionAccess().getRightCurlyBracketKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 100, ruleLiteralFunction_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleLiteralFunction"


    // $ANTLR start "entryRuleClosureExpression"
    // InternalBeeLangTestLanguage.g:5003:1: entryRuleClosureExpression returns [EObject current=null] : iv_ruleClosureExpression= ruleClosureExpression EOF ;
    public final EObject entryRuleClosureExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleClosureExpression_StartIndex = input.index();
        EObject iv_ruleClosureExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 101) ) { return current; }
            // InternalBeeLangTestLanguage.g:5003:58: (iv_ruleClosureExpression= ruleClosureExpression EOF )
            // InternalBeeLangTestLanguage.g:5004:2: iv_ruleClosureExpression= ruleClosureExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClosureExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 101, entryRuleClosureExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleClosureExpression"


    // $ANTLR start "ruleClosureExpression"
    // InternalBeeLangTestLanguage.g:5010:1: ruleClosureExpression returns [EObject current=null] : ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) ) ;
    public final EObject ruleClosureExpression() throws RecognitionException {
        EObject current = null;
        int ruleClosureExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_varArgs_9_0=null;
        Token lv_varArgs_11_0=null;
        Token otherlv_13=null;
        EObject lv_returnType_2_0 = null;

        EObject lv_parameters_5_0 = null;

        EObject lv_parameters_7_0 = null;

        EObject lv_parameters_10_0 = null;

        EObject lv_parameters_12_0 = null;

        EObject lv_funcExpr_14_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 102) ) { return current; }
            // InternalBeeLangTestLanguage.g:5016:2: ( ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) ) )
            // InternalBeeLangTestLanguage.g:5017:2: ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) )
            {
            // InternalBeeLangTestLanguage.g:5017:2: ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) )
            // InternalBeeLangTestLanguage.g:5018:3: () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) )
            {
            // InternalBeeLangTestLanguage.g:5018:3: ()
            // InternalBeeLangTestLanguage.g:5019:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getClosureExpressionAccess().getFunctionAction_0(),
              					current);
              			
            }

            }

            // InternalBeeLangTestLanguage.g:5028:3: (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==52) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:5029:4: otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>'
                    {
                    otherlv_1=(Token)match(input,52,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getClosureExpressionAccess().getLessThanSignKeyword_1_0());
                      			
                    }
                    // InternalBeeLangTestLanguage.g:5033:4: ( (lv_returnType_2_0= ruleTypeRef ) )
                    // InternalBeeLangTestLanguage.g:5034:5: (lv_returnType_2_0= ruleTypeRef )
                    {
                    // InternalBeeLangTestLanguage.g:5034:5: (lv_returnType_2_0= ruleTypeRef )
                    // InternalBeeLangTestLanguage.g:5035:6: lv_returnType_2_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getClosureExpressionAccess().getReturnTypeTypeRefParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_71);
                    lv_returnType_2_0=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getClosureExpressionRule());
                      						}
                      						set(
                      							current,
                      							"returnType",
                      							lv_returnType_2_0,
                      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.TypeRef");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,51,FOLLOW_72); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getClosureExpressionAccess().getGreaterThanSignKeyword_1_2());
                      			
                    }

                    }
                    break;

            }

            // InternalBeeLangTestLanguage.g:5057:3: ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )?
            int alt90=3;
            alt90 = dfa90.predict(input);
            switch (alt90) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:5058:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
                    {
                    // InternalBeeLangTestLanguage.g:5058:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
                    // InternalBeeLangTestLanguage.g:5059:5: (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
                    {
                    // InternalBeeLangTestLanguage.g:5059:5: (otherlv_4= '|' )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==77) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // InternalBeeLangTestLanguage.g:5060:6: otherlv_4= '|'
                            {
                            otherlv_4=(Token)match(input,77,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_4, grammarAccess.getClosureExpressionAccess().getVerticalLineKeyword_2_0_0());
                              					
                            }

                            }
                            break;

                    }

                    // InternalBeeLangTestLanguage.g:5065:5: ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
                    // InternalBeeLangTestLanguage.g:5066:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
                    {
                    // InternalBeeLangTestLanguage.g:5066:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) )
                    // InternalBeeLangTestLanguage.g:5067:7: (lv_parameters_5_0= ruleParameterDeclaration )
                    {
                    // InternalBeeLangTestLanguage.g:5067:7: (lv_parameters_5_0= ruleParameterDeclaration )
                    // InternalBeeLangTestLanguage.g:5068:8: lv_parameters_5_0= ruleParameterDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      								newCompositeNode(grammarAccess.getClosureExpressionAccess().getParametersParameterDeclarationParserRuleCall_2_0_1_0_0());
                      							
                    }
                    pushFollow(FOLLOW_73);
                    lv_parameters_5_0=ruleParameterDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElementForParent(grammarAccess.getClosureExpressionRule());
                      								}
                      								add(
                      									current,
                      									"parameters",
                      									lv_parameters_5_0,
                      									"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterDeclaration");
                      								afterParserOrEnumRuleCall();
                      							
                    }

                    }


                    }

                    // InternalBeeLangTestLanguage.g:5085:6: (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )*
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
                    	    // InternalBeeLangTestLanguage.g:5086:7: otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) )
                    	    {
                    	    otherlv_6=(Token)match(input,16,FOLLOW_35); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_6, grammarAccess.getClosureExpressionAccess().getCommaKeyword_2_0_1_1_0());
                    	      						
                    	    }
                    	    // InternalBeeLangTestLanguage.g:5090:7: ( (lv_parameters_7_0= ruleParameterDeclaration ) )
                    	    // InternalBeeLangTestLanguage.g:5091:8: (lv_parameters_7_0= ruleParameterDeclaration )
                    	    {
                    	    // InternalBeeLangTestLanguage.g:5091:8: (lv_parameters_7_0= ruleParameterDeclaration )
                    	    // InternalBeeLangTestLanguage.g:5092:9: lv_parameters_7_0= ruleParameterDeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      									newCompositeNode(grammarAccess.getClosureExpressionAccess().getParametersParameterDeclarationParserRuleCall_2_0_1_1_1_0());
                    	      								
                    	    }
                    	    pushFollow(FOLLOW_73);
                    	    lv_parameters_7_0=ruleParameterDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      									if (current==null) {
                    	      										current = createModelElementForParent(grammarAccess.getClosureExpressionRule());
                    	      									}
                    	      									add(
                    	      										current,
                    	      										"parameters",
                    	      										lv_parameters_7_0,
                    	      										"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterDeclaration");
                    	      									afterParserOrEnumRuleCall();
                    	      								
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop88;
                        }
                    } while (true);

                    // InternalBeeLangTestLanguage.g:5110:6: (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==16) ) {
                        alt89=1;
                    }
                    switch (alt89) {
                        case 1 :
                            // InternalBeeLangTestLanguage.g:5111:7: otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                            {
                            otherlv_8=(Token)match(input,16,FOLLOW_36); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_8, grammarAccess.getClosureExpressionAccess().getCommaKeyword_2_0_1_2_0());
                              						
                            }
                            // InternalBeeLangTestLanguage.g:5115:7: ( (lv_varArgs_9_0= '...' ) )
                            // InternalBeeLangTestLanguage.g:5116:8: (lv_varArgs_9_0= '...' )
                            {
                            // InternalBeeLangTestLanguage.g:5116:8: (lv_varArgs_9_0= '...' )
                            // InternalBeeLangTestLanguage.g:5117:9: lv_varArgs_9_0= '...'
                            {
                            lv_varArgs_9_0=(Token)match(input,36,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									newLeafNode(lv_varArgs_9_0, grammarAccess.getClosureExpressionAccess().getVarArgsFullStopFullStopFullStopKeyword_2_0_1_2_1_0());
                              								
                            }
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElement(grammarAccess.getClosureExpressionRule());
                              									}
                              									setWithLastConsumed(current, "varArgs", true, "...");
                              								
                            }

                            }


                            }

                            // InternalBeeLangTestLanguage.g:5129:7: ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                            // InternalBeeLangTestLanguage.g:5130:8: (lv_parameters_10_0= ruleParameterDeclaration )
                            {
                            // InternalBeeLangTestLanguage.g:5130:8: (lv_parameters_10_0= ruleParameterDeclaration )
                            // InternalBeeLangTestLanguage.g:5131:9: lv_parameters_10_0= ruleParameterDeclaration
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getClosureExpressionAccess().getParametersParameterDeclarationParserRuleCall_2_0_1_2_2_0());
                              								
                            }
                            pushFollow(FOLLOW_74);
                            lv_parameters_10_0=ruleParameterDeclaration();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getClosureExpressionRule());
                              									}
                              									add(
                              										current,
                              										"parameters",
                              										lv_parameters_10_0,
                              										"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterDeclaration");
                              									afterParserOrEnumRuleCall();
                              								
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
                    // InternalBeeLangTestLanguage.g:5152:4: ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )
                    {
                    // InternalBeeLangTestLanguage.g:5152:4: ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )
                    // InternalBeeLangTestLanguage.g:5153:5: ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                    {
                    // InternalBeeLangTestLanguage.g:5153:5: ( (lv_varArgs_11_0= '...' ) )
                    // InternalBeeLangTestLanguage.g:5154:6: (lv_varArgs_11_0= '...' )
                    {
                    // InternalBeeLangTestLanguage.g:5154:6: (lv_varArgs_11_0= '...' )
                    // InternalBeeLangTestLanguage.g:5155:7: lv_varArgs_11_0= '...'
                    {
                    lv_varArgs_11_0=(Token)match(input,36,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_varArgs_11_0, grammarAccess.getClosureExpressionAccess().getVarArgsFullStopFullStopFullStopKeyword_2_1_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getClosureExpressionRule());
                      							}
                      							setWithLastConsumed(current, "varArgs", true, "...");
                      						
                    }

                    }


                    }

                    // InternalBeeLangTestLanguage.g:5167:5: ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                    // InternalBeeLangTestLanguage.g:5168:6: (lv_parameters_12_0= ruleParameterDeclaration )
                    {
                    // InternalBeeLangTestLanguage.g:5168:6: (lv_parameters_12_0= ruleParameterDeclaration )
                    // InternalBeeLangTestLanguage.g:5169:7: lv_parameters_12_0= ruleParameterDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getClosureExpressionAccess().getParametersParameterDeclarationParserRuleCall_2_1_1_0());
                      						
                    }
                    pushFollow(FOLLOW_74);
                    lv_parameters_12_0=ruleParameterDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getClosureExpressionRule());
                      							}
                      							add(
                      								current,
                      								"parameters",
                      								lv_parameters_12_0,
                      								"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterDeclaration");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,77,FOLLOW_64); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_13, grammarAccess.getClosureExpressionAccess().getVerticalLineKeyword_3());
              		
            }
            // InternalBeeLangTestLanguage.g:5192:3: ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) )
            // InternalBeeLangTestLanguage.g:5193:4: (lv_funcExpr_14_0= ruleOneOrManyExpressions )
            {
            // InternalBeeLangTestLanguage.g:5193:4: (lv_funcExpr_14_0= ruleOneOrManyExpressions )
            // InternalBeeLangTestLanguage.g:5194:5: lv_funcExpr_14_0= ruleOneOrManyExpressions
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getClosureExpressionAccess().getFuncExprOneOrManyExpressionsParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_funcExpr_14_0=ruleOneOrManyExpressions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getClosureExpressionRule());
              					}
              					set(
              						current,
              						"funcExpr",
              						lv_funcExpr_14_0,
              						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.OneOrManyExpressions");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 102, ruleClosureExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleClosureExpression"


    // $ANTLR start "entryRuleOneOrManyExpressions"
    // InternalBeeLangTestLanguage.g:5215:1: entryRuleOneOrManyExpressions returns [EObject current=null] : iv_ruleOneOrManyExpressions= ruleOneOrManyExpressions EOF ;
    public final EObject entryRuleOneOrManyExpressions() throws RecognitionException {
        EObject current = null;
        int entryRuleOneOrManyExpressions_StartIndex = input.index();
        EObject iv_ruleOneOrManyExpressions = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 103) ) { return current; }
            // InternalBeeLangTestLanguage.g:5215:61: (iv_ruleOneOrManyExpressions= ruleOneOrManyExpressions EOF )
            // InternalBeeLangTestLanguage.g:5216:2: iv_ruleOneOrManyExpressions= ruleOneOrManyExpressions EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOneOrManyExpressionsRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 103, entryRuleOneOrManyExpressions_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleOneOrManyExpressions"


    // $ANTLR start "ruleOneOrManyExpressions"
    // InternalBeeLangTestLanguage.g:5222:1: ruleOneOrManyExpressions returns [EObject current=null] : (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression ) ;
    public final EObject ruleOneOrManyExpressions() throws RecognitionException {
        EObject current = null;
        int ruleOneOrManyExpressions_StartIndex = input.index();
        EObject this_BlockExpressionWithoutBrackets_0 = null;

        EObject this_Expression_1 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 104) ) { return current; }
            // InternalBeeLangTestLanguage.g:5228:2: ( (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression ) )
            // InternalBeeLangTestLanguage.g:5229:2: (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression )
            {
            // InternalBeeLangTestLanguage.g:5229:2: (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression )
            int alt91=2;
            alt91 = dfa91.predict(input);
            switch (alt91) {
                case 1 :
                    // InternalBeeLangTestLanguage.g:5230:3: this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOneOrManyExpressionsAccess().getBlockExpressionWithoutBracketsParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BlockExpressionWithoutBrackets_0=ruleBlockExpressionWithoutBrackets();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BlockExpressionWithoutBrackets_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBeeLangTestLanguage.g:5242:3: this_Expression_1= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOneOrManyExpressionsAccess().getExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Expression_1=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Expression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 104, ruleOneOrManyExpressions_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleOneOrManyExpressions"


    // $ANTLR start "entryRuleBlockExpressionWithoutBrackets"
    // InternalBeeLangTestLanguage.g:5257:1: entryRuleBlockExpressionWithoutBrackets returns [EObject current=null] : iv_ruleBlockExpressionWithoutBrackets= ruleBlockExpressionWithoutBrackets EOF ;
    public final EObject entryRuleBlockExpressionWithoutBrackets() throws RecognitionException {
        EObject current = null;
        int entryRuleBlockExpressionWithoutBrackets_StartIndex = input.index();
        EObject iv_ruleBlockExpressionWithoutBrackets = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 105) ) { return current; }
            // InternalBeeLangTestLanguage.g:5257:71: (iv_ruleBlockExpressionWithoutBrackets= ruleBlockExpressionWithoutBrackets EOF )
            // InternalBeeLangTestLanguage.g:5258:2: iv_ruleBlockExpressionWithoutBrackets= ruleBlockExpressionWithoutBrackets EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlockExpressionWithoutBracketsRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 105, entryRuleBlockExpressionWithoutBrackets_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleBlockExpressionWithoutBrackets"


    // $ANTLR start "ruleBlockExpressionWithoutBrackets"
    // InternalBeeLangTestLanguage.g:5264:1: ruleBlockExpressionWithoutBrackets returns [EObject current=null] : ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ ) ;
    public final EObject ruleBlockExpressionWithoutBrackets() throws RecognitionException {
        EObject current = null;
        int ruleBlockExpressionWithoutBrackets_StartIndex = input.index();
        Token otherlv_2=null;
        EObject lv_expressions_1_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 106) ) { return current; }
            // InternalBeeLangTestLanguage.g:5270:2: ( ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ ) )
            // InternalBeeLangTestLanguage.g:5271:2: ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ )
            {
            // InternalBeeLangTestLanguage.g:5271:2: ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ )
            // InternalBeeLangTestLanguage.g:5272:3: () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+
            {
            // InternalBeeLangTestLanguage.g:5272:3: ()
            // InternalBeeLangTestLanguage.g:5273:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBlockExpressionWithoutBracketsAccess().getChainedExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalBeeLangTestLanguage.g:5282:3: ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+
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
            	    // InternalBeeLangTestLanguage.g:5283:4: ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';'
            	    {
            	    // InternalBeeLangTestLanguage.g:5283:4: ( (lv_expressions_1_0= ruleTopLevelExpression ) )
            	    // InternalBeeLangTestLanguage.g:5284:5: (lv_expressions_1_0= ruleTopLevelExpression )
            	    {
            	    // InternalBeeLangTestLanguage.g:5284:5: (lv_expressions_1_0= ruleTopLevelExpression )
            	    // InternalBeeLangTestLanguage.g:5285:6: lv_expressions_1_0= ruleTopLevelExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBlockExpressionWithoutBracketsAccess().getExpressionsTopLevelExpressionParserRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_expressions_1_0=ruleTopLevelExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBlockExpressionWithoutBracketsRule());
            	      						}
            	      						add(
            	      							current,
            	      							"expressions",
            	      							lv_expressions_1_0,
            	      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.TopLevelExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    otherlv_2=(Token)match(input,20,FOLLOW_75); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getBlockExpressionWithoutBracketsAccess().getSemicolonKeyword_1_1());
            	      			
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 106, ruleBlockExpressionWithoutBrackets_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleBlockExpressionWithoutBrackets"


    // $ANTLR start "entryRuleValueLiteral"
    // InternalBeeLangTestLanguage.g:5311:1: entryRuleValueLiteral returns [EObject current=null] : iv_ruleValueLiteral= ruleValueLiteral EOF ;
    public final EObject entryRuleValueLiteral() throws RecognitionException {
        EObject current = null;
        int entryRuleValueLiteral_StartIndex = input.index();
        EObject iv_ruleValueLiteral = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 107) ) { return current; }
            // InternalBeeLangTestLanguage.g:5311:53: (iv_ruleValueLiteral= ruleValueLiteral EOF )
            // InternalBeeLangTestLanguage.g:5312:2: iv_ruleValueLiteral= ruleValueLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueLiteralRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 107, entryRuleValueLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleValueLiteral"


    // $ANTLR start "ruleValueLiteral"
    // InternalBeeLangTestLanguage.g:5318:1: ruleValueLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleValueLiteral() throws RecognitionException {
        EObject current = null;
        int ruleValueLiteral_StartIndex = input.index();
        Token lv_value_0_0=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 108) ) { return current; }
            // InternalBeeLangTestLanguage.g:5324:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalBeeLangTestLanguage.g:5325:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalBeeLangTestLanguage.g:5325:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalBeeLangTestLanguage.g:5326:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalBeeLangTestLanguage.g:5326:3: (lv_value_0_0= RULE_STRING )
            // InternalBeeLangTestLanguage.g:5327:4: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_value_0_0, grammarAccess.getValueLiteralAccess().getValueSTRINGTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getValueLiteralRule());
              				}
              				setWithLastConsumed(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.eclipse.xtext.common.Terminals.STRING");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 108, ruleValueLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleValueLiteral"


    // $ANTLR start "entryRuleParanthesizedExpression"
    // InternalBeeLangTestLanguage.g:5346:1: entryRuleParanthesizedExpression returns [EObject current=null] : iv_ruleParanthesizedExpression= ruleParanthesizedExpression EOF ;
    public final EObject entryRuleParanthesizedExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleParanthesizedExpression_StartIndex = input.index();
        EObject iv_ruleParanthesizedExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 109) ) { return current; }
            // InternalBeeLangTestLanguage.g:5346:64: (iv_ruleParanthesizedExpression= ruleParanthesizedExpression EOF )
            // InternalBeeLangTestLanguage.g:5347:2: iv_ruleParanthesizedExpression= ruleParanthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParanthesizedExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 109, entryRuleParanthesizedExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleParanthesizedExpression"


    // $ANTLR start "ruleParanthesizedExpression"
    // InternalBeeLangTestLanguage.g:5353:1: ruleParanthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) ;
    public final EObject ruleParanthesizedExpression() throws RecognitionException {
        EObject current = null;
        int ruleParanthesizedExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Expression_1 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 110) ) { return current; }
            // InternalBeeLangTestLanguage.g:5359:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) )
            // InternalBeeLangTestLanguage.g:5360:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            {
            // InternalBeeLangTestLanguage.g:5360:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            // InternalBeeLangTestLanguage.g:5361:3: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParanthesizedExpressionAccess().getLeftParenthesisKeyword_0());
              		
            }
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getParanthesizedExpressionAccess().getExpressionParserRuleCall_1());
              		
            }
            pushFollow(FOLLOW_37);
            this_Expression_1=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Expression_1;
              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_2=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getParanthesizedExpressionAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 110, ruleParanthesizedExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleParanthesizedExpression"


    // $ANTLR start "entryRuleQID"
    // InternalBeeLangTestLanguage.g:5384:1: entryRuleQID returns [String current=null] : iv_ruleQID= ruleQID EOF ;
    public final String entryRuleQID() throws RecognitionException {
        String current = null;
        int entryRuleQID_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleQID = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 111) ) { return current; }
            // InternalBeeLangTestLanguage.g:5386:2: (iv_ruleQID= ruleQID EOF )
            // InternalBeeLangTestLanguage.g:5387:2: iv_ruleQID= ruleQID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQIDRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQID=ruleQID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQID.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 111, entryRuleQID_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleQID"


    // $ANTLR start "ruleQID"
    // InternalBeeLangTestLanguage.g:5396:1: ruleQID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* ) ;
    public final AntlrDatatypeRuleToken ruleQID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
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


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 112) ) { return current; }
            // InternalBeeLangTestLanguage.g:5403:2: ( (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* ) )
            // InternalBeeLangTestLanguage.g:5404:2: (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* )
            {
            // InternalBeeLangTestLanguage.g:5404:2: (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* )
            // InternalBeeLangTestLanguage.g:5405:3: this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_76); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getQIDAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalBeeLangTestLanguage.g:5412:3: (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )*
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
            	    // InternalBeeLangTestLanguage.g:5413:4: this_INT_1= RULE_INT
            	    {
            	    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_76); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_INT_1);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_INT_1, grammarAccess.getQIDAccess().getINTTerminalRuleCall_1_0());
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // InternalBeeLangTestLanguage.g:5421:4: this_HEX_2= RULE_HEX
            	    {
            	    this_HEX_2=(Token)match(input,RULE_HEX,FOLLOW_76); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_HEX_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_HEX_2, grammarAccess.getQIDAccess().getHEXTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;
            	case 3 :
            	    // InternalBeeLangTestLanguage.g:5429:4: this_ID_3= RULE_ID
            	    {
            	    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_76); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_3);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_3, grammarAccess.getQIDAccess().getIDTerminalRuleCall_1_2());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop93;
                }
            } while (true);

            // InternalBeeLangTestLanguage.g:5437:3: (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==67) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // InternalBeeLangTestLanguage.g:5438:4: kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )*
            	    {
            	    kw=(Token)match(input,67,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getQIDAccess().getFullStopKeyword_2_0());
            	      			
            	    }
            	    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_76); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_5);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_5, grammarAccess.getQIDAccess().getIDTerminalRuleCall_2_1());
            	      			
            	    }
            	    // InternalBeeLangTestLanguage.g:5450:4: (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )*
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
            	    	    // InternalBeeLangTestLanguage.g:5451:5: this_INT_6= RULE_INT
            	    	    {
            	    	    this_INT_6=(Token)match(input,RULE_INT,FOLLOW_76); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      					current.merge(this_INT_6);
            	    	      				
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      					newLeafNode(this_INT_6, grammarAccess.getQIDAccess().getINTTerminalRuleCall_2_2_0());
            	    	      				
            	    	    }

            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // InternalBeeLangTestLanguage.g:5459:5: this_HEX_7= RULE_HEX
            	    	    {
            	    	    this_HEX_7=(Token)match(input,RULE_HEX,FOLLOW_76); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      					current.merge(this_HEX_7);
            	    	      				
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      					newLeafNode(this_HEX_7, grammarAccess.getQIDAccess().getHEXTerminalRuleCall_2_2_1());
            	    	      				
            	    	    }

            	    	    }
            	    	    break;
            	    	case 3 :
            	    	    // InternalBeeLangTestLanguage.g:5467:5: this_ID_8= RULE_ID
            	    	    {
            	    	    this_ID_8=(Token)match(input,RULE_ID,FOLLOW_76); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      					current.merge(this_ID_8);
            	    	      				
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      					newLeafNode(this_ID_8, grammarAccess.getQIDAccess().getIDTerminalRuleCall_2_2_2());
            	    	      				
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 112, ruleQID_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleQID"

    // $ANTLR start synpred2_InternalBeeLangTestLanguage
    public final void synpred2_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        EObject lv_units_0_0 = null;


        // InternalBeeLangTestLanguage.g:87:3: ( ( (lv_units_0_0= ruleUnit ) )* )
        // InternalBeeLangTestLanguage.g:87:3: ( (lv_units_0_0= ruleUnit ) )*
        {
        // InternalBeeLangTestLanguage.g:87:3: ( (lv_units_0_0= ruleUnit ) )*
        loop96:
        do {
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==RULE_DOCUMENTATION||LA96_0==13) ) {
                alt96=1;
            }


            switch (alt96) {
        	case 1 :
        	    // InternalBeeLangTestLanguage.g:88:4: (lv_units_0_0= ruleUnit )
        	    {
        	    // InternalBeeLangTestLanguage.g:88:4: (lv_units_0_0= ruleUnit )
        	    // InternalBeeLangTestLanguage.g:89:5: lv_units_0_0= ruleUnit
        	    {
        	    if ( state.backtracking==0 ) {

        	      					newCompositeNode(grammarAccess.getModelAccess().getUnitsUnitParserRuleCall_0_0());
        	      				
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
    // $ANTLR end synpred2_InternalBeeLangTestLanguage

    // $ANTLR start synpred9_InternalBeeLangTestLanguage
    public final void synpred9_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        AntlrDatatypeRuleToken lv_sourceLocation_14_0 = null;


        // InternalBeeLangTestLanguage.g:290:4: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) )
        // InternalBeeLangTestLanguage.g:290:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
        {
        // InternalBeeLangTestLanguage.g:290:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
        // InternalBeeLangTestLanguage.g:291:5: {...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_InternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0)");
        }
        // InternalBeeLangTestLanguage.g:291:101: ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
        // InternalBeeLangTestLanguage.g:292:6: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0);
        // InternalBeeLangTestLanguage.g:295:9: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
        // InternalBeeLangTestLanguage.g:295:10: {...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_InternalBeeLangTestLanguage", "true");
        }
        // InternalBeeLangTestLanguage.g:295:19: (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
        // InternalBeeLangTestLanguage.g:295:20: otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';'
        {
        otherlv_12=(Token)match(input,18,FOLLOW_12); if (state.failed) return ;
        otherlv_13=(Token)match(input,19,FOLLOW_13); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:303:9: ( (lv_sourceLocation_14_0= rulePath ) )
        // InternalBeeLangTestLanguage.g:304:10: (lv_sourceLocation_14_0= rulePath )
        {
        // InternalBeeLangTestLanguage.g:304:10: (lv_sourceLocation_14_0= rulePath )
        // InternalBeeLangTestLanguage.g:305:11: lv_sourceLocation_14_0= rulePath
        {
        if ( state.backtracking==0 ) {

          											newCompositeNode(grammarAccess.getUnitAccess().getSourceLocationPathParserRuleCall_7_0_2_0());
          										
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
    // $ANTLR end synpred9_InternalBeeLangTestLanguage

    // $ANTLR start synpred10_InternalBeeLangTestLanguage
    public final void synpred10_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        AntlrDatatypeRuleToken lv_outputLocation_18_0 = null;


        // InternalBeeLangTestLanguage.g:332:4: ( ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) )
        // InternalBeeLangTestLanguage.g:332:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
        {
        // InternalBeeLangTestLanguage.g:332:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
        // InternalBeeLangTestLanguage.g:333:5: {...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_InternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1)");
        }
        // InternalBeeLangTestLanguage.g:333:101: ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
        // InternalBeeLangTestLanguage.g:334:6: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1);
        // InternalBeeLangTestLanguage.g:337:9: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
        // InternalBeeLangTestLanguage.g:337:10: {...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_InternalBeeLangTestLanguage", "true");
        }
        // InternalBeeLangTestLanguage.g:337:19: (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
        // InternalBeeLangTestLanguage.g:337:20: otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';'
        {
        otherlv_16=(Token)match(input,21,FOLLOW_12); if (state.failed) return ;
        otherlv_17=(Token)match(input,19,FOLLOW_13); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:345:9: ( (lv_outputLocation_18_0= rulePath ) )
        // InternalBeeLangTestLanguage.g:346:10: (lv_outputLocation_18_0= rulePath )
        {
        // InternalBeeLangTestLanguage.g:346:10: (lv_outputLocation_18_0= rulePath )
        // InternalBeeLangTestLanguage.g:347:11: lv_outputLocation_18_0= rulePath
        {
        if ( state.backtracking==0 ) {

          											newCompositeNode(grammarAccess.getUnitAccess().getOutputLocationPathParserRuleCall_7_1_2_0());
          										
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
    // $ANTLR end synpred10_InternalBeeLangTestLanguage

    // $ANTLR start synpred11_InternalBeeLangTestLanguage
    public final void synpred11_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        EObject lv_providedCapabilities_22_0 = null;


        // InternalBeeLangTestLanguage.g:379:10: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )
        // InternalBeeLangTestLanguage.g:379:10: {...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred11_InternalBeeLangTestLanguage", "true");
        }
        // InternalBeeLangTestLanguage.g:379:19: (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        // InternalBeeLangTestLanguage.g:379:20: otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';'
        {
        otherlv_20=(Token)match(input,22,FOLLOW_12); if (state.failed) return ;
        otherlv_21=(Token)match(input,19,FOLLOW_15); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:387:9: ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) )
        // InternalBeeLangTestLanguage.g:388:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        {
        // InternalBeeLangTestLanguage.g:388:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        // InternalBeeLangTestLanguage.g:389:11: lv_providedCapabilities_22_0= ruleProvidedCapability
        {
        if ( state.backtracking==0 ) {

          											newCompositeNode(grammarAccess.getUnitAccess().getProvidedCapabilitiesProvidedCapabilityParserRuleCall_7_2_2_0());
          										
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
    // $ANTLR end synpred11_InternalBeeLangTestLanguage

    // $ANTLR start synpred12_InternalBeeLangTestLanguage
    public final void synpred12_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        EObject lv_providedCapabilities_22_0 = null;


        // InternalBeeLangTestLanguage.g:374:4: ( ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) )
        // InternalBeeLangTestLanguage.g:374:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
        {
        // InternalBeeLangTestLanguage.g:374:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
        // InternalBeeLangTestLanguage.g:375:5: {...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred12_InternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2)");
        }
        // InternalBeeLangTestLanguage.g:375:101: ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
        // InternalBeeLangTestLanguage.g:376:6: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2);
        // InternalBeeLangTestLanguage.g:379:9: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
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
        	    // InternalBeeLangTestLanguage.g:379:10: {...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred12_InternalBeeLangTestLanguage", "true");
        	    }
        	    // InternalBeeLangTestLanguage.g:379:19: (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        	    // InternalBeeLangTestLanguage.g:379:20: otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';'
        	    {
        	    otherlv_20=(Token)match(input,22,FOLLOW_12); if (state.failed) return ;
        	    otherlv_21=(Token)match(input,19,FOLLOW_15); if (state.failed) return ;
        	    // InternalBeeLangTestLanguage.g:387:9: ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) )
        	    // InternalBeeLangTestLanguage.g:388:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        	    {
        	    // InternalBeeLangTestLanguage.g:388:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        	    // InternalBeeLangTestLanguage.g:389:11: lv_providedCapabilities_22_0= ruleProvidedCapability
        	    {
        	    if ( state.backtracking==0 ) {

        	      											newCompositeNode(grammarAccess.getUnitAccess().getProvidedCapabilitiesProvidedCapabilityParserRuleCall_7_2_2_0());
        	      										
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
    // $ANTLR end synpred12_InternalBeeLangTestLanguage

    // $ANTLR start synpred13_InternalBeeLangTestLanguage
    public final void synpred13_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        EObject lv_requiredCapabilities_26_0 = null;


        // InternalBeeLangTestLanguage.g:421:10: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )
        // InternalBeeLangTestLanguage.g:421:10: {...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred13_InternalBeeLangTestLanguage", "true");
        }
        // InternalBeeLangTestLanguage.g:421:19: (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        // InternalBeeLangTestLanguage.g:421:20: otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';'
        {
        otherlv_24=(Token)match(input,23,FOLLOW_12); if (state.failed) return ;
        otherlv_25=(Token)match(input,19,FOLLOW_15); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:429:9: ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) )
        // InternalBeeLangTestLanguage.g:430:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        {
        // InternalBeeLangTestLanguage.g:430:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        // InternalBeeLangTestLanguage.g:431:11: lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability
        {
        if ( state.backtracking==0 ) {

          											newCompositeNode(grammarAccess.getUnitAccess().getRequiredCapabilitiesAliasedRequiredCapabilityParserRuleCall_7_3_2_0());
          										
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
    // $ANTLR end synpred13_InternalBeeLangTestLanguage

    // $ANTLR start synpred14_InternalBeeLangTestLanguage
    public final void synpred14_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        EObject lv_requiredCapabilities_26_0 = null;


        // InternalBeeLangTestLanguage.g:416:4: ( ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) )
        // InternalBeeLangTestLanguage.g:416:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
        {
        // InternalBeeLangTestLanguage.g:416:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
        // InternalBeeLangTestLanguage.g:417:5: {...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred14_InternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3)");
        }
        // InternalBeeLangTestLanguage.g:417:101: ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
        // InternalBeeLangTestLanguage.g:418:6: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3);
        // InternalBeeLangTestLanguage.g:421:9: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
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
        	    // InternalBeeLangTestLanguage.g:421:10: {...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred14_InternalBeeLangTestLanguage", "true");
        	    }
        	    // InternalBeeLangTestLanguage.g:421:19: (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        	    // InternalBeeLangTestLanguage.g:421:20: otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';'
        	    {
        	    otherlv_24=(Token)match(input,23,FOLLOW_12); if (state.failed) return ;
        	    otherlv_25=(Token)match(input,19,FOLLOW_15); if (state.failed) return ;
        	    // InternalBeeLangTestLanguage.g:429:9: ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) )
        	    // InternalBeeLangTestLanguage.g:430:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        	    {
        	    // InternalBeeLangTestLanguage.g:430:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        	    // InternalBeeLangTestLanguage.g:431:11: lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability
        	    {
        	    if ( state.backtracking==0 ) {

        	      											newCompositeNode(grammarAccess.getUnitAccess().getRequiredCapabilitiesAliasedRequiredCapabilityParserRuleCall_7_3_2_0());
        	      										
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
    // $ANTLR end synpred14_InternalBeeLangTestLanguage

    // $ANTLR start synpred15_InternalBeeLangTestLanguage
    public final void synpred15_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        EObject lv_metaRequiredCapabilities_31_0 = null;


        // InternalBeeLangTestLanguage.g:463:10: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )
        // InternalBeeLangTestLanguage.g:463:10: {...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred15_InternalBeeLangTestLanguage", "true");
        }
        // InternalBeeLangTestLanguage.g:463:19: (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        // InternalBeeLangTestLanguage.g:463:20: otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';'
        {
        otherlv_28=(Token)match(input,23,FOLLOW_16); if (state.failed) return ;
        otherlv_29=(Token)match(input,24,FOLLOW_12); if (state.failed) return ;
        otherlv_30=(Token)match(input,19,FOLLOW_15); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:475:9: ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) )
        // InternalBeeLangTestLanguage.g:476:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        {
        // InternalBeeLangTestLanguage.g:476:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        // InternalBeeLangTestLanguage.g:477:11: lv_metaRequiredCapabilities_31_0= ruleRequiredCapability
        {
        if ( state.backtracking==0 ) {

          											newCompositeNode(grammarAccess.getUnitAccess().getMetaRequiredCapabilitiesRequiredCapabilityParserRuleCall_7_4_3_0());
          										
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
    // $ANTLR end synpred15_InternalBeeLangTestLanguage

    // $ANTLR start synpred16_InternalBeeLangTestLanguage
    public final void synpred16_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        EObject lv_metaRequiredCapabilities_31_0 = null;


        // InternalBeeLangTestLanguage.g:458:4: ( ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) )
        // InternalBeeLangTestLanguage.g:458:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
        {
        // InternalBeeLangTestLanguage.g:458:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
        // InternalBeeLangTestLanguage.g:459:5: {...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred16_InternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4)");
        }
        // InternalBeeLangTestLanguage.g:459:101: ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
        // InternalBeeLangTestLanguage.g:460:6: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4);
        // InternalBeeLangTestLanguage.g:463:9: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
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
        	    // InternalBeeLangTestLanguage.g:463:10: {...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred16_InternalBeeLangTestLanguage", "true");
        	    }
        	    // InternalBeeLangTestLanguage.g:463:19: (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        	    // InternalBeeLangTestLanguage.g:463:20: otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';'
        	    {
        	    otherlv_28=(Token)match(input,23,FOLLOW_16); if (state.failed) return ;
        	    otherlv_29=(Token)match(input,24,FOLLOW_12); if (state.failed) return ;
        	    otherlv_30=(Token)match(input,19,FOLLOW_15); if (state.failed) return ;
        	    // InternalBeeLangTestLanguage.g:475:9: ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) )
        	    // InternalBeeLangTestLanguage.g:476:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        	    {
        	    // InternalBeeLangTestLanguage.g:476:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        	    // InternalBeeLangTestLanguage.g:477:11: lv_metaRequiredCapabilities_31_0= ruleRequiredCapability
        	    {
        	    if ( state.backtracking==0 ) {

        	      											newCompositeNode(grammarAccess.getUnitAccess().getMetaRequiredCapabilitiesRequiredCapabilityParserRuleCall_7_4_3_0());
        	      										
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
    // $ANTLR end synpred16_InternalBeeLangTestLanguage

    // $ANTLR start synpred17_InternalBeeLangTestLanguage
    public final void synpred17_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        EObject lv_functions_33_0 = null;


        // InternalBeeLangTestLanguage.g:509:10: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )
        // InternalBeeLangTestLanguage.g:509:10: {...}? => ( (lv_functions_33_0= ruleFunction ) )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred17_InternalBeeLangTestLanguage", "true");
        }
        // InternalBeeLangTestLanguage.g:509:19: ( (lv_functions_33_0= ruleFunction ) )
        // InternalBeeLangTestLanguage.g:509:20: (lv_functions_33_0= ruleFunction )
        {
        // InternalBeeLangTestLanguage.g:509:20: (lv_functions_33_0= ruleFunction )
        // InternalBeeLangTestLanguage.g:510:10: lv_functions_33_0= ruleFunction
        {
        if ( state.backtracking==0 ) {

          										newCompositeNode(grammarAccess.getUnitAccess().getFunctionsFunctionParserRuleCall_7_5_0());
          									
        }
        pushFollow(FOLLOW_2);
        lv_functions_33_0=ruleFunction();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred17_InternalBeeLangTestLanguage

    // $ANTLR start synpred18_InternalBeeLangTestLanguage
    public final void synpred18_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        EObject lv_functions_33_0 = null;


        // InternalBeeLangTestLanguage.g:504:4: ( ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )
        // InternalBeeLangTestLanguage.g:504:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
        {
        // InternalBeeLangTestLanguage.g:504:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
        // InternalBeeLangTestLanguage.g:505:5: {...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred18_InternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5)");
        }
        // InternalBeeLangTestLanguage.g:505:101: ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
        // InternalBeeLangTestLanguage.g:506:6: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5);
        // InternalBeeLangTestLanguage.g:509:9: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
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
        	    // InternalBeeLangTestLanguage.g:509:10: {...}? => ( (lv_functions_33_0= ruleFunction ) )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred18_InternalBeeLangTestLanguage", "true");
        	    }
        	    // InternalBeeLangTestLanguage.g:509:19: ( (lv_functions_33_0= ruleFunction ) )
        	    // InternalBeeLangTestLanguage.g:509:20: (lv_functions_33_0= ruleFunction )
        	    {
        	    // InternalBeeLangTestLanguage.g:509:20: (lv_functions_33_0= ruleFunction )
        	    // InternalBeeLangTestLanguage.g:510:10: lv_functions_33_0= ruleFunction
        	    {
        	    if ( state.backtracking==0 ) {

        	      										newCompositeNode(grammarAccess.getUnitAccess().getFunctionsFunctionParserRuleCall_7_5_0());
        	      									
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
    // $ANTLR end synpred18_InternalBeeLangTestLanguage

    // $ANTLR start synpred20_InternalBeeLangTestLanguage
    public final void synpred20_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_condExpr_7_0 = null;


        // InternalBeeLangTestLanguage.g:622:5: ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) )
        // InternalBeeLangTestLanguage.g:622:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
        {
        // InternalBeeLangTestLanguage.g:622:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
        // InternalBeeLangTestLanguage.g:623:6: {...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred20_InternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0)");
        }
        // InternalBeeLangTestLanguage.g:623:118: ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
        // InternalBeeLangTestLanguage.g:624:7: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0);
        // InternalBeeLangTestLanguage.g:627:10: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
        // InternalBeeLangTestLanguage.g:627:11: {...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred20_InternalBeeLangTestLanguage", "true");
        }
        // InternalBeeLangTestLanguage.g:627:20: (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
        // InternalBeeLangTestLanguage.g:627:21: otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';'
        {
        otherlv_5=(Token)match(input,26,FOLLOW_12); if (state.failed) return ;
        otherlv_6=(Token)match(input,19,FOLLOW_19); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:635:10: ( (lv_condExpr_7_0= ruleExpression ) )
        // InternalBeeLangTestLanguage.g:636:11: (lv_condExpr_7_0= ruleExpression )
        {
        // InternalBeeLangTestLanguage.g:636:11: (lv_condExpr_7_0= ruleExpression )
        // InternalBeeLangTestLanguage.g:637:12: lv_condExpr_7_0= ruleExpression
        {
        if ( state.backtracking==0 ) {

          												newCompositeNode(grammarAccess.getProvidedCapabilityAccess().getCondExprExpressionParserRuleCall_2_1_0_2_0());
          											
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
    // $ANTLR end synpred20_InternalBeeLangTestLanguage

    // $ANTLR start synpred21_InternalBeeLangTestLanguage
    public final void synpred21_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_name_11_0=null;
        Token otherlv_12=null;

        // InternalBeeLangTestLanguage.g:664:5: ( ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) )
        // InternalBeeLangTestLanguage.g:664:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
        {
        // InternalBeeLangTestLanguage.g:664:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
        // InternalBeeLangTestLanguage.g:665:6: {...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred21_InternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1)");
        }
        // InternalBeeLangTestLanguage.g:665:118: ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
        // InternalBeeLangTestLanguage.g:666:7: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1);
        // InternalBeeLangTestLanguage.g:669:10: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
        // InternalBeeLangTestLanguage.g:669:11: {...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred21_InternalBeeLangTestLanguage", "true");
        }
        // InternalBeeLangTestLanguage.g:669:20: (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
        // InternalBeeLangTestLanguage.g:669:21: otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';'
        {
        otherlv_9=(Token)match(input,27,FOLLOW_12); if (state.failed) return ;
        otherlv_10=(Token)match(input,19,FOLLOW_8); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:677:10: ( (lv_name_11_0= RULE_ID ) )
        // InternalBeeLangTestLanguage.g:678:11: (lv_name_11_0= RULE_ID )
        {
        // InternalBeeLangTestLanguage.g:678:11: (lv_name_11_0= RULE_ID )
        // InternalBeeLangTestLanguage.g:679:12: lv_name_11_0= RULE_ID
        {
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
    // $ANTLR end synpred21_InternalBeeLangTestLanguage

    // $ANTLR start synpred22_InternalBeeLangTestLanguage
    public final void synpred22_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_version_15_0=null;
        Token otherlv_16=null;

        // InternalBeeLangTestLanguage.g:705:5: ( ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )
        // InternalBeeLangTestLanguage.g:705:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
        {
        // InternalBeeLangTestLanguage.g:705:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
        // InternalBeeLangTestLanguage.g:706:6: {...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred22_InternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2)");
        }
        // InternalBeeLangTestLanguage.g:706:118: ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
        // InternalBeeLangTestLanguage.g:707:7: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2);
        // InternalBeeLangTestLanguage.g:710:10: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
        // InternalBeeLangTestLanguage.g:710:11: {...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred22_InternalBeeLangTestLanguage", "true");
        }
        // InternalBeeLangTestLanguage.g:710:20: (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
        // InternalBeeLangTestLanguage.g:710:21: otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';'
        {
        otherlv_13=(Token)match(input,14,FOLLOW_12); if (state.failed) return ;
        otherlv_14=(Token)match(input,19,FOLLOW_8); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:718:10: ( (lv_version_15_0= RULE_ID ) )
        // InternalBeeLangTestLanguage.g:719:11: (lv_version_15_0= RULE_ID )
        {
        // InternalBeeLangTestLanguage.g:719:11: (lv_version_15_0= RULE_ID )
        // InternalBeeLangTestLanguage.g:720:12: lv_version_15_0= RULE_ID
        {
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
    // $ANTLR end synpred22_InternalBeeLangTestLanguage

    // $ANTLR start synpred26_InternalBeeLangTestLanguage
    public final void synpred26_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_condExpr_9_0 = null;


        // InternalBeeLangTestLanguage.g:870:5: ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) )
        // InternalBeeLangTestLanguage.g:870:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
        {
        // InternalBeeLangTestLanguage.g:870:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
        // InternalBeeLangTestLanguage.g:871:6: {...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred26_InternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
        }
        // InternalBeeLangTestLanguage.g:871:125: ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
        // InternalBeeLangTestLanguage.g:872:7: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
        // InternalBeeLangTestLanguage.g:875:10: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
        // InternalBeeLangTestLanguage.g:875:11: {...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred26_InternalBeeLangTestLanguage", "true");
        }
        // InternalBeeLangTestLanguage.g:875:20: (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
        // InternalBeeLangTestLanguage.g:875:21: otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';'
        {
        otherlv_7=(Token)match(input,26,FOLLOW_12); if (state.failed) return ;
        otherlv_8=(Token)match(input,19,FOLLOW_19); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:883:10: ( (lv_condExpr_9_0= ruleExpression ) )
        // InternalBeeLangTestLanguage.g:884:11: (lv_condExpr_9_0= ruleExpression )
        {
        // InternalBeeLangTestLanguage.g:884:11: (lv_condExpr_9_0= ruleExpression )
        // InternalBeeLangTestLanguage.g:885:12: lv_condExpr_9_0= ruleExpression
        {
        if ( state.backtracking==0 ) {

          												newCompositeNode(grammarAccess.getAliasedRequiredCapabilityAccess().getCondExprExpressionParserRuleCall_3_1_0_2_0());
          											
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
    // $ANTLR end synpred26_InternalBeeLangTestLanguage

    // $ANTLR start synpred27_InternalBeeLangTestLanguage
    public final void synpred27_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_greedy_11_0=null;
        Token otherlv_12=null;

        // InternalBeeLangTestLanguage.g:912:5: ( ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) )
        // InternalBeeLangTestLanguage.g:912:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
        {
        // InternalBeeLangTestLanguage.g:912:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
        // InternalBeeLangTestLanguage.g:913:6: {...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred27_InternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
        }
        // InternalBeeLangTestLanguage.g:913:125: ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
        // InternalBeeLangTestLanguage.g:914:7: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
        // InternalBeeLangTestLanguage.g:917:10: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
        // InternalBeeLangTestLanguage.g:917:11: {...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred27_InternalBeeLangTestLanguage", "true");
        }
        // InternalBeeLangTestLanguage.g:917:20: ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
        // InternalBeeLangTestLanguage.g:917:21: ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';'
        {
        // InternalBeeLangTestLanguage.g:917:21: ( (lv_greedy_11_0= 'greedy' ) )
        // InternalBeeLangTestLanguage.g:918:11: (lv_greedy_11_0= 'greedy' )
        {
        // InternalBeeLangTestLanguage.g:918:11: (lv_greedy_11_0= 'greedy' )
        // InternalBeeLangTestLanguage.g:919:12: lv_greedy_11_0= 'greedy'
        {
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
    // $ANTLR end synpred27_InternalBeeLangTestLanguage

    // $ANTLR start synpred28_InternalBeeLangTestLanguage
    public final void synpred28_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_min_15_0=null;
        Token otherlv_16=null;

        // InternalBeeLangTestLanguage.g:941:5: ( ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) )
        // InternalBeeLangTestLanguage.g:941:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
        {
        // InternalBeeLangTestLanguage.g:941:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
        // InternalBeeLangTestLanguage.g:942:6: {...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred28_InternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
        }
        // InternalBeeLangTestLanguage.g:942:125: ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
        // InternalBeeLangTestLanguage.g:943:7: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
        // InternalBeeLangTestLanguage.g:946:10: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
        // InternalBeeLangTestLanguage.g:946:11: {...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred28_InternalBeeLangTestLanguage", "true");
        }
        // InternalBeeLangTestLanguage.g:946:20: (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
        // InternalBeeLangTestLanguage.g:946:21: otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';'
        {
        otherlv_13=(Token)match(input,30,FOLLOW_12); if (state.failed) return ;
        otherlv_14=(Token)match(input,19,FOLLOW_24); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:954:10: ( (lv_min_15_0= RULE_INT ) )
        // InternalBeeLangTestLanguage.g:955:11: (lv_min_15_0= RULE_INT )
        {
        // InternalBeeLangTestLanguage.g:955:11: (lv_min_15_0= RULE_INT )
        // InternalBeeLangTestLanguage.g:956:12: lv_min_15_0= RULE_INT
        {
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
    // $ANTLR end synpred28_InternalBeeLangTestLanguage

    // $ANTLR start synpred29_InternalBeeLangTestLanguage
    public final void synpred29_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token lv_max_19_0=null;
        Token otherlv_20=null;

        // InternalBeeLangTestLanguage.g:982:5: ( ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) )
        // InternalBeeLangTestLanguage.g:982:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
        {
        // InternalBeeLangTestLanguage.g:982:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
        // InternalBeeLangTestLanguage.g:983:6: {...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred29_InternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
        }
        // InternalBeeLangTestLanguage.g:983:125: ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
        // InternalBeeLangTestLanguage.g:984:7: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
        // InternalBeeLangTestLanguage.g:987:10: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
        // InternalBeeLangTestLanguage.g:987:11: {...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred29_InternalBeeLangTestLanguage", "true");
        }
        // InternalBeeLangTestLanguage.g:987:20: (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
        // InternalBeeLangTestLanguage.g:987:21: otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';'
        {
        otherlv_17=(Token)match(input,31,FOLLOW_12); if (state.failed) return ;
        otherlv_18=(Token)match(input,19,FOLLOW_24); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:995:10: ( (lv_max_19_0= RULE_INT ) )
        // InternalBeeLangTestLanguage.g:996:11: (lv_max_19_0= RULE_INT )
        {
        // InternalBeeLangTestLanguage.g:996:11: (lv_max_19_0= RULE_INT )
        // InternalBeeLangTestLanguage.g:997:12: lv_max_19_0= RULE_INT
        {
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
    // $ANTLR end synpred29_InternalBeeLangTestLanguage

    // $ANTLR start synpred30_InternalBeeLangTestLanguage
    public final void synpred30_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token lv_versionRange_23_0=null;
        Token otherlv_24=null;

        // InternalBeeLangTestLanguage.g:1023:5: ( ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )
        // InternalBeeLangTestLanguage.g:1023:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
        {
        // InternalBeeLangTestLanguage.g:1023:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
        // InternalBeeLangTestLanguage.g:1024:6: {...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred30_InternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
        }
        // InternalBeeLangTestLanguage.g:1024:125: ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
        // InternalBeeLangTestLanguage.g:1025:7: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
        // InternalBeeLangTestLanguage.g:1028:10: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
        // InternalBeeLangTestLanguage.g:1028:11: {...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred30_InternalBeeLangTestLanguage", "true");
        }
        // InternalBeeLangTestLanguage.g:1028:20: (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
        // InternalBeeLangTestLanguage.g:1028:21: otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';'
        {
        otherlv_21=(Token)match(input,14,FOLLOW_12); if (state.failed) return ;
        otherlv_22=(Token)match(input,19,FOLLOW_8); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:1036:10: ( (lv_versionRange_23_0= RULE_ID ) )
        // InternalBeeLangTestLanguage.g:1037:11: (lv_versionRange_23_0= RULE_ID )
        {
        // InternalBeeLangTestLanguage.g:1037:11: (lv_versionRange_23_0= RULE_ID )
        // InternalBeeLangTestLanguage.g:1038:12: lv_versionRange_23_0= RULE_ID
        {
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
    // $ANTLR end synpred30_InternalBeeLangTestLanguage

    // $ANTLR start synpred32_InternalBeeLangTestLanguage
    public final void synpred32_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_condExpr_8_0 = null;


        // InternalBeeLangTestLanguage.g:1173:5: ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) )
        // InternalBeeLangTestLanguage.g:1173:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
        {
        // InternalBeeLangTestLanguage.g:1173:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
        // InternalBeeLangTestLanguage.g:1174:6: {...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred32_InternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
        }
        // InternalBeeLangTestLanguage.g:1174:118: ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
        // InternalBeeLangTestLanguage.g:1175:7: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
        // InternalBeeLangTestLanguage.g:1178:10: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
        // InternalBeeLangTestLanguage.g:1178:11: {...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred32_InternalBeeLangTestLanguage", "true");
        }
        // InternalBeeLangTestLanguage.g:1178:20: (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
        // InternalBeeLangTestLanguage.g:1178:21: otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';'
        {
        otherlv_6=(Token)match(input,26,FOLLOW_12); if (state.failed) return ;
        otherlv_7=(Token)match(input,19,FOLLOW_19); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:1186:10: ( (lv_condExpr_8_0= ruleExpression ) )
        // InternalBeeLangTestLanguage.g:1187:11: (lv_condExpr_8_0= ruleExpression )
        {
        // InternalBeeLangTestLanguage.g:1187:11: (lv_condExpr_8_0= ruleExpression )
        // InternalBeeLangTestLanguage.g:1188:12: lv_condExpr_8_0= ruleExpression
        {
        if ( state.backtracking==0 ) {

          												newCompositeNode(grammarAccess.getRequiredCapabilityAccess().getCondExprExpressionParserRuleCall_3_1_0_2_0());
          											
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
    // $ANTLR end synpred32_InternalBeeLangTestLanguage

    // $ANTLR start synpred33_InternalBeeLangTestLanguage
    public final void synpred33_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_greedy_10_0=null;
        Token otherlv_11=null;

        // InternalBeeLangTestLanguage.g:1215:5: ( ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) )
        // InternalBeeLangTestLanguage.g:1215:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
        {
        // InternalBeeLangTestLanguage.g:1215:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
        // InternalBeeLangTestLanguage.g:1216:6: {...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred33_InternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
        }
        // InternalBeeLangTestLanguage.g:1216:118: ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
        // InternalBeeLangTestLanguage.g:1217:7: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
        // InternalBeeLangTestLanguage.g:1220:10: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
        // InternalBeeLangTestLanguage.g:1220:11: {...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred33_InternalBeeLangTestLanguage", "true");
        }
        // InternalBeeLangTestLanguage.g:1220:20: ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
        // InternalBeeLangTestLanguage.g:1220:21: ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';'
        {
        // InternalBeeLangTestLanguage.g:1220:21: ( (lv_greedy_10_0= 'greedy' ) )
        // InternalBeeLangTestLanguage.g:1221:11: (lv_greedy_10_0= 'greedy' )
        {
        // InternalBeeLangTestLanguage.g:1221:11: (lv_greedy_10_0= 'greedy' )
        // InternalBeeLangTestLanguage.g:1222:12: lv_greedy_10_0= 'greedy'
        {
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
    // $ANTLR end synpred33_InternalBeeLangTestLanguage

    // $ANTLR start synpred34_InternalBeeLangTestLanguage
    public final void synpred34_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token lv_min_14_0=null;
        Token otherlv_15=null;

        // InternalBeeLangTestLanguage.g:1244:5: ( ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) )
        // InternalBeeLangTestLanguage.g:1244:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
        {
        // InternalBeeLangTestLanguage.g:1244:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
        // InternalBeeLangTestLanguage.g:1245:6: {...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred34_InternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
        }
        // InternalBeeLangTestLanguage.g:1245:118: ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
        // InternalBeeLangTestLanguage.g:1246:7: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
        // InternalBeeLangTestLanguage.g:1249:10: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
        // InternalBeeLangTestLanguage.g:1249:11: {...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred34_InternalBeeLangTestLanguage", "true");
        }
        // InternalBeeLangTestLanguage.g:1249:20: (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
        // InternalBeeLangTestLanguage.g:1249:21: otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';'
        {
        otherlv_12=(Token)match(input,30,FOLLOW_12); if (state.failed) return ;
        otherlv_13=(Token)match(input,19,FOLLOW_24); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:1257:10: ( (lv_min_14_0= RULE_INT ) )
        // InternalBeeLangTestLanguage.g:1258:11: (lv_min_14_0= RULE_INT )
        {
        // InternalBeeLangTestLanguage.g:1258:11: (lv_min_14_0= RULE_INT )
        // InternalBeeLangTestLanguage.g:1259:12: lv_min_14_0= RULE_INT
        {
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
    // $ANTLR end synpred34_InternalBeeLangTestLanguage

    // $ANTLR start synpred35_InternalBeeLangTestLanguage
    public final void synpred35_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token lv_max_18_0=null;
        Token otherlv_19=null;

        // InternalBeeLangTestLanguage.g:1285:5: ( ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) )
        // InternalBeeLangTestLanguage.g:1285:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
        {
        // InternalBeeLangTestLanguage.g:1285:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
        // InternalBeeLangTestLanguage.g:1286:6: {...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred35_InternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
        }
        // InternalBeeLangTestLanguage.g:1286:118: ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
        // InternalBeeLangTestLanguage.g:1287:7: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
        // InternalBeeLangTestLanguage.g:1290:10: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
        // InternalBeeLangTestLanguage.g:1290:11: {...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred35_InternalBeeLangTestLanguage", "true");
        }
        // InternalBeeLangTestLanguage.g:1290:20: (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
        // InternalBeeLangTestLanguage.g:1290:21: otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';'
        {
        otherlv_16=(Token)match(input,31,FOLLOW_12); if (state.failed) return ;
        otherlv_17=(Token)match(input,19,FOLLOW_24); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:1298:10: ( (lv_max_18_0= RULE_INT ) )
        // InternalBeeLangTestLanguage.g:1299:11: (lv_max_18_0= RULE_INT )
        {
        // InternalBeeLangTestLanguage.g:1299:11: (lv_max_18_0= RULE_INT )
        // InternalBeeLangTestLanguage.g:1300:12: lv_max_18_0= RULE_INT
        {
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
    // $ANTLR end synpred35_InternalBeeLangTestLanguage

    // $ANTLR start synpred36_InternalBeeLangTestLanguage
    public final void synpred36_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token lv_versionRange_22_0=null;
        Token otherlv_23=null;

        // InternalBeeLangTestLanguage.g:1326:5: ( ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )
        // InternalBeeLangTestLanguage.g:1326:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
        {
        // InternalBeeLangTestLanguage.g:1326:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
        // InternalBeeLangTestLanguage.g:1327:6: {...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred36_InternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
        }
        // InternalBeeLangTestLanguage.g:1327:118: ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
        // InternalBeeLangTestLanguage.g:1328:7: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
        // InternalBeeLangTestLanguage.g:1331:10: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
        // InternalBeeLangTestLanguage.g:1331:11: {...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred36_InternalBeeLangTestLanguage", "true");
        }
        // InternalBeeLangTestLanguage.g:1331:20: (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
        // InternalBeeLangTestLanguage.g:1331:21: otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';'
        {
        otherlv_20=(Token)match(input,14,FOLLOW_12); if (state.failed) return ;
        otherlv_21=(Token)match(input,19,FOLLOW_8); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:1339:10: ( (lv_versionRange_22_0= RULE_ID ) )
        // InternalBeeLangTestLanguage.g:1340:11: (lv_versionRange_22_0= RULE_ID )
        {
        // InternalBeeLangTestLanguage.g:1340:11: (lv_versionRange_22_0= RULE_ID )
        // InternalBeeLangTestLanguage.g:1341:12: lv_versionRange_22_0= RULE_ID
        {
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
    // $ANTLR end synpred36_InternalBeeLangTestLanguage

    // $ANTLR start synpred42_InternalBeeLangTestLanguage
    public final void synpred42_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        EObject this_ClosureParameter_0 = null;


        // InternalBeeLangTestLanguage.g:1543:3: (this_ClosureParameter_0= ruleClosureParameter )
        // InternalBeeLangTestLanguage.g:1543:3: this_ClosureParameter_0= ruleClosureParameter
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
    // $ANTLR end synpred42_InternalBeeLangTestLanguage

    // $ANTLR start synpred69_InternalBeeLangTestLanguage
    public final void synpred69_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        EObject this_VarDeclaration_0 = null;


        // InternalBeeLangTestLanguage.g:2226:3: (this_VarDeclaration_0= ruleVarDeclaration )
        // InternalBeeLangTestLanguage.g:2226:3: this_VarDeclaration_0= ruleVarDeclaration
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
    // $ANTLR end synpred69_InternalBeeLangTestLanguage

    // $ANTLR start synpred71_InternalBeeLangTestLanguage
    public final void synpred71_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken lv_functionName_2_0 = null;

        EObject lv_rightExpr_3_0 = null;


        // InternalBeeLangTestLanguage.g:2320:4: ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )
        // InternalBeeLangTestLanguage.g:2320:4: () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
        {
        // InternalBeeLangTestLanguage.g:2320:4: ()
        // InternalBeeLangTestLanguage.g:2321:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalBeeLangTestLanguage.g:2330:4: ( (lv_functionName_2_0= ruleAssignmentOperator ) )
        // InternalBeeLangTestLanguage.g:2331:5: (lv_functionName_2_0= ruleAssignmentOperator )
        {
        // InternalBeeLangTestLanguage.g:2331:5: (lv_functionName_2_0= ruleAssignmentOperator )
        // InternalBeeLangTestLanguage.g:2332:6: lv_functionName_2_0= ruleAssignmentOperator
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getFunctionNameAssignmentOperatorParserRuleCall_1_1_0());
          					
        }
        pushFollow(FOLLOW_19);
        lv_functionName_2_0=ruleAssignmentOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalBeeLangTestLanguage.g:2349:4: ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
        // InternalBeeLangTestLanguage.g:2350:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
        {
        // InternalBeeLangTestLanguage.g:2350:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
        // InternalBeeLangTestLanguage.g:2351:6: lv_rightExpr_3_0= ruleAssignmentExpression
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRightExprAssignmentExpressionParserRuleCall_1_2_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_rightExpr_3_0=ruleAssignmentExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred71_InternalBeeLangTestLanguage

    // $ANTLR start synpred85_InternalBeeLangTestLanguage
    public final void synpred85_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        EObject lv_rightExpr_3_0 = null;


        // InternalBeeLangTestLanguage.g:2996:4: ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )
        // InternalBeeLangTestLanguage.g:2996:4: () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) )
        {
        // InternalBeeLangTestLanguage.g:2996:4: ()
        // InternalBeeLangTestLanguage.g:2997:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        otherlv_2=(Token)match(input,57,FOLLOW_19); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:3010:4: ( (lv_rightExpr_3_0= ruleAndExpression ) )
        // InternalBeeLangTestLanguage.g:3011:5: (lv_rightExpr_3_0= ruleAndExpression )
        {
        // InternalBeeLangTestLanguage.g:3011:5: (lv_rightExpr_3_0= ruleAndExpression )
        // InternalBeeLangTestLanguage.g:3012:6: lv_rightExpr_3_0= ruleAndExpression
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getOrExpressionAccess().getRightExprAndExpressionParserRuleCall_1_2_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_rightExpr_3_0=ruleAndExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred85_InternalBeeLangTestLanguage

    // $ANTLR start synpred86_InternalBeeLangTestLanguage
    public final void synpred86_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        EObject lv_rightExpr_3_0 = null;


        // InternalBeeLangTestLanguage.g:3061:4: ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )
        // InternalBeeLangTestLanguage.g:3061:4: () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
        {
        // InternalBeeLangTestLanguage.g:3061:4: ()
        // InternalBeeLangTestLanguage.g:3062:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        otherlv_2=(Token)match(input,58,FOLLOW_19); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:3075:4: ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
        // InternalBeeLangTestLanguage.g:3076:5: (lv_rightExpr_3_0= ruleRelationalExpression )
        {
        // InternalBeeLangTestLanguage.g:3076:5: (lv_rightExpr_3_0= ruleRelationalExpression )
        // InternalBeeLangTestLanguage.g:3077:6: lv_rightExpr_3_0= ruleRelationalExpression
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getAndExpressionAccess().getRightExprRelationalExpressionParserRuleCall_1_2_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_rightExpr_3_0=ruleRelationalExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred86_InternalBeeLangTestLanguage

    // $ANTLR start synpred87_InternalBeeLangTestLanguage
    public final void synpred87_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken lv_functionName_2_0 = null;

        EObject lv_rightExpr_3_0 = null;


        // InternalBeeLangTestLanguage.g:3126:4: ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )
        // InternalBeeLangTestLanguage.g:3126:4: () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
        {
        // InternalBeeLangTestLanguage.g:3126:4: ()
        // InternalBeeLangTestLanguage.g:3127:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalBeeLangTestLanguage.g:3136:4: ( (lv_functionName_2_0= ruleRelationalOperator ) )
        // InternalBeeLangTestLanguage.g:3137:5: (lv_functionName_2_0= ruleRelationalOperator )
        {
        // InternalBeeLangTestLanguage.g:3137:5: (lv_functionName_2_0= ruleRelationalOperator )
        // InternalBeeLangTestLanguage.g:3138:6: lv_functionName_2_0= ruleRelationalOperator
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getFunctionNameRelationalOperatorParserRuleCall_1_1_0());
          					
        }
        pushFollow(FOLLOW_19);
        lv_functionName_2_0=ruleRelationalOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalBeeLangTestLanguage.g:3155:4: ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
        // InternalBeeLangTestLanguage.g:3156:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
        {
        // InternalBeeLangTestLanguage.g:3156:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
        // InternalBeeLangTestLanguage.g:3157:6: lv_rightExpr_3_0= ruleAdditiveExpression
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightExprAdditiveExpressionParserRuleCall_1_2_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_rightExpr_3_0=ruleAdditiveExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred87_InternalBeeLangTestLanguage

    // $ANTLR start synpred89_InternalBeeLangTestLanguage
    public final void synpred89_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        EObject lv_rightExpr_3_0 = null;


        // InternalBeeLangTestLanguage.g:3206:4: ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )
        // InternalBeeLangTestLanguage.g:3206:4: () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
        {
        // InternalBeeLangTestLanguage.g:3206:4: ()
        // InternalBeeLangTestLanguage.g:3207:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalBeeLangTestLanguage.g:3216:4: ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) )
        // InternalBeeLangTestLanguage.g:3217:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
        {
        // InternalBeeLangTestLanguage.g:3217:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
        // InternalBeeLangTestLanguage.g:3218:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
        {
        // InternalBeeLangTestLanguage.g:3218:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
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
                // InternalBeeLangTestLanguage.g:3219:7: lv_functionName_2_1= '+'
                {
                lv_functionName_2_1=(Token)match(input,59,FOLLOW_19); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalBeeLangTestLanguage.g:3230:7: lv_functionName_2_2= '-'
                {
                lv_functionName_2_2=(Token)match(input,60,FOLLOW_19); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // InternalBeeLangTestLanguage.g:3243:4: ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
        // InternalBeeLangTestLanguage.g:3244:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
        {
        // InternalBeeLangTestLanguage.g:3244:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
        // InternalBeeLangTestLanguage.g:3245:6: lv_rightExpr_3_0= ruleMultiplicativeExpression
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightExprMultiplicativeExpressionParserRuleCall_1_2_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_rightExpr_3_0=ruleMultiplicativeExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred89_InternalBeeLangTestLanguage

    // $ANTLR start synpred92_InternalBeeLangTestLanguage
    public final void synpred92_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        Token lv_functionName_2_3=null;
        EObject lv_rightExpr_3_0 = null;


        // InternalBeeLangTestLanguage.g:3294:4: ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )
        // InternalBeeLangTestLanguage.g:3294:4: () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) )
        {
        // InternalBeeLangTestLanguage.g:3294:4: ()
        // InternalBeeLangTestLanguage.g:3295:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalBeeLangTestLanguage.g:3304:4: ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) )
        // InternalBeeLangTestLanguage.g:3305:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
        {
        // InternalBeeLangTestLanguage.g:3305:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
        // InternalBeeLangTestLanguage.g:3306:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
        {
        // InternalBeeLangTestLanguage.g:3306:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
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
                // InternalBeeLangTestLanguage.g:3307:7: lv_functionName_2_1= '*'
                {
                lv_functionName_2_1=(Token)match(input,61,FOLLOW_19); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalBeeLangTestLanguage.g:3318:7: lv_functionName_2_2= '/'
                {
                lv_functionName_2_2=(Token)match(input,32,FOLLOW_19); if (state.failed) return ;

                }
                break;
            case 3 :
                // InternalBeeLangTestLanguage.g:3329:7: lv_functionName_2_3= '%'
                {
                lv_functionName_2_3=(Token)match(input,62,FOLLOW_19); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // InternalBeeLangTestLanguage.g:3342:4: ( (lv_rightExpr_3_0= ruleSetExpression ) )
        // InternalBeeLangTestLanguage.g:3343:5: (lv_rightExpr_3_0= ruleSetExpression )
        {
        // InternalBeeLangTestLanguage.g:3343:5: (lv_rightExpr_3_0= ruleSetExpression )
        // InternalBeeLangTestLanguage.g:3344:6: lv_rightExpr_3_0= ruleSetExpression
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightExprSetExpressionParserRuleCall_1_2_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_rightExpr_3_0=ruleSetExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred92_InternalBeeLangTestLanguage

    // $ANTLR start synpred93_InternalBeeLangTestLanguage
    public final void synpred93_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_0=null;
        EObject lv_rightExpr_3_0 = null;


        // InternalBeeLangTestLanguage.g:3393:4: ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )
        // InternalBeeLangTestLanguage.g:3393:4: () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
        {
        // InternalBeeLangTestLanguage.g:3393:4: ()
        // InternalBeeLangTestLanguage.g:3394:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalBeeLangTestLanguage.g:3403:4: ( (lv_functionName_2_0= '..' ) )
        // InternalBeeLangTestLanguage.g:3404:5: (lv_functionName_2_0= '..' )
        {
        // InternalBeeLangTestLanguage.g:3404:5: (lv_functionName_2_0= '..' )
        // InternalBeeLangTestLanguage.g:3405:6: lv_functionName_2_0= '..'
        {
        lv_functionName_2_0=(Token)match(input,63,FOLLOW_19); if (state.failed) return ;

        }


        }

        // InternalBeeLangTestLanguage.g:3417:4: ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
        // InternalBeeLangTestLanguage.g:3418:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
        {
        // InternalBeeLangTestLanguage.g:3418:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
        // InternalBeeLangTestLanguage.g:3419:6: lv_rightExpr_3_0= ruleUnaryOrInfixExpression
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getSetExpressionAccess().getRightExprUnaryOrInfixExpressionParserRuleCall_1_2_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_rightExpr_3_0=ruleUnaryOrInfixExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred93_InternalBeeLangTestLanguage

    // $ANTLR start synpred99_InternalBeeLangTestLanguage
    public final void synpred99_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;

        // InternalBeeLangTestLanguage.g:3672:4: ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )
        // InternalBeeLangTestLanguage.g:3672:4: () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
        {
        // InternalBeeLangTestLanguage.g:3672:4: ()
        // InternalBeeLangTestLanguage.g:3673:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalBeeLangTestLanguage.g:3682:4: ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
        // InternalBeeLangTestLanguage.g:3683:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
        {
        // InternalBeeLangTestLanguage.g:3683:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
        // InternalBeeLangTestLanguage.g:3684:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
        {
        // InternalBeeLangTestLanguage.g:3684:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
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
                // InternalBeeLangTestLanguage.g:3685:7: lv_functionName_2_1= '--'
                {
                lv_functionName_2_1=(Token)match(input,66,FOLLOW_2); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalBeeLangTestLanguage.g:3696:7: lv_functionName_2_2= '++'
                {
                lv_functionName_2_2=(Token)match(input,65,FOLLOW_2); if (state.failed) return ;

                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred99_InternalBeeLangTestLanguage

    // $ANTLR start synpred101_InternalBeeLangTestLanguage
    public final void synpred101_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_parameterList_5_0 = null;


        // InternalBeeLangTestLanguage.g:3741:4: ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) )
        // InternalBeeLangTestLanguage.g:3741:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
        {
        // InternalBeeLangTestLanguage.g:3741:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
        // InternalBeeLangTestLanguage.g:3742:5: () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')'
        {
        // InternalBeeLangTestLanguage.g:3742:5: ()
        // InternalBeeLangTestLanguage.g:3743:6: 
        {
        if ( state.backtracking==0 ) {

          						/* */
          					
        }

        }

        otherlv_2=(Token)match(input,67,FOLLOW_8); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:3756:5: ( (lv_name_3_0= RULE_ID ) )
        // InternalBeeLangTestLanguage.g:3757:6: (lv_name_3_0= RULE_ID )
        {
        // InternalBeeLangTestLanguage.g:3757:6: (lv_name_3_0= RULE_ID )
        // InternalBeeLangTestLanguage.g:3758:7: lv_name_3_0= RULE_ID
        {
        lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_58); if (state.failed) return ;

        }


        }

        otherlv_4=(Token)match(input,35,FOLLOW_59); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:3778:5: ( (lv_parameterList_5_0= ruleParameterList ) )?
        int alt114=2;
        int LA114_0 = input.LA(1);

        if ( (LA114_0==RULE_ID||LA114_0==RULE_STRING||LA114_0==13||(LA114_0>=17 && LA114_0<=18)||LA114_0==21||(LA114_0>=35 && LA114_0<=36)||LA114_0==52||LA114_0==56||LA114_0==60||(LA114_0>=64 && LA114_0<=66)||LA114_0==70||(LA114_0>=72 && LA114_0<=77)) ) {
            alt114=1;
        }
        switch (alt114) {
            case 1 :
                // InternalBeeLangTestLanguage.g:3779:6: (lv_parameterList_5_0= ruleParameterList )
                {
                // InternalBeeLangTestLanguage.g:3779:6: (lv_parameterList_5_0= ruleParameterList )
                // InternalBeeLangTestLanguage.g:3780:7: lv_parameterList_5_0= ruleParameterList
                {
                if ( state.backtracking==0 ) {

                  							newCompositeNode(grammarAccess.getInfixExpressionAccess().getParameterListParameterListParserRuleCall_1_0_4_0());
                  						
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
    // $ANTLR end synpred101_InternalBeeLangTestLanguage

    // $ANTLR start synpred102_InternalBeeLangTestLanguage
    public final void synpred102_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_indexExpr_9_0 = null;


        // InternalBeeLangTestLanguage.g:3803:4: ( ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) )
        // InternalBeeLangTestLanguage.g:3803:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
        {
        // InternalBeeLangTestLanguage.g:3803:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
        // InternalBeeLangTestLanguage.g:3804:5: () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']'
        {
        // InternalBeeLangTestLanguage.g:3804:5: ()
        // InternalBeeLangTestLanguage.g:3805:6: 
        {
        if ( state.backtracking==0 ) {

          						/* */
          					
        }

        }

        otherlv_8=(Token)match(input,68,FOLLOW_19); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:3818:5: ( (lv_indexExpr_9_0= ruleExpression ) )
        // InternalBeeLangTestLanguage.g:3819:6: (lv_indexExpr_9_0= ruleExpression )
        {
        // InternalBeeLangTestLanguage.g:3819:6: (lv_indexExpr_9_0= ruleExpression )
        // InternalBeeLangTestLanguage.g:3820:7: lv_indexExpr_9_0= ruleExpression
        {
        if ( state.backtracking==0 ) {

          							newCompositeNode(grammarAccess.getInfixExpressionAccess().getIndexExprExpressionParserRuleCall_1_1_2_0());
          						
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
    // $ANTLR end synpred102_InternalBeeLangTestLanguage

    // $ANTLR start synpred103_InternalBeeLangTestLanguage
    public final void synpred103_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_12=null;
        Token lv_featureName_13_0=null;

        // InternalBeeLangTestLanguage.g:3843:4: ( ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )
        // InternalBeeLangTestLanguage.g:3843:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
        {
        // InternalBeeLangTestLanguage.g:3843:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
        // InternalBeeLangTestLanguage.g:3844:5: () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) )
        {
        // InternalBeeLangTestLanguage.g:3844:5: ()
        // InternalBeeLangTestLanguage.g:3845:6: 
        {
        if ( state.backtracking==0 ) {

          						/* */
          					
        }

        }

        otherlv_12=(Token)match(input,67,FOLLOW_8); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:3858:5: ( (lv_featureName_13_0= RULE_ID ) )
        // InternalBeeLangTestLanguage.g:3859:6: (lv_featureName_13_0= RULE_ID )
        {
        // InternalBeeLangTestLanguage.g:3859:6: (lv_featureName_13_0= RULE_ID )
        // InternalBeeLangTestLanguage.g:3860:7: lv_featureName_13_0= RULE_ID
        {
        lv_featureName_13_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred103_InternalBeeLangTestLanguage

    // $ANTLR start synpred105_InternalBeeLangTestLanguage
    public final void synpred105_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_parameterList_3_0 = null;


        // InternalBeeLangTestLanguage.g:3909:4: ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )
        // InternalBeeLangTestLanguage.g:3909:4: () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')'
        {
        // InternalBeeLangTestLanguage.g:3909:4: ()
        // InternalBeeLangTestLanguage.g:3910:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        otherlv_2=(Token)match(input,35,FOLLOW_59); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:3923:4: ( (lv_parameterList_3_0= ruleParameterList ) )?
        int alt115=2;
        int LA115_0 = input.LA(1);

        if ( (LA115_0==RULE_ID||LA115_0==RULE_STRING||LA115_0==13||(LA115_0>=17 && LA115_0<=18)||LA115_0==21||(LA115_0>=35 && LA115_0<=36)||LA115_0==52||LA115_0==56||LA115_0==60||(LA115_0>=64 && LA115_0<=66)||LA115_0==70||(LA115_0>=72 && LA115_0<=77)) ) {
            alt115=1;
        }
        switch (alt115) {
            case 1 :
                // InternalBeeLangTestLanguage.g:3924:5: (lv_parameterList_3_0= ruleParameterList )
                {
                // InternalBeeLangTestLanguage.g:3924:5: (lv_parameterList_3_0= ruleParameterList )
                // InternalBeeLangTestLanguage.g:3925:6: lv_parameterList_3_0= ruleParameterList
                {
                if ( state.backtracking==0 ) {

                  						newCompositeNode(grammarAccess.getCallExpressionAccess().getParameterListParameterListParserRuleCall_1_2_0());
                  					
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
    // $ANTLR end synpred105_InternalBeeLangTestLanguage

    // $ANTLR start synpred106_InternalBeeLangTestLanguage
    public final void synpred106_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        EObject this_FeatureCall_0 = null;


        // InternalBeeLangTestLanguage.g:3966:3: (this_FeatureCall_0= ruleFeatureCall )
        // InternalBeeLangTestLanguage.g:3966:3: this_FeatureCall_0= ruleFeatureCall
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
    // $ANTLR end synpred106_InternalBeeLangTestLanguage

    // $ANTLR start synpred108_InternalBeeLangTestLanguage
    public final void synpred108_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        EObject this_Value_2 = null;


        // InternalBeeLangTestLanguage.g:3990:3: (this_Value_2= ruleValue )
        // InternalBeeLangTestLanguage.g:3990:3: this_Value_2= ruleValue
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
    // $ANTLR end synpred108_InternalBeeLangTestLanguage

    // $ANTLR start synpred109_InternalBeeLangTestLanguage
    public final void synpred109_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        EObject this_Literal_3 = null;


        // InternalBeeLangTestLanguage.g:4002:3: (this_Literal_3= ruleLiteral )
        // InternalBeeLangTestLanguage.g:4002:3: this_Literal_3= ruleLiteral
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
    // $ANTLR end synpred109_InternalBeeLangTestLanguage

    // $ANTLR start synpred112_InternalBeeLangTestLanguage
    public final void synpred112_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        EObject this_BlockExpression_6 = null;


        // InternalBeeLangTestLanguage.g:4038:3: (this_BlockExpression_6= ruleBlockExpression )
        // InternalBeeLangTestLanguage.g:4038:3: this_BlockExpression_6= ruleBlockExpression
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
    // $ANTLR end synpred112_InternalBeeLangTestLanguage

    // $ANTLR start synpred113_InternalBeeLangTestLanguage
    public final void synpred113_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        EObject this_WithExpression_7 = null;


        // InternalBeeLangTestLanguage.g:4050:3: (this_WithExpression_7= ruleWithExpression )
        // InternalBeeLangTestLanguage.g:4050:3: this_WithExpression_7= ruleWithExpression
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
    // $ANTLR end synpred113_InternalBeeLangTestLanguage

    // $ANTLR start synpred127_InternalBeeLangTestLanguage
    public final void synpred127_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_parameterList_4_0 = null;


        // InternalBeeLangTestLanguage.g:4660:4: (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )
        // InternalBeeLangTestLanguage.g:4660:4: otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')'
        {
        otherlv_3=(Token)match(input,35,FOLLOW_59); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:4664:4: ( (lv_parameterList_4_0= ruleParameterList ) )?
        int alt117=2;
        int LA117_0 = input.LA(1);

        if ( (LA117_0==RULE_ID||LA117_0==RULE_STRING||LA117_0==13||(LA117_0>=17 && LA117_0<=18)||LA117_0==21||(LA117_0>=35 && LA117_0<=36)||LA117_0==52||LA117_0==56||LA117_0==60||(LA117_0>=64 && LA117_0<=66)||LA117_0==70||(LA117_0>=72 && LA117_0<=77)) ) {
            alt117=1;
        }
        switch (alt117) {
            case 1 :
                // InternalBeeLangTestLanguage.g:4665:5: (lv_parameterList_4_0= ruleParameterList )
                {
                // InternalBeeLangTestLanguage.g:4665:5: (lv_parameterList_4_0= ruleParameterList )
                // InternalBeeLangTestLanguage.g:4666:6: lv_parameterList_4_0= ruleParameterList
                {
                if ( state.backtracking==0 ) {

                  						newCompositeNode(grammarAccess.getConstructorCallExpressionAccess().getParameterListParameterListParserRuleCall_3_1_0());
                  					
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
    // $ANTLR end synpred127_InternalBeeLangTestLanguage

    // $ANTLR start synpred128_InternalBeeLangTestLanguage
    public final void synpred128_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        Token lv_alias_7_0=null;

        // InternalBeeLangTestLanguage.g:4689:4: (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )
        // InternalBeeLangTestLanguage.g:4689:4: otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) )
        {
        otherlv_6=(Token)match(input,28,FOLLOW_8); if (state.failed) return ;
        // InternalBeeLangTestLanguage.g:4693:4: ( (lv_alias_7_0= RULE_ID ) )
        // InternalBeeLangTestLanguage.g:4694:5: (lv_alias_7_0= RULE_ID )
        {
        // InternalBeeLangTestLanguage.g:4694:5: (lv_alias_7_0= RULE_ID )
        // InternalBeeLangTestLanguage.g:4695:6: lv_alias_7_0= RULE_ID
        {
        lv_alias_7_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred128_InternalBeeLangTestLanguage

    // $ANTLR start synpred135_InternalBeeLangTestLanguage
    public final void synpred135_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_varArgs_9_0=null;
        EObject lv_parameters_5_0 = null;

        EObject lv_parameters_7_0 = null;

        EObject lv_parameters_10_0 = null;


        // InternalBeeLangTestLanguage.g:5058:4: ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) )
        // InternalBeeLangTestLanguage.g:5058:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
        {
        // InternalBeeLangTestLanguage.g:5058:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
        // InternalBeeLangTestLanguage.g:5059:5: (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
        {
        // InternalBeeLangTestLanguage.g:5059:5: (otherlv_4= '|' )?
        int alt118=2;
        int LA118_0 = input.LA(1);

        if ( (LA118_0==77) ) {
            alt118=1;
        }
        switch (alt118) {
            case 1 :
                // InternalBeeLangTestLanguage.g:5060:6: otherlv_4= '|'
                {
                otherlv_4=(Token)match(input,77,FOLLOW_35); if (state.failed) return ;

                }
                break;

        }

        // InternalBeeLangTestLanguage.g:5065:5: ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
        // InternalBeeLangTestLanguage.g:5066:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
        {
        // InternalBeeLangTestLanguage.g:5066:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) )
        // InternalBeeLangTestLanguage.g:5067:7: (lv_parameters_5_0= ruleParameterDeclaration )
        {
        // InternalBeeLangTestLanguage.g:5067:7: (lv_parameters_5_0= ruleParameterDeclaration )
        // InternalBeeLangTestLanguage.g:5068:8: lv_parameters_5_0= ruleParameterDeclaration
        {
        if ( state.backtracking==0 ) {

          								newCompositeNode(grammarAccess.getClosureExpressionAccess().getParametersParameterDeclarationParserRuleCall_2_0_1_0_0());
          							
        }
        pushFollow(FOLLOW_26);
        lv_parameters_5_0=ruleParameterDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalBeeLangTestLanguage.g:5085:6: (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )*
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
        	    // InternalBeeLangTestLanguage.g:5086:7: otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) )
        	    {
        	    otherlv_6=(Token)match(input,16,FOLLOW_35); if (state.failed) return ;
        	    // InternalBeeLangTestLanguage.g:5090:7: ( (lv_parameters_7_0= ruleParameterDeclaration ) )
        	    // InternalBeeLangTestLanguage.g:5091:8: (lv_parameters_7_0= ruleParameterDeclaration )
        	    {
        	    // InternalBeeLangTestLanguage.g:5091:8: (lv_parameters_7_0= ruleParameterDeclaration )
        	    // InternalBeeLangTestLanguage.g:5092:9: lv_parameters_7_0= ruleParameterDeclaration
        	    {
        	    if ( state.backtracking==0 ) {

        	      									newCompositeNode(grammarAccess.getClosureExpressionAccess().getParametersParameterDeclarationParserRuleCall_2_0_1_1_1_0());
        	      								
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

        // InternalBeeLangTestLanguage.g:5110:6: (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
        int alt120=2;
        int LA120_0 = input.LA(1);

        if ( (LA120_0==16) ) {
            alt120=1;
        }
        switch (alt120) {
            case 1 :
                // InternalBeeLangTestLanguage.g:5111:7: otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                {
                otherlv_8=(Token)match(input,16,FOLLOW_36); if (state.failed) return ;
                // InternalBeeLangTestLanguage.g:5115:7: ( (lv_varArgs_9_0= '...' ) )
                // InternalBeeLangTestLanguage.g:5116:8: (lv_varArgs_9_0= '...' )
                {
                // InternalBeeLangTestLanguage.g:5116:8: (lv_varArgs_9_0= '...' )
                // InternalBeeLangTestLanguage.g:5117:9: lv_varArgs_9_0= '...'
                {
                lv_varArgs_9_0=(Token)match(input,36,FOLLOW_35); if (state.failed) return ;

                }


                }

                // InternalBeeLangTestLanguage.g:5129:7: ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                // InternalBeeLangTestLanguage.g:5130:8: (lv_parameters_10_0= ruleParameterDeclaration )
                {
                // InternalBeeLangTestLanguage.g:5130:8: (lv_parameters_10_0= ruleParameterDeclaration )
                // InternalBeeLangTestLanguage.g:5131:9: lv_parameters_10_0= ruleParameterDeclaration
                {
                if ( state.backtracking==0 ) {

                  									newCompositeNode(grammarAccess.getClosureExpressionAccess().getParametersParameterDeclarationParserRuleCall_2_0_1_2_2_0());
                  								
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
    // $ANTLR end synpred135_InternalBeeLangTestLanguage

    // $ANTLR start synpred137_InternalBeeLangTestLanguage
    public final void synpred137_InternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        EObject this_BlockExpressionWithoutBrackets_0 = null;


        // InternalBeeLangTestLanguage.g:5230:3: (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets )
        // InternalBeeLangTestLanguage.g:5230:3: this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets
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
    // $ANTLR end synpred137_InternalBeeLangTestLanguage

    // Delegated rules

    public final boolean synpred127_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred127_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred86_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred86_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred106_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred105_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred105_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred69_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred69_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred128_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred128_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred89_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred89_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred101_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred101_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred85_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred85_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred112_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred112_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred109_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred93_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred93_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred135_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred135_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred108_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred108_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred103_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred103_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred71_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred71_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred113_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred87_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred92_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred92_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred102_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred102_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred99_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred99_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred137_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred137_InternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalBeeLangTestLanguage_fragment(); // can never throw exception
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
    static final String dfa_4s = "\1\uffff\1\7\1\1\1\2\1\3\1\uffff\4\6\1\5\1\4";
    static final String dfa_5s = "\1\1\4\uffff\1\0\6\uffff}>";
    static final String[] dfa_6s = {
            "\1\6\1\7\14\uffff\1\2\2\uffff\1\3\1\4\1\5\1\uffff\1\1\7\uffff\1\10\1\11",
            "",
            "",
            "",
            "",
            "\1\13\4\uffff\1\12",
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
            return "()* loopback of 289:6: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA13_5 = input.LA(1);

                         
                        int index13_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA13_5 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4) ) {s = 10;}

                        else if ( LA13_5 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3) ) {s = 11;}

                         
                        input.seek(index13_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
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
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 13, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\56\uffff";
    static final String dfa_8s = "\3\uffff\1\4\4\uffff\2\4\12\uffff\2\4\3\uffff\1\4\13\uffff\2\4\7\uffff";
    static final String dfa_9s = "\1\5\1\uffff\2\5\1\uffff\1\20\2\5\2\20\2\5\1\0\3\5\1\0\1\20\1\5\1\67\1\5\2\20\1\5\1\67\1\20\1\5\1\45\4\5\1\45\2\5\1\20\1\5\1\20\1\5\1\20\2\5\1\45\1\0\1\45\1\0";
    static final String dfa_10s = "\1\115\1\uffff\1\114\1\115\1\uffff\1\104\1\114\1\115\2\104\1\43\1\114\1\0\1\115\1\114\1\45\1\0\1\104\1\5\1\67\2\115\1\45\1\5\1\67\1\104\1\44\1\45\1\5\1\114\1\115\1\44\1\45\2\5\1\45\1\5\2\115\1\45\2\5\1\45\1\0\1\45\1\0";
    static final String dfa_11s = "\1\uffff\1\1\2\uffff\1\2\51\uffff";
    static final String dfa_12s = "\14\uffff\1\1\3\uffff\1\3\32\uffff\1\2\1\uffff\1\0}>";
    static final String[] dfa_13s = {
            "\1\3\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\2\1\1\17\uffff\1\1\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4\1\1",
            "",
            "\1\5\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\2\1\22\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\1\12\uffff\1\7\17\uffff\1\4\2\uffff\1\4\1\uffff\17\4\1\6\4\uffff\7\4\1\uffff\4\4\10\uffff\1\1",
            "",
            "\1\1\17\uffff\1\4\2\uffff\1\4\1\uffff\1\10\17\4\4\uffff\7\4\1\uffff\4\4",
            "\1\11\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\30\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\14\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\13\1\12\17\uffff\1\4\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\6\4",
            "\1\4\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\2\uffff\1\1\1\uffff\7\4\1\uffff\4\4",
            "\1\15\17\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\16\1\4\4\uffff\7\4\1\uffff\4\4",
            "\1\20\35\uffff\1\17",
            "\1\21\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\1\22\1\23\22\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\uffff",
            "\1\24\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\2\4\17\uffff\1\4\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\6\4",
            "\1\25\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\30\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\26\36\uffff\1\27\1\30",
            "\1\uffff",
            "\1\32\17\uffff\1\4\2\uffff\1\4\1\uffff\1\31\17\4\4\uffff\7\4\1\uffff\4\4",
            "\1\33",
            "\1\34",
            "\1\4\12\uffff\1\36\17\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\35\1\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\4",
            "\1\7\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\1",
            "\1\37\24\uffff\1\30",
            "\1\40",
            "\1\41",
            "\1\4\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\2\uffff\1\34\1\uffff\7\4\1\uffff\4\4",
            "\1\43\36\uffff\1\42",
            "\1\23",
            "\1\44",
            "\1\45\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\30\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\46\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\2\4\17\uffff\1\4\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\6\4",
            "\1\47\36\uffff\1\50",
            "\1\30",
            "\1\51",
            "\1\52",
            "\1\32\24\uffff\1\23",
            "\1\53",
            "\1\7\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\1",
            "\1\4\12\uffff\1\36\17\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\35\1\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\4",
            "\1\37\24\uffff\1\30",
            "\1\54",
            "\1\55",
            "\1\23",
            "\1\uffff",
            "\1\30",
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
            return "1542:2: (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_45 = input.LA(1);

                         
                        int index27_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_InternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_45);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_12 = input.LA(1);

                         
                        int index27_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_InternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA27_43 = input.LA(1);

                         
                        int index27_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_InternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_43);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA27_16 = input.LA(1);

                         
                        int index27_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_InternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_16);
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
            return "2225:2: (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression )";
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
                        if ( (synpred69_InternalBeeLangTestLanguage()) ) {s = 2;}

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
    static final String dfa_25s = "\2\uffff\1\7\1\1\1\4\1\10\1\3\1\6\1\0\1\5\1\2\1\uffff}>";
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
            return "()* loopback of 3125:3: ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA58_8 = input.LA(1);

                         
                        int index58_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA58_3 = input.LA(1);

                         
                        int index58_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA58_10 = input.LA(1);

                         
                        int index58_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_10);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA58_6 = input.LA(1);

                         
                        int index58_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA58_4 = input.LA(1);

                         
                        int index58_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA58_9 = input.LA(1);

                         
                        int index58_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_9);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA58_7 = input.LA(1);

                         
                        int index58_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA58_2 = input.LA(1);

                         
                        int index58_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_2);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA58_5 = input.LA(1);

                         
                        int index58_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalBeeLangTestLanguage()) ) {s = 11;}

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
            return "3965:2: (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression )";
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
                        if ( (synpred106_InternalBeeLangTestLanguage()) ) {s = 14;}

                        else if ( (synpred108_InternalBeeLangTestLanguage()) ) {s = 15;}

                         
                        input.seek(index73_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA73_4 = input.LA(1);

                         
                        int index73_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred109_InternalBeeLangTestLanguage()) ) {s = 3;}

                        else if ( (synpred112_InternalBeeLangTestLanguage()) ) {s = 16;}

                         
                        input.seek(index73_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA73_13 = input.LA(1);

                         
                        int index73_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_InternalBeeLangTestLanguage()) ) {s = 17;}

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
            return "4659:3: (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )?";
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
                        if ( (synpred127_InternalBeeLangTestLanguage()) ) {s = 37;}

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
    static final String dfa_41s = "\6\uffff\1\4\7\uffff\1\4\2\uffff\1\4\16\uffff\2\4\4\uffff\1\4\12\uffff\2\4\7\uffff";
    static final String dfa_42s = "\2\5\3\uffff\2\5\1\20\1\5\1\67\1\5\1\20\2\5\1\20\1\45\1\5\1\20\2\5\1\0\1\5\1\20\4\5\1\0\1\20\1\5\1\67\1\45\1\5\2\20\1\5\1\67\1\5\1\20\1\45\4\5\1\45\1\5\1\20\2\5\1\20\1\5\1\20\2\5\1\45\1\0\1\45\1\0";
    static final String dfa_43s = "\1\115\1\114\3\uffff\1\114\1\115\1\104\1\5\1\67\1\114\2\115\1\44\1\104\1\45\1\5\1\104\1\43\1\114\1\0\1\5\1\45\1\5\1\115\1\114\1\45\1\0\1\104\1\5\1\67\1\45\2\115\1\45\1\5\1\67\1\44\1\104\1\45\1\5\1\114\1\115\1\44\1\45\1\5\1\45\2\5\2\115\1\45\2\5\1\45\1\0\1\45\1\0";
    static final String dfa_44s = "\2\uffff\1\1\1\2\1\3\65\uffff";
    static final String dfa_45s = "\24\uffff\1\0\6\uffff\1\1\33\uffff\1\3\1\uffff\1\2}>";
    static final String[] dfa_46s = {
            "\1\2\35\uffff\1\2\1\3\50\uffff\1\1",
            "\1\6\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\13\uffff\1\4\1\uffff\1\5\21\uffff\2\4\1\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "",
            "",
            "",
            "\1\7\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\1\10\1\11\22\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\13\12\uffff\1\14\3\uffff\1\4\4\uffff\1\4\6\uffff\1\4\2\uffff\1\4\1\uffff\17\4\1\12\4\uffff\7\4\1\uffff\4\4\10\uffff\1\2",
            "\1\15\17\uffff\1\4\2\uffff\1\4\1\uffff\1\16\17\4\4\uffff\7\4\1\uffff\4\4",
            "\1\17",
            "\1\20",
            "\1\21\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\30\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\2\3\uffff\1\4\21\uffff\1\4\46\uffff\1\2",
            "\1\24\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\23\1\22\17\uffff\1\4\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\6\4",
            "\1\26\36\uffff\1\25",
            "\1\4\3\uffff\1\4\4\uffff\1\4\6\uffff\1\4\2\uffff\1\4\1\uffff\20\4\2\uffff\1\20\1\uffff\7\4\1\uffff\4\4",
            "\1\11",
            "\1\27",
            "\1\30\3\uffff\1\4\4\uffff\1\4\6\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\31\1\4\4\uffff\7\4\1\uffff\4\4",
            "\1\33\35\uffff\1\32",
            "\1\34\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\1\35\1\36\22\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\uffff",
            "\1\37",
            "\1\15\24\uffff\1\11",
            "\1\13",
            "\1\40\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\2\4\17\uffff\1\4\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\6\4",
            "\1\41\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\30\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\42\36\uffff\1\43\1\44",
            "\1\uffff",
            "\1\45\17\uffff\1\4\2\uffff\1\4\1\uffff\1\46\17\4\4\uffff\7\4\1\uffff\4\4",
            "\1\47",
            "\1\50",
            "\1\11",
            "\1\4\12\uffff\1\52\17\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\51\1\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\4",
            "\1\14\3\uffff\1\4\4\uffff\1\4\6\uffff\1\4\2\uffff\1\4\1\uffff\20\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\2",
            "\1\53\24\uffff\1\44",
            "\1\54",
            "\1\55",
            "\1\56\36\uffff\1\57",
            "\1\4\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\2\uffff\1\50\1\uffff\7\4\1\uffff\4\4",
            "\1\36",
            "\1\60",
            "\1\61\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\30\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\62\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\2\4\17\uffff\1\4\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\6\4",
            "\1\63\36\uffff\1\64",
            "\1\44",
            "\1\65",
            "\1\45\24\uffff\1\36",
            "\1\66",
            "\1\67",
            "\1\14\3\uffff\1\4\13\uffff\1\4\2\uffff\1\4\1\uffff\20\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\2",
            "\1\4\12\uffff\1\52\17\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\51\1\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\4",
            "\1\53\24\uffff\1\44",
            "\1\70",
            "\1\71",
            "\1\36",
            "\1\uffff",
            "\1\44",
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
            return "5057:3: ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA90_20 = input.LA(1);

                         
                        int index90_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_InternalBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index90_20);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA90_27 = input.LA(1);

                         
                        int index90_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_InternalBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index90_27);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA90_57 = input.LA(1);

                         
                        int index90_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_InternalBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index90_57);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA90_55 = input.LA(1);

                         
                        int index90_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_InternalBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index90_55);
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
            return "5229:2: (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression )";
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
                        if ( (synpred137_InternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA91_4 = input.LA(1);

                         
                        int index91_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA91_6 = input.LA(1);

                         
                        int index91_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_6);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA91_7 = input.LA(1);

                         
                        int index91_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_7);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA91_8 = input.LA(1);

                         
                        int index91_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_8);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA91_9 = input.LA(1);

                         
                        int index91_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_9);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA91_10 = input.LA(1);

                         
                        int index91_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_10);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA91_11 = input.LA(1);

                         
                        int index91_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_11);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA91_12 = input.LA(1);

                         
                        int index91_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_12);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA91_13 = input.LA(1);

                         
                        int index91_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_13);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA91_14 = input.LA(1);

                         
                        int index91_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_14);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA91_15 = input.LA(1);

                         
                        int index91_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_15);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA91_16 = input.LA(1);

                         
                        int index91_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_16);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA91_17 = input.LA(1);

                         
                        int index91_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_17);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA91_18 = input.LA(1);

                         
                        int index91_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_18);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA91_19 = input.LA(1);

                         
                        int index91_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_19);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA91_20 = input.LA(1);

                         
                        int index91_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_20);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA91_21 = input.LA(1);

                         
                        int index91_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalBeeLangTestLanguage()) ) {s = 1;}

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
