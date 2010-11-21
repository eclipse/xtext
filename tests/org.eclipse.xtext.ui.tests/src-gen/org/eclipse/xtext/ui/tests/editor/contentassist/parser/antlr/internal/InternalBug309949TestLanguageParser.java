package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug309949TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug309949TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1*'", "'{'", "'}'", "'#1+'", "'#2*'", "'#2+'", "'#3*'", "'#3+'", "'#4*'", "'#4+'", "'#5*'", "'#5+'", "'error'", "'operation'", "'@uuid'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int RULE_ID=4;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__22=22;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int RULE_INT=5;
    public static final int EOF=-1;
    public static final int T__16=16;
    public static final int T__24=24;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalBug309949TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug309949TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug309949TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g"; }



     	private Bug309949TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug309949TestLanguageParser(TokenStream input, IAstFactory factory, Bug309949TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.semanticModelBuilder = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected Bug309949TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:70:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:71:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:72:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:79:1: ruleModel returns [EObject current=null] : ( () ( (otherlv_1= '#1*' otherlv_2= '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* otherlv_5= '}' ) | (otherlv_6= '#1+' otherlv_7= '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ otherlv_10= '}' ) | (otherlv_11= '#2*' otherlv_12= '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* otherlv_15= '}' ) | (otherlv_16= '#2+' ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ otherlv_21= '}' ) | (otherlv_22= '#3*' ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* otherlv_27= '}' ) | (otherlv_28= '#3+' ( (lv_name_29_0= RULE_ID ) ) otherlv_30= '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ otherlv_33= '}' ) | (otherlv_34= '#4*' ( (lv_name_35_0= RULE_ID ) ) otherlv_36= '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* otherlv_39= '}' ) | (otherlv_40= '#4+' ( (lv_name_41_0= RULE_ID ) ) otherlv_42= '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ otherlv_45= '}' ) | (otherlv_46= '#5*' ( (lv_name_47_0= RULE_ID ) ) otherlv_48= '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* otherlv_51= '}' ) | (otherlv_52= '#5+' ( (lv_name_53_0= RULE_ID ) ) otherlv_54= '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ otherlv_57= '}' ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token lv_name_17_0=null;
        Token otherlv_18=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token lv_name_23_0=null;
        Token otherlv_24=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token lv_name_29_0=null;
        Token otherlv_30=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token lv_name_35_0=null;
        Token otherlv_36=null;
        Token otherlv_39=null;
        Token otherlv_40=null;
        Token lv_name_41_0=null;
        Token otherlv_42=null;
        Token otherlv_45=null;
        Token otherlv_46=null;
        Token lv_name_47_0=null;
        Token otherlv_48=null;
        Token otherlv_51=null;
        Token otherlv_52=null;
        Token lv_name_53_0=null;
        Token otherlv_54=null;
        Token otherlv_57=null;
        EObject lv_errors_3_0 = null;

        EObject lv_operations_4_0 = null;

        EObject lv_errors_8_0 = null;

        EObject lv_operations_9_0 = null;

        EObject lv_errors_13_0 = null;

        EObject lv_operations_14_0 = null;

        EObject lv_errors_19_0 = null;

        EObject lv_operations_20_0 = null;

        EObject lv_errors_25_0 = null;

        EObject lv_operations_26_0 = null;

        EObject lv_errors_31_0 = null;

        EObject lv_operations_32_0 = null;

        EObject lv_errors_37_0 = null;

        EObject lv_operations_38_0 = null;

        EObject lv_errors_43_0 = null;

        EObject lv_operations_44_0 = null;

        EObject lv_errors_49_0 = null;

        EObject lv_operations_50_0 = null;

        EObject lv_errors_55_0 = null;

        EObject lv_operations_56_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:82:28: ( ( () ( (otherlv_1= '#1*' otherlv_2= '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* otherlv_5= '}' ) | (otherlv_6= '#1+' otherlv_7= '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ otherlv_10= '}' ) | (otherlv_11= '#2*' otherlv_12= '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* otherlv_15= '}' ) | (otherlv_16= '#2+' ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ otherlv_21= '}' ) | (otherlv_22= '#3*' ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* otherlv_27= '}' ) | (otherlv_28= '#3+' ( (lv_name_29_0= RULE_ID ) ) otherlv_30= '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ otherlv_33= '}' ) | (otherlv_34= '#4*' ( (lv_name_35_0= RULE_ID ) ) otherlv_36= '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* otherlv_39= '}' ) | (otherlv_40= '#4+' ( (lv_name_41_0= RULE_ID ) ) otherlv_42= '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ otherlv_45= '}' ) | (otherlv_46= '#5*' ( (lv_name_47_0= RULE_ID ) ) otherlv_48= '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* otherlv_51= '}' ) | (otherlv_52= '#5+' ( (lv_name_53_0= RULE_ID ) ) otherlv_54= '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ otherlv_57= '}' ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:83:1: ( () ( (otherlv_1= '#1*' otherlv_2= '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* otherlv_5= '}' ) | (otherlv_6= '#1+' otherlv_7= '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ otherlv_10= '}' ) | (otherlv_11= '#2*' otherlv_12= '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* otherlv_15= '}' ) | (otherlv_16= '#2+' ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ otherlv_21= '}' ) | (otherlv_22= '#3*' ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* otherlv_27= '}' ) | (otherlv_28= '#3+' ( (lv_name_29_0= RULE_ID ) ) otherlv_30= '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ otherlv_33= '}' ) | (otherlv_34= '#4*' ( (lv_name_35_0= RULE_ID ) ) otherlv_36= '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* otherlv_39= '}' ) | (otherlv_40= '#4+' ( (lv_name_41_0= RULE_ID ) ) otherlv_42= '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ otherlv_45= '}' ) | (otherlv_46= '#5*' ( (lv_name_47_0= RULE_ID ) ) otherlv_48= '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* otherlv_51= '}' ) | (otherlv_52= '#5+' ( (lv_name_53_0= RULE_ID ) ) otherlv_54= '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ otherlv_57= '}' ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:83:1: ( () ( (otherlv_1= '#1*' otherlv_2= '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* otherlv_5= '}' ) | (otherlv_6= '#1+' otherlv_7= '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ otherlv_10= '}' ) | (otherlv_11= '#2*' otherlv_12= '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* otherlv_15= '}' ) | (otherlv_16= '#2+' ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ otherlv_21= '}' ) | (otherlv_22= '#3*' ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* otherlv_27= '}' ) | (otherlv_28= '#3+' ( (lv_name_29_0= RULE_ID ) ) otherlv_30= '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ otherlv_33= '}' ) | (otherlv_34= '#4*' ( (lv_name_35_0= RULE_ID ) ) otherlv_36= '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* otherlv_39= '}' ) | (otherlv_40= '#4+' ( (lv_name_41_0= RULE_ID ) ) otherlv_42= '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ otherlv_45= '}' ) | (otherlv_46= '#5*' ( (lv_name_47_0= RULE_ID ) ) otherlv_48= '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* otherlv_51= '}' ) | (otherlv_52= '#5+' ( (lv_name_53_0= RULE_ID ) ) otherlv_54= '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ otherlv_57= '}' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:83:2: () ( (otherlv_1= '#1*' otherlv_2= '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* otherlv_5= '}' ) | (otherlv_6= '#1+' otherlv_7= '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ otherlv_10= '}' ) | (otherlv_11= '#2*' otherlv_12= '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* otherlv_15= '}' ) | (otherlv_16= '#2+' ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ otherlv_21= '}' ) | (otherlv_22= '#3*' ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* otherlv_27= '}' ) | (otherlv_28= '#3+' ( (lv_name_29_0= RULE_ID ) ) otherlv_30= '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ otherlv_33= '}' ) | (otherlv_34= '#4*' ( (lv_name_35_0= RULE_ID ) ) otherlv_36= '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* otherlv_39= '}' ) | (otherlv_40= '#4+' ( (lv_name_41_0= RULE_ID ) ) otherlv_42= '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ otherlv_45= '}' ) | (otherlv_46= '#5*' ( (lv_name_47_0= RULE_ID ) ) otherlv_48= '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* otherlv_51= '}' ) | (otherlv_52= '#5+' ( (lv_name_53_0= RULE_ID ) ) otherlv_54= '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ otherlv_57= '}' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:83:2: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:84:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getModelAccess().getModelAction_0(),
                        current);
                

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:89:2: ( (otherlv_1= '#1*' otherlv_2= '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* otherlv_5= '}' ) | (otherlv_6= '#1+' otherlv_7= '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ otherlv_10= '}' ) | (otherlv_11= '#2*' otherlv_12= '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* otherlv_15= '}' ) | (otherlv_16= '#2+' ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ otherlv_21= '}' ) | (otherlv_22= '#3*' ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* otherlv_27= '}' ) | (otherlv_28= '#3+' ( (lv_name_29_0= RULE_ID ) ) otherlv_30= '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ otherlv_33= '}' ) | (otherlv_34= '#4*' ( (lv_name_35_0= RULE_ID ) ) otherlv_36= '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* otherlv_39= '}' ) | (otherlv_40= '#4+' ( (lv_name_41_0= RULE_ID ) ) otherlv_42= '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ otherlv_45= '}' ) | (otherlv_46= '#5*' ( (lv_name_47_0= RULE_ID ) ) otherlv_48= '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* otherlv_51= '}' ) | (otherlv_52= '#5+' ( (lv_name_53_0= RULE_ID ) ) otherlv_54= '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ otherlv_57= '}' ) )
            int alt21=10;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt21=1;
                }
                break;
            case 14:
                {
                alt21=2;
                }
                break;
            case 15:
                {
                alt21=3;
                }
                break;
            case 16:
                {
                alt21=4;
                }
                break;
            case 17:
                {
                alt21=5;
                }
                break;
            case 18:
                {
                alt21=6;
                }
                break;
            case 19:
                {
                alt21=7;
                }
                break;
            case 20:
                {
                alt21=8;
                }
                break;
            case 21:
                {
                alt21=9;
                }
                break;
            case 22:
                {
                alt21=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:89:3: (otherlv_1= '#1*' otherlv_2= '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* otherlv_5= '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:89:3: (otherlv_1= '#1*' otherlv_2= '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* otherlv_5= '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:89:5: otherlv_1= '#1*' otherlv_2= '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* otherlv_5= '}'
                    {
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel133); 

                        	newLeafNode(otherlv_1, grammarAccess.getModelAccess().getNumberSignDigitOneAsteriskKeyword_1_0_0());
                        
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel145); 

                        	newLeafNode(otherlv_2, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_0_1());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:97:1: ( (lv_errors_3_0= ruleError_1 ) )*
                    loop1:
                    do {
                        int alt1=2;
                        alt1 = dfa1.predict(input);
                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:98:1: (lv_errors_3_0= ruleError_1 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:98:1: (lv_errors_3_0= ruleError_1 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:99:3: lv_errors_3_0= ruleError_1
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getErrorsError_1ParserRuleCall_1_0_2_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleError_1_in_ruleModel166);
                    	    lv_errors_3_0=ruleError_1();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"errors",
                    	            		lv_errors_3_0, 
                    	            		"Error_1");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:115:3: ( (lv_operations_4_0= ruleOperation_1 ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>=24 && LA2_0<=25)) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:116:1: (lv_operations_4_0= ruleOperation_1 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:116:1: (lv_operations_4_0= ruleOperation_1 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:117:3: lv_operations_4_0= ruleOperation_1
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_1ParserRuleCall_1_0_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleOperation_1_in_ruleModel188);
                    	    lv_operations_4_0=ruleOperation_1();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_4_0, 
                    	            		"Operation_1");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel201); 

                        	newLeafNode(otherlv_5, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_0_4());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:138:6: (otherlv_6= '#1+' otherlv_7= '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ otherlv_10= '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:138:6: (otherlv_6= '#1+' otherlv_7= '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ otherlv_10= '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:138:8: otherlv_6= '#1+' otherlv_7= '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ otherlv_10= '}'
                    {
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModel221); 

                        	newLeafNode(otherlv_6, grammarAccess.getModelAccess().getNumberSignDigitOnePlusSignKeyword_1_1_0());
                        
                    otherlv_7=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel233); 

                        	newLeafNode(otherlv_7, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_1_1());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:146:1: ( (lv_errors_8_0= ruleError_1 ) )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        alt3 = dfa3.predict(input);
                        switch (alt3) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:147:1: (lv_errors_8_0= ruleError_1 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:147:1: (lv_errors_8_0= ruleError_1 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:148:3: lv_errors_8_0= ruleError_1
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getErrorsError_1ParserRuleCall_1_1_2_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleError_1_in_ruleModel254);
                    	    lv_errors_8_0=ruleError_1();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"errors",
                    	            		lv_errors_8_0, 
                    	            		"Error_1");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:164:3: ( (lv_operations_9_0= ruleOperation_1 ) )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>=24 && LA4_0<=25)) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:165:1: (lv_operations_9_0= ruleOperation_1 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:165:1: (lv_operations_9_0= ruleOperation_1 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:166:3: lv_operations_9_0= ruleOperation_1
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_1ParserRuleCall_1_1_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleOperation_1_in_ruleModel276);
                    	    lv_operations_9_0=ruleOperation_1();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_9_0, 
                    	            		"Operation_1");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);

                    otherlv_10=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel289); 

                        	newLeafNode(otherlv_10, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_1_4());
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:187:6: (otherlv_11= '#2*' otherlv_12= '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* otherlv_15= '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:187:6: (otherlv_11= '#2*' otherlv_12= '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* otherlv_15= '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:187:8: otherlv_11= '#2*' otherlv_12= '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* otherlv_15= '}'
                    {
                    otherlv_11=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModel309); 

                        	newLeafNode(otherlv_11, grammarAccess.getModelAccess().getNumberSignDigitTwoAsteriskKeyword_1_2_0());
                        
                    otherlv_12=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel321); 

                        	newLeafNode(otherlv_12, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_2_1());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:195:1: ( (lv_errors_13_0= ruleError_2 ) )*
                    loop5:
                    do {
                        int alt5=2;
                        alt5 = dfa5.predict(input);
                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:196:1: (lv_errors_13_0= ruleError_2 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:196:1: (lv_errors_13_0= ruleError_2 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:197:3: lv_errors_13_0= ruleError_2
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getErrorsError_2ParserRuleCall_1_2_2_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleError_2_in_ruleModel342);
                    	    lv_errors_13_0=ruleError_2();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"errors",
                    	            		lv_errors_13_0, 
                    	            		"Error_2");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:213:3: ( (lv_operations_14_0= ruleOperation_2 ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==25) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:214:1: (lv_operations_14_0= ruleOperation_2 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:214:1: (lv_operations_14_0= ruleOperation_2 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:215:3: lv_operations_14_0= ruleOperation_2
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_2ParserRuleCall_1_2_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleOperation_2_in_ruleModel364);
                    	    lv_operations_14_0=ruleOperation_2();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_14_0, 
                    	            		"Operation_2");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel377); 

                        	newLeafNode(otherlv_15, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_2_4());
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:236:6: (otherlv_16= '#2+' ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ otherlv_21= '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:236:6: (otherlv_16= '#2+' ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ otherlv_21= '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:236:8: otherlv_16= '#2+' ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ otherlv_21= '}'
                    {
                    otherlv_16=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleModel397); 

                        	newLeafNode(otherlv_16, grammarAccess.getModelAccess().getNumberSignDigitTwoPlusSignKeyword_1_3_0());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:240:1: ( (lv_name_17_0= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:241:1: (lv_name_17_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:241:1: (lv_name_17_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:242:3: lv_name_17_0= RULE_ID
                    {
                    lv_name_17_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel414); 

                    			newLeafNode(lv_name_17_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModelRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_17_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_18=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel431); 

                        	newLeafNode(otherlv_18, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_3_2());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:262:1: ( (lv_errors_19_0= ruleError_2 ) )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        alt7 = dfa7.predict(input);
                        switch (alt7) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:263:1: (lv_errors_19_0= ruleError_2 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:263:1: (lv_errors_19_0= ruleError_2 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:264:3: lv_errors_19_0= ruleError_2
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getErrorsError_2ParserRuleCall_1_3_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleError_2_in_ruleModel452);
                    	    lv_errors_19_0=ruleError_2();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"errors",
                    	            		lv_errors_19_0, 
                    	            		"Error_2");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:280:3: ( (lv_operations_20_0= ruleOperation_2 ) )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==25) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:281:1: (lv_operations_20_0= ruleOperation_2 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:281:1: (lv_operations_20_0= ruleOperation_2 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:282:3: lv_operations_20_0= ruleOperation_2
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_2ParserRuleCall_1_3_4_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleOperation_2_in_ruleModel474);
                    	    lv_operations_20_0=ruleOperation_2();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_20_0, 
                    	            		"Operation_2");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);

                    otherlv_21=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel487); 

                        	newLeafNode(otherlv_21, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_3_5());
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:303:6: (otherlv_22= '#3*' ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* otherlv_27= '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:303:6: (otherlv_22= '#3*' ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* otherlv_27= '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:303:8: otherlv_22= '#3*' ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* otherlv_27= '}'
                    {
                    otherlv_22=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModel507); 

                        	newLeafNode(otherlv_22, grammarAccess.getModelAccess().getNumberSignDigitThreeAsteriskKeyword_1_4_0());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:307:1: ( (lv_name_23_0= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:308:1: (lv_name_23_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:308:1: (lv_name_23_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:309:3: lv_name_23_0= RULE_ID
                    {
                    lv_name_23_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel524); 

                    			newLeafNode(lv_name_23_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_4_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModelRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_23_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_24=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel541); 

                        	newLeafNode(otherlv_24, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_4_2());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:329:1: ( (lv_errors_25_0= ruleError_3 ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==25) ) {
                            int LA9_1 = input.LA(2);

                            if ( (LA9_1==RULE_ID) ) {
                                int LA9_4 = input.LA(3);

                                if ( (LA9_4==23) ) {
                                    alt9=1;
                                }


                            }


                        }
                        else if ( (LA9_0==23) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:330:1: (lv_errors_25_0= ruleError_3 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:330:1: (lv_errors_25_0= ruleError_3 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:331:3: lv_errors_25_0= ruleError_3
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getErrorsError_3ParserRuleCall_1_4_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleError_3_in_ruleModel562);
                    	    lv_errors_25_0=ruleError_3();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"errors",
                    	            		lv_errors_25_0, 
                    	            		"Error_3");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:347:3: ( (lv_operations_26_0= ruleOperation_3 ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>=24 && LA10_0<=25)) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:348:1: (lv_operations_26_0= ruleOperation_3 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:348:1: (lv_operations_26_0= ruleOperation_3 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:349:3: lv_operations_26_0= ruleOperation_3
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_3ParserRuleCall_1_4_4_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleOperation_3_in_ruleModel584);
                    	    lv_operations_26_0=ruleOperation_3();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_26_0, 
                    	            		"Operation_3");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    otherlv_27=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel597); 

                        	newLeafNode(otherlv_27, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_4_5());
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:370:6: (otherlv_28= '#3+' ( (lv_name_29_0= RULE_ID ) ) otherlv_30= '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ otherlv_33= '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:370:6: (otherlv_28= '#3+' ( (lv_name_29_0= RULE_ID ) ) otherlv_30= '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ otherlv_33= '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:370:8: otherlv_28= '#3+' ( (lv_name_29_0= RULE_ID ) ) otherlv_30= '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ otherlv_33= '}'
                    {
                    otherlv_28=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleModel617); 

                        	newLeafNode(otherlv_28, grammarAccess.getModelAccess().getNumberSignDigitThreePlusSignKeyword_1_5_0());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:374:1: ( (lv_name_29_0= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:375:1: (lv_name_29_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:375:1: (lv_name_29_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:376:3: lv_name_29_0= RULE_ID
                    {
                    lv_name_29_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel634); 

                    			newLeafNode(lv_name_29_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_5_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModelRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_29_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_30=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel651); 

                        	newLeafNode(otherlv_30, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_5_2());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:396:1: ( (lv_errors_31_0= ruleError_3 ) )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==25) ) {
                            int LA11_1 = input.LA(2);

                            if ( (LA11_1==RULE_ID) ) {
                                int LA11_4 = input.LA(3);

                                if ( (LA11_4==23) ) {
                                    alt11=1;
                                }


                            }


                        }
                        else if ( (LA11_0==23) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:397:1: (lv_errors_31_0= ruleError_3 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:397:1: (lv_errors_31_0= ruleError_3 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:398:3: lv_errors_31_0= ruleError_3
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getErrorsError_3ParserRuleCall_1_5_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleError_3_in_ruleModel672);
                    	    lv_errors_31_0=ruleError_3();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"errors",
                    	            		lv_errors_31_0, 
                    	            		"Error_3");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt11 >= 1 ) break loop11;
                                EarlyExitException eee =
                                    new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:414:3: ( (lv_operations_32_0= ruleOperation_3 ) )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>=24 && LA12_0<=25)) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:415:1: (lv_operations_32_0= ruleOperation_3 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:415:1: (lv_operations_32_0= ruleOperation_3 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:416:3: lv_operations_32_0= ruleOperation_3
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_3ParserRuleCall_1_5_4_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleOperation_3_in_ruleModel694);
                    	    lv_operations_32_0=ruleOperation_3();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_32_0, 
                    	            		"Operation_3");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);

                    otherlv_33=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel707); 

                        	newLeafNode(otherlv_33, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_5_5());
                        

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:437:6: (otherlv_34= '#4*' ( (lv_name_35_0= RULE_ID ) ) otherlv_36= '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* otherlv_39= '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:437:6: (otherlv_34= '#4*' ( (lv_name_35_0= RULE_ID ) ) otherlv_36= '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* otherlv_39= '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:437:8: otherlv_34= '#4*' ( (lv_name_35_0= RULE_ID ) ) otherlv_36= '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* otherlv_39= '}'
                    {
                    otherlv_34=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleModel727); 

                        	newLeafNode(otherlv_34, grammarAccess.getModelAccess().getNumberSignDigitFourAsteriskKeyword_1_6_0());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:441:1: ( (lv_name_35_0= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:442:1: (lv_name_35_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:442:1: (lv_name_35_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:443:3: lv_name_35_0= RULE_ID
                    {
                    lv_name_35_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel744); 

                    			newLeafNode(lv_name_35_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_6_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModelRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_35_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_36=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel761); 

                        	newLeafNode(otherlv_36, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_6_2());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:463:1: ( (lv_errors_37_0= ruleError_4 ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==25) ) {
                            int LA13_1 = input.LA(2);

                            if ( (LA13_1==RULE_ID) ) {
                                int LA13_3 = input.LA(3);

                                if ( (LA13_3==23) ) {
                                    alt13=1;
                                }


                            }


                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:464:1: (lv_errors_37_0= ruleError_4 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:464:1: (lv_errors_37_0= ruleError_4 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:465:3: lv_errors_37_0= ruleError_4
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getErrorsError_4ParserRuleCall_1_6_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleError_4_in_ruleModel782);
                    	    lv_errors_37_0=ruleError_4();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"errors",
                    	            		lv_errors_37_0, 
                    	            		"Error_4");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:481:3: ( (lv_operations_38_0= ruleOperation_4 ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==25) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:482:1: (lv_operations_38_0= ruleOperation_4 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:482:1: (lv_operations_38_0= ruleOperation_4 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:483:3: lv_operations_38_0= ruleOperation_4
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_4ParserRuleCall_1_6_4_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleOperation_4_in_ruleModel804);
                    	    lv_operations_38_0=ruleOperation_4();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_38_0, 
                    	            		"Operation_4");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    otherlv_39=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel817); 

                        	newLeafNode(otherlv_39, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_6_5());
                        

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:504:6: (otherlv_40= '#4+' ( (lv_name_41_0= RULE_ID ) ) otherlv_42= '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ otherlv_45= '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:504:6: (otherlv_40= '#4+' ( (lv_name_41_0= RULE_ID ) ) otherlv_42= '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ otherlv_45= '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:504:8: otherlv_40= '#4+' ( (lv_name_41_0= RULE_ID ) ) otherlv_42= '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ otherlv_45= '}'
                    {
                    otherlv_40=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleModel837); 

                        	newLeafNode(otherlv_40, grammarAccess.getModelAccess().getNumberSignDigitFourPlusSignKeyword_1_7_0());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:508:1: ( (lv_name_41_0= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:509:1: (lv_name_41_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:509:1: (lv_name_41_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:510:3: lv_name_41_0= RULE_ID
                    {
                    lv_name_41_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel854); 

                    			newLeafNode(lv_name_41_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_7_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModelRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_41_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_42=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel871); 

                        	newLeafNode(otherlv_42, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_7_2());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:530:1: ( (lv_errors_43_0= ruleError_4 ) )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==25) ) {
                            int LA15_1 = input.LA(2);

                            if ( (LA15_1==RULE_ID) ) {
                                int LA15_2 = input.LA(3);

                                if ( (LA15_2==23) ) {
                                    alt15=1;
                                }


                            }


                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:531:1: (lv_errors_43_0= ruleError_4 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:531:1: (lv_errors_43_0= ruleError_4 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:532:3: lv_errors_43_0= ruleError_4
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getErrorsError_4ParserRuleCall_1_7_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleError_4_in_ruleModel892);
                    	    lv_errors_43_0=ruleError_4();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"errors",
                    	            		lv_errors_43_0, 
                    	            		"Error_4");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:548:3: ( (lv_operations_44_0= ruleOperation_4 ) )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==25) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:549:1: (lv_operations_44_0= ruleOperation_4 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:549:1: (lv_operations_44_0= ruleOperation_4 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:550:3: lv_operations_44_0= ruleOperation_4
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_4ParserRuleCall_1_7_4_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleOperation_4_in_ruleModel914);
                    	    lv_operations_44_0=ruleOperation_4();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_44_0, 
                    	            		"Operation_4");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);

                    otherlv_45=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel927); 

                        	newLeafNode(otherlv_45, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_7_5());
                        

                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:571:6: (otherlv_46= '#5*' ( (lv_name_47_0= RULE_ID ) ) otherlv_48= '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* otherlv_51= '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:571:6: (otherlv_46= '#5*' ( (lv_name_47_0= RULE_ID ) ) otherlv_48= '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* otherlv_51= '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:571:8: otherlv_46= '#5*' ( (lv_name_47_0= RULE_ID ) ) otherlv_48= '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* otherlv_51= '}'
                    {
                    otherlv_46=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleModel947); 

                        	newLeafNode(otherlv_46, grammarAccess.getModelAccess().getNumberSignDigitFiveAsteriskKeyword_1_8_0());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:575:1: ( (lv_name_47_0= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:576:1: (lv_name_47_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:576:1: (lv_name_47_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:577:3: lv_name_47_0= RULE_ID
                    {
                    lv_name_47_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel964); 

                    			newLeafNode(lv_name_47_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_8_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModelRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_47_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_48=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel981); 

                        	newLeafNode(otherlv_48, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_8_2());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:597:1: ( (lv_errors_49_0= ruleError_5 ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==23) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:598:1: (lv_errors_49_0= ruleError_5 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:598:1: (lv_errors_49_0= ruleError_5 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:599:3: lv_errors_49_0= ruleError_5
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getErrorsError_5ParserRuleCall_1_8_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleError_5_in_ruleModel1002);
                    	    lv_errors_49_0=ruleError_5();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"errors",
                    	            		lv_errors_49_0, 
                    	            		"Error_5");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:615:3: ( (lv_operations_50_0= ruleOperation_5 ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==24) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:616:1: (lv_operations_50_0= ruleOperation_5 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:616:1: (lv_operations_50_0= ruleOperation_5 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:617:3: lv_operations_50_0= ruleOperation_5
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_5ParserRuleCall_1_8_4_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleOperation_5_in_ruleModel1024);
                    	    lv_operations_50_0=ruleOperation_5();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_50_0, 
                    	            		"Operation_5");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    otherlv_51=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel1037); 

                        	newLeafNode(otherlv_51, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_8_5());
                        

                    }


                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:638:6: (otherlv_52= '#5+' ( (lv_name_53_0= RULE_ID ) ) otherlv_54= '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ otherlv_57= '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:638:6: (otherlv_52= '#5+' ( (lv_name_53_0= RULE_ID ) ) otherlv_54= '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ otherlv_57= '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:638:8: otherlv_52= '#5+' ( (lv_name_53_0= RULE_ID ) ) otherlv_54= '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ otherlv_57= '}'
                    {
                    otherlv_52=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleModel1057); 

                        	newLeafNode(otherlv_52, grammarAccess.getModelAccess().getNumberSignDigitFivePlusSignKeyword_1_9_0());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:642:1: ( (lv_name_53_0= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:643:1: (lv_name_53_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:643:1: (lv_name_53_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:644:3: lv_name_53_0= RULE_ID
                    {
                    lv_name_53_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel1074); 

                    			newLeafNode(lv_name_53_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_9_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModelRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_53_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_54=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel1091); 

                        	newLeafNode(otherlv_54, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_9_2());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:664:1: ( (lv_errors_55_0= ruleError_5 ) )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==23) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:665:1: (lv_errors_55_0= ruleError_5 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:665:1: (lv_errors_55_0= ruleError_5 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:666:3: lv_errors_55_0= ruleError_5
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getErrorsError_5ParserRuleCall_1_9_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleError_5_in_ruleModel1112);
                    	    lv_errors_55_0=ruleError_5();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"errors",
                    	            		lv_errors_55_0, 
                    	            		"Error_5");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:682:3: ( (lv_operations_56_0= ruleOperation_5 ) )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==24) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:683:1: (lv_operations_56_0= ruleOperation_5 )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:683:1: (lv_operations_56_0= ruleOperation_5 )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:684:3: lv_operations_56_0= ruleOperation_5
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_5ParserRuleCall_1_9_4_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleOperation_5_in_ruleModel1134);
                    	    lv_operations_56_0=ruleOperation_5();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_56_0, 
                    	            		"Operation_5");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);

                    otherlv_57=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel1147); 

                        	newLeafNode(otherlv_57, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_9_5());
                        

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleError_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:712:1: entryRuleError_1 returns [EObject current=null] : iv_ruleError_1= ruleError_1 EOF ;
    public final EObject entryRuleError_1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleError_1 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:713:2: (iv_ruleError_1= ruleError_1 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:714:2: iv_ruleError_1= ruleError_1 EOF
            {
             newCompositeNode(grammarAccess.getError_1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleError_1_in_entryRuleError_11185);
            iv_ruleError_1=ruleError_1();

            state._fsp--;

             current =iv_ruleError_1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleError_11195); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleError_1"


    // $ANTLR start "ruleError_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:721:1: ruleError_1 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleError_1() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:724:28: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:725:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:725:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:725:2: ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:725:2: ( (lv_annotations_0_0= ruleAnnotation ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==25) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:726:1: (lv_annotations_0_0= ruleAnnotation )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:726:1: (lv_annotations_0_0= ruleAnnotation )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:727:3: lv_annotations_0_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getError_1Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_ruleError_11241);
            	    lv_annotations_0_0=ruleAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getError_1Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_0_0, 
            	            		"Annotation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleError_11254); 

                	newLeafNode(otherlv_1, grammarAccess.getError_1Access().getErrorKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:747:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:748:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:748:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:749:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleError_11271); 

            			newLeafNode(lv_name_2_0, grammarAccess.getError_1Access().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getError_1Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleError_1"


    // $ANTLR start "entryRuleOperation_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:773:1: entryRuleOperation_1 returns [EObject current=null] : iv_ruleOperation_1= ruleOperation_1 EOF ;
    public final EObject entryRuleOperation_1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation_1 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:774:2: (iv_ruleOperation_1= ruleOperation_1 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:775:2: iv_ruleOperation_1= ruleOperation_1 EOF
            {
             newCompositeNode(grammarAccess.getOperation_1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_1_in_entryRuleOperation_11312);
            iv_ruleOperation_1=ruleOperation_1();

            state._fsp--;

             current =iv_ruleOperation_1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperation_11322); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperation_1"


    // $ANTLR start "ruleOperation_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:782:1: ruleOperation_1 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleOperation_1() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:785:28: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:786:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:786:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:786:2: ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:786:2: ( (lv_annotations_0_0= ruleAnnotation ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==25) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:787:1: (lv_annotations_0_0= ruleAnnotation )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:787:1: (lv_annotations_0_0= ruleAnnotation )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:788:3: lv_annotations_0_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOperation_1Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_ruleOperation_11368);
            	    lv_annotations_0_0=ruleAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getOperation_1Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_0_0, 
            	            		"Annotation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleOperation_11381); 

                	newLeafNode(otherlv_1, grammarAccess.getOperation_1Access().getOperationKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:808:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:809:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:809:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:810:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOperation_11398); 

            			newLeafNode(lv_name_2_0, grammarAccess.getOperation_1Access().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOperation_1Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperation_1"


    // $ANTLR start "entryRuleError_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:834:1: entryRuleError_2 returns [EObject current=null] : iv_ruleError_2= ruleError_2 EOF ;
    public final EObject entryRuleError_2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleError_2 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:835:2: (iv_ruleError_2= ruleError_2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:836:2: iv_ruleError_2= ruleError_2 EOF
            {
             newCompositeNode(grammarAccess.getError_2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleError_2_in_entryRuleError_21439);
            iv_ruleError_2=ruleError_2();

            state._fsp--;

             current =iv_ruleError_2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleError_21449); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleError_2"


    // $ANTLR start "ruleError_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:843:1: ruleError_2 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )+ otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleError_2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:846:28: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )+ otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:847:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )+ otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:847:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )+ otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:847:2: ( (lv_annotations_0_0= ruleAnnotation ) )+ otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:847:2: ( (lv_annotations_0_0= ruleAnnotation ) )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==25) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:848:1: (lv_annotations_0_0= ruleAnnotation )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:848:1: (lv_annotations_0_0= ruleAnnotation )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:849:3: lv_annotations_0_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getError_2Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_ruleError_21495);
            	    lv_annotations_0_0=ruleAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getError_2Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_0_0, 
            	            		"Annotation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);

            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleError_21508); 

                	newLeafNode(otherlv_1, grammarAccess.getError_2Access().getErrorKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:869:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:870:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:870:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:871:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleError_21525); 

            			newLeafNode(lv_name_2_0, grammarAccess.getError_2Access().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getError_2Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleError_2"


    // $ANTLR start "entryRuleOperation_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:895:1: entryRuleOperation_2 returns [EObject current=null] : iv_ruleOperation_2= ruleOperation_2 EOF ;
    public final EObject entryRuleOperation_2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation_2 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:896:2: (iv_ruleOperation_2= ruleOperation_2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:897:2: iv_ruleOperation_2= ruleOperation_2 EOF
            {
             newCompositeNode(grammarAccess.getOperation_2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_2_in_entryRuleOperation_21566);
            iv_ruleOperation_2=ruleOperation_2();

            state._fsp--;

             current =iv_ruleOperation_2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperation_21576); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperation_2"


    // $ANTLR start "ruleOperation_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:904:1: ruleOperation_2 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )+ otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleOperation_2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:907:28: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )+ otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:908:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )+ otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:908:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )+ otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:908:2: ( (lv_annotations_0_0= ruleAnnotation ) )+ otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:908:2: ( (lv_annotations_0_0= ruleAnnotation ) )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==25) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:909:1: (lv_annotations_0_0= ruleAnnotation )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:909:1: (lv_annotations_0_0= ruleAnnotation )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:910:3: lv_annotations_0_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOperation_2Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_ruleOperation_21622);
            	    lv_annotations_0_0=ruleAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getOperation_2Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_0_0, 
            	            		"Annotation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);

            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleOperation_21635); 

                	newLeafNode(otherlv_1, grammarAccess.getOperation_2Access().getOperationKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:930:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:931:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:931:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:932:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOperation_21652); 

            			newLeafNode(lv_name_2_0, grammarAccess.getOperation_2Access().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOperation_2Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperation_2"


    // $ANTLR start "entryRuleError_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:956:1: entryRuleError_3 returns [EObject current=null] : iv_ruleError_3= ruleError_3 EOF ;
    public final EObject entryRuleError_3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleError_3 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:957:2: (iv_ruleError_3= ruleError_3 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:958:2: iv_ruleError_3= ruleError_3 EOF
            {
             newCompositeNode(grammarAccess.getError_3Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleError_3_in_entryRuleError_31693);
            iv_ruleError_3=ruleError_3();

            state._fsp--;

             current =iv_ruleError_3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleError_31703); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleError_3"


    // $ANTLR start "ruleError_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:965:1: ruleError_3 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )? otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleError_3() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:968:28: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )? otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:969:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )? otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:969:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )? otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:969:2: ( (lv_annotations_0_0= ruleAnnotation ) )? otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:969:2: ( (lv_annotations_0_0= ruleAnnotation ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==25) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:970:1: (lv_annotations_0_0= ruleAnnotation )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:970:1: (lv_annotations_0_0= ruleAnnotation )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:971:3: lv_annotations_0_0= ruleAnnotation
                    {
                     
                    	        newCompositeNode(grammarAccess.getError_3Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_ruleError_31749);
                    lv_annotations_0_0=ruleAnnotation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getError_3Rule());
                    	        }
                           		add(
                           			current, 
                           			"annotations",
                            		lv_annotations_0_0, 
                            		"Annotation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleError_31762); 

                	newLeafNode(otherlv_1, grammarAccess.getError_3Access().getErrorKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:991:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:992:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:992:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:993:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleError_31779); 

            			newLeafNode(lv_name_2_0, grammarAccess.getError_3Access().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getError_3Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleError_3"


    // $ANTLR start "entryRuleOperation_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1017:1: entryRuleOperation_3 returns [EObject current=null] : iv_ruleOperation_3= ruleOperation_3 EOF ;
    public final EObject entryRuleOperation_3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation_3 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1018:2: (iv_ruleOperation_3= ruleOperation_3 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1019:2: iv_ruleOperation_3= ruleOperation_3 EOF
            {
             newCompositeNode(grammarAccess.getOperation_3Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_3_in_entryRuleOperation_31820);
            iv_ruleOperation_3=ruleOperation_3();

            state._fsp--;

             current =iv_ruleOperation_3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperation_31830); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperation_3"


    // $ANTLR start "ruleOperation_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1026:1: ruleOperation_3 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )? otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleOperation_3() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1029:28: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )? otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1030:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )? otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1030:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )? otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1030:2: ( (lv_annotations_0_0= ruleAnnotation ) )? otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1030:2: ( (lv_annotations_0_0= ruleAnnotation ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==25) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1031:1: (lv_annotations_0_0= ruleAnnotation )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1031:1: (lv_annotations_0_0= ruleAnnotation )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1032:3: lv_annotations_0_0= ruleAnnotation
                    {
                     
                    	        newCompositeNode(grammarAccess.getOperation_3Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_ruleOperation_31876);
                    lv_annotations_0_0=ruleAnnotation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOperation_3Rule());
                    	        }
                           		add(
                           			current, 
                           			"annotations",
                            		lv_annotations_0_0, 
                            		"Annotation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleOperation_31889); 

                	newLeafNode(otherlv_1, grammarAccess.getOperation_3Access().getOperationKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1052:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1053:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1053:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1054:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOperation_31906); 

            			newLeafNode(lv_name_2_0, grammarAccess.getOperation_3Access().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOperation_3Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperation_3"


    // $ANTLR start "entryRuleError_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1078:1: entryRuleError_4 returns [EObject current=null] : iv_ruleError_4= ruleError_4 EOF ;
    public final EObject entryRuleError_4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleError_4 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1079:2: (iv_ruleError_4= ruleError_4 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1080:2: iv_ruleError_4= ruleError_4 EOF
            {
             newCompositeNode(grammarAccess.getError_4Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleError_4_in_entryRuleError_41947);
            iv_ruleError_4=ruleError_4();

            state._fsp--;

             current =iv_ruleError_4; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleError_41957); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleError_4"


    // $ANTLR start "ruleError_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1087:1: ruleError_4 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) ) otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleError_4() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1090:28: ( ( ( (lv_annotations_0_0= ruleAnnotation ) ) otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1091:1: ( ( (lv_annotations_0_0= ruleAnnotation ) ) otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1091:1: ( ( (lv_annotations_0_0= ruleAnnotation ) ) otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1091:2: ( (lv_annotations_0_0= ruleAnnotation ) ) otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1091:2: ( (lv_annotations_0_0= ruleAnnotation ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1092:1: (lv_annotations_0_0= ruleAnnotation )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1092:1: (lv_annotations_0_0= ruleAnnotation )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1093:3: lv_annotations_0_0= ruleAnnotation
            {
             
            	        newCompositeNode(grammarAccess.getError_4Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_ruleError_42003);
            lv_annotations_0_0=ruleAnnotation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getError_4Rule());
            	        }
                   		add(
                   			current, 
                   			"annotations",
                    		lv_annotations_0_0, 
                    		"Annotation");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleError_42015); 

                	newLeafNode(otherlv_1, grammarAccess.getError_4Access().getErrorKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1113:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1114:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1114:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1115:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleError_42032); 

            			newLeafNode(lv_name_2_0, grammarAccess.getError_4Access().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getError_4Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleError_4"


    // $ANTLR start "entryRuleOperation_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1139:1: entryRuleOperation_4 returns [EObject current=null] : iv_ruleOperation_4= ruleOperation_4 EOF ;
    public final EObject entryRuleOperation_4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation_4 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1140:2: (iv_ruleOperation_4= ruleOperation_4 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1141:2: iv_ruleOperation_4= ruleOperation_4 EOF
            {
             newCompositeNode(grammarAccess.getOperation_4Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_4_in_entryRuleOperation_42073);
            iv_ruleOperation_4=ruleOperation_4();

            state._fsp--;

             current =iv_ruleOperation_4; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperation_42083); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperation_4"


    // $ANTLR start "ruleOperation_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1148:1: ruleOperation_4 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) ) otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleOperation_4() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1151:28: ( ( ( (lv_annotations_0_0= ruleAnnotation ) ) otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1152:1: ( ( (lv_annotations_0_0= ruleAnnotation ) ) otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1152:1: ( ( (lv_annotations_0_0= ruleAnnotation ) ) otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1152:2: ( (lv_annotations_0_0= ruleAnnotation ) ) otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1152:2: ( (lv_annotations_0_0= ruleAnnotation ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1153:1: (lv_annotations_0_0= ruleAnnotation )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1153:1: (lv_annotations_0_0= ruleAnnotation )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1154:3: lv_annotations_0_0= ruleAnnotation
            {
             
            	        newCompositeNode(grammarAccess.getOperation_4Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_ruleOperation_42129);
            lv_annotations_0_0=ruleAnnotation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOperation_4Rule());
            	        }
                   		add(
                   			current, 
                   			"annotations",
                    		lv_annotations_0_0, 
                    		"Annotation");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleOperation_42141); 

                	newLeafNode(otherlv_1, grammarAccess.getOperation_4Access().getOperationKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1174:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1175:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1175:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1176:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOperation_42158); 

            			newLeafNode(lv_name_2_0, grammarAccess.getOperation_4Access().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOperation_4Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperation_4"


    // $ANTLR start "entryRuleError_5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1200:1: entryRuleError_5 returns [EObject current=null] : iv_ruleError_5= ruleError_5 EOF ;
    public final EObject entryRuleError_5() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleError_5 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1201:2: (iv_ruleError_5= ruleError_5 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1202:2: iv_ruleError_5= ruleError_5 EOF
            {
             newCompositeNode(grammarAccess.getError_5Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleError_5_in_entryRuleError_52199);
            iv_ruleError_5=ruleError_5();

            state._fsp--;

             current =iv_ruleError_5; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleError_52209); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleError_5"


    // $ANTLR start "ruleError_5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1209:1: ruleError_5 returns [EObject current=null] : (otherlv_0= 'error' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleError_5() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1212:28: ( (otherlv_0= 'error' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1213:1: (otherlv_0= 'error' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1213:1: (otherlv_0= 'error' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1213:3: otherlv_0= 'error' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleError_52246); 

                	newLeafNode(otherlv_0, grammarAccess.getError_5Access().getErrorKeyword_0());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1217:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1218:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1218:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1219:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleError_52263); 

            			newLeafNode(lv_name_1_0, grammarAccess.getError_5Access().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getError_5Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleError_5"


    // $ANTLR start "entryRuleOperation_5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1243:1: entryRuleOperation_5 returns [EObject current=null] : iv_ruleOperation_5= ruleOperation_5 EOF ;
    public final EObject entryRuleOperation_5() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation_5 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1244:2: (iv_ruleOperation_5= ruleOperation_5 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1245:2: iv_ruleOperation_5= ruleOperation_5 EOF
            {
             newCompositeNode(grammarAccess.getOperation_5Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_5_in_entryRuleOperation_52304);
            iv_ruleOperation_5=ruleOperation_5();

            state._fsp--;

             current =iv_ruleOperation_5; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperation_52314); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperation_5"


    // $ANTLR start "ruleOperation_5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1252:1: ruleOperation_5 returns [EObject current=null] : (otherlv_0= 'operation' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleOperation_5() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1255:28: ( (otherlv_0= 'operation' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1256:1: (otherlv_0= 'operation' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1256:1: (otherlv_0= 'operation' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1256:3: otherlv_0= 'operation' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleOperation_52351); 

                	newLeafNode(otherlv_0, grammarAccess.getOperation_5Access().getOperationKeyword_0());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1260:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1261:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1261:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1262:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOperation_52368); 

            			newLeafNode(lv_name_1_0, grammarAccess.getOperation_5Access().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOperation_5Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperation_5"


    // $ANTLR start "entryRuleAnnotation"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1286:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1287:2: (iv_ruleAnnotation= ruleAnnotation EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1288:2: iv_ruleAnnotation= ruleAnnotation EOF
            {
             newCompositeNode(grammarAccess.getAnnotationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_entryRuleAnnotation2409);
            iv_ruleAnnotation=ruleAnnotation();

            state._fsp--;

             current =iv_ruleAnnotation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAnnotation2419); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotation"


    // $ANTLR start "ruleAnnotation"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1295:1: ruleAnnotation returns [EObject current=null] : (otherlv_0= '@uuid' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1298:28: ( (otherlv_0= '@uuid' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1299:1: (otherlv_0= '@uuid' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1299:1: (otherlv_0= '@uuid' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1299:3: otherlv_0= '@uuid' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleAnnotation2456); 

                	newLeafNode(otherlv_0, grammarAccess.getAnnotationAccess().getUuidKeyword_0());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1303:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1304:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1304:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug309949TestLanguage.g:1305:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAnnotation2473); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAnnotationAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAnnotationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotation"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA3 dfa3 = new DFA3(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA1_eotS =
        "\5\uffff";
    static final String DFA1_eofS =
        "\5\uffff";
    static final String DFA1_minS =
        "\1\15\1\4\2\uffff\1\27";
    static final String DFA1_maxS =
        "\1\31\1\4\2\uffff\1\31";
    static final String DFA1_acceptS =
        "\2\uffff\1\2\1\1\1\uffff";
    static final String DFA1_specialS =
        "\5\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\2\11\uffff\1\3\1\2\1\1",
            "\1\4",
            "",
            "",
            "\1\3\1\2\1\1"
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
            return "()* loopback of 97:1: ( (lv_errors_3_0= ruleError_1 ) )*";
        }
    }
    static final String DFA3_eotS =
        "\5\uffff";
    static final String DFA3_eofS =
        "\5\uffff";
    static final String DFA3_minS =
        "\1\27\1\4\2\uffff\1\27";
    static final String DFA3_maxS =
        "\1\31\1\4\2\uffff\1\31";
    static final String DFA3_acceptS =
        "\2\uffff\1\2\1\1\1\uffff";
    static final String DFA3_specialS =
        "\5\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\3\1\2\1\1",
            "\1\4",
            "",
            "",
            "\1\3\1\2\1\1"
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "()+ loopback of 146:1: ( (lv_errors_8_0= ruleError_1 ) )+";
        }
    }
    static final String DFA5_eotS =
        "\5\uffff";
    static final String DFA5_eofS =
        "\5\uffff";
    static final String DFA5_minS =
        "\1\15\1\4\1\uffff\1\27\1\uffff";
    static final String DFA5_maxS =
        "\1\31\1\4\1\uffff\1\31\1\uffff";
    static final String DFA5_acceptS =
        "\2\uffff\1\2\1\uffff\1\1";
    static final String DFA5_specialS =
        "\5\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\2\13\uffff\1\1",
            "\1\3",
            "",
            "\1\4\1\2\1\1",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "()* loopback of 195:1: ( (lv_errors_13_0= ruleError_2 ) )*";
        }
    }
    static final String DFA7_eotS =
        "\5\uffff";
    static final String DFA7_eofS =
        "\5\uffff";
    static final String DFA7_minS =
        "\1\31\1\4\1\27\2\uffff";
    static final String DFA7_maxS =
        "\1\31\1\4\1\31\2\uffff";
    static final String DFA7_acceptS =
        "\3\uffff\1\1\1\2";
    static final String DFA7_specialS =
        "\5\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3\1\4\1\1",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "()+ loopback of 262:1: ( (lv_errors_19_0= ruleError_2 ) )+";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel133 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel145 = new BitSet(new long[]{0x0000000003802000L});
        public static final BitSet FOLLOW_ruleError_1_in_ruleModel166 = new BitSet(new long[]{0x0000000003802000L});
        public static final BitSet FOLLOW_ruleOperation_1_in_ruleModel188 = new BitSet(new long[]{0x0000000003002000L});
        public static final BitSet FOLLOW_13_in_ruleModel201 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleModel221 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel233 = new BitSet(new long[]{0x0000000002800000L});
        public static final BitSet FOLLOW_ruleError_1_in_ruleModel254 = new BitSet(new long[]{0x0000000003800000L});
        public static final BitSet FOLLOW_ruleOperation_1_in_ruleModel276 = new BitSet(new long[]{0x0000000003002000L});
        public static final BitSet FOLLOW_13_in_ruleModel289 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleModel309 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel321 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_ruleError_2_in_ruleModel342 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_ruleOperation_2_in_ruleModel364 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_13_in_ruleModel377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleModel397 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel414 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel431 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_ruleError_2_in_ruleModel452 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_ruleOperation_2_in_ruleModel474 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_13_in_ruleModel487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleModel507 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel524 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel541 = new BitSet(new long[]{0x0000000003802000L});
        public static final BitSet FOLLOW_ruleError_3_in_ruleModel562 = new BitSet(new long[]{0x0000000003802000L});
        public static final BitSet FOLLOW_ruleOperation_3_in_ruleModel584 = new BitSet(new long[]{0x0000000003002000L});
        public static final BitSet FOLLOW_13_in_ruleModel597 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleModel617 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel634 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel651 = new BitSet(new long[]{0x0000000002800000L});
        public static final BitSet FOLLOW_ruleError_3_in_ruleModel672 = new BitSet(new long[]{0x0000000003800000L});
        public static final BitSet FOLLOW_ruleOperation_3_in_ruleModel694 = new BitSet(new long[]{0x0000000003002000L});
        public static final BitSet FOLLOW_13_in_ruleModel707 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleModel727 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel744 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel761 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_ruleError_4_in_ruleModel782 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_ruleOperation_4_in_ruleModel804 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_13_in_ruleModel817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleModel837 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel854 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel871 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_ruleError_4_in_ruleModel892 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_ruleOperation_4_in_ruleModel914 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_13_in_ruleModel927 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleModel947 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel964 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel981 = new BitSet(new long[]{0x0000000001802000L});
        public static final BitSet FOLLOW_ruleError_5_in_ruleModel1002 = new BitSet(new long[]{0x0000000001802000L});
        public static final BitSet FOLLOW_ruleOperation_5_in_ruleModel1024 = new BitSet(new long[]{0x0000000001002000L});
        public static final BitSet FOLLOW_13_in_ruleModel1037 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleModel1057 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel1074 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel1091 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_ruleError_5_in_ruleModel1112 = new BitSet(new long[]{0x0000000001800000L});
        public static final BitSet FOLLOW_ruleOperation_5_in_ruleModel1134 = new BitSet(new long[]{0x0000000001002000L});
        public static final BitSet FOLLOW_13_in_ruleModel1147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_1_in_entryRuleError_11185 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleError_11195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_ruleError_11241 = new BitSet(new long[]{0x0000000002800000L});
        public static final BitSet FOLLOW_23_in_ruleError_11254 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleError_11271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_1_in_entryRuleOperation_11312 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperation_11322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_ruleOperation_11368 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_24_in_ruleOperation_11381 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOperation_11398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_2_in_entryRuleError_21439 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleError_21449 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_ruleError_21495 = new BitSet(new long[]{0x0000000002800000L});
        public static final BitSet FOLLOW_23_in_ruleError_21508 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleError_21525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_2_in_entryRuleOperation_21566 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperation_21576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_ruleOperation_21622 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_24_in_ruleOperation_21635 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOperation_21652 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_3_in_entryRuleError_31693 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleError_31703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_ruleError_31749 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleError_31762 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleError_31779 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_3_in_entryRuleOperation_31820 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperation_31830 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_ruleOperation_31876 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleOperation_31889 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOperation_31906 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_4_in_entryRuleError_41947 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleError_41957 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_ruleError_42003 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleError_42015 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleError_42032 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_4_in_entryRuleOperation_42073 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperation_42083 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_ruleOperation_42129 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleOperation_42141 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOperation_42158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleError_5_in_entryRuleError_52199 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleError_52209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleError_52246 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleError_52263 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_5_in_entryRuleOperation_52304 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperation_52314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleOperation_52351 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOperation_52368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_entryRuleAnnotation2409 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAnnotation2419 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleAnnotation2456 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAnnotation2473 = new BitSet(new long[]{0x0000000000000002L});
    }


}