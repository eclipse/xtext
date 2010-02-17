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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'#2'", "'kw1'", "'kw2'", "'#3'", "'kw3'", "'#4'", "'#5'", "'kw4'", "'kw5'", "'#6'", "'#7'", "'#8'", "'#9'", "'#10'", "'#11'", "'#12'", "'#13'", "'#14'", "'#15'", "'#16'", "'group'", "'#17'", "','", "'#18'", "'#19'", "'#20'", "'#21'", "'#22'", "'#23'", "'kw'", "'#24'", "'#25'", "'lit1'", "'lit2'"
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



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:73:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:74:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:75:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:82:1: ruleModel returns [EObject current=null] : ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) ) ;
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


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:87:6: ( ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:88:1: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:88:1: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) )
            int alt1=25;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("88:1: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) | ( (lv_x20_19_0= ruleList4 ) ) | ( (lv_x21_20_0= ruleList5 ) ) | ( (lv_x22_21_0= ruleAltList1 ) ) | ( (lv_x23_22_0= ruleAltList2 ) ) | ( (lv_x24_23_0= ruleTransientObject ) ) | ( (lv_x25_24_0= ruleTransientSerializeables1 ) ) )", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:88:2: ( (lv_x1_0_0= ruleSimpleGroup ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:88:2: ( (lv_x1_0_0= ruleSimpleGroup ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:89:1: (lv_x1_0_0= ruleSimpleGroup )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:89:1: (lv_x1_0_0= ruleSimpleGroup )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:90:3: lv_x1_0_0= ruleSimpleGroup
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:113:6: ( (lv_x2_1_0= ruleSimpleAlternative ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:113:6: ( (lv_x2_1_0= ruleSimpleAlternative ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:114:1: (lv_x2_1_0= ruleSimpleAlternative )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:114:1: (lv_x2_1_0= ruleSimpleAlternative )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:115:3: lv_x2_1_0= ruleSimpleAlternative
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:138:6: ( (lv_x3_2_0= ruleSimpleMultiplicities ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:138:6: ( (lv_x3_2_0= ruleSimpleMultiplicities ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:139:1: (lv_x3_2_0= ruleSimpleMultiplicities )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:139:1: (lv_x3_2_0= ruleSimpleMultiplicities )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:140:3: lv_x3_2_0= ruleSimpleMultiplicities
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:163:6: ( (lv_x4_3_0= ruleGroupMultiplicities ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:163:6: ( (lv_x4_3_0= ruleGroupMultiplicities ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:164:1: (lv_x4_3_0= ruleGroupMultiplicities )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:164:1: (lv_x4_3_0= ruleGroupMultiplicities )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:165:3: lv_x4_3_0= ruleGroupMultiplicities
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:188:6: ( (lv_x5_4_0= ruleAlternativeMultiplicities ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:188:6: ( (lv_x5_4_0= ruleAlternativeMultiplicities ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:189:1: (lv_x5_4_0= ruleAlternativeMultiplicities )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:189:1: (lv_x5_4_0= ruleAlternativeMultiplicities )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:190:3: lv_x5_4_0= ruleAlternativeMultiplicities
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:213:6: ( (lv_x6_5_0= ruleAssignedAction ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:213:6: ( (lv_x6_5_0= ruleAssignedAction ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:214:1: (lv_x6_5_0= ruleAssignedAction )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:214:1: (lv_x6_5_0= ruleAssignedAction )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:215:3: lv_x6_5_0= ruleAssignedAction
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:238:6: ( (lv_x7_6_0= ruleAssignedActionSecond ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:238:6: ( (lv_x7_6_0= ruleAssignedActionSecond ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:239:1: (lv_x7_6_0= ruleAssignedActionSecond )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:239:1: (lv_x7_6_0= ruleAssignedActionSecond )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:240:3: lv_x7_6_0= ruleAssignedActionSecond
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:263:6: ( (lv_x8_7_0= ruleUnassignedAction1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:263:6: ( (lv_x8_7_0= ruleUnassignedAction1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:264:1: (lv_x8_7_0= ruleUnassignedAction1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:264:1: (lv_x8_7_0= ruleUnassignedAction1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:265:3: lv_x8_7_0= ruleUnassignedAction1
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:288:6: ( (lv_x9_8_0= ruleUnassignedAction2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:288:6: ( (lv_x9_8_0= ruleUnassignedAction2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:289:1: (lv_x9_8_0= ruleUnassignedAction2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:289:1: (lv_x9_8_0= ruleUnassignedAction2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:290:3: lv_x9_8_0= ruleUnassignedAction2
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:313:6: ( (lv_x10_9_0= ruleUnassignedAction3 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:313:6: ( (lv_x10_9_0= ruleUnassignedAction3 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:314:1: (lv_x10_9_0= ruleUnassignedAction3 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:314:1: (lv_x10_9_0= ruleUnassignedAction3 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:315:3: lv_x10_9_0= ruleUnassignedAction3
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:338:6: ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:338:6: ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:339:1: (lv_x11_10_0= ruleUnassignedRuleCall1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:339:1: (lv_x11_10_0= ruleUnassignedRuleCall1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:340:3: lv_x11_10_0= ruleUnassignedRuleCall1
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:363:6: ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:363:6: ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:364:1: (lv_x12_11_0= ruleUnassignedRuleCall2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:364:1: (lv_x12_11_0= ruleUnassignedRuleCall2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:365:3: lv_x12_11_0= ruleUnassignedRuleCall2
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:388:6: ( (lv_x13_12_0= ruleCombination1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:388:6: ( (lv_x13_12_0= ruleCombination1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:389:1: (lv_x13_12_0= ruleCombination1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:389:1: (lv_x13_12_0= ruleCombination1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:390:3: lv_x13_12_0= ruleCombination1
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:413:6: ( (lv_x14_13_0= ruleCombination2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:413:6: ( (lv_x14_13_0= ruleCombination2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:414:1: (lv_x14_13_0= ruleCombination2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:414:1: (lv_x14_13_0= ruleCombination2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:415:3: lv_x14_13_0= ruleCombination2
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:438:6: ( (lv_x15_14_0= ruleCombination3 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:438:6: ( (lv_x15_14_0= ruleCombination3 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:439:1: (lv_x15_14_0= ruleCombination3 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:439:1: (lv_x15_14_0= ruleCombination3 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:440:3: lv_x15_14_0= ruleCombination3
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:463:6: ( (lv_x16_15_0= ruleCombination4 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:463:6: ( (lv_x16_15_0= ruleCombination4 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:464:1: (lv_x16_15_0= ruleCombination4 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:464:1: (lv_x16_15_0= ruleCombination4 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:465:3: lv_x16_15_0= ruleCombination4
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:488:6: ( (lv_x17_16_0= ruleList1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:488:6: ( (lv_x17_16_0= ruleList1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:489:1: (lv_x17_16_0= ruleList1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:489:1: (lv_x17_16_0= ruleList1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:490:3: lv_x17_16_0= ruleList1
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:513:6: ( (lv_x18_17_0= ruleList2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:513:6: ( (lv_x18_17_0= ruleList2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:514:1: (lv_x18_17_0= ruleList2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:514:1: (lv_x18_17_0= ruleList2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:515:3: lv_x18_17_0= ruleList2
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:538:6: ( (lv_x19_18_0= ruleList3 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:538:6: ( (lv_x19_18_0= ruleList3 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:539:1: (lv_x19_18_0= ruleList3 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:539:1: (lv_x19_18_0= ruleList3 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:540:3: lv_x19_18_0= ruleList3
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:563:6: ( (lv_x20_19_0= ruleList4 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:563:6: ( (lv_x20_19_0= ruleList4 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:564:1: (lv_x20_19_0= ruleList4 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:564:1: (lv_x20_19_0= ruleList4 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:565:3: lv_x20_19_0= ruleList4
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:588:6: ( (lv_x21_20_0= ruleList5 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:588:6: ( (lv_x21_20_0= ruleList5 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:589:1: (lv_x21_20_0= ruleList5 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:589:1: (lv_x21_20_0= ruleList5 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:590:3: lv_x21_20_0= ruleList5
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:613:6: ( (lv_x22_21_0= ruleAltList1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:613:6: ( (lv_x22_21_0= ruleAltList1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:614:1: (lv_x22_21_0= ruleAltList1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:614:1: (lv_x22_21_0= ruleAltList1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:615:3: lv_x22_21_0= ruleAltList1
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:638:6: ( (lv_x23_22_0= ruleAltList2 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:638:6: ( (lv_x23_22_0= ruleAltList2 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:639:1: (lv_x23_22_0= ruleAltList2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:639:1: (lv_x23_22_0= ruleAltList2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:640:3: lv_x23_22_0= ruleAltList2
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:663:6: ( (lv_x24_23_0= ruleTransientObject ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:663:6: ( (lv_x24_23_0= ruleTransientObject ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:664:1: (lv_x24_23_0= ruleTransientObject )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:664:1: (lv_x24_23_0= ruleTransientObject )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:665:3: lv_x24_23_0= ruleTransientObject
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:688:6: ( (lv_x25_24_0= ruleTransientSerializeables1 ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:688:6: ( (lv_x25_24_0= ruleTransientSerializeables1 ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:689:1: (lv_x25_24_0= ruleTransientSerializeables1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:689:1: (lv_x25_24_0= ruleTransientSerializeables1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:690:3: lv_x25_24_0= ruleTransientSerializeables1
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:720:1: entryRuleSimpleGroup returns [EObject current=null] : iv_ruleSimpleGroup= ruleSimpleGroup EOF ;
    public final EObject entryRuleSimpleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleGroup = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:721:2: (iv_ruleSimpleGroup= ruleSimpleGroup EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:722:2: iv_ruleSimpleGroup= ruleSimpleGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleGroupRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleGroup_in_entryRuleSimpleGroup815);
            iv_ruleSimpleGroup=ruleSimpleGroup();
            _fsp--;

             current =iv_ruleSimpleGroup; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleGroup825); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:729:1: ruleSimpleGroup returns [EObject current=null] : ( '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final EObject ruleSimpleGroup() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:734:6: ( ( '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:735:1: ( '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:735:1: ( '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:735:3: '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleSimpleGroup860); 

                    createLeafNode(grammarAccess.getSimpleGroupAccess().getNumberSignDigitOneKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:739:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:740:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:740:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:741:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleGroup877); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:763:2: ( (lv_val2_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:764:1: (lv_val2_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:764:1: (lv_val2_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:765:3: lv_val2_2_0= RULE_ID
            {
            lv_val2_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleGroup899); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:795:1: entryRuleSimpleAlternative returns [EObject current=null] : iv_ruleSimpleAlternative= ruleSimpleAlternative EOF ;
    public final EObject entryRuleSimpleAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAlternative = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:796:2: (iv_ruleSimpleAlternative= ruleSimpleAlternative EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:797:2: iv_ruleSimpleAlternative= ruleSimpleAlternative EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleAlternativeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleAlternative_in_entryRuleSimpleAlternative940);
            iv_ruleSimpleAlternative=ruleSimpleAlternative();
            _fsp--;

             current =iv_ruleSimpleAlternative; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleAlternative950); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:804:1: ruleSimpleAlternative returns [EObject current=null] : ( '#2' ( ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) ;
    public final EObject ruleSimpleAlternative() throws RecognitionException {
        EObject current = null;

        Token lv_val1_2_0=null;
        Token lv_val2_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:809:6: ( ( '#2' ( ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:810:1: ( '#2' ( ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:810:1: ( '#2' ( ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:810:3: '#2' ( ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
            {
            match(input,12,FollowSets000.FOLLOW_12_in_ruleSimpleAlternative985); 

                    createLeafNode(grammarAccess.getSimpleAlternativeAccess().getNumberSignDigitTwoKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:814:1: ( ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
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
                    new NoViableAltException("814:1: ( ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:814:2: ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:814:2: ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:814:4: 'kw1' ( (lv_val1_2_0= RULE_ID ) )
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleSimpleAlternative997); 

                            createLeafNode(grammarAccess.getSimpleAlternativeAccess().getKw1Keyword_1_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:818:1: ( (lv_val1_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:819:1: (lv_val1_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:819:1: (lv_val1_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:820:3: lv_val1_2_0= RULE_ID
                    {
                    lv_val1_2_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleAlternative1014); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:843:6: ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:843:6: ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:843:8: 'kw2' ( (lv_val2_4_0= RULE_ID ) )
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleSimpleAlternative1037); 

                            createLeafNode(grammarAccess.getSimpleAlternativeAccess().getKw2Keyword_1_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:847:1: ( (lv_val2_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:848:1: (lv_val2_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:848:1: (lv_val2_4_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:849:3: lv_val2_4_0= RULE_ID
                    {
                    lv_val2_4_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleAlternative1054); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:879:1: entryRuleSimpleMultiplicities returns [EObject current=null] : iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF ;
    public final EObject entryRuleSimpleMultiplicities() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleMultiplicities = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:880:2: (iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:881:2: iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleMultiplicitiesRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleMultiplicities_in_entryRuleSimpleMultiplicities1097);
            iv_ruleSimpleMultiplicities=ruleSimpleMultiplicities();
            _fsp--;

             current =iv_ruleSimpleMultiplicities; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleMultiplicities1107); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:888:1: ruleSimpleMultiplicities returns [EObject current=null] : ( '#3' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) )? 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) ;
    public final EObject ruleSimpleMultiplicities() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_3_0=null;
        Token lv_val3_5_0=null;
        Token lv_val4_7_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:893:6: ( ( '#3' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) )? 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:894:1: ( '#3' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) )? 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:894:1: ( '#3' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) )? 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:894:3: '#3' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) )? 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ 'kw3' ( (lv_val4_7_0= RULE_ID ) )*
            {
            match(input,15,FollowSets000.FOLLOW_15_in_ruleSimpleMultiplicities1142); 

                    createLeafNode(grammarAccess.getSimpleMultiplicitiesAccess().getNumberSignDigitThreeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:898:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:899:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:899:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:900:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1159); 

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

            match(input,13,FollowSets000.FOLLOW_13_in_ruleSimpleMultiplicities1174); 

                    createLeafNode(grammarAccess.getSimpleMultiplicitiesAccess().getKw1Keyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:926:1: ( (lv_val2_3_0= RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:927:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:927:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:928:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1191); 

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

            match(input,14,FollowSets000.FOLLOW_14_in_ruleSimpleMultiplicities1207); 

                    createLeafNode(grammarAccess.getSimpleMultiplicitiesAccess().getKw2Keyword_4(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:954:1: ( (lv_val3_5_0= RULE_ID ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:955:1: (lv_val3_5_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:955:1: (lv_val3_5_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:956:3: lv_val3_5_0= RULE_ID
            	    {
            	    lv_val3_5_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1224); 

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

            match(input,16,FollowSets000.FOLLOW_16_in_ruleSimpleMultiplicities1240); 

                    createLeafNode(grammarAccess.getSimpleMultiplicitiesAccess().getKw3Keyword_6(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:982:1: ( (lv_val4_7_0= RULE_ID ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:983:1: (lv_val4_7_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:983:1: (lv_val4_7_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:984:3: lv_val4_7_0= RULE_ID
            	    {
            	    lv_val4_7_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1257); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1014:1: entryRuleGroupMultiplicities returns [EObject current=null] : iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF ;
    public final EObject entryRuleGroupMultiplicities() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupMultiplicities = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1015:2: (iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1016:2: iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGroupMultiplicitiesRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleGroupMultiplicities_in_entryRuleGroupMultiplicities1299);
            iv_ruleGroupMultiplicities=ruleGroupMultiplicities();
            _fsp--;

             current =iv_ruleGroupMultiplicities; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroupMultiplicities1309); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1023:1: ruleGroupMultiplicities returns [EObject current=null] : ( '#4' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1028:6: ( ( '#4' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1029:1: ( '#4' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1029:1: ( '#4' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1029:3: '#4' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            {
            match(input,17,FollowSets000.FOLLOW_17_in_ruleGroupMultiplicities1344); 

                    createLeafNode(grammarAccess.getGroupMultiplicitiesAccess().getNumberSignDigitFourKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1033:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1034:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1034:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1035:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1361); 

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

            match(input,13,FollowSets000.FOLLOW_13_in_ruleGroupMultiplicities1376); 

                    createLeafNode(grammarAccess.getGroupMultiplicitiesAccess().getKw1Keyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1061:1: ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1061:2: ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1061:2: ( (lv_val2_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1062:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1062:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1063:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1394); 

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1085:2: ( (lv_val3_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1086:1: (lv_val3_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1086:1: (lv_val3_4_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1087:3: lv_val3_4_0= RULE_ID
                    {
                    lv_val3_4_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1416); 

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

            match(input,14,FollowSets000.FOLLOW_14_in_ruleGroupMultiplicities1433); 

                    createLeafNode(grammarAccess.getGroupMultiplicitiesAccess().getKw2Keyword_4(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1113:1: ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1113:2: ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1113:2: ( (lv_val4_6_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1114:1: (lv_val4_6_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1114:1: (lv_val4_6_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1115:3: lv_val4_6_0= RULE_ID
            	    {
            	    lv_val4_6_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1451); 

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

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1137:2: ( (lv_val5_7_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1138:1: (lv_val5_7_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1138:1: (lv_val5_7_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1139:3: lv_val5_7_0= RULE_ID
            	    {
            	    lv_val5_7_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1473); 

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

            match(input,16,FollowSets000.FOLLOW_16_in_ruleGroupMultiplicities1490); 

                    createLeafNode(grammarAccess.getGroupMultiplicitiesAccess().getKw3Keyword_6(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1165:1: ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1165:2: ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1165:2: ( (lv_val6_9_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1166:1: (lv_val6_9_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1166:1: (lv_val6_9_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1167:3: lv_val6_9_0= RULE_ID
            	    {
            	    lv_val6_9_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1508); 

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

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1189:2: ( (lv_val7_10_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1190:1: (lv_val7_10_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1190:1: (lv_val7_10_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1191:3: lv_val7_10_0= RULE_ID
            	    {
            	    lv_val7_10_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1530); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1221:1: entryRuleAlternativeMultiplicities returns [EObject current=null] : iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF ;
    public final EObject entryRuleAlternativeMultiplicities() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternativeMultiplicities = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1222:2: (iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1223:2: iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAlternativeMultiplicitiesRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternativeMultiplicities_in_entryRuleAlternativeMultiplicities1573);
            iv_ruleAlternativeMultiplicities=ruleAlternativeMultiplicities();
            _fsp--;

             current =iv_ruleAlternativeMultiplicities; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlternativeMultiplicities1583); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1230:1: ruleAlternativeMultiplicities returns [EObject current=null] : ( '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1235:6: ( ( '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1236:1: ( '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1236:1: ( '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1236:3: '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
            {
            match(input,18,FollowSets000.FOLLOW_18_in_ruleAlternativeMultiplicities1618); 

                    createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getNumberSignDigitFiveKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1240:1: ( ( (lv_val2_1_0= RULE_ID ) ) | ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )?
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1240:2: ( (lv_val2_1_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1240:2: ( (lv_val2_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1241:1: (lv_val2_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1241:1: (lv_val2_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1242:3: lv_val2_1_0= RULE_ID
                    {
                    lv_val2_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1636); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1265:6: ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1265:6: ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1265:8: 'kw1' ( (lv_val3_3_0= RULE_ID ) )
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleAlternativeMultiplicities1658); 

                            createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getKw1Keyword_1_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1269:1: ( (lv_val3_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1270:1: (lv_val3_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1270:1: (lv_val3_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1271:3: lv_val3_3_0= RULE_ID
                    {
                    lv_val3_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1675); 

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

            match(input,14,FollowSets000.FOLLOW_14_in_ruleAlternativeMultiplicities1693); 

                    createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getKw2Keyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1297:1: ( ( (lv_val4_5_0= RULE_ID ) ) | ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1297:2: ( (lv_val4_5_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1297:2: ( (lv_val4_5_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1298:1: (lv_val4_5_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1298:1: (lv_val4_5_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1299:3: lv_val4_5_0= RULE_ID
            	    {
            	    lv_val4_5_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1711); 

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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1322:6: ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1322:6: ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1322:8: 'kw3' ( (lv_val5_7_0= RULE_ID ) )
            	    {
            	    match(input,16,FollowSets000.FOLLOW_16_in_ruleAlternativeMultiplicities1733); 

            	            createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getKw3Keyword_3_1_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1326:1: ( (lv_val5_7_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1327:1: (lv_val5_7_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1327:1: (lv_val5_7_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1328:3: lv_val5_7_0= RULE_ID
            	    {
            	    lv_val5_7_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1750); 

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

            match(input,19,FollowSets000.FOLLOW_19_in_ruleAlternativeMultiplicities1768); 

                    createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getKw4Keyword_4(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1354:1: ( ( (lv_val6_9_0= RULE_ID ) ) | ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1354:2: ( (lv_val6_9_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1354:2: ( (lv_val6_9_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1355:1: (lv_val6_9_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1355:1: (lv_val6_9_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1356:3: lv_val6_9_0= RULE_ID
            	    {
            	    lv_val6_9_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1786); 

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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1379:6: ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1379:6: ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1379:8: 'kw5' ( (lv_val7_11_0= RULE_ID ) )
            	    {
            	    match(input,20,FollowSets000.FOLLOW_20_in_ruleAlternativeMultiplicities1808); 

            	            createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getKw5Keyword_5_1_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1383:1: ( (lv_val7_11_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1384:1: (lv_val7_11_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1384:1: (lv_val7_11_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1385:3: lv_val7_11_0= RULE_ID
            	    {
            	    lv_val7_11_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1825); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1415:1: entryRuleAssignedAction returns [EObject current=null] : iv_ruleAssignedAction= ruleAssignedAction EOF ;
    public final EObject entryRuleAssignedAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignedAction = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1416:2: (iv_ruleAssignedAction= ruleAssignedAction EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1417:2: iv_ruleAssignedAction= ruleAssignedAction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignedActionRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignedAction_in_entryRuleAssignedAction1869);
            iv_ruleAssignedAction=ruleAssignedAction();
            _fsp--;

             current =iv_ruleAssignedAction; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignedAction1879); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1424:1: ruleAssignedAction returns [EObject current=null] : ( '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ ) ;
    public final EObject ruleAssignedAction() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val1_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1429:6: ( ( '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1430:1: ( '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1430:1: ( '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1430:3: '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+
            {
            match(input,21,FollowSets000.FOLLOW_21_in_ruleAssignedAction1914); 

                    createLeafNode(grammarAccess.getAssignedActionAccess().getNumberSignDigitSixKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1434:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1435:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1435:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1436:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignedAction1931); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1458:2: ( () ( (lv_val1_3_0= RULE_ID ) ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1458:3: () ( (lv_val1_3_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1458:3: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1459:5: 
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

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1474:2: ( (lv_val1_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1475:1: (lv_val1_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1475:1: (lv_val1_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1476:3: lv_val1_3_0= RULE_ID
            	    {
            	    lv_val1_3_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignedAction1963); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1506:1: entryRuleAssignedActionSecond returns [EObject current=null] : iv_ruleAssignedActionSecond= ruleAssignedActionSecond EOF ;
    public final EObject entryRuleAssignedActionSecond() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignedActionSecond = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1507:2: (iv_ruleAssignedActionSecond= ruleAssignedActionSecond EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1508:2: iv_ruleAssignedActionSecond= ruleAssignedActionSecond EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignedActionSecondRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignedActionSecond_in_entryRuleAssignedActionSecond2006);
            iv_ruleAssignedActionSecond=ruleAssignedActionSecond();
            _fsp--;

             current =iv_ruleAssignedActionSecond; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignedActionSecond2016); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1515:1: ruleAssignedActionSecond returns [EObject current=null] : ( '#7' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) ;
    public final EObject ruleAssignedActionSecond() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1520:6: ( ( '#7' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1521:1: ( '#7' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1521:1: ( '#7' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1521:3: '#7' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) )
            {
            match(input,22,FollowSets000.FOLLOW_22_in_ruleAssignedActionSecond2051); 

                    createLeafNode(grammarAccess.getAssignedActionSecondAccess().getNumberSignDigitSevenKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1525:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1526:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1526:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1527:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignedActionSecond2068); 

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

            match(input,13,FollowSets000.FOLLOW_13_in_ruleAssignedActionSecond2083); 

                    createLeafNode(grammarAccess.getAssignedActionSecondAccess().getKw1Keyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1553:1: ( (lv_val2_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1554:1: (lv_val2_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1554:1: (lv_val2_3_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1555:3: lv_val2_3_0= RULE_ID
            {
            lv_val2_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignedActionSecond2100); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1585:1: entryRuleUnassignedAction1 returns [EObject current=null] : iv_ruleUnassignedAction1= ruleUnassignedAction1 EOF ;
    public final EObject entryRuleUnassignedAction1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedAction1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1586:2: (iv_ruleUnassignedAction1= ruleUnassignedAction1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1587:2: iv_ruleUnassignedAction1= ruleUnassignedAction1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedAction1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction1_in_entryRuleUnassignedAction12141);
            iv_ruleUnassignedAction1=ruleUnassignedAction1();
            _fsp--;

             current =iv_ruleUnassignedAction1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedAction12151); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1594:1: ruleUnassignedAction1 returns [EObject current=null] : ( () '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) ;
    public final EObject ruleUnassignedAction1() throws RecognitionException {
        EObject current = null;

        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1599:6: ( ( () '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1600:1: ( () '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1600:1: ( () '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1600:2: () '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1600:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1601:5: 
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

            match(input,23,FollowSets000.FOLLOW_23_in_ruleUnassignedAction12195); 

                    createLeafNode(grammarAccess.getUnassignedAction1Access().getNumberSignDigitEightKeyword_1(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1615:1: ( (lv_val1_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1616:1: (lv_val1_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1616:1: (lv_val1_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1617:3: lv_val1_2_0= RULE_ID
            {
            lv_val1_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction12212); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1639:2: ( (lv_val2_3_0= RULE_ID ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1640:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1640:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1641:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction12234); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1671:1: entryRuleUnassignedAction2 returns [EObject current=null] : iv_ruleUnassignedAction2= ruleUnassignedAction2 EOF ;
    public final EObject entryRuleUnassignedAction2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedAction2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1672:2: (iv_ruleUnassignedAction2= ruleUnassignedAction2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1673:2: iv_ruleUnassignedAction2= ruleUnassignedAction2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedAction2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction2_in_entryRuleUnassignedAction22276);
            iv_ruleUnassignedAction2=ruleUnassignedAction2();
            _fsp--;

             current =iv_ruleUnassignedAction2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedAction22286); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1680:1: ruleUnassignedAction2 returns [EObject current=null] : ( () '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) ;
    public final EObject ruleUnassignedAction2() throws RecognitionException {
        EObject current = null;

        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1685:6: ( ( () '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1686:1: ( () '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1686:1: ( () '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1686:2: () '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1686:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1687:5: 
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

            match(input,24,FollowSets000.FOLLOW_24_in_ruleUnassignedAction22330); 

                    createLeafNode(grammarAccess.getUnassignedAction2Access().getNumberSignDigitNineKeyword_1(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1701:1: ( (lv_val1_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1702:1: (lv_val1_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1702:1: (lv_val1_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1703:3: lv_val1_2_0= RULE_ID
            {
            lv_val1_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction22347); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1725:2: ( (lv_val2_3_0= RULE_ID ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1726:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1726:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1727:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction22369); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1757:1: entryRuleUnassignedAction3 returns [EObject current=null] : iv_ruleUnassignedAction3= ruleUnassignedAction3 EOF ;
    public final EObject entryRuleUnassignedAction3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedAction3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1758:2: (iv_ruleUnassignedAction3= ruleUnassignedAction3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1759:2: iv_ruleUnassignedAction3= ruleUnassignedAction3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedAction3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction3_in_entryRuleUnassignedAction32411);
            iv_ruleUnassignedAction3=ruleUnassignedAction3();
            _fsp--;

             current =iv_ruleUnassignedAction3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedAction32421); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1766:1: ruleUnassignedAction3 returns [EObject current=null] : ( '#10' ( ( 'kw1' () ) | ( 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? ) ;
    public final EObject ruleUnassignedAction3() throws RecognitionException {
        EObject current = null;

        Token lv_val1_5_0=null;
        Token lv_val2_6_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1771:6: ( ( '#10' ( ( 'kw1' () ) | ( 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1772:1: ( '#10' ( ( 'kw1' () ) | ( 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1772:1: ( '#10' ( ( 'kw1' () ) | ( 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1772:3: '#10' ( ( 'kw1' () ) | ( 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )?
            {
            match(input,25,FollowSets000.FOLLOW_25_in_ruleUnassignedAction32456); 

                    createLeafNode(grammarAccess.getUnassignedAction3Access().getNumberSignDigitOneDigitZeroKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1776:1: ( ( 'kw1' () ) | ( 'kw2' () ) )
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
                    new NoViableAltException("1776:1: ( ( 'kw1' () ) | ( 'kw2' () ) )", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1776:2: ( 'kw1' () )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1776:2: ( 'kw1' () )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1776:4: 'kw1' ()
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleUnassignedAction32468); 

                            createLeafNode(grammarAccess.getUnassignedAction3Access().getKw1Keyword_1_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1780:1: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1781:5: 
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1792:6: ( 'kw2' () )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1792:6: ( 'kw2' () )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1792:8: 'kw2' ()
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleUnassignedAction32495); 

                            createLeafNode(grammarAccess.getUnassignedAction3Access().getKw2Keyword_1_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1796:1: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1797:5: 
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1807:4: ( (lv_val1_5_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1808:1: (lv_val1_5_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1808:1: (lv_val1_5_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1809:3: lv_val1_5_0= RULE_ID
            {
            lv_val1_5_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction32523); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1831:2: ( (lv_val2_6_0= RULE_ID ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1832:1: (lv_val2_6_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1832:1: (lv_val2_6_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1833:3: lv_val2_6_0= RULE_ID
                    {
                    lv_val2_6_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction32545); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1863:1: entryRuleUnassignedRuleCall1 returns [EObject current=null] : iv_ruleUnassignedRuleCall1= ruleUnassignedRuleCall1 EOF ;
    public final EObject entryRuleUnassignedRuleCall1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedRuleCall1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1864:2: (iv_ruleUnassignedRuleCall1= ruleUnassignedRuleCall1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1865:2: iv_ruleUnassignedRuleCall1= ruleUnassignedRuleCall1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedRuleCall1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall1_in_entryRuleUnassignedRuleCall12587);
            iv_ruleUnassignedRuleCall1=ruleUnassignedRuleCall1();
            _fsp--;

             current =iv_ruleUnassignedRuleCall1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedRuleCall12597); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1872:1: ruleUnassignedRuleCall1 returns [EObject current=null] : ( '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final EObject ruleUnassignedRuleCall1() throws RecognitionException {
        EObject current = null;

        Token lv_val2_2_0=null;
        EObject this_UnassignedRuleCall1Sub_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1877:6: ( ( '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1878:1: ( '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1878:1: ( '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1878:3: '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) )
            {
            match(input,26,FollowSets000.FOLLOW_26_in_ruleUnassignedRuleCall12632); 

                    createLeafNode(grammarAccess.getUnassignedRuleCall1Access().getNumberSignDigitOneDigitOneKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getUnassignedRuleCall1Access().getUnassignedRuleCall1SubParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall1Sub_in_ruleUnassignedRuleCall12654);
            this_UnassignedRuleCall1Sub_1=ruleUnassignedRuleCall1Sub();
            _fsp--;

             
                    current = this_UnassignedRuleCall1Sub_1; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1891:1: ( (lv_val2_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1892:1: (lv_val2_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1892:1: (lv_val2_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1893:3: lv_val2_2_0= RULE_ID
            {
            lv_val2_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedRuleCall12670); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1923:1: entryRuleUnassignedRuleCall1Sub returns [EObject current=null] : iv_ruleUnassignedRuleCall1Sub= ruleUnassignedRuleCall1Sub EOF ;
    public final EObject entryRuleUnassignedRuleCall1Sub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedRuleCall1Sub = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1924:2: (iv_ruleUnassignedRuleCall1Sub= ruleUnassignedRuleCall1Sub EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1925:2: iv_ruleUnassignedRuleCall1Sub= ruleUnassignedRuleCall1Sub EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedRuleCall1SubRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall1Sub_in_entryRuleUnassignedRuleCall1Sub2711);
            iv_ruleUnassignedRuleCall1Sub=ruleUnassignedRuleCall1Sub();
            _fsp--;

             current =iv_ruleUnassignedRuleCall1Sub; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedRuleCall1Sub2721); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1932:1: ruleUnassignedRuleCall1Sub returns [EObject current=null] : ( (lv_val1_0_0= RULE_ID ) ) ;
    public final EObject ruleUnassignedRuleCall1Sub() throws RecognitionException {
        EObject current = null;

        Token lv_val1_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1937:6: ( ( (lv_val1_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1938:1: ( (lv_val1_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1938:1: ( (lv_val1_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1939:1: (lv_val1_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1939:1: (lv_val1_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1940:3: lv_val1_0_0= RULE_ID
            {
            lv_val1_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedRuleCall1Sub2762); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1970:1: entryRuleUnassignedRuleCall2 returns [EObject current=null] : iv_ruleUnassignedRuleCall2= ruleUnassignedRuleCall2 EOF ;
    public final EObject entryRuleUnassignedRuleCall2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedRuleCall2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1971:2: (iv_ruleUnassignedRuleCall2= ruleUnassignedRuleCall2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1972:2: iv_ruleUnassignedRuleCall2= ruleUnassignedRuleCall2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedRuleCall2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall2_in_entryRuleUnassignedRuleCall22802);
            iv_ruleUnassignedRuleCall2=ruleUnassignedRuleCall2();
            _fsp--;

             current =iv_ruleUnassignedRuleCall2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedRuleCall22812); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1979:1: ruleUnassignedRuleCall2 returns [EObject current=null] : ( '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final EObject ruleUnassignedRuleCall2() throws RecognitionException {
        EObject current = null;

        Token lv_val2_2_0=null;
        EObject this_UnassignedRuleCall2Sub_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1984:6: ( ( '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1985:1: ( '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1985:1: ( '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1985:3: '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) )
            {
            match(input,27,FollowSets000.FOLLOW_27_in_ruleUnassignedRuleCall22847); 

                    createLeafNode(grammarAccess.getUnassignedRuleCall2Access().getNumberSignDigitOneDigitTwoKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getUnassignedRuleCall2Access().getUnassignedRuleCall2SubParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall2Sub_in_ruleUnassignedRuleCall22869);
            this_UnassignedRuleCall2Sub_1=ruleUnassignedRuleCall2Sub();
            _fsp--;

             
                    current = this_UnassignedRuleCall2Sub_1; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1998:1: ( (lv_val2_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1999:1: (lv_val2_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1999:1: (lv_val2_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2000:3: lv_val2_2_0= RULE_ID
            {
            lv_val2_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedRuleCall22885); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2030:1: entryRuleUnassignedRuleCall2Sub returns [EObject current=null] : iv_ruleUnassignedRuleCall2Sub= ruleUnassignedRuleCall2Sub EOF ;
    public final EObject entryRuleUnassignedRuleCall2Sub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedRuleCall2Sub = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2031:2: (iv_ruleUnassignedRuleCall2Sub= ruleUnassignedRuleCall2Sub EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2032:2: iv_ruleUnassignedRuleCall2Sub= ruleUnassignedRuleCall2Sub EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedRuleCall2SubRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall2Sub_in_entryRuleUnassignedRuleCall2Sub2926);
            iv_ruleUnassignedRuleCall2Sub=ruleUnassignedRuleCall2Sub();
            _fsp--;

             current =iv_ruleUnassignedRuleCall2Sub; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedRuleCall2Sub2936); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2039:1: ruleUnassignedRuleCall2Sub returns [EObject current=null] : () ;
    public final EObject ruleUnassignedRuleCall2Sub() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2044:6: ( () )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2045:1: ()
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2045:1: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2046:5: 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2064:1: entryRuleCombination1 returns [EObject current=null] : iv_ruleCombination1= ruleCombination1 EOF ;
    public final EObject entryRuleCombination1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombination1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2065:2: (iv_ruleCombination1= ruleCombination1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2066:2: iv_ruleCombination1= ruleCombination1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCombination1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCombination1_in_entryRuleCombination13004);
            iv_ruleCombination1=ruleCombination1();
            _fsp--;

             current =iv_ruleCombination1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCombination13014); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2073:1: ruleCombination1 returns [EObject current=null] : ( '#13' ( (lv_val1_1_0= RULE_ID ) ) ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? ) ;
    public final EObject ruleCombination1() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_3_0=null;
        Token lv_val3_5_0=null;
        Token lv_val4_6_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2078:6: ( ( '#13' ( (lv_val1_1_0= RULE_ID ) ) ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2079:1: ( '#13' ( (lv_val1_1_0= RULE_ID ) ) ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2079:1: ( '#13' ( (lv_val1_1_0= RULE_ID ) ) ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2079:3: '#13' ( (lv_val1_1_0= RULE_ID ) ) ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )?
            {
            match(input,28,FollowSets000.FOLLOW_28_in_ruleCombination13049); 

                    createLeafNode(grammarAccess.getCombination1Access().getNumberSignDigitOneDigitThreeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2083:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2084:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2084:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2085:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination13066); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2107:2: ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==13) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2107:4: 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) )
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleCombination13082); 

                            createLeafNode(grammarAccess.getCombination1Access().getKw1Keyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2111:1: ( (lv_val2_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2112:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2112:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2113:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination13099); 

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2135:2: ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) )
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
                            new NoViableAltException("2135:2: ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) )", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2135:3: ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2135:3: ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2135:5: 'kw2' ( (lv_val3_5_0= RULE_ID ) )
                            {
                            match(input,14,FollowSets000.FOLLOW_14_in_ruleCombination13116); 

                                    createLeafNode(grammarAccess.getCombination1Access().getKw2Keyword_2_2_0_0(), null); 
                                
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2139:1: ( (lv_val3_5_0= RULE_ID ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2140:1: (lv_val3_5_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2140:1: (lv_val3_5_0= RULE_ID )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2141:3: lv_val3_5_0= RULE_ID
                            {
                            lv_val3_5_0=(Token)input.LT(1);
                            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination13133); 

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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2164:6: ( (lv_val4_6_0= RULE_ID ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2164:6: ( (lv_val4_6_0= RULE_ID ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2165:1: (lv_val4_6_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2165:1: (lv_val4_6_0= RULE_ID )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2166:3: lv_val4_6_0= RULE_ID
                            {
                            lv_val4_6_0=(Token)input.LT(1);
                            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination13162); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2196:1: entryRuleCombination2 returns [EObject current=null] : iv_ruleCombination2= ruleCombination2 EOF ;
    public final EObject entryRuleCombination2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombination2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2197:2: (iv_ruleCombination2= ruleCombination2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2198:2: iv_ruleCombination2= ruleCombination2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCombination2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCombination2_in_entryRuleCombination23206);
            iv_ruleCombination2=ruleCombination2();
            _fsp--;

             current =iv_ruleCombination2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCombination23216); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2205:1: ruleCombination2 returns [EObject current=null] : ( '#14' ( (lv_val1_1_0= RULE_ID ) ) ( ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) ) ;
    public final EObject ruleCombination2() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_3_0=null;
        Token lv_val3_4_0=null;
        Token lv_val4_5_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2210:6: ( ( '#14' ( (lv_val1_1_0= RULE_ID ) ) ( ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2211:1: ( '#14' ( (lv_val1_1_0= RULE_ID ) ) ( ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2211:1: ( '#14' ( (lv_val1_1_0= RULE_ID ) ) ( ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2211:3: '#14' ( (lv_val1_1_0= RULE_ID ) ) ( ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* )
            {
            match(input,29,FollowSets000.FOLLOW_29_in_ruleCombination23251); 

                    createLeafNode(grammarAccess.getCombination2Access().getNumberSignDigitOneDigitFourKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2215:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2216:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2216:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2217:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination23268); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2239:2: ( ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* )
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
                    new NoViableAltException("2239:2: ( ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* )", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2239:3: ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2239:3: ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2239:5: 'kw1' ( (lv_val2_3_0= RULE_ID ) )
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleCombination23285); 

                            createLeafNode(grammarAccess.getCombination2Access().getKw1Keyword_2_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2243:1: ( (lv_val2_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2244:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2244:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2245:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination23302); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2268:6: ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2268:6: ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==RULE_ID) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2268:7: ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2268:7: ( (lv_val3_4_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2269:1: (lv_val3_4_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2269:1: (lv_val3_4_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2270:3: lv_val3_4_0= RULE_ID
                    	    {
                    	    lv_val3_4_0=(Token)input.LT(1);
                    	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination23332); 

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

                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2292:2: ( (lv_val4_5_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2293:1: (lv_val4_5_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2293:1: (lv_val4_5_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2294:3: lv_val4_5_0= RULE_ID
                    	    {
                    	    lv_val4_5_0=(Token)input.LT(1);
                    	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination23354); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2324:1: entryRuleCombination3 returns [EObject current=null] : iv_ruleCombination3= ruleCombination3 EOF ;
    public final EObject entryRuleCombination3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombination3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2325:2: (iv_ruleCombination3= ruleCombination3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2326:2: iv_ruleCombination3= ruleCombination3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCombination3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCombination3_in_entryRuleCombination33398);
            iv_ruleCombination3=ruleCombination3();
            _fsp--;

             current =iv_ruleCombination3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCombination33408); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2333:1: ruleCombination3 returns [EObject current=null] : ( '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* ) ;
    public final EObject ruleCombination3() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;
        Token lv_val3_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2338:6: ( ( '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2339:1: ( '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2339:1: ( '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2339:3: '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )*
            {
            match(input,30,FollowSets000.FOLLOW_30_in_ruleCombination33443); 

                    createLeafNode(grammarAccess.getCombination3Access().getNumberSignDigitOneDigitFiveKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2343:1: ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2343:2: ( (lv_val1_1_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2343:2: ( (lv_val1_1_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2344:1: (lv_val1_1_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2344:1: (lv_val1_1_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2345:3: lv_val1_1_0= RULE_ID
            	    {
            	    lv_val1_1_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination33461); 

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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2368:6: ( (lv_val2_2_0= RULE_INT ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2368:6: ( (lv_val2_2_0= RULE_INT ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2369:1: (lv_val2_2_0= RULE_INT )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2369:1: (lv_val2_2_0= RULE_INT )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2370:3: lv_val2_2_0= RULE_INT
            	    {
            	    lv_val2_2_0=(Token)input.LT(1);
            	    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleCombination33489); 

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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2393:6: ( (lv_val3_3_0= RULE_STRING ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2393:6: ( (lv_val3_3_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2394:1: (lv_val3_3_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2394:1: (lv_val3_3_0= RULE_STRING )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2395:3: lv_val3_3_0= RULE_STRING
            	    {
            	    lv_val3_3_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCombination33517); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2425:1: entryRuleCombination4 returns [EObject current=null] : iv_ruleCombination4= ruleCombination4 EOF ;
    public final EObject entryRuleCombination4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombination4 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2426:2: (iv_ruleCombination4= ruleCombination4 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2427:2: iv_ruleCombination4= ruleCombination4 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCombination4Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCombination4_in_entryRuleCombination43560);
            iv_ruleCombination4=ruleCombination4();
            _fsp--;

             current =iv_ruleCombination4; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCombination43570); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2434:1: ruleCombination4 returns [EObject current=null] : ( '#16' ( 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ ) ;
    public final EObject ruleCombination4() throws RecognitionException {
        EObject current = null;

        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;
        Token lv_val3_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2439:6: ( ( '#16' ( 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2440:1: ( '#16' ( 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2440:1: ( '#16' ( 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2440:3: '#16' ( 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+
            {
            match(input,31,FollowSets000.FOLLOW_31_in_ruleCombination43605); 

                    createLeafNode(grammarAccess.getCombination4Access().getNumberSignDigitOneDigitSixKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2444:1: ( 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2444:3: 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) )
            	    {
            	    match(input,32,FollowSets000.FOLLOW_32_in_ruleCombination43616); 

            	            createLeafNode(grammarAccess.getCombination4Access().getGroupKeyword_1_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2448:1: ( (lv_val1_2_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2449:1: (lv_val1_2_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2449:1: (lv_val1_2_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2450:3: lv_val1_2_0= RULE_ID
            	    {
            	    lv_val1_2_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination43633); 

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

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2472:2: ( (lv_val2_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2473:1: (lv_val2_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2473:1: (lv_val2_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2474:3: lv_val2_3_0= RULE_ID
            	    {
            	    lv_val2_3_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination43655); 

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

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2496:2: ( (lv_val3_4_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2497:1: (lv_val3_4_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2497:1: (lv_val3_4_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2498:3: lv_val3_4_0= RULE_ID
            	    {
            	    lv_val3_4_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination43677); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2528:1: entryRuleList1 returns [EObject current=null] : iv_ruleList1= ruleList1 EOF ;
    public final EObject entryRuleList1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2529:2: (iv_ruleList1= ruleList1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2530:2: iv_ruleList1= ruleList1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getList1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleList1_in_entryRuleList13720);
            iv_ruleList1=ruleList1();
            _fsp--;

             current =iv_ruleList1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList13730); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2537:1: ruleList1 returns [EObject current=null] : ( '#17' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ;
    public final EObject ruleList1() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val1_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2542:6: ( ( '#17' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2543:1: ( '#17' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2543:1: ( '#17' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2543:3: '#17' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            {
            match(input,33,FollowSets000.FOLLOW_33_in_ruleList13765); 

                    createLeafNode(grammarAccess.getList1Access().getNumberSignDigitOneDigitSevenKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2547:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2548:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2548:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2549:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList13782); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2571:2: ( ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==34) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2571:4: ',' ( (lv_val1_3_0= RULE_ID ) )
            	    {
            	    match(input,34,FollowSets000.FOLLOW_34_in_ruleList13798); 

            	            createLeafNode(grammarAccess.getList1Access().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2575:1: ( (lv_val1_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2576:1: (lv_val1_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2576:1: (lv_val1_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2577:3: lv_val1_3_0= RULE_ID
            	    {
            	    lv_val1_3_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList13815); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2607:1: entryRuleList2 returns [EObject current=null] : iv_ruleList2= ruleList2 EOF ;
    public final EObject entryRuleList2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2608:2: (iv_ruleList2= ruleList2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2609:2: iv_ruleList2= ruleList2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getList2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleList2_in_entryRuleList23858);
            iv_ruleList2=ruleList2();
            _fsp--;

             current =iv_ruleList2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList23868); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2616:1: ruleList2 returns [EObject current=null] : ( '#18' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? ) ;
    public final EObject ruleList2() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val1_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2621:6: ( ( '#18' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2622:1: ( '#18' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2622:1: ( '#18' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2622:3: '#18' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )?
            {
            match(input,35,FollowSets000.FOLLOW_35_in_ruleList23903); 

                    createLeafNode(grammarAccess.getList2Access().getNumberSignDigitOneDigitEightKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2626:1: ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2626:2: ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2626:2: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2627:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2627:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2628:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList23921); 

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2650:2: ( ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==34) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2650:4: ',' ( (lv_val1_3_0= RULE_ID ) )
                    	    {
                    	    match(input,34,FollowSets000.FOLLOW_34_in_ruleList23937); 

                    	            createLeafNode(grammarAccess.getList2Access().getCommaKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2654:1: ( (lv_val1_3_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2655:1: (lv_val1_3_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2655:1: (lv_val1_3_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2656:3: lv_val1_3_0= RULE_ID
                    	    {
                    	    lv_val1_3_0=(Token)input.LT(1);
                    	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList23954); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2686:1: entryRuleList3 returns [EObject current=null] : iv_ruleList3= ruleList3 EOF ;
    public final EObject entryRuleList3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2687:2: (iv_ruleList3= ruleList3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2688:2: iv_ruleList3= ruleList3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getList3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleList3_in_entryRuleList33999);
            iv_ruleList3=ruleList3();
            _fsp--;

             current =iv_ruleList3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList34009); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2695:1: ruleList3 returns [EObject current=null] : ( ( '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | ( 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) ) ;
    public final EObject ruleList3() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val1_3_0=null;
        Token lv_val2_5_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2700:6: ( ( ( '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | ( 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2701:1: ( ( '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | ( 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2701:1: ( ( '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | ( 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )
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
                    new NoViableAltException("2701:1: ( ( '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | ( 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2701:2: ( '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2701:2: ( '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2701:4: '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
                    {
                    match(input,36,FollowSets000.FOLLOW_36_in_ruleList34045); 

                            createLeafNode(grammarAccess.getList3Access().getNumberSignDigitOneDigitNineKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2705:1: ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2705:2: ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2705:2: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2706:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2706:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2707:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList34063); 

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2729:2: ( ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==34) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2729:4: ',' ( (lv_val1_3_0= RULE_ID ) )
                    	    {
                    	    match(input,34,FollowSets000.FOLLOW_34_in_ruleList34079); 

                    	            createLeafNode(grammarAccess.getList3Access().getCommaKeyword_0_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2733:1: ( (lv_val1_3_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2734:1: (lv_val1_3_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2734:1: (lv_val1_3_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2735:3: lv_val1_3_0= RULE_ID
                    	    {
                    	    lv_val1_3_0=(Token)input.LT(1);
                    	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList34096); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2758:6: ( 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2758:6: ( 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2758:8: 'kw3' ( (lv_val2_5_0= RULE_ID ) )
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleList34122); 

                            createLeafNode(grammarAccess.getList3Access().getKw3Keyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2762:1: ( (lv_val2_5_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2763:1: (lv_val2_5_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2763:1: (lv_val2_5_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2764:3: lv_val2_5_0= RULE_ID
                    {
                    lv_val2_5_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList34139); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2794:1: entryRuleList4 returns [EObject current=null] : iv_ruleList4= ruleList4 EOF ;
    public final EObject entryRuleList4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList4 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2795:2: (iv_ruleList4= ruleList4 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2796:2: iv_ruleList4= ruleList4 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getList4Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleList4_in_entryRuleList44181);
            iv_ruleList4=ruleList4();
            _fsp--;

             current =iv_ruleList4; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList44191); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2803:1: ruleList4 returns [EObject current=null] : ( '#20' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) ;
    public final EObject ruleList4() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val1_3_0=null;
        Token lv_val2_5_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2808:6: ( ( '#20' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2809:1: ( '#20' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2809:1: ( '#20' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2809:3: '#20' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) )
            {
            match(input,37,FollowSets000.FOLLOW_37_in_ruleList44226); 

                    createLeafNode(grammarAccess.getList4Access().getNumberSignDigitTwoDigitZeroKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2813:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2814:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2814:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2815:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList44243); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2837:2: ( ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==34) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2837:4: ',' ( (lv_val1_3_0= RULE_ID ) )
            	    {
            	    match(input,34,FollowSets000.FOLLOW_34_in_ruleList44259); 

            	            createLeafNode(grammarAccess.getList4Access().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2841:1: ( (lv_val1_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2842:1: (lv_val1_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2842:1: (lv_val1_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2843:3: lv_val1_3_0= RULE_ID
            	    {
            	    lv_val1_3_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList44276); 

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

            match(input,16,FollowSets000.FOLLOW_16_in_ruleList44293); 

                    createLeafNode(grammarAccess.getList4Access().getKw3Keyword_3(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2869:1: ( (lv_val2_5_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2870:1: (lv_val2_5_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2870:1: (lv_val2_5_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2871:3: lv_val2_5_0= RULE_ID
            {
            lv_val2_5_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList44310); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2901:1: entryRuleList5 returns [EObject current=null] : iv_ruleList5= ruleList5 EOF ;
    public final EObject entryRuleList5() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList5 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2902:2: (iv_ruleList5= ruleList5 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2903:2: iv_ruleList5= ruleList5 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getList5Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleList5_in_entryRuleList54351);
            iv_ruleList5=ruleList5();
            _fsp--;

             current =iv_ruleList5; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList54361); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2910:1: ruleList5 returns [EObject current=null] : ( '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) ) ;
    public final EObject ruleList5() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val1_3_0=null;
        Token lv_val2_5_0=null;
        Token lv_val3_6_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2915:6: ( ( '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2916:1: ( '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2916:1: ( '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2916:3: '#21' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) )
            {
            match(input,38,FollowSets000.FOLLOW_38_in_ruleList54396); 

                    createLeafNode(grammarAccess.getList5Access().getNumberSignDigitTwoDigitOneKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2920:1: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) )
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
                        new NoViableAltException("2920:1: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) )", 30, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2920:1: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) | ( (lv_val3_6_0= RULE_ID ) ) )", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2920:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2920:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2920:3: ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* 'kw3' ( (lv_val2_5_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2920:3: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2921:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2921:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2922:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList54415); 

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2944:2: ( ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==34) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2944:4: ',' ( (lv_val1_3_0= RULE_ID ) )
                    	    {
                    	    match(input,34,FollowSets000.FOLLOW_34_in_ruleList54431); 

                    	            createLeafNode(grammarAccess.getList5Access().getCommaKeyword_1_0_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2948:1: ( (lv_val1_3_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2949:1: (lv_val1_3_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2949:1: (lv_val1_3_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2950:3: lv_val1_3_0= RULE_ID
                    	    {
                    	    lv_val1_3_0=(Token)input.LT(1);
                    	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList54448); 

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

                    match(input,16,FollowSets000.FOLLOW_16_in_ruleList54465); 

                            createLeafNode(grammarAccess.getList5Access().getKw3Keyword_1_0_2(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2976:1: ( (lv_val2_5_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2977:1: (lv_val2_5_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2977:1: (lv_val2_5_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2978:3: lv_val2_5_0= RULE_ID
                    {
                    lv_val2_5_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList54482); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3001:6: ( (lv_val3_6_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3001:6: ( (lv_val3_6_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3002:1: (lv_val3_6_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3002:1: (lv_val3_6_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3003:3: lv_val3_6_0= RULE_ID
                    {
                    lv_val3_6_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList54511); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3033:1: entryRuleAltList1 returns [EObject current=null] : iv_ruleAltList1= ruleAltList1 EOF ;
    public final EObject entryRuleAltList1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAltList1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3034:2: (iv_ruleAltList1= ruleAltList1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3035:2: iv_ruleAltList1= ruleAltList1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAltList1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAltList1_in_entryRuleAltList14553);
            iv_ruleAltList1=ruleAltList1();
            _fsp--;

             current =iv_ruleAltList1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAltList14563); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3042:1: ruleAltList1 returns [EObject current=null] : ( '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3047:6: ( ( '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3048:1: ( '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3048:1: ( '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3048:3: '#22' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
            {
            match(input,39,FollowSets000.FOLLOW_39_in_ruleAltList14598); 

                    createLeafNode(grammarAccess.getAltList1Access().getNumberSignDigitTwoDigitTwoKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3052:1: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )
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
                    new NoViableAltException("3052:1: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? ) )", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3052:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3052:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3052:3: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3052:3: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3053:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3053:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3054:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList14617); 

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3076:2: ( (lv_val2_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3077:1: (lv_val2_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3077:1: (lv_val2_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3078:3: lv_val2_2_0= RULE_ID
                    {
                    lv_val2_2_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList14639); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3101:6: ( 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3101:6: ( 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3101:8: 'kw1' ( (lv_val1_4_0= RULE_ID ) ) ( (lv_val3_5_0= RULE_ID ) )
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleAltList14662); 

                            createLeafNode(grammarAccess.getAltList1Access().getKw1Keyword_1_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3105:1: ( (lv_val1_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3106:1: (lv_val1_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3106:1: (lv_val1_4_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3107:3: lv_val1_4_0= RULE_ID
                    {
                    lv_val1_4_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList14679); 

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3129:2: ( (lv_val3_5_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3130:1: (lv_val3_5_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3130:1: (lv_val3_5_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3131:3: lv_val3_5_0= RULE_ID
                    {
                    lv_val3_5_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList14701); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3154:6: ( 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3154:6: ( 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )? )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3154:8: 'kw2' ( (lv_val1_7_0= RULE_ID ) ) ( (lv_val4_8_0= RULE_ID ) )?
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleAltList14724); 

                            createLeafNode(grammarAccess.getAltList1Access().getKw2Keyword_1_2_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3158:1: ( (lv_val1_7_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3159:1: (lv_val1_7_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3159:1: (lv_val1_7_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3160:3: lv_val1_7_0= RULE_ID
                    {
                    lv_val1_7_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList14741); 

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3182:2: ( (lv_val4_8_0= RULE_ID ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==RULE_ID) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3183:1: (lv_val4_8_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3183:1: (lv_val4_8_0= RULE_ID )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3184:3: lv_val4_8_0= RULE_ID
                            {
                            lv_val4_8_0=(Token)input.LT(1);
                            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList14763); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3214:1: entryRuleAltList2 returns [EObject current=null] : iv_ruleAltList2= ruleAltList2 EOF ;
    public final EObject entryRuleAltList2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAltList2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3215:2: (iv_ruleAltList2= ruleAltList2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3216:2: iv_ruleAltList2= ruleAltList2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAltList2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAltList2_in_entryRuleAltList24807);
            iv_ruleAltList2=ruleAltList2();
            _fsp--;

             current =iv_ruleAltList2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAltList24817); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3223:1: ruleAltList2 returns [EObject current=null] : ( '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw' ( (lv_val1_4_0= RULE_ID ) ) ( ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) ;
    public final EObject ruleAltList2() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;
        Token lv_val1_4_0=null;
        Token lv_val1_6_0=null;
        Token lv_val3_7_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3228:6: ( ( '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw' ( (lv_val1_4_0= RULE_ID ) ) ( ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3229:1: ( '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw' ( (lv_val1_4_0= RULE_ID ) ) ( ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3229:1: ( '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw' ( (lv_val1_4_0= RULE_ID ) ) ( ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3229:3: '#23' ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw' ( (lv_val1_4_0= RULE_ID ) ) ( ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
            {
            match(input,40,FollowSets000.FOLLOW_40_in_ruleAltList24852); 

                    createLeafNode(grammarAccess.getAltList2Access().getNumberSignDigitTwoDigitThreeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3233:1: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw' ( (lv_val1_4_0= RULE_ID ) ) ( ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )
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
                    new NoViableAltException("3233:1: ( ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) | ( 'kw' ( (lv_val1_4_0= RULE_ID ) ) ( ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) ) )", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3233:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3233:2: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3233:3: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3233:3: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3234:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3234:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3235:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList24871); 

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3257:2: ( (lv_val2_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3258:1: (lv_val2_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3258:1: (lv_val2_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3259:3: lv_val2_2_0= RULE_ID
                    {
                    lv_val2_2_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList24893); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3282:6: ( 'kw' ( (lv_val1_4_0= RULE_ID ) ) ( ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3282:6: ( 'kw' ( (lv_val1_4_0= RULE_ID ) ) ( ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3282:8: 'kw' ( (lv_val1_4_0= RULE_ID ) ) ( ',' ( (lv_val1_6_0= RULE_ID ) ) )* ( (lv_val3_7_0= RULE_ID ) )
                    {
                    match(input,41,FollowSets000.FOLLOW_41_in_ruleAltList24916); 

                            createLeafNode(grammarAccess.getAltList2Access().getKwKeyword_1_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3286:1: ( (lv_val1_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3287:1: (lv_val1_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3287:1: (lv_val1_4_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3288:3: lv_val1_4_0= RULE_ID
                    {
                    lv_val1_4_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList24933); 

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3310:2: ( ',' ( (lv_val1_6_0= RULE_ID ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==34) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3310:4: ',' ( (lv_val1_6_0= RULE_ID ) )
                    	    {
                    	    match(input,34,FollowSets000.FOLLOW_34_in_ruleAltList24949); 

                    	            createLeafNode(grammarAccess.getAltList2Access().getCommaKeyword_1_1_2_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3314:1: ( (lv_val1_6_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3315:1: (lv_val1_6_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3315:1: (lv_val1_6_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3316:3: lv_val1_6_0= RULE_ID
                    	    {
                    	    lv_val1_6_0=(Token)input.LT(1);
                    	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList24966); 

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3338:4: ( (lv_val3_7_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3339:1: (lv_val3_7_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3339:1: (lv_val3_7_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3340:3: lv_val3_7_0= RULE_ID
                    {
                    lv_val3_7_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAltList24990); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3370:1: entryRuleTransientObject returns [EObject current=null] : iv_ruleTransientObject= ruleTransientObject EOF ;
    public final EObject entryRuleTransientObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransientObject = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3371:2: (iv_ruleTransientObject= ruleTransientObject EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3372:2: iv_ruleTransientObject= ruleTransientObject EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransientObjectRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTransientObject_in_entryRuleTransientObject5033);
            iv_ruleTransientObject=ruleTransientObject();
            _fsp--;

             current =iv_ruleTransientObject; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransientObject5043); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3379:1: ruleTransientObject returns [EObject current=null] : ( '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? ) ;
    public final EObject ruleTransientObject() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        EObject lv_nested_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3384:6: ( ( '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3385:1: ( '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3385:1: ( '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3385:3: '#24' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )?
            {
            match(input,42,FollowSets000.FOLLOW_42_in_ruleTransientObject5078); 

                    createLeafNode(grammarAccess.getTransientObjectAccess().getNumberSignDigitTwoDigitFourKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3389:1: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3389:2: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_nested_2_0= ruleTransientObjectSub ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3389:2: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3390:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3390:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3391:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransientObject5096); 

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3413:2: ( (lv_nested_2_0= ruleTransientObjectSub ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3414:1: (lv_nested_2_0= ruleTransientObjectSub )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3414:1: (lv_nested_2_0= ruleTransientObjectSub )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3415:3: lv_nested_2_0= ruleTransientObjectSub
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTransientObjectAccess().getNestedTransientObjectSubParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTransientObjectSub_in_ruleTransientObject5122);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3445:1: entryRuleTransientObjectSub returns [EObject current=null] : iv_ruleTransientObjectSub= ruleTransientObjectSub EOF ;
    public final EObject entryRuleTransientObjectSub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransientObjectSub = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3446:2: (iv_ruleTransientObjectSub= ruleTransientObjectSub EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3447:2: iv_ruleTransientObjectSub= ruleTransientObjectSub EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransientObjectSubRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTransientObjectSub_in_entryRuleTransientObjectSub5160);
            iv_ruleTransientObjectSub=ruleTransientObjectSub();
            _fsp--;

             current =iv_ruleTransientObjectSub; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransientObjectSub5170); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3454:1: ruleTransientObjectSub returns [EObject current=null] : ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) ) ;
    public final EObject ruleTransientObjectSub() throws RecognitionException {
        EObject current = null;

        Token lv_val2_0_0=null;
        Token lv_val3_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3459:6: ( ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3460:1: ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3460:1: ( ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3460:2: ( (lv_val2_0_0= RULE_ID ) ) ( (lv_val3_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3460:2: ( (lv_val2_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3461:1: (lv_val2_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3461:1: (lv_val2_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3462:3: lv_val2_0_0= RULE_ID
            {
            lv_val2_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransientObjectSub5212); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3484:2: ( (lv_val3_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3485:1: (lv_val3_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3485:1: (lv_val3_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3486:3: lv_val3_1_0= RULE_ID
            {
            lv_val3_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransientObjectSub5234); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3516:1: entryRuleTransientSerializeables1 returns [EObject current=null] : iv_ruleTransientSerializeables1= ruleTransientSerializeables1 EOF ;
    public final EObject entryRuleTransientSerializeables1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransientSerializeables1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3517:2: (iv_ruleTransientSerializeables1= ruleTransientSerializeables1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3518:2: iv_ruleTransientSerializeables1= ruleTransientSerializeables1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransientSerializeables1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTransientSerializeables1_in_entryRuleTransientSerializeables15275);
            iv_ruleTransientSerializeables1=ruleTransientSerializeables1();
            _fsp--;

             current =iv_ruleTransientSerializeables1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransientSerializeables15285); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3525:1: ruleTransientSerializeables1 returns [EObject current=null] : ( '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? ) ;
    public final EObject ruleTransientSerializeables1() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_3_0=null;
        Token lv_int1_4_0=null;
        Enumerator lv_enum1_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3530:6: ( ( '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3531:1: ( '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3531:1: ( '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3531:3: '#25' ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )? ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )?
            {
            match(input,43,FollowSets000.FOLLOW_43_in_ruleTransientSerializeables15320); 

                    createLeafNode(grammarAccess.getTransientSerializeables1Access().getNumberSignDigitTwoDigitFiveKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3535:1: ( ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID) ) {
                int LA36_1 = input.LA(2);

                if ( ((LA36_1>=44 && LA36_1<=45)) ) {
                    alt36=1;
                }
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3535:2: ( (lv_val1_1_0= RULE_ID ) ) ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3535:2: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3536:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3536:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3537:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransientSerializeables15338); 

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3559:2: ( (lv_enum1_2_0= ruleTransientSerializeables1Enum ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3560:1: (lv_enum1_2_0= ruleTransientSerializeables1Enum )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3560:1: (lv_enum1_2_0= ruleTransientSerializeables1Enum )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3561:3: lv_enum1_2_0= ruleTransientSerializeables1Enum
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTransientSerializeables1Access().getEnum1TransientSerializeables1EnumEnumRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTransientSerializeables1Enum_in_ruleTransientSerializeables15364);
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3583:4: ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3583:5: ( (lv_val2_3_0= RULE_ID ) ) ( (lv_int1_4_0= RULE_INT ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3583:5: ( (lv_val2_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3584:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3584:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3585:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransientSerializeables15384); 

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3607:2: ( (lv_int1_4_0= RULE_INT ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3608:1: (lv_int1_4_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3608:1: (lv_int1_4_0= RULE_INT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3609:3: lv_int1_4_0= RULE_INT
                    {
                    lv_int1_4_0=(Token)input.LT(1);
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTransientSerializeables15406); 

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


    // $ANTLR start ruleTransientSerializeables1Enum
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3639:1: ruleTransientSerializeables1Enum returns [Enumerator current=null] : ( ( 'lit1' ) | ( 'lit2' ) ) ;
    public final Enumerator ruleTransientSerializeables1Enum() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3643:6: ( ( ( 'lit1' ) | ( 'lit2' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3644:1: ( ( 'lit1' ) | ( 'lit2' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3644:1: ( ( 'lit1' ) | ( 'lit2' ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==44) ) {
                alt38=1;
            }
            else if ( (LA38_0==45) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3644:1: ( ( 'lit1' ) | ( 'lit2' ) )", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3644:2: ( 'lit1' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3644:2: ( 'lit1' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3644:4: 'lit1'
                    {
                    match(input,44,FollowSets000.FOLLOW_44_in_ruleTransientSerializeables1Enum5461); 

                            current = grammarAccess.getTransientSerializeables1EnumAccess().getLit1EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTransientSerializeables1EnumAccess().getLit1EnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3650:6: ( 'lit2' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3650:6: ( 'lit2' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:3650:8: 'lit2'
                    {
                    match(input,45,FollowSets000.FOLLOW_45_in_ruleTransientSerializeables1Enum5476); 

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
        public static final BitSet FOLLOW_ruleSimpleGroup_in_entryRuleSimpleGroup815 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleGroup825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleSimpleGroup860 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleGroup877 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleGroup899 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleAlternative_in_entryRuleSimpleAlternative940 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleAlternative950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleSimpleAlternative985 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_13_in_ruleSimpleAlternative997 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAlternative1014 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleSimpleAlternative1037 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAlternative1054 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleMultiplicities_in_entryRuleSimpleMultiplicities1097 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleMultiplicities1107 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleSimpleMultiplicities1142 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1159 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleSimpleMultiplicities1174 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1191 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleSimpleMultiplicities1207 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1224 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_16_in_ruleSimpleMultiplicities1240 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1257 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleGroupMultiplicities_in_entryRuleGroupMultiplicities1299 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroupMultiplicities1309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleGroupMultiplicities1344 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1361 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleGroupMultiplicities1376 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1394 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1416 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleGroupMultiplicities1433 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1451 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1473 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_16_in_ruleGroupMultiplicities1490 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1508 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1530 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleAlternativeMultiplicities_in_entryRuleAlternativeMultiplicities1573 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlternativeMultiplicities1583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleAlternativeMultiplicities1618 = new BitSet(new long[]{0x0000000000006010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1636 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_13_in_ruleAlternativeMultiplicities1658 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1675 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleAlternativeMultiplicities1693 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1711 = new BitSet(new long[]{0x0000000000090010L});
        public static final BitSet FOLLOW_16_in_ruleAlternativeMultiplicities1733 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1750 = new BitSet(new long[]{0x0000000000090010L});
        public static final BitSet FOLLOW_19_in_ruleAlternativeMultiplicities1768 = new BitSet(new long[]{0x0000000000100012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1786 = new BitSet(new long[]{0x0000000000100012L});
        public static final BitSet FOLLOW_20_in_ruleAlternativeMultiplicities1808 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1825 = new BitSet(new long[]{0x0000000000100012L});
        public static final BitSet FOLLOW_ruleAssignedAction_in_entryRuleAssignedAction1869 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignedAction1879 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleAssignedAction1914 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignedAction1931 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignedAction1963 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleAssignedActionSecond_in_entryRuleAssignedActionSecond2006 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignedActionSecond2016 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleAssignedActionSecond2051 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignedActionSecond2068 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleAssignedActionSecond2083 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignedActionSecond2100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedAction1_in_entryRuleUnassignedAction12141 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedAction12151 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleUnassignedAction12195 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction12212 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction12234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedAction2_in_entryRuleUnassignedAction22276 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedAction22286 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleUnassignedAction22330 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction22347 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction22369 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedAction3_in_entryRuleUnassignedAction32411 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedAction32421 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleUnassignedAction32456 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_13_in_ruleUnassignedAction32468 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_14_in_ruleUnassignedAction32495 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction32523 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction32545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall1_in_entryRuleUnassignedRuleCall12587 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedRuleCall12597 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleUnassignedRuleCall12632 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall1Sub_in_ruleUnassignedRuleCall12654 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedRuleCall12670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall1Sub_in_entryRuleUnassignedRuleCall1Sub2711 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedRuleCall1Sub2721 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedRuleCall1Sub2762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall2_in_entryRuleUnassignedRuleCall22802 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedRuleCall22812 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleUnassignedRuleCall22847 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall2Sub_in_ruleUnassignedRuleCall22869 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedRuleCall22885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall2Sub_in_entryRuleUnassignedRuleCall2Sub2926 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedRuleCall2Sub2936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCombination1_in_entryRuleCombination13004 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCombination13014 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleCombination13049 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination13066 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleCombination13082 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination13099 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_14_in_ruleCombination13116 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination13133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination13162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCombination2_in_entryRuleCombination23206 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCombination23216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleCombination23251 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination23268 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_13_in_ruleCombination23285 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination23302 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination23332 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination23354 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleCombination3_in_entryRuleCombination33398 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCombination33408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleCombination33443 = new BitSet(new long[]{0x0000000000000072L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination33461 = new BitSet(new long[]{0x0000000000000072L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleCombination33489 = new BitSet(new long[]{0x0000000000000072L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCombination33517 = new BitSet(new long[]{0x0000000000000072L});
        public static final BitSet FOLLOW_ruleCombination4_in_entryRuleCombination43560 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCombination43570 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleCombination43605 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleCombination43616 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination43633 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination43655 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination43677 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_ruleList1_in_entryRuleList13720 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList13730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleList13765 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList13782 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_ruleList13798 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList13815 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_ruleList2_in_entryRuleList23858 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList23868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleList23903 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList23921 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_ruleList23937 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList23954 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_ruleList3_in_entryRuleList33999 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList34009 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleList34045 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList34063 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_ruleList34079 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList34096 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_16_in_ruleList34122 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList34139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleList4_in_entryRuleList44181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList44191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleList44226 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList44243 = new BitSet(new long[]{0x0000000400010000L});
        public static final BitSet FOLLOW_34_in_ruleList44259 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList44276 = new BitSet(new long[]{0x0000000400010000L});
        public static final BitSet FOLLOW_16_in_ruleList44293 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList44310 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleList5_in_entryRuleList54351 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList54361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleList54396 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList54415 = new BitSet(new long[]{0x0000000400010000L});
        public static final BitSet FOLLOW_34_in_ruleList54431 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList54448 = new BitSet(new long[]{0x0000000400010000L});
        public static final BitSet FOLLOW_16_in_ruleList54465 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList54482 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList54511 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAltList1_in_entryRuleAltList14553 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAltList14563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleAltList14598 = new BitSet(new long[]{0x0000000000006010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList14617 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList14639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleAltList14662 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList14679 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList14701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleAltList14724 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList14741 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList14763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAltList2_in_entryRuleAltList24807 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAltList24817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleAltList24852 = new BitSet(new long[]{0x0000020000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList24871 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList24893 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleAltList24916 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList24933 = new BitSet(new long[]{0x0000000400000010L});
        public static final BitSet FOLLOW_34_in_ruleAltList24949 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList24966 = new BitSet(new long[]{0x0000000400000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAltList24990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransientObject_in_entryRuleTransientObject5033 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransientObject5043 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleTransientObject5078 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransientObject5096 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleTransientObjectSub_in_ruleTransientObject5122 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransientObjectSub_in_entryRuleTransientObjectSub5160 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransientObjectSub5170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransientObjectSub5212 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransientObjectSub5234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransientSerializeables1_in_entryRuleTransientSerializeables15275 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransientSerializeables15285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleTransientSerializeables15320 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransientSerializeables15338 = new BitSet(new long[]{0x0000300000000000L});
        public static final BitSet FOLLOW_ruleTransientSerializeables1Enum_in_ruleTransientSerializeables15364 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransientSerializeables15384 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTransientSerializeables15406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleTransientSerializeables1Enum5461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleTransientSerializeables1Enum5476 = new BitSet(new long[]{0x0000000000000002L});
    }


}