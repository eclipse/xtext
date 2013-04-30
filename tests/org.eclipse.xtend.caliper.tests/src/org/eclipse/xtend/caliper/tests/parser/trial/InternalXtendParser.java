package org.eclipse.xtend.caliper.tests.parser.trial; 
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_RICH_TEXT", "RULE_RICH_TEXT_START", "RULE_RICH_TEXT_INBETWEEN", "RULE_COMMENT_RICH_TEXT_INBETWEEN", "RULE_RICH_TEXT_END", "RULE_COMMENT_RICH_TEXT_END", "RULE_HEX", "RULE_INT", "RULE_DECIMAL", "RULE_IDENTIFIER_START", "RULE_UNICODE_ESCAPE", "RULE_IDENTIFIER_PART", "RULE_HEX_DIGIT", "RULE_IN_RICH_STRING", "RULE_IDENTIFIER_PART_IMPL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "';'", "'class'", "'<'", "','", "'>'", "'extends'", "'implements'", "'{'", "'}'", "'interface'", "'enum'", "'annotation'", "'='", "'extension'", "'('", "')'", "'throws'", "'new'", "'public'", "'private'", "'protected'", "'abstract'", "'static'", "'dispatch'", "'final'", "'val'", "'var'", "'def'", "'override'", "'create'", "':'", "'import'", "'...'", "'FOR'", "'BEFORE'", "'SEPARATOR'", "'AFTER'", "'ENDFOR'", "'IF'", "'ELSE'", "'ENDIF'", "'ELSEIF'", "'@'", "'#'", "'['", "']'", "'+='", "'-='", "'||'", "'&&'", "'=='", "'!='", "'==='", "'!=='", "'instanceof'", "'>='", "'<='", "'->'", "'..<'", "'..'", "'=>'", "'<>'", "'?:'", "'<=>'", "'+'", "'-'", "'*'", "'**'", "'/'", "'%'", "'!'", "'as'", "'.'", "'::'", "'?.'", "'|'", "'if'", "'else'", "'switch'", "'default'", "'case'", "'for'", "'while'", "'do'", "'super'", "'false'", "'true'", "'null'", "'typeof'", "'throw'", "'return'", "'try'", "'finally'", "'catch'", "'?'", "'&'"
    };
    public static final int RULE_COMMENT_RICH_TEXT_INBETWEEN=9;
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_ANY_OTHER=24;
    public static final int RULE_IDENTIFIER_PART_IMPL=20;
    public static final int RULE_COMMENT_RICH_TEXT_END=11;
    public static final int EOF=-1;
    public static final int RULE_IDENTIFIER_START=15;
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
    public static final int RULE_HEX_DIGIT=18;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int RULE_IN_RICH_STRING=19;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int RULE_ML_COMMENT=21;
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
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__121=121;
    public static final int T__120=120;
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
    public static final int RULE_UNICODE_ESCAPE=16;
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
    public static final int RULE_IDENTIFIER_PART=17;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int RULE_SL_COMMENT=22;
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
    public static final int RULE_WS=23;

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
            if ( (LA2_0==25) ) {
                int LA2_1 = input.LA(2);
                if ( (LA2_1==37) ) {
                    int LA2_3 = input.LA(3);
                    if ( (LA2_3==37) ) {
                        int LA2_5 = input.LA(4);
                        if ( (LA2_5==RULE_ID||LA2_5==37||LA2_5==55) ) {
                            alt2=1;
                        }
                    }
                    else if ( (LA2_3==EOF||(LA2_3>=25 && LA2_3<=27)||(LA2_3>=35 && LA2_3<=36)||(LA2_3>=44 && LA2_3<=50)||LA2_3==57||LA2_3==68||LA2_3==98) ) {
                        alt2=1;
                    }
                }
                else if ( (LA2_1==RULE_ID||LA2_1==55) ) {
                    alt2=1;
                }
            }
            switch (alt2) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(25, FOLLOW_25_in_ruleFile129,  elementAccess.getPackageKeyword_0_0())) { return current; }


                    {

                    {
                    current = callRuleQualifiedNameAndSet(FOLLOW_ruleQualifiedName_in_ruleFile150, current, elementAccess.getPackageQualifiedNameParserRuleCall_0_1_0(), elementAccess.getRule(), XTEND_FILE__PACKAGE, "QualifiedName");
                    if (state.failed) return current;

                    }
                    }
                    int alt1=2;
                    int LA1_0 = input.LA(1);
                    if ( (LA1_0==26) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(26, FOLLOW_26_in_ruleFile163,  elementAccess.getSemicolonKeyword_0_2())) { return current; }

                            }
                            break;
                    }
                    }
                    break;
            }
            int alt3=2;
            int LA3_0 = input.LA(1);
            if ( (LA3_0==57) ) {
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
                if ( (LA4_0==25||LA4_0==27||(LA4_0>=35 && LA4_0<=37)||(LA4_0>=44 && LA4_0<=50)||LA4_0==68) ) {
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
                if ( (LA5_0==68) ) {
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
                        if ( (LA6_0==25||(LA6_0>=44 && LA6_0<=50)) ) {
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
                    if (!consumeUnassignedToken(27, FOLLOW_27_in_ruleType364,  elementAccess.getClassKeyword_2_0_2())) { return current; }


                    {

                    {
                    current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleType385, current, elementAccess.getNameValidIDParserRuleCall_2_0_3_0(), elementAccess.getRule(), XTEND_CLASS__NAME, "ValidID");
                    if (state.failed) return current;

                    }
                    }
                    int alt8=2;
                    int LA8_0 = input.LA(1);
                    if ( (LA8_0==28) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(28, FOLLOW_28_in_ruleType398,  elementAccess.getLessThanSignKeyword_2_0_4_0())) { return current; }


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
                                if ( (LA7_0==29) ) {
                                    alt7=1;
                                }
                                switch (alt7) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleType432,  elementAccess.getCommaKeyword_2_0_4_2_0())) { return current; }


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
                            if (!consumeUnassignedToken(30, FOLLOW_30_in_ruleType467,  elementAccess.getGreaterThanSignKeyword_2_0_4_3())) { return current; }

                            }
                            break;
                    }
                    int alt9=2;
                    int LA9_0 = input.LA(1);
                    if ( (LA9_0==31) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(31, FOLLOW_31_in_ruleType482,  elementAccess.getExtendsKeyword_2_0_5_0())) { return current; }


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
                    if ( (LA11_0==32) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(32, FOLLOW_32_in_ruleType518,  elementAccess.getImplementsKeyword_2_0_6_0())) { return current; }


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
                                if ( (LA10_0==29) ) {
                                    alt10=1;
                                }
                                switch (alt10) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleType552,  elementAccess.getCommaKeyword_2_0_6_2_0())) { return current; }


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
                    if (!consumeUnassignedToken(33, FOLLOW_33_in_ruleType589,  elementAccess.getLeftCurlyBracketKeyword_2_0_7())) { return current; }

                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);
                        if ( (LA12_0==RULE_ID||LA12_0==25||LA12_0==37||(LA12_0>=39 && LA12_0<=40)||(LA12_0>=43 && LA12_0<=55)||LA12_0==68||LA12_0==86) ) {
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
                    if (!consumeUnassignedToken(34, FOLLOW_34_in_ruleType623,  elementAccess.getRightCurlyBracketKeyword_2_0_9())) { return current; }

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
                        if ( (LA13_0==25||(LA13_0>=44 && LA13_0<=50)) ) {
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
                    if (!consumeUnassignedToken(35, FOLLOW_35_in_ruleType674,  elementAccess.getInterfaceKeyword_2_1_2())) { return current; }


                    {

                    {
                    current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleType695, current, elementAccess.getNameValidIDParserRuleCall_2_1_3_0(), elementAccess.getRule(), XTEND_INTERFACE__NAME, "ValidID");
                    if (state.failed) return current;

                    }
                    }
                    int alt15=2;
                    int LA15_0 = input.LA(1);
                    if ( (LA15_0==28) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(28, FOLLOW_28_in_ruleType708,  elementAccess.getLessThanSignKeyword_2_1_4_0())) { return current; }


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
                                if ( (LA14_0==29) ) {
                                    alt14=1;
                                }
                                switch (alt14) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleType742,  elementAccess.getCommaKeyword_2_1_4_2_0())) { return current; }


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
                            if (!consumeUnassignedToken(30, FOLLOW_30_in_ruleType777,  elementAccess.getGreaterThanSignKeyword_2_1_4_3())) { return current; }

                            }
                            break;
                    }
                    int alt17=2;
                    int LA17_0 = input.LA(1);
                    if ( (LA17_0==31) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(31, FOLLOW_31_in_ruleType792,  elementAccess.getExtendsKeyword_2_1_5_0())) { return current; }


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
                                if ( (LA16_0==29) ) {
                                    alt16=1;
                                }
                                switch (alt16) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleType826,  elementAccess.getCommaKeyword_2_1_5_2_0())) { return current; }


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
                    if (!consumeUnassignedToken(33, FOLLOW_33_in_ruleType863,  elementAccess.getLeftCurlyBracketKeyword_2_1_6())) { return current; }

                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);
                        if ( (LA18_0==RULE_ID||LA18_0==25||LA18_0==37||(LA18_0>=39 && LA18_0<=40)||(LA18_0>=43 && LA18_0<=55)||LA18_0==68||LA18_0==86) ) {
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
                    if (!consumeUnassignedToken(34, FOLLOW_34_in_ruleType897,  elementAccess.getRightCurlyBracketKeyword_2_1_8())) { return current; }

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
                        if ( (LA19_0==25||(LA19_0>=44 && LA19_0<=50)) ) {
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
                    if (!consumeUnassignedToken(36, FOLLOW_36_in_ruleType948,  elementAccess.getEnumKeyword_2_2_2())) { return current; }


                    {

                    {
                    current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleType969, current, elementAccess.getNameValidIDParserRuleCall_2_2_3_0(), elementAccess.getRule(), XTEND_ENUM__NAME, "ValidID");
                    if (state.failed) return current;

                    }
                    }
                    if (!consumeUnassignedToken(33, FOLLOW_33_in_ruleType981,  elementAccess.getLeftCurlyBracketKeyword_2_2_4())) { return current; }

                    int alt21=2;
                    int LA21_0 = input.LA(1);
                    if ( (LA21_0==RULE_ID||LA21_0==37||LA21_0==55) ) {
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
                                if ( (LA20_0==29) ) {
                                    alt20=1;
                                }
                                switch (alt20) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleType1016,  elementAccess.getCommaKeyword_2_2_5_1_0())) { return current; }


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
                    if ( (LA22_0==26) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(26, FOLLOW_26_in_ruleType1054,  elementAccess.getSemicolonKeyword_2_2_6())) { return current; }

                            }
                            break;
                    }
                    if (!consumeUnassignedToken(34, FOLLOW_34_in_ruleType1068,  elementAccess.getRightCurlyBracketKeyword_2_2_7())) { return current; }

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
                        if ( (LA23_0==25||(LA23_0>=44 && LA23_0<=50)) ) {
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
                    if (!consumeUnassignedToken(37, FOLLOW_37_in_ruleType1119,  elementAccess.getAnnotationKeyword_2_3_2())) { return current; }


                    {

                    {
                    current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleType1140, current, elementAccess.getNameValidIDParserRuleCall_2_3_3_0(), elementAccess.getRule(), XTEND_ANNOTATION_TYPE__NAME, "ValidID");
                    if (state.failed) return current;

                    }
                    }
                    if (!consumeUnassignedToken(33, FOLLOW_33_in_ruleType1152,  elementAccess.getLeftCurlyBracketKeyword_2_3_4())) { return current; }

                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);
                        if ( (LA24_0==RULE_ID||LA24_0==25||LA24_0==37||LA24_0==40||(LA24_0>=44 && LA24_0<=52)||LA24_0==55||LA24_0==68||LA24_0==86) ) {
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
                    if (!consumeUnassignedToken(34, FOLLOW_34_in_ruleType1186,  elementAccess.getRightCurlyBracketKeyword_2_3_6())) { return current; }

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
                if ( (LA26_0==68) ) {
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
                if ( (LA27_0==25||(LA27_0>=44 && LA27_0<=50)) ) {
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
            if ( ((LA30_0>=51 && LA30_0<=52)) ) {
                alt30=1;
            }
            else if ( (LA30_0==RULE_ID||LA30_0==37||LA30_0==40||LA30_0==55||LA30_0==86) ) {
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
                        if ( (LA28_0==25||(LA28_0>=44 && LA28_0<=50)) ) {
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
            if ( (LA31_0==38) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(38, FOLLOW_38_in_ruleAnnotationField1462,  elementAccess.getEqualsSignKeyword_3_0())) { return current; }


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
            if ( (LA32_0==26) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(26, FOLLOW_26_in_ruleAnnotationField1498,  elementAccess.getSemicolonKeyword_4())) { return current; }

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
                if ( (LA33_0==68) ) {
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
                        if ( (LA34_0==25||(LA34_0>=44 && LA34_0<=50)) ) {
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
                                if ( (LA35_0==25||(LA35_0>=44 && LA35_0<=50)) ) {
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
                            current = consumeTokenAndAdd(39, FOLLOW_39_in_ruleMember1755, current,  elementAccess.getModifiersExtensionKeyword_2_0_2_1_0_0(), elementAccess.getRule(), XTEND_FIELD__MODIFIERS);
                            if (state.failed) return current;

                            }
                            }
                            loop37:
                            do {
                                int alt37=3;
                                int LA37_0 = input.LA(1);
                                if ( ((LA37_0>=51 && LA37_0<=52)) ) {
                                    alt37=1;
                                }
                                else if ( (LA37_0==25||(LA37_0>=44 && LA37_0<=50)) ) {
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
                                if ( (LA39_0==25||(LA39_0>=44 && LA39_0<=50)) ) {
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
                            current = consumeTokenAndAdd(39, FOLLOW_39_in_ruleMember1931, current,  elementAccess.getModifiersExtensionKeyword_2_0_2_2_2_0(), elementAccess.getRule(), XTEND_FIELD__MODIFIERS);
                            if (state.failed) return current;

                            }
                            }
                            loop40:
                            do {
                                int alt40=2;
                                int LA40_0 = input.LA(1);
                                if ( (LA40_0==25||(LA40_0>=44 && LA40_0<=50)) ) {
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
                    if ( (LA43_0==38) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(38, FOLLOW_38_in_ruleMember2074,  elementAccess.getEqualsSignKeyword_2_0_3_0())) { return current; }


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
                    if ( (LA44_0==26) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(26, FOLLOW_26_in_ruleMember2110,  elementAccess.getSemicolonKeyword_2_0_4())) { return current; }

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
                        if ( (LA45_0==25||(LA45_0>=44 && LA45_0<=50)) ) {
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
                        if ( (LA46_0==25||(LA46_0>=44 && LA46_0<=50)) ) {
                            alt46=1;
                        }
                        else if ( ((LA46_0>=53 && LA46_0<=54)) ) {
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
                    if ( (LA48_0==28) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(28, FOLLOW_28_in_ruleMember2236,  elementAccess.getLessThanSignKeyword_2_1_4_0())) { return current; }


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
                                if ( (LA47_0==29) ) {
                                    alt47=1;
                                }
                                switch (alt47) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleMember2270,  elementAccess.getCommaKeyword_2_1_4_2_0())) { return current; }


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
                            if (!consumeUnassignedToken(30, FOLLOW_30_in_ruleMember2305,  elementAccess.getGreaterThanSignKeyword_2_1_4_3())) { return current; }

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
                            if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleMember2421,  elementAccess.getLeftParenthesisKeyword_2_1_5_0_0_3())) { return current; }

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
                            if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleMember2512,  elementAccess.getLeftParenthesisKeyword_2_1_5_1_0_2())) { return current; }

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
                            if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleMember2603,  elementAccess.getLeftParenthesisKeyword_2_1_5_2_0_2())) { return current; }

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
                            if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleMember2645,  elementAccess.getLeftParenthesisKeyword_2_1_5_3_1())) { return current; }

                            }
                            }
                            break;
                    }
                    int alt51=2;
                    int LA51_0 = input.LA(1);
                    if ( (LA51_0==RULE_ID||LA51_0==37||(LA51_0>=39 && LA51_0<=40)||LA51_0==55||LA51_0==68||LA51_0==86) ) {
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
                                if ( (LA50_0==29) ) {
                                    alt50=1;
                                }
                                switch (alt50) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleMember2682,  elementAccess.getCommaKeyword_2_1_6_1_0())) { return current; }


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
                    if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleMember2719,  elementAccess.getRightParenthesisKeyword_2_1_7())) { return current; }

                    int alt53=2;
                    int LA53_0 = input.LA(1);
                    if ( (LA53_0==42) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(42, FOLLOW_42_in_ruleMember2732,  elementAccess.getThrowsKeyword_2_1_8_0())) { return current; }


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
                                if ( (LA52_0==29) ) {
                                    alt52=1;
                                }
                                switch (alt52) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleMember2766,  elementAccess.getCommaKeyword_2_1_8_2_0())) { return current; }


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
                        case 33:
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
                        case 26:
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
                            if (!consumeUnassignedToken(26, FOLLOW_26_in_ruleMember2858,  elementAccess.getSemicolonKeyword_2_1_9_2())) { return current; }

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
                        if ( (LA55_0==25||(LA55_0>=44 && LA55_0<=50)) ) {
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
                    if (!consumeUnassignedToken(43, FOLLOW_43_in_ruleMember2911,  elementAccess.getNewKeyword_2_2_2())) { return current; }

                    int alt57=2;
                    int LA57_0 = input.LA(1);
                    if ( (LA57_0==28) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(28, FOLLOW_28_in_ruleMember2924,  elementAccess.getLessThanSignKeyword_2_2_3_0())) { return current; }


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
                                if ( (LA56_0==29) ) {
                                    alt56=1;
                                }
                                switch (alt56) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleMember2958,  elementAccess.getCommaKeyword_2_2_3_2_0())) { return current; }


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
                            if (!consumeUnassignedToken(30, FOLLOW_30_in_ruleMember2993,  elementAccess.getGreaterThanSignKeyword_2_2_3_3())) { return current; }

                            }
                            break;
                    }
                    if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleMember3007,  elementAccess.getLeftParenthesisKeyword_2_2_4())) { return current; }

                    int alt59=2;
                    int LA59_0 = input.LA(1);
                    if ( (LA59_0==RULE_ID||LA59_0==37||(LA59_0>=39 && LA59_0<=40)||LA59_0==55||LA59_0==68||LA59_0==86) ) {
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
                                if ( (LA58_0==29) ) {
                                    alt58=1;
                                }
                                switch (alt58) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleMember3042,  elementAccess.getCommaKeyword_2_2_5_1_0())) { return current; }


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
                    if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleMember3079,  elementAccess.getRightParenthesisKeyword_2_2_6())) { return current; }

                    int alt61=2;
                    int LA61_0 = input.LA(1);
                    if ( (LA61_0==42) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            {
                            if (!consumeUnassignedToken(42, FOLLOW_42_in_ruleMember3092,  elementAccess.getThrowsKeyword_2_2_7_0())) { return current; }


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
                                if ( (LA60_0==29) ) {
                                    alt60=1;
                                }
                                switch (alt60) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleMember3126,  elementAccess.getCommaKeyword_2_2_7_2_0())) { return current; }


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
            case 44:
                {
                alt63=1;
                }
                break;
            case 45:
                {
                alt63=2;
                }
                break;
            case 46:
                {
                alt63=3;
                }
                break;
            case 25:
                {
                alt63=4;
                }
                break;
            case 47:
                {
                alt63=5;
                }
                break;
            case 48:
                {
                alt63=6;
                }
                break;
            case 49:
                {
                alt63=7;
                }
                break;
            case 50:
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
                    if (!consumeTokenAndMerge(44, FOLLOW_44_in_ruleCommonModifier3362, current,  elementAccess.getPublicKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(45, FOLLOW_45_in_ruleCommonModifier3381, current,  elementAccess.getPrivateKeyword_1())) { return current; }

                    }
                    break;
                case 3 :
                    {
                    if (!consumeTokenAndMerge(46, FOLLOW_46_in_ruleCommonModifier3400, current,  elementAccess.getProtectedKeyword_2())) { return current; }

                    }
                    break;
                case 4 :
                    {
                    if (!consumeTokenAndMerge(25, FOLLOW_25_in_ruleCommonModifier3419, current,  elementAccess.getPackageKeyword_3())) { return current; }

                    }
                    break;
                case 5 :
                    {
                    if (!consumeTokenAndMerge(47, FOLLOW_47_in_ruleCommonModifier3438, current,  elementAccess.getAbstractKeyword_4())) { return current; }

                    }
                    break;
                case 6 :
                    {
                    if (!consumeTokenAndMerge(48, FOLLOW_48_in_ruleCommonModifier3457, current,  elementAccess.getStaticKeyword_5())) { return current; }

                    }
                    break;
                case 7 :
                    {
                    if (!consumeTokenAndMerge(49, FOLLOW_49_in_ruleCommonModifier3476, current,  elementAccess.getDispatchKeyword_6())) { return current; }

                    }
                    break;
                case 8 :
                    {
                    if (!consumeTokenAndMerge(50, FOLLOW_50_in_ruleCommonModifier3495, current,  elementAccess.getFinalKeyword_7())) { return current; }

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
            if ( (LA64_0==51) ) {
                alt64=1;
            }
            else if ( (LA64_0==52) ) {
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
                    if (!consumeTokenAndMerge(51, FOLLOW_51_in_ruleFieldModifier3591, current,  elementAccess.getValKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(52, FOLLOW_52_in_ruleFieldModifier3610, current,  elementAccess.getVarKeyword_1())) { return current; }

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
            if ( (LA65_0==53) ) {
                alt65=1;
            }
            else if ( (LA65_0==54) ) {
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
                    if (!consumeTokenAndMerge(53, FOLLOW_53_in_ruleMethodModifier3706, current,  elementAccess.getDefKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(54, FOLLOW_54_in_ruleMethodModifier3725, current,  elementAccess.getOverrideKeyword_1())) { return current; }

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
            if (!consumeUnassignedToken(55, FOLLOW_55_in_ruleCreateExtensionInfo3818,  elementAccess.getCreateKeyword_0())) { return current; }

            int alt66=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA66_1 = input.LA(2);
                    if ( (LA66_1==56) ) {
                        alt66=1;
                    }
                    }
                    break;
                case 55:
                    {
                    int LA66_2 = input.LA(2);
                    if ( (LA66_2==56) ) {
                        alt66=1;
                    }
                    }
                    break;
                case 37:
                    {
                    int LA66_3 = input.LA(2);
                    if ( (LA66_3==56) ) {
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
                    if (!consumeUnassignedToken(56, FOLLOW_56_in_ruleCreateExtensionInfo3852,  elementAccess.getColonKeyword_1_1())) { return current; }

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
            case 55:
                {
                alt67=2;
                }
                break;
            case 37:
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
                    if (!consumeTokenAndMerge(55, FOLLOW_55_in_ruleValidID3993, current,  elementAccess.getCreateKeyword_1())) { return current; }

                    }
                    break;
                case 3 :
                    {
                    if (!consumeTokenAndMerge(37, FOLLOW_37_in_ruleValidID4012, current,  elementAccess.getAnnotationKeyword_2())) { return current; }

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
            case 47:
                {
                alt68=2;
                }
                break;
            case 37:
                {
                alt68=3;
                }
                break;
            case 27:
                {
                alt68=4;
                }
                break;
            case 55:
                {
                alt68=5;
                }
                break;
            case 53:
                {
                alt68=6;
                }
                break;
            case 49:
                {
                alt68=7;
                }
                break;
            case 36:
                {
                alt68=8;
                }
                break;
            case 31:
                {
                alt68=9;
                }
                break;
            case 39:
                {
                alt68=10;
                }
                break;
            case 50:
                {
                alt68=11;
                }
                break;
            case 32:
                {
                alt68=12;
                }
                break;
            case 57:
                {
                alt68=13;
                }
                break;
            case 35:
                {
                alt68=14;
                }
                break;
            case 54:
                {
                alt68=15;
                }
                break;
            case 25:
                {
                alt68=16;
                }
                break;
            case 44:
                {
                alt68=17;
                }
                break;
            case 45:
                {
                alt68=18;
                }
                break;
            case 46:
                {
                alt68=19;
                }
                break;
            case 48:
                {
                alt68=20;
                }
                break;
            case 42:
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
                    if (!consumeTokenAndMerge(47, FOLLOW_47_in_ruleFeatureCallID4134, current,  elementAccess.getAbstractKeyword_1())) { return current; }

                    }
                    break;
                case 3 :
                    {
                    if (!consumeTokenAndMerge(37, FOLLOW_37_in_ruleFeatureCallID4153, current,  elementAccess.getAnnotationKeyword_2())) { return current; }

                    }
                    break;
                case 4 :
                    {
                    if (!consumeTokenAndMerge(27, FOLLOW_27_in_ruleFeatureCallID4172, current,  elementAccess.getClassKeyword_3())) { return current; }

                    }
                    break;
                case 5 :
                    {
                    if (!consumeTokenAndMerge(55, FOLLOW_55_in_ruleFeatureCallID4191, current,  elementAccess.getCreateKeyword_4())) { return current; }

                    }
                    break;
                case 6 :
                    {
                    if (!consumeTokenAndMerge(53, FOLLOW_53_in_ruleFeatureCallID4210, current,  elementAccess.getDefKeyword_5())) { return current; }

                    }
                    break;
                case 7 :
                    {
                    if (!consumeTokenAndMerge(49, FOLLOW_49_in_ruleFeatureCallID4229, current,  elementAccess.getDispatchKeyword_6())) { return current; }

                    }
                    break;
                case 8 :
                    {
                    if (!consumeTokenAndMerge(36, FOLLOW_36_in_ruleFeatureCallID4248, current,  elementAccess.getEnumKeyword_7())) { return current; }

                    }
                    break;
                case 9 :
                    {
                    if (!consumeTokenAndMerge(31, FOLLOW_31_in_ruleFeatureCallID4267, current,  elementAccess.getExtendsKeyword_8())) { return current; }

                    }
                    break;
                case 10 :
                    {
                    if (!consumeTokenAndMerge(39, FOLLOW_39_in_ruleFeatureCallID4286, current,  elementAccess.getExtensionKeyword_9())) { return current; }

                    }
                    break;
                case 11 :
                    {
                    if (!consumeTokenAndMerge(50, FOLLOW_50_in_ruleFeatureCallID4305, current,  elementAccess.getFinalKeyword_10())) { return current; }

                    }
                    break;
                case 12 :
                    {
                    if (!consumeTokenAndMerge(32, FOLLOW_32_in_ruleFeatureCallID4324, current,  elementAccess.getImplementsKeyword_11())) { return current; }

                    }
                    break;
                case 13 :
                    {
                    if (!consumeTokenAndMerge(57, FOLLOW_57_in_ruleFeatureCallID4343, current,  elementAccess.getImportKeyword_12())) { return current; }

                    }
                    break;
                case 14 :
                    {
                    if (!consumeTokenAndMerge(35, FOLLOW_35_in_ruleFeatureCallID4362, current,  elementAccess.getInterfaceKeyword_13())) { return current; }

                    }
                    break;
                case 15 :
                    {
                    if (!consumeTokenAndMerge(54, FOLLOW_54_in_ruleFeatureCallID4381, current,  elementAccess.getOverrideKeyword_14())) { return current; }

                    }
                    break;
                case 16 :
                    {
                    if (!consumeTokenAndMerge(25, FOLLOW_25_in_ruleFeatureCallID4400, current,  elementAccess.getPackageKeyword_15())) { return current; }

                    }
                    break;
                case 17 :
                    {
                    if (!consumeTokenAndMerge(44, FOLLOW_44_in_ruleFeatureCallID4419, current,  elementAccess.getPublicKeyword_16())) { return current; }

                    }
                    break;
                case 18 :
                    {
                    if (!consumeTokenAndMerge(45, FOLLOW_45_in_ruleFeatureCallID4438, current,  elementAccess.getPrivateKeyword_17())) { return current; }

                    }
                    break;
                case 19 :
                    {
                    if (!consumeTokenAndMerge(46, FOLLOW_46_in_ruleFeatureCallID4457, current,  elementAccess.getProtectedKeyword_18())) { return current; }

                    }
                    break;
                case 20 :
                    {
                    if (!consumeTokenAndMerge(48, FOLLOW_48_in_ruleFeatureCallID4476, current,  elementAccess.getStaticKeyword_19())) { return current; }

                    }
                    break;
                case 21 :
                    {
                    if (!consumeTokenAndMerge(42, FOLLOW_42_in_ruleFeatureCallID4495, current,  elementAccess.getThrowsKeyword_20())) { return current; }

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
                if ( (LA69_0==68) ) {
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
            if ( (LA71_0==39) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    {

                    {

                    {
                    current = consumeTokenAndSetBooleanValue(39, FOLLOW_39_in_ruleParameter4617, current,  elementAccess.getExtensionExtensionKeyword_1_0_0(), elementAccess.getRule(), XTEND_PARAMETER__EXTENSION);
                    if (state.failed) return current;

                    }
                    }
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);
                        if ( (LA70_0==68) ) {
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
            if ( (LA72_0==58) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    {

                    {
                    current = consumeTokenAndSetBooleanValue(58, FOLLOW_58_in_ruleParameter4693, current,  elementAccess.getVarArgFullStopFullStopFullStopKeyword_3_0(), elementAccess.getRule(), XTEND_PARAMETER__VAR_ARG);
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
            if ( ((LA76_0>=51 && LA76_0<=52)) ) {
                alt76=1;
            }
            else if ( (LA76_0==39) ) {
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
                    if ( (LA73_0==52) ) {
                        alt73=1;
                    }
                    else if ( (LA73_0==51) ) {
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
                            current = consumeTokenAndSetBooleanValue(52, FOLLOW_52_in_ruleXVariableDeclaration4938, current,  elementAccess.getWriteableVarKeyword_0_0_1_0_0_0_0(), elementAccess.getRule(), XTEND_VARIABLE_DECLARATION__WRITEABLE);
                            if (state.failed) return current;

                            }
                            }
                            }
                            break;
                        case 2 :
                            {
                            if (!consumeUnassignedToken(51, FOLLOW_51_in_ruleXVariableDeclaration4969,  elementAccess.getValKeyword_0_0_1_0_0_1())) { return current; }

                            }
                            break;
                    }
                    int alt74=2;
                    int LA74_0 = input.LA(1);
                    if ( (LA74_0==39) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            {

                            {
                            current = consumeTokenAndSetBooleanValue(39, FOLLOW_39_in_ruleXVariableDeclaration4988, current,  elementAccess.getExtensionExtensionKeyword_0_0_1_0_1_0(), elementAccess.getRule(), XTEND_VARIABLE_DECLARATION__EXTENSION);
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
                    current = consumeTokenAndSetBooleanValue(39, FOLLOW_39_in_ruleXVariableDeclaration5028, current,  elementAccess.getExtensionExtensionKeyword_0_0_1_1_0_0(), elementAccess.getRule(), XTEND_VARIABLE_DECLARATION__EXTENSION);
                    if (state.failed) return current;

                    }
                    }
                    int alt75=2;
                    int LA75_0 = input.LA(1);
                    if ( (LA75_0==52) ) {
                        alt75=1;
                    }
                    else if ( (LA75_0==51) ) {
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
                            current = consumeTokenAndSetBooleanValue(52, FOLLOW_52_in_ruleXVariableDeclaration5060, current,  elementAccess.getWriteableVarKeyword_0_0_1_1_1_0_0(), elementAccess.getRule(), XTEND_VARIABLE_DECLARATION__WRITEABLE);
                            if (state.failed) return current;

                            }
                            }
                            }
                            break;
                        case 2 :
                            {
                            if (!consumeUnassignedToken(51, FOLLOW_51_in_ruleXVariableDeclaration5091,  elementAccess.getValKeyword_0_0_1_1_1_1())) { return current; }

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
            else if ( (LA77_0==55) ) {
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
            else if ( (LA77_0==37) ) {
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
            else if ( (LA77_0==40) && (synpred5_InternalXtend())) {
                alt77=1;
            }
            else if ( (LA77_0==86) && (synpred5_InternalXtend())) {
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
            if ( (LA78_0==38) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(38, FOLLOW_38_in_ruleXVariableDeclaration5207,  elementAccess.getEqualsSignKeyword_2_0())) { return current; }


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
            if ( (LA79_0==39) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    {

                    {
                    current = consumeTokenAndSetBooleanValue(39, FOLLOW_39_in_ruleJvmFormalParameter5325, current,  elementAccess.getExtensionExtensionKeyword_0_0(), elementAccess.getRule(), XTEND_FORMAL_PARAMETER__EXTENSION);
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
                    if ( (LA80_1==RULE_ID||LA80_1==28||LA80_1==37||LA80_1==55||LA80_1==70||LA80_1==98) ) {
                        alt80=1;
                    }
                    }
                    break;
                case 55:
                    {
                    int LA80_2 = input.LA(2);
                    if ( (LA80_2==RULE_ID||LA80_2==28||LA80_2==37||LA80_2==55||LA80_2==70||LA80_2==98) ) {
                        alt80=1;
                    }
                    }
                    break;
                case 37:
                    {
                    int LA80_3 = input.LA(2);
                    if ( (LA80_3==RULE_ID||LA80_3==28||LA80_3==37||LA80_3==55||LA80_3==70||LA80_3==98) ) {
                        alt80=1;
                    }
                    }
                    break;
                case 40:
                case 86:
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
            if ( (LA81_0==39) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    {

                    {
                    current = consumeTokenAndSetBooleanValue(39, FOLLOW_39_in_ruleFullJvmFormalParameter5477, current,  elementAccess.getExtensionExtensionKeyword_0_0(), elementAccess.getRule(), XTEND_FORMAL_PARAMETER__EXTENSION);
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
                    if ( ((LA83_0>=RULE_ID && LA83_0<=RULE_RICH_TEXT_START)||(LA83_0>=RULE_HEX && LA83_0<=RULE_DECIMAL)||LA83_0==25||(LA83_0>=27 && LA83_0<=28)||(LA83_0>=31 && LA83_0<=33)||(LA83_0>=35 && LA83_0<=37)||(LA83_0>=39 && LA83_0<=40)||(LA83_0>=42 && LA83_0<=55)||LA83_0==57||LA83_0==59||LA83_0==64||(LA83_0>=69 && LA83_0<=70)||(LA83_0>=90 && LA83_0<=91)||LA83_0==96||LA83_0==102||LA83_0==104||(LA83_0>=107 && LA83_0<=117)) ) {
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
                    	    if ( ((LA84_0>=RULE_ID && LA84_0<=RULE_RICH_TEXT_START)||(LA84_0>=RULE_HEX && LA84_0<=RULE_DECIMAL)||LA84_0==25||(LA84_0>=27 && LA84_0<=28)||(LA84_0>=31 && LA84_0<=33)||(LA84_0>=35 && LA84_0<=37)||(LA84_0>=39 && LA84_0<=40)||(LA84_0>=42 && LA84_0<=55)||LA84_0==57||LA84_0==59||LA84_0==64||(LA84_0>=69 && LA84_0<=70)||(LA84_0>=90 && LA84_0<=91)||LA84_0==96||LA84_0==102||LA84_0==104||(LA84_0>=107 && LA84_0<=117)) ) {
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
                if ( ((LA90_0>=RULE_ID && LA90_0<=RULE_COMMENT_RICH_TEXT_INBETWEEN)||(LA90_0>=RULE_HEX && LA90_0<=RULE_DECIMAL)||LA90_0==25||(LA90_0>=27 && LA90_0<=28)||(LA90_0>=31 && LA90_0<=33)||(LA90_0>=35 && LA90_0<=37)||(LA90_0>=39 && LA90_0<=40)||(LA90_0>=42 && LA90_0<=55)||LA90_0==57||LA90_0==59||LA90_0==64||(LA90_0>=69 && LA90_0<=70)||(LA90_0>=90 && LA90_0<=91)||LA90_0==96||LA90_0==102||LA90_0==104||(LA90_0>=107 && LA90_0<=117)) ) {
                    alt90=1;
                }
                switch (alt90) {
            	case 1 :
            	    {
            	    int alt89=2;
            	    int LA89_0 = input.LA(1);
            	    if ( ((LA89_0>=RULE_ID && LA89_0<=RULE_RICH_TEXT_START)||(LA89_0>=RULE_HEX && LA89_0<=RULE_DECIMAL)||LA89_0==25||(LA89_0>=27 && LA89_0<=28)||(LA89_0>=31 && LA89_0<=33)||(LA89_0>=35 && LA89_0<=37)||(LA89_0>=39 && LA89_0<=40)||(LA89_0>=42 && LA89_0<=55)||LA89_0==57||LA89_0==59||LA89_0==64||(LA89_0>=69 && LA89_0<=70)||(LA89_0>=90 && LA89_0<=91)||LA89_0==96||LA89_0==102||LA89_0==104||(LA89_0>=107 && LA89_0<=117)) ) {
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
            case 25:
            case 27:
            case 28:
            case 31:
            case 32:
            case 33:
            case 35:
            case 36:
            case 37:
            case 39:
            case 40:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 57:
            case 69:
            case 70:
            case 90:
            case 91:
            case 96:
            case 102:
            case 104:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
                {
                alt91=1;
                }
                break;
            case 59:
                {
                alt91=2;
                }
                break;
            case 64:
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
            if (!consumeUnassignedToken(59, FOLLOW_59_in_ruleRichStringForLoop6890,  elementAccess.getFORKeyword_1())) { return current; }


            {

            {
            current = callRuleJvmFormalParameterAndSet(FOLLOW_ruleJvmFormalParameter_in_ruleRichStringForLoop6911, current, elementAccess.getDeclaredParamJvmFormalParameterParserRuleCall_2_0(), elementAccess.getRule(), RICH_STRING_FOR_LOOP__DECLARED_PARAM, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(56, FOLLOW_56_in_ruleRichStringForLoop6923,  elementAccess.getColonKeyword_3())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleRichStringForLoop6944, current, elementAccess.getForExpressionXExpressionParserRuleCall_4_0(), elementAccess.getRule(), RICH_STRING_FOR_LOOP__FOR_EXPRESSION, null);
            if (state.failed) return current;

            }
            }
            int alt92=2;
            int LA92_0 = input.LA(1);
            if ( (LA92_0==60) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(60, FOLLOW_60_in_ruleRichStringForLoop6957,  elementAccess.getBEFOREKeyword_5_0())) { return current; }


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
            if ( (LA93_0==61) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(61, FOLLOW_61_in_ruleRichStringForLoop6993,  elementAccess.getSEPARATORKeyword_6_0())) { return current; }


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
            if ( (LA94_0==62) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(62, FOLLOW_62_in_ruleRichStringForLoop7029,  elementAccess.getAFTERKeyword_7_0())) { return current; }


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
            if (!consumeUnassignedToken(63, FOLLOW_63_in_ruleRichStringForLoop7085,  elementAccess.getENDFORKeyword_9())) { return current; }

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
            if (!consumeUnassignedToken(64, FOLLOW_64_in_ruleRichStringIf7183,  elementAccess.getIFKeyword_1())) { return current; }


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
                if ( (LA95_0==67) ) {
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
            if ( (LA96_0==65) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(65, FOLLOW_65_in_ruleRichStringIf7260,  elementAccess.getELSEKeyword_5_0())) { return current; }


                    {

                    {
                    current = callRuleInternalRichStringAndSet(FOLLOW_ruleInternalRichString_in_ruleRichStringIf7281, current, elementAccess.getElseInternalRichStringParserRuleCall_5_1_0(), elementAccess.getRule(), RICH_STRING_IF__ELSE, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    break;
            }
            if (!consumeUnassignedToken(66, FOLLOW_66_in_ruleRichStringIf7295,  elementAccess.getENDIFKeyword_6())) { return current; }

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
            if (!consumeUnassignedToken(67, FOLLOW_67_in_ruleRichStringElseIf7384,  elementAccess.getELSEIFKeyword_0())) { return current; }


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
            if (!consumeUnassignedToken(68, FOLLOW_68_in_ruleXAnnotation7524,  elementAccess.getCommercialAtKeyword_1())) { return current; }


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
                    if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleXAnnotation7568,  elementAccess.getLeftParenthesisKeyword_3_0())) { return current; }

                    }
                    int alt98=3;
                    alt98 = dfa98.predict(input);
                    switch (alt98) {
                        case 1 :
                            {

                            {

                            {

                            {
                            current = callRuleXAnnotationElementValuePairAndAdd(FOLLOW_ruleXAnnotationElementValuePair_in_ruleXAnnotation7612, current, elementAccess.getElementValuePairsXAnnotationElementValuePairParserRuleCall_3_1_0_0_0(), elementAccess.getRule(), XANNOTATION__ELEMENT_VALUE_PAIRS, null);
                            if (state.failed) return current;

                            }
                            }
                            loop97:
                            do {
                                int alt97=2;
                                int LA97_0 = input.LA(1);
                                if ( (LA97_0==29) ) {
                                    alt97=1;
                                }
                                switch (alt97) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXAnnotation7625,  elementAccess.getCommaKeyword_3_1_0_1_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleXAnnotationElementValuePairAndAdd(FOLLOW_ruleXAnnotationElementValuePair_in_ruleXAnnotation7666, current, elementAccess.getElementValuePairsXAnnotationElementValuePairParserRuleCall_3_1_0_1_1_0(), elementAccess.getRule(), XANNOTATION__ELEMENT_VALUE_PAIRS, null);
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
                            current = callRuleXAnnotationElementValueAndSet(FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotation7696, current, elementAccess.getValueXAnnotationElementValueParserRuleCall_3_1_1_0(), elementAccess.getRule(), XANNOTATION__VALUE, null);
                            if (state.failed) return current;

                            }
                            }
                            }
                            break;
                    }
                    if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXAnnotation7710,  elementAccess.getRightParenthesisKeyword_3_2())) { return current; }

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
            pushFollow(FOLLOW_ruleXAnnotationElementValuePair_in_entryRuleXAnnotationElementValuePair7754);
            iv_ruleXAnnotationElementValuePair=ruleXAnnotationElementValuePair();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAnnotationElementValuePair; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAnnotationElementValuePair7764); if (state.failed) return current;
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

            {

            {
            current = callRuleValidID(FOLLOW_ruleValidID_in_ruleXAnnotationElementValuePair7834, current, elementAccess.getElementJvmOperationCrossReference_0_0_0_0(), elementAccess.getRule());
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(38, FOLLOW_38_in_ruleXAnnotationElementValuePair7846,  elementAccess.getEqualsSignKeyword_0_0_1())) { return current; }

            }
            }

            {

            {
            current = callRuleXAnnotationElementValueAndSet(FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotationElementValuePair7869, current, elementAccess.getValueXAnnotationElementValueParserRuleCall_1_0(), elementAccess.getRule(), XANNOTATION_ELEMENT_VALUE_PAIR__VALUE, null);
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

    public final EObject entryRuleXAnnotationElementValue() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXAnnotationElementValue = null;
        	org.eclipse.xtext.xbase.annotations.services.XbaseWithAnnotationsGrammarAccess.XAnnotationElementValueElements elementAccess = grammarAccess.getXAnnotationElementValueAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXAnnotationElementValue_in_entryRuleXAnnotationElementValue7911);
            iv_ruleXAnnotationElementValue=ruleXAnnotationElementValue();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAnnotationElementValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAnnotationElementValue7921); if (state.failed) return current;
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
            int alt101=3;
            switch ( input.LA(1) ) {
            case 68:
                {
                alt101=1;
                }
                break;
            case 69:
                {
                int LA101_2 = input.LA(2);
                if ( (LA101_2==70) ) {
                    int LA101_4 = input.LA(3);
                    if ( ((LA101_4>=RULE_ID && LA101_4<=RULE_RICH_TEXT_START)||(LA101_4>=RULE_HEX && LA101_4<=RULE_DECIMAL)||LA101_4==25||(LA101_4>=27 && LA101_4<=28)||(LA101_4>=31 && LA101_4<=33)||(LA101_4>=35 && LA101_4<=37)||(LA101_4>=39 && LA101_4<=40)||(LA101_4>=42 && LA101_4<=50)||(LA101_4>=53 && LA101_4<=55)||LA101_4==57||(LA101_4>=69 && LA101_4<=71)||(LA101_4>=90 && LA101_4<=91)||LA101_4==96||LA101_4==102||LA101_4==104||(LA101_4>=107 && LA101_4<=117)) ) {
                        alt101=3;
                    }
                    else if ( (LA101_4==68) ) {
                        alt101=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 101, 4, input);
                        throw nvae;
                    }
                }
                else if ( (LA101_2==33) ) {
                    alt101=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 101, 2, input);
                    throw nvae;
                }
                }
                break;
            case RULE_ID:
            case RULE_STRING:
            case RULE_RICH_TEXT:
            case RULE_RICH_TEXT_START:
            case RULE_HEX:
            case RULE_INT:
            case RULE_DECIMAL:
            case 25:
            case 27:
            case 28:
            case 31:
            case 32:
            case 33:
            case 35:
            case 36:
            case 37:
            case 39:
            case 40:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 53:
            case 54:
            case 55:
            case 57:
            case 70:
            case 90:
            case 91:
            case 96:
            case 102:
            case 104:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
                {
                alt101=3;
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
                    current = callUnassignedRuleXAnnotation(FOLLOW_ruleXAnnotation_in_ruleXAnnotationElementValue7968, elementAccess.getXAnnotationParserRuleCall_0());
                    if (state.failed) return current;

                    }
                    break;
                case 2 :
                    {

                    {

                    {
                    if ( state.backtracking==0 ) {
                              current = forceCreateModelElement(
                                  elementAccess.getXListLiteralAction_1_0(),
                                  current);
                    }
                    }

                    {

                    {
                    if (!consumeUnassignedToken(69, FOLLOW_69_in_ruleXAnnotationElementValue8019,  elementAccess.getNumberSignKeyword_1_1_0_0())) { return current; }

                    if (!consumeUnassignedToken(70, FOLLOW_70_in_ruleXAnnotationElementValue8031,  elementAccess.getLeftSquareBracketKeyword_1_1_0_1())) { return current; }


                    {

                    {
                    current = callRuleXAnnotationAndAdd(FOLLOW_ruleXAnnotation_in_ruleXAnnotationElementValue8052, current, elementAccess.getElementsXAnnotationParserRuleCall_1_1_0_2_0(), elementAccess.getRule(), XLIST_LITERAL__ELEMENTS, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    }
                    loop100:
                    do {
                        int alt100=2;
                        int LA100_0 = input.LA(1);
                        if ( (LA100_0==29) ) {
                            alt100=1;
                        }
                        switch (alt100) {
                    	case 1 :
                    	    {
                    	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXAnnotationElementValue8067,  elementAccess.getCommaKeyword_1_2_0())) { return current; }


                    	    {

                    	    {
                    	    current = callRuleXAnnotationAndAdd(FOLLOW_ruleXAnnotation_in_ruleXAnnotationElementValue8088, current, elementAccess.getElementsXAnnotationParserRuleCall_1_2_1_0(), elementAccess.getRule(), XLIST_LITERAL__ELEMENTS, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop100;
                        }
                    } while (true);
                    if (!consumeUnassignedToken(71, FOLLOW_71_in_ruleXAnnotationElementValue8102,  elementAccess.getRightSquareBracketKeyword_1_3())) { return current; }

                    }
                    }
                    break;
                case 3 :
                    {
                    current = callUnassignedRuleXExpression(FOLLOW_ruleXExpression_in_ruleXAnnotationElementValue8131, elementAccess.getXExpressionParserRuleCall_2());
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

    public final EObject entryRuleXExpression() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXExpression = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XExpressionElements elementAccess = grammarAccess.getXExpressionAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXExpression_in_entryRuleXExpression8172);
            iv_ruleXExpression=ruleXExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpression8182); if (state.failed) return current;
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
            current = callUnassignedRuleXAssignment(FOLLOW_ruleXAssignment_in_ruleXExpression8228, elementAccess.getXAssignmentParserRuleCall());
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
            pushFollow(FOLLOW_ruleXAssignment_in_entryRuleXAssignment8268);
            iv_ruleXAssignment=ruleXAssignment();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAssignment8278); if (state.failed) return current;
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
            int alt103=2;
            alt103 = dfa103.predict(input);
            switch (alt103) {
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
                    current = callRuleFeatureCallID(FOLLOW_ruleFeatureCallID_in_ruleXAssignment8336, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_0_1_0(), elementAccess.getRule());
                    if (state.failed) return current;

                    }
                    }
                    if ( state.backtracking==0 ) {
                              newCompositeNode(elementAccess.getOpSingleAssignParserRuleCall_0_2()); 
                    }
                    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXAssignment8352);
                    ruleOpSingleAssign();
                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                              afterParserOrEnumRuleCall();
                    }

                    {

                    {
                    current = callRuleXAssignmentAndSet(FOLLOW_ruleXAssignment_in_ruleXAssignment8372, current, elementAccess.getValueXAssignmentParserRuleCall_0_3_0(), elementAccess.getRule(), XASSIGNMENT__VALUE, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    }
                    break;
                case 2 :
                    {

                    {
                    current = callUnassignedRuleXOrExpression(FOLLOW_ruleXOrExpression_in_ruleXAssignment8402, elementAccess.getXOrExpressionParserRuleCall_1_0());
                    if (state.failed) return current;

                    int alt102=2;
                    int LA102_0 = input.LA(1);
                    if ( (LA102_0==72) ) {
                        int LA102_1 = input.LA(2);
                        if ( (synpred11_InternalXtend()) ) {
                            alt102=1;
                        }
                    }
                    else if ( (LA102_0==73) ) {
                        int LA102_2 = input.LA(2);
                        if ( (synpred11_InternalXtend()) ) {
                            alt102=1;
                        }
                    }
                    switch (alt102) {
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
                            current = callRuleOpMultiAssign(FOLLOW_ruleOpMultiAssign_in_ruleXAssignment8455, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0(), elementAccess.getRule());
                            if (state.failed) return current;

                            }
                            }
                            }
                            }

                            {

                            {
                            current = callRuleXAssignmentAndSet(FOLLOW_ruleXAssignment_in_ruleXAssignment8478, current, elementAccess.getRightOperandXAssignmentParserRuleCall_1_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
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
            pushFollow(FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign8524);
            iv_ruleOpSingleAssign=ruleOpSingleAssign();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpSingleAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpSingleAssign8535); if (state.failed) return current;
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
            if (!consumeTokenAndMerge(38, FOLLOW_38_in_ruleOpSingleAssign8572, current,  elementAccess.getEqualsSignKeyword())) { return current; }

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
            pushFollow(FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign8618);
            iv_ruleOpMultiAssign=ruleOpMultiAssign();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMultiAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMultiAssign8629); if (state.failed) return current;
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
            int alt104=2;
            int LA104_0 = input.LA(1);
            if ( (LA104_0==72) ) {
                alt104=1;
            }
            else if ( (LA104_0==73) ) {
                alt104=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);
                throw nvae;
            }
            switch (alt104) {
                case 1 :
                    {
                    if (!consumeTokenAndMerge(72, FOLLOW_72_in_ruleOpMultiAssign8667, current,  elementAccess.getPlusSignEqualsSignKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(73, FOLLOW_73_in_ruleOpMultiAssign8686, current,  elementAccess.getHyphenMinusEqualsSignKeyword_1())) { return current; }

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
            pushFollow(FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression8732);
            iv_ruleXOrExpression=ruleXOrExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOrExpression8742); if (state.failed) return current;
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
            current = callUnassignedRuleXAndExpression(FOLLOW_ruleXAndExpression_in_ruleXOrExpression8789, elementAccess.getXAndExpressionParserRuleCall_0());
            if (state.failed) return current;

            loop105:
            do {
                int alt105=2;
                int LA105_0 = input.LA(1);
                if ( (LA105_0==74) ) {
                    int LA105_2 = input.LA(2);
                    if ( (synpred12_InternalXtend()) ) {
                        alt105=1;
                    }
                }
                switch (alt105) {
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
            	    current = callRuleOpOr(FOLLOW_ruleOpOr_in_ruleXOrExpression8842, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleXAndExpressionAndSet(FOLLOW_ruleXAndExpression_in_ruleXOrExpression8865, current, elementAccess.getRightOperandXAndExpressionParserRuleCall_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    break;
            	default :
            	    break loop105;
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
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr8910);
            iv_ruleOpOr=ruleOpOr();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr8921); if (state.failed) return current;
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
            if (!consumeTokenAndMerge(74, FOLLOW_74_in_ruleOpOr8958, current,  elementAccess.getVerticalLineVerticalLineKeyword())) { return current; }

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
            pushFollow(FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression9003);
            iv_ruleXAndExpression=ruleXAndExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAndExpression9013); if (state.failed) return current;
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
            current = callUnassignedRuleXEqualityExpression(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression9060, elementAccess.getXEqualityExpressionParserRuleCall_0());
            if (state.failed) return current;

            loop106:
            do {
                int alt106=2;
                int LA106_0 = input.LA(1);
                if ( (LA106_0==75) ) {
                    int LA106_2 = input.LA(2);
                    if ( (synpred13_InternalXtend()) ) {
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
            	    current = callRuleOpAnd(FOLLOW_ruleOpAnd_in_ruleXAndExpression9113, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleXEqualityExpressionAndSet(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression9136, current, elementAccess.getRightOperandXEqualityExpressionParserRuleCall_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
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

    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleOpAnd = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpAndElements elementAccess = grammarAccess.getOpAndAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd9181);
            iv_ruleOpAnd=ruleOpAnd();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd9192); if (state.failed) return current;
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
            if (!consumeTokenAndMerge(75, FOLLOW_75_in_ruleOpAnd9229, current,  elementAccess.getAmpersandAmpersandKeyword())) { return current; }

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
            pushFollow(FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression9274);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXEqualityExpression9284); if (state.failed) return current;
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
            current = callUnassignedRuleXRelationalExpression(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression9331, elementAccess.getXRelationalExpressionParserRuleCall_0());
            if (state.failed) return current;

            loop107:
            do {
                int alt107=2;
                switch ( input.LA(1) ) {
                case 76:
                    {
                    int LA107_2 = input.LA(2);
                    if ( (synpred14_InternalXtend()) ) {
                        alt107=1;
                    }
                    }
                    break;
                case 77:
                    {
                    int LA107_3 = input.LA(2);
                    if ( (synpred14_InternalXtend()) ) {
                        alt107=1;
                    }
                    }
                    break;
                case 78:
                    {
                    int LA107_4 = input.LA(2);
                    if ( (synpred14_InternalXtend()) ) {
                        alt107=1;
                    }
                    }
                    break;
                case 79:
                    {
                    int LA107_5 = input.LA(2);
                    if ( (synpred14_InternalXtend()) ) {
                        alt107=1;
                    }
                    }
                    break;
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
            	    current = callRuleOpEquality(FOLLOW_ruleOpEquality_in_ruleXEqualityExpression9384, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleXRelationalExpressionAndSet(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression9407, current, elementAccess.getRightOperandXRelationalExpressionParserRuleCall_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
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

    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleOpEquality = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpEqualityElements elementAccess = grammarAccess.getOpEqualityAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality9452);
            iv_ruleOpEquality=ruleOpEquality();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality9463); if (state.failed) return current;
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
            int alt108=4;
            switch ( input.LA(1) ) {
            case 76:
                {
                alt108=1;
                }
                break;
            case 77:
                {
                alt108=2;
                }
                break;
            case 78:
                {
                alt108=3;
                }
                break;
            case 79:
                {
                alt108=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);
                throw nvae;
            }
            switch (alt108) {
                case 1 :
                    {
                    if (!consumeTokenAndMerge(76, FOLLOW_76_in_ruleOpEquality9501, current,  elementAccess.getEqualsSignEqualsSignKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(77, FOLLOW_77_in_ruleOpEquality9520, current,  elementAccess.getExclamationMarkEqualsSignKeyword_1())) { return current; }

                    }
                    break;
                case 3 :
                    {
                    if (!consumeTokenAndMerge(78, FOLLOW_78_in_ruleOpEquality9539, current,  elementAccess.getEqualsSignEqualsSignEqualsSignKeyword_2())) { return current; }

                    }
                    break;
                case 4 :
                    {
                    if (!consumeTokenAndMerge(79, FOLLOW_79_in_ruleOpEquality9558, current,  elementAccess.getExclamationMarkEqualsSignEqualsSignKeyword_3())) { return current; }

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
            pushFollow(FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression9604);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXRelationalExpression9614); if (state.failed) return current;
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
            current = callUnassignedRuleXOtherOperatorExpression(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression9661, elementAccess.getXOtherOperatorExpressionParserRuleCall_0());
            if (state.failed) return current;

            loop109:
            do {
                int alt109=3;
                switch ( input.LA(1) ) {
                case 28:
                    {
                    int LA109_2 = input.LA(2);
                    if ( (synpred16_InternalXtend()) ) {
                        alt109=2;
                    }
                    }
                    break;
                case 30:
                    {
                    int LA109_3 = input.LA(2);
                    if ( (synpred16_InternalXtend()) ) {
                        alt109=2;
                    }
                    }
                    break;
                case 80:
                    {
                    int LA109_4 = input.LA(2);
                    if ( (synpred15_InternalXtend()) ) {
                        alt109=1;
                    }
                    }
                    break;
                case 81:
                    {
                    int LA109_5 = input.LA(2);
                    if ( (synpred16_InternalXtend()) ) {
                        alt109=2;
                    }
                    }
                    break;
                case 82:
                    {
                    int LA109_6 = input.LA(2);
                    if ( (synpred16_InternalXtend()) ) {
                        alt109=2;
                    }
                    }
                    break;
                }
                switch (alt109) {
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
            	    if (!consumeUnassignedToken(80, FOLLOW_80_in_ruleXRelationalExpression9697,  elementAccess.getInstanceofKeyword_1_0_0_0_1())) { return current; }

            	    }
            	    }

            	    {

            	    {
            	    current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleXRelationalExpression9720, current, elementAccess.getTypeJvmTypeReferenceParserRuleCall_1_0_1_0(), elementAccess.getRule(), XINSTANCE_OF_EXPRESSION__TYPE, null);
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
            	    current = callRuleOpCompare(FOLLOW_ruleOpCompare_in_ruleXRelationalExpression9781, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleXOtherOperatorExpressionAndSet(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression9804, current, elementAccess.getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }
            	    break;
            	default :
            	    break loop109;
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
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare9850);
            iv_ruleOpCompare=ruleOpCompare();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare9861); if (state.failed) return current;
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
            int alt110=4;
            switch ( input.LA(1) ) {
            case 81:
                {
                alt110=1;
                }
                break;
            case 82:
                {
                alt110=2;
                }
                break;
            case 30:
                {
                alt110=3;
                }
                break;
            case 28:
                {
                alt110=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);
                throw nvae;
            }
            switch (alt110) {
                case 1 :
                    {
                    if (!consumeTokenAndMerge(81, FOLLOW_81_in_ruleOpCompare9899, current,  elementAccess.getGreaterThanSignEqualsSignKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(82, FOLLOW_82_in_ruleOpCompare9918, current,  elementAccess.getLessThanSignEqualsSignKeyword_1())) { return current; }

                    }
                    break;
                case 3 :
                    {
                    if (!consumeTokenAndMerge(30, FOLLOW_30_in_ruleOpCompare9937, current,  elementAccess.getGreaterThanSignKeyword_2())) { return current; }

                    }
                    break;
                case 4 :
                    {
                    if (!consumeTokenAndMerge(28, FOLLOW_28_in_ruleOpCompare9956, current,  elementAccess.getLessThanSignKeyword_3())) { return current; }

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
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression10002);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOtherOperatorExpression10012); if (state.failed) return current;
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
            current = callUnassignedRuleXAdditiveExpression(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression10059, elementAccess.getXAdditiveExpressionParserRuleCall_0());
            if (state.failed) return current;

            loop111:
            do {
                int alt111=2;
                alt111 = dfa111.predict(input);
                switch (alt111) {
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
            	    current = callRuleOpOther(FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression10112, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleXAdditiveExpressionAndSet(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression10135, current, elementAccess.getRightOperandXAdditiveExpressionParserRuleCall_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    break;
            	default :
            	    break loop111;
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
            pushFollow(FOLLOW_ruleOpOther_in_entryRuleOpOther10180);
            iv_ruleOpOther=ruleOpOther();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOther10191); if (state.failed) return current;
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
            int alt114=10;
            alt114 = dfa114.predict(input);
            switch (alt114) {
                case 1 :
                    {
                    if (!consumeTokenAndMerge(83, FOLLOW_83_in_ruleOpOther10229, current,  elementAccess.getHyphenMinusGreaterThanSignKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(84, FOLLOW_84_in_ruleOpOther10248, current,  elementAccess.getFullStopFullStopLessThanSignKeyword_1())) { return current; }

                    }
                    break;
                case 3 :
                    {

                    {
                    if (!consumeTokenAndMerge(30, FOLLOW_30_in_ruleOpOther10268, current,  elementAccess.getGreaterThanSignKeyword_2_0())) { return current; }

                    if (!consumeTokenAndMerge(85, FOLLOW_85_in_ruleOpOther10281, current,  elementAccess.getFullStopFullStopKeyword_2_1())) { return current; }

                    }
                    }
                    break;
                case 4 :
                    {
                    if (!consumeTokenAndMerge(85, FOLLOW_85_in_ruleOpOther10301, current,  elementAccess.getFullStopFullStopKeyword_3())) { return current; }

                    }
                    break;
                case 5 :
                    {
                    if (!consumeTokenAndMerge(86, FOLLOW_86_in_ruleOpOther10320, current,  elementAccess.getEqualsSignGreaterThanSignKeyword_4())) { return current; }

                    }
                    break;
                case 6 :
                    {

                    {
                    if (!consumeTokenAndMerge(30, FOLLOW_30_in_ruleOpOther10340, current,  elementAccess.getGreaterThanSignKeyword_5_0())) { return current; }

                    int alt112=2;
                    int LA112_0 = input.LA(1);
                    if ( (LA112_0==30) ) {
                        int LA112_1 = input.LA(2);
                        if ( (LA112_1==EOF||(LA112_1>=RULE_ID && LA112_1<=RULE_RICH_TEXT_START)||(LA112_1>=RULE_HEX && LA112_1<=RULE_DECIMAL)||LA112_1==25||(LA112_1>=27 && LA112_1<=28)||(LA112_1>=31 && LA112_1<=33)||(LA112_1>=35 && LA112_1<=37)||(LA112_1>=39 && LA112_1<=40)||(LA112_1>=42 && LA112_1<=50)||(LA112_1>=53 && LA112_1<=55)||LA112_1==57||(LA112_1>=69 && LA112_1<=70)||(LA112_1>=90 && LA112_1<=91)||LA112_1==96||LA112_1==102||LA112_1==104||(LA112_1>=107 && LA112_1<=117)) ) {
                            alt112=2;
                        }
                        else if ( (LA112_1==30) && (synpred18_InternalXtend())) {
                            alt112=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 112, 1, input);
                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 112, 0, input);
                        throw nvae;
                    }
                    switch (alt112) {
                        case 1 :
                            {

                            {

                            {
                            if (!consumeTokenAndMerge(30, FOLLOW_30_in_ruleOpOther10371, current,  elementAccess.getGreaterThanSignKeyword_5_1_0_0_0())) { return current; }

                            if (!consumeTokenAndMerge(30, FOLLOW_30_in_ruleOpOther10384, current,  elementAccess.getGreaterThanSignKeyword_5_1_0_0_1())) { return current; }

                            }
                            }
                            }
                            break;
                        case 2 :
                            {
                            if (!consumeTokenAndMerge(30, FOLLOW_30_in_ruleOpOther10405, current,  elementAccess.getGreaterThanSignKeyword_5_1_1())) { return current; }

                            }
                            break;
                    }
                    }
                    }
                    break;
                case 7 :
                    {

                    {
                    if (!consumeTokenAndMerge(28, FOLLOW_28_in_ruleOpOther10427, current,  elementAccess.getLessThanSignKeyword_6_0())) { return current; }

                    int alt113=2;
                    int LA113_0 = input.LA(1);
                    if ( (LA113_0==28) ) {
                        int LA113_1 = input.LA(2);
                        if ( (synpred19_InternalXtend()) ) {
                            alt113=1;
                        }
                        else if ( (true) ) {
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
                            if (!consumeTokenAndMerge(28, FOLLOW_28_in_ruleOpOther10458, current,  elementAccess.getLessThanSignKeyword_6_1_0_0_0())) { return current; }

                            if (!consumeTokenAndMerge(28, FOLLOW_28_in_ruleOpOther10471, current,  elementAccess.getLessThanSignKeyword_6_1_0_0_1())) { return current; }

                            }
                            }
                            }
                            break;
                        case 2 :
                            {
                            if (!consumeTokenAndMerge(28, FOLLOW_28_in_ruleOpOther10492, current,  elementAccess.getLessThanSignKeyword_6_1_1())) { return current; }

                            }
                            break;
                    }
                    }
                    }
                    break;
                case 8 :
                    {
                    if (!consumeTokenAndMerge(87, FOLLOW_87_in_ruleOpOther10513, current,  elementAccess.getLessThanSignGreaterThanSignKeyword_7())) { return current; }

                    }
                    break;
                case 9 :
                    {
                    if (!consumeTokenAndMerge(88, FOLLOW_88_in_ruleOpOther10532, current,  elementAccess.getQuestionMarkColonKeyword_8())) { return current; }

                    }
                    break;
                case 10 :
                    {
                    if (!consumeTokenAndMerge(89, FOLLOW_89_in_ruleOpOther10551, current,  elementAccess.getLessThanSignEqualsSignGreaterThanSignKeyword_9())) { return current; }

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
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression10597);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAdditiveExpression10607); if (state.failed) return current;
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
            current = callUnassignedRuleXMultiplicativeExpression(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression10654, elementAccess.getXMultiplicativeExpressionParserRuleCall_0());
            if (state.failed) return current;

            loop115:
            do {
                int alt115=2;
                int LA115_0 = input.LA(1);
                if ( (LA115_0==91) ) {
                    int LA115_2 = input.LA(2);
                    if ( (synpred20_InternalXtend()) ) {
                        alt115=1;
                    }
                }
                else if ( (LA115_0==90) ) {
                    int LA115_3 = input.LA(2);
                    if ( (synpred20_InternalXtend()) ) {
                        alt115=1;
                    }
                }
                switch (alt115) {
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
            	    current = callRuleOpAdd(FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression10707, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleXMultiplicativeExpressionAndSet(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression10730, current, elementAccess.getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    break;
            	default :
            	    break loop115;
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
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd10775);
            iv_ruleOpAdd=ruleOpAdd();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd10786); if (state.failed) return current;
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
            int alt116=2;
            int LA116_0 = input.LA(1);
            if ( (LA116_0==90) ) {
                alt116=1;
            }
            else if ( (LA116_0==91) ) {
                alt116=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);
                throw nvae;
            }
            switch (alt116) {
                case 1 :
                    {
                    if (!consumeTokenAndMerge(90, FOLLOW_90_in_ruleOpAdd10824, current,  elementAccess.getPlusSignKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(91, FOLLOW_91_in_ruleOpAdd10843, current,  elementAccess.getHyphenMinusKeyword_1())) { return current; }

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
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression10889);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMultiplicativeExpression10899); if (state.failed) return current;
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
            current = callUnassignedRuleXUnaryOperation(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression10946, elementAccess.getXUnaryOperationParserRuleCall_0());
            if (state.failed) return current;

            loop117:
            do {
                int alt117=2;
                switch ( input.LA(1) ) {
                case 92:
                    {
                    int LA117_2 = input.LA(2);
                    if ( (synpred21_InternalXtend()) ) {
                        alt117=1;
                    }
                    }
                    break;
                case 93:
                    {
                    int LA117_3 = input.LA(2);
                    if ( (synpred21_InternalXtend()) ) {
                        alt117=1;
                    }
                    }
                    break;
                case 94:
                    {
                    int LA117_4 = input.LA(2);
                    if ( (synpred21_InternalXtend()) ) {
                        alt117=1;
                    }
                    }
                    break;
                case 95:
                    {
                    int LA117_5 = input.LA(2);
                    if ( (synpred21_InternalXtend()) ) {
                        alt117=1;
                    }
                    }
                    break;
                }
                switch (alt117) {
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
            	    current = callRuleOpMulti(FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression10999, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleXUnaryOperationAndSet(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression11022, current, elementAccess.getRightOperandXUnaryOperationParserRuleCall_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    break;
            	default :
            	    break loop117;
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
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti11067);
            iv_ruleOpMulti=ruleOpMulti();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti11078); if (state.failed) return current;
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
            int alt118=4;
            switch ( input.LA(1) ) {
            case 92:
                {
                alt118=1;
                }
                break;
            case 93:
                {
                alt118=2;
                }
                break;
            case 94:
                {
                alt118=3;
                }
                break;
            case 95:
                {
                alt118=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 118, 0, input);
                throw nvae;
            }
            switch (alt118) {
                case 1 :
                    {
                    if (!consumeTokenAndMerge(92, FOLLOW_92_in_ruleOpMulti11116, current,  elementAccess.getAsteriskKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(93, FOLLOW_93_in_ruleOpMulti11135, current,  elementAccess.getAsteriskAsteriskKeyword_1())) { return current; }

                    }
                    break;
                case 3 :
                    {
                    if (!consumeTokenAndMerge(94, FOLLOW_94_in_ruleOpMulti11154, current,  elementAccess.getSolidusKeyword_2())) { return current; }

                    }
                    break;
                case 4 :
                    {
                    if (!consumeTokenAndMerge(95, FOLLOW_95_in_ruleOpMulti11173, current,  elementAccess.getPercentSignKeyword_3())) { return current; }

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
            pushFollow(FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation11219);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXUnaryOperation11229); if (state.failed) return current;
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
            int alt119=2;
            int LA119_0 = input.LA(1);
            if ( ((LA119_0>=90 && LA119_0<=91)||LA119_0==96) ) {
                alt119=1;
            }
            else if ( ((LA119_0>=RULE_ID && LA119_0<=RULE_RICH_TEXT_START)||(LA119_0>=RULE_HEX && LA119_0<=RULE_DECIMAL)||LA119_0==25||(LA119_0>=27 && LA119_0<=28)||(LA119_0>=31 && LA119_0<=33)||(LA119_0>=35 && LA119_0<=37)||(LA119_0>=39 && LA119_0<=40)||(LA119_0>=42 && LA119_0<=50)||(LA119_0>=53 && LA119_0<=55)||LA119_0==57||(LA119_0>=69 && LA119_0<=70)||LA119_0==102||LA119_0==104||(LA119_0>=107 && LA119_0<=117)) ) {
                alt119=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 119, 0, input);
                throw nvae;
            }
            switch (alt119) {
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
                    current = callRuleOpUnary(FOLLOW_ruleOpUnary_in_ruleXUnaryOperation11287, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_0_1_0(), elementAccess.getRule());
                    if (state.failed) return current;

                    }
                    }

                    {

                    {
                    current = callRuleXUnaryOperationAndSet(FOLLOW_ruleXUnaryOperation_in_ruleXUnaryOperation11308, current, elementAccess.getOperandXUnaryOperationParserRuleCall_0_2_0(), elementAccess.getRule(), XUNARY_OPERATION__OPERAND, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    }
                    break;
                case 2 :
                    {
                    current = callUnassignedRuleXCastedExpression(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation11337, elementAccess.getXCastedExpressionParserRuleCall_1());
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
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary11379);
            iv_ruleOpUnary=ruleOpUnary();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary11390); if (state.failed) return current;
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
            int alt120=3;
            switch ( input.LA(1) ) {
            case 96:
                {
                alt120=1;
                }
                break;
            case 91:
                {
                alt120=2;
                }
                break;
            case 90:
                {
                alt120=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 120, 0, input);
                throw nvae;
            }
            switch (alt120) {
                case 1 :
                    {
                    if (!consumeTokenAndMerge(96, FOLLOW_96_in_ruleOpUnary11428, current,  elementAccess.getExclamationMarkKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(91, FOLLOW_91_in_ruleOpUnary11447, current,  elementAccess.getHyphenMinusKeyword_1())) { return current; }

                    }
                    break;
                case 3 :
                    {
                    if (!consumeTokenAndMerge(90, FOLLOW_90_in_ruleOpUnary11466, current,  elementAccess.getPlusSignKeyword_2())) { return current; }

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
            pushFollow(FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression11512);
            iv_ruleXCastedExpression=ruleXCastedExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCastedExpression11522); if (state.failed) return current;
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
            current = callUnassignedRuleXMemberFeatureCall(FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression11569, elementAccess.getXMemberFeatureCallParserRuleCall_0());
            if (state.failed) return current;

            loop121:
            do {
                int alt121=2;
                int LA121_0 = input.LA(1);
                if ( (LA121_0==97) ) {
                    int LA121_2 = input.LA(2);
                    if ( (synpred22_InternalXtend()) ) {
                        alt121=1;
                    }
                }
                switch (alt121) {
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
            	    if (!consumeUnassignedToken(97, FOLLOW_97_in_ruleXCastedExpression11604,  elementAccess.getAsKeyword_1_0_0_1())) { return current; }

            	    }
            	    }

            	    {

            	    {
            	    current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression11627, current, elementAccess.getTypeJvmTypeReferenceParserRuleCall_1_1_0(), elementAccess.getRule(), XCASTED_EXPRESSION__TYPE, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    break;
            	default :
            	    break loop121;
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
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall11671);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMemberFeatureCall11681); if (state.failed) return current;
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
            current = callUnassignedRuleXPrimaryExpression(FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall11728, elementAccess.getXPrimaryExpressionParserRuleCall_0());
            if (state.failed) return current;

            loop130:
            do {
                int alt130=3;
                switch ( input.LA(1) ) {
                case 98:
                    {
                    int LA130_2 = input.LA(2);
                    if ( (synpred23_InternalXtend()) ) {
                        alt130=1;
                    }
                    else if ( (synpred24_InternalXtend()) ) {
                        alt130=2;
                    }
                    }
                    break;
                case 99:
                    {
                    int LA130_3 = input.LA(2);
                    if ( (synpred23_InternalXtend()) ) {
                        alt130=1;
                    }
                    else if ( (synpred24_InternalXtend()) ) {
                        alt130=2;
                    }
                    }
                    break;
                case 100:
                    {
                    int LA130_4 = input.LA(2);
                    if ( (synpred24_InternalXtend()) ) {
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
            	    int alt122=2;
            	    int LA122_0 = input.LA(1);
            	    if ( (LA122_0==98) ) {
            	        alt122=1;
            	    }
            	    else if ( (LA122_0==99) ) {
            	        alt122=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 122, 0, input);
            	        throw nvae;
            	    }
            	    switch (alt122) {
            	        case 1 :
            	            {
            	            if (!consumeUnassignedToken(98, FOLLOW_98_in_ruleXMemberFeatureCall11800,  elementAccess.getFullStopKeyword_1_0_0_0_1_0())) { return current; }

            	            }
            	            break;
            	        case 2 :
            	            {

            	            {

            	            {
            	            current = consumeTokenAndSetBooleanValue(99, FOLLOW_99_in_ruleXMemberFeatureCall11824, current,  elementAccess.getExplicitStaticColonColonKeyword_1_0_0_0_1_1_0(), elementAccess.getRule(), XASSIGNMENT__EXPLICIT_STATIC);
            	            if (state.failed) return current;

            	            }
            	            }
            	            }
            	            break;
            	    }

            	    {

            	    {
            	    current = callRuleFeatureCallID(FOLLOW_ruleFeatureCallID_in_ruleXMemberFeatureCall11861, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    if ( state.backtracking==0 ) {
            	              newCompositeNode(elementAccess.getOpSingleAssignParserRuleCall_1_0_0_0_3()); 
            	    }
            	    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall11877);
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
            	    current = callRuleXAssignmentAndSet(FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall11899, current, elementAccess.getValueXAssignmentParserRuleCall_1_0_1_0(), elementAccess.getRule(), XASSIGNMENT__VALUE, null);
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
            	    case 98:
            	        {
            	        alt123=1;
            	        }
            	        break;
            	    case 100:
            	        {
            	        alt123=2;
            	        }
            	        break;
            	    case 99:
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
            	            if (!consumeUnassignedToken(98, FOLLOW_98_in_ruleXMemberFeatureCall11985,  elementAccess.getFullStopKeyword_1_1_0_0_1_0())) { return current; }

            	            }
            	            break;
            	        case 2 :
            	            {

            	            {

            	            {
            	            current = consumeTokenAndSetBooleanValue(100, FOLLOW_100_in_ruleXMemberFeatureCall12009, current,  elementAccess.getNullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__NULL_SAFE);
            	            if (state.failed) return current;

            	            }
            	            }
            	            }
            	            break;
            	        case 3 :
            	            {

            	            {

            	            {
            	            current = consumeTokenAndSetBooleanValue(99, FOLLOW_99_in_ruleXMemberFeatureCall12046, current,  elementAccess.getExplicitStaticColonColonKeyword_1_1_0_0_1_2_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__EXPLICIT_STATIC);
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
            	    if ( (LA125_0==28) ) {
            	        alt125=1;
            	    }
            	    switch (alt125) {
            	        case 1 :
            	            {
            	            if (!consumeUnassignedToken(28, FOLLOW_28_in_ruleXMemberFeatureCall12075,  elementAccess.getLessThanSignKeyword_1_1_1_0())) { return current; }


            	            {

            	            {
            	            current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall12096, current, elementAccess.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__TYPE_ARGUMENTS, null);
            	            if (state.failed) return current;

            	            }
            	            }
            	            loop124:
            	            do {
            	                int alt124=2;
            	                int LA124_0 = input.LA(1);
            	                if ( (LA124_0==29) ) {
            	                    alt124=1;
            	                }
            	                switch (alt124) {
            	            	case 1 :
            	            	    {
            	            	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXMemberFeatureCall12109,  elementAccess.getCommaKeyword_1_1_1_2_0())) { return current; }


            	            	    {

            	            	    {
            	            	    current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall12130, current, elementAccess.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__TYPE_ARGUMENTS, null);
            	            	    if (state.failed) return current;

            	            	    }
            	            	    }
            	            	    }
            	            	    break;
            	            	default :
            	            	    break loop124;
            	                }
            	            } while (true);
            	            if (!consumeUnassignedToken(30, FOLLOW_30_in_ruleXMemberFeatureCall12144,  elementAccess.getGreaterThanSignKeyword_1_1_1_3())) { return current; }

            	            }
            	            break;
            	    }

            	    {

            	    {
            	    current = callRuleFeatureCallID(FOLLOW_ruleFeatureCallID_in_ruleXMemberFeatureCall12169, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_1_2_0(), elementAccess.getRule());
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
            	            current = consumeTokenAndSetBooleanValue(40, FOLLOW_40_in_ruleXMemberFeatureCall12203, current,  elementAccess.getExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__EXPLICIT_OPERATION_CALL);
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
            	                    current = callRuleXShortClosureAndAdd(FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall12288, current, elementAccess.getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS, null);
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
            	                    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall12316, current, elementAccess.getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS, null);
            	                    if (state.failed) return current;

            	                    }
            	                    }
            	                    loop126:
            	                    do {
            	                        int alt126=2;
            	                        int LA126_0 = input.LA(1);
            	                        if ( (LA126_0==29) ) {
            	                            alt126=1;
            	                        }
            	                        switch (alt126) {
            	                    	case 1 :
            	                    	    {
            	                    	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXMemberFeatureCall12329,  elementAccess.getCommaKeyword_1_1_3_1_1_1_0())) { return current; }


            	                    	    {

            	                    	    {
            	                    	    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall12350, current, elementAccess.getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS, null);
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
            	            if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXMemberFeatureCall12367,  elementAccess.getRightParenthesisKeyword_1_1_3_2())) { return current; }

            	            }
            	            break;
            	    }
            	    int alt129=2;
            	    alt129 = dfa129.predict(input);
            	    switch (alt129) {
            	        case 1 :
            	            {

            	            {
            	            current = callRuleXClosureAndAdd(FOLLOW_ruleXClosure_in_ruleXMemberFeatureCall12402, current, elementAccess.getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS, null);
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
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression12448);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXPrimaryExpression12458); if (state.failed) return current;
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
                    current = callUnassignedRuleXConstructorCall(FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression12505, elementAccess.getXConstructorCallParserRuleCall_0());
                    if (state.failed) return current;

                    }
                    break;
                case 2 :
                    {
                    current = callUnassignedRuleXBlockExpression(FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression12532, elementAccess.getXBlockExpressionParserRuleCall_1());
                    if (state.failed) return current;

                    }
                    break;
                case 3 :
                    {
                    current = callUnassignedRuleXSwitchExpression(FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression12559, elementAccess.getXSwitchExpressionParserRuleCall_2());
                    if (state.failed) return current;

                    }
                    break;
                case 4 :
                    {
                    current = callUnassignedRuleXFeatureCall(FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression12586, elementAccess.getXFeatureCallParserRuleCall_3());
                    if (state.failed) return current;

                    }
                    break;
                case 5 :
                    {
                    current = callUnassignedRuleXLiteral(FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression12613, elementAccess.getXLiteralParserRuleCall_4());
                    if (state.failed) return current;

                    }
                    break;
                case 6 :
                    {
                    current = callUnassignedRuleXIfExpression(FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression12640, elementAccess.getXIfExpressionParserRuleCall_5());
                    if (state.failed) return current;

                    }
                    break;
                case 7 :
                    {
                    current = callUnassignedRuleXForLoopExpression(FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression12667, elementAccess.getXForLoopExpressionParserRuleCall_6());
                    if (state.failed) return current;

                    }
                    break;
                case 8 :
                    {
                    current = callUnassignedRuleXWhileExpression(FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression12694, elementAccess.getXWhileExpressionParserRuleCall_7());
                    if (state.failed) return current;

                    }
                    break;
                case 9 :
                    {
                    current = callUnassignedRuleXDoWhileExpression(FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression12721, elementAccess.getXDoWhileExpressionParserRuleCall_8());
                    if (state.failed) return current;

                    }
                    break;
                case 10 :
                    {
                    current = callUnassignedRuleXThrowExpression(FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression12748, elementAccess.getXThrowExpressionParserRuleCall_9());
                    if (state.failed) return current;

                    }
                    break;
                case 11 :
                    {
                    current = callUnassignedRuleXReturnExpression(FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression12775, elementAccess.getXReturnExpressionParserRuleCall_10());
                    if (state.failed) return current;

                    }
                    break;
                case 12 :
                    {
                    current = callUnassignedRuleXTryCatchFinallyExpression(FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression12802, elementAccess.getXTryCatchFinallyExpressionParserRuleCall_11());
                    if (state.failed) return current;

                    }
                    break;
                case 13 :
                    {
                    current = callUnassignedRuleXParenthesizedExpression(FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression12829, elementAccess.getXParenthesizedExpressionParserRuleCall_12());
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
            pushFollow(FOLLOW_ruleXLiteral_in_entryRuleXLiteral12870);
            iv_ruleXLiteral=ruleXLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXLiteral12880); if (state.failed) return current;
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
            if ( (LA132_0==69) ) {
                alt132=1;
            }
            else if ( (LA132_0==70) && (synpred28_InternalXtend())) {
                alt132=2;
            }
            else if ( ((LA132_0>=111 && LA132_0<=112)) ) {
                alt132=3;
            }
            else if ( ((LA132_0>=RULE_HEX && LA132_0<=RULE_DECIMAL)) ) {
                alt132=4;
            }
            else if ( (LA132_0==113) ) {
                alt132=5;
            }
            else if ( ((LA132_0>=RULE_STRING && LA132_0<=RULE_RICH_TEXT_START)) ) {
                alt132=6;
            }
            else if ( (LA132_0==114) ) {
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
                    current = callUnassignedRuleXCollectionLiteral(FOLLOW_ruleXCollectionLiteral_in_ruleXLiteral12927, elementAccess.getXCollectionLiteralParserRuleCall_0());
                    if (state.failed) return current;

                    }
                    break;
                case 2 :
                    {

                    {
                    current = callUnassignedRuleXClosure(FOLLOW_ruleXClosure_in_ruleXLiteral12967, elementAccess.getXClosureParserRuleCall_1());
                    if (state.failed) return current;

                    }
                    }
                    break;
                case 3 :
                    {
                    current = callUnassignedRuleXBooleanLiteral(FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral12995, elementAccess.getXBooleanLiteralParserRuleCall_2());
                    if (state.failed) return current;

                    }
                    break;
                case 4 :
                    {
                    current = callUnassignedRuleXNumberLiteral(FOLLOW_ruleXNumberLiteral_in_ruleXLiteral13022, elementAccess.getXNumberLiteralParserRuleCall_3());
                    if (state.failed) return current;

                    }
                    break;
                case 5 :
                    {
                    current = callUnassignedRuleXNullLiteral(FOLLOW_ruleXNullLiteral_in_ruleXLiteral13049, elementAccess.getXNullLiteralParserRuleCall_4());
                    if (state.failed) return current;

                    }
                    break;
                case 6 :
                    {
                    current = callUnassignedRuleXStringLiteral(FOLLOW_ruleXStringLiteral_in_ruleXLiteral13076, elementAccess.getXStringLiteralParserRuleCall_5());
                    if (state.failed) return current;

                    }
                    break;
                case 7 :
                    {
                    current = callUnassignedRuleXTypeLiteral(FOLLOW_ruleXTypeLiteral_in_ruleXLiteral13103, elementAccess.getXTypeLiteralParserRuleCall_6());
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
            pushFollow(FOLLOW_ruleXCollectionLiteral_in_entryRuleXCollectionLiteral13144);
            iv_ruleXCollectionLiteral=ruleXCollectionLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCollectionLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCollectionLiteral13154); if (state.failed) return current;
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
            if ( (LA133_0==69) ) {
                int LA133_1 = input.LA(2);
                if ( (LA133_1==33) ) {
                    alt133=1;
                }
                else if ( (LA133_1==70) ) {
                    alt133=2;
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
                    current = callUnassignedRuleXSetLiteral(FOLLOW_ruleXSetLiteral_in_ruleXCollectionLiteral13201, elementAccess.getXSetLiteralParserRuleCall_0());
                    if (state.failed) return current;

                    }
                    break;
                case 2 :
                    {
                    current = callUnassignedRuleXListLiteral(FOLLOW_ruleXListLiteral_in_ruleXCollectionLiteral13228, elementAccess.getXListLiteralParserRuleCall_1());
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
            pushFollow(FOLLOW_ruleXSetLiteral_in_entryRuleXSetLiteral13269);
            iv_ruleXSetLiteral=ruleXSetLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSetLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSetLiteral13279); if (state.failed) return current;
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
            if (!consumeUnassignedToken(69, FOLLOW_69_in_ruleXSetLiteral13325,  elementAccess.getNumberSignKeyword_1())) { return current; }

            if (!consumeUnassignedToken(33, FOLLOW_33_in_ruleXSetLiteral13337,  elementAccess.getLeftCurlyBracketKeyword_2())) { return current; }

            int alt135=2;
            int LA135_0 = input.LA(1);
            if ( ((LA135_0>=RULE_ID && LA135_0<=RULE_RICH_TEXT_START)||(LA135_0>=RULE_HEX && LA135_0<=RULE_DECIMAL)||LA135_0==25||(LA135_0>=27 && LA135_0<=28)||(LA135_0>=31 && LA135_0<=33)||(LA135_0>=35 && LA135_0<=37)||(LA135_0>=39 && LA135_0<=40)||(LA135_0>=42 && LA135_0<=50)||(LA135_0>=53 && LA135_0<=55)||LA135_0==57||(LA135_0>=69 && LA135_0<=70)||(LA135_0>=90 && LA135_0<=91)||LA135_0==96||LA135_0==102||LA135_0==104||(LA135_0>=107 && LA135_0<=117)) ) {
                alt135=1;
            }
            switch (alt135) {
                case 1 :
                    {

                    {

                    {
                    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXSetLiteral13359, current, elementAccess.getElementsXExpressionParserRuleCall_3_0_0(), elementAccess.getRule(), XSET_LITERAL__ELEMENTS, null);
                    if (state.failed) return current;

                    }
                    }
                    loop134:
                    do {
                        int alt134=2;
                        int LA134_0 = input.LA(1);
                        if ( (LA134_0==29) ) {
                            alt134=1;
                        }
                        switch (alt134) {
                    	case 1 :
                    	    {
                    	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXSetLiteral13372,  elementAccess.getCommaKeyword_3_1_0())) { return current; }


                    	    {

                    	    {
                    	    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXSetLiteral13393, current, elementAccess.getElementsXExpressionParserRuleCall_3_1_1_0(), elementAccess.getRule(), XSET_LITERAL__ELEMENTS, null);
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
            if (!consumeUnassignedToken(34, FOLLOW_34_in_ruleXSetLiteral13409,  elementAccess.getRightCurlyBracketKeyword_4())) { return current; }

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
            pushFollow(FOLLOW_ruleXListLiteral_in_entryRuleXListLiteral13451);
            iv_ruleXListLiteral=ruleXListLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXListLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXListLiteral13461); if (state.failed) return current;
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
            if (!consumeUnassignedToken(69, FOLLOW_69_in_ruleXListLiteral13507,  elementAccess.getNumberSignKeyword_1())) { return current; }

            if (!consumeUnassignedToken(70, FOLLOW_70_in_ruleXListLiteral13519,  elementAccess.getLeftSquareBracketKeyword_2())) { return current; }

            int alt137=2;
            int LA137_0 = input.LA(1);
            if ( ((LA137_0>=RULE_ID && LA137_0<=RULE_RICH_TEXT_START)||(LA137_0>=RULE_HEX && LA137_0<=RULE_DECIMAL)||LA137_0==25||(LA137_0>=27 && LA137_0<=28)||(LA137_0>=31 && LA137_0<=33)||(LA137_0>=35 && LA137_0<=37)||(LA137_0>=39 && LA137_0<=40)||(LA137_0>=42 && LA137_0<=50)||(LA137_0>=53 && LA137_0<=55)||LA137_0==57||(LA137_0>=69 && LA137_0<=70)||(LA137_0>=90 && LA137_0<=91)||LA137_0==96||LA137_0==102||LA137_0==104||(LA137_0>=107 && LA137_0<=117)) ) {
                alt137=1;
            }
            switch (alt137) {
                case 1 :
                    {

                    {

                    {
                    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXListLiteral13541, current, elementAccess.getElementsXExpressionParserRuleCall_3_0_0(), elementAccess.getRule(), XLIST_LITERAL__ELEMENTS, null);
                    if (state.failed) return current;

                    }
                    }
                    loop136:
                    do {
                        int alt136=2;
                        int LA136_0 = input.LA(1);
                        if ( (LA136_0==29) ) {
                            alt136=1;
                        }
                        switch (alt136) {
                    	case 1 :
                    	    {
                    	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXListLiteral13554,  elementAccess.getCommaKeyword_3_1_0())) { return current; }


                    	    {

                    	    {
                    	    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXListLiteral13575, current, elementAccess.getElementsXExpressionParserRuleCall_3_1_1_0(), elementAccess.getRule(), XLIST_LITERAL__ELEMENTS, null);
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
            if (!consumeUnassignedToken(71, FOLLOW_71_in_ruleXListLiteral13591,  elementAccess.getRightSquareBracketKeyword_4())) { return current; }

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
            pushFollow(FOLLOW_ruleXClosure_in_entryRuleXClosure13633);
            iv_ruleXClosure=ruleXClosure();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXClosure13643); if (state.failed) return current;
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
            if (!consumeUnassignedToken(70, FOLLOW_70_in_ruleXClosure13703,  elementAccess.getLeftSquareBracketKeyword_0_0_1())) { return current; }

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
                    if ( (LA139_0==RULE_ID||LA139_0==37||(LA139_0>=39 && LA139_0<=40)||LA139_0==55||LA139_0==86) ) {
                        alt139=1;
                    }
                    switch (alt139) {
                        case 1 :
                            {

                            {

                            {
                            current = callRuleJvmFormalParameterAndAdd(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure13776, current, elementAccess.getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0(), elementAccess.getRule(), XCLOSURE__DECLARED_FORMAL_PARAMETERS, null);
                            if (state.failed) return current;

                            }
                            }
                            loop138:
                            do {
                                int alt138=2;
                                int LA138_0 = input.LA(1);
                                if ( (LA138_0==29) ) {
                                    alt138=1;
                                }
                                switch (alt138) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXClosure13789,  elementAccess.getCommaKeyword_1_0_0_1_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleJvmFormalParameterAndAdd(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure13810, current, elementAccess.getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0(), elementAccess.getRule(), XCLOSURE__DECLARED_FORMAL_PARAMETERS, null);
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
                    current = consumeTokenAndSetBooleanValue(101, FOLLOW_101_in_ruleXClosure13832, current,  elementAccess.getExplicitSyntaxVerticalLineKeyword_1_0_1_0(), elementAccess.getRule(), XCLOSURE__EXPLICIT_SYNTAX);
                    if (state.failed) return current;

                    }
                    }
                    }
                    }
                    break;
            }

            {

            {
            current = callRuleXExpressionInClosureAndSet(FOLLOW_ruleXExpressionInClosure_in_ruleXClosure13869, current, elementAccess.getExpressionXExpressionInClosureParserRuleCall_2_0(), elementAccess.getRule(), XCLOSURE__EXPRESSION, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(71, FOLLOW_71_in_ruleXClosure13881,  elementAccess.getRightSquareBracketKeyword_3())) { return current; }

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
            pushFollow(FOLLOW_ruleXExpressionInClosure_in_entryRuleXExpressionInClosure13923);
            iv_ruleXExpressionInClosure=ruleXExpressionInClosure();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInClosure13933); if (state.failed) return current;
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
                if ( ((LA142_0>=RULE_ID && LA142_0<=RULE_RICH_TEXT_START)||(LA142_0>=RULE_HEX && LA142_0<=RULE_DECIMAL)||LA142_0==25||(LA142_0>=27 && LA142_0<=28)||(LA142_0>=31 && LA142_0<=33)||(LA142_0>=35 && LA142_0<=37)||(LA142_0>=39 && LA142_0<=40)||(LA142_0>=42 && LA142_0<=55)||LA142_0==57||(LA142_0>=69 && LA142_0<=70)||(LA142_0>=90 && LA142_0<=91)||LA142_0==96||LA142_0==102||LA142_0==104||(LA142_0>=107 && LA142_0<=117)) ) {
                    alt142=1;
                }
                switch (alt142) {
            	case 1 :
            	    {

            	    {

            	    {
            	    current = callRuleXExpressionInsideBlockAndAdd(FOLLOW_ruleXExpressionInsideBlock_in_ruleXExpressionInClosure13989, current, elementAccess.getExpressionsXExpressionInsideBlockParserRuleCall_1_0_0(), elementAccess.getRule(), XBLOCK_EXPRESSION__EXPRESSIONS, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    int alt141=2;
            	    int LA141_0 = input.LA(1);
            	    if ( (LA141_0==26) ) {
            	        alt141=1;
            	    }
            	    switch (alt141) {
            	        case 1 :
            	            {
            	            if (!consumeUnassignedToken(26, FOLLOW_26_in_ruleXExpressionInClosure14002,  elementAccess.getSemicolonKeyword_1_1())) { return current; }

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
            pushFollow(FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure14048);
            iv_ruleXShortClosure=ruleXShortClosure();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXShortClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXShortClosure14058); if (state.failed) return current;
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
            if ( (LA144_0==RULE_ID||LA144_0==37||(LA144_0>=39 && LA144_0<=40)||LA144_0==55||LA144_0==86) ) {
                alt144=1;
            }
            switch (alt144) {
                case 1 :
                    {

                    {

                    {
                    current = callRuleJvmFormalParameterAndAdd(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure14166, current, elementAccess.getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0(), elementAccess.getRule(), XCLOSURE__DECLARED_FORMAL_PARAMETERS, null);
                    if (state.failed) return current;

                    }
                    }
                    loop143:
                    do {
                        int alt143=2;
                        int LA143_0 = input.LA(1);
                        if ( (LA143_0==29) ) {
                            alt143=1;
                        }
                        switch (alt143) {
                    	case 1 :
                    	    {
                    	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXShortClosure14179,  elementAccess.getCommaKeyword_0_0_1_1_0())) { return current; }


                    	    {

                    	    {
                    	    current = callRuleJvmFormalParameterAndAdd(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure14200, current, elementAccess.getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0(), elementAccess.getRule(), XCLOSURE__DECLARED_FORMAL_PARAMETERS, null);
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
            current = consumeTokenAndSetBooleanValue(101, FOLLOW_101_in_ruleXShortClosure14222, current,  elementAccess.getExplicitSyntaxVerticalLineKeyword_0_0_2_0(), elementAccess.getRule(), XCLOSURE__EXPLICIT_SYNTAX);
            if (state.failed) return current;

            }
            }
            }
            }

            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXShortClosure14258, current, elementAccess.getExpressionXExpressionParserRuleCall_1_0(), elementAccess.getRule(), XCLOSURE__EXPRESSION, null);
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
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression14300);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXParenthesizedExpression14310); if (state.failed) return current;
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
            if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleXParenthesizedExpression14347,  elementAccess.getLeftParenthesisKeyword_0())) { return current; }

            current = callUnassignedRuleXExpression(FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression14369, elementAccess.getXExpressionParserRuleCall_1());
            if (state.failed) return current;

            if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXParenthesizedExpression14380,  elementAccess.getRightParenthesisKeyword_2())) { return current; }

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
            pushFollow(FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression14422);
            iv_ruleXIfExpression=ruleXIfExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIfExpression14432); if (state.failed) return current;
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
            if (!consumeUnassignedToken(102, FOLLOW_102_in_ruleXIfExpression14478,  elementAccess.getIfKeyword_1())) { return current; }

            if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleXIfExpression14490,  elementAccess.getLeftParenthesisKeyword_2())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXIfExpression14511, current, elementAccess.getIfXExpressionParserRuleCall_3_0(), elementAccess.getRule(), XIF_EXPRESSION__IF, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXIfExpression14523,  elementAccess.getRightParenthesisKeyword_4())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXIfExpression14544, current, elementAccess.getThenXExpressionParserRuleCall_5_0(), elementAccess.getRule(), XIF_EXPRESSION__THEN, null);
            if (state.failed) return current;

            }
            }
            int alt145=2;
            int LA145_0 = input.LA(1);
            if ( (LA145_0==103) ) {
                int LA145_1 = input.LA(2);
                if ( (synpred32_InternalXtend()) ) {
                    alt145=1;
                }
            }
            switch (alt145) {
                case 1 :
                    {

                    {
                    if (!consumeUnassignedToken(103, FOLLOW_103_in_ruleXIfExpression14565,  elementAccess.getElseKeyword_6_0())) { return current; }

                    }

                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXIfExpression14587, current, elementAccess.getElseXExpressionParserRuleCall_6_1_0(), elementAccess.getRule(), XIF_EXPRESSION__ELSE, null);
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
            pushFollow(FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression14631);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSwitchExpression14641); if (state.failed) return current;
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
            if (!consumeUnassignedToken(104, FOLLOW_104_in_ruleXSwitchExpression14687,  elementAccess.getSwitchKeyword_1())) { return current; }

            int alt147=2;
            int LA147_0 = input.LA(1);
            if ( ((LA147_0>=RULE_ID && LA147_0<=RULE_RICH_TEXT_START)||(LA147_0>=RULE_HEX && LA147_0<=RULE_DECIMAL)||LA147_0==25||(LA147_0>=27 && LA147_0<=28)||(LA147_0>=31 && LA147_0<=33)||(LA147_0>=35 && LA147_0<=37)||LA147_0==39||(LA147_0>=42 && LA147_0<=50)||(LA147_0>=53 && LA147_0<=55)||LA147_0==57||(LA147_0>=69 && LA147_0<=70)||(LA147_0>=90 && LA147_0<=91)||LA147_0==96||LA147_0==102||LA147_0==104||(LA147_0>=107 && LA147_0<=117)) ) {
                alt147=1;
            }
            else if ( (LA147_0==40) ) {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    int LA147_3 = input.LA(3);
                    if ( (LA147_3==28||LA147_3==30||LA147_3==38||(LA147_3>=40 && LA147_3<=41)||LA147_3==70||(LA147_3>=72 && LA147_3<=95)||(LA147_3>=97 && LA147_3<=100)) ) {
                        alt147=1;
                    }
                    else if ( (LA147_3==56) && (synpred34_InternalXtend())) {
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
                case RULE_STRING:
                case RULE_RICH_TEXT:
                case RULE_RICH_TEXT_START:
                case RULE_HEX:
                case RULE_INT:
                case RULE_DECIMAL:
                case 25:
                case 27:
                case 28:
                case 31:
                case 32:
                case 33:
                case 35:
                case 36:
                case 39:
                case 40:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 53:
                case 54:
                case 57:
                case 69:
                case 70:
                case 90:
                case 91:
                case 96:
                case 102:
                case 104:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                case 115:
                case 116:
                case 117:
                    {
                    alt147=1;
                    }
                    break;
                case 37:
                    {
                    int LA147_4 = input.LA(3);
                    if ( (LA147_4==56) && (synpred34_InternalXtend())) {
                        alt147=2;
                    }
                    else if ( (LA147_4==28||LA147_4==30||LA147_4==38||(LA147_4>=40 && LA147_4<=41)||LA147_4==70||(LA147_4>=72 && LA147_4<=95)||(LA147_4>=97 && LA147_4<=100)) ) {
                        alt147=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 147, 4, input);
                        throw nvae;
                    }
                    }
                    break;
                case 55:
                    {
                    int LA147_5 = input.LA(3);
                    if ( (LA147_5==28||LA147_5==30||LA147_5==38||(LA147_5>=40 && LA147_5<=41)||LA147_5==70||(LA147_5>=72 && LA147_5<=95)||(LA147_5>=97 && LA147_5<=100)) ) {
                        alt147=1;
                    }
                    else if ( (LA147_5==56) && (synpred34_InternalXtend())) {
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
                            if ( (LA146_1==56) && (synpred33_InternalXtend())) {
                                alt146=1;
                            }
                            }
                            break;
                        case 55:
                            {
                            int LA146_2 = input.LA(2);
                            if ( (LA146_2==56) && (synpred33_InternalXtend())) {
                                alt146=1;
                            }
                            }
                            break;
                        case 37:
                            {
                            int LA146_3 = input.LA(2);
                            if ( (LA146_3==56) && (synpred33_InternalXtend())) {
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
                            current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleXSwitchExpression14730, current, elementAccess.getLocalVarNameValidIDParserRuleCall_2_0_0_0_0_0(), elementAccess.getRule(), XSWITCH_EXPRESSION__LOCAL_VAR_NAME, "ValidID");
                            if (state.failed) return current;

                            }
                            }
                            if (!consumeUnassignedToken(56, FOLLOW_56_in_ruleXSwitchExpression14742,  elementAccess.getColonKeyword_2_0_0_0_1())) { return current; }

                            }
                            }
                            break;
                    }

                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXSwitchExpression14766, current, elementAccess.getSwitchXExpressionParserRuleCall_2_0_1_0(), elementAccess.getRule(), XSWITCH_EXPRESSION__SWITCH, null);
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
                    if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleXSwitchExpression14810,  elementAccess.getLeftParenthesisKeyword_2_1_0_0_0())) { return current; }


                    {

                    {
                    current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleXSwitchExpression14831, current, elementAccess.getLocalVarNameValidIDParserRuleCall_2_1_0_0_1_0(), elementAccess.getRule(), XSWITCH_EXPRESSION__LOCAL_VAR_NAME, "ValidID");
                    if (state.failed) return current;

                    }
                    }
                    if (!consumeUnassignedToken(56, FOLLOW_56_in_ruleXSwitchExpression14843,  elementAccess.getColonKeyword_2_1_0_0_2())) { return current; }

                    }
                    }

                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXSwitchExpression14866, current, elementAccess.getSwitchXExpressionParserRuleCall_2_1_1_0(), elementAccess.getRule(), XSWITCH_EXPRESSION__SWITCH, null);
                    if (state.failed) return current;

                    }
                    }
                    if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXSwitchExpression14878,  elementAccess.getRightParenthesisKeyword_2_1_2())) { return current; }

                    }
                    }
                    break;
            }
            if (!consumeUnassignedToken(33, FOLLOW_33_in_ruleXSwitchExpression14892,  elementAccess.getLeftCurlyBracketKeyword_3())) { return current; }

            int cnt148=0;
            loop148:
            do {
                int alt148=2;
                int LA148_0 = input.LA(1);
                if ( (LA148_0==RULE_ID||LA148_0==37||LA148_0==40||(LA148_0>=55 && LA148_0<=56)||LA148_0==86||LA148_0==106) ) {
                    alt148=1;
                }
                switch (alt148) {
            	case 1 :
            	    {

            	    {
            	    current = callRuleXCasePartAndAdd(FOLLOW_ruleXCasePart_in_ruleXSwitchExpression14913, current, elementAccess.getCasesXCasePartParserRuleCall_4_0(), elementAccess.getRule(), XSWITCH_EXPRESSION__CASES, null);
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
            if ( (LA149_0==105) ) {
                alt149=1;
            }
            switch (alt149) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(105, FOLLOW_105_in_ruleXSwitchExpression14927,  elementAccess.getDefaultKeyword_5_0())) { return current; }

                    if (!consumeUnassignedToken(56, FOLLOW_56_in_ruleXSwitchExpression14939,  elementAccess.getColonKeyword_5_1())) { return current; }


                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXSwitchExpression14960, current, elementAccess.getDefaultXExpressionParserRuleCall_5_2_0(), elementAccess.getRule(), XSWITCH_EXPRESSION__DEFAULT, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    break;
            }
            if (!consumeUnassignedToken(34, FOLLOW_34_in_ruleXSwitchExpression14974,  elementAccess.getRightCurlyBracketKeyword_6())) { return current; }

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
            pushFollow(FOLLOW_ruleXCasePart_in_entryRuleXCasePart15016);
            iv_ruleXCasePart=ruleXCasePart();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCasePart15026); if (state.failed) return current;
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
            if ( (LA150_0==RULE_ID||LA150_0==37||LA150_0==40||LA150_0==55||LA150_0==86) ) {
                alt150=1;
            }
            switch (alt150) {
                case 1 :
                    {

                    {
                    current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleXCasePart15072, current, elementAccess.getTypeGuardJvmTypeReferenceParserRuleCall_0_0(), elementAccess.getRule(), XCASE_PART__TYPE_GUARD, null);
                    if (state.failed) return current;

                    }
                    }
                    break;
            }
            int alt151=2;
            int LA151_0 = input.LA(1);
            if ( (LA151_0==106) ) {
                alt151=1;
            }
            switch (alt151) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(106, FOLLOW_106_in_ruleXCasePart15086,  elementAccess.getCaseKeyword_1_0())) { return current; }


                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXCasePart15107, current, elementAccess.getCaseXExpressionParserRuleCall_1_1_0(), elementAccess.getRule(), XCASE_PART__CASE, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    break;
            }
            if (!consumeUnassignedToken(56, FOLLOW_56_in_ruleXCasePart15121,  elementAccess.getColonKeyword_2())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXCasePart15142, current, elementAccess.getThenXExpressionParserRuleCall_3_0(), elementAccess.getRule(), XCASE_PART__THEN, null);
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
            pushFollow(FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression15184);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXForLoopExpression15194); if (state.failed) return current;
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
            if (!consumeUnassignedToken(107, FOLLOW_107_in_ruleXForLoopExpression15240,  elementAccess.getForKeyword_1())) { return current; }

            if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleXForLoopExpression15252,  elementAccess.getLeftParenthesisKeyword_2())) { return current; }


            {

            {
            current = callRuleJvmFormalParameterAndSet(FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression15273, current, elementAccess.getDeclaredParamJvmFormalParameterParserRuleCall_3_0(), elementAccess.getRule(), XFOR_LOOP_EXPRESSION__DECLARED_PARAM, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(56, FOLLOW_56_in_ruleXForLoopExpression15285,  elementAccess.getColonKeyword_4())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXForLoopExpression15306, current, elementAccess.getForExpressionXExpressionParserRuleCall_5_0(), elementAccess.getRule(), XFOR_LOOP_EXPRESSION__FOR_EXPRESSION, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXForLoopExpression15318,  elementAccess.getRightParenthesisKeyword_6())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXForLoopExpression15339, current, elementAccess.getEachExpressionXExpressionParserRuleCall_7_0(), elementAccess.getRule(), XFOR_LOOP_EXPRESSION__EACH_EXPRESSION, null);
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
            pushFollow(FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression15381);
            iv_ruleXWhileExpression=ruleXWhileExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWhileExpression15391); if (state.failed) return current;
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
            if (!consumeUnassignedToken(108, FOLLOW_108_in_ruleXWhileExpression15437,  elementAccess.getWhileKeyword_1())) { return current; }

            if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleXWhileExpression15449,  elementAccess.getLeftParenthesisKeyword_2())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXWhileExpression15470, current, elementAccess.getPredicateXExpressionParserRuleCall_3_0(), elementAccess.getRule(), XWHILE_EXPRESSION__PREDICATE, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXWhileExpression15482,  elementAccess.getRightParenthesisKeyword_4())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXWhileExpression15503, current, elementAccess.getBodyXExpressionParserRuleCall_5_0(), elementAccess.getRule(), XWHILE_EXPRESSION__BODY, null);
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
            pushFollow(FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression15545);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXDoWhileExpression15555); if (state.failed) return current;
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
            if (!consumeUnassignedToken(109, FOLLOW_109_in_ruleXDoWhileExpression15601,  elementAccess.getDoKeyword_1())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression15622, current, elementAccess.getBodyXExpressionParserRuleCall_2_0(), elementAccess.getRule(), XDO_WHILE_EXPRESSION__BODY, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(108, FOLLOW_108_in_ruleXDoWhileExpression15634,  elementAccess.getWhileKeyword_3())) { return current; }

            if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleXDoWhileExpression15646,  elementAccess.getLeftParenthesisKeyword_4())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression15667, current, elementAccess.getPredicateXExpressionParserRuleCall_5_0(), elementAccess.getRule(), XDO_WHILE_EXPRESSION__PREDICATE, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXDoWhileExpression15679,  elementAccess.getRightParenthesisKeyword_6())) { return current; }

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
            pushFollow(FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression15721);
            iv_ruleXBlockExpression=ruleXBlockExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBlockExpression15731); if (state.failed) return current;
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
            if (!consumeUnassignedToken(33, FOLLOW_33_in_ruleXBlockExpression15777,  elementAccess.getLeftCurlyBracketKeyword_1())) { return current; }

            loop153:
            do {
                int alt153=2;
                int LA153_0 = input.LA(1);
                if ( ((LA153_0>=RULE_ID && LA153_0<=RULE_RICH_TEXT_START)||(LA153_0>=RULE_HEX && LA153_0<=RULE_DECIMAL)||LA153_0==25||(LA153_0>=27 && LA153_0<=28)||(LA153_0>=31 && LA153_0<=33)||(LA153_0>=35 && LA153_0<=37)||(LA153_0>=39 && LA153_0<=40)||(LA153_0>=42 && LA153_0<=55)||LA153_0==57||(LA153_0>=69 && LA153_0<=70)||(LA153_0>=90 && LA153_0<=91)||LA153_0==96||LA153_0==102||LA153_0==104||(LA153_0>=107 && LA153_0<=117)) ) {
                    alt153=1;
                }
                switch (alt153) {
            	case 1 :
            	    {

            	    {

            	    {
            	    current = callRuleXExpressionInsideBlockAndAdd(FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression15799, current, elementAccess.getExpressionsXExpressionInsideBlockParserRuleCall_2_0_0(), elementAccess.getRule(), XBLOCK_EXPRESSION__EXPRESSIONS, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    int alt152=2;
            	    int LA152_0 = input.LA(1);
            	    if ( (LA152_0==26) ) {
            	        alt152=1;
            	    }
            	    switch (alt152) {
            	        case 1 :
            	            {
            	            if (!consumeUnassignedToken(26, FOLLOW_26_in_ruleXBlockExpression15812,  elementAccess.getSemicolonKeyword_2_1())) { return current; }

            	            }
            	            break;
            	    }
            	    }
            	    break;
            	default :
            	    break loop153;
                }
            } while (true);
            if (!consumeUnassignedToken(34, FOLLOW_34_in_ruleXBlockExpression15828,  elementAccess.getRightCurlyBracketKeyword_3())) { return current; }

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
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock15870);
            iv_ruleXExpressionInsideBlock=ruleXExpressionInsideBlock();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInsideBlock15880); if (state.failed) return current;
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
            if ( (LA154_0==52) && (synpred35_InternalXtend())) {
                alt154=1;
            }
            else if ( (LA154_0==51) && (synpred35_InternalXtend())) {
                alt154=1;
            }
            else if ( (LA154_0==39) ) {
                switch ( input.LA(2) ) {
                case 52:
                    {
                    int LA154_5 = input.LA(3);
                    if ( (synpred35_InternalXtend()) ) {
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
                case 51:
                    {
                    int LA154_6 = input.LA(3);
                    if ( (synpred35_InternalXtend()) ) {
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
                case 25:
                case 26:
                case 27:
                case 28:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 53:
                case 54:
                case 55:
                case 57:
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
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 102:
                case 104:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                case 115:
                case 116:
                case 117:
                    {
                    alt154=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 154, 3, input);
                    throw nvae;
                }
            }
            else if ( ((LA154_0>=RULE_ID && LA154_0<=RULE_RICH_TEXT_START)||(LA154_0>=RULE_HEX && LA154_0<=RULE_DECIMAL)||LA154_0==25||(LA154_0>=27 && LA154_0<=28)||(LA154_0>=31 && LA154_0<=33)||(LA154_0>=35 && LA154_0<=37)||LA154_0==40||(LA154_0>=42 && LA154_0<=50)||(LA154_0>=53 && LA154_0<=55)||LA154_0==57||(LA154_0>=69 && LA154_0<=70)||(LA154_0>=90 && LA154_0<=91)||LA154_0==96||LA154_0==102||LA154_0==104||(LA154_0>=107 && LA154_0<=117)) ) {
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
                    current = callUnassignedRuleXVariableDeclaration(FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock16029, elementAccess.getXVariableDeclarationParserRuleCall_0());
                    if (state.failed) return current;

                    }
                    }
                    break;
                case 2 :
                    {
                    current = callUnassignedRuleXExpression(FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock16057, elementAccess.getXExpressionParserRuleCall_1());
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
            pushFollow(FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall16098);
            iv_ruleXFeatureCall=ruleXFeatureCall();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFeatureCall16108); if (state.failed) return current;
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
            int alt156=2;
            int LA156_0 = input.LA(1);
            if ( (LA156_0==28) ) {
                alt156=1;
            }
            switch (alt156) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(28, FOLLOW_28_in_ruleXFeatureCall16155,  elementAccess.getLessThanSignKeyword_1_0())) { return current; }


                    {

                    {
                    current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall16176, current, elementAccess.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0(), elementAccess.getRule(), XFEATURE_CALL__TYPE_ARGUMENTS, null);
                    if (state.failed) return current;

                    }
                    }
                    loop155:
                    do {
                        int alt155=2;
                        int LA155_0 = input.LA(1);
                        if ( (LA155_0==29) ) {
                            alt155=1;
                        }
                        switch (alt155) {
                    	case 1 :
                    	    {
                    	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXFeatureCall16189,  elementAccess.getCommaKeyword_1_2_0())) { return current; }


                    	    {

                    	    {
                    	    current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall16210, current, elementAccess.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0(), elementAccess.getRule(), XFEATURE_CALL__TYPE_ARGUMENTS, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop155;
                        }
                    } while (true);
                    if (!consumeUnassignedToken(30, FOLLOW_30_in_ruleXFeatureCall16224,  elementAccess.getGreaterThanSignKeyword_1_3())) { return current; }

                    }
                    break;
            }

            {

            {
            current = callRuleIdOrSuper(FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall16249, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_2_0(), elementAccess.getRule());
            if (state.failed) return current;

            }
            }
            int alt159=2;
            alt159 = dfa159.predict(input);
            switch (alt159) {
                case 1 :
                    {

                    {

                    {
                    current = consumeTokenAndSetBooleanValue(40, FOLLOW_40_in_ruleXFeatureCall16283, current,  elementAccess.getExplicitOperationCallLeftParenthesisKeyword_3_0_0(), elementAccess.getRule(), XFEATURE_CALL__EXPLICIT_OPERATION_CALL);
                    if (state.failed) return current;

                    }
                    }
                    int alt158=3;
                    alt158 = dfa158.predict(input);
                    switch (alt158) {
                        case 1 :
                            {

                            {

                            {
                            current = callRuleXShortClosureAndAdd(FOLLOW_ruleXShortClosure_in_ruleXFeatureCall16368, current, elementAccess.getFeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0(), elementAccess.getRule(), XFEATURE_CALL__FEATURE_CALL_ARGUMENTS, null);
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
                            current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXFeatureCall16396, current, elementAccess.getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0(), elementAccess.getRule(), XFEATURE_CALL__FEATURE_CALL_ARGUMENTS, null);
                            if (state.failed) return current;

                            }
                            }
                            loop157:
                            do {
                                int alt157=2;
                                int LA157_0 = input.LA(1);
                                if ( (LA157_0==29) ) {
                                    alt157=1;
                                }
                                switch (alt157) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXFeatureCall16409,  elementAccess.getCommaKeyword_3_1_1_1_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXFeatureCall16430, current, elementAccess.getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0(), elementAccess.getRule(), XFEATURE_CALL__FEATURE_CALL_ARGUMENTS, null);
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop157;
                                }
                            } while (true);
                            }
                            }
                            break;
                    }
                    if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXFeatureCall16447,  elementAccess.getRightParenthesisKeyword_3_2())) { return current; }

                    }
                    break;
            }
            int alt160=2;
            alt160 = dfa160.predict(input);
            switch (alt160) {
                case 1 :
                    {

                    {
                    current = callRuleXClosureAndAdd(FOLLOW_ruleXClosure_in_ruleXFeatureCall16482, current, elementAccess.getFeatureCallArgumentsXClosureParserRuleCall_4_0(), elementAccess.getRule(), XFEATURE_CALL__FEATURE_CALL_ARGUMENTS, null);
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
            pushFollow(FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper16526);
            iv_ruleIdOrSuper=ruleIdOrSuper();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrSuper.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdOrSuper16537); if (state.failed) return current;
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
            int alt161=2;
            int LA161_0 = input.LA(1);
            if ( (LA161_0==RULE_ID||LA161_0==25||LA161_0==27||(LA161_0>=31 && LA161_0<=32)||(LA161_0>=35 && LA161_0<=37)||LA161_0==39||LA161_0==42||(LA161_0>=44 && LA161_0<=50)||(LA161_0>=53 && LA161_0<=55)||LA161_0==57) ) {
                alt161=1;
            }
            else if ( (LA161_0==110) ) {
                alt161=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 161, 0, input);
                throw nvae;
            }
            switch (alt161) {
                case 1 :
                    {
                    callRuleFeatureCallID(FOLLOW_ruleFeatureCallID_in_ruleIdOrSuper16584, current, elementAccess.getFeatureCallIDParserRuleCall_0());
                    if (state.failed) return current;

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(110, FOLLOW_110_in_ruleIdOrSuper16608, current,  elementAccess.getSuperKeyword_1())) { return current; }

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

    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXConstructorCall = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XConstructorCallElements elementAccess = grammarAccess.getXConstructorCallAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall16654);
            iv_ruleXConstructorCall=ruleXConstructorCall();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXConstructorCall16664); if (state.failed) return current;
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
            if (!consumeUnassignedToken(43, FOLLOW_43_in_ruleXConstructorCall16710,  elementAccess.getNewKeyword_1())) { return current; }


            {

            {
            current = callRuleQualifiedName(FOLLOW_ruleQualifiedName_in_ruleXConstructorCall16733, current, elementAccess.getConstructorJvmConstructorCrossReference_2_0(), elementAccess.getRule());
            if (state.failed) return current;

            }
            }
            int alt163=2;
            alt163 = dfa163.predict(input);
            switch (alt163) {
                case 1 :
                    {

                    {
                    if (!consumeUnassignedToken(28, FOLLOW_28_in_ruleXConstructorCall16754,  elementAccess.getLessThanSignKeyword_3_0())) { return current; }

                    }

                    {

                    {
                    current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall16776, current, elementAccess.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0(), elementAccess.getRule(), XCONSTRUCTOR_CALL__TYPE_ARGUMENTS, null);
                    if (state.failed) return current;

                    }
                    }
                    loop162:
                    do {
                        int alt162=2;
                        int LA162_0 = input.LA(1);
                        if ( (LA162_0==29) ) {
                            alt162=1;
                        }
                        switch (alt162) {
                    	case 1 :
                    	    {
                    	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXConstructorCall16789,  elementAccess.getCommaKeyword_3_2_0())) { return current; }


                    	    {

                    	    {
                    	    current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall16810, current, elementAccess.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0(), elementAccess.getRule(), XCONSTRUCTOR_CALL__TYPE_ARGUMENTS, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop162;
                        }
                    } while (true);
                    if (!consumeUnassignedToken(30, FOLLOW_30_in_ruleXConstructorCall16824,  elementAccess.getGreaterThanSignKeyword_3_3())) { return current; }

                    }
                    break;
            }
            int alt166=2;
            alt166 = dfa166.predict(input);
            switch (alt166) {
                case 1 :
                    {

                    {
                    if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleXConstructorCall16847,  elementAccess.getLeftParenthesisKeyword_4_0())) { return current; }

                    }
                    int alt165=3;
                    alt165 = dfa165.predict(input);
                    switch (alt165) {
                        case 1 :
                            {

                            {

                            {
                            current = callRuleXShortClosureAndAdd(FOLLOW_ruleXShortClosure_in_ruleXConstructorCall16920, current, elementAccess.getArgumentsXShortClosureParserRuleCall_4_1_0_0(), elementAccess.getRule(), XCONSTRUCTOR_CALL__ARGUMENTS, null);
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
                            current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXConstructorCall16948, current, elementAccess.getArgumentsXExpressionParserRuleCall_4_1_1_0_0(), elementAccess.getRule(), XCONSTRUCTOR_CALL__ARGUMENTS, null);
                            if (state.failed) return current;

                            }
                            }
                            loop164:
                            do {
                                int alt164=2;
                                int LA164_0 = input.LA(1);
                                if ( (LA164_0==29) ) {
                                    alt164=1;
                                }
                                switch (alt164) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXConstructorCall16961,  elementAccess.getCommaKeyword_4_1_1_1_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXConstructorCall16982, current, elementAccess.getArgumentsXExpressionParserRuleCall_4_1_1_1_1_0(), elementAccess.getRule(), XCONSTRUCTOR_CALL__ARGUMENTS, null);
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop164;
                                }
                            } while (true);
                            }
                            }
                            break;
                    }
                    if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXConstructorCall16999,  elementAccess.getRightParenthesisKeyword_4_2())) { return current; }

                    }
                    break;
            }
            int alt167=2;
            alt167 = dfa167.predict(input);
            switch (alt167) {
                case 1 :
                    {

                    {
                    current = callRuleXClosureAndAdd(FOLLOW_ruleXClosure_in_ruleXConstructorCall17034, current, elementAccess.getArgumentsXClosureParserRuleCall_5_0(), elementAccess.getRule(), XCONSTRUCTOR_CALL__ARGUMENTS, null);
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
            pushFollow(FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral17077);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBooleanLiteral17087); if (state.failed) return current;
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
            int alt168=2;
            int LA168_0 = input.LA(1);
            if ( (LA168_0==111) ) {
                alt168=1;
            }
            else if ( (LA168_0==112) ) {
                alt168=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 168, 0, input);
                throw nvae;
            }
            switch (alt168) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(111, FOLLOW_111_in_ruleXBooleanLiteral17134,  elementAccess.getFalseKeyword_1_0())) { return current; }

                    }
                    break;
                case 2 :
                    {

                    {

                    {
                    current = consumeTokenAndSetBooleanValue(112, FOLLOW_112_in_ruleXBooleanLiteral17158, current,  elementAccess.getIsTrueTrueKeyword_1_1_0(), elementAccess.getRule(), XBOOLEAN_LITERAL__IS_TRUE);
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
            pushFollow(FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral17214);
            iv_ruleXNullLiteral=ruleXNullLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNullLiteral17224); if (state.failed) return current;
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
            if (!consumeUnassignedToken(113, FOLLOW_113_in_ruleXNullLiteral17270,  elementAccess.getNullKeyword_1())) { return current; }

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
            pushFollow(FOLLOW_ruleXNumberLiteral_in_entryRuleXNumberLiteral17312);
            iv_ruleXNumberLiteral=ruleXNumberLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNumberLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNumberLiteral17322); if (state.failed) return current;
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
            current = callRuleNumberAndSet(FOLLOW_ruleNumber_in_ruleXNumberLiteral17377, current, elementAccess.getValueNumberParserRuleCall_1_0(), elementAccess.getRule(), XNUMBER_LITERAL__VALUE, "Number");
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
            pushFollow(FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral17419);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTypeLiteral17429); if (state.failed) return current;
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
            if (!consumeUnassignedToken(114, FOLLOW_114_in_ruleXTypeLiteral17475,  elementAccess.getTypeofKeyword_1())) { return current; }

            if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleXTypeLiteral17487,  elementAccess.getLeftParenthesisKeyword_2())) { return current; }


            {

            {
            current = callRuleQualifiedName(FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral17510, current, elementAccess.getTypeJvmTypeCrossReference_3_0(), elementAccess.getRule());
            if (state.failed) return current;

            }
            }
            loop169:
            do {
                int alt169=2;
                int LA169_0 = input.LA(1);
                if ( (LA169_0==70) ) {
                    alt169=1;
                }
                switch (alt169) {
            	case 1 :
            	    {

            	    {
            	    current = callRuleArrayBracketsAndAdd(FOLLOW_ruleArrayBrackets_in_ruleXTypeLiteral17531, current, elementAccess.getArrayDimensionsArrayBracketsParserRuleCall_4_0(), elementAccess.getRule(), XTYPE_LITERAL__ARRAY_DIMENSIONS, "ArrayBrackets");
            	    if (state.failed) return current;

            	    }
            	    }
            	    break;
            	default :
            	    break loop169;
                }
            } while (true);
            if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXTypeLiteral17544,  elementAccess.getRightParenthesisKeyword_5())) { return current; }

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
            pushFollow(FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression17586);
            iv_ruleXThrowExpression=ruleXThrowExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXThrowExpression17596); if (state.failed) return current;
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
            if (!consumeUnassignedToken(115, FOLLOW_115_in_ruleXThrowExpression17642,  elementAccess.getThrowKeyword_1())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXThrowExpression17663, current, elementAccess.getExpressionXExpressionParserRuleCall_2_0(), elementAccess.getRule(), XTHROW_EXPRESSION__EXPRESSION, null);
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
            pushFollow(FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression17705);
            iv_ruleXReturnExpression=ruleXReturnExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXReturnExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXReturnExpression17715); if (state.failed) return current;
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
            if (!consumeUnassignedToken(116, FOLLOW_116_in_ruleXReturnExpression17761,  elementAccess.getReturnKeyword_1())) { return current; }

            int alt170=2;
            alt170 = dfa170.predict(input);
            switch (alt170) {
                case 1 :
                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXReturnExpression17792, current, elementAccess.getExpressionXExpressionParserRuleCall_2_0(), elementAccess.getRule(), XRETURN_EXPRESSION__EXPRESSION, null);
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
            pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression17835);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression17845); if (state.failed) return current;
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
            if (!consumeUnassignedToken(117, FOLLOW_117_in_ruleXTryCatchFinallyExpression17891,  elementAccess.getTryKeyword_1())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression17912, current, elementAccess.getExpressionXExpressionParserRuleCall_2_0(), elementAccess.getRule(), XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION, null);
            if (state.failed) return current;

            }
            }
            int alt173=2;
            int LA173_0 = input.LA(1);
            if ( (LA173_0==119) ) {
                alt173=1;
            }
            else if ( (LA173_0==118) ) {
                alt173=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 173, 0, input);
                throw nvae;
            }
            switch (alt173) {
                case 1 :
                    {

                    {
                    int cnt171=0;
                    loop171:
                    do {
                        int alt171=2;
                        int LA171_0 = input.LA(1);
                        if ( (LA171_0==119) ) {
                            int LA171_2 = input.LA(2);
                            if ( (synpred44_InternalXtend()) ) {
                                alt171=1;
                            }
                        }
                        switch (alt171) {
                    	case 1 :
                    	    {

                    	    {
                    	    current = callRuleXCatchClauseAndAdd(FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression17942, current, elementAccess.getCatchClausesXCatchClauseParserRuleCall_3_0_0_0(), elementAccess.getRule(), XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSES, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    break;
                    	default :
                    	    if ( cnt171 >= 1 ) break loop171;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(171, input);
                                throw eee;
                        }
                        cnt171++;
                    } while (true);
                    int alt172=2;
                    int LA172_0 = input.LA(1);
                    if ( (LA172_0==118) ) {
                        int LA172_1 = input.LA(2);
                        if ( (synpred45_InternalXtend()) ) {
                            alt172=1;
                        }
                    }
                    switch (alt172) {
                        case 1 :
                            {

                            {
                            if (!consumeUnassignedToken(118, FOLLOW_118_in_ruleXTryCatchFinallyExpression17964,  elementAccess.getFinallyKeyword_3_0_1_0())) { return current; }

                            }

                            {

                            {
                            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression17986, current, elementAccess.getFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0(), elementAccess.getRule(), XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION, null);
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
                    if (!consumeUnassignedToken(118, FOLLOW_118_in_ruleXTryCatchFinallyExpression18008,  elementAccess.getFinallyKeyword_3_1_0())) { return current; }


                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression18029, current, elementAccess.getFinallyExpressionXExpressionParserRuleCall_3_1_1_0(), elementAccess.getRule(), XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION, null);
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
            pushFollow(FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause18073);
            iv_ruleXCatchClause=ruleXCatchClause();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCatchClause18083); if (state.failed) return current;
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
            if (!consumeUnassignedToken(119, FOLLOW_119_in_ruleXCatchClause18128,  elementAccess.getCatchKeyword_0())) { return current; }

            }
            if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleXCatchClause18141,  elementAccess.getLeftParenthesisKeyword_1())) { return current; }


            {

            {
            current = callRuleFullJvmFormalParameterAndSet(FOLLOW_ruleFullJvmFormalParameter_in_ruleXCatchClause18162, current, elementAccess.getDeclaredParamFullJvmFormalParameterParserRuleCall_2_0(), elementAccess.getRule(), XCATCH_CLAUSE__DECLARED_PARAM, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXCatchClause18174,  elementAccess.getRightParenthesisKeyword_3())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXCatchClause18195, current, elementAccess.getExpressionXExpressionParserRuleCall_4_0(), elementAccess.getRule(), XCATCH_CLAUSE__EXPRESSION, null);
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
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName18238);
            iv_ruleQualifiedName=ruleQualifiedName();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName18249); if (state.failed) return current;
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
            callRuleValidID(FOLLOW_ruleValidID_in_ruleQualifiedName18296, current, elementAccess.getValidIDParserRuleCall_0());
            if (state.failed) return current;

            loop174:
            do {
                int alt174=2;
                int LA174_0 = input.LA(1);
                if ( (LA174_0==98) ) {
                    switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA174_3 = input.LA(3);
                        if ( (synpred47_InternalXtend()) ) {
                            alt174=1;
                        }
                        }
                        break;
                    case 37:
                        {
                        int LA174_4 = input.LA(3);
                        if ( (synpred47_InternalXtend()) ) {
                            alt174=1;
                        }
                        }
                        break;
                    case 55:
                        {
                        int LA174_5 = input.LA(3);
                        if ( (synpred47_InternalXtend()) ) {
                            alt174=1;
                        }
                        }
                        break;
                    }
                }
                switch (alt174) {
            	case 1 :
            	    {

            	    {
            	    if (!consumeTokenAndMerge(98, FOLLOW_98_in_ruleQualifiedName18324, current,  elementAccess.getFullStopKeyword_1_0())) { return current; }

            	    }
            	    callRuleValidID(FOLLOW_ruleValidID_in_ruleQualifiedName18347, current, elementAccess.getValidIDParserRuleCall_1_1());
            	    if (state.failed) return current;

            	    }
            	    break;
            	default :
            	    break loop174;
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
            pushFollow(FOLLOW_ruleNumber_in_entryRuleNumber18401);
            iv_ruleNumber=ruleNumber();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumber.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumber18412); if (state.failed) return current;
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
            int alt178=2;
            int LA178_0 = input.LA(1);
            if ( (LA178_0==RULE_HEX) ) {
                alt178=1;
            }
            else if ( ((LA178_0>=RULE_INT && LA178_0<=RULE_DECIMAL)) ) {
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
                    this_token=(Token)match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleNumber18456); if (state.failed) return current;
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
                    int alt175=2;
                    int LA175_0 = input.LA(1);
                    if ( (LA175_0==RULE_INT) ) {
                        alt175=1;
                    }
                    else if ( (LA175_0==RULE_DECIMAL) ) {
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
                            this_token=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNumber18484); if (state.failed) return current;
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
                            this_token=(Token)match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_ruleNumber18510); if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                              		current.merge(this_token);
                            }
                            if ( state.backtracking==0 ) {
                                  newLeafNode(this_token, elementAccess.getDECIMALTerminalRuleCall_1_0_1()); 
                            }
                            }
                            break;
                    }
                    int alt177=2;
                    int LA177_0 = input.LA(1);
                    if ( (LA177_0==98) ) {
                        int LA177_1 = input.LA(2);
                        if ( ((LA177_1>=RULE_INT && LA177_1<=RULE_DECIMAL)) ) {
                            alt177=1;
                        }
                    }
                    switch (alt177) {
                        case 1 :
                            {
                            if (!consumeTokenAndMerge(98, FOLLOW_98_in_ruleNumber18530, current,  elementAccess.getFullStopKeyword_1_1_0())) { return current; }

                            int alt176=2;
                            int LA176_0 = input.LA(1);
                            if ( (LA176_0==RULE_INT) ) {
                                alt176=1;
                            }
                            else if ( (LA176_0==RULE_DECIMAL) ) {
                                alt176=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 176, 0, input);
                                throw nvae;
                            }
                            switch (alt176) {
                                case 1 :
                                    {
                                    this_token=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNumber18546); if (state.failed) return current;
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
                                    this_token=(Token)match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_ruleNumber18572); if (state.failed) return current;
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
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference18633);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference18643); if (state.failed) return current;
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
            int alt180=2;
            int LA180_0 = input.LA(1);
            if ( (LA180_0==RULE_ID||LA180_0==37||LA180_0==55) ) {
                alt180=1;
            }
            else if ( (LA180_0==40||LA180_0==86) ) {
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

                    {
                    current = callUnassignedRuleJvmParameterizedTypeReference(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference18691, elementAccess.getJvmParameterizedTypeReferenceParserRuleCall_0_0());
                    if (state.failed) return current;

                    loop179:
                    do {
                        int alt179=2;
                        int LA179_0 = input.LA(1);
                        if ( (LA179_0==70) ) {
                            int LA179_2 = input.LA(2);
                            if ( (LA179_2==71) ) {
                                int LA179_3 = input.LA(3);
                                if ( (synpred48_InternalXtend()) ) {
                                    alt179=1;
                                }
                            }
                        }
                        switch (alt179) {
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
                    	    pushFollow(FOLLOW_ruleArrayBrackets_in_ruleJvmTypeReference18727);
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
                    	    break loop179;
                        }
                    } while (true);
                    }
                    }
                    break;
                case 2 :
                    {
                    current = callUnassignedRuleXFunctionTypeRef(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference18758, elementAccess.getXFunctionTypeRefParserRuleCall_1());
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
            pushFollow(FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets18800);
            iv_ruleArrayBrackets=ruleArrayBrackets();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayBrackets.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayBrackets18811); if (state.failed) return current;
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
            if (!consumeTokenAndMerge(70, FOLLOW_70_in_ruleArrayBrackets18849, current,  elementAccess.getLeftSquareBracketKeyword_0())) { return current; }

            if (!consumeTokenAndMerge(71, FOLLOW_71_in_ruleArrayBrackets18862, current,  elementAccess.getRightSquareBracketKeyword_1())) { return current; }

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
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef18908);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef18918); if (state.failed) return current;
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
            int alt183=2;
            int LA183_0 = input.LA(1);
            if ( (LA183_0==40) ) {
                alt183=1;
            }
            switch (alt183) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleXFunctionTypeRef18956,  elementAccess.getLeftParenthesisKeyword_0_0())) { return current; }

                    int alt182=2;
                    int LA182_0 = input.LA(1);
                    if ( (LA182_0==RULE_ID||LA182_0==37||LA182_0==40||LA182_0==55||LA182_0==86) ) {
                        alt182=1;
                    }
                    switch (alt182) {
                        case 1 :
                            {

                            {

                            {
                            current = callRuleJvmTypeReferenceAndAdd(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef18978, current, elementAccess.getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0(), elementAccess.getRule(), XFUNCTION_TYPE_REF__PARAM_TYPES, null);
                            if (state.failed) return current;

                            }
                            }
                            loop181:
                            do {
                                int alt181=2;
                                int LA181_0 = input.LA(1);
                                if ( (LA181_0==29) ) {
                                    alt181=1;
                                }
                                switch (alt181) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXFunctionTypeRef18991,  elementAccess.getCommaKeyword_0_1_1_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleJvmTypeReferenceAndAdd(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef19012, current, elementAccess.getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0(), elementAccess.getRule(), XFUNCTION_TYPE_REF__PARAM_TYPES, null);
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop181;
                                }
                            } while (true);
                            }
                            break;
                    }
                    if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXFunctionTypeRef19028,  elementAccess.getRightParenthesisKeyword_0_2())) { return current; }

                    }
                    break;
            }
            if (!consumeUnassignedToken(86, FOLLOW_86_in_ruleXFunctionTypeRef19042,  elementAccess.getEqualsSignGreaterThanSignKeyword_1())) { return current; }


            {

            {
            current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef19063, current, elementAccess.getReturnTypeJvmTypeReferenceParserRuleCall_2_0(), elementAccess.getRule(), XFUNCTION_TYPE_REF__RETURN_TYPE, null);
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
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference19105);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference19115); if (state.failed) return current;
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
            current = callRuleQualifiedName(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference19163, current, elementAccess.getTypeJvmTypeCrossReference_0_0(), elementAccess.getRule());
            if (state.failed) return current;

            }
            }
            int alt185=2;
            alt185 = dfa185.predict(input);
            switch (alt185) {
                case 1 :
                    {

                    {
                    if (!consumeUnassignedToken(28, FOLLOW_28_in_ruleJvmParameterizedTypeReference19184,  elementAccess.getLessThanSignKeyword_1_0())) { return current; }

                    }

                    {

                    {
                    current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference19206, current, elementAccess.getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0(), elementAccess.getRule(), JVM_PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS, null);
                    if (state.failed) return current;

                    }
                    }
                    loop184:
                    do {
                        int alt184=2;
                        int LA184_0 = input.LA(1);
                        if ( (LA184_0==29) ) {
                            alt184=1;
                        }
                        switch (alt184) {
                    	case 1 :
                    	    {
                    	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleJvmParameterizedTypeReference19219,  elementAccess.getCommaKeyword_1_2_0())) { return current; }


                    	    {

                    	    {
                    	    current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference19240, current, elementAccess.getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0(), elementAccess.getRule(), JVM_PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop184;
                        }
                    } while (true);
                    if (!consumeUnassignedToken(30, FOLLOW_30_in_ruleJvmParameterizedTypeReference19254,  elementAccess.getGreaterThanSignKeyword_1_3())) { return current; }

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
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference19298);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference19308); if (state.failed) return current;
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
            int alt186=2;
            int LA186_0 = input.LA(1);
            if ( (LA186_0==RULE_ID||LA186_0==37||LA186_0==40||LA186_0==55||LA186_0==86) ) {
                alt186=1;
            }
            else if ( (LA186_0==120) ) {
                alt186=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 186, 0, input);
                throw nvae;
            }
            switch (alt186) {
                case 1 :
                    {
                    current = callUnassignedRuleJvmTypeReference(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference19355, elementAccess.getJvmTypeReferenceParserRuleCall_0());
                    if (state.failed) return current;

                    }
                    break;
                case 2 :
                    {
                    current = callUnassignedRuleJvmWildcardTypeReference(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference19382, elementAccess.getJvmWildcardTypeReferenceParserRuleCall_1());
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
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference19423);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference19433); if (state.failed) return current;
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
            if (!consumeUnassignedToken(120, FOLLOW_120_in_ruleJvmWildcardTypeReference19479,  elementAccess.getQuestionMarkKeyword_1())) { return current; }

            int alt187=3;
            int LA187_0 = input.LA(1);
            if ( (LA187_0==31) ) {
                alt187=1;
            }
            else if ( (LA187_0==110) ) {
                alt187=2;
            }
            switch (alt187) {
                case 1 :
                    {

                    {

                    {
                    current = callRuleJvmUpperBoundAndAdd(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference19501, current, elementAccess.getConstraintsJvmUpperBoundParserRuleCall_2_0_0(), elementAccess.getRule(), JVM_WILDCARD_TYPE_REFERENCE__CONSTRAINTS, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    break;
                case 2 :
                    {

                    {

                    {
                    current = callRuleJvmLowerBoundAndAdd(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference19528, current, elementAccess.getConstraintsJvmLowerBoundParserRuleCall_2_1_0(), elementAccess.getRule(), JVM_WILDCARD_TYPE_REFERENCE__CONSTRAINTS, null);
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
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound19572);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound19582); if (state.failed) return current;
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
            if (!consumeUnassignedToken(31, FOLLOW_31_in_ruleJvmUpperBound19619,  elementAccess.getExtendsKeyword_0())) { return current; }


            {

            {
            current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound19640, current, elementAccess.getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), elementAccess.getRule(), JVM_UPPER_BOUND__TYPE_REFERENCE, null);
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
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded19682);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded19692); if (state.failed) return current;
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
            if (!consumeUnassignedToken(121, FOLLOW_121_in_ruleJvmUpperBoundAnded19729,  elementAccess.getAmpersandKeyword_0())) { return current; }


            {

            {
            current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded19750, current, elementAccess.getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), elementAccess.getRule(), JVM_UPPER_BOUND__TYPE_REFERENCE, null);
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
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound19792);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound19802); if (state.failed) return current;
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
            if (!consumeUnassignedToken(110, FOLLOW_110_in_ruleJvmLowerBound19839,  elementAccess.getSuperKeyword_0())) { return current; }


            {

            {
            current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound19860, current, elementAccess.getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), elementAccess.getRule(), JVM_LOWER_BOUND__TYPE_REFERENCE, null);
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
            pushFollow(FOLLOW_ruleJvmTypeParameter_in_entryRuleJvmTypeParameter19902);
            iv_ruleJvmTypeParameter=ruleJvmTypeParameter();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeParameter19912); if (state.failed) return current;
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
            current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleJvmTypeParameter19958, current, elementAccess.getNameValidIDParserRuleCall_0_0(), elementAccess.getRule(), JVM_TYPE_PARAMETER__NAME, "ValidID");
            if (state.failed) return current;

            }
            }
            int alt189=2;
            int LA189_0 = input.LA(1);
            if ( (LA189_0==31) ) {
                alt189=1;
            }
            switch (alt189) {
                case 1 :
                    {

                    {

                    {
                    current = callRuleJvmUpperBoundAndAdd(FOLLOW_ruleJvmUpperBound_in_ruleJvmTypeParameter19980, current, elementAccess.getConstraintsJvmUpperBoundParserRuleCall_1_0_0(), elementAccess.getRule(), JVM_TYPE_PARAMETER__CONSTRAINTS, null);
                    if (state.failed) return current;

                    }
                    }
                    loop188:
                    do {
                        int alt188=2;
                        int LA188_0 = input.LA(1);
                        if ( (LA188_0==121) ) {
                            alt188=1;
                        }
                        switch (alt188) {
                    	case 1 :
                    	    {

                    	    {
                    	    current = callRuleJvmUpperBoundAndedAndAdd(FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmTypeParameter20001, current, elementAccess.getConstraintsJvmUpperBoundAndedParserRuleCall_1_1_0(), elementAccess.getRule(), JVM_TYPE_PARAMETER__CONSTRAINTS, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop188;
                        }
                    } while (true);
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
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard20047);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildcard.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard20058); if (state.failed) return current;
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
            callRuleQualifiedName(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard20105, current, elementAccess.getQualifiedNameParserRuleCall_0());
            if (state.failed) return current;

            if (!consumeTokenAndMerge(98, FOLLOW_98_in_ruleQualifiedNameWithWildcard20123, current,  elementAccess.getFullStopKeyword_1())) { return current; }

            if (!consumeTokenAndMerge(92, FOLLOW_92_in_ruleQualifiedNameWithWildcard20136, current,  elementAccess.getAsteriskKeyword_2())) { return current; }

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
            pushFollow(FOLLOW_ruleXImportSection_in_entryRuleXImportSection20182);
            iv_ruleXImportSection=ruleXImportSection();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXImportSection; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXImportSection20192); if (state.failed) return current;
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
            int cnt190=0;
            loop190:
            do {
                int alt190=2;
                int LA190_0 = input.LA(1);
                if ( (LA190_0==57) ) {
                    alt190=1;
                }
                switch (alt190) {
            	case 1 :
            	    {

            	    {
            	    current = callRuleXImportDeclarationAndAdd(FOLLOW_ruleXImportDeclaration_in_ruleXImportSection20237, current, elementAccess.getImportDeclarationsXImportDeclarationParserRuleCall_0(), elementAccess.getRule(), XIMPORT_SECTION__IMPORT_DECLARATIONS, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    break;
            	default :
            	    if ( cnt190 >= 1 ) break loop190;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(190, input);
                        throw eee;
                }
                cnt190++;
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
            pushFollow(FOLLOW_ruleXImportDeclaration_in_entryRuleXImportDeclaration20279);
            iv_ruleXImportDeclaration=ruleXImportDeclaration();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXImportDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXImportDeclaration20289); if (state.failed) return current;
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
            if (!consumeUnassignedToken(57, FOLLOW_57_in_ruleXImportDeclaration20326,  elementAccess.getImportKeyword_0())) { return current; }

            int alt192=3;
            alt192 = dfa192.predict(input);
            switch (alt192) {
                case 1 :
                    {

                    {

                    {

                    {
                    current = consumeTokenAndSetBooleanValue(48, FOLLOW_48_in_ruleXImportDeclaration20346, current,  elementAccess.getStaticStaticKeyword_1_0_0_0(), elementAccess.getRule(), XIMPORT_DECLARATION__STATIC);
                    if (state.failed) return current;

                    }
                    }
                    int alt191=2;
                    int LA191_0 = input.LA(1);
                    if ( (LA191_0==39) ) {
                        alt191=1;
                    }
                    switch (alt191) {
                        case 1 :
                            {

                            {
                            current = consumeTokenAndSetBooleanValue(39, FOLLOW_39_in_ruleXImportDeclaration20377, current,  elementAccess.getExtensionExtensionKeyword_1_0_1_0(), elementAccess.getRule(), XIMPORT_DECLARATION__EXTENSION);
                            if (state.failed) return current;

                            }
                            }
                            break;
                    }

                    {

                    {
                    current = callRuleQualifiedName(FOLLOW_ruleQualifiedName_in_ruleXImportDeclaration20414, current, elementAccess.getImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0(), elementAccess.getRule());
                    if (state.failed) return current;

                    }
                    }
                    if (!consumeUnassignedToken(98, FOLLOW_98_in_ruleXImportDeclaration20426,  elementAccess.getFullStopKeyword_1_0_3())) { return current; }

                    if (!consumeUnassignedToken(92, FOLLOW_92_in_ruleXImportDeclaration20438,  elementAccess.getAsteriskKeyword_1_0_4())) { return current; }

                    }
                    }
                    break;
                case 2 :
                    {

                    {

                    {
                    current = callRuleQualifiedName(FOLLOW_ruleQualifiedName_in_ruleXImportDeclaration20468, current, elementAccess.getImportedTypeJvmDeclaredTypeCrossReference_1_1_0(), elementAccess.getRule());
                    if (state.failed) return current;

                    }
                    }
                    }
                    break;
                case 3 :
                    {

                    {

                    {
                    current = callRuleQualifiedNameWithWildcardAndSet(FOLLOW_ruleQualifiedNameWithWildcard_in_ruleXImportDeclaration20495, current, elementAccess.getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0(), elementAccess.getRule(), XIMPORT_DECLARATION__IMPORTED_NAMESPACE, "QualifiedNameWithWildcard");
                    if (state.failed) return current;

                    }
                    }
                    }
                    break;
            }
            int alt193=2;
            int LA193_0 = input.LA(1);
            if ( (LA193_0==26) ) {
                alt193=1;
            }
            switch (alt193) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(26, FOLLOW_26_in_ruleXImportDeclaration20509,  elementAccess.getSemicolonKeyword_2())) { return current; }

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
        match(input,40,FOLLOW_40_in_synpred1_InternalXtend2348); if (state.failed) return ;
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
        match(input,40,FOLLOW_40_in_synpred2_InternalXtend2460); if (state.failed) return ;
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
        match(input,40,FOLLOW_40_in_synpred3_InternalXtend2551); if (state.failed) return ;
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
        match(input,40,FOLLOW_40_in_synpred6_InternalXtend7560); if (state.failed) return ;
        }
    }

    public final void synpred7_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {

        {
        pushFollow(FOLLOW_ruleValidID_in_synpred7_InternalXtend7589);
        ruleValidID();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        match(input,38,FOLLOW_38_in_synpred7_InternalXtend7595); if (state.failed) return ;
        }
        }
    }

    public final void synpred11_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }

        {

        {
        pushFollow(FOLLOW_ruleOpMultiAssign_in_synpred11_InternalXtend8423);
        ruleOpMultiAssign();
        state._fsp--;
        if (state.failed) return ;
        }
        }
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
        pushFollow(FOLLOW_ruleOpOr_in_synpred12_InternalXtend8810);
        ruleOpOr();
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
        pushFollow(FOLLOW_ruleOpAnd_in_synpred13_InternalXtend9081);
        ruleOpAnd();
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

        {
        }

        {

        {
        pushFollow(FOLLOW_ruleOpEquality_in_synpred14_InternalXtend9352);
        ruleOpEquality();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        }
        }
    }

    public final void synpred15_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        match(input,80,FOLLOW_80_in_synpred15_InternalXtend9678); if (state.failed) return ;
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
        pushFollow(FOLLOW_ruleOpCompare_in_synpred16_InternalXtend9749);
        ruleOpCompare();
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
        pushFollow(FOLLOW_ruleOpOther_in_synpred17_InternalXtend10080);
        ruleOpOther();
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
        match(input,30,FOLLOW_30_in_synpred18_InternalXtend10355); if (state.failed) return ;
        match(input,30,FOLLOW_30_in_synpred18_InternalXtend10360); if (state.failed) return ;
        }
        }
    }

    public final void synpred19_InternalXtend_fragment() throws RecognitionException {   

        {

        {
        match(input,28,FOLLOW_28_in_synpred19_InternalXtend10442); if (state.failed) return ;
        match(input,28,FOLLOW_28_in_synpred19_InternalXtend10447); if (state.failed) return ;
        }
        }
    }

    public final void synpred20_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }

        {

        {
        pushFollow(FOLLOW_ruleOpAdd_in_synpred20_InternalXtend10675);
        ruleOpAdd();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        }
        }
    }

    public final void synpred21_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }

        {

        {
        pushFollow(FOLLOW_ruleOpMulti_in_synpred21_InternalXtend10967);
        ruleOpMulti();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        }
        }
    }

    public final void synpred22_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        match(input,97,FOLLOW_97_in_synpred22_InternalXtend11585); if (state.failed) return ;
        }
        }
    }

    public final void synpred23_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        int alt198=2;
        int LA198_0 = input.LA(1);
        if ( (LA198_0==98) ) {
            alt198=1;
        }
        else if ( (LA198_0==99) ) {
            alt198=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 198, 0, input);
            throw nvae;
        }
        switch (alt198) {
            case 1 :
                {
                match(input,98,FOLLOW_98_in_synpred23_InternalXtend11746); if (state.failed) return ;
                }
                break;
            case 2 :
                {

                {

                {
                match(input,99,FOLLOW_99_in_synpred23_InternalXtend11760); if (state.failed) return ;
                }
                }
                }
                break;
        }

        {

        {
        pushFollow(FOLLOW_ruleFeatureCallID_in_synpred23_InternalXtend11776);
        ruleFeatureCallID();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        pushFollow(FOLLOW_ruleOpSingleAssign_in_synpred23_InternalXtend11782);
        ruleOpSingleAssign();
        state._fsp--;
        if (state.failed) return ;
        }
        }
    }

    public final void synpred24_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        int alt199=3;
        switch ( input.LA(1) ) {
        case 98:
            {
            alt199=1;
            }
            break;
        case 100:
            {
            alt199=2;
            }
            break;
        case 99:
            {
            alt199=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 199, 0, input);
            throw nvae;
        }
        switch (alt199) {
            case 1 :
                {
                match(input,98,FOLLOW_98_in_synpred24_InternalXtend11924); if (state.failed) return ;
                }
                break;
            case 2 :
                {

                {

                {
                match(input,100,FOLLOW_100_in_synpred24_InternalXtend11938); if (state.failed) return ;
                }
                }
                }
                break;
            case 3 :
                {

                {

                {
                match(input,99,FOLLOW_99_in_synpred24_InternalXtend11958); if (state.failed) return ;
                }
                }
                }
                break;
        }
        }
        }
    }

    public final void synpred25_InternalXtend_fragment() throws RecognitionException {   

        {

        {
        match(input,40,FOLLOW_40_in_synpred25_InternalXtend12185); if (state.failed) return ;
        }
        }
    }

    public final void synpred26_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        int alt201=2;
        int LA201_0 = input.LA(1);
        if ( (LA201_0==RULE_ID||LA201_0==37||(LA201_0>=39 && LA201_0<=40)||LA201_0==55||LA201_0==86) ) {
            alt201=1;
        }
        switch (alt201) {
            case 1 :
                {

                {

                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred26_InternalXtend12237);
                ruleJvmFormalParameter();
                state._fsp--;
                if (state.failed) return ;
                }
                }
                loop200:
                do {
                    int alt200=2;
                    int LA200_0 = input.LA(1);
                    if ( (LA200_0==29) ) {
                        alt200=1;
                    }
                    switch (alt200) {
                	case 1 :
                	    {
                	    match(input,29,FOLLOW_29_in_synpred26_InternalXtend12244); if (state.failed) return ;

                	    {

                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred26_InternalXtend12251);
                	    ruleJvmFormalParameter();
                	    state._fsp--;
                	    if (state.failed) return ;
                	    }
                	    }
                	    }
                	    break;
                	default :
                	    break loop200;
                    }
                } while (true);
                }
                break;
        }

        {

        {
        match(input,101,FOLLOW_101_in_synpred26_InternalXtend12265); if (state.failed) return ;
        }
        }
        }
        }
    }

    public final void synpred27_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        match(input,70,FOLLOW_70_in_synpred27_InternalXtend12385); if (state.failed) return ;
        }
        }
    }

    public final void synpred28_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        match(input,70,FOLLOW_70_in_synpred28_InternalXtend12948); if (state.failed) return ;
        }
        }
    }

    public final void synpred30_InternalXtend_fragment() throws RecognitionException {   

        {

        {
        int alt203=2;
        int LA203_0 = input.LA(1);
        if ( (LA203_0==RULE_ID||LA203_0==37||(LA203_0>=39 && LA203_0<=40)||LA203_0==55||LA203_0==86) ) {
            alt203=1;
        }
        switch (alt203) {
            case 1 :
                {

                {

                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred30_InternalXtend13722);
                ruleJvmFormalParameter();
                state._fsp--;
                if (state.failed) return ;
                }
                }
                loop202:
                do {
                    int alt202=2;
                    int LA202_0 = input.LA(1);
                    if ( (LA202_0==29) ) {
                        alt202=1;
                    }
                    switch (alt202) {
                	case 1 :
                	    {
                	    match(input,29,FOLLOW_29_in_synpred30_InternalXtend13729); if (state.failed) return ;

                	    {

                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred30_InternalXtend13736);
                	    ruleJvmFormalParameter();
                	    state._fsp--;
                	    if (state.failed) return ;
                	    }
                	    }
                	    }
                	    break;
                	default :
                	    break loop202;
                    }
                } while (true);
                }
                break;
        }

        {

        {
        match(input,101,FOLLOW_101_in_synpred30_InternalXtend13750); if (state.failed) return ;
        }
        }
        }
        }
    }

    public final void synpred32_InternalXtend_fragment() throws RecognitionException {   

        {
        match(input,103,FOLLOW_103_in_synpred32_InternalXtend14557); if (state.failed) return ;
        }
    }

    public final void synpred33_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {

        {
        pushFollow(FOLLOW_ruleValidID_in_synpred33_InternalXtend14705);
        ruleValidID();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        match(input,56,FOLLOW_56_in_synpred33_InternalXtend14711); if (state.failed) return ;
        }
        }
    }

    public final void synpred34_InternalXtend_fragment() throws RecognitionException {   

        {

        {
        match(input,40,FOLLOW_40_in_synpred34_InternalXtend14787); if (state.failed) return ;

        {

        {
        pushFollow(FOLLOW_ruleValidID_in_synpred34_InternalXtend14794);
        ruleValidID();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        match(input,56,FOLLOW_56_in_synpred34_InternalXtend14800); if (state.failed) return ;
        }
        }
    }

    public final void synpred35_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        int alt209=2;
        int LA209_0 = input.LA(1);
        if ( ((LA209_0>=51 && LA209_0<=52)) ) {
            alt209=1;
        }
        else if ( (LA209_0==39) ) {
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
                int alt206=2;
                int LA206_0 = input.LA(1);
                if ( (LA206_0==52) ) {
                    alt206=1;
                }
                else if ( (LA206_0==51) ) {
                    alt206=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 206, 0, input);
                    throw nvae;
                }
                switch (alt206) {
                    case 1 :
                        {

                        {

                        {
                        match(input,52,FOLLOW_52_in_synpred35_InternalXtend15928); if (state.failed) return ;
                        }
                        }
                        }
                        break;
                    case 2 :
                        {
                        match(input,51,FOLLOW_51_in_synpred35_InternalXtend15944); if (state.failed) return ;
                        }
                        break;
                }
                int alt207=2;
                int LA207_0 = input.LA(1);
                if ( (LA207_0==39) ) {
                    alt207=1;
                }
                switch (alt207) {
                    case 1 :
                        {

                        {
                        match(input,39,FOLLOW_39_in_synpred35_InternalXtend15953); if (state.failed) return ;
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
                match(input,39,FOLLOW_39_in_synpred35_InternalXtend15976); if (state.failed) return ;
                }
                }
                int alt208=2;
                int LA208_0 = input.LA(1);
                if ( (LA208_0==52) ) {
                    alt208=1;
                }
                else if ( (LA208_0==51) ) {
                    alt208=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 208, 0, input);
                    throw nvae;
                }
                switch (alt208) {
                    case 1 :
                        {

                        {

                        {
                        match(input,52,FOLLOW_52_in_synpred35_InternalXtend15991); if (state.failed) return ;
                        }
                        }
                        }
                        break;
                    case 2 :
                        {
                        match(input,51,FOLLOW_51_in_synpred35_InternalXtend16007); if (state.failed) return ;
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

    public final void synpred36_InternalXtend_fragment() throws RecognitionException {   

        {

        {
        match(input,40,FOLLOW_40_in_synpred36_InternalXtend16265); if (state.failed) return ;
        }
        }
    }

    public final void synpred37_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        int alt211=2;
        int LA211_0 = input.LA(1);
        if ( (LA211_0==RULE_ID||LA211_0==37||(LA211_0>=39 && LA211_0<=40)||LA211_0==55||LA211_0==86) ) {
            alt211=1;
        }
        switch (alt211) {
            case 1 :
                {

                {

                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred37_InternalXtend16317);
                ruleJvmFormalParameter();
                state._fsp--;
                if (state.failed) return ;
                }
                }
                loop210:
                do {
                    int alt210=2;
                    int LA210_0 = input.LA(1);
                    if ( (LA210_0==29) ) {
                        alt210=1;
                    }
                    switch (alt210) {
                	case 1 :
                	    {
                	    match(input,29,FOLLOW_29_in_synpred37_InternalXtend16324); if (state.failed) return ;

                	    {

                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred37_InternalXtend16331);
                	    ruleJvmFormalParameter();
                	    state._fsp--;
                	    if (state.failed) return ;
                	    }
                	    }
                	    }
                	    break;
                	default :
                	    break loop210;
                    }
                } while (true);
                }
                break;
        }

        {

        {
        match(input,101,FOLLOW_101_in_synpred37_InternalXtend16345); if (state.failed) return ;
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
        match(input,70,FOLLOW_70_in_synpred38_InternalXtend16465); if (state.failed) return ;
        }
        }
    }

    public final void synpred39_InternalXtend_fragment() throws RecognitionException {   

        {
        match(input,28,FOLLOW_28_in_synpred39_InternalXtend16746); if (state.failed) return ;
        }
    }

    public final void synpred40_InternalXtend_fragment() throws RecognitionException {   

        {
        match(input,40,FOLLOW_40_in_synpred40_InternalXtend16839); if (state.failed) return ;
        }
    }

    public final void synpred41_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        int alt213=2;
        int LA213_0 = input.LA(1);
        if ( (LA213_0==RULE_ID||LA213_0==37||(LA213_0>=39 && LA213_0<=40)||LA213_0==55||LA213_0==86) ) {
            alt213=1;
        }
        switch (alt213) {
            case 1 :
                {

                {

                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred41_InternalXtend16869);
                ruleJvmFormalParameter();
                state._fsp--;
                if (state.failed) return ;
                }
                }
                loop212:
                do {
                    int alt212=2;
                    int LA212_0 = input.LA(1);
                    if ( (LA212_0==29) ) {
                        alt212=1;
                    }
                    switch (alt212) {
                	case 1 :
                	    {
                	    match(input,29,FOLLOW_29_in_synpred41_InternalXtend16876); if (state.failed) return ;

                	    {

                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred41_InternalXtend16883);
                	    ruleJvmFormalParameter();
                	    state._fsp--;
                	    if (state.failed) return ;
                	    }
                	    }
                	    }
                	    break;
                	default :
                	    break loop212;
                    }
                } while (true);
                }
                break;
        }

        {

        {
        match(input,101,FOLLOW_101_in_synpred41_InternalXtend16897); if (state.failed) return ;
        }
        }
        }
        }
    }

    public final void synpred42_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        match(input,70,FOLLOW_70_in_synpred42_InternalXtend17017); if (state.failed) return ;
        }
        }
    }

    public final void synpred43_InternalXtend_fragment() throws RecognitionException {   

        {

        {
        pushFollow(FOLLOW_ruleXExpression_in_synpred43_InternalXtend17775);
        ruleXExpression();
        state._fsp--;
        if (state.failed) return ;
        }
        }
    }

    public final void synpred44_InternalXtend_fragment() throws RecognitionException {   

        {
        match(input,119,FOLLOW_119_in_synpred44_InternalXtend17926); if (state.failed) return ;
        }
    }

    public final void synpred45_InternalXtend_fragment() throws RecognitionException {   

        {
        match(input,118,FOLLOW_118_in_synpred45_InternalXtend17956); if (state.failed) return ;
        }
    }

    public final void synpred47_InternalXtend_fragment() throws RecognitionException {   

        {
        match(input,98,FOLLOW_98_in_synpred47_InternalXtend18315); if (state.failed) return ;
        }
    }

    public final void synpred48_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        pushFollow(FOLLOW_ruleArrayBrackets_in_synpred48_InternalXtend18706);
        ruleArrayBrackets();
        state._fsp--;
        if (state.failed) return ;
        }
        }
    }

    public final void synpred49_InternalXtend_fragment() throws RecognitionException {   

        {
        match(input,28,FOLLOW_28_in_synpred49_InternalXtend19176); if (state.failed) return ;
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
    public final boolean synpred49_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_InternalXtend_fragment(); // can never throw exception
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
    public final boolean synpred48_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_InternalXtend_fragment(); // can never throw exception
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
    public final boolean synpred42_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_InternalXtend_fragment(); // can never throw exception
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
    public final boolean synpred47_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_InternalXtend_fragment(); // can never throw exception
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
    public final boolean synpred25_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalXtend_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalXtend() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalXtend_fragment(); // can never throw exception
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
    protected DFA98 dfa98 = new DFA98(this);
    protected DFA103 dfa103 = new DFA103(this);
    protected DFA111 dfa111 = new DFA111(this);
    protected DFA114 dfa114 = new DFA114(this);
    protected DFA128 dfa128 = new DFA128(this);
    protected DFA127 dfa127 = new DFA127(this);
    protected DFA129 dfa129 = new DFA129(this);
    protected DFA131 dfa131 = new DFA131(this);
    protected DFA140 dfa140 = new DFA140(this);
    protected DFA159 dfa159 = new DFA159(this);
    protected DFA158 dfa158 = new DFA158(this);
    protected DFA160 dfa160 = new DFA160(this);
    protected DFA163 dfa163 = new DFA163(this);
    protected DFA166 dfa166 = new DFA166(this);
    protected DFA165 dfa165 = new DFA165(this);
    protected DFA167 dfa167 = new DFA167(this);
    protected DFA170 dfa170 = new DFA170(this);
    protected DFA185 dfa185 = new DFA185(this);
    protected DFA192 dfa192 = new DFA192(this);
    static final String DFA25_eotS =
        "\15\uffff";
    static final String DFA25_eofS =
        "\15\uffff";
    static final String DFA25_minS =
        "\11\31\4\uffff";
    static final String DFA25_maxS =
        "\11\62\4\uffff";
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
        "\1\126\3\142\1\uffff\3\142\1\uffff\6\142";
    static final String DFA29_acceptS =
        "\4\uffff\1\1\3\uffff\1\2\6\uffff";
    static final String DFA29_specialS =
        "\17\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\1\40\uffff\1\3\2\uffff\1\4\16\uffff\1\2\36\uffff\1\4",
            "\1\5\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\7\1\10"+
            "\1\uffff\1\10\3\uffff\11\10\2\uffff\1\6\14\uffff\1\10\1\uffff"+
            "\1\4\17\uffff\1\10\13\uffff\1\4",
            "\1\5\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\7\1\10"+
            "\1\uffff\1\10\3\uffff\11\10\2\uffff\1\6\14\uffff\1\10\1\uffff"+
            "\1\4\17\uffff\1\10\13\uffff\1\4",
            "\1\5\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\7\1\10"+
            "\1\uffff\1\10\3\uffff\11\10\2\uffff\1\6\14\uffff\1\10\1\uffff"+
            "\1\4\17\uffff\1\10\13\uffff\1\4",
            "",
            "\1\11\24\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\1"+
            "\4\1\uffff\1\4\3\uffff\11\4\2\uffff\1\12\14\uffff\1\4\1\uffff"+
            "\1\10\17\uffff\1\4\13\uffff\1\10",
            "\1\11\24\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\1"+
            "\4\1\uffff\1\4\3\uffff\11\4\2\uffff\1\12\14\uffff\1\4\1\uffff"+
            "\1\10\17\uffff\1\4\13\uffff\1\10",
            "\1\11\24\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\1"+
            "\4\1\uffff\1\4\3\uffff\11\4\2\uffff\1\12\14\uffff\1\4\1\uffff"+
            "\1\10\17\uffff\1\4\13\uffff\1\10",
            "",
            "\1\14\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\16\1"+
            "\10\1\uffff\1\10\3\uffff\11\10\2\uffff\1\15\14\uffff\1\10\1"+
            "\uffff\1\4\17\uffff\1\10\13\uffff\1\4",
            "\1\14\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\16\1"+
            "\10\1\uffff\1\10\3\uffff\11\10\2\uffff\1\15\14\uffff\1\10\1"+
            "\uffff\1\4\17\uffff\1\10\13\uffff\1\4",
            "\1\14\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\16\1"+
            "\10\1\uffff\1\10\3\uffff\11\10\2\uffff\1\15\14\uffff\1\10\1"+
            "\uffff\1\4\17\uffff\1\10\13\uffff\1\4",
            "\1\11\24\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\1"+
            "\4\1\uffff\1\4\3\uffff\11\4\2\uffff\1\12\14\uffff\1\4\1\uffff"+
            "\1\10\17\uffff\1\4\13\uffff\1\10",
            "\1\11\24\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\1"+
            "\4\1\uffff\1\4\3\uffff\11\4\2\uffff\1\12\14\uffff\1\4\1\uffff"+
            "\1\10\17\uffff\1\4\13\uffff\1\10",
            "\1\11\24\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\1"+
            "\4\1\uffff\1\4\3\uffff\11\4\2\uffff\1\12\14\uffff\1\4\1\uffff"+
            "\1\10\17\uffff\1\4\13\uffff\1\10"
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
        "\11\126\3\uffff";
    static final String DFA62_acceptS =
        "\11\uffff\1\1\1\2\1\3";
    static final String DFA62_specialS =
        "\14\uffff}>";
    static final String[] DFA62_transitionS = {
            "\1\11\24\uffff\1\4\13\uffff\1\11\1\uffff\2\11\2\uffff\1\13\1"+
            "\1\1\2\1\3\1\5\1\6\1\7\1\10\2\11\2\12\1\11\36\uffff\1\11",
            "\1\11\24\uffff\1\4\13\uffff\1\11\1\uffff\2\11\2\uffff\1\13"+
            "\1\1\1\2\1\3\1\5\1\6\1\7\1\10\2\11\2\12\1\11\36\uffff\1\11",
            "\1\11\24\uffff\1\4\13\uffff\1\11\1\uffff\2\11\2\uffff\1\13"+
            "\1\1\1\2\1\3\1\5\1\6\1\7\1\10\2\11\2\12\1\11\36\uffff\1\11",
            "\1\11\24\uffff\1\4\13\uffff\1\11\1\uffff\2\11\2\uffff\1\13"+
            "\1\1\1\2\1\3\1\5\1\6\1\7\1\10\2\11\2\12\1\11\36\uffff\1\11",
            "\1\11\24\uffff\1\4\13\uffff\1\11\1\uffff\2\11\2\uffff\1\13"+
            "\1\1\1\2\1\3\1\5\1\6\1\7\1\10\2\11\2\12\1\11\36\uffff\1\11",
            "\1\11\24\uffff\1\4\13\uffff\1\11\1\uffff\2\11\2\uffff\1\13"+
            "\1\1\1\2\1\3\1\5\1\6\1\7\1\10\2\11\2\12\1\11\36\uffff\1\11",
            "\1\11\24\uffff\1\4\13\uffff\1\11\1\uffff\2\11\2\uffff\1\13"+
            "\1\1\1\2\1\3\1\5\1\6\1\7\1\10\2\11\2\12\1\11\36\uffff\1\11",
            "\1\11\24\uffff\1\4\13\uffff\1\11\1\uffff\2\11\2\uffff\1\13"+
            "\1\1\1\2\1\3\1\5\1\6\1\7\1\10\2\11\2\12\1\11\36\uffff\1\11",
            "\1\11\24\uffff\1\4\13\uffff\1\11\1\uffff\2\11\2\uffff\1\13"+
            "\1\1\1\2\1\3\1\5\1\6\1\7\1\10\2\11\2\12\1\11\36\uffff\1\11",
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
        "\3\126\2\uffff\10\126\2\uffff";
    static final String DFA42_acceptS =
        "\3\uffff\1\2\1\4\10\uffff\1\3\1\1";
    static final String DFA42_specialS =
        "\17\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\4\40\uffff\1\4\1\uffff\1\3\1\4\12\uffff\1\1\1\2\2\uffff\1"+
            "\4\36\uffff\1\4",
            "\1\16\24\uffff\1\10\13\uffff\1\16\1\uffff\1\15\1\16\3\uffff"+
            "\1\5\1\6\1\7\1\11\1\12\1\13\1\14\4\uffff\1\16\36\uffff\1\16",
            "\1\16\24\uffff\1\10\13\uffff\1\16\1\uffff\1\15\1\16\3\uffff"+
            "\1\5\1\6\1\7\1\11\1\12\1\13\1\14\4\uffff\1\16\36\uffff\1\16",
            "",
            "",
            "\1\16\24\uffff\1\10\13\uffff\1\16\1\uffff\1\15\1\16\3\uffff"+
            "\1\5\1\6\1\7\1\11\1\12\1\13\1\14\4\uffff\1\16\36\uffff\1\16",
            "\1\16\24\uffff\1\10\13\uffff\1\16\1\uffff\1\15\1\16\3\uffff"+
            "\1\5\1\6\1\7\1\11\1\12\1\13\1\14\4\uffff\1\16\36\uffff\1\16",
            "\1\16\24\uffff\1\10\13\uffff\1\16\1\uffff\1\15\1\16\3\uffff"+
            "\1\5\1\6\1\7\1\11\1\12\1\13\1\14\4\uffff\1\16\36\uffff\1\16",
            "\1\16\24\uffff\1\10\13\uffff\1\16\1\uffff\1\15\1\16\3\uffff"+
            "\1\5\1\6\1\7\1\11\1\12\1\13\1\14\4\uffff\1\16\36\uffff\1\16",
            "\1\16\24\uffff\1\10\13\uffff\1\16\1\uffff\1\15\1\16\3\uffff"+
            "\1\5\1\6\1\7\1\11\1\12\1\13\1\14\4\uffff\1\16\36\uffff\1\16",
            "\1\16\24\uffff\1\10\13\uffff\1\16\1\uffff\1\15\1\16\3\uffff"+
            "\1\5\1\6\1\7\1\11\1\12\1\13\1\14\4\uffff\1\16\36\uffff\1\16",
            "\1\16\24\uffff\1\10\13\uffff\1\16\1\uffff\1\15\1\16\3\uffff"+
            "\1\5\1\6\1\7\1\11\1\12\1\13\1\14\4\uffff\1\16\36\uffff\1\16",
            "\1\16\24\uffff\1\10\13\uffff\1\16\1\uffff\1\15\1\16\3\uffff"+
            "\1\5\1\6\1\7\1\11\1\12\1\13\1\14\4\uffff\1\16\36\uffff\1\16",
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
        "\1\uffff\3\10\1\uffff\3\4\7\uffff";
    static final String DFA36_minS =
        "\4\4\1\uffff\3\4\1\uffff\6\4";
    static final String DFA36_maxS =
        "\1\126\3\142\1\uffff\3\142\1\uffff\6\142";
    static final String DFA36_acceptS =
        "\4\uffff\1\1\3\uffff\1\2\6\uffff";
    static final String DFA36_specialS =
        "\17\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\1\40\uffff\1\3\2\uffff\1\4\16\uffff\1\2\36\uffff\1\4",
            "\1\5\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\7\3\10"+
            "\2\uffff\14\10\1\6\14\uffff\1\10\1\uffff\1\4\17\uffff\1\10\13"+
            "\uffff\1\4",
            "\1\5\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\7\3\10"+
            "\2\uffff\14\10\1\6\14\uffff\1\10\1\uffff\1\4\17\uffff\1\10\13"+
            "\uffff\1\4",
            "\1\5\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\7\3\10"+
            "\2\uffff\14\10\1\6\14\uffff\1\10\1\uffff\1\4\17\uffff\1\10\13"+
            "\uffff\1\4",
            "",
            "\1\11\24\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\3"+
            "\4\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\10\17\uffff\1\4"+
            "\13\uffff\1\10",
            "\1\11\24\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\3"+
            "\4\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\10\17\uffff\1\4"+
            "\13\uffff\1\10",
            "\1\11\24\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\3"+
            "\4\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\10\17\uffff\1\4"+
            "\13\uffff\1\10",
            "",
            "\1\14\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\16\3"+
            "\10\2\uffff\14\10\1\15\14\uffff\1\10\1\uffff\1\4\17\uffff\1"+
            "\10\13\uffff\1\4",
            "\1\14\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\16\3"+
            "\10\2\uffff\14\10\1\15\14\uffff\1\10\1\uffff\1\4\17\uffff\1"+
            "\10\13\uffff\1\4",
            "\1\14\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\16\3"+
            "\10\2\uffff\14\10\1\15\14\uffff\1\10\1\uffff\1\4\17\uffff\1"+
            "\10\13\uffff\1\4",
            "\1\11\24\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\3"+
            "\4\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\10\17\uffff\1\4"+
            "\13\uffff\1\10",
            "\1\11\24\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\3"+
            "\4\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\10\17\uffff\1\4"+
            "\13\uffff\1\10",
            "\1\11\24\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\3"+
            "\4\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\10\17\uffff\1\4"+
            "\13\uffff\1\10"
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
        "\1\4\3\10\10\uffff";
    static final String DFA38_minS =
        "\4\4\1\uffff\3\4\1\uffff\3\4";
    static final String DFA38_maxS =
        "\1\126\3\142\1\uffff\3\142\1\uffff\3\142";
    static final String DFA38_acceptS =
        "\4\uffff\1\2\3\uffff\1\1\3\uffff";
    static final String DFA38_specialS =
        "\14\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\1\24\uffff\2\4\7\uffff\1\4\2\uffff\1\3\3\4\2\uffff\14\4\1"+
            "\2\14\uffff\1\4\21\uffff\1\4",
            "\1\5\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\7\3\10"+
            "\2\uffff\14\10\1\6\14\uffff\1\10\1\uffff\1\4\17\uffff\1\10\13"+
            "\uffff\1\4",
            "\1\5\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\7\3\10"+
            "\2\uffff\14\10\1\6\14\uffff\1\10\1\uffff\1\4\17\uffff\1\10\13"+
            "\uffff\1\4",
            "\1\5\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\7\3\10"+
            "\2\uffff\14\10\1\6\14\uffff\1\10\1\uffff\1\4\17\uffff\1\10\13"+
            "\uffff\1\4",
            "",
            "\1\11\24\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\3"+
            "\4\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\10\17\uffff\1\4"+
            "\13\uffff\1\10",
            "\1\11\24\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\3"+
            "\4\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\10\17\uffff\1\4"+
            "\13\uffff\1\10",
            "\1\11\24\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\3"+
            "\4\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\10\17\uffff\1\4"+
            "\13\uffff\1\10",
            "",
            "\1\5\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\7\3\10"+
            "\2\uffff\14\10\1\6\14\uffff\1\10\1\uffff\1\4\17\uffff\1\10\13"+
            "\uffff\1\4",
            "\1\5\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\7\3\10"+
            "\2\uffff\14\10\1\6\14\uffff\1\10\1\uffff\1\4\17\uffff\1\10\13"+
            "\uffff\1\4",
            "\1\5\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\7\3\10"+
            "\2\uffff\14\10\1\6\14\uffff\1\10\1\uffff\1\4\17\uffff\1\10\13"+
            "\uffff\1\4"
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
        "\1\4\3\10\10\uffff";
    static final String DFA41_minS =
        "\4\4\1\uffff\3\4\1\uffff\3\4";
    static final String DFA41_maxS =
        "\1\126\3\142\1\uffff\3\142\1\uffff\3\142";
    static final String DFA41_acceptS =
        "\4\uffff\1\2\3\uffff\1\1\3\uffff";
    static final String DFA41_specialS =
        "\14\uffff}>";
    static final String[] DFA41_transitionS = {
            "\1\1\24\uffff\2\4\7\uffff\1\4\2\uffff\1\3\3\4\2\uffff\14\4\1"+
            "\2\14\uffff\1\4\21\uffff\1\4",
            "\1\5\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\7\3\10"+
            "\2\uffff\14\10\1\6\14\uffff\1\10\1\uffff\1\4\17\uffff\1\10\13"+
            "\uffff\1\4",
            "\1\5\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\7\3\10"+
            "\2\uffff\14\10\1\6\14\uffff\1\10\1\uffff\1\4\17\uffff\1\10\13"+
            "\uffff\1\4",
            "\1\5\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\7\3\10"+
            "\2\uffff\14\10\1\6\14\uffff\1\10\1\uffff\1\4\17\uffff\1\10\13"+
            "\uffff\1\4",
            "",
            "\1\11\24\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\3"+
            "\4\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\10\17\uffff\1\4"+
            "\13\uffff\1\10",
            "\1\11\24\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\3"+
            "\4\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\10\17\uffff\1\4"+
            "\13\uffff\1\10",
            "\1\11\24\uffff\2\4\1\uffff\1\10\5\uffff\1\4\2\uffff\1\13\3"+
            "\4\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\10\17\uffff\1\4"+
            "\13\uffff\1\10",
            "",
            "\1\5\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\7\3\10"+
            "\2\uffff\14\10\1\6\14\uffff\1\10\1\uffff\1\4\17\uffff\1\10\13"+
            "\uffff\1\4",
            "\1\5\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\7\3\10"+
            "\2\uffff\14\10\1\6\14\uffff\1\10\1\uffff\1\4\17\uffff\1\10\13"+
            "\uffff\1\4",
            "\1\5\24\uffff\2\10\1\uffff\1\4\5\uffff\1\10\2\uffff\1\7\3\10"+
            "\2\uffff\14\10\1\6\14\uffff\1\10\1\uffff\1\4\17\uffff\1\10\13"+
            "\uffff\1\4"
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
        "\1\126\5\0\4\uffff";
    static final String DFA49_acceptS =
        "\6\uffff\1\1\1\2\1\4\1\3";
    static final String DFA49_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\4\uffff}>";
    static final String[] DFA49_transitionS = {
            "\1\1\40\uffff\1\3\2\uffff\1\4\16\uffff\1\2\36\uffff\1\5",
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
        "\1\126\1\0\35\uffff";
    static final String DFA99_acceptS =
        "\2\uffff\1\2\33\uffff\1\1";
    static final String DFA99_specialS =
        "\1\uffff\1\0\35\uffff}>";
    static final String[] DFA99_transitionS = {
            "\1\2\24\uffff\3\2\1\uffff\1\2\4\uffff\4\2\1\uffff\1\2\1\1\1"+
            "\2\1\uffff\15\2\14\uffff\1\2\2\uffff\1\2\16\uffff\1\2",
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
            return "4074:2: ( ( ( '(' )=>other= '(' ) ( ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> (this_object= ruleXAnnotationElementValuePair ) ) (other= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (this_object= ruleXAnnotationElementValuePair ) ) )* ) | ( (this_object= ruleXAnnotationElementValue ) ) )? other= ')' )?";
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
    static final String DFA98_eotS =
        "\65\uffff";
    static final String DFA98_eofS =
        "\65\uffff";
    static final String DFA98_minS =
        "\1\4\3\0\61\uffff";
    static final String DFA98_maxS =
        "\1\165\3\0\61\uffff";
    static final String DFA98_acceptS =
        "\4\uffff\1\2\56\uffff\1\3\1\1";
    static final String DFA98_specialS =
        "\1\uffff\1\0\1\1\1\2\61\uffff}>";
    static final String[] DFA98_transitionS = {
            "\1\1\3\4\4\uffff\3\4\12\uffff\1\4\1\uffff\2\4\2\uffff\3\4\1"+
            "\uffff\2\4\1\3\1\uffff\2\4\1\63\11\4\2\uffff\2\4\1\2\1\uffff"+
            "\1\4\12\uffff\3\4\23\uffff\2\4\4\uffff\1\4\5\uffff\1\4\1\uffff"+
            "\1\4\2\uffff\13\4",
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
    static final short[] DFA98_eot = DFA.unpackEncodedString(DFA98_eotS);
    static final short[] DFA98_eof = DFA.unpackEncodedString(DFA98_eofS);
    static final char[] DFA98_min = DFA.unpackEncodedStringToUnsignedChars(DFA98_minS);
    static final char[] DFA98_max = DFA.unpackEncodedStringToUnsignedChars(DFA98_maxS);
    static final short[] DFA98_accept = DFA.unpackEncodedString(DFA98_acceptS);
    static final short[] DFA98_special = DFA.unpackEncodedString(DFA98_specialS);
    static final short[][] DFA98_transition;
    static {
        int numStates = DFA98_transitionS.length;
        DFA98_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA98_transition[i] = DFA.unpackEncodedString(DFA98_transitionS[i]);
        }
    }
    class DFA98 extends DFA {
        public DFA98(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 98;
            this.eot = DFA98_eot;
            this.eof = DFA98_eof;
            this.min = DFA98_min;
            this.max = DFA98_max;
            this.accept = DFA98_accept;
            this.special = DFA98_special;
            this.transition = DFA98_transition;
        }
        public String getDescription() {
            return "4079:2: ( ( ( ( ( ( ( ruleValidID ) ) '=' ) )=> (this_object= ruleXAnnotationElementValuePair ) ) (other= ',' ( ( ( ( ( ruleValidID ) ) '=' ) )=> (this_object= ruleXAnnotationElementValuePair ) ) )* ) | ( (this_object= ruleXAnnotationElementValue ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA98_1 = input.LA(1);
                        int index98_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalXtend()) ) {s = 52;}
                        else if ( (true) ) {s = 4;}
                        input.seek(index98_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA98_2 = input.LA(1);
                        int index98_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalXtend()) ) {s = 52;}
                        else if ( (true) ) {s = 4;}
                        input.seek(index98_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA98_3 = input.LA(1);
                        int index98_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalXtend()) ) {s = 52;}
                        else if ( (true) ) {s = 4;}
                        input.seek(index98_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 98, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA103_eotS =
        "\30\uffff";
    static final String DFA103_eofS =
        "\1\uffff\25\26\2\uffff";
    static final String DFA103_minS =
        "\26\4\2\uffff";
    static final String DFA103_maxS =
        "\1\165\25\167\2\uffff";
    static final String DFA103_acceptS =
        "\26\uffff\1\2\1\1";
    static final String DFA103_specialS =
        "\30\uffff}>";
    static final String[] DFA103_transitionS = {
            "\1\1\3\26\4\uffff\3\26\12\uffff\1\20\1\uffff\1\4\1\26\2\uffff"+
            "\1\11\1\14\1\26\1\uffff\1\16\1\10\1\3\1\uffff\1\12\1\26\1\uffff"+
            "\1\25\1\26\1\21\1\22\1\23\1\2\1\24\1\7\1\13\2\uffff\1\6\1\17"+
            "\1\5\1\uffff\1\15\13\uffff\2\26\23\uffff\2\26\4\uffff\1\26\5"+
            "\uffff\1\26\1\uffff\1\26\2\uffff\13\26",
            "\13\26\12\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\22\26",
            "\13\26\12\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\22\26",
            "\13\26\12\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\22\26",
            "\13\26\12\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\22\26",
            "\13\26\12\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\22\26",
            "\13\26\12\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\22\26",
            "\13\26\12\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\22\26",
            "\13\26\12\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\22\26",
            "\13\26\12\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\22\26",
            "\13\26\12\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\22\26",
            "\13\26\12\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\22\26",
            "\13\26\12\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\22\26",
            "\13\26\12\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\22\26",
            "\13\26\12\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\22\26",
            "\13\26\12\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\22\26",
            "\13\26\12\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\22\26",
            "\13\26\12\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\22\26",
            "\13\26\12\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\22\26",
            "\13\26\12\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\22\26",
            "\13\26\12\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\22\26",
            "\13\26\12\uffff\15\26\1\27\23\26\2\uffff\3\26\5\uffff\41\26"+
            "\1\uffff\22\26",
            "",
            ""
    };
    static final short[] DFA103_eot = DFA.unpackEncodedString(DFA103_eotS);
    static final short[] DFA103_eof = DFA.unpackEncodedString(DFA103_eofS);
    static final char[] DFA103_min = DFA.unpackEncodedStringToUnsignedChars(DFA103_minS);
    static final char[] DFA103_max = DFA.unpackEncodedStringToUnsignedChars(DFA103_maxS);
    static final short[] DFA103_accept = DFA.unpackEncodedString(DFA103_acceptS);
    static final short[] DFA103_special = DFA.unpackEncodedString(DFA103_specialS);
    static final short[][] DFA103_transition;
    static {
        int numStates = DFA103_transitionS.length;
        DFA103_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA103_transition[i] = DFA.unpackEncodedString(DFA103_transitionS[i]);
        }
    }
    class DFA103 extends DFA {
        public DFA103(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 103;
            this.eot = DFA103_eot;
            this.eof = DFA103_eof;
            this.min = DFA103_min;
            this.max = DFA103_max;
            this.accept = DFA103_accept;
            this.special = DFA103_special;
            this.transition = DFA103_transition;
        }
        public String getDescription() {
            return "4404:1: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (this_object= ruleXAssignment ) ) ) | (this_object= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (this_object= ruleXAssignment ) ) )? ) )";
        }
    }
    static final String DFA111_eotS =
        "\14\uffff";
    static final String DFA111_eofS =
        "\1\1\13\uffff";
    static final String DFA111_minS =
        "\1\4\1\uffff\11\0\1\uffff";
    static final String DFA111_maxS =
        "\1\167\1\uffff\11\0\1\uffff";
    static final String DFA111_acceptS =
        "\1\uffff\1\2\11\uffff\1\1";
    static final String DFA111_specialS =
        "\2\uffff\1\4\1\3\1\0\1\6\1\1\1\7\1\5\1\2\1\10\1\uffff}>";
    static final String[] DFA111_transitionS = {
            "\13\1\12\uffff\3\1\1\3\1\1\1\2\7\1\1\uffff\23\1\2\uffff\3\1"+
            "\5\uffff\17\1\1\5\1\6\1\7\1\4\1\10\1\11\1\12\13\1\1\uffff\22"+
            "\1",
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
    static final short[] DFA111_eot = DFA.unpackEncodedString(DFA111_eotS);
    static final short[] DFA111_eof = DFA.unpackEncodedString(DFA111_eofS);
    static final char[] DFA111_min = DFA.unpackEncodedStringToUnsignedChars(DFA111_minS);
    static final char[] DFA111_max = DFA.unpackEncodedStringToUnsignedChars(DFA111_maxS);
    static final short[] DFA111_accept = DFA.unpackEncodedString(DFA111_acceptS);
    static final short[] DFA111_special = DFA.unpackEncodedString(DFA111_specialS);
    static final short[][] DFA111_transition;
    static {
        int numStates = DFA111_transitionS.length;
        DFA111_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA111_transition[i] = DFA.unpackEncodedString(DFA111_transitionS[i]);
        }
    }
    class DFA111 extends DFA {
        public DFA111(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 111;
            this.eot = DFA111_eot;
            this.eof = DFA111_eof;
            this.min = DFA111_min;
            this.max = DFA111_max;
            this.accept = DFA111_accept;
            this.special = DFA111_special;
            this.transition = DFA111_transition;
        }
        public String getDescription() {
            return "()* loopback of 5168:1: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (this_object= ruleXAdditiveExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA111_4 = input.LA(1);
                        int index111_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index111_4);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA111_6 = input.LA(1);
                        int index111_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index111_6);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA111_9 = input.LA(1);
                        int index111_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index111_9);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA111_3 = input.LA(1);
                        int index111_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index111_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA111_2 = input.LA(1);
                        int index111_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index111_2);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA111_8 = input.LA(1);
                        int index111_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index111_8);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA111_5 = input.LA(1);
                        int index111_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index111_5);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA111_7 = input.LA(1);
                        int index111_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index111_7);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA111_10 = input.LA(1);
                        int index111_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index111_10);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 111, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA114_eotS =
        "\14\uffff";
    static final String DFA114_eofS =
        "\14\uffff";
    static final String DFA114_minS =
        "\1\34\2\uffff\1\36\10\uffff";
    static final String DFA114_maxS =
        "\1\131\2\uffff\1\125\10\uffff";
    static final String DFA114_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\4\1\5\1\7\1\10\1\11\1\12\1\6\1\3";
    static final String DFA114_specialS =
        "\14\uffff}>";
    static final String[] DFA114_transitionS = {
            "\1\6\1\uffff\1\3\64\uffff\1\1\1\2\1\4\1\5\1\7\1\10\1\11",
            "",
            "",
            "\1\12\66\uffff\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final short[] DFA114_eot = DFA.unpackEncodedString(DFA114_eotS);
    static final short[] DFA114_eof = DFA.unpackEncodedString(DFA114_eofS);
    static final char[] DFA114_min = DFA.unpackEncodedStringToUnsignedChars(DFA114_minS);
    static final char[] DFA114_max = DFA.unpackEncodedStringToUnsignedChars(DFA114_maxS);
    static final short[] DFA114_accept = DFA.unpackEncodedString(DFA114_acceptS);
    static final short[] DFA114_special = DFA.unpackEncodedString(DFA114_specialS);
    static final short[][] DFA114_transition;
    static {
        int numStates = DFA114_transitionS.length;
        DFA114_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA114_transition[i] = DFA.unpackEncodedString(DFA114_transitionS[i]);
        }
    }
    class DFA114 extends DFA {
        public DFA114(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 114;
            this.eot = DFA114_eot;
            this.eof = DFA114_eof;
            this.min = DFA114_min;
            this.max = DFA114_max;
            this.accept = DFA114_accept;
            this.special = DFA114_special;
            this.transition = DFA114_transition;
        }
        public String getDescription() {
            return "5242:1: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' ) ) | kw= '<>' | kw= '?:' | kw= '<=>' )";
        }
    }
    static final String DFA128_eotS =
        "\144\uffff";
    static final String DFA128_eofS =
        "\1\2\143\uffff";
    static final String DFA128_minS =
        "\1\4\1\0\142\uffff";
    static final String DFA128_maxS =
        "\1\167\1\0\142\uffff";
    static final String DFA128_acceptS =
        "\2\uffff\1\2\140\uffff\1\1";
    static final String DFA128_specialS =
        "\1\uffff\1\0\142\uffff}>";
    static final String[] DFA128_transitionS = {
            "\13\2\12\uffff\15\2\1\uffff\1\2\1\1\21\2\2\uffff\3\2\5\uffff"+
            "\41\2\1\uffff\22\2",
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
            return "6066:2: ( ( ( ( '(' ) )=> (other= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (this_object= ruleXShortClosure ) ) | ( ( (this_object= ruleXExpression ) ) (other= ',' ( (this_object= ruleXExpression ) ) )* ) )? other= ')' )?";
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
                        if ( (synpred25_InternalXtend()) ) {s = 99;}
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
        "\1\165\5\0\57\uffff";
    static final String DFA127_acceptS =
        "\6\uffff\2\1\1\2\53\uffff\1\3";
    static final String DFA127_specialS =
        "\1\0\1\1\1\2\1\3\1\4\1\5\57\uffff}>";
    static final String[] DFA127_transitionS = {
            "\1\2\3\10\4\uffff\3\10\12\uffff\1\10\1\uffff\2\10\2\uffff\3"+
            "\10\1\uffff\2\10\1\4\1\uffff\1\1\1\5\1\64\11\10\2\uffff\2\10"+
            "\1\3\1\uffff\1\10\13\uffff\2\10\17\uffff\1\6\3\uffff\2\10\4"+
            "\uffff\1\10\4\uffff\1\7\1\10\1\uffff\1\10\2\uffff\13\10",
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
            return "6087:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (this_object= ruleXShortClosure ) ) | ( ( (this_object= ruleXExpression ) ) (other= ',' ( (this_object= ruleXExpression ) ) )* ) )?";
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
                        if ( (LA127_0==39) ) {s = 1;}
                        else if ( (LA127_0==RULE_ID) ) {s = 2;}
                        else if ( (LA127_0==55) ) {s = 3;}
                        else if ( (LA127_0==37) ) {s = 4;}
                        else if ( (LA127_0==40) ) {s = 5;}
                        else if ( (LA127_0==86) && (synpred26_InternalXtend())) {s = 6;}
                        else if ( (LA127_0==101) && (synpred26_InternalXtend())) {s = 7;}
                        else if ( ((LA127_0>=RULE_STRING && LA127_0<=RULE_RICH_TEXT_START)||(LA127_0>=RULE_HEX && LA127_0<=RULE_DECIMAL)||LA127_0==25||(LA127_0>=27 && LA127_0<=28)||(LA127_0>=31 && LA127_0<=33)||(LA127_0>=35 && LA127_0<=36)||(LA127_0>=42 && LA127_0<=50)||(LA127_0>=53 && LA127_0<=54)||LA127_0==57||(LA127_0>=69 && LA127_0<=70)||(LA127_0>=90 && LA127_0<=91)||LA127_0==96||LA127_0==102||LA127_0==104||(LA127_0>=107 && LA127_0<=117)) ) {s = 8;}
                        else if ( (LA127_0==41) ) {s = 52;}
                        input.seek(index127_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA127_1 = input.LA(1);
                        int index127_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index127_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA127_2 = input.LA(1);
                        int index127_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index127_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA127_3 = input.LA(1);
                        int index127_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index127_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA127_4 = input.LA(1);
                        int index127_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index127_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA127_5 = input.LA(1);
                        int index127_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalXtend()) ) {s = 7;}
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
        "\1\167\1\0\142\uffff";
    static final String DFA129_acceptS =
        "\2\uffff\1\2\140\uffff\1\1";
    static final String DFA129_specialS =
        "\1\uffff\1\0\142\uffff}>";
    static final String[] DFA129_transitionS = {
            "\13\2\12\uffff\15\2\1\uffff\23\2\2\uffff\3\2\5\uffff\2\2\1\1"+
            "\36\2\1\uffff\22\2",
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
            return "6166:3: ( ( ( () '[' ) )=> (this_object= ruleXClosure ) )?";
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
                        if ( (synpred27_InternalXtend()) ) {s = 99;}
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
        "\1\165\15\uffff";
    static final String DFA131_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\15";
    static final String DFA131_specialS =
        "\16\uffff}>";
    static final String[] DFA131_transitionS = {
            "\1\4\3\5\4\uffff\3\5\12\uffff\1\4\1\uffff\2\4\2\uffff\2\4\1"+
            "\2\1\uffff\3\4\1\uffff\1\4\1\15\1\uffff\1\4\1\1\7\4\2\uffff"+
            "\3\4\1\uffff\1\4\13\uffff\2\5\37\uffff\1\6\1\uffff\1\3\2\uffff"+
            "\1\7\1\10\1\11\1\4\4\5\1\12\1\13\1\14",
            "",
            "",
            "",
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
            return "6215:1: (this_object= ruleXConstructorCall | this_object= ruleXBlockExpression | this_object= ruleXSwitchExpression | this_object= ruleXFeatureCall | this_object= ruleXLiteral | this_object= ruleXIfExpression | this_object= ruleXForLoopExpression | this_object= ruleXWhileExpression | this_object= ruleXDoWhileExpression | this_object= ruleXThrowExpression | this_object= ruleXReturnExpression | this_object= ruleXTryCatchFinallyExpression | this_object= ruleXParenthesizedExpression )";
        }
    }
    static final String DFA140_eotS =
        "\67\uffff";
    static final String DFA140_eofS =
        "\67\uffff";
    static final String DFA140_minS =
        "\1\4\5\0\61\uffff";
    static final String DFA140_maxS =
        "\1\165\5\0\61\uffff";
    static final String DFA140_acceptS =
        "\6\uffff\2\1\1\2\56\uffff";
    static final String DFA140_specialS =
        "\1\0\1\1\1\2\1\3\1\4\1\5\61\uffff}>";
    static final String[] DFA140_transitionS = {
            "\1\2\3\10\4\uffff\3\10\12\uffff\1\10\1\uffff\2\10\2\uffff\3"+
            "\10\1\uffff\2\10\1\4\1\uffff\1\1\1\5\1\uffff\15\10\1\3\1\uffff"+
            "\1\10\13\uffff\3\10\16\uffff\1\6\3\uffff\2\10\4\uffff\1\10\4"+
            "\uffff\1\7\1\10\1\uffff\1\10\2\uffff\13\10",
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
            return "6710:3: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (this_object= ruleJvmFormalParameter ) ) (other= ',' ( (this_object= ruleJvmFormalParameter ) ) )* )? ( (other= '|' ) ) ) )?";
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
                        if ( (LA140_0==39) ) {s = 1;}
                        else if ( (LA140_0==RULE_ID) ) {s = 2;}
                        else if ( (LA140_0==55) ) {s = 3;}
                        else if ( (LA140_0==37) ) {s = 4;}
                        else if ( (LA140_0==40) ) {s = 5;}
                        else if ( (LA140_0==86) && (synpred30_InternalXtend())) {s = 6;}
                        else if ( (LA140_0==101) && (synpred30_InternalXtend())) {s = 7;}
                        else if ( ((LA140_0>=RULE_STRING && LA140_0<=RULE_RICH_TEXT_START)||(LA140_0>=RULE_HEX && LA140_0<=RULE_DECIMAL)||LA140_0==25||(LA140_0>=27 && LA140_0<=28)||(LA140_0>=31 && LA140_0<=33)||(LA140_0>=35 && LA140_0<=36)||(LA140_0>=42 && LA140_0<=54)||LA140_0==57||(LA140_0>=69 && LA140_0<=71)||(LA140_0>=90 && LA140_0<=91)||LA140_0==96||LA140_0==102||LA140_0==104||(LA140_0>=107 && LA140_0<=117)) ) {s = 8;}
                        input.seek(index140_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA140_1 = input.LA(1);
                        int index140_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index140_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA140_2 = input.LA(1);
                        int index140_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index140_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA140_3 = input.LA(1);
                        int index140_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index140_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA140_4 = input.LA(1);
                        int index140_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index140_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA140_5 = input.LA(1);
                        int index140_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalXtend()) ) {s = 7;}
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
    static final String DFA159_eotS =
        "\144\uffff";
    static final String DFA159_eofS =
        "\1\2\143\uffff";
    static final String DFA159_minS =
        "\1\4\1\0\142\uffff";
    static final String DFA159_maxS =
        "\1\167\1\0\142\uffff";
    static final String DFA159_acceptS =
        "\2\uffff\1\2\140\uffff\1\1";
    static final String DFA159_specialS =
        "\1\uffff\1\0\142\uffff}>";
    static final String[] DFA159_transitionS = {
            "\13\2\12\uffff\15\2\1\uffff\1\2\1\1\21\2\2\uffff\3\2\5\uffff"+
            "\41\2\1\uffff\22\2",
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
            return "7942:2: ( ( ( ( '(' ) )=> (other= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (this_object= ruleXShortClosure ) ) | ( ( (this_object= ruleXExpression ) ) (other= ',' ( (this_object= ruleXExpression ) ) )* ) )? other= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA159_1 = input.LA(1);
                        int index159_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 2;}
                        input.seek(index159_1);
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
    static final String DFA158_eotS =
        "\65\uffff";
    static final String DFA158_eofS =
        "\65\uffff";
    static final String DFA158_minS =
        "\1\4\5\0\57\uffff";
    static final String DFA158_maxS =
        "\1\165\5\0\57\uffff";
    static final String DFA158_acceptS =
        "\6\uffff\2\1\1\2\53\uffff\1\3";
    static final String DFA158_specialS =
        "\1\0\1\1\1\2\1\3\1\4\1\5\57\uffff}>";
    static final String[] DFA158_transitionS = {
            "\1\2\3\10\4\uffff\3\10\12\uffff\1\10\1\uffff\2\10\2\uffff\3"+
            "\10\1\uffff\2\10\1\4\1\uffff\1\1\1\5\1\64\11\10\2\uffff\2\10"+
            "\1\3\1\uffff\1\10\13\uffff\2\10\17\uffff\1\6\3\uffff\2\10\4"+
            "\uffff\1\10\4\uffff\1\7\1\10\1\uffff\1\10\2\uffff\13\10",
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
    static final short[] DFA158_eot = DFA.unpackEncodedString(DFA158_eotS);
    static final short[] DFA158_eof = DFA.unpackEncodedString(DFA158_eofS);
    static final char[] DFA158_min = DFA.unpackEncodedStringToUnsignedChars(DFA158_minS);
    static final char[] DFA158_max = DFA.unpackEncodedStringToUnsignedChars(DFA158_maxS);
    static final short[] DFA158_accept = DFA.unpackEncodedString(DFA158_acceptS);
    static final short[] DFA158_special = DFA.unpackEncodedString(DFA158_specialS);
    static final short[][] DFA158_transition;
    static {
        int numStates = DFA158_transitionS.length;
        DFA158_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA158_transition[i] = DFA.unpackEncodedString(DFA158_transitionS[i]);
        }
    }
    class DFA158 extends DFA {
        public DFA158(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 158;
            this.eot = DFA158_eot;
            this.eof = DFA158_eof;
            this.min = DFA158_min;
            this.max = DFA158_max;
            this.accept = DFA158_accept;
            this.special = DFA158_special;
            this.transition = DFA158_transition;
        }
        public String getDescription() {
            return "7963:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (this_object= ruleXShortClosure ) ) | ( ( (this_object= ruleXExpression ) ) (other= ',' ( (this_object= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA158_0 = input.LA(1);
                        int index158_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA158_0==39) ) {s = 1;}
                        else if ( (LA158_0==RULE_ID) ) {s = 2;}
                        else if ( (LA158_0==55) ) {s = 3;}
                        else if ( (LA158_0==37) ) {s = 4;}
                        else if ( (LA158_0==40) ) {s = 5;}
                        else if ( (LA158_0==86) && (synpred37_InternalXtend())) {s = 6;}
                        else if ( (LA158_0==101) && (synpred37_InternalXtend())) {s = 7;}
                        else if ( ((LA158_0>=RULE_STRING && LA158_0<=RULE_RICH_TEXT_START)||(LA158_0>=RULE_HEX && LA158_0<=RULE_DECIMAL)||LA158_0==25||(LA158_0>=27 && LA158_0<=28)||(LA158_0>=31 && LA158_0<=33)||(LA158_0>=35 && LA158_0<=36)||(LA158_0>=42 && LA158_0<=50)||(LA158_0>=53 && LA158_0<=54)||LA158_0==57||(LA158_0>=69 && LA158_0<=70)||(LA158_0>=90 && LA158_0<=91)||LA158_0==96||LA158_0==102||LA158_0==104||(LA158_0>=107 && LA158_0<=117)) ) {s = 8;}
                        else if ( (LA158_0==41) ) {s = 52;}
                        input.seek(index158_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA158_1 = input.LA(1);
                        int index158_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index158_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA158_2 = input.LA(1);
                        int index158_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index158_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA158_3 = input.LA(1);
                        int index158_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index158_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA158_4 = input.LA(1);
                        int index158_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index158_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA158_5 = input.LA(1);
                        int index158_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index158_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 158, _s, input);
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
        "\1\167\1\0\142\uffff";
    static final String DFA160_acceptS =
        "\2\uffff\1\2\140\uffff\1\1";
    static final String DFA160_specialS =
        "\1\uffff\1\0\142\uffff}>";
    static final String[] DFA160_transitionS = {
            "\13\2\12\uffff\15\2\1\uffff\23\2\2\uffff\3\2\5\uffff\2\2\1\1"+
            "\36\2\1\uffff\22\2",
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
            return "8042:3: ( ( ( () '[' ) )=> (this_object= ruleXClosure ) )?";
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
                        if ( (synpred38_InternalXtend()) ) {s = 99;}
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
    static final String DFA163_eotS =
        "\144\uffff";
    static final String DFA163_eofS =
        "\1\2\143\uffff";
    static final String DFA163_minS =
        "\1\4\1\0\142\uffff";
    static final String DFA163_maxS =
        "\1\167\1\0\142\uffff";
    static final String DFA163_acceptS =
        "\2\uffff\1\2\140\uffff\1\1";
    static final String DFA163_specialS =
        "\1\uffff\1\0\142\uffff}>";
    static final String[] DFA163_transitionS = {
            "\13\2\12\uffff\3\2\1\1\11\2\1\uffff\23\2\2\uffff\3\2\5\uffff"+
            "\41\2\1\uffff\22\2",
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
    static final short[] DFA163_eot = DFA.unpackEncodedString(DFA163_eotS);
    static final short[] DFA163_eof = DFA.unpackEncodedString(DFA163_eofS);
    static final char[] DFA163_min = DFA.unpackEncodedStringToUnsignedChars(DFA163_minS);
    static final char[] DFA163_max = DFA.unpackEncodedStringToUnsignedChars(DFA163_maxS);
    static final short[] DFA163_accept = DFA.unpackEncodedString(DFA163_acceptS);
    static final short[] DFA163_special = DFA.unpackEncodedString(DFA163_specialS);
    static final short[][] DFA163_transition;
    static {
        int numStates = DFA163_transitionS.length;
        DFA163_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA163_transition[i] = DFA.unpackEncodedString(DFA163_transitionS[i]);
        }
    }
    class DFA163 extends DFA {
        public DFA163(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 163;
            this.eot = DFA163_eot;
            this.eof = DFA163_eof;
            this.min = DFA163_min;
            this.max = DFA163_max;
            this.accept = DFA163_accept;
            this.special = DFA163_special;
            this.transition = DFA163_transition;
        }
        public String getDescription() {
            return "8164:2: ( ( ( '<' )=>other= '<' ) ( (this_object= ruleJvmArgumentTypeReference ) ) (other= ',' ( (this_object= ruleJvmArgumentTypeReference ) ) )* other= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA163_1 = input.LA(1);
                        int index163_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 2;}
                        input.seek(index163_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 163, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA166_eotS =
        "\144\uffff";
    static final String DFA166_eofS =
        "\1\2\143\uffff";
    static final String DFA166_minS =
        "\1\4\1\0\142\uffff";
    static final String DFA166_maxS =
        "\1\167\1\0\142\uffff";
    static final String DFA166_acceptS =
        "\2\uffff\1\2\140\uffff\1\1";
    static final String DFA166_specialS =
        "\1\uffff\1\0\142\uffff}>";
    static final String[] DFA166_transitionS = {
            "\13\2\12\uffff\15\2\1\uffff\1\2\1\1\21\2\2\uffff\3\2\5\uffff"+
            "\41\2\1\uffff\22\2",
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
    static final short[] DFA166_eot = DFA.unpackEncodedString(DFA166_eotS);
    static final short[] DFA166_eof = DFA.unpackEncodedString(DFA166_eofS);
    static final char[] DFA166_min = DFA.unpackEncodedStringToUnsignedChars(DFA166_minS);
    static final char[] DFA166_max = DFA.unpackEncodedStringToUnsignedChars(DFA166_maxS);
    static final short[] DFA166_accept = DFA.unpackEncodedString(DFA166_acceptS);
    static final short[] DFA166_special = DFA.unpackEncodedString(DFA166_specialS);
    static final short[][] DFA166_transition;
    static {
        int numStates = DFA166_transitionS.length;
        DFA166_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA166_transition[i] = DFA.unpackEncodedString(DFA166_transitionS[i]);
        }
    }
    class DFA166 extends DFA {
        public DFA166(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 166;
            this.eot = DFA166_eot;
            this.eof = DFA166_eof;
            this.min = DFA166_min;
            this.max = DFA166_max;
            this.accept = DFA166_accept;
            this.special = DFA166_special;
            this.transition = DFA166_transition;
        }
        public String getDescription() {
            return "8213:3: ( ( ( '(' )=>other= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (this_object= ruleXShortClosure ) ) | ( ( (this_object= ruleXExpression ) ) (other= ',' ( (this_object= ruleXExpression ) ) )* ) )? other= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA166_1 = input.LA(1);
                        int index166_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred40_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 2;}
                        input.seek(index166_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 166, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA165_eotS =
        "\65\uffff";
    static final String DFA165_eofS =
        "\65\uffff";
    static final String DFA165_minS =
        "\1\4\5\0\57\uffff";
    static final String DFA165_maxS =
        "\1\165\5\0\57\uffff";
    static final String DFA165_acceptS =
        "\6\uffff\2\1\1\2\53\uffff\1\3";
    static final String DFA165_specialS =
        "\1\0\1\1\1\2\1\3\1\4\1\5\57\uffff}>";
    static final String[] DFA165_transitionS = {
            "\1\2\3\10\4\uffff\3\10\12\uffff\1\10\1\uffff\2\10\2\uffff\3"+
            "\10\1\uffff\2\10\1\4\1\uffff\1\1\1\5\1\64\11\10\2\uffff\2\10"+
            "\1\3\1\uffff\1\10\13\uffff\2\10\17\uffff\1\6\3\uffff\2\10\4"+
            "\uffff\1\10\4\uffff\1\7\1\10\1\uffff\1\10\2\uffff\13\10",
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
            return "8218:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (this_object= ruleXShortClosure ) ) | ( ( (this_object= ruleXExpression ) ) (other= ',' ( (this_object= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA165_0 = input.LA(1);
                        int index165_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA165_0==39) ) {s = 1;}
                        else if ( (LA165_0==RULE_ID) ) {s = 2;}
                        else if ( (LA165_0==55) ) {s = 3;}
                        else if ( (LA165_0==37) ) {s = 4;}
                        else if ( (LA165_0==40) ) {s = 5;}
                        else if ( (LA165_0==86) && (synpred41_InternalXtend())) {s = 6;}
                        else if ( (LA165_0==101) && (synpred41_InternalXtend())) {s = 7;}
                        else if ( ((LA165_0>=RULE_STRING && LA165_0<=RULE_RICH_TEXT_START)||(LA165_0>=RULE_HEX && LA165_0<=RULE_DECIMAL)||LA165_0==25||(LA165_0>=27 && LA165_0<=28)||(LA165_0>=31 && LA165_0<=33)||(LA165_0>=35 && LA165_0<=36)||(LA165_0>=42 && LA165_0<=50)||(LA165_0>=53 && LA165_0<=54)||LA165_0==57||(LA165_0>=69 && LA165_0<=70)||(LA165_0>=90 && LA165_0<=91)||LA165_0==96||LA165_0==102||LA165_0==104||(LA165_0>=107 && LA165_0<=117)) ) {s = 8;}
                        else if ( (LA165_0==41) ) {s = 52;}
                        input.seek(index165_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA165_1 = input.LA(1);
                        int index165_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index165_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA165_2 = input.LA(1);
                        int index165_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index165_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA165_3 = input.LA(1);
                        int index165_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index165_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA165_4 = input.LA(1);
                        int index165_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index165_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA165_5 = input.LA(1);
                        int index165_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index165_5);
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
    static final String DFA167_eotS =
        "\144\uffff";
    static final String DFA167_eofS =
        "\1\2\143\uffff";
    static final String DFA167_minS =
        "\1\4\1\0\142\uffff";
    static final String DFA167_maxS =
        "\1\167\1\0\142\uffff";
    static final String DFA167_acceptS =
        "\2\uffff\1\2\140\uffff\1\1";
    static final String DFA167_specialS =
        "\1\uffff\1\0\142\uffff}>";
    static final String[] DFA167_transitionS = {
            "\13\2\12\uffff\15\2\1\uffff\23\2\2\uffff\3\2\5\uffff\2\2\1\1"+
            "\36\2\1\uffff\22\2",
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
            return "8297:3: ( ( ( () '[' ) )=> (this_object= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA167_1 = input.LA(1);
                        int index167_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 2;}
                        input.seek(index167_1);
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
    static final String DFA170_eotS =
        "\144\uffff";
    static final String DFA170_eofS =
        "\1\62\143\uffff";
    static final String DFA170_minS =
        "\1\4\61\0\62\uffff";
    static final String DFA170_maxS =
        "\1\167\61\0\62\uffff";
    static final String DFA170_acceptS =
        "\62\uffff\1\2\60\uffff\1\1";
    static final String DFA170_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31"+
        "\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46"+
        "\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\62\uffff}>";
    static final String[] DFA170_transitionS = {
            "\1\1\1\46\1\47\1\50\4\62\1\42\1\43\1\44\12\uffff\1\20\1\62\1"+
            "\4\1\34\2\62\1\11\1\14\1\32\1\62\1\16\1\10\1\3\1\uffff\1\12"+
            "\1\61\1\62\1\25\1\31\1\21\1\22\1\23\1\2\1\24\1\7\1\13\2\62\1"+
            "\6\1\17\1\5\1\62\1\15\2\uffff\3\62\5\uffff\1\62\1\36\1\37\23"+
            "\62\1\30\1\27\4\62\1\26\4\62\1\uffff\1\52\1\62\1\33\2\62\1\53"+
            "\1\54\1\55\1\35\1\40\1\41\1\45\1\51\1\56\1\57\1\60\2\62",
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
    static final short[] DFA170_eot = DFA.unpackEncodedString(DFA170_eotS);
    static final short[] DFA170_eof = DFA.unpackEncodedString(DFA170_eofS);
    static final char[] DFA170_min = DFA.unpackEncodedStringToUnsignedChars(DFA170_minS);
    static final char[] DFA170_max = DFA.unpackEncodedStringToUnsignedChars(DFA170_maxS);
    static final short[] DFA170_accept = DFA.unpackEncodedString(DFA170_acceptS);
    static final short[] DFA170_special = DFA.unpackEncodedString(DFA170_specialS);
    static final short[][] DFA170_transition;
    static {
        int numStates = DFA170_transitionS.length;
        DFA170_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA170_transition[i] = DFA.unpackEncodedString(DFA170_transitionS[i]);
        }
    }
    class DFA170 extends DFA {
        public DFA170(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 170;
            this.eot = DFA170_eot;
            this.eof = DFA170_eof;
            this.min = DFA170_min;
            this.max = DFA170_max;
            this.accept = DFA170_accept;
            this.special = DFA170_special;
            this.transition = DFA170_transition;
        }
        public String getDescription() {
            return "8646:1: ( ( ( ruleXExpression ) )=> (this_object= ruleXExpression ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA170_1 = input.LA(1);
                        int index170_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA170_2 = input.LA(1);
                        int index170_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA170_3 = input.LA(1);
                        int index170_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA170_4 = input.LA(1);
                        int index170_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA170_5 = input.LA(1);
                        int index170_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA170_6 = input.LA(1);
                        int index170_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA170_7 = input.LA(1);
                        int index170_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA170_8 = input.LA(1);
                        int index170_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA170_9 = input.LA(1);
                        int index170_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA170_10 = input.LA(1);
                        int index170_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA170_11 = input.LA(1);
                        int index170_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA170_12 = input.LA(1);
                        int index170_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA170_13 = input.LA(1);
                        int index170_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA170_14 = input.LA(1);
                        int index170_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA170_15 = input.LA(1);
                        int index170_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA170_16 = input.LA(1);
                        int index170_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA170_17 = input.LA(1);
                        int index170_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA170_18 = input.LA(1);
                        int index170_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA170_19 = input.LA(1);
                        int index170_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA170_20 = input.LA(1);
                        int index170_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA170_21 = input.LA(1);
                        int index170_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA170_22 = input.LA(1);
                        int index170_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA170_23 = input.LA(1);
                        int index170_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA170_24 = input.LA(1);
                        int index170_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA170_25 = input.LA(1);
                        int index170_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA170_26 = input.LA(1);
                        int index170_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_26);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA170_27 = input.LA(1);
                        int index170_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_27);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA170_28 = input.LA(1);
                        int index170_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_28);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA170_29 = input.LA(1);
                        int index170_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_29);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA170_30 = input.LA(1);
                        int index170_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_30);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA170_31 = input.LA(1);
                        int index170_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_31);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA170_32 = input.LA(1);
                        int index170_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_32);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA170_33 = input.LA(1);
                        int index170_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_33);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA170_34 = input.LA(1);
                        int index170_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_34);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA170_35 = input.LA(1);
                        int index170_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_35);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA170_36 = input.LA(1);
                        int index170_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_36);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA170_37 = input.LA(1);
                        int index170_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_37);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA170_38 = input.LA(1);
                        int index170_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_38);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA170_39 = input.LA(1);
                        int index170_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_39);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA170_40 = input.LA(1);
                        int index170_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_40);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA170_41 = input.LA(1);
                        int index170_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_41);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA170_42 = input.LA(1);
                        int index170_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_42);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA170_43 = input.LA(1);
                        int index170_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_43);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA170_44 = input.LA(1);
                        int index170_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_44);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA170_45 = input.LA(1);
                        int index170_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_45);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA170_46 = input.LA(1);
                        int index170_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_46);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA170_47 = input.LA(1);
                        int index170_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_47);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA170_48 = input.LA(1);
                        int index170_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_48);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA170_49 = input.LA(1);
                        int index170_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index170_49);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 170, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA185_eotS =
        "\147\uffff";
    static final String DFA185_eofS =
        "\1\2\146\uffff";
    static final String DFA185_minS =
        "\1\4\1\0\145\uffff";
    static final String DFA185_maxS =
        "\1\171\1\0\145\uffff";
    static final String DFA185_acceptS =
        "\2\uffff\1\2\143\uffff\1\1";
    static final String DFA185_specialS =
        "\1\uffff\1\0\145\uffff}>";
    static final String[] DFA185_transitionS = {
            "\13\2\12\uffff\3\2\1\1\36\2\1\uffff\3\2\5\uffff\41\2\1\uffff"+
            "\22\2\1\uffff\1\2",
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
    static final short[] DFA185_eot = DFA.unpackEncodedString(DFA185_eotS);
    static final short[] DFA185_eof = DFA.unpackEncodedString(DFA185_eofS);
    static final char[] DFA185_min = DFA.unpackEncodedStringToUnsignedChars(DFA185_minS);
    static final char[] DFA185_max = DFA.unpackEncodedStringToUnsignedChars(DFA185_maxS);
    static final short[] DFA185_accept = DFA.unpackEncodedString(DFA185_acceptS);
    static final short[] DFA185_special = DFA.unpackEncodedString(DFA185_specialS);
    static final short[][] DFA185_transition;
    static {
        int numStates = DFA185_transitionS.length;
        DFA185_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA185_transition[i] = DFA.unpackEncodedString(DFA185_transitionS[i]);
        }
    }
    class DFA185 extends DFA {
        public DFA185(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 185;
            this.eot = DFA185_eot;
            this.eof = DFA185_eof;
            this.min = DFA185_min;
            this.max = DFA185_max;
            this.accept = DFA185_accept;
            this.special = DFA185_special;
            this.transition = DFA185_transition;
        }
        public String getDescription() {
            return "9259:2: ( ( ( '<' )=>other= '<' ) ( (this_object= ruleJvmArgumentTypeReference ) ) (other= ',' ( (this_object= ruleJvmArgumentTypeReference ) ) )* other= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA185_1 = input.LA(1);
                        int index185_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_InternalXtend()) ) {s = 102;}
                        else if ( (true) ) {s = 2;}
                        input.seek(index185_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 185, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA192_eotS =
        "\13\uffff";
    static final String DFA192_eofS =
        "\2\uffff\3\6\3\uffff\3\6";
    static final String DFA192_minS =
        "\1\4\1\uffff\3\31\1\4\2\uffff\3\31";
    static final String DFA192_maxS =
        "\1\67\1\uffff\3\142\1\134\2\uffff\3\142";
    static final String DFA192_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\1\3\3\uffff";
    static final String DFA192_specialS =
        "\13\uffff}>";
    static final String[] DFA192_transitionS = {
            "\1\2\40\uffff\1\4\12\uffff\1\1\6\uffff\1\3",
            "",
            "\3\6\7\uffff\3\6\6\uffff\7\6\6\uffff\1\6\12\uffff\1\6\35\uffff"+
            "\1\5",
            "\3\6\7\uffff\3\6\6\uffff\7\6\6\uffff\1\6\12\uffff\1\6\35\uffff"+
            "\1\5",
            "\3\6\7\uffff\3\6\6\uffff\7\6\6\uffff\1\6\12\uffff\1\6\35\uffff"+
            "\1\5",
            "\1\10\40\uffff\1\12\21\uffff\1\11\44\uffff\1\7",
            "",
            "",
            "\3\6\7\uffff\3\6\6\uffff\7\6\6\uffff\1\6\12\uffff\1\6\35\uffff"+
            "\1\5",
            "\3\6\7\uffff\3\6\6\uffff\7\6\6\uffff\1\6\12\uffff\1\6\35\uffff"+
            "\1\5",
            "\3\6\7\uffff\3\6\6\uffff\7\6\6\uffff\1\6\12\uffff\1\6\35\uffff"+
            "\1\5"
    };
    static final short[] DFA192_eot = DFA.unpackEncodedString(DFA192_eotS);
    static final short[] DFA192_eof = DFA.unpackEncodedString(DFA192_eofS);
    static final char[] DFA192_min = DFA.unpackEncodedStringToUnsignedChars(DFA192_minS);
    static final char[] DFA192_max = DFA.unpackEncodedStringToUnsignedChars(DFA192_maxS);
    static final short[] DFA192_accept = DFA.unpackEncodedString(DFA192_acceptS);
    static final short[] DFA192_special = DFA.unpackEncodedString(DFA192_specialS);
    static final short[][] DFA192_transition;
    static {
        int numStates = DFA192_transitionS.length;
        DFA192_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA192_transition[i] = DFA.unpackEncodedString(DFA192_transitionS[i]);
        }
    }
    class DFA192 extends DFA {
        public DFA192(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 192;
            this.eot = DFA192_eot;
            this.eof = DFA192_eof;
            this.min = DFA192_min;
            this.max = DFA192_max;
            this.accept = DFA192_accept;
            this.special = DFA192_special;
            this.transition = DFA192_transition;
        }
        public String getDescription() {
            return "9801:1: ( ( ( (other= 'static' ) ) ( (other= 'extension' ) )? ( ( ruleQualifiedName ) ) other= '.' other= '*' ) | ( ( ruleQualifiedName ) ) | ( (this_dataType= ruleQualifiedNameWithWildcard ) ) )";
        }
    }
    public static final BitSet FOLLOW_ruleFile_in_entryRuleFile81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFile91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleFile129 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFile150 = new BitSet(new long[]{0x0207F0380E000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_26_in_ruleFile163 = new BitSet(new long[]{0x0207F0380A000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleXImportSection_in_ruleFile188 = new BitSet(new long[]{0x0007F0380A000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleType_in_ruleFile210 = new BitSet(new long[]{0x0007F0380A000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType253 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotation_in_ruleType318 = new BitSet(new long[]{0x0007F0380A000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleType351 = new BitSet(new long[]{0x0007F0000A000000L});
    public static final BitSet FOLLOW_27_in_ruleType364 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleType385 = new BitSet(new long[]{0x0000000390000000L});
    public static final BitSet FOLLOW_28_in_ruleType398 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleType419 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleType432 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleType453 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_30_in_ruleType467 = new BitSet(new long[]{0x0000000380000000L});
    public static final BitSet FOLLOW_31_in_ruleType482 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleType503 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_32_in_ruleType518 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleType539 = new BitSet(new long[]{0x0000000220000000L});
    public static final BitSet FOLLOW_29_in_ruleType552 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleType573 = new BitSet(new long[]{0x0000000220000000L});
    public static final BitSet FOLLOW_33_in_ruleType589 = new BitSet(new long[]{0x00FFF9A402000010L,0x0000000000400010L});
    public static final BitSet FOLLOW_ruleMember_in_ruleType610 = new BitSet(new long[]{0x00FFF9A402000010L,0x0000000000400010L});
    public static final BitSet FOLLOW_34_in_ruleType623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleType661 = new BitSet(new long[]{0x0007F00802000000L});
    public static final BitSet FOLLOW_35_in_ruleType674 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleType695 = new BitSet(new long[]{0x0000000290000000L});
    public static final BitSet FOLLOW_28_in_ruleType708 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleType729 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleType742 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleType763 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_30_in_ruleType777 = new BitSet(new long[]{0x0000000280000000L});
    public static final BitSet FOLLOW_31_in_ruleType792 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleType813 = new BitSet(new long[]{0x0000000220000000L});
    public static final BitSet FOLLOW_29_in_ruleType826 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleType847 = new BitSet(new long[]{0x0000000220000000L});
    public static final BitSet FOLLOW_33_in_ruleType863 = new BitSet(new long[]{0x00FFF9A402000010L,0x0000000000400010L});
    public static final BitSet FOLLOW_ruleMember_in_ruleType884 = new BitSet(new long[]{0x00FFF9A402000010L,0x0000000000400010L});
    public static final BitSet FOLLOW_34_in_ruleType897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleType935 = new BitSet(new long[]{0x0007F01002000000L});
    public static final BitSet FOLLOW_36_in_ruleType948 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleType969 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleType981 = new BitSet(new long[]{0x0080002404000010L});
    public static final BitSet FOLLOW_ruleXtendEnumLiteral_in_ruleType1003 = new BitSet(new long[]{0x0000000424000000L});
    public static final BitSet FOLLOW_29_in_ruleType1016 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleXtendEnumLiteral_in_ruleType1037 = new BitSet(new long[]{0x0000000424000000L});
    public static final BitSet FOLLOW_26_in_ruleType1054 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleType1068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleType1106 = new BitSet(new long[]{0x0007F02002000000L});
    public static final BitSet FOLLOW_37_in_ruleType1119 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleType1140 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleType1152 = new BitSet(new long[]{0x009FF1A402000010L,0x0000000000400010L});
    public static final BitSet FOLLOW_ruleAnnotationField_in_ruleType1173 = new BitSet(new long[]{0x009FF1A402000010L,0x0000000000400010L});
    public static final BitSet FOLLOW_34_in_ruleType1186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotationField_in_entryRuleAnnotationField1230 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotationField1240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotation_in_ruleAnnotationField1286 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400010L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleAnnotationField1308 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleFieldModifier_in_ruleAnnotationField1332 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleAnnotationField1353 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleAnnotationField1375 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleAnnotationField1397 = new BitSet(new long[]{0x0000004004000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleAnnotationField1426 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleAnnotationField1447 = new BitSet(new long[]{0x0000004004000002L});
    public static final BitSet FOLLOW_38_in_ruleAnnotationField1462 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValue_in_ruleAnnotationField1483 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleAnnotationField1498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMember_in_entryRuleMember1542 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMember1552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotation_in_ruleMember1607 = new BitSet(new long[]{0x00FFF9A002000010L,0x0000000000400010L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleMember1640 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleFieldModifier_in_ruleMember1664 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleMember1685 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleMember1707 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleMember1729 = new BitSet(new long[]{0x0000004004000002L});
    public static final BitSet FOLLOW_39_in_ruleMember1755 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleFieldModifier_in_ruleMember1790 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleMember1817 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleMember1840 = new BitSet(new long[]{0x0080006004000012L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleMember1861 = new BitSet(new long[]{0x0000004004000002L});
    public static final BitSet FOLLOW_ruleFieldModifier_in_ruleMember1891 = new BitSet(new long[]{0x0007F08002000000L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleMember1912 = new BitSet(new long[]{0x0007F08002000000L});
    public static final BitSet FOLLOW_39_in_ruleMember1931 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleMember1965 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleMember1987 = new BitSet(new long[]{0x0080006004000012L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleMember2008 = new BitSet(new long[]{0x0000004004000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleMember2038 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleMember2059 = new BitSet(new long[]{0x0000004004000002L});
    public static final BitSet FOLLOW_38_in_ruleMember2074 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleMember2095 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleMember2110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleMember2150 = new BitSet(new long[]{0x0067F00002000000L});
    public static final BitSet FOLLOW_ruleMethodModifier_in_ruleMember2172 = new BitSet(new long[]{0x00FFF1A012000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleMember2194 = new BitSet(new long[]{0x00FFF1A012000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleMethodModifier_in_ruleMember2221 = new BitSet(new long[]{0x00FFF1A012000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_28_in_ruleMember2236 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleMember2257 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleMember2270 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleMember2291 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_30_in_ruleMember2305 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleMember2367 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleCreateExtensionInfo_in_ruleMember2388 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleMember2409 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleMember2421 = new BitSet(new long[]{0x009FF3A002000010L,0x0000000000400010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleMember2479 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleMember2500 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleMember2512 = new BitSet(new long[]{0x009FF3A002000010L,0x0000000000400010L});
    public static final BitSet FOLLOW_ruleCreateExtensionInfo_in_ruleMember2570 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleMember2591 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleMember2603 = new BitSet(new long[]{0x009FF3A002000010L,0x0000000000400010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleMember2633 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleMember2645 = new BitSet(new long[]{0x009FF3A002000010L,0x0000000000400010L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleMember2669 = new BitSet(new long[]{0x0000020020000000L});
    public static final BitSet FOLLOW_29_in_ruleMember2682 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400010L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleMember2703 = new BitSet(new long[]{0x0000020020000000L});
    public static final BitSet FOLLOW_41_in_ruleMember2719 = new BitSet(new long[]{0x00000402040000E2L});
    public static final BitSet FOLLOW_42_in_ruleMember2732 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleMember2753 = new BitSet(new long[]{0x00000002240000E2L});
    public static final BitSet FOLLOW_29_in_ruleMember2766 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleMember2787 = new BitSet(new long[]{0x00000002240000E2L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleMember2813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichString_in_ruleMember2840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleMember2858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_ruleMember2898 = new BitSet(new long[]{0x0007F80002000000L});
    public static final BitSet FOLLOW_43_in_ruleMember2911 = new BitSet(new long[]{0x0000010010000000L});
    public static final BitSet FOLLOW_28_in_ruleMember2924 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleMember2945 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleMember2958 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_ruleMember2979 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_30_in_ruleMember2993 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleMember3007 = new BitSet(new long[]{0x009FF3A002000010L,0x0000000000400010L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleMember3029 = new BitSet(new long[]{0x0000020020000000L});
    public static final BitSet FOLLOW_29_in_ruleMember3042 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400010L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleMember3063 = new BitSet(new long[]{0x0000020020000000L});
    public static final BitSet FOLLOW_41_in_ruleMember3079 = new BitSet(new long[]{0x0000040200000000L});
    public static final BitSet FOLLOW_42_in_ruleMember3092 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleMember3113 = new BitSet(new long[]{0x0000000220000000L});
    public static final BitSet FOLLOW_29_in_ruleMember3126 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleMember3147 = new BitSet(new long[]{0x0000000220000000L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleMember3172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXtendEnumLiteral_in_entryRuleXtendEnumLiteral3216 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXtendEnumLiteral3226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXtendEnumLiteral3271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommonModifier_in_entryRuleCommonModifier3313 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommonModifier3324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleCommonModifier3362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleCommonModifier3381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleCommonModifier3400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleCommonModifier3419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleCommonModifier3438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleCommonModifier3457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleCommonModifier3476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleCommonModifier3495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFieldModifier_in_entryRuleFieldModifier3542 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFieldModifier3553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleFieldModifier3591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleFieldModifier3610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodModifier_in_entryRuleMethodModifier3657 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodModifier3668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleMethodModifier3706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleMethodModifier3725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreateExtensionInfo_in_entryRuleCreateExtensionInfo3771 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCreateExtensionInfo3781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleCreateExtensionInfo3818 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleCreateExtensionInfo3840 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleCreateExtensionInfo3852 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleCreateExtensionInfo3875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID3918 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID3929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID3969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleValidID3993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleValidID4012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCallID_in_entryRuleFeatureCallID4059 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCallID4070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureCallID4110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleFeatureCallID4134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleFeatureCallID4153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleFeatureCallID4172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleFeatureCallID4191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleFeatureCallID4210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleFeatureCallID4229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleFeatureCallID4248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleFeatureCallID4267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleFeatureCallID4286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleFeatureCallID4305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleFeatureCallID4324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleFeatureCallID4343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleFeatureCallID4362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleFeatureCallID4381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleFeatureCallID4400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleFeatureCallID4419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleFeatureCallID4438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleFeatureCallID4457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleFeatureCallID4476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleFeatureCallID4495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter4541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter4551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotation_in_ruleParameter4597 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400010L});
    public static final BitSet FOLLOW_39_in_ruleParameter4617 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400010L});
    public static final BitSet FOLLOW_ruleXAnnotation_in_ruleParameter4651 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleParameter4675 = new BitSet(new long[]{0x0480002000000010L});
    public static final BitSet FOLLOW_58_in_ruleParameter4693 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleParameter4728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_entryRuleXVariableDeclaration4770 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXVariableDeclaration4780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleXVariableDeclaration4938 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_51_in_ruleXVariableDeclaration4969 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_39_in_ruleXVariableDeclaration4988 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_39_in_ruleXVariableDeclaration5028 = new BitSet(new long[]{0x0018000000000000L});
    public static final BitSet FOLLOW_52_in_ruleXVariableDeclaration5060 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_51_in_ruleXVariableDeclaration5091 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXVariableDeclaration5143 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration5164 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXVariableDeclaration5193 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleXVariableDeclaration5207 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXVariableDeclaration5228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_entryRuleJvmFormalParameter5272 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmFormalParameter5282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleJvmFormalParameter5325 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmFormalParameter5360 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmFormalParameter5382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFullJvmFormalParameter_in_entryRuleFullJvmFormalParameter5424 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFullJvmFormalParameter5434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleFullJvmFormalParameter5477 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleFullJvmFormalParameter5512 = new BitSet(new long[]{0x0080002000000010L});
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
    public static final BitSet FOLLOW_ruleRichStringLiteralStart_in_ruleRichString5902 = new BitSet(new long[]{0x0AFFFDBB9A007FF0L,0x003FF9410C000071L});
    public static final BitSet FOLLOW_ruleRichStringPart_in_ruleRichString5923 = new BitSet(new long[]{0x0AFFFDBB9A007FF0L,0x003FF9410C000071L});
    public static final BitSet FOLLOW_ruleRichStringLiteralInbetween_in_ruleRichString5946 = new BitSet(new long[]{0x0AFFFDBB9A007FF0L,0x003FF9410C000071L});
    public static final BitSet FOLLOW_ruleRichStringPart_in_ruleRichString5967 = new BitSet(new long[]{0x0AFFFDBB9A007FF0L,0x003FF9410C000071L});
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
    public static final BitSet FOLLOW_ruleRichStringLiteralInbetween_in_ruleInternalRichString6593 = new BitSet(new long[]{0x0AFFFDBB9A0073F2L,0x003FF9410C000071L});
    public static final BitSet FOLLOW_ruleRichStringPart_in_ruleInternalRichString6615 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_ruleRichStringLiteralInbetween_in_ruleInternalRichString6637 = new BitSet(new long[]{0x0AFFFDBB9A0073F2L,0x003FF9410C000071L});
    public static final BitSet FOLLOW_ruleRichStringPart_in_entryRuleRichStringPart6682 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringPart6692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleRichStringPart6739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringForLoop_in_ruleRichStringPart6766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringIf_in_ruleRichStringPart6793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringForLoop_in_entryRuleRichStringForLoop6834 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringForLoop6844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleRichStringForLoop6890 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleRichStringForLoop6911 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleRichStringForLoop6923 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleRichStringForLoop6944 = new BitSet(new long[]{0x7000000000000300L});
    public static final BitSet FOLLOW_60_in_ruleRichStringForLoop6957 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleRichStringForLoop6978 = new BitSet(new long[]{0x7000000000000300L});
    public static final BitSet FOLLOW_61_in_ruleRichStringForLoop6993 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleRichStringForLoop7014 = new BitSet(new long[]{0x7000000000000300L});
    public static final BitSet FOLLOW_62_in_ruleRichStringForLoop7029 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleRichStringForLoop7050 = new BitSet(new long[]{0x7000000000000300L});
    public static final BitSet FOLLOW_ruleInternalRichString_in_ruleRichStringForLoop7073 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_ruleRichStringForLoop7085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringIf_in_entryRuleRichStringIf7127 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringIf7137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleRichStringIf7183 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleRichStringIf7204 = new BitSet(new long[]{0x7000000000000300L});
    public static final BitSet FOLLOW_ruleInternalRichString_in_ruleRichStringIf7225 = new BitSet(new long[]{0x0000000000000000L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleRichStringElseIf_in_ruleRichStringIf7246 = new BitSet(new long[]{0x0000000000000000L,0x000000000000000EL});
    public static final BitSet FOLLOW_65_in_ruleRichStringIf7260 = new BitSet(new long[]{0x7000000000000300L});
    public static final BitSet FOLLOW_ruleInternalRichString_in_ruleRichStringIf7281 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_ruleRichStringIf7295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRichStringElseIf_in_entryRuleRichStringElseIf7337 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRichStringElseIf7347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleRichStringElseIf7384 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleRichStringElseIf7405 = new BitSet(new long[]{0x7000000000000300L});
    public static final BitSet FOLLOW_ruleInternalRichString_in_ruleRichStringElseIf7426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotation_in_entryRuleXAnnotation7468 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAnnotation7478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleXAnnotation7524 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXAnnotation7547 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleXAnnotation7568 = new BitSet(new long[]{0x02E7FFBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValuePair_in_ruleXAnnotation7612 = new BitSet(new long[]{0x0000020020000000L});
    public static final BitSet FOLLOW_29_in_ruleXAnnotation7625 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValuePair_in_ruleXAnnotation7666 = new BitSet(new long[]{0x0000020020000000L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotation7696 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXAnnotation7710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValuePair_in_entryRuleXAnnotationElementValuePair7754 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAnnotationElementValuePair7764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXAnnotationElementValuePair7834 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleXAnnotationElementValuePair7846 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValue_in_ruleXAnnotationElementValuePair7869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotationElementValue_in_entryRuleXAnnotationElementValue7911 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAnnotationElementValue7921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotation_in_ruleXAnnotationElementValue7968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleXAnnotationElementValue8019 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleXAnnotationElementValue8031 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleXAnnotation_in_ruleXAnnotationElementValue8052 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_29_in_ruleXAnnotationElementValue8067 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleXAnnotation_in_ruleXAnnotationElementValue8088 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleXAnnotationElementValue8102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXAnnotationElementValue8131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_entryRuleXExpression8172 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpression8182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXExpression8228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_entryRuleXAssignment8268 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAssignment8278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCallID_in_ruleXAssignment8336 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXAssignment8352 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment8372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment8402 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_ruleXAssignment8455 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment8478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign8524 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpSingleAssign8535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOpSingleAssign8572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign8618 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMultiAssign8629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleOpMultiAssign8667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleOpMultiAssign8686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression8732 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOrExpression8742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression8789 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleXOrExpression8842 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression8865 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr8910 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr8921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleOpOr8958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression9003 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAndExpression9013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression9060 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleXAndExpression9113 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression9136 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd9181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd9192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleOpAnd9229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression9274 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXEqualityExpression9284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression9331 = new BitSet(new long[]{0x0000000000000002L,0x000000000000F000L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleXEqualityExpression9384 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression9407 = new BitSet(new long[]{0x0000000000000002L,0x000000000000F000L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality9452 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality9463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleOpEquality9501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleOpEquality9520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleOpEquality9539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleOpEquality9558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression9604 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRelationalExpression9614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression9661 = new BitSet(new long[]{0x0000000050000002L,0x0000000000070000L});
    public static final BitSet FOLLOW_80_in_ruleXRelationalExpression9697 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXRelationalExpression9720 = new BitSet(new long[]{0x0000000050000002L,0x0000000000070000L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleXRelationalExpression9781 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression9804 = new BitSet(new long[]{0x0000000050000002L,0x0000000000070000L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare9850 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare9861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleOpCompare9899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleOpCompare9918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpCompare9937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOpCompare9956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression10002 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOtherOperatorExpression10012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression10059 = new BitSet(new long[]{0x0000000050000002L,0x0000000003F80000L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression10112 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression10135 = new BitSet(new long[]{0x0000000050000002L,0x0000000003F80000L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther10180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther10191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleOpOther10229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleOpOther10248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpOther10268 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_ruleOpOther10281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_ruleOpOther10301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_ruleOpOther10320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpOther10340 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleOpOther10371 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleOpOther10384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpOther10405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOpOther10427 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleOpOther10458 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleOpOther10471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOpOther10492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_ruleOpOther10513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_ruleOpOther10532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_ruleOpOther10551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression10597 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAdditiveExpression10607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression10654 = new BitSet(new long[]{0x0000000000000002L,0x000000000C000000L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression10707 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression10730 = new BitSet(new long[]{0x0000000000000002L,0x000000000C000000L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd10775 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd10786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_ruleOpAdd10824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_ruleOpAdd10843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression10889 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMultiplicativeExpression10899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression10946 = new BitSet(new long[]{0x0000000000000002L,0x00000000F0000000L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression10999 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression11022 = new BitSet(new long[]{0x0000000000000002L,0x00000000F0000000L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti11067 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti11078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_ruleOpMulti11116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_ruleOpMulti11135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_ruleOpMulti11154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_ruleOpMulti11173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation11219 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXUnaryOperation11229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleXUnaryOperation11287 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXUnaryOperation11308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation11337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary11379 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary11390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_ruleOpUnary11428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_ruleOpUnary11447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_ruleOpUnary11466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression11512 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCastedExpression11522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression11569 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_ruleXCastedExpression11604 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression11627 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall11671 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMemberFeatureCall11681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall11728 = new BitSet(new long[]{0x0000000000000002L,0x0000001C00000000L});
    public static final BitSet FOLLOW_98_in_ruleXMemberFeatureCall11800 = new BitSet(new long[]{0x02E7F4B98A000010L});
    public static final BitSet FOLLOW_99_in_ruleXMemberFeatureCall11824 = new BitSet(new long[]{0x02E7F4B98A000010L});
    public static final BitSet FOLLOW_ruleFeatureCallID_in_ruleXMemberFeatureCall11861 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall11877 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall11899 = new BitSet(new long[]{0x0000000000000002L,0x0000001C00000000L});
    public static final BitSet FOLLOW_98_in_ruleXMemberFeatureCall11985 = new BitSet(new long[]{0x02E7F4B99A000010L});
    public static final BitSet FOLLOW_100_in_ruleXMemberFeatureCall12009 = new BitSet(new long[]{0x02E7F4B99A000010L});
    public static final BitSet FOLLOW_99_in_ruleXMemberFeatureCall12046 = new BitSet(new long[]{0x02E7F4B99A000010L});
    public static final BitSet FOLLOW_28_in_ruleXMemberFeatureCall12075 = new BitSet(new long[]{0x009FF1A002000010L,0x0100000000400000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall12096 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleXMemberFeatureCall12109 = new BitSet(new long[]{0x009FF1A002000010L,0x0100000000400000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall12130 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_30_in_ruleXMemberFeatureCall12144 = new BitSet(new long[]{0x02E7F4B98A000010L});
    public static final BitSet FOLLOW_ruleFeatureCallID_in_ruleXMemberFeatureCall12169 = new BitSet(new long[]{0x0000010000000002L,0x0000001C00000040L});
    public static final BitSet FOLLOW_40_in_ruleXMemberFeatureCall12203 = new BitSet(new long[]{0x02FFFFBB9A0070F0L,0x003FF9610C400070L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall12288 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall12316 = new BitSet(new long[]{0x0000020020000000L});
    public static final BitSet FOLLOW_29_in_ruleXMemberFeatureCall12329 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall12350 = new BitSet(new long[]{0x0000020020000000L});
    public static final BitSet FOLLOW_41_in_ruleXMemberFeatureCall12367 = new BitSet(new long[]{0x0000000000000002L,0x0000001C00000040L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXMemberFeatureCall12402 = new BitSet(new long[]{0x0000000000000002L,0x0000001C00000000L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression12448 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXPrimaryExpression12458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression12505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression12532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression12559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression12586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression12613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression12640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression12667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression12694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression12721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression12748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression12775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression12802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression12829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_entryRuleXLiteral12870 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXLiteral12880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCollectionLiteral_in_ruleXLiteral12927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXLiteral12967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral12995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNumberLiteral_in_ruleXLiteral13022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_ruleXLiteral13049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXLiteral13076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXLiteral13103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCollectionLiteral_in_entryRuleXCollectionLiteral13144 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCollectionLiteral13154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSetLiteral_in_ruleXCollectionLiteral13201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXListLiteral_in_ruleXCollectionLiteral13228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSetLiteral_in_entryRuleXSetLiteral13269 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSetLiteral13279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleXSetLiteral13325 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleXSetLiteral13337 = new BitSet(new long[]{0x02E7FDBF9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSetLiteral13359 = new BitSet(new long[]{0x0000000420000000L});
    public static final BitSet FOLLOW_29_in_ruleXSetLiteral13372 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSetLiteral13393 = new BitSet(new long[]{0x0000000420000000L});
    public static final BitSet FOLLOW_34_in_ruleXSetLiteral13409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXListLiteral_in_entryRuleXListLiteral13451 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXListLiteral13461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleXListLiteral13507 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleXListLiteral13519 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C0000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXListLiteral13541 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_29_in_ruleXListLiteral13554 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXListLiteral13575 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleXListLiteral13591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_entryRuleXClosure13633 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXClosure13643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleXClosure13703 = new BitSet(new long[]{0x02FFFDBB9A0070F0L,0x003FF9610C4000F0L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure13776 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_29_in_ruleXClosure13789 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure13810 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_ruleXClosure13832 = new BitSet(new long[]{0x02FFFDBB9A0070F0L,0x003FF9410C0000F0L});
    public static final BitSet FOLLOW_ruleXExpressionInClosure_in_ruleXClosure13869 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleXClosure13881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInClosure_in_entryRuleXExpressionInClosure13923 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInClosure13933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXExpressionInClosure13989 = new BitSet(new long[]{0x02FFFDBB9E0070F2L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_26_in_ruleXExpressionInClosure14002 = new BitSet(new long[]{0x02FFFDBB9A0070F2L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure14048 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXShortClosure14058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure14166 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_29_in_ruleXShortClosure14179 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure14200 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_ruleXShortClosure14222 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXShortClosure14258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression14300 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXParenthesizedExpression14310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleXParenthesizedExpression14347 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression14369 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXParenthesizedExpression14380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression14422 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIfExpression14432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_ruleXIfExpression14478 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXIfExpression14490 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression14511 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXIfExpression14523 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression14544 = new BitSet(new long[]{0x0000000000000002L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_ruleXIfExpression14565 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression14587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression14631 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSwitchExpression14641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_ruleXSwitchExpression14687 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXSwitchExpression14730 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleXSwitchExpression14742 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression14766 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_40_in_ruleXSwitchExpression14810 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXSwitchExpression14831 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleXSwitchExpression14843 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression14866 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXSwitchExpression14878 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleXSwitchExpression14892 = new BitSet(new long[]{0x019FF1A002000010L,0x0000040000400000L});
    public static final BitSet FOLLOW_ruleXCasePart_in_ruleXSwitchExpression14913 = new BitSet(new long[]{0x019FF1A402000010L,0x0000060000400000L});
    public static final BitSet FOLLOW_105_in_ruleXSwitchExpression14927 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleXSwitchExpression14939 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression14960 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleXSwitchExpression14974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_entryRuleXCasePart15016 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCasePart15026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCasePart15072 = new BitSet(new long[]{0x0100000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_106_in_ruleXCasePart15086 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart15107 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleXCasePart15121 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart15142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression15184 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXForLoopExpression15194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_ruleXForLoopExpression15240 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXForLoopExpression15252 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression15273 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleXForLoopExpression15285 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression15306 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXForLoopExpression15318 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression15339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression15381 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWhileExpression15391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_ruleXWhileExpression15437 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXWhileExpression15449 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression15470 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXWhileExpression15482 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression15503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression15545 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXDoWhileExpression15555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_ruleXDoWhileExpression15601 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression15622 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_108_in_ruleXDoWhileExpression15634 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXDoWhileExpression15646 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression15667 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXDoWhileExpression15679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression15721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBlockExpression15731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleXBlockExpression15777 = new BitSet(new long[]{0x02FFFDBF9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression15799 = new BitSet(new long[]{0x02FFFDBF9E0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_26_in_ruleXBlockExpression15812 = new BitSet(new long[]{0x02FFFDBF9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_34_in_ruleXBlockExpression15828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock15870 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInsideBlock15880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock16029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock16057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall16098 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFeatureCall16108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleXFeatureCall16155 = new BitSet(new long[]{0x009FF1A002000010L,0x0100000000400000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall16176 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleXFeatureCall16189 = new BitSet(new long[]{0x009FF1A002000010L,0x0100000000400000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall16210 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_30_in_ruleXFeatureCall16224 = new BitSet(new long[]{0x02E7F4B99A000010L,0x0000400000000000L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall16249 = new BitSet(new long[]{0x0000010000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_40_in_ruleXFeatureCall16283 = new BitSet(new long[]{0x02FFFFBB9A0070F0L,0x003FF9610C400070L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXFeatureCall16368 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall16396 = new BitSet(new long[]{0x0000020020000000L});
    public static final BitSet FOLLOW_29_in_ruleXFeatureCall16409 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall16430 = new BitSet(new long[]{0x0000020020000000L});
    public static final BitSet FOLLOW_41_in_ruleXFeatureCall16447 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXFeatureCall16482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper16526 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdOrSuper16537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCallID_in_ruleIdOrSuper16584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_ruleIdOrSuper16608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall16654 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXConstructorCall16664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleXConstructorCall16710 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXConstructorCall16733 = new BitSet(new long[]{0x0000010010000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_28_in_ruleXConstructorCall16754 = new BitSet(new long[]{0x009FF1A002000010L,0x0100000000400000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall16776 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleXConstructorCall16789 = new BitSet(new long[]{0x009FF1A002000010L,0x0100000000400000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall16810 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_30_in_ruleXConstructorCall16824 = new BitSet(new long[]{0x0000010000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_40_in_ruleXConstructorCall16847 = new BitSet(new long[]{0x02FFFFBB9A0070F0L,0x003FF9610C400070L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXConstructorCall16920 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall16948 = new BitSet(new long[]{0x0000020020000000L});
    public static final BitSet FOLLOW_29_in_ruleXConstructorCall16961 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall16982 = new BitSet(new long[]{0x0000020020000000L});
    public static final BitSet FOLLOW_41_in_ruleXConstructorCall16999 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXConstructorCall17034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral17077 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBooleanLiteral17087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_ruleXBooleanLiteral17134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_ruleXBooleanLiteral17158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral17214 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNullLiteral17224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_ruleXNullLiteral17270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNumberLiteral_in_entryRuleXNumberLiteral17312 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNumberLiteral17322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_ruleXNumberLiteral17377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral17419 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTypeLiteral17429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_ruleXTypeLiteral17475 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXTypeLiteral17487 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral17510 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_ruleXTypeLiteral17531 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_41_in_ruleXTypeLiteral17544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression17586 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXThrowExpression17596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_ruleXThrowExpression17642 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXThrowExpression17663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression17705 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXReturnExpression17715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_ruleXReturnExpression17761 = new BitSet(new long[]{0x02E7FDBB9A0070F2L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXReturnExpression17792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression17835 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression17845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_ruleXTryCatchFinallyExpression17891 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression17912 = new BitSet(new long[]{0x0000000000000000L,0x00C0000000000000L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression17942 = new BitSet(new long[]{0x0000000000000002L,0x00C0000000000000L});
    public static final BitSet FOLLOW_118_in_ruleXTryCatchFinallyExpression17964 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression17986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_ruleXTryCatchFinallyExpression18008 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression18029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause18073 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCatchClause18083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_ruleXCatchClause18128 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXCatchClause18141 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleFullJvmFormalParameter_in_ruleXCatchClause18162 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXCatchClause18174 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCatchClause18195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName18238 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName18249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName18296 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_ruleQualifiedName18324 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName18347 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_ruleNumber_in_entryRuleNumber18401 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumber18412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleNumber18456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNumber18484 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_ruleNumber18510 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_ruleNumber18530 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNumber18546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_ruleNumber18572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference18633 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference18643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference18691 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_ruleJvmTypeReference18727 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference18758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets18800 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayBrackets18811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleArrayBrackets18849 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleArrayBrackets18862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef18908 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef18918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleXFunctionTypeRef18956 = new BitSet(new long[]{0x009FF3A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef18978 = new BitSet(new long[]{0x0000020020000000L});
    public static final BitSet FOLLOW_29_in_ruleXFunctionTypeRef18991 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef19012 = new BitSet(new long[]{0x0000020020000000L});
    public static final BitSet FOLLOW_41_in_ruleXFunctionTypeRef19028 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_ruleXFunctionTypeRef19042 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef19063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference19105 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference19115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference19163 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleJvmParameterizedTypeReference19184 = new BitSet(new long[]{0x009FF1A002000010L,0x0100000000400000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference19206 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleJvmParameterizedTypeReference19219 = new BitSet(new long[]{0x009FF1A002000010L,0x0100000000400000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference19240 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_30_in_ruleJvmParameterizedTypeReference19254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference19298 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference19308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference19355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference19382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference19423 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference19433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_ruleJvmWildcardTypeReference19479 = new BitSet(new long[]{0x0000000080000002L,0x0000400000000000L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference19501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference19528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound19572 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound19582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleJvmUpperBound19619 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound19640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded19682 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded19692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_ruleJvmUpperBoundAnded19729 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded19750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound19792 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound19802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_ruleJvmLowerBound19839 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound19860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_entryRuleJvmTypeParameter19902 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeParameter19912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmTypeParameter19958 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmTypeParameter19980 = new BitSet(new long[]{0x0000000000000002L,0x0200000000000000L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmTypeParameter20001 = new BitSet(new long[]{0x0000000000000002L,0x0200000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard20047 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard20058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard20105 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_ruleQualifiedNameWithWildcard20123 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_ruleQualifiedNameWithWildcard20136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportSection_in_entryRuleXImportSection20182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXImportSection20192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportDeclaration_in_ruleXImportSection20237 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_ruleXImportDeclaration_in_entryRuleXImportDeclaration20279 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXImportDeclaration20289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleXImportDeclaration20326 = new BitSet(new long[]{0x0081002000000010L});
    public static final BitSet FOLLOW_48_in_ruleXImportDeclaration20346 = new BitSet(new long[]{0x008000A000000010L});
    public static final BitSet FOLLOW_39_in_ruleXImportDeclaration20377 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXImportDeclaration20414 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_ruleXImportDeclaration20426 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_ruleXImportDeclaration20438 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXImportDeclaration20468 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_ruleXImportDeclaration20495 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleXImportDeclaration20509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_synpred1_InternalXtend2324 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleCreateExtensionInfo_in_synpred1_InternalXtend2333 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred1_InternalXtend2342 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_synpred1_InternalXtend2348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_synpred2_InternalXtend2445 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred2_InternalXtend2454 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_synpred2_InternalXtend2460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreateExtensionInfo_in_synpred3_InternalXtend2536 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred3_InternalXtend2545 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_synpred3_InternalXtend2551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_synpred5_InternalXtend5113 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred5_InternalXtend5122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_synpred6_InternalXtend7560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred7_InternalXtend7589 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_synpred7_InternalXtend7595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_synpred11_InternalXtend8423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred12_InternalXtend8810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred13_InternalXtend9081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred14_InternalXtend9352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_synpred15_InternalXtend9678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred16_InternalXtend9749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred17_InternalXtend10080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_synpred18_InternalXtend10355 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_synpred18_InternalXtend10360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_synpred19_InternalXtend10442 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_synpred19_InternalXtend10447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred20_InternalXtend10675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred21_InternalXtend10967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_synpred22_InternalXtend11585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_synpred23_InternalXtend11746 = new BitSet(new long[]{0x02E7F4B98A000010L});
    public static final BitSet FOLLOW_99_in_synpred23_InternalXtend11760 = new BitSet(new long[]{0x02E7F4B98A000010L});
    public static final BitSet FOLLOW_ruleFeatureCallID_in_synpred23_InternalXtend11776 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_synpred23_InternalXtend11782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_synpred24_InternalXtend11924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_synpred24_InternalXtend11938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_synpred24_InternalXtend11958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_synpred25_InternalXtend12185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred26_InternalXtend12237 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_29_in_synpred26_InternalXtend12244 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred26_InternalXtend12251 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_synpred26_InternalXtend12265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_synpred27_InternalXtend12385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_synpred28_InternalXtend12948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred30_InternalXtend13722 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_29_in_synpred30_InternalXtend13729 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred30_InternalXtend13736 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_synpred30_InternalXtend13750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_synpred32_InternalXtend14557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred33_InternalXtend14705 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_synpred33_InternalXtend14711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_synpred34_InternalXtend14787 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred34_InternalXtend14794 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_synpred34_InternalXtend14800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_synpred35_InternalXtend15928 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_51_in_synpred35_InternalXtend15944 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_synpred35_InternalXtend15953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_synpred35_InternalXtend15976 = new BitSet(new long[]{0x0018000000000000L});
    public static final BitSet FOLLOW_52_in_synpred35_InternalXtend15991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_synpred35_InternalXtend16007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_synpred36_InternalXtend16265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred37_InternalXtend16317 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_29_in_synpred37_InternalXtend16324 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred37_InternalXtend16331 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_synpred37_InternalXtend16345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_synpred38_InternalXtend16465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_synpred39_InternalXtend16746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_synpred40_InternalXtend16839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred41_InternalXtend16869 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_29_in_synpred41_InternalXtend16876 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred41_InternalXtend16883 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_synpred41_InternalXtend16897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_synpred42_InternalXtend17017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred43_InternalXtend17775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_synpred44_InternalXtend17926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_synpred45_InternalXtend17956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_synpred47_InternalXtend18315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_synpred48_InternalXtend18706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_synpred49_InternalXtend19176 = new BitSet(new long[]{0x0000000000000002L});
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

	private EObject callUnassignedRuleXAnnotation(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXAnnotation();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXExpression(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXExpression();
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

	private EObject callUnassignedRuleXNullLiteral(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXNullLiteral();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXStringLiteral(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXStringLiteral();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXTypeLiteral(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXTypeLiteral();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXSetLiteral(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXSetLiteral();
		return getCurrentOrNull(token);
	}

	private EObject callUnassignedRuleXListLiteral(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXListLiteral();
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

	private EObject callRuleIdOrSuper(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule) throws RecognitionException {
		current = createModelElementAndPushFollow(current, rule, followSet, grammarElement);
		ruleIdOrSuper();
		postCrossReference();
		return current;
	}

}