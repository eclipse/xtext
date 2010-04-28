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

public class InternalConcreteSyntaxValidationTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'#2'", "'kw1'", "'kw2'", "'#3'", "'kw3'", "'#4'", "'#5'", "'kw4'", "'kw5'", "'#6'", "'#7'", "'#8'", "'#9'", "'#10'", "'#11'", "'#12'", "'#13'", "'#14'", "'#15'", "'#16'", "'group'", "'#17'", "','", "'#18'", "'#19'", "'#20'", "'#21'", "'#22'", "'#23'", "'kw'", "'#24'", "'#25'", "'#26'", "'#27'", "'short'", "'one'", "'long'", "'extra'", "'two'", "'#28'", "'lit1'", "'lit2'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalConcreteSyntaxValidationTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g"; }



     	private ConcreteSyntaxValidationTestLanguageGrammarAccess grammarAccess;
     	
        public InternalConcreteSyntaxValidationTestLanguageParser(TokenStream input, IAstFactory factory, ConcreteSyntaxValidationTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected ConcreteSyntaxValidationTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:78:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:79:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:80:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();
            _fsp--;

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:87:1: ruleModel returns [EObject current=null] : ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) ) ;
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


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:92:6: ( ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:93:1: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:93:1: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) )
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
                    new NoViableAltException("93:1: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) | ( (lv_x26_25_0= ruleStaticSimplification ) ) | ( (lv_x27_26_0= ruleTwoVersion ) ) | ( (lv_x28_27_0= ruleHeuristic1 ) ) )", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:93:2: ( (lv_x1_0_0= ruleSimpleGroup ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:93:2: ( (lv_x1_0_0= ruleSimpleGroup ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:94:1: (lv_x1_0_0= ruleSimpleGroup )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:94:1: (lv_x1_0_0= ruleSimpleGroup )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:95:3: lv_x1_0_0= ruleSimpleGroup
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX1SimpleGroupParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleGroup_in_ruleModel131);
                    lv_x1_0_0=ruleSimpleGroup();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:118:6: ( (lv_x2_1_0= ruleSimpleAlternative ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:118:6: ( (lv_x2_1_0= ruleSimpleAlternative ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:119:1: (lv_x2_1_0= ruleSimpleAlternative )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:119:1: (lv_x2_1_0= ruleSimpleAlternative )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:120:3: lv_x2_1_0= ruleSimpleAlternative
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX2SimpleAlternativeParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleAlternative_in_ruleModel158);
                    lv_x2_1_0=ruleSimpleAlternative();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:143:6: ( (lv_x3_2_0= ruleSimpleMultiplicities ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:143:6: ( (lv_x3_2_0= ruleSimpleMultiplicities ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:144:1: (lv_x3_2_0= ruleSimpleMultiplicities )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:144:1: (lv_x3_2_0= ruleSimpleMultiplicities )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:145:3: lv_x3_2_0= ruleSimpleMultiplicities
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX3SimpleMultiplicitiesParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleMultiplicities_in_ruleModel185);
                    lv_x3_2_0=ruleSimpleMultiplicities();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:168:6: ( (lv_x4_3_0= ruleGroupMultiplicities ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:168:6: ( (lv_x4_3_0= ruleGroupMultiplicities ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:169:1: (lv_x4_3_0= ruleGroupMultiplicities )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:169:1: (lv_x4_3_0= ruleGroupMultiplicities )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:170:3: lv_x4_3_0= ruleGroupMultiplicities
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX4GroupMultiplicitiesParserRuleCall_3_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleGroupMultiplicities_in_ruleModel212);
                    lv_x4_3_0=ruleGroupMultiplicities();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:193:6: ( (lv_x5_4_0= ruleAlternativeMultiplicities ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:193:6: ( (lv_x5_4_0= ruleAlternativeMultiplicities ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:194:1: (lv_x5_4_0= ruleAlternativeMultiplicities )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:194:1: (lv_x5_4_0= ruleAlternativeMultiplicities )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:195:3: lv_x5_4_0= ruleAlternativeMultiplicities
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX5AlternativeMultiplicitiesParserRuleCall_4_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAlternativeMultiplicities_in_ruleModel239);
                    lv_x5_4_0=ruleAlternativeMultiplicities();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:218:6: ( (lv_x6_5_0= ruleAssignedAction ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:218:6: ( (lv_x6_5_0= ruleAssignedAction ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:219:1: (lv_x6_5_0= ruleAssignedAction )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:219:1: (lv_x6_5_0= ruleAssignedAction )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:220:3: lv_x6_5_0= ruleAssignedAction
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX6AssignedActionParserRuleCall_5_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAssignedAction_in_ruleModel266);
                    lv_x6_5_0=ruleAssignedAction();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:243:6: ( (lv_x7_6_0= ruleAssignedActionSecond ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:243:6: ( (lv_x7_6_0= ruleAssignedActionSecond ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:244:1: (lv_x7_6_0= ruleAssignedActionSecond )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:244:1: (lv_x7_6_0= ruleAssignedActionSecond )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:245:3: lv_x7_6_0= ruleAssignedActionSecond
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX7AssignedActionSecondParserRuleCall_6_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAssignedActionSecond_in_ruleModel293);
                    lv_x7_6_0=ruleAssignedActionSecond();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:268:6: ( (lv_x8_7_0= ruleUnassignedAction1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:268:6: ( (lv_x8_7_0= ruleUnassignedAction1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:269:1: (lv_x8_7_0= ruleUnassignedAction1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:269:1: (lv_x8_7_0= ruleUnassignedAction1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:270:3: lv_x8_7_0= ruleUnassignedAction1
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX8UnassignedAction1ParserRuleCall_7_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction1_in_ruleModel320);
                    lv_x8_7_0=ruleUnassignedAction1();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:293:6: ( (lv_x9_8_0= ruleUnassignedAction2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:293:6: ( (lv_x9_8_0= ruleUnassignedAction2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:294:1: (lv_x9_8_0= ruleUnassignedAction2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:294:1: (lv_x9_8_0= ruleUnassignedAction2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:295:3: lv_x9_8_0= ruleUnassignedAction2
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX9UnassignedAction2ParserRuleCall_8_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction2_in_ruleModel347);
                    lv_x9_8_0=ruleUnassignedAction2();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:318:6: ( (lv_x10_9_0= ruleUnassignedAction3 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:318:6: ( (lv_x10_9_0= ruleUnassignedAction3 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:319:1: (lv_x10_9_0= ruleUnassignedAction3 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:319:1: (lv_x10_9_0= ruleUnassignedAction3 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:320:3: lv_x10_9_0= ruleUnassignedAction3
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX10UnassignedAction3ParserRuleCall_9_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction3_in_ruleModel374);
                    lv_x10_9_0=ruleUnassignedAction3();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:343:6: ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:343:6: ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:344:1: (lv_x11_10_0= ruleUnassignedRuleCall1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:344:1: (lv_x11_10_0= ruleUnassignedRuleCall1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:345:3: lv_x11_10_0= ruleUnassignedRuleCall1
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX11UnassignedRuleCall1ParserRuleCall_10_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall1_in_ruleModel401);
                    lv_x11_10_0=ruleUnassignedRuleCall1();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:368:6: ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:368:6: ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:369:1: (lv_x12_11_0= ruleUnassignedRuleCall2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:369:1: (lv_x12_11_0= ruleUnassignedRuleCall2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:370:3: lv_x12_11_0= ruleUnassignedRuleCall2
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX12UnassignedRuleCall2ParserRuleCall_11_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall2_in_ruleModel428);
                    lv_x12_11_0=ruleUnassignedRuleCall2();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:393:6: ( (lv_x13_12_0= ruleCombination1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:393:6: ( (lv_x13_12_0= ruleCombination1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:394:1: (lv_x13_12_0= ruleCombination1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:394:1: (lv_x13_12_0= ruleCombination1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:395:3: lv_x13_12_0= ruleCombination1
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX13Combination1ParserRuleCall_12_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCombination1_in_ruleModel455);
                    lv_x13_12_0=ruleCombination1();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:418:6: ( (lv_x14_13_0= ruleCombination2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:418:6: ( (lv_x14_13_0= ruleCombination2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:419:1: (lv_x14_13_0= ruleCombination2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:419:1: (lv_x14_13_0= ruleCombination2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:420:3: lv_x14_13_0= ruleCombination2
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX14Combination2ParserRuleCall_13_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCombination2_in_ruleModel482);
                    lv_x14_13_0=ruleCombination2();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:443:6: ( (lv_x15_14_0= ruleCombination3 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:443:6: ( (lv_x15_14_0= ruleCombination3 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:444:1: (lv_x15_14_0= ruleCombination3 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:444:1: (lv_x15_14_0= ruleCombination3 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:445:3: lv_x15_14_0= ruleCombination3
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX15Combination3ParserRuleCall_14_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCombination3_in_ruleModel509);
                    lv_x15_14_0=ruleCombination3();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:468:6: ( (lv_x16_15_0= ruleCombination4 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:468:6: ( (lv_x16_15_0= ruleCombination4 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:469:1: (lv_x16_15_0= ruleCombination4 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:469:1: (lv_x16_15_0= ruleCombination4 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:470:3: lv_x16_15_0= ruleCombination4
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX16Combination4ParserRuleCall_15_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleCombination4_in_ruleModel536);
                    lv_x16_15_0=ruleCombination4();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:493:6: ( (lv_x17_16_0= ruleList1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:493:6: ( (lv_x17_16_0= ruleList1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:494:1: (lv_x17_16_0= ruleList1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:494:1: (lv_x17_16_0= ruleList1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:495:3: lv_x17_16_0= ruleList1
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX17List1ParserRuleCall_16_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleList1_in_ruleModel563);
                    lv_x17_16_0=ruleList1();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:518:6: ( (lv_x18_17_0= ruleList2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:518:6: ( (lv_x18_17_0= ruleList2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:519:1: (lv_x18_17_0= ruleList2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:519:1: (lv_x18_17_0= ruleList2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:520:3: lv_x18_17_0= ruleList2
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX18List2ParserRuleCall_17_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleList2_in_ruleModel590);
                    lv_x18_17_0=ruleList2();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:543:6: ( (lv_x19_18_0= ruleList3 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:543:6: ( (lv_x19_18_0= ruleList3 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:544:1: (lv_x19_18_0= ruleList3 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:544:1: (lv_x19_18_0= ruleList3 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:545:3: lv_x19_18_0= ruleList3
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX19List3ParserRuleCall_18_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleList3_in_ruleModel617);
                    lv_x19_18_0=ruleList3();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:568:6: ( (lv_x20_19_0= ruleList4 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:568:6: ( (lv_x20_19_0= ruleList4 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:569:1: (lv_x20_19_0= ruleList4 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:569:1: (lv_x20_19_0= ruleList4 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:570:3: lv_x20_19_0= ruleList4
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX20List4ParserRuleCall_19_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleList4_in_ruleModel644);
                    lv_x20_19_0=ruleList4();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:593:6: ( (lv_x21_20_0= ruleList5 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:593:6: ( (lv_x21_20_0= ruleList5 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:594:1: (lv_x21_20_0= ruleList5 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:594:1: (lv_x21_20_0= ruleList5 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:595:3: lv_x21_20_0= ruleList5
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX21List5ParserRuleCall_20_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleList5_in_ruleModel671);
                    lv_x21_20_0=ruleList5();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:618:6: ( (lv_x22_21_0= ruleAltList1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:618:6: ( (lv_x22_21_0= ruleAltList1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:619:1: (lv_x22_21_0= ruleAltList1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:619:1: (lv_x22_21_0= ruleAltList1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:620:3: lv_x22_21_0= ruleAltList1
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX22AltList1ParserRuleCall_21_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAltList1_in_ruleModel698);
                    lv_x22_21_0=ruleAltList1();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:643:6: ( (lv_x23_22_0= ruleAltList2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:643:6: ( (lv_x23_22_0= ruleAltList2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:644:1: (lv_x23_22_0= ruleAltList2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:644:1: (lv_x23_22_0= ruleAltList2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:645:3: lv_x23_22_0= ruleAltList2
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX23AltList2ParserRuleCall_22_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAltList2_in_ruleModel725);
                    lv_x23_22_0=ruleAltList2();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:668:6: ( (lv_x24_23_0= ruleTransientObject ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:668:6: ( (lv_x24_23_0= ruleTransientObject ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:669:1: (lv_x24_23_0= ruleTransientObject )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:669:1: (lv_x24_23_0= ruleTransientObject )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:670:3: lv_x24_23_0= ruleTransientObject
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX24TransientObjectParserRuleCall_23_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTransientObject_in_ruleModel752);
                    lv_x24_23_0=ruleTransientObject();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:693:6: ( (lv_x25_24_0= ruleTransientSerializeables1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:693:6: ( (lv_x25_24_0= ruleTransientSerializeables1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:694:1: (lv_x25_24_0= ruleTransientSerializeables1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:694:1: (lv_x25_24_0= ruleTransientSerializeables1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:695:3: lv_x25_24_0= ruleTransientSerializeables1
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX25TransientSerializeables1ParserRuleCall_24_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTransientSerializeables1_in_ruleModel779);
                    lv_x25_24_0=ruleTransientSerializeables1();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:718:6: ( (lv_x26_25_0= ruleStaticSimplification ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:718:6: ( (lv_x26_25_0= ruleStaticSimplification ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:719:1: (lv_x26_25_0= ruleStaticSimplification )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:719:1: (lv_x26_25_0= ruleStaticSimplification )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:720:3: lv_x26_25_0= ruleStaticSimplification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX26StaticSimplificationParserRuleCall_25_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleStaticSimplification_in_ruleModel806);
                    lv_x26_25_0=ruleStaticSimplification();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:743:6: ( (lv_x27_26_0= ruleTwoVersion ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:743:6: ( (lv_x27_26_0= ruleTwoVersion ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:744:1: (lv_x27_26_0= ruleTwoVersion )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:744:1: (lv_x27_26_0= ruleTwoVersion )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:745:3: lv_x27_26_0= ruleTwoVersion
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX27TwoVersionParserRuleCall_26_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTwoVersion_in_ruleModel833);
                    lv_x27_26_0=ruleTwoVersion();
                    _fsp--;


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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:768:6: ( (lv_x28_27_0= ruleHeuristic1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:768:6: ( (lv_x28_27_0= ruleHeuristic1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:769:1: (lv_x28_27_0= ruleHeuristic1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:769:1: (lv_x28_27_0= ruleHeuristic1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:770:3: lv_x28_27_0= ruleHeuristic1
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getX28Heuristic1ParserRuleCall_27_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleHeuristic1_in_ruleModel860);
                    lv_x28_27_0=ruleHeuristic1();
                    _fsp--;


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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleSimpleGroup
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:800:1: entryRuleSimpleGroup returns [EObject current=null] : iv_ruleSimpleGroup= ruleSimpleGroup EOF ;
    public final EObject entryRuleSimpleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleGroup = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:801:2: (iv_ruleSimpleGroup= ruleSimpleGroup EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:802:2: iv_ruleSimpleGroup= ruleSimpleGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleGroupRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleGroup_in_entryRuleSimpleGroup896);
            iv_ruleSimpleGroup=ruleSimpleGroup();
            _fsp--;

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
    // $ANTLR end entryRuleSimpleGroup


    // $ANTLR start ruleSimpleGroup
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:809:1: ruleSimpleGroup returns [EObject current=null] : ( '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final EObject ruleSimpleGroup() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:814:6: ( ( '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:815:1: ( '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:815:1: ( '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:815:3: '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleSimpleGroup941); 

                    createLeafNode(grammarAccess.getSimpleGroupAccess().getNumberSignDigitOneKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:819:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:820:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:820:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:821:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleGroup958); 

            			createLeafNode(grammarAccess.getSimpleGroupAccess().getVal1IDTerminalRuleCall_1_0(), "val1"); 
            		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:843:2: ( (lv_val2_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:844:1: (lv_val2_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:844:1: (lv_val2_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:845:3: lv_val2_2_0= RULE_ID
            {
            lv_val2_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleGroup980); 

            			createLeafNode(grammarAccess.getSimpleGroupAccess().getVal2IDTerminalRuleCall_2_0(), "val2"); 
            		

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
    // $ANTLR end ruleSimpleGroup


    // $ANTLR start entryRuleSimpleAlternative
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:875:1: entryRuleSimpleAlternative returns [EObject current=null] : iv_ruleSimpleAlternative= ruleSimpleAlternative EOF ;
    public final EObject entryRuleSimpleAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAlternative = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:876:2: (iv_ruleSimpleAlternative= ruleSimpleAlternative EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:877:2: iv_ruleSimpleAlternative= ruleSimpleAlternative EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleAlternativeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleAlternative_in_entryRuleSimpleAlternative1021);
            iv_ruleSimpleAlternative=ruleSimpleAlternative();
            _fsp--;

             current =iv_ruleSimpleAlternative; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleAlternative1031); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSimpleAlternative


    // $ANTLR start ruleSimpleAlternative
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:884:1: ruleSimpleAlternative returns [EObject current=null] : ( '#2' ( ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) ;
    public final EObject ruleSimpleAlternative() throws RecognitionException {
        EObject current = null;

        Token lv_val1_2_0=null;
        Token lv_val2_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:889:6: ( ( '#2' ( ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:890:1: ( '#2' ( ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:890:1: ( '#2' ( ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:890:3: '#2' ( ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
            {
            match(input,12,FollowSets000.FOLLOW_12_in_ruleSimpleAlternative1066); 

                    createLeafNode(grammarAccess.getSimpleAlternativeAccess().getNumberSignDigitTwoKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:894:1: ( ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
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
                    new NoViableAltException("894:1: ( ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:894:2: ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:894:2: ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:894:4: 'kw1' ( (lv_val1_2_0= RULE_ID ) )
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleSimpleAlternative1078); 

                            createLeafNode(grammarAccess.getSimpleAlternativeAccess().getKw1Keyword_1_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:898:1: ( (lv_val1_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:899:1: (lv_val1_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:899:1: (lv_val1_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:900:3: lv_val1_2_0= RULE_ID
                    {
                    lv_val1_2_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleAlternative1095); 

                    			createLeafNode(grammarAccess.getSimpleAlternativeAccess().getVal1IDTerminalRuleCall_1_0_1_0(), "val1"); 
                    		

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:923:6: ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:923:6: ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:923:8: 'kw2' ( (lv_val2_4_0= RULE_ID ) )
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleSimpleAlternative1118); 

                            createLeafNode(grammarAccess.getSimpleAlternativeAccess().getKw2Keyword_1_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:927:1: ( (lv_val2_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:928:1: (lv_val2_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:928:1: (lv_val2_4_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:929:3: lv_val2_4_0= RULE_ID
                    {
                    lv_val2_4_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleAlternative1135); 

                    			createLeafNode(grammarAccess.getSimpleAlternativeAccess().getVal2IDTerminalRuleCall_1_1_1_0(), "val2"); 
                    		

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
    // $ANTLR end ruleSimpleAlternative


    // $ANTLR start entryRuleSimpleMultiplicities
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:959:1: entryRuleSimpleMultiplicities returns [EObject current=null] : iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF ;
    public final EObject entryRuleSimpleMultiplicities() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleMultiplicities = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:960:2: (iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:961:2: iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleMultiplicitiesRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleMultiplicities_in_entryRuleSimpleMultiplicities1178);
            iv_ruleSimpleMultiplicities=ruleSimpleMultiplicities();
            _fsp--;

             current =iv_ruleSimpleMultiplicities; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleMultiplicities1188); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSimpleMultiplicities


    // $ANTLR start ruleSimpleMultiplicities
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:968:1: ruleSimpleMultiplicities returns [EObject current=null] : ( '#3' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) )? 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) ;
    public final EObject ruleSimpleMultiplicities() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_3_0=null;
        Token lv_val3_5_0=null;
        Token lv_val4_7_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:973:6: ( ( '#3' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) )? 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:974:1: ( '#3' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) )? 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:974:1: ( '#3' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) )? 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:974:3: '#3' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) )? 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ 'kw3' ( (lv_val4_7_0= RULE_ID ) )*
            {
            match(input,15,FollowSets000.FOLLOW_15_in_ruleSimpleMultiplicities1223); 

                    createLeafNode(grammarAccess.getSimpleMultiplicitiesAccess().getNumberSignDigitThreeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:978:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:979:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:979:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:980:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1240); 

            			createLeafNode(grammarAccess.getSimpleMultiplicitiesAccess().getVal1IDTerminalRuleCall_1_0(), "val1"); 
            		

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

            match(input,13,FollowSets000.FOLLOW_13_in_ruleSimpleMultiplicities1255); 

                    createLeafNode(grammarAccess.getSimpleMultiplicitiesAccess().getKw1Keyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1006:1: ( (lv_val2_3_0= RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1007:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1007:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1008:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1272); 

                    			createLeafNode(grammarAccess.getSimpleMultiplicitiesAccess().getVal2IDTerminalRuleCall_3_0(), "val2"); 
                    		

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

            match(input,14,FollowSets000.FOLLOW_14_in_ruleSimpleMultiplicities1288); 

                    createLeafNode(grammarAccess.getSimpleMultiplicitiesAccess().getKw2Keyword_4(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1034:1: ( (lv_val3_5_0= RULE_ID ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1035:1: (lv_val3_5_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1035:1: (lv_val3_5_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1036:3: lv_val3_5_0= RULE_ID
            	    {
            	    lv_val3_5_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1305); 

            	    			createLeafNode(grammarAccess.getSimpleMultiplicitiesAccess().getVal3IDTerminalRuleCall_5_0(), "val3"); 
            	    		

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

            match(input,16,FollowSets000.FOLLOW_16_in_ruleSimpleMultiplicities1321); 

                    createLeafNode(grammarAccess.getSimpleMultiplicitiesAccess().getKw3Keyword_6(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1062:1: ( (lv_val4_7_0= RULE_ID ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1063:1: (lv_val4_7_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1063:1: (lv_val4_7_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1064:3: lv_val4_7_0= RULE_ID
            	    {
            	    lv_val4_7_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1338); 

            	    			createLeafNode(grammarAccess.getSimpleMultiplicitiesAccess().getVal4IDTerminalRuleCall_7_0(), "val4"); 
            	    		

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
    // $ANTLR end ruleSimpleMultiplicities


    // $ANTLR start entryRuleGroupMultiplicities
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1094:1: entryRuleGroupMultiplicities returns [EObject current=null] : iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF ;
    public final EObject entryRuleGroupMultiplicities() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupMultiplicities = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1095:2: (iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1096:2: iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGroupMultiplicitiesRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleGroupMultiplicities_in_entryRuleGroupMultiplicities1380);
            iv_ruleGroupMultiplicities=ruleGroupMultiplicities();
            _fsp--;

             current =iv_ruleGroupMultiplicities; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroupMultiplicities1390); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleGroupMultiplicities


    // $ANTLR start ruleGroupMultiplicities
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1103:1: ruleGroupMultiplicities returns [EObject current=null] : ( '#4' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) ;
    public final EObject ruleGroupMultiplicities() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_3_0=null;
        Token lv_val3_4_0=null;
        Token lv_val4_6_0=null;
        Token lv_val5_7_0=null;
        Token lv_val6_9_0=null;
        Token lv_val7_10_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1108:6: ( ( '#4' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1109:1: ( '#4' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1109:1: ( '#4' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1109:3: '#4' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            {
            match(input,17,FollowSets000.FOLLOW_17_in_ruleGroupMultiplicities1425); 

                    createLeafNode(grammarAccess.getGroupMultiplicitiesAccess().getNumberSignDigitFourKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1113:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1114:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1114:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1115:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1442); 

            			createLeafNode(grammarAccess.getGroupMultiplicitiesAccess().getVal1IDTerminalRuleCall_1_0(), "val1"); 
            		

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

            match(input,13,FollowSets000.FOLLOW_13_in_ruleGroupMultiplicities1457); 

                    createLeafNode(grammarAccess.getGroupMultiplicitiesAccess().getKw1Keyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1141:1: ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1141:2: ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1141:2: ( (lv_val2_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1142:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1142:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1143:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1475); 

                    			createLeafNode(grammarAccess.getGroupMultiplicitiesAccess().getVal2IDTerminalRuleCall_3_0_0(), "val2"); 
                    		

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1165:2: ( (lv_val3_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1166:1: (lv_val3_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1166:1: (lv_val3_4_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1167:3: lv_val3_4_0= RULE_ID
                    {
                    lv_val3_4_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1497); 

                    			createLeafNode(grammarAccess.getGroupMultiplicitiesAccess().getVal3IDTerminalRuleCall_3_1_0(), "val3"); 
                    		

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

            match(input,14,FollowSets000.FOLLOW_14_in_ruleGroupMultiplicities1514); 

                    createLeafNode(grammarAccess.getGroupMultiplicitiesAccess().getKw2Keyword_4(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1193:1: ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1193:2: ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1193:2: ( (lv_val4_6_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1194:1: (lv_val4_6_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1194:1: (lv_val4_6_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1195:3: lv_val4_6_0= RULE_ID
            	    {
            	    lv_val4_6_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1532); 

            	    			createLeafNode(grammarAccess.getGroupMultiplicitiesAccess().getVal4IDTerminalRuleCall_5_0_0(), "val4"); 
            	    		

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

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1217:2: ( (lv_val5_7_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1218:1: (lv_val5_7_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1218:1: (lv_val5_7_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1219:3: lv_val5_7_0= RULE_ID
            	    {
            	    lv_val5_7_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1554); 

            	    			createLeafNode(grammarAccess.getGroupMultiplicitiesAccess().getVal5IDTerminalRuleCall_5_1_0(), "val5"); 
            	    		

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

            match(input,16,FollowSets000.FOLLOW_16_in_ruleGroupMultiplicities1571); 

                    createLeafNode(grammarAccess.getGroupMultiplicitiesAccess().getKw3Keyword_6(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1245:1: ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1245:2: ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1245:2: ( (lv_val6_9_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1246:1: (lv_val6_9_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1246:1: (lv_val6_9_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1247:3: lv_val6_9_0= RULE_ID
            	    {
            	    lv_val6_9_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1589); 

            	    			createLeafNode(grammarAccess.getGroupMultiplicitiesAccess().getVal6IDTerminalRuleCall_7_0_0(), "val6"); 
            	    		

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

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1269:2: ( (lv_val7_10_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1270:1: (lv_val7_10_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1270:1: (lv_val7_10_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1271:3: lv_val7_10_0= RULE_ID
            	    {
            	    lv_val7_10_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1611); 

            	    			createLeafNode(grammarAccess.getGroupMultiplicitiesAccess().getVal7IDTerminalRuleCall_7_1_0(), "val7"); 
            	    		

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
    // $ANTLR end ruleGroupMultiplicities


    // $ANTLR start entryRuleAlternativeMultiplicities
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1301:1: entryRuleAlternativeMultiplicities returns [EObject current=null] : iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF ;
    public final EObject entryRuleAlternativeMultiplicities() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternativeMultiplicities = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1302:2: (iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1303:2: iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAlternativeMultiplicitiesRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternativeMultiplicities_in_entryRuleAlternativeMultiplicities1654);
            iv_ruleAlternativeMultiplicities=ruleAlternativeMultiplicities();
            _fsp--;

             current =iv_ruleAlternativeMultiplicities; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlternativeMultiplicities1664); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAlternativeMultiplicities


    // $ANTLR start ruleAlternativeMultiplicities
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1310:1: ruleAlternativeMultiplicities returns [EObject current=null] : ( '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) ;
    public final EObject ruleAlternativeMultiplicities() throws RecognitionException {
        EObject current = null;

        Token lv_val2_1_0=null;
        Token lv_val3_3_0=null;
        Token lv_val4_5_0=null;
        Token lv_val5_7_0=null;
        Token lv_val6_9_0=null;
        Token lv_val7_11_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1315:6: ( ( '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1316:1: ( '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1316:1: ( '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1316:3: '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
            {
            match(input,18,FollowSets000.FOLLOW_18_in_ruleAlternativeMultiplicities1699); 

                    createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getNumberSignDigitFiveKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1320:1: ( ( (lv_val2_1_0= RULE_ID ) ) | ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )?
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1320:2: ( (lv_val2_1_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1320:2: ( (lv_val2_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1321:1: (lv_val2_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1321:1: (lv_val2_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1322:3: lv_val2_1_0= RULE_ID
                    {
                    lv_val2_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1717); 

                    			createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getVal2IDTerminalRuleCall_1_0_0(), "val2"); 
                    		

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1345:6: ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1345:6: ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1345:8: 'kw1' ( (lv_val3_3_0= RULE_ID ) )
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleAlternativeMultiplicities1739); 

                            createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getKw1Keyword_1_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1349:1: ( (lv_val3_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1350:1: (lv_val3_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1350:1: (lv_val3_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1351:3: lv_val3_3_0= RULE_ID
                    {
                    lv_val3_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1756); 

                    			createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getVal3IDTerminalRuleCall_1_1_1_0(), "val3"); 
                    		

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

            match(input,14,FollowSets000.FOLLOW_14_in_ruleAlternativeMultiplicities1774); 

                    createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getKw2Keyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1377:1: ( ( (lv_val4_5_0= RULE_ID ) ) | ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1377:2: ( (lv_val4_5_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1377:2: ( (lv_val4_5_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1378:1: (lv_val4_5_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1378:1: (lv_val4_5_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1379:3: lv_val4_5_0= RULE_ID
            	    {
            	    lv_val4_5_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1792); 

            	    			createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getVal4IDTerminalRuleCall_3_0_0(), "val4"); 
            	    		

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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1402:6: ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1402:6: ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1402:8: 'kw3' ( (lv_val5_7_0= RULE_ID ) )
            	    {
            	    match(input,16,FollowSets000.FOLLOW_16_in_ruleAlternativeMultiplicities1814); 

            	            createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getKw3Keyword_3_1_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1406:1: ( (lv_val5_7_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1407:1: (lv_val5_7_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1407:1: (lv_val5_7_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1408:3: lv_val5_7_0= RULE_ID
            	    {
            	    lv_val5_7_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1831); 

            	    			createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getVal5IDTerminalRuleCall_3_1_1_0(), "val5"); 
            	    		

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

            match(input,19,FollowSets000.FOLLOW_19_in_ruleAlternativeMultiplicities1849); 

                    createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getKw4Keyword_4(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1434:1: ( ( (lv_val6_9_0= RULE_ID ) ) | ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1434:2: ( (lv_val6_9_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1434:2: ( (lv_val6_9_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1435:1: (lv_val6_9_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1435:1: (lv_val6_9_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1436:3: lv_val6_9_0= RULE_ID
            	    {
            	    lv_val6_9_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1867); 

            	    			createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getVal6IDTerminalRuleCall_5_0_0(), "val6"); 
            	    		

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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1459:6: ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1459:6: ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1459:8: 'kw5' ( (lv_val7_11_0= RULE_ID ) )
            	    {
            	    match(input,20,FollowSets000.FOLLOW_20_in_ruleAlternativeMultiplicities1889); 

            	            createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getKw5Keyword_5_1_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1463:1: ( (lv_val7_11_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1464:1: (lv_val7_11_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1464:1: (lv_val7_11_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1465:3: lv_val7_11_0= RULE_ID
            	    {
            	    lv_val7_11_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1906); 

            	    			createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getVal7IDTerminalRuleCall_5_1_1_0(), "val7"); 
            	    		

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
    // $ANTLR end ruleAlternativeMultiplicities


    // $ANTLR start entryRuleAssignedAction
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1495:1: entryRuleAssignedAction returns [EObject current=null] : iv_ruleAssignedAction= ruleAssignedAction EOF ;
    public final EObject entryRuleAssignedAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignedAction = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1496:2: (iv_ruleAssignedAction= ruleAssignedAction EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1497:2: iv_ruleAssignedAction= ruleAssignedAction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignedActionRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignedAction_in_entryRuleAssignedAction1950);
            iv_ruleAssignedAction=ruleAssignedAction();
            _fsp--;

             current =iv_ruleAssignedAction; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignedAction1960); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAssignedAction


    // $ANTLR start ruleAssignedAction
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1504:1: ruleAssignedAction returns [EObject current=null] : ( '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ ) ;
    public final EObject ruleAssignedAction() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val1_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1509:6: ( ( '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1510:1: ( '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1510:1: ( '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1510:3: '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+
            {
            match(input,21,FollowSets000.FOLLOW_21_in_ruleAssignedAction1995); 

                    createLeafNode(grammarAccess.getAssignedActionAccess().getNumberSignDigitSixKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1514:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1515:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1515:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1516:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignedAction2012); 

            			createLeafNode(grammarAccess.getAssignedActionAccess().getVal1IDTerminalRuleCall_1_0(), "val1"); 
            		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1538:2: ( () ( (lv_val1_3_0= RULE_ID ) ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1538:3: () ( (lv_val1_3_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1538:3: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1539:5: 
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

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1554:2: ( (lv_val1_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1555:1: (lv_val1_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1555:1: (lv_val1_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1556:3: lv_val1_3_0= RULE_ID
            	    {
            	    lv_val1_3_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignedAction2044); 

            	    			createLeafNode(grammarAccess.getAssignedActionAccess().getVal1IDTerminalRuleCall_2_1_0(), "val1"); 
            	    		

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
    // $ANTLR end ruleAssignedAction


    // $ANTLR start entryRuleAssignedActionSecond
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1586:1: entryRuleAssignedActionSecond returns [EObject current=null] : iv_ruleAssignedActionSecond= ruleAssignedActionSecond EOF ;
    public final EObject entryRuleAssignedActionSecond() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignedActionSecond = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1587:2: (iv_ruleAssignedActionSecond= ruleAssignedActionSecond EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1588:2: iv_ruleAssignedActionSecond= ruleAssignedActionSecond EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignedActionSecondRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignedActionSecond_in_entryRuleAssignedActionSecond2087);
            iv_ruleAssignedActionSecond=ruleAssignedActionSecond();
            _fsp--;

             current =iv_ruleAssignedActionSecond; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignedActionSecond2097); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAssignedActionSecond


    // $ANTLR start ruleAssignedActionSecond
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1595:1: ruleAssignedActionSecond returns [EObject current=null] : ( '#7' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) ;
    public final EObject ruleAssignedActionSecond() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1600:6: ( ( '#7' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1601:1: ( '#7' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1601:1: ( '#7' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1601:3: '#7' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) )
            {
            match(input,22,FollowSets000.FOLLOW_22_in_ruleAssignedActionSecond2132); 

                    createLeafNode(grammarAccess.getAssignedActionSecondAccess().getNumberSignDigitSevenKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1605:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1606:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1606:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1607:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignedActionSecond2149); 

            			createLeafNode(grammarAccess.getAssignedActionSecondAccess().getVal1IDTerminalRuleCall_1_0(), "val1"); 
            		

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

            match(input,13,FollowSets000.FOLLOW_13_in_ruleAssignedActionSecond2164); 

                    createLeafNode(grammarAccess.getAssignedActionSecondAccess().getKw1Keyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1633:1: ( (lv_val2_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1634:1: (lv_val2_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1634:1: (lv_val2_3_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1635:3: lv_val2_3_0= RULE_ID
            {
            lv_val2_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignedActionSecond2181); 

            			createLeafNode(grammarAccess.getAssignedActionSecondAccess().getVal2IDTerminalRuleCall_3_0(), "val2"); 
            		

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
    // $ANTLR end ruleAssignedActionSecond


    // $ANTLR start entryRuleUnassignedAction1
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1665:1: entryRuleUnassignedAction1 returns [EObject current=null] : iv_ruleUnassignedAction1= ruleUnassignedAction1 EOF ;
    public final EObject entryRuleUnassignedAction1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedAction1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1666:2: (iv_ruleUnassignedAction1= ruleUnassignedAction1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1667:2: iv_ruleUnassignedAction1= ruleUnassignedAction1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedAction1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction1_in_entryRuleUnassignedAction12222);
            iv_ruleUnassignedAction1=ruleUnassignedAction1();
            _fsp--;

             current =iv_ruleUnassignedAction1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedAction12232); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleUnassignedAction1


    // $ANTLR start ruleUnassignedAction1
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1674:1: ruleUnassignedAction1 returns [EObject current=null] : ( () '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) ;
    public final EObject ruleUnassignedAction1() throws RecognitionException {
        EObject current = null;

        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1679:6: ( ( () '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1680:1: ( () '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1680:1: ( () '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1680:2: () '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1680:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1681:5: 
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

            match(input,23,FollowSets000.FOLLOW_23_in_ruleUnassignedAction12276); 

                    createLeafNode(grammarAccess.getUnassignedAction1Access().getNumberSignDigitEightKeyword_1(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1695:1: ( (lv_val1_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1696:1: (lv_val1_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1696:1: (lv_val1_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1697:3: lv_val1_2_0= RULE_ID
            {
            lv_val1_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction12293); 

            			createLeafNode(grammarAccess.getUnassignedAction1Access().getVal1IDTerminalRuleCall_2_0(), "val1"); 
            		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1719:2: ( (lv_val2_3_0= RULE_ID ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1720:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1720:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1721:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction12315); 

                    			createLeafNode(grammarAccess.getUnassignedAction1Access().getVal2IDTerminalRuleCall_3_0(), "val2"); 
                    		

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
    // $ANTLR end ruleUnassignedAction1


    // $ANTLR start entryRuleUnassignedAction2
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1751:1: entryRuleUnassignedAction2 returns [EObject current=null] : iv_ruleUnassignedAction2= ruleUnassignedAction2 EOF ;
    public final EObject entryRuleUnassignedAction2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedAction2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1752:2: (iv_ruleUnassignedAction2= ruleUnassignedAction2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1753:2: iv_ruleUnassignedAction2= ruleUnassignedAction2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedAction2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction2_in_entryRuleUnassignedAction22357);
            iv_ruleUnassignedAction2=ruleUnassignedAction2();
            _fsp--;

             current =iv_ruleUnassignedAction2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedAction22367); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleUnassignedAction2


    // $ANTLR start ruleUnassignedAction2
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1760:1: ruleUnassignedAction2 returns [EObject current=null] : ( () '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) ;
    public final EObject ruleUnassignedAction2() throws RecognitionException {
        EObject current = null;

        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1765:6: ( ( () '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1766:1: ( () '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1766:1: ( () '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1766:2: () '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1766:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1767:5: 
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

            match(input,24,FollowSets000.FOLLOW_24_in_ruleUnassignedAction22411); 

                    createLeafNode(grammarAccess.getUnassignedAction2Access().getNumberSignDigitNineKeyword_1(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1781:1: ( (lv_val1_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1782:1: (lv_val1_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1782:1: (lv_val1_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1783:3: lv_val1_2_0= RULE_ID
            {
            lv_val1_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction22428); 

            			createLeafNode(grammarAccess.getUnassignedAction2Access().getVal1IDTerminalRuleCall_2_0(), "val1"); 
            		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1805:2: ( (lv_val2_3_0= RULE_ID ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1806:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1806:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1807:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction22450); 

                    			createLeafNode(grammarAccess.getUnassignedAction2Access().getVal2IDTerminalRuleCall_3_0(), "val2"); 
                    		

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
    // $ANTLR end ruleUnassignedAction2


    // $ANTLR start entryRuleUnassignedAction3
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1837:1: entryRuleUnassignedAction3 returns [EObject current=null] : iv_ruleUnassignedAction3= ruleUnassignedAction3 EOF ;
    public final EObject entryRuleUnassignedAction3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedAction3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1838:2: (iv_ruleUnassignedAction3= ruleUnassignedAction3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1839:2: iv_ruleUnassignedAction3= ruleUnassignedAction3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedAction3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction3_in_entryRuleUnassignedAction32492);
            iv_ruleUnassignedAction3=ruleUnassignedAction3();
            _fsp--;

             current =iv_ruleUnassignedAction3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedAction32502); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleUnassignedAction3


    // $ANTLR start ruleUnassignedAction3
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1846:1: ruleUnassignedAction3 returns [EObject current=null] : ( '#10' ( ( 'kw1' () ) | ( 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? ) ;
    public final EObject ruleUnassignedAction3() throws RecognitionException {
        EObject current = null;

        Token lv_val1_5_0=null;
        Token lv_val2_6_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1851:6: ( ( '#10' ( ( 'kw1' () ) | ( 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1852:1: ( '#10' ( ( 'kw1' () ) | ( 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1852:1: ( '#10' ( ( 'kw1' () ) | ( 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1852:3: '#10' ( ( 'kw1' () ) | ( 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )?
            {
            match(input,25,FollowSets000.FOLLOW_25_in_ruleUnassignedAction32537); 

                    createLeafNode(grammarAccess.getUnassignedAction3Access().getNumberSignDigitOneDigitZeroKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1856:1: ( ( 'kw1' () ) | ( 'kw2' () ) )
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
                    new NoViableAltException("1856:1: ( ( 'kw1' () ) | ( 'kw2' () ) )", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1856:2: ( 'kw1' () )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1856:2: ( 'kw1' () )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1856:4: 'kw1' ()
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleUnassignedAction32549); 

                            createLeafNode(grammarAccess.getUnassignedAction3Access().getKw1Keyword_1_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1860:1: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1861:5: 
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1872:6: ( 'kw2' () )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1872:6: ( 'kw2' () )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1872:8: 'kw2' ()
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleUnassignedAction32576); 

                            createLeafNode(grammarAccess.getUnassignedAction3Access().getKw2Keyword_1_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1876:1: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1877:5: 
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1887:4: ( (lv_val1_5_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1888:1: (lv_val1_5_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1888:1: (lv_val1_5_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1889:3: lv_val1_5_0= RULE_ID
            {
            lv_val1_5_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction32604); 

            			createLeafNode(grammarAccess.getUnassignedAction3Access().getVal1IDTerminalRuleCall_2_0(), "val1"); 
            		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1911:2: ( (lv_val2_6_0= RULE_ID ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1912:1: (lv_val2_6_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1912:1: (lv_val2_6_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1913:3: lv_val2_6_0= RULE_ID
                    {
                    lv_val2_6_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction32626); 

                    			createLeafNode(grammarAccess.getUnassignedAction3Access().getVal2IDTerminalRuleCall_3_0(), "val2"); 
                    		

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
    // $ANTLR end ruleUnassignedAction3


    // $ANTLR start entryRuleUnassignedRuleCall1
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1943:1: entryRuleUnassignedRuleCall1 returns [EObject current=null] : iv_ruleUnassignedRuleCall1= ruleUnassignedRuleCall1 EOF ;
    public final EObject entryRuleUnassignedRuleCall1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedRuleCall1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1944:2: (iv_ruleUnassignedRuleCall1= ruleUnassignedRuleCall1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1945:2: iv_ruleUnassignedRuleCall1= ruleUnassignedRuleCall1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedRuleCall1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall1_in_entryRuleUnassignedRuleCall12668);
            iv_ruleUnassignedRuleCall1=ruleUnassignedRuleCall1();
            _fsp--;

             current =iv_ruleUnassignedRuleCall1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedRuleCall12678); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleUnassignedRuleCall1


    // $ANTLR start ruleUnassignedRuleCall1
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1952:1: ruleUnassignedRuleCall1 returns [EObject current=null] : ( '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final EObject ruleUnassignedRuleCall1() throws RecognitionException {
        EObject current = null;

        Token lv_val2_2_0=null;
        EObject this_UnassignedRuleCall1Sub_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1957:6: ( ( '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1958:1: ( '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1958:1: ( '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1958:3: '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) )
            {
            match(input,26,FollowSets000.FOLLOW_26_in_ruleUnassignedRuleCall12713); 

                    createLeafNode(grammarAccess.getUnassignedRuleCall1Access().getNumberSignDigitOneDigitOneKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getUnassignedRuleCall1Access().getUnassignedRuleCall1SubParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall1Sub_in_ruleUnassignedRuleCall12735);
            this_UnassignedRuleCall1Sub_1=ruleUnassignedRuleCall1Sub();
            _fsp--;

             
                    current = this_UnassignedRuleCall1Sub_1; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1971:1: ( (lv_val2_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1972:1: (lv_val2_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1972:1: (lv_val2_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1973:3: lv_val2_2_0= RULE_ID
            {
            lv_val2_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedRuleCall12751); 

            			createLeafNode(grammarAccess.getUnassignedRuleCall1Access().getVal2IDTerminalRuleCall_2_0(), "val2"); 
            		

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
    // $ANTLR end ruleUnassignedRuleCall1


    // $ANTLR start entryRuleUnassignedRuleCall1Sub
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2003:1: entryRuleUnassignedRuleCall1Sub returns [EObject current=null] : iv_ruleUnassignedRuleCall1Sub= ruleUnassignedRuleCall1Sub EOF ;
    public final EObject entryRuleUnassignedRuleCall1Sub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedRuleCall1Sub = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2004:2: (iv_ruleUnassignedRuleCall1Sub= ruleUnassignedRuleCall1Sub EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2005:2: iv_ruleUnassignedRuleCall1Sub= ruleUnassignedRuleCall1Sub EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedRuleCall1SubRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall1Sub_in_entryRuleUnassignedRuleCall1Sub2792);
            iv_ruleUnassignedRuleCall1Sub=ruleUnassignedRuleCall1Sub();
            _fsp--;

             current =iv_ruleUnassignedRuleCall1Sub; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedRuleCall1Sub2802); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleUnassignedRuleCall1Sub


    // $ANTLR start ruleUnassignedRuleCall1Sub
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2012:1: ruleUnassignedRuleCall1Sub returns [EObject current=null] : ( (lv_val1_0_0= RULE_ID ) ) ;
    public final EObject ruleUnassignedRuleCall1Sub() throws RecognitionException {
        EObject current = null;

        Token lv_val1_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2017:6: ( ( (lv_val1_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2018:1: ( (lv_val1_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2018:1: ( (lv_val1_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2019:1: (lv_val1_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2019:1: (lv_val1_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2020:3: lv_val1_0_0= RULE_ID
            {
            lv_val1_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedRuleCall1Sub2843); 

            			createLeafNode(grammarAccess.getUnassignedRuleCall1SubAccess().getVal1IDTerminalRuleCall_0(), "val1"); 
            		

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
    // $ANTLR end ruleUnassignedRuleCall1Sub


    // $ANTLR start entryRuleUnassignedRuleCall2
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2050:1: entryRuleUnassignedRuleCall2 returns [EObject current=null] : iv_ruleUnassignedRuleCall2= ruleUnassignedRuleCall2 EOF ;
    public final EObject entryRuleUnassignedRuleCall2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedRuleCall2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2051:2: (iv_ruleUnassignedRuleCall2= ruleUnassignedRuleCall2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2052:2: iv_ruleUnassignedRuleCall2= ruleUnassignedRuleCall2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedRuleCall2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall2_in_entryRuleUnassignedRuleCall22883);
            iv_ruleUnassignedRuleCall2=ruleUnassignedRuleCall2();
            _fsp--;

             current =iv_ruleUnassignedRuleCall2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedRuleCall22893); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleUnassignedRuleCall2


    // $ANTLR start ruleUnassignedRuleCall2
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2059:1: ruleUnassignedRuleCall2 returns [EObject current=null] : ( '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final EObject ruleUnassignedRuleCall2() throws RecognitionException {
        EObject current = null;

        Token lv_val2_2_0=null;
        EObject this_UnassignedRuleCall2Sub_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2064:6: ( ( '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2065:1: ( '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2065:1: ( '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2065:3: '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) )
            {
            match(input,27,FollowSets000.FOLLOW_27_in_ruleUnassignedRuleCall22928); 

                    createLeafNode(grammarAccess.getUnassignedRuleCall2Access().getNumberSignDigitOneDigitTwoKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getUnassignedRuleCall2Access().getUnassignedRuleCall2SubParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall2Sub_in_ruleUnassignedRuleCall22950);
            this_UnassignedRuleCall2Sub_1=ruleUnassignedRuleCall2Sub();
            _fsp--;

             
                    current = this_UnassignedRuleCall2Sub_1; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2078:1: ( (lv_val2_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2079:1: (lv_val2_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2079:1: (lv_val2_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2080:3: lv_val2_2_0= RULE_ID
            {
            lv_val2_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedRuleCall22966); 

            			createLeafNode(grammarAccess.getUnassignedRuleCall2Access().getVal2IDTerminalRuleCall_2_0(), "val2"); 
            		

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
    // $ANTLR end ruleUnassignedRuleCall2


    // $ANTLR start entryRuleUnassignedRuleCall2Sub
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2110:1: entryRuleUnassignedRuleCall2Sub returns [EObject current=null] : iv_ruleUnassignedRuleCall2Sub= ruleUnassignedRuleCall2Sub EOF ;
    public final EObject entryRuleUnassignedRuleCall2Sub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedRuleCall2Sub = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2111:2: (iv_ruleUnassignedRuleCall2Sub= ruleUnassignedRuleCall2Sub EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2112:2: iv_ruleUnassignedRuleCall2Sub= ruleUnassignedRuleCall2Sub EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedRuleCall2SubRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall2Sub_in_entryRuleUnassignedRuleCall2Sub3007);
            iv_ruleUnassignedRuleCall2Sub=ruleUnassignedRuleCall2Sub();
            _fsp--;

             current =iv_ruleUnassignedRuleCall2Sub; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedRuleCall2Sub3017); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleUnassignedRuleCall2Sub


    // $ANTLR start ruleUnassignedRuleCall2Sub
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2119:1: ruleUnassignedRuleCall2Sub returns [EObject current=null] : () ;
    public final EObject ruleUnassignedRuleCall2Sub() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2124:6: ( () )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2125:1: ()
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2125:1: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2126:5: 
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
    // $ANTLR end ruleUnassignedRuleCall2Sub


    // $ANTLR start entryRuleCombination1
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2144:1: entryRuleCombination1 returns [EObject current=null] : iv_ruleCombination1= ruleCombination1 EOF ;
    public final EObject entryRuleCombination1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombination1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2145:2: (iv_ruleCombination1= ruleCombination1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2146:2: iv_ruleCombination1= ruleCombination1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCombination1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCombination1_in_entryRuleCombination13085);
            iv_ruleCombination1=ruleCombination1();
            _fsp--;

             current =iv_ruleCombination1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCombination13095); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleCombination1


    // $ANTLR start ruleCombination1
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2153:1: ruleCombination1 returns [EObject current=null] : ( '#13' ( (lv_val1_1_0= RULE_ID ) ) ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? ) ;
    public final EObject ruleCombination1() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_3_0=null;
        Token lv_val3_5_0=null;
        Token lv_val4_6_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2158:6: ( ( '#13' ( (lv_val1_1_0= RULE_ID ) ) ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2159:1: ( '#13' ( (lv_val1_1_0= RULE_ID ) ) ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2159:1: ( '#13' ( (lv_val1_1_0= RULE_ID ) ) ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2159:3: '#13' ( (lv_val1_1_0= RULE_ID ) ) ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )?
            {
            match(input,28,FollowSets000.FOLLOW_28_in_ruleCombination13130); 

                    createLeafNode(grammarAccess.getCombination1Access().getNumberSignDigitOneDigitThreeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2163:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2164:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2164:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2165:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination13147); 

            			createLeafNode(grammarAccess.getCombination1Access().getVal1IDTerminalRuleCall_1_0(), "val1"); 
            		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2187:2: ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==13) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2187:4: 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) )
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleCombination13163); 

                            createLeafNode(grammarAccess.getCombination1Access().getKw1Keyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2191:1: ( (lv_val2_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2192:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2192:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2193:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination13180); 

                    			createLeafNode(grammarAccess.getCombination1Access().getVal2IDTerminalRuleCall_2_1_0(), "val2"); 
                    		

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2215:2: ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) )
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
                            new NoViableAltException("2215:2: ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) )", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2215:3: ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2215:3: ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2215:5: 'kw2' ( (lv_val3_5_0= RULE_ID ) )
                            {
                            match(input,14,FollowSets000.FOLLOW_14_in_ruleCombination13197); 

                                    createLeafNode(grammarAccess.getCombination1Access().getKw2Keyword_2_2_0_0(), null); 
                                
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2219:1: ( (lv_val3_5_0= RULE_ID ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2220:1: (lv_val3_5_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2220:1: (lv_val3_5_0= RULE_ID )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2221:3: lv_val3_5_0= RULE_ID
                            {
                            lv_val3_5_0=(Token)input.LT(1);
                            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination13214); 

                            			createLeafNode(grammarAccess.getCombination1Access().getVal3IDTerminalRuleCall_2_2_0_1_0(), "val3"); 
                            		

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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2244:6: ( (lv_val4_6_0= RULE_ID ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2244:6: ( (lv_val4_6_0= RULE_ID ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2245:1: (lv_val4_6_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2245:1: (lv_val4_6_0= RULE_ID )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2246:3: lv_val4_6_0= RULE_ID
                            {
                            lv_val4_6_0=(Token)input.LT(1);
                            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination13243); 

                            			createLeafNode(grammarAccess.getCombination1Access().getVal4IDTerminalRuleCall_2_2_1_0(), "val4"); 
                            		

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
    // $ANTLR end ruleCombination1


    // $ANTLR start entryRuleCombination2
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2276:1: entryRuleCombination2 returns [EObject current=null] : iv_ruleCombination2= ruleCombination2 EOF ;
    public final EObject entryRuleCombination2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombination2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2277:2: (iv_ruleCombination2= ruleCombination2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2278:2: iv_ruleCombination2= ruleCombination2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCombination2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCombination2_in_entryRuleCombination23287);
            iv_ruleCombination2=ruleCombination2();
            _fsp--;

             current =iv_ruleCombination2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCombination23297); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleCombination2


    // $ANTLR start ruleCombination2
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2285:1: ruleCombination2 returns [EObject current=null] : ( '#14' ( (lv_val1_1_0= RULE_ID ) ) ( ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) ) ;
    public final EObject ruleCombination2() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_3_0=null;
        Token lv_val3_4_0=null;
        Token lv_val4_5_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2290:6: ( ( '#14' ( (lv_val1_1_0= RULE_ID ) ) ( ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2291:1: ( '#14' ( (lv_val1_1_0= RULE_ID ) ) ( ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2291:1: ( '#14' ( (lv_val1_1_0= RULE_ID ) ) ( ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2291:3: '#14' ( (lv_val1_1_0= RULE_ID ) ) ( ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* )
            {
            match(input,29,FollowSets000.FOLLOW_29_in_ruleCombination23332); 

                    createLeafNode(grammarAccess.getCombination2Access().getNumberSignDigitOneDigitFourKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2295:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2296:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2296:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2297:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination23349); 

            			createLeafNode(grammarAccess.getCombination2Access().getVal1IDTerminalRuleCall_1_0(), "val1"); 
            		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2319:2: ( ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* )
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
                    new NoViableAltException("2319:2: ( ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* )", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2319:3: ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2319:3: ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2319:5: 'kw1' ( (lv_val2_3_0= RULE_ID ) )
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleCombination23366); 

                            createLeafNode(grammarAccess.getCombination2Access().getKw1Keyword_2_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2323:1: ( (lv_val2_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2324:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2324:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2325:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination23383); 

                    			createLeafNode(grammarAccess.getCombination2Access().getVal2IDTerminalRuleCall_2_0_1_0(), "val2"); 
                    		

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2348:6: ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2348:6: ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==RULE_ID) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2348:7: ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2348:7: ( (lv_val3_4_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2349:1: (lv_val3_4_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2349:1: (lv_val3_4_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2350:3: lv_val3_4_0= RULE_ID
                    	    {
                    	    lv_val3_4_0=(Token)input.LT(1);
                    	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination23413); 

                    	    			createLeafNode(grammarAccess.getCombination2Access().getVal3IDTerminalRuleCall_2_1_0_0(), "val3"); 
                    	    		

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

                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2372:2: ( (lv_val4_5_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2373:1: (lv_val4_5_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2373:1: (lv_val4_5_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2374:3: lv_val4_5_0= RULE_ID
                    	    {
                    	    lv_val4_5_0=(Token)input.LT(1);
                    	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination23435); 

                    	    			createLeafNode(grammarAccess.getCombination2Access().getVal4IDTerminalRuleCall_2_1_1_0(), "val4"); 
                    	    		

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
    // $ANTLR end ruleCombination2


    // $ANTLR start entryRuleCombination3
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2404:1: entryRuleCombination3 returns [EObject current=null] : iv_ruleCombination3= ruleCombination3 EOF ;
    public final EObject entryRuleCombination3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombination3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2405:2: (iv_ruleCombination3= ruleCombination3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2406:2: iv_ruleCombination3= ruleCombination3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCombination3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCombination3_in_entryRuleCombination33479);
            iv_ruleCombination3=ruleCombination3();
            _fsp--;

             current =iv_ruleCombination3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCombination33489); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleCombination3


    // $ANTLR start ruleCombination3
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2413:1: ruleCombination3 returns [EObject current=null] : ( '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* ) ;
    public final EObject ruleCombination3() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;
        Token lv_val3_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2418:6: ( ( '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2419:1: ( '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2419:1: ( '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2419:3: '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )*
            {
            match(input,30,FollowSets000.FOLLOW_30_in_ruleCombination33524); 

                    createLeafNode(grammarAccess.getCombination3Access().getNumberSignDigitOneDigitFiveKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2423:1: ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2423:2: ( (lv_val1_1_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2423:2: ( (lv_val1_1_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2424:1: (lv_val1_1_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2424:1: (lv_val1_1_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2425:3: lv_val1_1_0= RULE_ID
            	    {
            	    lv_val1_1_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination33542); 

            	    			createLeafNode(grammarAccess.getCombination3Access().getVal1IDTerminalRuleCall_1_0_0(), "val1"); 
            	    		

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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2448:6: ( (lv_val2_2_0= RULE_INT ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2448:6: ( (lv_val2_2_0= RULE_INT ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2449:1: (lv_val2_2_0= RULE_INT )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2449:1: (lv_val2_2_0= RULE_INT )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2450:3: lv_val2_2_0= RULE_INT
            	    {
            	    lv_val2_2_0=(Token)input.LT(1);
            	    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleCombination33570); 

            	    			createLeafNode(grammarAccess.getCombination3Access().getVal2INTTerminalRuleCall_1_1_0(), "val2"); 
            	    		

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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2473:6: ( (lv_val3_3_0= RULE_STRING ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2473:6: ( (lv_val3_3_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2474:1: (lv_val3_3_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2474:1: (lv_val3_3_0= RULE_STRING )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2475:3: lv_val3_3_0= RULE_STRING
            	    {
            	    lv_val3_3_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCombination33598); 

            	    			createLeafNode(grammarAccess.getCombination3Access().getVal3STRINGTerminalRuleCall_1_2_0(), "val3"); 
            	    		

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
    // $ANTLR end ruleCombination3


    // $ANTLR start entryRuleCombination4
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2505:1: entryRuleCombination4 returns [EObject current=null] : iv_ruleCombination4= ruleCombination4 EOF ;
    public final EObject entryRuleCombination4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombination4 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2506:2: (iv_ruleCombination4= ruleCombination4 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2507:2: iv_ruleCombination4= ruleCombination4 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCombination4Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCombination4_in_entryRuleCombination43641);
            iv_ruleCombination4=ruleCombination4();
            _fsp--;

             current =iv_ruleCombination4; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCombination43651); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleCombination4


    // $ANTLR start ruleCombination4
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2514:1: ruleCombination4 returns [EObject current=null] : ( '#16' ( 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ ) ;
    public final EObject ruleCombination4() throws RecognitionException {
        EObject current = null;

        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;
        Token lv_val3_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2519:6: ( ( '#16' ( 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2520:1: ( '#16' ( 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2520:1: ( '#16' ( 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2520:3: '#16' ( 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+
            {
            match(input,31,FollowSets000.FOLLOW_31_in_ruleCombination43686); 

                    createLeafNode(grammarAccess.getCombination4Access().getNumberSignDigitOneDigitSixKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2524:1: ( 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2524:3: 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) )
            	    {
            	    match(input,32,FollowSets000.FOLLOW_32_in_ruleCombination43697); 

            	            createLeafNode(grammarAccess.getCombination4Access().getGroupKeyword_1_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2528:1: ( (lv_val1_2_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2529:1: (lv_val1_2_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2529:1: (lv_val1_2_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2530:3: lv_val1_2_0= RULE_ID
            	    {
            	    lv_val1_2_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination43714); 

            	    			createLeafNode(grammarAccess.getCombination4Access().getVal1IDTerminalRuleCall_1_1_0(), "val1"); 
            	    		

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

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2552:2: ( (lv_val2_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2553:1: (lv_val2_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2553:1: (lv_val2_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2554:3: lv_val2_3_0= RULE_ID
            	    {
            	    lv_val2_3_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination43736); 

            	    			createLeafNode(grammarAccess.getCombination4Access().getVal2IDTerminalRuleCall_1_2_0(), "val2"); 
            	    		

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

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2576:2: ( (lv_val3_4_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2577:1: (lv_val3_4_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2577:1: (lv_val3_4_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2578:3: lv_val3_4_0= RULE_ID
            	    {
            	    lv_val3_4_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination43758); 

            	    			createLeafNode(grammarAccess.getCombination4Access().getVal3IDTerminalRuleCall_1_3_0(), "val3"); 
            	    		

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
    // $ANTLR end ruleCombination4


    // $ANTLR start entryRuleList1
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2608:1: entryRuleList1 returns [EObject current=null] : iv_ruleList1= ruleList1 EOF ;
    public final EObject entryRuleList1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2609:2: (iv_ruleList1= ruleList1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2610:2: iv_ruleList1= ruleList1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getList1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleList1_in_entryRuleList13801);
            iv_ruleList1=ruleList1();
            _fsp--;

             current =iv_ruleList1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList13811); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleList1


    // $ANTLR start ruleList1
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2617:1: ruleList1 returns [EObject current=null] : ( '#17' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ;
    public final EObject ruleList1() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val1_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2622:6: ( ( '#17' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2623:1: ( '#17' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2623:1: ( '#17' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2623:3: '#17' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            {
            match(input,33,FollowSets000.FOLLOW_33_in_ruleList13846); 

                    createLeafNode(grammarAccess.getList1Access().getNumberSignDigitOneDigitSevenKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2627:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2628:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2628:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2629:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList13863); 

            			createLeafNode(grammarAccess.getList1Access().getVal1IDTerminalRuleCall_1_0(), "val1"); 
            		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2651:2: ( ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==34) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2651:4: ',' ( (lv_val1_3_0= RULE_ID ) )
            	    {
            	    match(input,34,FollowSets000.FOLLOW_34_in_ruleList13879); 

            	            createLeafNode(grammarAccess.getList1Access().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2655:1: ( (lv_val1_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2656:1: (lv_val1_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2656:1: (lv_val1_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2657:3: lv_val1_3_0= RULE_ID
            	    {
            	    lv_val1_3_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList13896); 

            	    			createLeafNode(grammarAccess.getList1Access().getVal1IDTerminalRuleCall_2_1_0(), "val1"); 
            	    		

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
    // $ANTLR end ruleList1


    // $ANTLR start entryRuleList2
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2687:1: entryRuleList2 returns [EObject current=null] : iv_ruleList2= ruleList2 EOF ;
    public final EObject entryRuleList2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2688:2: (iv_ruleList2= ruleList2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2689:2: iv_ruleList2= ruleList2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getList2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleList2_in_entryRuleList23939);
            iv_ruleList2=ruleList2();
            _fsp--;

             current =iv_ruleList2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList23949); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleList2


    // $ANTLR start ruleList2
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2696:1: ruleList2 returns [EObject current=null] : ( '#18' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? ) ;
    public final EObject ruleList2() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val1_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2701:6: ( ( '#18' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2702:1: ( '#18' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2702:1: ( '#18' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2702:3: '#18' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )?
            {
            match(input,35,FollowSets000.FOLLOW_35_in_ruleList23984); 

                    createLeafNode(grammarAccess.getList2Access().getNumberSignDigitOneDigitEightKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2706:1: ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2706:2: ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2706:2: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2707:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2707:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2708:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList24002); 

                    			createLeafNode(grammarAccess.getList2Access().getVal1IDTerminalRuleCall_1_0_0(), "val1"); 
                    		

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2730:2: ( ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==34) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2730:4: ',' ( (lv_val1_3_0= RULE_ID ) )
                    	    {
                    	    match(input,34,FollowSets000.FOLLOW_34_in_ruleList24018); 

                    	            createLeafNode(grammarAccess.getList2Access().getCommaKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2734:1: ( (lv_val1_3_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2735:1: (lv_val1_3_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2735:1: (lv_val1_3_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2736:3: lv_val1_3_0= RULE_ID
                    	    {
                    	    lv_val1_3_0=(Token)input.LT(1);
                    	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList24035); 

                    	    			createLeafNode(grammarAccess.getList2Access().getVal1IDTerminalRuleCall_1_1_1_0(), "val1"); 
                    	    		

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
    // $ANTLR end ruleList2


    // $ANTLR start entryRuleList3
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2766:1: entryRuleList3 returns [EObject current=null] : iv_ruleList3= ruleList3 EOF ;
    public final EObject entryRuleList3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2767:2: (iv_ruleList3= ruleList3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2768:2: iv_ruleList3= ruleList3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getList3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleList3_in_entryRuleList34080);
            iv_ruleList3=ruleList3();
            _fsp--;

             current =iv_ruleList3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList34090); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleList3


    // $ANTLR start ruleList3
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2775:1: ruleList3 returns [EObject current=null] : ( ( '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | ( 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) ) ;
    public final EObject ruleList3() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val1_3_0=null;
        Token lv_val2_5_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2780:6: ( ( ( '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | ( 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2781:1: ( ( '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | ( 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2781:1: ( ( '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | ( 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )
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
                    new NoViableAltException("2781:1: ( ( '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | ( 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2781:2: ( '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2781:2: ( '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2781:4: '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
                    {
                    match(input,36,FollowSets000.FOLLOW_36_in_ruleList34126); 

                            createLeafNode(grammarAccess.getList3Access().getNumberSignDigitOneDigitNineKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2785:1: ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2785:2: ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2785:2: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2786:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2786:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2787:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList34144); 

                    			createLeafNode(grammarAccess.getList3Access().getVal1IDTerminalRuleCall_0_1_0_0(), "val1"); 
                    		

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2809:2: ( ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==34) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2809:4: ',' ( (lv_val1_3_0= RULE_ID ) )
                    	    {
                    	    match(input,34,FollowSets000.FOLLOW_34_in_ruleList34160); 

                    	            createLeafNode(grammarAccess.getList3Access().getCommaKeyword_0_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2813:1: ( (lv_val1_3_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2814:1: (lv_val1_3_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2814:1: (lv_val1_3_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2815:3: lv_val1_3_0= RULE_ID
                    	    {
                    	    lv_val1_3_0=(Token)input.LT(1);
                    	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList34177); 

                    	    			createLeafNode(grammarAccess.getList3Access().getVal1IDTerminalRuleCall_0_1_1_1_0(), "val1"); 
                    	    		

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2838:6: ( 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2838:6: ( 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2838:8: 'kw3' ( (lv_val2_5_0= RULE_ID ) )
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleList34203); 

                            createLeafNode(grammarAccess.getList3Access().getKw3Keyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2842:1: ( (lv_val2_5_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2843:1: (lv_val2_5_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2843:1: (lv_val2_5_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2844:3: lv_val2_5_0= RULE_ID
                    {
                    lv_val2_5_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList34220); 

                    			createLeafNode(grammarAccess.getList3Access().getVal2IDTerminalRuleCall_1_1_0(), "val2"); 
                    		

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
    // $ANTLR end ruleList3


    // $ANTLR start entryRuleList4
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2874:1: entryRuleList4 returns [EObject current=null] : iv_ruleList4= ruleList4 EOF ;
    public final EObject entryRuleList4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList4 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2875:2: (iv_ruleList4= ruleList4 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2876:2: iv_ruleList4= ruleList4 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getList4Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleList4_in_entryRuleList44262);
            iv_ruleList4=ruleList4();
            _fsp--;

             current =iv_ruleList4; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList44272); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleList4


    // $ANTLR start ruleList4
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2883:1: ruleList4 returns [EObject current=null] : ( '#20' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) ;
    public final EObject ruleList4() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val1_3_0=null;
        Token lv_val2_5_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2888:6: ( ( '#20' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2889:1: ( '#20' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2889:1: ( '#20' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2889:3: '#20' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) )
            {
            match(input,37,FollowSets000.FOLLOW_37_in_ruleList44307); 

                    createLeafNode(grammarAccess.getList4Access().getNumberSignDigitTwoDigitZeroKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2893:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2894:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2894:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2895:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList44324); 

            			createLeafNode(grammarAccess.getList4Access().getVal1IDTerminalRuleCall_1_0(), "val1"); 
            		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2917:2: ( ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==34) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2917:4: ',' ( (lv_val1_3_0= RULE_ID ) )
            	    {
            	    match(input,34,FollowSets000.FOLLOW_34_in_ruleList44340); 

            	            createLeafNode(grammarAccess.getList4Access().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2921:1: ( (lv_val1_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2922:1: (lv_val1_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2922:1: (lv_val1_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2923:3: lv_val1_3_0= RULE_ID
            	    {
            	    lv_val1_3_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList44357); 

            	    			createLeafNode(grammarAccess.getList4Access().getVal1IDTerminalRuleCall_2_1_0(), "val1"); 
            	    		

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

            match(input,16,FollowSets000.FOLLOW_16_in_ruleList44374); 

                    createLeafNode(grammarAccess.getList4Access().getKw3Keyword_3(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2949:1: ( (lv_val2_5_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2950:1: (lv_val2_5_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2950:1: (lv_val2_5_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2951:3: lv_val2_5_0= RULE_ID
            {
            lv_val2_5_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList44391); 

            			createLeafNode(grammarAccess.getList4Access().getVal2IDTerminalRuleCall_4_0(), "val2"); 
            		

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
    // $ANTLR end ruleList4


    // $ANTLR start entryRuleList5
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2981:1: entryRuleList5 returns [EObject current=null] : iv_ruleList5= ruleList5 EOF ;
    public final EObject entryRuleList5() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList5 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2982:2: (iv_ruleList5= ruleList5 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2983:2: iv_ruleList5= ruleList5 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getList5Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleList5_in_entryRuleList54432);
            iv_ruleList5=ruleList5();
            _fsp--;

             current =iv_ruleList5; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList54442); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleList5


    // $ANTLR start ruleList5
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2990:1: ruleList5 returns [EObject current=null] : ( '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) ) ;
    public final EObject ruleList5() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val1_3_0=null;
        Token lv_val2_5_0=null;
        Token lv_val3_6_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2995:6: ( ( '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2996:1: ( '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2996:1: ( '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2996:3: '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) )
            {
            match(input,38,FollowSets000.FOLLOW_38_in_ruleList54477); 

                    createLeafNode(grammarAccess.getList5Access().getNumberSignDigitTwoDigitOneKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3000:1: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) )
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
                        new NoViableAltException("3000:1: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) )", 30, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3000:1: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) )", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3000:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3000:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3000:3: ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3000:3: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3001:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3001:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3002:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList54496); 

                    			createLeafNode(grammarAccess.getList5Access().getVal1IDTerminalRuleCall_1_0_0_0(), "val1"); 
                    		

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3024:2: ( ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==34) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3024:4: ',' ( (lv_val1_3_0= RULE_ID ) )
                    	    {
                    	    match(input,34,FollowSets000.FOLLOW_34_in_ruleList54512); 

                    	            createLeafNode(grammarAccess.getList5Access().getCommaKeyword_1_0_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3028:1: ( (lv_val1_3_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3029:1: (lv_val1_3_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3029:1: (lv_val1_3_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3030:3: lv_val1_3_0= RULE_ID
                    	    {
                    	    lv_val1_3_0=(Token)input.LT(1);
                    	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList54529); 

                    	    			createLeafNode(grammarAccess.getList5Access().getVal1IDTerminalRuleCall_1_0_1_1_0(), "val1"); 
                    	    		

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

                    match(input,16,FollowSets000.FOLLOW_16_in_ruleList54546); 

                            createLeafNode(grammarAccess.getList5Access().getKw3Keyword_1_0_2(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3056:1: ( (lv_val2_5_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3057:1: (lv_val2_5_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3057:1: (lv_val2_5_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3058:3: lv_val2_5_0= RULE_ID
                    {
                    lv_val2_5_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList54563); 

                    			createLeafNode(grammarAccess.getList5Access().getVal2IDTerminalRuleCall_1_0_3_0(), "val2"); 
                    		

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3081:6: ( (lv_val3_6_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3081:6: ( (lv_val3_6_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3082:1: (lv_val3_6_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3082:1: (lv_val3_6_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3083:3: lv_val3_6_0= RULE_ID
                    {
                    lv_val3_6_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList54592); 

                    			createLeafNode(grammarAccess.getList5Access().getVal3IDTerminalRuleCall_1_1_0(), "val3"); 
                    		

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
    // $ANTLR end ruleList5


    // $ANTLR start entryRuleAltList1
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3113:1: entryRuleAltList1 returns [EObject current=null] : iv_ruleAltList1= ruleAltList1 EOF ;
    public final EObject entryRuleAltList1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAltList1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3114:2: (iv_ruleAltList1= ruleAltList1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3115:2: iv_ruleAltList1= ruleAltList1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAltList1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAltList1_in_entryRuleAltList14634);
            iv_ruleAltList1=ruleAltList1();
            _fsp--;

             current =iv_ruleAltList1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAltList14644); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAltList1


    // $ANTLR start ruleAltList1
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3122:1: ruleAltList1 returns [EObject current=null] : ( '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) ;
    public final EObject ruleAltList1() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;
        Token lv_val1_4_0=null;
        Token lv_val3_5_0=null;
        Token lv_val1_7_0=null;
        Token lv_val4_8_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3127:6: ( ( '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3128:1: ( '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3128:1: ( '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3128:3: '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
            {
            match(input,39,FollowSets000.FOLLOW_39_in_ruleAltList14679); 

                    createLeafNode(grammarAccess.getAltList1Access().getNumberSignDigitTwoDigitTwoKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3132:1: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
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
                    new NoViableAltException("3132:1: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3132:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3132:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3132:3: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3132:3: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3133:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3133:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3134:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList14698); 

                    			createLeafNode(grammarAccess.getAltList1Access().getVal1IDTerminalRuleCall_1_0_0_0(), "val1"); 
                    		

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3156:2: ( (lv_val2_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3157:1: (lv_val2_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3157:1: (lv_val2_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3158:3: lv_val2_2_0= RULE_ID
                    {
                    lv_val2_2_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList14720); 

                    			createLeafNode(grammarAccess.getAltList1Access().getVal2IDTerminalRuleCall_1_0_1_0(), "val2"); 
                    		

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3181:6: ( 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3181:6: ( 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3181:8: 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) )
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleAltList14743); 

                            createLeafNode(grammarAccess.getAltList1Access().getKw1Keyword_1_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3185:1: ( (lv_val1_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3186:1: (lv_val1_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3186:1: (lv_val1_4_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3187:3: lv_val1_4_0= RULE_ID
                    {
                    lv_val1_4_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList14760); 

                    			createLeafNode(grammarAccess.getAltList1Access().getVal1IDTerminalRuleCall_1_1_1_0(), "val1"); 
                    		

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3209:2: ( (lv_val3_5_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3210:1: (lv_val3_5_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3210:1: (lv_val3_5_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3211:3: lv_val3_5_0= RULE_ID
                    {
                    lv_val3_5_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList14782); 

                    			createLeafNode(grammarAccess.getAltList1Access().getVal3IDTerminalRuleCall_1_1_2_0(), "val3"); 
                    		

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3234:6: ( 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3234:6: ( 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3234:8: 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )?
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleAltList14805); 

                            createLeafNode(grammarAccess.getAltList1Access().getKw2Keyword_1_2_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3238:1: ( (lv_val1_7_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3239:1: (lv_val1_7_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3239:1: (lv_val1_7_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3240:3: lv_val1_7_0= RULE_ID
                    {
                    lv_val1_7_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList14822); 

                    			createLeafNode(grammarAccess.getAltList1Access().getVal1IDTerminalRuleCall_1_2_1_0(), "val1"); 
                    		

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3262:2: ( (lv_val4_8_0= RULE_ID ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==RULE_ID) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3263:1: (lv_val4_8_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3263:1: (lv_val4_8_0= RULE_ID )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3264:3: lv_val4_8_0= RULE_ID
                            {
                            lv_val4_8_0=(Token)input.LT(1);
                            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList14844); 

                            			createLeafNode(grammarAccess.getAltList1Access().getVal4IDTerminalRuleCall_1_2_2_0(), "val4"); 
                            		

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
    // $ANTLR end ruleAltList1


    // $ANTLR start entryRuleAltList2
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3294:1: entryRuleAltList2 returns [EObject current=null] : iv_ruleAltList2= ruleAltList2 EOF ;
    public final EObject entryRuleAltList2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAltList2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3295:2: (iv_ruleAltList2= ruleAltList2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3296:2: iv_ruleAltList2= ruleAltList2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAltList2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAltList2_in_entryRuleAltList24888);
            iv_ruleAltList2=ruleAltList2();
            _fsp--;

             current =iv_ruleAltList2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAltList24898); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAltList2


    // $ANTLR start ruleAltList2
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3303:1: ruleAltList2 returns [EObject current=null] : ( '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw' ( (lv_val1_4_0= RULE_ID ) ) ( ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) ;
    public final EObject ruleAltList2() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;
        Token lv_val1_4_0=null;
        Token lv_val1_6_0=null;
        Token lv_val3_7_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3308:6: ( ( '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw' ( (lv_val1_4_0= RULE_ID ) ) ( ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3309:1: ( '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw' ( (lv_val1_4_0= RULE_ID ) ) ( ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3309:1: ( '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw' ( (lv_val1_4_0= RULE_ID ) ) ( ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3309:3: '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw' ( (lv_val1_4_0= RULE_ID ) ) ( ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
            {
            match(input,40,FollowSets000.FOLLOW_40_in_ruleAltList24933); 

                    createLeafNode(grammarAccess.getAltList2Access().getNumberSignDigitTwoDigitThreeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3313:1: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw' ( (lv_val1_4_0= RULE_ID ) ) ( ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
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
                    new NoViableAltException("3313:1: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw' ( (lv_val1_4_0= RULE_ID ) ) ( ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3313:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3313:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3313:3: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3313:3: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3314:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3314:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3315:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList24952); 

                    			createLeafNode(grammarAccess.getAltList2Access().getVal1IDTerminalRuleCall_1_0_0_0(), "val1"); 
                    		

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3337:2: ( (lv_val2_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3338:1: (lv_val2_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3338:1: (lv_val2_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3339:3: lv_val2_2_0= RULE_ID
                    {
                    lv_val2_2_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList24974); 

                    			createLeafNode(grammarAccess.getAltList2Access().getVal2IDTerminalRuleCall_1_0_1_0(), "val2"); 
                    		

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3362:6: ( 'kw' ( (lv_val1_4_0= RULE_ID ) ) ( ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3362:6: ( 'kw' ( (lv_val1_4_0= RULE_ID ) ) ( ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3362:8: 'kw' ( (lv_val1_4_0= RULE_ID ) ) ( ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) )
                    {
                    match(input,41,FollowSets000.FOLLOW_41_in_ruleAltList24997); 

                            createLeafNode(grammarAccess.getAltList2Access().getKwKeyword_1_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3366:1: ( (lv_val1_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3367:1: (lv_val1_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3367:1: (lv_val1_4_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3368:3: lv_val1_4_0= RULE_ID
                    {
                    lv_val1_4_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList25014); 

                    			createLeafNode(grammarAccess.getAltList2Access().getVal1IDTerminalRuleCall_1_1_1_0(), "val1"); 
                    		

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3390:2: ( ',' ( (lv_val1_6_0= RULE_ID ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==34) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3390:4: ',' ( (lv_val1_6_0= RULE_ID ) )
                    	    {
                    	    match(input,34,FollowSets000.FOLLOW_34_in_ruleAltList25030); 

                    	            createLeafNode(grammarAccess.getAltList2Access().getCommaKeyword_1_1_2_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3394:1: ( (lv_val1_6_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3395:1: (lv_val1_6_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3395:1: (lv_val1_6_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3396:3: lv_val1_6_0= RULE_ID
                    	    {
                    	    lv_val1_6_0=(Token)input.LT(1);
                    	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList25047); 

                    	    			createLeafNode(grammarAccess.getAltList2Access().getVal1IDTerminalRuleCall_1_1_2_1_0(), "val1"); 
                    	    		

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3418:4: ( (lv_val3_7_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3419:1: (lv_val3_7_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3419:1: (lv_val3_7_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3420:3: lv_val3_7_0= RULE_ID
                    {
                    lv_val3_7_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList25071); 

                    			createLeafNode(grammarAccess.getAltList2Access().getVal3IDTerminalRuleCall_1_1_3_0(), "val3"); 
                    		

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
    // $ANTLR end ruleAltList2


    // $ANTLR start entryRuleTransientObject
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3450:1: entryRuleTransientObject returns [EObject current=null] : iv_ruleTransientObject= ruleTransientObject EOF ;
    public final EObject entryRuleTransientObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransientObject = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3451:2: (iv_ruleTransientObject= ruleTransientObject EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3452:2: iv_ruleTransientObject= ruleTransientObject EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransientObjectRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTransientObject_in_entryRuleTransientObject5114);
            iv_ruleTransientObject=ruleTransientObject();
            _fsp--;

             current =iv_ruleTransientObject; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransientObject5124); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTransientObject


    // $ANTLR start ruleTransientObject
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3459:1: ruleTransientObject returns [EObject current=null] : ( '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? ) ;
    public final EObject ruleTransientObject() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        EObject lv_nested_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3464:6: ( ( '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3465:1: ( '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3465:1: ( '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3465:3: '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )?
            {
            match(input,42,FollowSets000.FOLLOW_42_in_ruleTransientObject5159); 

                    createLeafNode(grammarAccess.getTransientObjectAccess().getNumberSignDigitTwoDigitFourKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3469:1: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3469:2: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3469:2: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3470:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3470:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3471:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransientObject5177); 

                    			createLeafNode(grammarAccess.getTransientObjectAccess().getVal1IDTerminalRuleCall_1_0_0(), "val1"); 
                    		

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3493:2: ( (lv_nested_2_0= ruleTransientObjectSub ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3494:1: (lv_nested_2_0= ruleTransientObjectSub )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3494:1: (lv_nested_2_0= ruleTransientObjectSub )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3495:3: lv_nested_2_0= ruleTransientObjectSub
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTransientObjectAccess().getNestedTransientObjectSubParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTransientObjectSub_in_ruleTransientObject5203);
                    lv_nested_2_0=ruleTransientObjectSub();
                    _fsp--;


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
    // $ANTLR end ruleTransientObject


    // $ANTLR start entryRuleTransientObjectSub
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3525:1: entryRuleTransientObjectSub returns [EObject current=null] : iv_ruleTransientObjectSub= ruleTransientObjectSub EOF ;
    public final EObject entryRuleTransientObjectSub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransientObjectSub = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3526:2: (iv_ruleTransientObjectSub= ruleTransientObjectSub EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3527:2: iv_ruleTransientObjectSub= ruleTransientObjectSub EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransientObjectSubRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTransientObjectSub_in_entryRuleTransientObjectSub5241);
            iv_ruleTransientObjectSub=ruleTransientObjectSub();
            _fsp--;

             current =iv_ruleTransientObjectSub; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransientObjectSub5251); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTransientObjectSub


    // $ANTLR start ruleTransientObjectSub
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3534:1: ruleTransientObjectSub returns [EObject current=null] : ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) ) ;
    public final EObject ruleTransientObjectSub() throws RecognitionException {
        EObject current = null;

        Token lv_val2_0_0=null;
        Token lv_val3_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3539:6: ( ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3540:1: ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3540:1: ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3540:2: ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3540:2: ( (lv_val2_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3541:1: (lv_val2_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3541:1: (lv_val2_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3542:3: lv_val2_0_0= RULE_ID
            {
            lv_val2_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransientObjectSub5293); 

            			createLeafNode(grammarAccess.getTransientObjectSubAccess().getVal2IDTerminalRuleCall_0_0(), "val2"); 
            		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3564:2: ( (lv_val3_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3565:1: (lv_val3_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3565:1: (lv_val3_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3566:3: lv_val3_1_0= RULE_ID
            {
            lv_val3_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransientObjectSub5315); 

            			createLeafNode(grammarAccess.getTransientObjectSubAccess().getVal3IDTerminalRuleCall_1_0(), "val3"); 
            		

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
    // $ANTLR end ruleTransientObjectSub


    // $ANTLR start entryRuleTransientSerializeables1
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3596:1: entryRuleTransientSerializeables1 returns [EObject current=null] : iv_ruleTransientSerializeables1= ruleTransientSerializeables1 EOF ;
    public final EObject entryRuleTransientSerializeables1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransientSerializeables1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3597:2: (iv_ruleTransientSerializeables1= ruleTransientSerializeables1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3598:2: iv_ruleTransientSerializeables1= ruleTransientSerializeables1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransientSerializeables1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTransientSerializeables1_in_entryRuleTransientSerializeables15356);
            iv_ruleTransientSerializeables1=ruleTransientSerializeables1();
            _fsp--;

             current =iv_ruleTransientSerializeables1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransientSerializeables15366); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTransientSerializeables1


    // $ANTLR start ruleTransientSerializeables1
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3605:1: ruleTransientSerializeables1 returns [EObject current=null] : ( '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? ) ;
    public final EObject ruleTransientSerializeables1() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_3_0=null;
        Token lv_int1_4_0=null;
        Enumerator lv_enum1_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3610:6: ( ( '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3611:1: ( '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3611:1: ( '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3611:3: '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )?
            {
            match(input,43,FollowSets000.FOLLOW_43_in_ruleTransientSerializeables15401); 

                    createLeafNode(grammarAccess.getTransientSerializeables1Access().getNumberSignDigitTwoDigitFiveKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3615:1: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )?
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3615:2: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3615:2: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3616:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3616:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3617:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransientSerializeables15419); 

                    			createLeafNode(grammarAccess.getTransientSerializeables1Access().getVal1IDTerminalRuleCall_1_0_0(), "val1"); 
                    		

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3639:2: ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3640:1: (lv_enum1_2_0= ruleTransientSerializeables1Enum )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3640:1: (lv_enum1_2_0= ruleTransientSerializeables1Enum )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3641:3: lv_enum1_2_0= ruleTransientSerializeables1Enum
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTransientSerializeables1Access().getEnum1TransientSerializeables1EnumEnumRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTransientSerializeables1Enum_in_ruleTransientSerializeables15445);
                    lv_enum1_2_0=ruleTransientSerializeables1Enum();
                    _fsp--;


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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3663:4: ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3663:5: ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3663:5: ( (lv_val2_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3664:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3664:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3665:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransientSerializeables15465); 

                    			createLeafNode(grammarAccess.getTransientSerializeables1Access().getVal2IDTerminalRuleCall_2_0_0(), "val2"); 
                    		

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3687:2: ( (lv_int1_4_0= RULE_INT ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3688:1: (lv_int1_4_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3688:1: (lv_int1_4_0= RULE_INT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3689:3: lv_int1_4_0= RULE_INT
                    {
                    lv_int1_4_0=(Token)input.LT(1);
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTransientSerializeables15487); 

                    			createLeafNode(grammarAccess.getTransientSerializeables1Access().getInt1INTTerminalRuleCall_2_1_0(), "int1"); 
                    		

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
    // $ANTLR end ruleTransientSerializeables1


    // $ANTLR start entryRuleStaticSimplification
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3719:1: entryRuleStaticSimplification returns [EObject current=null] : iv_ruleStaticSimplification= ruleStaticSimplification EOF ;
    public final EObject entryRuleStaticSimplification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStaticSimplification = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3720:2: (iv_ruleStaticSimplification= ruleStaticSimplification EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3721:2: iv_ruleStaticSimplification= ruleStaticSimplification EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStaticSimplificationRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleStaticSimplification_in_entryRuleStaticSimplification5530);
            iv_ruleStaticSimplification=ruleStaticSimplification();
            _fsp--;

             current =iv_ruleStaticSimplification; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStaticSimplification5540); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleStaticSimplification


    // $ANTLR start ruleStaticSimplification
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3728:1: ruleStaticSimplification returns [EObject current=null] : ( '#26' ( 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) ( 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) ( 'kw3' ( 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) ) ;
    public final EObject ruleStaticSimplification() throws RecognitionException {
        EObject current = null;

        Token lv_val1_3_0=null;
        Token lv_val2_5_0=null;
        Token lv_val3_8_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3733:6: ( ( '#26' ( 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) ( 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) ( 'kw3' ( 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3734:1: ( '#26' ( 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) ( 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) ( 'kw3' ( 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3734:1: ( '#26' ( 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) ( 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) ( 'kw3' ( 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3734:3: '#26' ( 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) ) ( 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) ) ( 'kw3' ( 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? )
            {
            match(input,44,FollowSets000.FOLLOW_44_in_ruleStaticSimplification5575); 

                    createLeafNode(grammarAccess.getStaticSimplificationAccess().getNumberSignDigitTwoDigitSixKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3738:1: ( 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) )
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

                if ( (LA38_3==16) ) {
                    alt38=2;
                }
                else if ( (LA38_3==RULE_ID||LA38_3==14) ) {
                    alt38=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("3738:1: ( 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) )", 38, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3738:1: ( 'kw1' | () | ( (lv_val1_3_0= RULE_ID ) ) )", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3738:3: 'kw1'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleStaticSimplification5586); 

                            createLeafNode(grammarAccess.getStaticSimplificationAccess().getKw1Keyword_1_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3743:6: ()
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3743:6: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3744:5: 
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3755:6: ( (lv_val1_3_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3755:6: ( (lv_val1_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3756:1: (lv_val1_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3756:1: (lv_val1_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3757:3: lv_val1_3_0= RULE_ID
                    {
                    lv_val1_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleStaticSimplification5624); 

                    			createLeafNode(grammarAccess.getStaticSimplificationAccess().getVal1IDTerminalRuleCall_1_2_0(), "val1"); 
                    		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3779:3: ( 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) )
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
                    new NoViableAltException("3779:3: ( 'kw2' | ( (lv_val2_5_0= RULE_ID ) ) )", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3779:5: 'kw2'
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleStaticSimplification5641); 

                            createLeafNode(grammarAccess.getStaticSimplificationAccess().getKw2Keyword_2_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3784:6: ( (lv_val2_5_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3784:6: ( (lv_val2_5_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3785:1: (lv_val2_5_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3785:1: (lv_val2_5_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3786:3: lv_val2_5_0= RULE_ID
                    {
                    lv_val2_5_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleStaticSimplification5664); 

                    			createLeafNode(grammarAccess.getStaticSimplificationAccess().getVal2IDTerminalRuleCall_2_1_0(), "val2"); 
                    		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3808:3: ( 'kw3' ( 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3808:5: 'kw3' ( 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )?
            {
            match(input,16,FollowSets000.FOLLOW_16_in_ruleStaticSimplification5681); 

                    createLeafNode(grammarAccess.getStaticSimplificationAccess().getKw3Keyword_3_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3812:1: ( 'kw4' ( (lv_val3_8_0= RULE_ID ) )+ )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==19) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3812:3: 'kw4' ( (lv_val3_8_0= RULE_ID ) )+
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleStaticSimplification5692); 

                            createLeafNode(grammarAccess.getStaticSimplificationAccess().getKw4Keyword_3_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3816:1: ( (lv_val3_8_0= RULE_ID ) )+
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
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3817:1: (lv_val3_8_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3817:1: (lv_val3_8_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3818:3: lv_val3_8_0= RULE_ID
                    	    {
                    	    lv_val3_8_0=(Token)input.LT(1);
                    	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleStaticSimplification5709); 

                    	    			createLeafNode(grammarAccess.getStaticSimplificationAccess().getVal3IDTerminalRuleCall_3_1_1_0(), "val3"); 
                    	    		

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
    // $ANTLR end ruleStaticSimplification


    // $ANTLR start entryRuleTwoVersion
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3848:1: entryRuleTwoVersion returns [EObject current=null] : iv_ruleTwoVersion= ruleTwoVersion EOF ;
    public final EObject entryRuleTwoVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoVersion = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3849:2: (iv_ruleTwoVersion= ruleTwoVersion EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3850:2: iv_ruleTwoVersion= ruleTwoVersion EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTwoVersionRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTwoVersion_in_entryRuleTwoVersion5754);
            iv_ruleTwoVersion=ruleTwoVersion();
            _fsp--;

             current =iv_ruleTwoVersion; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTwoVersion5764); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTwoVersion


    // $ANTLR start ruleTwoVersion
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3857:1: ruleTwoVersion returns [EObject current=null] : ( '#27' (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 ) ) ;
    public final EObject ruleTwoVersion() throws RecognitionException {
        EObject current = null;

        EObject this_TwoVersionNo1_1 = null;

        EObject this_TwoVersionNo2_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3862:6: ( ( '#27' (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3863:1: ( '#27' (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3863:1: ( '#27' (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3863:3: '#27' (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 )
            {
            match(input,45,FollowSets000.FOLLOW_45_in_ruleTwoVersion5799); 

                    createLeafNode(grammarAccess.getTwoVersionAccess().getNumberSignDigitTwoDigitSevenKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3867:1: (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 48:
                    {
                    alt42=2;
                    }
                    break;
                case 46:
                    {
                    alt42=1;
                    }
                    break;
                case RULE_ID:
                    {
                    int LA42_4 = input.LA(3);

                    if ( (LA42_4==48) ) {
                        alt42=2;
                    }
                    else if ( (LA42_4==46) ) {
                        alt42=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("3867:1: (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 )", 42, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("3867:1: (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 )", 42, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3867:1: (this_TwoVersionNo1_1= ruleTwoVersionNo1 | this_TwoVersionNo2_2= ruleTwoVersionNo2 )", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3868:5: this_TwoVersionNo1_1= ruleTwoVersionNo1
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTwoVersionAccess().getTwoVersionNo1ParserRuleCall_1_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTwoVersionNo1_in_ruleTwoVersion5822);
                    this_TwoVersionNo1_1=ruleTwoVersionNo1();
                    _fsp--;

                     
                            current = this_TwoVersionNo1_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3878:5: this_TwoVersionNo2_2= ruleTwoVersionNo2
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTwoVersionAccess().getTwoVersionNo2ParserRuleCall_1_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTwoVersionNo2_in_ruleTwoVersion5849);
                    this_TwoVersionNo2_2=ruleTwoVersionNo2();
                    _fsp--;

                     
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
    // $ANTLR end ruleTwoVersion


    // $ANTLR start entryRuleTwoVersionNo1
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3894:1: entryRuleTwoVersionNo1 returns [EObject current=null] : iv_ruleTwoVersionNo1= ruleTwoVersionNo1 EOF ;
    public final EObject entryRuleTwoVersionNo1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoVersionNo1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3895:2: (iv_ruleTwoVersionNo1= ruleTwoVersionNo1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3896:2: iv_ruleTwoVersionNo1= ruleTwoVersionNo1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTwoVersionNo1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTwoVersionNo1_in_entryRuleTwoVersionNo15885);
            iv_ruleTwoVersionNo1=ruleTwoVersionNo1();
            _fsp--;

             current =iv_ruleTwoVersionNo1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTwoVersionNo15895); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTwoVersionNo1


    // $ANTLR start ruleTwoVersionNo1
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3903:1: ruleTwoVersionNo1 returns [EObject current=null] : ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? 'one' ( (lv_version1_6_0= RULE_ID ) )? ) ;
    public final EObject ruleTwoVersionNo1() throws RecognitionException {
        EObject current = null;

        Token lv_shared1_0_0=null;
        Token lv_shared2_1_0=null;
        Token lv_shared3_3_0=null;
        Token lv_shared3_4_0=null;
        Token lv_version1_6_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3908:6: ( ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? 'one' ( (lv_version1_6_0= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3909:1: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? 'one' ( (lv_version1_6_0= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3909:1: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? 'one' ( (lv_version1_6_0= RULE_ID ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3909:2: ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) 'short' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? 'one' ( (lv_version1_6_0= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3909:2: ( (lv_shared1_0_0= RULE_ID ) )?
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3910:1: (lv_shared1_0_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3910:1: (lv_shared1_0_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3911:3: lv_shared1_0_0= RULE_ID
                    {
                    lv_shared1_0_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo15937); 

                    			createLeafNode(grammarAccess.getTwoVersionNo1Access().getShared1IDTerminalRuleCall_0_0(), "shared1"); 
                    		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3933:3: ( (lv_shared2_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3934:1: (lv_shared2_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3934:1: (lv_shared2_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3935:3: lv_shared2_1_0= RULE_ID
            {
            lv_shared2_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo15960); 

            			createLeafNode(grammarAccess.getTwoVersionNo1Access().getShared2IDTerminalRuleCall_1_0(), "shared2"); 
            		

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

            match(input,46,FollowSets000.FOLLOW_46_in_ruleTwoVersionNo15975); 

                    createLeafNode(grammarAccess.getTwoVersionNo1Access().getShortKeyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3961:1: ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3961:2: ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3961:2: ( (lv_shared3_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3962:1: (lv_shared3_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3962:1: (lv_shared3_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3963:3: lv_shared3_3_0= RULE_ID
                    {
                    lv_shared3_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo15993); 

                    			createLeafNode(grammarAccess.getTwoVersionNo1Access().getShared3IDTerminalRuleCall_3_0_0(), "shared3"); 
                    		

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3985:2: ( (lv_shared3_4_0= RULE_ID ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==RULE_ID) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3986:1: (lv_shared3_4_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3986:1: (lv_shared3_4_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3987:3: lv_shared3_4_0= RULE_ID
                    	    {
                    	    lv_shared3_4_0=(Token)input.LT(1);
                    	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo16015); 

                    	    			createLeafNode(grammarAccess.getTwoVersionNo1Access().getShared3IDTerminalRuleCall_3_1_0(), "shared3"); 
                    	    		

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

            match(input,47,FollowSets000.FOLLOW_47_in_ruleTwoVersionNo16033); 

                    createLeafNode(grammarAccess.getTwoVersionNo1Access().getOneKeyword_4(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4013:1: ( (lv_version1_6_0= RULE_ID ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ID) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4014:1: (lv_version1_6_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4014:1: (lv_version1_6_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4015:3: lv_version1_6_0= RULE_ID
                    {
                    lv_version1_6_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo16050); 

                    			createLeafNode(grammarAccess.getTwoVersionNo1Access().getVersion1IDTerminalRuleCall_5_0(), "version1"); 
                    		

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
    // $ANTLR end ruleTwoVersionNo1


    // $ANTLR start entryRuleTwoVersionNo2
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4045:1: entryRuleTwoVersionNo2 returns [EObject current=null] : iv_ruleTwoVersionNo2= ruleTwoVersionNo2 EOF ;
    public final EObject entryRuleTwoVersionNo2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoVersionNo2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4046:2: (iv_ruleTwoVersionNo2= ruleTwoVersionNo2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4047:2: iv_ruleTwoVersionNo2= ruleTwoVersionNo2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTwoVersionNo2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTwoVersionNo2_in_entryRuleTwoVersionNo26092);
            iv_ruleTwoVersionNo2=ruleTwoVersionNo2();
            _fsp--;

             current =iv_ruleTwoVersionNo2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTwoVersionNo26102); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTwoVersionNo2


    // $ANTLR start ruleTwoVersionNo2
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4054:1: ruleTwoVersionNo2 returns [EObject current=null] : ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | ( 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? ) ;
    public final EObject ruleTwoVersionNo2() throws RecognitionException {
        EObject current = null;

        Token lv_shared1_0_0=null;
        Token lv_shared2_1_0=null;
        Token lv_shared3_3_0=null;
        Token lv_shared3_4_0=null;
        Token lv_extra1_6_0=null;
        Token lv_extra2_7_0=null;
        Token lv_extra3_8_0=null;
        Token lv_extra4_10_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4059:6: ( ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | ( 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4060:1: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | ( 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4060:1: ( ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | ( 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4060:2: ( (lv_shared1_0_0= RULE_ID ) )? ( (lv_shared2_1_0= RULE_ID ) ) 'long' ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )? 'extra' ( (lv_extra1_6_0= RULE_ID ) )? ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | ( 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4060:2: ( (lv_shared1_0_0= RULE_ID ) )?
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4061:1: (lv_shared1_0_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4061:1: (lv_shared1_0_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4062:3: lv_shared1_0_0= RULE_ID
                    {
                    lv_shared1_0_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo26144); 

                    			createLeafNode(grammarAccess.getTwoVersionNo2Access().getShared1IDTerminalRuleCall_0_0(), "shared1"); 
                    		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4084:3: ( (lv_shared2_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4085:1: (lv_shared2_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4085:1: (lv_shared2_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4086:3: lv_shared2_1_0= RULE_ID
            {
            lv_shared2_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo26167); 

            			createLeafNode(grammarAccess.getTwoVersionNo2Access().getShared2IDTerminalRuleCall_1_0(), "shared2"); 
            		

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

            match(input,48,FollowSets000.FOLLOW_48_in_ruleTwoVersionNo26182); 

                    createLeafNode(grammarAccess.getTwoVersionNo2Access().getLongKeyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4112:1: ( ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )* )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_ID) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4112:2: ( (lv_shared3_3_0= RULE_ID ) ) ( (lv_shared3_4_0= RULE_ID ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4112:2: ( (lv_shared3_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4113:1: (lv_shared3_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4113:1: (lv_shared3_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4114:3: lv_shared3_3_0= RULE_ID
                    {
                    lv_shared3_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo26200); 

                    			createLeafNode(grammarAccess.getTwoVersionNo2Access().getShared3IDTerminalRuleCall_3_0_0(), "shared3"); 
                    		

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4136:2: ( (lv_shared3_4_0= RULE_ID ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==RULE_ID) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4137:1: (lv_shared3_4_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4137:1: (lv_shared3_4_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4138:3: lv_shared3_4_0= RULE_ID
                    	    {
                    	    lv_shared3_4_0=(Token)input.LT(1);
                    	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo26222); 

                    	    			createLeafNode(grammarAccess.getTwoVersionNo2Access().getShared3IDTerminalRuleCall_3_1_0(), "shared3"); 
                    	    		

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

            match(input,49,FollowSets000.FOLLOW_49_in_ruleTwoVersionNo26240); 

                    createLeafNode(grammarAccess.getTwoVersionNo2Access().getExtraKeyword_4(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4164:1: ( (lv_extra1_6_0= RULE_ID ) )?
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4165:1: (lv_extra1_6_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4165:1: (lv_extra1_6_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4166:3: lv_extra1_6_0= RULE_ID
                    {
                    lv_extra1_6_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo26257); 

                    			createLeafNode(grammarAccess.getTwoVersionNo2Access().getExtra1IDTerminalRuleCall_5_0(), "extra1"); 
                    		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4188:3: ( ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) ) | ( 'two' ( (lv_extra4_10_0= RULE_ID ) ) ) )?
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4188:4: ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4188:4: ( ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4188:5: ( (lv_extra2_7_0= RULE_ID ) ) ( (lv_extra3_8_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4188:5: ( (lv_extra2_7_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4189:1: (lv_extra2_7_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4189:1: (lv_extra2_7_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4190:3: lv_extra2_7_0= RULE_ID
                    {
                    lv_extra2_7_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo26282); 

                    			createLeafNode(grammarAccess.getTwoVersionNo2Access().getExtra2IDTerminalRuleCall_6_0_0_0(), "extra2"); 
                    		

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4212:2: ( (lv_extra3_8_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4213:1: (lv_extra3_8_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4213:1: (lv_extra3_8_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4214:3: lv_extra3_8_0= RULE_ID
                    {
                    lv_extra3_8_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo26304); 

                    			createLeafNode(grammarAccess.getTwoVersionNo2Access().getExtra3IDTerminalRuleCall_6_0_1_0(), "extra3"); 
                    		

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4237:6: ( 'two' ( (lv_extra4_10_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4237:6: ( 'two' ( (lv_extra4_10_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4237:8: 'two' ( (lv_extra4_10_0= RULE_ID ) )
                    {
                    match(input,50,FollowSets000.FOLLOW_50_in_ruleTwoVersionNo26327); 

                            createLeafNode(grammarAccess.getTwoVersionNo2Access().getTwoKeyword_6_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4241:1: ( (lv_extra4_10_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4242:1: (lv_extra4_10_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4242:1: (lv_extra4_10_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4243:3: lv_extra4_10_0= RULE_ID
                    {
                    lv_extra4_10_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoVersionNo26344); 

                    			createLeafNode(grammarAccess.getTwoVersionNo2Access().getExtra4IDTerminalRuleCall_6_1_1_0(), "extra4"); 
                    		

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
    // $ANTLR end ruleTwoVersionNo2


    // $ANTLR start entryRuleHeuristic1
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4273:1: entryRuleHeuristic1 returns [EObject current=null] : iv_ruleHeuristic1= ruleHeuristic1 EOF ;
    public final EObject entryRuleHeuristic1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHeuristic1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4274:2: (iv_ruleHeuristic1= ruleHeuristic1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4275:2: iv_ruleHeuristic1= ruleHeuristic1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getHeuristic1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleHeuristic1_in_entryRuleHeuristic16388);
            iv_ruleHeuristic1=ruleHeuristic1();
            _fsp--;

             current =iv_ruleHeuristic1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleHeuristic16398); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleHeuristic1


    // $ANTLR start ruleHeuristic1
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4282:1: ruleHeuristic1 returns [EObject current=null] : ( '#28' ( 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* ( 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* ( 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* ) ;
    public final EObject ruleHeuristic1() throws RecognitionException {
        EObject current = null;

        Token lv_a_2_0=null;
        Token lv_b_3_0=null;
        Token lv_a_5_0=null;
        Token lv_c_6_0=null;
        Token lv_b_8_0=null;
        Token lv_c_9_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4287:6: ( ( '#28' ( 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* ( 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* ( 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4288:1: ( '#28' ( 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* ( 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* ( 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4288:1: ( '#28' ( 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* ( 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* ( 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4288:3: '#28' ( 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )* ( 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )* ( 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )*
            {
            match(input,51,FollowSets000.FOLLOW_51_in_ruleHeuristic16433); 

                    createLeafNode(grammarAccess.getHeuristic1Access().getNumberSignDigitTwoDigitEightKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4292:1: ( 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==13) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4292:3: 'kw1' ( (lv_a_2_0= RULE_ID ) ) ( (lv_b_3_0= RULE_ID ) )
            	    {
            	    match(input,13,FollowSets000.FOLLOW_13_in_ruleHeuristic16444); 

            	            createLeafNode(grammarAccess.getHeuristic1Access().getKw1Keyword_1_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4296:1: ( (lv_a_2_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4297:1: (lv_a_2_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4297:1: (lv_a_2_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4298:3: lv_a_2_0= RULE_ID
            	    {
            	    lv_a_2_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleHeuristic16461); 

            	    			createLeafNode(grammarAccess.getHeuristic1Access().getAIDTerminalRuleCall_1_1_0(), "a"); 
            	    		

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

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4320:2: ( (lv_b_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4321:1: (lv_b_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4321:1: (lv_b_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4322:3: lv_b_3_0= RULE_ID
            	    {
            	    lv_b_3_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleHeuristic16483); 

            	    			createLeafNode(grammarAccess.getHeuristic1Access().getBIDTerminalRuleCall_1_2_0(), "b"); 
            	    		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4344:4: ( 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==14) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4344:6: 'kw2' ( (lv_a_5_0= RULE_ID ) ) ( (lv_c_6_0= RULE_ID ) )
            	    {
            	    match(input,14,FollowSets000.FOLLOW_14_in_ruleHeuristic16501); 

            	            createLeafNode(grammarAccess.getHeuristic1Access().getKw2Keyword_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4348:1: ( (lv_a_5_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4349:1: (lv_a_5_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4349:1: (lv_a_5_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4350:3: lv_a_5_0= RULE_ID
            	    {
            	    lv_a_5_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleHeuristic16518); 

            	    			createLeafNode(grammarAccess.getHeuristic1Access().getAIDTerminalRuleCall_2_1_0(), "a"); 
            	    		

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

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4372:2: ( (lv_c_6_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4373:1: (lv_c_6_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4373:1: (lv_c_6_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4374:3: lv_c_6_0= RULE_ID
            	    {
            	    lv_c_6_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleHeuristic16540); 

            	    			createLeafNode(grammarAccess.getHeuristic1Access().getCIDTerminalRuleCall_2_2_0(), "c"); 
            	    		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4396:4: ( 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==16) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4396:6: 'kw3' ( (lv_b_8_0= RULE_ID ) ) ( (lv_c_9_0= RULE_ID ) )
            	    {
            	    match(input,16,FollowSets000.FOLLOW_16_in_ruleHeuristic16558); 

            	            createLeafNode(grammarAccess.getHeuristic1Access().getKw3Keyword_3_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4400:1: ( (lv_b_8_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4401:1: (lv_b_8_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4401:1: (lv_b_8_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4402:3: lv_b_8_0= RULE_ID
            	    {
            	    lv_b_8_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleHeuristic16575); 

            	    			createLeafNode(grammarAccess.getHeuristic1Access().getBIDTerminalRuleCall_3_1_0(), "b"); 
            	    		

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

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4424:2: ( (lv_c_9_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4425:1: (lv_c_9_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4425:1: (lv_c_9_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4426:3: lv_c_9_0= RULE_ID
            	    {
            	    lv_c_9_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleHeuristic16597); 

            	    			createLeafNode(grammarAccess.getHeuristic1Access().getCIDTerminalRuleCall_3_2_0(), "c"); 
            	    		

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
    // $ANTLR end ruleHeuristic1


    // $ANTLR start ruleTransientSerializeables1Enum
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4456:1: ruleTransientSerializeables1Enum returns [Enumerator current=null] : ( ( 'lit1' ) | ( 'lit2' ) ) ;
    public final Enumerator ruleTransientSerializeables1Enum() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4460:6: ( ( ( 'lit1' ) | ( 'lit2' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4461:1: ( ( 'lit1' ) | ( 'lit2' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4461:1: ( ( 'lit1' ) | ( 'lit2' ) )
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
                    new NoViableAltException("4461:1: ( ( 'lit1' ) | ( 'lit2' ) )", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4461:2: ( 'lit1' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4461:2: ( 'lit1' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4461:4: 'lit1'
                    {
                    match(input,52,FollowSets000.FOLLOW_52_in_ruleTransientSerializeables1Enum6652); 

                            current = grammarAccess.getTransientSerializeables1EnumAccess().getLit1EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTransientSerializeables1EnumAccess().getLit1EnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4467:6: ( 'lit2' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4467:6: ( 'lit2' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:4467:8: 'lit2'
                    {
                    match(input,53,FollowSets000.FOLLOW_53_in_ruleTransientSerializeables1Enum6667); 

                            current = grammarAccess.getTransientSerializeables1EnumAccess().getLit2EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTransientSerializeables1EnumAccess().getLit2EnumLiteralDeclaration_1(), null); 
                        

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
    // $ANTLR end ruleTransientSerializeables1Enum


 

    
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
        public static final BitSet FOLLOW_11_in_ruleSimpleGroup941 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleGroup958 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleGroup980 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleAlternative_in_entryRuleSimpleAlternative1021 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleAlternative1031 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleSimpleAlternative1066 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_13_in_ruleSimpleAlternative1078 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAlternative1095 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleSimpleAlternative1118 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAlternative1135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleMultiplicities_in_entryRuleSimpleMultiplicities1178 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleMultiplicities1188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleSimpleMultiplicities1223 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1240 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleSimpleMultiplicities1255 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1272 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleSimpleMultiplicities1288 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1305 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_16_in_ruleSimpleMultiplicities1321 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1338 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleGroupMultiplicities_in_entryRuleGroupMultiplicities1380 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroupMultiplicities1390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleGroupMultiplicities1425 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1442 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleGroupMultiplicities1457 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1475 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1497 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleGroupMultiplicities1514 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1532 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1554 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_16_in_ruleGroupMultiplicities1571 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1589 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1611 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleAlternativeMultiplicities_in_entryRuleAlternativeMultiplicities1654 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlternativeMultiplicities1664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleAlternativeMultiplicities1699 = new BitSet(new long[]{0x0000000000006010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1717 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_13_in_ruleAlternativeMultiplicities1739 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1756 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleAlternativeMultiplicities1774 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1792 = new BitSet(new long[]{0x0000000000090010L});
        public static final BitSet FOLLOW_16_in_ruleAlternativeMultiplicities1814 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1831 = new BitSet(new long[]{0x0000000000090010L});
        public static final BitSet FOLLOW_19_in_ruleAlternativeMultiplicities1849 = new BitSet(new long[]{0x0000000000100012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1867 = new BitSet(new long[]{0x0000000000100012L});
        public static final BitSet FOLLOW_20_in_ruleAlternativeMultiplicities1889 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1906 = new BitSet(new long[]{0x0000000000100012L});
        public static final BitSet FOLLOW_ruleAssignedAction_in_entryRuleAssignedAction1950 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignedAction1960 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleAssignedAction1995 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignedAction2012 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignedAction2044 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleAssignedActionSecond_in_entryRuleAssignedActionSecond2087 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignedActionSecond2097 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleAssignedActionSecond2132 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignedActionSecond2149 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleAssignedActionSecond2164 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignedActionSecond2181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedAction1_in_entryRuleUnassignedAction12222 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedAction12232 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleUnassignedAction12276 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction12293 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction12315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedAction2_in_entryRuleUnassignedAction22357 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedAction22367 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleUnassignedAction22411 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction22428 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction22450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedAction3_in_entryRuleUnassignedAction32492 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedAction32502 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleUnassignedAction32537 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_13_in_ruleUnassignedAction32549 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_14_in_ruleUnassignedAction32576 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction32604 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction32626 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall1_in_entryRuleUnassignedRuleCall12668 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedRuleCall12678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleUnassignedRuleCall12713 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall1Sub_in_ruleUnassignedRuleCall12735 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedRuleCall12751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall1Sub_in_entryRuleUnassignedRuleCall1Sub2792 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedRuleCall1Sub2802 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedRuleCall1Sub2843 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall2_in_entryRuleUnassignedRuleCall22883 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedRuleCall22893 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleUnassignedRuleCall22928 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall2Sub_in_ruleUnassignedRuleCall22950 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedRuleCall22966 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall2Sub_in_entryRuleUnassignedRuleCall2Sub3007 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedRuleCall2Sub3017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCombination1_in_entryRuleCombination13085 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCombination13095 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleCombination13130 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination13147 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleCombination13163 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination13180 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_14_in_ruleCombination13197 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination13214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination13243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCombination2_in_entryRuleCombination23287 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCombination23297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleCombination23332 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination23349 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_13_in_ruleCombination23366 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination23383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination23413 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination23435 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleCombination3_in_entryRuleCombination33479 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCombination33489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleCombination33524 = new BitSet(new long[]{0x0000000000000072L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination33542 = new BitSet(new long[]{0x0000000000000072L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleCombination33570 = new BitSet(new long[]{0x0000000000000072L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCombination33598 = new BitSet(new long[]{0x0000000000000072L});
        public static final BitSet FOLLOW_ruleCombination4_in_entryRuleCombination43641 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCombination43651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleCombination43686 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleCombination43697 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination43714 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination43736 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination43758 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_ruleList1_in_entryRuleList13801 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList13811 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleList13846 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList13863 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_ruleList13879 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList13896 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_ruleList2_in_entryRuleList23939 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList23949 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleList23984 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList24002 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_ruleList24018 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList24035 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_ruleList3_in_entryRuleList34080 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList34090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleList34126 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList34144 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_ruleList34160 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList34177 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_16_in_ruleList34203 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList34220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleList4_in_entryRuleList44262 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList44272 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleList44307 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList44324 = new BitSet(new long[]{0x0000000400010000L});
        public static final BitSet FOLLOW_34_in_ruleList44340 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList44357 = new BitSet(new long[]{0x0000000400010000L});
        public static final BitSet FOLLOW_16_in_ruleList44374 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList44391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleList5_in_entryRuleList54432 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList54442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleList54477 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList54496 = new BitSet(new long[]{0x0000000400010000L});
        public static final BitSet FOLLOW_34_in_ruleList54512 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList54529 = new BitSet(new long[]{0x0000000400010000L});
        public static final BitSet FOLLOW_16_in_ruleList54546 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList54563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList54592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAltList1_in_entryRuleAltList14634 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAltList14644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleAltList14679 = new BitSet(new long[]{0x0000000000006010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList14698 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList14720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleAltList14743 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList14760 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList14782 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleAltList14805 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList14822 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList14844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAltList2_in_entryRuleAltList24888 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAltList24898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleAltList24933 = new BitSet(new long[]{0x0000020000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList24952 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList24974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleAltList24997 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList25014 = new BitSet(new long[]{0x0000000400000010L});
        public static final BitSet FOLLOW_34_in_ruleAltList25030 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList25047 = new BitSet(new long[]{0x0000000400000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList25071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransientObject_in_entryRuleTransientObject5114 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransientObject5124 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleTransientObject5159 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransientObject5177 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTransientObjectSub_in_ruleTransientObject5203 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransientObjectSub_in_entryRuleTransientObjectSub5241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransientObjectSub5251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransientObjectSub5293 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransientObjectSub5315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransientSerializeables1_in_entryRuleTransientSerializeables15356 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransientSerializeables15366 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleTransientSerializeables15401 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransientSerializeables15419 = new BitSet(new long[]{0x0030000000000000L});
        public static final BitSet FOLLOW_ruleTransientSerializeables1Enum_in_ruleTransientSerializeables15445 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransientSerializeables15465 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTransientSerializeables15487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStaticSimplification_in_entryRuleStaticSimplification5530 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStaticSimplification5540 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleStaticSimplification5575 = new BitSet(new long[]{0x0000000000006010L});
        public static final BitSet FOLLOW_13_in_ruleStaticSimplification5586 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleStaticSimplification5624 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_14_in_ruleStaticSimplification5641 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleStaticSimplification5664 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleStaticSimplification5681 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleStaticSimplification5692 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleStaticSimplification5709 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleTwoVersion_in_entryRuleTwoVersion5754 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTwoVersion5764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleTwoVersion5799 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTwoVersionNo1_in_ruleTwoVersion5822 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoVersionNo2_in_ruleTwoVersion5849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoVersionNo1_in_entryRuleTwoVersionNo15885 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTwoVersionNo15895 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo15937 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo15960 = new BitSet(new long[]{0x0000400000000000L});
        public static final BitSet FOLLOW_46_in_ruleTwoVersionNo15975 = new BitSet(new long[]{0x0000800000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo15993 = new BitSet(new long[]{0x0000800000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo16015 = new BitSet(new long[]{0x0000800000000010L});
        public static final BitSet FOLLOW_47_in_ruleTwoVersionNo16033 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo16050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoVersionNo2_in_entryRuleTwoVersionNo26092 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTwoVersionNo26102 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo26144 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo26167 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleTwoVersionNo26182 = new BitSet(new long[]{0x0002000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo26200 = new BitSet(new long[]{0x0002000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo26222 = new BitSet(new long[]{0x0002000000000010L});
        public static final BitSet FOLLOW_49_in_ruleTwoVersionNo26240 = new BitSet(new long[]{0x0004000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo26257 = new BitSet(new long[]{0x0004000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo26282 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo26304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleTwoVersionNo26327 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoVersionNo26344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHeuristic1_in_entryRuleHeuristic16388 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleHeuristic16398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleHeuristic16433 = new BitSet(new long[]{0x0000000000016002L});
        public static final BitSet FOLLOW_13_in_ruleHeuristic16444 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleHeuristic16461 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleHeuristic16483 = new BitSet(new long[]{0x0000000000016002L});
        public static final BitSet FOLLOW_14_in_ruleHeuristic16501 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleHeuristic16518 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleHeuristic16540 = new BitSet(new long[]{0x0000000000014002L});
        public static final BitSet FOLLOW_16_in_ruleHeuristic16558 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleHeuristic16575 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleHeuristic16597 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_52_in_ruleTransientSerializeables1Enum6652 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleTransientSerializeables1Enum6667 = new BitSet(new long[]{0x0000000000000002L});
    }


}