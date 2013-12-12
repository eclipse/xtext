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
public class MinifiedInternalXtendParser extends InternalXtendParserBase {
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

        public MinifiedInternalXtendParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public MinifiedInternalXtendParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
        }
    public String[] getTokenNames() { return MinifiedInternalXtendParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtend.core/src-gen/org/eclipse/xtend/core/parser/antlr/internal/InternalXtend.g"; }
     	private XtendGrammarAccess grammarAccess;
        public MinifiedInternalXtendParser(TokenStream input, XtendGrammarAccess grammarAccess) {
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
                if ( (LA2_1==RULE_ID||LA2_1==55) ) {
                    alt2=1;
                }
                else if ( (LA2_1==37) ) {
                    int LA2_4 = input.LA(3);
                    if ( (LA2_4==EOF||(LA2_4>=25 && LA2_4<=27)||(LA2_4>=35 && LA2_4<=36)||(LA2_4>=44 && LA2_4<=50)||LA2_4==57||LA2_4==68||LA2_4==98) ) {
                        alt2=1;
                    }
                    else if ( (LA2_4==37) ) {
                        int LA2_5 = input.LA(4);
                        if ( (LA2_5==RULE_ID||LA2_5==37||LA2_5==55) ) {
                            alt2=1;
                        }
                    }
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
            int alt102=2;
            alt102 = dfa102.predict(input);
            switch (alt102) {
                case 1 :
                    {

                    {

                    {

                    {

                    {
                    if ( state.backtracking==0 ) {
                              current = forceCreateModelElement(
                                  elementAccess.getXListLiteralAction_0_0_0_0(),
                                  current);
                    }
                    }
                    if (!consumeUnassignedToken(69, FOLLOW_69_in_ruleXAnnotationElementValue7986,  elementAccess.getNumberSignKeyword_0_0_0_1())) { return current; }

                    if (!consumeUnassignedToken(70, FOLLOW_70_in_ruleXAnnotationElementValue7998,  elementAccess.getLeftSquareBracketKeyword_0_0_0_2())) { return current; }

                    }
                    }
                    int alt101=2;
                    int LA101_0 = input.LA(1);
                    if ( ((LA101_0>=RULE_ID && LA101_0<=RULE_RICH_TEXT_START)||(LA101_0>=RULE_HEX && LA101_0<=RULE_DECIMAL)||LA101_0==25||(LA101_0>=27 && LA101_0<=28)||(LA101_0>=31 && LA101_0<=33)||(LA101_0>=35 && LA101_0<=37)||(LA101_0>=39 && LA101_0<=40)||(LA101_0>=42 && LA101_0<=50)||(LA101_0>=53 && LA101_0<=55)||LA101_0==57||(LA101_0>=68 && LA101_0<=70)||(LA101_0>=90 && LA101_0<=91)||LA101_0==96||LA101_0==102||LA101_0==104||(LA101_0>=107 && LA101_0<=117)) ) {
                        alt101=1;
                    }
                    switch (alt101) {
                        case 1 :
                            {

                            {

                            {
                            current = callRuleXAnnotationOrExpressionAndAdd(FOLLOW_ruleXAnnotationOrExpression_in_ruleXAnnotationElementValue8022, current, elementAccess.getElementsXAnnotationOrExpressionParserRuleCall_0_1_0_0(), elementAccess.getRule(), XLIST_LITERAL__ELEMENTS, null);
                            if (state.failed) return current;

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
                            	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXAnnotationElementValue8035,  elementAccess.getCommaKeyword_0_1_1_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleXAnnotationOrExpressionAndAdd(FOLLOW_ruleXAnnotationOrExpression_in_ruleXAnnotationElementValue8056, current, elementAccess.getElementsXAnnotationOrExpressionParserRuleCall_0_1_1_1_0(), elementAccess.getRule(), XLIST_LITERAL__ELEMENTS, null);
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
                            break;
                    }
                    if (!consumeUnassignedToken(71, FOLLOW_71_in_ruleXAnnotationElementValue8072,  elementAccess.getRightSquareBracketKeyword_0_2())) { return current; }

                    }
                    }
                    break;
                case 2 :
                    {
                    current = callUnassignedRuleXAnnotationOrExpression(FOLLOW_ruleXAnnotationOrExpression_in_ruleXAnnotationElementValue8101, elementAccess.getXAnnotationOrExpressionParserRuleCall_1());
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

    public final EObject entryRuleXAnnotationOrExpression() throws RecognitionException {
        EObject current = null;
        EObject iv_ruleXAnnotationOrExpression = null;
        	org.eclipse.xtext.xbase.annotations.services.XbaseWithAnnotationsGrammarAccess.XAnnotationOrExpressionElements elementAccess = grammarAccess.getXAnnotationOrExpressionAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleXAnnotationOrExpression_in_entryRuleXAnnotationOrExpression8142);
            iv_ruleXAnnotationOrExpression=ruleXAnnotationOrExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAnnotationOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAnnotationOrExpression8152); if (state.failed) return current;
            }
        }
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }

    public final EObject ruleXAnnotationOrExpression() throws RecognitionException {
        EObject current = null;
         enterRule();
        	org.eclipse.xtext.xbase.annotations.services.XbaseWithAnnotationsGrammarAccess.XAnnotationOrExpressionElements elementAccess = grammarAccess.getXAnnotationOrExpressionAccess();
        try {

            {
            int alt103=2;
            int LA103_0 = input.LA(1);
            if ( (LA103_0==68) ) {
                alt103=1;
            }
            else if ( ((LA103_0>=RULE_ID && LA103_0<=RULE_RICH_TEXT_START)||(LA103_0>=RULE_HEX && LA103_0<=RULE_DECIMAL)||LA103_0==25||(LA103_0>=27 && LA103_0<=28)||(LA103_0>=31 && LA103_0<=33)||(LA103_0>=35 && LA103_0<=37)||(LA103_0>=39 && LA103_0<=40)||(LA103_0>=42 && LA103_0<=50)||(LA103_0>=53 && LA103_0<=55)||LA103_0==57||(LA103_0>=69 && LA103_0<=70)||(LA103_0>=90 && LA103_0<=91)||LA103_0==96||LA103_0==102||LA103_0==104||(LA103_0>=107 && LA103_0<=117)) ) {
                alt103=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);
                throw nvae;
            }
            switch (alt103) {
                case 1 :
                    {
                    current = callUnassignedRuleXAnnotation(FOLLOW_ruleXAnnotation_in_ruleXAnnotationOrExpression8199, elementAccess.getXAnnotationParserRuleCall_0());
                    if (state.failed) return current;

                    }
                    break;
                case 2 :
                    {
                    current = callUnassignedRuleXExpression(FOLLOW_ruleXExpression_in_ruleXAnnotationOrExpression8226, elementAccess.getXExpressionParserRuleCall_1());
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
            pushFollow(FOLLOW_ruleXExpression_in_entryRuleXExpression8267);
            iv_ruleXExpression=ruleXExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpression8277); if (state.failed) return current;
            }
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
            current = callUnassignedRuleXAssignment(FOLLOW_ruleXAssignment_in_ruleXExpression8323, elementAccess.getXAssignmentParserRuleCall());
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
            pushFollow(FOLLOW_ruleXAssignment_in_entryRuleXAssignment8363);
            iv_ruleXAssignment=ruleXAssignment();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAssignment8373); if (state.failed) return current;
            }
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
            int alt105=2;
            alt105 = dfa105.predict(input);
            switch (alt105) {
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
                    current = callRuleFeatureCallID(FOLLOW_ruleFeatureCallID_in_ruleXAssignment8431, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_0_1_0(), elementAccess.getRule());
                    if (state.failed) return current;

                    }
                    }
                    if ( state.backtracking==0 ) {
                              newCompositeNode(elementAccess.getOpSingleAssignParserRuleCall_0_2()); 
                    }
                    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXAssignment8447);
                    ruleOpSingleAssign();
                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                              afterParserOrEnumRuleCall();
                    }

                    {

                    {
                    current = callRuleXAssignmentAndSet(FOLLOW_ruleXAssignment_in_ruleXAssignment8467, current, elementAccess.getValueXAssignmentParserRuleCall_0_3_0(), elementAccess.getRule(), XASSIGNMENT__VALUE, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    }
                    break;
                case 2 :
                    {

                    {
                    current = callUnassignedRuleXOrExpression(FOLLOW_ruleXOrExpression_in_ruleXAssignment8497, elementAccess.getXOrExpressionParserRuleCall_1_0());
                    if (state.failed) return current;

                    int alt104=2;
                    int LA104_0 = input.LA(1);
                    if ( (LA104_0==72) ) {
                        int LA104_1 = input.LA(2);
                        if ( (synpred11_InternalXtend()) ) {
                            alt104=1;
                        }
                    }
                    else if ( (LA104_0==73) ) {
                        int LA104_2 = input.LA(2);
                        if ( (synpred11_InternalXtend()) ) {
                            alt104=1;
                        }
                    }
                    switch (alt104) {
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
                            current = callRuleOpMultiAssign(FOLLOW_ruleOpMultiAssign_in_ruleXAssignment8550, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0(), elementAccess.getRule());
                            if (state.failed) return current;

                            }
                            }
                            }
                            }

                            {

                            {
                            current = callRuleXAssignmentAndSet(FOLLOW_ruleXAssignment_in_ruleXAssignment8573, current, elementAccess.getRightOperandXAssignmentParserRuleCall_1_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
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
            pushFollow(FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign8619);
            iv_ruleOpSingleAssign=ruleOpSingleAssign();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpSingleAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpSingleAssign8630); if (state.failed) return current;
            }
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
            if (!consumeTokenAndMerge(38, FOLLOW_38_in_ruleOpSingleAssign8667, current,  elementAccess.getEqualsSignKeyword())) { return current; }

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
            pushFollow(FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign8713);
            iv_ruleOpMultiAssign=ruleOpMultiAssign();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMultiAssign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMultiAssign8724); if (state.failed) return current;
            }
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
            int alt106=2;
            int LA106_0 = input.LA(1);
            if ( (LA106_0==72) ) {
                alt106=1;
            }
            else if ( (LA106_0==73) ) {
                alt106=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);
                throw nvae;
            }
            switch (alt106) {
                case 1 :
                    {
                    if (!consumeTokenAndMerge(72, FOLLOW_72_in_ruleOpMultiAssign8762, current,  elementAccess.getPlusSignEqualsSignKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(73, FOLLOW_73_in_ruleOpMultiAssign8781, current,  elementAccess.getHyphenMinusEqualsSignKeyword_1())) { return current; }

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
            pushFollow(FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression8827);
            iv_ruleXOrExpression=ruleXOrExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOrExpression8837); if (state.failed) return current;
            }
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
            current = callUnassignedRuleXAndExpression(FOLLOW_ruleXAndExpression_in_ruleXOrExpression8884, elementAccess.getXAndExpressionParserRuleCall_0());
            if (state.failed) return current;

            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);
                if ( (LA107_0==74) ) {
                    int LA107_2 = input.LA(2);
                    if ( (synpred12_InternalXtend()) ) {
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
            	    current = callRuleOpOr(FOLLOW_ruleOpOr_in_ruleXOrExpression8937, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleXAndExpressionAndSet(FOLLOW_ruleXAndExpression_in_ruleXOrExpression8960, current, elementAccess.getRightOperandXAndExpressionParserRuleCall_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
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

    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleOpOr = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpOrElements elementAccess = grammarAccess.getOpOrAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr9005);
            iv_ruleOpOr=ruleOpOr();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr9016); if (state.failed) return current;
            }
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
            if (!consumeTokenAndMerge(74, FOLLOW_74_in_ruleOpOr9053, current,  elementAccess.getVerticalLineVerticalLineKeyword())) { return current; }

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
            pushFollow(FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression9098);
            iv_ruleXAndExpression=ruleXAndExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAndExpression9108); if (state.failed) return current;
            }
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
            current = callUnassignedRuleXEqualityExpression(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression9155, elementAccess.getXEqualityExpressionParserRuleCall_0());
            if (state.failed) return current;

            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);
                if ( (LA108_0==75) ) {
                    int LA108_2 = input.LA(2);
                    if ( (synpred13_InternalXtend()) ) {
                        alt108=1;
                    }
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
            	    current = callRuleOpAnd(FOLLOW_ruleOpAnd_in_ruleXAndExpression9208, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleXEqualityExpressionAndSet(FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression9231, current, elementAccess.getRightOperandXEqualityExpressionParserRuleCall_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
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

    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleOpAnd = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpAndElements elementAccess = grammarAccess.getOpAndAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd9276);
            iv_ruleOpAnd=ruleOpAnd();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd9287); if (state.failed) return current;
            }
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
            if (!consumeTokenAndMerge(75, FOLLOW_75_in_ruleOpAnd9324, current,  elementAccess.getAmpersandAmpersandKeyword())) { return current; }

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
            pushFollow(FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression9369);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXEqualityExpression9379); if (state.failed) return current;
            }
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
            current = callUnassignedRuleXRelationalExpression(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression9426, elementAccess.getXRelationalExpressionParserRuleCall_0());
            if (state.failed) return current;

            loop109:
            do {
                int alt109=2;
                switch ( input.LA(1) ) {
                case 76:
                    {
                    int LA109_2 = input.LA(2);
                    if ( (synpred14_InternalXtend()) ) {
                        alt109=1;
                    }
                    }
                    break;
                case 77:
                    {
                    int LA109_3 = input.LA(2);
                    if ( (synpred14_InternalXtend()) ) {
                        alt109=1;
                    }
                    }
                    break;
                case 78:
                    {
                    int LA109_4 = input.LA(2);
                    if ( (synpred14_InternalXtend()) ) {
                        alt109=1;
                    }
                    }
                    break;
                case 79:
                    {
                    int LA109_5 = input.LA(2);
                    if ( (synpred14_InternalXtend()) ) {
                        alt109=1;
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
            	    if ( state.backtracking==0 ) {
            	              current = forceCreateModelElementAndSet(
            	                  elementAccess.getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	                  XBINARY_OPERATION__LEFT_OPERAND,
            	                  current);
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleOpEquality(FOLLOW_ruleOpEquality_in_ruleXEqualityExpression9479, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleXRelationalExpressionAndSet(FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression9502, current, elementAccess.getRightOperandXRelationalExpressionParserRuleCall_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
            	    if (state.failed) return current;

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

    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleOpEquality = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpEqualityElements elementAccess = grammarAccess.getOpEqualityAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality9547);
            iv_ruleOpEquality=ruleOpEquality();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality9558); if (state.failed) return current;
            }
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
            int alt110=4;
            switch ( input.LA(1) ) {
            case 76:
                {
                alt110=1;
                }
                break;
            case 77:
                {
                alt110=2;
                }
                break;
            case 78:
                {
                alt110=3;
                }
                break;
            case 79:
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
                    if (!consumeTokenAndMerge(76, FOLLOW_76_in_ruleOpEquality9596, current,  elementAccess.getEqualsSignEqualsSignKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(77, FOLLOW_77_in_ruleOpEquality9615, current,  elementAccess.getExclamationMarkEqualsSignKeyword_1())) { return current; }

                    }
                    break;
                case 3 :
                    {
                    if (!consumeTokenAndMerge(78, FOLLOW_78_in_ruleOpEquality9634, current,  elementAccess.getEqualsSignEqualsSignEqualsSignKeyword_2())) { return current; }

                    }
                    break;
                case 4 :
                    {
                    if (!consumeTokenAndMerge(79, FOLLOW_79_in_ruleOpEquality9653, current,  elementAccess.getExclamationMarkEqualsSignEqualsSignKeyword_3())) { return current; }

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
            pushFollow(FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression9699);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXRelationalExpression9709); if (state.failed) return current;
            }
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
            current = callUnassignedRuleXOtherOperatorExpression(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression9756, elementAccess.getXOtherOperatorExpressionParserRuleCall_0());
            if (state.failed) return current;

            loop111:
            do {
                int alt111=3;
                switch ( input.LA(1) ) {
                case 28:
                    {
                    int LA111_2 = input.LA(2);
                    if ( (synpred16_InternalXtend()) ) {
                        alt111=2;
                    }
                    }
                    break;
                case 30:
                    {
                    int LA111_3 = input.LA(2);
                    if ( (synpred16_InternalXtend()) ) {
                        alt111=2;
                    }
                    }
                    break;
                case 80:
                    {
                    int LA111_4 = input.LA(2);
                    if ( (synpred15_InternalXtend()) ) {
                        alt111=1;
                    }
                    }
                    break;
                case 81:
                    {
                    int LA111_5 = input.LA(2);
                    if ( (synpred16_InternalXtend()) ) {
                        alt111=2;
                    }
                    }
                    break;
                case 82:
                    {
                    int LA111_6 = input.LA(2);
                    if ( (synpred16_InternalXtend()) ) {
                        alt111=2;
                    }
                    }
                    break;
                }
                switch (alt111) {
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
            	    if (!consumeUnassignedToken(80, FOLLOW_80_in_ruleXRelationalExpression9792,  elementAccess.getInstanceofKeyword_1_0_0_0_1())) { return current; }

            	    }
            	    }

            	    {

            	    {
            	    current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleXRelationalExpression9815, current, elementAccess.getTypeJvmTypeReferenceParserRuleCall_1_0_1_0(), elementAccess.getRule(), XINSTANCE_OF_EXPRESSION__TYPE, null);
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
            	    current = callRuleOpCompare(FOLLOW_ruleOpCompare_in_ruleXRelationalExpression9876, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleXOtherOperatorExpressionAndSet(FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression9899, current, elementAccess.getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
            	    if (state.failed) return current;

            	    }
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

    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleOpCompare = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpCompareElements elementAccess = grammarAccess.getOpCompareAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare9945);
            iv_ruleOpCompare=ruleOpCompare();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare9956); if (state.failed) return current;
            }
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
            int alt112=4;
            switch ( input.LA(1) ) {
            case 81:
                {
                alt112=1;
                }
                break;
            case 82:
                {
                alt112=2;
                }
                break;
            case 30:
                {
                alt112=3;
                }
                break;
            case 28:
                {
                alt112=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);
                throw nvae;
            }
            switch (alt112) {
                case 1 :
                    {
                    if (!consumeTokenAndMerge(81, FOLLOW_81_in_ruleOpCompare9994, current,  elementAccess.getGreaterThanSignEqualsSignKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(82, FOLLOW_82_in_ruleOpCompare10013, current,  elementAccess.getLessThanSignEqualsSignKeyword_1())) { return current; }

                    }
                    break;
                case 3 :
                    {
                    if (!consumeTokenAndMerge(30, FOLLOW_30_in_ruleOpCompare10032, current,  elementAccess.getGreaterThanSignKeyword_2())) { return current; }

                    }
                    break;
                case 4 :
                    {
                    if (!consumeTokenAndMerge(28, FOLLOW_28_in_ruleOpCompare10051, current,  elementAccess.getLessThanSignKeyword_3())) { return current; }

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
            pushFollow(FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression10097);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXOtherOperatorExpression10107); if (state.failed) return current;
            }
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
            current = callUnassignedRuleXAdditiveExpression(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression10154, elementAccess.getXAdditiveExpressionParserRuleCall_0());
            if (state.failed) return current;

            loop113:
            do {
                int alt113=2;
                alt113 = dfa113.predict(input);
                switch (alt113) {
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
            	    current = callRuleOpOther(FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression10207, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleXAdditiveExpressionAndSet(FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression10230, current, elementAccess.getRightOperandXAdditiveExpressionParserRuleCall_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    break;
            	default :
            	    break loop113;
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
            pushFollow(FOLLOW_ruleOpOther_in_entryRuleOpOther10275);
            iv_ruleOpOther=ruleOpOther();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOther10286); if (state.failed) return current;
            }
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
            int alt116=10;
            alt116 = dfa116.predict(input);
            switch (alt116) {
                case 1 :
                    {
                    if (!consumeTokenAndMerge(83, FOLLOW_83_in_ruleOpOther10324, current,  elementAccess.getHyphenMinusGreaterThanSignKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(84, FOLLOW_84_in_ruleOpOther10343, current,  elementAccess.getFullStopFullStopLessThanSignKeyword_1())) { return current; }

                    }
                    break;
                case 3 :
                    {

                    {
                    if (!consumeTokenAndMerge(30, FOLLOW_30_in_ruleOpOther10363, current,  elementAccess.getGreaterThanSignKeyword_2_0())) { return current; }

                    if (!consumeTokenAndMerge(85, FOLLOW_85_in_ruleOpOther10376, current,  elementAccess.getFullStopFullStopKeyword_2_1())) { return current; }

                    }
                    }
                    break;
                case 4 :
                    {
                    if (!consumeTokenAndMerge(85, FOLLOW_85_in_ruleOpOther10396, current,  elementAccess.getFullStopFullStopKeyword_3())) { return current; }

                    }
                    break;
                case 5 :
                    {
                    if (!consumeTokenAndMerge(86, FOLLOW_86_in_ruleOpOther10415, current,  elementAccess.getEqualsSignGreaterThanSignKeyword_4())) { return current; }

                    }
                    break;
                case 6 :
                    {

                    {
                    if (!consumeTokenAndMerge(30, FOLLOW_30_in_ruleOpOther10435, current,  elementAccess.getGreaterThanSignKeyword_5_0())) { return current; }

                    int alt114=2;
                    int LA114_0 = input.LA(1);
                    if ( (LA114_0==30) ) {
                        int LA114_1 = input.LA(2);
                        if ( (LA114_1==EOF||(LA114_1>=RULE_ID && LA114_1<=RULE_RICH_TEXT_START)||(LA114_1>=RULE_HEX && LA114_1<=RULE_DECIMAL)||LA114_1==25||(LA114_1>=27 && LA114_1<=28)||(LA114_1>=31 && LA114_1<=33)||(LA114_1>=35 && LA114_1<=37)||(LA114_1>=39 && LA114_1<=40)||(LA114_1>=42 && LA114_1<=50)||(LA114_1>=53 && LA114_1<=55)||LA114_1==57||(LA114_1>=69 && LA114_1<=70)||(LA114_1>=90 && LA114_1<=91)||LA114_1==96||LA114_1==102||LA114_1==104||(LA114_1>=107 && LA114_1<=117)) ) {
                            alt114=2;
                        }
                        else if ( (LA114_1==30) && (synpred18_InternalXtend())) {
                            alt114=1;
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
                            if (!consumeTokenAndMerge(30, FOLLOW_30_in_ruleOpOther10466, current,  elementAccess.getGreaterThanSignKeyword_5_1_0_0_0())) { return current; }

                            if (!consumeTokenAndMerge(30, FOLLOW_30_in_ruleOpOther10479, current,  elementAccess.getGreaterThanSignKeyword_5_1_0_0_1())) { return current; }

                            }
                            }
                            }
                            break;
                        case 2 :
                            {
                            if (!consumeTokenAndMerge(30, FOLLOW_30_in_ruleOpOther10500, current,  elementAccess.getGreaterThanSignKeyword_5_1_1())) { return current; }

                            }
                            break;
                    }
                    }
                    }
                    break;
                case 7 :
                    {

                    {
                    if (!consumeTokenAndMerge(28, FOLLOW_28_in_ruleOpOther10522, current,  elementAccess.getLessThanSignKeyword_6_0())) { return current; }

                    int alt115=2;
                    int LA115_0 = input.LA(1);
                    if ( (LA115_0==28) ) {
                        int LA115_1 = input.LA(2);
                        if ( (synpred19_InternalXtend()) ) {
                            alt115=1;
                        }
                        else if ( (true) ) {
                            alt115=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 115, 1, input);
                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 115, 0, input);
                        throw nvae;
                    }
                    switch (alt115) {
                        case 1 :
                            {

                            {

                            {
                            if (!consumeTokenAndMerge(28, FOLLOW_28_in_ruleOpOther10553, current,  elementAccess.getLessThanSignKeyword_6_1_0_0_0())) { return current; }

                            if (!consumeTokenAndMerge(28, FOLLOW_28_in_ruleOpOther10566, current,  elementAccess.getLessThanSignKeyword_6_1_0_0_1())) { return current; }

                            }
                            }
                            }
                            break;
                        case 2 :
                            {
                            if (!consumeTokenAndMerge(28, FOLLOW_28_in_ruleOpOther10587, current,  elementAccess.getLessThanSignKeyword_6_1_1())) { return current; }

                            }
                            break;
                    }
                    }
                    }
                    break;
                case 8 :
                    {
                    if (!consumeTokenAndMerge(87, FOLLOW_87_in_ruleOpOther10608, current,  elementAccess.getLessThanSignGreaterThanSignKeyword_7())) { return current; }

                    }
                    break;
                case 9 :
                    {
                    if (!consumeTokenAndMerge(88, FOLLOW_88_in_ruleOpOther10627, current,  elementAccess.getQuestionMarkColonKeyword_8())) { return current; }

                    }
                    break;
                case 10 :
                    {
                    if (!consumeTokenAndMerge(89, FOLLOW_89_in_ruleOpOther10646, current,  elementAccess.getLessThanSignEqualsSignGreaterThanSignKeyword_9())) { return current; }

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
            pushFollow(FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression10692);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXAdditiveExpression10702); if (state.failed) return current;
            }
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
            current = callUnassignedRuleXMultiplicativeExpression(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression10749, elementAccess.getXMultiplicativeExpressionParserRuleCall_0());
            if (state.failed) return current;

            loop117:
            do {
                int alt117=2;
                int LA117_0 = input.LA(1);
                if ( (LA117_0==91) ) {
                    int LA117_2 = input.LA(2);
                    if ( (synpred20_InternalXtend()) ) {
                        alt117=1;
                    }
                }
                else if ( (LA117_0==90) ) {
                    int LA117_3 = input.LA(2);
                    if ( (synpred20_InternalXtend()) ) {
                        alt117=1;
                    }
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
            	    current = callRuleOpAdd(FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression10802, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleXMultiplicativeExpressionAndSet(FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression10825, current, elementAccess.getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
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

    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;
        AntlrDatatypeRuleToken iv_ruleOpAdd = null;
        	org.eclipse.xtext.xbase.services.XbaseGrammarAccess.OpAddElements elementAccess = grammarAccess.getOpAddAccess();
        try {

            {
            if ( state.backtracking==0 ) {
               newCompositeNode(elementAccess.getRule()); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd10870);
            iv_ruleOpAdd=ruleOpAdd();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd10881); if (state.failed) return current;
            }
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
            int alt118=2;
            int LA118_0 = input.LA(1);
            if ( (LA118_0==90) ) {
                alt118=1;
            }
            else if ( (LA118_0==91) ) {
                alt118=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 118, 0, input);
                throw nvae;
            }
            switch (alt118) {
                case 1 :
                    {
                    if (!consumeTokenAndMerge(90, FOLLOW_90_in_ruleOpAdd10919, current,  elementAccess.getPlusSignKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(91, FOLLOW_91_in_ruleOpAdd10938, current,  elementAccess.getHyphenMinusKeyword_1())) { return current; }

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
            pushFollow(FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression10984);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMultiplicativeExpression10994); if (state.failed) return current;
            }
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
            current = callUnassignedRuleXUnaryOperation(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression11041, elementAccess.getXUnaryOperationParserRuleCall_0());
            if (state.failed) return current;

            loop119:
            do {
                int alt119=2;
                switch ( input.LA(1) ) {
                case 92:
                    {
                    int LA119_2 = input.LA(2);
                    if ( (synpred21_InternalXtend()) ) {
                        alt119=1;
                    }
                    }
                    break;
                case 93:
                    {
                    int LA119_3 = input.LA(2);
                    if ( (synpred21_InternalXtend()) ) {
                        alt119=1;
                    }
                    }
                    break;
                case 94:
                    {
                    int LA119_4 = input.LA(2);
                    if ( (synpred21_InternalXtend()) ) {
                        alt119=1;
                    }
                    }
                    break;
                case 95:
                    {
                    int LA119_5 = input.LA(2);
                    if ( (synpred21_InternalXtend()) ) {
                        alt119=1;
                    }
                    }
                    break;
                }
                switch (alt119) {
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
            	    current = callRuleOpMulti(FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression11094, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    }

            	    {

            	    {
            	    current = callRuleXUnaryOperationAndSet(FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression11117, current, elementAccess.getRightOperandXUnaryOperationParserRuleCall_1_1_0(), elementAccess.getRule(), XBINARY_OPERATION__RIGHT_OPERAND, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    break;
            	default :
            	    break loop119;
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
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti11162);
            iv_ruleOpMulti=ruleOpMulti();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti11173); if (state.failed) return current;
            }
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
            int alt120=4;
            switch ( input.LA(1) ) {
            case 92:
                {
                alt120=1;
                }
                break;
            case 93:
                {
                alt120=2;
                }
                break;
            case 94:
                {
                alt120=3;
                }
                break;
            case 95:
                {
                alt120=4;
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
                    if (!consumeTokenAndMerge(92, FOLLOW_92_in_ruleOpMulti11211, current,  elementAccess.getAsteriskKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(93, FOLLOW_93_in_ruleOpMulti11230, current,  elementAccess.getAsteriskAsteriskKeyword_1())) { return current; }

                    }
                    break;
                case 3 :
                    {
                    if (!consumeTokenAndMerge(94, FOLLOW_94_in_ruleOpMulti11249, current,  elementAccess.getSolidusKeyword_2())) { return current; }

                    }
                    break;
                case 4 :
                    {
                    if (!consumeTokenAndMerge(95, FOLLOW_95_in_ruleOpMulti11268, current,  elementAccess.getPercentSignKeyword_3())) { return current; }

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
            pushFollow(FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation11314);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXUnaryOperation11324); if (state.failed) return current;
            }
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
            int alt121=2;
            int LA121_0 = input.LA(1);
            if ( ((LA121_0>=90 && LA121_0<=91)||LA121_0==96) ) {
                alt121=1;
            }
            else if ( ((LA121_0>=RULE_ID && LA121_0<=RULE_RICH_TEXT_START)||(LA121_0>=RULE_HEX && LA121_0<=RULE_DECIMAL)||LA121_0==25||(LA121_0>=27 && LA121_0<=28)||(LA121_0>=31 && LA121_0<=33)||(LA121_0>=35 && LA121_0<=37)||(LA121_0>=39 && LA121_0<=40)||(LA121_0>=42 && LA121_0<=50)||(LA121_0>=53 && LA121_0<=55)||LA121_0==57||(LA121_0>=69 && LA121_0<=70)||LA121_0==102||LA121_0==104||(LA121_0>=107 && LA121_0<=117)) ) {
                alt121=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 121, 0, input);
                throw nvae;
            }
            switch (alt121) {
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
                    current = callRuleOpUnary(FOLLOW_ruleOpUnary_in_ruleXUnaryOperation11382, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_0_1_0(), elementAccess.getRule());
                    if (state.failed) return current;

                    }
                    }

                    {

                    {
                    current = callRuleXUnaryOperationAndSet(FOLLOW_ruleXUnaryOperation_in_ruleXUnaryOperation11403, current, elementAccess.getOperandXUnaryOperationParserRuleCall_0_2_0(), elementAccess.getRule(), XUNARY_OPERATION__OPERAND, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    }
                    break;
                case 2 :
                    {
                    current = callUnassignedRuleXCastedExpression(FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation11432, elementAccess.getXCastedExpressionParserRuleCall_1());
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
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary11474);
            iv_ruleOpUnary=ruleOpUnary();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary11485); if (state.failed) return current;
            }
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
            int alt122=3;
            switch ( input.LA(1) ) {
            case 96:
                {
                alt122=1;
                }
                break;
            case 91:
                {
                alt122=2;
                }
                break;
            case 90:
                {
                alt122=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 122, 0, input);
                throw nvae;
            }
            switch (alt122) {
                case 1 :
                    {
                    if (!consumeTokenAndMerge(96, FOLLOW_96_in_ruleOpUnary11523, current,  elementAccess.getExclamationMarkKeyword_0())) { return current; }

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(91, FOLLOW_91_in_ruleOpUnary11542, current,  elementAccess.getHyphenMinusKeyword_1())) { return current; }

                    }
                    break;
                case 3 :
                    {
                    if (!consumeTokenAndMerge(90, FOLLOW_90_in_ruleOpUnary11561, current,  elementAccess.getPlusSignKeyword_2())) { return current; }

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
            pushFollow(FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression11607);
            iv_ruleXCastedExpression=ruleXCastedExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCastedExpression11617); if (state.failed) return current;
            }
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
            current = callUnassignedRuleXMemberFeatureCall(FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression11664, elementAccess.getXMemberFeatureCallParserRuleCall_0());
            if (state.failed) return current;

            loop123:
            do {
                int alt123=2;
                int LA123_0 = input.LA(1);
                if ( (LA123_0==97) ) {
                    int LA123_2 = input.LA(2);
                    if ( (synpred22_InternalXtend()) ) {
                        alt123=1;
                    }
                }
                switch (alt123) {
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
            	    if (!consumeUnassignedToken(97, FOLLOW_97_in_ruleXCastedExpression11699,  elementAccess.getAsKeyword_1_0_0_1())) { return current; }

            	    }
            	    }

            	    {

            	    {
            	    current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression11722, current, elementAccess.getTypeJvmTypeReferenceParserRuleCall_1_1_0(), elementAccess.getRule(), XCASTED_EXPRESSION__TYPE, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    }
            	    break;
            	default :
            	    break loop123;
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
            pushFollow(FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall11766);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXMemberFeatureCall11776); if (state.failed) return current;
            }
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
            current = callUnassignedRuleXPrimaryExpression(FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall11823, elementAccess.getXPrimaryExpressionParserRuleCall_0());
            if (state.failed) return current;

            loop132:
            do {
                int alt132=3;
                switch ( input.LA(1) ) {
                case 98:
                    {
                    int LA132_2 = input.LA(2);
                    if ( (synpred23_InternalXtend()) ) {
                        alt132=1;
                    }
                    else if ( (synpred24_InternalXtend()) ) {
                        alt132=2;
                    }
                    }
                    break;
                case 99:
                    {
                    int LA132_3 = input.LA(2);
                    if ( (synpred23_InternalXtend()) ) {
                        alt132=1;
                    }
                    else if ( (synpred24_InternalXtend()) ) {
                        alt132=2;
                    }
                    }
                    break;
                case 100:
                    {
                    int LA132_4 = input.LA(2);
                    if ( (synpred24_InternalXtend()) ) {
                        alt132=2;
                    }
                    }
                    break;
                }
                switch (alt132) {
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
            	    int alt124=2;
            	    int LA124_0 = input.LA(1);
            	    if ( (LA124_0==98) ) {
            	        alt124=1;
            	    }
            	    else if ( (LA124_0==99) ) {
            	        alt124=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 124, 0, input);
            	        throw nvae;
            	    }
            	    switch (alt124) {
            	        case 1 :
            	            {
            	            if (!consumeUnassignedToken(98, FOLLOW_98_in_ruleXMemberFeatureCall11895,  elementAccess.getFullStopKeyword_1_0_0_0_1_0())) { return current; }

            	            }
            	            break;
            	        case 2 :
            	            {

            	            {

            	            {
            	            current = consumeTokenAndSetBooleanValue(99, FOLLOW_99_in_ruleXMemberFeatureCall11919, current,  elementAccess.getExplicitStaticColonColonKeyword_1_0_0_0_1_1_0(), elementAccess.getRule(), XASSIGNMENT__EXPLICIT_STATIC);
            	            if (state.failed) return current;

            	            }
            	            }
            	            }
            	            break;
            	    }

            	    {

            	    {
            	    current = callRuleFeatureCallID(FOLLOW_ruleFeatureCallID_in_ruleXMemberFeatureCall11956, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    if ( state.backtracking==0 ) {
            	              newCompositeNode(elementAccess.getOpSingleAssignParserRuleCall_1_0_0_0_3()); 
            	    }
            	    pushFollow(FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall11972);
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
            	    current = callRuleXAssignmentAndSet(FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall11994, current, elementAccess.getValueXAssignmentParserRuleCall_1_0_1_0(), elementAccess.getRule(), XASSIGNMENT__VALUE, null);
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
            	    int alt125=3;
            	    switch ( input.LA(1) ) {
            	    case 98:
            	        {
            	        alt125=1;
            	        }
            	        break;
            	    case 100:
            	        {
            	        alt125=2;
            	        }
            	        break;
            	    case 99:
            	        {
            	        alt125=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 125, 0, input);
            	        throw nvae;
            	    }
            	    switch (alt125) {
            	        case 1 :
            	            {
            	            if (!consumeUnassignedToken(98, FOLLOW_98_in_ruleXMemberFeatureCall12080,  elementAccess.getFullStopKeyword_1_1_0_0_1_0())) { return current; }

            	            }
            	            break;
            	        case 2 :
            	            {

            	            {

            	            {
            	            current = consumeTokenAndSetBooleanValue(100, FOLLOW_100_in_ruleXMemberFeatureCall12104, current,  elementAccess.getNullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__NULL_SAFE);
            	            if (state.failed) return current;

            	            }
            	            }
            	            }
            	            break;
            	        case 3 :
            	            {

            	            {

            	            {
            	            current = consumeTokenAndSetBooleanValue(99, FOLLOW_99_in_ruleXMemberFeatureCall12141, current,  elementAccess.getExplicitStaticColonColonKeyword_1_1_0_0_1_2_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__EXPLICIT_STATIC);
            	            if (state.failed) return current;

            	            }
            	            }
            	            }
            	            break;
            	    }
            	    }
            	    }
            	    int alt127=2;
            	    int LA127_0 = input.LA(1);
            	    if ( (LA127_0==28) ) {
            	        alt127=1;
            	    }
            	    switch (alt127) {
            	        case 1 :
            	            {
            	            if (!consumeUnassignedToken(28, FOLLOW_28_in_ruleXMemberFeatureCall12170,  elementAccess.getLessThanSignKeyword_1_1_1_0())) { return current; }


            	            {

            	            {
            	            current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall12191, current, elementAccess.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__TYPE_ARGUMENTS, null);
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
            	            	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXMemberFeatureCall12204,  elementAccess.getCommaKeyword_1_1_1_2_0())) { return current; }


            	            	    {

            	            	    {
            	            	    current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall12225, current, elementAccess.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__TYPE_ARGUMENTS, null);
            	            	    if (state.failed) return current;

            	            	    }
            	            	    }
            	            	    }
            	            	    break;
            	            	default :
            	            	    break loop126;
            	                }
            	            } while (true);
            	            if (!consumeUnassignedToken(30, FOLLOW_30_in_ruleXMemberFeatureCall12239,  elementAccess.getGreaterThanSignKeyword_1_1_1_3())) { return current; }

            	            }
            	            break;
            	    }

            	    {

            	    {
            	    current = callRuleFeatureCallID(FOLLOW_ruleFeatureCallID_in_ruleXMemberFeatureCall12264, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_1_1_2_0(), elementAccess.getRule());
            	    if (state.failed) return current;

            	    }
            	    }
            	    int alt130=2;
            	    alt130 = dfa130.predict(input);
            	    switch (alt130) {
            	        case 1 :
            	            {

            	            {

            	            {
            	            current = consumeTokenAndSetBooleanValue(40, FOLLOW_40_in_ruleXMemberFeatureCall12298, current,  elementAccess.getExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__EXPLICIT_OPERATION_CALL);
            	            if (state.failed) return current;

            	            }
            	            }
            	            int alt129=3;
            	            alt129 = dfa129.predict(input);
            	            switch (alt129) {
            	                case 1 :
            	                    {

            	                    {

            	                    {
            	                    current = callRuleXShortClosureAndAdd(FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall12383, current, elementAccess.getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS, null);
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
            	                    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall12411, current, elementAccess.getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS, null);
            	                    if (state.failed) return current;

            	                    }
            	                    }
            	                    loop128:
            	                    do {
            	                        int alt128=2;
            	                        int LA128_0 = input.LA(1);
            	                        if ( (LA128_0==29) ) {
            	                            alt128=1;
            	                        }
            	                        switch (alt128) {
            	                    	case 1 :
            	                    	    {
            	                    	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXMemberFeatureCall12424,  elementAccess.getCommaKeyword_1_1_3_1_1_1_0())) { return current; }


            	                    	    {

            	                    	    {
            	                    	    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall12445, current, elementAccess.getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS, null);
            	                    	    if (state.failed) return current;

            	                    	    }
            	                    	    }
            	                    	    }
            	                    	    break;
            	                    	default :
            	                    	    break loop128;
            	                        }
            	                    } while (true);
            	                    }
            	                    }
            	                    break;
            	            }
            	            if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXMemberFeatureCall12462,  elementAccess.getRightParenthesisKeyword_1_1_3_2())) { return current; }

            	            }
            	            break;
            	    }
            	    int alt131=2;
            	    alt131 = dfa131.predict(input);
            	    switch (alt131) {
            	        case 1 :
            	            {

            	            {
            	            current = callRuleXClosureAndAdd(FOLLOW_ruleXClosure_in_ruleXMemberFeatureCall12497, current, elementAccess.getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0(), elementAccess.getRule(), XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS, null);
            	            if (state.failed) return current;

            	            }
            	            }
            	            break;
            	    }
            	    }
            	    }
            	    break;
            	default :
            	    break loop132;
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
            pushFollow(FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression12543);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXPrimaryExpression12553); if (state.failed) return current;
            }
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
            int alt133=13;
            alt133 = dfa133.predict(input);
            switch (alt133) {
                case 1 :
                    {
                    current = callUnassignedRuleXConstructorCall(FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression12600, elementAccess.getXConstructorCallParserRuleCall_0());
                    if (state.failed) return current;

                    }
                    break;
                case 2 :
                    {
                    current = callUnassignedRuleXBlockExpression(FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression12627, elementAccess.getXBlockExpressionParserRuleCall_1());
                    if (state.failed) return current;

                    }
                    break;
                case 3 :
                    {
                    current = callUnassignedRuleXSwitchExpression(FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression12654, elementAccess.getXSwitchExpressionParserRuleCall_2());
                    if (state.failed) return current;

                    }
                    break;
                case 4 :
                    {
                    current = callUnassignedRuleXFeatureCall(FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression12681, elementAccess.getXFeatureCallParserRuleCall_3());
                    if (state.failed) return current;

                    }
                    break;
                case 5 :
                    {
                    current = callUnassignedRuleXLiteral(FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression12708, elementAccess.getXLiteralParserRuleCall_4());
                    if (state.failed) return current;

                    }
                    break;
                case 6 :
                    {
                    current = callUnassignedRuleXIfExpression(FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression12735, elementAccess.getXIfExpressionParserRuleCall_5());
                    if (state.failed) return current;

                    }
                    break;
                case 7 :
                    {
                    current = callUnassignedRuleXForLoopExpression(FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression12762, elementAccess.getXForLoopExpressionParserRuleCall_6());
                    if (state.failed) return current;

                    }
                    break;
                case 8 :
                    {
                    current = callUnassignedRuleXWhileExpression(FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression12789, elementAccess.getXWhileExpressionParserRuleCall_7());
                    if (state.failed) return current;

                    }
                    break;
                case 9 :
                    {
                    current = callUnassignedRuleXDoWhileExpression(FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression12816, elementAccess.getXDoWhileExpressionParserRuleCall_8());
                    if (state.failed) return current;

                    }
                    break;
                case 10 :
                    {
                    current = callUnassignedRuleXThrowExpression(FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression12843, elementAccess.getXThrowExpressionParserRuleCall_9());
                    if (state.failed) return current;

                    }
                    break;
                case 11 :
                    {
                    current = callUnassignedRuleXReturnExpression(FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression12870, elementAccess.getXReturnExpressionParserRuleCall_10());
                    if (state.failed) return current;

                    }
                    break;
                case 12 :
                    {
                    current = callUnassignedRuleXTryCatchFinallyExpression(FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression12897, elementAccess.getXTryCatchFinallyExpressionParserRuleCall_11());
                    if (state.failed) return current;

                    }
                    break;
                case 13 :
                    {
                    current = callUnassignedRuleXParenthesizedExpression(FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression12924, elementAccess.getXParenthesizedExpressionParserRuleCall_12());
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
            pushFollow(FOLLOW_ruleXLiteral_in_entryRuleXLiteral12965);
            iv_ruleXLiteral=ruleXLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXLiteral12975); if (state.failed) return current;
            }
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
            int alt134=7;
            int LA134_0 = input.LA(1);
            if ( (LA134_0==69) ) {
                alt134=1;
            }
            else if ( (LA134_0==70) && (synpred28_InternalXtend())) {
                alt134=2;
            }
            else if ( ((LA134_0>=111 && LA134_0<=112)) ) {
                alt134=3;
            }
            else if ( ((LA134_0>=RULE_HEX && LA134_0<=RULE_DECIMAL)) ) {
                alt134=4;
            }
            else if ( (LA134_0==113) ) {
                alt134=5;
            }
            else if ( ((LA134_0>=RULE_STRING && LA134_0<=RULE_RICH_TEXT_START)) ) {
                alt134=6;
            }
            else if ( (LA134_0==114) ) {
                alt134=7;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 134, 0, input);
                throw nvae;
            }
            switch (alt134) {
                case 1 :
                    {
                    current = callUnassignedRuleXCollectionLiteral(FOLLOW_ruleXCollectionLiteral_in_ruleXLiteral13022, elementAccess.getXCollectionLiteralParserRuleCall_0());
                    if (state.failed) return current;

                    }
                    break;
                case 2 :
                    {

                    {
                    current = callUnassignedRuleXClosure(FOLLOW_ruleXClosure_in_ruleXLiteral13062, elementAccess.getXClosureParserRuleCall_1());
                    if (state.failed) return current;

                    }
                    }
                    break;
                case 3 :
                    {
                    current = callUnassignedRuleXBooleanLiteral(FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral13090, elementAccess.getXBooleanLiteralParserRuleCall_2());
                    if (state.failed) return current;

                    }
                    break;
                case 4 :
                    {
                    current = callUnassignedRuleXNumberLiteral(FOLLOW_ruleXNumberLiteral_in_ruleXLiteral13117, elementAccess.getXNumberLiteralParserRuleCall_3());
                    if (state.failed) return current;

                    }
                    break;
                case 5 :
                    {
                    current = callUnassignedRuleXNullLiteral(FOLLOW_ruleXNullLiteral_in_ruleXLiteral13144, elementAccess.getXNullLiteralParserRuleCall_4());
                    if (state.failed) return current;

                    }
                    break;
                case 6 :
                    {
                    current = callUnassignedRuleXStringLiteral(FOLLOW_ruleXStringLiteral_in_ruleXLiteral13171, elementAccess.getXStringLiteralParserRuleCall_5());
                    if (state.failed) return current;

                    }
                    break;
                case 7 :
                    {
                    current = callUnassignedRuleXTypeLiteral(FOLLOW_ruleXTypeLiteral_in_ruleXLiteral13198, elementAccess.getXTypeLiteralParserRuleCall_6());
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
            pushFollow(FOLLOW_ruleXCollectionLiteral_in_entryRuleXCollectionLiteral13239);
            iv_ruleXCollectionLiteral=ruleXCollectionLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCollectionLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCollectionLiteral13249); if (state.failed) return current;
            }
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
            int alt135=2;
            int LA135_0 = input.LA(1);
            if ( (LA135_0==69) ) {
                int LA135_1 = input.LA(2);
                if ( (LA135_1==70) ) {
                    alt135=2;
                }
                else if ( (LA135_1==33) ) {
                    alt135=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 135, 1, input);
                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 135, 0, input);
                throw nvae;
            }
            switch (alt135) {
                case 1 :
                    {
                    current = callUnassignedRuleXSetLiteral(FOLLOW_ruleXSetLiteral_in_ruleXCollectionLiteral13296, elementAccess.getXSetLiteralParserRuleCall_0());
                    if (state.failed) return current;

                    }
                    break;
                case 2 :
                    {
                    current = callUnassignedRuleXListLiteral(FOLLOW_ruleXListLiteral_in_ruleXCollectionLiteral13323, elementAccess.getXListLiteralParserRuleCall_1());
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
            pushFollow(FOLLOW_ruleXSetLiteral_in_entryRuleXSetLiteral13364);
            iv_ruleXSetLiteral=ruleXSetLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSetLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSetLiteral13374); if (state.failed) return current;
            }
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
            if (!consumeUnassignedToken(69, FOLLOW_69_in_ruleXSetLiteral13420,  elementAccess.getNumberSignKeyword_1())) { return current; }

            if (!consumeUnassignedToken(33, FOLLOW_33_in_ruleXSetLiteral13432,  elementAccess.getLeftCurlyBracketKeyword_2())) { return current; }

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
                    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXSetLiteral13454, current, elementAccess.getElementsXExpressionParserRuleCall_3_0_0(), elementAccess.getRule(), XSET_LITERAL__ELEMENTS, null);
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
                    	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXSetLiteral13467,  elementAccess.getCommaKeyword_3_1_0())) { return current; }


                    	    {

                    	    {
                    	    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXSetLiteral13488, current, elementAccess.getElementsXExpressionParserRuleCall_3_1_1_0(), elementAccess.getRule(), XSET_LITERAL__ELEMENTS, null);
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
            if (!consumeUnassignedToken(34, FOLLOW_34_in_ruleXSetLiteral13504,  elementAccess.getRightCurlyBracketKeyword_4())) { return current; }

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
            pushFollow(FOLLOW_ruleXListLiteral_in_entryRuleXListLiteral13546);
            iv_ruleXListLiteral=ruleXListLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXListLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXListLiteral13556); if (state.failed) return current;
            }
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
            if (!consumeUnassignedToken(69, FOLLOW_69_in_ruleXListLiteral13602,  elementAccess.getNumberSignKeyword_1())) { return current; }

            if (!consumeUnassignedToken(70, FOLLOW_70_in_ruleXListLiteral13614,  elementAccess.getLeftSquareBracketKeyword_2())) { return current; }

            int alt139=2;
            int LA139_0 = input.LA(1);
            if ( ((LA139_0>=RULE_ID && LA139_0<=RULE_RICH_TEXT_START)||(LA139_0>=RULE_HEX && LA139_0<=RULE_DECIMAL)||LA139_0==25||(LA139_0>=27 && LA139_0<=28)||(LA139_0>=31 && LA139_0<=33)||(LA139_0>=35 && LA139_0<=37)||(LA139_0>=39 && LA139_0<=40)||(LA139_0>=42 && LA139_0<=50)||(LA139_0>=53 && LA139_0<=55)||LA139_0==57||(LA139_0>=69 && LA139_0<=70)||(LA139_0>=90 && LA139_0<=91)||LA139_0==96||LA139_0==102||LA139_0==104||(LA139_0>=107 && LA139_0<=117)) ) {
                alt139=1;
            }
            switch (alt139) {
                case 1 :
                    {

                    {

                    {
                    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXListLiteral13636, current, elementAccess.getElementsXExpressionParserRuleCall_3_0_0(), elementAccess.getRule(), XLIST_LITERAL__ELEMENTS, null);
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
                    	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXListLiteral13649,  elementAccess.getCommaKeyword_3_1_0())) { return current; }


                    	    {

                    	    {
                    	    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXListLiteral13670, current, elementAccess.getElementsXExpressionParserRuleCall_3_1_1_0(), elementAccess.getRule(), XLIST_LITERAL__ELEMENTS, null);
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
            if (!consumeUnassignedToken(71, FOLLOW_71_in_ruleXListLiteral13686,  elementAccess.getRightSquareBracketKeyword_4())) { return current; }

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
            pushFollow(FOLLOW_ruleXClosure_in_entryRuleXClosure13728);
            iv_ruleXClosure=ruleXClosure();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXClosure13738); if (state.failed) return current;
            }
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
            if (!consumeUnassignedToken(70, FOLLOW_70_in_ruleXClosure13798,  elementAccess.getLeftSquareBracketKeyword_0_0_1())) { return current; }

            }
            }
            int alt142=2;
            alt142 = dfa142.predict(input);
            switch (alt142) {
                case 1 :
                    {

                    {
                    int alt141=2;
                    int LA141_0 = input.LA(1);
                    if ( (LA141_0==RULE_ID||LA141_0==37||(LA141_0>=39 && LA141_0<=40)||LA141_0==55||LA141_0==86) ) {
                        alt141=1;
                    }
                    switch (alt141) {
                        case 1 :
                            {

                            {

                            {
                            current = callRuleJvmFormalParameterAndAdd(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure13871, current, elementAccess.getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0(), elementAccess.getRule(), XCLOSURE__DECLARED_FORMAL_PARAMETERS, null);
                            if (state.failed) return current;

                            }
                            }
                            loop140:
                            do {
                                int alt140=2;
                                int LA140_0 = input.LA(1);
                                if ( (LA140_0==29) ) {
                                    alt140=1;
                                }
                                switch (alt140) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXClosure13884,  elementAccess.getCommaKeyword_1_0_0_1_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleJvmFormalParameterAndAdd(FOLLOW_ruleJvmFormalParameter_in_ruleXClosure13905, current, elementAccess.getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0(), elementAccess.getRule(), XCLOSURE__DECLARED_FORMAL_PARAMETERS, null);
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop140;
                                }
                            } while (true);
                            }
                            break;
                    }

                    {

                    {
                    current = consumeTokenAndSetBooleanValue(101, FOLLOW_101_in_ruleXClosure13927, current,  elementAccess.getExplicitSyntaxVerticalLineKeyword_1_0_1_0(), elementAccess.getRule(), XCLOSURE__EXPLICIT_SYNTAX);
                    if (state.failed) return current;

                    }
                    }
                    }
                    }
                    break;
            }

            {

            {
            current = callRuleXExpressionInClosureAndSet(FOLLOW_ruleXExpressionInClosure_in_ruleXClosure13964, current, elementAccess.getExpressionXExpressionInClosureParserRuleCall_2_0(), elementAccess.getRule(), XCLOSURE__EXPRESSION, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(71, FOLLOW_71_in_ruleXClosure13976,  elementAccess.getRightSquareBracketKeyword_3())) { return current; }

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
            pushFollow(FOLLOW_ruleXExpressionInClosure_in_entryRuleXExpressionInClosure14018);
            iv_ruleXExpressionInClosure=ruleXExpressionInClosure();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInClosure14028); if (state.failed) return current;
            }
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
            loop144:
            do {
                int alt144=2;
                int LA144_0 = input.LA(1);
                if ( ((LA144_0>=RULE_ID && LA144_0<=RULE_RICH_TEXT_START)||(LA144_0>=RULE_HEX && LA144_0<=RULE_DECIMAL)||LA144_0==25||(LA144_0>=27 && LA144_0<=28)||(LA144_0>=31 && LA144_0<=33)||(LA144_0>=35 && LA144_0<=37)||(LA144_0>=39 && LA144_0<=40)||(LA144_0>=42 && LA144_0<=55)||LA144_0==57||(LA144_0>=69 && LA144_0<=70)||(LA144_0>=90 && LA144_0<=91)||LA144_0==96||LA144_0==102||LA144_0==104||(LA144_0>=107 && LA144_0<=117)) ) {
                    alt144=1;
                }
                switch (alt144) {
            	case 1 :
            	    {

            	    {

            	    {
            	    current = callRuleXExpressionInsideBlockAndAdd(FOLLOW_ruleXExpressionInsideBlock_in_ruleXExpressionInClosure14084, current, elementAccess.getExpressionsXExpressionInsideBlockParserRuleCall_1_0_0(), elementAccess.getRule(), XBLOCK_EXPRESSION__EXPRESSIONS, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    int alt143=2;
            	    int LA143_0 = input.LA(1);
            	    if ( (LA143_0==26) ) {
            	        alt143=1;
            	    }
            	    switch (alt143) {
            	        case 1 :
            	            {
            	            if (!consumeUnassignedToken(26, FOLLOW_26_in_ruleXExpressionInClosure14097,  elementAccess.getSemicolonKeyword_1_1())) { return current; }

            	            }
            	            break;
            	    }
            	    }
            	    break;
            	default :
            	    break loop144;
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
            pushFollow(FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure14143);
            iv_ruleXShortClosure=ruleXShortClosure();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXShortClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXShortClosure14153); if (state.failed) return current;
            }
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
            int alt146=2;
            int LA146_0 = input.LA(1);
            if ( (LA146_0==RULE_ID||LA146_0==37||(LA146_0>=39 && LA146_0<=40)||LA146_0==55||LA146_0==86) ) {
                alt146=1;
            }
            switch (alt146) {
                case 1 :
                    {

                    {

                    {
                    current = callRuleJvmFormalParameterAndAdd(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure14261, current, elementAccess.getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0(), elementAccess.getRule(), XCLOSURE__DECLARED_FORMAL_PARAMETERS, null);
                    if (state.failed) return current;

                    }
                    }
                    loop145:
                    do {
                        int alt145=2;
                        int LA145_0 = input.LA(1);
                        if ( (LA145_0==29) ) {
                            alt145=1;
                        }
                        switch (alt145) {
                    	case 1 :
                    	    {
                    	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXShortClosure14274,  elementAccess.getCommaKeyword_0_0_1_1_0())) { return current; }


                    	    {

                    	    {
                    	    current = callRuleJvmFormalParameterAndAdd(FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure14295, current, elementAccess.getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0(), elementAccess.getRule(), XCLOSURE__DECLARED_FORMAL_PARAMETERS, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop145;
                        }
                    } while (true);
                    }
                    break;
            }

            {

            {
            current = consumeTokenAndSetBooleanValue(101, FOLLOW_101_in_ruleXShortClosure14317, current,  elementAccess.getExplicitSyntaxVerticalLineKeyword_0_0_2_0(), elementAccess.getRule(), XCLOSURE__EXPLICIT_SYNTAX);
            if (state.failed) return current;

            }
            }
            }
            }

            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXShortClosure14353, current, elementAccess.getExpressionXExpressionParserRuleCall_1_0(), elementAccess.getRule(), XCLOSURE__EXPRESSION, null);
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
            pushFollow(FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression14395);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXParenthesizedExpression14405); if (state.failed) return current;
            }
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
            if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleXParenthesizedExpression14442,  elementAccess.getLeftParenthesisKeyword_0())) { return current; }

            current = callUnassignedRuleXExpression(FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression14464, elementAccess.getXExpressionParserRuleCall_1());
            if (state.failed) return current;

            if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXParenthesizedExpression14475,  elementAccess.getRightParenthesisKeyword_2())) { return current; }

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
            pushFollow(FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression14517);
            iv_ruleXIfExpression=ruleXIfExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXIfExpression14527); if (state.failed) return current;
            }
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
            if (!consumeUnassignedToken(102, FOLLOW_102_in_ruleXIfExpression14573,  elementAccess.getIfKeyword_1())) { return current; }

            if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleXIfExpression14585,  elementAccess.getLeftParenthesisKeyword_2())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXIfExpression14606, current, elementAccess.getIfXExpressionParserRuleCall_3_0(), elementAccess.getRule(), XIF_EXPRESSION__IF, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXIfExpression14618,  elementAccess.getRightParenthesisKeyword_4())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXIfExpression14639, current, elementAccess.getThenXExpressionParserRuleCall_5_0(), elementAccess.getRule(), XIF_EXPRESSION__THEN, null);
            if (state.failed) return current;

            }
            }
            int alt147=2;
            int LA147_0 = input.LA(1);
            if ( (LA147_0==103) ) {
                int LA147_1 = input.LA(2);
                if ( (synpred32_InternalXtend()) ) {
                    alt147=1;
                }
            }
            switch (alt147) {
                case 1 :
                    {

                    {
                    if (!consumeUnassignedToken(103, FOLLOW_103_in_ruleXIfExpression14660,  elementAccess.getElseKeyword_6_0())) { return current; }

                    }

                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXIfExpression14682, current, elementAccess.getElseXExpressionParserRuleCall_6_1_0(), elementAccess.getRule(), XIF_EXPRESSION__ELSE, null);
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
            pushFollow(FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression14726);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXSwitchExpression14736); if (state.failed) return current;
            }
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
            if (!consumeUnassignedToken(104, FOLLOW_104_in_ruleXSwitchExpression14782,  elementAccess.getSwitchKeyword_1())) { return current; }

            int alt149=2;
            int LA149_0 = input.LA(1);
            if ( ((LA149_0>=RULE_ID && LA149_0<=RULE_RICH_TEXT_START)||(LA149_0>=RULE_HEX && LA149_0<=RULE_DECIMAL)||LA149_0==25||(LA149_0>=27 && LA149_0<=28)||(LA149_0>=31 && LA149_0<=33)||(LA149_0>=35 && LA149_0<=37)||LA149_0==39||(LA149_0>=42 && LA149_0<=50)||(LA149_0>=53 && LA149_0<=55)||LA149_0==57||(LA149_0>=69 && LA149_0<=70)||(LA149_0>=90 && LA149_0<=91)||LA149_0==96||LA149_0==102||LA149_0==104||(LA149_0>=107 && LA149_0<=117)) ) {
                alt149=1;
            }
            else if ( (LA149_0==40) ) {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    int LA149_3 = input.LA(3);
                    if ( (LA149_3==56) && (synpred34_InternalXtend())) {
                        alt149=2;
                    }
                    else if ( (LA149_3==28||LA149_3==30||LA149_3==38||(LA149_3>=40 && LA149_3<=41)||LA149_3==70||(LA149_3>=72 && LA149_3<=95)||(LA149_3>=97 && LA149_3<=100)) ) {
                        alt149=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 149, 3, input);
                        throw nvae;
                    }
                    }
                    break;
                case 55:
                    {
                    int LA149_4 = input.LA(3);
                    if ( (LA149_4==28||LA149_4==30||LA149_4==38||(LA149_4>=40 && LA149_4<=41)||LA149_4==70||(LA149_4>=72 && LA149_4<=95)||(LA149_4>=97 && LA149_4<=100)) ) {
                        alt149=1;
                    }
                    else if ( (LA149_4==56) && (synpred34_InternalXtend())) {
                        alt149=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 149, 4, input);
                        throw nvae;
                    }
                    }
                    break;
                case 37:
                    {
                    int LA149_5 = input.LA(3);
                    if ( (LA149_5==28||LA149_5==30||LA149_5==38||(LA149_5>=40 && LA149_5<=41)||LA149_5==70||(LA149_5>=72 && LA149_5<=95)||(LA149_5>=97 && LA149_5<=100)) ) {
                        alt149=1;
                    }
                    else if ( (LA149_5==56) && (synpred34_InternalXtend())) {
                        alt149=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 149, 5, input);
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
                    alt149=1;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 149, 2, input);
                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 149, 0, input);
                throw nvae;
            }
            switch (alt149) {
                case 1 :
                    {

                    {
                    int alt148=2;
                    switch ( input.LA(1) ) {
                        case RULE_ID:
                            {
                            int LA148_1 = input.LA(2);
                            if ( (LA148_1==56) && (synpred33_InternalXtend())) {
                                alt148=1;
                            }
                            }
                            break;
                        case 55:
                            {
                            int LA148_2 = input.LA(2);
                            if ( (LA148_2==56) && (synpred33_InternalXtend())) {
                                alt148=1;
                            }
                            }
                            break;
                        case 37:
                            {
                            int LA148_3 = input.LA(2);
                            if ( (LA148_3==56) && (synpred33_InternalXtend())) {
                                alt148=1;
                            }
                            }
                            break;
                    }
                    switch (alt148) {
                        case 1 :
                            {

                            {

                            {

                            {
                            current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleXSwitchExpression14825, current, elementAccess.getLocalVarNameValidIDParserRuleCall_2_0_0_0_0_0(), elementAccess.getRule(), XSWITCH_EXPRESSION__LOCAL_VAR_NAME, "ValidID");
                            if (state.failed) return current;

                            }
                            }
                            if (!consumeUnassignedToken(56, FOLLOW_56_in_ruleXSwitchExpression14837,  elementAccess.getColonKeyword_2_0_0_0_1())) { return current; }

                            }
                            }
                            break;
                    }

                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXSwitchExpression14861, current, elementAccess.getSwitchXExpressionParserRuleCall_2_0_1_0(), elementAccess.getRule(), XSWITCH_EXPRESSION__SWITCH, null);
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
                    if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleXSwitchExpression14905,  elementAccess.getLeftParenthesisKeyword_2_1_0_0_0())) { return current; }


                    {

                    {
                    current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleXSwitchExpression14926, current, elementAccess.getLocalVarNameValidIDParserRuleCall_2_1_0_0_1_0(), elementAccess.getRule(), XSWITCH_EXPRESSION__LOCAL_VAR_NAME, "ValidID");
                    if (state.failed) return current;

                    }
                    }
                    if (!consumeUnassignedToken(56, FOLLOW_56_in_ruleXSwitchExpression14938,  elementAccess.getColonKeyword_2_1_0_0_2())) { return current; }

                    }
                    }

                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXSwitchExpression14961, current, elementAccess.getSwitchXExpressionParserRuleCall_2_1_1_0(), elementAccess.getRule(), XSWITCH_EXPRESSION__SWITCH, null);
                    if (state.failed) return current;

                    }
                    }
                    if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXSwitchExpression14973,  elementAccess.getRightParenthesisKeyword_2_1_2())) { return current; }

                    }
                    }
                    break;
            }
            if (!consumeUnassignedToken(33, FOLLOW_33_in_ruleXSwitchExpression14987,  elementAccess.getLeftCurlyBracketKeyword_3())) { return current; }

            int cnt150=0;
            loop150:
            do {
                int alt150=2;
                int LA150_0 = input.LA(1);
                if ( (LA150_0==RULE_ID||LA150_0==37||LA150_0==40||(LA150_0>=55 && LA150_0<=56)||LA150_0==86||LA150_0==106) ) {
                    alt150=1;
                }
                switch (alt150) {
            	case 1 :
            	    {

            	    {
            	    current = callRuleXCasePartAndAdd(FOLLOW_ruleXCasePart_in_ruleXSwitchExpression15008, current, elementAccess.getCasesXCasePartParserRuleCall_4_0(), elementAccess.getRule(), XSWITCH_EXPRESSION__CASES, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    break;
            	default :
            	    if ( cnt150 >= 1 ) break loop150;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(150, input);
                        throw eee;
                }
                cnt150++;
            } while (true);
            int alt151=2;
            int LA151_0 = input.LA(1);
            if ( (LA151_0==105) ) {
                alt151=1;
            }
            switch (alt151) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(105, FOLLOW_105_in_ruleXSwitchExpression15022,  elementAccess.getDefaultKeyword_5_0())) { return current; }

                    if (!consumeUnassignedToken(56, FOLLOW_56_in_ruleXSwitchExpression15034,  elementAccess.getColonKeyword_5_1())) { return current; }


                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXSwitchExpression15055, current, elementAccess.getDefaultXExpressionParserRuleCall_5_2_0(), elementAccess.getRule(), XSWITCH_EXPRESSION__DEFAULT, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    break;
            }
            if (!consumeUnassignedToken(34, FOLLOW_34_in_ruleXSwitchExpression15069,  elementAccess.getRightCurlyBracketKeyword_6())) { return current; }

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
            pushFollow(FOLLOW_ruleXCasePart_in_entryRuleXCasePart15111);
            iv_ruleXCasePart=ruleXCasePart();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCasePart15121); if (state.failed) return current;
            }
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
            int alt152=2;
            int LA152_0 = input.LA(1);
            if ( (LA152_0==RULE_ID||LA152_0==37||LA152_0==40||LA152_0==55||LA152_0==86) ) {
                alt152=1;
            }
            switch (alt152) {
                case 1 :
                    {

                    {
                    current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleXCasePart15167, current, elementAccess.getTypeGuardJvmTypeReferenceParserRuleCall_0_0(), elementAccess.getRule(), XCASE_PART__TYPE_GUARD, null);
                    if (state.failed) return current;

                    }
                    }
                    break;
            }
            int alt153=2;
            int LA153_0 = input.LA(1);
            if ( (LA153_0==106) ) {
                alt153=1;
            }
            switch (alt153) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(106, FOLLOW_106_in_ruleXCasePart15181,  elementAccess.getCaseKeyword_1_0())) { return current; }


                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXCasePart15202, current, elementAccess.getCaseXExpressionParserRuleCall_1_1_0(), elementAccess.getRule(), XCASE_PART__CASE, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    break;
            }
            if (!consumeUnassignedToken(56, FOLLOW_56_in_ruleXCasePart15216,  elementAccess.getColonKeyword_2())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXCasePart15237, current, elementAccess.getThenXExpressionParserRuleCall_3_0(), elementAccess.getRule(), XCASE_PART__THEN, null);
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
            pushFollow(FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression15279);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXForLoopExpression15289); if (state.failed) return current;
            }
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
            if (!consumeUnassignedToken(107, FOLLOW_107_in_ruleXForLoopExpression15335,  elementAccess.getForKeyword_1())) { return current; }

            if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleXForLoopExpression15347,  elementAccess.getLeftParenthesisKeyword_2())) { return current; }


            {

            {
            current = callRuleJvmFormalParameterAndSet(FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression15368, current, elementAccess.getDeclaredParamJvmFormalParameterParserRuleCall_3_0(), elementAccess.getRule(), XFOR_LOOP_EXPRESSION__DECLARED_PARAM, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(56, FOLLOW_56_in_ruleXForLoopExpression15380,  elementAccess.getColonKeyword_4())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXForLoopExpression15401, current, elementAccess.getForExpressionXExpressionParserRuleCall_5_0(), elementAccess.getRule(), XFOR_LOOP_EXPRESSION__FOR_EXPRESSION, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXForLoopExpression15413,  elementAccess.getRightParenthesisKeyword_6())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXForLoopExpression15434, current, elementAccess.getEachExpressionXExpressionParserRuleCall_7_0(), elementAccess.getRule(), XFOR_LOOP_EXPRESSION__EACH_EXPRESSION, null);
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
            pushFollow(FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression15476);
            iv_ruleXWhileExpression=ruleXWhileExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXWhileExpression15486); if (state.failed) return current;
            }
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
            if (!consumeUnassignedToken(108, FOLLOW_108_in_ruleXWhileExpression15532,  elementAccess.getWhileKeyword_1())) { return current; }

            if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleXWhileExpression15544,  elementAccess.getLeftParenthesisKeyword_2())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXWhileExpression15565, current, elementAccess.getPredicateXExpressionParserRuleCall_3_0(), elementAccess.getRule(), XWHILE_EXPRESSION__PREDICATE, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXWhileExpression15577,  elementAccess.getRightParenthesisKeyword_4())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXWhileExpression15598, current, elementAccess.getBodyXExpressionParserRuleCall_5_0(), elementAccess.getRule(), XWHILE_EXPRESSION__BODY, null);
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
            pushFollow(FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression15640);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXDoWhileExpression15650); if (state.failed) return current;
            }
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
            if (!consumeUnassignedToken(109, FOLLOW_109_in_ruleXDoWhileExpression15696,  elementAccess.getDoKeyword_1())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression15717, current, elementAccess.getBodyXExpressionParserRuleCall_2_0(), elementAccess.getRule(), XDO_WHILE_EXPRESSION__BODY, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(108, FOLLOW_108_in_ruleXDoWhileExpression15729,  elementAccess.getWhileKeyword_3())) { return current; }

            if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleXDoWhileExpression15741,  elementAccess.getLeftParenthesisKeyword_4())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXDoWhileExpression15762, current, elementAccess.getPredicateXExpressionParserRuleCall_5_0(), elementAccess.getRule(), XDO_WHILE_EXPRESSION__PREDICATE, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXDoWhileExpression15774,  elementAccess.getRightParenthesisKeyword_6())) { return current; }

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
            pushFollow(FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression15816);
            iv_ruleXBlockExpression=ruleXBlockExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBlockExpression15826); if (state.failed) return current;
            }
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
            if (!consumeUnassignedToken(33, FOLLOW_33_in_ruleXBlockExpression15872,  elementAccess.getLeftCurlyBracketKeyword_1())) { return current; }

            loop155:
            do {
                int alt155=2;
                int LA155_0 = input.LA(1);
                if ( ((LA155_0>=RULE_ID && LA155_0<=RULE_RICH_TEXT_START)||(LA155_0>=RULE_HEX && LA155_0<=RULE_DECIMAL)||LA155_0==25||(LA155_0>=27 && LA155_0<=28)||(LA155_0>=31 && LA155_0<=33)||(LA155_0>=35 && LA155_0<=37)||(LA155_0>=39 && LA155_0<=40)||(LA155_0>=42 && LA155_0<=55)||LA155_0==57||(LA155_0>=69 && LA155_0<=70)||(LA155_0>=90 && LA155_0<=91)||LA155_0==96||LA155_0==102||LA155_0==104||(LA155_0>=107 && LA155_0<=117)) ) {
                    alt155=1;
                }
                switch (alt155) {
            	case 1 :
            	    {

            	    {

            	    {
            	    current = callRuleXExpressionInsideBlockAndAdd(FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression15894, current, elementAccess.getExpressionsXExpressionInsideBlockParserRuleCall_2_0_0(), elementAccess.getRule(), XBLOCK_EXPRESSION__EXPRESSIONS, null);
            	    if (state.failed) return current;

            	    }
            	    }
            	    int alt154=2;
            	    int LA154_0 = input.LA(1);
            	    if ( (LA154_0==26) ) {
            	        alt154=1;
            	    }
            	    switch (alt154) {
            	        case 1 :
            	            {
            	            if (!consumeUnassignedToken(26, FOLLOW_26_in_ruleXBlockExpression15907,  elementAccess.getSemicolonKeyword_2_1())) { return current; }

            	            }
            	            break;
            	    }
            	    }
            	    break;
            	default :
            	    break loop155;
                }
            } while (true);
            if (!consumeUnassignedToken(34, FOLLOW_34_in_ruleXBlockExpression15923,  elementAccess.getRightCurlyBracketKeyword_3())) { return current; }

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
            pushFollow(FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock15965);
            iv_ruleXExpressionInsideBlock=ruleXExpressionInsideBlock();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInsideBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExpressionInsideBlock15975); if (state.failed) return current;
            }
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
            int alt156=2;
            int LA156_0 = input.LA(1);
            if ( (LA156_0==52) && (synpred35_InternalXtend())) {
                alt156=1;
            }
            else if ( (LA156_0==51) && (synpred35_InternalXtend())) {
                alt156=1;
            }
            else if ( (LA156_0==39) ) {
                switch ( input.LA(2) ) {
                case 52:
                    {
                    int LA156_5 = input.LA(3);
                    if ( (synpred35_InternalXtend()) ) {
                        alt156=1;
                    }
                    else if ( (true) ) {
                        alt156=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 156, 5, input);
                        throw nvae;
                    }
                    }
                    break;
                case 51:
                    {
                    int LA156_6 = input.LA(3);
                    if ( (synpred35_InternalXtend()) ) {
                        alt156=1;
                    }
                    else if ( (true) ) {
                        alt156=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 156, 6, input);
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
                    alt156=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 156, 3, input);
                    throw nvae;
                }
            }
            else if ( ((LA156_0>=RULE_ID && LA156_0<=RULE_RICH_TEXT_START)||(LA156_0>=RULE_HEX && LA156_0<=RULE_DECIMAL)||LA156_0==25||(LA156_0>=27 && LA156_0<=28)||(LA156_0>=31 && LA156_0<=33)||(LA156_0>=35 && LA156_0<=37)||LA156_0==40||(LA156_0>=42 && LA156_0<=50)||(LA156_0>=53 && LA156_0<=55)||LA156_0==57||(LA156_0>=69 && LA156_0<=70)||(LA156_0>=90 && LA156_0<=91)||LA156_0==96||LA156_0==102||LA156_0==104||(LA156_0>=107 && LA156_0<=117)) ) {
                alt156=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 156, 0, input);
                throw nvae;
            }
            switch (alt156) {
                case 1 :
                    {

                    {
                    current = callUnassignedRuleXVariableDeclaration(FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock16124, elementAccess.getXVariableDeclarationParserRuleCall_0());
                    if (state.failed) return current;

                    }
                    }
                    break;
                case 2 :
                    {
                    current = callUnassignedRuleXExpression(FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock16152, elementAccess.getXExpressionParserRuleCall_1());
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
            pushFollow(FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall16193);
            iv_ruleXFeatureCall=ruleXFeatureCall();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFeatureCall16203); if (state.failed) return current;
            }
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
            int alt158=2;
            int LA158_0 = input.LA(1);
            if ( (LA158_0==28) ) {
                alt158=1;
            }
            switch (alt158) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(28, FOLLOW_28_in_ruleXFeatureCall16250,  elementAccess.getLessThanSignKeyword_1_0())) { return current; }


                    {

                    {
                    current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall16271, current, elementAccess.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0(), elementAccess.getRule(), XFEATURE_CALL__TYPE_ARGUMENTS, null);
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
                    	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXFeatureCall16284,  elementAccess.getCommaKeyword_1_2_0())) { return current; }


                    	    {

                    	    {
                    	    current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall16305, current, elementAccess.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0(), elementAccess.getRule(), XFEATURE_CALL__TYPE_ARGUMENTS, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop157;
                        }
                    } while (true);
                    if (!consumeUnassignedToken(30, FOLLOW_30_in_ruleXFeatureCall16319,  elementAccess.getGreaterThanSignKeyword_1_3())) { return current; }

                    }
                    break;
            }

            {

            {
            current = callRuleIdOrSuper(FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall16344, current, elementAccess.getFeatureJvmIdentifiableElementCrossReference_2_0(), elementAccess.getRule());
            if (state.failed) return current;

            }
            }
            int alt161=2;
            alt161 = dfa161.predict(input);
            switch (alt161) {
                case 1 :
                    {

                    {

                    {
                    current = consumeTokenAndSetBooleanValue(40, FOLLOW_40_in_ruleXFeatureCall16378, current,  elementAccess.getExplicitOperationCallLeftParenthesisKeyword_3_0_0(), elementAccess.getRule(), XFEATURE_CALL__EXPLICIT_OPERATION_CALL);
                    if (state.failed) return current;

                    }
                    }
                    int alt160=3;
                    alt160 = dfa160.predict(input);
                    switch (alt160) {
                        case 1 :
                            {

                            {

                            {
                            current = callRuleXShortClosureAndAdd(FOLLOW_ruleXShortClosure_in_ruleXFeatureCall16463, current, elementAccess.getFeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0(), elementAccess.getRule(), XFEATURE_CALL__FEATURE_CALL_ARGUMENTS, null);
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
                            current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXFeatureCall16491, current, elementAccess.getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0(), elementAccess.getRule(), XFEATURE_CALL__FEATURE_CALL_ARGUMENTS, null);
                            if (state.failed) return current;

                            }
                            }
                            loop159:
                            do {
                                int alt159=2;
                                int LA159_0 = input.LA(1);
                                if ( (LA159_0==29) ) {
                                    alt159=1;
                                }
                                switch (alt159) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXFeatureCall16504,  elementAccess.getCommaKeyword_3_1_1_1_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXFeatureCall16525, current, elementAccess.getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0(), elementAccess.getRule(), XFEATURE_CALL__FEATURE_CALL_ARGUMENTS, null);
                            	    if (state.failed) return current;

                            	    }
                            	    }
                            	    }
                            	    break;
                            	default :
                            	    break loop159;
                                }
                            } while (true);
                            }
                            }
                            break;
                    }
                    if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXFeatureCall16542,  elementAccess.getRightParenthesisKeyword_3_2())) { return current; }

                    }
                    break;
            }
            int alt162=2;
            alt162 = dfa162.predict(input);
            switch (alt162) {
                case 1 :
                    {

                    {
                    current = callRuleXClosureAndAdd(FOLLOW_ruleXClosure_in_ruleXFeatureCall16577, current, elementAccess.getFeatureCallArgumentsXClosureParserRuleCall_4_0(), elementAccess.getRule(), XFEATURE_CALL__FEATURE_CALL_ARGUMENTS, null);
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
            pushFollow(FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper16621);
            iv_ruleIdOrSuper=ruleIdOrSuper();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrSuper.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdOrSuper16632); if (state.failed) return current;
            }
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
            int alt163=2;
            int LA163_0 = input.LA(1);
            if ( (LA163_0==RULE_ID||LA163_0==25||LA163_0==27||(LA163_0>=31 && LA163_0<=32)||(LA163_0>=35 && LA163_0<=37)||LA163_0==39||LA163_0==42||(LA163_0>=44 && LA163_0<=50)||(LA163_0>=53 && LA163_0<=55)||LA163_0==57) ) {
                alt163=1;
            }
            else if ( (LA163_0==110) ) {
                alt163=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 163, 0, input);
                throw nvae;
            }
            switch (alt163) {
                case 1 :
                    {
                    callRuleFeatureCallID(FOLLOW_ruleFeatureCallID_in_ruleIdOrSuper16679, current, elementAccess.getFeatureCallIDParserRuleCall_0());
                    if (state.failed) return current;

                    }
                    break;
                case 2 :
                    {
                    if (!consumeTokenAndMerge(110, FOLLOW_110_in_ruleIdOrSuper16703, current,  elementAccess.getSuperKeyword_1())) { return current; }

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
            pushFollow(FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall16749);
            iv_ruleXConstructorCall=ruleXConstructorCall();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXConstructorCall16759); if (state.failed) return current;
            }
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
            if (!consumeUnassignedToken(43, FOLLOW_43_in_ruleXConstructorCall16805,  elementAccess.getNewKeyword_1())) { return current; }


            {

            {
            current = callRuleQualifiedName(FOLLOW_ruleQualifiedName_in_ruleXConstructorCall16828, current, elementAccess.getConstructorJvmConstructorCrossReference_2_0(), elementAccess.getRule());
            if (state.failed) return current;

            }
            }
            int alt165=2;
            alt165 = dfa165.predict(input);
            switch (alt165) {
                case 1 :
                    {

                    {
                    if (!consumeUnassignedToken(28, FOLLOW_28_in_ruleXConstructorCall16849,  elementAccess.getLessThanSignKeyword_3_0())) { return current; }

                    }

                    {

                    {
                    current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall16871, current, elementAccess.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0(), elementAccess.getRule(), XCONSTRUCTOR_CALL__TYPE_ARGUMENTS, null);
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
                    	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXConstructorCall16884,  elementAccess.getCommaKeyword_3_2_0())) { return current; }


                    	    {

                    	    {
                    	    current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall16905, current, elementAccess.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0(), elementAccess.getRule(), XCONSTRUCTOR_CALL__TYPE_ARGUMENTS, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop164;
                        }
                    } while (true);
                    if (!consumeUnassignedToken(30, FOLLOW_30_in_ruleXConstructorCall16919,  elementAccess.getGreaterThanSignKeyword_3_3())) { return current; }

                    }
                    break;
            }
            int alt168=2;
            alt168 = dfa168.predict(input);
            switch (alt168) {
                case 1 :
                    {

                    {
                    if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleXConstructorCall16942,  elementAccess.getLeftParenthesisKeyword_4_0())) { return current; }

                    }
                    int alt167=3;
                    alt167 = dfa167.predict(input);
                    switch (alt167) {
                        case 1 :
                            {

                            {

                            {
                            current = callRuleXShortClosureAndAdd(FOLLOW_ruleXShortClosure_in_ruleXConstructorCall17015, current, elementAccess.getArgumentsXShortClosureParserRuleCall_4_1_0_0(), elementAccess.getRule(), XCONSTRUCTOR_CALL__ARGUMENTS, null);
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
                            current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXConstructorCall17043, current, elementAccess.getArgumentsXExpressionParserRuleCall_4_1_1_0_0(), elementAccess.getRule(), XCONSTRUCTOR_CALL__ARGUMENTS, null);
                            if (state.failed) return current;

                            }
                            }
                            loop166:
                            do {
                                int alt166=2;
                                int LA166_0 = input.LA(1);
                                if ( (LA166_0==29) ) {
                                    alt166=1;
                                }
                                switch (alt166) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXConstructorCall17056,  elementAccess.getCommaKeyword_4_1_1_1_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleXExpressionAndAdd(FOLLOW_ruleXExpression_in_ruleXConstructorCall17077, current, elementAccess.getArgumentsXExpressionParserRuleCall_4_1_1_1_1_0(), elementAccess.getRule(), XCONSTRUCTOR_CALL__ARGUMENTS, null);
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
                    if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXConstructorCall17094,  elementAccess.getRightParenthesisKeyword_4_2())) { return current; }

                    }
                    break;
            }
            int alt169=2;
            alt169 = dfa169.predict(input);
            switch (alt169) {
                case 1 :
                    {

                    {
                    current = callRuleXClosureAndAdd(FOLLOW_ruleXClosure_in_ruleXConstructorCall17129, current, elementAccess.getArgumentsXClosureParserRuleCall_5_0(), elementAccess.getRule(), XCONSTRUCTOR_CALL__ARGUMENTS, null);
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
            pushFollow(FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral17172);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXBooleanLiteral17182); if (state.failed) return current;
            }
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
            if ( (LA170_0==111) ) {
                alt170=1;
            }
            else if ( (LA170_0==112) ) {
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
                    if (!consumeUnassignedToken(111, FOLLOW_111_in_ruleXBooleanLiteral17229,  elementAccess.getFalseKeyword_1_0())) { return current; }

                    }
                    break;
                case 2 :
                    {

                    {

                    {
                    current = consumeTokenAndSetBooleanValue(112, FOLLOW_112_in_ruleXBooleanLiteral17253, current,  elementAccess.getIsTrueTrueKeyword_1_1_0(), elementAccess.getRule(), XBOOLEAN_LITERAL__IS_TRUE);
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
            pushFollow(FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral17309);
            iv_ruleXNullLiteral=ruleXNullLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNullLiteral17319); if (state.failed) return current;
            }
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
            if (!consumeUnassignedToken(113, FOLLOW_113_in_ruleXNullLiteral17365,  elementAccess.getNullKeyword_1())) { return current; }

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
            pushFollow(FOLLOW_ruleXNumberLiteral_in_entryRuleXNumberLiteral17407);
            iv_ruleXNumberLiteral=ruleXNumberLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNumberLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXNumberLiteral17417); if (state.failed) return current;
            }
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
            current = callRuleNumberAndSet(FOLLOW_ruleNumber_in_ruleXNumberLiteral17472, current, elementAccess.getValueNumberParserRuleCall_1_0(), elementAccess.getRule(), XNUMBER_LITERAL__VALUE, "Number");
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
            pushFollow(FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral17514);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTypeLiteral17524); if (state.failed) return current;
            }
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
            if (!consumeUnassignedToken(114, FOLLOW_114_in_ruleXTypeLiteral17570,  elementAccess.getTypeofKeyword_1())) { return current; }

            if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleXTypeLiteral17582,  elementAccess.getLeftParenthesisKeyword_2())) { return current; }


            {

            {
            current = callRuleQualifiedName(FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral17605, current, elementAccess.getTypeJvmTypeCrossReference_3_0(), elementAccess.getRule());
            if (state.failed) return current;

            }
            }
            loop171:
            do {
                int alt171=2;
                int LA171_0 = input.LA(1);
                if ( (LA171_0==70) ) {
                    alt171=1;
                }
                switch (alt171) {
            	case 1 :
            	    {

            	    {
            	    current = callRuleArrayBracketsAndAdd(FOLLOW_ruleArrayBrackets_in_ruleXTypeLiteral17626, current, elementAccess.getArrayDimensionsArrayBracketsParserRuleCall_4_0(), elementAccess.getRule(), XTYPE_LITERAL__ARRAY_DIMENSIONS, "ArrayBrackets");
            	    if (state.failed) return current;

            	    }
            	    }
            	    break;
            	default :
            	    break loop171;
                }
            } while (true);
            if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXTypeLiteral17639,  elementAccess.getRightParenthesisKeyword_5())) { return current; }

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
            pushFollow(FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression17681);
            iv_ruleXThrowExpression=ruleXThrowExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXThrowExpression17691); if (state.failed) return current;
            }
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
            if (!consumeUnassignedToken(115, FOLLOW_115_in_ruleXThrowExpression17737,  elementAccess.getThrowKeyword_1())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXThrowExpression17758, current, elementAccess.getExpressionXExpressionParserRuleCall_2_0(), elementAccess.getRule(), XTHROW_EXPRESSION__EXPRESSION, null);
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
            pushFollow(FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression17800);
            iv_ruleXReturnExpression=ruleXReturnExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXReturnExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXReturnExpression17810); if (state.failed) return current;
            }
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
            if (!consumeUnassignedToken(116, FOLLOW_116_in_ruleXReturnExpression17856,  elementAccess.getReturnKeyword_1())) { return current; }

            int alt172=2;
            alt172 = dfa172.predict(input);
            switch (alt172) {
                case 1 :
                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXReturnExpression17887, current, elementAccess.getExpressionXExpressionParserRuleCall_2_0(), elementAccess.getRule(), XRETURN_EXPRESSION__EXPRESSION, null);
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
            pushFollow(FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression17930);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression17940); if (state.failed) return current;
            }
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
            if (!consumeUnassignedToken(117, FOLLOW_117_in_ruleXTryCatchFinallyExpression17986,  elementAccess.getTryKeyword_1())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression18007, current, elementAccess.getExpressionXExpressionParserRuleCall_2_0(), elementAccess.getRule(), XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION, null);
            if (state.failed) return current;

            }
            }
            int alt175=2;
            int LA175_0 = input.LA(1);
            if ( (LA175_0==119) ) {
                alt175=1;
            }
            else if ( (LA175_0==118) ) {
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
                        if ( (LA173_0==119) ) {
                            int LA173_2 = input.LA(2);
                            if ( (synpred44_InternalXtend()) ) {
                                alt173=1;
                            }
                        }
                        switch (alt173) {
                    	case 1 :
                    	    {

                    	    {
                    	    current = callRuleXCatchClauseAndAdd(FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression18037, current, elementAccess.getCatchClausesXCatchClauseParserRuleCall_3_0_0_0(), elementAccess.getRule(), XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSES, null);
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
                    if ( (LA174_0==118) ) {
                        int LA174_1 = input.LA(2);
                        if ( (synpred45_InternalXtend()) ) {
                            alt174=1;
                        }
                    }
                    switch (alt174) {
                        case 1 :
                            {

                            {
                            if (!consumeUnassignedToken(118, FOLLOW_118_in_ruleXTryCatchFinallyExpression18059,  elementAccess.getFinallyKeyword_3_0_1_0())) { return current; }

                            }

                            {

                            {
                            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression18081, current, elementAccess.getFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0(), elementAccess.getRule(), XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION, null);
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
                    if (!consumeUnassignedToken(118, FOLLOW_118_in_ruleXTryCatchFinallyExpression18103,  elementAccess.getFinallyKeyword_3_1_0())) { return current; }


                    {

                    {
                    current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression18124, current, elementAccess.getFinallyExpressionXExpressionParserRuleCall_3_1_1_0(), elementAccess.getRule(), XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION, null);
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
            pushFollow(FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause18168);
            iv_ruleXCatchClause=ruleXCatchClause();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXCatchClause18178); if (state.failed) return current;
            }
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
            if (!consumeUnassignedToken(119, FOLLOW_119_in_ruleXCatchClause18223,  elementAccess.getCatchKeyword_0())) { return current; }

            }
            if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleXCatchClause18236,  elementAccess.getLeftParenthesisKeyword_1())) { return current; }


            {

            {
            current = callRuleFullJvmFormalParameterAndSet(FOLLOW_ruleFullJvmFormalParameter_in_ruleXCatchClause18257, current, elementAccess.getDeclaredParamFullJvmFormalParameterParserRuleCall_2_0(), elementAccess.getRule(), XCATCH_CLAUSE__DECLARED_PARAM, null);
            if (state.failed) return current;

            }
            }
            if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXCatchClause18269,  elementAccess.getRightParenthesisKeyword_3())) { return current; }


            {

            {
            current = callRuleXExpressionAndSet(FOLLOW_ruleXExpression_in_ruleXCatchClause18290, current, elementAccess.getExpressionXExpressionParserRuleCall_4_0(), elementAccess.getRule(), XCATCH_CLAUSE__EXPRESSION, null);
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
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName18333);
            iv_ruleQualifiedName=ruleQualifiedName();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName18344); if (state.failed) return current;
            }
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
            callRuleValidID(FOLLOW_ruleValidID_in_ruleQualifiedName18391, current, elementAccess.getValidIDParserRuleCall_0());
            if (state.failed) return current;

            loop176:
            do {
                int alt176=2;
                int LA176_0 = input.LA(1);
                if ( (LA176_0==98) ) {
                    switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA176_3 = input.LA(3);
                        if ( (synpred47_InternalXtend()) ) {
                            alt176=1;
                        }
                        }
                        break;
                    case 37:
                        {
                        int LA176_4 = input.LA(3);
                        if ( (synpred47_InternalXtend()) ) {
                            alt176=1;
                        }
                        }
                        break;
                    case 55:
                        {
                        int LA176_5 = input.LA(3);
                        if ( (synpred47_InternalXtend()) ) {
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
            	    if (!consumeTokenAndMerge(98, FOLLOW_98_in_ruleQualifiedName18419, current,  elementAccess.getFullStopKeyword_1_0())) { return current; }

            	    }
            	    callRuleValidID(FOLLOW_ruleValidID_in_ruleQualifiedName18442, current, elementAccess.getValidIDParserRuleCall_1_1());
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
            pushFollow(FOLLOW_ruleNumber_in_entryRuleNumber18496);
            iv_ruleNumber=ruleNumber();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumber.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumber18507); if (state.failed) return current;
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
                    this_token=(Token)match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleNumber18551); if (state.failed) return current;
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
                            this_token=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNumber18579); if (state.failed) return current;
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
                            this_token=(Token)match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_ruleNumber18605); if (state.failed) return current;
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
                    if ( (LA179_0==98) ) {
                        int LA179_1 = input.LA(2);
                        if ( ((LA179_1>=RULE_INT && LA179_1<=RULE_DECIMAL)) ) {
                            alt179=1;
                        }
                    }
                    switch (alt179) {
                        case 1 :
                            {
                            if (!consumeTokenAndMerge(98, FOLLOW_98_in_ruleNumber18625, current,  elementAccess.getFullStopKeyword_1_1_0())) { return current; }

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
                                    this_token=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNumber18641); if (state.failed) return current;
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
                                    this_token=(Token)match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_ruleNumber18667); if (state.failed) return current;
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
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference18728);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference18738); if (state.failed) return current;
            }
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
            if ( (LA182_0==RULE_ID||LA182_0==37||LA182_0==55) ) {
                alt182=1;
            }
            else if ( (LA182_0==40||LA182_0==86) ) {
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
                    current = callUnassignedRuleJvmParameterizedTypeReference(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference18786, elementAccess.getJvmParameterizedTypeReferenceParserRuleCall_0_0());
                    if (state.failed) return current;

                    loop181:
                    do {
                        int alt181=2;
                        int LA181_0 = input.LA(1);
                        if ( (LA181_0==70) ) {
                            int LA181_2 = input.LA(2);
                            if ( (LA181_2==71) ) {
                                int LA181_3 = input.LA(3);
                                if ( (synpred48_InternalXtend()) ) {
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
                    	    pushFollow(FOLLOW_ruleArrayBrackets_in_ruleJvmTypeReference18822);
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
                    current = callUnassignedRuleXFunctionTypeRef(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference18853, elementAccess.getXFunctionTypeRefParserRuleCall_1());
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
            pushFollow(FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets18895);
            iv_ruleArrayBrackets=ruleArrayBrackets();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayBrackets.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayBrackets18906); if (state.failed) return current;
            }
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
            if (!consumeTokenAndMerge(70, FOLLOW_70_in_ruleArrayBrackets18944, current,  elementAccess.getLeftSquareBracketKeyword_0())) { return current; }

            if (!consumeTokenAndMerge(71, FOLLOW_71_in_ruleArrayBrackets18957, current,  elementAccess.getRightSquareBracketKeyword_1())) { return current; }

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
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef19003);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef19013); if (state.failed) return current;
            }
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
            if ( (LA185_0==40) ) {
                alt185=1;
            }
            switch (alt185) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(40, FOLLOW_40_in_ruleXFunctionTypeRef19051,  elementAccess.getLeftParenthesisKeyword_0_0())) { return current; }

                    int alt184=2;
                    int LA184_0 = input.LA(1);
                    if ( (LA184_0==RULE_ID||LA184_0==37||LA184_0==40||LA184_0==55||LA184_0==86) ) {
                        alt184=1;
                    }
                    switch (alt184) {
                        case 1 :
                            {

                            {

                            {
                            current = callRuleJvmTypeReferenceAndAdd(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef19073, current, elementAccess.getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0(), elementAccess.getRule(), XFUNCTION_TYPE_REF__PARAM_TYPES, null);
                            if (state.failed) return current;

                            }
                            }
                            loop183:
                            do {
                                int alt183=2;
                                int LA183_0 = input.LA(1);
                                if ( (LA183_0==29) ) {
                                    alt183=1;
                                }
                                switch (alt183) {
                            	case 1 :
                            	    {
                            	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleXFunctionTypeRef19086,  elementAccess.getCommaKeyword_0_1_1_0())) { return current; }


                            	    {

                            	    {
                            	    current = callRuleJvmTypeReferenceAndAdd(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef19107, current, elementAccess.getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0(), elementAccess.getRule(), XFUNCTION_TYPE_REF__PARAM_TYPES, null);
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
                    if (!consumeUnassignedToken(41, FOLLOW_41_in_ruleXFunctionTypeRef19123,  elementAccess.getRightParenthesisKeyword_0_2())) { return current; }

                    }
                    break;
            }
            if (!consumeUnassignedToken(86, FOLLOW_86_in_ruleXFunctionTypeRef19137,  elementAccess.getEqualsSignGreaterThanSignKeyword_1())) { return current; }


            {

            {
            current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef19158, current, elementAccess.getReturnTypeJvmTypeReferenceParserRuleCall_2_0(), elementAccess.getRule(), XFUNCTION_TYPE_REF__RETURN_TYPE, null);
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
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference19200);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference19210); if (state.failed) return current;
            }
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
            current = callRuleQualifiedName(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference19258, current, elementAccess.getTypeJvmTypeCrossReference_0_0(), elementAccess.getRule());
            if (state.failed) return current;

            }
            }
            int alt187=2;
            alt187 = dfa187.predict(input);
            switch (alt187) {
                case 1 :
                    {

                    {
                    if (!consumeUnassignedToken(28, FOLLOW_28_in_ruleJvmParameterizedTypeReference19279,  elementAccess.getLessThanSignKeyword_1_0())) { return current; }

                    }

                    {

                    {
                    current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference19301, current, elementAccess.getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0(), elementAccess.getRule(), JVM_PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS, null);
                    if (state.failed) return current;

                    }
                    }
                    loop186:
                    do {
                        int alt186=2;
                        int LA186_0 = input.LA(1);
                        if ( (LA186_0==29) ) {
                            alt186=1;
                        }
                        switch (alt186) {
                    	case 1 :
                    	    {
                    	    if (!consumeUnassignedToken(29, FOLLOW_29_in_ruleJvmParameterizedTypeReference19314,  elementAccess.getCommaKeyword_1_2_0())) { return current; }


                    	    {

                    	    {
                    	    current = callRuleJvmArgumentTypeReferenceAndAdd(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference19335, current, elementAccess.getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0(), elementAccess.getRule(), JVM_PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop186;
                        }
                    } while (true);
                    if (!consumeUnassignedToken(30, FOLLOW_30_in_ruleJvmParameterizedTypeReference19349,  elementAccess.getGreaterThanSignKeyword_1_3())) { return current; }

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
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference19393);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference19403); if (state.failed) return current;
            }
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
            if ( (LA188_0==RULE_ID||LA188_0==37||LA188_0==40||LA188_0==55||LA188_0==86) ) {
                alt188=1;
            }
            else if ( (LA188_0==120) ) {
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
                    current = callUnassignedRuleJvmTypeReference(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference19450, elementAccess.getJvmTypeReferenceParserRuleCall_0());
                    if (state.failed) return current;

                    }
                    break;
                case 2 :
                    {
                    current = callUnassignedRuleJvmWildcardTypeReference(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference19477, elementAccess.getJvmWildcardTypeReferenceParserRuleCall_1());
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
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference19518);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference19528); if (state.failed) return current;
            }
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
            if (!consumeUnassignedToken(120, FOLLOW_120_in_ruleJvmWildcardTypeReference19574,  elementAccess.getQuestionMarkKeyword_1())) { return current; }

            int alt189=3;
            int LA189_0 = input.LA(1);
            if ( (LA189_0==31) ) {
                alt189=1;
            }
            else if ( (LA189_0==110) ) {
                alt189=2;
            }
            switch (alt189) {
                case 1 :
                    {

                    {

                    {
                    current = callRuleJvmUpperBoundAndAdd(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference19596, current, elementAccess.getConstraintsJvmUpperBoundParserRuleCall_2_0_0(), elementAccess.getRule(), JVM_WILDCARD_TYPE_REFERENCE__CONSTRAINTS, null);
                    if (state.failed) return current;

                    }
                    }
                    }
                    break;
                case 2 :
                    {

                    {

                    {
                    current = callRuleJvmLowerBoundAndAdd(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference19623, current, elementAccess.getConstraintsJvmLowerBoundParserRuleCall_2_1_0(), elementAccess.getRule(), JVM_WILDCARD_TYPE_REFERENCE__CONSTRAINTS, null);
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
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound19667);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound19677); if (state.failed) return current;
            }
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
            if (!consumeUnassignedToken(31, FOLLOW_31_in_ruleJvmUpperBound19714,  elementAccess.getExtendsKeyword_0())) { return current; }


            {

            {
            current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound19735, current, elementAccess.getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), elementAccess.getRule(), JVM_UPPER_BOUND__TYPE_REFERENCE, null);
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
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded19777);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded19787); if (state.failed) return current;
            }
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
            if (!consumeUnassignedToken(121, FOLLOW_121_in_ruleJvmUpperBoundAnded19824,  elementAccess.getAmpersandKeyword_0())) { return current; }


            {

            {
            current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded19845, current, elementAccess.getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), elementAccess.getRule(), JVM_UPPER_BOUND__TYPE_REFERENCE, null);
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
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound19887);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound19897); if (state.failed) return current;
            }
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
            if (!consumeUnassignedToken(110, FOLLOW_110_in_ruleJvmLowerBound19934,  elementAccess.getSuperKeyword_0())) { return current; }


            {

            {
            current = callRuleJvmTypeReferenceAndSet(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound19955, current, elementAccess.getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), elementAccess.getRule(), JVM_LOWER_BOUND__TYPE_REFERENCE, null);
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
            pushFollow(FOLLOW_ruleJvmTypeParameter_in_entryRuleJvmTypeParameter19997);
            iv_ruleJvmTypeParameter=ruleJvmTypeParameter();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeParameter20007); if (state.failed) return current;
            }
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
            current = callRuleValidIDAndSet(FOLLOW_ruleValidID_in_ruleJvmTypeParameter20053, current, elementAccess.getNameValidIDParserRuleCall_0_0(), elementAccess.getRule(), JVM_TYPE_PARAMETER__NAME, "ValidID");
            if (state.failed) return current;

            }
            }
            int alt191=2;
            int LA191_0 = input.LA(1);
            if ( (LA191_0==31) ) {
                alt191=1;
            }
            switch (alt191) {
                case 1 :
                    {

                    {

                    {
                    current = callRuleJvmUpperBoundAndAdd(FOLLOW_ruleJvmUpperBound_in_ruleJvmTypeParameter20075, current, elementAccess.getConstraintsJvmUpperBoundParserRuleCall_1_0_0(), elementAccess.getRule(), JVM_TYPE_PARAMETER__CONSTRAINTS, null);
                    if (state.failed) return current;

                    }
                    }
                    loop190:
                    do {
                        int alt190=2;
                        int LA190_0 = input.LA(1);
                        if ( (LA190_0==121) ) {
                            alt190=1;
                        }
                        switch (alt190) {
                    	case 1 :
                    	    {

                    	    {
                    	    current = callRuleJvmUpperBoundAndedAndAdd(FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmTypeParameter20096, current, elementAccess.getConstraintsJvmUpperBoundAndedParserRuleCall_1_1_0(), elementAccess.getRule(), JVM_TYPE_PARAMETER__CONSTRAINTS, null);
                    	    if (state.failed) return current;

                    	    }
                    	    }
                    	    break;
                    	default :
                    	    break loop190;
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
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard20142);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildcard.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard20153); if (state.failed) return current;
            }
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
            callRuleQualifiedName(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard20200, current, elementAccess.getQualifiedNameParserRuleCall_0());
            if (state.failed) return current;

            if (!consumeTokenAndMerge(98, FOLLOW_98_in_ruleQualifiedNameWithWildcard20218, current,  elementAccess.getFullStopKeyword_1())) { return current; }

            if (!consumeTokenAndMerge(92, FOLLOW_92_in_ruleQualifiedNameWithWildcard20231, current,  elementAccess.getAsteriskKeyword_2())) { return current; }

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
            pushFollow(FOLLOW_ruleXImportSection_in_entryRuleXImportSection20277);
            iv_ruleXImportSection=ruleXImportSection();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXImportSection; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXImportSection20287); if (state.failed) return current;
            }
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
                if ( (LA192_0==57) ) {
                    alt192=1;
                }
                switch (alt192) {
            	case 1 :
            	    {

            	    {
            	    current = callRuleXImportDeclarationAndAdd(FOLLOW_ruleXImportDeclaration_in_ruleXImportSection20332, current, elementAccess.getImportDeclarationsXImportDeclarationParserRuleCall_0(), elementAccess.getRule(), XIMPORT_SECTION__IMPORT_DECLARATIONS, null);
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
            pushFollow(FOLLOW_ruleXImportDeclaration_in_entryRuleXImportDeclaration20374);
            iv_ruleXImportDeclaration=ruleXImportDeclaration();
            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXImportDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXImportDeclaration20384); if (state.failed) return current;
            }
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
            if (!consumeUnassignedToken(57, FOLLOW_57_in_ruleXImportDeclaration20421,  elementAccess.getImportKeyword_0())) { return current; }

            int alt194=3;
            alt194 = dfa194.predict(input);
            switch (alt194) {
                case 1 :
                    {

                    {

                    {

                    {
                    current = consumeTokenAndSetBooleanValue(48, FOLLOW_48_in_ruleXImportDeclaration20441, current,  elementAccess.getStaticStaticKeyword_1_0_0_0(), elementAccess.getRule(), XIMPORT_DECLARATION__STATIC);
                    if (state.failed) return current;

                    }
                    }
                    int alt193=2;
                    int LA193_0 = input.LA(1);
                    if ( (LA193_0==39) ) {
                        alt193=1;
                    }
                    switch (alt193) {
                        case 1 :
                            {

                            {
                            current = consumeTokenAndSetBooleanValue(39, FOLLOW_39_in_ruleXImportDeclaration20472, current,  elementAccess.getExtensionExtensionKeyword_1_0_1_0(), elementAccess.getRule(), XIMPORT_DECLARATION__EXTENSION);
                            if (state.failed) return current;

                            }
                            }
                            break;
                    }

                    {

                    {
                    current = callRuleQualifiedName(FOLLOW_ruleQualifiedName_in_ruleXImportDeclaration20509, current, elementAccess.getImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0(), elementAccess.getRule());
                    if (state.failed) return current;

                    }
                    }
                    if (!consumeUnassignedToken(98, FOLLOW_98_in_ruleXImportDeclaration20521,  elementAccess.getFullStopKeyword_1_0_3())) { return current; }

                    if (!consumeUnassignedToken(92, FOLLOW_92_in_ruleXImportDeclaration20533,  elementAccess.getAsteriskKeyword_1_0_4())) { return current; }

                    }
                    }
                    break;
                case 2 :
                    {

                    {

                    {
                    current = callRuleQualifiedName(FOLLOW_ruleQualifiedName_in_ruleXImportDeclaration20563, current, elementAccess.getImportedTypeJvmDeclaredTypeCrossReference_1_1_0(), elementAccess.getRule());
                    if (state.failed) return current;

                    }
                    }
                    }
                    break;
                case 3 :
                    {

                    {

                    {
                    current = callRuleQualifiedNameWithWildcardAndSet(FOLLOW_ruleQualifiedNameWithWildcard_in_ruleXImportDeclaration20590, current, elementAccess.getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0(), elementAccess.getRule(), XIMPORT_DECLARATION__IMPORTED_NAMESPACE, "QualifiedNameWithWildcard");
                    if (state.failed) return current;

                    }
                    }
                    }
                    break;
            }
            int alt195=2;
            int LA195_0 = input.LA(1);
            if ( (LA195_0==26) ) {
                alt195=1;
            }
            switch (alt195) {
                case 1 :
                    {
                    if (!consumeUnassignedToken(26, FOLLOW_26_in_ruleXImportDeclaration20604,  elementAccess.getSemicolonKeyword_2())) { return current; }

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

    public final void synpred10_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        match(input,69,FOLLOW_69_in_synpred10_InternalXtend7963); if (state.failed) return ;
        match(input,70,FOLLOW_70_in_synpred10_InternalXtend7967); if (state.failed) return ;
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
        pushFollow(FOLLOW_ruleOpMultiAssign_in_synpred11_InternalXtend8518);
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
        pushFollow(FOLLOW_ruleOpOr_in_synpred12_InternalXtend8905);
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
        pushFollow(FOLLOW_ruleOpAnd_in_synpred13_InternalXtend9176);
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
        pushFollow(FOLLOW_ruleOpEquality_in_synpred14_InternalXtend9447);
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
        match(input,80,FOLLOW_80_in_synpred15_InternalXtend9773); if (state.failed) return ;
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
        pushFollow(FOLLOW_ruleOpCompare_in_synpred16_InternalXtend9844);
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
        pushFollow(FOLLOW_ruleOpOther_in_synpred17_InternalXtend10175);
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
        match(input,30,FOLLOW_30_in_synpred18_InternalXtend10450); if (state.failed) return ;
        match(input,30,FOLLOW_30_in_synpred18_InternalXtend10455); if (state.failed) return ;
        }
        }
    }

    public final void synpred19_InternalXtend_fragment() throws RecognitionException {   

        {

        {
        match(input,28,FOLLOW_28_in_synpred19_InternalXtend10537); if (state.failed) return ;
        match(input,28,FOLLOW_28_in_synpred19_InternalXtend10542); if (state.failed) return ;
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
        pushFollow(FOLLOW_ruleOpAdd_in_synpred20_InternalXtend10770);
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
        pushFollow(FOLLOW_ruleOpMulti_in_synpred21_InternalXtend11062);
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
        match(input,97,FOLLOW_97_in_synpred22_InternalXtend11680); if (state.failed) return ;
        }
        }
    }

    public final void synpred23_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        int alt200=2;
        int LA200_0 = input.LA(1);
        if ( (LA200_0==98) ) {
            alt200=1;
        }
        else if ( (LA200_0==99) ) {
            alt200=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 200, 0, input);
            throw nvae;
        }
        switch (alt200) {
            case 1 :
                {
                match(input,98,FOLLOW_98_in_synpred23_InternalXtend11841); if (state.failed) return ;
                }
                break;
            case 2 :
                {

                {

                {
                match(input,99,FOLLOW_99_in_synpred23_InternalXtend11855); if (state.failed) return ;
                }
                }
                }
                break;
        }

        {

        {
        pushFollow(FOLLOW_ruleFeatureCallID_in_synpred23_InternalXtend11871);
        ruleFeatureCallID();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        pushFollow(FOLLOW_ruleOpSingleAssign_in_synpred23_InternalXtend11877);
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
        int alt201=3;
        switch ( input.LA(1) ) {
        case 98:
            {
            alt201=1;
            }
            break;
        case 100:
            {
            alt201=2;
            }
            break;
        case 99:
            {
            alt201=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 201, 0, input);
            throw nvae;
        }
        switch (alt201) {
            case 1 :
                {
                match(input,98,FOLLOW_98_in_synpred24_InternalXtend12019); if (state.failed) return ;
                }
                break;
            case 2 :
                {

                {

                {
                match(input,100,FOLLOW_100_in_synpred24_InternalXtend12033); if (state.failed) return ;
                }
                }
                }
                break;
            case 3 :
                {

                {

                {
                match(input,99,FOLLOW_99_in_synpred24_InternalXtend12053); if (state.failed) return ;
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
        match(input,40,FOLLOW_40_in_synpred25_InternalXtend12280); if (state.failed) return ;
        }
        }
    }

    public final void synpred26_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
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
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred26_InternalXtend12332);
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
                	    match(input,29,FOLLOW_29_in_synpred26_InternalXtend12339); if (state.failed) return ;

                	    {

                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred26_InternalXtend12346);
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
        match(input,101,FOLLOW_101_in_synpred26_InternalXtend12360); if (state.failed) return ;
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
        match(input,70,FOLLOW_70_in_synpred27_InternalXtend12480); if (state.failed) return ;
        }
        }
    }

    public final void synpred28_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        match(input,70,FOLLOW_70_in_synpred28_InternalXtend13043); if (state.failed) return ;
        }
        }
    }

    public final void synpred30_InternalXtend_fragment() throws RecognitionException {   

        {

        {
        int alt205=2;
        int LA205_0 = input.LA(1);
        if ( (LA205_0==RULE_ID||LA205_0==37||(LA205_0>=39 && LA205_0<=40)||LA205_0==55||LA205_0==86) ) {
            alt205=1;
        }
        switch (alt205) {
            case 1 :
                {

                {

                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred30_InternalXtend13817);
                ruleJvmFormalParameter();
                state._fsp--;
                if (state.failed) return ;
                }
                }
                loop204:
                do {
                    int alt204=2;
                    int LA204_0 = input.LA(1);
                    if ( (LA204_0==29) ) {
                        alt204=1;
                    }
                    switch (alt204) {
                	case 1 :
                	    {
                	    match(input,29,FOLLOW_29_in_synpred30_InternalXtend13824); if (state.failed) return ;

                	    {

                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred30_InternalXtend13831);
                	    ruleJvmFormalParameter();
                	    state._fsp--;
                	    if (state.failed) return ;
                	    }
                	    }
                	    }
                	    break;
                	default :
                	    break loop204;
                    }
                } while (true);
                }
                break;
        }

        {

        {
        match(input,101,FOLLOW_101_in_synpred30_InternalXtend13845); if (state.failed) return ;
        }
        }
        }
        }
    }

    public final void synpred32_InternalXtend_fragment() throws RecognitionException {   

        {
        match(input,103,FOLLOW_103_in_synpred32_InternalXtend14652); if (state.failed) return ;
        }
    }

    public final void synpred33_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {

        {
        pushFollow(FOLLOW_ruleValidID_in_synpred33_InternalXtend14800);
        ruleValidID();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        match(input,56,FOLLOW_56_in_synpred33_InternalXtend14806); if (state.failed) return ;
        }
        }
    }

    public final void synpred34_InternalXtend_fragment() throws RecognitionException {   

        {

        {
        match(input,40,FOLLOW_40_in_synpred34_InternalXtend14882); if (state.failed) return ;

        {

        {
        pushFollow(FOLLOW_ruleValidID_in_synpred34_InternalXtend14889);
        ruleValidID();
        state._fsp--;
        if (state.failed) return ;
        }
        }
        match(input,56,FOLLOW_56_in_synpred34_InternalXtend14895); if (state.failed) return ;
        }
        }
    }

    public final void synpred35_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        int alt211=2;
        int LA211_0 = input.LA(1);
        if ( ((LA211_0>=51 && LA211_0<=52)) ) {
            alt211=1;
        }
        else if ( (LA211_0==39) ) {
            alt211=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 211, 0, input);
            throw nvae;
        }
        switch (alt211) {
            case 1 :
                {

                {
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
                        match(input,52,FOLLOW_52_in_synpred35_InternalXtend16023); if (state.failed) return ;
                        }
                        }
                        }
                        break;
                    case 2 :
                        {
                        match(input,51,FOLLOW_51_in_synpred35_InternalXtend16039); if (state.failed) return ;
                        }
                        break;
                }
                int alt209=2;
                int LA209_0 = input.LA(1);
                if ( (LA209_0==39) ) {
                    alt209=1;
                }
                switch (alt209) {
                    case 1 :
                        {

                        {
                        match(input,39,FOLLOW_39_in_synpred35_InternalXtend16048); if (state.failed) return ;
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
                match(input,39,FOLLOW_39_in_synpred35_InternalXtend16071); if (state.failed) return ;
                }
                }
                int alt210=2;
                int LA210_0 = input.LA(1);
                if ( (LA210_0==52) ) {
                    alt210=1;
                }
                else if ( (LA210_0==51) ) {
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

                        {
                        match(input,52,FOLLOW_52_in_synpred35_InternalXtend16086); if (state.failed) return ;
                        }
                        }
                        }
                        break;
                    case 2 :
                        {
                        match(input,51,FOLLOW_51_in_synpred35_InternalXtend16102); if (state.failed) return ;
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
        match(input,40,FOLLOW_40_in_synpred36_InternalXtend16360); if (state.failed) return ;
        }
        }
    }

    public final void synpred37_InternalXtend_fragment() throws RecognitionException {   

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
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred37_InternalXtend16412);
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
                	    match(input,29,FOLLOW_29_in_synpred37_InternalXtend16419); if (state.failed) return ;

                	    {

                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred37_InternalXtend16426);
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
        match(input,101,FOLLOW_101_in_synpred37_InternalXtend16440); if (state.failed) return ;
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
        match(input,70,FOLLOW_70_in_synpred38_InternalXtend16560); if (state.failed) return ;
        }
        }
    }

    public final void synpred39_InternalXtend_fragment() throws RecognitionException {   

        {
        match(input,28,FOLLOW_28_in_synpred39_InternalXtend16841); if (state.failed) return ;
        }
    }

    public final void synpred40_InternalXtend_fragment() throws RecognitionException {   

        {
        match(input,40,FOLLOW_40_in_synpred40_InternalXtend16934); if (state.failed) return ;
        }
    }

    public final void synpred41_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        int alt215=2;
        int LA215_0 = input.LA(1);
        if ( (LA215_0==RULE_ID||LA215_0==37||(LA215_0>=39 && LA215_0<=40)||LA215_0==55||LA215_0==86) ) {
            alt215=1;
        }
        switch (alt215) {
            case 1 :
                {

                {

                {
                pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred41_InternalXtend16964);
                ruleJvmFormalParameter();
                state._fsp--;
                if (state.failed) return ;
                }
                }
                loop214:
                do {
                    int alt214=2;
                    int LA214_0 = input.LA(1);
                    if ( (LA214_0==29) ) {
                        alt214=1;
                    }
                    switch (alt214) {
                	case 1 :
                	    {
                	    match(input,29,FOLLOW_29_in_synpred41_InternalXtend16971); if (state.failed) return ;

                	    {

                	    {
                	    pushFollow(FOLLOW_ruleJvmFormalParameter_in_synpred41_InternalXtend16978);
                	    ruleJvmFormalParameter();
                	    state._fsp--;
                	    if (state.failed) return ;
                	    }
                	    }
                	    }
                	    break;
                	default :
                	    break loop214;
                    }
                } while (true);
                }
                break;
        }

        {

        {
        match(input,101,FOLLOW_101_in_synpred41_InternalXtend16992); if (state.failed) return ;
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
        match(input,70,FOLLOW_70_in_synpred42_InternalXtend17112); if (state.failed) return ;
        }
        }
    }

    public final void synpred43_InternalXtend_fragment() throws RecognitionException {   

        {

        {
        pushFollow(FOLLOW_ruleXExpression_in_synpred43_InternalXtend17870);
        ruleXExpression();
        state._fsp--;
        if (state.failed) return ;
        }
        }
    }

    public final void synpred44_InternalXtend_fragment() throws RecognitionException {   

        {
        match(input,119,FOLLOW_119_in_synpred44_InternalXtend18021); if (state.failed) return ;
        }
    }

    public final void synpred45_InternalXtend_fragment() throws RecognitionException {   

        {
        match(input,118,FOLLOW_118_in_synpred45_InternalXtend18051); if (state.failed) return ;
        }
    }

    public final void synpred47_InternalXtend_fragment() throws RecognitionException {   

        {
        match(input,98,FOLLOW_98_in_synpred47_InternalXtend18410); if (state.failed) return ;
        }
    }

    public final void synpred48_InternalXtend_fragment() throws RecognitionException {   

        {

        {

        {
        }
        pushFollow(FOLLOW_ruleArrayBrackets_in_synpred48_InternalXtend18801);
        ruleArrayBrackets();
        state._fsp--;
        if (state.failed) return ;
        }
        }
    }

    public final void synpred49_InternalXtend_fragment() throws RecognitionException {   

        {
        match(input,28,FOLLOW_28_in_synpred49_InternalXtend19271); if (state.failed) return ;
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
    protected DFA102 dfa102 = new DFA102(this);
    protected DFA105 dfa105 = new DFA105(this);
    protected DFA113 dfa113 = new DFA113(this);
    protected DFA116 dfa116 = new DFA116(this);
    protected DFA130 dfa130 = new DFA130(this);
    protected DFA129 dfa129 = new DFA129(this);
    protected DFA131 dfa131 = new DFA131(this);
    protected DFA133 dfa133 = new DFA133(this);
    protected DFA142 dfa142 = new DFA142(this);
    protected DFA161 dfa161 = new DFA161(this);
    protected DFA160 dfa160 = new DFA160(this);
    protected DFA162 dfa162 = new DFA162(this);
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
        "\1\uffff\3\5\2\uffff\3\4\6\uffff";
    static final String DFA36_minS =
        "\4\4\2\uffff\11\4";
    static final String DFA36_maxS =
        "\1\126\3\142\2\uffff\11\142";
    static final String DFA36_acceptS =
        "\4\uffff\1\1\1\2\11\uffff";
    static final String DFA36_specialS =
        "\17\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\1\40\uffff\1\3\2\uffff\1\4\16\uffff\1\2\36\uffff\1\4",
            "\1\6\24\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\1\uffff\1\4\17\uffff\1\5\13\uffff"+
            "\1\4",
            "\1\6\24\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\1\uffff\1\4\17\uffff\1\5\13\uffff"+
            "\1\4",
            "\1\6\24\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\1\uffff\1\4\17\uffff\1\5\13\uffff"+
            "\1\4",
            "",
            "",
            "\1\11\24\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\5\17\uffff\1\4\13"+
            "\uffff\1\5",
            "\1\11\24\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\5\17\uffff\1\4\13"+
            "\uffff\1\5",
            "\1\11\24\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\5\17\uffff\1\4\13"+
            "\uffff\1\5",
            "\1\14\24\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\16\3\5"+
            "\2\uffff\14\5\1\15\14\uffff\1\5\1\uffff\1\4\17\uffff\1\5\13"+
            "\uffff\1\4",
            "\1\14\24\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\16\3\5"+
            "\2\uffff\14\5\1\15\14\uffff\1\5\1\uffff\1\4\17\uffff\1\5\13"+
            "\uffff\1\4",
            "\1\14\24\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\16\3\5"+
            "\2\uffff\14\5\1\15\14\uffff\1\5\1\uffff\1\4\17\uffff\1\5\13"+
            "\uffff\1\4",
            "\1\11\24\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\5\17\uffff\1\4\13"+
            "\uffff\1\5",
            "\1\11\24\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\5\17\uffff\1\4\13"+
            "\uffff\1\5",
            "\1\11\24\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\5\17\uffff\1\4\13"+
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
        "\1\126\3\142\2\uffff\6\142";
    static final String DFA38_acceptS =
        "\4\uffff\1\2\1\1\6\uffff";
    static final String DFA38_specialS =
        "\14\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\1\24\uffff\2\4\7\uffff\1\4\2\uffff\1\3\3\4\2\uffff\14\4\1"+
            "\2\14\uffff\1\4\21\uffff\1\4",
            "\1\6\24\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\1\uffff\1\4\17\uffff\1\5\13\uffff"+
            "\1\4",
            "\1\6\24\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\1\uffff\1\4\17\uffff\1\5\13\uffff"+
            "\1\4",
            "\1\6\24\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\1\uffff\1\4\17\uffff\1\5\13\uffff"+
            "\1\4",
            "",
            "",
            "\1\11\24\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\5\17\uffff\1\4\13"+
            "\uffff\1\5",
            "\1\11\24\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\5\17\uffff\1\4\13"+
            "\uffff\1\5",
            "\1\11\24\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\5\17\uffff\1\4\13"+
            "\uffff\1\5",
            "\1\6\24\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\1\uffff\1\4\17\uffff\1\5\13\uffff"+
            "\1\4",
            "\1\6\24\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\1\uffff\1\4\17\uffff\1\5\13\uffff"+
            "\1\4",
            "\1\6\24\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\1\uffff\1\4\17\uffff\1\5\13\uffff"+
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
        "\1\126\3\142\2\uffff\6\142";
    static final String DFA41_acceptS =
        "\4\uffff\1\2\1\1\6\uffff";
    static final String DFA41_specialS =
        "\14\uffff}>";
    static final String[] DFA41_transitionS = {
            "\1\1\24\uffff\2\4\7\uffff\1\4\2\uffff\1\3\3\4\2\uffff\14\4\1"+
            "\2\14\uffff\1\4\21\uffff\1\4",
            "\1\6\24\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\1\uffff\1\4\17\uffff\1\5\13\uffff"+
            "\1\4",
            "\1\6\24\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\1\uffff\1\4\17\uffff\1\5\13\uffff"+
            "\1\4",
            "\1\6\24\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\1\uffff\1\4\17\uffff\1\5\13\uffff"+
            "\1\4",
            "",
            "",
            "\1\11\24\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\5\17\uffff\1\4\13"+
            "\uffff\1\5",
            "\1\11\24\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\5\17\uffff\1\4\13"+
            "\uffff\1\5",
            "\1\11\24\uffff\2\4\1\uffff\1\5\5\uffff\1\4\2\uffff\1\13\3\4"+
            "\2\uffff\14\4\1\12\14\uffff\1\4\1\uffff\1\5\17\uffff\1\4\13"+
            "\uffff\1\5",
            "\1\6\24\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\1\uffff\1\4\17\uffff\1\5\13\uffff"+
            "\1\4",
            "\1\6\24\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\1\uffff\1\4\17\uffff\1\5\13\uffff"+
            "\1\4",
            "\1\6\24\uffff\2\5\1\uffff\1\4\5\uffff\1\5\2\uffff\1\10\3\5"+
            "\2\uffff\14\5\1\7\14\uffff\1\5\1\uffff\1\4\17\uffff\1\5\13\uffff"+
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
    static final String DFA102_eotS =
        "\64\uffff";
    static final String DFA102_eofS =
        "\64\uffff";
    static final String DFA102_minS =
        "\1\4\1\0\62\uffff";
    static final String DFA102_maxS =
        "\1\165\1\0\62\uffff";
    static final String DFA102_acceptS =
        "\2\uffff\1\2\60\uffff\1\1";
    static final String DFA102_specialS =
        "\1\uffff\1\0\62\uffff}>";
    static final String[] DFA102_transitionS = {
            "\4\2\4\uffff\3\2\12\uffff\1\2\1\uffff\2\2\2\uffff\3\2\1\uffff"+
            "\3\2\1\uffff\2\2\1\uffff\11\2\2\uffff\3\2\1\uffff\1\2\12\uffff"+
            "\1\2\1\1\1\2\23\uffff\2\2\4\uffff\1\2\5\uffff\1\2\1\uffff\1"+
            "\2\2\uffff\13\2",
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
    static final short[] DFA102_eot = DFA.unpackEncodedString(DFA102_eotS);
    static final short[] DFA102_eof = DFA.unpackEncodedString(DFA102_eofS);
    static final char[] DFA102_min = DFA.unpackEncodedStringToUnsignedChars(DFA102_minS);
    static final char[] DFA102_max = DFA.unpackEncodedStringToUnsignedChars(DFA102_maxS);
    static final short[] DFA102_accept = DFA.unpackEncodedString(DFA102_acceptS);
    static final short[] DFA102_special = DFA.unpackEncodedString(DFA102_specialS);
    static final short[][] DFA102_transition;
    static {
        int numStates = DFA102_transitionS.length;
        DFA102_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA102_transition[i] = DFA.unpackEncodedString(DFA102_transitionS[i]);
        }
    }
    class DFA102 extends DFA {
        public DFA102(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 102;
            this.eot = DFA102_eot;
            this.eof = DFA102_eof;
            this.min = DFA102_min;
            this.max = DFA102_max;
            this.accept = DFA102_accept;
            this.special = DFA102_special;
            this.transition = DFA102_transition;
        }
        public String getDescription() {
            return "4252:1: ( ( ( ( ( () '#' '[' ) )=> ( () other= '#' other= '[' ) ) ( ( (this_object= ruleXAnnotationOrExpression ) ) (other= ',' ( (this_object= ruleXAnnotationOrExpression ) ) )* )? other= ']' ) | this_object= ruleXAnnotationOrExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA102_1 = input.LA(1);
                        int index102_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalXtend()) ) {s = 51;}
                        else if ( (true) ) {s = 2;}
                        input.seek(index102_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 102, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA105_eotS =
        "\30\uffff";
    static final String DFA105_eofS =
        "\1\uffff\25\26\2\uffff";
    static final String DFA105_minS =
        "\26\4\2\uffff";
    static final String DFA105_maxS =
        "\1\165\25\167\2\uffff";
    static final String DFA105_acceptS =
        "\26\uffff\1\2\1\1";
    static final String DFA105_specialS =
        "\30\uffff}>";
    static final String[] DFA105_transitionS = {
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
    static final short[] DFA105_eot = DFA.unpackEncodedString(DFA105_eotS);
    static final short[] DFA105_eof = DFA.unpackEncodedString(DFA105_eofS);
    static final char[] DFA105_min = DFA.unpackEncodedStringToUnsignedChars(DFA105_minS);
    static final char[] DFA105_max = DFA.unpackEncodedStringToUnsignedChars(DFA105_maxS);
    static final short[] DFA105_accept = DFA.unpackEncodedString(DFA105_acceptS);
    static final short[] DFA105_special = DFA.unpackEncodedString(DFA105_specialS);
    static final short[][] DFA105_transition;
    static {
        int numStates = DFA105_transitionS.length;
        DFA105_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA105_transition[i] = DFA.unpackEncodedString(DFA105_transitionS[i]);
        }
    }
    class DFA105 extends DFA {
        public DFA105(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 105;
            this.eot = DFA105_eot;
            this.eof = DFA105_eof;
            this.min = DFA105_min;
            this.max = DFA105_max;
            this.accept = DFA105_accept;
            this.special = DFA105_special;
            this.transition = DFA105_transition;
        }
        public String getDescription() {
            return "4439:1: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (this_object= ruleXAssignment ) ) ) | (this_object= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (this_object= ruleXAssignment ) ) )? ) )";
        }
    }
    static final String DFA113_eotS =
        "\14\uffff";
    static final String DFA113_eofS =
        "\1\1\13\uffff";
    static final String DFA113_minS =
        "\1\4\1\uffff\11\0\1\uffff";
    static final String DFA113_maxS =
        "\1\167\1\uffff\11\0\1\uffff";
    static final String DFA113_acceptS =
        "\1\uffff\1\2\11\uffff\1\1";
    static final String DFA113_specialS =
        "\2\uffff\1\7\1\4\1\2\1\5\1\3\1\10\1\1\1\0\1\6\1\uffff}>";
    static final String[] DFA113_transitionS = {
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
    static final short[] DFA113_eot = DFA.unpackEncodedString(DFA113_eotS);
    static final short[] DFA113_eof = DFA.unpackEncodedString(DFA113_eofS);
    static final char[] DFA113_min = DFA.unpackEncodedStringToUnsignedChars(DFA113_minS);
    static final char[] DFA113_max = DFA.unpackEncodedStringToUnsignedChars(DFA113_maxS);
    static final short[] DFA113_accept = DFA.unpackEncodedString(DFA113_acceptS);
    static final short[] DFA113_special = DFA.unpackEncodedString(DFA113_specialS);
    static final short[][] DFA113_transition;
    static {
        int numStates = DFA113_transitionS.length;
        DFA113_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA113_transition[i] = DFA.unpackEncodedString(DFA113_transitionS[i]);
        }
    }
    class DFA113 extends DFA {
        public DFA113(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 113;
            this.eot = DFA113_eot;
            this.eof = DFA113_eof;
            this.min = DFA113_min;
            this.max = DFA113_max;
            this.accept = DFA113_accept;
            this.special = DFA113_special;
            this.transition = DFA113_transition;
        }
        public String getDescription() {
            return "()* loopback of 5203:1: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (this_object= ruleXAdditiveExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA113_9 = input.LA(1);
                        int index113_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index113_9);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA113_8 = input.LA(1);
                        int index113_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index113_8);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA113_4 = input.LA(1);
                        int index113_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index113_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA113_6 = input.LA(1);
                        int index113_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index113_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA113_3 = input.LA(1);
                        int index113_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index113_3);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA113_5 = input.LA(1);
                        int index113_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index113_5);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA113_10 = input.LA(1);
                        int index113_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index113_10);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA113_2 = input.LA(1);
                        int index113_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index113_2);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA113_7 = input.LA(1);
                        int index113_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalXtend()) ) {s = 11;}
                        else if ( (true) ) {s = 1;}
                        input.seek(index113_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 113, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA116_eotS =
        "\14\uffff";
    static final String DFA116_eofS =
        "\14\uffff";
    static final String DFA116_minS =
        "\1\34\2\uffff\1\36\10\uffff";
    static final String DFA116_maxS =
        "\1\131\2\uffff\1\125\10\uffff";
    static final String DFA116_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\4\1\5\1\7\1\10\1\11\1\12\1\3\1\6";
    static final String DFA116_specialS =
        "\14\uffff}>";
    static final String[] DFA116_transitionS = {
            "\1\6\1\uffff\1\3\64\uffff\1\1\1\2\1\4\1\5\1\7\1\10\1\11",
            "",
            "",
            "\1\13\66\uffff\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final short[] DFA116_eot = DFA.unpackEncodedString(DFA116_eotS);
    static final short[] DFA116_eof = DFA.unpackEncodedString(DFA116_eofS);
    static final char[] DFA116_min = DFA.unpackEncodedStringToUnsignedChars(DFA116_minS);
    static final char[] DFA116_max = DFA.unpackEncodedStringToUnsignedChars(DFA116_maxS);
    static final short[] DFA116_accept = DFA.unpackEncodedString(DFA116_acceptS);
    static final short[] DFA116_special = DFA.unpackEncodedString(DFA116_specialS);
    static final short[][] DFA116_transition;
    static {
        int numStates = DFA116_transitionS.length;
        DFA116_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA116_transition[i] = DFA.unpackEncodedString(DFA116_transitionS[i]);
        }
    }
    class DFA116 extends DFA {
        public DFA116(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 116;
            this.eot = DFA116_eot;
            this.eof = DFA116_eof;
            this.min = DFA116_min;
            this.max = DFA116_max;
            this.accept = DFA116_accept;
            this.special = DFA116_special;
            this.transition = DFA116_transition;
        }
        public String getDescription() {
            return "5277:1: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' ) ) | kw= '<>' | kw= '?:' | kw= '<=>' )";
        }
    }
    static final String DFA130_eotS =
        "\144\uffff";
    static final String DFA130_eofS =
        "\1\2\143\uffff";
    static final String DFA130_minS =
        "\1\4\1\0\142\uffff";
    static final String DFA130_maxS =
        "\1\167\1\0\142\uffff";
    static final String DFA130_acceptS =
        "\2\uffff\1\2\140\uffff\1\1";
    static final String DFA130_specialS =
        "\1\uffff\1\0\142\uffff}>";
    static final String[] DFA130_transitionS = {
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
    static final short[] DFA130_eot = DFA.unpackEncodedString(DFA130_eotS);
    static final short[] DFA130_eof = DFA.unpackEncodedString(DFA130_eofS);
    static final char[] DFA130_min = DFA.unpackEncodedStringToUnsignedChars(DFA130_minS);
    static final char[] DFA130_max = DFA.unpackEncodedStringToUnsignedChars(DFA130_maxS);
    static final short[] DFA130_accept = DFA.unpackEncodedString(DFA130_acceptS);
    static final short[] DFA130_special = DFA.unpackEncodedString(DFA130_specialS);
    static final short[][] DFA130_transition;
    static {
        int numStates = DFA130_transitionS.length;
        DFA130_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA130_transition[i] = DFA.unpackEncodedString(DFA130_transitionS[i]);
        }
    }
    class DFA130 extends DFA {
        public DFA130(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 130;
            this.eot = DFA130_eot;
            this.eof = DFA130_eof;
            this.min = DFA130_min;
            this.max = DFA130_max;
            this.accept = DFA130_accept;
            this.special = DFA130_special;
            this.transition = DFA130_transition;
        }
        public String getDescription() {
            return "6101:2: ( ( ( ( '(' ) )=> (other= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (this_object= ruleXShortClosure ) ) | ( ( (this_object= ruleXExpression ) ) (other= ',' ( (this_object= ruleXExpression ) ) )* ) )? other= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA130_1 = input.LA(1);
                        int index130_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 2;}
                        input.seek(index130_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 130, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA129_eotS =
        "\65\uffff";
    static final String DFA129_eofS =
        "\65\uffff";
    static final String DFA129_minS =
        "\1\4\5\0\57\uffff";
    static final String DFA129_maxS =
        "\1\165\5\0\57\uffff";
    static final String DFA129_acceptS =
        "\6\uffff\2\1\1\2\53\uffff\1\3";
    static final String DFA129_specialS =
        "\1\0\1\1\1\2\1\3\1\4\1\5\57\uffff}>";
    static final String[] DFA129_transitionS = {
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
            return "6122:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (this_object= ruleXShortClosure ) ) | ( ( (this_object= ruleXExpression ) ) (other= ',' ( (this_object= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA129_0 = input.LA(1);
                        int index129_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA129_0==39) ) {s = 1;}
                        else if ( (LA129_0==RULE_ID) ) {s = 2;}
                        else if ( (LA129_0==55) ) {s = 3;}
                        else if ( (LA129_0==37) ) {s = 4;}
                        else if ( (LA129_0==40) ) {s = 5;}
                        else if ( (LA129_0==86) && (synpred26_InternalXtend())) {s = 6;}
                        else if ( (LA129_0==101) && (synpred26_InternalXtend())) {s = 7;}
                        else if ( ((LA129_0>=RULE_STRING && LA129_0<=RULE_RICH_TEXT_START)||(LA129_0>=RULE_HEX && LA129_0<=RULE_DECIMAL)||LA129_0==25||(LA129_0>=27 && LA129_0<=28)||(LA129_0>=31 && LA129_0<=33)||(LA129_0>=35 && LA129_0<=36)||(LA129_0>=42 && LA129_0<=50)||(LA129_0>=53 && LA129_0<=54)||LA129_0==57||(LA129_0>=69 && LA129_0<=70)||(LA129_0>=90 && LA129_0<=91)||LA129_0==96||LA129_0==102||LA129_0==104||(LA129_0>=107 && LA129_0<=117)) ) {s = 8;}
                        else if ( (LA129_0==41) ) {s = 52;}
                        input.seek(index129_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA129_1 = input.LA(1);
                        int index129_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index129_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA129_2 = input.LA(1);
                        int index129_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index129_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA129_3 = input.LA(1);
                        int index129_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index129_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA129_4 = input.LA(1);
                        int index129_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index129_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA129_5 = input.LA(1);
                        int index129_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index129_5);
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
        "\144\uffff";
    static final String DFA131_eofS =
        "\1\2\143\uffff";
    static final String DFA131_minS =
        "\1\4\1\0\142\uffff";
    static final String DFA131_maxS =
        "\1\167\1\0\142\uffff";
    static final String DFA131_acceptS =
        "\2\uffff\1\2\140\uffff\1\1";
    static final String DFA131_specialS =
        "\1\uffff\1\0\142\uffff}>";
    static final String[] DFA131_transitionS = {
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
            return "6201:3: ( ( ( () '[' ) )=> (this_object= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA131_1 = input.LA(1);
                        int index131_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 2;}
                        input.seek(index131_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 131, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA133_eotS =
        "\16\uffff";
    static final String DFA133_eofS =
        "\16\uffff";
    static final String DFA133_minS =
        "\1\4\15\uffff";
    static final String DFA133_maxS =
        "\1\165\15\uffff";
    static final String DFA133_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\15";
    static final String DFA133_specialS =
        "\16\uffff}>";
    static final String[] DFA133_transitionS = {
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
    static final short[] DFA133_eot = DFA.unpackEncodedString(DFA133_eotS);
    static final short[] DFA133_eof = DFA.unpackEncodedString(DFA133_eofS);
    static final char[] DFA133_min = DFA.unpackEncodedStringToUnsignedChars(DFA133_minS);
    static final char[] DFA133_max = DFA.unpackEncodedStringToUnsignedChars(DFA133_maxS);
    static final short[] DFA133_accept = DFA.unpackEncodedString(DFA133_acceptS);
    static final short[] DFA133_special = DFA.unpackEncodedString(DFA133_specialS);
    static final short[][] DFA133_transition;
    static {
        int numStates = DFA133_transitionS.length;
        DFA133_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA133_transition[i] = DFA.unpackEncodedString(DFA133_transitionS[i]);
        }
    }
    class DFA133 extends DFA {
        public DFA133(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 133;
            this.eot = DFA133_eot;
            this.eof = DFA133_eof;
            this.min = DFA133_min;
            this.max = DFA133_max;
            this.accept = DFA133_accept;
            this.special = DFA133_special;
            this.transition = DFA133_transition;
        }
        public String getDescription() {
            return "6250:1: (this_object= ruleXConstructorCall | this_object= ruleXBlockExpression | this_object= ruleXSwitchExpression | this_object= ruleXFeatureCall | this_object= ruleXLiteral | this_object= ruleXIfExpression | this_object= ruleXForLoopExpression | this_object= ruleXWhileExpression | this_object= ruleXDoWhileExpression | this_object= ruleXThrowExpression | this_object= ruleXReturnExpression | this_object= ruleXTryCatchFinallyExpression | this_object= ruleXParenthesizedExpression )";
        }
    }
    static final String DFA142_eotS =
        "\67\uffff";
    static final String DFA142_eofS =
        "\67\uffff";
    static final String DFA142_minS =
        "\1\4\5\0\61\uffff";
    static final String DFA142_maxS =
        "\1\165\5\0\61\uffff";
    static final String DFA142_acceptS =
        "\6\uffff\2\1\1\2\56\uffff";
    static final String DFA142_specialS =
        "\1\0\1\1\1\2\1\3\1\4\1\5\61\uffff}>";
    static final String[] DFA142_transitionS = {
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
    static final short[] DFA142_eot = DFA.unpackEncodedString(DFA142_eotS);
    static final short[] DFA142_eof = DFA.unpackEncodedString(DFA142_eofS);
    static final char[] DFA142_min = DFA.unpackEncodedStringToUnsignedChars(DFA142_minS);
    static final char[] DFA142_max = DFA.unpackEncodedStringToUnsignedChars(DFA142_maxS);
    static final short[] DFA142_accept = DFA.unpackEncodedString(DFA142_acceptS);
    static final short[] DFA142_special = DFA.unpackEncodedString(DFA142_specialS);
    static final short[][] DFA142_transition;
    static {
        int numStates = DFA142_transitionS.length;
        DFA142_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA142_transition[i] = DFA.unpackEncodedString(DFA142_transitionS[i]);
        }
    }
    class DFA142 extends DFA {
        public DFA142(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 142;
            this.eot = DFA142_eot;
            this.eof = DFA142_eof;
            this.min = DFA142_min;
            this.max = DFA142_max;
            this.accept = DFA142_accept;
            this.special = DFA142_special;
            this.transition = DFA142_transition;
        }
        public String getDescription() {
            return "6745:3: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (this_object= ruleJvmFormalParameter ) ) (other= ',' ( (this_object= ruleJvmFormalParameter ) ) )* )? ( (other= '|' ) ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA142_0 = input.LA(1);
                        int index142_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA142_0==39) ) {s = 1;}
                        else if ( (LA142_0==RULE_ID) ) {s = 2;}
                        else if ( (LA142_0==55) ) {s = 3;}
                        else if ( (LA142_0==37) ) {s = 4;}
                        else if ( (LA142_0==40) ) {s = 5;}
                        else if ( (LA142_0==86) && (synpred30_InternalXtend())) {s = 6;}
                        else if ( (LA142_0==101) && (synpred30_InternalXtend())) {s = 7;}
                        else if ( ((LA142_0>=RULE_STRING && LA142_0<=RULE_RICH_TEXT_START)||(LA142_0>=RULE_HEX && LA142_0<=RULE_DECIMAL)||LA142_0==25||(LA142_0>=27 && LA142_0<=28)||(LA142_0>=31 && LA142_0<=33)||(LA142_0>=35 && LA142_0<=36)||(LA142_0>=42 && LA142_0<=54)||LA142_0==57||(LA142_0>=69 && LA142_0<=71)||(LA142_0>=90 && LA142_0<=91)||LA142_0==96||LA142_0==102||LA142_0==104||(LA142_0>=107 && LA142_0<=117)) ) {s = 8;}
                        input.seek(index142_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA142_1 = input.LA(1);
                        int index142_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index142_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA142_2 = input.LA(1);
                        int index142_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index142_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA142_3 = input.LA(1);
                        int index142_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index142_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA142_4 = input.LA(1);
                        int index142_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index142_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA142_5 = input.LA(1);
                        int index142_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index142_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 142, _s, input);
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
        "\1\167\1\0\142\uffff";
    static final String DFA161_acceptS =
        "\2\uffff\1\2\140\uffff\1\1";
    static final String DFA161_specialS =
        "\1\uffff\1\0\142\uffff}>";
    static final String[] DFA161_transitionS = {
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
            return "7977:2: ( ( ( ( '(' ) )=> (other= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (this_object= ruleXShortClosure ) ) | ( ( (this_object= ruleXExpression ) ) (other= ',' ( (this_object= ruleXExpression ) ) )* ) )? other= ')' )?";
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
                        if ( (synpred36_InternalXtend()) ) {s = 99;}
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
    static final String DFA160_eotS =
        "\65\uffff";
    static final String DFA160_eofS =
        "\65\uffff";
    static final String DFA160_minS =
        "\1\4\5\0\57\uffff";
    static final String DFA160_maxS =
        "\1\165\5\0\57\uffff";
    static final String DFA160_acceptS =
        "\6\uffff\2\1\1\2\53\uffff\1\3";
    static final String DFA160_specialS =
        "\1\0\1\1\1\2\1\3\1\4\1\5\57\uffff}>";
    static final String[] DFA160_transitionS = {
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
            return "7998:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (this_object= ruleXShortClosure ) ) | ( ( (this_object= ruleXExpression ) ) (other= ',' ( (this_object= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA160_0 = input.LA(1);
                        int index160_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA160_0==39) ) {s = 1;}
                        else if ( (LA160_0==RULE_ID) ) {s = 2;}
                        else if ( (LA160_0==55) ) {s = 3;}
                        else if ( (LA160_0==37) ) {s = 4;}
                        else if ( (LA160_0==40) ) {s = 5;}
                        else if ( (LA160_0==86) && (synpred37_InternalXtend())) {s = 6;}
                        else if ( (LA160_0==101) && (synpred37_InternalXtend())) {s = 7;}
                        else if ( ((LA160_0>=RULE_STRING && LA160_0<=RULE_RICH_TEXT_START)||(LA160_0>=RULE_HEX && LA160_0<=RULE_DECIMAL)||LA160_0==25||(LA160_0>=27 && LA160_0<=28)||(LA160_0>=31 && LA160_0<=33)||(LA160_0>=35 && LA160_0<=36)||(LA160_0>=42 && LA160_0<=50)||(LA160_0>=53 && LA160_0<=54)||LA160_0==57||(LA160_0>=69 && LA160_0<=70)||(LA160_0>=90 && LA160_0<=91)||LA160_0==96||LA160_0==102||LA160_0==104||(LA160_0>=107 && LA160_0<=117)) ) {s = 8;}
                        else if ( (LA160_0==41) ) {s = 52;}
                        input.seek(index160_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA160_1 = input.LA(1);
                        int index160_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index160_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA160_2 = input.LA(1);
                        int index160_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index160_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA160_3 = input.LA(1);
                        int index160_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index160_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA160_4 = input.LA(1);
                        int index160_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index160_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA160_5 = input.LA(1);
                        int index160_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index160_5);
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
    static final String DFA162_eotS =
        "\144\uffff";
    static final String DFA162_eofS =
        "\1\2\143\uffff";
    static final String DFA162_minS =
        "\1\4\1\0\142\uffff";
    static final String DFA162_maxS =
        "\1\167\1\0\142\uffff";
    static final String DFA162_acceptS =
        "\2\uffff\1\2\140\uffff\1\1";
    static final String DFA162_specialS =
        "\1\uffff\1\0\142\uffff}>";
    static final String[] DFA162_transitionS = {
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
    static final short[] DFA162_eot = DFA.unpackEncodedString(DFA162_eotS);
    static final short[] DFA162_eof = DFA.unpackEncodedString(DFA162_eofS);
    static final char[] DFA162_min = DFA.unpackEncodedStringToUnsignedChars(DFA162_minS);
    static final char[] DFA162_max = DFA.unpackEncodedStringToUnsignedChars(DFA162_maxS);
    static final short[] DFA162_accept = DFA.unpackEncodedString(DFA162_acceptS);
    static final short[] DFA162_special = DFA.unpackEncodedString(DFA162_specialS);
    static final short[][] DFA162_transition;
    static {
        int numStates = DFA162_transitionS.length;
        DFA162_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA162_transition[i] = DFA.unpackEncodedString(DFA162_transitionS[i]);
        }
    }
    class DFA162 extends DFA {
        public DFA162(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 162;
            this.eot = DFA162_eot;
            this.eof = DFA162_eof;
            this.min = DFA162_min;
            this.max = DFA162_max;
            this.accept = DFA162_accept;
            this.special = DFA162_special;
            this.transition = DFA162_transition;
        }
        public String getDescription() {
            return "8077:3: ( ( ( () '[' ) )=> (this_object= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA162_1 = input.LA(1);
                        int index162_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 2;}
                        input.seek(index162_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 162, _s, input);
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
        "\1\167\1\0\142\uffff";
    static final String DFA165_acceptS =
        "\2\uffff\1\2\140\uffff\1\1";
    static final String DFA165_specialS =
        "\1\uffff\1\0\142\uffff}>";
    static final String[] DFA165_transitionS = {
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
            return "8199:2: ( ( ( '<' )=>other= '<' ) ( (this_object= ruleJvmArgumentTypeReference ) ) (other= ',' ( (this_object= ruleJvmArgumentTypeReference ) ) )* other= '>' )?";
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
                        if ( (synpred39_InternalXtend()) ) {s = 99;}
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
        "\1\167\1\0\142\uffff";
    static final String DFA168_acceptS =
        "\2\uffff\1\2\140\uffff\1\1";
    static final String DFA168_specialS =
        "\1\uffff\1\0\142\uffff}>";
    static final String[] DFA168_transitionS = {
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
            return "8248:3: ( ( ( '(' )=>other= '(' ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (this_object= ruleXShortClosure ) ) | ( ( (this_object= ruleXExpression ) ) (other= ',' ( (this_object= ruleXExpression ) ) )* ) )? other= ')' )?";
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
                        if ( (synpred40_InternalXtend()) ) {s = 99;}
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
        "\1\165\5\0\57\uffff";
    static final String DFA167_acceptS =
        "\6\uffff\2\1\1\2\53\uffff\1\3";
    static final String DFA167_specialS =
        "\1\0\1\1\1\2\1\3\1\4\1\5\57\uffff}>";
    static final String[] DFA167_transitionS = {
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
            return "8253:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (this_object= ruleXShortClosure ) ) | ( ( (this_object= ruleXExpression ) ) (other= ',' ( (this_object= ruleXExpression ) ) )* ) )?";
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
                        if ( (LA167_0==39) ) {s = 1;}
                        else if ( (LA167_0==RULE_ID) ) {s = 2;}
                        else if ( (LA167_0==55) ) {s = 3;}
                        else if ( (LA167_0==37) ) {s = 4;}
                        else if ( (LA167_0==40) ) {s = 5;}
                        else if ( (LA167_0==86) && (synpred41_InternalXtend())) {s = 6;}
                        else if ( (LA167_0==101) && (synpred41_InternalXtend())) {s = 7;}
                        else if ( ((LA167_0>=RULE_STRING && LA167_0<=RULE_RICH_TEXT_START)||(LA167_0>=RULE_HEX && LA167_0<=RULE_DECIMAL)||LA167_0==25||(LA167_0>=27 && LA167_0<=28)||(LA167_0>=31 && LA167_0<=33)||(LA167_0>=35 && LA167_0<=36)||(LA167_0>=42 && LA167_0<=50)||(LA167_0>=53 && LA167_0<=54)||LA167_0==57||(LA167_0>=69 && LA167_0<=70)||(LA167_0>=90 && LA167_0<=91)||LA167_0==96||LA167_0==102||LA167_0==104||(LA167_0>=107 && LA167_0<=117)) ) {s = 8;}
                        else if ( (LA167_0==41) ) {s = 52;}
                        input.seek(index167_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA167_1 = input.LA(1);
                        int index167_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index167_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA167_2 = input.LA(1);
                        int index167_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index167_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA167_3 = input.LA(1);
                        int index167_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index167_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA167_4 = input.LA(1);
                        int index167_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_InternalXtend()) ) {s = 7;}
                        else if ( (true) ) {s = 8;}
                        input.seek(index167_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA167_5 = input.LA(1);
                        int index167_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_InternalXtend()) ) {s = 7;}
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
        "\1\167\1\0\142\uffff";
    static final String DFA169_acceptS =
        "\2\uffff\1\2\140\uffff\1\1";
    static final String DFA169_specialS =
        "\1\uffff\1\0\142\uffff}>";
    static final String[] DFA169_transitionS = {
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
            return "8332:3: ( ( ( () '[' ) )=> (this_object= ruleXClosure ) )?";
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
                        if ( (synpred42_InternalXtend()) ) {s = 99;}
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
        "\1\167\61\0\62\uffff";
    static final String DFA172_acceptS =
        "\62\uffff\1\2\60\uffff\1\1";
    static final String DFA172_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31"+
        "\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46"+
        "\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\62\uffff}>";
    static final String[] DFA172_transitionS = {
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
            return "8681:1: ( ( ( ruleXExpression ) )=> (this_object= ruleXExpression ) )?";
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
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA172_2 = input.LA(1);
                        int index172_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA172_3 = input.LA(1);
                        int index172_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA172_4 = input.LA(1);
                        int index172_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA172_5 = input.LA(1);
                        int index172_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA172_6 = input.LA(1);
                        int index172_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA172_7 = input.LA(1);
                        int index172_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA172_8 = input.LA(1);
                        int index172_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA172_9 = input.LA(1);
                        int index172_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA172_10 = input.LA(1);
                        int index172_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA172_11 = input.LA(1);
                        int index172_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA172_12 = input.LA(1);
                        int index172_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA172_13 = input.LA(1);
                        int index172_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA172_14 = input.LA(1);
                        int index172_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA172_15 = input.LA(1);
                        int index172_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA172_16 = input.LA(1);
                        int index172_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA172_17 = input.LA(1);
                        int index172_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA172_18 = input.LA(1);
                        int index172_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA172_19 = input.LA(1);
                        int index172_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA172_20 = input.LA(1);
                        int index172_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA172_21 = input.LA(1);
                        int index172_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA172_22 = input.LA(1);
                        int index172_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA172_23 = input.LA(1);
                        int index172_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA172_24 = input.LA(1);
                        int index172_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA172_25 = input.LA(1);
                        int index172_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA172_26 = input.LA(1);
                        int index172_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_26);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA172_27 = input.LA(1);
                        int index172_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_27);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA172_28 = input.LA(1);
                        int index172_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_28);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA172_29 = input.LA(1);
                        int index172_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_29);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA172_30 = input.LA(1);
                        int index172_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_30);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA172_31 = input.LA(1);
                        int index172_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_31);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA172_32 = input.LA(1);
                        int index172_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_32);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA172_33 = input.LA(1);
                        int index172_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_33);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA172_34 = input.LA(1);
                        int index172_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_34);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA172_35 = input.LA(1);
                        int index172_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_35);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA172_36 = input.LA(1);
                        int index172_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_36);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA172_37 = input.LA(1);
                        int index172_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_37);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA172_38 = input.LA(1);
                        int index172_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_38);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA172_39 = input.LA(1);
                        int index172_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_39);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA172_40 = input.LA(1);
                        int index172_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_40);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA172_41 = input.LA(1);
                        int index172_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_41);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA172_42 = input.LA(1);
                        int index172_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_42);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA172_43 = input.LA(1);
                        int index172_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_43);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA172_44 = input.LA(1);
                        int index172_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_44);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA172_45 = input.LA(1);
                        int index172_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_45);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA172_46 = input.LA(1);
                        int index172_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_46);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA172_47 = input.LA(1);
                        int index172_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_47);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA172_48 = input.LA(1);
                        int index172_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
                        else if ( (true) ) {s = 50;}
                        input.seek(index172_48);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA172_49 = input.LA(1);
                        int index172_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_InternalXtend()) ) {s = 99;}
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
        "\1\171\1\0\145\uffff";
    static final String DFA187_acceptS =
        "\2\uffff\1\2\143\uffff\1\1";
    static final String DFA187_specialS =
        "\1\uffff\1\0\145\uffff}>";
    static final String[] DFA187_transitionS = {
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
            return "9294:2: ( ( ( '<' )=>other= '<' ) ( (this_object= ruleJvmArgumentTypeReference ) ) (other= ',' ( (this_object= ruleJvmArgumentTypeReference ) ) )* other= '>' )?";
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
                        if ( (synpred49_InternalXtend()) ) {s = 102;}
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
        "\2\uffff\3\6\3\uffff\3\6";
    static final String DFA194_minS =
        "\1\4\1\uffff\3\31\1\4\2\uffff\3\31";
    static final String DFA194_maxS =
        "\1\67\1\uffff\3\142\1\134\2\uffff\3\142";
    static final String DFA194_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\1\3\3\uffff";
    static final String DFA194_specialS =
        "\13\uffff}>";
    static final String[] DFA194_transitionS = {
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
            return "9836:1: ( ( ( (other= 'static' ) ) ( (other= 'extension' ) )? ( ( ruleQualifiedName ) ) other= '.' other= '*' ) | ( ( ruleQualifiedName ) ) | ( (this_dataType= ruleQualifiedNameWithWildcard ) ) )";
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
    public static final BitSet FOLLOW_69_in_ruleXAnnotationElementValue7986 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleXAnnotationElementValue7998 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C0000F0L});
    public static final BitSet FOLLOW_ruleXAnnotationOrExpression_in_ruleXAnnotationElementValue8022 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_29_in_ruleXAnnotationElementValue8035 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXAnnotationOrExpression_in_ruleXAnnotationElementValue8056 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleXAnnotationElementValue8072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotationOrExpression_in_ruleXAnnotationElementValue8101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotationOrExpression_in_entryRuleXAnnotationOrExpression8142 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAnnotationOrExpression8152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAnnotation_in_ruleXAnnotationOrExpression8199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXAnnotationOrExpression8226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_entryRuleXExpression8267 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpression8277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXExpression8323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAssignment_in_entryRuleXAssignment8363 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAssignment8373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCallID_in_ruleXAssignment8431 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXAssignment8447 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment8467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_ruleXAssignment8497 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_ruleXAssignment8550 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXAssignment8573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_entryRuleOpSingleAssign8619 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpSingleAssign8630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOpSingleAssign8667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_entryRuleOpMultiAssign8713 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMultiAssign8724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleOpMultiAssign8762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleOpMultiAssign8781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOrExpression_in_entryRuleXOrExpression8827 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOrExpression8837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression8884 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleXOrExpression8937 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_ruleXOrExpression8960 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr9005 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr9016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleOpOr9053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAndExpression_in_entryRuleXAndExpression9098 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAndExpression9108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression9155 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleXAndExpression9208 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_ruleXAndExpression9231 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd9276 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd9287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleOpAnd9324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXEqualityExpression_in_entryRuleXEqualityExpression9369 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXEqualityExpression9379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression9426 = new BitSet(new long[]{0x0000000000000002L,0x000000000000F000L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleXEqualityExpression9479 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_ruleXEqualityExpression9502 = new BitSet(new long[]{0x0000000000000002L,0x000000000000F000L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality9547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality9558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleOpEquality9596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleOpEquality9615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleOpEquality9634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleOpEquality9653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXRelationalExpression_in_entryRuleXRelationalExpression9699 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXRelationalExpression9709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression9756 = new BitSet(new long[]{0x0000000050000002L,0x0000000000070000L});
    public static final BitSet FOLLOW_80_in_ruleXRelationalExpression9792 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXRelationalExpression9815 = new BitSet(new long[]{0x0000000050000002L,0x0000000000070000L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleXRelationalExpression9876 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_ruleXRelationalExpression9899 = new BitSet(new long[]{0x0000000050000002L,0x0000000000070000L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare9945 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare9956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleOpCompare9994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleOpCompare10013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpCompare10032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOpCompare10051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXOtherOperatorExpression_in_entryRuleXOtherOperatorExpression10097 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXOtherOperatorExpression10107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression10154 = new BitSet(new long[]{0x0000000050000002L,0x0000000003F80000L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleXOtherOperatorExpression10207 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_ruleXOtherOperatorExpression10230 = new BitSet(new long[]{0x0000000050000002L,0x0000000003F80000L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther10275 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther10286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleOpOther10324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleOpOther10343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpOther10363 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_ruleOpOther10376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_ruleOpOther10396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_ruleOpOther10415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpOther10435 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleOpOther10466 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleOpOther10479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleOpOther10500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOpOther10522 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleOpOther10553 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleOpOther10566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleOpOther10587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_ruleOpOther10608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_ruleOpOther10627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_ruleOpOther10646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXAdditiveExpression_in_entryRuleXAdditiveExpression10692 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXAdditiveExpression10702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression10749 = new BitSet(new long[]{0x0000000000000002L,0x000000000C000000L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleXAdditiveExpression10802 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_ruleXAdditiveExpression10825 = new BitSet(new long[]{0x0000000000000002L,0x000000000C000000L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd10870 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd10881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_ruleOpAdd10919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_ruleOpAdd10938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMultiplicativeExpression_in_entryRuleXMultiplicativeExpression10984 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMultiplicativeExpression10994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression11041 = new BitSet(new long[]{0x0000000000000002L,0x00000000F0000000L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleXMultiplicativeExpression11094 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXMultiplicativeExpression11117 = new BitSet(new long[]{0x0000000000000002L,0x00000000F0000000L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti11162 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti11173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_ruleOpMulti11211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_ruleOpMulti11230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_ruleOpMulti11249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_ruleOpMulti11268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_entryRuleXUnaryOperation11314 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXUnaryOperation11324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleXUnaryOperation11382 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXUnaryOperation_in_ruleXUnaryOperation11403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_ruleXUnaryOperation11432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary11474 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary11485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_ruleOpUnary11523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_ruleOpUnary11542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_ruleOpUnary11561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCastedExpression_in_entryRuleXCastedExpression11607 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCastedExpression11617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_ruleXCastedExpression11664 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_ruleXCastedExpression11699 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCastedExpression11722 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_ruleXMemberFeatureCall_in_entryRuleXMemberFeatureCall11766 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXMemberFeatureCall11776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_ruleXMemberFeatureCall11823 = new BitSet(new long[]{0x0000000000000002L,0x0000001C00000000L});
    public static final BitSet FOLLOW_98_in_ruleXMemberFeatureCall11895 = new BitSet(new long[]{0x02E7F4B98A000010L});
    public static final BitSet FOLLOW_99_in_ruleXMemberFeatureCall11919 = new BitSet(new long[]{0x02E7F4B98A000010L});
    public static final BitSet FOLLOW_ruleFeatureCallID_in_ruleXMemberFeatureCall11956 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_ruleXMemberFeatureCall11972 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXAssignment_in_ruleXMemberFeatureCall11994 = new BitSet(new long[]{0x0000000000000002L,0x0000001C00000000L});
    public static final BitSet FOLLOW_98_in_ruleXMemberFeatureCall12080 = new BitSet(new long[]{0x02E7F4B99A000010L});
    public static final BitSet FOLLOW_100_in_ruleXMemberFeatureCall12104 = new BitSet(new long[]{0x02E7F4B99A000010L});
    public static final BitSet FOLLOW_99_in_ruleXMemberFeatureCall12141 = new BitSet(new long[]{0x02E7F4B99A000010L});
    public static final BitSet FOLLOW_28_in_ruleXMemberFeatureCall12170 = new BitSet(new long[]{0x009FF1A002000010L,0x0100000000400000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall12191 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleXMemberFeatureCall12204 = new BitSet(new long[]{0x009FF1A002000010L,0x0100000000400000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXMemberFeatureCall12225 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_30_in_ruleXMemberFeatureCall12239 = new BitSet(new long[]{0x02E7F4B98A000010L});
    public static final BitSet FOLLOW_ruleFeatureCallID_in_ruleXMemberFeatureCall12264 = new BitSet(new long[]{0x0000010000000002L,0x0000001C00000040L});
    public static final BitSet FOLLOW_40_in_ruleXMemberFeatureCall12298 = new BitSet(new long[]{0x02FFFFBB9A0070F0L,0x003FF9610C400070L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXMemberFeatureCall12383 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall12411 = new BitSet(new long[]{0x0000020020000000L});
    public static final BitSet FOLLOW_29_in_ruleXMemberFeatureCall12424 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXMemberFeatureCall12445 = new BitSet(new long[]{0x0000020020000000L});
    public static final BitSet FOLLOW_41_in_ruleXMemberFeatureCall12462 = new BitSet(new long[]{0x0000000000000002L,0x0000001C00000040L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXMemberFeatureCall12497 = new BitSet(new long[]{0x0000000000000002L,0x0000001C00000000L});
    public static final BitSet FOLLOW_ruleXPrimaryExpression_in_entryRuleXPrimaryExpression12543 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXPrimaryExpression12553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_ruleXPrimaryExpression12600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_ruleXPrimaryExpression12627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_ruleXPrimaryExpression12654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_ruleXPrimaryExpression12681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_ruleXPrimaryExpression12708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_ruleXPrimaryExpression12735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_ruleXPrimaryExpression12762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_ruleXPrimaryExpression12789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_ruleXPrimaryExpression12816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_ruleXPrimaryExpression12843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_ruleXPrimaryExpression12870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_ruleXPrimaryExpression12897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_ruleXPrimaryExpression12924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXLiteral_in_entryRuleXLiteral12965 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXLiteral12975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCollectionLiteral_in_ruleXLiteral13022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXLiteral13062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_ruleXLiteral13090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNumberLiteral_in_ruleXLiteral13117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_ruleXLiteral13144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXStringLiteral_in_ruleXLiteral13171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_ruleXLiteral13198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCollectionLiteral_in_entryRuleXCollectionLiteral13239 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCollectionLiteral13249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSetLiteral_in_ruleXCollectionLiteral13296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXListLiteral_in_ruleXCollectionLiteral13323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSetLiteral_in_entryRuleXSetLiteral13364 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSetLiteral13374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleXSetLiteral13420 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleXSetLiteral13432 = new BitSet(new long[]{0x02E7FDBF9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSetLiteral13454 = new BitSet(new long[]{0x0000000420000000L});
    public static final BitSet FOLLOW_29_in_ruleXSetLiteral13467 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSetLiteral13488 = new BitSet(new long[]{0x0000000420000000L});
    public static final BitSet FOLLOW_34_in_ruleXSetLiteral13504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXListLiteral_in_entryRuleXListLiteral13546 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXListLiteral13556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleXListLiteral13602 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleXListLiteral13614 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C0000F0L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXListLiteral13636 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_29_in_ruleXListLiteral13649 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXListLiteral13670 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleXListLiteral13686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXClosure_in_entryRuleXClosure13728 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXClosure13738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleXClosure13798 = new BitSet(new long[]{0x02FFFDBB9A0070F0L,0x003FF9610C4000F0L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure13871 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_29_in_ruleXClosure13884 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXClosure13905 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_ruleXClosure13927 = new BitSet(new long[]{0x02FFFDBB9A0070F0L,0x003FF9410C0000F0L});
    public static final BitSet FOLLOW_ruleXExpressionInClosure_in_ruleXClosure13964 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleXClosure13976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInClosure_in_entryRuleXExpressionInClosure14018 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInClosure14028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXExpressionInClosure14084 = new BitSet(new long[]{0x02FFFDBB9E0070F2L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_26_in_ruleXExpressionInClosure14097 = new BitSet(new long[]{0x02FFFDBB9A0070F2L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_entryRuleXShortClosure14143 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXShortClosure14153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure14261 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_29_in_ruleXShortClosure14274 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXShortClosure14295 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_ruleXShortClosure14317 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXShortClosure14353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXParenthesizedExpression_in_entryRuleXParenthesizedExpression14395 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXParenthesizedExpression14405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleXParenthesizedExpression14442 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXParenthesizedExpression14464 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXParenthesizedExpression14475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXIfExpression_in_entryRuleXIfExpression14517 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXIfExpression14527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_ruleXIfExpression14573 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXIfExpression14585 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression14606 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXIfExpression14618 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression14639 = new BitSet(new long[]{0x0000000000000002L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_ruleXIfExpression14660 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXIfExpression14682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXSwitchExpression_in_entryRuleXSwitchExpression14726 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXSwitchExpression14736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_ruleXSwitchExpression14782 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXSwitchExpression14825 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleXSwitchExpression14837 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression14861 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_40_in_ruleXSwitchExpression14905 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXSwitchExpression14926 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleXSwitchExpression14938 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression14961 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXSwitchExpression14973 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleXSwitchExpression14987 = new BitSet(new long[]{0x019FF1A002000010L,0x0000040000400000L});
    public static final BitSet FOLLOW_ruleXCasePart_in_ruleXSwitchExpression15008 = new BitSet(new long[]{0x019FF1A402000010L,0x0000060000400000L});
    public static final BitSet FOLLOW_105_in_ruleXSwitchExpression15022 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleXSwitchExpression15034 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXSwitchExpression15055 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleXSwitchExpression15069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCasePart_in_entryRuleXCasePart15111 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCasePart15121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXCasePart15167 = new BitSet(new long[]{0x0100000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_106_in_ruleXCasePart15181 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart15202 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleXCasePart15216 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCasePart15237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXForLoopExpression_in_entryRuleXForLoopExpression15279 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXForLoopExpression15289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_ruleXForLoopExpression15335 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXForLoopExpression15347 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_ruleXForLoopExpression15368 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleXForLoopExpression15380 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression15401 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXForLoopExpression15413 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXForLoopExpression15434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXWhileExpression_in_entryRuleXWhileExpression15476 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXWhileExpression15486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_ruleXWhileExpression15532 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXWhileExpression15544 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression15565 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXWhileExpression15577 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXWhileExpression15598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXDoWhileExpression_in_entryRuleXDoWhileExpression15640 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXDoWhileExpression15650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_ruleXDoWhileExpression15696 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression15717 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_108_in_ruleXDoWhileExpression15729 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXDoWhileExpression15741 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXDoWhileExpression15762 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXDoWhileExpression15774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBlockExpression_in_entryRuleXBlockExpression15816 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBlockExpression15826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleXBlockExpression15872 = new BitSet(new long[]{0x02FFFDBF9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_ruleXBlockExpression15894 = new BitSet(new long[]{0x02FFFDBF9E0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_26_in_ruleXBlockExpression15907 = new BitSet(new long[]{0x02FFFDBF9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_34_in_ruleXBlockExpression15923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpressionInsideBlock_in_entryRuleXExpressionInsideBlock15965 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExpressionInsideBlock15975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXVariableDeclaration_in_ruleXExpressionInsideBlock16124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXExpressionInsideBlock16152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFeatureCall_in_entryRuleXFeatureCall16193 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFeatureCall16203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleXFeatureCall16250 = new BitSet(new long[]{0x009FF1A002000010L,0x0100000000400000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall16271 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleXFeatureCall16284 = new BitSet(new long[]{0x009FF1A002000010L,0x0100000000400000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXFeatureCall16305 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_30_in_ruleXFeatureCall16319 = new BitSet(new long[]{0x02E7F4B99A000010L,0x0000400000000000L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_ruleXFeatureCall16344 = new BitSet(new long[]{0x0000010000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_40_in_ruleXFeatureCall16378 = new BitSet(new long[]{0x02FFFFBB9A0070F0L,0x003FF9610C400070L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXFeatureCall16463 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall16491 = new BitSet(new long[]{0x0000020020000000L});
    public static final BitSet FOLLOW_29_in_ruleXFeatureCall16504 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXFeatureCall16525 = new BitSet(new long[]{0x0000020020000000L});
    public static final BitSet FOLLOW_41_in_ruleXFeatureCall16542 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXFeatureCall16577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdOrSuper_in_entryRuleIdOrSuper16621 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdOrSuper16632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCallID_in_ruleIdOrSuper16679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_ruleIdOrSuper16703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXConstructorCall_in_entryRuleXConstructorCall16749 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXConstructorCall16759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleXConstructorCall16805 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXConstructorCall16828 = new BitSet(new long[]{0x0000010010000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_28_in_ruleXConstructorCall16849 = new BitSet(new long[]{0x009FF1A002000010L,0x0100000000400000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall16871 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleXConstructorCall16884 = new BitSet(new long[]{0x009FF1A002000010L,0x0100000000400000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleXConstructorCall16905 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_30_in_ruleXConstructorCall16919 = new BitSet(new long[]{0x0000010000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_40_in_ruleXConstructorCall16942 = new BitSet(new long[]{0x02FFFFBB9A0070F0L,0x003FF9610C400070L});
    public static final BitSet FOLLOW_ruleXShortClosure_in_ruleXConstructorCall17015 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall17043 = new BitSet(new long[]{0x0000020020000000L});
    public static final BitSet FOLLOW_29_in_ruleXConstructorCall17056 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXConstructorCall17077 = new BitSet(new long[]{0x0000020020000000L});
    public static final BitSet FOLLOW_41_in_ruleXConstructorCall17094 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleXClosure_in_ruleXConstructorCall17129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXBooleanLiteral_in_entryRuleXBooleanLiteral17172 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXBooleanLiteral17182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_ruleXBooleanLiteral17229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_ruleXBooleanLiteral17253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNullLiteral_in_entryRuleXNullLiteral17309 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNullLiteral17319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_ruleXNullLiteral17365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXNumberLiteral_in_entryRuleXNumberLiteral17407 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXNumberLiteral17417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_ruleXNumberLiteral17472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTypeLiteral_in_entryRuleXTypeLiteral17514 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTypeLiteral17524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_ruleXTypeLiteral17570 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXTypeLiteral17582 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXTypeLiteral17605 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_ruleXTypeLiteral17626 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_41_in_ruleXTypeLiteral17639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXThrowExpression_in_entryRuleXThrowExpression17681 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXThrowExpression17691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_ruleXThrowExpression17737 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXThrowExpression17758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXReturnExpression_in_entryRuleXReturnExpression17800 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXReturnExpression17810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_ruleXReturnExpression17856 = new BitSet(new long[]{0x02E7FDBB9A0070F2L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXReturnExpression17887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXTryCatchFinallyExpression_in_entryRuleXTryCatchFinallyExpression17930 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXTryCatchFinallyExpression17940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_ruleXTryCatchFinallyExpression17986 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression18007 = new BitSet(new long[]{0x0000000000000000L,0x00C0000000000000L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_ruleXTryCatchFinallyExpression18037 = new BitSet(new long[]{0x0000000000000002L,0x00C0000000000000L});
    public static final BitSet FOLLOW_118_in_ruleXTryCatchFinallyExpression18059 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression18081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_ruleXTryCatchFinallyExpression18103 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXTryCatchFinallyExpression18124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXCatchClause_in_entryRuleXCatchClause18168 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXCatchClause18178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_ruleXCatchClause18223 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleXCatchClause18236 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleFullJvmFormalParameter_in_ruleXCatchClause18257 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleXCatchClause18269 = new BitSet(new long[]{0x02E7FDBB9A0070F0L,0x003FF9410C000070L});
    public static final BitSet FOLLOW_ruleXExpression_in_ruleXCatchClause18290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName18333 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName18344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName18391 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_ruleQualifiedName18419 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName18442 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_ruleNumber_in_entryRuleNumber18496 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumber18507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleNumber18551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNumber18579 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_ruleNumber18605 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_ruleNumber18625 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNumber18641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_ruleNumber18667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference18728 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference18738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference18786 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_ruleJvmTypeReference18822 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference18853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets18895 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayBrackets18906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleArrayBrackets18944 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleArrayBrackets18957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef19003 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef19013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleXFunctionTypeRef19051 = new BitSet(new long[]{0x009FF3A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef19073 = new BitSet(new long[]{0x0000020020000000L});
    public static final BitSet FOLLOW_29_in_ruleXFunctionTypeRef19086 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef19107 = new BitSet(new long[]{0x0000020020000000L});
    public static final BitSet FOLLOW_41_in_ruleXFunctionTypeRef19123 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_ruleXFunctionTypeRef19137 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef19158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference19200 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference19210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference19258 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleJvmParameterizedTypeReference19279 = new BitSet(new long[]{0x009FF1A002000010L,0x0100000000400000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference19301 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleJvmParameterizedTypeReference19314 = new BitSet(new long[]{0x009FF1A002000010L,0x0100000000400000L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference19335 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_30_in_ruleJvmParameterizedTypeReference19349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference19393 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference19403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference19450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference19477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference19518 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference19528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_ruleJvmWildcardTypeReference19574 = new BitSet(new long[]{0x0000000080000002L,0x0000400000000000L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference19596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference19623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound19667 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound19677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleJvmUpperBound19714 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound19735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded19777 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded19787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_ruleJvmUpperBoundAnded19824 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded19845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound19887 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound19897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_ruleJvmLowerBound19934 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound19955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeParameter_in_entryRuleJvmTypeParameter19997 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeParameter20007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleJvmTypeParameter20053 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmTypeParameter20075 = new BitSet(new long[]{0x0000000000000002L,0x0200000000000000L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_ruleJvmTypeParameter20096 = new BitSet(new long[]{0x0000000000000002L,0x0200000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard20142 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard20153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard20200 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_ruleQualifiedNameWithWildcard20218 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_ruleQualifiedNameWithWildcard20231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportSection_in_entryRuleXImportSection20277 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXImportSection20287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportDeclaration_in_ruleXImportSection20332 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_ruleXImportDeclaration_in_entryRuleXImportDeclaration20374 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXImportDeclaration20384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleXImportDeclaration20421 = new BitSet(new long[]{0x0081002000000010L});
    public static final BitSet FOLLOW_48_in_ruleXImportDeclaration20441 = new BitSet(new long[]{0x008000A000000010L});
    public static final BitSet FOLLOW_39_in_ruleXImportDeclaration20472 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXImportDeclaration20509 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_ruleXImportDeclaration20521 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_ruleXImportDeclaration20533 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleXImportDeclaration20563 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_ruleXImportDeclaration20590 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleXImportDeclaration20604 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_69_in_synpred10_InternalXtend7963 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_synpred10_InternalXtend7967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMultiAssign_in_synpred11_InternalXtend8518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred12_InternalXtend8905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred13_InternalXtend9176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred14_InternalXtend9447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_synpred15_InternalXtend9773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred16_InternalXtend9844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred17_InternalXtend10175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_synpred18_InternalXtend10450 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_synpred18_InternalXtend10455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_synpred19_InternalXtend10537 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_synpred19_InternalXtend10542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred20_InternalXtend10770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred21_InternalXtend11062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_synpred22_InternalXtend11680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_synpred23_InternalXtend11841 = new BitSet(new long[]{0x02E7F4B98A000010L});
    public static final BitSet FOLLOW_99_in_synpred23_InternalXtend11855 = new BitSet(new long[]{0x02E7F4B98A000010L});
    public static final BitSet FOLLOW_ruleFeatureCallID_in_synpred23_InternalXtend11871 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_ruleOpSingleAssign_in_synpred23_InternalXtend11877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_synpred24_InternalXtend12019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_synpred24_InternalXtend12033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_synpred24_InternalXtend12053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_synpred25_InternalXtend12280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred26_InternalXtend12332 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_29_in_synpred26_InternalXtend12339 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred26_InternalXtend12346 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_synpred26_InternalXtend12360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_synpred27_InternalXtend12480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_synpred28_InternalXtend13043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred30_InternalXtend13817 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_29_in_synpred30_InternalXtend13824 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred30_InternalXtend13831 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_synpred30_InternalXtend13845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_synpred32_InternalXtend14652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred33_InternalXtend14800 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_synpred33_InternalXtend14806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_synpred34_InternalXtend14882 = new BitSet(new long[]{0x0080002000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_synpred34_InternalXtend14889 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_synpred34_InternalXtend14895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_synpred35_InternalXtend16023 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_51_in_synpred35_InternalXtend16039 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_synpred35_InternalXtend16048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_synpred35_InternalXtend16071 = new BitSet(new long[]{0x0018000000000000L});
    public static final BitSet FOLLOW_52_in_synpred35_InternalXtend16086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_synpred35_InternalXtend16102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_synpred36_InternalXtend16360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred37_InternalXtend16412 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_29_in_synpred37_InternalXtend16419 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred37_InternalXtend16426 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_synpred37_InternalXtend16440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_synpred38_InternalXtend16560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_synpred39_InternalXtend16841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_synpred40_InternalXtend16934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred41_InternalXtend16964 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_29_in_synpred41_InternalXtend16971 = new BitSet(new long[]{0x009FF1A002000010L,0x0000000000400000L});
    public static final BitSet FOLLOW_ruleJvmFormalParameter_in_synpred41_InternalXtend16978 = new BitSet(new long[]{0x0000000020000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_synpred41_InternalXtend16992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_synpred42_InternalXtend17112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExpression_in_synpred43_InternalXtend17870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_synpred44_InternalXtend18021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_synpred45_InternalXtend18051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_synpred47_InternalXtend18410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_synpred48_InternalXtend18801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_synpred49_InternalXtend19271 = new BitSet(new long[]{0x0000000000000002L});
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

	private EObject callRuleXAnnotationOrExpressionAndAdd(BitSet followSet, EObject current, AbstractElement grammarElement, ParserRule rule, int featureId, String ruleName) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXAnnotationOrExpression();
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

	private EObject callUnassignedRuleXAnnotationOrExpression(BitSet followSet, AbstractElement grammarElement) throws RecognitionException {
		pushFollow(followSet, grammarElement);
		EObject token = ruleXAnnotationOrExpression();
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