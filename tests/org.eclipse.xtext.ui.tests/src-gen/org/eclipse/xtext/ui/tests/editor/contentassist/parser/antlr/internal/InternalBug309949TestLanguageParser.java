package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
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
    public static final int RULE_ID=4;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalBug309949TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug309949TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug309949TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug309949TestLanguage.g"; }



     	private Bug309949TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug309949TestLanguageParser(TokenStream input, Bug309949TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
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
    // InternalBug309949TestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalBug309949TestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalBug309949TestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalBug309949TestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( () ( (otherlv_1= '#1*' otherlv_2= '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* otherlv_5= '}' ) | (otherlv_6= '#1+' otherlv_7= '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ otherlv_10= '}' ) | (otherlv_11= '#2*' otherlv_12= '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* otherlv_15= '}' ) | (otherlv_16= '#2+' ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ otherlv_21= '}' ) | (otherlv_22= '#3*' ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* otherlv_27= '}' ) | (otherlv_28= '#3+' ( (lv_name_29_0= RULE_ID ) ) otherlv_30= '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ otherlv_33= '}' ) | (otherlv_34= '#4*' ( (lv_name_35_0= RULE_ID ) ) otherlv_36= '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* otherlv_39= '}' ) | (otherlv_40= '#4+' ( (lv_name_41_0= RULE_ID ) ) otherlv_42= '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ otherlv_45= '}' ) | (otherlv_46= '#5*' ( (lv_name_47_0= RULE_ID ) ) otherlv_48= '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* otherlv_51= '}' ) | (otherlv_52= '#5+' ( (lv_name_53_0= RULE_ID ) ) otherlv_54= '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ otherlv_57= '}' ) ) ) ;
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
            // InternalBug309949TestLanguage.g:79:28: ( ( () ( (otherlv_1= '#1*' otherlv_2= '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* otherlv_5= '}' ) | (otherlv_6= '#1+' otherlv_7= '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ otherlv_10= '}' ) | (otherlv_11= '#2*' otherlv_12= '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* otherlv_15= '}' ) | (otherlv_16= '#2+' ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ otherlv_21= '}' ) | (otherlv_22= '#3*' ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* otherlv_27= '}' ) | (otherlv_28= '#3+' ( (lv_name_29_0= RULE_ID ) ) otherlv_30= '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ otherlv_33= '}' ) | (otherlv_34= '#4*' ( (lv_name_35_0= RULE_ID ) ) otherlv_36= '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* otherlv_39= '}' ) | (otherlv_40= '#4+' ( (lv_name_41_0= RULE_ID ) ) otherlv_42= '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ otherlv_45= '}' ) | (otherlv_46= '#5*' ( (lv_name_47_0= RULE_ID ) ) otherlv_48= '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* otherlv_51= '}' ) | (otherlv_52= '#5+' ( (lv_name_53_0= RULE_ID ) ) otherlv_54= '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ otherlv_57= '}' ) ) ) )
            // InternalBug309949TestLanguage.g:80:1: ( () ( (otherlv_1= '#1*' otherlv_2= '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* otherlv_5= '}' ) | (otherlv_6= '#1+' otherlv_7= '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ otherlv_10= '}' ) | (otherlv_11= '#2*' otherlv_12= '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* otherlv_15= '}' ) | (otherlv_16= '#2+' ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ otherlv_21= '}' ) | (otherlv_22= '#3*' ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* otherlv_27= '}' ) | (otherlv_28= '#3+' ( (lv_name_29_0= RULE_ID ) ) otherlv_30= '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ otherlv_33= '}' ) | (otherlv_34= '#4*' ( (lv_name_35_0= RULE_ID ) ) otherlv_36= '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* otherlv_39= '}' ) | (otherlv_40= '#4+' ( (lv_name_41_0= RULE_ID ) ) otherlv_42= '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ otherlv_45= '}' ) | (otherlv_46= '#5*' ( (lv_name_47_0= RULE_ID ) ) otherlv_48= '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* otherlv_51= '}' ) | (otherlv_52= '#5+' ( (lv_name_53_0= RULE_ID ) ) otherlv_54= '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ otherlv_57= '}' ) ) )
            {
            // InternalBug309949TestLanguage.g:80:1: ( () ( (otherlv_1= '#1*' otherlv_2= '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* otherlv_5= '}' ) | (otherlv_6= '#1+' otherlv_7= '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ otherlv_10= '}' ) | (otherlv_11= '#2*' otherlv_12= '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* otherlv_15= '}' ) | (otherlv_16= '#2+' ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ otherlv_21= '}' ) | (otherlv_22= '#3*' ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* otherlv_27= '}' ) | (otherlv_28= '#3+' ( (lv_name_29_0= RULE_ID ) ) otherlv_30= '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ otherlv_33= '}' ) | (otherlv_34= '#4*' ( (lv_name_35_0= RULE_ID ) ) otherlv_36= '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* otherlv_39= '}' ) | (otherlv_40= '#4+' ( (lv_name_41_0= RULE_ID ) ) otherlv_42= '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ otherlv_45= '}' ) | (otherlv_46= '#5*' ( (lv_name_47_0= RULE_ID ) ) otherlv_48= '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* otherlv_51= '}' ) | (otherlv_52= '#5+' ( (lv_name_53_0= RULE_ID ) ) otherlv_54= '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ otherlv_57= '}' ) ) )
            // InternalBug309949TestLanguage.g:80:2: () ( (otherlv_1= '#1*' otherlv_2= '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* otherlv_5= '}' ) | (otherlv_6= '#1+' otherlv_7= '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ otherlv_10= '}' ) | (otherlv_11= '#2*' otherlv_12= '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* otherlv_15= '}' ) | (otherlv_16= '#2+' ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ otherlv_21= '}' ) | (otherlv_22= '#3*' ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* otherlv_27= '}' ) | (otherlv_28= '#3+' ( (lv_name_29_0= RULE_ID ) ) otherlv_30= '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ otherlv_33= '}' ) | (otherlv_34= '#4*' ( (lv_name_35_0= RULE_ID ) ) otherlv_36= '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* otherlv_39= '}' ) | (otherlv_40= '#4+' ( (lv_name_41_0= RULE_ID ) ) otherlv_42= '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ otherlv_45= '}' ) | (otherlv_46= '#5*' ( (lv_name_47_0= RULE_ID ) ) otherlv_48= '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* otherlv_51= '}' ) | (otherlv_52= '#5+' ( (lv_name_53_0= RULE_ID ) ) otherlv_54= '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ otherlv_57= '}' ) )
            {
            // InternalBug309949TestLanguage.g:80:2: ()
            // InternalBug309949TestLanguage.g:81:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getModelAccess().getModelAction_0(),
                        current);
                

            }

            // InternalBug309949TestLanguage.g:86:2: ( (otherlv_1= '#1*' otherlv_2= '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* otherlv_5= '}' ) | (otherlv_6= '#1+' otherlv_7= '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ otherlv_10= '}' ) | (otherlv_11= '#2*' otherlv_12= '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* otherlv_15= '}' ) | (otherlv_16= '#2+' ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ otherlv_21= '}' ) | (otherlv_22= '#3*' ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* otherlv_27= '}' ) | (otherlv_28= '#3+' ( (lv_name_29_0= RULE_ID ) ) otherlv_30= '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ otherlv_33= '}' ) | (otherlv_34= '#4*' ( (lv_name_35_0= RULE_ID ) ) otherlv_36= '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* otherlv_39= '}' ) | (otherlv_40= '#4+' ( (lv_name_41_0= RULE_ID ) ) otherlv_42= '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ otherlv_45= '}' ) | (otherlv_46= '#5*' ( (lv_name_47_0= RULE_ID ) ) otherlv_48= '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* otherlv_51= '}' ) | (otherlv_52= '#5+' ( (lv_name_53_0= RULE_ID ) ) otherlv_54= '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ otherlv_57= '}' ) )
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
                    // InternalBug309949TestLanguage.g:86:3: (otherlv_1= '#1*' otherlv_2= '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* otherlv_5= '}' )
                    {
                    // InternalBug309949TestLanguage.g:86:3: (otherlv_1= '#1*' otherlv_2= '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* otherlv_5= '}' )
                    // InternalBug309949TestLanguage.g:86:5: otherlv_1= '#1*' otherlv_2= '{' ( (lv_errors_3_0= ruleError_1 ) )* ( (lv_operations_4_0= ruleOperation_1 ) )* otherlv_5= '}'
                    {
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_1, grammarAccess.getModelAccess().getNumberSignDigitOneAsteriskKeyword_1_0_0());
                        
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_4); 

                        	newLeafNode(otherlv_2, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_0_1());
                        
                    // InternalBug309949TestLanguage.g:94:1: ( (lv_errors_3_0= ruleError_1 ) )*
                    loop1:
                    do {
                        int alt1=2;
                        alt1 = dfa1.predict(input);
                        switch (alt1) {
                    	case 1 :
                    	    // InternalBug309949TestLanguage.g:95:1: (lv_errors_3_0= ruleError_1 )
                    	    {
                    	    // InternalBug309949TestLanguage.g:95:1: (lv_errors_3_0= ruleError_1 )
                    	    // InternalBug309949TestLanguage.g:96:3: lv_errors_3_0= ruleError_1
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getErrorsError_1ParserRuleCall_1_0_2_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_4);
                    	    lv_errors_3_0=ruleError_1();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"errors",
                    	            		lv_errors_3_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Error_1");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    // InternalBug309949TestLanguage.g:112:3: ( (lv_operations_4_0= ruleOperation_1 ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>=24 && LA2_0<=25)) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalBug309949TestLanguage.g:113:1: (lv_operations_4_0= ruleOperation_1 )
                    	    {
                    	    // InternalBug309949TestLanguage.g:113:1: (lv_operations_4_0= ruleOperation_1 )
                    	    // InternalBug309949TestLanguage.g:114:3: lv_operations_4_0= ruleOperation_1
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_1ParserRuleCall_1_0_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_5);
                    	    lv_operations_4_0=ruleOperation_1();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_4_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Operation_1");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_5, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_0_4());
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalBug309949TestLanguage.g:135:6: (otherlv_6= '#1+' otherlv_7= '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ otherlv_10= '}' )
                    {
                    // InternalBug309949TestLanguage.g:135:6: (otherlv_6= '#1+' otherlv_7= '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ otherlv_10= '}' )
                    // InternalBug309949TestLanguage.g:135:8: otherlv_6= '#1+' otherlv_7= '{' ( (lv_errors_8_0= ruleError_1 ) )+ ( (lv_operations_9_0= ruleOperation_1 ) )+ otherlv_10= '}'
                    {
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_6, grammarAccess.getModelAccess().getNumberSignDigitOnePlusSignKeyword_1_1_0());
                        
                    otherlv_7=(Token)match(input,12,FollowSets000.FOLLOW_6); 

                        	newLeafNode(otherlv_7, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_1_1());
                        
                    // InternalBug309949TestLanguage.g:143:1: ( (lv_errors_8_0= ruleError_1 ) )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        alt3 = dfa3.predict(input);
                        switch (alt3) {
                    	case 1 :
                    	    // InternalBug309949TestLanguage.g:144:1: (lv_errors_8_0= ruleError_1 )
                    	    {
                    	    // InternalBug309949TestLanguage.g:144:1: (lv_errors_8_0= ruleError_1 )
                    	    // InternalBug309949TestLanguage.g:145:3: lv_errors_8_0= ruleError_1
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getErrorsError_1ParserRuleCall_1_1_2_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_7);
                    	    lv_errors_8_0=ruleError_1();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"errors",
                    	            		lv_errors_8_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Error_1");
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

                    // InternalBug309949TestLanguage.g:161:3: ( (lv_operations_9_0= ruleOperation_1 ) )+
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
                    	    // InternalBug309949TestLanguage.g:162:1: (lv_operations_9_0= ruleOperation_1 )
                    	    {
                    	    // InternalBug309949TestLanguage.g:162:1: (lv_operations_9_0= ruleOperation_1 )
                    	    // InternalBug309949TestLanguage.g:163:3: lv_operations_9_0= ruleOperation_1
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_1ParserRuleCall_1_1_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_5);
                    	    lv_operations_9_0=ruleOperation_1();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_9_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Operation_1");
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

                    otherlv_10=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_10, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_1_4());
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalBug309949TestLanguage.g:184:6: (otherlv_11= '#2*' otherlv_12= '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* otherlv_15= '}' )
                    {
                    // InternalBug309949TestLanguage.g:184:6: (otherlv_11= '#2*' otherlv_12= '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* otherlv_15= '}' )
                    // InternalBug309949TestLanguage.g:184:8: otherlv_11= '#2*' otherlv_12= '{' ( (lv_errors_13_0= ruleError_2 ) )* ( (lv_operations_14_0= ruleOperation_2 ) )* otherlv_15= '}'
                    {
                    otherlv_11=(Token)match(input,15,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_11, grammarAccess.getModelAccess().getNumberSignDigitTwoAsteriskKeyword_1_2_0());
                        
                    otherlv_12=(Token)match(input,12,FollowSets000.FOLLOW_8); 

                        	newLeafNode(otherlv_12, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_2_1());
                        
                    // InternalBug309949TestLanguage.g:192:1: ( (lv_errors_13_0= ruleError_2 ) )*
                    loop5:
                    do {
                        int alt5=2;
                        alt5 = dfa5.predict(input);
                        switch (alt5) {
                    	case 1 :
                    	    // InternalBug309949TestLanguage.g:193:1: (lv_errors_13_0= ruleError_2 )
                    	    {
                    	    // InternalBug309949TestLanguage.g:193:1: (lv_errors_13_0= ruleError_2 )
                    	    // InternalBug309949TestLanguage.g:194:3: lv_errors_13_0= ruleError_2
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getErrorsError_2ParserRuleCall_1_2_2_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_8);
                    	    lv_errors_13_0=ruleError_2();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"errors",
                    	            		lv_errors_13_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Error_2");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    // InternalBug309949TestLanguage.g:210:3: ( (lv_operations_14_0= ruleOperation_2 ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==25) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalBug309949TestLanguage.g:211:1: (lv_operations_14_0= ruleOperation_2 )
                    	    {
                    	    // InternalBug309949TestLanguage.g:211:1: (lv_operations_14_0= ruleOperation_2 )
                    	    // InternalBug309949TestLanguage.g:212:3: lv_operations_14_0= ruleOperation_2
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_2ParserRuleCall_1_2_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_8);
                    	    lv_operations_14_0=ruleOperation_2();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_14_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Operation_2");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_15, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_2_4());
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalBug309949TestLanguage.g:233:6: (otherlv_16= '#2+' ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ otherlv_21= '}' )
                    {
                    // InternalBug309949TestLanguage.g:233:6: (otherlv_16= '#2+' ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ otherlv_21= '}' )
                    // InternalBug309949TestLanguage.g:233:8: otherlv_16= '#2+' ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '{' ( (lv_errors_19_0= ruleError_2 ) )+ ( (lv_operations_20_0= ruleOperation_2 ) )+ otherlv_21= '}'
                    {
                    otherlv_16=(Token)match(input,16,FollowSets000.FOLLOW_9); 

                        	newLeafNode(otherlv_16, grammarAccess.getModelAccess().getNumberSignDigitTwoPlusSignKeyword_1_3_0());
                        
                    // InternalBug309949TestLanguage.g:237:1: ( (lv_name_17_0= RULE_ID ) )
                    // InternalBug309949TestLanguage.g:238:1: (lv_name_17_0= RULE_ID )
                    {
                    // InternalBug309949TestLanguage.g:238:1: (lv_name_17_0= RULE_ID )
                    // InternalBug309949TestLanguage.g:239:3: lv_name_17_0= RULE_ID
                    {
                    lv_name_17_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    			newLeafNode(lv_name_17_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModelRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_17_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    otherlv_18=(Token)match(input,12,FollowSets000.FOLLOW_10); 

                        	newLeafNode(otherlv_18, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_3_2());
                        
                    // InternalBug309949TestLanguage.g:259:1: ( (lv_errors_19_0= ruleError_2 ) )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        alt7 = dfa7.predict(input);
                        switch (alt7) {
                    	case 1 :
                    	    // InternalBug309949TestLanguage.g:260:1: (lv_errors_19_0= ruleError_2 )
                    	    {
                    	    // InternalBug309949TestLanguage.g:260:1: (lv_errors_19_0= ruleError_2 )
                    	    // InternalBug309949TestLanguage.g:261:3: lv_errors_19_0= ruleError_2
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getErrorsError_2ParserRuleCall_1_3_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_10);
                    	    lv_errors_19_0=ruleError_2();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"errors",
                    	            		lv_errors_19_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Error_2");
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

                    // InternalBug309949TestLanguage.g:277:3: ( (lv_operations_20_0= ruleOperation_2 ) )+
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
                    	    // InternalBug309949TestLanguage.g:278:1: (lv_operations_20_0= ruleOperation_2 )
                    	    {
                    	    // InternalBug309949TestLanguage.g:278:1: (lv_operations_20_0= ruleOperation_2 )
                    	    // InternalBug309949TestLanguage.g:279:3: lv_operations_20_0= ruleOperation_2
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_2ParserRuleCall_1_3_4_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_8);
                    	    lv_operations_20_0=ruleOperation_2();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_20_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Operation_2");
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

                    otherlv_21=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_21, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_3_5());
                        

                    }


                    }
                    break;
                case 5 :
                    // InternalBug309949TestLanguage.g:300:6: (otherlv_22= '#3*' ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* otherlv_27= '}' )
                    {
                    // InternalBug309949TestLanguage.g:300:6: (otherlv_22= '#3*' ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* otherlv_27= '}' )
                    // InternalBug309949TestLanguage.g:300:8: otherlv_22= '#3*' ( (lv_name_23_0= RULE_ID ) ) otherlv_24= '{' ( (lv_errors_25_0= ruleError_3 ) )* ( (lv_operations_26_0= ruleOperation_3 ) )* otherlv_27= '}'
                    {
                    otherlv_22=(Token)match(input,17,FollowSets000.FOLLOW_9); 

                        	newLeafNode(otherlv_22, grammarAccess.getModelAccess().getNumberSignDigitThreeAsteriskKeyword_1_4_0());
                        
                    // InternalBug309949TestLanguage.g:304:1: ( (lv_name_23_0= RULE_ID ) )
                    // InternalBug309949TestLanguage.g:305:1: (lv_name_23_0= RULE_ID )
                    {
                    // InternalBug309949TestLanguage.g:305:1: (lv_name_23_0= RULE_ID )
                    // InternalBug309949TestLanguage.g:306:3: lv_name_23_0= RULE_ID
                    {
                    lv_name_23_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    			newLeafNode(lv_name_23_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_4_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModelRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_23_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    otherlv_24=(Token)match(input,12,FollowSets000.FOLLOW_4); 

                        	newLeafNode(otherlv_24, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_4_2());
                        
                    // InternalBug309949TestLanguage.g:326:1: ( (lv_errors_25_0= ruleError_3 ) )*
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
                    	    // InternalBug309949TestLanguage.g:327:1: (lv_errors_25_0= ruleError_3 )
                    	    {
                    	    // InternalBug309949TestLanguage.g:327:1: (lv_errors_25_0= ruleError_3 )
                    	    // InternalBug309949TestLanguage.g:328:3: lv_errors_25_0= ruleError_3
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getErrorsError_3ParserRuleCall_1_4_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_4);
                    	    lv_errors_25_0=ruleError_3();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"errors",
                    	            		lv_errors_25_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Error_3");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    // InternalBug309949TestLanguage.g:344:3: ( (lv_operations_26_0= ruleOperation_3 ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>=24 && LA10_0<=25)) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalBug309949TestLanguage.g:345:1: (lv_operations_26_0= ruleOperation_3 )
                    	    {
                    	    // InternalBug309949TestLanguage.g:345:1: (lv_operations_26_0= ruleOperation_3 )
                    	    // InternalBug309949TestLanguage.g:346:3: lv_operations_26_0= ruleOperation_3
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_3ParserRuleCall_1_4_4_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_5);
                    	    lv_operations_26_0=ruleOperation_3();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_26_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Operation_3");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    otherlv_27=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_27, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_4_5());
                        

                    }


                    }
                    break;
                case 6 :
                    // InternalBug309949TestLanguage.g:367:6: (otherlv_28= '#3+' ( (lv_name_29_0= RULE_ID ) ) otherlv_30= '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ otherlv_33= '}' )
                    {
                    // InternalBug309949TestLanguage.g:367:6: (otherlv_28= '#3+' ( (lv_name_29_0= RULE_ID ) ) otherlv_30= '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ otherlv_33= '}' )
                    // InternalBug309949TestLanguage.g:367:8: otherlv_28= '#3+' ( (lv_name_29_0= RULE_ID ) ) otherlv_30= '{' ( (lv_errors_31_0= ruleError_3 ) )+ ( (lv_operations_32_0= ruleOperation_3 ) )+ otherlv_33= '}'
                    {
                    otherlv_28=(Token)match(input,18,FollowSets000.FOLLOW_9); 

                        	newLeafNode(otherlv_28, grammarAccess.getModelAccess().getNumberSignDigitThreePlusSignKeyword_1_5_0());
                        
                    // InternalBug309949TestLanguage.g:371:1: ( (lv_name_29_0= RULE_ID ) )
                    // InternalBug309949TestLanguage.g:372:1: (lv_name_29_0= RULE_ID )
                    {
                    // InternalBug309949TestLanguage.g:372:1: (lv_name_29_0= RULE_ID )
                    // InternalBug309949TestLanguage.g:373:3: lv_name_29_0= RULE_ID
                    {
                    lv_name_29_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    			newLeafNode(lv_name_29_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_5_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModelRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_29_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    otherlv_30=(Token)match(input,12,FollowSets000.FOLLOW_6); 

                        	newLeafNode(otherlv_30, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_5_2());
                        
                    // InternalBug309949TestLanguage.g:393:1: ( (lv_errors_31_0= ruleError_3 ) )+
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
                    	    // InternalBug309949TestLanguage.g:394:1: (lv_errors_31_0= ruleError_3 )
                    	    {
                    	    // InternalBug309949TestLanguage.g:394:1: (lv_errors_31_0= ruleError_3 )
                    	    // InternalBug309949TestLanguage.g:395:3: lv_errors_31_0= ruleError_3
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getErrorsError_3ParserRuleCall_1_5_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_7);
                    	    lv_errors_31_0=ruleError_3();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"errors",
                    	            		lv_errors_31_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Error_3");
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

                    // InternalBug309949TestLanguage.g:411:3: ( (lv_operations_32_0= ruleOperation_3 ) )+
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
                    	    // InternalBug309949TestLanguage.g:412:1: (lv_operations_32_0= ruleOperation_3 )
                    	    {
                    	    // InternalBug309949TestLanguage.g:412:1: (lv_operations_32_0= ruleOperation_3 )
                    	    // InternalBug309949TestLanguage.g:413:3: lv_operations_32_0= ruleOperation_3
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_3ParserRuleCall_1_5_4_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_5);
                    	    lv_operations_32_0=ruleOperation_3();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_32_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Operation_3");
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

                    otherlv_33=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_33, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_5_5());
                        

                    }


                    }
                    break;
                case 7 :
                    // InternalBug309949TestLanguage.g:434:6: (otherlv_34= '#4*' ( (lv_name_35_0= RULE_ID ) ) otherlv_36= '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* otherlv_39= '}' )
                    {
                    // InternalBug309949TestLanguage.g:434:6: (otherlv_34= '#4*' ( (lv_name_35_0= RULE_ID ) ) otherlv_36= '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* otherlv_39= '}' )
                    // InternalBug309949TestLanguage.g:434:8: otherlv_34= '#4*' ( (lv_name_35_0= RULE_ID ) ) otherlv_36= '{' ( (lv_errors_37_0= ruleError_4 ) )* ( (lv_operations_38_0= ruleOperation_4 ) )* otherlv_39= '}'
                    {
                    otherlv_34=(Token)match(input,19,FollowSets000.FOLLOW_9); 

                        	newLeafNode(otherlv_34, grammarAccess.getModelAccess().getNumberSignDigitFourAsteriskKeyword_1_6_0());
                        
                    // InternalBug309949TestLanguage.g:438:1: ( (lv_name_35_0= RULE_ID ) )
                    // InternalBug309949TestLanguage.g:439:1: (lv_name_35_0= RULE_ID )
                    {
                    // InternalBug309949TestLanguage.g:439:1: (lv_name_35_0= RULE_ID )
                    // InternalBug309949TestLanguage.g:440:3: lv_name_35_0= RULE_ID
                    {
                    lv_name_35_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    			newLeafNode(lv_name_35_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_6_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModelRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_35_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    otherlv_36=(Token)match(input,12,FollowSets000.FOLLOW_8); 

                        	newLeafNode(otherlv_36, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_6_2());
                        
                    // InternalBug309949TestLanguage.g:460:1: ( (lv_errors_37_0= ruleError_4 ) )*
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
                    	    // InternalBug309949TestLanguage.g:461:1: (lv_errors_37_0= ruleError_4 )
                    	    {
                    	    // InternalBug309949TestLanguage.g:461:1: (lv_errors_37_0= ruleError_4 )
                    	    // InternalBug309949TestLanguage.g:462:3: lv_errors_37_0= ruleError_4
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getErrorsError_4ParserRuleCall_1_6_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_8);
                    	    lv_errors_37_0=ruleError_4();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"errors",
                    	            		lv_errors_37_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Error_4");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    // InternalBug309949TestLanguage.g:478:3: ( (lv_operations_38_0= ruleOperation_4 ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==25) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalBug309949TestLanguage.g:479:1: (lv_operations_38_0= ruleOperation_4 )
                    	    {
                    	    // InternalBug309949TestLanguage.g:479:1: (lv_operations_38_0= ruleOperation_4 )
                    	    // InternalBug309949TestLanguage.g:480:3: lv_operations_38_0= ruleOperation_4
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_4ParserRuleCall_1_6_4_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_8);
                    	    lv_operations_38_0=ruleOperation_4();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_38_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Operation_4");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    otherlv_39=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_39, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_6_5());
                        

                    }


                    }
                    break;
                case 8 :
                    // InternalBug309949TestLanguage.g:501:6: (otherlv_40= '#4+' ( (lv_name_41_0= RULE_ID ) ) otherlv_42= '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ otherlv_45= '}' )
                    {
                    // InternalBug309949TestLanguage.g:501:6: (otherlv_40= '#4+' ( (lv_name_41_0= RULE_ID ) ) otherlv_42= '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ otherlv_45= '}' )
                    // InternalBug309949TestLanguage.g:501:8: otherlv_40= '#4+' ( (lv_name_41_0= RULE_ID ) ) otherlv_42= '{' ( (lv_errors_43_0= ruleError_4 ) )+ ( (lv_operations_44_0= ruleOperation_4 ) )+ otherlv_45= '}'
                    {
                    otherlv_40=(Token)match(input,20,FollowSets000.FOLLOW_9); 

                        	newLeafNode(otherlv_40, grammarAccess.getModelAccess().getNumberSignDigitFourPlusSignKeyword_1_7_0());
                        
                    // InternalBug309949TestLanguage.g:505:1: ( (lv_name_41_0= RULE_ID ) )
                    // InternalBug309949TestLanguage.g:506:1: (lv_name_41_0= RULE_ID )
                    {
                    // InternalBug309949TestLanguage.g:506:1: (lv_name_41_0= RULE_ID )
                    // InternalBug309949TestLanguage.g:507:3: lv_name_41_0= RULE_ID
                    {
                    lv_name_41_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    			newLeafNode(lv_name_41_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_7_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModelRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_41_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    otherlv_42=(Token)match(input,12,FollowSets000.FOLLOW_10); 

                        	newLeafNode(otherlv_42, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_7_2());
                        
                    // InternalBug309949TestLanguage.g:527:1: ( (lv_errors_43_0= ruleError_4 ) )+
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
                    	    // InternalBug309949TestLanguage.g:528:1: (lv_errors_43_0= ruleError_4 )
                    	    {
                    	    // InternalBug309949TestLanguage.g:528:1: (lv_errors_43_0= ruleError_4 )
                    	    // InternalBug309949TestLanguage.g:529:3: lv_errors_43_0= ruleError_4
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getErrorsError_4ParserRuleCall_1_7_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_10);
                    	    lv_errors_43_0=ruleError_4();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"errors",
                    	            		lv_errors_43_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Error_4");
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

                    // InternalBug309949TestLanguage.g:545:3: ( (lv_operations_44_0= ruleOperation_4 ) )+
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
                    	    // InternalBug309949TestLanguage.g:546:1: (lv_operations_44_0= ruleOperation_4 )
                    	    {
                    	    // InternalBug309949TestLanguage.g:546:1: (lv_operations_44_0= ruleOperation_4 )
                    	    // InternalBug309949TestLanguage.g:547:3: lv_operations_44_0= ruleOperation_4
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_4ParserRuleCall_1_7_4_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_8);
                    	    lv_operations_44_0=ruleOperation_4();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_44_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Operation_4");
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

                    otherlv_45=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_45, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_7_5());
                        

                    }


                    }
                    break;
                case 9 :
                    // InternalBug309949TestLanguage.g:568:6: (otherlv_46= '#5*' ( (lv_name_47_0= RULE_ID ) ) otherlv_48= '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* otherlv_51= '}' )
                    {
                    // InternalBug309949TestLanguage.g:568:6: (otherlv_46= '#5*' ( (lv_name_47_0= RULE_ID ) ) otherlv_48= '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* otherlv_51= '}' )
                    // InternalBug309949TestLanguage.g:568:8: otherlv_46= '#5*' ( (lv_name_47_0= RULE_ID ) ) otherlv_48= '{' ( (lv_errors_49_0= ruleError_5 ) )* ( (lv_operations_50_0= ruleOperation_5 ) )* otherlv_51= '}'
                    {
                    otherlv_46=(Token)match(input,21,FollowSets000.FOLLOW_9); 

                        	newLeafNode(otherlv_46, grammarAccess.getModelAccess().getNumberSignDigitFiveAsteriskKeyword_1_8_0());
                        
                    // InternalBug309949TestLanguage.g:572:1: ( (lv_name_47_0= RULE_ID ) )
                    // InternalBug309949TestLanguage.g:573:1: (lv_name_47_0= RULE_ID )
                    {
                    // InternalBug309949TestLanguage.g:573:1: (lv_name_47_0= RULE_ID )
                    // InternalBug309949TestLanguage.g:574:3: lv_name_47_0= RULE_ID
                    {
                    lv_name_47_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    			newLeafNode(lv_name_47_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_8_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModelRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_47_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    otherlv_48=(Token)match(input,12,FollowSets000.FOLLOW_11); 

                        	newLeafNode(otherlv_48, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_8_2());
                        
                    // InternalBug309949TestLanguage.g:594:1: ( (lv_errors_49_0= ruleError_5 ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==23) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalBug309949TestLanguage.g:595:1: (lv_errors_49_0= ruleError_5 )
                    	    {
                    	    // InternalBug309949TestLanguage.g:595:1: (lv_errors_49_0= ruleError_5 )
                    	    // InternalBug309949TestLanguage.g:596:3: lv_errors_49_0= ruleError_5
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getErrorsError_5ParserRuleCall_1_8_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_11);
                    	    lv_errors_49_0=ruleError_5();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"errors",
                    	            		lv_errors_49_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Error_5");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    // InternalBug309949TestLanguage.g:612:3: ( (lv_operations_50_0= ruleOperation_5 ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==24) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalBug309949TestLanguage.g:613:1: (lv_operations_50_0= ruleOperation_5 )
                    	    {
                    	    // InternalBug309949TestLanguage.g:613:1: (lv_operations_50_0= ruleOperation_5 )
                    	    // InternalBug309949TestLanguage.g:614:3: lv_operations_50_0= ruleOperation_5
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_5ParserRuleCall_1_8_4_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_12);
                    	    lv_operations_50_0=ruleOperation_5();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_50_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Operation_5");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    otherlv_51=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_51, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_8_5());
                        

                    }


                    }
                    break;
                case 10 :
                    // InternalBug309949TestLanguage.g:635:6: (otherlv_52= '#5+' ( (lv_name_53_0= RULE_ID ) ) otherlv_54= '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ otherlv_57= '}' )
                    {
                    // InternalBug309949TestLanguage.g:635:6: (otherlv_52= '#5+' ( (lv_name_53_0= RULE_ID ) ) otherlv_54= '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ otherlv_57= '}' )
                    // InternalBug309949TestLanguage.g:635:8: otherlv_52= '#5+' ( (lv_name_53_0= RULE_ID ) ) otherlv_54= '{' ( (lv_errors_55_0= ruleError_5 ) )+ ( (lv_operations_56_0= ruleOperation_5 ) )+ otherlv_57= '}'
                    {
                    otherlv_52=(Token)match(input,22,FollowSets000.FOLLOW_9); 

                        	newLeafNode(otherlv_52, grammarAccess.getModelAccess().getNumberSignDigitFivePlusSignKeyword_1_9_0());
                        
                    // InternalBug309949TestLanguage.g:639:1: ( (lv_name_53_0= RULE_ID ) )
                    // InternalBug309949TestLanguage.g:640:1: (lv_name_53_0= RULE_ID )
                    {
                    // InternalBug309949TestLanguage.g:640:1: (lv_name_53_0= RULE_ID )
                    // InternalBug309949TestLanguage.g:641:3: lv_name_53_0= RULE_ID
                    {
                    lv_name_53_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    			newLeafNode(lv_name_53_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_9_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModelRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_53_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    otherlv_54=(Token)match(input,12,FollowSets000.FOLLOW_13); 

                        	newLeafNode(otherlv_54, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_9_2());
                        
                    // InternalBug309949TestLanguage.g:661:1: ( (lv_errors_55_0= ruleError_5 ) )+
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
                    	    // InternalBug309949TestLanguage.g:662:1: (lv_errors_55_0= ruleError_5 )
                    	    {
                    	    // InternalBug309949TestLanguage.g:662:1: (lv_errors_55_0= ruleError_5 )
                    	    // InternalBug309949TestLanguage.g:663:3: lv_errors_55_0= ruleError_5
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getErrorsError_5ParserRuleCall_1_9_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_14);
                    	    lv_errors_55_0=ruleError_5();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"errors",
                    	            		lv_errors_55_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Error_5");
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

                    // InternalBug309949TestLanguage.g:679:3: ( (lv_operations_56_0= ruleOperation_5 ) )+
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
                    	    // InternalBug309949TestLanguage.g:680:1: (lv_operations_56_0= ruleOperation_5 )
                    	    {
                    	    // InternalBug309949TestLanguage.g:680:1: (lv_operations_56_0= ruleOperation_5 )
                    	    // InternalBug309949TestLanguage.g:681:3: lv_operations_56_0= ruleOperation_5
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelAccess().getOperationsOperation_5ParserRuleCall_1_9_4_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_12);
                    	    lv_operations_56_0=ruleOperation_5();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operations",
                    	            		lv_operations_56_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Operation_5");
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

                    otherlv_57=(Token)match(input,13,FollowSets000.FOLLOW_2); 

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
    // InternalBug309949TestLanguage.g:709:1: entryRuleError_1 returns [EObject current=null] : iv_ruleError_1= ruleError_1 EOF ;
    public final EObject entryRuleError_1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleError_1 = null;


        try {
            // InternalBug309949TestLanguage.g:710:2: (iv_ruleError_1= ruleError_1 EOF )
            // InternalBug309949TestLanguage.g:711:2: iv_ruleError_1= ruleError_1 EOF
            {
             newCompositeNode(grammarAccess.getError_1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleError_1=ruleError_1();

            state._fsp--;

             current =iv_ruleError_1; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalBug309949TestLanguage.g:718:1: ruleError_1 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleError_1() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBug309949TestLanguage.g:721:28: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalBug309949TestLanguage.g:722:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalBug309949TestLanguage.g:722:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalBug309949TestLanguage.g:722:2: ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalBug309949TestLanguage.g:722:2: ( (lv_annotations_0_0= ruleAnnotation ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==25) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalBug309949TestLanguage.g:723:1: (lv_annotations_0_0= ruleAnnotation )
            	    {
            	    // InternalBug309949TestLanguage.g:723:1: (lv_annotations_0_0= ruleAnnotation )
            	    // InternalBug309949TestLanguage.g:724:3: lv_annotations_0_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getError_1Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    lv_annotations_0_0=ruleAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getError_1Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_0_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Annotation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_9); 

                	newLeafNode(otherlv_1, grammarAccess.getError_1Access().getErrorKeyword_1());
                
            // InternalBug309949TestLanguage.g:744:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalBug309949TestLanguage.g:745:1: (lv_name_2_0= RULE_ID )
            {
            // InternalBug309949TestLanguage.g:745:1: (lv_name_2_0= RULE_ID )
            // InternalBug309949TestLanguage.g:746:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_2_0, grammarAccess.getError_1Access().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getError_1Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // InternalBug309949TestLanguage.g:770:1: entryRuleOperation_1 returns [EObject current=null] : iv_ruleOperation_1= ruleOperation_1 EOF ;
    public final EObject entryRuleOperation_1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation_1 = null;


        try {
            // InternalBug309949TestLanguage.g:771:2: (iv_ruleOperation_1= ruleOperation_1 EOF )
            // InternalBug309949TestLanguage.g:772:2: iv_ruleOperation_1= ruleOperation_1 EOF
            {
             newCompositeNode(grammarAccess.getOperation_1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOperation_1=ruleOperation_1();

            state._fsp--;

             current =iv_ruleOperation_1; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalBug309949TestLanguage.g:779:1: ruleOperation_1 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleOperation_1() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBug309949TestLanguage.g:782:28: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalBug309949TestLanguage.g:783:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalBug309949TestLanguage.g:783:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalBug309949TestLanguage.g:783:2: ( (lv_annotations_0_0= ruleAnnotation ) )* otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalBug309949TestLanguage.g:783:2: ( (lv_annotations_0_0= ruleAnnotation ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==25) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalBug309949TestLanguage.g:784:1: (lv_annotations_0_0= ruleAnnotation )
            	    {
            	    // InternalBug309949TestLanguage.g:784:1: (lv_annotations_0_0= ruleAnnotation )
            	    // InternalBug309949TestLanguage.g:785:3: lv_annotations_0_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOperation_1Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_15);
            	    lv_annotations_0_0=ruleAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getOperation_1Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_0_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Annotation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_9); 

                	newLeafNode(otherlv_1, grammarAccess.getOperation_1Access().getOperationKeyword_1());
                
            // InternalBug309949TestLanguage.g:805:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalBug309949TestLanguage.g:806:1: (lv_name_2_0= RULE_ID )
            {
            // InternalBug309949TestLanguage.g:806:1: (lv_name_2_0= RULE_ID )
            // InternalBug309949TestLanguage.g:807:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_2_0, grammarAccess.getOperation_1Access().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOperation_1Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // InternalBug309949TestLanguage.g:831:1: entryRuleError_2 returns [EObject current=null] : iv_ruleError_2= ruleError_2 EOF ;
    public final EObject entryRuleError_2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleError_2 = null;


        try {
            // InternalBug309949TestLanguage.g:832:2: (iv_ruleError_2= ruleError_2 EOF )
            // InternalBug309949TestLanguage.g:833:2: iv_ruleError_2= ruleError_2 EOF
            {
             newCompositeNode(grammarAccess.getError_2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleError_2=ruleError_2();

            state._fsp--;

             current =iv_ruleError_2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalBug309949TestLanguage.g:840:1: ruleError_2 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )+ otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleError_2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBug309949TestLanguage.g:843:28: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )+ otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalBug309949TestLanguage.g:844:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )+ otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalBug309949TestLanguage.g:844:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )+ otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalBug309949TestLanguage.g:844:2: ( (lv_annotations_0_0= ruleAnnotation ) )+ otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalBug309949TestLanguage.g:844:2: ( (lv_annotations_0_0= ruleAnnotation ) )+
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
            	    // InternalBug309949TestLanguage.g:845:1: (lv_annotations_0_0= ruleAnnotation )
            	    {
            	    // InternalBug309949TestLanguage.g:845:1: (lv_annotations_0_0= ruleAnnotation )
            	    // InternalBug309949TestLanguage.g:846:3: lv_annotations_0_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getError_2Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    lv_annotations_0_0=ruleAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getError_2Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_0_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Annotation");
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

            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_9); 

                	newLeafNode(otherlv_1, grammarAccess.getError_2Access().getErrorKeyword_1());
                
            // InternalBug309949TestLanguage.g:866:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalBug309949TestLanguage.g:867:1: (lv_name_2_0= RULE_ID )
            {
            // InternalBug309949TestLanguage.g:867:1: (lv_name_2_0= RULE_ID )
            // InternalBug309949TestLanguage.g:868:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_2_0, grammarAccess.getError_2Access().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getError_2Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // InternalBug309949TestLanguage.g:892:1: entryRuleOperation_2 returns [EObject current=null] : iv_ruleOperation_2= ruleOperation_2 EOF ;
    public final EObject entryRuleOperation_2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation_2 = null;


        try {
            // InternalBug309949TestLanguage.g:893:2: (iv_ruleOperation_2= ruleOperation_2 EOF )
            // InternalBug309949TestLanguage.g:894:2: iv_ruleOperation_2= ruleOperation_2 EOF
            {
             newCompositeNode(grammarAccess.getOperation_2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOperation_2=ruleOperation_2();

            state._fsp--;

             current =iv_ruleOperation_2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalBug309949TestLanguage.g:901:1: ruleOperation_2 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )+ otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleOperation_2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBug309949TestLanguage.g:904:28: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )+ otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalBug309949TestLanguage.g:905:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )+ otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalBug309949TestLanguage.g:905:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )+ otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalBug309949TestLanguage.g:905:2: ( (lv_annotations_0_0= ruleAnnotation ) )+ otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalBug309949TestLanguage.g:905:2: ( (lv_annotations_0_0= ruleAnnotation ) )+
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
            	    // InternalBug309949TestLanguage.g:906:1: (lv_annotations_0_0= ruleAnnotation )
            	    {
            	    // InternalBug309949TestLanguage.g:906:1: (lv_annotations_0_0= ruleAnnotation )
            	    // InternalBug309949TestLanguage.g:907:3: lv_annotations_0_0= ruleAnnotation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOperation_2Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_15);
            	    lv_annotations_0_0=ruleAnnotation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getOperation_2Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"annotations",
            	            		lv_annotations_0_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Annotation");
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

            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_9); 

                	newLeafNode(otherlv_1, grammarAccess.getOperation_2Access().getOperationKeyword_1());
                
            // InternalBug309949TestLanguage.g:927:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalBug309949TestLanguage.g:928:1: (lv_name_2_0= RULE_ID )
            {
            // InternalBug309949TestLanguage.g:928:1: (lv_name_2_0= RULE_ID )
            // InternalBug309949TestLanguage.g:929:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_2_0, grammarAccess.getOperation_2Access().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOperation_2Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // InternalBug309949TestLanguage.g:953:1: entryRuleError_3 returns [EObject current=null] : iv_ruleError_3= ruleError_3 EOF ;
    public final EObject entryRuleError_3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleError_3 = null;


        try {
            // InternalBug309949TestLanguage.g:954:2: (iv_ruleError_3= ruleError_3 EOF )
            // InternalBug309949TestLanguage.g:955:2: iv_ruleError_3= ruleError_3 EOF
            {
             newCompositeNode(grammarAccess.getError_3Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleError_3=ruleError_3();

            state._fsp--;

             current =iv_ruleError_3; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalBug309949TestLanguage.g:962:1: ruleError_3 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )? otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleError_3() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBug309949TestLanguage.g:965:28: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )? otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalBug309949TestLanguage.g:966:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )? otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalBug309949TestLanguage.g:966:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )? otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalBug309949TestLanguage.g:966:2: ( (lv_annotations_0_0= ruleAnnotation ) )? otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalBug309949TestLanguage.g:966:2: ( (lv_annotations_0_0= ruleAnnotation ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==25) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalBug309949TestLanguage.g:967:1: (lv_annotations_0_0= ruleAnnotation )
                    {
                    // InternalBug309949TestLanguage.g:967:1: (lv_annotations_0_0= ruleAnnotation )
                    // InternalBug309949TestLanguage.g:968:3: lv_annotations_0_0= ruleAnnotation
                    {
                     
                    	        newCompositeNode(grammarAccess.getError_3Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_13);
                    lv_annotations_0_0=ruleAnnotation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getError_3Rule());
                    	        }
                           		add(
                           			current, 
                           			"annotations",
                            		lv_annotations_0_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Annotation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_9); 

                	newLeafNode(otherlv_1, grammarAccess.getError_3Access().getErrorKeyword_1());
                
            // InternalBug309949TestLanguage.g:988:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalBug309949TestLanguage.g:989:1: (lv_name_2_0= RULE_ID )
            {
            // InternalBug309949TestLanguage.g:989:1: (lv_name_2_0= RULE_ID )
            // InternalBug309949TestLanguage.g:990:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_2_0, grammarAccess.getError_3Access().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getError_3Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // InternalBug309949TestLanguage.g:1014:1: entryRuleOperation_3 returns [EObject current=null] : iv_ruleOperation_3= ruleOperation_3 EOF ;
    public final EObject entryRuleOperation_3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation_3 = null;


        try {
            // InternalBug309949TestLanguage.g:1015:2: (iv_ruleOperation_3= ruleOperation_3 EOF )
            // InternalBug309949TestLanguage.g:1016:2: iv_ruleOperation_3= ruleOperation_3 EOF
            {
             newCompositeNode(grammarAccess.getOperation_3Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOperation_3=ruleOperation_3();

            state._fsp--;

             current =iv_ruleOperation_3; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalBug309949TestLanguage.g:1023:1: ruleOperation_3 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )? otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleOperation_3() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBug309949TestLanguage.g:1026:28: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )? otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalBug309949TestLanguage.g:1027:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )? otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalBug309949TestLanguage.g:1027:1: ( ( (lv_annotations_0_0= ruleAnnotation ) )? otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalBug309949TestLanguage.g:1027:2: ( (lv_annotations_0_0= ruleAnnotation ) )? otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalBug309949TestLanguage.g:1027:2: ( (lv_annotations_0_0= ruleAnnotation ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==25) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalBug309949TestLanguage.g:1028:1: (lv_annotations_0_0= ruleAnnotation )
                    {
                    // InternalBug309949TestLanguage.g:1028:1: (lv_annotations_0_0= ruleAnnotation )
                    // InternalBug309949TestLanguage.g:1029:3: lv_annotations_0_0= ruleAnnotation
                    {
                     
                    	        newCompositeNode(grammarAccess.getOperation_3Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_16);
                    lv_annotations_0_0=ruleAnnotation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOperation_3Rule());
                    	        }
                           		add(
                           			current, 
                           			"annotations",
                            		lv_annotations_0_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Annotation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_9); 

                	newLeafNode(otherlv_1, grammarAccess.getOperation_3Access().getOperationKeyword_1());
                
            // InternalBug309949TestLanguage.g:1049:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalBug309949TestLanguage.g:1050:1: (lv_name_2_0= RULE_ID )
            {
            // InternalBug309949TestLanguage.g:1050:1: (lv_name_2_0= RULE_ID )
            // InternalBug309949TestLanguage.g:1051:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_2_0, grammarAccess.getOperation_3Access().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOperation_3Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // InternalBug309949TestLanguage.g:1075:1: entryRuleError_4 returns [EObject current=null] : iv_ruleError_4= ruleError_4 EOF ;
    public final EObject entryRuleError_4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleError_4 = null;


        try {
            // InternalBug309949TestLanguage.g:1076:2: (iv_ruleError_4= ruleError_4 EOF )
            // InternalBug309949TestLanguage.g:1077:2: iv_ruleError_4= ruleError_4 EOF
            {
             newCompositeNode(grammarAccess.getError_4Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleError_4=ruleError_4();

            state._fsp--;

             current =iv_ruleError_4; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalBug309949TestLanguage.g:1084:1: ruleError_4 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) ) otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleError_4() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBug309949TestLanguage.g:1087:28: ( ( ( (lv_annotations_0_0= ruleAnnotation ) ) otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalBug309949TestLanguage.g:1088:1: ( ( (lv_annotations_0_0= ruleAnnotation ) ) otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalBug309949TestLanguage.g:1088:1: ( ( (lv_annotations_0_0= ruleAnnotation ) ) otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalBug309949TestLanguage.g:1088:2: ( (lv_annotations_0_0= ruleAnnotation ) ) otherlv_1= 'error' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalBug309949TestLanguage.g:1088:2: ( (lv_annotations_0_0= ruleAnnotation ) )
            // InternalBug309949TestLanguage.g:1089:1: (lv_annotations_0_0= ruleAnnotation )
            {
            // InternalBug309949TestLanguage.g:1089:1: (lv_annotations_0_0= ruleAnnotation )
            // InternalBug309949TestLanguage.g:1090:3: lv_annotations_0_0= ruleAnnotation
            {
             
            	        newCompositeNode(grammarAccess.getError_4Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_13);
            lv_annotations_0_0=ruleAnnotation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getError_4Rule());
            	        }
                   		add(
                   			current, 
                   			"annotations",
                    		lv_annotations_0_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Annotation");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_9); 

                	newLeafNode(otherlv_1, grammarAccess.getError_4Access().getErrorKeyword_1());
                
            // InternalBug309949TestLanguage.g:1110:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalBug309949TestLanguage.g:1111:1: (lv_name_2_0= RULE_ID )
            {
            // InternalBug309949TestLanguage.g:1111:1: (lv_name_2_0= RULE_ID )
            // InternalBug309949TestLanguage.g:1112:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_2_0, grammarAccess.getError_4Access().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getError_4Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // InternalBug309949TestLanguage.g:1136:1: entryRuleOperation_4 returns [EObject current=null] : iv_ruleOperation_4= ruleOperation_4 EOF ;
    public final EObject entryRuleOperation_4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation_4 = null;


        try {
            // InternalBug309949TestLanguage.g:1137:2: (iv_ruleOperation_4= ruleOperation_4 EOF )
            // InternalBug309949TestLanguage.g:1138:2: iv_ruleOperation_4= ruleOperation_4 EOF
            {
             newCompositeNode(grammarAccess.getOperation_4Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOperation_4=ruleOperation_4();

            state._fsp--;

             current =iv_ruleOperation_4; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalBug309949TestLanguage.g:1145:1: ruleOperation_4 returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) ) otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleOperation_4() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBug309949TestLanguage.g:1148:28: ( ( ( (lv_annotations_0_0= ruleAnnotation ) ) otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalBug309949TestLanguage.g:1149:1: ( ( (lv_annotations_0_0= ruleAnnotation ) ) otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalBug309949TestLanguage.g:1149:1: ( ( (lv_annotations_0_0= ruleAnnotation ) ) otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalBug309949TestLanguage.g:1149:2: ( (lv_annotations_0_0= ruleAnnotation ) ) otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalBug309949TestLanguage.g:1149:2: ( (lv_annotations_0_0= ruleAnnotation ) )
            // InternalBug309949TestLanguage.g:1150:1: (lv_annotations_0_0= ruleAnnotation )
            {
            // InternalBug309949TestLanguage.g:1150:1: (lv_annotations_0_0= ruleAnnotation )
            // InternalBug309949TestLanguage.g:1151:3: lv_annotations_0_0= ruleAnnotation
            {
             
            	        newCompositeNode(grammarAccess.getOperation_4Access().getAnnotationsAnnotationParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_16);
            lv_annotations_0_0=ruleAnnotation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOperation_4Rule());
            	        }
                   		add(
                   			current, 
                   			"annotations",
                    		lv_annotations_0_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug309949TestLanguage.Annotation");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_9); 

                	newLeafNode(otherlv_1, grammarAccess.getOperation_4Access().getOperationKeyword_1());
                
            // InternalBug309949TestLanguage.g:1171:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalBug309949TestLanguage.g:1172:1: (lv_name_2_0= RULE_ID )
            {
            // InternalBug309949TestLanguage.g:1172:1: (lv_name_2_0= RULE_ID )
            // InternalBug309949TestLanguage.g:1173:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_2_0, grammarAccess.getOperation_4Access().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOperation_4Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // InternalBug309949TestLanguage.g:1197:1: entryRuleError_5 returns [EObject current=null] : iv_ruleError_5= ruleError_5 EOF ;
    public final EObject entryRuleError_5() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleError_5 = null;


        try {
            // InternalBug309949TestLanguage.g:1198:2: (iv_ruleError_5= ruleError_5 EOF )
            // InternalBug309949TestLanguage.g:1199:2: iv_ruleError_5= ruleError_5 EOF
            {
             newCompositeNode(grammarAccess.getError_5Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleError_5=ruleError_5();

            state._fsp--;

             current =iv_ruleError_5; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalBug309949TestLanguage.g:1206:1: ruleError_5 returns [EObject current=null] : (otherlv_0= 'error' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleError_5() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalBug309949TestLanguage.g:1209:28: ( (otherlv_0= 'error' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalBug309949TestLanguage.g:1210:1: (otherlv_0= 'error' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalBug309949TestLanguage.g:1210:1: (otherlv_0= 'error' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalBug309949TestLanguage.g:1210:3: otherlv_0= 'error' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_9); 

                	newLeafNode(otherlv_0, grammarAccess.getError_5Access().getErrorKeyword_0());
                
            // InternalBug309949TestLanguage.g:1214:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalBug309949TestLanguage.g:1215:1: (lv_name_1_0= RULE_ID )
            {
            // InternalBug309949TestLanguage.g:1215:1: (lv_name_1_0= RULE_ID )
            // InternalBug309949TestLanguage.g:1216:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_1_0, grammarAccess.getError_5Access().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getError_5Rule());
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
    // InternalBug309949TestLanguage.g:1240:1: entryRuleOperation_5 returns [EObject current=null] : iv_ruleOperation_5= ruleOperation_5 EOF ;
    public final EObject entryRuleOperation_5() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation_5 = null;


        try {
            // InternalBug309949TestLanguage.g:1241:2: (iv_ruleOperation_5= ruleOperation_5 EOF )
            // InternalBug309949TestLanguage.g:1242:2: iv_ruleOperation_5= ruleOperation_5 EOF
            {
             newCompositeNode(grammarAccess.getOperation_5Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOperation_5=ruleOperation_5();

            state._fsp--;

             current =iv_ruleOperation_5; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalBug309949TestLanguage.g:1249:1: ruleOperation_5 returns [EObject current=null] : (otherlv_0= 'operation' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleOperation_5() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalBug309949TestLanguage.g:1252:28: ( (otherlv_0= 'operation' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalBug309949TestLanguage.g:1253:1: (otherlv_0= 'operation' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalBug309949TestLanguage.g:1253:1: (otherlv_0= 'operation' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalBug309949TestLanguage.g:1253:3: otherlv_0= 'operation' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_9); 

                	newLeafNode(otherlv_0, grammarAccess.getOperation_5Access().getOperationKeyword_0());
                
            // InternalBug309949TestLanguage.g:1257:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalBug309949TestLanguage.g:1258:1: (lv_name_1_0= RULE_ID )
            {
            // InternalBug309949TestLanguage.g:1258:1: (lv_name_1_0= RULE_ID )
            // InternalBug309949TestLanguage.g:1259:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_1_0, grammarAccess.getOperation_5Access().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOperation_5Rule());
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
    // InternalBug309949TestLanguage.g:1283:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // InternalBug309949TestLanguage.g:1284:2: (iv_ruleAnnotation= ruleAnnotation EOF )
            // InternalBug309949TestLanguage.g:1285:2: iv_ruleAnnotation= ruleAnnotation EOF
            {
             newCompositeNode(grammarAccess.getAnnotationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAnnotation=ruleAnnotation();

            state._fsp--;

             current =iv_ruleAnnotation; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

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
    // InternalBug309949TestLanguage.g:1292:1: ruleAnnotation returns [EObject current=null] : (otherlv_0= '@uuid' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalBug309949TestLanguage.g:1295:28: ( (otherlv_0= '@uuid' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalBug309949TestLanguage.g:1296:1: (otherlv_0= '@uuid' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalBug309949TestLanguage.g:1296:1: (otherlv_0= '@uuid' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalBug309949TestLanguage.g:1296:3: otherlv_0= '@uuid' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_9); 

                	newLeafNode(otherlv_0, grammarAccess.getAnnotationAccess().getUuidKeyword_0());
                
            // InternalBug309949TestLanguage.g:1300:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalBug309949TestLanguage.g:1301:1: (lv_name_1_0= RULE_ID )
            {
            // InternalBug309949TestLanguage.g:1301:1: (lv_name_1_0= RULE_ID )
            // InternalBug309949TestLanguage.g:1302:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAnnotationAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAnnotationRule());
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
            return "()* loopback of 94:1: ( (lv_errors_3_0= ruleError_1 ) )*";
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
            return "()+ loopback of 143:1: ( (lv_errors_8_0= ruleError_1 ) )+";
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
            return "()* loopback of 192:1: ( (lv_errors_13_0= ruleError_2 ) )*";
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
        "\3\uffff\1\2\1\1";
    static final String DFA7_specialS =
        "\5\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1",
            "\1\2",
            "\1\4\1\3\1\1",
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
            return "()+ loopback of 259:1: ( (lv_errors_19_0= ruleError_2 ) )+";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000003802000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000003002000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000002800000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000003800000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000001802000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000001002000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001800000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001000000L});
    }


}