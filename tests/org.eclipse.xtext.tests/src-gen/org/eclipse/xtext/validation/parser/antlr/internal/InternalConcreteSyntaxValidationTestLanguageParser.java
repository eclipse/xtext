package org.eclipse.xtext.validation.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'#2'", "'kw1'", "'kw2'", "'#3'", "'kw3'", "'#4'", "'#5'", "'kw4'", "'kw5'", "'#6'", "'#7'", "'#8'", "'#9'", "'#10'", "'#11'", "'#12'", "'#13'", "'#14'", "'#15'", "'#16'", "'group'", "'#17'", "','", "'#18'", "'#19'"
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:81:1: ruleModel returns [EObject current=null] : ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) ) ;
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


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:86:6: ( ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:87:1: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:87:1: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) )
            int alt1=19;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("87:1: ( ( (lv_x1_0_0= ruleSimpleGroup ) ) | ( (lv_x2_1_0= ruleSimpleAlternative ) ) | ( (lv_x3_2_0= ruleSimpleMultiplicities ) ) | ( (lv_x4_3_0= ruleGroupMultiplicities ) ) | ( (lv_x5_4_0= ruleAlternativeMultiplicities ) ) | ( (lv_x6_5_0= ruleAssignedAction ) ) | ( (lv_x7_6_0= ruleAssignedActionSecond ) ) | ( (lv_x8_7_0= ruleUnassignedAction1 ) ) | ( (lv_x9_8_0= ruleUnassignedAction2 ) ) | ( (lv_x10_9_0= ruleUnassignedAction3 ) ) | ( (lv_x11_10_0= ruleUnassignedRuleCall1 ) ) | ( (lv_x12_11_0= ruleUnassignedRuleCall2 ) ) | ( (lv_x13_12_0= ruleCombination1 ) ) | ( (lv_x14_13_0= ruleCombination2 ) ) | ( (lv_x15_14_0= ruleCombination3 ) ) | ( (lv_x16_15_0= ruleCombination4 ) ) | ( (lv_x17_16_0= ruleList1 ) ) | ( (lv_x18_17_0= ruleList2 ) ) | ( (lv_x19_18_0= ruleList3 ) ) )", 1, 0, input);

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:569:1: entryRuleSimpleGroup returns [EObject current=null] : iv_ruleSimpleGroup= ruleSimpleGroup EOF ;
    public final EObject entryRuleSimpleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleGroup = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:570:2: (iv_ruleSimpleGroup= ruleSimpleGroup EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:571:2: iv_ruleSimpleGroup= ruleSimpleGroup EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleGroupRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleGroup_in_entryRuleSimpleGroup653);
            iv_ruleSimpleGroup=ruleSimpleGroup();
            _fsp--;

             current =iv_ruleSimpleGroup; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleGroup663); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:578:1: ruleSimpleGroup returns [EObject current=null] : ( '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final EObject ruleSimpleGroup() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:583:6: ( ( '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:584:1: ( '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:584:1: ( '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:584:3: '#1' ( (lv_val1_1_0= RULE_ID ) ) ( (lv_val2_2_0= RULE_ID ) )
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleSimpleGroup698); 

                    createLeafNode(grammarAccess.getSimpleGroupAccess().getNumberSignDigitOneKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:588:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:589:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:589:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:590:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleGroup715); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:612:2: ( (lv_val2_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:613:1: (lv_val2_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:613:1: (lv_val2_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:614:3: lv_val2_2_0= RULE_ID
            {
            lv_val2_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleGroup737); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:644:1: entryRuleSimpleAlternative returns [EObject current=null] : iv_ruleSimpleAlternative= ruleSimpleAlternative EOF ;
    public final EObject entryRuleSimpleAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAlternative = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:645:2: (iv_ruleSimpleAlternative= ruleSimpleAlternative EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:646:2: iv_ruleSimpleAlternative= ruleSimpleAlternative EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleAlternativeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleAlternative_in_entryRuleSimpleAlternative778);
            iv_ruleSimpleAlternative=ruleSimpleAlternative();
            _fsp--;

             current =iv_ruleSimpleAlternative; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleAlternative788); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:653:1: ruleSimpleAlternative returns [EObject current=null] : ( '#2' ( ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) ;
    public final EObject ruleSimpleAlternative() throws RecognitionException {
        EObject current = null;

        Token lv_val1_2_0=null;
        Token lv_val2_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:658:6: ( ( '#2' ( ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:659:1: ( '#2' ( ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:659:1: ( '#2' ( ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:659:3: '#2' ( ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
            {
            match(input,12,FollowSets000.FOLLOW_12_in_ruleSimpleAlternative823); 

                    createLeafNode(grammarAccess.getSimpleAlternativeAccess().getNumberSignDigitTwoKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:663:1: ( ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )
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
                    new NoViableAltException("663:1: ( ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) ) | ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) ) )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:663:2: ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:663:2: ( 'kw1' ( (lv_val1_2_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:663:4: 'kw1' ( (lv_val1_2_0= RULE_ID ) )
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleSimpleAlternative835); 

                            createLeafNode(grammarAccess.getSimpleAlternativeAccess().getKw1Keyword_1_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:667:1: ( (lv_val1_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:668:1: (lv_val1_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:668:1: (lv_val1_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:669:3: lv_val1_2_0= RULE_ID
                    {
                    lv_val1_2_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleAlternative852); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:692:6: ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:692:6: ( 'kw2' ( (lv_val2_4_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:692:8: 'kw2' ( (lv_val2_4_0= RULE_ID ) )
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleSimpleAlternative875); 

                            createLeafNode(grammarAccess.getSimpleAlternativeAccess().getKw2Keyword_1_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:696:1: ( (lv_val2_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:697:1: (lv_val2_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:697:1: (lv_val2_4_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:698:3: lv_val2_4_0= RULE_ID
                    {
                    lv_val2_4_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleAlternative892); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:728:1: entryRuleSimpleMultiplicities returns [EObject current=null] : iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF ;
    public final EObject entryRuleSimpleMultiplicities() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleMultiplicities = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:729:2: (iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:730:2: iv_ruleSimpleMultiplicities= ruleSimpleMultiplicities EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleMultiplicitiesRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleMultiplicities_in_entryRuleSimpleMultiplicities935);
            iv_ruleSimpleMultiplicities=ruleSimpleMultiplicities();
            _fsp--;

             current =iv_ruleSimpleMultiplicities; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleMultiplicities945); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:737:1: ruleSimpleMultiplicities returns [EObject current=null] : ( '#3' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) )? 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) ;
    public final EObject ruleSimpleMultiplicities() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_3_0=null;
        Token lv_val3_5_0=null;
        Token lv_val4_7_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:742:6: ( ( '#3' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) )? 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ 'kw3' ( (lv_val4_7_0= RULE_ID ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:743:1: ( '#3' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) )? 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:743:1: ( '#3' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) )? 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ 'kw3' ( (lv_val4_7_0= RULE_ID ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:743:3: '#3' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) )? 'kw2' ( (lv_val3_5_0= RULE_ID ) )+ 'kw3' ( (lv_val4_7_0= RULE_ID ) )*
            {
            match(input,15,FollowSets000.FOLLOW_15_in_ruleSimpleMultiplicities980); 

                    createLeafNode(grammarAccess.getSimpleMultiplicitiesAccess().getNumberSignDigitThreeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:747:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:748:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:748:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:749:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities997); 

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

            match(input,13,FollowSets000.FOLLOW_13_in_ruleSimpleMultiplicities1012); 

                    createLeafNode(grammarAccess.getSimpleMultiplicitiesAccess().getKw1Keyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:775:1: ( (lv_val2_3_0= RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:776:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:776:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:777:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1029); 

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

            match(input,14,FollowSets000.FOLLOW_14_in_ruleSimpleMultiplicities1045); 

                    createLeafNode(grammarAccess.getSimpleMultiplicitiesAccess().getKw2Keyword_4(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:803:1: ( (lv_val3_5_0= RULE_ID ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:804:1: (lv_val3_5_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:804:1: (lv_val3_5_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:805:3: lv_val3_5_0= RULE_ID
            	    {
            	    lv_val3_5_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1062); 

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

            match(input,16,FollowSets000.FOLLOW_16_in_ruleSimpleMultiplicities1078); 

                    createLeafNode(grammarAccess.getSimpleMultiplicitiesAccess().getKw3Keyword_6(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:831:1: ( (lv_val4_7_0= RULE_ID ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:832:1: (lv_val4_7_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:832:1: (lv_val4_7_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:833:3: lv_val4_7_0= RULE_ID
            	    {
            	    lv_val4_7_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1095); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:863:1: entryRuleGroupMultiplicities returns [EObject current=null] : iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF ;
    public final EObject entryRuleGroupMultiplicities() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupMultiplicities = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:864:2: (iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:865:2: iv_ruleGroupMultiplicities= ruleGroupMultiplicities EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGroupMultiplicitiesRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleGroupMultiplicities_in_entryRuleGroupMultiplicities1137);
            iv_ruleGroupMultiplicities=ruleGroupMultiplicities();
            _fsp--;

             current =iv_ruleGroupMultiplicities; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroupMultiplicities1147); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:872:1: ruleGroupMultiplicities returns [EObject current=null] : ( '#4' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:877:6: ( ( '#4' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:878:1: ( '#4' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:878:1: ( '#4' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:878:3: '#4' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )? 'kw2' ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+ 'kw3' ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            {
            match(input,17,FollowSets000.FOLLOW_17_in_ruleGroupMultiplicities1182); 

                    createLeafNode(grammarAccess.getGroupMultiplicitiesAccess().getNumberSignDigitFourKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:882:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:883:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:883:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:884:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1199); 

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

            match(input,13,FollowSets000.FOLLOW_13_in_ruleGroupMultiplicities1214); 

                    createLeafNode(grammarAccess.getGroupMultiplicitiesAccess().getKw1Keyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:910:1: ( ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:910:2: ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:910:2: ( (lv_val2_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:911:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:911:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:912:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1232); 

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:934:2: ( (lv_val3_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:935:1: (lv_val3_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:935:1: (lv_val3_4_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:936:3: lv_val3_4_0= RULE_ID
                    {
                    lv_val3_4_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1254); 

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

            match(input,14,FollowSets000.FOLLOW_14_in_ruleGroupMultiplicities1271); 

                    createLeafNode(grammarAccess.getGroupMultiplicitiesAccess().getKw2Keyword_4(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:962:1: ( ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:962:2: ( (lv_val4_6_0= RULE_ID ) ) ( (lv_val5_7_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:962:2: ( (lv_val4_6_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:963:1: (lv_val4_6_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:963:1: (lv_val4_6_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:964:3: lv_val4_6_0= RULE_ID
            	    {
            	    lv_val4_6_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1289); 

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

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:986:2: ( (lv_val5_7_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:987:1: (lv_val5_7_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:987:1: (lv_val5_7_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:988:3: lv_val5_7_0= RULE_ID
            	    {
            	    lv_val5_7_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1311); 

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

            match(input,16,FollowSets000.FOLLOW_16_in_ruleGroupMultiplicities1328); 

                    createLeafNode(grammarAccess.getGroupMultiplicitiesAccess().getKw3Keyword_6(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1014:1: ( ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1014:2: ( (lv_val6_9_0= RULE_ID ) ) ( (lv_val7_10_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1014:2: ( (lv_val6_9_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1015:1: (lv_val6_9_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1015:1: (lv_val6_9_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1016:3: lv_val6_9_0= RULE_ID
            	    {
            	    lv_val6_9_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1346); 

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

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1038:2: ( (lv_val7_10_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1039:1: (lv_val7_10_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1039:1: (lv_val7_10_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1040:3: lv_val7_10_0= RULE_ID
            	    {
            	    lv_val7_10_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupMultiplicities1368); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1070:1: entryRuleAlternativeMultiplicities returns [EObject current=null] : iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF ;
    public final EObject entryRuleAlternativeMultiplicities() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternativeMultiplicities = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1071:2: (iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1072:2: iv_ruleAlternativeMultiplicities= ruleAlternativeMultiplicities EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAlternativeMultiplicitiesRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternativeMultiplicities_in_entryRuleAlternativeMultiplicities1411);
            iv_ruleAlternativeMultiplicities=ruleAlternativeMultiplicities();
            _fsp--;

             current =iv_ruleAlternativeMultiplicities; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlternativeMultiplicities1421); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1079:1: ruleAlternativeMultiplicities returns [EObject current=null] : ( '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1084:6: ( ( '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1085:1: ( '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1085:1: ( '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1085:3: '#5' ( ( (lv_val2_1_0= RULE_ID ) ) | ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )? 'kw2' ( ( (lv_val4_5_0= RULE_ID ) ) | ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+ 'kw4' ( ( (lv_val6_9_0= RULE_ID ) ) | ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
            {
            match(input,18,FollowSets000.FOLLOW_18_in_ruleAlternativeMultiplicities1456); 

                    createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getNumberSignDigitFiveKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1089:1: ( ( (lv_val2_1_0= RULE_ID ) ) | ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) ) )?
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1089:2: ( (lv_val2_1_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1089:2: ( (lv_val2_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1090:1: (lv_val2_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1090:1: (lv_val2_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1091:3: lv_val2_1_0= RULE_ID
                    {
                    lv_val2_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1474); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1114:6: ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1114:6: ( 'kw1' ( (lv_val3_3_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1114:8: 'kw1' ( (lv_val3_3_0= RULE_ID ) )
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleAlternativeMultiplicities1496); 

                            createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getKw1Keyword_1_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1118:1: ( (lv_val3_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1119:1: (lv_val3_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1119:1: (lv_val3_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1120:3: lv_val3_3_0= RULE_ID
                    {
                    lv_val3_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1513); 

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

            match(input,14,FollowSets000.FOLLOW_14_in_ruleAlternativeMultiplicities1531); 

                    createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getKw2Keyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1146:1: ( ( (lv_val4_5_0= RULE_ID ) ) | ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1146:2: ( (lv_val4_5_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1146:2: ( (lv_val4_5_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1147:1: (lv_val4_5_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1147:1: (lv_val4_5_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1148:3: lv_val4_5_0= RULE_ID
            	    {
            	    lv_val4_5_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1549); 

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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1171:6: ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1171:6: ( 'kw3' ( (lv_val5_7_0= RULE_ID ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1171:8: 'kw3' ( (lv_val5_7_0= RULE_ID ) )
            	    {
            	    match(input,16,FollowSets000.FOLLOW_16_in_ruleAlternativeMultiplicities1571); 

            	            createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getKw3Keyword_3_1_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1175:1: ( (lv_val5_7_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1176:1: (lv_val5_7_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1176:1: (lv_val5_7_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1177:3: lv_val5_7_0= RULE_ID
            	    {
            	    lv_val5_7_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1588); 

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

            match(input,19,FollowSets000.FOLLOW_19_in_ruleAlternativeMultiplicities1606); 

                    createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getKw4Keyword_4(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1203:1: ( ( (lv_val6_9_0= RULE_ID ) ) | ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) ) )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1203:2: ( (lv_val6_9_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1203:2: ( (lv_val6_9_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1204:1: (lv_val6_9_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1204:1: (lv_val6_9_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1205:3: lv_val6_9_0= RULE_ID
            	    {
            	    lv_val6_9_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1624); 

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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1228:6: ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1228:6: ( 'kw5' ( (lv_val7_11_0= RULE_ID ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1228:8: 'kw5' ( (lv_val7_11_0= RULE_ID ) )
            	    {
            	    match(input,20,FollowSets000.FOLLOW_20_in_ruleAlternativeMultiplicities1646); 

            	            createLeafNode(grammarAccess.getAlternativeMultiplicitiesAccess().getKw5Keyword_5_1_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1232:1: ( (lv_val7_11_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1233:1: (lv_val7_11_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1233:1: (lv_val7_11_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1234:3: lv_val7_11_0= RULE_ID
            	    {
            	    lv_val7_11_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1663); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1264:1: entryRuleAssignedAction returns [EObject current=null] : iv_ruleAssignedAction= ruleAssignedAction EOF ;
    public final EObject entryRuleAssignedAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignedAction = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1265:2: (iv_ruleAssignedAction= ruleAssignedAction EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1266:2: iv_ruleAssignedAction= ruleAssignedAction EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignedActionRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignedAction_in_entryRuleAssignedAction1707);
            iv_ruleAssignedAction=ruleAssignedAction();
            _fsp--;

             current =iv_ruleAssignedAction; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignedAction1717); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1273:1: ruleAssignedAction returns [EObject current=null] : ( '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ ) ;
    public final EObject ruleAssignedAction() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val1_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1278:6: ( ( '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1279:1: ( '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1279:1: ( '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1279:3: '#6' ( (lv_val1_1_0= RULE_ID ) ) ( () ( (lv_val1_3_0= RULE_ID ) ) )+
            {
            match(input,21,FollowSets000.FOLLOW_21_in_ruleAssignedAction1752); 

                    createLeafNode(grammarAccess.getAssignedActionAccess().getNumberSignDigitSixKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1283:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1284:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1284:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1285:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignedAction1769); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1307:2: ( () ( (lv_val1_3_0= RULE_ID ) ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1307:3: () ( (lv_val1_3_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1307:3: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1308:5: 
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

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1323:2: ( (lv_val1_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1324:1: (lv_val1_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1324:1: (lv_val1_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1325:3: lv_val1_3_0= RULE_ID
            	    {
            	    lv_val1_3_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignedAction1801); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1355:1: entryRuleAssignedActionSecond returns [EObject current=null] : iv_ruleAssignedActionSecond= ruleAssignedActionSecond EOF ;
    public final EObject entryRuleAssignedActionSecond() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignedActionSecond = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1356:2: (iv_ruleAssignedActionSecond= ruleAssignedActionSecond EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1357:2: iv_ruleAssignedActionSecond= ruleAssignedActionSecond EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssignedActionSecondRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignedActionSecond_in_entryRuleAssignedActionSecond1844);
            iv_ruleAssignedActionSecond=ruleAssignedActionSecond();
            _fsp--;

             current =iv_ruleAssignedActionSecond; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignedActionSecond1854); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1364:1: ruleAssignedActionSecond returns [EObject current=null] : ( '#7' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) ;
    public final EObject ruleAssignedActionSecond() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1369:6: ( ( '#7' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1370:1: ( '#7' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1370:1: ( '#7' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1370:3: '#7' ( (lv_val1_1_0= RULE_ID ) ) 'kw1' ( (lv_val2_3_0= RULE_ID ) )
            {
            match(input,22,FollowSets000.FOLLOW_22_in_ruleAssignedActionSecond1889); 

                    createLeafNode(grammarAccess.getAssignedActionSecondAccess().getNumberSignDigitSevenKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1374:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1375:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1375:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1376:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignedActionSecond1906); 

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

            match(input,13,FollowSets000.FOLLOW_13_in_ruleAssignedActionSecond1921); 

                    createLeafNode(grammarAccess.getAssignedActionSecondAccess().getKw1Keyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1402:1: ( (lv_val2_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1403:1: (lv_val2_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1403:1: (lv_val2_3_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1404:3: lv_val2_3_0= RULE_ID
            {
            lv_val2_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignedActionSecond1938); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1434:1: entryRuleUnassignedAction1 returns [EObject current=null] : iv_ruleUnassignedAction1= ruleUnassignedAction1 EOF ;
    public final EObject entryRuleUnassignedAction1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedAction1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1435:2: (iv_ruleUnassignedAction1= ruleUnassignedAction1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1436:2: iv_ruleUnassignedAction1= ruleUnassignedAction1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedAction1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction1_in_entryRuleUnassignedAction11979);
            iv_ruleUnassignedAction1=ruleUnassignedAction1();
            _fsp--;

             current =iv_ruleUnassignedAction1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedAction11989); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1443:1: ruleUnassignedAction1 returns [EObject current=null] : ( () '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) ;
    public final EObject ruleUnassignedAction1() throws RecognitionException {
        EObject current = null;

        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1448:6: ( ( () '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1449:1: ( () '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1449:1: ( () '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1449:2: () '#8' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1449:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1450:5: 
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

            match(input,23,FollowSets000.FOLLOW_23_in_ruleUnassignedAction12033); 

                    createLeafNode(grammarAccess.getUnassignedAction1Access().getNumberSignDigitEightKeyword_1(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1464:1: ( (lv_val1_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1465:1: (lv_val1_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1465:1: (lv_val1_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1466:3: lv_val1_2_0= RULE_ID
            {
            lv_val1_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction12050); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1488:2: ( (lv_val2_3_0= RULE_ID ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1489:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1489:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1490:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction12072); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1520:1: entryRuleUnassignedAction2 returns [EObject current=null] : iv_ruleUnassignedAction2= ruleUnassignedAction2 EOF ;
    public final EObject entryRuleUnassignedAction2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedAction2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1521:2: (iv_ruleUnassignedAction2= ruleUnassignedAction2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1522:2: iv_ruleUnassignedAction2= ruleUnassignedAction2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedAction2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction2_in_entryRuleUnassignedAction22114);
            iv_ruleUnassignedAction2=ruleUnassignedAction2();
            _fsp--;

             current =iv_ruleUnassignedAction2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedAction22124); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1529:1: ruleUnassignedAction2 returns [EObject current=null] : ( () '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) ;
    public final EObject ruleUnassignedAction2() throws RecognitionException {
        EObject current = null;

        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1534:6: ( ( () '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1535:1: ( () '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1535:1: ( () '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1535:2: () '#9' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1535:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1536:5: 
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

            match(input,24,FollowSets000.FOLLOW_24_in_ruleUnassignedAction22168); 

                    createLeafNode(grammarAccess.getUnassignedAction2Access().getNumberSignDigitNineKeyword_1(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1550:1: ( (lv_val1_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1551:1: (lv_val1_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1551:1: (lv_val1_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1552:3: lv_val1_2_0= RULE_ID
            {
            lv_val1_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction22185); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1574:2: ( (lv_val2_3_0= RULE_ID ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1575:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1575:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1576:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction22207); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1606:1: entryRuleUnassignedAction3 returns [EObject current=null] : iv_ruleUnassignedAction3= ruleUnassignedAction3 EOF ;
    public final EObject entryRuleUnassignedAction3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedAction3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1607:2: (iv_ruleUnassignedAction3= ruleUnassignedAction3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1608:2: iv_ruleUnassignedAction3= ruleUnassignedAction3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedAction3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedAction3_in_entryRuleUnassignedAction32249);
            iv_ruleUnassignedAction3=ruleUnassignedAction3();
            _fsp--;

             current =iv_ruleUnassignedAction3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedAction32259); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1615:1: ruleUnassignedAction3 returns [EObject current=null] : ( '#10' ( ( 'kw1' () ) | ( 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? ) ;
    public final EObject ruleUnassignedAction3() throws RecognitionException {
        EObject current = null;

        Token lv_val1_5_0=null;
        Token lv_val2_6_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1620:6: ( ( '#10' ( ( 'kw1' () ) | ( 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1621:1: ( '#10' ( ( 'kw1' () ) | ( 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1621:1: ( '#10' ( ( 'kw1' () ) | ( 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1621:3: '#10' ( ( 'kw1' () ) | ( 'kw2' () ) ) ( (lv_val1_5_0= RULE_ID ) ) ( (lv_val2_6_0= RULE_ID ) )?
            {
            match(input,25,FollowSets000.FOLLOW_25_in_ruleUnassignedAction32294); 

                    createLeafNode(grammarAccess.getUnassignedAction3Access().getNumberSignDigitOneDigitZeroKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1625:1: ( ( 'kw1' () ) | ( 'kw2' () ) )
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
                    new NoViableAltException("1625:1: ( ( 'kw1' () ) | ( 'kw2' () ) )", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1625:2: ( 'kw1' () )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1625:2: ( 'kw1' () )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1625:4: 'kw1' ()
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleUnassignedAction32306); 

                            createLeafNode(grammarAccess.getUnassignedAction3Access().getKw1Keyword_1_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1629:1: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1630:5: 
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1641:6: ( 'kw2' () )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1641:6: ( 'kw2' () )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1641:8: 'kw2' ()
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleUnassignedAction32333); 

                            createLeafNode(grammarAccess.getUnassignedAction3Access().getKw2Keyword_1_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1645:1: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1646:5: 
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1656:4: ( (lv_val1_5_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1657:1: (lv_val1_5_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1657:1: (lv_val1_5_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1658:3: lv_val1_5_0= RULE_ID
            {
            lv_val1_5_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction32361); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1680:2: ( (lv_val2_6_0= RULE_ID ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1681:1: (lv_val2_6_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1681:1: (lv_val2_6_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1682:3: lv_val2_6_0= RULE_ID
                    {
                    lv_val2_6_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedAction32383); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1712:1: entryRuleUnassignedRuleCall1 returns [EObject current=null] : iv_ruleUnassignedRuleCall1= ruleUnassignedRuleCall1 EOF ;
    public final EObject entryRuleUnassignedRuleCall1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedRuleCall1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1713:2: (iv_ruleUnassignedRuleCall1= ruleUnassignedRuleCall1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1714:2: iv_ruleUnassignedRuleCall1= ruleUnassignedRuleCall1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedRuleCall1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall1_in_entryRuleUnassignedRuleCall12425);
            iv_ruleUnassignedRuleCall1=ruleUnassignedRuleCall1();
            _fsp--;

             current =iv_ruleUnassignedRuleCall1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedRuleCall12435); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1721:1: ruleUnassignedRuleCall1 returns [EObject current=null] : ( '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final EObject ruleUnassignedRuleCall1() throws RecognitionException {
        EObject current = null;

        Token lv_val2_2_0=null;
        EObject this_UnassignedRuleCall1Sub_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1726:6: ( ( '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1727:1: ( '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1727:1: ( '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1727:3: '#11' this_UnassignedRuleCall1Sub_1= ruleUnassignedRuleCall1Sub ( (lv_val2_2_0= RULE_ID ) )
            {
            match(input,26,FollowSets000.FOLLOW_26_in_ruleUnassignedRuleCall12470); 

                    createLeafNode(grammarAccess.getUnassignedRuleCall1Access().getNumberSignDigitOneDigitOneKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getUnassignedRuleCall1Access().getUnassignedRuleCall1SubParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall1Sub_in_ruleUnassignedRuleCall12492);
            this_UnassignedRuleCall1Sub_1=ruleUnassignedRuleCall1Sub();
            _fsp--;

             
                    current = this_UnassignedRuleCall1Sub_1; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1740:1: ( (lv_val2_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1741:1: (lv_val2_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1741:1: (lv_val2_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1742:3: lv_val2_2_0= RULE_ID
            {
            lv_val2_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedRuleCall12508); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1772:1: entryRuleUnassignedRuleCall1Sub returns [EObject current=null] : iv_ruleUnassignedRuleCall1Sub= ruleUnassignedRuleCall1Sub EOF ;
    public final EObject entryRuleUnassignedRuleCall1Sub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedRuleCall1Sub = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1773:2: (iv_ruleUnassignedRuleCall1Sub= ruleUnassignedRuleCall1Sub EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1774:2: iv_ruleUnassignedRuleCall1Sub= ruleUnassignedRuleCall1Sub EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedRuleCall1SubRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall1Sub_in_entryRuleUnassignedRuleCall1Sub2549);
            iv_ruleUnassignedRuleCall1Sub=ruleUnassignedRuleCall1Sub();
            _fsp--;

             current =iv_ruleUnassignedRuleCall1Sub; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedRuleCall1Sub2559); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1781:1: ruleUnassignedRuleCall1Sub returns [EObject current=null] : ( (lv_val1_0_0= RULE_ID ) ) ;
    public final EObject ruleUnassignedRuleCall1Sub() throws RecognitionException {
        EObject current = null;

        Token lv_val1_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1786:6: ( ( (lv_val1_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1787:1: ( (lv_val1_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1787:1: ( (lv_val1_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1788:1: (lv_val1_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1788:1: (lv_val1_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1789:3: lv_val1_0_0= RULE_ID
            {
            lv_val1_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedRuleCall1Sub2600); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1819:1: entryRuleUnassignedRuleCall2 returns [EObject current=null] : iv_ruleUnassignedRuleCall2= ruleUnassignedRuleCall2 EOF ;
    public final EObject entryRuleUnassignedRuleCall2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedRuleCall2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1820:2: (iv_ruleUnassignedRuleCall2= ruleUnassignedRuleCall2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1821:2: iv_ruleUnassignedRuleCall2= ruleUnassignedRuleCall2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedRuleCall2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall2_in_entryRuleUnassignedRuleCall22640);
            iv_ruleUnassignedRuleCall2=ruleUnassignedRuleCall2();
            _fsp--;

             current =iv_ruleUnassignedRuleCall2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedRuleCall22650); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1828:1: ruleUnassignedRuleCall2 returns [EObject current=null] : ( '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) ) ;
    public final EObject ruleUnassignedRuleCall2() throws RecognitionException {
        EObject current = null;

        Token lv_val2_2_0=null;
        EObject this_UnassignedRuleCall2Sub_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1833:6: ( ( '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1834:1: ( '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1834:1: ( '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1834:3: '#12' this_UnassignedRuleCall2Sub_1= ruleUnassignedRuleCall2Sub ( (lv_val2_2_0= RULE_ID ) )
            {
            match(input,27,FollowSets000.FOLLOW_27_in_ruleUnassignedRuleCall22685); 

                    createLeafNode(grammarAccess.getUnassignedRuleCall2Access().getNumberSignDigitOneDigitTwoKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getUnassignedRuleCall2Access().getUnassignedRuleCall2SubParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall2Sub_in_ruleUnassignedRuleCall22707);
            this_UnassignedRuleCall2Sub_1=ruleUnassignedRuleCall2Sub();
            _fsp--;

             
                    current = this_UnassignedRuleCall2Sub_1; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1847:1: ( (lv_val2_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1848:1: (lv_val2_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1848:1: (lv_val2_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1849:3: lv_val2_2_0= RULE_ID
            {
            lv_val2_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnassignedRuleCall22723); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1879:1: entryRuleUnassignedRuleCall2Sub returns [EObject current=null] : iv_ruleUnassignedRuleCall2Sub= ruleUnassignedRuleCall2Sub EOF ;
    public final EObject entryRuleUnassignedRuleCall2Sub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassignedRuleCall2Sub = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1880:2: (iv_ruleUnassignedRuleCall2Sub= ruleUnassignedRuleCall2Sub EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1881:2: iv_ruleUnassignedRuleCall2Sub= ruleUnassignedRuleCall2Sub EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnassignedRuleCall2SubRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassignedRuleCall2Sub_in_entryRuleUnassignedRuleCall2Sub2764);
            iv_ruleUnassignedRuleCall2Sub=ruleUnassignedRuleCall2Sub();
            _fsp--;

             current =iv_ruleUnassignedRuleCall2Sub; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassignedRuleCall2Sub2774); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1888:1: ruleUnassignedRuleCall2Sub returns [EObject current=null] : () ;
    public final EObject ruleUnassignedRuleCall2Sub() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1893:6: ( () )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1894:1: ()
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1894:1: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1895:5: 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1913:1: entryRuleCombination1 returns [EObject current=null] : iv_ruleCombination1= ruleCombination1 EOF ;
    public final EObject entryRuleCombination1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombination1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1914:2: (iv_ruleCombination1= ruleCombination1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1915:2: iv_ruleCombination1= ruleCombination1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCombination1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCombination1_in_entryRuleCombination12842);
            iv_ruleCombination1=ruleCombination1();
            _fsp--;

             current =iv_ruleCombination1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCombination12852); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1922:1: ruleCombination1 returns [EObject current=null] : ( '#13' ( (lv_val1_1_0= RULE_ID ) ) ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? ) ;
    public final EObject ruleCombination1() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_3_0=null;
        Token lv_val3_5_0=null;
        Token lv_val4_6_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1927:6: ( ( '#13' ( (lv_val1_1_0= RULE_ID ) ) ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1928:1: ( '#13' ( (lv_val1_1_0= RULE_ID ) ) ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1928:1: ( '#13' ( (lv_val1_1_0= RULE_ID ) ) ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1928:3: '#13' ( (lv_val1_1_0= RULE_ID ) ) ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )?
            {
            match(input,28,FollowSets000.FOLLOW_28_in_ruleCombination12887); 

                    createLeafNode(grammarAccess.getCombination1Access().getNumberSignDigitOneDigitThreeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1932:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1933:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1933:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1934:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination12904); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1956:2: ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==13) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1956:4: 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) )
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleCombination12920); 

                            createLeafNode(grammarAccess.getCombination1Access().getKw1Keyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1960:1: ( (lv_val2_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1961:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1961:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1962:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination12937); 

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1984:2: ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) )
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
                            new NoViableAltException("1984:2: ( ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) ) | ( (lv_val4_6_0= RULE_ID ) ) )", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1984:3: ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1984:3: ( 'kw2' ( (lv_val3_5_0= RULE_ID ) ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1984:5: 'kw2' ( (lv_val3_5_0= RULE_ID ) )
                            {
                            match(input,14,FollowSets000.FOLLOW_14_in_ruleCombination12954); 

                                    createLeafNode(grammarAccess.getCombination1Access().getKw2Keyword_2_2_0_0(), null); 
                                
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1988:1: ( (lv_val3_5_0= RULE_ID ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1989:1: (lv_val3_5_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1989:1: (lv_val3_5_0= RULE_ID )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:1990:3: lv_val3_5_0= RULE_ID
                            {
                            lv_val3_5_0=(Token)input.LT(1);
                            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination12971); 

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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2013:6: ( (lv_val4_6_0= RULE_ID ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2013:6: ( (lv_val4_6_0= RULE_ID ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2014:1: (lv_val4_6_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2014:1: (lv_val4_6_0= RULE_ID )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2015:3: lv_val4_6_0= RULE_ID
                            {
                            lv_val4_6_0=(Token)input.LT(1);
                            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination13000); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2045:1: entryRuleCombination2 returns [EObject current=null] : iv_ruleCombination2= ruleCombination2 EOF ;
    public final EObject entryRuleCombination2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombination2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2046:2: (iv_ruleCombination2= ruleCombination2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2047:2: iv_ruleCombination2= ruleCombination2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCombination2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCombination2_in_entryRuleCombination23044);
            iv_ruleCombination2=ruleCombination2();
            _fsp--;

             current =iv_ruleCombination2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCombination23054); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2054:1: ruleCombination2 returns [EObject current=null] : ( '#14' ( (lv_val1_1_0= RULE_ID ) ) ( ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) ) ;
    public final EObject ruleCombination2() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_3_0=null;
        Token lv_val3_4_0=null;
        Token lv_val4_5_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2059:6: ( ( '#14' ( (lv_val1_1_0= RULE_ID ) ) ( ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2060:1: ( '#14' ( (lv_val1_1_0= RULE_ID ) ) ( ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2060:1: ( '#14' ( (lv_val1_1_0= RULE_ID ) ) ( ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2060:3: '#14' ( (lv_val1_1_0= RULE_ID ) ) ( ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* )
            {
            match(input,29,FollowSets000.FOLLOW_29_in_ruleCombination23089); 

                    createLeafNode(grammarAccess.getCombination2Access().getNumberSignDigitOneDigitFourKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2064:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2065:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2065:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2066:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination23106); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2088:2: ( ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* )
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
                    new NoViableAltException("2088:2: ( ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) ) | ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )* )", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2088:3: ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2088:3: ( 'kw1' ( (lv_val2_3_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2088:5: 'kw1' ( (lv_val2_3_0= RULE_ID ) )
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleCombination23123); 

                            createLeafNode(grammarAccess.getCombination2Access().getKw1Keyword_2_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2092:1: ( (lv_val2_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2093:1: (lv_val2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2093:1: (lv_val2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2094:3: lv_val2_3_0= RULE_ID
                    {
                    lv_val2_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination23140); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2117:6: ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2117:6: ( ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==RULE_ID) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2117:7: ( (lv_val3_4_0= RULE_ID ) ) ( (lv_val4_5_0= RULE_ID ) )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2117:7: ( (lv_val3_4_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2118:1: (lv_val3_4_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2118:1: (lv_val3_4_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2119:3: lv_val3_4_0= RULE_ID
                    	    {
                    	    lv_val3_4_0=(Token)input.LT(1);
                    	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination23170); 

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

                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2141:2: ( (lv_val4_5_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2142:1: (lv_val4_5_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2142:1: (lv_val4_5_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2143:3: lv_val4_5_0= RULE_ID
                    	    {
                    	    lv_val4_5_0=(Token)input.LT(1);
                    	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination23192); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2173:1: entryRuleCombination3 returns [EObject current=null] : iv_ruleCombination3= ruleCombination3 EOF ;
    public final EObject entryRuleCombination3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombination3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2174:2: (iv_ruleCombination3= ruleCombination3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2175:2: iv_ruleCombination3= ruleCombination3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCombination3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCombination3_in_entryRuleCombination33236);
            iv_ruleCombination3=ruleCombination3();
            _fsp--;

             current =iv_ruleCombination3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCombination33246); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2182:1: ruleCombination3 returns [EObject current=null] : ( '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* ) ;
    public final EObject ruleCombination3() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val2_2_0=null;
        Token lv_val3_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2187:6: ( ( '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2188:1: ( '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2188:1: ( '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2188:3: '#15' ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )*
            {
            match(input,30,FollowSets000.FOLLOW_30_in_ruleCombination33281); 

                    createLeafNode(grammarAccess.getCombination3Access().getNumberSignDigitOneDigitFiveKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2192:1: ( ( (lv_val1_1_0= RULE_ID ) ) | ( (lv_val2_2_0= RULE_INT ) ) | ( (lv_val3_3_0= RULE_STRING ) ) )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2192:2: ( (lv_val1_1_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2192:2: ( (lv_val1_1_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2193:1: (lv_val1_1_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2193:1: (lv_val1_1_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2194:3: lv_val1_1_0= RULE_ID
            	    {
            	    lv_val1_1_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination33299); 

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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2217:6: ( (lv_val2_2_0= RULE_INT ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2217:6: ( (lv_val2_2_0= RULE_INT ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2218:1: (lv_val2_2_0= RULE_INT )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2218:1: (lv_val2_2_0= RULE_INT )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2219:3: lv_val2_2_0= RULE_INT
            	    {
            	    lv_val2_2_0=(Token)input.LT(1);
            	    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleCombination33327); 

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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2242:6: ( (lv_val3_3_0= RULE_STRING ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2242:6: ( (lv_val3_3_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2243:1: (lv_val3_3_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2243:1: (lv_val3_3_0= RULE_STRING )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2244:3: lv_val3_3_0= RULE_STRING
            	    {
            	    lv_val3_3_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCombination33355); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2274:1: entryRuleCombination4 returns [EObject current=null] : iv_ruleCombination4= ruleCombination4 EOF ;
    public final EObject entryRuleCombination4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombination4 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2275:2: (iv_ruleCombination4= ruleCombination4 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2276:2: iv_ruleCombination4= ruleCombination4 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCombination4Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCombination4_in_entryRuleCombination43398);
            iv_ruleCombination4=ruleCombination4();
            _fsp--;

             current =iv_ruleCombination4; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCombination43408); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2283:1: ruleCombination4 returns [EObject current=null] : ( '#16' ( 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ ) ;
    public final EObject ruleCombination4() throws RecognitionException {
        EObject current = null;

        Token lv_val1_2_0=null;
        Token lv_val2_3_0=null;
        Token lv_val3_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2288:6: ( ( '#16' ( 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2289:1: ( '#16' ( 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2289:1: ( '#16' ( 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2289:3: '#16' ( 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+
            {
            match(input,31,FollowSets000.FOLLOW_31_in_ruleCombination43443); 

                    createLeafNode(grammarAccess.getCombination4Access().getNumberSignDigitOneDigitSixKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2293:1: ( 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2293:3: 'group' ( (lv_val1_2_0= RULE_ID ) ) ( (lv_val2_3_0= RULE_ID ) ) ( (lv_val3_4_0= RULE_ID ) )
            	    {
            	    match(input,32,FollowSets000.FOLLOW_32_in_ruleCombination43454); 

            	            createLeafNode(grammarAccess.getCombination4Access().getGroupKeyword_1_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2297:1: ( (lv_val1_2_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2298:1: (lv_val1_2_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2298:1: (lv_val1_2_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2299:3: lv_val1_2_0= RULE_ID
            	    {
            	    lv_val1_2_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination43471); 

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

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2321:2: ( (lv_val2_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2322:1: (lv_val2_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2322:1: (lv_val2_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2323:3: lv_val2_3_0= RULE_ID
            	    {
            	    lv_val2_3_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination43493); 

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

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2345:2: ( (lv_val3_4_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2346:1: (lv_val3_4_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2346:1: (lv_val3_4_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2347:3: lv_val3_4_0= RULE_ID
            	    {
            	    lv_val3_4_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCombination43515); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2377:1: entryRuleList1 returns [EObject current=null] : iv_ruleList1= ruleList1 EOF ;
    public final EObject entryRuleList1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2378:2: (iv_ruleList1= ruleList1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2379:2: iv_ruleList1= ruleList1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getList1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleList1_in_entryRuleList13558);
            iv_ruleList1=ruleList1();
            _fsp--;

             current =iv_ruleList1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList13568); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2386:1: ruleList1 returns [EObject current=null] : ( '#17' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ;
    public final EObject ruleList1() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val1_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2391:6: ( ( '#17' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2392:1: ( '#17' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2392:1: ( '#17' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2392:3: '#17' ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            {
            match(input,33,FollowSets000.FOLLOW_33_in_ruleList13603); 

                    createLeafNode(grammarAccess.getList1Access().getNumberSignDigitOneDigitSevenKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2396:1: ( (lv_val1_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2397:1: (lv_val1_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2397:1: (lv_val1_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2398:3: lv_val1_1_0= RULE_ID
            {
            lv_val1_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList13620); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2420:2: ( ',' ( (lv_val1_3_0= RULE_ID ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==34) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2420:4: ',' ( (lv_val1_3_0= RULE_ID ) )
            	    {
            	    match(input,34,FollowSets000.FOLLOW_34_in_ruleList13636); 

            	            createLeafNode(grammarAccess.getList1Access().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2424:1: ( (lv_val1_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2425:1: (lv_val1_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2425:1: (lv_val1_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2426:3: lv_val1_3_0= RULE_ID
            	    {
            	    lv_val1_3_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList13653); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2456:1: entryRuleList2 returns [EObject current=null] : iv_ruleList2= ruleList2 EOF ;
    public final EObject entryRuleList2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2457:2: (iv_ruleList2= ruleList2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2458:2: iv_ruleList2= ruleList2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getList2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleList2_in_entryRuleList23696);
            iv_ruleList2=ruleList2();
            _fsp--;

             current =iv_ruleList2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList23706); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2465:1: ruleList2 returns [EObject current=null] : ( '#18' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? ) ;
    public final EObject ruleList2() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val1_3_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2470:6: ( ( '#18' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2471:1: ( '#18' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2471:1: ( '#18' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2471:3: '#18' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )?
            {
            match(input,35,FollowSets000.FOLLOW_35_in_ruleList23741); 

                    createLeafNode(grammarAccess.getList2Access().getNumberSignDigitOneDigitEightKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2475:1: ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2475:2: ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2475:2: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2476:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2476:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2477:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList23759); 

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2499:2: ( ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==34) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2499:4: ',' ( (lv_val1_3_0= RULE_ID ) )
                    	    {
                    	    match(input,34,FollowSets000.FOLLOW_34_in_ruleList23775); 

                    	            createLeafNode(grammarAccess.getList2Access().getCommaKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2503:1: ( (lv_val1_3_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2504:1: (lv_val1_3_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2504:1: (lv_val1_3_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2505:3: lv_val1_3_0= RULE_ID
                    	    {
                    	    lv_val1_3_0=(Token)input.LT(1);
                    	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList23792); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2535:1: entryRuleList3 returns [EObject current=null] : iv_ruleList3= ruleList3 EOF ;
    public final EObject entryRuleList3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2536:2: (iv_ruleList3= ruleList3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2537:2: iv_ruleList3= ruleList3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getList3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleList3_in_entryRuleList33837);
            iv_ruleList3=ruleList3();
            _fsp--;

             current =iv_ruleList3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleList33847); 

            }

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2544:1: ruleList3 returns [EObject current=null] : ( ( '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | ( 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) ) ;
    public final EObject ruleList3() throws RecognitionException {
        EObject current = null;

        Token lv_val1_1_0=null;
        Token lv_val1_3_0=null;
        Token lv_val2_5_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2549:6: ( ( ( '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | ( 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2550:1: ( ( '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | ( 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2550:1: ( ( '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | ( 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )
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
                    new NoViableAltException("2550:1: ( ( '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) ) | ( 'kw3' ( (lv_val2_5_0= RULE_ID ) ) ) )", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2550:2: ( '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2550:2: ( '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2550:4: '#19' ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
                    {
                    match(input,36,FollowSets000.FOLLOW_36_in_ruleList33883); 

                            createLeafNode(grammarAccess.getList3Access().getNumberSignDigitOneDigitNineKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2554:1: ( ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )* )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2554:2: ( (lv_val1_1_0= RULE_ID ) ) ( ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2554:2: ( (lv_val1_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2555:1: (lv_val1_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2555:1: (lv_val1_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2556:3: lv_val1_1_0= RULE_ID
                    {
                    lv_val1_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList33901); 

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2578:2: ( ',' ( (lv_val1_3_0= RULE_ID ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==34) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2578:4: ',' ( (lv_val1_3_0= RULE_ID ) )
                    	    {
                    	    match(input,34,FollowSets000.FOLLOW_34_in_ruleList33917); 

                    	            createLeafNode(grammarAccess.getList3Access().getCommaKeyword_0_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2582:1: ( (lv_val1_3_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2583:1: (lv_val1_3_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2583:1: (lv_val1_3_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2584:3: lv_val1_3_0= RULE_ID
                    	    {
                    	    lv_val1_3_0=(Token)input.LT(1);
                    	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList33934); 

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2607:6: ( 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2607:6: ( 'kw3' ( (lv_val2_5_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2607:8: 'kw3' ( (lv_val2_5_0= RULE_ID ) )
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleList33960); 

                            createLeafNode(grammarAccess.getList3Access().getKw3Keyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2611:1: ( (lv_val2_5_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2612:1: (lv_val2_5_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2612:1: (lv_val2_5_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/validation/parser/antlr/internal/InternalConcreteSyntaxValidationTestLanguage.g:2613:3: lv_val2_5_0= RULE_ID
                    {
                    lv_val2_5_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleList33977); 

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
        public static final BitSet FOLLOW_ruleSimpleGroup_in_entryRuleSimpleGroup653 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleGroup663 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleSimpleGroup698 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleGroup715 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleGroup737 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleAlternative_in_entryRuleSimpleAlternative778 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleAlternative788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleSimpleAlternative823 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_13_in_ruleSimpleAlternative835 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAlternative852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleSimpleAlternative875 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleAlternative892 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleMultiplicities_in_entryRuleSimpleMultiplicities935 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleMultiplicities945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleSimpleMultiplicities980 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities997 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleSimpleMultiplicities1012 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1029 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleSimpleMultiplicities1045 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1062 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_16_in_ruleSimpleMultiplicities1078 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleMultiplicities1095 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleGroupMultiplicities_in_entryRuleGroupMultiplicities1137 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroupMultiplicities1147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleGroupMultiplicities1182 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1199 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleGroupMultiplicities1214 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1232 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1254 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleGroupMultiplicities1271 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1289 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1311 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_16_in_ruleGroupMultiplicities1328 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1346 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupMultiplicities1368 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleAlternativeMultiplicities_in_entryRuleAlternativeMultiplicities1411 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlternativeMultiplicities1421 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleAlternativeMultiplicities1456 = new BitSet(new long[]{0x0000000000006010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1474 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_13_in_ruleAlternativeMultiplicities1496 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1513 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleAlternativeMultiplicities1531 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1549 = new BitSet(new long[]{0x0000000000090010L});
        public static final BitSet FOLLOW_16_in_ruleAlternativeMultiplicities1571 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1588 = new BitSet(new long[]{0x0000000000090010L});
        public static final BitSet FOLLOW_19_in_ruleAlternativeMultiplicities1606 = new BitSet(new long[]{0x0000000000100012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1624 = new BitSet(new long[]{0x0000000000100012L});
        public static final BitSet FOLLOW_20_in_ruleAlternativeMultiplicities1646 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAlternativeMultiplicities1663 = new BitSet(new long[]{0x0000000000100012L});
        public static final BitSet FOLLOW_ruleAssignedAction_in_entryRuleAssignedAction1707 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignedAction1717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleAssignedAction1752 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignedAction1769 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignedAction1801 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleAssignedActionSecond_in_entryRuleAssignedActionSecond1844 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignedActionSecond1854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleAssignedActionSecond1889 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignedActionSecond1906 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleAssignedActionSecond1921 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignedActionSecond1938 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedAction1_in_entryRuleUnassignedAction11979 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedAction11989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleUnassignedAction12033 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction12050 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction12072 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedAction2_in_entryRuleUnassignedAction22114 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedAction22124 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleUnassignedAction22168 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction22185 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction22207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedAction3_in_entryRuleUnassignedAction32249 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedAction32259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleUnassignedAction32294 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_13_in_ruleUnassignedAction32306 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_14_in_ruleUnassignedAction32333 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction32361 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedAction32383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall1_in_entryRuleUnassignedRuleCall12425 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedRuleCall12435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleUnassignedRuleCall12470 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall1Sub_in_ruleUnassignedRuleCall12492 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedRuleCall12508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall1Sub_in_entryRuleUnassignedRuleCall1Sub2549 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedRuleCall1Sub2559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedRuleCall1Sub2600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall2_in_entryRuleUnassignedRuleCall22640 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedRuleCall22650 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleUnassignedRuleCall22685 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall2Sub_in_ruleUnassignedRuleCall22707 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnassignedRuleCall22723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassignedRuleCall2Sub_in_entryRuleUnassignedRuleCall2Sub2764 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassignedRuleCall2Sub2774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCombination1_in_entryRuleCombination12842 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCombination12852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleCombination12887 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination12904 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleCombination12920 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination12937 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_14_in_ruleCombination12954 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination12971 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination13000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCombination2_in_entryRuleCombination23044 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCombination23054 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleCombination23089 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination23106 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_13_in_ruleCombination23123 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination23140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination23170 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination23192 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleCombination3_in_entryRuleCombination33236 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCombination33246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleCombination33281 = new BitSet(new long[]{0x0000000000000072L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination33299 = new BitSet(new long[]{0x0000000000000072L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleCombination33327 = new BitSet(new long[]{0x0000000000000072L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCombination33355 = new BitSet(new long[]{0x0000000000000072L});
        public static final BitSet FOLLOW_ruleCombination4_in_entryRuleCombination43398 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCombination43408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleCombination43443 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleCombination43454 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination43471 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination43493 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCombination43515 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_ruleList1_in_entryRuleList13558 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList13568 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleList13603 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList13620 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_ruleList13636 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList13653 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_ruleList2_in_entryRuleList23696 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList23706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleList23741 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList23759 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_ruleList23775 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList23792 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_ruleList3_in_entryRuleList33837 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleList33847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleList33883 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList33901 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_ruleList33917 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList33934 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_16_in_ruleList33960 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleList33977 = new BitSet(new long[]{0x0000000000000002L});
    }


}