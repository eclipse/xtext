package org.eclipse.xtend.caliper.tests.parser.minified; 
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendParserBase;
import org.eclipse.xtend.core.services.XtendGrammarAccess;
import static org.eclipse.xtend.core.xtend.XtendPackage.*;
import static org.eclipse.xtext.xbase.XbasePackage.*;
import static org.eclipse.xtext.xtype.XtypePackage.*;
import static org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage.*;
import static org.eclipse.xtext.common.types.TypesPackage.*;
import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalXtendParser extends InternalXtendParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_RICH_TEXT", "RULE_RICH_TEXT_START", "RULE_RICH_TEXT_INBETWEEN", "RULE_COMMENT_RICH_TEXT_INBETWEEN", "RULE_RICH_TEXT_END", "RULE_COMMENT_RICH_TEXT_END", "RULE_HEX", "RULE_INT", "RULE_DECIMAL", "RULE_IN_RICH_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "';'", "'class'", "'<'", "','", "'>'", "'extends'", "'implements'", "'{'", "'}'", "'interface'", "'enum'", "'annotation'", "'='", "'extension'", "'('", "')'", "'throws'", "'new'", "'public'", "'private'", "'protected'", "'abstract'", "'static'", "'dispatch'", "'final'", "'val'", "'var'", "'def'", "'override'", "'create'", "':'", "'import'", "'...'", "'FOR'", "'BEFORE'", "'SEPARATOR'", "'AFTER'", "'ENDFOR'", "'IF'", "'ELSE'", "'ENDIF'", "'ELSEIF'", "'@'", "'+'", "'+='", "'-='", "'||'", "'&&'", "'=='", "'!='", "'==='", "'!=='", "'instanceof'", "'>='", "'<='", "'->'", "'..<'", "'..'", "'=>'", "'<>'", "'?:'", "'<=>'", "'-'", "'*'", "'**'", "'/'", "'%'", "'!'", "'as'", "'.'", "'?.'", "'*.'", "'#'", "'['", "']'", "'|'", "'if'", "'else'", "'switch'", "'default'", "'case'", "'for'", "'while'", "'do'", "'super'", "'::'", "'false'", "'true'", "'null'", "'typeof'", "'throw'", "'return'", "'try'", "'finally'", "'catch'", "'?'", "'&'"
    };
    public static final int RULE_COMMENT_RICH_TEXT_INBETWEEN=9;
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=19;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_COMMENT_RICH_TEXT_END=11;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int RULE_HEX=12;
    public static final int T__92=92;
    public static final int T__90=90;
    public static final int RULE_RICH_TEXT_END=10;
    public static final int RULE_DECIMAL=14;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int RULE_IN_RICH_STRING=15;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int RULE_ML_COMMENT=16;
    public static final int RULE_STRING=5;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int RULE_RICH_TEXT_START=7;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int RULE_RICH_TEXT=6;
    public static final int T__63=63;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__59=59;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int RULE_INT=13;
    public static final int T__113=113;
    public static final int T__112=112;
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
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int RULE_SL_COMMENT=17;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_RICH_TEXT_INBETWEEN=8;
    public static final int RULE_WS=18;

        public InternalXtendParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXtendParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
        }
    public String[] getTokenNames() { return InternalXtendParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g"; }
     	private XtendGrammarAccess grammarAccess;
        public InternalXtendParser(TokenStream input, XtendGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        @Override
        protected String getFirstRuleName() {
        	return "File";	
       	}
       	@Override
       	protected XtendGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}

    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleFile = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.FileElements elementAccess = grammarAccess.getFileAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleFile_in_entryRuleFile81);
            iv_ruleFile=ruleFile();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFile; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFile91); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.FileElements elementAccess = grammarAccess.getFileAccess();
        try {

            {

            {
            int alt2=2;
            int LA2_0 = input.LA(1);
            if ( (LA2_0==20) ) {
                int LA2_1 = input.LA(2);
                if ( (LA2_1==RULE_ID||LA2_1==50) ) {
                    alt2=1;
                }
                else if ( (LA2_1==32) ) {
                    int LA2_4 = input.LA(3);
                    if ( (LA2_4==EOF||(LA2_4>=20 && LA2_4<=22)||(LA2_4>=30 && LA2_4<=31)||(LA2_4>=39 && LA2_4<=45)||LA2_4==52||LA2_4==63||LA2_4==90) ) {
                        alt2=1;
                    }
                    else if ( (LA2_4==32) ) {
                        int LA2_5 = input.LA(4);
                        if ( (LA2_5==RULE_ID||LA2_5==32||LA2_5==50) ) {
                            alt2=1;
                        }
                    }
                }
            }
            switch (alt2) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(20, FOLLOW_20_in_ruleFile129,  elementAccess.getPackageKeyword_0_0())) { return current; }


                    {

                    {
                    current = callRuleQualifiedNameAndSet(FOLLOW_ruleQualifiedName_in_ruleFile150, current, elementAccess.getPackageQualifiedNameParserRuleCall_0_1_0(), elementAccess.getRule(), XTEND_FILE__PACKAGE, "QualifiedName");
                    if (state.failed) return current;

                    }
                    }
                    int alt1=2;
                    int LA1_0 = input.LA(1);
                    if ( (LA1_0==21) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(21, FOLLOW_21_in_ruleFile163,  elementAccess.getSemicolonKeyword_0_2())) { return current; }

                            }
                            break;
                    }
                    }
                    break;
            }
            int alt3=2;
            int LA3_0 = input.LA(1);
            if ( (LA3_0==52) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    {

                    {
                    current = callRuleXImportSectionAndSet(FOLLOW_ruleXImportSection_in_ruleFile188, current, elementAccess.getImportSectionXImportSectionParserRuleCall_1_0(), elementAccess.getRule(), XTEND_FILE__IMPORT_SECTION, null);
                    if (state.failed) return current;

                    }
                    }
                    break;
            }
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);
                if ( (LA4_0==20||LA4_0==22||(LA4_0>=30 && LA4_0<=32)||(LA4_0>=39 && LA4_0<=45)||LA4_0==63) ) {
                    alt4=1;
                }
                switch (alt4) {
            	case 1 :
            	    {

            	    {
            	    current = callRuleTypeAndAdd(FOLLOW_ruleType_in_ruleFile210, current, elementAccess.getXtendTypesTypeParserRuleCall_2_0(), elementAccess.getRule(), XTEND_FILE__XTEND_TYPES, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    break;
            	default :
            	    break loop4;
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
        }
        return current;
    }

    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleType = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.TypeElements elementAccess = grammarAccess.getTypeAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType253);
            iv_ruleType=ruleType();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType263); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleType() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.TypeElements elementAccess = grammarAccess.getTypeAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXtendTypeDeclarationAction_0(),
                          current);
            }
            }
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);
                if ( (LA5_0==63) ) {
                    alt5=1;
                }
                switch (alt5) {
            	case 1 :
            	    {

            	    {
            	    current = callRuleXAnnotationAndAdd(FOLLOW_ruleXAnnotation_in_ruleType318, current, elementAccess.getAnnotationsXAnnotationParserRuleCall_1_0(), elementAccess.getRule(), XTEND_TYPE_DECLARATION__ANNOTATIONS, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    break;
            	default :
            	    break loop5;
                }
            } while (true);
            int alt25=4;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    {

                    {

                    {
                    if ( state.backtracking==0 ) {
                              current = forceCreateModelElementAndSet(
                                  elementAccess.getXtendClassAnnotationInfoAction_2_0_0(),
                                  XTEND_CLASS__ANNOTATION_INFO,
                                  current);
                    }
                    }
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);
                        if ( (LA6_0==20||(LA6_0>=39 && LA6_0<=45)) ) {
                            alt6=1;
                        }
                        switch (alt6) {
                    	case 1 :
                    	    {

                    	    {
                    	    current = callRuleCommonModifierAndAdd(FOLLOW_ruleCommonModifier_in_ruleType351, current, elementAccess.getModifiersCommonModifierParserRuleCall_2_0_1_0(), elementAccess.getRule(), XTEND_CLASS__MODIFIERS, "CommonModifier");
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop6;
                        }
                    } while (true);
                    if (!consumeUnassignedToken(22, FOLLOW_22_in_ruleType364,  elementAccess.getClassKeyword_2_0_2())) { return current; }


                    {

                    {
                    current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleType385, current, elementAccess.getNameValidIDParserRuleCall_2_0_3_0(), elementAccess.getRule(), XTEND_CLASS__NAME, "ValidID");
                    if (state.failed) return current;

                    }
                    }
                    int alt8=2;
                    int LA8_0 = input.LA(1);
                    if ( (LA8_0==23) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(23, FOLLOW_23_in_ruleType398,  elementAccess.getLessThanSignKeyword_2_0_4_0())) { return current; }


                            {

                            {
                            current = callRuleJvmTypeParameterAndAdd(FOLLOW_ruleJvmTypeParameter_in_ruleType419, current, elementAccess.getTypeParametersJvmTypeParameterParserRuleCall_2_0_4_1_0(), elementAccess.getRule(), XTEND_CLASS__TYPE_PARAMETERS, null);
                            if (state.failed) return current;

                            }
                            }
                            loop7:
                            do {
                                int alt7=2;
                                int LA7_0 = input.LA(1);
                                if ( (LA7_0==24) ) {
                                    alt7=1;
                                }
                                switch (alt7) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleType432,  elementAccess.getCommaKeyword_2_0_4_2_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleJvmTypeParameterAndAdd(FOLLOW_ruleJvmTypeParameter_in_ruleType453, current, elementAccess.getTypeParametersJvmTypeParameterParserRuleCall_2_0_4_2_1_0(), elementAccess.getRule(), XTEND_CLASS__TYPE_PARAMETERS, null);
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop7;
                                }
                            } while (true);
                            if (!consumeUnassignedToken(25, FOLLOW_25_in_ruleType467,  elementAccess.getGreaterThanSignKeyword_2_0_4_3())) { return current; }

                            }
                            break;
                    }
                    int alt9=2;
                    int LA9_0 = input.LA(1);
                    if ( (LA9_0==26) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(26, FOLLOW_26_in_ruleType482,  elementAccess.getExtendsKeyword_2_0_5_0())) { return current; }


                            {

                            {
                            current = callRuleJvmParameterizedTypeReferenceAndSet(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleType503, current, elementAccess.getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_0_5_1_0(), elementAccess.getRule(), XTEND_CLASS__EXTENDS, null);
                            if (state.failed) return current;

                            }
                            }
                            }
                            break;
                    }
                    int alt11=2;
                    int LA11_0 = input.LA(1);
                    if ( (LA11_0==27) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(27, FOLLOW_27_in_ruleType518,  elementAccess.getImplementsKeyword_2_0_6_0())) { return current; }


                            {

                            {
                            current = callRuleJvmParameterizedTypeReferenceAndAdd(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleType539, current, elementAccess.getImplementsJvmParameterizedTypeReferenceParserRuleCall_2_0_6_1_0(), elementAccess.getRule(), XTEND_CLASS__IMPLEMENTS, null);
                            if (state.failed) return current;

                            }
                            }
                            loop10:
                            do {
                                int alt10=2;
                                int LA10_0 = input.LA(1);
                                if ( (LA10_0==24) ) {
                                    alt10=1;
                                }
                                switch (alt10) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleType552,  elementAccess.getCommaKeyword_2_0_6_2_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleJvmParameterizedTypeReferenceAndAdd(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleType573, current, elementAccess.getImplementsJvmParameterizedTypeReferenceParserRuleCall_2_0_6_2_1_0(), elementAccess.getRule(), XTEND_CLASS__IMPLEMENTS, null);
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop10;
                                }
                            } while (true);
                            }
                            break;
                    }
                    if (!consumeUnassignedToken(28, FOLLOW_28_in_ruleType589,  elementAccess.getLeftCurlyBracketKeyword_2_0_7())) { return current; }

                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);
                        if ( (LA12_0==RULE_ID||LA12_0==20||LA12_0==32||(LA12_0>=34 && LA12_0<=35)||(LA12_0>=38 && LA12_0<=50)||LA12_0==63||LA12_0==79) ) {
                            alt12=1;
                        }
                        switch (alt12) {
                    	case 1 :
                    	    {

                    	    {
                    	    current = callRuleMemberAndAdd(FOLLOW_ruleMember_in_ruleType610, current, elementAccess.getMembersMemberParserRuleCall_2_0_8_0(), elementAccess.getRule(), XTEND_CLASS__MEMBERS, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop12;
                        }
                    } while (true);
                    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleType623,  elementAccess.getRightCurlyBracketKeyword_2_0_9())) { return current; }

                    }
                    }
                    break;
                case 2 :
                    {

                    {

                    {
                    if ( state.backtracking==0 ) {
                              current = forceCreateModelElementAndSet(
                                  elementAccess.getXtendInterfaceAnnotationInfoAction_2_1_0(),
                                  XTEND_INTERFACE__ANNOTATION_INFO,
                                  current);
                    }
                    }
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);
                        if ( (LA13_0==20||(LA13_0>=39 && LA13_0<=45)) ) {
                            alt13=1;
                        }
                        switch (alt13) {
                    	case 1 :
                    	    {

                    	    {
                    	    current = callRuleCommonModifierAndAdd(FOLLOW_ruleCommonModifier_in_ruleType661, current, elementAccess.getModifiersCommonModifierParserRuleCall_2_1_1_0(), elementAccess.getRule(), XTEND_INTERFACE__MODIFIERS, "CommonModifier");
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop13;
                        }
                    } while (true);
                    if (!consumeUnassignedToken(30, FOLLOW_30_in_ruleType674,  elementAccess.getInterfaceKeyword_2_1_2())) { return current; }


                    {

                    {
                    current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleType695, current, elementAccess.getNameValidIDParserRuleCall_2_1_3_0(), elementAccess.getRule(), XTEND_INTERFACE__NAME, "ValidID");
                    if (state.failed) return current;

                    }
                    }
                    int alt15=2;
                    int LA15_0 = input.LA(1);
                    if ( (LA15_0==23) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(23, FOLLOW_23_in_ruleType708,  elementAccess.getLessThanSignKeyword_2_1_4_0())) { return current; }


                            {

                            {
                            current = callRuleJvmTypeParameterAndAdd(FOLLOW_ruleJvmTypeParameter_in_ruleType729, current, elementAccess.getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0(), elementAccess.getRule(), XTEND_INTERFACE__TYPE_PARAMETERS, null);
                            if (state.failed) return current;

                            }
                            }
                            loop14:
                            do {
                                int alt14=2;
                                int LA14_0 = input.LA(1);
                                if ( (LA14_0==24) ) {
                                    alt14=1;
                                }
                                switch (alt14) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleType742,  elementAccess.getCommaKeyword_2_1_4_2_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleJvmTypeParameterAndAdd(FOLLOW_ruleJvmTypeParameter_in_ruleType763, current, elementAccess.getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0(), elementAccess.getRule(), XTEND_INTERFACE__TYPE_PARAMETERS, null);
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop14;
                                }
                            } while (true);
                            if (!consumeUnassignedToken(25, FOLLOW_25_in_ruleType777,  elementAccess.getGreaterThanSignKeyword_2_1_4_3())) { return current; }

                            }
                            break;
                    }
                    int alt17=2;
                    int LA17_0 = input.LA(1);
                    if ( (LA17_0==26) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(26, FOLLOW_26_in_ruleType792,  elementAccess.getExtendsKeyword_2_1_5_0())) { return current; }


                            {

                            {
                            current = callRuleJvmParameterizedTypeReferenceAndAdd(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleType813, current, elementAccess.getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_1_5_1_0(), elementAccess.getRule(), XTEND_INTERFACE__EXTENDS, null);
                            if (state.failed) return current;

                            }
                            }
                            loop16:
                            do {
                                int alt16=2;
                                int LA16_0 = input.LA(1);
                                if ( (LA16_0==24) ) {
                                    alt16=1;
                                }
                                switch (alt16) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleType826,  elementAccess.getCommaKeyword_2_1_5_2_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleJvmParameterizedTypeReferenceAndAdd(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleType847, current, elementAccess.getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_1_5_2_1_0(), elementAccess.getRule(), XTEND_INTERFACE__EXTENDS, null);
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop16;
                                }
                            } while (true);
                            }
                            break;
                    }
                    if (!consumeUnassignedToken(28, FOLLOW_28_in_ruleType863,  elementAccess.getLeftCurlyBracketKeyword_2_1_6())) { return current; }

                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);
                        if ( (LA18_0==RULE_ID||LA18_0==20||LA18_0==32||(LA18_0>=34 && LA18_0<=35)||(LA18_0>=38 && LA18_0<=50)||LA18_0==63||LA18_0==79) ) {
                            alt18=1;
                        }
                        switch (alt18) {
                    	case 1 :
                    	    {

                    	    {
                    	    current = callRuleMemberAndAdd(FOLLOW_ruleMember_in_ruleType884, current, elementAccess.getMembersMemberParserRuleCall_2_1_7_0(), elementAccess.getRule(), XTEND_INTERFACE__MEMBERS, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop18;
                        }
                    } while (true);
                    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleType897,  elementAccess.getRightCurlyBracketKeyword_2_1_8())) { return current; }

                    }
                    }
                    break;
                case 3 :
                    {

                    {

                    {
                    if ( state.backtracking==0 ) {
                              current = forceCreateModelElementAndSet(
                                  elementAccess.getXtendEnumAnnotationInfoAction_2_2_0(),
                                  XTEND_ENUM__ANNOTATION_INFO,
                                  current);
                    }
                    }
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);
                        if ( (LA19_0==20||(LA19_0>=39 && LA19_0<=45)) ) {
                            alt19=1;
                        }
                        switch (alt19) {
                    	case 1 :
                    	    {

                    	    {
                    	    current = callRuleCommonModifierAndAdd(FOLLOW_ruleCommonModifier_in_ruleType935, current, elementAccess.getModifiersCommonModifierParserRuleCall_2_2_1_0(), elementAccess.getRule(), XTEND_ENUM__MODIFIERS, "CommonModifier");
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop19;
                        }
                    } while (true);
                    if (!consumeUnassignedToken(31, FOLLOW_31_in_ruleType948,  elementAccess.getEnumKeyword_2_2_2())) { return current; }


                    {

                    {
                    current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleType969, current, elementAccess.getNameValidIDParserRuleCall_2_2_3_0(), elementAccess.getRule(), XTEND_ENUM__NAME, "ValidID");
                    if (state.failed) return current;

                    }
                    }
                    if (!consumeUnassignedToken(28, FOLLOW_28_in_ruleType981,  elementAccess.getLeftCurlyBracketKeyword_2_2_4())) { return current; }

                    int alt21=2;
                    int LA21_0 = input.LA(1);
                    if ( (LA21_0==RULE_ID||LA21_0==32||LA21_0==50) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            {

                            {

                            {
                            current = callRuleXtendEnumLiteralAndAdd(FOLLOW_ruleXtendEnumLiteral_in_ruleType1003, current, elementAccess.getMembersXtendEnumLiteralParserRuleCall_2_2_5_0_0(), elementAccess.getRule(), XTEND_ENUM__MEMBERS, null);
                            if (state.failed) return current;

                            }
                            }
                            loop20:
                            do {
                                int alt20=2;
                                int LA20_0 = input.LA(1);
                                if ( (LA20_0==24) ) {
                                    alt20=1;
                                }
                                switch (alt20) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleType1016,  elementAccess.getCommaKeyword_2_2_5_1_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleXtendEnumLiteralAndAdd(FOLLOW_ruleXtendEnumLiteral_in_ruleType1037, current, elementAccess.getMembersXtendEnumLiteralParserRuleCall_2_2_5_1_1_0(), elementAccess.getRule(), XTEND_ENUM__MEMBERS, null);
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop20;
                                }
                            } while (true);
                            }
                            break;
                    }
                    int alt22=2;
                    int LA22_0 = input.LA(1);
                    if ( (LA22_0==21) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(21, FOLLOW_21_in_ruleType1054,  elementAccess.getSemicolonKeyword_2_2_6())) { return current; }

                            }
                            break;
                    }
                    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleType1068,  elementAccess.getRightCurlyBracketKeyword_2_2_7())) { return current; }

                    }
                    }
                    break;
                case 4 :
                    {

                    {

                    {
                    if ( state.backtracking==0 ) {
                              current = forceCreateModelElementAndSet(
                                  elementAccess.getXtendAnnotationTypeAnnotationInfoAction_2_3_0(),
                                  XTEND_ANNOTATION_TYPE__ANNOTATION_INFO,
                                  current);
                    }
                    }
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);
                        if ( (LA23_0==20||(LA23_0>=39 && LA23_0<=45)) ) {
                            alt23=1;
                        }
                        switch (alt23) {
                    	case 1 :
                    	    {

                    	    {
                    	    current = callRuleCommonModifierAndAdd(FOLLOW_ruleCommonModifier_in_ruleType1106, current, elementAccess.getModifiersCommonModifierParserRuleCall_2_3_1_0(), elementAccess.getRule(), XTEND_ANNOTATION_TYPE__MODIFIERS, "CommonModifier");
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop23;
                        }
                    } while (true);
                    if (!consumeUnassignedToken(32, FOLLOW_32_in_ruleType1119,  elementAccess.getAnnotationKeyword_2_3_2())) { return current; }


                    {

                    {
                    current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleType1140, current, elementAccess.getNameValidIDParserRuleCall_2_3_3_0(), elementAccess.getRule(), XTEND_ANNOTATION_TYPE__NAME, "ValidID");
                    if (state.failed) return current;

                    }
                    }
                    if (!consumeUnassignedToken(28, FOLLOW_28_in_ruleType1152,  elementAccess.getLeftCurlyBracketKeyword_2_3_4())) { return current; }

                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);
                        if ( (LA24_0==RULE_ID||LA24_0==20||LA24_0==32||LA24_0==35||(LA24_0>=39 && LA24_0<=47)||LA24_0==50||LA24_0==63||LA24_0==79) ) {
                            alt24=1;
                        }
                        switch (alt24) {
                    	case 1 :
                    	    {

                    	    {
                    	    current = callRuleAnnotationFieldAndAdd(FOLLOW_ruleAnnotationField_in_ruleType1173, current, elementAccess.getMembersAnnotationFieldParserRuleCall_2_3_5_0(), elementAccess.getRule(), XTEND_ANNOTATION_TYPE__MEMBERS, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop24;
                        }
                    } while (true);
                    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleType1186,  elementAccess.getRightCurlyBracketKeyword_2_3_6())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleAnnotationField() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleAnnotationField = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.AnnotationFieldElements elementAccess = grammarAccess.getAnnotationFieldAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleAnnotationField_in_entryRuleAnnotationField1230);
            iv_ruleAnnotationField=ruleAnnotationField();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnnotationField; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotationField1240); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleAnnotationField() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.AnnotationFieldElements elementAccess = grammarAccess.getAnnotationFieldAccess();
        try {

            {

            {
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);
                if ( (LA26_0==63) ) {
                    alt26=1;
                }
                switch (alt26) {
            	case 1 :
            	    {

            	    {
            	    current = callRuleXAnnotationAndAdd(FOLLOW_ruleXAnnotation_in_ruleAnnotationField1286, current, elementAccess.getAnnotationsXAnnotationParserRuleCall_0_0(), elementAccess.getRule(), XTEND_FIELD__ANNOTATIONS, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    break;
            	default :
            	    break loop26;
                }
            } while (true);
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);
                if ( (LA27_0==20||(LA27_0>=39 && LA27_0<=45)) ) {
                    alt27=1;
                }
                switch (alt27) {
            	case 1 :
            	    {

            	    {
            	    current = callRuleCommonModifierAndAdd(FOLLOW_ruleCommonModifier_in_ruleAnnotationField1308, current, elementAccess.getModifiersCommonModifierParserRuleCall_1_0(), elementAccess.getRule(), XTEND_FIELD__MODIFIERS, "CommonModifier");
            	    if (state.failed) return current;

            	    }
            	    }
            	    break;
            	default :
            	    break loop27;
                }
            } while (true);
            int alt30=2;
            int LA30_0 = input.LA(1);
            if ( ((LA30_0>=46 && LA30_0<=47)) ) {
                alt30=1;
            }
            else if ( (LA30_0==RULE_ID||LA30_0==32||LA30_0==35||LA30_0==50||LA30_0==79) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);
                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    {

                    {

                    {

                    {
                    current = callRuleFieldModifierAndAdd(FOLLOW_ruleFieldModifier_in_ruleAnnotationField1332, current, elementAccess.getModifiersFieldModifierParserRuleCall_2_0_0_0(), elementAccess.getRule(), XTEND_FIELD__MODIFIERS, "FieldModifier");
                    if (state.failed) return current;

                    }
                    }
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);
                        if ( (LA28_0==20||(LA28_0>=39 && LA28_0<=45)) ) {
                            alt28=1;
                        }
                        switch (alt28) {
                    	case 1 :
                    	    {

                    	    {
                    	    current = callRuleCommonModifierAndAdd(FOLLOW_ruleCommonModifier_in_ruleAnnotationField1353, current, elementAccess.getModifiersCommonModifierParserRuleCall_2_0_1_0(), elementAccess.getRule(), XTEND_FIELD__MODIFIERS, "CommonModifier");
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop28;
                        }
                    } while (true);
                    int alt29=2;
                    alt29 = dfa29.predict(input);
                    switch (alt29) {
                        case 1 :
                            {

                            {
                            current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleAnnotationField1375, current, elementAccess.getTypeJvmTypeReferenceParserRuleCall_2_0_2_0(), elementAccess.getRule(), XTEND_FIELD__TYPE, null);
                            if (state.failed) return current;

                            }
                            }
                            break;
                    }

                    {

                    {
                    current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleAnnotationField1397, current, elementAccess.getNameValidIDParserRuleCall_2_0_3_0(), elementAccess.getRule(), XTEND_FIELD__NAME, "ValidID");
                    if (state.failed) return current;

                    }
                    }
                    }
                    }
                    break;
                case 2 :
                    {

                    {

                    {

                    {
                    current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleAnnotationField1426, current, elementAccess.getTypeJvmTypeReferenceParserRuleCall_2_1_0_0(), elementAccess.getRule(), XTEND_FIELD__TYPE, null);
                    if (state.failed) return current;

                    }
                    }

                    {

                    {
                    current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleAnnotationField1447, current, elementAccess.getNameValidIDParserRuleCall_2_1_1_0(), elementAccess.getRule(), XTEND_FIELD__NAME, "ValidID");
                    if (state.failed) return current;

                    }
                    }
                    }
                    }
                    break;
            }
            int alt31=2;
            int LA31_0 = input.LA(1);
            if ( (LA31_0==33) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(33, FOLLOW_33_in_ruleAnnotationField1462,  elementAccess.getEqualsSignKeyword_3_0())) { return current; }


                    {

                    {
                    current = callRuleXAnnotationElementValueAndSet(FOLLOW_ruleXAnnotationElementValue_in_ruleAnnotationField1483, current, elementAccess.getInitialValueXAnnotationElementValueParserRuleCall_3_1_0(), elementAccess.getRule(), XTEND_FIELD__INITIAL_VALUE, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    break;
            }
            int alt32=2;
            int LA32_0 = input.LA(1);
            if ( (LA32_0==21) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(21, FOLLOW_21_in_ruleAnnotationField1498,  elementAccess.getSemicolonKeyword_4())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleMember() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleMember = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.MemberElements elementAccess = grammarAccess.getMemberAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleMember_in_entryRuleMember1542);
            iv_ruleMember=ruleMember();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMember; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMember1552); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleMember() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.MemberElements elementAccess = grammarAccess.getMemberAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXtendMemberAction_0(),
                          current);
            }
            }
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);
                if ( (LA33_0==63) ) {
                    alt33=1;
                }
                switch (alt33) {
            	case 1 :
            	    {

            	    {
            	    current = callRuleXAnnotationAndAdd(FOLLOW_ruleXAnnotation_in_ruleMember1607, current, elementAccess.getAnnotationsXAnnotationParserRuleCall_1_0(), elementAccess.getRule(), XTEND_MEMBER__ANNOTATIONS, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    break;
            	default :
            	    break loop33;
                }
            } while (true);
            int alt62=3;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    {

                    {

                    {
                    if ( state.backtracking==0 ) {
                              current = forceCreateModelElementAndSet(
                                  elementAccess.getXtendFieldAnnotationInfoAction_2_0_0(),
                                  XTEND_FIELD__ANNOTATION_INFO,
                                  current);
                    }
                    }
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);
                        if ( (LA34_0==20||(LA34_0>=39 && LA34_0<=45)) ) {
                            alt34=1;
                        }
                        switch (alt34) {
                    	case 1 :
                    	    {

                    	    {
                    	    current = callRuleCommonModifierAndAdd(FOLLOW_ruleCommonModifier_in_ruleMember1640, current, elementAccess.getModifiersCommonModifierParserRuleCall_2_0_1_0(), elementAccess.getRule(), XTEND_FIELD__MODIFIERS, "CommonModifier");
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop34;
                        }
                    } while (true);
                    int alt42=4;
                    alt42 = dfa42.predict(input);
                    switch (alt42) {
                        case 1 :
                            {

                            {

                            {

                            {
                            current = callRuleFieldModifierAndAdd(FOLLOW_ruleFieldModifier_in_ruleMember1664, current, elementAccess.getModifiersFieldModifierParserRuleCall_2_0_2_0_0_0(), elementAccess.getRule(), XTEND_FIELD__MODIFIERS, "FieldModifier");
                            if (state.failed) return current;

                            }
                            }
                            loop35:
                            do {
                                int alt35=2;
                                int LA35_0 = input.LA(1);
                                if ( (LA35_0==20||(LA35_0>=39 && LA35_0<=45)) ) {
                                    alt35=1;
                                }
                                switch (alt35) {
                            	case 1 :
                            	    {

                            	    {
                            	    current = callRuleCommonModifierAndAdd(FOLLOW_ruleCommonModifier_in_ruleMember1685, current, elementAccess.getModifiersCommonModifierParserRuleCall_2_0_2_0_1_0(), elementAccess.getRule(), XTEND_FIELD__MODIFIERS, "CommonModifier");
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop35;
                                }
                            } while (true);
                            int alt36=2;
                            alt36 = dfa36.predict(input);
                            switch (alt36) {
                                case 1 :
                                    {

                                    {
                                    current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleMember1707, current, elementAccess.getTypeJvmTypeReferenceParserRuleCall_2_0_2_0_2_0(), elementAccess.getRule(), XTEND_FIELD__TYPE, null);
                                    if (state.failed) return current;

                                    }
                                    }
                                    break;
                            }

                            {

                            {
                            current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleMember1729, current, elementAccess.getNameValidIDParserRuleCall_2_0_2_0_3_0(), elementAccess.getRule(), XTEND_FIELD__NAME, "ValidID");
                            if (state.failed) return current;

                            }
                            }
                            }
                            }
                            break;
                        case 2 :
                            {

                            {

                            {

                            {
                            current = consumeTokenAndAdd(34, FOLLOW_34_in_ruleMember1755, current,  elementAccess.getModifiersExtensionKeyword_2_0_2_1_0_0(), elementAccess.getRule(), XTEND_FIELD__MODIFIERS);
                            if (state.failed) return current;

                            }
                            }
                            loop37:
                            do {
                                int alt37=3;
                                int LA37_0 = input.LA(1);
                                if ( ((LA37_0>=46 && LA37_0<=47)) ) {
                                    alt37=1;
                                }
                                else if ( (LA37_0==20||(LA37_0>=39 && LA37_0<=45)) ) {
                                    alt37=2;
                                }
                                switch (alt37) {
                            	case 1 :
                            	    {

                            	    {

                            	    {
                            	    current = callRuleFieldModifierAndAdd(FOLLOW_ruleFieldModifier_in_ruleMember1790, current, elementAccess.getModifiersFieldModifierParserRuleCall_2_0_2_1_1_0_0(), elementAccess.getRule(), XTEND_FIELD__MODIFIERS, "FieldModifier");
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    }
                            	    break;
                            	case 2 :
                            	    {

                            	    {

                            	    {
                            	    current = callRuleCommonModifierAndAdd(FOLLOW_ruleCommonModifier_in_ruleMember1817, current, elementAccess.getModifiersCommonModifierParserRuleCall_2_0_2_1_1_1_0(), elementAccess.getRule(), XTEND_FIELD__MODIFIERS, "CommonModifier");
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop37;
                                }
                            } while (true);

                            {

                            {
                            current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleMember1840, current, elementAccess.getTypeJvmTypeReferenceParserRuleCall_2_0_2_1_2_0(), elementAccess.getRule(), XTEND_FIELD__TYPE, null);
                            if (state.failed) return current;

                            }
                            }
                            int alt38=2;
                            alt38 = dfa38.predict(input);
                            switch (alt38) {
                                case 1 :
                                    {

                                    {
                                    current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleMember1861, current, elementAccess.getNameValidIDParserRuleCall_2_0_2_1_3_0(), elementAccess.getRule(), XTEND_FIELD__NAME, "ValidID");
                                    if (state.failed) return current;

                                    }
                                    }
                                    break;
                            }
                            }
                            }
                            break;
                        case 3 :
                            {

                            {

                            {

                            {
                            current = callRuleFieldModifierAndAdd(FOLLOW_ruleFieldModifier_in_ruleMember1891, current, elementAccess.getModifiersFieldModifierParserRuleCall_2_0_2_2_0_0(), elementAccess.getRule(), XTEND_FIELD__MODIFIERS, "FieldModifier");
                            if (state.failed) return current;

                            }
                            }
                            loop39:
                            do {
                                int alt39=2;
                                int LA39_0 = input.LA(1);
                                if ( (LA39_0==20||(LA39_0>=39 && LA39_0<=45)) ) {
                                    alt39=1;
                                }
                                switch (alt39) {
                            	case 1 :
                            	    {

                            	    {
                            	    current = callRuleCommonModifierAndAdd(FOLLOW_ruleCommonModifier_in_ruleMember1912, current, elementAccess.getModifiersCommonModifierParserRuleCall_2_0_2_2_1_0(), elementAccess.getRule(), XTEND_FIELD__MODIFIERS, "CommonModifier");
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop39;
                                }
                            } while (true);

                            {

                            {
                            current = consumeTokenAndAdd(34, FOLLOW_34_in_ruleMember1931, current,  elementAccess.getModifiersExtensionKeyword_2_0_2_2_2_0(), elementAccess.getRule(), XTEND_FIELD__MODIFIERS);
                            if (state.failed) return current;

                            }
                            }
                            loop40:
                            do {
                                int alt40=2;
                                int LA40_0 = input.LA(1);
                                if ( (LA40_0==20||(LA40_0>=39 && LA40_0<=45)) ) {
                                    alt40=1;
                                }
                                switch (alt40) {
                            	case 1 :
                            	    {

                            	    {
                            	    current = callRuleCommonModifierAndAdd(FOLLOW_ruleCommonModifier_in_ruleMember1965, current, elementAccess.getModifiersCommonModifierParserRuleCall_2_0_2_2_3_0(), elementAccess.getRule(), XTEND_FIELD__MODIFIERS, "CommonModifier");
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop40;
                                }
                            } while (true);

                            {

                            {
                            current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleMember1987, current, elementAccess.getTypeJvmTypeReferenceParserRuleCall_2_0_2_2_4_0(), elementAccess.getRule(), XTEND_FIELD__TYPE, null);
                            if (state.failed) return current;

                            }
                            }
                            int alt41=2;
                            alt41 = dfa41.predict(input);
                            switch (alt41) {
                                case 1 :
                                    {

                                    {
                                    current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleMember2008, current, elementAccess.getNameValidIDParserRuleCall_2_0_2_2_5_0(), elementAccess.getRule(), XTEND_FIELD__NAME, "ValidID");
                                    if (state.failed) return current;

                                    }
                                    }
                                    break;
                            }
                            }
                            }
                            break;
                        case 4 :
                            {

                            {

                            {

                            {
                            current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleMember2038, current, elementAccess.getTypeJvmTypeReferenceParserRuleCall_2_0_2_3_0_0(), elementAccess.getRule(), XTEND_FIELD__TYPE, null);
                            if (state.failed) return current;

                            }
                            }

                            {

                            {
                            current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleMember2059, current, elementAccess.getNameValidIDParserRuleCall_2_0_2_3_1_0(), elementAccess.getRule(), XTEND_FIELD__NAME, "ValidID");
                            if (state.failed) return current;

                            }
                            }
                            }
                            }
                            break;
                    }
                    int alt43=2;
                    int LA43_0 = input.LA(1);
                    if ( (LA43_0==33) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(33, FOLLOW_33_in_ruleMember2074,  elementAccess.getEqualsSignKeyword_2_0_3_0())) { return current; }


                            {

                            {
                            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleMember2095, current, elementAccess.getInitialValueXExpressionParserRuleCall_2_0_3_1_0(), elementAccess.getRule(), XTEND_FIELD__INITIAL_VALUE, null);
                            if (state.failed) return current;

                            }
                            }
                            }
                            break;
                    }
                    int alt44=2;
                    int LA44_0 = input.LA(1);
                    if ( (LA44_0==21) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(21, FOLLOW_21_in_ruleMember2110,  elementAccess.getSemicolonKeyword_2_0_4())) { return current; }

                            }
                            break;
                    }
                    }
                    }
                    break;
                case 2 :
                    {

                    {

                    {
                    if ( state.backtracking==0 ) {
                              current = forceCreateModelElementAndSet(
                                  elementAccess.getXtendFunctionAnnotationInfoAction_2_1_0(),
                                  XTEND_FUNCTION__ANNOTATION_INFO,
                                  current);
                    }
                    }
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);
                        if ( (LA45_0==20||(LA45_0>=39 && LA45_0<=45)) ) {
                            alt45=1;
                        }
                        switch (alt45) {
                    	case 1 :
                    	    {

                    	    {
                    	    current = callRuleCommonModifierAndAdd(FOLLOW_ruleCommonModifier_in_ruleMember2150, current, elementAccess.getModifiersCommonModifierParserRuleCall_2_1_1_0(), elementAccess.getRule(), XTEND_FUNCTION__MODIFIERS, "CommonModifier");
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop45;
                        }
                    } while (true);

                    {

                    {
                    current = callRuleMethodModifierAndAdd(FOLLOW_ruleMethodModifier_in_ruleMember2172, current, elementAccess.getModifiersMethodModifierParserRuleCall_2_1_2_0(), elementAccess.getRule(), XTEND_FUNCTION__MODIFIERS, "MethodModifier");
                    if (state.failed) return current;

                    }
                    }
                    loop46:
                    do {
                        int alt46=3;
                        int LA46_0 = input.LA(1);
                        if ( (LA46_0==20||(LA46_0>=39 && LA46_0<=45)) ) {
                            alt46=1;
                        }
                        else if ( ((LA46_0>=48 && LA46_0<=49)) ) {
                            alt46=2;
                        }
                        switch (alt46) {
                    	case 1 :
                    	    {

                    	    {

                    	    {
                    	    current = callRuleCommonModifierAndAdd(FOLLOW_ruleCommonModifier_in_ruleMember2194, current, elementAccess.getModifiersCommonModifierParserRuleCall_2_1_3_0_0(), elementAccess.getRule(), XTEND_FUNCTION__MODIFIERS, "CommonModifier");
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    }
                    	    break;
                    	case 2 :
                    	    {

                    	    {

                    	    {
                    	    current = callRuleMethodModifierAndAdd(FOLLOW_ruleMethodModifier_in_ruleMember2221, current, elementAccess.getModifiersMethodModifierParserRuleCall_2_1_3_1_0(), elementAccess.getRule(), XTEND_FUNCTION__MODIFIERS, "MethodModifier");
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop46;
                        }
                    } while (true);
                    int alt48=2;
                    int LA48_0 = input.LA(1);
                    if ( (LA48_0==23) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(23, FOLLOW_23_in_ruleMember2236,  elementAccess.getLessThanSignKeyword_2_1_4_0())) { return current; }


                            {

                            {
                            current = callRuleJvmTypeParameterAndAdd(FOLLOW_ruleJvmTypeParameter_in_ruleMember2257, current, elementAccess.getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0(), elementAccess.getRule(), XTEND_FUNCTION__TYPE_PARAMETERS, null);
                            if (state.failed) return current;

                            }
                            }
                            loop47:
                            do {
                                int alt47=2;
                                int LA47_0 = input.LA(1);
                                if ( (LA47_0==24) ) {
                                    alt47=1;
                                }
                                switch (alt47) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleMember2270,  elementAccess.getCommaKeyword_2_1_4_2_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleJvmTypeParameterAndAdd(FOLLOW_ruleJvmTypeParameter_in_ruleMember2291, current, elementAccess.getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0(), elementAccess.getRule(), XTEND_FUNCTION__TYPE_PARAMETERS, null);
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop47;
                                }
                            } while (true);
                            if (!consumeUnassignedToken(25, FOLLOW_25_in_ruleMember2305,  elementAccess.getGreaterThanSignKeyword_2_1_4_3())) { return current; }

                            }
                            break;
                    }
                    int alt49=4;
                    alt49 = dfa49.predict(input);
                    switch (alt49) {
                        case 1 :
                            {

                            {

                            {

                            {

                            {
                            current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleMember2367, current, elementAccess.getReturnTypeJvmTypeReferenceParserRuleCall_2_1_5_0_0_0_0(), elementAccess.getRule(), XTEND_FUNCTION__RETURN_TYPE, null);
                            if (state.failed) return current;

                            }
                            }

                            {

                            {
                            current = callRuleCreateExtensionInfoAndSet(FOLLOW_ruleCreateExtensionInfo_in_ruleMember2388, current, elementAccess.getCreateExtensionInfoCreateExtensionInfoParserRuleCall_2_1_5_0_0_1_0(), elementAccess.getRule(), XTEND_FUNCTION__CREATE_EXTENSION_INFO, null);
                            if (state.failed) return current;

                            }
                            }

                            {

                            {
                            current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleMember2409, current, elementAccess.getNameValidIDParserRuleCall_2_1_5_0_0_2_0(), elementAccess.getRule(), XTEND_FUNCTION__NAME, "ValidID");
                            if (state.failed) return current;

                            }
                            }
                            if (!consumeUnassignedToken(35, FOLLOW_35_in_ruleMember2421,  elementAccess.getLeftParenthesisKeyword_2_1_5_0_0_3())) { return current; }

                            }
                            }
                            }
                            break;
                        case 2 :
                            {

                            {

                            {

                            {

                            {
                            current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleMember2479, current, elementAccess.getReturnTypeJvmTypeReferenceParserRuleCall_2_1_5_1_0_0_0(), elementAccess.getRule(), XTEND_FUNCTION__RETURN_TYPE, null);
                            if (state.failed) return current;

                            }
                            }

                            {

                            {
                            current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleMember2500, current, elementAccess.getNameValidIDParserRuleCall_2_1_5_1_0_1_0(), elementAccess.getRule(), XTEND_FUNCTION__NAME, "ValidID");
                            if (state.failed) return current;

                            }
                            }
                            if (!consumeUnassignedToken(35, FOLLOW_35_in_ruleMember2512,  elementAccess.getLeftParenthesisKeyword_2_1_5_1_0_2())) { return current; }

                            }
                            }
                            }
                            break;
                        case 3 :
                            {

                            {

                            {

                            {

                            {
                            current = callRuleCreateExtensionInfoAndSet(FOLLOW_ruleCreateExtensionInfo_in_ruleMember2570, current, elementAccess.getCreateExtensionInfoCreateExtensionInfoParserRuleCall_2_1_5_2_0_0_0(), elementAccess.getRule(), XTEND_FUNCTION__CREATE_EXTENSION_INFO, null);
                            if (state.failed) return current;

                            }
                            }

                            {

                            {
                            current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleMember2591, current, elementAccess.getNameValidIDParserRuleCall_2_1_5_2_0_1_0(), elementAccess.getRule(), XTEND_FUNCTION__NAME, "ValidID");
                            if (state.failed) return current;

                            }
                            }
                            if (!consumeUnassignedToken(35, FOLLOW_35_in_ruleMember2603,  elementAccess.getLeftParenthesisKeyword_2_1_5_2_0_2())) { return current; }

                            }
                            }
                            }
                            break;
                        case 4 :
                            {

                            {

                            {

                            {
                            current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleMember2633, current, elementAccess.getNameValidIDParserRuleCall_2_1_5_3_0_0(), elementAccess.getRule(), XTEND_FUNCTION__NAME, "ValidID");
                            if (state.failed) return current;

                            }
                            }
                            if (!consumeUnassignedToken(35, FOLLOW_35_in_ruleMember2645,  elementAccess.getLeftParenthesisKeyword_2_1_5_3_1())) { return current; }

                            }
                            }
                            break;
                    }
                    int alt51=2;
                    int LA51_0 = input.LA(1);
                    if ( (LA51_0==RULE_ID||LA51_0==32||(LA51_0>=34 && LA51_0<=35)||LA51_0==50||LA51_0==63||LA51_0==79) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            {

                            {

                            {
                            current = callRuleParameterAndAdd(FOLLOW_ruleParameter_in_ruleMember2669, current, elementAccess.getParametersParameterParserRuleCall_2_1_6_0_0(), elementAccess.getRule(), XTEND_FUNCTION__PARAMETERS, null);
                            if (state.failed) return current;

                            }
                            }
                            loop50:
                            do {
                                int alt50=2;
                                int LA50_0 = input.LA(1);
                                if ( (LA50_0==24) ) {
                                    alt50=1;
                                }
                                switch (alt50) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleMember2682,  elementAccess.getCommaKeyword_2_1_6_1_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleParameterAndAdd(FOLLOW_ruleParameter_in_ruleMember2703, current, elementAccess.getParametersParameterParserRuleCall_2_1_6_1_1_0(), elementAccess.getRule(), XTEND_FUNCTION__PARAMETERS, null);
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop50;
                                }
                            } while (true);
                            }
                            break;
                    }
                    if (!consumeUnassignedToken(36, FOLLOW_36_in_ruleMember2719,  elementAccess.getRightParenthesisKeyword_2_1_7())) { return current; }

                    int alt53=2;
                    int LA53_0 = input.LA(1);
                    if ( (LA53_0==37) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(37, FOLLOW_37_in_ruleMember2732,  elementAccess.getThrowsKeyword_2_1_8_0())) { return current; }


                            {

                            {
                            current = callRuleJvmTypeReferenceAndAdd(FOLLOW_ruleJvmTypeReference_in_ruleMember2753, current, elementAccess.getExceptionsJvmTypeReferenceParserRuleCall_2_1_8_1_0(), elementAccess.getRule(), XTEND_FUNCTION__EXCEPTIONS, null);
                            if (state.failed) return current;

                            }
                            }
                            loop52:
                            do {
                                int alt52=2;
                                int LA52_0 = input.LA(1);
                                if ( (LA52_0==24) ) {
                                    alt52=1;
                                }
                                switch (alt52) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleMember2766,  elementAccess.getCommaKeyword_2_1_8_2_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleJvmTypeReferenceAndAdd(FOLLOW_ruleJvmTypeReference_in_ruleMember2787, current, elementAccess.getExceptionsJvmTypeReferenceParserRuleCall_2_1_8_2_1_0(), elementAccess.getRule(), XTEND_FUNCTION__EXCEPTIONS, null);
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop52;
                                }
                            } while (true);
                            }
                            break;
                    }
                    int alt54=4;
                    switch ( input.LA(1) ) {
                        case 28:
                            {
                            alt54=1;
                            }
                            break;
                        case RULE_RICH_TEXT:
                        case RULE_RICH_TEXT_START:
                            {
                            alt54=2;
                            }
                            break;
                        case 21:
                            {
                            alt54=3;
                            }
                            break;
                    }
                    switch (alt54) {
                        case 1 :
                            {

                            {

                            {
                            current = callRuleXBlockExpressionAndSet(FOLLOW_ruleXBlockExpression_in_ruleMember2813, current, elementAccess.getExpressionXBlockExpressionParserRuleCall_2_1_9_0_0(), elementAccess.getRule(), XTEND_FUNCTION__EXPRESSION, null);
                            if (state.failed) return current;

                            }
                            }
                            }
                            break;
                        case 2 :
                            {

                            {

                            {
                            current = callRuleRichStringAndSet(FOLLOW_ruleRichString_in_ruleMember2840, current, elementAccess.getExpressionRichStringParserRuleCall_2_1_9_1_0(), elementAccess.getRule(), XTEND_FUNCTION__EXPRESSION, null);
                            if (state.failed) return current;

                            }
                            }
                            }
                            break;
                        case 3 :
                            {
                            if (!consumeUnassignedToken(21, FOLLOW_21_in_ruleMember2858,  elementAccess.getSemicolonKeyword_2_1_9_2())) { return current; }

                            }
                            break;
                    }
                    }
                    }
                    break;
                case 3 :
                    {

                    {

                    {
                    if ( state.backtracking==0 ) {
                              current = forceCreateModelElementAndSet(
                                  elementAccess.getXtendConstructorAnnotationInfoAction_2_2_0(),
                                  XTEND_CONSTRUCTOR__ANNOTATION_INFO,
                                  current);
                    }
                    }
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);
                        if ( (LA55_0==20||(LA55_0>=39 && LA55_0<=45)) ) {
                            alt55=1;
                        }
                        switch (alt55) {
                    	case 1 :
                    	    {

                    	    {
                    	    current = callRuleCommonModifierAndAdd(FOLLOW_ruleCommonModifier_in_ruleMember2898, current, elementAccess.getModifiersCommonModifierParserRuleCall_2_2_1_0(), elementAccess.getRule(), XTEND_CONSTRUCTOR__MODIFIERS, "CommonModifier");
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop55;
                        }
                    } while (true);
                    if (!consumeUnassignedToken(38, FOLLOW_38_in_ruleMember2911,  elementAccess.getNewKeyword_2_2_2())) { return current; }

                    int alt57=2;
                    int LA57_0 = input.LA(1);
                    if ( (LA57_0==23) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(23, FOLLOW_23_in_ruleMember2924,  elementAccess.getLessThanSignKeyword_2_2_3_0())) { return current; }


                            {

                            {
                            current = callRuleJvmTypeParameterAndAdd(FOLLOW_ruleJvmTypeParameter_in_ruleMember2945, current, elementAccess.getTypeParametersJvmTypeParameterParserRuleCall_2_2_3_1_0(), elementAccess.getRule(), XTEND_CONSTRUCTOR__TYPE_PARAMETERS, null);
                            if (state.failed) return current;

                            }
                            }
                            loop56:
                            do {
                                int alt56=2;
                                int LA56_0 = input.LA(1);
                                if ( (LA56_0==24) ) {
                                    alt56=1;
                                }
                                switch (alt56) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleMember2958,  elementAccess.getCommaKeyword_2_2_3_2_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleJvmTypeParameterAndAdd(FOLLOW_ruleJvmTypeParameter_in_ruleMember2979, current, elementAccess.getTypeParametersJvmTypeParameterParserRuleCall_2_2_3_2_1_0(), elementAccess.getRule(), XTEND_CONSTRUCTOR__TYPE_PARAMETERS, null);
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop56;
                                }
                            } while (true);
                            if (!consumeUnassignedToken(25, FOLLOW_25_in_ruleMember2993,  elementAccess.getGreaterThanSignKeyword_2_2_3_3())) { return current; }

                            }
                            break;
                    }
                    if (!consumeUnassignedToken(35, FOLLOW_35_in_ruleMember3007,  elementAccess.getLeftParenthesisKeyword_2_2_4())) { return current; }

                    int alt59=2;
                    int LA59_0 = input.LA(1);
                    if ( (LA59_0==RULE_ID||LA59_0==32||(LA59_0>=34 && LA59_0<=35)||LA59_0==50||LA59_0==63||LA59_0==79) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            {

                            {

                            {
                            current = callRuleParameterAndAdd(FOLLOW_ruleParameter_in_ruleMember3029, current, elementAccess.getParametersParameterParserRuleCall_2_2_5_0_0(), elementAccess.getRule(), XTEND_CONSTRUCTOR__PARAMETERS, null);
                            if (state.failed) return current;

                            }
                            }
                            loop58:
                            do {
                                int alt58=2;
                                int LA58_0 = input.LA(1);
                                if ( (LA58_0==24) ) {
                                    alt58=1;
                                }
                                switch (alt58) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleMember3042,  elementAccess.getCommaKeyword_2_2_5_1_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleParameterAndAdd(FOLLOW_ruleParameter_in_ruleMember3063, current, elementAccess.getParametersParameterParserRuleCall_2_2_5_1_1_0(), elementAccess.getRule(), XTEND_CONSTRUCTOR__PARAMETERS, null);
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop58;
                                }
                            } while (true);
                            }
                            break;
                    }
                    if (!consumeUnassignedToken(36, FOLLOW_36_in_ruleMember3079,  elementAccess.getRightParenthesisKeyword_2_2_6())) { return current; }

                    int alt61=2;
                    int LA61_0 = input.LA(1);
                    if ( (LA61_0==37) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(37, FOLLOW_37_in_ruleMember3092,  elementAccess.getThrowsKeyword_2_2_7_0())) { return current; }


                            {

                            {
                            current = callRuleJvmTypeReferenceAndAdd(FOLLOW_ruleJvmTypeReference_in_ruleMember3113, current, elementAccess.getExceptionsJvmTypeReferenceParserRuleCall_2_2_7_1_0(), elementAccess.getRule(), XTEND_CONSTRUCTOR__EXCEPTIONS, null);
                            if (state.failed) return current;

                            }
                            }
                            loop60:
                            do {
                                int alt60=2;
                                int LA60_0 = input.LA(1);
                                if ( (LA60_0==24) ) {
                                    alt60=1;
                                }
                                switch (alt60) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleMember3126,  elementAccess.getCommaKeyword_2_2_7_2_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleJvmTypeReferenceAndAdd(FOLLOW_ruleJvmTypeReference_in_ruleMember3147, current, elementAccess.getExceptionsJvmTypeReferenceParserRuleCall_2_2_7_2_1_0(), elementAccess.getRule(), XTEND_CONSTRUCTOR__EXCEPTIONS, null);
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop60;
                                }
                            } while (true);
                            }
                            break;
                    }

                    {

                    {
                    current = callRuleXBlockExpressionAndSet(FOLLOW_ruleXBlockExpression_in_ruleMember3172, current, elementAccess.getExpressionXBlockExpressionParserRuleCall_2_2_8_0(), elementAccess.getRule(), XTEND_CONSTRUCTOR__EXPRESSION, null);
                    if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleXtendEnumLiteral() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXtendEnumLiteral = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.XtendEnumLiteralElements elementAccess = grammarAccess.getXtendEnumLiteralAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXtendEnumLiteral_in_entryRuleXtendEnumLiteral3216);
            iv_ruleXtendEnumLiteral=ruleXtendEnumLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXtendEnumLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXtendEnumLiteral3226); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXtendEnumLiteral() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.XtendEnumLiteralElements elementAccess = grammarAccess.getXtendEnumLiteralAccess();
        try {

            {

            {

            {
            current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleXtendEnumLiteral3271, current, elementAccess.getNameValidIDParserRuleCall_0(), elementAccess.getRule(), XTEND_ENUM_LITERAL__NAME, "ValidID");
            if (state.failed) return current;

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
        }
        return current;
    }

    public final String entryRuleCommonModifier() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleCommonModifier = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.CommonModifierElements elementAccess = grammarAccess.getCommonModifierAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleCommonModifier_in_entryRuleCommonModifier3313);
            iv_ruleCommonModifier=ruleCommonModifier();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCommonModifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommonModifier3324); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final AntlrDatatypeRuleToken ruleCommonModifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.CommonModifierElements elementAccess = grammarAccess.getCommonModifierAccess();
        try {

            {
            int alt63=8;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt63=1;
                }
                break;
            case 40:
                {
                alt63=2;
                }
                break;
            case 41:
                {
                alt63=3;
                }
                break;
            case 20:
                {
                alt63=4;
                }
                break;
            case 42:
                {
                alt63=5;
                }
                break;
            case 43:
                {
                alt63=6;
                }
                break;
            case 44:
                {
                alt63=7;
                }
                break;
            case 45:
                {
                alt63=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);
                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    {
                    if (!consumeTokenAndMerge(39, FOLLOW_39_in_ruleCommonModifier3362, current,  elementAccess.getPublicKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(40, FOLLOW_40_in_ruleCommonModifier3381, current,  elementAccess.getPrivateKeyword_1())) { return current; }

                    }
                    break;
                case 3 :
                    {
                    if (!consumeTokenAndMerge(41, FOLLOW_41_in_ruleCommonModifier3400, current,  elementAccess.getProtectedKeyword_2())) { return current; }

                    }
                    break;
                case 4 :
                    {
                    if (!consumeTokenAndMerge(20, FOLLOW_20_in_ruleCommonModifier3419, current,  elementAccess.getPackageKeyword_3())) { return current; }

                    }
                    break;
                case 5 :
                    {
                    if (!consumeTokenAndMerge(42, FOLLOW_42_in_ruleCommonModifier3438, current,  elementAccess.getAbstractKeyword_4())) { return current; }

                    }
                    break;
                case 6 :
                    {
                    if (!consumeTokenAndMerge(43, FOLLOW_43_in_ruleCommonModifier3457, current,  elementAccess.getStaticKeyword_5())) { return current; }

                    }
                    break;
                case 7 :
                    {
                    if (!consumeTokenAndMerge(44, FOLLOW_44_in_ruleCommonModifier3476, current,  elementAccess.getDispatchKeyword_6())) { return current; }

                    }
                    break;
                case 8 :
                    {
                    if (!consumeTokenAndMerge(45, FOLLOW_45_in_ruleCommonModifier3495, current,  elementAccess.getFinalKeyword_7())) { return current; }

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
        }
        return current;
    }

    public final String entryRuleFieldModifier() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleFieldModifier = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.FieldModifierElements elementAccess = grammarAccess.getFieldModifierAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleFieldModifier_in_entryRuleFieldModifier3542);
            iv_ruleFieldModifier=ruleFieldModifier();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFieldModifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFieldModifier3553); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final AntlrDatatypeRuleToken ruleFieldModifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.FieldModifierElements elementAccess = grammarAccess.getFieldModifierAccess();
        try {

            {
            int alt64=2;
            int LA64_0 = input.LA(1);
            if ( (LA64_0==46) ) {
                alt64=1;
            }
            else if ( (LA64_0==47) ) {
                alt64=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);
                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    {
                    if (!consumeTokenAndMerge(46, FOLLOW_46_in_ruleFieldModifier3591, current,  elementAccess.getValKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(47, FOLLOW_47_in_ruleFieldModifier3610, current,  elementAccess.getVarKeyword_1())) { return current; }

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
        }
        return current;
    }

    public final String entryRuleMethodModifier() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleMethodModifier = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.MethodModifierElements elementAccess = grammarAccess.getMethodModifierAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleMethodModifier_in_entryRuleMethodModifier3657);
            iv_ruleMethodModifier=ruleMethodModifier();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMethodModifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodModifier3668); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final AntlrDatatypeRuleToken ruleMethodModifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.MethodModifierElements elementAccess = grammarAccess.getMethodModifierAccess();
        try {

            {
            int alt65=2;
            int LA65_0 = input.LA(1);
            if ( (LA65_0==48) ) {
                alt65=1;
            }
            else if ( (LA65_0==49) ) {
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
                    {
                    if (!consumeTokenAndMerge(48, FOLLOW_48_in_ruleMethodModifier3706, current,  elementAccess.getDefKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(49, FOLLOW_49_in_ruleMethodModifier3725, current,  elementAccess.getOverrideKeyword_1())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleCreateExtensionInfo() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleCreateExtensionInfo = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.CreateExtensionInfoElements elementAccess = grammarAccess.getCreateExtensionInfoAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleCreateExtensionInfo_in_entryRuleCreateExtensionInfo3771);
            iv_ruleCreateExtensionInfo=ruleCreateExtensionInfo();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCreateExtensionInfo; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCreateExtensionInfo3781); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleCreateExtensionInfo() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.CreateExtensionInfoElements elementAccess = grammarAccess.getCreateExtensionInfoAccess();
        try {

            {

            {
            if (!consumeUnassignedToken(50, FOLLOW_50_in_ruleCreateExtensionInfo3818,  elementAccess.getCreateKeyword_0())) { return current; }

            int alt66=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA66_1 = input.LA(2);
                    if ( (LA66_1==51) ) {
                        alt66=1;
                    }
                    }
                    break;
                case 50:
                    {
                    int LA66_2 = input.LA(2);
                    if ( (LA66_2==51) ) {
                        alt66=1;
                    }
                    }
                    break;
                case 32:
                    {
                    int LA66_3 = input.LA(2);
                    if ( (LA66_3==51) ) {
                        alt66=1;
                    }
                    }
                    break;
            }
            switch (alt66) {
                case 1 :
                    {

                    {

                    {
                    current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleCreateExtensionInfo3840, current, elementAccess.getNameValidIDParserRuleCall_1_0_0(), elementAccess.getRule(), CREATE_EXTENSION_INFO__NAME, "ValidID");
                    if (state.failed) return current;

                    }
                    }
                    if (!consumeUnassignedToken(51, FOLLOW_51_in_ruleCreateExtensionInfo3852,  elementAccess.getColonKeyword_1_1())) { return current; }

                    }
                    break;
            }

            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleCreateExtensionInfo3875, current, elementAccess.getCreateExpressionXExpressionParserRuleCall_2_0(), elementAccess.getRule(), CREATE_EXTENSION_INFO__CREATE_EXPRESSION, null);
            if (state.failed) return current;

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
        }
        return current;
    }

    public final String entryRuleValidID() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleValidID = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.ValidIDElements elementAccess = grammarAccess.getValidIDAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID3918);
            iv_ruleValidID=ruleValidID();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID3929); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        Token this_token=null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.ValidIDElements elementAccess = grammarAccess.getValidIDAccess();
        try {

            {
            int alt67=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt67=1;
                }
                break;
            case 50:
                {
                alt67=2;
                }
                break;
            case 32:
                {
                alt67=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);
                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    {
                    this_token=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID3969); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                      		current.merge(this_token);
                    }
                    if ( state.backtracking==0 ) {
                          newLeafNode(this_token, elementAccess.getIDTerminalRuleCall_0()); 
                    }
                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(50, FOLLOW_50_in_ruleValidID3993, current,  elementAccess.getCreateKeyword_1())) { return current; }

                    }
                    break;
                case 3 :
                    {
                    if (!consumeTokenAndMerge(32, FOLLOW_32_in_ruleValidID4012, current,  elementAccess.getAnnotationKeyword_2())) { return current; }

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
        }
        return current;
    }

    public final String entryRuleFeatureCallID() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleFeatureCallID = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.FeatureCallIDElements elementAccess = grammarAccess.getFeatureCallIDAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleFeatureCallID_in_entryRuleFeatureCallID4059);
            iv_ruleFeatureCallID=ruleFeatureCallID();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureCallID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCallID4070); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final AntlrDatatypeRuleToken ruleFeatureCallID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        Token this_token=null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.FeatureCallIDElements elementAccess = grammarAccess.getFeatureCallIDAccess();
        try {

            {
            int alt68=21;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt68=1;
                }
                break;
            case 42:
                {
                alt68=2;
                }
                break;
            case 32:
                {
                alt68=3;
                }
                break;
            case 22:
                {
                alt68=4;
                }
                break;
            case 50:
                {
                alt68=5;
                }
                break;
            case 48:
                {
                alt68=6;
                }
                break;
            case 44:
                {
                alt68=7;
                }
                break;
            case 31:
                {
                alt68=8;
                }
                break;
            case 26:
                {
                alt68=9;
                }
                break;
            case 34:
                {
                alt68=10;
                }
                break;
            case 45:
                {
                alt68=11;
                }
                break;
            case 27:
                {
                alt68=12;
                }
                break;
            case 52:
                {
                alt68=13;
                }
                break;
            case 30:
                {
                alt68=14;
                }
                break;
            case 49:
                {
                alt68=15;
                }
                break;
            case 20:
                {
                alt68=16;
                }
                break;
            case 39:
                {
                alt68=17;
                }
                break;
            case 40:
                {
                alt68=18;
                }
                break;
            case 41:
                {
                alt68=19;
                }
                break;
            case 43:
                {
                alt68=20;
                }
                break;
            case 37:
                {
                alt68=21;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);
                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    {
                    this_token=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureCallID4110); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                      		current.merge(this_token);
                    }
                    if ( state.backtracking==0 ) {
                          newLeafNode(this_token, elementAccess.getIDTerminalRuleCall_0()); 
                    }
                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(42, FOLLOW_42_in_ruleFeatureCallID4134, current,  elementAccess.getAbstractKeyword_1())) { return current; }

                    }
                    break;
                case 3 :
                    {
                    if (!consumeTokenAndMerge(32, FOLLOW_32_in_ruleFeatureCallID4153, current,  elementAccess.getAnnotationKeyword_2())) { return current; }

                    }
                    break;
                case 4 :
                    {
                    if (!consumeTokenAndMerge(22, FOLLOW_22_in_ruleFeatureCallID4172, current,  elementAccess.getClassKeyword_3())) { return current; }

                    }
                    break;
                case 5 :
                    {
                    if (!consumeTokenAndMerge(50, FOLLOW_50_in_ruleFeatureCallID4191, current,  elementAccess.getCreateKeyword_4())) { return current; }

                    }
                    break;
                case 6 :
                    {
                    if (!consumeTokenAndMerge(48, FOLLOW_48_in_ruleFeatureCallID4210, current,  elementAccess.getDefKeyword_5())) { return current; }

                    }
                    break;
                case 7 :
                    {
                    if (!consumeTokenAndMerge(44, FOLLOW_44_in_ruleFeatureCallID4229, current,  elementAccess.getDispatchKeyword_6())) { return current; }

                    }
                    break;
                case 8 :
                    {
                    if (!consumeTokenAndMerge(31, FOLLOW_31_in_ruleFeatureCallID4248, current,  elementAccess.getEnumKeyword_7())) { return current; }

                    }
                    break;
                case 9 :
                    {
                    if (!consumeTokenAndMerge(26, FOLLOW_26_in_ruleFeatureCallID4267, current,  elementAccess.getExtendsKeyword_8())) { return current; }

                    }
                    break;
                case 10 :
                    {
                    if (!consumeTokenAndMerge(34, FOLLOW_34_in_ruleFeatureCallID4286, current,  elementAccess.getExtensionKeyword_9())) { return current; }

                    }
                    break;
                case 11 :
                    {
                    if (!consumeTokenAndMerge(45, FOLLOW_45_in_ruleFeatureCallID4305, current,  elementAccess.getFinalKeyword_10())) { return current; }

                    }
                    break;
                case 12 :
                    {
                    if (!consumeTokenAndMerge(27, FOLLOW_27_in_ruleFeatureCallID4324, current,  elementAccess.getImplementsKeyword_11())) { return current; }

                    }
                    break;
                case 13 :
                    {
                    if (!consumeTokenAndMerge(52, FOLLOW_52_in_ruleFeatureCallID4343, current,  elementAccess.getImportKeyword_12())) { return current; }

                    }
                    break;
                case 14 :
                    {
                    if (!consumeTokenAndMerge(30, FOLLOW_30_in_ruleFeatureCallID4362, current,  elementAccess.getInterfaceKeyword_13())) { return current; }

                    }
                    break;
                case 15 :
                    {
                    if (!consumeTokenAndMerge(49, FOLLOW_49_in_ruleFeatureCallID4381, current,  elementAccess.getOverrideKeyword_14())) { return current; }

                    }
                    break;
                case 16 :
                    {
                    if (!consumeTokenAndMerge(20, FOLLOW_20_in_ruleFeatureCallID4400, current,  elementAccess.getPackageKeyword_15())) { return current; }

                    }
                    break;
                case 17 :
                    {
                    if (!consumeTokenAndMerge(39, FOLLOW_39_in_ruleFeatureCallID4419, current,  elementAccess.getPublicKeyword_16())) { return current; }

                    }
                    break;
                case 18 :
                    {
                    if (!consumeTokenAndMerge(40, FOLLOW_40_in_ruleFeatureCallID4438, current,  elementAccess.getPrivateKeyword_17())) { return current; }

                    }
                    break;
                case 19 :
                    {
                    if (!consumeTokenAndMerge(41, FOLLOW_41_in_ruleFeatureCallID4457, current,  elementAccess.getProtectedKeyword_18())) { return current; }

                    }
                    break;
                case 20 :
                    {
                    if (!consumeTokenAndMerge(43, FOLLOW_43_in_ruleFeatureCallID4476, current,  elementAccess.getStaticKeyword_19())) { return current; }

                    }
                    break;
                case 21 :
                    {
                    if (!consumeTokenAndMerge(37, FOLLOW_37_in_ruleFeatureCallID4495, current,  elementAccess.getThrowsKeyword_20())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleParameter = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.ParameterElements elementAccess = grammarAccess.getParameterAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter4541);
            iv_ruleParameter=ruleParameter();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter4551); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.ParameterElements elementAccess = grammarAccess.getParameterAccess();
        try {

            {

            {
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);
                if ( (LA69_0==63) ) {
                    alt69=1;
                }
                switch (alt69) {
            	case 1 :
            	    {

            	    {
            	    current = callRuleXAnnotationAndAdd(FOLLOW_ruleXAnnotation_in_ruleParameter4597, current, elementAccess.getAnnotationsXAnnotationParserRuleCall_0_0(), elementAccess.getRule(), XTEND_PARAMETER__ANNOTATIONS, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    break;
            	default :
            	    break loop69;
                }
            } while (true);
            int alt71=2;
            int LA71_0 = input.LA(1);
            if ( (LA71_0==34) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    {

                    {

                    {
                    current = consumeTokenAndSetBooleanValue(34, FOLLOW_34_in_ruleParameter4617, current,  elementAccess.getExtensionExtensionKeyword_1_0_0(), elementAccess.getRule(), XTEND_PARAMETER__EXTENSION);
                    if (state.failed) return current;

                    }
                    }
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);
                        if ( (LA70_0==63) ) {
                            alt70=1;
                        }
                        switch (alt70) {
                    	case 1 :
                    	    {

                    	    {
                    	    current = callRuleXAnnotationAndAdd(FOLLOW_ruleXAnnotation_in_ruleParameter4651, current, elementAccess.getAnnotationsXAnnotationParserRuleCall_1_1_0(), elementAccess.getRule(), XTEND_PARAMETER__ANNOTATIONS, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop70;
                        }
                    } while (true);
                    }
                    break;
            }

            {

            {
            current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleParameter4675, current, elementAccess.getParameterTypeJvmTypeReferenceParserRuleCall_2_0(), elementAccess.getRule(), XTEND_PARAMETER__PARAMETER_TYPE, null);
            if (state.failed) return current;

            }
            }
            int alt72=2;
            int LA72_0 = input.LA(1);
            if ( (LA72_0==53) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    {

                    {
                    current = consumeTokenAndSetBooleanValue(53, FOLLOW_53_in_ruleParameter4693, current,  elementAccess.getVarArgFullStopFullStopFullStopKeyword_3_0(), elementAccess.getRule(), XTEND_PARAMETER__VAR_ARG);
                    if (state.failed) return current;

                    }
                    }
                    break;
            }

            {

            {
            current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleParameter4728, current, elementAccess.getNameValidIDParserRuleCall_4_0(), elementAccess.getRule(), XTEND_PARAMETER__NAME, "ValidID");
            if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXVariableDeclaration = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.XVariableDeclarationElements elementAccess = grammarAccess.getXVariableDeclarationAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration4770);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXVariableDeclaration4780); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXVariableDeclaration() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.XVariableDeclarationElements elementAccess = grammarAccess.getXVariableDeclarationAccess();
        try {

            {

            {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXtendVariableDeclarationAction_0_0_0(),
                          current);
            }
            }
            int alt76=2;
            int LA76_0 = input.LA(1);
            if ( ((LA76_0>=46 && LA76_0<=47)) ) {
                alt76=1;
            }
            else if ( (LA76_0==34) ) {
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
                    {

                    {
                    int alt73=2;
                    int LA73_0 = input.LA(1);
                    if ( (LA73_0==47) ) {
                        alt73=1;
                    }
                    else if ( (LA73_0==46) ) {
                        alt73=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 73, 0, input);
                        throw nvae;
                    }
                    switch (alt73) {
                        case 1 :
                            {

                            {

                            {
                            current = consumeTokenAndSetBooleanValue(47, FOLLOW_47_in_ruleXVariableDeclaration4938, current,  elementAccess.getWriteableVarKeyword_0_0_1_0_0_0_0(), elementAccess.getRule(), XTEND_VARIABLE_DECLARATION__WRITEABLE);
                            if (state.failed) return current;

                            }
                            }
                            }
                            break;
                        case 2 :
                            {
                            if (!consumeUnassignedToken(46, FOLLOW_46_in_ruleXVariableDeclaration4969,  elementAccess.getValKeyword_0_0_1_0_0_1())) { return current; }

                            }
                            break;
                    }
                    int alt74=2;
                    int LA74_0 = input.LA(1);
                    if ( (LA74_0==34) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            {

                            {
                            current = consumeTokenAndSetBooleanValue(34, FOLLOW_34_in_ruleXVariableDeclaration4988, current,  elementAccess.getExtensionExtensionKeyword_0_0_1_0_1_0(), elementAccess.getRule(), XTEND_VARIABLE_DECLARATION__EXTENSION);
                            if (state.failed) return current;

                            }
                            }
                            break;
                    }
                    }
                    }
                    break;
                case 2 :
                    {

                    {

                    {

                    {
                    current = consumeTokenAndSetBooleanValue(34, FOLLOW_34_in_ruleXVariableDeclaration5028, current,  elementAccess.getExtensionExtensionKeyword_0_0_1_1_0_0(), elementAccess.getRule(), XTEND_VARIABLE_DECLARATION__EXTENSION);
                    if (state.failed) return current;

                    }
                    }
                    int alt75=2;
                    int LA75_0 = input.LA(1);
                    if ( (LA75_0==47) ) {
                        alt75=1;
                    }
                    else if ( (LA75_0==46) ) {
                        alt75=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 75, 0, input);
                        throw nvae;
                    }
                    switch (alt75) {
                        case 1 :
                            {

                            {

                            {
                            current = consumeTokenAndSetBooleanValue(47, FOLLOW_47_in_ruleXVariableDeclaration5060, current,  elementAccess.getWriteableVarKeyword_0_0_1_1_1_0_0(), elementAccess.getRule(), XTEND_VARIABLE_DECLARATION__WRITEABLE);
                            if (state.failed) return current;

                            }
                            }
                            }
                            break;
                        case 2 :
                            {
                            if (!consumeUnassignedToken(46, FOLLOW_46_in_ruleXVariableDeclaration5091,  elementAccess.getValKeyword_0_0_1_1_1_1())) { return current; }

                            }
                            break;
                    }
                    }
                    }
                    break;
            }
            }
            }
            int alt77=2;
            int LA77_0 = input.LA(1);
            if ( (LA77_0==RULE_ID) ) {
                int LA77_1 = input.LA(2);
                if ( (synpred5_InternalXtend()) ) {
                    alt77=1;
                }
                else if ( (true) ) {
                    alt77=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 77, 1, input);
                    throw nvae;
                }
            }
            else if ( (LA77_0==50) ) {
                int LA77_2 = input.LA(2);
                if ( (synpred5_InternalXtend()) ) {
                    alt77=1;
                }
                else if ( (true) ) {
                    alt77=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 77, 2, input);
                    throw nvae;
                }
            }
            else if ( (LA77_0==32) ) {
                int LA77_3 = input.LA(2);
                if ( (synpred5_InternalXtend()) ) {
                    alt77=1;
                }
                else if ( (true) ) {
                    alt77=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 77, 3, input);
                    throw nvae;
                }
            }
            else if ( (LA77_0==35) && (synpred5_InternalXtend())) {
                alt77=1;
            }
            else if ( (LA77_0==79) && (synpred5_InternalXtend())) {
                alt77=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);
                throw nvae;
            }
            switch (alt77) {
                case 1 :
                    {

                    {

                    {

                    {

                    {
                    current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration5143, current, elementAccess.getTypeJvmTypeReferenceParserRuleCall_1_0_0_0_0(), elementAccess.getRule(), XTEND_VARIABLE_DECLARATION__TYPE, null);
                    if (state.failed) return current;

                    }
                    }

                    {

                    {
                    current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleXVariableDeclaration5164, current, elementAccess.getNameValidIDParserRuleCall_1_0_0_1_0(), elementAccess.getRule(), XTEND_VARIABLE_DECLARATION__NAME, "ValidID");
                    if (state.failed) return current;

                    }
                    }
                    }
                    }
                    }
                    break;
                case 2 :
                    {

                    {

                    {
                    current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleXVariableDeclaration5193, current, elementAccess.getNameValidIDParserRuleCall_1_1_0(), elementAccess.getRule(), XTEND_VARIABLE_DECLARATION__NAME, "ValidID");
                    if (state.failed) return current;

                    }
                    }
                    }
                    break;
            }
            int alt78=2;
            int LA78_0 = input.LA(1);
            if ( (LA78_0==33) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(33, FOLLOW_33_in_ruleXVariableDeclaration5207,  elementAccess.getEqualsSignKeyword_2_0())) { return current; }


                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXVariableDeclaration5228, current, elementAccess.getRightXExpressionParserRuleCall_2_1_0(), elementAccess.getRule(), XTEND_VARIABLE_DECLARATION__RIGHT, null);
                    if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleJvmFormalParameter = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.JvmFormalParameterElements elementAccess = grammarAccess.getJvmFormalParameterAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter5272);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmFormalParameter5282); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.JvmFormalParameterElements elementAccess = grammarAccess.getJvmFormalParameterAccess();
        try {

            {

            {
            int alt79=2;
            int LA79_0 = input.LA(1);
            if ( (LA79_0==34) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    {

                    {
                    current = consumeTokenAndSetBooleanValue(34, FOLLOW_34_in_ruleJvmFormalParameter5325, current,  elementAccess.getExtensionExtensionKeyword_0_0(), elementAccess.getRule(), XTEND_FORMAL_PARAMETER__EXTENSION);
                    if (state.failed) return current;

                    }
                    }
                    break;
            }
            int alt80=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA80_1 = input.LA(2);
                    if ( (LA80_1==RULE_ID||LA80_1==23||LA80_1==32||LA80_1==50||LA80_1==90||LA80_1==94) ) {
                        alt80=1;
                    }
                    }
                    break;
                case 50:
                    {
                    int LA80_2 = input.LA(2);
                    if ( (LA80_2==RULE_ID||LA80_2==23||LA80_2==32||LA80_2==50||LA80_2==90||LA80_2==94) ) {
                        alt80=1;
                    }
                    }
                    break;
                case 32:
                    {
                    int LA80_3 = input.LA(2);
                    if ( (LA80_3==RULE_ID||LA80_3==23||LA80_3==32||LA80_3==50||LA80_3==90||LA80_3==94) ) {
                        alt80=1;
                    }
                    }
                    break;
                case 35:
                case 79:
                    {
                    alt80=1;
                    }
                    break;
            }
            switch (alt80) {
                case 1 :
                    {

                    {
                    current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter5360, current, elementAccess.getParameterTypeJvmTypeReferenceParserRuleCall_1_0(), elementAccess.getRule(), XTEND_FORMAL_PARAMETER__PARAMETER_TYPE, null);
                    if (state.failed) return current;

                    }
                    }
                    break;
            }

            {

            {
            current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleJvmFormalParameter5382, current, elementAccess.getNameValidIDParserRuleCall_2_0(), elementAccess.getRule(), XTEND_FORMAL_PARAMETER__NAME, "ValidID");
            if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleFullJvmFormalParameter = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.FullJvmFormalParameterElements elementAccess = grammarAccess.getFullJvmFormalParameterAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleFullJvmFormalParameter_in_entryRuleFullJvmFormalParameter5424);
            iv_ruleFullJvmFormalParameter=ruleFullJvmFormalParameter();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFullJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFullJvmFormalParameter5434); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.FullJvmFormalParameterElements elementAccess = grammarAccess.getFullJvmFormalParameterAccess();
        try {

            {

            {
            int alt81=2;
            int LA81_0 = input.LA(1);
            if ( (LA81_0==34) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    {

                    {
                    current = consumeTokenAndSetBooleanValue(34, FOLLOW_34_in_ruleFullJvmFormalParameter5477, current,  elementAccess.getExtensionExtensionKeyword_0_0(), elementAccess.getRule(), XTEND_FORMAL_PARAMETER__EXTENSION);
                    if (state.failed) return current;

                    }
                    }
                    break;
            }

            {

            {
            current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleFullJvmFormalParameter5512, current, elementAccess.getParameterTypeJvmTypeReferenceParserRuleCall_1_0(), elementAccess.getRule(), XTEND_FORMAL_PARAMETER__PARAMETER_TYPE, null);
            if (state.failed) return current;

            }
            }

            {

            {
            current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleFullJvmFormalParameter5533, current, elementAccess.getNameValidIDParserRuleCall_2_0(), elementAccess.getRule(), XTEND_FORMAL_PARAMETER__NAME, "ValidID");
            if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXStringLiteral = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.XStringLiteralElements elementAccess = grammarAccess.getXStringLiteralAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral5575);
            iv_ruleXStringLiteral=ruleXStringLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXStringLiteral5585); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.XStringLiteralElements elementAccess = grammarAccess.getXStringLiteralAccess();
        try {

            {
            int alt82=2;
            int LA82_0 = input.LA(1);
            if ( (LA82_0==RULE_STRING) ) {
                alt82=1;
            }
            else if ( ((LA82_0>=RULE_RICH_TEXT && LA82_0<=RULE_RICH_TEXT_START)) ) {
                alt82=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);
                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    {
                    current = callUnassignedRuleSimpleStringLiteral(FOLLOW_ruleSimpleStringLiteral_in_ruleXStringLiteral5632, elementAccess.getSimpleStringLiteralParserRuleCall_0());
                    if (state.failed) return current;

                    }
                    break;
                case 2 :
                    {
                    current = callUnassignedRuleRichString(FOLLOW_ruleRichString_in_ruleXStringLiteral5659, elementAccess.getRichStringParserRuleCall_1());
                    if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleSimpleStringLiteral() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleSimpleStringLiteral = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.SimpleStringLiteralElements elementAccess = grammarAccess.getSimpleStringLiteralAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleSimpleStringLiteral_in_entryRuleSimpleStringLiteral5700);
            iv_ruleSimpleStringLiteral=ruleSimpleStringLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleStringLiteral5710); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleSimpleStringLiteral() throws RecognitionException {
        EObject current = null;
        Token this_token=null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.SimpleStringLiteralElements elementAccess = grammarAccess.getSimpleStringLiteralAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXStringLiteralAction_0(),
                          current);
            }
            }

            {

            {
            this_token=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSimpleStringLiteral5761); if (state.failed) return current;
            if ( state.backtracking==0 ) {
              			newLeafNode(this_token, elementAccess.getValueSTRINGTerminalRuleCall_1_0()); 
            }
            if ( state.backtracking==0 ) {
              	        if (current==null) {
              	            current = createModelElement(elementAccess.getRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			XSTRING_LITERAL__VALUE,
                      		this_token, 
                      		"STRING");
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
        }
        return current;
    }

    public final EObject entryRuleRichString() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleRichString = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.RichStringElements elementAccess = grammarAccess.getRichStringAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleRichString_in_entryRuleRichString5808);
            iv_ruleRichString=ruleRichString();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichString; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichString5818); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleRichString() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.RichStringElements elementAccess = grammarAccess.getRichStringAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getRichStringAction_0(),
                          current);
            }
            }
            int alt86=2;
            int LA86_0 = input.LA(1);
            if ( (LA86_0==RULE_RICH_TEXT) ) {
                alt86=1;
            }
            else if ( (LA86_0==RULE_RICH_TEXT_START) ) {
                alt86=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);
                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    {

                    {

                    {
                    current = callRuleRichStringLiteralAndAdd(FOLLOW_ruleRichStringLiteral_in_ruleRichString5874, current, elementAccess.getExpressionsRichStringLiteralParserRuleCall_1_0_0(), elementAccess.getRule(), RICH_STRING__EXPRESSIONS, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    break;
                case 2 :
                    {

                    {

                    {

                    {
                    current = callRuleRichStringLiteralStartAndAdd(FOLLOW_ruleRichStringLiteralStart_in_ruleRichString5902, current, elementAccess.getExpressionsRichStringLiteralStartParserRuleCall_1_1_0_0(), elementAccess.getRule(), RICH_STRING__EXPRESSIONS, null);
                    if (state.failed) return current;

                    }
                    }
                    int alt83=2;
                    int LA83_0 = input.LA(1);
                    if ( ((LA83_0>=RULE_ID && LA83_0<=RULE_RICH_TEXT_START)||(LA83_0>=RULE_HEX && LA83_0<=RULE_DECIMAL)||LA83_0==20||(LA83_0>=22 && LA83_0<=23)||(LA83_0>=26 && LA83_0<=28)||(LA83_0>=30 && LA83_0<=32)||(LA83_0>=34 && LA83_0<=35)||(LA83_0>=37 && LA83_0<=50)||LA83_0==52||LA83_0==54||LA83_0==59||LA83_0==64||LA83_0==83||LA83_0==88||(LA83_0>=93 && LA83_0<=94)||LA83_0==97||LA83_0==99||(LA83_0>=102 && LA83_0<=105)||(LA83_0>=107 && LA83_0<=113)) ) {
                        alt83=1;
                    }
                    switch (alt83) {
                        case 1 :
                            {

                            {
                            current = callRuleRichStringPartAndAdd(FOLLOW_ruleRichStringPart_in_ruleRichString5923, current, elementAccess.getExpressionsRichStringPartParserRuleCall_1_1_1_0(), elementAccess.getRule(), RICH_STRING__EXPRESSIONS, null);
                            if (state.failed) return current;

                            }
                            }
                            break;
                    }
                    loop85:
                    do {
                        int alt85=2;
                        int LA85_0 = input.LA(1);
                        if ( ((LA85_0>=RULE_RICH_TEXT_INBETWEEN && LA85_0<=RULE_COMMENT_RICH_TEXT_INBETWEEN)) ) {
                            alt85=1;
                        }
                        switch (alt85) {
                    	case 1 :
                    	    {

                    	    {

                    	    {
                    	    current = callRuleRichStringLiteralInbetweenAndAdd(FOLLOW_ruleRichStringLiteralInbetween_in_ruleRichString5946, current, elementAccess.getExpressionsRichStringLiteralInbetweenParserRuleCall_1_1_2_0_0(), elementAccess.getRule(), RICH_STRING__EXPRESSIONS, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    int alt84=2;
                    	    int LA84_0 = input.LA(1);
                    	    if ( ((LA84_0>=RULE_ID && LA84_0<=RULE_RICH_TEXT_START)||(LA84_0>=RULE_HEX && LA84_0<=RULE_DECIMAL)||LA84_0==20||(LA84_0>=22 && LA84_0<=23)||(LA84_0>=26 && LA84_0<=28)||(LA84_0>=30 && LA84_0<=32)||(LA84_0>=34 && LA84_0<=35)||(LA84_0>=37 && LA84_0<=50)||LA84_0==52||LA84_0==54||LA84_0==59||LA84_0==64||LA84_0==83||LA84_0==88||(LA84_0>=93 && LA84_0<=94)||LA84_0==97||LA84_0==99||(LA84_0>=102 && LA84_0<=105)||(LA84_0>=107 && LA84_0<=113)) ) {
                    	        alt84=1;
                    	    }
                    	    switch (alt84) {
                    	        case 1 :
                    	            {

                    	            {
                    	            current = callRuleRichStringPartAndAdd(FOLLOW_ruleRichStringPart_in_ruleRichString5967, current, elementAccess.getExpressionsRichStringPartParserRuleCall_1_1_2_1_0(), elementAccess.getRule(), RICH_STRING__EXPRESSIONS, null);
                    	            if (state.failed) return current;

                    	            }
                    	            }
                    	            break;
                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop85;
                        }
                    } while (true);

                    {

                    {
                    current = callRuleRichStringLiteralEndAndAdd(FOLLOW_ruleRichStringLiteralEnd_in_ruleRichString5991, current, elementAccess.getExpressionsRichStringLiteralEndParserRuleCall_1_1_3_0(), elementAccess.getRule(), RICH_STRING__EXPRESSIONS, null);
                    if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleRichStringLiteral() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleRichStringLiteral = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.RichStringLiteralElements elementAccess = grammarAccess.getRichStringLiteralAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleRichStringLiteral_in_entryRuleRichStringLiteral6035);
            iv_ruleRichStringLiteral=ruleRichStringLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichStringLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringLiteral6045); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleRichStringLiteral() throws RecognitionException {
        EObject current = null;
        Token this_token=null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.RichStringLiteralElements elementAccess = grammarAccess.getRichStringLiteralAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getRichStringLiteralAction_0(),
                          current);
            }
            }

            {

            {
            this_token=(Token)match(input,RULE_RICH_TEXT,FOLLOW_RULE_RICH_TEXT_in_ruleRichStringLiteral6096); if (state.failed) return current;
            if ( state.backtracking==0 ) {
              			newLeafNode(this_token, elementAccess.getValueRICH_TEXTTerminalRuleCall_1_0()); 
            }
            if ( state.backtracking==0 ) {
              	        if (current==null) {
              	            current = createModelElement(elementAccess.getRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			RICH_STRING_LITERAL__VALUE,
                      		this_token, 
                      		"RICH_TEXT");
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
        }
        return current;
    }

    public final EObject entryRuleRichStringLiteralStart() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleRichStringLiteralStart = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.RichStringLiteralStartElements elementAccess = grammarAccess.getRichStringLiteralStartAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleRichStringLiteralStart_in_entryRuleRichStringLiteralStart6143);
            iv_ruleRichStringLiteralStart=ruleRichStringLiteralStart();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichStringLiteralStart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringLiteralStart6153); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleRichStringLiteralStart() throws RecognitionException {
        EObject current = null;
        Token this_token=null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.RichStringLiteralStartElements elementAccess = grammarAccess.getRichStringLiteralStartAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getRichStringLiteralAction_0(),
                          current);
            }
            }

            {

            {
            this_token=(Token)match(input,RULE_RICH_TEXT_START,FOLLOW_RULE_RICH_TEXT_START_in_ruleRichStringLiteralStart6204); if (state.failed) return current;
            if ( state.backtracking==0 ) {
              			newLeafNode(this_token, elementAccess.getValueRICH_TEXT_STARTTerminalRuleCall_1_0()); 
            }
            if ( state.backtracking==0 ) {
              	        if (current==null) {
              	            current = createModelElement(elementAccess.getRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			RICH_STRING_LITERAL__VALUE,
                      		this_token, 
                      		"RICH_TEXT_START");
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
        }
        return current;
    }

    public final EObject entryRuleRichStringLiteralInbetween() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleRichStringLiteralInbetween = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.RichStringLiteralInbetweenElements elementAccess = grammarAccess.getRichStringLiteralInbetweenAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleRichStringLiteralInbetween_in_entryRuleRichStringLiteralInbetween6251);
            iv_ruleRichStringLiteralInbetween=ruleRichStringLiteralInbetween();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichStringLiteralInbetween; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringLiteralInbetween6261); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleRichStringLiteralInbetween() throws RecognitionException {
        EObject current = null;
        Token this_token=null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.RichStringLiteralInbetweenElements elementAccess = grammarAccess.getRichStringLiteralInbetweenAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getRichStringLiteralAction_0(),
                          current);
            }
            }
            int alt87=2;
            int LA87_0 = input.LA(1);
            if ( (LA87_0==RULE_RICH_TEXT_INBETWEEN) ) {
                alt87=1;
            }
            else if ( (LA87_0==RULE_COMMENT_RICH_TEXT_INBETWEEN) ) {
                alt87=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);
                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    {

                    {

                    {
                    this_token=(Token)match(input,RULE_RICH_TEXT_INBETWEEN,FOLLOW_RULE_RICH_TEXT_INBETWEEN_in_ruleRichStringLiteralInbetween6313); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                      			newLeafNode(this_token, elementAccess.getValueRICH_TEXT_INBETWEENTerminalRuleCall_1_0_0()); 
                    }
                    if ( state.backtracking==0 ) {
                      	        if (current==null) {
                      	            current = createModelElement(elementAccess.getRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			RICH_STRING_LITERAL__VALUE,
                              		this_token, 
                              		"RICH_TEXT_INBETWEEN");
                    }
                    }
                    }
                    }
                    break;
                case 2 :
                    {

                    {

                    {
                    this_token=(Token)match(input,RULE_COMMENT_RICH_TEXT_INBETWEEN,FOLLOW_RULE_COMMENT_RICH_TEXT_INBETWEEN_in_ruleRichStringLiteralInbetween6341); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                      			newLeafNode(this_token, elementAccess.getValueCOMMENT_RICH_TEXT_INBETWEENTerminalRuleCall_1_1_0()); 
                    }
                    if ( state.backtracking==0 ) {
                      	        if (current==null) {
                      	            current = createModelElement(elementAccess.getRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			RICH_STRING_LITERAL__VALUE,
                              		this_token, 
                              		"COMMENT_RICH_TEXT_INBETWEEN");
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
        }
        return current;
    }

    public final EObject entryRuleRichStringLiteralEnd() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleRichStringLiteralEnd = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.RichStringLiteralEndElements elementAccess = grammarAccess.getRichStringLiteralEndAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleRichStringLiteralEnd_in_entryRuleRichStringLiteralEnd6389);
            iv_ruleRichStringLiteralEnd=ruleRichStringLiteralEnd();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichStringLiteralEnd; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringLiteralEnd6399); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleRichStringLiteralEnd() throws RecognitionException {
        EObject current = null;
        Token this_token=null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.RichStringLiteralEndElements elementAccess = grammarAccess.getRichStringLiteralEndAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getRichStringLiteralAction_0(),
                          current);
            }
            }
            int alt88=2;
            int LA88_0 = input.LA(1);
            if ( (LA88_0==RULE_RICH_TEXT_END) ) {
                alt88=1;
            }
            else if ( (LA88_0==RULE_COMMENT_RICH_TEXT_END) ) {
                alt88=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);
                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    {

                    {

                    {
                    this_token=(Token)match(input,RULE_RICH_TEXT_END,FOLLOW_RULE_RICH_TEXT_END_in_ruleRichStringLiteralEnd6451); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                      			newLeafNode(this_token, elementAccess.getValueRICH_TEXT_ENDTerminalRuleCall_1_0_0()); 
                    }
                    if ( state.backtracking==0 ) {
                      	        if (current==null) {
                      	            current = createModelElement(elementAccess.getRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			RICH_STRING_LITERAL__VALUE,
                              		this_token, 
                              		"RICH_TEXT_END");
                    }
                    }
                    }
                    }
                    break;
                case 2 :
                    {

                    {

                    {
                    this_token=(Token)match(input,RULE_COMMENT_RICH_TEXT_END,FOLLOW_RULE_COMMENT_RICH_TEXT_END_in_ruleRichStringLiteralEnd6479); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                      			newLeafNode(this_token, elementAccess.getValueCOMMENT_RICH_TEXT_ENDTerminalRuleCall_1_1_0()); 
                    }
                    if ( state.backtracking==0 ) {
                      	        if (current==null) {
                      	            current = createModelElement(elementAccess.getRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			RICH_STRING_LITERAL__VALUE,
                              		this_token, 
                              		"COMMENT_RICH_TEXT_END");
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
        }
        return current;
    }

    public final EObject entryRuleInternalRichString() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleInternalRichString = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.InternalRichStringElements elementAccess = grammarAccess.getInternalRichStringAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleInternalRichString_in_entryRuleInternalRichString6527);
            iv_ruleInternalRichString=ruleInternalRichString();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInternalRichString; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInternalRichString6537); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleInternalRichString() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.InternalRichStringElements elementAccess = grammarAccess.getInternalRichStringAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getRichStringAction_0(),
                          current);
            }
            }

            {

            {

            {
            current = callRuleRichStringLiteralInbetweenAndAdd(FOLLOW_ruleRichStringLiteralInbetween_in_ruleInternalRichString6593, current, elementAccess.getExpressionsRichStringLiteralInbetweenParserRuleCall_1_0_0(), elementAccess.getRule(), RICH_STRING__EXPRESSIONS, null);
            if (state.failed) return current;

            }
            }
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);
                if ( ((LA90_0>=RULE_ID && LA90_0<=RULE_COMMENT_RICH_TEXT_INBETWEEN)||(LA90_0>=RULE_HEX && LA90_0<=RULE_DECIMAL)||LA90_0==20||(LA90_0>=22 && LA90_0<=23)||(LA90_0>=26 && LA90_0<=28)||(LA90_0>=30 && LA90_0<=32)||(LA90_0>=34 && LA90_0<=35)||(LA90_0>=37 && LA90_0<=50)||LA90_0==52||LA90_0==54||LA90_0==59||LA90_0==64||LA90_0==83||LA90_0==88||(LA90_0>=93 && LA90_0<=94)||LA90_0==97||LA90_0==99||(LA90_0>=102 && LA90_0<=105)||(LA90_0>=107 && LA90_0<=113)) ) {
                    alt90=1;
                }
                switch (alt90) {
            	case 1 :
            	    {
            	    int alt89=2;
            	    int LA89_0 = input.LA(1);
            	    if ( ((LA89_0>=RULE_ID && LA89_0<=RULE_RICH_TEXT_START)||(LA89_0>=RULE_HEX && LA89_0<=RULE_DECIMAL)||LA89_0==20||(LA89_0>=22 && LA89_0<=23)||(LA89_0>=26 && LA89_0<=28)||(LA89_0>=30 && LA89_0<=32)||(LA89_0>=34 && LA89_0<=35)||(LA89_0>=37 && LA89_0<=50)||LA89_0==52||LA89_0==54||LA89_0==59||LA89_0==64||LA89_0==83||LA89_0==88||(LA89_0>=93 && LA89_0<=94)||LA89_0==97||LA89_0==99||(LA89_0>=102 && LA89_0<=105)||(LA89_0>=107 && LA89_0<=113)) ) {
            	        alt89=1;
            	    }
            	    switch (alt89) {
            	        case 1 :
            	            {

            	            {
            	            current = callRuleRichStringPartAndAdd(FOLLOW_ruleRichStringPart_in_ruleInternalRichString6615, current, elementAccess.getExpressionsRichStringPartParserRuleCall_1_1_0_0(), elementAccess.getRule(), RICH_STRING__EXPRESSIONS, null);
            	            if (state.failed) return current;

            	            }
            	            }
            	            break;
            	    }

            	    {

            	    {
            	    current = callRuleRichStringLiteralInbetweenAndAdd(FOLLOW_ruleRichStringLiteralInbetween_in_ruleInternalRichString6637, current, elementAccess.getExpressionsRichStringLiteralInbetweenParserRuleCall_1_1_1_0(), elementAccess.getRule(), RICH_STRING__EXPRESSIONS, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    break;
            	default :
            	    break loop90;
                }
            } while (true);
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
        }
        return current;
    }

    public final EObject entryRuleRichStringPart() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleRichStringPart = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.RichStringPartElements elementAccess = grammarAccess.getRichStringPartAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleRichStringPart_in_entryRuleRichStringPart6682);
            iv_ruleRichStringPart=ruleRichStringPart();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichStringPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringPart6692); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleRichStringPart() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.RichStringPartElements elementAccess = grammarAccess.getRichStringPartAccess();
        try {

            {
            int alt91=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_STRING:
            case RULE_RICH_TEXT:
            case RULE_RICH_TEXT_START:
            case RULE_HEX:
            case RULE_INT:
            case RULE_DECIMAL:
            case 20:
            case 22:
            case 23:
            case 26:
            case 27:
            case 28:
            case 30:
            case 31:
            case 32:
            case 34:
            case 35:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 52:
            case 64:
            case 83:
            case 88:
            case 93:
            case 94:
            case 97:
            case 99:
            case 102:
            case 103:
            case 104:
            case 105:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
                {
                alt91=1;
                }
                break;
            case 54:
                {
                alt91=2;
                }
                break;
            case 59:
                {
                alt91=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);
                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    {
                    current = callUnassignedRuleXExpressionInsideBlock(FOLLOW_ruleXExpressionInsideBlock_in_ruleRichStringPart6739, elementAccess.getXExpressionInsideBlockParserRuleCall_0());
                    if (state.failed) return current;

                    }
                    break;
                case 2 :
                    {
                    current = callUnassignedRuleRichStringForLoop(FOLLOW_ruleRichStringForLoop_in_ruleRichStringPart6766, elementAccess.getRichStringForLoopParserRuleCall_1());
                    if (state.failed) return current;

                    }
                    break;
                case 3 :
                    {
                    current = callUnassignedRuleRichStringIf(FOLLOW_ruleRichStringIf_in_ruleRichStringPart6793, elementAccess.getRichStringIfParserRuleCall_2());
                    if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleRichStringForLoop() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleRichStringForLoop = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.RichStringForLoopElements elementAccess = grammarAccess.getRichStringForLoopAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleRichStringForLoop_in_entryRuleRichStringForLoop6834);
            iv_ruleRichStringForLoop=ruleRichStringForLoop();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichStringForLoop; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringForLoop6844); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleRichStringForLoop() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.RichStringForLoopElements elementAccess = grammarAccess.getRichStringForLoopAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getRichStringForLoopAction_0(),
                          current);
            }
            }
            if (!consumeUnassignedToken(54, FOLLOW_54_in_ruleRichStringForLoop6890,  elementAccess.getFORKeyword_1())) { return current; }


            {

            {
            current = callRuleJvmFormalParameterAndSet(FOLLOW_ruleJvmFormalParameter_in_ruleRichStringForLoop6911, current, elementAccess.getDeclaredParamJvmFormalParameterParserRuleCall_2_0(), elementAccess.getRule(), RICH_STRING_FOR_LOOP__DECLARED_PARAM, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(51, FOLLOW_51_in_ruleRichStringForLoop6923,  elementAccess.getColonKeyword_3())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleRichStringForLoop6944, current, elementAccess.getForExpressionXExpressionParserRuleCall_4_0(), elementAccess.getRule(), RICH_STRING_FOR_LOOP__FOR_EXPRESSION, null);
            if (state.failed) return current;

            }
            }
            int alt92=2;
            int LA92_0 = input.LA(1);
            if ( (LA92_0==55) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(55, FOLLOW_55_in_ruleRichStringForLoop6957,  elementAccess.getBEFOREKeyword_5_0())) { return current; }


                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleRichStringForLoop6978, current, elementAccess.getBeforeXExpressionParserRuleCall_5_1_0(), elementAccess.getRule(), RICH_STRING_FOR_LOOP__BEFORE, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    break;
            }
            int alt93=2;
            int LA93_0 = input.LA(1);
            if ( (LA93_0==56) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(56, FOLLOW_56_in_ruleRichStringForLoop6993,  elementAccess.getSEPARATORKeyword_6_0())) { return current; }


                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleRichStringForLoop7014, current, elementAccess.getSeparatorXExpressionParserRuleCall_6_1_0(), elementAccess.getRule(), RICH_STRING_FOR_LOOP__SEPARATOR, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    break;
            }
            int alt94=2;
            int LA94_0 = input.LA(1);
            if ( (LA94_0==57) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(57, FOLLOW_57_in_ruleRichStringForLoop7029,  elementAccess.getAFTERKeyword_7_0())) { return current; }


                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleRichStringForLoop7050, current, elementAccess.getAfterXExpressionParserRuleCall_7_1_0(), elementAccess.getRule(), RICH_STRING_FOR_LOOP__AFTER, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    break;
            }

            {

            {
            current = callRuleInternalRichStringAndSet(FOLLOW_ruleInternalRichString_in_ruleRichStringForLoop7073, current, elementAccess.getEachExpressionInternalRichStringParserRuleCall_8_0(), elementAccess.getRule(), RICH_STRING_FOR_LOOP__EACH_EXPRESSION, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(58, FOLLOW_58_in_ruleRichStringForLoop7085,  elementAccess.getENDFORKeyword_9())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleRichStringIf() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleRichStringIf = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.RichStringIfElements elementAccess = grammarAccess.getRichStringIfAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleRichStringIf_in_entryRuleRichStringIf7127);
            iv_ruleRichStringIf=ruleRichStringIf();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichStringIf; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringIf7137); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleRichStringIf() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.RichStringIfElements elementAccess = grammarAccess.getRichStringIfAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getRichStringIfAction_0(),
                          current);
            }
            }
            if (!consumeUnassignedToken(59, FOLLOW_59_in_ruleRichStringIf7183,  elementAccess.getIFKeyword_1())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleRichStringIf7204, current, elementAccess.getIfXExpressionParserRuleCall_2_0(), elementAccess.getRule(), RICH_STRING_IF__IF, null);
            if (state.failed) return current;

            }
            }

            {

            {
            current = callRuleInternalRichStringAndSet(FOLLOW_ruleInternalRichString_in_ruleRichStringIf7225, current, elementAccess.getThenInternalRichStringParserRuleCall_3_0(), elementAccess.getRule(), RICH_STRING_IF__THEN, null);
            if (state.failed) return current;

            }
            }
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);
                if ( (LA95_0==62) ) {
                    alt95=1;
                }
                switch (alt95) {
            	case 1 :
            	    {

            	    {
            	    current = callRuleRichStringElseIfAndAdd(FOLLOW_ruleRichStringElseIf_in_ruleRichStringIf7246, current, elementAccess.getElseIfsRichStringElseIfParserRuleCall_4_0(), elementAccess.getRule(), RICH_STRING_IF__ELSE_IFS, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    break;
            	default :
            	    break loop95;
                }
            } while (true);
            int alt96=2;
            int LA96_0 = input.LA(1);
            if ( (LA96_0==60) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(60, FOLLOW_60_in_ruleRichStringIf7260,  elementAccess.getELSEKeyword_5_0())) { return current; }


                    {

                    {
                    current = callRuleInternalRichStringAndSet(FOLLOW_ruleInternalRichString_in_ruleRichStringIf7281, current, elementAccess.getElseInternalRichStringParserRuleCall_5_1_0(), elementAccess.getRule(), RICH_STRING_IF__ELSE, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    break;
            }
            if (!consumeUnassignedToken(61, FOLLOW_61_in_ruleRichStringIf7295,  elementAccess.getENDIFKeyword_6())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleRichStringElseIf() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleRichStringElseIf = null;
        	org.eclipse.xtend.core.services.XtendGrammarAccess.RichStringElseIfElements elementAccess = grammarAccess.getRichStringElseIfAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleRichStringElseIf_in_entryRuleRichStringElseIf7337);
            iv_ruleRichStringElseIf=ruleRichStringElseIf();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRichStringElseIf; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRichStringElseIf7347); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleRichStringElseIf() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtend.core.services.XtendGrammarAccess.RichStringElseIfElements elementAccess = grammarAccess.getRichStringElseIfAccess();
        try {

            {

            {
            if (!consumeUnassignedToken(62, FOLLOW_62_in_ruleRichStringElseIf7384,  elementAccess.getELSEIFKeyword_0())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleRichStringElseIf7405, current, elementAccess.getIfXExpressionParserRuleCall_1_0(), elementAccess.getRule(), RICH_STRING_ELSE_IF__IF, null);
            if (state.failed) return current;

            }
            }

            {

            {
            current = callRuleInternalRichStringAndSet(FOLLOW_ruleInternalRichString_in_ruleRichStringElseIf7426, current, elementAccess.getThenInternalRichStringParserRuleCall_2_0(), elementAccess.getRule(), RICH_STRING_ELSE_IF__THEN, null);
            if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleXAnnotation() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXAnnotation = null;
        	org.eclipse.xtext.xbase.annotations.services.XbaseWithAnnotationsGrammarAccess.XAnnotationElements elementAccess = grammarAccess.getXAnnotationAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXAnnotation_in_entryRuleXAnnotation7468);
            iv_ruleXAnnotation=ruleXAnnotation();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAnnotation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAnnotation7478); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXAnnotation() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.annotations.services.XbaseWithAnnotationsGrammarAccess.XAnnotationElements elementAccess = grammarAccess.getXAnnotationAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXAnnotationAction_0(),
                          current);
            }
            }
            if (!consumeUnassignedToken(63, FOLLOW_63_in_ruleXAnnotation7524,  elementAccess.getCommercialAtKeyword_1())) { return current; }


            {

            {
            current = callRuleQualifiedName(FOLLOW_ruleQualifiedName_in_ruleXAnnotation7547, current, elementAccess.getAnnotationTypeJvmAnnotationTypeCrossReference_2_0(), elementAccess.getRule());
            if (state.failed) return current;

            }
            }
            int alt99=2;
            alt99 = dfa99.predict(input);
            switch (alt99) {
                case 1 :
                    {

                    {
                    if (!consumeUnassignedToken(35, FOLLOW_35_in_ruleXAnnotation7568,  elementAccess.getLeftParenthesisKeyword_3_0())) { return current; }

                    }
                    int alt98=3;
                    switch ( input.LA(1) ) {
                        case RULE_ID:
                            {
                            int LA98_1 = input.LA(2);
                            if ( (LA98_1==36||LA98_1==106) ) {
                                alt98=2;
                            }
                            else if ( (LA98_1==33) ) {
                                alt98=1;
                            }
                            }
                            break;
                        case 50:
                            {
                            int LA98_2 = input.LA(2);
                            if ( (LA98_2==36||LA98_2==106) ) {
                                alt98=2;
                            }
                            else if ( (LA98_2==33) ) {
                                alt98=1;
                            }
                            }
                            break;
                        case 32:
                            {
                            int LA98_3 = input.LA(2);
                            if ( (LA98_3==36||LA98_3==106) ) {
                                alt98=2;
                            }
                            else if ( (LA98_3==33) ) {
                                alt98=1;
                            }
                            }
                            break;
                        case RULE_STRING:
                        case RULE_RICH_TEXT:
                        case RULE_RICH_TEXT_START:
                        case RULE_HEX:
                        case RULE_INT:
                        case RULE_DECIMAL:
                        case 20:
                        case 22:
                        case 26:
                        case 27:
                        case 30:
                        case 31:
                        case 34:
                        case 35:
                        case 37:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 48:
                        case 49:
                        case 52:
                        case 63:
                        case 93:
                        case 105:
                        case 107:
                        case 108:
                        case 110:
                            {
                            alt98=2;
                            }
                            break;
                    }
                    switch (alt98) {
                        case 1 :
                            {

                            {

                            {

                            {
                            current = callRuleXAnnotationElementValuePairAndAdd(FOLLOW_ruleXAnnotationElementValuePair_in_ruleXAnnotation7592, current, elementAccess.getElementValuePairsXAnnotationElementValuePairParserRuleCall_3_1_0_0_0(), elementAccess.getRule(), XANNOTATION__ELEMENT_VALUE_PAIRS, null);
                            if (state.failed) return current;

                            }
                            }
                            loop97:
                            do {
                                int alt97=2;
                                int LA97_0 = input.LA(1);
                                if ( (LA97_0==24) ) {
                                    alt97=1;
                                }
                                switch (alt97) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleXAnnotation7605,  elementAccess.getCommaKeyword_3_1_0_1_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleXAnnotationElementValuePairAndAdd(FOLLOW_ruleXAnnotationElementValuePair_in_ruleXAnnotation7626, current, elementAccess.getElementValuePairsXAnnotationElementValuePairParserRuleCall_3_1_0_1_1_0(), elementAccess.getRule(), XANNOTATION__ELEMENT_VALUE_PAIRS, null);
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop97;
                                }
                            } while (true);
                            }
                            }
                            break;
                        case 2 :
                            {

                            {

                            {
                            current = callRuleXAnnotationElementValueAndSet(FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotation7656, current, elementAccess.getValueXAnnotationElementValueParserRuleCall_3_1_1_0(), elementAccess.getRule(), XANNOTATION__VALUE, null);
                            if (state.failed) return current;

                            }
                            }
                            }
                            break;
                    }
                    if (!consumeUnassignedToken(36, FOLLOW_36_in_ruleXAnnotation7670,  elementAccess.getRightParenthesisKeyword_3_2())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleXAnnotationElementValuePair() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXAnnotationElementValuePair = null;
        	org.eclipse.xtext.xbase.annotations.services.XbaseWithAnnotationsGrammarAccess.XAnnotationElementValuePairElements elementAccess = grammarAccess.getXAnnotationElementValuePairAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXAnnotationElementValuePair_in_entryRuleXAnnotationElementValuePair7714);
            iv_ruleXAnnotationElementValuePair=ruleXAnnotationElementValuePair();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAnnotationElementValuePair; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAnnotationElementValuePair7724); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXAnnotationElementValuePair() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.annotations.services.XbaseWithAnnotationsGrammarAccess.XAnnotationElementValuePairElements elementAccess = grammarAccess.getXAnnotationElementValuePairAccess();
        try {

            {

            {

            {

            {
            current = callRuleValidID(FOLLOW_ruleValidID_in_ruleXAnnotationElementValuePair7772, current, elementAccess.getElementJvmOperationCrossReference_0_0(), elementAccess.getRule());
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(33, FOLLOW_33_in_ruleXAnnotationElementValuePair7784,  elementAccess.getEqualsSignKeyword_1())) { return current; }


            {

            {
            current = callRuleXAnnotationElementValueAndSet(FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotationElementValuePair7805, current, elementAccess.getValueXAnnotationElementValueParserRuleCall_2_0(), elementAccess.getRule(), XANNOTATION_ELEMENT_VALUE_PAIR__VALUE, null);
            if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleXAnnotationElementValueStringConcatenation() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXAnnotationElementValueStringConcatenation = null;
        	org.eclipse.xtext.xbase.annotations.services.XbaseWithAnnotationsGrammarAccess.XAnnotationElementValueStringConcatenationElements elementAccess = grammarAccess.getXAnnotationElementValueStringConcatenationAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXAnnotationElementValueStringConcatenation_in_entryRuleXAnnotationElementValueStringConcatenation7847);
            iv_ruleXAnnotationElementValueStringConcatenation=ruleXAnnotationElementValueStringConcatenation();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAnnotationElementValueStringConcatenation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAnnotationElementValueStringConcatenation7857); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXAnnotationElementValueStringConcatenation() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.annotations.services.XbaseWithAnnotationsGrammarAccess.XAnnotationElementValueStringConcatenationElements elementAccess = grammarAccess.getXAnnotationElementValueStringConcatenationAccess();
        try {

            {

            {
            current = callUnassignedRuleXAnnotationElementValue(FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotationElementValueStringConcatenation7904, elementAccess.getXAnnotationElementValueParserRuleCall_0());
            if (state.failed) return current;

            loop100:
            do {
                int alt100=2;
                int LA100_0 = input.LA(1);
                if ( (LA100_0==64) ) {
                    alt100=1;
                }
                switch (alt100) {
            	case 1 :
            	    {

            	    {
            	    if ( state.backtracking==0 ) {
            	              current = forceCreateModelElementAndSet(
            	                  elementAccess.getXAnnotationElementValueBinaryOperationLeftOperandAction_1_0(),
            	                  XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__LEFT_OPERAND,
            	                  current);
            	    }
            	    }

            	    {

            	    {
            	    current = consumeTokenAndSet(64, FOLLOW_64_in_ruleXAnnotationElementValueStringConcatenation7931, current,  elementAccess.getOperatorPlusSignKeyword_1_1_0(), elementAccess.getRule(), XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__OPERATOR);
            	    if (state.failed) return current;

            	    }
            	    }

            	    {

            	    {
            	    current = callRuleXAnnotationElementValueAndSet(FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotationElementValueStringConcatenation7965, current, elementAccess.getRightOperandXAnnotationElementValueParserRuleCall_1_2_0(), elementAccess.getRule(), XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__RIGHT_OPERAND, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    break;
            	default :
            	    break loop100;
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
        }
        return current;
    }

    public final EObject entryRuleXAnnotationElementValue() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXAnnotationElementValue = null;
        	org.eclipse.xtext.xbase.annotations.services.XbaseWithAnnotationsGrammarAccess.XAnnotationElementValueElements elementAccess = grammarAccess.getXAnnotationElementValueAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXAnnotationElementValue_in_entryRuleXAnnotationElementValue8009);
            iv_ruleXAnnotationElementValue=ruleXAnnotationElementValue();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAnnotationElementValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAnnotationElementValue8019); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXAnnotationElementValue() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.annotations.services.XbaseWithAnnotationsGrammarAccess.XAnnotationElementValueElements elementAccess = grammarAccess.getXAnnotationElementValueAccess();
        try {

            {
            int alt101=8;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt101=1;
                }
                break;
            case 93:
                {
                alt101=2;
                }
                break;
            case RULE_STRING:
            case RULE_RICH_TEXT:
            case RULE_RICH_TEXT_START:
                {
                alt101=3;
                }
                break;
            case 107:
            case 108:
                {
                alt101=4;
                }
                break;
            case RULE_HEX:
            case RULE_INT:
            case RULE_DECIMAL:
                {
                alt101=5;
                }
                break;
            case 110:
                {
                alt101=6;
                }
                break;
            case RULE_ID:
            case 20:
            case 22:
            case 26:
            case 27:
            case 30:
            case 31:
            case 32:
            case 34:
            case 37:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 48:
            case 49:
            case 50:
            case 52:
            case 105:
                {
                alt101=7;
                }
                break;
            case 35:
                {
                alt101=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);
                throw nvae;
            }
            switch (alt101) {
                case 1 :
                    {
                    current = callUnassignedRuleXAnnotation(FOLLOW_ruleXAnnotation_in_ruleXAnnotationElementValue8066, elementAccess.getXAnnotationParserRuleCall_0());
                    if (state.failed) return current;

                    }
                    break;
                case 2 :
                    {
                    current = callUnassignedRuleXListLiteral(FOLLOW_ruleXListLiteral_in_ruleXAnnotationElementValue8093, elementAccess.getXListLiteralParserRuleCall_1());
                    if (state.failed) return current;

                    }
                    break;
                case 3 :
                    {
                    current = callUnassignedRuleXStringLiteral(FOLLOW_ruleXStringLiteral_in_ruleXAnnotationElementValue8120, elementAccess.getXStringLiteralParserRuleCall_2());
                    if (state.failed) return current;

                    }
                    break;
                case 4 :
                    {
                    current = callUnassignedRuleXBooleanLiteral(FOLLOW_ruleXBooleanLiteral_in_ruleXAnnotationElementValue8147, elementAccess.getXBooleanLiteralParserRuleCall_3());
                    if (state.failed) return current;

                    }
                    break;
                case 5 :
                    {
                    current = callUnassignedRuleXNumberLiteral(FOLLOW_ruleXNumberLiteral_in_ruleXAnnotationElementValue8174, elementAccess.getXNumberLiteralParserRuleCall_4());
                    if (state.failed) return current;

                    }
                    break;
                case 6 :
                    {
                    current = callUnassignedRuleXTypeLiteral(FOLLOW_ruleXTypeLiteral_in_ruleXAnnotationElementValue8201, elementAccess.getXTypeLiteralParserRuleCall_5());
                    if (state.failed) return current;

                    }
                    break;
                case 7 :
                    {
                    current = callUnassignedRuleXAnnotationValueFieldReference(FOLLOW_ruleXAnnotationValueFieldReference_in_ruleXAnnotationElementValue8228, elementAccess.getXAnnotationValueFieldReferenceParserRuleCall_6());
                    if (state.failed) return current;

                    }
                    break;
                case 8 :
                    {

                    {
                    if (!consumeUnassignedToken(35, FOLLOW_35_in_ruleXAnnotationElementValue8246,  elementAccess.getLeftParenthesisKeyword_7_0())) { return current; }

                    current = callUnassignedRuleXAnnotationElementValueStringConcatenation(FOLLOW_ruleXAnnotationElementValueStringConcatenation_in_ruleXAnnotationElementValue8268, elementAccess.getXAnnotationElementValueStringConcatenationParserRuleCall_7_1());
                    if (state.failed) return current;

                    if (!consumeUnassignedToken(36, FOLLOW_36_in_ruleXAnnotationElementValue8279,  elementAccess.getRightParenthesisKeyword_7_2())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleXAnnotationValueFieldReference() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXAnnotationValueFieldReference = null;
        	org.eclipse.xtext.xbase.annotations.services.XbaseWithAnnotationsGrammarAccess.XAnnotationValueFieldReferenceElements elementAccess = grammarAccess.getXAnnotationValueFieldReferenceAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXAnnotationValueFieldReference_in_entryRuleXAnnotationValueFieldReference8322);
            iv_ruleXAnnotationValueFieldReference=ruleXAnnotationValueFieldReference();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAnnotationValueFieldReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAnnotationValueFieldReference8332); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXAnnotationValueFieldReference() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.annotations.services.XbaseWithAnnotationsGrammarAccess.XAnnotationValueFieldReferenceElements elementAccess = grammarAccess.getXAnnotationValueFieldReferenceAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXFeatureCallAction_0(),
                          current);
            }
            }
            int alt102=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA102_1 = input.LA(2);
                    if ( (LA102_1==106) ) {
                        alt102=1;
                    }
                    }
                    break;
                case 50:
                    {
                    int LA102_2 = input.LA(2);
                    if ( (LA102_2==106) ) {
                        alt102=1;
                    }
                    }
                    break;
                case 32:
                    {
                    int LA102_3 = input.LA(2);
                    if ( (LA102_3==106) ) {
                        alt102=1;
                    }
                    }
                    break;
            }
            switch (alt102) {
                case 1 :
                    {

                    {
                    current = callRuleStaticQualifier(FOLLOW_ruleStaticQualifier_in_ruleXAnnotationValueFieldReference8389, current, elementAccess.getDeclaringTypeJvmDeclaredTypeCrossReference_1_0(), elementAccess.getRule());
                    if (state.failed) return current;

                    }
                    }
                    break;
            }

            {

            {
            current = callRuleIdOrSuper(FOLLOW_ruleIdOrSuper_in_ruleXAnnotationValueFieldReference8413, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_2_0(), elementAccess.getRule());
            if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleXExpression() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXExpression = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XExpressionElements elementAccess = grammarAccess.getXExpressionAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXExpression_in_entryRuleXExpression8455);
            iv_ruleXExpression=ruleXExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpression8465); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXExpression() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XExpressionElements elementAccess = grammarAccess.getXExpressionAccess();
        try {

            {
            current = callUnassignedRuleXAssignment(FOLLOW_ruleXAssignment_in_ruleXExpression8511, elementAccess.getXAssignmentParserRuleCall());
            if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleXAssignment() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXAssignment = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XAssignmentElements elementAccess = grammarAccess.getXAssignmentAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXAssignment_in_entryRuleXAssignment8551);
            iv_ruleXAssignment=ruleXAssignment();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAssignment8561); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXAssignment() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XAssignmentElements elementAccess = grammarAccess.getXAssignmentAccess();
        try {

            {
            int alt104=2;
            alt104 = dfa104.predict(input);
            switch (alt104) {
                case 1 :
                    {

                    {

                    {
                    if ( state.backtracking==0 ) {
                              current = forceCreateModelElement(
                                  elementAccess.getXAssignmentAction_0_0(),
                                  current);
                    }
                    }

                    {

                    {
                    current = callRuleFeatureCallID(FOLLOW_ruleFeatureCallID_in_ruleXAssignment8619, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_0_1_0(), elementAccess.getRule());
                    if (state.failed) return current;

                    }
                    }
                    if ( state.backtracking==0 ) {
                              newCompositeNode(elementAccess.getOpSingleAssignParserRuleCall_0_2()); 
                    }
                    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXAssignment8635);
                    ruleOpSingleAssign();
                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                              afterParserOrEnumRuleCall();
                    }

                    {

                    {
                    current = callRuleXAssignmentAndSet(FOLLOW_ruleXAssignment_in_ruleXAssignment8655, current, elementAccess.getValueXAssignmentParserRuleCall_0_3_0(), elementAccess.getRule(), XASSIGNMENT__VALUE, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    }
                    break;
                case 2 :
                    {

                    {
                    current = callUnassignedRuleXOrExpression(FOLLOW_ruleXOrExpression_in_ruleXAssignment8685, elementAccess.getXOrExpressionParserRuleCall_1_0());
                    if (state.failed) return current;

                    int alt103=2;
                    int LA103_0 = input.LA(1);
                    if ( (LA103_0==65) ) {
                        int LA103_1 = input.LA(2);
                        if ( (synpred7_InternalXtend()) ) {
                            alt103=1;
                        }
                    }
                    else if ( (LA103_0==66) ) {
                        int LA103_2 = input.LA(2);
                        if ( (synpred7_InternalXtend()) ) {
                            alt103=1;
                        }
                    }
                    switch (alt103) {
                        case 1 :
                            {

                            {

                            {

                            {
                            if ( state.backtracking==0 ) {
                                      current = forceCreateModelElementAndSet(
                                          elementAccess.getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
                                          XBINARY_OPERATION__LEFT_OPERAND,
                                          current);
                            }
                            }

                            {

                            {
                            current = callRuleOpMultiAssign(FOLLOW_ruleOpMultiAssign_in_ruleXAssignment8738, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0(), elementAccess.getRule());
                            if (state.failed) return current;

                            }
                            }
                            }
                            }

                            {

                            {
                            current = callRuleXAssignmentAndSet(FOLLOW_ruleXAssignment_in_ruleXAssignment8761, current, elementAccess.getRightOperandXAssignmentParserRuleCall_1_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
                            if (state.failed) return current;

                            }
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
        }
        return current;
    }

    public final String entryRuleOpSingleAssign() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleOpSingleAssign = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpSingleAssignElements elementAccess = grammarAccess.getOpSingleAssignAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign8807);
            iv_ruleOpSingleAssign=ruleOpSingleAssign();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpSingleAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpSingleAssign8818); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final AntlrDatatypeRuleToken ruleOpSingleAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpSingleAssignElements elementAccess = grammarAccess.getOpSingleAssignAccess();
        try {

            {
            if (!consumeTokenAndMerge(33, FOLLOW_33_in_ruleOpSingleAssign8855, current,  elementAccess.getEqualsSignKeyword())) { return current; }

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
        }
        return current;
    }

    public final String entryRuleOpMultiAssign() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleOpMultiAssign = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpMultiAssignElements elementAccess = grammarAccess.getOpMultiAssignAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign8901);
            iv_ruleOpMultiAssign=ruleOpMultiAssign();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMultiAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMultiAssign8912); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final AntlrDatatypeRuleToken ruleOpMultiAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpMultiAssignElements elementAccess = grammarAccess.getOpMultiAssignAccess();
        try {

            {
            int alt105=2;
            int LA105_0 = input.LA(1);
            if ( (LA105_0==65) ) {
                alt105=1;
            }
            else if ( (LA105_0==66) ) {
                alt105=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);
                throw nvae;
            }
            switch (alt105) {
                case 1 :
                    {
                    if (!consumeTokenAndMerge(65, FOLLOW_65_in_ruleOpMultiAssign8950, current,  elementAccess.getPlusSignEqualsSignKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(66, FOLLOW_66_in_ruleOpMultiAssign8969, current,  elementAccess.getHyphenMinusEqualsSignKeyword_1())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleXOrExpression() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXOrExpression = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XOrExpressionElements elementAccess = grammarAccess.getXOrExpressionAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression9015);
            iv_ruleXOrExpression=ruleXOrExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOrExpression9025); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXOrExpression() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XOrExpressionElements elementAccess = grammarAccess.getXOrExpressionAccess();
        try {

            {

            {
            current = callUnassignedRuleXAndExpression(FOLLOW_ruleXAndExpression_in_ruleXOrExpression9072, elementAccess.getXAndExpressionParserRuleCall_0());
            if (state.failed) return current;

            loop106:
            do {
                int alt106=2;
                int LA106_0 = input.LA(1);
                if ( (LA106_0==67) ) {
                    int LA106_2 = input.LA(2);
                    if ( (synpred8_InternalXtend()) ) {
                        alt106=1;
                    }
                }
                switch (alt106) {
            	case 1 :
            	    {

            	    {

            	    {

            	    {
            	    if ( state.backtracking==0 ) {
            	              current = forceCreateModelElementAndSet(
            	                  elementAccess.getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  XBINARY_OPERATION__LEFT_OPERAND,
            	                  current);
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleOpOr(FOLLOW_ruleOpOr_in_ruleXOrExpression9125, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleXAndExpressionAndSet(FOLLOW_ruleXAndExpression_in_ruleXOrExpression9148, current, elementAccess.getRightOperandXAndExpressionParserRuleCall_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    break;
            	default :
            	    break loop106;
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
        }
        return current;
    }

    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleOpOr = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpOrElements elementAccess = grammarAccess.getOpOrAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr9193);
            iv_ruleOpOr=ruleOpOr();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr9204); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpOrElements elementAccess = grammarAccess.getOpOrAccess();
        try {

            {
            if (!consumeTokenAndMerge(67, FOLLOW_67_in_ruleOpOr9241, current,  elementAccess.getVerticalLineVerticalLineKeyword())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleXAndExpression() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXAndExpression = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XAndExpressionElements elementAccess = grammarAccess.getXAndExpressionAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression9286);
            iv_ruleXAndExpression=ruleXAndExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAndExpression9296); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXAndExpression() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XAndExpressionElements elementAccess = grammarAccess.getXAndExpressionAccess();
        try {

            {

            {
            current = callUnassignedRuleXEqualityExpression(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression9343, elementAccess.getXEqualityExpressionParserRuleCall_0());
            if (state.failed) return current;

            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);
                if ( (LA107_0==68) ) {
                    int LA107_2 = input.LA(2);
                    if ( (synpred9_InternalXtend()) ) {
                        alt107=1;
                    }
                }
                switch (alt107) {
            	case 1 :
            	    {

            	    {

            	    {

            	    {
            	    if ( state.backtracking==0 ) {
            	              current = forceCreateModelElementAndSet(
            	                  elementAccess.getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  XBINARY_OPERATION__LEFT_OPERAND,
            	                  current);
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleOpAnd(FOLLOW_ruleOpAnd_in_ruleXAndExpression9396, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleXEqualityExpressionAndSet(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression9419, current, elementAccess.getRightOperandXEqualityExpressionParserRuleCall_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    break;
            	default :
            	    break loop107;
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
        }
        return current;
    }

    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleOpAnd = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpAndElements elementAccess = grammarAccess.getOpAndAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd9464);
            iv_ruleOpAnd=ruleOpAnd();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd9475); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpAndElements elementAccess = grammarAccess.getOpAndAccess();
        try {

            {
            if (!consumeTokenAndMerge(68, FOLLOW_68_in_ruleOpAnd9512, current,  elementAccess.getAmpersandAmpersandKeyword())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleXEqualityExpression() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXEqualityExpression = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XEqualityExpressionElements elementAccess = grammarAccess.getXEqualityExpressionAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression9557);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXEqualityExpression9567); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXEqualityExpression() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XEqualityExpressionElements elementAccess = grammarAccess.getXEqualityExpressionAccess();
        try {

            {

            {
            current = callUnassignedRuleXRelationalExpression(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression9614, elementAccess.getXRelationalExpressionParserRuleCall_0());
            if (state.failed) return current;

            loop108:
            do {
                int alt108=2;
                switch ( input.LA(1) ) {
                case 69:
                    {
                    int LA108_2 = input.LA(2);
                    if ( (synpred10_InternalXtend()) ) {
                        alt108=1;
                    }
                    }
                    break;
                case 70:
                    {
                    int LA108_3 = input.LA(2);
                    if ( (synpred10_InternalXtend()) ) {
                        alt108=1;
                    }
                    }
                    break;
                case 71:
                    {
                    int LA108_4 = input.LA(2);
                    if ( (synpred10_InternalXtend()) ) {
                        alt108=1;
                    }
                    }
                    break;
                case 72:
                    {
                    int LA108_5 = input.LA(2);
                    if ( (synpred10_InternalXtend()) ) {
                        alt108=1;
                    }
                    }
                    break;
                }
                switch (alt108) {
            	case 1 :
            	    {

            	    {

            	    {

            	    {
            	    if ( state.backtracking==0 ) {
            	              current = forceCreateModelElementAndSet(
            	                  elementAccess.getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  XBINARY_OPERATION__LEFT_OPERAND,
            	                  current);
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleOpEquality(FOLLOW_ruleOpEquality_in_ruleXEqualityExpression9667, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleXRelationalExpressionAndSet(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression9690, current, elementAccess.getRightOperandXRelationalExpressionParserRuleCall_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    break;
            	default :
            	    break loop108;
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
        }
        return current;
    }

    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleOpEquality = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpEqualityElements elementAccess = grammarAccess.getOpEqualityAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality9735);
            iv_ruleOpEquality=ruleOpEquality();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality9746); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpEqualityElements elementAccess = grammarAccess.getOpEqualityAccess();
        try {

            {
            int alt109=4;
            switch ( input.LA(1) ) {
            case 69:
                {
                alt109=1;
                }
                break;
            case 70:
                {
                alt109=2;
                }
                break;
            case 71:
                {
                alt109=3;
                }
                break;
            case 72:
                {
                alt109=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);
                throw nvae;
            }
            switch (alt109) {
                case 1 :
                    {
                    if (!consumeTokenAndMerge(69, FOLLOW_69_in_ruleOpEquality9784, current,  elementAccess.getEqualsSignEqualsSignKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(70, FOLLOW_70_in_ruleOpEquality9803, current,  elementAccess.getExclamationMarkEqualsSignKeyword_1())) { return current; }

                    }
                    break;
                case 3 :
                    {
                    if (!consumeTokenAndMerge(71, FOLLOW_71_in_ruleOpEquality9822, current,  elementAccess.getEqualsSignEqualsSignEqualsSignKeyword_2())) { return current; }

                    }
                    break;
                case 4 :
                    {
                    if (!consumeTokenAndMerge(72, FOLLOW_72_in_ruleOpEquality9841, current,  elementAccess.getExclamationMarkEqualsSignEqualsSignKeyword_3())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleXRelationalExpression() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXRelationalExpression = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XRelationalExpressionElements elementAccess = grammarAccess.getXRelationalExpressionAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression9887);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXRelationalExpression9897); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXRelationalExpression() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XRelationalExpressionElements elementAccess = grammarAccess.getXRelationalExpressionAccess();
        try {

            {

            {
            current = callUnassignedRuleXOtherOperatorExpression(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression9944, elementAccess.getXOtherOperatorExpressionParserRuleCall_0());
            if (state.failed) return current;

            loop110:
            do {
                int alt110=3;
                switch ( input.LA(1) ) {
                case 23:
                    {
                    int LA110_2 = input.LA(2);
                    if ( (synpred12_InternalXtend()) ) {
                        alt110=2;
                    }
                    }
                    break;
                case 25:
                    {
                    int LA110_3 = input.LA(2);
                    if ( (synpred12_InternalXtend()) ) {
                        alt110=2;
                    }
                    }
                    break;
                case 73:
                    {
                    int LA110_4 = input.LA(2);
                    if ( (synpred11_InternalXtend()) ) {
                        alt110=1;
                    }
                    }
                    break;
                case 74:
                    {
                    int LA110_5 = input.LA(2);
                    if ( (synpred12_InternalXtend()) ) {
                        alt110=2;
                    }
                    }
                    break;
                case 75:
                    {
                    int LA110_6 = input.LA(2);
                    if ( (synpred12_InternalXtend()) ) {
                        alt110=2;
                    }
                    }
                    break;
                }
                switch (alt110) {
            	case 1 :
            	    {

            	    {

            	    {

            	    {

            	    {
            	    if ( state.backtracking==0 ) {
            	              current = forceCreateModelElementAndSet(
            	                  elementAccess.getXInstanceOfExpressionExpressionAction_1_0_0_0_0(),
            	                  XINSTANCE_OF_EXPRESSION__EXPRESSION,
            	                  current);
            	    }
            	    }
            	    if (!consumeUnassignedToken(73, FOLLOW_73_in_ruleXRelationalExpression9980,  elementAccess.getInstanceofKeyword_1_0_0_0_1())) { return current; }

            	    }
            	    }

            	    {

            	    {
            	    current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleXRelationalExpression10003, current, elementAccess.getTypeJvmTypeReferenceParserRuleCall_1_0_1_0(), elementAccess.getRule(), XINSTANCE_OF_EXPRESSION__TYPE, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }
            	    break;
            	case 2 :
            	    {

            	    {

            	    {

            	    {

            	    {
            	    if ( state.backtracking==0 ) {
            	              current = forceCreateModelElementAndSet(
            	                  elementAccess.getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
            	                  XBINARY_OPERATION__LEFT_OPERAND,
            	                  current);
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleOpCompare(FOLLOW_ruleOpCompare_in_ruleXRelationalExpression10064, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleXOtherOperatorExpressionAndSet(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression10087, current, elementAccess.getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }
            	    break;
            	default :
            	    break loop110;
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
        }
        return current;
    }

    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleOpCompare = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpCompareElements elementAccess = grammarAccess.getOpCompareAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare10133);
            iv_ruleOpCompare=ruleOpCompare();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare10144); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpCompareElements elementAccess = grammarAccess.getOpCompareAccess();
        try {

            {
            int alt111=4;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt111=1;
                }
                break;
            case 75:
                {
                alt111=2;
                }
                break;
            case 25:
                {
                alt111=3;
                }
                break;
            case 23:
                {
                alt111=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);
                throw nvae;
            }
            switch (alt111) {
                case 1 :
                    {
                    if (!consumeTokenAndMerge(74, FOLLOW_74_in_ruleOpCompare10182, current,  elementAccess.getGreaterThanSignEqualsSignKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(75, FOLLOW_75_in_ruleOpCompare10201, current,  elementAccess.getLessThanSignEqualsSignKeyword_1())) { return current; }

                    }
                    break;
                case 3 :
                    {
                    if (!consumeTokenAndMerge(25, FOLLOW_25_in_ruleOpCompare10220, current,  elementAccess.getGreaterThanSignKeyword_2())) { return current; }

                    }
                    break;
                case 4 :
                    {
                    if (!consumeTokenAndMerge(23, FOLLOW_23_in_ruleOpCompare10239, current,  elementAccess.getLessThanSignKeyword_3())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXOtherOperatorExpression = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XOtherOperatorExpressionElements elementAccess = grammarAccess.getXOtherOperatorExpressionAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression10285);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOtherOperatorExpression10295); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XOtherOperatorExpressionElements elementAccess = grammarAccess.getXOtherOperatorExpressionAccess();
        try {

            {

            {
            current = callUnassignedRuleXAdditiveExpression(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression10342, elementAccess.getXAdditiveExpressionParserRuleCall_0());
            if (state.failed) return current;

            loop112:
            do {
                int alt112=2;
                alt112 = dfa112.predict(input);
                switch (alt112) {
            	case 1 :
            	    {

            	    {

            	    {

            	    {
            	    if ( state.backtracking==0 ) {
            	              current = forceCreateModelElementAndSet(
            	                  elementAccess.getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  XBINARY_OPERATION__LEFT_OPERAND,
            	                  current);
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleOpOther(FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression10395, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleXAdditiveExpressionAndSet(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression10418, current, elementAccess.getRightOperandXAdditiveExpressionParserRuleCall_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    break;
            	default :
            	    break loop112;
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
        }
        return current;
    }

    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleOpOther = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpOtherElements elementAccess = grammarAccess.getOpOtherAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleOpOther_in_entryRuleOpOther10463);
            iv_ruleOpOther=ruleOpOther();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOther10474); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpOtherElements elementAccess = grammarAccess.getOpOtherAccess();
        try {

            {
            int alt115=10;
            alt115 = dfa115.predict(input);
            switch (alt115) {
                case 1 :
                    {
                    if (!consumeTokenAndMerge(76, FOLLOW_76_in_ruleOpOther10512, current,  elementAccess.getHyphenMinusGreaterThanSignKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(77, FOLLOW_77_in_ruleOpOther10531, current,  elementAccess.getFullStopFullStopLessThanSignKeyword_1())) { return current; }

                    }
                    break;
                case 3 :
                    {

                    {
                    if (!consumeTokenAndMerge(25, FOLLOW_25_in_ruleOpOther10551, current,  elementAccess.getGreaterThanSignKeyword_2_0())) { return current; }

                    if (!consumeTokenAndMerge(78, FOLLOW_78_in_ruleOpOther10564, current,  elementAccess.getFullStopFullStopKeyword_2_1())) { return current; }

                    }
                    }
                    break;
                case 4 :
                    {
                    if (!consumeTokenAndMerge(78, FOLLOW_78_in_ruleOpOther10584, current,  elementAccess.getFullStopFullStopKeyword_3())) { return current; }

                    }
                    break;
                case 5 :
                    {
                    if (!consumeTokenAndMerge(79, FOLLOW_79_in_ruleOpOther10603, current,  elementAccess.getEqualsSignGreaterThanSignKeyword_4())) { return current; }

                    }
                    break;
                case 6 :
                    {

                    {
                    if (!consumeTokenAndMerge(25, FOLLOW_25_in_ruleOpOther10623, current,  elementAccess.getGreaterThanSignKeyword_5_0())) { return current; }

                    int alt113=2;
                    int LA113_0 = input.LA(1);
                    if ( (LA113_0==25) ) {
                        int LA113_1 = input.LA(2);
                        if ( (LA113_1==25) && (synpred14_InternalXtend())) {
                            alt113=1;
                        }
                        else if ( (LA113_1==EOF||(LA113_1>=RULE_ID && LA113_1<=RULE_RICH_TEXT_START)||(LA113_1>=RULE_HEX && LA113_1<=RULE_DECIMAL)||LA113_1==20||(LA113_1>=22 && LA113_1<=23)||(LA113_1>=26 && LA113_1<=28)||(LA113_1>=30 && LA113_1<=32)||(LA113_1>=34 && LA113_1<=35)||(LA113_1>=37 && LA113_1<=45)||(LA113_1>=48 && LA113_1<=50)||LA113_1==52||LA113_1==64||LA113_1==83||LA113_1==88||(LA113_1>=93 && LA113_1<=94)||LA113_1==97||LA113_1==99||(LA113_1>=102 && LA113_1<=105)||(LA113_1>=107 && LA113_1<=113)) ) {
                            alt113=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 113, 1, input);
                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 113, 0, input);
                        throw nvae;
                    }
                    switch (alt113) {
                        case 1 :
                            {

                            {

                            {
                            if (!consumeTokenAndMerge(25, FOLLOW_25_in_ruleOpOther10654, current,  elementAccess.getGreaterThanSignKeyword_5_1_0_0_0())) { return current; }

                            if (!consumeTokenAndMerge(25, FOLLOW_25_in_ruleOpOther10667, current,  elementAccess.getGreaterThanSignKeyword_5_1_0_0_1())) { return current; }

                            }
                            }
                            }
                            break;
                        case 2 :
                            {
                            if (!consumeTokenAndMerge(25, FOLLOW_25_in_ruleOpOther10688, current,  elementAccess.getGreaterThanSignKeyword_5_1_1())) { return current; }

                            }
                            break;
                    }
                    }
                    }
                    break;
                case 7 :
                    {

                    {
                    if (!consumeTokenAndMerge(23, FOLLOW_23_in_ruleOpOther10710, current,  elementAccess.getLessThanSignKeyword_6_0())) { return current; }

                    int alt114=2;
                    int LA114_0 = input.LA(1);
                    if ( (LA114_0==23) ) {
                        int LA114_1 = input.LA(2);
                        if ( (synpred15_InternalXtend()) ) {
                            alt114=1;
                        }
                        else if ( (true) ) {
                            alt114=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 114, 1, input);
                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 114, 0, input);
                        throw nvae;
                    }
                    switch (alt114) {
                        case 1 :
                            {

                            {

                            {
                            if (!consumeTokenAndMerge(23, FOLLOW_23_in_ruleOpOther10741, current,  elementAccess.getLessThanSignKeyword_6_1_0_0_0())) { return current; }

                            if (!consumeTokenAndMerge(23, FOLLOW_23_in_ruleOpOther10754, current,  elementAccess.getLessThanSignKeyword_6_1_0_0_1())) { return current; }

                            }
                            }
                            }
                            break;
                        case 2 :
                            {
                            if (!consumeTokenAndMerge(23, FOLLOW_23_in_ruleOpOther10775, current,  elementAccess.getLessThanSignKeyword_6_1_1())) { return current; }

                            }
                            break;
                    }
                    }
                    }
                    break;
                case 8 :
                    {
                    if (!consumeTokenAndMerge(80, FOLLOW_80_in_ruleOpOther10796, current,  elementAccess.getLessThanSignGreaterThanSignKeyword_7())) { return current; }

                    }
                    break;
                case 9 :
                    {
                    if (!consumeTokenAndMerge(81, FOLLOW_81_in_ruleOpOther10815, current,  elementAccess.getQuestionMarkColonKeyword_8())) { return current; }

                    }
                    break;
                case 10 :
                    {
                    if (!consumeTokenAndMerge(82, FOLLOW_82_in_ruleOpOther10834, current,  elementAccess.getLessThanSignEqualsSignGreaterThanSignKeyword_9())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXAdditiveExpression = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XAdditiveExpressionElements elementAccess = grammarAccess.getXAdditiveExpressionAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression10880);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAdditiveExpression10890); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXAdditiveExpression() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XAdditiveExpressionElements elementAccess = grammarAccess.getXAdditiveExpressionAccess();
        try {

            {

            {
            current = callUnassignedRuleXMultiplicativeExpression(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression10937, elementAccess.getXMultiplicativeExpressionParserRuleCall_0());
            if (state.failed) return current;

            loop116:
            do {
                int alt116=2;
                int LA116_0 = input.LA(1);
                if ( (LA116_0==83) ) {
                    int LA116_2 = input.LA(2);
                    if ( (synpred16_InternalXtend()) ) {
                        alt116=1;
                    }
                }
                else if ( (LA116_0==64) ) {
                    int LA116_3 = input.LA(2);
                    if ( (synpred16_InternalXtend()) ) {
                        alt116=1;
                    }
                }
                switch (alt116) {
            	case 1 :
            	    {

            	    {

            	    {

            	    {
            	    if ( state.backtracking==0 ) {
            	              current = forceCreateModelElementAndSet(
            	                  elementAccess.getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  XBINARY_OPERATION__LEFT_OPERAND,
            	                  current);
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleOpAdd(FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression10990, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleXMultiplicativeExpressionAndSet(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression11013, current, elementAccess.getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    break;
            	default :
            	    break loop116;
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
        }
        return current;
    }

    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleOpAdd = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpAddElements elementAccess = grammarAccess.getOpAddAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd11058);
            iv_ruleOpAdd=ruleOpAdd();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd11069); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpAddElements elementAccess = grammarAccess.getOpAddAccess();
        try {

            {
            int alt117=2;
            int LA117_0 = input.LA(1);
            if ( (LA117_0==64) ) {
                alt117=1;
            }
            else if ( (LA117_0==83) ) {
                alt117=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);
                throw nvae;
            }
            switch (alt117) {
                case 1 :
                    {
                    if (!consumeTokenAndMerge(64, FOLLOW_64_in_ruleOpAdd11107, current,  elementAccess.getPlusSignKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(83, FOLLOW_83_in_ruleOpAdd11126, current,  elementAccess.getHyphenMinusKeyword_1())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXMultiplicativeExpression = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XMultiplicativeExpressionElements elementAccess = grammarAccess.getXMultiplicativeExpressionAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression11172);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMultiplicativeExpression11182); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XMultiplicativeExpressionElements elementAccess = grammarAccess.getXMultiplicativeExpressionAccess();
        try {

            {

            {
            current = callUnassignedRuleXUnaryOperation(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression11229, elementAccess.getXUnaryOperationParserRuleCall_0());
            if (state.failed) return current;

            loop118:
            do {
                int alt118=2;
                switch ( input.LA(1) ) {
                case 84:
                    {
                    int LA118_2 = input.LA(2);
                    if ( (synpred17_InternalXtend()) ) {
                        alt118=1;
                    }
                    }
                    break;
                case 85:
                    {
                    int LA118_3 = input.LA(2);
                    if ( (synpred17_InternalXtend()) ) {
                        alt118=1;
                    }
                    }
                    break;
                case 86:
                    {
                    int LA118_4 = input.LA(2);
                    if ( (synpred17_InternalXtend()) ) {
                        alt118=1;
                    }
                    }
                    break;
                case 87:
                    {
                    int LA118_5 = input.LA(2);
                    if ( (synpred17_InternalXtend()) ) {
                        alt118=1;
                    }
                    }
                    break;
                }
                switch (alt118) {
            	case 1 :
            	    {

            	    {

            	    {

            	    {
            	    if ( state.backtracking==0 ) {
            	              current = forceCreateModelElementAndSet(
            	                  elementAccess.getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  XBINARY_OPERATION__LEFT_OPERAND,
            	                  current);
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleOpMulti(FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression11282, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleXUnaryOperationAndSet(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression11305, current, elementAccess.getRightOperandXUnaryOperationParserRuleCall_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    break;
            	default :
            	    break loop118;
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
        }
        return current;
    }

    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleOpMulti = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpMultiElements elementAccess = grammarAccess.getOpMultiAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti11350);
            iv_ruleOpMulti=ruleOpMulti();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti11361); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpMultiElements elementAccess = grammarAccess.getOpMultiAccess();
        try {

            {
            int alt119=4;
            switch ( input.LA(1) ) {
            case 84:
                {
                alt119=1;
                }
                break;
            case 85:
                {
                alt119=2;
                }
                break;
            case 86:
                {
                alt119=3;
                }
                break;
            case 87:
                {
                alt119=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 119, 0, input);
                throw nvae;
            }
            switch (alt119) {
                case 1 :
                    {
                    if (!consumeTokenAndMerge(84, FOLLOW_84_in_ruleOpMulti11399, current,  elementAccess.getAsteriskKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(85, FOLLOW_85_in_ruleOpMulti11418, current,  elementAccess.getAsteriskAsteriskKeyword_1())) { return current; }

                    }
                    break;
                case 3 :
                    {
                    if (!consumeTokenAndMerge(86, FOLLOW_86_in_ruleOpMulti11437, current,  elementAccess.getSolidusKeyword_2())) { return current; }

                    }
                    break;
                case 4 :
                    {
                    if (!consumeTokenAndMerge(87, FOLLOW_87_in_ruleOpMulti11456, current,  elementAccess.getPercentSignKeyword_3())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleXUnaryOperation() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXUnaryOperation = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XUnaryOperationElements elementAccess = grammarAccess.getXUnaryOperationAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation11502);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXUnaryOperation11512); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXUnaryOperation() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XUnaryOperationElements elementAccess = grammarAccess.getXUnaryOperationAccess();
        try {

            {
            int alt120=2;
            int LA120_0 = input.LA(1);
            if ( (LA120_0==64||LA120_0==83||LA120_0==88) ) {
                alt120=1;
            }
            else if ( ((LA120_0>=RULE_ID && LA120_0<=RULE_RICH_TEXT_START)||(LA120_0>=RULE_HEX && LA120_0<=RULE_DECIMAL)||LA120_0==20||(LA120_0>=22 && LA120_0<=23)||(LA120_0>=26 && LA120_0<=28)||(LA120_0>=30 && LA120_0<=32)||(LA120_0>=34 && LA120_0<=35)||(LA120_0>=37 && LA120_0<=45)||(LA120_0>=48 && LA120_0<=50)||LA120_0==52||(LA120_0>=93 && LA120_0<=94)||LA120_0==97||LA120_0==99||(LA120_0>=102 && LA120_0<=105)||(LA120_0>=107 && LA120_0<=113)) ) {
                alt120=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 120, 0, input);
                throw nvae;
            }
            switch (alt120) {
                case 1 :
                    {

                    {

                    {
                    if ( state.backtracking==0 ) {
                              current = forceCreateModelElement(
                                  elementAccess.getXUnaryOperationAction_0_0(),
                                  current);
                    }
                    }

                    {

                    {
                    current = callRuleOpUnary(FOLLOW_ruleOpUnary_in_ruleXUnaryOperation11570, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_0_1_0(), elementAccess.getRule());
                    if (state.failed) return current;

                    }
                    }

                    {

                    {
                    current = callRuleXUnaryOperationAndSet(FOLLOW_ruleXUnaryOperation_in_ruleXUnaryOperation11591, current, elementAccess.getOperandXUnaryOperationParserRuleCall_0_2_0(), elementAccess.getRule(), XUNARY_OPERATION__OPERAND, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    }
                    break;
                case 2 :
                    {
                    current = callUnassignedRuleXCastedExpression(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation11620, elementAccess.getXCastedExpressionParserRuleCall_1());
                    if (state.failed) return current;

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
        }
        return current;
    }

    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleOpUnary = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpUnaryElements elementAccess = grammarAccess.getOpUnaryAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary11662);
            iv_ruleOpUnary=ruleOpUnary();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary11673); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpUnaryElements elementAccess = grammarAccess.getOpUnaryAccess();
        try {

            {
            int alt121=3;
            switch ( input.LA(1) ) {
            case 88:
                {
                alt121=1;
                }
                break;
            case 83:
                {
                alt121=2;
                }
                break;
            case 64:
                {
                alt121=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 121, 0, input);
                throw nvae;
            }
            switch (alt121) {
                case 1 :
                    {
                    if (!consumeTokenAndMerge(88, FOLLOW_88_in_ruleOpUnary11711, current,  elementAccess.getExclamationMarkKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(83, FOLLOW_83_in_ruleOpUnary11730, current,  elementAccess.getHyphenMinusKeyword_1())) { return current; }

                    }
                    break;
                case 3 :
                    {
                    if (!consumeTokenAndMerge(64, FOLLOW_64_in_ruleOpUnary11749, current,  elementAccess.getPlusSignKeyword_2())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleXCastedExpression() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXCastedExpression = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XCastedExpressionElements elementAccess = grammarAccess.getXCastedExpressionAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression11795);
            iv_ruleXCastedExpression=ruleXCastedExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCastedExpression11805); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXCastedExpression() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XCastedExpressionElements elementAccess = grammarAccess.getXCastedExpressionAccess();
        try {

            {

            {
            current = callUnassignedRuleXMemberFeatureCall(FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression11852, elementAccess.getXMemberFeatureCallParserRuleCall_0());
            if (state.failed) return current;

            loop122:
            do {
                int alt122=2;
                int LA122_0 = input.LA(1);
                if ( (LA122_0==89) ) {
                    int LA122_2 = input.LA(2);
                    if ( (synpred18_InternalXtend()) ) {
                        alt122=1;
                    }
                }
                switch (alt122) {
            	case 1 :
            	    {

            	    {

            	    {

            	    {
            	    if ( state.backtracking==0 ) {
            	              current = forceCreateModelElementAndSet(
            	                  elementAccess.getXCastedExpressionTargetAction_1_0_0_0(),
            	                  XCASTED_EXPRESSION__TARGET,
            	                  current);
            	    }
            	    }
            	    if (!consumeUnassignedToken(89, FOLLOW_89_in_ruleXCastedExpression11887,  elementAccess.getAsKeyword_1_0_0_1())) { return current; }

            	    }
            	    }

            	    {

            	    {
            	    current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression11910, current, elementAccess.getTypeJvmTypeReferenceParserRuleCall_1_1_0(), elementAccess.getRule(), XCASTED_EXPRESSION__TYPE, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    break;
            	default :
            	    break loop122;
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
        }
        return current;
    }

    public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXMemberFeatureCall = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XMemberFeatureCallElements elementAccess = grammarAccess.getXMemberFeatureCallAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall11954);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMemberFeatureCall11964); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XMemberFeatureCallElements elementAccess = grammarAccess.getXMemberFeatureCallAccess();
        try {

            {

            {
            current = callUnassignedRuleXPrimaryExpression(FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall12011, elementAccess.getXPrimaryExpressionParserRuleCall_0());
            if (state.failed) return current;

            loop130:
            do {
                int alt130=3;
                switch ( input.LA(1) ) {
                case 90:
                    {
                    int LA130_2 = input.LA(2);
                    if ( (synpred19_InternalXtend()) ) {
                        alt130=1;
                    }
                    else if ( (synpred20_InternalXtend()) ) {
                        alt130=2;
                    }
                    }
                    break;
                case 91:
                    {
                    int LA130_3 = input.LA(2);
                    if ( (synpred20_InternalXtend()) ) {
                        alt130=2;
                    }
                    }
                    break;
                case 92:
                    {
                    int LA130_4 = input.LA(2);
                    if ( (synpred20_InternalXtend()) ) {
                        alt130=2;
                    }
                    }
                    break;
                }
                switch (alt130) {
            	case 1 :
            	    {

            	    {

            	    {

            	    {

            	    {
            	    if ( state.backtracking==0 ) {
            	              current = forceCreateModelElementAndSet(
            	                  elementAccess.getXAssignmentAssignableAction_1_0_0_0_0(),
            	                  XASSIGNMENT__ASSIGNABLE,
            	                  current);
            	    }
            	    }
            	    if (!consumeUnassignedToken(90, FOLLOW_90_in_ruleXMemberFeatureCall12060,  elementAccess.getFullStopKeyword_1_0_0_0_1())) { return current; }


            	    {

            	    {
            	    current = callRuleFeatureCallID(FOLLOW_ruleFeatureCallID_in_ruleXMemberFeatureCall12083, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    if ( state.backtracking==0 ) {
            	              newCompositeNode(elementAccess.getOpSingleAssignParserRuleCall_1_0_0_0_3()); 
            	    }
            	    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall12099);
            	    ruleOpSingleAssign();
            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	              afterParserOrEnumRuleCall();
            	    }
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleXAssignmentAndSet(FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall12121, current, elementAccess.getValueXAssignmentParserRuleCall_1_0_1_0(), elementAccess.getRule(), XASSIGNMENT__VALUE, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }
            	    break;
            	case 2 :
            	    {

            	    {

            	    {

            	    {

            	    {
            	    if ( state.backtracking==0 ) {
            	              current = forceCreateModelElementAndSet(
            	                  elementAccess.getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0(),
            	                  XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET,
            	                  current);
            	    }
            	    }
            	    int alt123=3;
            	    switch ( input.LA(1) ) {
            	    case 90:
            	        {
            	        alt123=1;
            	        }
            	        break;
            	    case 91:
            	        {
            	        alt123=2;
            	        }
            	        break;
            	    case 92:
            	        {
            	        alt123=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 123, 0, input);
            	        throw nvae;
            	    }
            	    switch (alt123) {
            	        case 1 :
            	            {
            	            if (!consumeUnassignedToken(90, FOLLOW_90_in_ruleXMemberFeatureCall12207,  elementAccess.getFullStopKeyword_1_1_0_0_1_0())) { return current; }

            	            }
            	            break;
            	        case 2 :
            	            {

            	            {

            	            {
            	            current = consumeTokenAndSetBooleanValue(91, FOLLOW_91_in_ruleXMemberFeatureCall12231, current,  elementAccess.getNullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__NULL_SAFE);
            	            if (state.failed) return current;

            	            }
            	            }
            	            }
            	            break;
            	        case 3 :
            	            {

            	            {

            	            {
            	            current = consumeTokenAndSetBooleanValue(92, FOLLOW_92_in_ruleXMemberFeatureCall12268, current,  elementAccess.getSpreadingAsteriskFullStopKeyword_1_1_0_0_1_2_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__SPREADING);
            	            if (state.failed) return current;

            	            }
            	            }
            	            }
            	            break;
            	    }
            	    }
            	    }
            	    int alt125=2;
            	    int LA125_0 = input.LA(1);
            	    if ( (LA125_0==23) ) {
            	        alt125=1;
            	    }
            	    switch (alt125) {
            	        case 1 :
            	            {
            	            if (!consumeUnassignedToken(23, FOLLOW_23_in_ruleXMemberFeatureCall12297,  elementAccess.getLessThanSignKeyword_1_1_1_0())) { return current; }


            	            {

            	            {
            	            current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall12318, current, elementAccess.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__TYPE_ARGUMENTS, null);
            	            if (state.failed) return current;

            	            }
            	            }
            	            loop124:
            	            do {
            	                int alt124=2;
            	                int LA124_0 = input.LA(1);
            	                if ( (LA124_0==24) ) {
            	                    alt124=1;
            	                }
            	                switch (alt124) {
            	            	case 1 :
            	            	    {
            	            	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleXMemberFeatureCall12331,  elementAccess.getCommaKeyword_1_1_1_2_0())) { return current; }


            	            	    {

            	            	    {
            	            	    current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall12352, current, elementAccess.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__TYPE_ARGUMENTS, null);
            	            	    if (state.failed) return current;

            	            	    }
            	            	    }
            	            	    }
            	            	    break;
            	            	default :
            	            	    break loop124;
            	                }
            	            } while (true);
            	            if (!consumeUnassignedToken(25, FOLLOW_25_in_ruleXMemberFeatureCall12366,  elementAccess.getGreaterThanSignKeyword_1_1_1_3())) { return current; }

            	            }
            	            break;
            	    }

            	    {

            	    {
            	    current = callRuleFeatureCallID(FOLLOW_ruleFeatureCallID_in_ruleXMemberFeatureCall12391, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_1_2_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    int alt128=2;
            	    alt128 = dfa128.predict(input);
            	    switch (alt128) {
            	        case 1 :
            	            {

            	            {

            	            {
            	            current = consumeTokenAndSetBooleanValue(35, FOLLOW_35_in_ruleXMemberFeatureCall12425, current,  elementAccess.getExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__EXPLICIT_OPERATION_CALL);
            	            if (state.failed) return current;

            	            }
            	            }
            	            int alt127=3;
            	            alt127 = dfa127.predict(input);
            	            switch (alt127) {
            	                case 1 :
            	                    {

            	                    {

            	                    {
            	                    current = callRuleXShortClosureAndAdd(FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall12510, current, elementAccess.getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS, null);
            	                    if (state.failed) return current;

            	                    }
            	                    }
            	                    }
            	                    break;
            	                case 2 :
            	                    {

            	                    {

            	                    {

            	                    {
            	                    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall12538, current, elementAccess.getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS, null);
            	                    if (state.failed) return current;

            	                    }
            	                    }
            	                    loop126:
            	                    do {
            	                        int alt126=2;
            	                        int LA126_0 = input.LA(1);
            	                        if ( (LA126_0==24) ) {
            	                            alt126=1;
            	                        }
            	                        switch (alt126) {
            	                    	case 1 :
            	                    	    {
            	                    	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleXMemberFeatureCall12551,  elementAccess.getCommaKeyword_1_1_3_1_1_1_0())) { return current; }


            	                    	    {

            	                    	    {
            	                    	    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall12572, current, elementAccess.getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS, null);
            	                    	    if (state.failed) return current;

            	                    	    }
            	                    	    }
            	                    	    }
            	                    	    break;
            	                    	default :
            	                    	    break loop126;
            	                        }
            	                    } while (true);
            	                    }
            	                    }
            	                    break;
            	            }
            	            if (!consumeUnassignedToken(36, FOLLOW_36_in_ruleXMemberFeatureCall12589,  elementAccess.getRightParenthesisKeyword_1_1_3_2())) { return current; }

            	            }
            	            break;
            	    }
            	    int alt129=2;
            	    alt129 = dfa129.predict(input);
            	    switch (alt129) {
            	        case 1 :
            	            {

            	            {
            	            current = callRuleXClosureAndAdd(FOLLOW_ruleXClosure_in_ruleXMemberFeatureCall12624, current, elementAccess.getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS, null);
            	            if (state.failed) return current;

            	            }
            	            }
            	            break;
            	    }
            	    }
            	    }
            	    break;
            	default :
            	    break loop130;
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
        }
        return current;
    }

    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXPrimaryExpression = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XPrimaryExpressionElements elementAccess = grammarAccess.getXPrimaryExpressionAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression12670);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXPrimaryExpression12680); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXPrimaryExpression() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XPrimaryExpressionElements elementAccess = grammarAccess.getXPrimaryExpressionAccess();
        try {

            {
            int alt131=13;
            alt131 = dfa131.predict(input);
            switch (alt131) {
                case 1 :
                    {
                    current = callUnassignedRuleXConstructorCall(FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression12727, elementAccess.getXConstructorCallParserRuleCall_0());
                    if (state.failed) return current;

                    }
                    break;
                case 2 :
                    {
                    current = callUnassignedRuleXBlockExpression(FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression12754, elementAccess.getXBlockExpressionParserRuleCall_1());
                    if (state.failed) return current;

                    }
                    break;
                case 3 :
                    {
                    current = callUnassignedRuleXSwitchExpression(FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression12781, elementAccess.getXSwitchExpressionParserRuleCall_2());
                    if (state.failed) return current;

                    }
                    break;
                case 4 :
                    {
                    current = callUnassignedRuleXFeatureCall(FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression12808, elementAccess.getXFeatureCallParserRuleCall_3());
                    if (state.failed) return current;

                    }
                    break;
                case 5 :
                    {
                    current = callUnassignedRuleXLiteral(FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression12835, elementAccess.getXLiteralParserRuleCall_4());
                    if (state.failed) return current;

                    }
                    break;
                case 6 :
                    {
                    current = callUnassignedRuleXIfExpression(FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression12862, elementAccess.getXIfExpressionParserRuleCall_5());
                    if (state.failed) return current;

                    }
                    break;
                case 7 :
                    {
                    current = callUnassignedRuleXForLoopExpression(FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression12889, elementAccess.getXForLoopExpressionParserRuleCall_6());
                    if (state.failed) return current;

                    }
                    break;
                case 8 :
                    {
                    current = callUnassignedRuleXWhileExpression(FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression12916, elementAccess.getXWhileExpressionParserRuleCall_7());
                    if (state.failed) return current;

                    }
                    break;
                case 9 :
                    {
                    current = callUnassignedRuleXDoWhileExpression(FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression12943, elementAccess.getXDoWhileExpressionParserRuleCall_8());
                    if (state.failed) return current;

                    }
                    break;
                case 10 :
                    {
                    current = callUnassignedRuleXThrowExpression(FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression12970, elementAccess.getXThrowExpressionParserRuleCall_9());
                    if (state.failed) return current;

                    }
                    break;
                case 11 :
                    {
                    current = callUnassignedRuleXReturnExpression(FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression12997, elementAccess.getXReturnExpressionParserRuleCall_10());
                    if (state.failed) return current;

                    }
                    break;
                case 12 :
                    {
                    current = callUnassignedRuleXTryCatchFinallyExpression(FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression13024, elementAccess.getXTryCatchFinallyExpressionParserRuleCall_11());
                    if (state.failed) return current;

                    }
                    break;
                case 13 :
                    {
                    current = callUnassignedRuleXParenthesizedExpression(FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression13051, elementAccess.getXParenthesizedExpressionParserRuleCall_12());
                    if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleXLiteral() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXLiteral = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XLiteralElements elementAccess = grammarAccess.getXLiteralAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXLiteral_in_entryRuleXLiteral13092);
            iv_ruleXLiteral=ruleXLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXLiteral13102); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXLiteral() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XLiteralElements elementAccess = grammarAccess.getXLiteralAccess();
        try {

            {
            int alt132=7;
            int LA132_0 = input.LA(1);
            if ( (LA132_0==93) ) {
                alt132=1;
            }
            else if ( (LA132_0==94) && (synpred24_InternalXtend())) {
                alt132=2;
            }
            else if ( ((LA132_0>=107 && LA132_0<=108)) ) {
                alt132=3;
            }
            else if ( ((LA132_0>=RULE_HEX && LA132_0<=RULE_DECIMAL)) ) {
                alt132=4;
            }
            else if ( (LA132_0==109) ) {
                alt132=5;
            }
            else if ( ((LA132_0>=RULE_STRING && LA132_0<=RULE_RICH_TEXT_START)) ) {
                alt132=6;
            }
            else if ( (LA132_0==110) ) {
                alt132=7;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 132, 0, input);
                throw nvae;
            }
            switch (alt132) {
                case 1 :
                    {
                    current = callUnassignedRuleXCollectionLiteral(FOLLOW_ruleXCollectionLiteral_in_ruleXLiteral13149, elementAccess.getXCollectionLiteralParserRuleCall_0());
                    if (state.failed) return current;

                    }
                    break;
                case 2 :
                    {

                    {
                    current = callUnassignedRuleXClosure(FOLLOW_ruleXClosure_in_ruleXLiteral13189, elementAccess.getXClosureParserRuleCall_1());
                    if (state.failed) return current;

                    }
                    }
                    break;
                case 3 :
                    {
                    current = callUnassignedRuleXBooleanLiteral(FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral13217, elementAccess.getXBooleanLiteralParserRuleCall_2());
                    if (state.failed) return current;

                    }
                    break;
                case 4 :
                    {
                    current = callUnassignedRuleXNumberLiteral(FOLLOW_ruleXNumberLiteral_in_ruleXLiteral13244, elementAccess.getXNumberLiteralParserRuleCall_3());
                    if (state.failed) return current;

                    }
                    break;
                case 5 :
                    {
                    current = callUnassignedRuleXNullLiteral(FOLLOW_ruleXNullLiteral_in_ruleXLiteral13271, elementAccess.getXNullLiteralParserRuleCall_4());
                    if (state.failed) return current;

                    }
                    break;
                case 6 :
                    {
                    current = callUnassignedRuleXStringLiteral(FOLLOW_ruleXStringLiteral_in_ruleXLiteral13298, elementAccess.getXStringLiteralParserRuleCall_5());
                    if (state.failed) return current;

                    }
                    break;
                case 7 :
                    {
                    current = callUnassignedRuleXTypeLiteral(FOLLOW_ruleXTypeLiteral_in_ruleXLiteral13325, elementAccess.getXTypeLiteralParserRuleCall_6());
                    if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleXCollectionLiteral() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXCollectionLiteral = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XCollectionLiteralElements elementAccess = grammarAccess.getXCollectionLiteralAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXCollectionLiteral_in_entryRuleXCollectionLiteral13366);
            iv_ruleXCollectionLiteral=ruleXCollectionLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCollectionLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCollectionLiteral13376); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXCollectionLiteral() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XCollectionLiteralElements elementAccess = grammarAccess.getXCollectionLiteralAccess();
        try {

            {
            int alt133=2;
            int LA133_0 = input.LA(1);
            if ( (LA133_0==93) ) {
                int LA133_1 = input.LA(2);
                if ( (LA133_1==94) ) {
                    alt133=2;
                }
                else if ( (LA133_1==28) ) {
                    alt133=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 133, 1, input);
                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 133, 0, input);
                throw nvae;
            }
            switch (alt133) {
                case 1 :
                    {
                    current = callUnassignedRuleXSetLiteral(FOLLOW_ruleXSetLiteral_in_ruleXCollectionLiteral13423, elementAccess.getXSetLiteralParserRuleCall_0());
                    if (state.failed) return current;

                    }
                    break;
                case 2 :
                    {
                    current = callUnassignedRuleXListLiteral(FOLLOW_ruleXListLiteral_in_ruleXCollectionLiteral13450, elementAccess.getXListLiteralParserRuleCall_1());
                    if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleXSetLiteral() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXSetLiteral = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XSetLiteralElements elementAccess = grammarAccess.getXSetLiteralAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXSetLiteral_in_entryRuleXSetLiteral13491);
            iv_ruleXSetLiteral=ruleXSetLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSetLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSetLiteral13501); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXSetLiteral() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XSetLiteralElements elementAccess = grammarAccess.getXSetLiteralAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXSetLiteralAction_0(),
                          current);
            }
            }
            if (!consumeUnassignedToken(93, FOLLOW_93_in_ruleXSetLiteral13547,  elementAccess.getNumberSignKeyword_1())) { return current; }

            if (!consumeUnassignedToken(28, FOLLOW_28_in_ruleXSetLiteral13559,  elementAccess.getLeftCurlyBracketKeyword_2())) { return current; }

            int alt135=2;
            int LA135_0 = input.LA(1);
            if ( ((LA135_0>=RULE_ID && LA135_0<=RULE_RICH_TEXT_START)||(LA135_0>=RULE_HEX && LA135_0<=RULE_DECIMAL)||LA135_0==20||(LA135_0>=22 && LA135_0<=23)||(LA135_0>=26 && LA135_0<=28)||(LA135_0>=30 && LA135_0<=32)||(LA135_0>=34 && LA135_0<=35)||(LA135_0>=37 && LA135_0<=45)||(LA135_0>=48 && LA135_0<=50)||LA135_0==52||LA135_0==64||LA135_0==83||LA135_0==88||(LA135_0>=93 && LA135_0<=94)||LA135_0==97||LA135_0==99||(LA135_0>=102 && LA135_0<=105)||(LA135_0>=107 && LA135_0<=113)) ) {
                alt135=1;
            }
            switch (alt135) {
                case 1 :
                    {

                    {

                    {
                    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXSetLiteral13581, current, elementAccess.getElementsXExpressionParserRuleCall_3_0_0(), elementAccess.getRule(), XSET_LITERAL__ELEMENTS, null);
                    if (state.failed) return current;

                    }
                    }
                    loop134:
                    do {
                        int alt134=2;
                        int LA134_0 = input.LA(1);
                        if ( (LA134_0==24) ) {
                            alt134=1;
                        }
                        switch (alt134) {
                    	case 1 :
                    	    {
                    	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleXSetLiteral13594,  elementAccess.getCommaKeyword_3_1_0())) { return current; }


                    	    {

                    	    {
                    	    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXSetLiteral13615, current, elementAccess.getElementsXExpressionParserRuleCall_3_1_1_0(), elementAccess.getRule(), XSET_LITERAL__ELEMENTS, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop134;
                        }
                    } while (true);
                    }
                    break;
            }
            if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXSetLiteral13631,  elementAccess.getRightCurlyBracketKeyword_4())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleXListLiteral() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXListLiteral = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XListLiteralElements elementAccess = grammarAccess.getXListLiteralAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXListLiteral_in_entryRuleXListLiteral13673);
            iv_ruleXListLiteral=ruleXListLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXListLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXListLiteral13683); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXListLiteral() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XListLiteralElements elementAccess = grammarAccess.getXListLiteralAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXListLiteralAction_0(),
                          current);
            }
            }
            if (!consumeUnassignedToken(93, FOLLOW_93_in_ruleXListLiteral13729,  elementAccess.getNumberSignKeyword_1())) { return current; }

            if (!consumeUnassignedToken(94, FOLLOW_94_in_ruleXListLiteral13741,  elementAccess.getLeftSquareBracketKeyword_2())) { return current; }

            int alt137=2;
            int LA137_0 = input.LA(1);
            if ( ((LA137_0>=RULE_ID && LA137_0<=RULE_RICH_TEXT_START)||(LA137_0>=RULE_HEX && LA137_0<=RULE_DECIMAL)||LA137_0==20||(LA137_0>=22 && LA137_0<=23)||(LA137_0>=26 && LA137_0<=28)||(LA137_0>=30 && LA137_0<=32)||(LA137_0>=34 && LA137_0<=35)||(LA137_0>=37 && LA137_0<=45)||(LA137_0>=48 && LA137_0<=50)||LA137_0==52||LA137_0==64||LA137_0==83||LA137_0==88||(LA137_0>=93 && LA137_0<=94)||LA137_0==97||LA137_0==99||(LA137_0>=102 && LA137_0<=105)||(LA137_0>=107 && LA137_0<=113)) ) {
                alt137=1;
            }
            switch (alt137) {
                case 1 :
                    {

                    {

                    {
                    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXListLiteral13763, current, elementAccess.getElementsXExpressionParserRuleCall_3_0_0(), elementAccess.getRule(), XLIST_LITERAL__ELEMENTS, null);
                    if (state.failed) return current;

                    }
                    }
                    loop136:
                    do {
                        int alt136=2;
                        int LA136_0 = input.LA(1);
                        if ( (LA136_0==24) ) {
                            alt136=1;
                        }
                        switch (alt136) {
                    	case 1 :
                    	    {
                    	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleXListLiteral13776,  elementAccess.getCommaKeyword_3_1_0())) { return current; }


                    	    {

                    	    {
                    	    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXListLiteral13797, current, elementAccess.getElementsXExpressionParserRuleCall_3_1_1_0(), elementAccess.getRule(), XLIST_LITERAL__ELEMENTS, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop136;
                        }
                    } while (true);
                    }
                    break;
            }
            if (!consumeUnassignedToken(95, FOLLOW_95_in_ruleXListLiteral13813,  elementAccess.getRightSquareBracketKeyword_4())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXClosure = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XClosureElements elementAccess = grammarAccess.getXClosureAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXClosure_in_entryRuleXClosure13855);
            iv_ruleXClosure=ruleXClosure();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXClosure13865); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXClosure() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XClosureElements elementAccess = grammarAccess.getXClosureAccess();
        try {

            {

            {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXClosureAction_0_0_0(),
                          current);
            }
            }
            if (!consumeUnassignedToken(94, FOLLOW_94_in_ruleXClosure13925,  elementAccess.getLeftSquareBracketKeyword_0_0_1())) { return current; }

            }
            }
            int alt140=2;
            alt140 = dfa140.predict(input);
            switch (alt140) {
                case 1 :
                    {

                    {
                    int alt139=2;
                    int LA139_0 = input.LA(1);
                    if ( (LA139_0==RULE_ID||LA139_0==32||(LA139_0>=34 && LA139_0<=35)||LA139_0==50||LA139_0==79) ) {
                        alt139=1;
                    }
                    switch (alt139) {
                        case 1 :
                            {

                            {

                            {
                            current = callRuleJvmFormalParameterAndAdd(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure13998, current, elementAccess.getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0(), elementAccess.getRule(), XCLOSURE__DECLARED_FORMAL_PARAMETERS, null);
                            if (state.failed) return current;

                            }
                            }
                            loop138:
                            do {
                                int alt138=2;
                                int LA138_0 = input.LA(1);
                                if ( (LA138_0==24) ) {
                                    alt138=1;
                                }
                                switch (alt138) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleXClosure14011,  elementAccess.getCommaKeyword_1_0_0_1_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleJvmFormalParameterAndAdd(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure14032, current, elementAccess.getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0(), elementAccess.getRule(), XCLOSURE__DECLARED_FORMAL_PARAMETERS, null);
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop138;
                                }
                            } while (true);
                            }
                            break;
                    }

                    {

                    {
                    current = consumeTokenAndSetBooleanValue(96, FOLLOW_96_in_ruleXClosure14054, current,  elementAccess.getExplicitSyntaxVerticalLineKeyword_1_0_1_0(), elementAccess.getRule(), XCLOSURE__EXPLICIT_SYNTAX);
                    if (state.failed) return current;

                    }
                    }
                    }
                    }
                    break;
            }

            {

            {
            current = callRuleXExpressionInClosureAndSet(FOLLOW_ruleXExpressionInClosure_in_ruleXClosure14091, current, elementAccess.getExpressionXExpressionInClosureParserRuleCall_2_0(), elementAccess.getRule(), XCLOSURE__EXPRESSION, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(95, FOLLOW_95_in_ruleXClosure14103,  elementAccess.getRightSquareBracketKeyword_3())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleXExpressionInClosure() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXExpressionInClosure = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XExpressionInClosureElements elementAccess = grammarAccess.getXExpressionInClosureAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInClosure_in_entryRuleXExpressionInClosure14145);
            iv_ruleXExpressionInClosure=ruleXExpressionInClosure();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInClosure14155); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXExpressionInClosure() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XExpressionInClosureElements elementAccess = grammarAccess.getXExpressionInClosureAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXBlockExpressionAction_0(),
                          current);
            }
            }
            loop142:
            do {
                int alt142=2;
                int LA142_0 = input.LA(1);
                if ( ((LA142_0>=RULE_ID && LA142_0<=RULE_RICH_TEXT_START)||(LA142_0>=RULE_HEX && LA142_0<=RULE_DECIMAL)||LA142_0==20||(LA142_0>=22 && LA142_0<=23)||(LA142_0>=26 && LA142_0<=28)||(LA142_0>=30 && LA142_0<=32)||(LA142_0>=34 && LA142_0<=35)||(LA142_0>=37 && LA142_0<=50)||LA142_0==52||LA142_0==64||LA142_0==83||LA142_0==88||(LA142_0>=93 && LA142_0<=94)||LA142_0==97||LA142_0==99||(LA142_0>=102 && LA142_0<=105)||(LA142_0>=107 && LA142_0<=113)) ) {
                    alt142=1;
                }
                switch (alt142) {
            	case 1 :
            	    {

            	    {

            	    {
            	    current = callRuleXExpressionInsideBlockAndAdd(FOLLOW_ruleXExpressionInsideBlock_in_ruleXExpressionInClosure14211, current, elementAccess.getExpressionsXExpressionInsideBlockParserRuleCall_1_0_0(), elementAccess.getRule(), XBLOCK_EXPRESSION__EXPRESSIONS, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    int alt141=2;
            	    int LA141_0 = input.LA(1);
            	    if ( (LA141_0==21) ) {
            	        alt141=1;
            	    }
            	    switch (alt141) {
            	        case 1 :
            	            {
            	            if (!consumeUnassignedToken(21, FOLLOW_21_in_ruleXExpressionInClosure14224,  elementAccess.getSemicolonKeyword_1_1())) { return current; }

            	            }
            	            break;
            	    }
            	    }
            	    break;
            	default :
            	    break loop142;
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
        }
        return current;
    }

    public final EObject entryRuleXShortClosure() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXShortClosure = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XShortClosureElements elementAccess = grammarAccess.getXShortClosureAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure14270);
            iv_ruleXShortClosure=ruleXShortClosure();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXShortClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXShortClosure14280); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXShortClosure() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XShortClosureElements elementAccess = grammarAccess.getXShortClosureAccess();
        try {

            {

            {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXClosureAction_0_0_0(),
                          current);
            }
            }
            int alt144=2;
            int LA144_0 = input.LA(1);
            if ( (LA144_0==RULE_ID||LA144_0==32||(LA144_0>=34 && LA144_0<=35)||LA144_0==50||LA144_0==79) ) {
                alt144=1;
            }
            switch (alt144) {
                case 1 :
                    {

                    {

                    {
                    current = callRuleJvmFormalParameterAndAdd(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure14388, current, elementAccess.getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0(), elementAccess.getRule(), XCLOSURE__DECLARED_FORMAL_PARAMETERS, null);
                    if (state.failed) return current;

                    }
                    }
                    loop143:
                    do {
                        int alt143=2;
                        int LA143_0 = input.LA(1);
                        if ( (LA143_0==24) ) {
                            alt143=1;
                        }
                        switch (alt143) {
                    	case 1 :
                    	    {
                    	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleXShortClosure14401,  elementAccess.getCommaKeyword_0_0_1_1_0())) { return current; }


                    	    {

                    	    {
                    	    current = callRuleJvmFormalParameterAndAdd(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure14422, current, elementAccess.getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0(), elementAccess.getRule(), XCLOSURE__DECLARED_FORMAL_PARAMETERS, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop143;
                        }
                    } while (true);
                    }
                    break;
            }

            {

            {
            current = consumeTokenAndSetBooleanValue(96, FOLLOW_96_in_ruleXShortClosure14444, current,  elementAccess.getExplicitSyntaxVerticalLineKeyword_0_0_2_0(), elementAccess.getRule(), XCLOSURE__EXPLICIT_SYNTAX);
            if (state.failed) return current;

            }
            }
            }
            }

            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXShortClosure14480, current, elementAccess.getExpressionXExpressionParserRuleCall_1_0(), elementAccess.getRule(), XCLOSURE__EXPRESSION, null);
            if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXParenthesizedExpression = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XParenthesizedExpressionElements elementAccess = grammarAccess.getXParenthesizedExpressionAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression14522);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXParenthesizedExpression14532); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XParenthesizedExpressionElements elementAccess = grammarAccess.getXParenthesizedExpressionAccess();
        try {

            {

            {
            if (!consumeUnassignedToken(35, FOLLOW_35_in_ruleXParenthesizedExpression14569,  elementAccess.getLeftParenthesisKeyword_0())) { return current; }

            current = callUnassignedRuleXExpression(FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression14591, elementAccess.getXExpressionParserRuleCall_1());
            if (state.failed) return current;

            if (!consumeUnassignedToken(36, FOLLOW_36_in_ruleXParenthesizedExpression14602,  elementAccess.getRightParenthesisKeyword_2())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleXIfExpression() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXIfExpression = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XIfExpressionElements elementAccess = grammarAccess.getXIfExpressionAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression14644);
            iv_ruleXIfExpression=ruleXIfExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIfExpression14654); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXIfExpression() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XIfExpressionElements elementAccess = grammarAccess.getXIfExpressionAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXIfExpressionAction_0(),
                          current);
            }
            }
            if (!consumeUnassignedToken(97, FOLLOW_97_in_ruleXIfExpression14700,  elementAccess.getIfKeyword_1())) { return current; }

            if (!consumeUnassignedToken(35, FOLLOW_35_in_ruleXIfExpression14712,  elementAccess.getLeftParenthesisKeyword_2())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXIfExpression14733, current, elementAccess.getIfXExpressionParserRuleCall_3_0(), elementAccess.getRule(), XIF_EXPRESSION__IF, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(36, FOLLOW_36_in_ruleXIfExpression14745,  elementAccess.getRightParenthesisKeyword_4())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXIfExpression14766, current, elementAccess.getThenXExpressionParserRuleCall_5_0(), elementAccess.getRule(), XIF_EXPRESSION__THEN, null);
            if (state.failed) return current;

            }
            }
            int alt145=2;
            int LA145_0 = input.LA(1);
            if ( (LA145_0==98) ) {
                int LA145_1 = input.LA(2);
                if ( (synpred28_InternalXtend()) ) {
                    alt145=1;
                }
            }
            switch (alt145) {
                case 1 :
                    {

                    {
                    if (!consumeUnassignedToken(98, FOLLOW_98_in_ruleXIfExpression14787,  elementAccess.getElseKeyword_6_0())) { return current; }

                    }

                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXIfExpression14809, current, elementAccess.getElseXExpressionParserRuleCall_6_1_0(), elementAccess.getRule(), XIF_EXPRESSION__ELSE, null);
                    if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleXSwitchExpression() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXSwitchExpression = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XSwitchExpressionElements elementAccess = grammarAccess.getXSwitchExpressionAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression14853);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSwitchExpression14863); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXSwitchExpression() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XSwitchExpressionElements elementAccess = grammarAccess.getXSwitchExpressionAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXSwitchExpressionAction_0(),
                          current);
            }
            }
            if (!consumeUnassignedToken(99, FOLLOW_99_in_ruleXSwitchExpression14909,  elementAccess.getSwitchKeyword_1())) { return current; }

            int alt147=2;
            int LA147_0 = input.LA(1);
            if ( ((LA147_0>=RULE_ID && LA147_0<=RULE_RICH_TEXT_START)||(LA147_0>=RULE_HEX && LA147_0<=RULE_DECIMAL)||LA147_0==20||(LA147_0>=22 && LA147_0<=23)||(LA147_0>=26 && LA147_0<=28)||(LA147_0>=30 && LA147_0<=32)||LA147_0==34||(LA147_0>=37 && LA147_0<=45)||(LA147_0>=48 && LA147_0<=50)||LA147_0==52||LA147_0==64||LA147_0==83||LA147_0==88||(LA147_0>=93 && LA147_0<=94)||LA147_0==97||LA147_0==99||(LA147_0>=102 && LA147_0<=105)||(LA147_0>=107 && LA147_0<=113)) ) {
                alt147=1;
            }
            else if ( (LA147_0==35) ) {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    int LA147_3 = input.LA(3);
                    if ( (LA147_3==23||LA147_3==25||LA147_3==33||(LA147_3>=35 && LA147_3<=36)||(LA147_3>=64 && LA147_3<=87)||(LA147_3>=89 && LA147_3<=92)||LA147_3==94||LA147_3==106) ) {
                        alt147=1;
                    }
                    else if ( (LA147_3==51) && (synpred30_InternalXtend())) {
                        alt147=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 147, 3, input);
                        throw nvae;
                    }
                    }
                    break;
                case 50:
                    {
                    int LA147_4 = input.LA(3);
                    if ( (LA147_4==23||LA147_4==25||LA147_4==33||(LA147_4>=35 && LA147_4<=36)||(LA147_4>=64 && LA147_4<=87)||(LA147_4>=89 && LA147_4<=92)||LA147_4==94||LA147_4==106) ) {
                        alt147=1;
                    }
                    else if ( (LA147_4==51) && (synpred30_InternalXtend())) {
                        alt147=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 147, 4, input);
                        throw nvae;
                    }
                    }
                    break;
                case 32:
                    {
                    int LA147_5 = input.LA(3);
                    if ( (LA147_5==23||LA147_5==25||LA147_5==33||(LA147_5>=35 && LA147_5<=36)||(LA147_5>=64 && LA147_5<=87)||(LA147_5>=89 && LA147_5<=92)||LA147_5==94||LA147_5==106) ) {
                        alt147=1;
                    }
                    else if ( (LA147_5==51) && (synpred30_InternalXtend())) {
                        alt147=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 147, 5, input);
                        throw nvae;
                    }
                    }
                    break;
                case RULE_STRING:
                case RULE_RICH_TEXT:
                case RULE_RICH_TEXT_START:
                case RULE_HEX:
                case RULE_INT:
                case RULE_DECIMAL:
                case 20:
                case 22:
                case 23:
                case 26:
                case 27:
                case 28:
                case 30:
                case 31:
                case 34:
                case 35:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 48:
                case 49:
                case 52:
                case 64:
                case 83:
                case 88:
                case 93:
                case 94:
                case 97:
                case 99:
                case 102:
                case 103:
                case 104:
                case 105:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                    {
                    alt147=1;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 147, 2, input);
                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 147, 0, input);
                throw nvae;
            }
            switch (alt147) {
                case 1 :
                    {

                    {
                    int alt146=2;
                    switch ( input.LA(1) ) {
                        case RULE_ID:
                            {
                            int LA146_1 = input.LA(2);
                            if ( (LA146_1==51) && (synpred29_InternalXtend())) {
                                alt146=1;
                            }
                            }
                            break;
                        case 50:
                            {
                            int LA146_2 = input.LA(2);
                            if ( (LA146_2==51) && (synpred29_InternalXtend())) {
                                alt146=1;
                            }
                            }
                            break;
                        case 32:
                            {
                            int LA146_3 = input.LA(2);
                            if ( (LA146_3==51) && (synpred29_InternalXtend())) {
                                alt146=1;
                            }
                            }
                            break;
                    }
                    switch (alt146) {
                        case 1 :
                            {

                            {

                            {

                            {
                            current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleXSwitchExpression14952, current, elementAccess.getLocalVarNameValidIDParserRuleCall_2_0_0_0_0_0(), elementAccess.getRule(), XSWITCH_EXPRESSION__LOCAL_VAR_NAME, "ValidID");
                            if (state.failed) return current;

                            }
                            }
                            if (!consumeUnassignedToken(51, FOLLOW_51_in_ruleXSwitchExpression14964,  elementAccess.getColonKeyword_2_0_0_0_1())) { return current; }

                            }
                            }
                            break;
                    }

                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXSwitchExpression14988, current, elementAccess.getSwitchXExpressionParserRuleCall_2_0_1_0(), elementAccess.getRule(), XSWITCH_EXPRESSION__SWITCH, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    }
                    break;
                case 2 :
                    {

                    {

                    {

                    {
                    if (!consumeUnassignedToken(35, FOLLOW_35_in_ruleXSwitchExpression15032,  elementAccess.getLeftParenthesisKeyword_2_1_0_0_0())) { return current; }


                    {

                    {
                    current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleXSwitchExpression15053, current, elementAccess.getLocalVarNameValidIDParserRuleCall_2_1_0_0_1_0(), elementAccess.getRule(), XSWITCH_EXPRESSION__LOCAL_VAR_NAME, "ValidID");
                    if (state.failed) return current;

                    }
                    }
                    if (!consumeUnassignedToken(51, FOLLOW_51_in_ruleXSwitchExpression15065,  elementAccess.getColonKeyword_2_1_0_0_2())) { return current; }

                    }
                    }

                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXSwitchExpression15088, current, elementAccess.getSwitchXExpressionParserRuleCall_2_1_1_0(), elementAccess.getRule(), XSWITCH_EXPRESSION__SWITCH, null);
                    if (state.failed) return current;

                    }
                    }
                    if (!consumeUnassignedToken(36, FOLLOW_36_in_ruleXSwitchExpression15100,  elementAccess.getRightParenthesisKeyword_2_1_2())) { return current; }

                    }
                    }
                    break;
            }
            if (!consumeUnassignedToken(28, FOLLOW_28_in_ruleXSwitchExpression15114,  elementAccess.getLeftCurlyBracketKeyword_3())) { return current; }

            int cnt148=0;
            loop148:
            do {
                int alt148=2;
                int LA148_0 = input.LA(1);
                if ( (LA148_0==RULE_ID||LA148_0==32||LA148_0==35||(LA148_0>=50 && LA148_0<=51)||LA148_0==79||LA148_0==101) ) {
                    alt148=1;
                }
                switch (alt148) {
            	case 1 :
            	    {

            	    {
            	    current = callRuleXCasePartAndAdd(FOLLOW_ruleXCasePart_in_ruleXSwitchExpression15135, current, elementAccess.getCasesXCasePartParserRuleCall_4_0(), elementAccess.getRule(), XSWITCH_EXPRESSION__CASES, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    break;
            	default :
            	    if ( cnt148 >= 1 ) break loop148;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(148, input);
                        throw eee;
                }
                cnt148++;
            } while (true);
            int alt149=2;
            int LA149_0 = input.LA(1);
            if ( (LA149_0==100) ) {
                alt149=1;
            }
            switch (alt149) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(100, FOLLOW_100_in_ruleXSwitchExpression15149,  elementAccess.getDefaultKeyword_5_0())) { return current; }

                    if (!consumeUnassignedToken(51, FOLLOW_51_in_ruleXSwitchExpression15161,  elementAccess.getColonKeyword_5_1())) { return current; }


                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXSwitchExpression15182, current, elementAccess.getDefaultXExpressionParserRuleCall_5_2_0(), elementAccess.getRule(), XSWITCH_EXPRESSION__DEFAULT, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    break;
            }
            if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXSwitchExpression15196,  elementAccess.getRightCurlyBracketKeyword_6())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXCasePart = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XCasePartElements elementAccess = grammarAccess.getXCasePartAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXCasePart_in_entryRuleXCasePart15238);
            iv_ruleXCasePart=ruleXCasePart();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCasePart15248); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXCasePart() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XCasePartElements elementAccess = grammarAccess.getXCasePartAccess();
        try {

            {

            {
            int alt150=2;
            int LA150_0 = input.LA(1);
            if ( (LA150_0==RULE_ID||LA150_0==32||LA150_0==35||LA150_0==50||LA150_0==79) ) {
                alt150=1;
            }
            switch (alt150) {
                case 1 :
                    {

                    {
                    current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleXCasePart15294, current, elementAccess.getTypeGuardJvmTypeReferenceParserRuleCall_0_0(), elementAccess.getRule(), XCASE_PART__TYPE_GUARD, null);
                    if (state.failed) return current;

                    }
                    }
                    break;
            }
            int alt151=2;
            int LA151_0 = input.LA(1);
            if ( (LA151_0==101) ) {
                alt151=1;
            }
            switch (alt151) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(101, FOLLOW_101_in_ruleXCasePart15308,  elementAccess.getCaseKeyword_1_0())) { return current; }


                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXCasePart15329, current, elementAccess.getCaseXExpressionParserRuleCall_1_1_0(), elementAccess.getRule(), XCASE_PART__CASE, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    break;
            }
            if (!consumeUnassignedToken(51, FOLLOW_51_in_ruleXCasePart15343,  elementAccess.getColonKeyword_2())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXCasePart15364, current, elementAccess.getThenXExpressionParserRuleCall_3_0(), elementAccess.getRule(), XCASE_PART__THEN, null);
            if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleXForLoopExpression() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXForLoopExpression = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XForLoopExpressionElements elementAccess = grammarAccess.getXForLoopExpressionAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression15406);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXForLoopExpression15416); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXForLoopExpression() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XForLoopExpressionElements elementAccess = grammarAccess.getXForLoopExpressionAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXForLoopExpressionAction_0(),
                          current);
            }
            }
            if (!consumeUnassignedToken(102, FOLLOW_102_in_ruleXForLoopExpression15462,  elementAccess.getForKeyword_1())) { return current; }

            if (!consumeUnassignedToken(35, FOLLOW_35_in_ruleXForLoopExpression15474,  elementAccess.getLeftParenthesisKeyword_2())) { return current; }


            {

            {
            current = callRuleJvmFormalParameterAndSet(FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression15495, current, elementAccess.getDeclaredParamJvmFormalParameterParserRuleCall_3_0(), elementAccess.getRule(), XFOR_LOOP_EXPRESSION__DECLARED_PARAM, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(51, FOLLOW_51_in_ruleXForLoopExpression15507,  elementAccess.getColonKeyword_4())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXForLoopExpression15528, current, elementAccess.getForExpressionXExpressionParserRuleCall_5_0(), elementAccess.getRule(), XFOR_LOOP_EXPRESSION__FOR_EXPRESSION, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(36, FOLLOW_36_in_ruleXForLoopExpression15540,  elementAccess.getRightParenthesisKeyword_6())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXForLoopExpression15561, current, elementAccess.getEachExpressionXExpressionParserRuleCall_7_0(), elementAccess.getRule(), XFOR_LOOP_EXPRESSION__EACH_EXPRESSION, null);
            if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleXWhileExpression() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXWhileExpression = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XWhileExpressionElements elementAccess = grammarAccess.getXWhileExpressionAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression15603);
            iv_ruleXWhileExpression=ruleXWhileExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWhileExpression15613); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXWhileExpression() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XWhileExpressionElements elementAccess = grammarAccess.getXWhileExpressionAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXWhileExpressionAction_0(),
                          current);
            }
            }
            if (!consumeUnassignedToken(103, FOLLOW_103_in_ruleXWhileExpression15659,  elementAccess.getWhileKeyword_1())) { return current; }

            if (!consumeUnassignedToken(35, FOLLOW_35_in_ruleXWhileExpression15671,  elementAccess.getLeftParenthesisKeyword_2())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXWhileExpression15692, current, elementAccess.getPredicateXExpressionParserRuleCall_3_0(), elementAccess.getRule(), XWHILE_EXPRESSION__PREDICATE, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(36, FOLLOW_36_in_ruleXWhileExpression15704,  elementAccess.getRightParenthesisKeyword_4())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXWhileExpression15725, current, elementAccess.getBodyXExpressionParserRuleCall_5_0(), elementAccess.getRule(), XWHILE_EXPRESSION__BODY, null);
            if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXDoWhileExpression = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XDoWhileExpressionElements elementAccess = grammarAccess.getXDoWhileExpressionAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression15767);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXDoWhileExpression15777); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXDoWhileExpression() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XDoWhileExpressionElements elementAccess = grammarAccess.getXDoWhileExpressionAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXDoWhileExpressionAction_0(),
                          current);
            }
            }
            if (!consumeUnassignedToken(104, FOLLOW_104_in_ruleXDoWhileExpression15823,  elementAccess.getDoKeyword_1())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression15844, current, elementAccess.getBodyXExpressionParserRuleCall_2_0(), elementAccess.getRule(), XDO_WHILE_EXPRESSION__BODY, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(103, FOLLOW_103_in_ruleXDoWhileExpression15856,  elementAccess.getWhileKeyword_3())) { return current; }

            if (!consumeUnassignedToken(35, FOLLOW_35_in_ruleXDoWhileExpression15868,  elementAccess.getLeftParenthesisKeyword_4())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression15889, current, elementAccess.getPredicateXExpressionParserRuleCall_5_0(), elementAccess.getRule(), XDO_WHILE_EXPRESSION__PREDICATE, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(36, FOLLOW_36_in_ruleXDoWhileExpression15901,  elementAccess.getRightParenthesisKeyword_6())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleXBlockExpression() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXBlockExpression = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XBlockExpressionElements elementAccess = grammarAccess.getXBlockExpressionAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression15943);
            iv_ruleXBlockExpression=ruleXBlockExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBlockExpression15953); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXBlockExpression() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XBlockExpressionElements elementAccess = grammarAccess.getXBlockExpressionAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXBlockExpressionAction_0(),
                          current);
            }
            }
            if (!consumeUnassignedToken(28, FOLLOW_28_in_ruleXBlockExpression15999,  elementAccess.getLeftCurlyBracketKeyword_1())) { return current; }

            loop153:
            do {
                int alt153=2;
                int LA153_0 = input.LA(1);
                if ( ((LA153_0>=RULE_ID && LA153_0<=RULE_RICH_TEXT_START)||(LA153_0>=RULE_HEX && LA153_0<=RULE_DECIMAL)||LA153_0==20||(LA153_0>=22 && LA153_0<=23)||(LA153_0>=26 && LA153_0<=28)||(LA153_0>=30 && LA153_0<=32)||(LA153_0>=34 && LA153_0<=35)||(LA153_0>=37 && LA153_0<=50)||LA153_0==52||LA153_0==64||LA153_0==83||LA153_0==88||(LA153_0>=93 && LA153_0<=94)||LA153_0==97||LA153_0==99||(LA153_0>=102 && LA153_0<=105)||(LA153_0>=107 && LA153_0<=113)) ) {
                    alt153=1;
                }
                switch (alt153) {
            	case 1 :
            	    {

            	    {

            	    {
            	    current = callRuleXExpressionInsideBlockAndAdd(FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression16021, current, elementAccess.getExpressionsXExpressionInsideBlockParserRuleCall_2_0_0(), elementAccess.getRule(), XBLOCK_EXPRESSION__EXPRESSIONS, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    int alt152=2;
            	    int LA152_0 = input.LA(1);
            	    if ( (LA152_0==21) ) {
            	        alt152=1;
            	    }
            	    switch (alt152) {
            	        case 1 :
            	            {
            	            if (!consumeUnassignedToken(21, FOLLOW_21_in_ruleXBlockExpression16034,  elementAccess.getSemicolonKeyword_2_1())) { return current; }

            	            }
            	            break;
            	    }
            	    }
            	    break;
            	default :
            	    break loop153;
                }
            } while (true);
            if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXBlockExpression16050,  elementAccess.getRightCurlyBracketKeyword_3())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXExpressionInsideBlock = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XExpressionInsideBlockElements elementAccess = grammarAccess.getXExpressionInsideBlockAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock16092);
            iv_ruleXExpressionInsideBlock=ruleXExpressionInsideBlock();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInsideBlock16102); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXExpressionInsideBlock() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XExpressionInsideBlockElements elementAccess = grammarAccess.getXExpressionInsideBlockAccess();
        try {

            {
            int alt154=2;
            int LA154_0 = input.LA(1);
            if ( (LA154_0==47) && (synpred31_InternalXtend())) {
                alt154=1;
            }
            else if ( (LA154_0==46) && (synpred31_InternalXtend())) {
                alt154=1;
            }
            else if ( (LA154_0==34) ) {
                switch ( input.LA(2) ) {
                case EOF:
                case RULE_ID:
                case RULE_STRING:
                case RULE_RICH_TEXT:
                case RULE_RICH_TEXT_START:
                case RULE_RICH_TEXT_INBETWEEN:
                case RULE_COMMENT_RICH_TEXT_INBETWEEN:
                case RULE_RICH_TEXT_END:
                case RULE_COMMENT_RICH_TEXT_END:
                case RULE_HEX:
                case RULE_INT:
                case RULE_DECIMAL:
                case 20:
                case 21:
                case 22:
                case 23:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 48:
                case 49:
                case 50:
                case 52:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                case 82:
                case 83:
                case 84:
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 97:
                case 99:
                case 102:
                case 103:
                case 104:
                case 105:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                    {
                    alt154=2;
                    }
                    break;
                case 47:
                    {
                    int LA154_5 = input.LA(3);
                    if ( (synpred31_InternalXtend()) ) {
                        alt154=1;
                    }
                    else if ( (true) ) {
                        alt154=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 154, 5, input);
                        throw nvae;
                    }
                    }
                    break;
                case 46:
                    {
                    int LA154_6 = input.LA(3);
                    if ( (synpred31_InternalXtend()) ) {
                        alt154=1;
                    }
                    else if ( (true) ) {
                        alt154=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 154, 6, input);
                        throw nvae;
                    }
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 154, 3, input);
                    throw nvae;
                }
            }
            else if ( ((LA154_0>=RULE_ID && LA154_0<=RULE_RICH_TEXT_START)||(LA154_0>=RULE_HEX && LA154_0<=RULE_DECIMAL)||LA154_0==20||(LA154_0>=22 && LA154_0<=23)||(LA154_0>=26 && LA154_0<=28)||(LA154_0>=30 && LA154_0<=32)||LA154_0==35||(LA154_0>=37 && LA154_0<=45)||(LA154_0>=48 && LA154_0<=50)||LA154_0==52||LA154_0==64||LA154_0==83||LA154_0==88||(LA154_0>=93 && LA154_0<=94)||LA154_0==97||LA154_0==99||(LA154_0>=102 && LA154_0<=105)||(LA154_0>=107 && LA154_0<=113)) ) {
                alt154=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 154, 0, input);
                throw nvae;
            }
            switch (alt154) {
                case 1 :
                    {

                    {
                    current = callUnassignedRuleXVariableDeclaration(FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock16251, elementAccess.getXVariableDeclarationParserRuleCall_0());
                    if (state.failed) return current;

                    }
                    }
                    break;
                case 2 :
                    {
                    current = callUnassignedRuleXExpression(FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock16279, elementAccess.getXExpressionParserRuleCall_1());
                    if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXFeatureCall = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XFeatureCallElements elementAccess = grammarAccess.getXFeatureCallAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall16320);
            iv_ruleXFeatureCall=ruleXFeatureCall();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFeatureCall16330); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXFeatureCall() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XFeatureCallElements elementAccess = grammarAccess.getXFeatureCallAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXFeatureCallAction_0(),
                          current);
            }
            }
            int alt155=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA155_1 = input.LA(2);
                    if ( (LA155_1==106) ) {
                        alt155=1;
                    }
                    }
                    break;
                case 50:
                    {
                    int LA155_2 = input.LA(2);
                    if ( (LA155_2==106) ) {
                        alt155=1;
                    }
                    }
                    break;
                case 32:
                    {
                    int LA155_3 = input.LA(2);
                    if ( (LA155_3==106) ) {
                        alt155=1;
                    }
                    }
                    break;
            }
            switch (alt155) {
                case 1 :
                    {

                    {
                    current = callRuleStaticQualifier(FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall16387, current, elementAccess.getDeclaringTypeJvmDeclaredTypeCrossReference_1_0(), elementAccess.getRule());
                    if (state.failed) return current;

                    }
                    }
                    break;
            }
            int alt157=2;
            int LA157_0 = input.LA(1);
            if ( (LA157_0==23) ) {
                alt157=1;
            }
            switch (alt157) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(23, FOLLOW_23_in_ruleXFeatureCall16401,  elementAccess.getLessThanSignKeyword_2_0())) { return current; }


                    {

                    {
                    current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall16422, current, elementAccess.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_1_0(), elementAccess.getRule(), XFEATURE_CALL__TYPE_ARGUMENTS, null);
                    if (state.failed) return current;

                    }
                    }
                    loop156:
                    do {
                        int alt156=2;
                        int LA156_0 = input.LA(1);
                        if ( (LA156_0==24) ) {
                            alt156=1;
                        }
                        switch (alt156) {
                    	case 1 :
                    	    {
                    	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleXFeatureCall16435,  elementAccess.getCommaKeyword_2_2_0())) { return current; }


                    	    {

                    	    {
                    	    current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall16456, current, elementAccess.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_2_2_1_0(), elementAccess.getRule(), XFEATURE_CALL__TYPE_ARGUMENTS, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop156;
                        }
                    } while (true);
                    if (!consumeUnassignedToken(25, FOLLOW_25_in_ruleXFeatureCall16470,  elementAccess.getGreaterThanSignKeyword_2_3())) { return current; }

                    }
                    break;
            }

            {

            {
            current = callRuleIdOrSuper(FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall16495, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_3_0(), elementAccess.getRule());
            if (state.failed) return current;

            }
            }
            int alt160=2;
            alt160 = dfa160.predict(input);
            switch (alt160) {
                case 1 :
                    {

                    {

                    {
                    current = consumeTokenAndSetBooleanValue(35, FOLLOW_35_in_ruleXFeatureCall16529, current,  elementAccess.getExplicitOperationCallLeftParenthesisKeyword_4_0_0(), elementAccess.getRule(), XFEATURE_CALL__EXPLICIT_OPERATION_CALL);
                    if (state.failed) return current;

                    }
                    }
                    int alt159=3;
                    alt159 = dfa159.predict(input);
                    switch (alt159) {
                        case 1 :
                            {

                            {

                            {
                            current = callRuleXShortClosureAndAdd(FOLLOW_ruleXShortClosure_in_ruleXFeatureCall16614, current, elementAccess.getFeatureCallArgumentsXShortClosureParserRuleCall_4_1_0_0(), elementAccess.getRule(), XFEATURE_CALL__FEATURE_CALL_ARGUMENTS, null);
                            if (state.failed) return current;

                            }
                            }
                            }
                            break;
                        case 2 :
                            {

                            {

                            {

                            {
                            current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXFeatureCall16642, current, elementAccess.getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_0_0(), elementAccess.getRule(), XFEATURE_CALL__FEATURE_CALL_ARGUMENTS, null);
                            if (state.failed) return current;

                            }
                            }
                            loop158:
                            do {
                                int alt158=2;
                                int LA158_0 = input.LA(1);
                                if ( (LA158_0==24) ) {
                                    alt158=1;
                                }
                                switch (alt158) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleXFeatureCall16655,  elementAccess.getCommaKeyword_4_1_1_1_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXFeatureCall16676, current, elementAccess.getFeatureCallArgumentsXExpressionParserRuleCall_4_1_1_1_1_0(), elementAccess.getRule(), XFEATURE_CALL__FEATURE_CALL_ARGUMENTS, null);
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop158;
                                }
                            } while (true);
                            }
                            }
                            break;
                    }
                    if (!consumeUnassignedToken(36, FOLLOW_36_in_ruleXFeatureCall16693,  elementAccess.getRightParenthesisKeyword_4_2())) { return current; }

                    }
                    break;
            }
            int alt161=2;
            alt161 = dfa161.predict(input);
            switch (alt161) {
                case 1 :
                    {

                    {
                    current = callRuleXClosureAndAdd(FOLLOW_ruleXClosure_in_ruleXFeatureCall16728, current, elementAccess.getFeatureCallArgumentsXClosureParserRuleCall_5_0(), elementAccess.getRule(), XFEATURE_CALL__FEATURE_CALL_ARGUMENTS, null);
                    if (state.failed) return current;

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
        }
        return current;
    }

    public final String entryRuleIdOrSuper() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleIdOrSuper = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.IdOrSuperElements elementAccess = grammarAccess.getIdOrSuperAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper16772);
            iv_ruleIdOrSuper=ruleIdOrSuper();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrSuper.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdOrSuper16783); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final AntlrDatatypeRuleToken ruleIdOrSuper() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.IdOrSuperElements elementAccess = grammarAccess.getIdOrSuperAccess();
        try {

            {
            int alt162=2;
            int LA162_0 = input.LA(1);
            if ( (LA162_0==RULE_ID||LA162_0==20||LA162_0==22||(LA162_0>=26 && LA162_0<=27)||(LA162_0>=30 && LA162_0<=32)||LA162_0==34||LA162_0==37||(LA162_0>=39 && LA162_0<=45)||(LA162_0>=48 && LA162_0<=50)||LA162_0==52) ) {
                alt162=1;
            }
            else if ( (LA162_0==105) ) {
                alt162=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 162, 0, input);
                throw nvae;
            }
            switch (alt162) {
                case 1 :
                    {
                    callRuleFeatureCallID(FOLLOW_ruleFeatureCallID_in_ruleIdOrSuper16830, current, elementAccess.getFeatureCallIDParserRuleCall_0());
                    if (state.failed) return current;

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(105, FOLLOW_105_in_ruleIdOrSuper16854, current,  elementAccess.getSuperKeyword_1())) { return current; }

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
        }
        return current;
    }

    public final String entryRuleStaticQualifier() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleStaticQualifier = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.StaticQualifierElements elementAccess = grammarAccess.getStaticQualifierAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier16901);
            iv_ruleStaticQualifier=ruleStaticQualifier();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStaticQualifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStaticQualifier16912); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final AntlrDatatypeRuleToken ruleStaticQualifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.StaticQualifierElements elementAccess = grammarAccess.getStaticQualifierAccess();
        try {

            {
            int cnt163=0;
            loop163:
            do {
                int alt163=2;
                switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA163_1 = input.LA(2);
                    if ( (LA163_1==106) ) {
                        alt163=1;
                    }
                    }
                    break;
                case 32:
                    {
                    int LA163_3 = input.LA(2);
                    if ( (LA163_3==106) ) {
                        alt163=1;
                    }
                    }
                    break;
                case 50:
                    {
                    int LA163_4 = input.LA(2);
                    if ( (LA163_4==106) ) {
                        alt163=1;
                    }
                    }
                    break;
                }
                switch (alt163) {
            	case 1 :
            	    {
            	    callRuleValidID(FOLLOW_ruleValidID_in_ruleStaticQualifier16959, current, elementAccess.getValidIDParserRuleCall_0());
            	    if (state.failed) return current;

            	    if (!consumeTokenAndMerge(106, FOLLOW_106_in_ruleStaticQualifier16977, current,  elementAccess.getColonColonKeyword_1())) { return current; }

            	    }
            	    break;
            	default :
            	    if ( cnt163 >= 1 ) break loop163;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(163, input);
                        throw eee;
                }
                cnt163++;
            } while (true);
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
        }
        return current;
    }

    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXConstructorCall = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XConstructorCallElements elementAccess = grammarAccess.getXConstructorCallAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall17024);
            iv_ruleXConstructorCall=ruleXConstructorCall();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXConstructorCall17034); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXConstructorCall() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XConstructorCallElements elementAccess = grammarAccess.getXConstructorCallAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXConstructorCallAction_0(),
                          current);
            }
            }
            if (!consumeUnassignedToken(38, FOLLOW_38_in_ruleXConstructorCall17080,  elementAccess.getNewKeyword_1())) { return current; }


            {

            {
            current = callRuleQualifiedName(FOLLOW_ruleQualifiedName_in_ruleXConstructorCall17103, current, elementAccess.getConstructorJvmConstructorCrossReference_2_0(), elementAccess.getRule());
            if (state.failed) return current;

            }
            }
            int alt165=2;
            alt165 = dfa165.predict(input);
            switch (alt165) {
                case 1 :
                    {

                    {
                    if (!consumeUnassignedToken(23, FOLLOW_23_in_ruleXConstructorCall17124,  elementAccess.getLessThanSignKeyword_3_0())) { return current; }

                    }

                    {

                    {
                    current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall17146, current, elementAccess.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0(), elementAccess.getRule(), XCONSTRUCTOR_CALL__TYPE_ARGUMENTS, null);
                    if (state.failed) return current;

                    }
                    }
                    loop164:
                    do {
                        int alt164=2;
                        int LA164_0 = input.LA(1);
                        if ( (LA164_0==24) ) {
                            alt164=1;
                        }
                        switch (alt164) {
                    	case 1 :
                    	    {
                    	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleXConstructorCall17159,  elementAccess.getCommaKeyword_3_2_0())) { return current; }


                    	    {

                    	    {
                    	    current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall17180, current, elementAccess.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0(), elementAccess.getRule(), XCONSTRUCTOR_CALL__TYPE_ARGUMENTS, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop164;
                        }
                    } while (true);
                    if (!consumeUnassignedToken(25, FOLLOW_25_in_ruleXConstructorCall17194,  elementAccess.getGreaterThanSignKeyword_3_3())) { return current; }

                    }
                    break;
            }
            int alt168=2;
            alt168 = dfa168.predict(input);
            switch (alt168) {
                case 1 :
                    {

                    {
                    if (!consumeUnassignedToken(35, FOLLOW_35_in_ruleXConstructorCall17217,  elementAccess.getLeftParenthesisKeyword_4_0())) { return current; }

                    }
                    int alt167=3;
                    alt167 = dfa167.predict(input);
                    switch (alt167) {
                        case 1 :
                            {

                            {

                            {
                            current = callRuleXShortClosureAndAdd(FOLLOW_ruleXShortClosure_in_ruleXConstructorCall17290, current, elementAccess.getArgumentsXShortClosureParserRuleCall_4_1_0_0(), elementAccess.getRule(), XCONSTRUCTOR_CALL__ARGUMENTS, null);
                            if (state.failed) return current;

                            }
                            }
                            }
                            break;
                        case 2 :
                            {

                            {

                            {

                            {
                            current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXConstructorCall17318, current, elementAccess.getArgumentsXExpressionParserRuleCall_4_1_1_0_0(), elementAccess.getRule(), XCONSTRUCTOR_CALL__ARGUMENTS, null);
                            if (state.failed) return current;

                            }
                            }
                            loop166:
                            do {
                                int alt166=2;
                                int LA166_0 = input.LA(1);
                                if ( (LA166_0==24) ) {
                                    alt166=1;
                                }
                                switch (alt166) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleXConstructorCall17331,  elementAccess.getCommaKeyword_4_1_1_1_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXConstructorCall17352, current, elementAccess.getArgumentsXExpressionParserRuleCall_4_1_1_1_1_0(), elementAccess.getRule(), XCONSTRUCTOR_CALL__ARGUMENTS, null);
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop166;
                                }
                            } while (true);
                            }
                            }
                            break;
                    }
                    if (!consumeUnassignedToken(36, FOLLOW_36_in_ruleXConstructorCall17369,  elementAccess.getRightParenthesisKeyword_4_2())) { return current; }

                    }
                    break;
            }
            int alt169=2;
            alt169 = dfa169.predict(input);
            switch (alt169) {
                case 1 :
                    {

                    {
                    current = callRuleXClosureAndAdd(FOLLOW_ruleXClosure_in_ruleXConstructorCall17404, current, elementAccess.getArgumentsXClosureParserRuleCall_5_0(), elementAccess.getRule(), XCONSTRUCTOR_CALL__ARGUMENTS, null);
                    if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXBooleanLiteral = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XBooleanLiteralElements elementAccess = grammarAccess.getXBooleanLiteralAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral17447);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBooleanLiteral17457); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XBooleanLiteralElements elementAccess = grammarAccess.getXBooleanLiteralAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXBooleanLiteralAction_0(),
                          current);
            }
            }
            int alt170=2;
            int LA170_0 = input.LA(1);
            if ( (LA170_0==107) ) {
                alt170=1;
            }
            else if ( (LA170_0==108) ) {
                alt170=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 170, 0, input);
                throw nvae;
            }
            switch (alt170) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(107, FOLLOW_107_in_ruleXBooleanLiteral17504,  elementAccess.getFalseKeyword_1_0())) { return current; }

                    }
                    break;
                case 2 :
                    {

                    {

                    {
                    current = consumeTokenAndSetBooleanValue(108, FOLLOW_108_in_ruleXBooleanLiteral17528, current,  elementAccess.getIsTrueTrueKeyword_1_1_0(), elementAccess.getRule(), XBOOLEAN_LITERAL__IS_TRUE);
                    if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXNullLiteral = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XNullLiteralElements elementAccess = grammarAccess.getXNullLiteralAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral17584);
            iv_ruleXNullLiteral=ruleXNullLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNullLiteral17594); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XNullLiteralElements elementAccess = grammarAccess.getXNullLiteralAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXNullLiteralAction_0(),
                          current);
            }
            }
            if (!consumeUnassignedToken(109, FOLLOW_109_in_ruleXNullLiteral17640,  elementAccess.getNullKeyword_1())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleXNumberLiteral() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXNumberLiteral = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XNumberLiteralElements elementAccess = grammarAccess.getXNumberLiteralAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXNumberLiteral_in_entryRuleXNumberLiteral17682);
            iv_ruleXNumberLiteral=ruleXNumberLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNumberLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNumberLiteral17692); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXNumberLiteral() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XNumberLiteralElements elementAccess = grammarAccess.getXNumberLiteralAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXNumberLiteralAction_0(),
                          current);
            }
            }

            {

            {
            current = callRuleNumberAndSet(FOLLOW_ruleNumber_in_ruleXNumberLiteral17747, current, elementAccess.getValueNumberParserRuleCall_1_0(), elementAccess.getRule(), XNUMBER_LITERAL__VALUE, "Number");
            if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXTypeLiteral = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XTypeLiteralElements elementAccess = grammarAccess.getXTypeLiteralAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral17789);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTypeLiteral17799); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XTypeLiteralElements elementAccess = grammarAccess.getXTypeLiteralAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXTypeLiteralAction_0(),
                          current);
            }
            }
            if (!consumeUnassignedToken(110, FOLLOW_110_in_ruleXTypeLiteral17845,  elementAccess.getTypeofKeyword_1())) { return current; }

            if (!consumeUnassignedToken(35, FOLLOW_35_in_ruleXTypeLiteral17857,  elementAccess.getLeftParenthesisKeyword_2())) { return current; }


            {

            {
            current = callRuleQualifiedName(FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral17880, current, elementAccess.getTypeJvmTypeCrossReference_3_0(), elementAccess.getRule());
            if (state.failed) return current;

            }
            }
            loop171:
            do {
                int alt171=2;
                int LA171_0 = input.LA(1);
                if ( (LA171_0==94) ) {
                    alt171=1;
                }
                switch (alt171) {
            	case 1 :
            	    {

            	    {
            	    current = callRuleArrayBracketsAndAdd(FOLLOW_ruleArrayBrackets_in_ruleXTypeLiteral17901, current, elementAccess.getArrayDimensionsArrayBracketsParserRuleCall_4_0(), elementAccess.getRule(), XTYPE_LITERAL__ARRAY_DIMENSIONS, "ArrayBrackets");
            	    if (state.failed) return current;

            	    }
            	    }
            	    break;
            	default :
            	    break loop171;
                }
            } while (true);
            if (!consumeUnassignedToken(36, FOLLOW_36_in_ruleXTypeLiteral17914,  elementAccess.getRightParenthesisKeyword_5())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleXThrowExpression() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXThrowExpression = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XThrowExpressionElements elementAccess = grammarAccess.getXThrowExpressionAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression17956);
            iv_ruleXThrowExpression=ruleXThrowExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXThrowExpression17966); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXThrowExpression() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XThrowExpressionElements elementAccess = grammarAccess.getXThrowExpressionAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXThrowExpressionAction_0(),
                          current);
            }
            }
            if (!consumeUnassignedToken(111, FOLLOW_111_in_ruleXThrowExpression18012,  elementAccess.getThrowKeyword_1())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXThrowExpression18033, current, elementAccess.getExpressionXExpressionParserRuleCall_2_0(), elementAccess.getRule(), XTHROW_EXPRESSION__EXPRESSION, null);
            if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleXReturnExpression() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXReturnExpression = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XReturnExpressionElements elementAccess = grammarAccess.getXReturnExpressionAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression18075);
            iv_ruleXReturnExpression=ruleXReturnExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXReturnExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXReturnExpression18085); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXReturnExpression() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XReturnExpressionElements elementAccess = grammarAccess.getXReturnExpressionAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXReturnExpressionAction_0(),
                          current);
            }
            }
            if (!consumeUnassignedToken(112, FOLLOW_112_in_ruleXReturnExpression18131,  elementAccess.getReturnKeyword_1())) { return current; }

            int alt172=2;
            alt172 = dfa172.predict(input);
            switch (alt172) {
                case 1 :
                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXReturnExpression18162, current, elementAccess.getExpressionXExpressionParserRuleCall_2_0(), elementAccess.getRule(), XRETURN_EXPRESSION__EXPRESSION, null);
                    if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXTryCatchFinallyExpression = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XTryCatchFinallyExpressionElements elementAccess = grammarAccess.getXTryCatchFinallyExpressionAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression18205);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression18215); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XTryCatchFinallyExpressionElements elementAccess = grammarAccess.getXTryCatchFinallyExpressionAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getXTryCatchFinallyExpressionAction_0(),
                          current);
            }
            }
            if (!consumeUnassignedToken(113, FOLLOW_113_in_ruleXTryCatchFinallyExpression18261,  elementAccess.getTryKeyword_1())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression18282, current, elementAccess.getExpressionXExpressionParserRuleCall_2_0(), elementAccess.getRule(), XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION, null);
            if (state.failed) return current;

            }
            }
            int alt175=2;
            int LA175_0 = input.LA(1);
            if ( (LA175_0==115) ) {
                alt175=1;
            }
            else if ( (LA175_0==114) ) {
                alt175=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 175, 0, input);
                throw nvae;
            }
            switch (alt175) {
                case 1 :
                    {

                    {
                    int cnt173=0;
                    loop173:
                    do {
                        int alt173=2;
                        int LA173_0 = input.LA(1);
                        if ( (LA173_0==115) ) {
                            int LA173_2 = input.LA(2);
                            if ( (synpred40_InternalXtend()) ) {
                                alt173=1;
                            }
                        }
                        switch (alt173) {
                    	case 1 :
                    	    {

                    	    {
                    	    current = callRuleXCatchClauseAndAdd(FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression18312, current, elementAccess.getCatchClausesXCatchClauseParserRuleCall_3_0_0_0(), elementAccess.getRule(), XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSES, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    break;
                    	default :
                    	    if ( cnt173 >= 1 ) break loop173;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(173, input);
                                throw eee;
                        }
                        cnt173++;
                    } while (true);
                    int alt174=2;
                    int LA174_0 = input.LA(1);
                    if ( (LA174_0==114) ) {
                        int LA174_1 = input.LA(2);
                        if ( (synpred41_InternalXtend()) ) {
                            alt174=1;
                        }
                    }
                    switch (alt174) {
                        case 1 :
                            {

                            {
                            if (!consumeUnassignedToken(114, FOLLOW_114_in_ruleXTryCatchFinallyExpression18334,  elementAccess.getFinallyKeyword_3_0_1_0())) { return current; }

                            }

                            {

                            {
                            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression18356, current, elementAccess.getFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0(), elementAccess.getRule(), XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION, null);
                            if (state.failed) return current;

                            }
                            }
                            }
                            break;
                    }
                    }
                    }
                    break;
                case 2 :
                    {

                    {
                    if (!consumeUnassignedToken(114, FOLLOW_114_in_ruleXTryCatchFinallyExpression18378,  elementAccess.getFinallyKeyword_3_1_0())) { return current; }


                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression18399, current, elementAccess.getFinallyExpressionXExpressionParserRuleCall_3_1_1_0(), elementAccess.getRule(), XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION, null);
                    if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleXCatchClause() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXCatchClause = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XCatchClauseElements elementAccess = grammarAccess.getXCatchClauseAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause18443);
            iv_ruleXCatchClause=ruleXCatchClause();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCatchClause18453); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXCatchClause() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XCatchClauseElements elementAccess = grammarAccess.getXCatchClauseAccess();
        try {

            {

            {

            {
            if (!consumeUnassignedToken(115, FOLLOW_115_in_ruleXCatchClause18498,  elementAccess.getCatchKeyword_0())) { return current; }

            }
            if (!consumeUnassignedToken(35, FOLLOW_35_in_ruleXCatchClause18511,  elementAccess.getLeftParenthesisKeyword_1())) { return current; }


            {

            {
            current = callRuleFullJvmFormalParameterAndSet(FOLLOW_ruleFullJvmFormalParameter_in_ruleXCatchClause18532, current, elementAccess.getDeclaredParamFullJvmFormalParameterParserRuleCall_2_0(), elementAccess.getRule(), XCATCH_CLAUSE__DECLARED_PARAM, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(36, FOLLOW_36_in_ruleXCatchClause18544,  elementAccess.getRightParenthesisKeyword_3())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXCatchClause18565, current, elementAccess.getExpressionXExpressionParserRuleCall_4_0(), elementAccess.getRule(), XCATCH_CLAUSE__EXPRESSION, null);
            if (state.failed) return current;

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
        }
        return current;
    }

    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.QualifiedNameElements elementAccess = grammarAccess.getQualifiedNameAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName18608);
            iv_ruleQualifiedName=ruleQualifiedName();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName18619); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.QualifiedNameElements elementAccess = grammarAccess.getQualifiedNameAccess();
        try {

            {

            {
            callRuleValidID(FOLLOW_ruleValidID_in_ruleQualifiedName18666, current, elementAccess.getValidIDParserRuleCall_0());
            if (state.failed) return current;

            loop176:
            do {
                int alt176=2;
                int LA176_0 = input.LA(1);
                if ( (LA176_0==90) ) {
                    switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA176_3 = input.LA(3);
                        if ( (synpred43_InternalXtend()) ) {
                            alt176=1;
                        }
                        }
                        break;
                    case 32:
                        {
                        int LA176_4 = input.LA(3);
                        if ( (synpred43_InternalXtend()) ) {
                            alt176=1;
                        }
                        }
                        break;
                    case 50:
                        {
                        int LA176_5 = input.LA(3);
                        if ( (synpred43_InternalXtend()) ) {
                            alt176=1;
                        }
                        }
                        break;
                    }
                }
                switch (alt176) {
            	case 1 :
            	    {

            	    {
            	    if (!consumeTokenAndMerge(90, FOLLOW_90_in_ruleQualifiedName18694, current,  elementAccess.getFullStopKeyword_1_0())) { return current; }

            	    }
            	    callRuleValidID(FOLLOW_ruleValidID_in_ruleQualifiedName18717, current, elementAccess.getValidIDParserRuleCall_1_1());
            	    if (state.failed) return current;

            	    }
            	    break;
            	default :
            	    break loop176;
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
        }
        return current;
    }

    public final String entryRuleNumber() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleNumber = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.NumberElements elementAccess = grammarAccess.getNumberAccess();
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleNumber_in_entryRuleNumber18771);
            iv_ruleNumber=ruleNumber();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumber.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumber18782); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
            	myHiddenTokenState.restore();
        }
        return current;
    }

    public final AntlrDatatypeRuleToken ruleNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        Token this_token=null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.NumberElements elementAccess = grammarAccess.getNumberAccess();
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        try {

            {
            int alt180=2;
            int LA180_0 = input.LA(1);
            if ( (LA180_0==RULE_HEX) ) {
                alt180=1;
            }
            else if ( ((LA180_0>=RULE_INT && LA180_0<=RULE_DECIMAL)) ) {
                alt180=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 180, 0, input);
                throw nvae;
            }
            switch (alt180) {
                case 1 :
                    {
                    this_token=(Token)match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleNumber18826); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                      		current.merge(this_token);
                    }
                    if ( state.backtracking==0 ) {
                          newLeafNode(this_token, elementAccess.getHEXTerminalRuleCall_0()); 
                    }
                    }
                    break;
                case 2 :
                    {

                    {
                    int alt177=2;
                    int LA177_0 = input.LA(1);
                    if ( (LA177_0==RULE_INT) ) {
                        alt177=1;
                    }
                    else if ( (LA177_0==RULE_DECIMAL) ) {
                        alt177=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 177, 0, input);
                        throw nvae;
                    }
                    switch (alt177) {
                        case 1 :
                            {
                            this_token=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNumber18854); if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                              		current.merge(this_token);
                            }
                            if ( state.backtracking==0 ) {
                                  newLeafNode(this_token, elementAccess.getINTTerminalRuleCall_1_0_0()); 
                            }
                            }
                            break;
                        case 2 :
                            {
                            this_token=(Token)match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_ruleNumber18880); if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                              		current.merge(this_token);
                            }
                            if ( state.backtracking==0 ) {
                                  newLeafNode(this_token, elementAccess.getDECIMALTerminalRuleCall_1_0_1()); 
                            }
                            }
                            break;
                    }
                    int alt179=2;
                    int LA179_0 = input.LA(1);
                    if ( (LA179_0==90) ) {
                        int LA179_1 = input.LA(2);
                        if ( ((LA179_1>=RULE_INT && LA179_1<=RULE_DECIMAL)) ) {
                            alt179=1;
                        }
                    }
                    switch (alt179) {
                        case 1 :
                            {
                            if (!consumeTokenAndMerge(90, FOLLOW_90_in_ruleNumber18900, current,  elementAccess.getFullStopKeyword_1_1_0())) { return current; }

                            int alt178=2;
                            int LA178_0 = input.LA(1);
                            if ( (LA178_0==RULE_INT) ) {
                                alt178=1;
                            }
                            else if ( (LA178_0==RULE_DECIMAL) ) {
                                alt178=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 178, 0, input);
                                throw nvae;
                            }
                            switch (alt178) {
                                case 1 :
                                    {
                                    this_token=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNumber18916); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {
                                      		current.merge(this_token);
                                    }
                                    if ( state.backtracking==0 ) {
                                          newLeafNode(this_token, elementAccess.getINTTerminalRuleCall_1_1_1_0()); 
                                    }
                                    }
                                    break;
                                case 2 :
                                    {
                                    this_token=(Token)match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_ruleNumber18942); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {
                                      		current.merge(this_token);
                                    }
                                    if ( state.backtracking==0 ) {
                                          newLeafNode(this_token, elementAccess.getDECIMALTerminalRuleCall_1_1_1_1()); 
                                    }
                                    }
                                    break;
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
            	myHiddenTokenState.restore();
        }
        return current;
    }

    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleJvmTypeReference = null;
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.JvmTypeReferenceElements elementAccess = grammarAccess.getJvmTypeReferenceAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference19001);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference19011); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.JvmTypeReferenceElements elementAccess = grammarAccess.getJvmTypeReferenceAccess();
        try {

            {
            int alt182=2;
            int LA182_0 = input.LA(1);
            if ( (LA182_0==RULE_ID||LA182_0==32||LA182_0==50) ) {
                alt182=1;
            }
            else if ( (LA182_0==35||LA182_0==79) ) {
                alt182=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 182, 0, input);
                throw nvae;
            }
            switch (alt182) {
                case 1 :
                    {

                    {
                    current = callUnassignedRuleJvmParameterizedTypeReference(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference19059, elementAccess.getJvmParameterizedTypeReferenceParserRuleCall_0_0());
                    if (state.failed) return current;

                    loop181:
                    do {
                        int alt181=2;
                        int LA181_0 = input.LA(1);
                        if ( (LA181_0==94) ) {
                            int LA181_2 = input.LA(2);
                            if ( (LA181_2==95) ) {
                                int LA181_3 = input.LA(3);
                                if ( (synpred44_InternalXtend()) ) {
                                    alt181=1;
                                }
                            }
                        }
                        switch (alt181) {
                    	case 1 :
                    	    {

                    	    {

                    	    {
                    	    if ( state.backtracking==0 ) {
                    	              current = forceCreateModelElementAndSet(
                    	                  elementAccess.getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0(),
                    	                  JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE,
                    	                  current);
                    	    }
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	              newCompositeNode(elementAccess.getArrayBracketsParserRuleCall_0_1_0_1()); 
                    	    }
                    	    pushFollow(FOLLOW_ruleArrayBrackets_in_ruleJvmTypeReference19095);
                    	    ruleArrayBrackets();
                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	              afterParserOrEnumRuleCall();
                    	    }
                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop181;
                        }
                    } while (true);
                    }
                    }
                    break;
                case 2 :
                    {
                    current = callUnassignedRuleXFunctionTypeRef(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference19126, elementAccess.getXFunctionTypeRefParserRuleCall_1());
                    if (state.failed) return current;

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
        }
        return current;
    }

    public final String entryRuleArrayBrackets() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleArrayBrackets = null;
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.ArrayBracketsElements elementAccess = grammarAccess.getArrayBracketsAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets19168);
            iv_ruleArrayBrackets=ruleArrayBrackets();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayBrackets.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayBrackets19179); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final AntlrDatatypeRuleToken ruleArrayBrackets() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
         enterRule();
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.ArrayBracketsElements elementAccess = grammarAccess.getArrayBracketsAccess();
        try {

            {

            {
            if (!consumeTokenAndMerge(94, FOLLOW_94_in_ruleArrayBrackets19217, current,  elementAccess.getLeftSquareBracketKeyword_0())) { return current; }

            if (!consumeTokenAndMerge(95, FOLLOW_95_in_ruleArrayBrackets19230, current,  elementAccess.getRightSquareBracketKeyword_1())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXFunctionTypeRef = null;
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.XFunctionTypeRefElements elementAccess = grammarAccess.getXFunctionTypeRefAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef19276);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef19286); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.XFunctionTypeRefElements elementAccess = grammarAccess.getXFunctionTypeRefAccess();
        try {

            {

            {
            int alt185=2;
            int LA185_0 = input.LA(1);
            if ( (LA185_0==35) ) {
                alt185=1;
            }
            switch (alt185) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(35, FOLLOW_35_in_ruleXFunctionTypeRef19324,  elementAccess.getLeftParenthesisKeyword_0_0())) { return current; }

                    int alt184=2;
                    int LA184_0 = input.LA(1);
                    if ( (LA184_0==RULE_ID||LA184_0==32||LA184_0==35||LA184_0==50||LA184_0==79) ) {
                        alt184=1;
                    }
                    switch (alt184) {
                        case 1 :
                            {

                            {

                            {
                            current = callRuleJvmTypeReferenceAndAdd(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef19346, current, elementAccess.getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0(), elementAccess.getRule(), XFUNCTION_TYPE_REF__PARAM_TYPES, null);
                            if (state.failed) return current;

                            }
                            }
                            loop183:
                            do {
                                int alt183=2;
                                int LA183_0 = input.LA(1);
                                if ( (LA183_0==24) ) {
                                    alt183=1;
                                }
                                switch (alt183) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleXFunctionTypeRef19359,  elementAccess.getCommaKeyword_0_1_1_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleJvmTypeReferenceAndAdd(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef19380, current, elementAccess.getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0(), elementAccess.getRule(), XFUNCTION_TYPE_REF__PARAM_TYPES, null);
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop183;
                                }
                            } while (true);
                            }
                            break;
                    }
                    if (!consumeUnassignedToken(36, FOLLOW_36_in_ruleXFunctionTypeRef19396,  elementAccess.getRightParenthesisKeyword_0_2())) { return current; }

                    }
                    break;
            }
            if (!consumeUnassignedToken(79, FOLLOW_79_in_ruleXFunctionTypeRef19410,  elementAccess.getEqualsSignGreaterThanSignKeyword_1())) { return current; }


            {

            {
            current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef19431, current, elementAccess.getReturnTypeJvmTypeReferenceParserRuleCall_2_0(), elementAccess.getRule(), XFUNCTION_TYPE_REF__RETURN_TYPE, null);
            if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleJvmParameterizedTypeReference = null;
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.JvmParameterizedTypeReferenceElements elementAccess = grammarAccess.getJvmParameterizedTypeReferenceAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference19473);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference19483); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.JvmParameterizedTypeReferenceElements elementAccess = grammarAccess.getJvmParameterizedTypeReferenceAccess();
        try {

            {

            {

            {

            {
            current = callRuleQualifiedName(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference19531, current, elementAccess.getTypeJvmTypeCrossReference_0_0(), elementAccess.getRule());
            if (state.failed) return current;

            }
            }
            int alt187=2;
            alt187 = dfa187.predict(input);
            switch (alt187) {
                case 1 :
                    {

                    {
                    if (!consumeUnassignedToken(23, FOLLOW_23_in_ruleJvmParameterizedTypeReference19552,  elementAccess.getLessThanSignKeyword_1_0())) { return current; }

                    }

                    {

                    {
                    current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference19574, current, elementAccess.getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0(), elementAccess.getRule(), JVM_PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS, null);
                    if (state.failed) return current;

                    }
                    }
                    loop186:
                    do {
                        int alt186=2;
                        int LA186_0 = input.LA(1);
                        if ( (LA186_0==24) ) {
                            alt186=1;
                        }
                        switch (alt186) {
                    	case 1 :
                    	    {
                    	    if (!consumeUnassignedToken(24, FOLLOW_24_in_ruleJvmParameterizedTypeReference19587,  elementAccess.getCommaKeyword_1_2_0())) { return current; }


                    	    {

                    	    {
                    	    current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference19608, current, elementAccess.getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0(), elementAccess.getRule(), JVM_PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop186;
                        }
                    } while (true);
                    if (!consumeUnassignedToken(25, FOLLOW_25_in_ruleJvmParameterizedTypeReference19622,  elementAccess.getGreaterThanSignKeyword_1_3())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleJvmArgumentTypeReference = null;
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.JvmArgumentTypeReferenceElements elementAccess = grammarAccess.getJvmArgumentTypeReferenceAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference19666);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference19676); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.JvmArgumentTypeReferenceElements elementAccess = grammarAccess.getJvmArgumentTypeReferenceAccess();
        try {

            {
            int alt188=2;
            int LA188_0 = input.LA(1);
            if ( (LA188_0==RULE_ID||LA188_0==32||LA188_0==35||LA188_0==50||LA188_0==79) ) {
                alt188=1;
            }
            else if ( (LA188_0==116) ) {
                alt188=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 188, 0, input);
                throw nvae;
            }
            switch (alt188) {
                case 1 :
                    {
                    current = callUnassignedRuleJvmTypeReference(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference19723, elementAccess.getJvmTypeReferenceParserRuleCall_0());
                    if (state.failed) return current;

                    }
                    break;
                case 2 :
                    {
                    current = callUnassignedRuleJvmWildcardTypeReference(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference19750, elementAccess.getJvmWildcardTypeReferenceParserRuleCall_1());
                    if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleJvmWildcardTypeReference = null;
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.JvmWildcardTypeReferenceElements elementAccess = grammarAccess.getJvmWildcardTypeReferenceAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference19791);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference19801); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.JvmWildcardTypeReferenceElements elementAccess = grammarAccess.getJvmWildcardTypeReferenceAccess();
        try {

            {

            {

            {
            if ( state.backtracking==0 ) {
                      current = forceCreateModelElement(
                          elementAccess.getJvmWildcardTypeReferenceAction_0(),
                          current);
            }
            }
            if (!consumeUnassignedToken(116, FOLLOW_116_in_ruleJvmWildcardTypeReference19847,  elementAccess.getQuestionMarkKeyword_1())) { return current; }

            int alt189=3;
            int LA189_0 = input.LA(1);
            if ( (LA189_0==26) ) {
                alt189=1;
            }
            else if ( (LA189_0==105) ) {
                alt189=2;
            }
            switch (alt189) {
                case 1 :
                    {

                    {

                    {
                    current = callRuleJvmUpperBoundAndAdd(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference19869, current, elementAccess.getConstraintsJvmUpperBoundParserRuleCall_2_0_0(), elementAccess.getRule(), JVM_WILDCARD_TYPE_REFERENCE__CONSTRAINTS, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    break;
                case 2 :
                    {

                    {

                    {
                    current = callRuleJvmLowerBoundAndAdd(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference19896, current, elementAccess.getConstraintsJvmLowerBoundParserRuleCall_2_1_0(), elementAccess.getRule(), JVM_WILDCARD_TYPE_REFERENCE__CONSTRAINTS, null);
                    if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleJvmUpperBound = null;
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.JvmUpperBoundElements elementAccess = grammarAccess.getJvmUpperBoundAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound19940);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound19950); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.JvmUpperBoundElements elementAccess = grammarAccess.getJvmUpperBoundAccess();
        try {

            {

            {
            if (!consumeUnassignedToken(26, FOLLOW_26_in_ruleJvmUpperBound19987,  elementAccess.getExtendsKeyword_0())) { return current; }


            {

            {
            current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound20008, current, elementAccess.getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), elementAccess.getRule(), JVM_UPPER_BOUND__TYPE_REFERENCE, null);
            if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleJvmUpperBoundAnded = null;
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.JvmUpperBoundAndedElements elementAccess = grammarAccess.getJvmUpperBoundAndedAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded20050);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded20060); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.JvmUpperBoundAndedElements elementAccess = grammarAccess.getJvmUpperBoundAndedAccess();
        try {

            {

            {
            if (!consumeUnassignedToken(117, FOLLOW_117_in_ruleJvmUpperBoundAnded20097,  elementAccess.getAmpersandKeyword_0())) { return current; }


            {

            {
            current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded20118, current, elementAccess.getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), elementAccess.getRule(), JVM_UPPER_BOUND__TYPE_REFERENCE, null);
            if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleJvmLowerBound = null;
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.JvmLowerBoundElements elementAccess = grammarAccess.getJvmLowerBoundAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound20160);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound20170); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.JvmLowerBoundElements elementAccess = grammarAccess.getJvmLowerBoundAccess();
        try {

            {

            {
            if (!consumeUnassignedToken(105, FOLLOW_105_in_ruleJvmLowerBound20207,  elementAccess.getSuperKeyword_0())) { return current; }


            {

            {
            current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound20228, current, elementAccess.getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), elementAccess.getRule(), JVM_LOWER_BOUND__TYPE_REFERENCE, null);
            if (state.failed) return current;

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
        }
        return current;
    }

    public final EObject entryRuleJvmTypeParameter() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleJvmTypeParameter = null;
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.JvmTypeParameterElements elementAccess = grammarAccess.getJvmTypeParameterAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeParameter_in_entryRuleJvmTypeParameter20270);
            iv_ruleJvmTypeParameter=ruleJvmTypeParameter();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeParameter20280); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleJvmTypeParameter() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.JvmTypeParameterElements elementAccess = grammarAccess.getJvmTypeParameterAccess();
        try {

            {

            {

            {

            {
            current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleJvmTypeParameter20326, current, elementAccess.getNameValidIDParserRuleCall_0_0(), elementAccess.getRule(), JVM_TYPE_PARAMETER__NAME, "ValidID");
            if (state.failed) return current;

            }
            }
            int alt191=3;
            int LA191_0 = input.LA(1);
            if ( (LA191_0==26) ) {
                alt191=1;
            }
            else if ( (LA191_0==105) ) {
                alt191=2;
            }
            switch (alt191) {
                case 1 :
                    {

                    {

                    {

                    {
                    current = callRuleJvmUpperBoundAndAdd(FOLLOW_ruleJvmUpperBound_in_ruleJvmTypeParameter20349, current, elementAccess.getConstraintsJvmUpperBoundParserRuleCall_1_0_0_0(), elementAccess.getRule(), JVM_TYPE_PARAMETER__CONSTRAINTS, null);
                    if (state.failed) return current;

                    }
                    }
                    loop190:
                    do {
                        int alt190=2;
                        int LA190_0 = input.LA(1);
                        if ( (LA190_0==117) ) {
                            alt190=1;
                        }
                        switch (alt190) {
                    	case 1 :
                    	    {

                    	    {
                    	    current = callRuleJvmUpperBoundAndedAndAdd(FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmTypeParameter20370, current, elementAccess.getConstraintsJvmUpperBoundAndedParserRuleCall_1_0_1_0(), elementAccess.getRule(), JVM_TYPE_PARAMETER__CONSTRAINTS, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop190;
                        }
                    } while (true);
                    }
                    }
                    break;
                case 2 :
                    {

                    {

                    {
                    current = callRuleJvmLowerBoundAndAdd(FOLLOW_ruleJvmLowerBound_in_ruleJvmTypeParameter20399, current, elementAccess.getConstraintsJvmLowerBoundParserRuleCall_1_1_0(), elementAccess.getRule(), JVM_TYPE_PARAMETER__CONSTRAINTS, null);
                    if (state.failed) return current;

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
        }
        return current;
    }

    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.QualifiedNameWithWildcardElements elementAccess = grammarAccess.getQualifiedNameWithWildcardAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard20444);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildcard.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard20455); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
         enterRule();
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.QualifiedNameWithWildcardElements elementAccess = grammarAccess.getQualifiedNameWithWildcardAccess();
        try {

            {

            {
            callRuleQualifiedName(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard20502, current, elementAccess.getQualifiedNameParserRuleCall_0());
            if (state.failed) return current;

            if (!consumeTokenAndMerge(90, FOLLOW_90_in_ruleQualifiedNameWithWildcard20520, current,  elementAccess.getFullStopKeyword_1())) { return current; }

            if (!consumeTokenAndMerge(84, FOLLOW_84_in_ruleQualifiedNameWithWildcard20533, current,  elementAccess.getAsteriskKeyword_2())) { return current; }

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
        }
        return current;
    }

    public final EObject entryRuleXImportSection() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXImportSection = null;
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.XImportSectionElements elementAccess = grammarAccess.getXImportSectionAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXImportSection_in_entryRuleXImportSection20579);
            iv_ruleXImportSection=ruleXImportSection();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXImportSection; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXImportSection20589); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXImportSection() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.XImportSectionElements elementAccess = grammarAccess.getXImportSectionAccess();
        try {

            {
            int cnt192=0;
            loop192:
            do {
                int alt192=2;
                int LA192_0 = input.LA(1);
                if ( (LA192_0==52) ) {
                    alt192=1;
                }
                switch (alt192) {
            	case 1 :
            	    {

            	    {
            	    current = callRuleXImportDeclarationAndAdd(FOLLOW_ruleXImportDeclaration_in_ruleXImportSection20634, current, elementAccess.getImportDeclarationsXImportDeclarationParserRuleCall_0(), elementAccess.getRule(), XIMPORT_SECTION__IMPORT_DECLARATIONS, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    break;
            	default :
            	    if ( cnt192 >= 1 ) break loop192;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(192, input);
                        throw eee;
                }
                cnt192++;
            } while (true);
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
        }
        return current;
    }

    public final EObject entryRuleXImportDeclaration() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXImportDeclaration = null;
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.XImportDeclarationElements elementAccess = grammarAccess.getXImportDeclarationAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXImportDeclaration_in_entryRuleXImportDeclaration20676);
            iv_ruleXImportDeclaration=ruleXImportDeclaration();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXImportDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXImportDeclaration20686); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXImportDeclaration() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.services.XtypeGrammarAccess.XImportDeclarationElements elementAccess = grammarAccess.getXImportDeclarationAccess();
        try {

            {

            {
            if (!consumeUnassignedToken(52, FOLLOW_52_in_ruleXImportDeclaration20723,  elementAccess.getImportKeyword_0())) { return current; }

            int alt194=3;
            alt194 = dfa194.predict(input);
            switch (alt194) {
                case 1 :
                    {

                    {

                    {

                    {
                    current = consumeTokenAndSetBooleanValue(43, FOLLOW_43_in_ruleXImportDeclaration20743, current,  elementAccess.getStaticStaticKeyword_1_0_0_0(), elementAccess.getRule(), XIMPORT_DECLARATION__STATIC);
                    if (state.failed) return current;

                    }
                    }
                    int alt193=2;
                    int LA193_0 = input.LA(1);
                    if ( (LA193_0==34) ) {
                        alt193=1;
                    }
                    switch (alt193) {
                        case 1 :
                            {

                            {
                            current = consumeTokenAndSetBooleanValue(34, FOLLOW_34_in_ruleXImportDeclaration20774, current,  elementAccess.getExtensionExtensionKeyword_1_0_1_0(), elementAccess.getRule(), XIMPORT_DECLARATION__EXTENSION);
                            if (state.failed) return current;

                            }
                            }
                            break;
                    }

                    {

                    {
                    current = callRuleQualifiedName(FOLLOW_ruleQualifiedName_in_ruleXImportDeclaration20811, current, elementAccess.getImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0(), elementAccess.getRule());
                    if (state.failed) return current;

                    }
                    }
                    if (!consumeUnassignedToken(90, FOLLOW_90_in_ruleXImportDeclaration20823,  elementAccess.getFullStopKeyword_1_0_3())) { return current; }

                    if (!consumeUnassignedToken(84, FOLLOW_84_in_ruleXImportDeclaration20835,  elementAccess.getAsteriskKeyword_1_0_4())) { return current; }

                    }
                    }
                    break;
                case 2 :
                    {

                    {

                    {
                    current = callRuleQualifiedName(FOLLOW_ruleQualifiedName_in_ruleXImportDeclaration20865, current, elementAccess.getImportedTypeJvmDeclaredTypeCrossReference_1_1_0(), elementAccess.getRule());
                    if (state.failed) return current;

                    }
                    }
                    }
                    break;
                case 3 :
                    {

                    {

                    {
                    current = callRuleQualifiedNameWithWildcardAndSet(FOLLOW_ruleQualifiedNameWithWildcard_in_ruleXImportDeclaration20892, current, elementAccess.getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0(), elementAccess.getRule(), XIMPORT_DECLARATION__IMPORTED_NAMESPACE, "QualifiedNameWithWildcard");
                    if (state.failed) return current;

                    }
                    }
                    }
                    break;
            }
            int alt195=2;
            int LA195_0 = input.LA(1);
            if ( (LA195_0==21) ) {
                alt195=1;
            }
            switch (alt195) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(21, FOLLOW_21_in_ruleXImportDeclaration20906,  elementAccess.getSemicolonKeyword_2())) { return current; }

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
        }
        return current;
    }

    public final void synpred1_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {

        {
        pushFollow(FOLLOW_ruleJvmTypeReference_in_synpred1_InternalXtend2324);
        ruleJvmTypeReference();
        state._fsp--;
        if (state.failed) return ;
        }
        }

        {

        {
        pushFollow(FOLLOW_ruleCreateExtensionInfo_in_synpred1_InternalXtend2333);
        ruleCreateExtensionInfo();
        state._fsp--;
        if (state.failed) return ;
        }
        }

        {

        {
        pushFollow(FOLLOW_ruleValidID_in_synpred1_InternalXtend2342);
        ruleValidID();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        match(input,35,FOLLOW_35_in_synpred1_InternalXtend2348); if (state.failed) return ;
        }
        }
    }

    public final void synpred2_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {

        {
        pushFollow(FOLLOW_ruleJvmTypeReference_in_synpred2_InternalXtend2445);
        ruleJvmTypeReference();
        state._fsp--;
        if (state.failed) return ;
        }
        }

        {

        {
        pushFollow(FOLLOW_ruleValidID_in_synpred2_InternalXtend2454);
        ruleValidID();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        match(input,35,FOLLOW_35_in_synpred2_InternalXtend2460); if (state.failed) return ;
        }
        }
    }

    public final void synpred3_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {

        {
        pushFollow(FOLLOW_ruleCreateExtensionInfo_in_synpred3_InternalXtend2536);
        ruleCreateExtensionInfo();
        state._fsp--;
        if (state.failed) return ;
        }
        }

        {

        {
        pushFollow(FOLLOW_ruleValidID_in_synpred3_InternalXtend2545);
        ruleValidID();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        match(input,35,FOLLOW_35_in_synpred3_InternalXtend2551); if (state.failed) return ;
        }
        }
    }

    public final void synpred5_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {

        {
        pushFollow(FOLLOW_ruleJvmTypeReference_in_synpred5_InternalXtend5113);
        ruleJvmTypeReference();
        state._fsp--;
        if (state.failed) return ;
        }
        }

        {

        {
        pushFollow(FOLLOW_ruleValidID_in_synpred5_InternalXtend5122);
        ruleValidID();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        }
        }
    }

    public final void synpred6_InternalXtend_fragment() throws RecognitionException {   

        {
        match(input,35,FOLLOW_35_in_synpred6_InternalXtend7560); if (state.failed) return ;
        }
    }

    public final void synpred7_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }

        {

        {
        pushFollow(FOLLOW_ruleOpMultiAssign_in_synpred7_InternalXtend8706);
        ruleOpMultiAssign();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        }
        }
    }

    public final void synpred8_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }

        {

        {
        pushFollow(FOLLOW_ruleOpOr_in_synpred8_InternalXtend9093);
        ruleOpOr();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        }
        }
    }

    public final void synpred9_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }

        {

        {
        pushFollow(FOLLOW_ruleOpAnd_in_synpred9_InternalXtend9364);
        ruleOpAnd();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        }
        }
    }

    public final void synpred10_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }

        {

        {
        pushFollow(FOLLOW_ruleOpEquality_in_synpred10_InternalXtend9635);
        ruleOpEquality();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        }
        }
    }

    public final void synpred11_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        match(input,73,FOLLOW_73_in_synpred11_InternalXtend9961); if (state.failed) return ;
        }
        }
    }

    public final void synpred12_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }

        {

        {
        pushFollow(FOLLOW_ruleOpCompare_in_synpred12_InternalXtend10032);
        ruleOpCompare();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        }
        }
    }

    public final void synpred13_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }

        {

        {
        pushFollow(FOLLOW_ruleOpOther_in_synpred13_InternalXtend10363);
        ruleOpOther();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        }
        }
    }

    public final void synpred14_InternalXtend_fragment() throws RecognitionException {   

        {

        {
        match(input,25,FOLLOW_25_in_synpred14_InternalXtend10638); if (state.failed) return ;
        match(input,25,FOLLOW_25_in_synpred14_InternalXtend10643); if (state.failed) return ;
        }
        }
    }

    public final void synpred15_InternalXtend_fragment() throws RecognitionException {   

        {

        {
        match(input,23,FOLLOW_23_in_synpred15_InternalXtend10725); if (state.failed) return ;
        match(input,23,FOLLOW_23_in_synpred15_InternalXtend10730); if (state.failed) return ;
        }
        }
    }

    public final void synpred16_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }

        {

        {
        pushFollow(FOLLOW_ruleOpAdd_in_synpred16_InternalXtend10958);
        ruleOpAdd();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        }
        }
    }

    public final void synpred17_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }

        {

        {
        pushFollow(FOLLOW_ruleOpMulti_in_synpred17_InternalXtend11250);
        ruleOpMulti();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        }
        }
    }

    public final void synpred18_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        match(input,89,FOLLOW_89_in_synpred18_InternalXtend11868); if (state.failed) return ;
        }
        }
    }

    public final void synpred19_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        match(input,90,FOLLOW_90_in_synpred19_InternalXtend12028); if (state.failed) return ;

        {

        {
        pushFollow(FOLLOW_ruleFeatureCallID_in_synpred19_InternalXtend12037);
        ruleFeatureCallID();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        pushFollow(FOLLOW_ruleOpSingleAssign_in_synpred19_InternalXtend12043);
        ruleOpSingleAssign();
        state._fsp--;
        if (state.failed) return ;
        }
        }
    }

    public final void synpred20_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        int alt200=3;
        switch ( input.LA(1) ) {
        case 90:
            {
            alt200=1;
            }
            break;
        case 91:
            {
            alt200=2;
            }
            break;
        case 92:
            {
            alt200=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 200, 0, input);
            throw nvae;
        }
        switch (alt200) {
            case 1 :
                {
                match(input,90,FOLLOW_90_in_synpred20_InternalXtend12146); if (state.failed) return ;
                }
                break;
            case 2 :
                {

                {

                {
                match(input,91,FOLLOW_91_in_synpred20_InternalXtend12160); if (state.failed) return ;
                }
                }
                }
                break;
            case 3 :
                {

                {

                {
                match(input,92,FOLLOW_92_in_synpred20_InternalXtend12180); if (state.failed) return ;
                }
                }
                }
                break;
        }
        }
        }
    }

    public final void synpred21_InternalXtend_fragment() throws RecognitionException {   

        {

        {
        match(input,35,FOLLOW_35_in_synpred21_InternalXtend12407); if (state.failed) return ;
        }
        }
    }

    public final void synpred22_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        int alt202=2;
        int LA202_0 = input.LA(1);
        if ( (LA202_0==RULE_ID||LA202_0==32||(LA202_0>=34 && LA202_0<=35)||LA202_0==50||LA202_0==79) ) {
            alt202=1;
        }
        switch (alt202) {
            case 1 :
                {

                {

                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred22_InternalXtend12459);
                ruleJvmFormalParameter();
                state._fsp--;
                if (state.failed) return ;
                }
                }
                loop201:
                do {
                    int alt201=2;
                    int LA201_0 = input.LA(1);
                    if ( (LA201_0==24) ) {
                        alt201=1;
                    }
                    switch (alt201) {
                	case 1 :
                	    {
                	    match(input,24,FOLLOW_24_in_synpred22_InternalXtend12466); if (state.failed) return ;

                	    {

                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred22_InternalXtend12473);
                	    ruleJvmFormalParameter();
                	    state._fsp--;
                	    if (state.failed) return ;
                	    }
                	    }
                	    }
                	    break;
                	default :
                	    break loop201;
                    }
                } while (true);
                }
                break;
        }

        {

        {
        match(input,96,FOLLOW_96_in_synpred22_InternalXtend12487); if (state.failed) return ;
        }
        }
        }
        }
    }

    public final void synpred23_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        match(input,94,FOLLOW_94_in_synpred23_InternalXtend12607); if (state.failed) return ;
        }
        }
    }

    public final void synpred24_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        match(input,94,FOLLOW_94_in_synpred24_InternalXtend13170); if (state.failed) return ;
        }
        }
    }

    public final void synpred26_InternalXtend_fragment() throws RecognitionException {   

        {

        {
        int alt204=2;
        int LA204_0 = input.LA(1);
        if ( (LA204_0==RULE_ID||LA204_0==32||(LA204_0>=34 && LA204_0<=35)||LA204_0==50||LA204_0==79) ) {
            alt204=1;
        }
        switch (alt204) {
            case 1 :
                {

                {

                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred26_InternalXtend13944);
                ruleJvmFormalParameter();
                state._fsp--;
                if (state.failed) return ;
                }
                }
                loop203:
                do {
                    int alt203=2;
                    int LA203_0 = input.LA(1);
                    if ( (LA203_0==24) ) {
                        alt203=1;
                    }
                    switch (alt203) {
                	case 1 :
                	    {
                	    match(input,24,FOLLOW_24_in_synpred26_InternalXtend13951); if (state.failed) return ;

                	    {

                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred26_InternalXtend13958);
                	    ruleJvmFormalParameter();
                	    state._fsp--;
                	    if (state.failed) return ;
                	    }
                	    }
                	    }
                	    break;
                	default :
                	    break loop203;
                    }
                } while (true);
                }
                break;
        }

        {

        {
        match(input,96,FOLLOW_96_in_synpred26_InternalXtend13972); if (state.failed) return ;
        }
        }
        }
        }
    }

    public final void synpred28_InternalXtend_fragment() throws RecognitionException {   

        {
        match(input,98,FOLLOW_98_in_synpred28_InternalXtend14779); if (state.failed) return ;
        }
    }

    public final void synpred29_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {

        {
        pushFollow(FOLLOW_ruleValidID_in_synpred29_InternalXtend14927);
        ruleValidID();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        match(input,51,FOLLOW_51_in_synpred29_InternalXtend14933); if (state.failed) return ;
        }
        }
    }

    public final void synpred30_InternalXtend_fragment() throws RecognitionException {   

        {

        {
        match(input,35,FOLLOW_35_in_synpred30_InternalXtend15009); if (state.failed) return ;

        {

        {
        pushFollow(FOLLOW_ruleValidID_in_synpred30_InternalXtend15016);
        ruleValidID();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        match(input,51,FOLLOW_51_in_synpred30_InternalXtend15022); if (state.failed) return ;
        }
        }
    }

    public final void synpred31_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        int alt210=2;
        int LA210_0 = input.LA(1);
        if ( ((LA210_0>=46 && LA210_0<=47)) ) {
            alt210=1;
        }
        else if ( (LA210_0==34) ) {
            alt210=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 210, 0, input);
            throw nvae;
        }
        switch (alt210) {
            case 1 :
                {

                {
                int alt207=2;
                int LA207_0 = input.LA(1);
                if ( (LA207_0==47) ) {
                    alt207=1;
                }
                else if ( (LA207_0==46) ) {
                    alt207=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 207, 0, input);
                    throw nvae;
                }
                switch (alt207) {
                    case 1 :
                        {

                        {

                        {
                        match(input,47,FOLLOW_47_in_synpred31_InternalXtend16150); if (state.failed) return ;
                        }
                        }
                        }
                        break;
                    case 2 :
                        {
                        match(input,46,FOLLOW_46_in_synpred31_InternalXtend16166); if (state.failed) return ;
                        }
                        break;
                }
                int alt208=2;
                int LA208_0 = input.LA(1);
                if ( (LA208_0==34) ) {
                    alt208=1;
                }
                switch (alt208) {
                    case 1 :
                        {

                        {
                        match(input,34,FOLLOW_34_in_synpred31_InternalXtend16175); if (state.failed) return ;
                        }
                        }
                        break;
                }
                }
                }
                break;
            case 2 :
                {

                {

                {

                {
                match(input,34,FOLLOW_34_in_synpred31_InternalXtend16198); if (state.failed) return ;
                }
                }
                int alt209=2;
                int LA209_0 = input.LA(1);
                if ( (LA209_0==47) ) {
                    alt209=1;
                }
                else if ( (LA209_0==46) ) {
                    alt209=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 209, 0, input);
                    throw nvae;
                }
                switch (alt209) {
                    case 1 :
                        {

                        {

                        {
                        match(input,47,FOLLOW_47_in_synpred31_InternalXtend16213); if (state.failed) return ;
                        }
                        }
                        }
                        break;
                    case 2 :
                        {
                        match(input,46,FOLLOW_46_in_synpred31_InternalXtend16229); if (state.failed) return ;
                        }
                        break;
                }
                }
                }
                break;
        }
        }
        }
    }

    public final void synpred32_InternalXtend_fragment() throws RecognitionException {   

        {

        {
        match(input,35,FOLLOW_35_in_synpred32_InternalXtend16511); if (state.failed) return ;
        }
        }
    }

    public final void synpred33_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        int alt212=2;
        int LA212_0 = input.LA(1);
        if ( (LA212_0==RULE_ID||LA212_0==32||(LA212_0>=34 && LA212_0<=35)||LA212_0==50||LA212_0==79) ) {
            alt212=1;
        }
        switch (alt212) {
            case 1 :
                {

                {

                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred33_InternalXtend16563);
                ruleJvmFormalParameter();
                state._fsp--;
                if (state.failed) return ;
                }
                }
                loop211:
                do {
                    int alt211=2;
                    int LA211_0 = input.LA(1);
                    if ( (LA211_0==24) ) {
                        alt211=1;
                    }
                    switch (alt211) {
                	case 1 :
                	    {
                	    match(input,24,FOLLOW_24_in_synpred33_InternalXtend16570); if (state.failed) return ;

                	    {

                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred33_InternalXtend16577);
                	    ruleJvmFormalParameter();
                	    state._fsp--;
                	    if (state.failed) return ;
                	    }
                	    }
                	    }
                	    break;
                	default :
                	    break loop211;
                    }
                } while (true);
                }
                break;
        }

        {

        {
        match(input,96,FOLLOW_96_in_synpred33_InternalXtend16591); if (state.failed) return ;
        }
        }
        }
        }
    }

    public final void synpred34_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        match(input,94,FOLLOW_94_in_synpred34_InternalXtend16711); if (state.failed) return ;
        }
        }
    }

    public final void synpred35_InternalXtend_fragment() throws RecognitionException {   

        {
        match(input,23,FOLLOW_23_in_synpred35_InternalXtend17116); if (state.failed) return ;
        }
    }

    public final void synpred36_InternalXtend_fragment() throws RecognitionException {   

        {
        match(input,35,FOLLOW_35_in_synpred36_InternalXtend17209); if (state.failed) return ;
        }
    }

    public final void synpred37_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        int alt214=2;
        int LA214_0 = input.LA(1);
        if ( (LA214_0==RULE_ID||LA214_0==32||(LA214_0>=34 && LA214_0<=35)||LA214_0==50||LA214_0==79) ) {
            alt214=1;
        }
        switch (alt214) {
            case 1 :
                {

                {

                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred37_InternalXtend17239);
                ruleJvmFormalParameter();
                state._fsp--;
                if (state.failed) return ;
                }
                }
                loop213:
                do {
                    int alt213=2;
                    int LA213_0 = input.LA(1);
                    if ( (LA213_0==24) ) {
                        alt213=1;
                    }
                    switch (alt213) {
                	case 1 :
                	    {
                	    match(input,24,FOLLOW_24_in_synpred37_InternalXtend17246); if (state.failed) return ;

                	    {

                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred37_InternalXtend17253);
                	    ruleJvmFormalParameter();
                	    state._fsp--;
                	    if (state.failed) return ;
                	    }
                	    }
                	    }
                	    break;
                	default :
                	    break loop213;
                    }
                } while (true);
                }
                break;
        }

        {

        {
        match(input,96,FOLLOW_96_in_synpred37_InternalXtend17267); if (state.failed) return ;
        }
        }
        }
        }
    }

    public final void synpred38_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        match(input,94,FOLLOW_94_in_synpred38_InternalXtend17387); if (state.failed) return ;
        }
        }
    }

    public final void synpred39_InternalXtend_fragment() throws RecognitionException {   

        {

        {
        pushFollow(FOLLOW_ruleXExpression_in_synpred39_InternalXtend18145);
        ruleXExpression();
        state._fsp--;
        if (state.failed) return ;
        }
        }
    }

    public final void synpred40_InternalXtend_fragment() throws RecognitionException {   

        {
        match(input,115,FOLLOW_115_in_synpred40_InternalXtend18296); if (state.failed) return ;
        }
    }

    public final void synpred41_InternalXtend_fragment() throws RecognitionException {   

        {
        match(input,114,FOLLOW_114_in_synpred41_InternalXtend18326); if (state.failed) return ;
        }
    }

    public final void synpred43_InternalXtend_fragment() throws RecognitionException {   

        {
        match(input,90,FOLLOW_90_in_synpred43_InternalXtend18685); if (state.failed) return ;
        }
    }

    public final void synpred44_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        pushFollow(FOLLOW_ruleArrayBrackets_in_synpred44_InternalXtend19074);
        ruleArrayBrackets();
        state._fsp--;
        if (state.failed) return ;
        }
        }
    }

    public final void synpred45_InternalXtend_fragment() throws RecognitionException {   

        {
        match(input,23,FOLLOW_23_in_synpred45_InternalXtend19544); if (state.failed) return ;
        }
    }

    public final boolean synpred5_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred41_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred41_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA62 dfa62 = new DFA62(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA41 dfa41 = new DFA41(this);
    protected DFA49 dfa49 = new DFA49(this);
    protected DFA99 dfa99 = new DFA99(this);
    protected DFA104 dfa104 = new DFA104(this);
    protected DFA112 dfa112 = new DFA112(this);
    protected DFA115 dfa115 = new DFA115(this);
    protected DFA128 dfa128 = new DFA128(this);
    protected DFA127 dfa127 = new DFA127(this);
    protected DFA129 dfa129 = new DFA129(this);
    protected DFA131 dfa131 = new DFA131(this);
    protected DFA140 dfa140 = new DFA140(this);
    protected DFA160 dfa160 = new DFA160(this);
    protected DFA159 dfa159 = new DFA159(this);
    protected DFA161 dfa161 = new DFA161(this);
    protected DFA165 dfa165 = new DFA165(this);
    protected DFA168 dfa168 = new DFA168(this);
    protected DFA167 dfa167 = new DFA167(this);
    protected DFA169 dfa169 = new DFA169(this);
    protected DFA172 dfa172 = new DFA172(this);
    protected DFA187 dfa187 = new DFA187(this);
    protected DFA194 dfa194 = new DFA194(this);
    static final String DFA25_eotS =
        "\15\uffff";
    static final String DFA25_eofS =
        "\15\uffff";
    static final String DFA25_minS =
        "\11\24\4\uffff";
    static final String DFA25_maxS =
        "\11\55\4\uffff";
    static final String DFA25_acceptS =
        "\11\uffff\1\1\1\2\1\3\1\4";
    static final String DFA25_specialS =
        "\15\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\4\1\uffff\1\11\7\uffff\1\12\1\13\1\14\6\uffff\1\1\1\2\1\3"+
            "\1\5\1\6\1\7\1\10",
            "\1\4\1\uffff\1\11\7\uffff\1\12\1\13\1\14\6\uffff\1\1\1\2\1"+
            "\3\1\5\1\6\1\7\1\10",
            "\1\4\1\uffff\1\11\7\uffff\1\12\1\13\1\14\6\uffff\1\1\1\2\1"+
            "\3\1\5\1\6\1\7\1\10",
            "\1\4\1\uffff\1\11\7\uffff\1\12\1\13\1\14\6\uffff\1\1\1\2\1"+
            "\3\1\5\1\6\1\7\1\10",
            "\1\4\1\uffff\1\11\7\uffff\1\12\1\13\1\14\6\uffff\1\1\1\2\1"+
            "\3\1\5\1\6\1\7\1\10",
            "\1\4\1\uffff\1\11\7\uffff\1\12\1\13\1\14\6\uffff\1\1\1\2\1"+
            "\3\1\5\1\6\1\7\1\10",
            "\1\4\1\uffff\1\11\7\uffff\1\12\1\13\1\14\6\uffff\1\1\1\2\1"+
            "\3\1\5\1\6\1\7\1\10",
            "\1\4\1\uffff\1\11\7\uffff\1\12\1\13\1\14\6\uffff\1\1\1\2\1"+
            "\3\1\5\1\6\1\7\1\10",
            "\1\4\1\uffff\1\11\7\uffff\1\12\1\13\1\14\6\uffff\1\1\1\2\1"+
            "\3\1\5\1\6\1\7\1\10",
            "",
            "",
            "",
            ""
    };
    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;
    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }
    class DFA25 extends DFA {
        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "209:3: ( ( () ( (this_dataType= ruleCommonModifier ) )* other= 'class' ( (this_dataType= ruleValidID ) ) (other= '<' ( (this_object= ruleJvmTypeParameter ) ) (other= ',' ( (this_object= ruleJvmTypeParameter ) ) )* other= '>' )? (other= 'extends' ( (this_object= ruleJvmParameterizedTypeReference ) ) )? (other= 'implements' ( (this_object= ruleJvmParameterizedTypeReference ) ) (other= ',' ( (this_object= ruleJvmParameterizedTypeReference ) ) )* )? other= '{' ( (this_object= ruleMember ) )* other= '}' ) | ( () ( (this_dataType= ruleCommonModifier ) )* other= 'interface' ( (this_dataType= ruleValidID ) ) (other= '<' ( (this_object= ruleJvmTypeParameter ) ) (other= ',' ( (this_object= ruleJvmTypeParameter ) ) )* other= '>' )? (other= 'extends' ( (this_object= ruleJvmParameterizedTypeReference ) ) (other= ',' ( (this_object= ruleJvmParameterizedTypeReference ) ) )* )? other= '{' ( (this_object= ruleMember ) )* other= '}' ) | ( () ( (this_dataType= ruleCommonModifier ) )* other= 'enum' ( (this_dataType= ruleValidID ) ) other= '{' ( ( (this_object= ruleXtendEnumLiteral ) ) (other= ',' ( (this_object= ruleXtendEnumLiteral ) ) )* )? (other= ';' )? other= '}' ) | ( () ( (this_dataType= ruleCommonModifier ) )* other= 'annotation' ( (this_dataType= ruleValidID ) ) other= '{' ( (this_object= ruleAnnotationField ) )* other= '}' ) )";
        }
    }
    static final String DFA29_eotS =
        "\17\uffff";
    static final String DFA29_eofS =
        "\1\uffff\3\10\1\uffff\3\4\7\uffff";
    static final String DFA29_minS =
        "\4\4\1\uffff\3\4\1\uffff\6\4";
    static final String DFA29_maxS =
        "\1\117\3\136\1\uffff\3\136\1\uffff\6\136";
    static final String DFA29_acceptS =
        "\4\uffff\1\1\3\uffff\1\2\6\uffff";
    static final String DFA29_specialS =
        "\17\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\1\33\uffff\1\3\2\uffff\1\4\16\uffff\1\2\34\uffff\1\4",
            "\1\5\17\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\7\1\10"+
            "\1\uffff\1\10\3\uffff\11\10\2\uffff\1\6\14\uffff\1\10\17\uffff"+
            "\1\10\12\uffff\1\4\3\uffff\1\4",
            "\1\5\17\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\7\1\10"+
            "\1\uffff\1\10\3\uffff\11\10\2\uffff\1\6\14\uffff\1\10\17\uffff"+
            "\1\10\12\uffff\1\4\3\uffff\1\4",
            "\1\5\17\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\7\1\10"+
            "\1\uffff\1\10\3\uffff\11\10\2\uffff\1\6\14\uffff\1\10\17\uffff"+
            "\1\10\12\uffff\1\4\3\uffff\1\4",
            "",
            "\1\11\17\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\1"+
            "\4\1\uffff\1\4\3\uffff\11\4\2\uffff\1\12\14\uffff\1\4\17\uffff"+
            "\1\4\12\uffff\1\10\3\uffff\1\10",
            "\1\11\17\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\1"+
            "\4\1\uffff\1\4\3\uffff\11\4\2\uffff\1\12\14\uffff\1\4\17\uffff"+
            "\1\4\12\uffff\1\10\3\uffff\1\10",
            "\1\11\17\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\1"+
            "\4\1\uffff\1\4\3\uffff\11\4\2\uffff\1\12\14\uffff\1\4\17\uffff"+
            "\1\4\12\uffff\1\10\3\uffff\1\10",
            "",
            "\1\14\17\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\16\1"+
            "\10\1\uffff\1\10\3\uffff\11\10\2\uffff\1\15\14\uffff\1\10\17"+
            "\uffff\1\10\12\uffff\1\4\3\uffff\1\4",
            "\1\14\17\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\16\1"+
            "\10\1\uffff\1\10\3\uffff\11\10\2\uffff\1\15\14\uffff\1\10\17"+
            "\uffff\1\10\12\uffff\1\4\3\uffff\1\4",
            "\1\14\17\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\16\1"+
            "\10\1\uffff\1\10\3\uffff\11\10\2\uffff\1\15\14\uffff\1\10\17"+
            "\uffff\1\10\12\uffff\1\4\3\uffff\1\4",
            "\1\11\17\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\1"+
            "\4\1\uffff\1\4\3\uffff\11\4\2\uffff\1\12\14\uffff\1\4\17\uffff"+
            "\1\4\12\uffff\1\10\3\uffff\1\10",
            "\1\11\17\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\1"+
            "\4\1\uffff\1\4\3\uffff\11\4\2\uffff\1\12\14\uffff\1\4\17\uffff"+
            "\1\4\12\uffff\1\10\3\uffff\1\10",
            "\1\11\17\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\1"+
            "\4\1\uffff\1\4\3\uffff\11\4\2\uffff\1\12\14\uffff\1\4\17\uffff"+
            "\1\4\12\uffff\1\10\3\uffff\1\10"
    };
    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;
    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }
    class DFA29 extends DFA {
        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "837:3: ( (this_object= ruleJvmTypeReference ) )?";
        }
    }
    static final String DFA62_eotS =
        "\14\uffff";
    static final String DFA62_eofS =
        "\14\uffff";
    static final String DFA62_minS =
        "\11\4\3\uffff";
    static final String DFA62_maxS =
        "\11\117\3\uffff";
    static final String DFA62_acceptS =
        "\11\uffff\1\1\1\2\1\3";
    static final String DFA62_specialS =
        "\14\uffff}>";
    static final String[] DFA62_transitionS = {
            "\1\11\17\uffff\1\4\13\uffff\1\11\1\uffff\2\11\2\uffff\1\13\1"+
            "\1\1\2\1\3\1\5\1\6\1\7\1\10\2\11\2\12\1\11\34\uffff\1\11",
            "\1\11\17\uffff\1\4\13\uffff\1\11\1\uffff\2\11\2\uffff\1\13"+
            "\1\1\1\2\1\3\1\5\1\6\1\7\1\10\2\11\2\12\1\11\34\uffff\1\11",
            "\1\11\17\uffff\1\4\13\uffff\1\11\1\uffff\2\11\2\uffff\1\13"+
            "\1\1\1\2\1\3\1\5\1\6\1\7\1\10\2\11\2\12\1\11\34\uffff\1\11",
            "\1\11\17\uffff\1\4\13\uffff\1\11\1\uffff\2\11\2\uffff\1\13"+
            "\1\1\1\2\1\3\1\5\1\6\1\7\1\10\2\11\2\12\1\11\34\uffff\1\11",
            "\1\11\17\uffff\1\4\13\uffff\1\11\1\uffff\2\11\2\uffff\1\13"+
            "\1\1\1\2\1\3\1\5\1\6\1\7\1\10\2\11\2\12\1\11\34\uffff\1\11",
            "\1\11\17\uffff\1\4\13\uffff\1\11\1\uffff\2\11\2\uffff\1\13"+
            "\1\1\1\2\1\3\1\5\1\6\1\7\1\10\2\11\2\12\1\11\34\uffff\1\11",
            "\1\11\17\uffff\1\4\13\uffff\1\11\1\uffff\2\11\2\uffff\1\13"+
            "\1\1\1\2\1\3\1\5\1\6\1\7\1\10\2\11\2\12\1\11\34\uffff\1\11",
            "\1\11\17\uffff\1\4\13\uffff\1\11\1\uffff\2\11\2\uffff\1\13"+
            "\1\1\1\2\1\3\1\5\1\6\1\7\1\10\2\11\2\12\1\11\34\uffff\1\11",
            "\1\11\17\uffff\1\4\13\uffff\1\11\1\uffff\2\11\2\uffff\1\13"+
            "\1\1\1\2\1\3\1\5\1\6\1\7\1\10\2\11\2\12\1\11\34\uffff\1\11",
            "",
            "",
            ""
    };
    static final short[] DFA62_eot = DFA.unpackEncodedString(DFA62_eotS);
    static final short[] DFA62_eof = DFA.unpackEncodedString(DFA62_eofS);
    static final char[] DFA62_min = DFA.unpackEncodedStringToUnsignedChars(DFA62_minS);
    static final char[] DFA62_max = DFA.unpackEncodedStringToUnsignedChars(DFA62_maxS);
    static final short[] DFA62_accept = DFA.unpackEncodedString(DFA62_acceptS);
    static final short[] DFA62_special = DFA.unpackEncodedString(DFA62_specialS);
    static final short[][] DFA62_transition;
    static {
        int numStates = DFA62_transitionS.length;
        DFA62_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA62_transition[i] = DFA.unpackEncodedString(DFA62_transitionS[i]);
        }
    }
    class DFA62 extends DFA {
        public DFA62(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 62;
            this.eot = DFA62_eot;
            this.eof = DFA62_eof;
            this.min = DFA62_min;
            this.max = DFA62_max;
            this.accept = DFA62_accept;
            this.special = DFA62_special;
            this.transition = DFA62_transition;
        }
        public String getDescription() {
            return "990:3: ( ( () ( (this_dataType= ruleCommonModifier ) )* ( ( ( (this_dataType= ruleFieldModifier ) ) ( (this_dataType= ruleCommonModifier ) )* ( (this_object= ruleJvmTypeReference ) )? ( (this_dataType= ruleValidID ) ) ) | ( ( (other= 'extension' ) ) ( ( (this_dataType= ruleFieldModifier ) ) | ( (this_dataType= ruleCommonModifier ) ) )* ( (this_object= ruleJvmTypeReference ) ) ( (this_dataType= ruleValidID ) )? ) | ( ( (this_dataType= ruleFieldModifier ) ) ( (this_dataType= ruleCommonModifier ) )* ( (other= 'extension' ) ) ( (this_dataType= ruleCommonModifier ) )* ( (this_object= ruleJvmTypeReference ) ) ( (this_dataType= ruleValidID ) )? ) | ( ( (this_object= ruleJvmTypeReference ) ) ( (this_dataType= ruleValidID ) ) ) ) (other= '=' ( (this_object= ruleXExpression ) ) )? (other= ';' )? ) | ( () ( (this_dataType= ruleCommonModifier ) )* ( (this_dataType= ruleMethodModifier ) ) ( ( (this_dataType= ruleCommonModifier ) ) | ( (this_dataType= ruleMethodModifier ) ) )* (other= '<' ( (this_object= ruleJvmTypeParameter ) ) (other= ',' ( (this_object= ruleJvmTypeParameter ) ) )* other= '>' )? ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleCreateExtensionInfo ) ) ( ( ruleValidID ) ) '(' ) )=> ( ( (this_object= ruleJvmTypeReference ) ) ( (this_object= ruleCreateExtensionInfo ) ) ( (this_dataType= ruleValidID ) ) other= '(' ) ) | ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) '(' ) )=> ( ( (this_object= ruleJvmTypeReference ) ) ( (this_dataType= ruleValidID ) ) other= '(' ) ) | ( ( ( ( ( ruleCreateExtensionInfo ) ) ( ( ruleValidID ) ) '(' ) )=> ( ( (this_object= ruleCreateExtensionInfo ) ) ( (this_dataType= ruleValidID ) ) other= '(' ) ) | ( ( (this_dataType= ruleValidID ) ) other= '(' ) ) ( ( (this_object= ruleParameter ) ) (other= ',' ( (this_object= ruleParameter ) ) )* )? other= ')' (other= 'throws' ( (this_object= ruleJvmTypeReference ) ) (other= ',' ( (this_object= ruleJvmTypeReference ) ) )* )? ( ( (this_object= ruleXBlockExpression ) ) | ( (this_object= ruleRichString ) ) | other= ';' )? ) | ( () ( (this_dataType= ruleCommonModifier ) )* other= 'new' (other= '<' ( (this_object= ruleJvmTypeParameter ) ) (other= ',' ( (this_object= ruleJvmTypeParameter ) ) )* other= '>' )? other= '(' ( ( (this_object= ruleParameter ) ) (other= ',' ( (this_object= ruleParameter ) ) )* )? other= ')' (other= 'throws' ( (this_object= ruleJvmTypeReference ) ) (other= ',' ( (this_object= ruleJvmTypeReference ) ) )* )? ( (this_object= ruleXBlockExpression ) ) ) )";
        }
    }
    static final String DFA42_eotS =
        "\17\uffff";
    static final String DFA42_eofS =
        "\17\uffff";
    static final String DFA42_minS =
        "\3\4\2\uffff\10\4\2\uffff";
    static final String DFA42_maxS =
        "\3\117\2\uffff\10\117\2\uffff";
    static final String DFA42_acceptS =
        "\3\uffff\1\2\1\4\10\uffff\1\3\1\1";
    static final String DFA42_specialS =
        "\17\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\4\33\uffff\1\4\1\uffff\1\3\1\4\12\uffff\1\1\1\2\2\uffff\1"+
            "\4\34\uffff\1\4",
            "\1\16\17\uffff\1\10\13\uffff\1\16\1\uffff\1\15\1\16\3\uffff"+
            "\1\5\1\6\1\7\1\11\1\12\1\13\1\14\4\uffff\1\16\34\uffff\1\16",
            "\1\16\17\uffff\1\10\13\uffff\1\16\1\uffff\1\15\1\16\3\uffff"+
            "\1\5\1\6\1\7\1\11\1\12\1\13\1\14\4\uffff\1\16\34\uffff\1\16",
            "",
            "",
            "\1\16\17\uffff\1\10\13\uffff\1\16\1\uffff\1\15\1\16\3\uffff"+
            "\1\5\1\6\1\7\1\11\1\12\1\13\1\14\4\uffff\1\16\34\uffff\1\16",
            "\1\16\17\uffff\1\10\13\uffff\1\16\1\uffff\1\15\1\16\3\uffff"+
            "\1\5\1\6\1\7\1\11\1\12\1\13\1\14\4\uffff\1\16\34\uffff\1\16",
            "\1\16\17\uffff\1\10\13\uffff\1\16\1\uffff\1\15\1\16\3\uffff"+
            "\1\5\1\6\1\7\1\11\1\12\1\13\1\14\4\uffff\1\16\34\uffff\1\16",
            "\1\16\17\uffff\1\10\13\uffff\1\16\1\uffff\1\15\1\16\3\uffff"+
            "\1\5\1\6\1\7\1\11\1\12\1\13\1\14\4\uffff\1\16\34\uffff\1\16",
            "\1\16\17\uffff\1\10\13\uffff\1\16\1\uffff\1\15\1\16\3\uffff"+
            "\1\5\1\6\1\7\1\11\1\12\1\13\1\14\4\uffff\1\16\34\uffff\1\16",
            "\1\16\17\uffff\1\10\13\uffff\1\16\1\uffff\1\15\1\16\3\uffff"+
            "\1\5\1\6\1\7\1\11\1\12\1\13\1\14\4\uffff\1\16\34\uffff\1\16",
            "\1\16\17\uffff\1\10\13\uffff\1\16\1\uffff\1\15\1\16\3\uffff"+
            "\1\5\1\6\1\7\1\11\1\12\1\13\1\14\4\uffff\1\16\34\uffff\1\16",
            "\1\16\17\uffff\1\10\13\uffff\1\16\1\uffff\1\15\1\16\3\uffff"+
            "\1\5\1\6\1\7\1\11\1\12\1\13\1\14\4\uffff\1\16\34\uffff\1\16",
            "",
            ""
    };
    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;
    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }
    class DFA42 extends DFA {
        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "1015:3: ( ( ( (this_dataType= ruleFieldModifier ) ) ( (this_dataType= ruleCommonModifier ) )* ( (this_object= ruleJvmTypeReference ) )? ( (this_dataType= ruleValidID ) ) ) | ( ( (other= 'extension' ) ) ( ( (this_dataType= ruleFieldModifier ) ) | ( (this_dataType= ruleCommonModifier ) ) )* ( (this_object= ruleJvmTypeReference ) ) ( (this_dataType= ruleValidID ) )? ) | ( ( (this_dataType= ruleFieldModifier ) ) ( (this_dataType= ruleCommonModifier ) )* ( (other= 'extension' ) ) ( (this_dataType= ruleCommonModifier ) )* ( (this_object= ruleJvmTypeReference ) ) ( (this_dataType= ruleValidID ) )? ) | ( ( (this_object= ruleJvmTypeReference ) ) ( (this_dataType= ruleValidID ) ) ) )";
        }
    }
    static final String DFA36_eotS =
        "\17\uffff";
    static final String DFA36_eofS =
        "\1\uffff\3\5\2\uffff\3\4\6\uffff";
    static final String DFA36_minS =
        "\4\4\2\uffff\11\4";
    static final String DFA36_maxS =
        "\1\117\3\136\2\uffff\11\136";
    static final String DFA36_acceptS =
        "\4\uffff\1\1\1\2\11\uffff";
    static final String DFA36_specialS =
        "\17\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\1\33\uffff\1\3\2\uffff\1\4\16\uffff\1\2\34\uffff\1\4",
            "\1\6\17\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\17\uffff\1\5\12\uffff\1\4\3\uffff"+
            "\1\4",
            "\1\6\17\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\17\uffff\1\5\12\uffff\1\4\3\uffff"+
            "\1\4",
            "\1\6\17\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\17\uffff\1\5\12\uffff\1\4\3\uffff"+
            "\1\4",
            "",
            "",
            "\1\11\17\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\17\uffff\1\4\12\uffff\1\5\3"+
            "\uffff\1\5",
            "\1\11\17\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\17\uffff\1\4\12\uffff\1\5\3"+
            "\uffff\1\5",
            "\1\11\17\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\17\uffff\1\4\12\uffff\1\5\3"+
            "\uffff\1\5",
            "\1\14\17\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\16\3\5"+
            "\2\uffff\14\5\1\15\14\uffff\1\5\17\uffff\1\5\12\uffff\1\4\3"+
            "\uffff\1\4",
            "\1\14\17\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\16\3\5"+
            "\2\uffff\14\5\1\15\14\uffff\1\5\17\uffff\1\5\12\uffff\1\4\3"+
            "\uffff\1\4",
            "\1\14\17\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\16\3\5"+
            "\2\uffff\14\5\1\15\14\uffff\1\5\17\uffff\1\5\12\uffff\1\4\3"+
            "\uffff\1\4",
            "\1\11\17\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\17\uffff\1\4\12\uffff\1\5\3"+
            "\uffff\1\5",
            "\1\11\17\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\17\uffff\1\4\12\uffff\1\5\3"+
            "\uffff\1\5",
            "\1\11\17\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\17\uffff\1\4\12\uffff\1\5\3"+
            "\uffff\1\5"
    };
    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;
    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }
    class DFA36 extends DFA {
        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "1051:3: ( (this_object= ruleJvmTypeReference ) )?";
        }
    }
    static final String DFA38_eotS =
        "\14\uffff";
    static final String DFA38_eofS =
        "\1\4\3\5\10\uffff";
    static final String DFA38_minS =
        "\4\4\2\uffff\6\4";
    static final String DFA38_maxS =
        "\1\117\3\136\2\uffff\6\136";
    static final String DFA38_acceptS =
        "\4\uffff\1\2\1\1\6\uffff";
    static final String DFA38_specialS =
        "\14\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\1\17\uffff\2\4\7\uffff\1\4\2\uffff\1\3\3\4\2\uffff\14\4\1"+
            "\2\14\uffff\1\4\17\uffff\1\4",
            "\1\6\17\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\17\uffff\1\5\12\uffff\1\4\3\uffff"+
            "\1\4",
            "\1\6\17\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\17\uffff\1\5\12\uffff\1\4\3\uffff"+
            "\1\4",
            "\1\6\17\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\17\uffff\1\5\12\uffff\1\4\3\uffff"+
            "\1\4",
            "",
            "",
            "\1\11\17\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\17\uffff\1\4\12\uffff\1\5\3"+
            "\uffff\1\5",
            "\1\11\17\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\17\uffff\1\4\12\uffff\1\5\3"+
            "\uffff\1\5",
            "\1\11\17\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\17\uffff\1\4\12\uffff\1\5\3"+
            "\uffff\1\5",
            "\1\6\17\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\17\uffff\1\5\12\uffff\1\4\3\uffff"+
            "\1\4",
            "\1\6\17\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\17\uffff\1\5\12\uffff\1\4\3\uffff"+
            "\1\4",
            "\1\6\17\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\17\uffff\1\5\12\uffff\1\4\3\uffff"+
            "\1\4"
    };
    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;
    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }
    class DFA38 extends DFA {
        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "1158:2: ( (this_dataType= ruleValidID ) )?";
        }
    }
    static final String DFA41_eotS =
        "\14\uffff";
    static final String DFA41_eofS =
        "\1\4\3\5\10\uffff";
    static final String DFA41_minS =
        "\4\4\2\uffff\6\4";
    static final String DFA41_maxS =
        "\1\117\3\136\2\uffff\6\136";
    static final String DFA41_acceptS =
        "\4\uffff\1\2\1\1\6\uffff";
    static final String DFA41_specialS =
        "\14\uffff}>";
    static final String[] DFA41_transitionS = {
            "\1\1\17\uffff\2\4\7\uffff\1\4\2\uffff\1\3\3\4\2\uffff\14\4\1"+
            "\2\14\uffff\1\4\17\uffff\1\4",
            "\1\6\17\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\17\uffff\1\5\12\uffff\1\4\3\uffff"+
            "\1\4",
            "\1\6\17\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\17\uffff\1\5\12\uffff\1\4\3\uffff"+
            "\1\4",
            "\1\6\17\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\17\uffff\1\5\12\uffff\1\4\3\uffff"+
            "\1\4",
            "",
            "",
            "\1\11\17\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\17\uffff\1\4\12\uffff\1\5\3"+
            "\uffff\1\5",
            "\1\11\17\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\17\uffff\1\4\12\uffff\1\5\3"+
            "\uffff\1\5",
            "\1\11\17\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\17\uffff\1\4\12\uffff\1\5\3"+
            "\uffff\1\5",
            "\1\6\17\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\17\uffff\1\5\12\uffff\1\4\3\uffff"+
            "\1\4",
            "\1\6\17\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\17\uffff\1\5\12\uffff\1\4\3\uffff"+
            "\1\4",
            "\1\6\17\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\17\uffff\1\5\12\uffff\1\4\3\uffff"+
            "\1\4"
    };
    static final short[] DFA41_eot = DFA.unpackEncodedString(DFA41_eotS);
    static final short[] DFA41_eof = DFA.unpackEncodedString(DFA41_eofS);
    static final char[] DFA41_min = DFA.unpackEncodedStringToUnsignedChars(DFA41_minS);
    static final char[] DFA41_max = DFA.unpackEncodedStringToUnsignedChars(DFA41_maxS);
    static final short[] DFA41_accept = DFA.unpackEncodedString(DFA41_acceptS);
    static final short[] DFA41_special = DFA.unpackEncodedString(DFA41_specialS);
    static final short[][] DFA41_transition;
    static {
        int numStates = DFA41_transitionS.length;
        DFA41_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA41_transition[i] = DFA.unpackEncodedString(DFA41_transitionS[i]);
        }
    }
    class DFA41 extends DFA {
        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = DFA41_eot;
            this.eof = DFA41_eof;
            this.min = DFA41_min;
            this.max = DFA41_max;
            this.accept = DFA41_accept;
            this.special = DFA41_special;
            this.transition = DFA41_transition;
        }
        public String getDescription() {
            return "1264:2: ( (this_dataType= ruleValidID ) )?";
        }
    }
    static final String DFA49_eotS =
        "\12\uffff";
    static final String DFA49_eofS =
        "\12\uffff";
    static final String DFA49_minS =
        "\1\4\5\0\4\uffff";
    static final String DFA49_maxS =
        "\1\117\5\0\4\uffff";
    static final String DFA49_acceptS =
        "\6\uffff\1\1\1\2\1\4\1\3";
    static final String DFA49_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\4\uffff}>";
    static final String[] DFA49_transitionS = {
            "\1\1\33\uffff\1\3\2\uffff\1\4\16\uffff\1\2\34\uffff\1\5",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            ""
    };
    static final short[] DFA49_eot = DFA.unpackEncodedString(DFA49_eotS);
    static final short[] DFA49_eof = DFA.unpackEncodedString(DFA49_eofS);
    static final char[] DFA49_min = DFA.unpackEncodedStringToUnsignedChars(DFA49_minS);
    static final char[] DFA49_max = DFA.unpackEncodedStringToUnsignedChars(DFA49_maxS);
    static final short[] DFA49_accept = DFA.unpackEncodedString(DFA49_acceptS);
    static final short[] DFA49_special = DFA.unpackEncodedString(DFA49_specialS);
    static final short[][] DFA49_transition;
    static {
        int numStates = DFA49_transitionS.length;
        DFA49_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA49_transition[i] = DFA.unpackEncodedString(DFA49_transitionS[i]);
        }
    }
    class DFA49 extends DFA {
        public DFA49(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 49;
            this.eot = DFA49_eot;
            this.eof = DFA49_eof;
            this.min = DFA49_min;
            this.max = DFA49_max;
            this.accept = DFA49_accept;
            this.special = DFA49_special;
            this.transition = DFA49_transition;
        }
        public String getDescription() {
            return "1474:3: ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleCreateExtensionInfo ) ) ( ( ruleValidID ) ) '(' ) )=> ( ( (this_object= ruleJvmTypeReference ) ) ( (this_object= ruleCreateExtensionInfo ) ) ( (this_dataType= ruleValidID ) ) other= '(' ) ) | ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) '(' ) )=> ( ( (this_object= ruleJvmTypeReference ) ) ( (this_dataType= ruleValidID ) ) other= '(' ) ) | ( ( ( ( ( ruleCreateExtensionInfo ) ) ( ( ruleValidID ) ) '(' ) )=> ( ( (this_object= ruleCreateExtensionInfo ) ) ( (this_dataType= ruleValidID ) ) other= '(' ) ) | ( ( (this_dataType= ruleValidID ) ) other= '(' ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA49_1 = input.LA(1);
                        int index49_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalXtend()) ) {s = 6;}
                        else if ( (synpred2_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index49_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA49_2 = input.LA(1);
                        int index49_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalXtend()) ) {s = 6;}
                        else if ( (synpred2_InternalXtend()) ) {s = 7;}
                        else if ( (synpred3_InternalXtend()) ) {s = 9;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index49_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA49_3 = input.LA(1);
                        int index49_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalXtend()) ) {s = 6;}
                        else if ( (synpred2_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index49_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA49_4 = input.LA(1);
                        int index49_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalXtend()) ) {s = 6;}
                        else if ( (synpred2_InternalXtend()) ) {s = 7;}
                        input.seek(index49_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA49_5 = input.LA(1);
                        int index49_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalXtend()) ) {s = 6;}
                        else if ( (synpred2_InternalXtend()) ) {s = 7;}
                        input.seek(index49_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 49, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA99_eotS =
        "\37\uffff";
    static final String DFA99_eofS =
        "\1\2\36\uffff";
    static final String DFA99_minS =
        "\1\4\1\0\35\uffff";
    static final String DFA99_maxS =
        "\1\117\1\0\35\uffff";
    static final String DFA99_acceptS =
        "\2\uffff\1\2\33\uffff\1\1";
    static final String DFA99_specialS =
        "\1\uffff\1\0\35\uffff}>";
    static final String[] DFA99_transitionS = {
            "\1\2\17\uffff\3\2\1\uffff\1\2\4\uffff\4\2\1\uffff\1\2\1\1\1"+
            "\2\1\uffff\15\2\14\uffff\2\2\16\uffff\1\2",
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
            ""
    };
    static final short[] DFA99_eot = DFA.unpackEncodedString(DFA99_eotS);
    static final short[] DFA99_eof = DFA.unpackEncodedString(DFA99_eofS);
    static final char[] DFA99_min = DFA.unpackEncodedStringToUnsignedChars(DFA99_minS);
    static final char[] DFA99_max = DFA.unpackEncodedStringToUnsignedChars(DFA99_maxS);
    static final short[] DFA99_accept = DFA.unpackEncodedString(DFA99_acceptS);
    static final short[] DFA99_special = DFA.unpackEncodedString(DFA99_specialS);
    static final short[][] DFA99_transition;
    static {
        int numStates = DFA99_transitionS.length;
        DFA99_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA99_transition[i] = DFA.unpackEncodedString(DFA99_transitionS[i]);
        }
    }
    class DFA99 extends DFA {
        public DFA99(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 99;
            this.eot = DFA99_eot;
            this.eof = DFA99_eof;
            this.min = DFA99_min;
            this.max = DFA99_max;
            this.accept = DFA99_accept;
            this.special = DFA99_special;
            this.transition = DFA99_transition;
        }
        public String getDescription() {
            return "4074:2: ( ( ( '(' )=>other= '(' ) ( ( ( (this_object= ruleXAnnotationElementValuePair ) ) (other= ',' ( (this_object= ruleXAnnotationElementValuePair ) ) )* ) | ( (this_object= ruleXAnnotationElementValue ) ) )? other= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA99_1 = input.LA(1);
                        int index99_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalXtend()) ) {s = 30;}
                        else if ( (true) ) {s = 2;}
                        input.seek(index99_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 99, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA104_eotS =
        "\30\uffff";
    static final String DFA104_eofS =
        "\1\uffff\25\26\2\uffff";
    static final String DFA104_minS =
        "\26\4\2\uffff";
    static final String DFA104_maxS =
        "\1\161\25\163\2\uffff";
    static final String DFA104_acceptS =
        "\26\uffff\1\2\1\1";
    static final String DFA104_specialS =
        "\30\uffff}>";
    static final String[] DFA104_transitionS = {
            "\1\1\3\26\4\uffff\3\26\5\uffff\1\20\1\uffff\1\4\1\26\2\uffff"+
            "\1\11\1\14\1\26\1\uffff\1\16\1\10\1\3\1\uffff\1\12\1\26\1\uffff"+
            "\1\25\1\26\1\21\1\22\1\23\1\2\1\24\1\7\1\13\2\uffff\1\6\1\17"+
            "\1\5\1\uffff\1\15\13\uffff\1\26\22\uffff\1\26\4\uffff\1\26\4"+
            "\uffff\2\26\2\uffff\1\26\1\uffff\1\26\2\uffff\4\26\1\uffff\7"+
            "\26",
            "\13\26\5\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\23\26",
            "\13\26\5\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\11\26\1\uffff\11\26",
            "\13\26\5\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\23\26",
            "\13\26\5\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\11\26\1\uffff\11\26",
            "\13\26\5\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\23\26",
            "\13\26\5\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\11\26\1\uffff\11\26",
            "\13\26\5\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\11\26\1\uffff\11\26",
            "\13\26\5\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\11\26\1\uffff\11\26",
            "\13\26\5\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\11\26\1\uffff\11\26",
            "\13\26\5\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\11\26\1\uffff\11\26",
            "\13\26\5\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\11\26\1\uffff\11\26",
            "\13\26\5\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\11\26\1\uffff\11\26",
            "\13\26\5\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\11\26\1\uffff\11\26",
            "\13\26\5\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\11\26\1\uffff\11\26",
            "\13\26\5\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\11\26\1\uffff\11\26",
            "\13\26\5\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\11\26\1\uffff\11\26",
            "\13\26\5\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\11\26\1\uffff\11\26",
            "\13\26\5\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\11\26\1\uffff\11\26",
            "\13\26\5\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\11\26\1\uffff\11\26",
            "\13\26\5\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\11\26\1\uffff\11\26",
            "\13\26\5\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\11\26\1\uffff\11\26",
            "",
            ""
    };
    static final short[] DFA104_eot = DFA.unpackEncodedString(DFA104_eotS);
    static final short[] DFA104_eof = DFA.unpackEncodedString(DFA104_eofS);
    static final char[] DFA104_min = DFA.unpackEncodedStringToUnsignedChars(DFA104_minS);
    static final char[] DFA104_max = DFA.unpackEncodedStringToUnsignedChars(DFA104_maxS);
    static final short[] DFA104_accept = DFA.unpackEncodedString(DFA104_acceptS);
    static final short[] DFA104_special = DFA.unpackEncodedString(DFA104_specialS);
    static final short[][] DFA104_transition;
    static {
        int numStates = DFA104_transitionS.length;
        DFA104_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA104_transition[i] = DFA.unpackEncodedString(DFA104_transitionS[i]);
        }
    }
    class DFA104 extends DFA {
        public DFA104(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 104;
            this.eot = DFA104_eot;
            this.eof = DFA104_eof;
            this.min = DFA104_min;
            this.max = DFA104_max;
            this.accept = DFA104_accept;
            this.special = DFA104_special;
            this.transition = DFA104_transition;
        }
        public String getDescription() {
            return "4535:1: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (this_object= ruleXAssignment ) ) ) | (this_object= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (this_object= ruleXAssignment ) ) )? ) )";
        }
    }
    static final String DFA112_eotS =
        "\14\uffff";
    static final String DFA112_eofS =
        "\1\1\13\uffff";
    static final String DFA112_minS =
        "\1\4\1\uffff\11\0\1\uffff";
    static final String DFA112_maxS =
        "\1\163\1\uffff\11\0\1\uffff";
    static final String DFA112_acceptS =
        "\1\uffff\1\2\11\uffff\1\1";
    static final String DFA112_specialS =
        "\2\uffff\1\4\1\7\1\6\1\2\1\3\1\10\1\0\1\1\1\5\1\uffff}>";
    static final String[] DFA112_transitionS = {
            "\13\1\5\uffff\3\1\1\3\1\1\1\2\7\1\1\uffff\23\1\2\uffff\3\1\5"+
            "\uffff\15\1\1\5\1\6\1\7\1\4\1\10\1\11\1\12\15\1\1\uffff\11\1"+
            "\1\uffff\11\1",
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
    static final short[] DFA112_eot = DFA.unpackEncodedString(DFA112_eotS);
    static final short[] DFA112_eof = DFA.unpackEncodedString(DFA112_eofS);
    static final char[] DFA112_min = DFA.unpackEncodedStringToUnsignedChars(DFA112_minS);
    static final char[] DFA112_max = DFA.unpackEncodedStringToUnsignedChars(DFA112_maxS);
    static final short[] DFA112_accept = DFA.unpackEncodedString(DFA112_acceptS);
    static final short[] DFA112_special = DFA.unpackEncodedString(DFA112_specialS);
    static final short[][] DFA112_transition;
    static {
        int numStates = DFA112_transitionS.length;
        DFA112_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA112_transition[i] = DFA.unpackEncodedString(DFA112_transitionS[i]);
        }
    }
    class DFA112 extends DFA {
        public DFA112(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 112;
            this.eot = DFA112_eot;
            this.eof = DFA112_eof;
            this.min = DFA112_min;
            this.max = DFA112_max;
            this.accept = DFA112_accept;
            this.special = DFA112_special;
            this.transition = DFA112_transition;
        }
        public String getDescription() {
            return "()* loopback of 5299:1: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (this_object= ruleXAdditiveExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA112_8 = input.LA(1);
                        int index112_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index112_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA112_9 = input.LA(1);
                        int index112_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index112_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA112_5 = input.LA(1);
                        int index112_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index112_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA112_6 = input.LA(1);
                        int index112_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index112_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA112_2 = input.LA(1);
                        int index112_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index112_2);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA112_10 = input.LA(1);
                        int index112_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index112_10);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA112_4 = input.LA(1);
                        int index112_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index112_4);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA112_3 = input.LA(1);
                        int index112_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index112_3);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA112_7 = input.LA(1);
                        int index112_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index112_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 112, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA115_eotS =
        "\14\uffff";
    static final String DFA115_eofS =
        "\14\uffff";
    static final String DFA115_minS =
        "\1\27\2\uffff\1\31\10\uffff";
    static final String DFA115_maxS =
        "\1\122\2\uffff\1\116\10\uffff";
    static final String DFA115_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\4\1\5\1\7\1\10\1\11\1\12\1\6\1\3";
    static final String DFA115_specialS =
        "\14\uffff}>";
    static final String[] DFA115_transitionS = {
            "\1\6\1\uffff\1\3\62\uffff\1\1\1\2\1\4\1\5\1\7\1\10\1\11",
            "",
            "",
            "\1\12\64\uffff\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final short[] DFA115_eot = DFA.unpackEncodedString(DFA115_eotS);
    static final short[] DFA115_eof = DFA.unpackEncodedString(DFA115_eofS);
    static final char[] DFA115_min = DFA.unpackEncodedStringToUnsignedChars(DFA115_minS);
    static final char[] DFA115_max = DFA.unpackEncodedStringToUnsignedChars(DFA115_maxS);
    static final short[] DFA115_accept = DFA.unpackEncodedString(DFA115_acceptS);
    static final short[] DFA115_special = DFA.unpackEncodedString(DFA115_specialS);
    static final short[][] DFA115_transition;
    static {
        int numStates = DFA115_transitionS.length;
        DFA115_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA115_transition[i] = DFA.unpackEncodedString(DFA115_transitionS[i]);
        }
    }
    class DFA115 extends DFA {
        public DFA115(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 115;
            this.eot = DFA115_eot;
            this.eof = DFA115_eof;
            this.min = DFA115_min;
            this.max = DFA115_max;
            this.accept = DFA115_accept;
            this.special = DFA115_special;
            this.transition = DFA115_transition;
        }
        public String getDescription() {
            return "5373:1: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' ) ) | kw= '<>' | kw= '?:' | kw= '<=>' )";
        }
    }
    static final String DFA128_eotS =
        "\144\uffff";
    static final String DFA128_eofS =
        "\1\2\143\uffff";
    static final String DFA128_minS =
        "\1\4\1\0\142\uffff";
    static final String DFA128_maxS =
        "\1\163\1\0\142\uffff";
    static final String DFA128_acceptS =
        "\2\uffff\1\2\140\uffff\1\1";
    static final String DFA128_specialS =
        "\1\uffff\1\0\142\uffff}>";
    static final String[] DFA128_transitionS = {
            "\13\2\5\uffff\15\2\1\uffff\1\2\1\1\21\2\2\uffff\3\2\5\uffff"+
            "\41\2\1\uffff\11\2\1\uffff\11\2",
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
    static final short[] DFA128_eot = DFA.unpackEncodedString(DFA128_eotS);
    static final short[] DFA128_eof = DFA.unpackEncodedString(DFA128_eofS);
    static final char[] DFA128_min = DFA.unpackEncodedStringToUnsignedChars(DFA128_minS);
    static final char[] DFA128_max = DFA.unpackEncodedStringToUnsignedChars(DFA128_maxS);
    static final short[] DFA128_accept = DFA.unpackEncodedString(DFA128_acceptS);
    static final short[] DFA128_special = DFA.unpackEncodedString(DFA128_specialS);
    static final short[][] DFA128_transition;
    static {
        int numStates = DFA128_transitionS.length;
        DFA128_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA128_transition[i] = DFA.unpackEncodedString(DFA128_transitionS[i]);
        }
    }
    class DFA128 extends DFA {
        public DFA128(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 128;
            this.eot = DFA128_eot;
            this.eof = DFA128_eof;
            this.min = DFA128_min;
            this.max = DFA128_max;
            this.accept = DFA128_accept;
            this.special = DFA128_special;
            this.transition = DFA128_transition;
        }
        public String getDescription() {
            return "6174:2: ( ( ( ( '(' ) )=> (other= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (this_object= ruleXShortClosure ) ) | ( ( (this_object= ruleXExpression ) ) (other= ',' ( (this_object= ruleXExpression ) ) )* ) )? other= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA128_1 = input.LA(1);
                        int index128_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 2;}
                        input.seek(index128_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 128, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA127_eotS =
        "\65\uffff";
    static final String DFA127_eofS =
        "\65\uffff";
    static final String DFA127_minS =
        "\1\4\5\0\57\uffff";
    static final String DFA127_maxS =
        "\1\161\5\0\57\uffff";
    static final String DFA127_acceptS =
        "\6\uffff\2\1\1\2\53\uffff\1\3";
    static final String DFA127_specialS =
        "\1\0\1\1\1\2\1\3\1\4\1\5\57\uffff}>";
    static final String[] DFA127_transitionS = {
            "\1\2\3\10\4\uffff\3\10\5\uffff\1\10\1\uffff\2\10\2\uffff\3\10"+
            "\1\uffff\2\10\1\4\1\uffff\1\1\1\5\1\64\11\10\2\uffff\2\10\1"+
            "\3\1\uffff\1\10\13\uffff\1\10\16\uffff\1\6\3\uffff\1\10\4\uffff"+
            "\1\10\4\uffff\2\10\1\uffff\1\7\1\10\1\uffff\1\10\2\uffff\4\10"+
            "\1\uffff\7\10",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
    static final short[] DFA127_eot = DFA.unpackEncodedString(DFA127_eotS);
    static final short[] DFA127_eof = DFA.unpackEncodedString(DFA127_eofS);
    static final char[] DFA127_min = DFA.unpackEncodedStringToUnsignedChars(DFA127_minS);
    static final char[] DFA127_max = DFA.unpackEncodedStringToUnsignedChars(DFA127_maxS);
    static final short[] DFA127_accept = DFA.unpackEncodedString(DFA127_acceptS);
    static final short[] DFA127_special = DFA.unpackEncodedString(DFA127_specialS);
    static final short[][] DFA127_transition;
    static {
        int numStates = DFA127_transitionS.length;
        DFA127_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA127_transition[i] = DFA.unpackEncodedString(DFA127_transitionS[i]);
        }
    }
    class DFA127 extends DFA {
        public DFA127(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 127;
            this.eot = DFA127_eot;
            this.eof = DFA127_eof;
            this.min = DFA127_min;
            this.max = DFA127_max;
            this.accept = DFA127_accept;
            this.special = DFA127_special;
            this.transition = DFA127_transition;
        }
        public String getDescription() {
            return "6195:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (this_object= ruleXShortClosure ) ) | ( ( (this_object= ruleXExpression ) ) (other= ',' ( (this_object= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA127_0 = input.LA(1);
                        int index127_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA127_0==34) ) {s = 1;}
                        else if ( (LA127_0==RULE_ID) ) {s = 2;}
                        else if ( (LA127_0==50) ) {s = 3;}
                        else if ( (LA127_0==32) ) {s = 4;}
                        else if ( (LA127_0==35) ) {s = 5;}
                        else if ( (LA127_0==79) && (synpred22_InternalXtend())) {s = 6;}
                        else if ( (LA127_0==96) && (synpred22_InternalXtend())) {s = 7;}
                        else if ( ((LA127_0>=RULE_STRING && LA127_0<=RULE_RICH_TEXT_START)||(LA127_0>=RULE_HEX && LA127_0<=RULE_DECIMAL)||LA127_0==20||(LA127_0>=22 && LA127_0<=23)||(LA127_0>=26 && LA127_0<=28)||(LA127_0>=30 && LA127_0<=31)||(LA127_0>=37 && LA127_0<=45)||(LA127_0>=48 && LA127_0<=49)||LA127_0==52||LA127_0==64||LA127_0==83||LA127_0==88||(LA127_0>=93 && LA127_0<=94)||LA127_0==97||LA127_0==99||(LA127_0>=102 && LA127_0<=105)||(LA127_0>=107 && LA127_0<=113)) ) {s = 8;}
                        else if ( (LA127_0==36) ) {s = 52;}
                        input.seek(index127_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA127_1 = input.LA(1);
                        int index127_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index127_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA127_2 = input.LA(1);
                        int index127_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index127_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA127_3 = input.LA(1);
                        int index127_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index127_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA127_4 = input.LA(1);
                        int index127_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index127_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA127_5 = input.LA(1);
                        int index127_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index127_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 127, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA129_eotS =
        "\144\uffff";
    static final String DFA129_eofS =
        "\1\2\143\uffff";
    static final String DFA129_minS =
        "\1\4\1\0\142\uffff";
    static final String DFA129_maxS =
        "\1\163\1\0\142\uffff";
    static final String DFA129_acceptS =
        "\2\uffff\1\2\140\uffff\1\1";
    static final String DFA129_specialS =
        "\1\uffff\1\0\142\uffff}>";
    static final String[] DFA129_transitionS = {
            "\13\2\5\uffff\15\2\1\uffff\23\2\2\uffff\3\2\5\uffff\37\2\1\1"+
            "\1\2\1\uffff\11\2\1\uffff\11\2",
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
    static final short[] DFA129_eot = DFA.unpackEncodedString(DFA129_eotS);
    static final short[] DFA129_eof = DFA.unpackEncodedString(DFA129_eofS);
    static final char[] DFA129_min = DFA.unpackEncodedStringToUnsignedChars(DFA129_minS);
    static final char[] DFA129_max = DFA.unpackEncodedStringToUnsignedChars(DFA129_maxS);
    static final short[] DFA129_accept = DFA.unpackEncodedString(DFA129_acceptS);
    static final short[] DFA129_special = DFA.unpackEncodedString(DFA129_specialS);
    static final short[][] DFA129_transition;
    static {
        int numStates = DFA129_transitionS.length;
        DFA129_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA129_transition[i] = DFA.unpackEncodedString(DFA129_transitionS[i]);
        }
    }
    class DFA129 extends DFA {
        public DFA129(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 129;
            this.eot = DFA129_eot;
            this.eof = DFA129_eof;
            this.min = DFA129_min;
            this.max = DFA129_max;
            this.accept = DFA129_accept;
            this.special = DFA129_special;
            this.transition = DFA129_transition;
        }
        public String getDescription() {
            return "6274:3: ( ( ( () '[' ) )=> (this_object= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA129_1 = input.LA(1);
                        int index129_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 2;}
                        input.seek(index129_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 129, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA131_eotS =
        "\16\uffff";
    static final String DFA131_eofS =
        "\16\uffff";
    static final String DFA131_minS =
        "\1\4\15\uffff";
    static final String DFA131_maxS =
        "\1\161\15\uffff";
    static final String DFA131_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\15";
    static final String DFA131_specialS =
        "\16\uffff}>";
    static final String[] DFA131_transitionS = {
            "\1\4\3\5\4\uffff\3\5\5\uffff\1\4\1\uffff\2\4\2\uffff\2\4\1\2"+
            "\1\uffff\3\4\1\uffff\1\4\1\15\1\uffff\1\4\1\1\7\4\2\uffff\3"+
            "\4\1\uffff\1\4\50\uffff\2\5\2\uffff\1\6\1\uffff\1\3\2\uffff"+
            "\1\7\1\10\1\11\1\4\1\uffff\4\5\1\12\1\13\1\14",
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
    static final short[] DFA131_eot = DFA.unpackEncodedString(DFA131_eotS);
    static final short[] DFA131_eof = DFA.unpackEncodedString(DFA131_eofS);
    static final char[] DFA131_min = DFA.unpackEncodedStringToUnsignedChars(DFA131_minS);
    static final char[] DFA131_max = DFA.unpackEncodedStringToUnsignedChars(DFA131_maxS);
    static final short[] DFA131_accept = DFA.unpackEncodedString(DFA131_acceptS);
    static final short[] DFA131_special = DFA.unpackEncodedString(DFA131_specialS);
    static final short[][] DFA131_transition;
    static {
        int numStates = DFA131_transitionS.length;
        DFA131_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA131_transition[i] = DFA.unpackEncodedString(DFA131_transitionS[i]);
        }
    }
    class DFA131 extends DFA {
        public DFA131(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 131;
            this.eot = DFA131_eot;
            this.eof = DFA131_eof;
            this.min = DFA131_min;
            this.max = DFA131_max;
            this.accept = DFA131_accept;
            this.special = DFA131_special;
            this.transition = DFA131_transition;
        }
        public String getDescription() {
            return "6323:1: (this_object= ruleXConstructorCall | this_object= ruleXBlockExpression | this_object= ruleXSwitchExpression | this_object= ruleXFeatureCall | this_object= ruleXLiteral | this_object= ruleXIfExpression | this_object= ruleXForLoopExpression | this_object= ruleXWhileExpression | this_object= ruleXDoWhileExpression | this_object= ruleXThrowExpression | this_object= ruleXReturnExpression | this_object= ruleXTryCatchFinallyExpression | this_object= ruleXParenthesizedExpression )";
        }
    }
    static final String DFA140_eotS =
        "\67\uffff";
    static final String DFA140_eofS =
        "\67\uffff";
    static final String DFA140_minS =
        "\1\4\5\0\61\uffff";
    static final String DFA140_maxS =
        "\1\161\5\0\61\uffff";
    static final String DFA140_acceptS =
        "\6\uffff\2\1\1\2\56\uffff";
    static final String DFA140_specialS =
        "\1\0\1\1\1\2\1\3\1\4\1\5\61\uffff}>";
    static final String[] DFA140_transitionS = {
            "\1\2\3\10\4\uffff\3\10\5\uffff\1\10\1\uffff\2\10\2\uffff\3\10"+
            "\1\uffff\2\10\1\4\1\uffff\1\1\1\5\1\uffff\15\10\1\3\1\uffff"+
            "\1\10\13\uffff\1\10\16\uffff\1\6\3\uffff\1\10\4\uffff\1\10\4"+
            "\uffff\3\10\1\7\1\10\1\uffff\1\10\2\uffff\4\10\1\uffff\7\10",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
    static final short[] DFA140_eot = DFA.unpackEncodedString(DFA140_eotS);
    static final short[] DFA140_eof = DFA.unpackEncodedString(DFA140_eofS);
    static final char[] DFA140_min = DFA.unpackEncodedStringToUnsignedChars(DFA140_minS);
    static final char[] DFA140_max = DFA.unpackEncodedStringToUnsignedChars(DFA140_maxS);
    static final short[] DFA140_accept = DFA.unpackEncodedString(DFA140_acceptS);
    static final short[] DFA140_special = DFA.unpackEncodedString(DFA140_specialS);
    static final short[][] DFA140_transition;
    static {
        int numStates = DFA140_transitionS.length;
        DFA140_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA140_transition[i] = DFA.unpackEncodedString(DFA140_transitionS[i]);
        }
    }
    class DFA140 extends DFA {
        public DFA140(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 140;
            this.eot = DFA140_eot;
            this.eof = DFA140_eof;
            this.min = DFA140_min;
            this.max = DFA140_max;
            this.accept = DFA140_accept;
            this.special = DFA140_special;
            this.transition = DFA140_transition;
        }
        public String getDescription() {
            return "6818:3: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (this_object= ruleJvmFormalParameter ) ) (other= ',' ( (this_object= ruleJvmFormalParameter ) ) )* )? ( (other= '|' ) ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA140_0 = input.LA(1);
                        int index140_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA140_0==34) ) {s = 1;}
                        else if ( (LA140_0==RULE_ID) ) {s = 2;}
                        else if ( (LA140_0==50) ) {s = 3;}
                        else if ( (LA140_0==32) ) {s = 4;}
                        else if ( (LA140_0==35) ) {s = 5;}
                        else if ( (LA140_0==79) && (synpred26_InternalXtend())) {s = 6;}
                        else if ( (LA140_0==96) && (synpred26_InternalXtend())) {s = 7;}
                        else if ( ((LA140_0>=RULE_STRING && LA140_0<=RULE_RICH_TEXT_START)||(LA140_0>=RULE_HEX && LA140_0<=RULE_DECIMAL)||LA140_0==20||(LA140_0>=22 && LA140_0<=23)||(LA140_0>=26 && LA140_0<=28)||(LA140_0>=30 && LA140_0<=31)||(LA140_0>=37 && LA140_0<=49)||LA140_0==52||LA140_0==64||LA140_0==83||LA140_0==88||(LA140_0>=93 && LA140_0<=95)||LA140_0==97||LA140_0==99||(LA140_0>=102 && LA140_0<=105)||(LA140_0>=107 && LA140_0<=113)) ) {s = 8;}
                        input.seek(index140_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA140_1 = input.LA(1);
                        int index140_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index140_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA140_2 = input.LA(1);
                        int index140_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index140_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA140_3 = input.LA(1);
                        int index140_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index140_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA140_4 = input.LA(1);
                        int index140_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index140_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA140_5 = input.LA(1);
                        int index140_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index140_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 140, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA160_eotS =
        "\144\uffff";
    static final String DFA160_eofS =
        "\1\2\143\uffff";
    static final String DFA160_minS =
        "\1\4\1\0\142\uffff";
    static final String DFA160_maxS =
        "\1\163\1\0\142\uffff";
    static final String DFA160_acceptS =
        "\2\uffff\1\2\140\uffff\1\1";
    static final String DFA160_specialS =
        "\1\uffff\1\0\142\uffff}>";
    static final String[] DFA160_transitionS = {
            "\13\2\5\uffff\15\2\1\uffff\1\2\1\1\21\2\2\uffff\3\2\5\uffff"+
            "\41\2\1\uffff\11\2\1\uffff\11\2",
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
    static final short[] DFA160_eot = DFA.unpackEncodedString(DFA160_eotS);
    static final short[] DFA160_eof = DFA.unpackEncodedString(DFA160_eofS);
    static final char[] DFA160_min = DFA.unpackEncodedStringToUnsignedChars(DFA160_minS);
    static final char[] DFA160_max = DFA.unpackEncodedStringToUnsignedChars(DFA160_maxS);
    static final short[] DFA160_accept = DFA.unpackEncodedString(DFA160_acceptS);
    static final short[] DFA160_special = DFA.unpackEncodedString(DFA160_specialS);
    static final short[][] DFA160_transition;
    static {
        int numStates = DFA160_transitionS.length;
        DFA160_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA160_transition[i] = DFA.unpackEncodedString(DFA160_transitionS[i]);
        }
    }
    class DFA160 extends DFA {
        public DFA160(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 160;
            this.eot = DFA160_eot;
            this.eof = DFA160_eof;
            this.min = DFA160_min;
            this.max = DFA160_max;
            this.accept = DFA160_accept;
            this.special = DFA160_special;
            this.transition = DFA160_transition;
        }
        public String getDescription() {
            return "8065:2: ( ( ( ( '(' ) )=> (other= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (this_object= ruleXShortClosure ) ) | ( ( (this_object= ruleXExpression ) ) (other= ',' ( (this_object= ruleXExpression ) ) )* ) )? other= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA160_1 = input.LA(1);
                        int index160_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 2;}
                        input.seek(index160_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 160, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA159_eotS =
        "\65\uffff";
    static final String DFA159_eofS =
        "\65\uffff";
    static final String DFA159_minS =
        "\1\4\5\0\57\uffff";
    static final String DFA159_maxS =
        "\1\161\5\0\57\uffff";
    static final String DFA159_acceptS =
        "\6\uffff\2\1\1\2\53\uffff\1\3";
    static final String DFA159_specialS =
        "\1\0\1\1\1\2\1\3\1\4\1\5\57\uffff}>";
    static final String[] DFA159_transitionS = {
            "\1\2\3\10\4\uffff\3\10\5\uffff\1\10\1\uffff\2\10\2\uffff\3\10"+
            "\1\uffff\2\10\1\4\1\uffff\1\1\1\5\1\64\11\10\2\uffff\2\10\1"+
            "\3\1\uffff\1\10\13\uffff\1\10\16\uffff\1\6\3\uffff\1\10\4\uffff"+
            "\1\10\4\uffff\2\10\1\uffff\1\7\1\10\1\uffff\1\10\2\uffff\4\10"+
            "\1\uffff\7\10",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
    static final short[] DFA159_eot = DFA.unpackEncodedString(DFA159_eotS);
    static final short[] DFA159_eof = DFA.unpackEncodedString(DFA159_eofS);
    static final char[] DFA159_min = DFA.unpackEncodedStringToUnsignedChars(DFA159_minS);
    static final char[] DFA159_max = DFA.unpackEncodedStringToUnsignedChars(DFA159_maxS);
    static final short[] DFA159_accept = DFA.unpackEncodedString(DFA159_acceptS);
    static final short[] DFA159_special = DFA.unpackEncodedString(DFA159_specialS);
    static final short[][] DFA159_transition;
    static {
        int numStates = DFA159_transitionS.length;
        DFA159_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA159_transition[i] = DFA.unpackEncodedString(DFA159_transitionS[i]);
        }
    }
    class DFA159 extends DFA {
        public DFA159(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 159;
            this.eot = DFA159_eot;
            this.eof = DFA159_eof;
            this.min = DFA159_min;
            this.max = DFA159_max;
            this.accept = DFA159_accept;
            this.special = DFA159_special;
            this.transition = DFA159_transition;
        }
        public String getDescription() {
            return "8086:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (this_object= ruleXShortClosure ) ) | ( ( (this_object= ruleXExpression ) ) (other= ',' ( (this_object= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA159_0 = input.LA(1);
                        int index159_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA159_0==34) ) {s = 1;}
                        else if ( (LA159_0==RULE_ID) ) {s = 2;}
                        else if ( (LA159_0==50) ) {s = 3;}
                        else if ( (LA159_0==32) ) {s = 4;}
                        else if ( (LA159_0==35) ) {s = 5;}
                        else if ( (LA159_0==79) && (synpred33_InternalXtend())) {s = 6;}
                        else if ( (LA159_0==96) && (synpred33_InternalXtend())) {s = 7;}
                        else if ( ((LA159_0>=RULE_STRING && LA159_0<=RULE_RICH_TEXT_START)||(LA159_0>=RULE_HEX && LA159_0<=RULE_DECIMAL)||LA159_0==20||(LA159_0>=22 && LA159_0<=23)||(LA159_0>=26 && LA159_0<=28)||(LA159_0>=30 && LA159_0<=31)||(LA159_0>=37 && LA159_0<=45)||(LA159_0>=48 && LA159_0<=49)||LA159_0==52||LA159_0==64||LA159_0==83||LA159_0==88||(LA159_0>=93 && LA159_0<=94)||LA159_0==97||LA159_0==99||(LA159_0>=102 && LA159_0<=105)||(LA159_0>=107 && LA159_0<=113)) ) {s = 8;}
                        else if ( (LA159_0==36) ) {s = 52;}
                        input.seek(index159_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA159_1 = input.LA(1);
                        int index159_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index159_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA159_2 = input.LA(1);
                        int index159_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index159_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA159_3 = input.LA(1);
                        int index159_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index159_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA159_4 = input.LA(1);
                        int index159_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index159_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA159_5 = input.LA(1);
                        int index159_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index159_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 159, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA161_eotS =
        "\144\uffff";
    static final String DFA161_eofS =
        "\1\2\143\uffff";
    static final String DFA161_minS =
        "\1\4\1\0\142\uffff";
    static final String DFA161_maxS =
        "\1\163\1\0\142\uffff";
    static final String DFA161_acceptS =
        "\2\uffff\1\2\140\uffff\1\1";
    static final String DFA161_specialS =
        "\1\uffff\1\0\142\uffff}>";
    static final String[] DFA161_transitionS = {
            "\13\2\5\uffff\15\2\1\uffff\23\2\2\uffff\3\2\5\uffff\37\2\1\1"+
            "\1\2\1\uffff\11\2\1\uffff\11\2",
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
    static final short[] DFA161_eot = DFA.unpackEncodedString(DFA161_eotS);
    static final short[] DFA161_eof = DFA.unpackEncodedString(DFA161_eofS);
    static final char[] DFA161_min = DFA.unpackEncodedStringToUnsignedChars(DFA161_minS);
    static final char[] DFA161_max = DFA.unpackEncodedStringToUnsignedChars(DFA161_maxS);
    static final short[] DFA161_accept = DFA.unpackEncodedString(DFA161_acceptS);
    static final short[] DFA161_special = DFA.unpackEncodedString(DFA161_specialS);
    static final short[][] DFA161_transition;
    static {
        int numStates = DFA161_transitionS.length;
        DFA161_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA161_transition[i] = DFA.unpackEncodedString(DFA161_transitionS[i]);
        }
    }
    class DFA161 extends DFA {
        public DFA161(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 161;
            this.eot = DFA161_eot;
            this.eof = DFA161_eof;
            this.min = DFA161_min;
            this.max = DFA161_max;
            this.accept = DFA161_accept;
            this.special = DFA161_special;
            this.transition = DFA161_transition;
        }
        public String getDescription() {
            return "8165:3: ( ( ( () '[' ) )=> (this_object= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA161_1 = input.LA(1);
                        int index161_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 2;}
                        input.seek(index161_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 161, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA165_eotS =
        "\144\uffff";
    static final String DFA165_eofS =
        "\1\2\143\uffff";
    static final String DFA165_minS =
        "\1\4\1\0\142\uffff";
    static final String DFA165_maxS =
        "\1\163\1\0\142\uffff";
    static final String DFA165_acceptS =
        "\2\uffff\1\2\140\uffff\1\1";
    static final String DFA165_specialS =
        "\1\uffff\1\0\142\uffff}>";
    static final String[] DFA165_transitionS = {
            "\13\2\5\uffff\3\2\1\1\11\2\1\uffff\23\2\2\uffff\3\2\5\uffff"+
            "\41\2\1\uffff\11\2\1\uffff\11\2",
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
    static final short[] DFA165_eot = DFA.unpackEncodedString(DFA165_eotS);
    static final short[] DFA165_eof = DFA.unpackEncodedString(DFA165_eofS);
    static final char[] DFA165_min = DFA.unpackEncodedStringToUnsignedChars(DFA165_minS);
    static final char[] DFA165_max = DFA.unpackEncodedStringToUnsignedChars(DFA165_maxS);
    static final short[] DFA165_accept = DFA.unpackEncodedString(DFA165_acceptS);
    static final short[] DFA165_special = DFA.unpackEncodedString(DFA165_specialS);
    static final short[][] DFA165_transition;
    static {
        int numStates = DFA165_transitionS.length;
        DFA165_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA165_transition[i] = DFA.unpackEncodedString(DFA165_transitionS[i]);
        }
    }
    class DFA165 extends DFA {
        public DFA165(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 165;
            this.eot = DFA165_eot;
            this.eof = DFA165_eof;
            this.min = DFA165_min;
            this.max = DFA165_max;
            this.accept = DFA165_accept;
            this.special = DFA165_special;
            this.transition = DFA165_transition;
        }
        public String getDescription() {
            return "8333:2: ( ( ( '<' )=>other= '<' ) ( (this_object= ruleJvmArgumentTypeReference ) ) (other= ',' ( (this_object= ruleJvmArgumentTypeReference ) ) )* other= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA165_1 = input.LA(1);
                        int index165_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 2;}
                        input.seek(index165_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 165, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA168_eotS =
        "\144\uffff";
    static final String DFA168_eofS =
        "\1\2\143\uffff";
    static final String DFA168_minS =
        "\1\4\1\0\142\uffff";
    static final String DFA168_maxS =
        "\1\163\1\0\142\uffff";
    static final String DFA168_acceptS =
        "\2\uffff\1\2\140\uffff\1\1";
    static final String DFA168_specialS =
        "\1\uffff\1\0\142\uffff}>";
    static final String[] DFA168_transitionS = {
            "\13\2\5\uffff\15\2\1\uffff\1\2\1\1\21\2\2\uffff\3\2\5\uffff"+
            "\41\2\1\uffff\11\2\1\uffff\11\2",
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
    static final short[] DFA168_eot = DFA.unpackEncodedString(DFA168_eotS);
    static final short[] DFA168_eof = DFA.unpackEncodedString(DFA168_eofS);
    static final char[] DFA168_min = DFA.unpackEncodedStringToUnsignedChars(DFA168_minS);
    static final char[] DFA168_max = DFA.unpackEncodedStringToUnsignedChars(DFA168_maxS);
    static final short[] DFA168_accept = DFA.unpackEncodedString(DFA168_acceptS);
    static final short[] DFA168_special = DFA.unpackEncodedString(DFA168_specialS);
    static final short[][] DFA168_transition;
    static {
        int numStates = DFA168_transitionS.length;
        DFA168_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA168_transition[i] = DFA.unpackEncodedString(DFA168_transitionS[i]);
        }
    }
    class DFA168 extends DFA {
        public DFA168(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 168;
            this.eot = DFA168_eot;
            this.eof = DFA168_eof;
            this.min = DFA168_min;
            this.max = DFA168_max;
            this.accept = DFA168_accept;
            this.special = DFA168_special;
            this.transition = DFA168_transition;
        }
        public String getDescription() {
            return "8382:3: ( ( ( '(' )=>other= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (this_object= ruleXShortClosure ) ) | ( ( (this_object= ruleXExpression ) ) (other= ',' ( (this_object= ruleXExpression ) ) )* ) )? other= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA168_1 = input.LA(1);
                        int index168_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 2;}
                        input.seek(index168_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 168, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA167_eotS =
        "\65\uffff";
    static final String DFA167_eofS =
        "\65\uffff";
    static final String DFA167_minS =
        "\1\4\5\0\57\uffff";
    static final String DFA167_maxS =
        "\1\161\5\0\57\uffff";
    static final String DFA167_acceptS =
        "\6\uffff\2\1\1\2\53\uffff\1\3";
    static final String DFA167_specialS =
        "\1\0\1\1\1\2\1\3\1\4\1\5\57\uffff}>";
    static final String[] DFA167_transitionS = {
            "\1\2\3\10\4\uffff\3\10\5\uffff\1\10\1\uffff\2\10\2\uffff\3\10"+
            "\1\uffff\2\10\1\4\1\uffff\1\1\1\5\1\64\11\10\2\uffff\2\10\1"+
            "\3\1\uffff\1\10\13\uffff\1\10\16\uffff\1\6\3\uffff\1\10\4\uffff"+
            "\1\10\4\uffff\2\10\1\uffff\1\7\1\10\1\uffff\1\10\2\uffff\4\10"+
            "\1\uffff\7\10",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
    static final short[] DFA167_eot = DFA.unpackEncodedString(DFA167_eotS);
    static final short[] DFA167_eof = DFA.unpackEncodedString(DFA167_eofS);
    static final char[] DFA167_min = DFA.unpackEncodedStringToUnsignedChars(DFA167_minS);
    static final char[] DFA167_max = DFA.unpackEncodedStringToUnsignedChars(DFA167_maxS);
    static final short[] DFA167_accept = DFA.unpackEncodedString(DFA167_acceptS);
    static final short[] DFA167_special = DFA.unpackEncodedString(DFA167_specialS);
    static final short[][] DFA167_transition;
    static {
        int numStates = DFA167_transitionS.length;
        DFA167_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA167_transition[i] = DFA.unpackEncodedString(DFA167_transitionS[i]);
        }
    }
    class DFA167 extends DFA {
        public DFA167(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 167;
            this.eot = DFA167_eot;
            this.eof = DFA167_eof;
            this.min = DFA167_min;
            this.max = DFA167_max;
            this.accept = DFA167_accept;
            this.special = DFA167_special;
            this.transition = DFA167_transition;
        }
        public String getDescription() {
            return "8387:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (this_object= ruleXShortClosure ) ) | ( ( (this_object= ruleXExpression ) ) (other= ',' ( (this_object= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA167_0 = input.LA(1);
                        int index167_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA167_0==34) ) {s = 1;}
                        else if ( (LA167_0==RULE_ID) ) {s = 2;}
                        else if ( (LA167_0==50) ) {s = 3;}
                        else if ( (LA167_0==32) ) {s = 4;}
                        else if ( (LA167_0==35) ) {s = 5;}
                        else if ( (LA167_0==79) && (synpred37_InternalXtend())) {s = 6;}
                        else if ( (LA167_0==96) && (synpred37_InternalXtend())) {s = 7;}
                        else if ( ((LA167_0>=RULE_STRING && LA167_0<=RULE_RICH_TEXT_START)||(LA167_0>=RULE_HEX && LA167_0<=RULE_DECIMAL)||LA167_0==20||(LA167_0>=22 && LA167_0<=23)||(LA167_0>=26 && LA167_0<=28)||(LA167_0>=30 && LA167_0<=31)||(LA167_0>=37 && LA167_0<=45)||(LA167_0>=48 && LA167_0<=49)||LA167_0==52||LA167_0==64||LA167_0==83||LA167_0==88||(LA167_0>=93 && LA167_0<=94)||LA167_0==97||LA167_0==99||(LA167_0>=102 && LA167_0<=105)||(LA167_0>=107 && LA167_0<=113)) ) {s = 8;}
                        else if ( (LA167_0==36) ) {s = 52;}
                        input.seek(index167_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA167_1 = input.LA(1);
                        int index167_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index167_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA167_2 = input.LA(1);
                        int index167_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index167_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA167_3 = input.LA(1);
                        int index167_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index167_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA167_4 = input.LA(1);
                        int index167_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index167_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA167_5 = input.LA(1);
                        int index167_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index167_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 167, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA169_eotS =
        "\144\uffff";
    static final String DFA169_eofS =
        "\1\2\143\uffff";
    static final String DFA169_minS =
        "\1\4\1\0\142\uffff";
    static final String DFA169_maxS =
        "\1\163\1\0\142\uffff";
    static final String DFA169_acceptS =
        "\2\uffff\1\2\140\uffff\1\1";
    static final String DFA169_specialS =
        "\1\uffff\1\0\142\uffff}>";
    static final String[] DFA169_transitionS = {
            "\13\2\5\uffff\15\2\1\uffff\23\2\2\uffff\3\2\5\uffff\37\2\1\1"+
            "\1\2\1\uffff\11\2\1\uffff\11\2",
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
    static final short[] DFA169_eot = DFA.unpackEncodedString(DFA169_eotS);
    static final short[] DFA169_eof = DFA.unpackEncodedString(DFA169_eofS);
    static final char[] DFA169_min = DFA.unpackEncodedStringToUnsignedChars(DFA169_minS);
    static final char[] DFA169_max = DFA.unpackEncodedStringToUnsignedChars(DFA169_maxS);
    static final short[] DFA169_accept = DFA.unpackEncodedString(DFA169_acceptS);
    static final short[] DFA169_special = DFA.unpackEncodedString(DFA169_specialS);
    static final short[][] DFA169_transition;
    static {
        int numStates = DFA169_transitionS.length;
        DFA169_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA169_transition[i] = DFA.unpackEncodedString(DFA169_transitionS[i]);
        }
    }
    class DFA169 extends DFA {
        public DFA169(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 169;
            this.eot = DFA169_eot;
            this.eof = DFA169_eof;
            this.min = DFA169_min;
            this.max = DFA169_max;
            this.accept = DFA169_accept;
            this.special = DFA169_special;
            this.transition = DFA169_transition;
        }
        public String getDescription() {
            return "8466:3: ( ( ( () '[' ) )=> (this_object= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA169_1 = input.LA(1);
                        int index169_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 2;}
                        input.seek(index169_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 169, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA172_eotS =
        "\144\uffff";
    static final String DFA172_eofS =
        "\1\62\143\uffff";
    static final String DFA172_minS =
        "\1\4\61\0\62\uffff";
    static final String DFA172_maxS =
        "\1\163\61\0\62\uffff";
    static final String DFA172_acceptS =
        "\62\uffff\1\2\60\uffff\1\1";
    static final String DFA172_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31"+
        "\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46"+
        "\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\62\uffff}>";
    static final String[] DFA172_transitionS = {
            "\1\1\1\46\1\47\1\50\4\62\1\42\1\43\1\44\5\uffff\1\20\1\62\1"+
            "\4\1\34\2\62\1\11\1\14\1\32\1\62\1\16\1\10\1\3\1\uffff\1\12"+
            "\1\61\1\62\1\25\1\31\1\21\1\22\1\23\1\2\1\24\1\7\1\13\2\62\1"+
            "\6\1\17\1\5\1\62\1\15\2\uffff\3\62\5\uffff\1\62\1\30\22\62\1"+
            "\27\4\62\1\26\4\62\1\36\1\37\1\62\1\uffff\1\52\1\62\1\33\2\62"+
            "\1\53\1\54\1\55\1\35\1\uffff\1\40\1\41\1\45\1\51\1\56\1\57\1"+
            "\60\2\62",
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
    static final short[] DFA172_eot = DFA.unpackEncodedString(DFA172_eotS);
    static final short[] DFA172_eof = DFA.unpackEncodedString(DFA172_eofS);
    static final char[] DFA172_min = DFA.unpackEncodedStringToUnsignedChars(DFA172_minS);
    static final char[] DFA172_max = DFA.unpackEncodedStringToUnsignedChars(DFA172_maxS);
    static final short[] DFA172_accept = DFA.unpackEncodedString(DFA172_acceptS);
    static final short[] DFA172_special = DFA.unpackEncodedString(DFA172_specialS);
    static final short[][] DFA172_transition;
    static {
        int numStates = DFA172_transitionS.length;
        DFA172_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA172_transition[i] = DFA.unpackEncodedString(DFA172_transitionS[i]);
        }
    }
    class DFA172 extends DFA {
        public DFA172(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 172;
            this.eot = DFA172_eot;
            this.eof = DFA172_eof;
            this.min = DFA172_min;
            this.max = DFA172_max;
            this.accept = DFA172_accept;
            this.special = DFA172_special;
            this.transition = DFA172_transition;
        }
        public String getDescription() {
            return "8815:1: ( ( ( ruleXExpression ) )=> (this_object= ruleXExpression ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA172_1 = input.LA(1);
                        int index172_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA172_2 = input.LA(1);
                        int index172_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA172_3 = input.LA(1);
                        int index172_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA172_4 = input.LA(1);
                        int index172_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA172_5 = input.LA(1);
                        int index172_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA172_6 = input.LA(1);
                        int index172_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA172_7 = input.LA(1);
                        int index172_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA172_8 = input.LA(1);
                        int index172_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA172_9 = input.LA(1);
                        int index172_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA172_10 = input.LA(1);
                        int index172_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA172_11 = input.LA(1);
                        int index172_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA172_12 = input.LA(1);
                        int index172_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA172_13 = input.LA(1);
                        int index172_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA172_14 = input.LA(1);
                        int index172_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA172_15 = input.LA(1);
                        int index172_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA172_16 = input.LA(1);
                        int index172_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA172_17 = input.LA(1);
                        int index172_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA172_18 = input.LA(1);
                        int index172_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA172_19 = input.LA(1);
                        int index172_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA172_20 = input.LA(1);
                        int index172_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA172_21 = input.LA(1);
                        int index172_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA172_22 = input.LA(1);
                        int index172_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA172_23 = input.LA(1);
                        int index172_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA172_24 = input.LA(1);
                        int index172_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA172_25 = input.LA(1);
                        int index172_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA172_26 = input.LA(1);
                        int index172_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_26);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA172_27 = input.LA(1);
                        int index172_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_27);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA172_28 = input.LA(1);
                        int index172_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_28);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA172_29 = input.LA(1);
                        int index172_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_29);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA172_30 = input.LA(1);
                        int index172_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_30);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA172_31 = input.LA(1);
                        int index172_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_31);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA172_32 = input.LA(1);
                        int index172_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_32);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA172_33 = input.LA(1);
                        int index172_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_33);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA172_34 = input.LA(1);
                        int index172_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_34);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA172_35 = input.LA(1);
                        int index172_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_35);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA172_36 = input.LA(1);
                        int index172_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_36);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA172_37 = input.LA(1);
                        int index172_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_37);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA172_38 = input.LA(1);
                        int index172_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_38);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA172_39 = input.LA(1);
                        int index172_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_39);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA172_40 = input.LA(1);
                        int index172_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_40);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA172_41 = input.LA(1);
                        int index172_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_41);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA172_42 = input.LA(1);
                        int index172_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_42);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA172_43 = input.LA(1);
                        int index172_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_43);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA172_44 = input.LA(1);
                        int index172_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_44);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA172_45 = input.LA(1);
                        int index172_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_45);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA172_46 = input.LA(1);
                        int index172_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_46);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA172_47 = input.LA(1);
                        int index172_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_47);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA172_48 = input.LA(1);
                        int index172_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_48);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA172_49 = input.LA(1);
                        int index172_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_49);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 172, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA187_eotS =
        "\147\uffff";
    static final String DFA187_eofS =
        "\1\2\146\uffff";
    static final String DFA187_minS =
        "\1\4\1\0\145\uffff";
    static final String DFA187_maxS =
        "\1\165\1\0\145\uffff";
    static final String DFA187_acceptS =
        "\2\uffff\1\2\143\uffff\1\1";
    static final String DFA187_specialS =
        "\1\uffff\1\0\145\uffff}>";
    static final String[] DFA187_transitionS = {
            "\13\2\5\uffff\3\2\1\1\36\2\1\uffff\3\2\5\uffff\41\2\1\uffff"+
            "\11\2\1\uffff\11\2\1\uffff\1\2",
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
    static final short[] DFA187_eot = DFA.unpackEncodedString(DFA187_eotS);
    static final short[] DFA187_eof = DFA.unpackEncodedString(DFA187_eofS);
    static final char[] DFA187_min = DFA.unpackEncodedStringToUnsignedChars(DFA187_minS);
    static final char[] DFA187_max = DFA.unpackEncodedStringToUnsignedChars(DFA187_maxS);
    static final short[] DFA187_accept = DFA.unpackEncodedString(DFA187_acceptS);
    static final short[] DFA187_special = DFA.unpackEncodedString(DFA187_specialS);
    static final short[][] DFA187_transition;
    static {
        int numStates = DFA187_transitionS.length;
        DFA187_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA187_transition[i] = DFA.unpackEncodedString(DFA187_transitionS[i]);
        }
    }
    class DFA187 extends DFA {
        public DFA187(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 187;
            this.eot = DFA187_eot;
            this.eof = DFA187_eof;
            this.min = DFA187_min;
            this.max = DFA187_max;
            this.accept = DFA187_accept;
            this.special = DFA187_special;
            this.transition = DFA187_transition;
        }
        public String getDescription() {
            return "9426:2: ( ( ( '<' )=>other= '<' ) ( (this_object= ruleJvmArgumentTypeReference ) ) (other= ',' ( (this_object= ruleJvmArgumentTypeReference ) ) )* other= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA187_1 = input.LA(1);
                        int index187_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalXtend()) ) {s = 102;}
                        else if ( (true) ) {s = 2;}
                        input.seek(index187_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 187, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA194_eotS =
        "\13\uffff";
    static final String DFA194_eofS =
        "\2\uffff\3\6\2\uffff\3\6\1\uffff";
    static final String DFA194_minS =
        "\1\4\1\uffff\3\24\1\4\1\uffff\3\24\1\uffff";
    static final String DFA194_maxS =
        "\1\62\1\uffff\3\132\1\124\1\uffff\3\132\1\uffff";
    static final String DFA194_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\3\uffff\1\3";
    static final String DFA194_specialS =
        "\13\uffff}>";
    static final String[] DFA194_transitionS = {
            "\1\2\33\uffff\1\4\12\uffff\1\1\6\uffff\1\3",
            "",
            "\3\6\7\uffff\3\6\6\uffff\7\6\6\uffff\1\6\12\uffff\1\6\32\uffff"+
            "\1\5",
            "\3\6\7\uffff\3\6\6\uffff\7\6\6\uffff\1\6\12\uffff\1\6\32\uffff"+
            "\1\5",
            "\3\6\7\uffff\3\6\6\uffff\7\6\6\uffff\1\6\12\uffff\1\6\32\uffff"+
            "\1\5",
            "\1\7\33\uffff\1\11\21\uffff\1\10\41\uffff\1\12",
            "",
            "\3\6\7\uffff\3\6\6\uffff\7\6\6\uffff\1\6\12\uffff\1\6\32\uffff"+
            "\1\5",
            "\3\6\7\uffff\3\6\6\uffff\7\6\6\uffff\1\6\12\uffff\1\6\32\uffff"+
            "\1\5",
            "\3\6\7\uffff\3\6\6\uffff\7\6\6\uffff\1\6\12\uffff\1\6\32\uffff"+
            "\1\5",
            ""
    };
    static final short[] DFA194_eot = DFA.unpackEncodedString(DFA194_eotS);
    static final short[] DFA194_eof = DFA.unpackEncodedString(DFA194_eofS);
    static final char[] DFA194_min = DFA.unpackEncodedStringToUnsignedChars(DFA194_minS);
    static final char[] DFA194_max = DFA.unpackEncodedStringToUnsignedChars(DFA194_maxS);
    static final short[] DFA194_accept = DFA.unpackEncodedString(DFA194_acceptS);
    static final short[] DFA194_special = DFA.unpackEncodedString(DFA194_specialS);
    static final short[][] DFA194_transition;
    static {
        int numStates = DFA194_transitionS.length;
        DFA194_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA194_transition[i] = DFA.unpackEncodedString(DFA194_transitionS[i]);
        }
    }
    class DFA194 extends DFA {
        public DFA194(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 194;
            this.eot = DFA194_eot;
            this.eof = DFA194_eof;
            this.min = DFA194_min;
            this.max = DFA194_max;
            this.accept = DFA194_accept;
            this.special = DFA194_special;
            this.transition = DFA194_transition;
        }
        public String getDescription() {
            return "9987:1: ( ( ( (other= 'static' ) ) ( (other= 'extension' ) )? ( ( ruleQualifiedName ) ) other= '.' other= '*' ) | ( ( ruleQualifiedName ) ) | ( (this_dataType= ruleQualifiedNameWithWildcard ) ) )";
        }
    }
    public static final BitSet FOLLOW_ruleFile_in_entryRuleFile81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFile91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleFile129 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFile150 = new BitSet(new long[]{0x80103F81C0700002L});
    public static final BitSet FOLLOW_21_in_ruleFile163 = new BitSet(new long[]{0x80103F81C0500002L});
    public static final BitSet FOLLOW_ruleXImportSection_in_ruleFile188 = new BitSet(new long[]{0x80003F81C0500002L});
    public static final BitSet FOLLOW_ruleType_in_ruleFile210 = new BitSet(new long[]{0x80003F81C0500002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType253 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotation_in_ruleType318 = new BitSet(new long[]{0x80003F81C0500000L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleType351 = new BitSet(new long[]{0x00003F8000500000L});
    public static final BitSet FOLLOW_22_in_ruleType364 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleType385 = new BitSet(new long[]{0x000000001C800000L});
    public static final BitSet FOLLOW_23_in_ruleType398 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleType419 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleType432 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleType453 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_ruleType467 = new BitSet(new long[]{0x000000001C000000L});
    public static final BitSet FOLLOW_26_in_ruleType482 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleType503 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_ruleType518 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleType539 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_24_in_ruleType552 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleType573 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_28_in_ruleType589 = new BitSet(new long[]{0x8007FFCD20100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleMember_in_ruleType610 = new BitSet(new long[]{0x8007FFCD20100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_29_in_ruleType623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleType661 = new BitSet(new long[]{0x00003F8040100000L});
    public static final BitSet FOLLOW_30_in_ruleType674 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleType695 = new BitSet(new long[]{0x0000000014800000L});
    public static final BitSet FOLLOW_23_in_ruleType708 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleType729 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleType742 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleType763 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_ruleType777 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_26_in_ruleType792 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleType813 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_24_in_ruleType826 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleType847 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_28_in_ruleType863 = new BitSet(new long[]{0x8007FFCD20100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleMember_in_ruleType884 = new BitSet(new long[]{0x8007FFCD20100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_29_in_ruleType897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleType935 = new BitSet(new long[]{0x00003F8080100000L});
    public static final BitSet FOLLOW_31_in_ruleType948 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleType969 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleType981 = new BitSet(new long[]{0x0004000120200010L});
    public static final BitSet FOLLOW_ruleXtendEnumLiteral_in_ruleType1003 = new BitSet(new long[]{0x0000000021200000L});
    public static final BitSet FOLLOW_24_in_ruleType1016 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleXtendEnumLiteral_in_ruleType1037 = new BitSet(new long[]{0x0000000021200000L});
    public static final BitSet FOLLOW_21_in_ruleType1054 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleType1068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleType1106 = new BitSet(new long[]{0x00003F8100100000L});
    public static final BitSet FOLLOW_32_in_ruleType1119 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleType1140 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleType1152 = new BitSet(new long[]{0x8004FF8D20100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleAnnotationField_in_ruleType1173 = new BitSet(new long[]{0x8004FF8D20100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_29_in_ruleType1186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotationField_in_entryRuleAnnotationField1230 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotationField1240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotation_in_ruleAnnotationField1286 = new BitSet(new long[]{0x8004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleAnnotationField1308 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleFieldModifier_in_ruleAnnotationField1332 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleAnnotationField1353 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleAnnotationField1375 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleAnnotationField1397 = new BitSet(new long[]{0x0000000200200002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleAnnotationField1426 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleAnnotationField1447 = new BitSet(new long[]{0x0000000200200002L});
    public static final BitSet FOLLOW_33_in_ruleAnnotationField1462 = new BitSet(new long[]{0x80173FADCC5070F0L,0x00005A0020000000L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValue_in_ruleAnnotationField1483 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleAnnotationField1498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMember_in_entryRuleMember1542 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMember1552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotation_in_ruleMember1607 = new BitSet(new long[]{0x8007FFCD00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleMember1640 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleFieldModifier_in_ruleMember1664 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleMember1685 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleMember1707 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleMember1729 = new BitSet(new long[]{0x0000000200200002L});
    public static final BitSet FOLLOW_34_in_ruleMember1755 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleFieldModifier_in_ruleMember1790 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleMember1817 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleMember1840 = new BitSet(new long[]{0x0004000300200012L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleMember1861 = new BitSet(new long[]{0x0000000200200002L});
    public static final BitSet FOLLOW_ruleFieldModifier_in_ruleMember1891 = new BitSet(new long[]{0x00003F8400100000L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleMember1912 = new BitSet(new long[]{0x00003F8400100000L});
    public static final BitSet FOLLOW_34_in_ruleMember1931 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleMember1965 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleMember1987 = new BitSet(new long[]{0x0004000300200012L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleMember2008 = new BitSet(new long[]{0x0000000200200002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleMember2038 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleMember2059 = new BitSet(new long[]{0x0000000200200002L});
    public static final BitSet FOLLOW_33_in_ruleMember2074 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleMember2095 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleMember2110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleMember2150 = new BitSet(new long[]{0x00033F8000100000L});
    public static final BitSet FOLLOW_ruleMethodModifier_in_ruleMember2172 = new BitSet(new long[]{0x0007FF8D00900010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleMember2194 = new BitSet(new long[]{0x0007FF8D00900010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleMethodModifier_in_ruleMember2221 = new BitSet(new long[]{0x0007FF8D00900010L,0x0000000000008000L});
    public static final BitSet FOLLOW_23_in_ruleMember2236 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleMember2257 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleMember2270 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleMember2291 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_ruleMember2305 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleMember2367 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_ruleCreateExtensionInfo_in_ruleMember2388 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleMember2409 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleMember2421 = new BitSet(new long[]{0x8004FF9D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleMember2479 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleMember2500 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleMember2512 = new BitSet(new long[]{0x8004FF9D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleCreateExtensionInfo_in_ruleMember2570 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleMember2591 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleMember2603 = new BitSet(new long[]{0x8004FF9D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleMember2633 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleMember2645 = new BitSet(new long[]{0x8004FF9D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleMember2669 = new BitSet(new long[]{0x0000001001000000L});
    public static final BitSet FOLLOW_24_in_ruleMember2682 = new BitSet(new long[]{0x8004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleMember2703 = new BitSet(new long[]{0x0000001001000000L});
    public static final BitSet FOLLOW_36_in_ruleMember2719 = new BitSet(new long[]{0x00000020102000E2L});
    public static final BitSet FOLLOW_37_in_ruleMember2732 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleMember2753 = new BitSet(new long[]{0x00000000112000E2L});
    public static final BitSet FOLLOW_24_in_ruleMember2766 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleMember2787 = new BitSet(new long[]{0x00000000112000E2L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleMember2813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichString_in_ruleMember2840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleMember2858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleMember2898 = new BitSet(new long[]{0x00003FC000100000L});
    public static final BitSet FOLLOW_38_in_ruleMember2911 = new BitSet(new long[]{0x0000000800800000L});
    public static final BitSet FOLLOW_23_in_ruleMember2924 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleMember2945 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleMember2958 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleMember2979 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_ruleMember2993 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleMember3007 = new BitSet(new long[]{0x8004FF9D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleMember3029 = new BitSet(new long[]{0x0000001001000000L});
    public static final BitSet FOLLOW_24_in_ruleMember3042 = new BitSet(new long[]{0x8004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleMember3063 = new BitSet(new long[]{0x0000001001000000L});
    public static final BitSet FOLLOW_36_in_ruleMember3079 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_ruleMember3092 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleMember3113 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_24_in_ruleMember3126 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleMember3147 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleMember3172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXtendEnumLiteral_in_entryRuleXtendEnumLiteral3216 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXtendEnumLiteral3226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXtendEnumLiteral3271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_entryRuleCommonModifier3313 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommonModifier3324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleCommonModifier3362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleCommonModifier3381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleCommonModifier3400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleCommonModifier3419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleCommonModifier3438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleCommonModifier3457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleCommonModifier3476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleCommonModifier3495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFieldModifier_in_entryRuleFieldModifier3542 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFieldModifier3553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleFieldModifier3591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleFieldModifier3610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodModifier_in_entryRuleMethodModifier3657 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodModifier3668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleMethodModifier3706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleMethodModifier3725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreateExtensionInfo_in_entryRuleCreateExtensionInfo3771 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCreateExtensionInfo3781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleCreateExtensionInfo3818 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleCreateExtensionInfo3840 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleCreateExtensionInfo3852 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleCreateExtensionInfo3875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID3918 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID3929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID3969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleValidID3993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleValidID4012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCallID_in_entryRuleFeatureCallID4059 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCallID4070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureCallID4110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleFeatureCallID4134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleFeatureCallID4153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleFeatureCallID4172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleFeatureCallID4191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleFeatureCallID4210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleFeatureCallID4229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleFeatureCallID4248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleFeatureCallID4267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleFeatureCallID4286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleFeatureCallID4305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleFeatureCallID4324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleFeatureCallID4343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleFeatureCallID4362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleFeatureCallID4381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleFeatureCallID4400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleFeatureCallID4419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleFeatureCallID4438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleFeatureCallID4457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleFeatureCallID4476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleFeatureCallID4495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter4541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter4551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotation_in_ruleParameter4597 = new BitSet(new long[]{0x8004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_34_in_ruleParameter4617 = new BitSet(new long[]{0x8004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleXAnnotation_in_ruleParameter4651 = new BitSet(new long[]{0x8004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleParameter4675 = new BitSet(new long[]{0x0024000100000010L});
    public static final BitSet FOLLOW_53_in_ruleParameter4693 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleParameter4728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration4770 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXVariableDeclaration4780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleXVariableDeclaration4938 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_46_in_ruleXVariableDeclaration4969 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_34_in_ruleXVariableDeclaration4988 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_34_in_ruleXVariableDeclaration5028 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_47_in_ruleXVariableDeclaration5060 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_46_in_ruleXVariableDeclaration5091 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration5143 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration5164 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration5193 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleXVariableDeclaration5207 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXVariableDeclaration5228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter5272 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameter5282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleJvmFormalParameter5325 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter5360 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmFormalParameter5382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFullJvmFormalParameter_in_entryRuleFullJvmFormalParameter5424 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFullJvmFormalParameter5434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleFullJvmFormalParameter5477 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleFullJvmFormalParameter5512 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleFullJvmFormalParameter5533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_entryRuleXStringLiteral5575 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXStringLiteral5585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleStringLiteral_in_ruleXStringLiteral5632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichString_in_ruleXStringLiteral5659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleStringLiteral_in_entryRuleSimpleStringLiteral5700 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleStringLiteral5710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSimpleStringLiteral5761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichString_in_entryRuleRichString5808 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichString5818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringLiteral_in_ruleRichString5874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringLiteralStart_in_ruleRichString5902 = new BitSet(new long[]{0x0857FFEDDCD07FF0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleRichStringPart_in_ruleRichString5923 = new BitSet(new long[]{0x0857FFEDDCD07FF0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleRichStringLiteralInbetween_in_ruleRichString5946 = new BitSet(new long[]{0x0857FFEDDCD07FF0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleRichStringPart_in_ruleRichString5967 = new BitSet(new long[]{0x0857FFEDDCD07FF0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleRichStringLiteralEnd_in_ruleRichString5991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringLiteral_in_entryRuleRichStringLiteral6035 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringLiteral6045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RICH_TEXT_in_ruleRichStringLiteral6096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringLiteralStart_in_entryRuleRichStringLiteralStart6143 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringLiteralStart6153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RICH_TEXT_START_in_ruleRichStringLiteralStart6204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringLiteralInbetween_in_entryRuleRichStringLiteralInbetween6251 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringLiteralInbetween6261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RICH_TEXT_INBETWEEN_in_ruleRichStringLiteralInbetween6313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_COMMENT_RICH_TEXT_INBETWEEN_in_ruleRichStringLiteralInbetween6341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringLiteralEnd_in_entryRuleRichStringLiteralEnd6389 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringLiteralEnd6399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RICH_TEXT_END_in_ruleRichStringLiteralEnd6451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_COMMENT_RICH_TEXT_END_in_ruleRichStringLiteralEnd6479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInternalRichString_in_entryRuleInternalRichString6527 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInternalRichString6537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringLiteralInbetween_in_ruleInternalRichString6593 = new BitSet(new long[]{0x0857FFEDDCD073F2L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleRichStringPart_in_ruleInternalRichString6615 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_ruleRichStringLiteralInbetween_in_ruleInternalRichString6637 = new BitSet(new long[]{0x0857FFEDDCD073F2L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleRichStringPart_in_entryRuleRichStringPart6682 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringPart6692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleRichStringPart6739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringForLoop_in_ruleRichStringPart6766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringIf_in_ruleRichStringPart6793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringForLoop_in_entryRuleRichStringForLoop6834 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringForLoop6844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleRichStringForLoop6890 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleRichStringForLoop6911 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleRichStringForLoop6923 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleRichStringForLoop6944 = new BitSet(new long[]{0x0380000000000300L});
    public static final BitSet FOLLOW_55_in_ruleRichStringForLoop6957 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleRichStringForLoop6978 = new BitSet(new long[]{0x0380000000000300L});
    public static final BitSet FOLLOW_56_in_ruleRichStringForLoop6993 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleRichStringForLoop7014 = new BitSet(new long[]{0x0380000000000300L});
    public static final BitSet FOLLOW_57_in_ruleRichStringForLoop7029 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleRichStringForLoop7050 = new BitSet(new long[]{0x0380000000000300L});
    public static final BitSet FOLLOW_ruleInternalRichString_in_ruleRichStringForLoop7073 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleRichStringForLoop7085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringIf_in_entryRuleRichStringIf7127 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringIf7137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleRichStringIf7183 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleRichStringIf7204 = new BitSet(new long[]{0x0380000000000300L});
    public static final BitSet FOLLOW_ruleInternalRichString_in_ruleRichStringIf7225 = new BitSet(new long[]{0x7000000000000000L});
    public static final BitSet FOLLOW_ruleRichStringElseIf_in_ruleRichStringIf7246 = new BitSet(new long[]{0x7000000000000000L});
    public static final BitSet FOLLOW_60_in_ruleRichStringIf7260 = new BitSet(new long[]{0x0380000000000300L});
    public static final BitSet FOLLOW_ruleInternalRichString_in_ruleRichStringIf7281 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_ruleRichStringIf7295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringElseIf_in_entryRuleRichStringElseIf7337 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringElseIf7347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleRichStringElseIf7384 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleRichStringElseIf7405 = new BitSet(new long[]{0x0380000000000300L});
    public static final BitSet FOLLOW_ruleInternalRichString_in_ruleRichStringElseIf7426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotation_in_entryRuleXAnnotation7468 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAnnotation7478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleXAnnotation7524 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXAnnotation7547 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_ruleXAnnotation7568 = new BitSet(new long[]{0x80173FBDCC5070F0L,0x00005A0020000000L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValuePair_in_ruleXAnnotation7592 = new BitSet(new long[]{0x0000001001000000L});
    public static final BitSet FOLLOW_24_in_ruleXAnnotation7605 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValuePair_in_ruleXAnnotation7626 = new BitSet(new long[]{0x0000001001000000L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotation7656 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleXAnnotation7670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValuePair_in_entryRuleXAnnotationElementValuePair7714 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAnnotationElementValuePair7724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXAnnotationElementValuePair7772 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleXAnnotationElementValuePair7784 = new BitSet(new long[]{0x80173FADCC5070F0L,0x00005A0020000000L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotationElementValuePair7805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValueStringConcatenation_in_entryRuleXAnnotationElementValueStringConcatenation7847 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAnnotationElementValueStringConcatenation7857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotationElementValueStringConcatenation7904 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleXAnnotationElementValueStringConcatenation7931 = new BitSet(new long[]{0x80173FADCC5070F0L,0x00005A0020000000L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotationElementValueStringConcatenation7965 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValue_in_entryRuleXAnnotationElementValue8009 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAnnotationElementValue8019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotation_in_ruleXAnnotationElementValue8066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXListLiteral_in_ruleXAnnotationElementValue8093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXAnnotationElementValue8120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXAnnotationElementValue8147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNumberLiteral_in_ruleXAnnotationElementValue8174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXAnnotationElementValue8201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotationValueFieldReference_in_ruleXAnnotationElementValue8228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleXAnnotationElementValue8246 = new BitSet(new long[]{0x80173FADCC5070F0L,0x00005A0020000000L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValueStringConcatenation_in_ruleXAnnotationElementValue8268 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleXAnnotationElementValue8279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotationValueFieldReference_in_entryRuleXAnnotationValueFieldReference8322 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAnnotationValueFieldReference8332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_ruleXAnnotationValueFieldReference8389 = new BitSet(new long[]{0x00173FA5CC500010L,0x0000020000000000L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_ruleXAnnotationValueFieldReference8413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_entryRuleXExpression8455 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpression8465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXExpression8511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_entryRuleXAssignment8551 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAssignment8561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCallID_in_ruleXAssignment8619 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXAssignment8635 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment8655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment8685 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_ruleXAssignment8738 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment8761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign8807 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpSingleAssign8818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOpSingleAssign8855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign8901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMultiAssign8912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleOpMultiAssign8950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleOpMultiAssign8969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression9015 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOrExpression9025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression9072 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleXOrExpression9125 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression9148 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr9193 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr9204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleOpOr9241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression9286 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAndExpression9296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression9343 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleXAndExpression9396 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression9419 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd9464 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd9475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleOpAnd9512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression9557 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXEqualityExpression9567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression9614 = new BitSet(new long[]{0x0000000000000002L,0x00000000000001E0L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleXEqualityExpression9667 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression9690 = new BitSet(new long[]{0x0000000000000002L,0x00000000000001E0L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality9735 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality9746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleOpEquality9784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleOpEquality9803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleOpEquality9822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleOpEquality9841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression9887 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRelationalExpression9897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression9944 = new BitSet(new long[]{0x0000000002800002L,0x0000000000000E00L});
    public static final BitSet FOLLOW_73_in_ruleXRelationalExpression9980 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXRelationalExpression10003 = new BitSet(new long[]{0x0000000002800002L,0x0000000000000E00L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleXRelationalExpression10064 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression10087 = new BitSet(new long[]{0x0000000002800002L,0x0000000000000E00L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare10133 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare10144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleOpCompare10182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleOpCompare10201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOpCompare10220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOpCompare10239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression10285 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOtherOperatorExpression10295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression10342 = new BitSet(new long[]{0x0000000002800002L,0x000000000007F000L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression10395 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression10418 = new BitSet(new long[]{0x0000000002800002L,0x000000000007F000L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther10463 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther10474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleOpOther10512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleOpOther10531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOpOther10551 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_ruleOpOther10564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleOpOther10584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleOpOther10603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOpOther10623 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleOpOther10654 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleOpOther10667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOpOther10688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOpOther10710 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleOpOther10741 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleOpOther10754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOpOther10775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleOpOther10796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleOpOther10815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleOpOther10834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression10880 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAdditiveExpression10890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression10937 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080001L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression10990 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression11013 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080001L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd11058 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd11069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleOpAdd11107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleOpAdd11126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression11172 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMultiplicativeExpression11182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression11229 = new BitSet(new long[]{0x0000000000000002L,0x0000000000F00000L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression11282 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression11305 = new BitSet(new long[]{0x0000000000000002L,0x0000000000F00000L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti11350 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti11361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleOpMulti11399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_ruleOpMulti11418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_ruleOpMulti11437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_ruleOpMulti11456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation11502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXUnaryOperation11512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleXUnaryOperation11570 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXUnaryOperation11591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation11620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary11662 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary11673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_ruleOpUnary11711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleOpUnary11730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleOpUnary11749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression11795 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCastedExpression11805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression11852 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_ruleXCastedExpression11887 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression11910 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall11954 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMemberFeatureCall11964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall12011 = new BitSet(new long[]{0x0000000000000002L,0x000000001C000000L});
    public static final BitSet FOLLOW_90_in_ruleXMemberFeatureCall12060 = new BitSet(new long[]{0x00173FA5CC500010L});
    public static final BitSet FOLLOW_ruleFeatureCallID_in_ruleXMemberFeatureCall12083 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall12099 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall12121 = new BitSet(new long[]{0x0000000000000002L,0x000000001C000000L});
    public static final BitSet FOLLOW_90_in_ruleXMemberFeatureCall12207 = new BitSet(new long[]{0x00173FA5CCD00010L});
    public static final BitSet FOLLOW_91_in_ruleXMemberFeatureCall12231 = new BitSet(new long[]{0x00173FA5CCD00010L});
    public static final BitSet FOLLOW_92_in_ruleXMemberFeatureCall12268 = new BitSet(new long[]{0x00173FA5CCD00010L});
    public static final BitSet FOLLOW_23_in_ruleXMemberFeatureCall12297 = new BitSet(new long[]{0x0004FF8D00100010L,0x0010000000008000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall12318 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleXMemberFeatureCall12331 = new BitSet(new long[]{0x0004FF8D00100010L,0x0010000000008000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall12352 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_ruleXMemberFeatureCall12366 = new BitSet(new long[]{0x00173FA5CC500010L});
    public static final BitSet FOLLOW_ruleFeatureCallID_in_ruleXMemberFeatureCall12391 = new BitSet(new long[]{0x0000000800000002L,0x000000005C000000L});
    public static final BitSet FOLLOW_35_in_ruleXMemberFeatureCall12425 = new BitSet(new long[]{0x0017FFFDDCD070F0L,0x0003FBCB61088001L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall12510 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall12538 = new BitSet(new long[]{0x0000001001000000L});
    public static final BitSet FOLLOW_24_in_ruleXMemberFeatureCall12551 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall12572 = new BitSet(new long[]{0x0000001001000000L});
    public static final BitSet FOLLOW_36_in_ruleXMemberFeatureCall12589 = new BitSet(new long[]{0x0000000000000002L,0x000000005C000000L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXMemberFeatureCall12624 = new BitSet(new long[]{0x0000000000000002L,0x000000001C000000L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression12670 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXPrimaryExpression12680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression12727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression12754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression12781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression12808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression12835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression12862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression12889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression12916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression12943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression12970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression12997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression13024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression13051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_entryRuleXLiteral13092 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXLiteral13102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCollectionLiteral_in_ruleXLiteral13149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXLiteral13189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral13217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNumberLiteral_in_ruleXLiteral13244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_ruleXLiteral13271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXLiteral13298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXLiteral13325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCollectionLiteral_in_entryRuleXCollectionLiteral13366 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCollectionLiteral13376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSetLiteral_in_ruleXCollectionLiteral13423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXListLiteral_in_ruleXCollectionLiteral13450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSetLiteral_in_entryRuleXSetLiteral13491 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSetLiteral13501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_ruleXSetLiteral13547 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleXSetLiteral13559 = new BitSet(new long[]{0x00173FEDFCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSetLiteral13581 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_24_in_ruleXSetLiteral13594 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSetLiteral13615 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_29_in_ruleXSetLiteral13631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXListLiteral_in_entryRuleXListLiteral13673 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXListLiteral13683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_ruleXListLiteral13729 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_ruleXListLiteral13741 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCAE1080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXListLiteral13763 = new BitSet(new long[]{0x0000000001000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_24_in_ruleXListLiteral13776 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXListLiteral13797 = new BitSet(new long[]{0x0000000001000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_ruleXListLiteral13813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_entryRuleXClosure13855 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXClosure13865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_ruleXClosure13925 = new BitSet(new long[]{0x0017FFEDDCD070F0L,0x0003FBCBE1088001L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure13998 = new BitSet(new long[]{0x0000000001000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_24_in_ruleXClosure14011 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure14032 = new BitSet(new long[]{0x0000000001000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_ruleXClosure14054 = new BitSet(new long[]{0x0017FFEDDCD070F0L,0x0003FBCAE1080001L});
    public static final BitSet FOLLOW_ruleXExpressionInClosure_in_ruleXClosure14091 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_ruleXClosure14103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInClosure_in_entryRuleXExpressionInClosure14145 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInClosure14155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXExpressionInClosure14211 = new BitSet(new long[]{0x0017FFEDDCF070F2L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_21_in_ruleXExpressionInClosure14224 = new BitSet(new long[]{0x0017FFEDDCD070F2L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure14270 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXShortClosure14280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure14388 = new BitSet(new long[]{0x0000000001000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_24_in_ruleXShortClosure14401 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure14422 = new BitSet(new long[]{0x0000000001000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_ruleXShortClosure14444 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXShortClosure14480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression14522 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXParenthesizedExpression14532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleXParenthesizedExpression14569 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression14591 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleXParenthesizedExpression14602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression14644 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIfExpression14654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_ruleXIfExpression14700 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleXIfExpression14712 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression14733 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleXIfExpression14745 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression14766 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_ruleXIfExpression14787 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression14809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression14853 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSwitchExpression14863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_ruleXSwitchExpression14909 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXSwitchExpression14952 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleXSwitchExpression14964 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression14988 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_35_in_ruleXSwitchExpression15032 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXSwitchExpression15053 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleXSwitchExpression15065 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression15088 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleXSwitchExpression15100 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleXSwitchExpression15114 = new BitSet(new long[]{0x000CFF8D00100010L,0x0000002000008000L});
    public static final BitSet FOLLOW_ruleXCasePart_in_ruleXSwitchExpression15135 = new BitSet(new long[]{0x000CFF8D20100010L,0x0000003000008000L});
    public static final BitSet FOLLOW_100_in_ruleXSwitchExpression15149 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleXSwitchExpression15161 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression15182 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleXSwitchExpression15196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_entryRuleXCasePart15238 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCasePart15248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCasePart15294 = new BitSet(new long[]{0x0008000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_ruleXCasePart15308 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart15329 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleXCasePart15343 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart15364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression15406 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXForLoopExpression15416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_ruleXForLoopExpression15462 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleXForLoopExpression15474 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression15495 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleXForLoopExpression15507 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression15528 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleXForLoopExpression15540 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression15561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression15603 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWhileExpression15613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_ruleXWhileExpression15659 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleXWhileExpression15671 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression15692 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleXWhileExpression15704 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression15725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression15767 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXDoWhileExpression15777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_ruleXDoWhileExpression15823 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression15844 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_ruleXDoWhileExpression15856 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleXDoWhileExpression15868 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression15889 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleXDoWhileExpression15901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression15943 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBlockExpression15953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleXBlockExpression15999 = new BitSet(new long[]{0x0017FFEDFCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression16021 = new BitSet(new long[]{0x0017FFEDFCF070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_21_in_ruleXBlockExpression16034 = new BitSet(new long[]{0x0017FFEDFCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_29_in_ruleXBlockExpression16050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock16092 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInsideBlock16102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock16251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock16279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall16320 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFeatureCall16330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_ruleXFeatureCall16387 = new BitSet(new long[]{0x00173FA5CCD00010L,0x0000020000000000L});
    public static final BitSet FOLLOW_23_in_ruleXFeatureCall16401 = new BitSet(new long[]{0x0004FF8D00100010L,0x0010000000008000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall16422 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleXFeatureCall16435 = new BitSet(new long[]{0x0004FF8D00100010L,0x0010000000008000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall16456 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_ruleXFeatureCall16470 = new BitSet(new long[]{0x00173FA5CC500010L,0x0000020000000000L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall16495 = new BitSet(new long[]{0x0000000800000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_35_in_ruleXFeatureCall16529 = new BitSet(new long[]{0x0017FFFDDCD070F0L,0x0003FBCB61088001L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXFeatureCall16614 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall16642 = new BitSet(new long[]{0x0000001001000000L});
    public static final BitSet FOLLOW_24_in_ruleXFeatureCall16655 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall16676 = new BitSet(new long[]{0x0000001001000000L});
    public static final BitSet FOLLOW_36_in_ruleXFeatureCall16693 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXFeatureCall16728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper16772 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdOrSuper16783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCallID_in_ruleIdOrSuper16830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_ruleIdOrSuper16854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticQualifier_in_entryRuleStaticQualifier16901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStaticQualifier16912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleStaticQualifier16959 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_106_in_ruleStaticQualifier16977 = new BitSet(new long[]{0x0004000100000012L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall17024 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXConstructorCall17034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleXConstructorCall17080 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXConstructorCall17103 = new BitSet(new long[]{0x0000000800800002L,0x0000000040000000L});
    public static final BitSet FOLLOW_23_in_ruleXConstructorCall17124 = new BitSet(new long[]{0x0004FF8D00100010L,0x0010000000008000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall17146 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleXConstructorCall17159 = new BitSet(new long[]{0x0004FF8D00100010L,0x0010000000008000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall17180 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_ruleXConstructorCall17194 = new BitSet(new long[]{0x0000000800000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_35_in_ruleXConstructorCall17217 = new BitSet(new long[]{0x0017FFFDDCD070F0L,0x0003FBCB61088001L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXConstructorCall17290 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall17318 = new BitSet(new long[]{0x0000001001000000L});
    public static final BitSet FOLLOW_24_in_ruleXConstructorCall17331 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall17352 = new BitSet(new long[]{0x0000001001000000L});
    public static final BitSet FOLLOW_36_in_ruleXConstructorCall17369 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXConstructorCall17404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral17447 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBooleanLiteral17457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_ruleXBooleanLiteral17504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_ruleXBooleanLiteral17528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral17584 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNullLiteral17594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_ruleXNullLiteral17640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNumberLiteral_in_entryRuleXNumberLiteral17682 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNumberLiteral17692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_ruleXNumberLiteral17747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral17789 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTypeLiteral17799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_ruleXTypeLiteral17845 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleXTypeLiteral17857 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral17880 = new BitSet(new long[]{0x0000001000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_ruleXTypeLiteral17901 = new BitSet(new long[]{0x0000001000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_36_in_ruleXTypeLiteral17914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression17956 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXThrowExpression17966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_ruleXThrowExpression18012 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXThrowExpression18033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression18075 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXReturnExpression18085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_ruleXReturnExpression18131 = new BitSet(new long[]{0x00173FEDDCD070F2L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXReturnExpression18162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression18205 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression18215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_ruleXTryCatchFinallyExpression18261 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression18282 = new BitSet(new long[]{0x0000000000000000L,0x000C000000000000L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression18312 = new BitSet(new long[]{0x0000000000000002L,0x000C000000000000L});
    public static final BitSet FOLLOW_114_in_ruleXTryCatchFinallyExpression18334 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression18356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_ruleXTryCatchFinallyExpression18378 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression18399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause18443 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCatchClause18453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_ruleXCatchClause18498 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleXCatchClause18511 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleFullJvmFormalParameter_in_ruleXCatchClause18532 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleXCatchClause18544 = new BitSet(new long[]{0x00173FEDDCD070F0L,0x0003FBCA61080001L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCatchClause18565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName18608 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName18619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName18666 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_ruleQualifiedName18694 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName18717 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_ruleNumber_in_entryRuleNumber18771 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumber18782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleNumber18826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNumber18854 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_ruleNumber18880 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_ruleNumber18900 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNumber18916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_ruleNumber18942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference19001 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference19011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference19059 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_ruleJvmTypeReference19095 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference19126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets19168 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayBrackets19179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_ruleArrayBrackets19217 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_ruleArrayBrackets19230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef19276 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef19286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleXFunctionTypeRef19324 = new BitSet(new long[]{0x0004FF9D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef19346 = new BitSet(new long[]{0x0000001001000000L});
    public static final BitSet FOLLOW_24_in_ruleXFunctionTypeRef19359 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef19380 = new BitSet(new long[]{0x0000001001000000L});
    public static final BitSet FOLLOW_36_in_ruleXFunctionTypeRef19396 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_ruleXFunctionTypeRef19410 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef19431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference19473 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference19483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference19531 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleJvmParameterizedTypeReference19552 = new BitSet(new long[]{0x0004FF8D00100010L,0x0010000000008000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference19574 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleJvmParameterizedTypeReference19587 = new BitSet(new long[]{0x0004FF8D00100010L,0x0010000000008000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference19608 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_ruleJvmParameterizedTypeReference19622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference19666 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference19676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference19723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference19750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference19791 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference19801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_ruleJvmWildcardTypeReference19847 = new BitSet(new long[]{0x0000000004000002L,0x0000020000000000L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference19869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference19896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound19940 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound19950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleJvmUpperBound19987 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound20008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded20050 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded20060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_ruleJvmUpperBoundAnded20097 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded20118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound20160 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound20170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_ruleJvmLowerBound20207 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound20228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_entryRuleJvmTypeParameter20270 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeParameter20280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmTypeParameter20326 = new BitSet(new long[]{0x0000000004000002L,0x0000020000000000L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmTypeParameter20349 = new BitSet(new long[]{0x0000000000000002L,0x0020000000000000L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmTypeParameter20370 = new BitSet(new long[]{0x0000000000000002L,0x0020000000000000L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmTypeParameter20399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard20444 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard20455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard20502 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_ruleQualifiedNameWithWildcard20520 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_ruleQualifiedNameWithWildcard20533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportSection_in_entryRuleXImportSection20579 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXImportSection20589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportDeclaration_in_ruleXImportSection20634 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_ruleXImportDeclaration_in_entryRuleXImportDeclaration20676 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXImportDeclaration20686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleXImportDeclaration20723 = new BitSet(new long[]{0x0004080100000010L});
    public static final BitSet FOLLOW_43_in_ruleXImportDeclaration20743 = new BitSet(new long[]{0x0004000500000010L});
    public static final BitSet FOLLOW_34_in_ruleXImportDeclaration20774 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXImportDeclaration20811 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_ruleXImportDeclaration20823 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_ruleXImportDeclaration20835 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXImportDeclaration20865 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_ruleXImportDeclaration20892 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleXImportDeclaration20906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_synpred1_InternalXtend2324 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_ruleCreateExtensionInfo_in_synpred1_InternalXtend2333 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred1_InternalXtend2342 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred1_InternalXtend2348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_synpred2_InternalXtend2445 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred2_InternalXtend2454 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred2_InternalXtend2460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreateExtensionInfo_in_synpred3_InternalXtend2536 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred3_InternalXtend2545 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred3_InternalXtend2551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_synpred5_InternalXtend5113 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred5_InternalXtend5122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_synpred6_InternalXtend7560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_synpred7_InternalXtend8706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred8_InternalXtend9093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred9_InternalXtend9364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred10_InternalXtend9635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_synpred11_InternalXtend9961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred12_InternalXtend10032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred13_InternalXtend10363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_synpred14_InternalXtend10638 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred14_InternalXtend10643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_synpred15_InternalXtend10725 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_synpred15_InternalXtend10730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred16_InternalXtend10958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred17_InternalXtend11250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_synpred18_InternalXtend11868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_synpred19_InternalXtend12028 = new BitSet(new long[]{0x00173FA5CC500010L});
    public static final BitSet FOLLOW_ruleFeatureCallID_in_synpred19_InternalXtend12037 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_synpred19_InternalXtend12043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_synpred20_InternalXtend12146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_synpred20_InternalXtend12160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_synpred20_InternalXtend12180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_synpred21_InternalXtend12407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred22_InternalXtend12459 = new BitSet(new long[]{0x0000000001000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_24_in_synpred22_InternalXtend12466 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred22_InternalXtend12473 = new BitSet(new long[]{0x0000000001000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_synpred22_InternalXtend12487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_synpred23_InternalXtend12607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_synpred24_InternalXtend13170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred26_InternalXtend13944 = new BitSet(new long[]{0x0000000001000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_24_in_synpred26_InternalXtend13951 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred26_InternalXtend13958 = new BitSet(new long[]{0x0000000001000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_synpred26_InternalXtend13972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_synpred28_InternalXtend14779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred29_InternalXtend14927 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_synpred29_InternalXtend14933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_synpred30_InternalXtend15009 = new BitSet(new long[]{0x0004000100000010L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred30_InternalXtend15016 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_synpred30_InternalXtend15022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_synpred31_InternalXtend16150 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_46_in_synpred31_InternalXtend16166 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_synpred31_InternalXtend16175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred31_InternalXtend16198 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_47_in_synpred31_InternalXtend16213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_synpred31_InternalXtend16229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_synpred32_InternalXtend16511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred33_InternalXtend16563 = new BitSet(new long[]{0x0000000001000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_24_in_synpred33_InternalXtend16570 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred33_InternalXtend16577 = new BitSet(new long[]{0x0000000001000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_synpred33_InternalXtend16591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_synpred34_InternalXtend16711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_synpred35_InternalXtend17116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_synpred36_InternalXtend17209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred37_InternalXtend17239 = new BitSet(new long[]{0x0000000001000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_24_in_synpred37_InternalXtend17246 = new BitSet(new long[]{0x0004FF8D00100010L,0x0000000000008000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred37_InternalXtend17253 = new BitSet(new long[]{0x0000000001000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_synpred37_InternalXtend17267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_synpred38_InternalXtend17387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred39_InternalXtend18145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_synpred40_InternalXtend18296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_synpred41_InternalXtend18326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_synpred43_InternalXtend18685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_synpred44_InternalXtend19074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_synpred45_InternalXtend19544 = new BitSet(new long[]{0x0000000000000002L});
	private EObject callRuleQualifiedNameAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		AntlrDatatypeRuleToken token = ruleQualifiedName();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleXImportSectionAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXImportSection();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleTypeAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleType();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleXAnnotationAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXAnnotation();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleCommonModifierAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		AntlrDatatypeRuleToken token = ruleCommonModifier();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleValidIDAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		AntlrDatatypeRuleToken token = ruleValidID();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleJvmTypeParameterAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleJvmTypeParameter();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleJvmParameterizedTypeReferenceAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleJvmParameterizedTypeReference();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleJvmParameterizedTypeReferenceAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleJvmParameterizedTypeReference();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleMemberAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleMember();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleXtendEnumLiteralAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXtendEnumLiteral();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleAnnotationFieldAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleAnnotationField();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleFieldModifierAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		AntlrDatatypeRuleToken token = ruleFieldModifier();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleJvmTypeReferenceAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleJvmTypeReference();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleXAnnotationElementValueAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXAnnotationElementValue();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleXExpressionAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXExpression();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleMethodModifierAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		AntlrDatatypeRuleToken token = ruleMethodModifier();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleCreateExtensionInfoAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleCreateExtensionInfo();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleParameterAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleParameter();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleJvmTypeReferenceAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleJvmTypeReference();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleXBlockExpressionAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXBlockExpression();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleRichStringAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleRichString();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleRichStringLiteralAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleRichStringLiteral();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleRichStringLiteralStartAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleRichStringLiteralStart();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleRichStringPartAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleRichStringPart();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleRichStringLiteralInbetweenAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleRichStringLiteralInbetween();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleRichStringLiteralEndAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleRichStringLiteralEnd();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleJvmFormalParameterAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleJvmFormalParameter();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleInternalRichStringAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleInternalRichString();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleRichStringElseIfAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleRichStringElseIf();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleXAnnotationElementValuePairAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXAnnotationElementValuePair();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleXAssignmentAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXAssignment();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleXAndExpressionAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXAndExpression();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleXEqualityExpressionAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXEqualityExpression();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleXRelationalExpressionAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXRelationalExpression();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleXOtherOperatorExpressionAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXOtherOperatorExpression();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleXAdditiveExpressionAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXAdditiveExpression();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleXMultiplicativeExpressionAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXMultiplicativeExpression();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleXUnaryOperationAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXUnaryOperation();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleJvmArgumentTypeReferenceAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleJvmArgumentTypeReference();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleXShortClosureAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXShortClosure();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleXExpressionAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXExpression();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleXClosureAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXClosure();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleJvmFormalParameterAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleJvmFormalParameter();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleXExpressionInClosureAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXExpressionInClosure();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleXExpressionInsideBlockAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXExpressionInsideBlock();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleXCasePartAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXCasePart();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleNumberAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		AntlrDatatypeRuleToken token = ruleNumber();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleArrayBracketsAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		AntlrDatatypeRuleToken token = ruleArrayBrackets();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleXCatchClauseAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXCatchClause();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleFullJvmFormalParameterAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleFullJvmFormalParameter();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleJvmUpperBoundAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleJvmUpperBound();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleJvmLowerBoundAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleJvmLowerBound();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleJvmUpperBoundAndedAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleJvmUpperBoundAnded();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleXImportDeclarationAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXImportDeclaration();
		return addValue(current, token, rule, featureId, ruleName);
	}

	private EObject callRuleQualifiedNameWithWildcardAndSet(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		AntlrDatatypeRuleToken token = ruleQualifiedNameWithWildcard();
		return setValue(current, token, rule, featureId, ruleName);
	}

	private EObject callUnassignedRuleSimpleStringLiteral(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleSimpleStringLiteral();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleRichString(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleRichString();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXExpressionInsideBlock(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXExpressionInsideBlock();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleRichStringForLoop(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleRichStringForLoop();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleRichStringIf(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleRichStringIf();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXAnnotationElementValue(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXAnnotationElementValue();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXAnnotation(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXAnnotation();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXListLiteral(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXListLiteral();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXStringLiteral(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXStringLiteral();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXBooleanLiteral(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXBooleanLiteral();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXNumberLiteral(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXNumberLiteral();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXTypeLiteral(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXTypeLiteral();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXAnnotationValueFieldReference(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXAnnotationValueFieldReference();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXAnnotationElementValueStringConcatenation(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXAnnotationElementValueStringConcatenation();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXAssignment(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXAssignment();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXOrExpression(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXOrExpression();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXAndExpression(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXAndExpression();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXEqualityExpression(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXEqualityExpression();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXRelationalExpression(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXRelationalExpression();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXOtherOperatorExpression(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXOtherOperatorExpression();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXAdditiveExpression(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXAdditiveExpression();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXMultiplicativeExpression(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXMultiplicativeExpression();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXUnaryOperation(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXUnaryOperation();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXCastedExpression(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXCastedExpression();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXMemberFeatureCall(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXMemberFeatureCall();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXPrimaryExpression(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXPrimaryExpression();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXConstructorCall(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXConstructorCall();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXBlockExpression(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXBlockExpression();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXSwitchExpression(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXSwitchExpression();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXFeatureCall(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXFeatureCall();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXLiteral(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXLiteral();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXIfExpression(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXIfExpression();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXForLoopExpression(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXForLoopExpression();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXWhileExpression(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXWhileExpression();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXDoWhileExpression(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXDoWhileExpression();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXThrowExpression(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXThrowExpression();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXReturnExpression(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXReturnExpression();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXTryCatchFinallyExpression(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXTryCatchFinallyExpression();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXParenthesizedExpression(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXParenthesizedExpression();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXCollectionLiteral(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXCollectionLiteral();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXClosure(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXClosure();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXNullLiteral(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXNullLiteral();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXSetLiteral(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXSetLiteral();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXExpression(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXExpression();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXVariableDeclaration(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXVariableDeclaration();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleJvmParameterizedTypeReference(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleJvmParameterizedTypeReference();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXFunctionTypeRef(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXFunctionTypeRef();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleJvmTypeReference(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleJvmTypeReference();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleJvmWildcardTypeReference(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleJvmWildcardTypeReference();
		return getCurrentOrNull(token);
	}

	private void callRuleFeatureCallID(BitSet followSet, AntlrDatatypeRuleToken current, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		merge(current, ruleFeatureCallID());
	}

	private void callRuleValidID(BitSet followSet, AntlrDatatypeRuleToken current, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		merge(current, ruleValidID());
	}

	private void callRuleQualifiedName(BitSet followSet, AntlrDatatypeRuleToken current, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		merge(current, ruleQualifiedName());
	}

	private EObject callRuleQualifiedName(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule) throws RecognitionException {
		current = createModelElementAndPushFollow(current, rule, followSet, grammarElement);
		ruleQualifiedName();
		postCrossReference();
		return current;
	}

	private EObject callRuleValidID(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule) throws RecognitionException {
		current = createModelElementAndPushFollow(current, rule, followSet, grammarElement);
		ruleValidID();
		postCrossReference();
		return current;
	}

	private EObject callRuleStaticQualifier(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule) throws RecognitionException {
		current = createModelElementAndPushFollow(current, rule, followSet, grammarElement);
		ruleStaticQualifier();
		postCrossReference();
		return current;
	}

	private EObject callRuleIdOrSuper(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule) throws RecognitionException {
		current = createModelElementAndPushFollow(current, rule, followSet, grammarElement);
		ruleIdOrSuper();
		postCrossReference();
		return current;
	}

	private EObject callRuleFeatureCallID(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule) throws RecognitionException {
		current = createModelElementAndPushFollow(current, rule, followSet, grammarElement);
		ruleFeatureCallID();
		postCrossReference();
		return current;
	}

	private EObject callRuleOpMultiAssign(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule) throws RecognitionException {
		current = createModelElementAndPushFollow(current, rule, followSet, grammarElement);
		ruleOpMultiAssign();
		postCrossReference();
		return current;
	}

	private EObject callRuleOpOr(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule) throws RecognitionException {
		current = createModelElementAndPushFollow(current, rule, followSet, grammarElement);
		ruleOpOr();
		postCrossReference();
		return current;
	}

	private EObject callRuleOpAnd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule) throws RecognitionException {
		current = createModelElementAndPushFollow(current, rule, followSet, grammarElement);
		ruleOpAnd();
		postCrossReference();
		return current;
	}

	private EObject callRuleOpEquality(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule) throws RecognitionException {
		current = createModelElementAndPushFollow(current, rule, followSet, grammarElement);
		ruleOpEquality();
		postCrossReference();
		return current;
	}

	private EObject callRuleOpCompare(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule) throws RecognitionException {
		current = createModelElementAndPushFollow(current, rule, followSet, grammarElement);
		ruleOpCompare();
		postCrossReference();
		return current;
	}

	private EObject callRuleOpOther(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule) throws RecognitionException {
		current = createModelElementAndPushFollow(current, rule, followSet, grammarElement);
		ruleOpOther();
		postCrossReference();
		return current;
	}

	private EObject callRuleOpAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule) throws RecognitionException {
		current = createModelElementAndPushFollow(current, rule, followSet, grammarElement);
		ruleOpAdd();
		postCrossReference();
		return current;
	}

	private EObject callRuleOpMulti(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule) throws RecognitionException {
		current = createModelElementAndPushFollow(current, rule, followSet, grammarElement);
		ruleOpMulti();
		postCrossReference();
		return current;
	}

	private EObject callRuleOpUnary(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule) throws RecognitionException {
		current = createModelElementAndPushFollow(current, rule, followSet, grammarElement);
		ruleOpUnary();
		postCrossReference();
		return current;
	}

}