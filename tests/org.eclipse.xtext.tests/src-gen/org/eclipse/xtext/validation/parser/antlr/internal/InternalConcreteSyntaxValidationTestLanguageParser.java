package org.eclipse.xtext.validation.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.validation.services.ConcreteSyntaxValidationTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalConcreteSyntaxValidationTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'#2'", "'kw1'", "'kw2'", "'#3'", "'kw3'", "'#4'", "'#5'", "'kw4'", "'kw5'", "'#6'", "'#7'", "'#8'", "'#9'", "'#10'", "'#11'", "'#12'", "'#13'", "'#14'", "'#15'", "'#16'", "'group'", "'#17'", "','", "'#18'", "'#19'", "'#20'", "'#21'", "'#22'", "'#23'", "'kw'", "'#24'", "'#25'", "'#26'", "'#27'", "'short'", "'one'", "'long'", "'extra'", "'two'", "'#28'", "'lit1'", "'lit2'"
    };
    public static final int T__42=42;
    public static final int T__12=12;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int T__51=51;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__47=47;
    public static final int T__50=50;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__39=39;
    public static final int T__30=30;
    public static final int T__52=52;
    public static final int T__46=46;
    public static final int T__17=17;
    public static final int RULE_INT=5;
    public static final int T__27=27;
    public static final int T__24=24;
    public static final int T__49=49;
    public static final int T__48=48;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__35=35;
    public static final int RULE_ID=4;
    public static final int T__36=36;
    public static final int T__20=20;
    public static final int T__44=44;
    public static final int T__14=14;
    public static final int T__33=33;
    public static final int T__22=22;
    public static final int T__11=11;
    public static final int T__29=29;
    public static final int T__45=45;
    public static final int RULE_WS=9;
    public static final int T__43=43;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int T__16=16;
    public static final int T__32=32;
    public static final int T__38=38;
    public static final int T__37=37;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__41=41;
    public static final int T__18=18;

    // delegates
    // delegators


        public InternalConcreteSyntaxValidationTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalConcreteSyntaxValidationTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalConcreteSyntaxValidationTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g"; }



     	private ConcreteSyntaxValidationTestLanguageGrammarAccess grammarAccess;
     	
        public InternalConcreteSyntaxValidationTestLanguageParser(TokenStream input, IAstFactory factory, ConcreteSyntaxValidationTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected ConcreteSyntaxValidationTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:73:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:74:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:81:1: ruleModel returns [EObject current=null] : ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_x1_0_0 = null;

        EObject lv_x2_1_0 = null;

        EObject lv_x3_2_0 = null;

        EObject lv_x4_3_0 = null;

        EObject lv_x5_4_0 = null;

        EObject lv_x6_5_0 = null;

        EObject lv_x7_6_0 = null;

        EObject lv_x8_7_0 = null;

        EObject lv_x9_8_0 = null;

        EObject lv_x10_9_0 = null;

        EObject lv_x11_10_0 = null;

        EObject lv_x12_11_0 = null;

        EObject lv_x13_12_0 = null;

        EObject lv_x14_13_0 = null;

        EObject lv_x15_14_0 = null;

        EObject lv_x16_15_0 = null;

        EObject lv_x17_16_0 = null;

        EObject lv_x18_17_0 = null;

        EObject lv_x19_18_0 = null;

        EObject lv_x20_19_0 = null;

        EObject lv_x21_20_0 = null;

        EObject lv_x22_21_0 = null;

        EObject lv_x23_22_0 = null;

        EObject lv_x24_23_0 = null;

        EObject lv_x25_24_0 = null;

        EObject lv_x26_25_0 = null;

        EObject lv_x27_26_0 = null;

        EObject lv_x28_27_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:86:6: ( ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:87:1: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:87:1: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) )
            int alt1=28;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 12:
                {
                alt1=2;
                }
                break;
            case 15:
                {
                alt1=3;
                }
                break;
            case 17:
                {
                alt1=4;
                }
                break;
            case 18:
                {
                alt1=5;
                }
                break;
            case 21:
                {
                alt1=6;
                }
                break;
            case 22:
                {
                alt1=7;
                }
                break;
            case 23:
                {
                alt1=8;
                }
                break;
            case 24:
                {
                alt1=9;
                }
                break;
            case 25:
                {
                alt1=10;
                }
                break;
            case 26:
                {
                alt1=11;
                }
                break;
            case 27:
                {
                alt1=12;
                }
                break;
            case 28:
                {
                alt1=13;
                }
                break;
            case 29:
                {
                alt1=14;
                }
                break;
            case 30:
                {
                alt1=15;
                }
                break;
            case 31:
                {
                alt1=16;
                }
                break;
            case 33:
                {
                alt1=17;
                }
                break;
            case 35:
                {
                alt1=18;
                }
                break;
            case 16:
            case 36:
                {
                alt1=19;
                }
                break;
            case 37:
                {
                alt1=20;
                }
                break;
            case 38:
                {
                alt1=21;
                }
                break;
            case 39:
                {
                alt1=22;
                }
                break;
            case 40:
                {
                alt1=23;
                }
                break;
            case 42:
                {
                alt1=24;
                }
                break;
            case 43:
                {
                alt1=25;
                }
                break;
            case 44:
                {
                alt1=26;
                }
                break;
            case 45:
                {
                alt1=27;
                }
                break;
            case 51:
                {
                alt1=28;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:87:2: ( (lv_x1_0_0= ruleSimpleGroup ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:87:2: ( (lv_x1_0_0= ruleSimpleGroup ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:88:1: (lv_x1_0_0= ruleSimpleGroup )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:88:1: (lv_x1_0_0= ruleSimpleGroup )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:89:3: lv_x1_0_0= ruleSimpleGroup
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX1SimpleGroupParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleGroup_in_ruleModel131);
                    lv_x1_0_0=ruleSimpleGroup();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x1",
                    	        		lv_x1_0_0, 
                    	        		"SimpleGroup", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:112:6: ( (lv_x2_1_0= ruleSimpleAlternative ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:112:6: ( (lv_x2_1_0= ruleSimpleAlternative ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:113:1: (lv_x2_1_0= ruleSimpleAlternative )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:113:1: (lv_x2_1_0= ruleSimpleAlternative )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:114:3: lv_x2_1_0= ruleSimpleAlternative
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX2SimpleAlternativeParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleAlternative_in_ruleModel158);
                    lv_x2_1_0=ruleSimpleAlternative();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x2",
                    	        		lv_x2_1_0, 
                    	        		"SimpleAlternative", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:137:6: ( (lv_x3_2_0= ruleSimpleMultiplicities ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:137:6: ( (lv_x3_2_0= ruleSimpleMultiplicities ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:138:1: (lv_x3_2_0= ruleSimpleMultiplicities )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:138:1: (lv_x3_2_0= ruleSimpleMultiplicities )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:139:3: lv_x3_2_0= ruleSimpleMultiplicities
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX3SimpleMultiplicitiesParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleMultiplicities_in_ruleModel185);
                    lv_x3_2_0=ruleSimpleMultiplicities();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x3",
                    	        		lv_x3_2_0, 
                    	        		"SimpleMultiplicities", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:162:6: ( (lv_x4_3_0= ruleGroupMultiplicities ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:162:6: ( (lv_x4_3_0= ruleGroupMultiplicities ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:163:1: (lv_x4_3_0= ruleGroupMultiplicities )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:163:1: (lv_x4_3_0= ruleGroupMultiplicities )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:164:3: lv_x4_3_0= ruleGroupMultiplicities
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX4GroupMultiplicitiesParserRuleCall_3_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleGroupMultiplicities_in_ruleModel212);
                    lv_x4_3_0=ruleGroupMultiplicities();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x4",
                    	        		lv_x4_3_0, 
                    	        		"GroupMultiplicities", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:187:6: ( (lv_x5_4_0= ruleAlternativeMultiplicities ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:187:6: ( (lv_x5_4_0= ruleAlternativeMultiplicities ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:188:1: (lv_x5_4_0= ruleAlternativeMultiplicities )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:188:1: (lv_x5_4_0= ruleAlternativeMultiplicities )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:189:3: lv_x5_4_0= ruleAlternativeMultiplicities
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX5AlternativeMultiplicitiesParserRuleCall_4_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAlternativeMultiplicities_in_ruleModel239);
                    lv_x5_4_0=ruleAlternativeMultiplicities();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x5",
                    	        		lv_x5_4_0, 
                    	        		"AlternativeMultiplicities", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:212:6: ( (lv_x6_5_0= ruleAssignedAction ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:212:6: ( (lv_x6_5_0= ruleAssignedAction ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:213:1: (lv_x6_5_0= ruleAssignedAction )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:213:1: (lv_x6_5_0= ruleAssignedAction )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:214:3: lv_x6_5_0= ruleAssignedAction
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX6AssignedActionParserRuleCall_5_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAssignedAction_in_ruleModel266);
                    lv_x6_5_0=ruleAssignedAction();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x6",
                    	        		lv_x6_5_0, 
                    	        		"AssignedAction", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:237:6: ( (lv_x7_6_0= ruleAssignedActionSecond ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:237:6: ( (lv_x7_6_0= ruleAssignedActionSecond ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:238:1: (lv_x7_6_0= ruleAssignedActionSecond )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:238:1: (lv_x7_6_0= ruleAssignedActionSecond )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:239:3: lv_x7_6_0= ruleAssignedActionSecond
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX7AssignedActionSecondParserRuleCall_6_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAssignedActionSecond_in_ruleModel293);
                    lv_x7_6_0=ruleAssignedActionSecond();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x7",
                    	        		lv_x7_6_0, 
                    	        		"AssignedActionSecond", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:262:6: ( (lv_x8_7_0= ruleUnassignedAction1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:262:6: ( (lv_x8_7_0= ruleUnassignedAction1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:263:1: (lv_x8_7_0= ruleUnassignedAction1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:263:1: (lv_x8_7_0= ruleUnassignedAction1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:264:3: lv_x8_7_0= ruleUnassignedAction1
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX8UnassignedAction1ParserRuleCall_7_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction1_in_ruleModel320);
                    lv_x8_7_0=ruleUnassignedAction1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x8",
                    	        		lv_x8_7_0, 
                    	        		"UnassignedAction1", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:287:6: ( (lv_x9_8_0= ruleUnassignedAction2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:287:6: ( (lv_x9_8_0= ruleUnassignedAction2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:288:1: (lv_x9_8_0= ruleUnassignedAction2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:288:1: (lv_x9_8_0= ruleUnassignedAction2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:289:3: lv_x9_8_0= ruleUnassignedAction2
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX9UnassignedAction2ParserRuleCall_8_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction2_in_ruleModel347);
                    lv_x9_8_0=ruleUnassignedAction2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x9",
                    	        		lv_x9_8_0, 
                    	        		"UnassignedAction2", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:312:6: ( (lv_x10_9_0= ruleUnassignedAction3 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:312:6: ( (lv_x10_9_0= ruleUnassignedAction3 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:313:1: (lv_x10_9_0= ruleUnassignedAction3 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:313:1: (lv_x10_9_0= ruleUnassignedAction3 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:314:3: lv_x10_9_0= ruleUnassignedAction3
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX10UnassignedAction3ParserRuleCall_9_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction3_in_ruleModel374);
                    lv_x10_9_0=ruleUnassignedAction3();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x10",
                    	        		lv_x10_9_0, 
                    	        		"UnassignedAction3", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 11 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:337:6: ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:337:6: ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:338:1: (lv_x11_10_0= ruleUnassignedRuleCall1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:338:1: (lv_x11_10_0= ruleUnassignedRuleCall1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:339:3: lv_x11_10_0= ruleUnassignedRuleCall1
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX11UnassignedRuleCall1ParserRuleCall_10_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall1_in_ruleModel401);
                    lv_x11_10_0=ruleUnassignedRuleCall1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x11",
                    	        		lv_x11_10_0, 
                    	        		"UnassignedRuleCall1", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 12 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:362:6: ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:362:6: ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:363:1: (lv_x12_11_0= ruleUnassignedRuleCall2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:363:1: (lv_x12_11_0= ruleUnassignedRuleCall2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:364:3: lv_x12_11_0= ruleUnassignedRuleCall2
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX12UnassignedRuleCall2ParserRuleCall_11_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall2_in_ruleModel428);
                    lv_x12_11_0=ruleUnassignedRuleCall2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x12",
                    	        		lv_x12_11_0, 
                    	        		"UnassignedRuleCall2", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 13 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:387:6: ( (lv_x13_12_0= ruleCombination1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:387:6: ( (lv_x13_12_0= ruleCombination1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:388:1: (lv_x13_12_0= ruleCombination1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:388:1: (lv_x13_12_0= ruleCombination1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:389:3: lv_x13_12_0= ruleCombination1
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX13Combination1ParserRuleCall_12_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCombination1_in_ruleModel455);
                    lv_x13_12_0=ruleCombination1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x13",
                    	        		lv_x13_12_0, 
                    	        		"Combination1", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 14 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:412:6: ( (lv_x14_13_0= ruleCombination2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:412:6: ( (lv_x14_13_0= ruleCombination2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:413:1: (lv_x14_13_0= ruleCombination2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:413:1: (lv_x14_13_0= ruleCombination2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:414:3: lv_x14_13_0= ruleCombination2
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX14Combination2ParserRuleCall_13_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCombination2_in_ruleModel482);
                    lv_x14_13_0=ruleCombination2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x14",
                    	        		lv_x14_13_0, 
                    	        		"Combination2", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 15 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:437:6: ( (lv_x15_14_0= ruleCombination3 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:437:6: ( (lv_x15_14_0= ruleCombination3 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:438:1: (lv_x15_14_0= ruleCombination3 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:438:1: (lv_x15_14_0= ruleCombination3 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:439:3: lv_x15_14_0= ruleCombination3
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX15Combination3ParserRuleCall_14_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCombination3_in_ruleModel509);
                    lv_x15_14_0=ruleCombination3();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x15",
                    	        		lv_x15_14_0, 
                    	        		"Combination3", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 16 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:462:6: ( (lv_x16_15_0= ruleCombination4 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:462:6: ( (lv_x16_15_0= ruleCombination4 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:463:1: (lv_x16_15_0= ruleCombination4 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:463:1: (lv_x16_15_0= ruleCombination4 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:464:3: lv_x16_15_0= ruleCombination4
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX16Combination4ParserRuleCall_15_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCombination4_in_ruleModel536);
                    lv_x16_15_0=ruleCombination4();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x16",
                    	        		lv_x16_15_0, 
                    	        		"Combination4", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 17 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:487:6: ( (lv_x17_16_0= ruleList1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:487:6: ( (lv_x17_16_0= ruleList1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:488:1: (lv_x17_16_0= ruleList1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:488:1: (lv_x17_16_0= ruleList1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:489:3: lv_x17_16_0= ruleList1
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX17List1ParserRuleCall_16_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleList1_in_ruleModel563);
                    lv_x17_16_0=ruleList1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x17",
                    	        		lv_x17_16_0, 
                    	        		"List1", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 18 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:512:6: ( (lv_x18_17_0= ruleList2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:512:6: ( (lv_x18_17_0= ruleList2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:513:1: (lv_x18_17_0= ruleList2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:513:1: (lv_x18_17_0= ruleList2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:514:3: lv_x18_17_0= ruleList2
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX18List2ParserRuleCall_17_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleList2_in_ruleModel590);
                    lv_x18_17_0=ruleList2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x18",
                    	        		lv_x18_17_0, 
                    	        		"List2", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 19 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:537:6: ( (lv_x19_18_0= ruleList3 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:537:6: ( (lv_x19_18_0= ruleList3 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:538:1: (lv_x19_18_0= ruleList3 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:538:1: (lv_x19_18_0= ruleList3 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:539:3: lv_x19_18_0= ruleList3
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX19List3ParserRuleCall_18_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleList3_in_ruleModel617);
                    lv_x19_18_0=ruleList3();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x19",
                    	        		lv_x19_18_0, 
                    	        		"List3", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 20 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:562:6: ( (lv_x20_19_0= ruleList4 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:562:6: ( (lv_x20_19_0= ruleList4 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:563:1: (lv_x20_19_0= ruleList4 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:563:1: (lv_x20_19_0= ruleList4 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:564:3: lv_x20_19_0= ruleList4
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX20List4ParserRuleCall_19_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleList4_in_ruleModel644);
                    lv_x20_19_0=ruleList4();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x20",
                    	        		lv_x20_19_0, 
                    	        		"List4", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 21 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:587:6: ( (lv_x21_20_0= ruleList5 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:587:6: ( (lv_x21_20_0= ruleList5 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:588:1: (lv_x21_20_0= ruleList5 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:588:1: (lv_x21_20_0= ruleList5 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:589:3: lv_x21_20_0= ruleList5
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX21List5ParserRuleCall_20_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleList5_in_ruleModel671);
                    lv_x21_20_0=ruleList5();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x21",
                    	        		lv_x21_20_0, 
                    	        		"List5", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 22 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:612:6: ( (lv_x22_21_0= ruleAltList1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:612:6: ( (lv_x22_21_0= ruleAltList1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:613:1: (lv_x22_21_0= ruleAltList1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:613:1: (lv_x22_21_0= ruleAltList1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:614:3: lv_x22_21_0= ruleAltList1
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX22AltList1ParserRuleCall_21_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAltList1_in_ruleModel698);
                    lv_x22_21_0=ruleAltList1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x22",
                    	        		lv_x22_21_0, 
                    	        		"AltList1", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 23 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:637:6: ( (lv_x23_22_0= ruleAltList2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:637:6: ( (lv_x23_22_0= ruleAltList2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:638:1: (lv_x23_22_0= ruleAltList2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:638:1: (lv_x23_22_0= ruleAltList2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:639:3: lv_x23_22_0= ruleAltList2
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX23AltList2ParserRuleCall_22_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAltList2_in_ruleModel725);
                    lv_x23_22_0=ruleAltList2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x23",
                    	        		lv_x23_22_0, 
                    	        		"AltList2", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 24 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:662:6: ( (lv_x24_23_0= ruleTransientObject ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:662:6: ( (lv_x24_23_0= ruleTransientObject ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:663:1: (lv_x24_23_0= ruleTransientObject )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:663:1: (lv_x24_23_0= ruleTransientObject )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:664:3: lv_x24_23_0= ruleTransientObject
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX24TransientObjectParserRuleCall_23_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTransientObject_in_ruleModel752);
                    lv_x24_23_0=ruleTransientObject();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x24",
                    	        		lv_x24_23_0, 
                    	        		"TransientObject", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 25 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:687:6: ( (lv_x25_24_0= ruleTransientSerializeables1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:687:6: ( (lv_x25_24_0= ruleTransientSerializeables1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:688:1: (lv_x25_24_0= ruleTransientSerializeables1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:688:1: (lv_x25_24_0= ruleTransientSerializeables1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:689:3: lv_x25_24_0= ruleTransientSerializeables1
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX25TransientSerializeables1ParserRuleCall_24_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTransientSerializeables1_in_ruleModel779);
                    lv_x25_24_0=ruleTransientSerializeables1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x25",
                    	        		lv_x25_24_0, 
                    	        		"TransientSerializeables1", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 26 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:712:6: ( (lv_x26_25_0= ruleStaticSimplification ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:712:6: ( (lv_x26_25_0= ruleStaticSimplification ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:713:1: (lv_x26_25_0= ruleStaticSimplification )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:713:1: (lv_x26_25_0= ruleStaticSimplification )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:714:3: lv_x26_25_0= ruleStaticSimplification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX26StaticSimplificationParserRuleCall_25_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleStaticSimplification_in_ruleModel806);
                    lv_x26_25_0=ruleStaticSimplification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x26",
                    	        		lv_x26_25_0, 
                    	        		"StaticSimplification", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 27 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:737:6: ( (lv_x27_26_0= ruleTwoVersion ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:737:6: ( (lv_x27_26_0= ruleTwoVersion ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:738:1: (lv_x27_26_0= ruleTwoVersion )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:738:1: (lv_x27_26_0= ruleTwoVersion )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:739:3: lv_x27_26_0= ruleTwoVersion
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX27TwoVersionParserRuleCall_26_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTwoVersion_in_ruleModel833);
                    lv_x27_26_0=ruleTwoVersion();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x27",
                    	        		lv_x27_26_0, 
                    	        		"TwoVersion", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 28 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:762:6: ( (lv_x28_27_0= ruleHeuristic1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:762:6: ( (lv_x28_27_0= ruleHeuristic1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:763:1: (lv_x28_27_0= ruleHeuristic1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:763:1: (lv_x28_27_0= ruleHeuristic1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:764:3: lv_x28_27_0= ruleHeuristic1
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX28Heuristic1ParserRuleCall_27_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleHeuristic1_in_ruleModel860);
                    lv_x28_27_0=ruleHeuristic1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"x28",
                    	        		lv_x28_27_0, 
                    	        		"Heuristic1", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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


    // $ANTLR start "entryRuleSimpleGroup"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:794:1: entryRuleSimpleGroup returns [EObject current=null] : iv_ruleSimpleGroup= ruleSimpleGroup EOF ;
    public final EObject entryRuleSimpleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleGroup = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:795:2: (iv_ruleSimpleGroup= ruleSimpleGroup EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:796:2: iv_ruleSimpleGroup= ruleSimpleGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleGroupRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleGroup_in_entryRuleSimpleGroup896);
            iv_ruleSimpleGroup=ruleSimpleGroup();

            state._fsp--;

             current =iv_ruleSimpleGroup; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleGroup906); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleGroup"


    // $ANTLR start "ruleSimpleGroup"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:803:1: ruleSimpleGroup returns [EObject current=null] : (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final EObject ruleSimpleGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:808:6: ( (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:809:1: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:809:1: (otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:809:3: otherlv_0= '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleSimpleGroup943); 

                	createLeafNode(otherlv_0, grammarAccess.getSimpleGroupAccess().getNumberSignDigitOneKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:813:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:814:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:814:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:815:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleGroup960); 

            			createLeafNode(lv_val1_1_0, grammarAccess.getSimpleGroupAccess().getVal1IDTerminalRuleCall_1_0(), "val1"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSimpleGroupRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val1",
            	        		lv_val1_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:837:2: ( (lv_val2_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:838:1: (lv_val2_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:838:1: (lv_val2_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:839:3: lv_val2_2_0= RULE_ID
            {
            lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleGroup982); 

            			createLeafNode(lv_val2_2_0, grammarAccess.getSimpleGroupAccess().getVal2IDTerminalRuleCall_2_0(), "val2"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSimpleGroupRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val2",
            	        		lv_val2_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleGroup"


    // $ANTLR start "entryRuleSimpleAlternative"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:869:1: entryRuleSimpleAlternative returns [EObject current=null] : iv_ruleSimpleAlternative= ruleSimpleAlternative EOF ;
    public final EObject entryRuleSimpleAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAlternative = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:870:2: (iv_ruleSimpleAlternative= ruleSimpleAlternative EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:871:2: iv_ruleSimpleAlternative= ruleSimpleAlternative EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleAlternativeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleAlternative_in_entryRuleSimpleAlternative1023);
            iv_ruleSimpleAlternative=ruleSimpleAlternative();

            state._fsp--;

             current =iv_ruleSimpleAlternative; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleAlternative1033); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleAlternative"


    // $ANTLR start "ruleSimpleAlternative"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:878:1: ruleSimpleAlternative returns [EObject current=null] : (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) ;
    public final EObject ruleSimpleAlternative() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token otherlv_3=null;
        Token lv_val2_4_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:883:6: ( (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:884:1: (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:884:1: (otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:884:3: otherlv_0= '#2' ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSimpleAlternative1070); 

                	createLeafNode(otherlv_0, grammarAccess.getSimpleAlternativeAccess().getNumberSignDigitTwoKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:888:1: ( (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            else if ( (LA2_0==14) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:888:2: (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:888:2: (otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:888:4: otherlv_1= 'kw1' ( (lv_val1_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSimpleAlternative1084); 

                        	createLeafNode(otherlv_1, grammarAccess.getSimpleAlternativeAccess().getKw1Keyword_1_0_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:892:1: ( (lv_val1_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:893:1: (lv_val1_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:893:1: (lv_val1_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:894:3: lv_val1_2_0= RULE_ID
                    {
                    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleAlternative1101); 

                    			createLeafNode(lv_val1_2_0, grammarAccess.getSimpleAlternativeAccess().getVal1IDTerminalRuleCall_1_0_1_0(), "val1"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSimpleAlternativeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val1",
                    	        		lv_val1_2_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:917:6: (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:917:6: (otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:917:8: otherlv_3= 'kw2' ( (lv_val2_4_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSimpleAlternative1126); 

                        	createLeafNode(otherlv_3, grammarAccess.getSimpleAlternativeAccess().getKw2Keyword_1_1_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:921:1: ( (lv_val2_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:922:1: (lv_val2_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:922:1: (lv_val2_4_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:923:3: lv_val2_4_0= RULE_ID
                    {
                    lv_val2_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleAlternative1143); 

                    			createLeafNode(lv_val2_4_0, grammarAccess.getSimpleAlternativeAccess().getVal2IDTerminalRuleCall_1_1_1_0(), "val2"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSimpleAlternativeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val2",
                    	        		lv_val2_4_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleAlternative"


    // $ANTLR start "entryRuleSimpleMultiplicities"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:953:1: entryRuleSimpleMultiplicities returns [EObject current=null] : iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF ;
    public final EObject entryRuleSimpleMultiplicities() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleMultiplicities = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:954:2: (iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:955:2: iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleMultiplicitiesRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleMultiplicities_in_entryRuleSimpleMultiplicities1186);
            iv_ruleSimpleMultiplicities=ruleSimpleMultiplicities();

            state._fsp--;

             current =iv_ruleSimpleMultiplicities; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleMultiplicities1196); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleMultiplicities"


    // $ANTLR start "ruleSimpleMultiplicities"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:962:1: ruleSimpleMultiplicities returns [EObject current=null] : (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) ;
    public final EObject ruleSimpleMultiplicities() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;
        Token otherlv_4=null;
        Token lv_val3_5_0=null;
        Token otherlv_6=null;
        Token lv_val4_7_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:967:6: ( (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:968:1: (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:968:1: (otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:968:3: otherlv_0= '#3' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )? otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ otherlv_6= 'kw3' ( (lv_val4_7_0= RULE_ID ) )*
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSimpleMultiplicities1233); 

                	createLeafNode(otherlv_0, grammarAccess.getSimpleMultiplicitiesAccess().getNumberSignDigitThreeKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:972:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:973:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:973:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:974:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1250); 

            			createLeafNode(lv_val1_1_0, grammarAccess.getSimpleMultiplicitiesAccess().getVal1IDTerminalRuleCall_1_0(), "val1"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSimpleMultiplicitiesRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val1",
            	        		lv_val1_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSimpleMultiplicities1267); 

                	createLeafNode(otherlv_2, grammarAccess.getSimpleMultiplicitiesAccess().getKw1Keyword_2(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1000:1: ( (lv_val2_3_0= RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1001:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1001:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1002:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1284); 

                    			createLeafNode(lv_val2_3_0, grammarAccess.getSimpleMultiplicitiesAccess().getVal2IDTerminalRuleCall_3_0(), "val2"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSimpleMultiplicitiesRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val2",
                    	        		lv_val2_3_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSimpleMultiplicities1302); 

                	createLeafNode(otherlv_4, grammarAccess.getSimpleMultiplicitiesAccess().getKw2Keyword_4(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1028:1: ( (lv_val3_5_0= RULE_ID ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1029:1: (lv_val3_5_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1029:1: (lv_val3_5_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1030:3: lv_val3_5_0= RULE_ID
            	    {
            	    lv_val3_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1319); 

            	    			createLeafNode(lv_val3_5_0, grammarAccess.getSimpleMultiplicitiesAccess().getVal3IDTerminalRuleCall_5_0(), "val3"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSimpleMultiplicitiesRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"val3",
            	    	        		lv_val3_5_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

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

            otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSimpleMultiplicities1337); 

                	createLeafNode(otherlv_6, grammarAccess.getSimpleMultiplicitiesAccess().getKw3Keyword_6(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1056:1: ( (lv_val4_7_0= RULE_ID ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1057:1: (lv_val4_7_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1057:1: (lv_val4_7_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1058:3: lv_val4_7_0= RULE_ID
            	    {
            	    lv_val4_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1354); 

            	    			createLeafNode(lv_val4_7_0, grammarAccess.getSimpleMultiplicitiesAccess().getVal4IDTerminalRuleCall_7_0(), "val4"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSimpleMultiplicitiesRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"val4",
            	    	        		lv_val4_7_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleMultiplicities"


    // $ANTLR start "entryRuleGroupMultiplicities"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1088:1: entryRuleGroupMultiplicities returns [EObject current=null] : iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF ;
    public final EObject entryRuleGroupMultiplicities() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupMultiplicities = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1089:2: (iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1090:2: iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGroupMultiplicitiesRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleGroupMultiplicities_in_entryRuleGroupMultiplicities1396);
            iv_ruleGroupMultiplicities=ruleGroupMultiplicities();

            state._fsp--;

             current =iv_ruleGroupMultiplicities; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroupMultiplicities1406); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGroupMultiplicities"


    // $ANTLR start "ruleGroupMultiplicities"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1097:1: ruleGroupMultiplicities returns [EObject current=null] : (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) ;
    public final EObject ruleGroupMultiplicities() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;
        Token lv_val3_4_0=null;
        Token otherlv_5=null;
        Token lv_val4_6_0=null;
        Token lv_val5_7_0=null;
        Token otherlv_8=null;
        Token lv_val6_9_0=null;
        Token lv_val7_10_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1102:6: ( (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1103:1: (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1103:1: (otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1103:3: otherlv_0= '#4' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? otherlv_5= 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ otherlv_8= 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleGroupMultiplicities1443); 

                	createLeafNode(otherlv_0, grammarAccess.getGroupMultiplicitiesAccess().getNumberSignDigitFourKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1107:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1108:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1108:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1109:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1460); 

            			createLeafNode(lv_val1_1_0, grammarAccess.getGroupMultiplicitiesAccess().getVal1IDTerminalRuleCall_1_0(), "val1"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getGroupMultiplicitiesRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val1",
            	        		lv_val1_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleGroupMultiplicities1477); 

                	createLeafNode(otherlv_2, grammarAccess.getGroupMultiplicitiesAccess().getKw1Keyword_2(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1135:1: ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1135:2: ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1135:2: ( (lv_val2_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1136:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1136:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1137:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1495); 

                    			createLeafNode(lv_val2_3_0, grammarAccess.getGroupMultiplicitiesAccess().getVal2IDTerminalRuleCall_3_0_0(), "val2"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getGroupMultiplicitiesRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val2",
                    	        		lv_val2_3_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1159:2: ( (lv_val3_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1160:1: (lv_val3_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1160:1: (lv_val3_4_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1161:3: lv_val3_4_0= RULE_ID
                    {
                    lv_val3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1517); 

                    			createLeafNode(lv_val3_4_0, grammarAccess.getGroupMultiplicitiesAccess().getVal3IDTerminalRuleCall_3_1_0(), "val3"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getGroupMultiplicitiesRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val3",
                    	        		lv_val3_4_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleGroupMultiplicities1536); 

                	createLeafNode(otherlv_5, grammarAccess.getGroupMultiplicitiesAccess().getKw2Keyword_4(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1187:1: ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1187:2: ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1187:2: ( (lv_val4_6_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1188:1: (lv_val4_6_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1188:1: (lv_val4_6_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1189:3: lv_val4_6_0= RULE_ID
            	    {
            	    lv_val4_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1554); 

            	    			createLeafNode(lv_val4_6_0, grammarAccess.getGroupMultiplicitiesAccess().getVal4IDTerminalRuleCall_5_0_0(), "val4"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getGroupMultiplicitiesRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"val4",
            	    	        		lv_val4_6_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1211:2: ( (lv_val5_7_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1212:1: (lv_val5_7_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1212:1: (lv_val5_7_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1213:3: lv_val5_7_0= RULE_ID
            	    {
            	    lv_val5_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1576); 

            	    			createLeafNode(lv_val5_7_0, grammarAccess.getGroupMultiplicitiesAccess().getVal5IDTerminalRuleCall_5_1_0(), "val5"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getGroupMultiplicitiesRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"val5",
            	    	        		lv_val5_7_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


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

            otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleGroupMultiplicities1595); 

                	createLeafNode(otherlv_8, grammarAccess.getGroupMultiplicitiesAccess().getKw3Keyword_6(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1239:1: ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1239:2: ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1239:2: ( (lv_val6_9_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1240:1: (lv_val6_9_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1240:1: (lv_val6_9_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1241:3: lv_val6_9_0= RULE_ID
            	    {
            	    lv_val6_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1613); 

            	    			createLeafNode(lv_val6_9_0, grammarAccess.getGroupMultiplicitiesAccess().getVal6IDTerminalRuleCall_7_0_0(), "val6"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getGroupMultiplicitiesRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"val6",
            	    	        		lv_val6_9_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1263:2: ( (lv_val7_10_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1264:1: (lv_val7_10_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1264:1: (lv_val7_10_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1265:3: lv_val7_10_0= RULE_ID
            	    {
            	    lv_val7_10_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1635); 

            	    			createLeafNode(lv_val7_10_0, grammarAccess.getGroupMultiplicitiesAccess().getVal7IDTerminalRuleCall_7_1_0(), "val7"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getGroupMultiplicitiesRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"val7",
            	    	        		lv_val7_10_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGroupMultiplicities"


    // $ANTLR start "entryRuleAlternativeMultiplicities"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1295:1: entryRuleAlternativeMultiplicities returns [EObject current=null] : iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF ;
    public final EObject entryRuleAlternativeMultiplicities() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternativeMultiplicities = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1296:2: (iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1297:2: iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAlternativeMultiplicitiesRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternativeMultiplicities_in_entryRuleAlternativeMultiplicities1678);
            iv_ruleAlternativeMultiplicities=ruleAlternativeMultiplicities();

            state._fsp--;

             current =iv_ruleAlternativeMultiplicities; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlternativeMultiplicities1688); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlternativeMultiplicities"


    // $ANTLR start "ruleAlternativeMultiplicities"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1304:1: ruleAlternativeMultiplicities returns [EObject current=null] : (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) ;
    public final EObject ruleAlternativeMultiplicities() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val2_1_0=null;
        Token otherlv_2=null;
        Token lv_val3_3_0=null;
        Token otherlv_4=null;
        Token lv_val4_5_0=null;
        Token otherlv_6=null;
        Token lv_val5_7_0=null;
        Token otherlv_8=null;
        Token lv_val6_9_0=null;
        Token otherlv_10=null;
        Token lv_val7_11_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1309:6: ( (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1310:1: (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1310:1: (otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1310:3: otherlv_0= '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? otherlv_4= 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ otherlv_8= 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAlternativeMultiplicities1725); 

                	createLeafNode(otherlv_0, grammarAccess.getAlternativeMultiplicitiesAccess().getNumberSignDigitFiveKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1314:1: ( ( (lv_val2_1_0= RULE_ID ) ) | (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )?
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            else if ( (LA9_0==13) ) {
                alt9=2;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1314:2: ( (lv_val2_1_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1314:2: ( (lv_val2_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1315:1: (lv_val2_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1315:1: (lv_val2_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1316:3: lv_val2_1_0= RULE_ID
                    {
                    lv_val2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1743); 

                    			createLeafNode(lv_val2_1_0, grammarAccess.getAlternativeMultiplicitiesAccess().getVal2IDTerminalRuleCall_1_0_0(), "val2"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAlternativeMultiplicitiesRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val2",
                    	        		lv_val2_1_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1339:6: (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1339:6: (otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1339:8: otherlv_2= 'kw1' ( (lv_val3_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleAlternativeMultiplicities1767); 

                        	createLeafNode(otherlv_2, grammarAccess.getAlternativeMultiplicitiesAccess().getKw1Keyword_1_1_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1343:1: ( (lv_val3_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1344:1: (lv_val3_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1344:1: (lv_val3_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1345:3: lv_val3_3_0= RULE_ID
                    {
                    lv_val3_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1784); 

                    			createLeafNode(lv_val3_3_0, grammarAccess.getAlternativeMultiplicitiesAccess().getVal3IDTerminalRuleCall_1_1_1_0(), "val3"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAlternativeMultiplicitiesRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val3",
                    	        		lv_val3_3_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAlternativeMultiplicities1804); 

                	createLeafNode(otherlv_4, grammarAccess.getAlternativeMultiplicitiesAccess().getKw2Keyword_2(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1371:1: ( ( (lv_val4_5_0= RULE_ID ) ) | (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=3;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID) ) {
                    alt10=1;
                }
                else if ( (LA10_0==16) ) {
                    alt10=2;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1371:2: ( (lv_val4_5_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1371:2: ( (lv_val4_5_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1372:1: (lv_val4_5_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1372:1: (lv_val4_5_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1373:3: lv_val4_5_0= RULE_ID
            	    {
            	    lv_val4_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1822); 

            	    			createLeafNode(lv_val4_5_0, grammarAccess.getAlternativeMultiplicitiesAccess().getVal4IDTerminalRuleCall_3_0_0(), "val4"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getAlternativeMultiplicitiesRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"val4",
            	    	        		lv_val4_5_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1396:6: (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1396:6: (otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1396:8: otherlv_6= 'kw3' ( (lv_val5_7_0= RULE_ID ) )
            	    {
            	    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleAlternativeMultiplicities1846); 

            	        	createLeafNode(otherlv_6, grammarAccess.getAlternativeMultiplicitiesAccess().getKw3Keyword_3_1_0(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1400:1: ( (lv_val5_7_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1401:1: (lv_val5_7_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1401:1: (lv_val5_7_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1402:3: lv_val5_7_0= RULE_ID
            	    {
            	    lv_val5_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1863); 

            	    			createLeafNode(lv_val5_7_0, grammarAccess.getAlternativeMultiplicitiesAccess().getVal5IDTerminalRuleCall_3_1_1_0(), "val5"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getAlternativeMultiplicitiesRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"val5",
            	    	        		lv_val5_7_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAlternativeMultiplicities1883); 

                	createLeafNode(otherlv_8, grammarAccess.getAlternativeMultiplicitiesAccess().getKw4Keyword_4(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1428:1: ( ( (lv_val6_9_0= RULE_ID ) ) | (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID) ) {
                    alt11=1;
                }
                else if ( (LA11_0==20) ) {
                    alt11=2;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1428:2: ( (lv_val6_9_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1428:2: ( (lv_val6_9_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1429:1: (lv_val6_9_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1429:1: (lv_val6_9_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1430:3: lv_val6_9_0= RULE_ID
            	    {
            	    lv_val6_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1901); 

            	    			createLeafNode(lv_val6_9_0, grammarAccess.getAlternativeMultiplicitiesAccess().getVal6IDTerminalRuleCall_5_0_0(), "val6"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getAlternativeMultiplicitiesRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"val6",
            	    	        		lv_val6_9_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1453:6: (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1453:6: (otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1453:8: otherlv_10= 'kw5' ( (lv_val7_11_0= RULE_ID ) )
            	    {
            	    otherlv_10=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAlternativeMultiplicities1925); 

            	        	createLeafNode(otherlv_10, grammarAccess.getAlternativeMultiplicitiesAccess().getKw5Keyword_5_1_0(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1457:1: ( (lv_val7_11_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1458:1: (lv_val7_11_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1458:1: (lv_val7_11_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1459:3: lv_val7_11_0= RULE_ID
            	    {
            	    lv_val7_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1942); 

            	    			createLeafNode(lv_val7_11_0, grammarAccess.getAlternativeMultiplicitiesAccess().getVal7IDTerminalRuleCall_5_1_1_0(), "val7"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getAlternativeMultiplicitiesRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"val7",
            	    	        		lv_val7_11_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlternativeMultiplicities"


    // $ANTLR start "entryRuleAssignedAction"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1489:1: entryRuleAssignedAction returns [EObject current=null] : iv_ruleAssignedAction= ruleAssignedAction EOF ;
    public final EObject entryRuleAssignedAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignedAction = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1490:2: (iv_ruleAssignedAction= ruleAssignedAction EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1491:2: iv_ruleAssignedAction= ruleAssignedAction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignedActionRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignedAction_in_entryRuleAssignedAction1986);
            iv_ruleAssignedAction=ruleAssignedAction();

            state._fsp--;

             current =iv_ruleAssignedAction; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignedAction1996); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignedAction"


    // $ANTLR start "ruleAssignedAction"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1498:1: ruleAssignedAction returns [EObject current=null] : (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ ) ;
    public final EObject ruleAssignedAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val1_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1503:6: ( (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1504:1: (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1504:1: (otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1504:3: otherlv_0= '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAssignedAction2033); 

                	createLeafNode(otherlv_0, grammarAccess.getAssignedActionAccess().getNumberSignDigitSixKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1508:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1509:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1509:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1510:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignedAction2050); 

            			createLeafNode(lv_val1_1_0, grammarAccess.getAssignedActionAccess().getVal1IDTerminalRuleCall_1_0(), "val1"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAssignedActionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val1",
            	        		lv_val1_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1532:2: ( () ( (lv_val1_3_0= RULE_ID ) ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_ID) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1532:3: () ( (lv_val1_3_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1532:3: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1533:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.getAssignedActionAccess().getAssignedActionChildAction_2_0().getType().getClassifier());
            	            try {
            	            	factory.set(temp, "child", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.getAssignedActionAccess().getAssignedActionChildAction_2_0(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1548:2: ( (lv_val1_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1549:1: (lv_val1_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1549:1: (lv_val1_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1550:3: lv_val1_3_0= RULE_ID
            	    {
            	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignedAction2082); 

            	    			createLeafNode(lv_val1_3_0, grammarAccess.getAssignedActionAccess().getVal1IDTerminalRuleCall_2_1_0(), "val1"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getAssignedActionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"val1",
            	    	        		lv_val1_3_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


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


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignedAction"


    // $ANTLR start "entryRuleAssignedActionSecond"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1580:1: entryRuleAssignedActionSecond returns [EObject current=null] : iv_ruleAssignedActionSecond= ruleAssignedActionSecond EOF ;
    public final EObject entryRuleAssignedActionSecond() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignedActionSecond = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1581:2: (iv_ruleAssignedActionSecond= ruleAssignedActionSecond EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1582:2: iv_ruleAssignedActionSecond= ruleAssignedActionSecond EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignedActionSecondRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignedActionSecond_in_entryRuleAssignedActionSecond2125);
            iv_ruleAssignedActionSecond=ruleAssignedActionSecond();

            state._fsp--;

             current =iv_ruleAssignedActionSecond; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignedActionSecond2135); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignedActionSecond"


    // $ANTLR start "ruleAssignedActionSecond"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1589:1: ruleAssignedActionSecond returns [EObject current=null] : (otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) ;
    public final EObject ruleAssignedActionSecond() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1594:6: ( (otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1595:1: (otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1595:1: (otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1595:3: otherlv_0= '#7' ( (lv_val1_1_0= RULE_ID ) ) otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleAssignedActionSecond2172); 

                	createLeafNode(otherlv_0, grammarAccess.getAssignedActionSecondAccess().getNumberSignDigitSevenKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1599:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1600:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1600:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1601:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignedActionSecond2189); 

            			createLeafNode(lv_val1_1_0, grammarAccess.getAssignedActionSecondAccess().getVal1IDTerminalRuleCall_1_0(), "val1"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAssignedActionSecondRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val1",
            	        		lv_val1_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleAssignedActionSecond2206); 

                	createLeafNode(otherlv_2, grammarAccess.getAssignedActionSecondAccess().getKw1Keyword_2(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1627:1: ( (lv_val2_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1628:1: (lv_val2_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1628:1: (lv_val2_3_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1629:3: lv_val2_3_0= RULE_ID
            {
            lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignedActionSecond2223); 

            			createLeafNode(lv_val2_3_0, grammarAccess.getAssignedActionSecondAccess().getVal2IDTerminalRuleCall_3_0(), "val2"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAssignedActionSecondRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val2",
            	        		lv_val2_3_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignedActionSecond"


    // $ANTLR start "entryRuleUnassignedAction1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1659:1: entryRuleUnassignedAction1 returns [EObject current=null] : iv_ruleUnassignedAction1= ruleUnassignedAction1 EOF ;
    public final EObject entryRuleUnassignedAction1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedAction1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1660:2: (iv_ruleUnassignedAction1= ruleUnassignedAction1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1661:2: iv_ruleUnassignedAction1= ruleUnassignedAction1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedAction1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction1_in_entryRuleUnassignedAction12264);
            iv_ruleUnassignedAction1=ruleUnassignedAction1();

            state._fsp--;

             current =iv_ruleUnassignedAction1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedAction12274); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnassignedAction1"


    // $ANTLR start "ruleUnassignedAction1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1668:1: ruleUnassignedAction1 returns [EObject current=null] : ( () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) ;
    public final EObject ruleUnassignedAction1() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1673:6: ( ( () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1674:1: ( () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1674:1: ( () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1674:2: () otherlv_1= '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1674:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1675:5: 
            {
             
                    temp=factory.create(grammarAccess.getUnassignedAction1Access().getUnassignedAction1Action_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getUnassignedAction1Access().getUnassignedAction1Action_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleUnassignedAction12320); 

                	createLeafNode(otherlv_1, grammarAccess.getUnassignedAction1Access().getNumberSignDigitEightKeyword_1(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1689:1: ( (lv_val1_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1690:1: (lv_val1_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1690:1: (lv_val1_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1691:3: lv_val1_2_0= RULE_ID
            {
            lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction12337); 

            			createLeafNode(lv_val1_2_0, grammarAccess.getUnassignedAction1Access().getVal1IDTerminalRuleCall_2_0(), "val1"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUnassignedAction1Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val1",
            	        		lv_val1_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1713:2: ( (lv_val2_3_0= RULE_ID ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1714:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1714:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1715:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction12359); 

                    			createLeafNode(lv_val2_3_0, grammarAccess.getUnassignedAction1Access().getVal2IDTerminalRuleCall_3_0(), "val2"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnassignedAction1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val2",
                    	        		lv_val2_3_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnassignedAction1"


    // $ANTLR start "entryRuleUnassignedAction2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1745:1: entryRuleUnassignedAction2 returns [EObject current=null] : iv_ruleUnassignedAction2= ruleUnassignedAction2 EOF ;
    public final EObject entryRuleUnassignedAction2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedAction2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1746:2: (iv_ruleUnassignedAction2= ruleUnassignedAction2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1747:2: iv_ruleUnassignedAction2= ruleUnassignedAction2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedAction2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction2_in_entryRuleUnassignedAction22401);
            iv_ruleUnassignedAction2=ruleUnassignedAction2();

            state._fsp--;

             current =iv_ruleUnassignedAction2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedAction22411); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnassignedAction2"


    // $ANTLR start "ruleUnassignedAction2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1754:1: ruleUnassignedAction2 returns [EObject current=null] : ( () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) ;
    public final EObject ruleUnassignedAction2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1759:6: ( ( () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1760:1: ( () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1760:1: ( () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1760:2: () otherlv_1= '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1760:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1761:5: 
            {
             
                    temp=factory.create(grammarAccess.getUnassignedAction2Access().getUnassignedAction2SubAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getUnassignedAction2Access().getUnassignedAction2SubAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleUnassignedAction22457); 

                	createLeafNode(otherlv_1, grammarAccess.getUnassignedAction2Access().getNumberSignDigitNineKeyword_1(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1775:1: ( (lv_val1_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1776:1: (lv_val1_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1776:1: (lv_val1_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1777:3: lv_val1_2_0= RULE_ID
            {
            lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction22474); 

            			createLeafNode(lv_val1_2_0, grammarAccess.getUnassignedAction2Access().getVal1IDTerminalRuleCall_2_0(), "val1"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUnassignedAction2Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val1",
            	        		lv_val1_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1799:2: ( (lv_val2_3_0= RULE_ID ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1800:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1800:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1801:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction22496); 

                    			createLeafNode(lv_val2_3_0, grammarAccess.getUnassignedAction2Access().getVal2IDTerminalRuleCall_3_0(), "val2"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnassignedAction2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val2",
                    	        		lv_val2_3_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnassignedAction2"


    // $ANTLR start "entryRuleUnassignedAction3"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1831:1: entryRuleUnassignedAction3 returns [EObject current=null] : iv_ruleUnassignedAction3= ruleUnassignedAction3 EOF ;
    public final EObject entryRuleUnassignedAction3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedAction3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1832:2: (iv_ruleUnassignedAction3= ruleUnassignedAction3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1833:2: iv_ruleUnassignedAction3= ruleUnassignedAction3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedAction3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction3_in_entryRuleUnassignedAction32538);
            iv_ruleUnassignedAction3=ruleUnassignedAction3();

            state._fsp--;

             current =iv_ruleUnassignedAction3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedAction32548); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnassignedAction3"


    // $ANTLR start "ruleUnassignedAction3"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1840:1: ruleUnassignedAction3 returns [EObject current=null] : (otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? ) ;
    public final EObject ruleUnassignedAction3() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_val1_5_0=null;
        Token lv_val2_6_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1845:6: ( (otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1846:1: (otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1846:1: (otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1846:3: otherlv_0= '#10' ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )?
            {
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleUnassignedAction32585); 

                	createLeafNode(otherlv_0, grammarAccess.getUnassignedAction3Access().getNumberSignDigitOneDigitZeroKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1850:1: ( (otherlv_1= 'kw1' () ) | (otherlv_3= 'kw2' () ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==13) ) {
                alt15=1;
            }
            else if ( (LA15_0==14) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1850:2: (otherlv_1= 'kw1' () )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1850:2: (otherlv_1= 'kw1' () )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1850:4: otherlv_1= 'kw1' ()
                    {
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleUnassignedAction32599); 

                        	createLeafNode(otherlv_1, grammarAccess.getUnassignedAction3Access().getKw1Keyword_1_0_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1854:1: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1855:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getUnassignedAction3Access().getUnassignedAction2Sub1Action_1_0_1().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getUnassignedAction3Access().getUnassignedAction2Sub1Action_1_0_1(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1866:6: (otherlv_3= 'kw2' () )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1866:6: (otherlv_3= 'kw2' () )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1866:8: otherlv_3= 'kw2' ()
                    {
                    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleUnassignedAction32628); 

                        	createLeafNode(otherlv_3, grammarAccess.getUnassignedAction3Access().getKw2Keyword_1_1_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1870:1: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1871:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getUnassignedAction3Access().getUnassignedAction2Sub2Action_1_1_1().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getUnassignedAction3Access().getUnassignedAction2Sub2Action_1_1_1(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1881:4: ( (lv_val1_5_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1882:1: (lv_val1_5_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1882:1: (lv_val1_5_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1883:3: lv_val1_5_0= RULE_ID
            {
            lv_val1_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction32656); 

            			createLeafNode(lv_val1_5_0, grammarAccess.getUnassignedAction3Access().getVal1IDTerminalRuleCall_2_0(), "val1"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUnassignedAction3Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val1",
            	        		lv_val1_5_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1905:2: ( (lv_val2_6_0= RULE_ID ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1906:1: (lv_val2_6_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1906:1: (lv_val2_6_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1907:3: lv_val2_6_0= RULE_ID
                    {
                    lv_val2_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction32678); 

                    			createLeafNode(lv_val2_6_0, grammarAccess.getUnassignedAction3Access().getVal2IDTerminalRuleCall_3_0(), "val2"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnassignedAction3Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val2",
                    	        		lv_val2_6_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnassignedAction3"


    // $ANTLR start "entryRuleUnassignedRuleCall1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1937:1: entryRuleUnassignedRuleCall1 returns [EObject current=null] : iv_ruleUnassignedRuleCall1= ruleUnassignedRuleCall1 EOF ;
    public final EObject entryRuleUnassignedRuleCall1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedRuleCall1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1938:2: (iv_ruleUnassignedRuleCall1= ruleUnassignedRuleCall1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1939:2: iv_ruleUnassignedRuleCall1= ruleUnassignedRuleCall1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedRuleCall1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall1_in_entryRuleUnassignedRuleCall12720);
            iv_ruleUnassignedRuleCall1=ruleUnassignedRuleCall1();

            state._fsp--;

             current =iv_ruleUnassignedRuleCall1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedRuleCall12730); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnassignedRuleCall1"


    // $ANTLR start "ruleUnassignedRuleCall1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1946:1: ruleUnassignedRuleCall1 returns [EObject current=null] : (otherlv_0= '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final EObject ruleUnassignedRuleCall1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val2_2_0=null;
        EObject this_UnassignedRuleCall1Sub_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1951:6: ( (otherlv_0= '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1952:1: (otherlv_0= '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1952:1: (otherlv_0= '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1952:3: otherlv_0= '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleUnassignedRuleCall12767); 

                	createLeafNode(otherlv_0, grammarAccess.getUnassignedRuleCall1Access().getNumberSignDigitOneDigitOneKeyword_0(), null);
                
             
                    currentNode=createCompositeNode(grammarAccess.getUnassignedRuleCall1Access().getUnassignedRuleCall1SubParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall1Sub_in_ruleUnassignedRuleCall12789);
            this_UnassignedRuleCall1Sub_1=ruleUnassignedRuleCall1Sub();

            state._fsp--;

             
                    current = this_UnassignedRuleCall1Sub_1; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1965:1: ( (lv_val2_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1966:1: (lv_val2_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1966:1: (lv_val2_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1967:3: lv_val2_2_0= RULE_ID
            {
            lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedRuleCall12805); 

            			createLeafNode(lv_val2_2_0, grammarAccess.getUnassignedRuleCall1Access().getVal2IDTerminalRuleCall_2_0(), "val2"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUnassignedRuleCall1Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val2",
            	        		lv_val2_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnassignedRuleCall1"


    // $ANTLR start "entryRuleUnassignedRuleCall1Sub"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1997:1: entryRuleUnassignedRuleCall1Sub returns [EObject current=null] : iv_ruleUnassignedRuleCall1Sub= ruleUnassignedRuleCall1Sub EOF ;
    public final EObject entryRuleUnassignedRuleCall1Sub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedRuleCall1Sub = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1998:2: (iv_ruleUnassignedRuleCall1Sub= ruleUnassignedRuleCall1Sub EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1999:2: iv_ruleUnassignedRuleCall1Sub= ruleUnassignedRuleCall1Sub EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedRuleCall1SubRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall1Sub_in_entryRuleUnassignedRuleCall1Sub2846);
            iv_ruleUnassignedRuleCall1Sub=ruleUnassignedRuleCall1Sub();

            state._fsp--;

             current =iv_ruleUnassignedRuleCall1Sub; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedRuleCall1Sub2856); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnassignedRuleCall1Sub"


    // $ANTLR start "ruleUnassignedRuleCall1Sub"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2006:1: ruleUnassignedRuleCall1Sub returns [EObject current=null] : ( (lv_val1_0_0= RULE_ID ) ) ;
    public final EObject ruleUnassignedRuleCall1Sub() throws RecognitionException {
        EObject current = null;

        Token lv_val1_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2011:6: ( ( (lv_val1_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2012:1: ( (lv_val1_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2012:1: ( (lv_val1_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2013:1: (lv_val1_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2013:1: (lv_val1_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2014:3: lv_val1_0_0= RULE_ID
            {
            lv_val1_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedRuleCall1Sub2897); 

            			createLeafNode(lv_val1_0_0, grammarAccess.getUnassignedRuleCall1SubAccess().getVal1IDTerminalRuleCall_0(), "val1"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUnassignedRuleCall1SubRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val1",
            	        		lv_val1_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnassignedRuleCall1Sub"


    // $ANTLR start "entryRuleUnassignedRuleCall2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2044:1: entryRuleUnassignedRuleCall2 returns [EObject current=null] : iv_ruleUnassignedRuleCall2= ruleUnassignedRuleCall2 EOF ;
    public final EObject entryRuleUnassignedRuleCall2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedRuleCall2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2045:2: (iv_ruleUnassignedRuleCall2= ruleUnassignedRuleCall2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2046:2: iv_ruleUnassignedRuleCall2= ruleUnassignedRuleCall2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedRuleCall2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall2_in_entryRuleUnassignedRuleCall22937);
            iv_ruleUnassignedRuleCall2=ruleUnassignedRuleCall2();

            state._fsp--;

             current =iv_ruleUnassignedRuleCall2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedRuleCall22947); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnassignedRuleCall2"


    // $ANTLR start "ruleUnassignedRuleCall2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2053:1: ruleUnassignedRuleCall2 returns [EObject current=null] : (otherlv_0= '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final EObject ruleUnassignedRuleCall2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val2_2_0=null;
        EObject this_UnassignedRuleCall2Sub_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2058:6: ( (otherlv_0= '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2059:1: (otherlv_0= '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2059:1: (otherlv_0= '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2059:3: otherlv_0= '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleUnassignedRuleCall22984); 

                	createLeafNode(otherlv_0, grammarAccess.getUnassignedRuleCall2Access().getNumberSignDigitOneDigitTwoKeyword_0(), null);
                
             
                    currentNode=createCompositeNode(grammarAccess.getUnassignedRuleCall2Access().getUnassignedRuleCall2SubParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall2Sub_in_ruleUnassignedRuleCall23006);
            this_UnassignedRuleCall2Sub_1=ruleUnassignedRuleCall2Sub();

            state._fsp--;

             
                    current = this_UnassignedRuleCall2Sub_1; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2072:1: ( (lv_val2_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2073:1: (lv_val2_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2073:1: (lv_val2_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2074:3: lv_val2_2_0= RULE_ID
            {
            lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedRuleCall23022); 

            			createLeafNode(lv_val2_2_0, grammarAccess.getUnassignedRuleCall2Access().getVal2IDTerminalRuleCall_2_0(), "val2"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUnassignedRuleCall2Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val2",
            	        		lv_val2_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnassignedRuleCall2"


    // $ANTLR start "entryRuleUnassignedRuleCall2Sub"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2104:1: entryRuleUnassignedRuleCall2Sub returns [EObject current=null] : iv_ruleUnassignedRuleCall2Sub= ruleUnassignedRuleCall2Sub EOF ;
    public final EObject entryRuleUnassignedRuleCall2Sub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedRuleCall2Sub = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2105:2: (iv_ruleUnassignedRuleCall2Sub= ruleUnassignedRuleCall2Sub EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2106:2: iv_ruleUnassignedRuleCall2Sub= ruleUnassignedRuleCall2Sub EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedRuleCall2SubRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall2Sub_in_entryRuleUnassignedRuleCall2Sub3063);
            iv_ruleUnassignedRuleCall2Sub=ruleUnassignedRuleCall2Sub();

            state._fsp--;

             current =iv_ruleUnassignedRuleCall2Sub; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedRuleCall2Sub3073); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnassignedRuleCall2Sub"


    // $ANTLR start "ruleUnassignedRuleCall2Sub"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2113:1: ruleUnassignedRuleCall2Sub returns [EObject current=null] : () ;
    public final EObject ruleUnassignedRuleCall2Sub() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2118:6: ( () )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2119:1: ()
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2119:1: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2120:5: 
            {
             
                    temp=factory.create(grammarAccess.getUnassignedRuleCall2SubAccess().getUnassignedRuleCall2SubActionAction().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getUnassignedRuleCall2SubAccess().getUnassignedRuleCall2SubActionAction(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnassignedRuleCall2Sub"


    // $ANTLR start "entryRuleCombination1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2138:1: entryRuleCombination1 returns [EObject current=null] : iv_ruleCombination1= ruleCombination1 EOF ;
    public final EObject entryRuleCombination1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombination1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2139:2: (iv_ruleCombination1= ruleCombination1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2140:2: iv_ruleCombination1= ruleCombination1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCombination1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCombination1_in_entryRuleCombination13141);
            iv_ruleCombination1=ruleCombination1();

            state._fsp--;

             current =iv_ruleCombination1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCombination13151); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCombination1"


    // $ANTLR start "ruleCombination1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2147:1: ruleCombination1 returns [EObject current=null] : (otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? ) ;
    public final EObject ruleCombination1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;
        Token otherlv_4=null;
        Token lv_val3_5_0=null;
        Token lv_val4_6_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2152:6: ( (otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2153:1: (otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2153:1: (otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2153:3: otherlv_0= '#13' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )?
            {
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleCombination13188); 

                	createLeafNode(otherlv_0, grammarAccess.getCombination1Access().getNumberSignDigitOneDigitThreeKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2157:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2158:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2158:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2159:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination13205); 

            			createLeafNode(lv_val1_1_0, grammarAccess.getCombination1Access().getVal1IDTerminalRuleCall_1_0(), "val1"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCombination1Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val1",
            	        		lv_val1_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2181:2: (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==13) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2181:4: otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) )
                    {
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleCombination13223); 

                        	createLeafNode(otherlv_2, grammarAccess.getCombination1Access().getKw1Keyword_2_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2185:1: ( (lv_val2_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2186:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2186:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2187:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination13240); 

                    			createLeafNode(lv_val2_3_0, grammarAccess.getCombination1Access().getVal2IDTerminalRuleCall_2_1_0(), "val2"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCombination1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val2",
                    	        		lv_val2_3_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2209:2: ( (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==14) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==RULE_ID) ) {
                        alt17=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2209:3: (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2209:3: (otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2209:5: otherlv_4= 'kw2' ( (lv_val3_5_0= RULE_ID ) )
                            {
                            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCombination13259); 

                                	createLeafNode(otherlv_4, grammarAccess.getCombination1Access().getKw2Keyword_2_2_0_0(), null);
                                
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2213:1: ( (lv_val3_5_0= RULE_ID ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2214:1: (lv_val3_5_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2214:1: (lv_val3_5_0= RULE_ID )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2215:3: lv_val3_5_0= RULE_ID
                            {
                            lv_val3_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination13276); 

                            			createLeafNode(lv_val3_5_0, grammarAccess.getCombination1Access().getVal3IDTerminalRuleCall_2_2_0_1_0(), "val3"); 
                            		

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getCombination1Rule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"val3",
                            	        		lv_val3_5_0, 
                            	        		"ID", 
                            	        		lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2238:6: ( (lv_val4_6_0= RULE_ID ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2238:6: ( (lv_val4_6_0= RULE_ID ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2239:1: (lv_val4_6_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2239:1: (lv_val4_6_0= RULE_ID )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2240:3: lv_val4_6_0= RULE_ID
                            {
                            lv_val4_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination13305); 

                            			createLeafNode(lv_val4_6_0, grammarAccess.getCombination1Access().getVal4IDTerminalRuleCall_2_2_1_0(), "val4"); 
                            		

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getCombination1Rule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"val4",
                            	        		lv_val4_6_0, 
                            	        		"ID", 
                            	        		lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCombination1"


    // $ANTLR start "entryRuleCombination2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2270:1: entryRuleCombination2 returns [EObject current=null] : iv_ruleCombination2= ruleCombination2 EOF ;
    public final EObject entryRuleCombination2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombination2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2271:2: (iv_ruleCombination2= ruleCombination2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2272:2: iv_ruleCombination2= ruleCombination2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCombination2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCombination2_in_entryRuleCombination23349);
            iv_ruleCombination2=ruleCombination2();

            state._fsp--;

             current =iv_ruleCombination2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCombination23359); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCombination2"


    // $ANTLR start "ruleCombination2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2279:1: ruleCombination2 returns [EObject current=null] : (otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) ) ;
    public final EObject ruleCombination2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val2_3_0=null;
        Token lv_val3_4_0=null;
        Token lv_val4_5_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2284:6: ( (otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2285:1: (otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2285:1: (otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2285:3: otherlv_0= '#14' ( (lv_val1_1_0= RULE_ID ) ) ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* )
            {
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCombination23396); 

                	createLeafNode(otherlv_0, grammarAccess.getCombination2Access().getNumberSignDigitOneDigitFourKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2289:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2290:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2290:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2291:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination23413); 

            			createLeafNode(lv_val1_1_0, grammarAccess.getCombination2Access().getVal1IDTerminalRuleCall_1_0(), "val1"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCombination2Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val1",
            	        		lv_val1_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2313:2: ( (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==13) ) {
                alt20=1;
            }
            else if ( (LA20_0==EOF||LA20_0==RULE_ID) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2313:3: (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2313:3: (otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2313:5: otherlv_2= 'kw1' ( (lv_val2_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleCombination23432); 

                        	createLeafNode(otherlv_2, grammarAccess.getCombination2Access().getKw1Keyword_2_0_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2317:1: ( (lv_val2_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2318:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2318:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2319:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination23449); 

                    			createLeafNode(lv_val2_3_0, grammarAccess.getCombination2Access().getVal2IDTerminalRuleCall_2_0_1_0(), "val2"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCombination2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val2",
                    	        		lv_val2_3_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2342:6: ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2342:6: ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==RULE_ID) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2342:7: ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2342:7: ( (lv_val3_4_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2343:1: (lv_val3_4_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2343:1: (lv_val3_4_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2344:3: lv_val3_4_0= RULE_ID
                    	    {
                    	    lv_val3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination23479); 

                    	    			createLeafNode(lv_val3_4_0, grammarAccess.getCombination2Access().getVal3IDTerminalRuleCall_2_1_0_0(), "val3"); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getCombination2Rule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"val3",
                    	    	        		lv_val3_4_0, 
                    	    	        		"ID", 
                    	    	        		lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

                    	    }


                    	    }

                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2366:2: ( (lv_val4_5_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2367:1: (lv_val4_5_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2367:1: (lv_val4_5_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2368:3: lv_val4_5_0= RULE_ID
                    	    {
                    	    lv_val4_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination23501); 

                    	    			createLeafNode(lv_val4_5_0, grammarAccess.getCombination2Access().getVal4IDTerminalRuleCall_2_1_1_0(), "val4"); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getCombination2Rule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"val4",
                    	    	        		lv_val4_5_0, 
                    	    	        		"ID", 
                    	    	        		lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCombination2"


    // $ANTLR start "entryRuleCombination3"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2398:1: entryRuleCombination3 returns [EObject current=null] : iv_ruleCombination3= ruleCombination3 EOF ;
    public final EObject entryRuleCombination3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombination3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2399:2: (iv_ruleCombination3= ruleCombination3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2400:2: iv_ruleCombination3= ruleCombination3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCombination3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCombination3_in_entryRuleCombination33545);
            iv_ruleCombination3=ruleCombination3();

            state._fsp--;

             current =iv_ruleCombination3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCombination33555); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCombination3"


    // $ANTLR start "ruleCombination3"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2407:1: ruleCombination3 returns [EObject current=null] : (otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* ) ;
    public final EObject ruleCombination3() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;
        Token lv_val3_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2412:6: ( (otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2413:1: (otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2413:1: (otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2413:3: otherlv_0= '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )*
            {
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleCombination33592); 

                	createLeafNode(otherlv_0, grammarAccess.getCombination3Access().getNumberSignDigitOneDigitFiveKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2417:1: ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )*
            loop21:
            do {
                int alt21=4;
                switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    alt21=1;
                    }
                    break;
                case RULE_INT:
                    {
                    alt21=2;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt21=3;
                    }
                    break;

                }

                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2417:2: ( (lv_val1_1_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2417:2: ( (lv_val1_1_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2418:1: (lv_val1_1_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2418:1: (lv_val1_1_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2419:3: lv_val1_1_0= RULE_ID
            	    {
            	    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination33610); 

            	    			createLeafNode(lv_val1_1_0, grammarAccess.getCombination3Access().getVal1IDTerminalRuleCall_1_0_0(), "val1"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getCombination3Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"val1",
            	    	        		lv_val1_1_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2442:6: ( (lv_val2_2_0= RULE_INT ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2442:6: ( (lv_val2_2_0= RULE_INT ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2443:1: (lv_val2_2_0= RULE_INT )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2443:1: (lv_val2_2_0= RULE_INT )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2444:3: lv_val2_2_0= RULE_INT
            	    {
            	    lv_val2_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleCombination33638); 

            	    			createLeafNode(lv_val2_2_0, grammarAccess.getCombination3Access().getVal2INTTerminalRuleCall_1_1_0(), "val2"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getCombination3Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"val2",
            	    	        		lv_val2_2_0, 
            	    	        		"INT", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2467:6: ( (lv_val3_3_0= RULE_STRING ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2467:6: ( (lv_val3_3_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2468:1: (lv_val3_3_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2468:1: (lv_val3_3_0= RULE_STRING )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2469:3: lv_val3_3_0= RULE_STRING
            	    {
            	    lv_val3_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCombination33666); 

            	    			createLeafNode(lv_val3_3_0, grammarAccess.getCombination3Access().getVal3STRINGTerminalRuleCall_1_2_0(), "val3"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getCombination3Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"val3",
            	    	        		lv_val3_3_0, 
            	    	        		"STRING", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

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

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCombination3"


    // $ANTLR start "entryRuleCombination4"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2499:1: entryRuleCombination4 returns [EObject current=null] : iv_ruleCombination4= ruleCombination4 EOF ;
    public final EObject entryRuleCombination4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombination4 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2500:2: (iv_ruleCombination4= ruleCombination4 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2501:2: iv_ruleCombination4= ruleCombination4 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCombination4Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCombination4_in_entryRuleCombination43709);
            iv_ruleCombination4=ruleCombination4();

            state._fsp--;

             current =iv_ruleCombination4; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCombination43719); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCombination4"


    // $ANTLR start "ruleCombination4"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2508:1: ruleCombination4 returns [EObject current=null] : (otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ ) ;
    public final EObject ruleCombination4() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;
        Token lv_val3_4_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2513:6: ( (otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2514:1: (otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2514:1: (otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2514:3: otherlv_0= '#16' (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+
            {
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleCombination43756); 

                	createLeafNode(otherlv_0, grammarAccess.getCombination4Access().getNumberSignDigitOneDigitSixKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2518:1: (otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==32) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2518:3: otherlv_1= 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) )
            	    {
            	    otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleCombination43769); 

            	        	createLeafNode(otherlv_1, grammarAccess.getCombination4Access().getGroupKeyword_1_0(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2522:1: ( (lv_val1_2_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2523:1: (lv_val1_2_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2523:1: (lv_val1_2_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2524:3: lv_val1_2_0= RULE_ID
            	    {
            	    lv_val1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination43786); 

            	    			createLeafNode(lv_val1_2_0, grammarAccess.getCombination4Access().getVal1IDTerminalRuleCall_1_1_0(), "val1"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getCombination4Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"val1",
            	    	        		lv_val1_2_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2546:2: ( (lv_val2_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2547:1: (lv_val2_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2547:1: (lv_val2_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2548:3: lv_val2_3_0= RULE_ID
            	    {
            	    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination43808); 

            	    			createLeafNode(lv_val2_3_0, grammarAccess.getCombination4Access().getVal2IDTerminalRuleCall_1_2_0(), "val2"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getCombination4Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"val2",
            	    	        		lv_val2_3_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2570:2: ( (lv_val3_4_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2571:1: (lv_val3_4_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2571:1: (lv_val3_4_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2572:3: lv_val3_4_0= RULE_ID
            	    {
            	    lv_val3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination43830); 

            	    			createLeafNode(lv_val3_4_0, grammarAccess.getCombination4Access().getVal3IDTerminalRuleCall_1_3_0(), "val3"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getCombination4Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"val3",
            	    	        		lv_val3_4_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCombination4"


    // $ANTLR start "entryRuleList1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2602:1: entryRuleList1 returns [EObject current=null] : iv_ruleList1= ruleList1 EOF ;
    public final EObject entryRuleList1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2603:2: (iv_ruleList1= ruleList1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2604:2: iv_ruleList1= ruleList1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getList1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleList1_in_entryRuleList13873);
            iv_ruleList1=ruleList1();

            state._fsp--;

             current =iv_ruleList1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList13883); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleList1"


    // $ANTLR start "ruleList1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2611:1: ruleList1 returns [EObject current=null] : (otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ;
    public final EObject ruleList1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2616:6: ( (otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2617:1: (otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2617:1: (otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2617:3: otherlv_0= '#17' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleList13920); 

                	createLeafNode(otherlv_0, grammarAccess.getList1Access().getNumberSignDigitOneDigitSevenKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2621:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2622:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2622:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2623:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList13937); 

            			createLeafNode(lv_val1_1_0, grammarAccess.getList1Access().getVal1IDTerminalRuleCall_1_0(), "val1"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getList1Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"val1",
            	        		lv_val1_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2645:2: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==34) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2645:4: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleList13955); 

            	        	createLeafNode(otherlv_2, grammarAccess.getList1Access().getCommaKeyword_2_0(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2649:1: ( (lv_val1_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2650:1: (lv_val1_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2650:1: (lv_val1_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2651:3: lv_val1_3_0= RULE_ID
            	    {
            	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList13972); 

            	    			createLeafNode(lv_val1_3_0, grammarAccess.getList1Access().getVal1IDTerminalRuleCall_2_1_0(), "val1"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getList1Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"val1",
            	    	        		lv_val1_3_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleList1"


    // $ANTLR start "entryRuleList2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2681:1: entryRuleList2 returns [EObject current=null] : iv_ruleList2= ruleList2 EOF ;
    public final EObject entryRuleList2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2682:2: (iv_ruleList2= ruleList2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2683:2: iv_ruleList2= ruleList2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getList2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleList2_in_entryRuleList24015);
            iv_ruleList2=ruleList2();

            state._fsp--;

             current =iv_ruleList2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList24025); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleList2"


    // $ANTLR start "ruleList2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2690:1: ruleList2 returns [EObject current=null] : (otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? ) ;
    public final EObject ruleList2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2695:6: ( (otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2696:1: (otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2696:1: (otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2696:3: otherlv_0= '#18' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )?
            {
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleList24062); 

                	createLeafNode(otherlv_0, grammarAccess.getList2Access().getNumberSignDigitOneDigitEightKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2700:1: ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2700:2: ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2700:2: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2701:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2701:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2702:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList24080); 

                    			createLeafNode(lv_val1_1_0, grammarAccess.getList2Access().getVal1IDTerminalRuleCall_1_0_0(), "val1"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getList2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"val1",
                    	        		lv_val1_1_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2724:2: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==34) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2724:4: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleList24098); 

                    	        	createLeafNode(otherlv_2, grammarAccess.getList2Access().getCommaKeyword_1_1_0(), null);
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2728:1: ( (lv_val1_3_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2729:1: (lv_val1_3_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2729:1: (lv_val1_3_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2730:3: lv_val1_3_0= RULE_ID
                    	    {
                    	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList24115); 

                    	    			createLeafNode(lv_val1_3_0, grammarAccess.getList2Access().getVal1IDTerminalRuleCall_1_1_1_0(), "val1"); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getList2Rule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"val1",
                    	    	        		lv_val1_3_0, 
                    	    	        		"ID", 
                    	    	        		lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleList2"


    // $ANTLR start "entryRuleList3"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2760:1: entryRuleList3 returns [EObject current=null] : iv_ruleList3= ruleList3 EOF ;
    public final EObject entryRuleList3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2761:2: (iv_ruleList3= ruleList3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2762:2: iv_ruleList3= ruleList3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getList3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleList3_in_entryRuleList34160);
            iv_ruleList3=ruleList3();

            state._fsp--;

             current =iv_ruleList3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList34170); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleList3"


    // $ANTLR start "ruleList3"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2769:1: ruleList3 returns [EObject current=null] : ( (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) ) ;
    public final EObject ruleList3() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;
        Token otherlv_4=null;
        Token lv_val2_5_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2774:6: ( ( (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2775:1: ( (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2775:1: ( (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==36) ) {
                alt27=1;
            }
            else if ( (LA27_0==16) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2775:2: (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2775:2: (otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2775:4: otherlv_0= '#19' ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
                    {
                    otherlv_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleList34208); 

                        	createLeafNode(otherlv_0, grammarAccess.getList3Access().getNumberSignDigitOneDigitNineKeyword_0_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2779:1: ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2779:2: ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2779:2: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2780:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2780:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2781:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList34226); 

                    			createLeafNode(lv_val1_1_0, grammarAccess.getList3Access().getVal1IDTerminalRuleCall_0_1_0_0(), "val1"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getList3Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"val1",
                    	        		lv_val1_1_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2803:2: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==34) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2803:4: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleList34244); 

                    	        	createLeafNode(otherlv_2, grammarAccess.getList3Access().getCommaKeyword_0_1_1_0(), null);
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2807:1: ( (lv_val1_3_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2808:1: (lv_val1_3_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2808:1: (lv_val1_3_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2809:3: lv_val1_3_0= RULE_ID
                    	    {
                    	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList34261); 

                    	    			createLeafNode(lv_val1_3_0, grammarAccess.getList3Access().getVal1IDTerminalRuleCall_0_1_1_1_0(), "val1"); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getList3Rule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"val1",
                    	    	        		lv_val1_3_0, 
                    	    	        		"ID", 
                    	    	        		lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
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
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2832:6: (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2832:6: (otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2832:8: otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleList34289); 

                        	createLeafNode(otherlv_4, grammarAccess.getList3Access().getKw3Keyword_1_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2836:1: ( (lv_val2_5_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2837:1: (lv_val2_5_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2837:1: (lv_val2_5_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2838:3: lv_val2_5_0= RULE_ID
                    {
                    lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList34306); 

                    			createLeafNode(lv_val2_5_0, grammarAccess.getList3Access().getVal2IDTerminalRuleCall_1_1_0(), "val2"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getList3Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val2",
                    	        		lv_val2_5_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleList3"


    // $ANTLR start "entryRuleList4"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2868:1: entryRuleList4 returns [EObject current=null] : iv_ruleList4= ruleList4 EOF ;
    public final EObject entryRuleList4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList4 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2869:2: (iv_ruleList4= ruleList4 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2870:2: iv_ruleList4= ruleList4 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getList4Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleList4_in_entryRuleList44348);
            iv_ruleList4=ruleList4();

            state._fsp--;

             current =iv_ruleList4; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList44358); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleList4"


    // $ANTLR start "ruleList4"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2877:1: ruleList4 returns [EObject current=null] : (otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) ;
    public final EObject ruleList4() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;
        Token otherlv_4=null;
        Token lv_val2_5_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2882:6: ( (otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2883:1: (otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2883:1: (otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2883:3: otherlv_0= '#20' ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleList44395); 

                	createLeafNode(otherlv_0, grammarAccess.getList4Access().getNumberSignDigitTwoDigitZeroKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2887:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2888:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2888:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2889:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList44412); 

            			createLeafNode(lv_val1_1_0, grammarAccess.getList4Access().getVal1IDTerminalRuleCall_1_0(), "val1"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getList4Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"val1",
            	        		lv_val1_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2911:2: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==34) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2911:4: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleList44430); 

            	        	createLeafNode(otherlv_2, grammarAccess.getList4Access().getCommaKeyword_2_0(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2915:1: ( (lv_val1_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2916:1: (lv_val1_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2916:1: (lv_val1_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2917:3: lv_val1_3_0= RULE_ID
            	    {
            	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList44447); 

            	    			createLeafNode(lv_val1_3_0, grammarAccess.getList4Access().getVal1IDTerminalRuleCall_2_1_0(), "val1"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getList4Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"val1",
            	    	        		lv_val1_3_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleList44466); 

                	createLeafNode(otherlv_4, grammarAccess.getList4Access().getKw3Keyword_3(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2943:1: ( (lv_val2_5_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2944:1: (lv_val2_5_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2944:1: (lv_val2_5_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2945:3: lv_val2_5_0= RULE_ID
            {
            lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList44483); 

            			createLeafNode(lv_val2_5_0, grammarAccess.getList4Access().getVal2IDTerminalRuleCall_4_0(), "val2"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getList4Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val2",
            	        		lv_val2_5_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleList4"


    // $ANTLR start "entryRuleList5"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2975:1: entryRuleList5 returns [EObject current=null] : iv_ruleList5= ruleList5 EOF ;
    public final EObject entryRuleList5() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList5 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2976:2: (iv_ruleList5= ruleList5 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2977:2: iv_ruleList5= ruleList5 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getList5Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleList5_in_entryRuleList54524);
            iv_ruleList5=ruleList5();

            state._fsp--;

             current =iv_ruleList5; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList54534); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleList5"


    // $ANTLR start "ruleList5"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2984:1: ruleList5 returns [EObject current=null] : (otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) ) ;
    public final EObject ruleList5() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token otherlv_2=null;
        Token lv_val1_3_0=null;
        Token otherlv_4=null;
        Token lv_val2_5_0=null;
        Token lv_val3_6_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2989:6: ( (otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2990:1: (otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2990:1: (otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2990:3: otherlv_0= '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) )
            {
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleList54571); 

                	createLeafNode(otherlv_0, grammarAccess.getList5Access().getNumberSignDigitTwoDigitOneKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2994:1: ( ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID) ) {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==EOF) ) {
                    alt30=2;
                }
                else if ( (LA30_1==16||LA30_1==34) ) {
                    alt30=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2994:2: ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2994:2: ( ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2994:3: ( (lv_val1_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )* otherlv_4= 'kw3' ( (lv_val2_5_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2994:3: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2995:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2995:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2996:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList54590); 

                    			createLeafNode(lv_val1_1_0, grammarAccess.getList5Access().getVal1IDTerminalRuleCall_1_0_0_0(), "val1"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getList5Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"val1",
                    	        		lv_val1_1_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3018:2: (otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==34) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3018:4: otherlv_2= ',' ( (lv_val1_3_0= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleList54608); 

                    	        	createLeafNode(otherlv_2, grammarAccess.getList5Access().getCommaKeyword_1_0_1_0(), null);
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3022:1: ( (lv_val1_3_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3023:1: (lv_val1_3_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3023:1: (lv_val1_3_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3024:3: lv_val1_3_0= RULE_ID
                    	    {
                    	    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList54625); 

                    	    			createLeafNode(lv_val1_3_0, grammarAccess.getList5Access().getVal1IDTerminalRuleCall_1_0_1_1_0(), "val1"); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getList5Rule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"val1",
                    	    	        		lv_val1_3_0, 
                    	    	        		"ID", 
                    	    	        		lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleList54644); 

                        	createLeafNode(otherlv_4, grammarAccess.getList5Access().getKw3Keyword_1_0_2(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3050:1: ( (lv_val2_5_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3051:1: (lv_val2_5_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3051:1: (lv_val2_5_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3052:3: lv_val2_5_0= RULE_ID
                    {
                    lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList54661); 

                    			createLeafNode(lv_val2_5_0, grammarAccess.getList5Access().getVal2IDTerminalRuleCall_1_0_3_0(), "val2"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getList5Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val2",
                    	        		lv_val2_5_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3075:6: ( (lv_val3_6_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3075:6: ( (lv_val3_6_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3076:1: (lv_val3_6_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3076:1: (lv_val3_6_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3077:3: lv_val3_6_0= RULE_ID
                    {
                    lv_val3_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList54690); 

                    			createLeafNode(lv_val3_6_0, grammarAccess.getList5Access().getVal3IDTerminalRuleCall_1_1_0(), "val3"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getList5Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val3",
                    	        		lv_val3_6_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleList5"


    // $ANTLR start "entryRuleAltList1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3107:1: entryRuleAltList1 returns [EObject current=null] : iv_ruleAltList1= ruleAltList1 EOF ;
    public final EObject entryRuleAltList1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAltList1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3108:2: (iv_ruleAltList1= ruleAltList1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3109:2: iv_ruleAltList1= ruleAltList1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAltList1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAltList1_in_entryRuleAltList14732);
            iv_ruleAltList1=ruleAltList1();

            state._fsp--;

             current =iv_ruleAltList1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAltList14742); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAltList1"


    // $ANTLR start "ruleAltList1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3116:1: ruleAltList1 returns [EObject current=null] : (otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) ;
    public final EObject ruleAltList1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;
        Token otherlv_3=null;
        Token lv_val1_4_0=null;
        Token lv_val3_5_0=null;
        Token otherlv_6=null;
        Token lv_val1_7_0=null;
        Token lv_val4_8_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3121:6: ( (otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3122:1: (otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3122:1: (otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3122:3: otherlv_0= '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
            {
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleAltList14779); 

                	createLeafNode(otherlv_0, grammarAccess.getAltList1Access().getNumberSignDigitTwoDigitTwoKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3126:1: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
            int alt32=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt32=1;
                }
                break;
            case 13:
                {
                alt32=2;
                }
                break;
            case 14:
                {
                alt32=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3126:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3126:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3126:3: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3126:3: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3127:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3127:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3128:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList14798); 

                    			createLeafNode(lv_val1_1_0, grammarAccess.getAltList1Access().getVal1IDTerminalRuleCall_1_0_0_0(), "val1"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAltList1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val1",
                    	        		lv_val1_1_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3150:2: ( (lv_val2_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3151:1: (lv_val2_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3151:1: (lv_val2_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3152:3: lv_val2_2_0= RULE_ID
                    {
                    lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList14820); 

                    			createLeafNode(lv_val2_2_0, grammarAccess.getAltList1Access().getVal2IDTerminalRuleCall_1_0_1_0(), "val2"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAltList1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val2",
                    	        		lv_val2_2_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3175:6: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3175:6: (otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3175:8: otherlv_3= 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleAltList14845); 

                        	createLeafNode(otherlv_3, grammarAccess.getAltList1Access().getKw1Keyword_1_1_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3179:1: ( (lv_val1_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3180:1: (lv_val1_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3180:1: (lv_val1_4_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3181:3: lv_val1_4_0= RULE_ID
                    {
                    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList14862); 

                    			createLeafNode(lv_val1_4_0, grammarAccess.getAltList1Access().getVal1IDTerminalRuleCall_1_1_1_0(), "val1"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAltList1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val1",
                    	        		lv_val1_4_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3203:2: ( (lv_val3_5_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3204:1: (lv_val3_5_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3204:1: (lv_val3_5_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3205:3: lv_val3_5_0= RULE_ID
                    {
                    lv_val3_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList14884); 

                    			createLeafNode(lv_val3_5_0, grammarAccess.getAltList1Access().getVal3IDTerminalRuleCall_1_1_2_0(), "val3"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAltList1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val3",
                    	        		lv_val3_5_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3228:6: (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3228:6: (otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3228:8: otherlv_6= 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )?
                    {
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAltList14909); 

                        	createLeafNode(otherlv_6, grammarAccess.getAltList1Access().getKw2Keyword_1_2_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3232:1: ( (lv_val1_7_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3233:1: (lv_val1_7_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3233:1: (lv_val1_7_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3234:3: lv_val1_7_0= RULE_ID
                    {
                    lv_val1_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList14926); 

                    			createLeafNode(lv_val1_7_0, grammarAccess.getAltList1Access().getVal1IDTerminalRuleCall_1_2_1_0(), "val1"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAltList1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val1",
                    	        		lv_val1_7_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3256:2: ( (lv_val4_8_0= RULE_ID ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==RULE_ID) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3257:1: (lv_val4_8_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3257:1: (lv_val4_8_0= RULE_ID )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3258:3: lv_val4_8_0= RULE_ID
                            {
                            lv_val4_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList14948); 

                            			createLeafNode(lv_val4_8_0, grammarAccess.getAltList1Access().getVal4IDTerminalRuleCall_1_2_2_0(), "val4"); 
                            		

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getAltList1Rule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"val4",
                            	        		lv_val4_8_0, 
                            	        		"ID", 
                            	        		lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
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


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAltList1"


    // $ANTLR start "entryRuleAltList2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3288:1: entryRuleAltList2 returns [EObject current=null] : iv_ruleAltList2= ruleAltList2 EOF ;
    public final EObject entryRuleAltList2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAltList2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3289:2: (iv_ruleAltList2= ruleAltList2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3290:2: iv_ruleAltList2= ruleAltList2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAltList2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAltList2_in_entryRuleAltList24992);
            iv_ruleAltList2=ruleAltList2();

            state._fsp--;

             current =iv_ruleAltList2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAltList25002); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAltList2"


    // $ANTLR start "ruleAltList2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3297:1: ruleAltList2 returns [EObject current=null] : (otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) ;
    public final EObject ruleAltList2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;
        Token otherlv_3=null;
        Token lv_val1_4_0=null;
        Token otherlv_5=null;
        Token lv_val1_6_0=null;
        Token lv_val3_7_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3302:6: ( (otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3303:1: (otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3303:1: (otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3303:3: otherlv_0= '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
            {
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleAltList25039); 

                	createLeafNode(otherlv_0, grammarAccess.getAltList2Access().getNumberSignDigitTwoDigitThreeKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3307:1: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_ID) ) {
                alt34=1;
            }
            else if ( (LA34_0==41) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3307:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3307:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3307:3: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3307:3: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3308:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3308:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3309:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList25058); 

                    			createLeafNode(lv_val1_1_0, grammarAccess.getAltList2Access().getVal1IDTerminalRuleCall_1_0_0_0(), "val1"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAltList2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"val1",
                    	        		lv_val1_1_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3331:2: ( (lv_val2_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3332:1: (lv_val2_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3332:1: (lv_val2_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3333:3: lv_val2_2_0= RULE_ID
                    {
                    lv_val2_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList25080); 

                    			createLeafNode(lv_val2_2_0, grammarAccess.getAltList2Access().getVal2IDTerminalRuleCall_1_0_1_0(), "val2"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAltList2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val2",
                    	        		lv_val2_2_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3356:6: (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3356:6: (otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3356:8: otherlv_3= 'kw' ( (lv_val1_4_0= RULE_ID ) ) (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleAltList25105); 

                        	createLeafNode(otherlv_3, grammarAccess.getAltList2Access().getKwKeyword_1_1_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3360:1: ( (lv_val1_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3361:1: (lv_val1_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3361:1: (lv_val1_4_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3362:3: lv_val1_4_0= RULE_ID
                    {
                    lv_val1_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList25122); 

                    			createLeafNode(lv_val1_4_0, grammarAccess.getAltList2Access().getVal1IDTerminalRuleCall_1_1_1_0(), "val1"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAltList2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"val1",
                    	        		lv_val1_4_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3384:2: (otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==34) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3384:4: otherlv_5= ',' ( (lv_val1_6_0= RULE_ID ) )
                    	    {
                    	    otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAltList25140); 

                    	        	createLeafNode(otherlv_5, grammarAccess.getAltList2Access().getCommaKeyword_1_1_2_0(), null);
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3388:1: ( (lv_val1_6_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3389:1: (lv_val1_6_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3389:1: (lv_val1_6_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3390:3: lv_val1_6_0= RULE_ID
                    	    {
                    	    lv_val1_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList25157); 

                    	    			createLeafNode(lv_val1_6_0, grammarAccess.getAltList2Access().getVal1IDTerminalRuleCall_1_1_2_1_0(), "val1"); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getAltList2Rule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"val1",
                    	    	        		lv_val1_6_0, 
                    	    	        		"ID", 
                    	    	        		lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3412:4: ( (lv_val3_7_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3413:1: (lv_val3_7_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3413:1: (lv_val3_7_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3414:3: lv_val3_7_0= RULE_ID
                    {
                    lv_val3_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList25181); 

                    			createLeafNode(lv_val3_7_0, grammarAccess.getAltList2Access().getVal3IDTerminalRuleCall_1_1_3_0(), "val3"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getAltList2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val3",
                    	        		lv_val3_7_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAltList2"


    // $ANTLR start "entryRuleTransientObject"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3444:1: entryRuleTransientObject returns [EObject current=null] : iv_ruleTransientObject= ruleTransientObject EOF ;
    public final EObject entryRuleTransientObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransientObject = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3445:2: (iv_ruleTransientObject= ruleTransientObject EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3446:2: iv_ruleTransientObject= ruleTransientObject EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransientObjectRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTransientObject_in_entryRuleTransientObject5224);
            iv_ruleTransientObject=ruleTransientObject();

            state._fsp--;

             current =iv_ruleTransientObject; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransientObject5234); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransientObject"


    // $ANTLR start "ruleTransientObject"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3453:1: ruleTransientObject returns [EObject current=null] : (otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? ) ;
    public final EObject ruleTransientObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        EObject lv_nested_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3458:6: ( (otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3459:1: (otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3459:1: (otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3459:3: otherlv_0= '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )?
            {
            otherlv_0=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleTransientObject5271); 

                	createLeafNode(otherlv_0, grammarAccess.getTransientObjectAccess().getNumberSignDigitTwoDigitFourKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3463:1: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3463:2: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3463:2: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3464:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3464:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3465:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransientObject5289); 

                    			createLeafNode(lv_val1_1_0, grammarAccess.getTransientObjectAccess().getVal1IDTerminalRuleCall_1_0_0(), "val1"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTransientObjectRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val1",
                    	        		lv_val1_1_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3487:2: ( (lv_nested_2_0= ruleTransientObjectSub ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3488:1: (lv_nested_2_0= ruleTransientObjectSub )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3488:1: (lv_nested_2_0= ruleTransientObjectSub )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3489:3: lv_nested_2_0= ruleTransientObjectSub
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTransientObjectAccess().getNestedTransientObjectSubParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTransientObjectSub_in_ruleTransientObject5315);
                    lv_nested_2_0=ruleTransientObjectSub();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTransientObjectRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"nested",
                    	        		lv_nested_2_0, 
                    	        		"TransientObjectSub", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransientObject"


    // $ANTLR start "entryRuleTransientObjectSub"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3519:1: entryRuleTransientObjectSub returns [EObject current=null] : iv_ruleTransientObjectSub= ruleTransientObjectSub EOF ;
    public final EObject entryRuleTransientObjectSub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransientObjectSub = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3520:2: (iv_ruleTransientObjectSub= ruleTransientObjectSub EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3521:2: iv_ruleTransientObjectSub= ruleTransientObjectSub EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransientObjectSubRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTransientObjectSub_in_entryRuleTransientObjectSub5353);
            iv_ruleTransientObjectSub=ruleTransientObjectSub();

            state._fsp--;

             current =iv_ruleTransientObjectSub; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransientObjectSub5363); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransientObjectSub"


    // $ANTLR start "ruleTransientObjectSub"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3528:1: ruleTransientObjectSub returns [EObject current=null] : ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) ) ;
    public final EObject ruleTransientObjectSub() throws RecognitionException {
        EObject current = null;

        Token lv_val2_0_0=null;
        Token lv_val3_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3533:6: ( ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3534:1: ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3534:1: ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3534:2: ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3534:2: ( (lv_val2_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3535:1: (lv_val2_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3535:1: (lv_val2_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3536:3: lv_val2_0_0= RULE_ID
            {
            lv_val2_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransientObjectSub5405); 

            			createLeafNode(lv_val2_0_0, grammarAccess.getTransientObjectSubAccess().getVal2IDTerminalRuleCall_0_0(), "val2"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTransientObjectSubRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val2",
            	        		lv_val2_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3558:2: ( (lv_val3_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3559:1: (lv_val3_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3559:1: (lv_val3_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3560:3: lv_val3_1_0= RULE_ID
            {
            lv_val3_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransientObjectSub5427); 

            			createLeafNode(lv_val3_1_0, grammarAccess.getTransientObjectSubAccess().getVal3IDTerminalRuleCall_1_0(), "val3"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTransientObjectSubRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val3",
            	        		lv_val3_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransientObjectSub"


    // $ANTLR start "entryRuleTransientSerializeables1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3590:1: entryRuleTransientSerializeables1 returns [EObject current=null] : iv_ruleTransientSerializeables1= ruleTransientSerializeables1 EOF ;
    public final EObject entryRuleTransientSerializeables1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransientSerializeables1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3591:2: (iv_ruleTransientSerializeables1= ruleTransientSerializeables1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3592:2: iv_ruleTransientSerializeables1= ruleTransientSerializeables1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransientSerializeables1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTransientSerializeables1_in_entryRuleTransientSerializeables15468);
            iv_ruleTransientSerializeables1=ruleTransientSerializeables1();

            state._fsp--;

             current =iv_ruleTransientSerializeables1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransientSerializeables15478); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransientSerializeables1"


    // $ANTLR start "ruleTransientSerializeables1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3599:1: ruleTransientSerializeables1 returns [EObject current=null] : (otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? ) ;
    public final EObject ruleTransientSerializeables1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_val1_1_0=null;
        Token lv_val2_3_0=null;
        Token lv_int1_4_0=null;
        Enumerator lv_enum1_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3604:6: ( (otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3605:1: (otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3605:1: (otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3605:3: otherlv_0= '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )?
            {
            otherlv_0=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleTransientSerializeables15515); 

                	createLeafNode(otherlv_0, grammarAccess.getTransientSerializeables1Access().getNumberSignDigitTwoDigitFiveKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3609:1: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID) ) {
                int LA36_1 = input.LA(2);

                if ( ((LA36_1>=52 && LA36_1<=53)) ) {
                    alt36=1;
                }
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3609:2: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3609:2: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3610:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3610:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3611:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransientSerializeables15533); 

                    			createLeafNode(lv_val1_1_0, grammarAccess.getTransientSerializeables1Access().getVal1IDTerminalRuleCall_1_0_0(), "val1"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTransientSerializeables1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val1",
                    	        		lv_val1_1_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3633:2: ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3634:1: (lv_enum1_2_0= ruleTransientSerializeables1Enum )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3634:1: (lv_enum1_2_0= ruleTransientSerializeables1Enum )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3635:3: lv_enum1_2_0= ruleTransientSerializeables1Enum
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTransientSerializeables1Access().getEnum1TransientSerializeables1EnumEnumRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTransientSerializeables1Enum_in_ruleTransientSerializeables15559);
                    lv_enum1_2_0=ruleTransientSerializeables1Enum();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTransientSerializeables1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"enum1",
                    	        		lv_enum1_2_0, 
                    	        		"TransientSerializeables1Enum", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3657:4: ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3657:5: ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3657:5: ( (lv_val2_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3658:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3658:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3659:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransientSerializeables15579); 

                    			createLeafNode(lv_val2_3_0, grammarAccess.getTransientSerializeables1Access().getVal2IDTerminalRuleCall_2_0_0(), "val2"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTransientSerializeables1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val2",
                    	        		lv_val2_3_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3681:2: ( (lv_int1_4_0= RULE_INT ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3682:1: (lv_int1_4_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3682:1: (lv_int1_4_0= RULE_INT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3683:3: lv_int1_4_0= RULE_INT
                    {
                    lv_int1_4_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTransientSerializeables15601); 

                    			createLeafNode(lv_int1_4_0, grammarAccess.getTransientSerializeables1Access().getInt1INTTerminalRuleCall_2_1_0(), "int1"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTransientSerializeables1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"int1",
                    	        		lv_int1_4_0, 
                    	        		"INT", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransientSerializeables1"


    // $ANTLR start "entryRuleStaticSimplification"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3713:1: entryRuleStaticSimplification returns [EObject current=null] : iv_ruleStaticSimplification= ruleStaticSimplification EOF ;
    public final EObject entryRuleStaticSimplification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStaticSimplification = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3714:2: (iv_ruleStaticSimplification= ruleStaticSimplification EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3715:2: iv_ruleStaticSimplification= ruleStaticSimplification EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStaticSimplificationRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleStaticSimplification_in_entryRuleStaticSimplification5644);
            iv_ruleStaticSimplification=ruleStaticSimplification();

            state._fsp--;

             current =iv_ruleStaticSimplification; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStaticSimplification5654); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStaticSimplification"


    // $ANTLR start "ruleStaticSimplification"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3722:1: ruleStaticSimplification returns [EObject current=null] : (otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) ) ;
    public final EObject ruleStaticSimplification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_val1_3_0=null;
        Token otherlv_4=null;
        Token lv_val2_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_val3_8_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3727:6: ( (otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3728:1: (otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3728:1: (otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3728:3: otherlv_0= '#26' (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? )
            {
            otherlv_0=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleStaticSimplification5691); 

                	createLeafNode(otherlv_0, grammarAccess.getStaticSimplificationAccess().getNumberSignDigitTwoDigitSixKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3732:1: (otherlv_1= 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) )
            int alt38=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt38=1;
                }
                break;
            case 14:
                {
                alt38=2;
                }
                break;
            case RULE_ID:
                {
                int LA38_3 = input.LA(2);

                if ( (LA38_3==RULE_ID||LA38_3==14) ) {
                    alt38=3;
                }
                else if ( (LA38_3==16) ) {
                    alt38=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3732:3: otherlv_1= 'kw1'
                    {
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleStaticSimplification5704); 

                        	createLeafNode(otherlv_1, grammarAccess.getStaticSimplificationAccess().getKw1Keyword_1_0(), null);
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3737:6: ()
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3737:6: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3738:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getStaticSimplificationAccess().getEmptyAlternativeSubAction_1_1().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getStaticSimplificationAccess().getEmptyAlternativeSubAction_1_1(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3749:6: ( (lv_val1_3_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3749:6: ( (lv_val1_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3750:1: (lv_val1_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3750:1: (lv_val1_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3751:3: lv_val1_3_0= RULE_ID
                    {
                    lv_val1_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleStaticSimplification5742); 

                    			createLeafNode(lv_val1_3_0, grammarAccess.getStaticSimplificationAccess().getVal1IDTerminalRuleCall_1_2_0(), "val1"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStaticSimplificationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val1",
                    	        		lv_val1_3_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3773:3: (otherlv_4= 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==14) ) {
                alt39=1;
            }
            else if ( (LA39_0==RULE_ID) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3773:5: otherlv_4= 'kw2'
                    {
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleStaticSimplification5761); 

                        	createLeafNode(otherlv_4, grammarAccess.getStaticSimplificationAccess().getKw2Keyword_2_0(), null);
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3778:6: ( (lv_val2_5_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3778:6: ( (lv_val2_5_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3779:1: (lv_val2_5_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3779:1: (lv_val2_5_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3780:3: lv_val2_5_0= RULE_ID
                    {
                    lv_val2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleStaticSimplification5784); 

                    			createLeafNode(lv_val2_5_0, grammarAccess.getStaticSimplificationAccess().getVal2IDTerminalRuleCall_2_1_0(), "val2"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStaticSimplificationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val2",
                    	        		lv_val2_5_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3802:3: (otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3802:5: otherlv_6= 'kw3' (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )?
            {
            otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleStaticSimplification5803); 

                	createLeafNode(otherlv_6, grammarAccess.getStaticSimplificationAccess().getKw3Keyword_3_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3806:1: (otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==19) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3806:3: otherlv_7= 'kw4' ( (lv_val3_8_0= RULE_ID ) )+
                    {
                    otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleStaticSimplification5816); 

                        	createLeafNode(otherlv_7, grammarAccess.getStaticSimplificationAccess().getKw4Keyword_3_1_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3810:1: ( (lv_val3_8_0= RULE_ID ) )+
                    int cnt40=0;
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==RULE_ID) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3811:1: (lv_val3_8_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3811:1: (lv_val3_8_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3812:3: lv_val3_8_0= RULE_ID
                    	    {
                    	    lv_val3_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleStaticSimplification5833); 

                    	    			createLeafNode(lv_val3_8_0, grammarAccess.getStaticSimplificationAccess().getVal3IDTerminalRuleCall_3_1_1_0(), "val3"); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getStaticSimplificationRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        try {
                    	    	       		set(
                    	    	       			current, 
                    	    	       			"val3",
                    	    	        		lv_val3_8_0, 
                    	    	        		"ID", 
                    	    	        		lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt40 >= 1 ) break loop40;
                                EarlyExitException eee =
                                    new EarlyExitException(40, input);
                                throw eee;
                        }
                        cnt40++;
                    } while (true);


                    }
                    break;

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStaticSimplification"


    // $ANTLR start "entryRuleTwoVersion"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3842:1: entryRuleTwoVersion returns [EObject current=null] : iv_ruleTwoVersion= ruleTwoVersion EOF ;
    public final EObject entryRuleTwoVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoVersion = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3843:2: (iv_ruleTwoVersion= ruleTwoVersion EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3844:2: iv_ruleTwoVersion= ruleTwoVersion EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTwoVersionRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTwoVersion_in_entryRuleTwoVersion5878);
            iv_ruleTwoVersion=ruleTwoVersion();

            state._fsp--;

             current =iv_ruleTwoVersion; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTwoVersion5888); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTwoVersion"


    // $ANTLR start "ruleTwoVersion"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3851:1: ruleTwoVersion returns [EObject current=null] : (otherlv_0= '#27' (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 ) ) ;
    public final EObject ruleTwoVersion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_TwoVersionNo1_1 = null;

        EObject this_TwoVersionNo2_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3856:6: ( (otherlv_0= '#27' (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3857:1: (otherlv_0= '#27' (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3857:1: (otherlv_0= '#27' (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3857:3: otherlv_0= '#27' (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 )
            {
            otherlv_0=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleTwoVersion5925); 

                	createLeafNode(otherlv_0, grammarAccess.getTwoVersionAccess().getNumberSignDigitTwoDigitSevenKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3861:1: (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 46:
                    {
                    alt42=1;
                    }
                    break;
                case RULE_ID:
                    {
                    int LA42_3 = input.LA(3);

                    if ( (LA42_3==46) ) {
                        alt42=1;
                    }
                    else if ( (LA42_3==48) ) {
                        alt42=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 42, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 48:
                    {
                    alt42=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3862:5: this_TwoVersionNo1_1= ruleTwoVersionNo1
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTwoVersionAccess().getTwoVersionNo1ParserRuleCall_1_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTwoVersionNo1_in_ruleTwoVersion5948);
                    this_TwoVersionNo1_1=ruleTwoVersionNo1();

                    state._fsp--;

                     
                            current = this_TwoVersionNo1_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3872:5: this_TwoVersionNo2_2= ruleTwoVersionNo2
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTwoVersionAccess().getTwoVersionNo2ParserRuleCall_1_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTwoVersionNo2_in_ruleTwoVersion5975);
                    this_TwoVersionNo2_2=ruleTwoVersionNo2();

                    state._fsp--;

                     
                            current = this_TwoVersionNo2_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTwoVersion"


    // $ANTLR start "entryRuleTwoVersionNo1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3888:1: entryRuleTwoVersionNo1 returns [EObject current=null] : iv_ruleTwoVersionNo1= ruleTwoVersionNo1 EOF ;
    public final EObject entryRuleTwoVersionNo1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoVersionNo1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3889:2: (iv_ruleTwoVersionNo1= ruleTwoVersionNo1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3890:2: iv_ruleTwoVersionNo1= ruleTwoVersionNo1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTwoVersionNo1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTwoVersionNo1_in_entryRuleTwoVersionNo16011);
            iv_ruleTwoVersionNo1=ruleTwoVersionNo1();

            state._fsp--;

             current =iv_ruleTwoVersionNo1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTwoVersionNo16021); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTwoVersionNo1"


    // $ANTLR start "ruleTwoVersionNo1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3897:1: ruleTwoVersionNo1 returns [EObject current=null] : ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )? ) ;
    public final EObject ruleTwoVersionNo1() throws RecognitionException {
        EObject current = null;

        Token lv_shared1_0_0=null;
        Token lv_shared2_1_0=null;
        Token otherlv_2=null;
        Token lv_shared3_3_0=null;
        Token lv_shared3_4_0=null;
        Token otherlv_5=null;
        Token lv_version1_6_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3902:6: ( ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3903:1: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3903:1: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3903:2: ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'one' ( (lv_version1_6_0= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3903:2: ( (lv_shared1_0_0= RULE_ID ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_ID) ) {
                int LA43_1 = input.LA(2);

                if ( (LA43_1==RULE_ID) ) {
                    alt43=1;
                }
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3904:1: (lv_shared1_0_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3904:1: (lv_shared1_0_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3905:3: lv_shared1_0_0= RULE_ID
                    {
                    lv_shared1_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo16063); 

                    			createLeafNode(lv_shared1_0_0, grammarAccess.getTwoVersionNo1Access().getShared1IDTerminalRuleCall_0_0(), "shared1"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTwoVersionNo1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"shared1",
                    	        		lv_shared1_0_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3927:3: ( (lv_shared2_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3928:1: (lv_shared2_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3928:1: (lv_shared2_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3929:3: lv_shared2_1_0= RULE_ID
            {
            lv_shared2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo16086); 

            			createLeafNode(lv_shared2_1_0, grammarAccess.getTwoVersionNo1Access().getShared2IDTerminalRuleCall_1_0(), "shared2"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTwoVersionNo1Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"shared2",
            	        		lv_shared2_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            otherlv_2=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleTwoVersionNo16103); 

                	createLeafNode(otherlv_2, grammarAccess.getTwoVersionNo1Access().getShortKeyword_2(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3955:1: ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3955:2: ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3955:2: ( (lv_shared3_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3956:1: (lv_shared3_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3956:1: (lv_shared3_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3957:3: lv_shared3_3_0= RULE_ID
                    {
                    lv_shared3_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo16121); 

                    			createLeafNode(lv_shared3_3_0, grammarAccess.getTwoVersionNo1Access().getShared3IDTerminalRuleCall_3_0_0(), "shared3"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTwoVersionNo1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"shared3",
                    	        		lv_shared3_3_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3979:2: ( (lv_shared3_4_0= RULE_ID ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==RULE_ID) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3980:1: (lv_shared3_4_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3980:1: (lv_shared3_4_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3981:3: lv_shared3_4_0= RULE_ID
                    	    {
                    	    lv_shared3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo16143); 

                    	    			createLeafNode(lv_shared3_4_0, grammarAccess.getTwoVersionNo1Access().getShared3IDTerminalRuleCall_3_1_0(), "shared3"); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getTwoVersionNo1Rule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"shared3",
                    	    	        		lv_shared3_4_0, 
                    	    	        		"ID", 
                    	    	        		lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleTwoVersionNo16163); 

                	createLeafNode(otherlv_5, grammarAccess.getTwoVersionNo1Access().getOneKeyword_4(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4007:1: ( (lv_version1_6_0= RULE_ID ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ID) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4008:1: (lv_version1_6_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4008:1: (lv_version1_6_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4009:3: lv_version1_6_0= RULE_ID
                    {
                    lv_version1_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo16180); 

                    			createLeafNode(lv_version1_6_0, grammarAccess.getTwoVersionNo1Access().getVersion1IDTerminalRuleCall_5_0(), "version1"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTwoVersionNo1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"version1",
                    	        		lv_version1_6_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTwoVersionNo1"


    // $ANTLR start "entryRuleTwoVersionNo2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4039:1: entryRuleTwoVersionNo2 returns [EObject current=null] : iv_ruleTwoVersionNo2= ruleTwoVersionNo2 EOF ;
    public final EObject entryRuleTwoVersionNo2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoVersionNo2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4040:2: (iv_ruleTwoVersionNo2= ruleTwoVersionNo2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4041:2: iv_ruleTwoVersionNo2= ruleTwoVersionNo2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTwoVersionNo2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTwoVersionNo2_in_entryRuleTwoVersionNo26222);
            iv_ruleTwoVersionNo2=ruleTwoVersionNo2();

            state._fsp--;

             current =iv_ruleTwoVersionNo2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTwoVersionNo26232); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTwoVersionNo2"


    // $ANTLR start "ruleTwoVersionNo2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4048:1: ruleTwoVersionNo2 returns [EObject current=null] : ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? ) ;
    public final EObject ruleTwoVersionNo2() throws RecognitionException {
        EObject current = null;

        Token lv_shared1_0_0=null;
        Token lv_shared2_1_0=null;
        Token otherlv_2=null;
        Token lv_shared3_3_0=null;
        Token lv_shared3_4_0=null;
        Token otherlv_5=null;
        Token lv_extra1_6_0=null;
        Token lv_extra2_7_0=null;
        Token lv_extra3_8_0=null;
        Token otherlv_9=null;
        Token lv_extra4_10_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4053:6: ( ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4054:1: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4054:1: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4054:2: ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) otherlv_2= 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? otherlv_5= 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4054:2: ( (lv_shared1_0_0= RULE_ID ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_ID) ) {
                int LA47_1 = input.LA(2);

                if ( (LA47_1==RULE_ID) ) {
                    alt47=1;
                }
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4055:1: (lv_shared1_0_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4055:1: (lv_shared1_0_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4056:3: lv_shared1_0_0= RULE_ID
                    {
                    lv_shared1_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo26274); 

                    			createLeafNode(lv_shared1_0_0, grammarAccess.getTwoVersionNo2Access().getShared1IDTerminalRuleCall_0_0(), "shared1"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTwoVersionNo2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"shared1",
                    	        		lv_shared1_0_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4078:3: ( (lv_shared2_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4079:1: (lv_shared2_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4079:1: (lv_shared2_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4080:3: lv_shared2_1_0= RULE_ID
            {
            lv_shared2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo26297); 

            			createLeafNode(lv_shared2_1_0, grammarAccess.getTwoVersionNo2Access().getShared2IDTerminalRuleCall_1_0(), "shared2"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTwoVersionNo2Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"shared2",
            	        		lv_shared2_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            otherlv_2=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleTwoVersionNo26314); 

                	createLeafNode(otherlv_2, grammarAccess.getTwoVersionNo2Access().getLongKeyword_2(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4106:1: ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_ID) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4106:2: ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4106:2: ( (lv_shared3_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4107:1: (lv_shared3_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4107:1: (lv_shared3_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4108:3: lv_shared3_3_0= RULE_ID
                    {
                    lv_shared3_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo26332); 

                    			createLeafNode(lv_shared3_3_0, grammarAccess.getTwoVersionNo2Access().getShared3IDTerminalRuleCall_3_0_0(), "shared3"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTwoVersionNo2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"shared3",
                    	        		lv_shared3_3_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4130:2: ( (lv_shared3_4_0= RULE_ID ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==RULE_ID) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4131:1: (lv_shared3_4_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4131:1: (lv_shared3_4_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4132:3: lv_shared3_4_0= RULE_ID
                    	    {
                    	    lv_shared3_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo26354); 

                    	    			createLeafNode(lv_shared3_4_0, grammarAccess.getTwoVersionNo2Access().getShared3IDTerminalRuleCall_3_1_0(), "shared3"); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getTwoVersionNo2Rule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"shared3",
                    	    	        		lv_shared3_4_0, 
                    	    	        		"ID", 
                    	    	        		lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleTwoVersionNo26374); 

                	createLeafNode(otherlv_5, grammarAccess.getTwoVersionNo2Access().getExtraKeyword_4(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4158:1: ( (lv_extra1_6_0= RULE_ID ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_ID) ) {
                int LA50_1 = input.LA(2);

                if ( (LA50_1==RULE_ID) ) {
                    int LA50_3 = input.LA(3);

                    if ( (LA50_3==RULE_ID) ) {
                        alt50=1;
                    }
                }
                else if ( (LA50_1==EOF||LA50_1==50) ) {
                    alt50=1;
                }
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4159:1: (lv_extra1_6_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4159:1: (lv_extra1_6_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4160:3: lv_extra1_6_0= RULE_ID
                    {
                    lv_extra1_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo26391); 

                    			createLeafNode(lv_extra1_6_0, grammarAccess.getTwoVersionNo2Access().getExtra1IDTerminalRuleCall_5_0(), "extra1"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTwoVersionNo2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"extra1",
                    	        		lv_extra1_6_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4182:3: ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )?
            int alt51=3;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_ID) ) {
                alt51=1;
            }
            else if ( (LA51_0==50) ) {
                alt51=2;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4182:4: ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4182:4: ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4182:5: ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4182:5: ( (lv_extra2_7_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4183:1: (lv_extra2_7_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4183:1: (lv_extra2_7_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4184:3: lv_extra2_7_0= RULE_ID
                    {
                    lv_extra2_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo26416); 

                    			createLeafNode(lv_extra2_7_0, grammarAccess.getTwoVersionNo2Access().getExtra2IDTerminalRuleCall_6_0_0_0(), "extra2"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTwoVersionNo2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"extra2",
                    	        		lv_extra2_7_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4206:2: ( (lv_extra3_8_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4207:1: (lv_extra3_8_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4207:1: (lv_extra3_8_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4208:3: lv_extra3_8_0= RULE_ID
                    {
                    lv_extra3_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo26438); 

                    			createLeafNode(lv_extra3_8_0, grammarAccess.getTwoVersionNo2Access().getExtra3IDTerminalRuleCall_6_0_1_0(), "extra3"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTwoVersionNo2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"extra3",
                    	        		lv_extra3_8_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4231:6: (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4231:6: (otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4231:8: otherlv_9= 'two' ( (lv_extra4_10_0= RULE_ID ) )
                    {
                    otherlv_9=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleTwoVersionNo26463); 

                        	createLeafNode(otherlv_9, grammarAccess.getTwoVersionNo2Access().getTwoKeyword_6_1_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4235:1: ( (lv_extra4_10_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4236:1: (lv_extra4_10_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4236:1: (lv_extra4_10_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4237:3: lv_extra4_10_0= RULE_ID
                    {
                    lv_extra4_10_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo26480); 

                    			createLeafNode(lv_extra4_10_0, grammarAccess.getTwoVersionNo2Access().getExtra4IDTerminalRuleCall_6_1_1_0(), "extra4"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTwoVersionNo2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"extra4",
                    	        		lv_extra4_10_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTwoVersionNo2"


    // $ANTLR start "entryRuleHeuristic1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4267:1: entryRuleHeuristic1 returns [EObject current=null] : iv_ruleHeuristic1= ruleHeuristic1 EOF ;
    public final EObject entryRuleHeuristic1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHeuristic1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4268:2: (iv_ruleHeuristic1= ruleHeuristic1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4269:2: iv_ruleHeuristic1= ruleHeuristic1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getHeuristic1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleHeuristic1_in_entryRuleHeuristic16524);
            iv_ruleHeuristic1=ruleHeuristic1();

            state._fsp--;

             current =iv_ruleHeuristic1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleHeuristic16534); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHeuristic1"


    // $ANTLR start "ruleHeuristic1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4276:1: ruleHeuristic1 returns [EObject current=null] : (otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* ) ;
    public final EObject ruleHeuristic1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_a_2_0=null;
        Token lv_b_3_0=null;
        Token otherlv_4=null;
        Token lv_a_5_0=null;
        Token lv_c_6_0=null;
        Token otherlv_7=null;
        Token lv_b_8_0=null;
        Token lv_c_9_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4281:6: ( (otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4282:1: (otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4282:1: (otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4282:3: otherlv_0= '#28' (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleHeuristic16571); 

                	createLeafNode(otherlv_0, grammarAccess.getHeuristic1Access().getNumberSignDigitTwoDigitEightKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4286:1: (otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==13) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4286:3: otherlv_1= 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) )
            	    {
            	    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleHeuristic16584); 

            	        	createLeafNode(otherlv_1, grammarAccess.getHeuristic1Access().getKw1Keyword_1_0(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4290:1: ( (lv_a_2_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4291:1: (lv_a_2_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4291:1: (lv_a_2_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4292:3: lv_a_2_0= RULE_ID
            	    {
            	    lv_a_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleHeuristic16601); 

            	    			createLeafNode(lv_a_2_0, grammarAccess.getHeuristic1Access().getAIDTerminalRuleCall_1_1_0(), "a"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getHeuristic1Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"a",
            	    	        		lv_a_2_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4314:2: ( (lv_b_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4315:1: (lv_b_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4315:1: (lv_b_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4316:3: lv_b_3_0= RULE_ID
            	    {
            	    lv_b_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleHeuristic16623); 

            	    			createLeafNode(lv_b_3_0, grammarAccess.getHeuristic1Access().getBIDTerminalRuleCall_1_2_0(), "b"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getHeuristic1Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"b",
            	    	        		lv_b_3_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4338:4: (otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==14) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4338:6: otherlv_4= 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) )
            	    {
            	    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleHeuristic16643); 

            	        	createLeafNode(otherlv_4, grammarAccess.getHeuristic1Access().getKw2Keyword_2_0(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4342:1: ( (lv_a_5_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4343:1: (lv_a_5_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4343:1: (lv_a_5_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4344:3: lv_a_5_0= RULE_ID
            	    {
            	    lv_a_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleHeuristic16660); 

            	    			createLeafNode(lv_a_5_0, grammarAccess.getHeuristic1Access().getAIDTerminalRuleCall_2_1_0(), "a"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getHeuristic1Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"a",
            	    	        		lv_a_5_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4366:2: ( (lv_c_6_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4367:1: (lv_c_6_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4367:1: (lv_c_6_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4368:3: lv_c_6_0= RULE_ID
            	    {
            	    lv_c_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleHeuristic16682); 

            	    			createLeafNode(lv_c_6_0, grammarAccess.getHeuristic1Access().getCIDTerminalRuleCall_2_2_0(), "c"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getHeuristic1Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"c",
            	    	        		lv_c_6_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4390:4: (otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==16) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4390:6: otherlv_7= 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) )
            	    {
            	    otherlv_7=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleHeuristic16702); 

            	        	createLeafNode(otherlv_7, grammarAccess.getHeuristic1Access().getKw3Keyword_3_0(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4394:1: ( (lv_b_8_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4395:1: (lv_b_8_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4395:1: (lv_b_8_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4396:3: lv_b_8_0= RULE_ID
            	    {
            	    lv_b_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleHeuristic16719); 

            	    			createLeafNode(lv_b_8_0, grammarAccess.getHeuristic1Access().getBIDTerminalRuleCall_3_1_0(), "b"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getHeuristic1Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"b",
            	    	        		lv_b_8_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4418:2: ( (lv_c_9_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4419:1: (lv_c_9_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4419:1: (lv_c_9_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4420:3: lv_c_9_0= RULE_ID
            	    {
            	    lv_c_9_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleHeuristic16741); 

            	    			createLeafNode(lv_c_9_0, grammarAccess.getHeuristic1Access().getCIDTerminalRuleCall_3_2_0(), "c"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getHeuristic1Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"c",
            	    	        		lv_c_9_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHeuristic1"


    // $ANTLR start "ruleTransientSerializeables1Enum"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4450:1: ruleTransientSerializeables1Enum returns [Enumerator current=null] : ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) ) ;
    public final Enumerator ruleTransientSerializeables1Enum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4454:6: ( ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4455:1: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4455:1: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==52) ) {
                alt55=1;
            }
            else if ( (LA55_0==53) ) {
                alt55=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4455:2: (enumLiteral_0= 'lit1' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4455:2: (enumLiteral_0= 'lit1' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4455:4: enumLiteral_0= 'lit1'
                    {
                    enumLiteral_0=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleTransientSerializeables1Enum6798); 

                            current = grammarAccess.getTransientSerializeables1EnumAccess().getLit1EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(enumLiteral_0, grammarAccess.getTransientSerializeables1EnumAccess().getLit1EnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4461:6: (enumLiteral_1= 'lit2' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4461:6: (enumLiteral_1= 'lit2' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4461:8: enumLiteral_1= 'lit2'
                    {
                    enumLiteral_1=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleTransientSerializeables1Enum6815); 

                            current = grammarAccess.getTransientSerializeables1EnumAccess().getLit2EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(enumLiteral_1, grammarAccess.getTransientSerializeables1EnumAccess().getLit2EnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransientSerializeables1Enum"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleGroup_in_ruleModel131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleAlternative_in_ruleModel158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleMultiplicities_in_ruleModel185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroupMultiplicities_in_ruleModel212 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternativeMultiplicities_in_ruleModel239 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignedAction_in_ruleModel266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignedActionSecond_in_ruleModel293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedAction1_in_ruleModel320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedAction2_in_ruleModel347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedAction3_in_ruleModel374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall1_in_ruleModel401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall2_in_ruleModel428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCombination1_in_ruleModel455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCombination2_in_ruleModel482 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCombination3_in_ruleModel509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCombination4_in_ruleModel536 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleList1_in_ruleModel563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleList2_in_ruleModel590 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleList3_in_ruleModel617 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleList4_in_ruleModel644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleList5_in_ruleModel671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAltList1_in_ruleModel698 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAltList2_in_ruleModel725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransientObject_in_ruleModel752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransientSerializeables1_in_ruleModel779 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStaticSimplification_in_ruleModel806 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoVersion_in_ruleModel833 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHeuristic1_in_ruleModel860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleGroup_in_entryRuleSimpleGroup896 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleGroup906 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleSimpleGroup943 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleGroup960 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleGroup982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleAlternative_in_entryRuleSimpleAlternative1023 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleAlternative1033 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleSimpleAlternative1070 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_13_in_ruleSimpleAlternative1084 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAlternative1101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleSimpleAlternative1126 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAlternative1143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleMultiplicities_in_entryRuleSimpleMultiplicities1186 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleMultiplicities1196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleSimpleMultiplicities1233 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1250 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleSimpleMultiplicities1267 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1284 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleSimpleMultiplicities1302 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1319 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_16_in_ruleSimpleMultiplicities1337 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1354 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleGroupMultiplicities_in_entryRuleGroupMultiplicities1396 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroupMultiplicities1406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleGroupMultiplicities1443 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1460 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleGroupMultiplicities1477 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1495 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1517 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleGroupMultiplicities1536 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1554 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1576 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_16_in_ruleGroupMultiplicities1595 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1613 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1635 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleAlternativeMultiplicities_in_entryRuleAlternativeMultiplicities1678 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlternativeMultiplicities1688 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleAlternativeMultiplicities1725 = new BitSet(new long[]{0x0000000000006010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1743 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_13_in_ruleAlternativeMultiplicities1767 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1784 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleAlternativeMultiplicities1804 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1822 = new BitSet(new long[]{0x0000000000090010L});
        public static final BitSet FOLLOW_16_in_ruleAlternativeMultiplicities1846 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1863 = new BitSet(new long[]{0x0000000000090010L});
        public static final BitSet FOLLOW_19_in_ruleAlternativeMultiplicities1883 = new BitSet(new long[]{0x0000000000100012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1901 = new BitSet(new long[]{0x0000000000100012L});
        public static final BitSet FOLLOW_20_in_ruleAlternativeMultiplicities1925 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1942 = new BitSet(new long[]{0x0000000000100012L});
        public static final BitSet FOLLOW_ruleAssignedAction_in_entryRuleAssignedAction1986 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignedAction1996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleAssignedAction2033 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignedAction2050 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignedAction2082 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleAssignedActionSecond_in_entryRuleAssignedActionSecond2125 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignedActionSecond2135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleAssignedActionSecond2172 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignedActionSecond2189 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleAssignedActionSecond2206 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignedActionSecond2223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedAction1_in_entryRuleUnassignedAction12264 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedAction12274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleUnassignedAction12320 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction12337 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction12359 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedAction2_in_entryRuleUnassignedAction22401 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedAction22411 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleUnassignedAction22457 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction22474 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction22496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedAction3_in_entryRuleUnassignedAction32538 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedAction32548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleUnassignedAction32585 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_13_in_ruleUnassignedAction32599 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_14_in_ruleUnassignedAction32628 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction32656 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction32678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall1_in_entryRuleUnassignedRuleCall12720 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedRuleCall12730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleUnassignedRuleCall12767 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall1Sub_in_ruleUnassignedRuleCall12789 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedRuleCall12805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall1Sub_in_entryRuleUnassignedRuleCall1Sub2846 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedRuleCall1Sub2856 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedRuleCall1Sub2897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall2_in_entryRuleUnassignedRuleCall22937 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedRuleCall22947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleUnassignedRuleCall22984 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall2Sub_in_ruleUnassignedRuleCall23006 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedRuleCall23022 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall2Sub_in_entryRuleUnassignedRuleCall2Sub3063 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedRuleCall2Sub3073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCombination1_in_entryRuleCombination13141 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCombination13151 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleCombination13188 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination13205 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleCombination13223 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination13240 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_14_in_ruleCombination13259 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination13276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination13305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCombination2_in_entryRuleCombination23349 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCombination23359 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleCombination23396 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination23413 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_13_in_ruleCombination23432 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination23449 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination23479 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination23501 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleCombination3_in_entryRuleCombination33545 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCombination33555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleCombination33592 = new BitSet(new long[]{0x0000000000000072L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination33610 = new BitSet(new long[]{0x0000000000000072L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleCombination33638 = new BitSet(new long[]{0x0000000000000072L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCombination33666 = new BitSet(new long[]{0x0000000000000072L});
        public static final BitSet FOLLOW_ruleCombination4_in_entryRuleCombination43709 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCombination43719 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleCombination43756 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleCombination43769 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination43786 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination43808 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination43830 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_ruleList1_in_entryRuleList13873 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList13883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleList13920 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList13937 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_ruleList13955 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList13972 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_ruleList2_in_entryRuleList24015 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList24025 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleList24062 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList24080 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_ruleList24098 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList24115 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_ruleList3_in_entryRuleList34160 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList34170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleList34208 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList34226 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_ruleList34244 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList34261 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_16_in_ruleList34289 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList34306 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleList4_in_entryRuleList44348 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList44358 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleList44395 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList44412 = new BitSet(new long[]{0x0000000400010000L});
        public static final BitSet FOLLOW_34_in_ruleList44430 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList44447 = new BitSet(new long[]{0x0000000400010000L});
        public static final BitSet FOLLOW_16_in_ruleList44466 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList44483 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleList5_in_entryRuleList54524 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList54534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleList54571 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList54590 = new BitSet(new long[]{0x0000000400010000L});
        public static final BitSet FOLLOW_34_in_ruleList54608 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList54625 = new BitSet(new long[]{0x0000000400010000L});
        public static final BitSet FOLLOW_16_in_ruleList54644 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList54661 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList54690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAltList1_in_entryRuleAltList14732 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAltList14742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleAltList14779 = new BitSet(new long[]{0x0000000000006010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList14798 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList14820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleAltList14845 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList14862 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList14884 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleAltList14909 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList14926 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList14948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAltList2_in_entryRuleAltList24992 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAltList25002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleAltList25039 = new BitSet(new long[]{0x0000020000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList25058 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList25080 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleAltList25105 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList25122 = new BitSet(new long[]{0x0000000400000010L});
        public static final BitSet FOLLOW_34_in_ruleAltList25140 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList25157 = new BitSet(new long[]{0x0000000400000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList25181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransientObject_in_entryRuleTransientObject5224 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransientObject5234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleTransientObject5271 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransientObject5289 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTransientObjectSub_in_ruleTransientObject5315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransientObjectSub_in_entryRuleTransientObjectSub5353 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransientObjectSub5363 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransientObjectSub5405 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransientObjectSub5427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransientSerializeables1_in_entryRuleTransientSerializeables15468 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransientSerializeables15478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleTransientSerializeables15515 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransientSerializeables15533 = new BitSet(new long[]{0x0030000000000000L});
        public static final BitSet FOLLOW_ruleTransientSerializeables1Enum_in_ruleTransientSerializeables15559 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransientSerializeables15579 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTransientSerializeables15601 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStaticSimplification_in_entryRuleStaticSimplification5644 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStaticSimplification5654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleStaticSimplification5691 = new BitSet(new long[]{0x0000000000006010L});
        public static final BitSet FOLLOW_13_in_ruleStaticSimplification5704 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleStaticSimplification5742 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_14_in_ruleStaticSimplification5761 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleStaticSimplification5784 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleStaticSimplification5803 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleStaticSimplification5816 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleStaticSimplification5833 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleTwoVersion_in_entryRuleTwoVersion5878 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTwoVersion5888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleTwoVersion5925 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTwoVersionNo1_in_ruleTwoVersion5948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoVersionNo2_in_ruleTwoVersion5975 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoVersionNo1_in_entryRuleTwoVersionNo16011 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTwoVersionNo16021 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo16063 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo16086 = new BitSet(new long[]{0x0000400000000000L});
        public static final BitSet FOLLOW_46_in_ruleTwoVersionNo16103 = new BitSet(new long[]{0x0000800000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo16121 = new BitSet(new long[]{0x0000800000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo16143 = new BitSet(new long[]{0x0000800000000010L});
        public static final BitSet FOLLOW_47_in_ruleTwoVersionNo16163 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo16180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoVersionNo2_in_entryRuleTwoVersionNo26222 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTwoVersionNo26232 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo26274 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo26297 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleTwoVersionNo26314 = new BitSet(new long[]{0x0002000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo26332 = new BitSet(new long[]{0x0002000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo26354 = new BitSet(new long[]{0x0002000000000010L});
        public static final BitSet FOLLOW_49_in_ruleTwoVersionNo26374 = new BitSet(new long[]{0x0004000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo26391 = new BitSet(new long[]{0x0004000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo26416 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo26438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleTwoVersionNo26463 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo26480 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHeuristic1_in_entryRuleHeuristic16524 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleHeuristic16534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleHeuristic16571 = new BitSet(new long[]{0x0000000000016002L});
        public static final BitSet FOLLOW_13_in_ruleHeuristic16584 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleHeuristic16601 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleHeuristic16623 = new BitSet(new long[]{0x0000000000016002L});
        public static final BitSet FOLLOW_14_in_ruleHeuristic16643 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleHeuristic16660 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleHeuristic16682 = new BitSet(new long[]{0x0000000000014002L});
        public static final BitSet FOLLOW_16_in_ruleHeuristic16702 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleHeuristic16719 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleHeuristic16741 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_52_in_ruleTransientSerializeables1Enum6798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleTransientSerializeables1Enum6815 = new BitSet(new long[]{0x0000000000000002L});
    }


}