package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.UnorderedGroupsTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalUnorderedGroupsTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'1'", "'2'", "'3'", "'4'", "'5'", "'bug304681'", "'public'", "'private'", "'protected'", "'static'", "'synchronized'", "'abstract'", "'final'", "'class'", "'{'", "'}'", "'before'", "'after'", "'short'", "';'", "'long'", "'uid'", "'flag'", "'attr'", "'ref'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalUnorderedGroupsTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g"; }



     	private UnorderedGroupsTestLanguageGrammarAccess grammarAccess;
     	
        public InternalUnorderedGroupsTestLanguageParser(TokenStream input, IAstFactory factory, UnorderedGroupsTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:73:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:74:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:81:1: ruleModel returns [EObject current=null] : ( ( '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | ( '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | ( '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | ( '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) | ( '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) ) | ( 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_first_1_0 = null;

        EObject lv_second_3_0 = null;

        EObject lv_thrird_5_0 = null;

        EObject lv_forth_7_0 = null;

        EObject lv_fifth_9_0 = null;

        EObject lv_model_11_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:86:6: ( ( ( '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | ( '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | ( '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | ( '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) | ( '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) ) | ( 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:87:1: ( ( '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | ( '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | ( '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | ( '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) | ( '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) ) | ( 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:87:1: ( ( '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | ( '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | ( '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | ( '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) | ( '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) ) | ( 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) ) )
            int alt1=6;
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
            case 13:
                {
                alt1=3;
                }
                break;
            case 14:
                {
                alt1=4;
                }
                break;
            case 15:
                {
                alt1=5;
                }
                break;
            case 16:
                {
                alt1=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("87:1: ( ( '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | ( '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | ( '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | ( '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) | ( '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) ) | ( 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) ) )", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:87:2: ( '1' ( (lv_first_1_0= ruleSimpleModel ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:87:2: ( '1' ( (lv_first_1_0= ruleSimpleModel ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:87:4: '1' ( (lv_first_1_0= ruleSimpleModel ) )
                    {
                    match(input,11,FollowSets000.FOLLOW_11_in_ruleModel121); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitOneKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:91:1: ( (lv_first_1_0= ruleSimpleModel ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:92:1: (lv_first_1_0= ruleSimpleModel )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:92:1: (lv_first_1_0= ruleSimpleModel )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:93:3: lv_first_1_0= ruleSimpleModel
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getFirstSimpleModelParserRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleModel_in_ruleModel142);
                    lv_first_1_0=ruleSimpleModel();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"first",
                    	        		lv_first_1_0, 
                    	        		"SimpleModel", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:116:6: ( '2' ( (lv_second_3_0= ruleMandatoryModel ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:116:6: ( '2' ( (lv_second_3_0= ruleMandatoryModel ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:116:8: '2' ( (lv_second_3_0= ruleMandatoryModel ) )
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleModel160); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitTwoKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:120:1: ( (lv_second_3_0= ruleMandatoryModel ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:121:1: (lv_second_3_0= ruleMandatoryModel )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:121:1: (lv_second_3_0= ruleMandatoryModel )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:122:3: lv_second_3_0= ruleMandatoryModel
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getSecondMandatoryModelParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMandatoryModel_in_ruleModel181);
                    lv_second_3_0=ruleMandatoryModel();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"second",
                    	        		lv_second_3_0, 
                    	        		"MandatoryModel", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:145:6: ( '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:145:6: ( '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:145:8: '3' ( (lv_thrird_5_0= ruleLoopedModel ) )
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleModel199); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitThreeKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:149:1: ( (lv_thrird_5_0= ruleLoopedModel ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:150:1: (lv_thrird_5_0= ruleLoopedModel )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:150:1: (lv_thrird_5_0= ruleLoopedModel )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:151:3: lv_thrird_5_0= ruleLoopedModel
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getThrirdLoopedModelParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleLoopedModel_in_ruleModel220);
                    lv_thrird_5_0=ruleLoopedModel();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"thrird",
                    	        		lv_thrird_5_0, 
                    	        		"LoopedModel", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:174:6: ( '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:174:6: ( '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:174:8: '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) )
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleModel238); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitFourKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:178:1: ( (lv_forth_7_0= ruleGroupLoopedModel ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:179:1: (lv_forth_7_0= ruleGroupLoopedModel )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:179:1: (lv_forth_7_0= ruleGroupLoopedModel )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:180:3: lv_forth_7_0= ruleGroupLoopedModel
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getForthGroupLoopedModelParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleGroupLoopedModel_in_ruleModel259);
                    lv_forth_7_0=ruleGroupLoopedModel();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"forth",
                    	        		lv_forth_7_0, 
                    	        		"GroupLoopedModel", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:203:6: ( '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:203:6: ( '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:203:8: '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) )
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleModel277); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitFiveKeyword_4_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:207:1: ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:208:1: (lv_fifth_9_0= ruleLoopedAlternativeModel )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:208:1: (lv_fifth_9_0= ruleLoopedAlternativeModel )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:209:3: lv_fifth_9_0= ruleLoopedAlternativeModel
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getFifthLoopedAlternativeModelParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleLoopedAlternativeModel_in_ruleModel298);
                    lv_fifth_9_0=ruleLoopedAlternativeModel();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"fifth",
                    	        		lv_fifth_9_0, 
                    	        		"LoopedAlternativeModel", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:232:6: ( 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:232:6: ( 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:232:8: 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) )
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleModel316); 

                            createLeafNode(grammarAccess.getModelAccess().getBug304681Keyword_5_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:236:1: ( (lv_model_11_0= ruleBug304681Model ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:237:1: (lv_model_11_0= ruleBug304681Model )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:237:1: (lv_model_11_0= ruleBug304681Model )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:238:3: lv_model_11_0= ruleBug304681Model
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getModelBug304681ModelParserRuleCall_5_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleBug304681Model_in_ruleModel337);
                    lv_model_11_0=ruleBug304681Model();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"model",
                    	        		lv_model_11_0, 
                    	        		"Bug304681Model", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleSimpleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:268:1: entryRuleSimpleModel returns [EObject current=null] : iv_ruleSimpleModel= ruleSimpleModel EOF ;
    public final EObject entryRuleSimpleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:269:2: (iv_ruleSimpleModel= ruleSimpleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:270:2: iv_ruleSimpleModel= ruleSimpleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleModel_in_entryRuleSimpleModel374);
            iv_ruleSimpleModel=ruleSimpleModel();
            _fsp--;

             current =iv_ruleSimpleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleModel384); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSimpleModel


    // $ANTLR start ruleSimpleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:277:1: ruleSimpleModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) ;
    public final EObject ruleSimpleModel() throws RecognitionException {
        EObject current = null;

        Token lv_visibility_1_1=null;
        Token lv_visibility_1_2=null;
        Token lv_visibility_1_3=null;
        Token lv_static_2_0=null;
        Token lv_synchronized_3_0=null;
        Token lv_abstract_4_0=null;
        Token lv_final_5_0=null;
        Token lv_name_7_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:282:6: ( ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:283:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:283:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:283:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:283:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:285:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:285:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:286:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            	
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:289:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:290:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:290:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )*
            loop4:
            do {
                int alt4=5;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=17 && LA4_0<=19)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0))) {
                    alt4=1;
                }
                else if ( (LA4_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1))) {
                    alt4=2;
                }
                else if ( (LA4_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2))) {
                    alt4=3;
                }
                else if ( ((LA4_0>=22 && LA4_0<=23)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3))) {
                    alt4=4;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:292:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:292:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:293:5: {...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0)) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:293:108: ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:294:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:297:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:298:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:298:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:299:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:299:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    int alt2=3;
            	    switch ( input.LA(1) ) {
            	    case 17:
            	        {
            	        alt2=1;
            	        }
            	        break;
            	    case 18:
            	        {
            	        alt2=2;
            	        }
            	        break;
            	    case 19:
            	        {
            	        alt2=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("299:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )", 2, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt2) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:300:3: lv_visibility_1_1= 'public'
            	            {
            	            lv_visibility_1_1=(Token)input.LT(1);
            	            match(input,17,FollowSets000.FOLLOW_17_in_ruleSimpleModel471); 

            	                    createLeafNode(grammarAccess.getSimpleModelAccess().getVisibilityPublicKeyword_0_0_0_0(), "visibility"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getSimpleModelRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		set(current, "visibility", lv_visibility_1_1, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:318:8: lv_visibility_1_2= 'private'
            	            {
            	            lv_visibility_1_2=(Token)input.LT(1);
            	            match(input,18,FollowSets000.FOLLOW_18_in_ruleSimpleModel500); 

            	                    createLeafNode(grammarAccess.getSimpleModelAccess().getVisibilityPrivateKeyword_0_0_0_1(), "visibility"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getSimpleModelRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		set(current, "visibility", lv_visibility_1_2, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:336:8: lv_visibility_1_3= 'protected'
            	            {
            	            lv_visibility_1_3=(Token)input.LT(1);
            	            match(input,19,FollowSets000.FOLLOW_19_in_ruleSimpleModel529); 

            	                    createLeafNode(grammarAccess.getSimpleModelAccess().getVisibilityProtectedKeyword_0_0_0_2(), "visibility"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getSimpleModelRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		set(current, "visibility", lv_visibility_1_3, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:364:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:364:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:365:5: {...}? => ( ( (lv_static_2_0= 'static' ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1)) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:365:108: ( ( (lv_static_2_0= 'static' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:366:6: ( (lv_static_2_0= 'static' ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:369:6: ( (lv_static_2_0= 'static' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:370:1: (lv_static_2_0= 'static' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:370:1: (lv_static_2_0= 'static' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:371:3: lv_static_2_0= 'static'
            	    {
            	    lv_static_2_0=(Token)input.LT(1);
            	    match(input,20,FollowSets000.FOLLOW_20_in_ruleSimpleModel613); 

            	            createLeafNode(grammarAccess.getSimpleModelAccess().getStaticStaticKeyword_0_1_0(), "static"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSimpleModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "static", true, "static", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:397:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:397:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:398:5: {...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2)) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:398:108: ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:399:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:402:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:403:1: (lv_synchronized_3_0= 'synchronized' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:403:1: (lv_synchronized_3_0= 'synchronized' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:404:3: lv_synchronized_3_0= 'synchronized'
            	    {
            	    lv_synchronized_3_0=(Token)input.LT(1);
            	    match(input,21,FollowSets000.FOLLOW_21_in_ruleSimpleModel694); 

            	            createLeafNode(grammarAccess.getSimpleModelAccess().getSynchronizedSynchronizedKeyword_0_2_0(), "synchronized"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSimpleModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "synchronized", true, "synchronized", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:430:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:430:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:431:5: {...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3)) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:431:108: ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:432:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:435:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0==22) ) {
            	        alt3=1;
            	    }
            	    else if ( (LA3_0==23) ) {
            	        alt3=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("435:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )", 3, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:435:7: ( (lv_abstract_4_0= 'abstract' ) )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:435:7: ( (lv_abstract_4_0= 'abstract' ) )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:436:1: (lv_abstract_4_0= 'abstract' )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:436:1: (lv_abstract_4_0= 'abstract' )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:437:3: lv_abstract_4_0= 'abstract'
            	            {
            	            lv_abstract_4_0=(Token)input.LT(1);
            	            match(input,22,FollowSets000.FOLLOW_22_in_ruleSimpleModel776); 

            	                    createLeafNode(grammarAccess.getSimpleModelAccess().getAbstractAbstractKeyword_0_3_0_0(), "abstract"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getSimpleModelRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		set(current, "abstract", true, "abstract", lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:457:6: ( (lv_final_5_0= 'final' ) )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:457:6: ( (lv_final_5_0= 'final' ) )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:458:1: (lv_final_5_0= 'final' )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:458:1: (lv_final_5_0= 'final' )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:459:3: lv_final_5_0= 'final'
            	            {
            	            lv_final_5_0=(Token)input.LT(1);
            	            match(input,23,FollowSets000.FOLLOW_23_in_ruleSimpleModel813); 

            	                    createLeafNode(grammarAccess.getSimpleModelAccess().getFinalFinalKeyword_0_3_1_0(), "final"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getSimpleModelRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		set(current, "final", true, "final", lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }


            	            }


            	            }
            	            break;

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            	

            }

            match(input,24,FollowSets000.FOLLOW_24_in_ruleSimpleModel876); 

                    createLeafNode(grammarAccess.getSimpleModelAccess().getClassKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:496:1: ( (lv_name_7_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:497:1: (lv_name_7_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:497:1: (lv_name_7_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:498:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleModel893); 

            			createLeafNode(grammarAccess.getSimpleModelAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSimpleModelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_7_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,25,FollowSets000.FOLLOW_25_in_ruleSimpleModel908); 

                    createLeafNode(grammarAccess.getSimpleModelAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            match(input,26,FollowSets000.FOLLOW_26_in_ruleSimpleModel918); 

                    createLeafNode(grammarAccess.getSimpleModelAccess().getRightCurlyBracketKeyword_4(), null); 
                

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
    // $ANTLR end ruleSimpleModel


    // $ANTLR start entryRuleMandatoryModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:536:1: entryRuleMandatoryModel returns [EObject current=null] : iv_ruleMandatoryModel= ruleMandatoryModel EOF ;
    public final EObject entryRuleMandatoryModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMandatoryModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:537:2: (iv_ruleMandatoryModel= ruleMandatoryModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:538:2: iv_ruleMandatoryModel= ruleMandatoryModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMandatoryModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMandatoryModel_in_entryRuleMandatoryModel954);
            iv_ruleMandatoryModel=ruleMandatoryModel();
            _fsp--;

             current =iv_ruleMandatoryModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMandatoryModel964); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleMandatoryModel


    // $ANTLR start ruleMandatoryModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:545:1: ruleMandatoryModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) ;
    public final EObject ruleMandatoryModel() throws RecognitionException {
        EObject current = null;

        Token lv_visibility_1_1=null;
        Token lv_visibility_1_2=null;
        Token lv_visibility_1_3=null;
        Token lv_static_2_0=null;
        Token lv_synchronized_3_0=null;
        Token lv_abstract_4_0=null;
        Token lv_final_5_0=null;
        Token lv_name_7_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:550:6: ( ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:551:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:551:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:551:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:551:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:553:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:553:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:554:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            	
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:557:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?)
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:558:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:558:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=5;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=17 && LA7_0<=19)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0))) {
                    alt7=1;
                }
                else if ( (LA7_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1))) {
                    alt7=2;
                }
                else if ( (LA7_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2))) {
                    alt7=3;
                }
                else if ( ((LA7_0>=22 && LA7_0<=23)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3))) {
                    alt7=4;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:560:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:560:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:561:5: {...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0)) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:561:111: ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:562:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:565:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:566:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:566:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:567:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:567:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    int alt5=3;
            	    switch ( input.LA(1) ) {
            	    case 17:
            	        {
            	        alt5=1;
            	        }
            	        break;
            	    case 18:
            	        {
            	        alt5=2;
            	        }
            	        break;
            	    case 19:
            	        {
            	        alt5=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("567:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )", 5, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt5) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:568:3: lv_visibility_1_1= 'public'
            	            {
            	            lv_visibility_1_1=(Token)input.LT(1);
            	            match(input,17,FollowSets000.FOLLOW_17_in_ruleMandatoryModel1051); 

            	                    createLeafNode(grammarAccess.getMandatoryModelAccess().getVisibilityPublicKeyword_0_0_0_0(), "visibility"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getMandatoryModelRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		set(current, "visibility", lv_visibility_1_1, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:586:8: lv_visibility_1_2= 'private'
            	            {
            	            lv_visibility_1_2=(Token)input.LT(1);
            	            match(input,18,FollowSets000.FOLLOW_18_in_ruleMandatoryModel1080); 

            	                    createLeafNode(grammarAccess.getMandatoryModelAccess().getVisibilityPrivateKeyword_0_0_0_1(), "visibility"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getMandatoryModelRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		set(current, "visibility", lv_visibility_1_2, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:604:8: lv_visibility_1_3= 'protected'
            	            {
            	            lv_visibility_1_3=(Token)input.LT(1);
            	            match(input,19,FollowSets000.FOLLOW_19_in_ruleMandatoryModel1109); 

            	                    createLeafNode(grammarAccess.getMandatoryModelAccess().getVisibilityProtectedKeyword_0_0_0_2(), "visibility"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getMandatoryModelRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		set(current, "visibility", lv_visibility_1_3, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:632:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:632:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:633:5: {...}? => ( ( (lv_static_2_0= 'static' ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1)) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:633:111: ( ( (lv_static_2_0= 'static' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:634:6: ( (lv_static_2_0= 'static' ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:637:6: ( (lv_static_2_0= 'static' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:638:1: (lv_static_2_0= 'static' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:638:1: (lv_static_2_0= 'static' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:639:3: lv_static_2_0= 'static'
            	    {
            	    lv_static_2_0=(Token)input.LT(1);
            	    match(input,20,FollowSets000.FOLLOW_20_in_ruleMandatoryModel1193); 

            	            createLeafNode(grammarAccess.getMandatoryModelAccess().getStaticStaticKeyword_0_1_0(), "static"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMandatoryModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "static", true, "static", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:665:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:665:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:666:5: {...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2)) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:666:111: ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:667:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:670:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:671:1: (lv_synchronized_3_0= 'synchronized' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:671:1: (lv_synchronized_3_0= 'synchronized' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:672:3: lv_synchronized_3_0= 'synchronized'
            	    {
            	    lv_synchronized_3_0=(Token)input.LT(1);
            	    match(input,21,FollowSets000.FOLLOW_21_in_ruleMandatoryModel1274); 

            	            createLeafNode(grammarAccess.getMandatoryModelAccess().getSynchronizedSynchronizedKeyword_0_2_0(), "synchronized"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMandatoryModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "synchronized", true, "synchronized", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:698:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:698:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:699:5: {...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3)) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:699:111: ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:700:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:703:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==22) ) {
            	        alt6=1;
            	    }
            	    else if ( (LA6_0==23) ) {
            	        alt6=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("703:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )", 6, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:703:7: ( (lv_abstract_4_0= 'abstract' ) )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:703:7: ( (lv_abstract_4_0= 'abstract' ) )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:704:1: (lv_abstract_4_0= 'abstract' )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:704:1: (lv_abstract_4_0= 'abstract' )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:705:3: lv_abstract_4_0= 'abstract'
            	            {
            	            lv_abstract_4_0=(Token)input.LT(1);
            	            match(input,22,FollowSets000.FOLLOW_22_in_ruleMandatoryModel1356); 

            	                    createLeafNode(grammarAccess.getMandatoryModelAccess().getAbstractAbstractKeyword_0_3_0_0(), "abstract"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getMandatoryModelRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		set(current, "abstract", true, "abstract", lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:725:6: ( (lv_final_5_0= 'final' ) )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:725:6: ( (lv_final_5_0= 'final' ) )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:726:1: (lv_final_5_0= 'final' )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:726:1: (lv_final_5_0= 'final' )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:727:3: lv_final_5_0= 'final'
            	            {
            	            lv_final_5_0=(Token)input.LT(1);
            	            match(input,23,FollowSets000.FOLLOW_23_in_ruleMandatoryModel1393); 

            	                    createLeafNode(grammarAccess.getMandatoryModelAccess().getFinalFinalKeyword_0_3_1_0(), "final"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getMandatoryModelRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		set(current, "final", true, "final", lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }


            	            }


            	            }
            	            break;

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            	    	 				

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

            if ( !(getUnorderedGroupHelper().canLeave(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0())) ) {
                throw new FailedPredicateException(input, "ruleMandatoryModel", "getUnorderedGroupHelper().canLeave(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            	

            }

            match(input,24,FollowSets000.FOLLOW_24_in_ruleMandatoryModel1462); 

                    createLeafNode(grammarAccess.getMandatoryModelAccess().getClassKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:765:1: ( (lv_name_7_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:766:1: (lv_name_7_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:766:1: (lv_name_7_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:767:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMandatoryModel1479); 

            			createLeafNode(grammarAccess.getMandatoryModelAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMandatoryModelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_7_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,25,FollowSets000.FOLLOW_25_in_ruleMandatoryModel1494); 

                    createLeafNode(grammarAccess.getMandatoryModelAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            match(input,26,FollowSets000.FOLLOW_26_in_ruleMandatoryModel1504); 

                    createLeafNode(grammarAccess.getMandatoryModelAccess().getRightCurlyBracketKeyword_4(), null); 
                

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
    // $ANTLR end ruleMandatoryModel


    // $ANTLR start entryRuleLoopedModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:805:1: entryRuleLoopedModel returns [EObject current=null] : iv_ruleLoopedModel= ruleLoopedModel EOF ;
    public final EObject entryRuleLoopedModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopedModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:806:2: (iv_ruleLoopedModel= ruleLoopedModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:807:2: iv_ruleLoopedModel= ruleLoopedModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLoopedModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLoopedModel_in_entryRuleLoopedModel1540);
            iv_ruleLoopedModel=ruleLoopedModel();
            _fsp--;

             current =iv_ruleLoopedModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoopedModel1550); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLoopedModel


    // $ANTLR start ruleLoopedModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:814:1: ruleLoopedModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) ;
    public final EObject ruleLoopedModel() throws RecognitionException {
        EObject current = null;

        Token lv_visibility_1_1=null;
        Token lv_visibility_1_2=null;
        Token lv_visibility_1_3=null;
        Token lv_static_2_0=null;
        Token lv_synchronized_3_0=null;
        Token lv_abstract_4_0=null;
        Token lv_final_5_0=null;
        Token lv_name_7_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:819:6: ( ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:820:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:820:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:820:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:820:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:822:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:822:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:823:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            	
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:826:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:827:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:827:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )*
            loop13:
            do {
                int alt13=5;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=17 && LA13_0<=19)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0))) {
                    alt13=1;
                }
                else if ( (LA13_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1))) {
                    alt13=2;
                }
                else if ( (LA13_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2))) {
                    alt13=3;
                }
                else if ( ((LA13_0>=22 && LA13_0<=23)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3))) {
                    alt13=4;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:829:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:829:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:830:5: {...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0)) ) {
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:830:108: ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:831:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:834:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        switch ( input.LA(1) ) {
            	        case 17:
            	            {
            	            int LA9_2 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0))) ) {
            	                alt9=1;
            	            }


            	            }
            	            break;
            	        case 18:
            	            {
            	            int LA9_3 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0))) ) {
            	                alt9=1;
            	            }


            	            }
            	            break;
            	        case 19:
            	            {
            	            int LA9_4 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0))) ) {
            	                alt9=1;
            	            }


            	            }
            	            break;

            	        }

            	        switch (alt9) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:835:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:835:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:836:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:836:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    	    int alt8=3;
            	    	    switch ( input.LA(1) ) {
            	    	    case 17:
            	    	        {
            	    	        alt8=1;
            	    	        }
            	    	        break;
            	    	    case 18:
            	    	        {
            	    	        alt8=2;
            	    	        }
            	    	        break;
            	    	    case 19:
            	    	        {
            	    	        alt8=3;
            	    	        }
            	    	        break;
            	    	    default:
            	    	        NoViableAltException nvae =
            	    	            new NoViableAltException("836:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )", 8, 0, input);

            	    	        throw nvae;
            	    	    }

            	    	    switch (alt8) {
            	    	        case 1 :
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:837:3: lv_visibility_1_1= 'public'
            	    	            {
            	    	            lv_visibility_1_1=(Token)input.LT(1);
            	    	            match(input,17,FollowSets000.FOLLOW_17_in_ruleLoopedModel1637); 

            	    	                    createLeafNode(grammarAccess.getLoopedModelAccess().getVisibilityPublicKeyword_0_0_0_0(), "visibility"); 
            	    	                

            	    	            	        if (current==null) {
            	    	            	            current = factory.create(grammarAccess.getLoopedModelRule().getType().getClassifier());
            	    	            	            associateNodeWithAstElement(currentNode, current);
            	    	            	        }
            	    	            	        
            	    	            	        try {
            	    	            	       		add(current, "visibility", lv_visibility_1_1, null, lastConsumedNode);
            	    	            	        } catch (ValueConverterException vce) {
            	    	            				handleValueConverterException(vce);
            	    	            	        }
            	    	            	    

            	    	            }
            	    	            break;
            	    	        case 2 :
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:855:8: lv_visibility_1_2= 'private'
            	    	            {
            	    	            lv_visibility_1_2=(Token)input.LT(1);
            	    	            match(input,18,FollowSets000.FOLLOW_18_in_ruleLoopedModel1666); 

            	    	                    createLeafNode(grammarAccess.getLoopedModelAccess().getVisibilityPrivateKeyword_0_0_0_1(), "visibility"); 
            	    	                

            	    	            	        if (current==null) {
            	    	            	            current = factory.create(grammarAccess.getLoopedModelRule().getType().getClassifier());
            	    	            	            associateNodeWithAstElement(currentNode, current);
            	    	            	        }
            	    	            	        
            	    	            	        try {
            	    	            	       		add(current, "visibility", lv_visibility_1_2, null, lastConsumedNode);
            	    	            	        } catch (ValueConverterException vce) {
            	    	            				handleValueConverterException(vce);
            	    	            	        }
            	    	            	    

            	    	            }
            	    	            break;
            	    	        case 3 :
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:873:8: lv_visibility_1_3= 'protected'
            	    	            {
            	    	            lv_visibility_1_3=(Token)input.LT(1);
            	    	            match(input,19,FollowSets000.FOLLOW_19_in_ruleLoopedModel1695); 

            	    	                    createLeafNode(grammarAccess.getLoopedModelAccess().getVisibilityProtectedKeyword_0_0_0_2(), "visibility"); 
            	    	                

            	    	            	        if (current==null) {
            	    	            	            current = factory.create(grammarAccess.getLoopedModelRule().getType().getClassifier());
            	    	            	            associateNodeWithAstElement(currentNode, current);
            	    	            	        }
            	    	            	        
            	    	            	        try {
            	    	            	       		add(current, "visibility", lv_visibility_1_3, null, lastConsumedNode);
            	    	            	        } catch (ValueConverterException vce) {
            	    	            				handleValueConverterException(vce);
            	    	            	        }
            	    	            	    

            	    	            }
            	    	            break;

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt9 >= 1 ) break loop9;
            	                EarlyExitException eee =
            	                    new EarlyExitException(9, input);
            	                throw eee;
            	        }
            	        cnt9++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:901:4: ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:901:4: ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:902:5: {...}? => ( ( (lv_static_2_0= 'static' ) )+ )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1)) ) {
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:902:108: ( ( (lv_static_2_0= 'static' ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:903:6: ( (lv_static_2_0= 'static' ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:906:6: ( (lv_static_2_0= 'static' ) )+
            	    int cnt10=0;
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==20) ) {
            	            int LA10_3 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1))) ) {
            	                alt10=1;
            	            }


            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:907:1: (lv_static_2_0= 'static' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:907:1: (lv_static_2_0= 'static' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:908:3: lv_static_2_0= 'static'
            	    	    {
            	    	    lv_static_2_0=(Token)input.LT(1);
            	    	    match(input,20,FollowSets000.FOLLOW_20_in_ruleLoopedModel1780); 

            	    	            createLeafNode(grammarAccess.getLoopedModelAccess().getStaticStaticKeyword_0_1_0(), "static"); 
            	    	        

            	    	    	        if (current==null) {
            	    	    	            current = factory.create(grammarAccess.getLoopedModelRule().getType().getClassifier());
            	    	    	            associateNodeWithAstElement(currentNode, current);
            	    	    	        }
            	    	    	        
            	    	    	        try {
            	    	    	       		add(current, "static", lv_static_2_0, "static", lastConsumedNode);
            	    	    	        } catch (ValueConverterException vce) {
            	    	    				handleValueConverterException(vce);
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:934:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:934:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:935:5: {...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2)) ) {
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:935:108: ( ( (lv_synchronized_3_0= 'synchronized' ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:936:6: ( (lv_synchronized_3_0= 'synchronized' ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:939:6: ( (lv_synchronized_3_0= 'synchronized' ) )+
            	    int cnt11=0;
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( (LA11_0==21) ) {
            	            int LA11_4 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2))) ) {
            	                alt11=1;
            	            }


            	        }


            	        switch (alt11) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:940:1: (lv_synchronized_3_0= 'synchronized' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:940:1: (lv_synchronized_3_0= 'synchronized' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:941:3: lv_synchronized_3_0= 'synchronized'
            	    	    {
            	    	    lv_synchronized_3_0=(Token)input.LT(1);
            	    	    match(input,21,FollowSets000.FOLLOW_21_in_ruleLoopedModel1862); 

            	    	            createLeafNode(grammarAccess.getLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0(), "synchronized"); 
            	    	        

            	    	    	        if (current==null) {
            	    	    	            current = factory.create(grammarAccess.getLoopedModelRule().getType().getClassifier());
            	    	    	            associateNodeWithAstElement(currentNode, current);
            	    	    	        }
            	    	    	        
            	    	    	        try {
            	    	    	       		add(current, "synchronized", lv_synchronized_3_0, "synchronized", lastConsumedNode);
            	    	    	        } catch (ValueConverterException vce) {
            	    	    				handleValueConverterException(vce);
            	    	    	        }
            	    	    	    

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:967:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:967:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:968:5: {...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3)) ) {
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:968:108: ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:969:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:972:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+
            	    int cnt12=0;
            	    loop12:
            	    do {
            	        int alt12=3;
            	        int LA12_0 = input.LA(1);

            	        if ( (LA12_0==22) ) {
            	            int LA12_5 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3))) ) {
            	                alt12=1;
            	            }


            	        }
            	        else if ( (LA12_0==23) ) {
            	            int LA12_6 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3))) ) {
            	                alt12=2;
            	            }


            	        }


            	        switch (alt12) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:972:7: ( (lv_abstract_4_0= 'abstract' ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:972:7: ( (lv_abstract_4_0= 'abstract' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:973:1: (lv_abstract_4_0= 'abstract' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:973:1: (lv_abstract_4_0= 'abstract' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:974:3: lv_abstract_4_0= 'abstract'
            	    	    {
            	    	    lv_abstract_4_0=(Token)input.LT(1);
            	    	    match(input,22,FollowSets000.FOLLOW_22_in_ruleLoopedModel1945); 

            	    	            createLeafNode(grammarAccess.getLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0(), "abstract"); 
            	    	        

            	    	    	        if (current==null) {
            	    	    	            current = factory.create(grammarAccess.getLoopedModelRule().getType().getClassifier());
            	    	    	            associateNodeWithAstElement(currentNode, current);
            	    	    	        }
            	    	    	        
            	    	    	        try {
            	    	    	       		add(current, "abstract", lv_abstract_4_0, "abstract", lastConsumedNode);
            	    	    	        } catch (ValueConverterException vce) {
            	    	    				handleValueConverterException(vce);
            	    	    	        }
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:994:6: ( (lv_final_5_0= 'final' ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:994:6: ( (lv_final_5_0= 'final' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:995:1: (lv_final_5_0= 'final' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:995:1: (lv_final_5_0= 'final' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:996:3: lv_final_5_0= 'final'
            	    	    {
            	    	    lv_final_5_0=(Token)input.LT(1);
            	    	    match(input,23,FollowSets000.FOLLOW_23_in_ruleLoopedModel1982); 

            	    	            createLeafNode(grammarAccess.getLoopedModelAccess().getFinalFinalKeyword_0_3_1_0(), "final"); 
            	    	        

            	    	    	        if (current==null) {
            	    	    	            current = factory.create(grammarAccess.getLoopedModelRule().getType().getClassifier());
            	    	    	            associateNodeWithAstElement(currentNode, current);
            	    	    	        }
            	    	    	        
            	    	    	        try {
            	    	    	       		add(current, "final", lv_final_5_0, "final", lastConsumedNode);
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            	    	 				

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

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            	

            }

            match(input,24,FollowSets000.FOLLOW_24_in_ruleLoopedModel2046); 

                    createLeafNode(grammarAccess.getLoopedModelAccess().getClassKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1033:1: ( (lv_name_7_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1034:1: (lv_name_7_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1034:1: (lv_name_7_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1035:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoopedModel2063); 

            			createLeafNode(grammarAccess.getLoopedModelAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLoopedModelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_7_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,25,FollowSets000.FOLLOW_25_in_ruleLoopedModel2078); 

                    createLeafNode(grammarAccess.getLoopedModelAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            match(input,26,FollowSets000.FOLLOW_26_in_ruleLoopedModel2088); 

                    createLeafNode(grammarAccess.getLoopedModelAccess().getRightCurlyBracketKeyword_4(), null); 
                

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
    // $ANTLR end ruleLoopedModel


    // $ANTLR start entryRuleGroupLoopedModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1073:1: entryRuleGroupLoopedModel returns [EObject current=null] : iv_ruleGroupLoopedModel= ruleGroupLoopedModel EOF ;
    public final EObject entryRuleGroupLoopedModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupLoopedModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1074:2: (iv_ruleGroupLoopedModel= ruleGroupLoopedModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1075:2: iv_ruleGroupLoopedModel= ruleGroupLoopedModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGroupLoopedModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleGroupLoopedModel_in_entryRuleGroupLoopedModel2124);
            iv_ruleGroupLoopedModel=ruleGroupLoopedModel();
            _fsp--;

             current =iv_ruleGroupLoopedModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroupLoopedModel2134); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleGroupLoopedModel


    // $ANTLR start ruleGroupLoopedModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1082:1: ruleGroupLoopedModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )* 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) ;
    public final EObject ruleGroupLoopedModel() throws RecognitionException {
        EObject current = null;

        Token lv_visibility_1_1=null;
        Token lv_visibility_1_2=null;
        Token lv_visibility_1_3=null;
        Token lv_static_2_0=null;
        Token lv_synchronized_3_0=null;
        Token lv_abstract_4_0=null;
        Token lv_final_5_0=null;
        Token lv_name_7_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1087:6: ( ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )* 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1088:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )* 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1088:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )* 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1088:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )* 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1088:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=17 && LA17_0<=19)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0))) {
                    alt17=1;
                }
                else if ( (LA17_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1))) {
                    alt17=1;
                }
                else if ( (LA17_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2))) {
                    alt17=1;
                }
                else if ( ((LA17_0>=22 && LA17_0<=23)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3))) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1090:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1090:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1091:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?)
            	    {
            	     
            	    	  getUnorderedGroupHelper().enter(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	    	
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1094:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?)
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1095:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1095:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+
            	    int cnt16=0;
            	    loop16:
            	    do {
            	        int alt16=5;
            	        int LA16_0 = input.LA(1);

            	        if ( (LA16_0==17) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0))) {
            	            int LA16_2 = input.LA(2);

            	            if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)) ) {
            	                alt16=1;
            	            }


            	        }
            	        else if ( (LA16_0==18) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0))) {
            	            int LA16_3 = input.LA(2);

            	            if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)) ) {
            	                alt16=1;
            	            }


            	        }
            	        else if ( (LA16_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0))) {
            	            int LA16_4 = input.LA(2);

            	            if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)) ) {
            	                alt16=1;
            	            }


            	        }
            	        else if ( (LA16_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1))) {
            	            int LA16_5 = input.LA(2);

            	            if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1)) ) {
            	                alt16=2;
            	            }


            	        }
            	        else if ( (LA16_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2))) {
            	            int LA16_6 = input.LA(2);

            	            if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2)) ) {
            	                alt16=3;
            	            }


            	        }
            	        else if ( (LA16_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3))) {
            	            int LA16_7 = input.LA(2);

            	            if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3)) ) {
            	                alt16=4;
            	            }


            	        }
            	        else if ( (LA16_0==23) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3))) {
            	            int LA16_8 = input.LA(2);

            	            if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3)) ) {
            	                alt16=4;
            	            }


            	        }


            	        switch (alt16) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1097:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1097:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1098:5: {...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    	    {
            	    	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)");
            	    	    }
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1098:113: ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1099:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    	    {
            	    	     
            	    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0);
            	    	    	 				
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1102:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1103:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1103:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1104:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1104:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    	    int alt14=3;
            	    	    switch ( input.LA(1) ) {
            	    	    case 17:
            	    	        {
            	    	        alt14=1;
            	    	        }
            	    	        break;
            	    	    case 18:
            	    	        {
            	    	        alt14=2;
            	    	        }
            	    	        break;
            	    	    case 19:
            	    	        {
            	    	        alt14=3;
            	    	        }
            	    	        break;
            	    	    default:
            	    	        NoViableAltException nvae =
            	    	            new NoViableAltException("1104:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )", 14, 0, input);

            	    	        throw nvae;
            	    	    }

            	    	    switch (alt14) {
            	    	        case 1 :
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1105:3: lv_visibility_1_1= 'public'
            	    	            {
            	    	            lv_visibility_1_1=(Token)input.LT(1);
            	    	            match(input,17,FollowSets000.FOLLOW_17_in_ruleGroupLoopedModel2221); 

            	    	                    createLeafNode(grammarAccess.getGroupLoopedModelAccess().getVisibilityPublicKeyword_0_0_0_0(), "visibility"); 
            	    	                

            	    	            	        if (current==null) {
            	    	            	            current = factory.create(grammarAccess.getGroupLoopedModelRule().getType().getClassifier());
            	    	            	            associateNodeWithAstElement(currentNode, current);
            	    	            	        }
            	    	            	        
            	    	            	        try {
            	    	            	       		add(current, "visibility", lv_visibility_1_1, null, lastConsumedNode);
            	    	            	        } catch (ValueConverterException vce) {
            	    	            				handleValueConverterException(vce);
            	    	            	        }
            	    	            	    

            	    	            }
            	    	            break;
            	    	        case 2 :
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1123:8: lv_visibility_1_2= 'private'
            	    	            {
            	    	            lv_visibility_1_2=(Token)input.LT(1);
            	    	            match(input,18,FollowSets000.FOLLOW_18_in_ruleGroupLoopedModel2250); 

            	    	                    createLeafNode(grammarAccess.getGroupLoopedModelAccess().getVisibilityPrivateKeyword_0_0_0_1(), "visibility"); 
            	    	                

            	    	            	        if (current==null) {
            	    	            	            current = factory.create(grammarAccess.getGroupLoopedModelRule().getType().getClassifier());
            	    	            	            associateNodeWithAstElement(currentNode, current);
            	    	            	        }
            	    	            	        
            	    	            	        try {
            	    	            	       		add(current, "visibility", lv_visibility_1_2, null, lastConsumedNode);
            	    	            	        } catch (ValueConverterException vce) {
            	    	            				handleValueConverterException(vce);
            	    	            	        }
            	    	            	    

            	    	            }
            	    	            break;
            	    	        case 3 :
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1141:8: lv_visibility_1_3= 'protected'
            	    	            {
            	    	            lv_visibility_1_3=(Token)input.LT(1);
            	    	            match(input,19,FollowSets000.FOLLOW_19_in_ruleGroupLoopedModel2279); 

            	    	                    createLeafNode(grammarAccess.getGroupLoopedModelAccess().getVisibilityProtectedKeyword_0_0_0_2(), "visibility"); 
            	    	                

            	    	            	        if (current==null) {
            	    	            	            current = factory.create(grammarAccess.getGroupLoopedModelRule().getType().getClassifier());
            	    	            	            associateNodeWithAstElement(currentNode, current);
            	    	            	        }
            	    	            	        
            	    	            	        try {
            	    	            	       		add(current, "visibility", lv_visibility_1_3, null, lastConsumedNode);
            	    	            	        } catch (ValueConverterException vce) {
            	    	            				handleValueConverterException(vce);
            	    	            	        }
            	    	            	    

            	    	            }
            	    	            break;

            	    	    }


            	    	    }


            	    	    }

            	    	     
            	    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	    	    	 				

            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1169:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1169:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1170:5: {...}? => ( ( (lv_static_2_0= 'static' ) ) )
            	    	    {
            	    	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1)) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1)");
            	    	    }
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1170:113: ( ( (lv_static_2_0= 'static' ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1171:6: ( (lv_static_2_0= 'static' ) )
            	    	    {
            	    	     
            	    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1);
            	    	    	 				
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1174:6: ( (lv_static_2_0= 'static' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1175:1: (lv_static_2_0= 'static' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1175:1: (lv_static_2_0= 'static' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1176:3: lv_static_2_0= 'static'
            	    	    {
            	    	    lv_static_2_0=(Token)input.LT(1);
            	    	    match(input,20,FollowSets000.FOLLOW_20_in_ruleGroupLoopedModel2363); 

            	    	            createLeafNode(grammarAccess.getGroupLoopedModelAccess().getStaticStaticKeyword_0_1_0(), "static"); 
            	    	        

            	    	    	        if (current==null) {
            	    	    	            current = factory.create(grammarAccess.getGroupLoopedModelRule().getType().getClassifier());
            	    	    	            associateNodeWithAstElement(currentNode, current);
            	    	    	        }
            	    	    	        
            	    	    	        try {
            	    	    	       		add(current, "static", lv_static_2_0, "static", lastConsumedNode);
            	    	    	        } catch (ValueConverterException vce) {
            	    	    				handleValueConverterException(vce);
            	    	    	        }
            	    	    	    

            	    	    }


            	    	    }

            	    	     
            	    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	    	    	 				

            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 3 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1202:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1202:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1203:5: {...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    	    {
            	    	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2)) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2)");
            	    	    }
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1203:113: ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1204:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    	    {
            	    	     
            	    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2);
            	    	    	 				
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1207:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1208:1: (lv_synchronized_3_0= 'synchronized' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1208:1: (lv_synchronized_3_0= 'synchronized' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1209:3: lv_synchronized_3_0= 'synchronized'
            	    	    {
            	    	    lv_synchronized_3_0=(Token)input.LT(1);
            	    	    match(input,21,FollowSets000.FOLLOW_21_in_ruleGroupLoopedModel2444); 

            	    	            createLeafNode(grammarAccess.getGroupLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0(), "synchronized"); 
            	    	        

            	    	    	        if (current==null) {
            	    	    	            current = factory.create(grammarAccess.getGroupLoopedModelRule().getType().getClassifier());
            	    	    	            associateNodeWithAstElement(currentNode, current);
            	    	    	        }
            	    	    	        
            	    	    	        try {
            	    	    	       		add(current, "synchronized", lv_synchronized_3_0, "synchronized", lastConsumedNode);
            	    	    	        } catch (ValueConverterException vce) {
            	    	    				handleValueConverterException(vce);
            	    	    	        }
            	    	    	    

            	    	    }


            	    	    }

            	    	     
            	    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	    	    	 				

            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 4 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1235:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1235:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1236:5: {...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    	    {
            	    	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3)) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3)");
            	    	    }
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1236:113: ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1237:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    	    {
            	    	     
            	    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3);
            	    	    	 				
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1240:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    	    int alt15=2;
            	    	    int LA15_0 = input.LA(1);

            	    	    if ( (LA15_0==22) ) {
            	    	        alt15=1;
            	    	    }
            	    	    else if ( (LA15_0==23) ) {
            	    	        alt15=2;
            	    	    }
            	    	    else {
            	    	        NoViableAltException nvae =
            	    	            new NoViableAltException("1240:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )", 15, 0, input);

            	    	        throw nvae;
            	    	    }
            	    	    switch (alt15) {
            	    	        case 1 :
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1240:7: ( (lv_abstract_4_0= 'abstract' ) )
            	    	            {
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1240:7: ( (lv_abstract_4_0= 'abstract' ) )
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1241:1: (lv_abstract_4_0= 'abstract' )
            	    	            {
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1241:1: (lv_abstract_4_0= 'abstract' )
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1242:3: lv_abstract_4_0= 'abstract'
            	    	            {
            	    	            lv_abstract_4_0=(Token)input.LT(1);
            	    	            match(input,22,FollowSets000.FOLLOW_22_in_ruleGroupLoopedModel2526); 

            	    	                    createLeafNode(grammarAccess.getGroupLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0(), "abstract"); 
            	    	                

            	    	            	        if (current==null) {
            	    	            	            current = factory.create(grammarAccess.getGroupLoopedModelRule().getType().getClassifier());
            	    	            	            associateNodeWithAstElement(currentNode, current);
            	    	            	        }
            	    	            	        
            	    	            	        try {
            	    	            	       		add(current, "abstract", lv_abstract_4_0, "abstract", lastConsumedNode);
            	    	            	        } catch (ValueConverterException vce) {
            	    	            				handleValueConverterException(vce);
            	    	            	        }
            	    	            	    

            	    	            }


            	    	            }


            	    	            }
            	    	            break;
            	    	        case 2 :
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1262:6: ( (lv_final_5_0= 'final' ) )
            	    	            {
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1262:6: ( (lv_final_5_0= 'final' ) )
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1263:1: (lv_final_5_0= 'final' )
            	    	            {
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1263:1: (lv_final_5_0= 'final' )
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1264:3: lv_final_5_0= 'final'
            	    	            {
            	    	            lv_final_5_0=(Token)input.LT(1);
            	    	            match(input,23,FollowSets000.FOLLOW_23_in_ruleGroupLoopedModel2563); 

            	    	                    createLeafNode(grammarAccess.getGroupLoopedModelAccess().getFinalFinalKeyword_0_3_1_0(), "final"); 
            	    	                

            	    	            	        if (current==null) {
            	    	            	            current = factory.create(grammarAccess.getGroupLoopedModelRule().getType().getClassifier());
            	    	            	            associateNodeWithAstElement(currentNode, current);
            	    	            	        }
            	    	            	        
            	    	            	        try {
            	    	            	       		add(current, "final", lv_final_5_0, "final", lastConsumedNode);
            	    	            	        } catch (ValueConverterException vce) {
            	    	            				handleValueConverterException(vce);
            	    	            	        }
            	    	            	    

            	    	            }


            	    	            }


            	    	            }
            	    	            break;

            	    	    }

            	    	     
            	    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	    	    	 				

            	    	    }


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

            	    if ( !(getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0())) ) {
            	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0())");
            	    }

            	    }


            	    }

            	     
            	    	  getUnorderedGroupHelper().leave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	    	

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            match(input,24,FollowSets000.FOLLOW_24_in_ruleGroupLoopedModel2633); 

                    createLeafNode(grammarAccess.getGroupLoopedModelAccess().getClassKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1302:1: ( (lv_name_7_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1303:1: (lv_name_7_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1303:1: (lv_name_7_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1304:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupLoopedModel2650); 

            			createLeafNode(grammarAccess.getGroupLoopedModelAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getGroupLoopedModelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_7_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,25,FollowSets000.FOLLOW_25_in_ruleGroupLoopedModel2665); 

                    createLeafNode(grammarAccess.getGroupLoopedModelAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            match(input,26,FollowSets000.FOLLOW_26_in_ruleGroupLoopedModel2675); 

                    createLeafNode(grammarAccess.getGroupLoopedModelAccess().getRightCurlyBracketKeyword_4(), null); 
                

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
    // $ANTLR end ruleGroupLoopedModel


    // $ANTLR start entryRuleLoopedAlternativeModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1342:1: entryRuleLoopedAlternativeModel returns [EObject current=null] : iv_ruleLoopedAlternativeModel= ruleLoopedAlternativeModel EOF ;
    public final EObject entryRuleLoopedAlternativeModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopedAlternativeModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1343:2: (iv_ruleLoopedAlternativeModel= ruleLoopedAlternativeModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1344:2: iv_ruleLoopedAlternativeModel= ruleLoopedAlternativeModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLoopedAlternativeModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLoopedAlternativeModel_in_entryRuleLoopedAlternativeModel2711);
            iv_ruleLoopedAlternativeModel=ruleLoopedAlternativeModel();
            _fsp--;

             current =iv_ruleLoopedAlternativeModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoopedAlternativeModel2721); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLoopedAlternativeModel


    // $ANTLR start ruleLoopedAlternativeModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1351:1: ruleLoopedAlternativeModel returns [EObject current=null] : ( ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | ( 'before' ( 'after' )* ) )* 'class' ( (lv_name_8_0= RULE_ID ) ) '{' '}' ) ;
    public final EObject ruleLoopedAlternativeModel() throws RecognitionException {
        EObject current = null;

        Token lv_visibility_0_1=null;
        Token lv_visibility_0_2=null;
        Token lv_visibility_0_3=null;
        Token lv_static_1_0=null;
        Token lv_synchronized_2_0=null;
        Token lv_abstract_3_0=null;
        Token lv_final_4_0=null;
        Token lv_name_8_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1356:6: ( ( ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | ( 'before' ( 'after' )* ) )* 'class' ( (lv_name_8_0= RULE_ID ) ) '{' '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1357:1: ( ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | ( 'before' ( 'after' )* ) )* 'class' ( (lv_name_8_0= RULE_ID ) ) '{' '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1357:1: ( ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | ( 'before' ( 'after' )* ) )* 'class' ( (lv_name_8_0= RULE_ID ) ) '{' '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1357:2: ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | ( 'before' ( 'after' )* ) )* 'class' ( (lv_name_8_0= RULE_ID ) ) '{' '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1357:2: ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | ( 'before' ( 'after' )* ) )*
            loop21:
            do {
                int alt21=6;
                switch ( input.LA(1) ) {
                case 17:
                case 18:
                case 19:
                    {
                    alt21=1;
                    }
                    break;
                case 20:
                    {
                    alt21=2;
                    }
                    break;
                case 21:
                    {
                    alt21=3;
                    }
                    break;
                case 22:
                case 23:
                    {
                    alt21=4;
                    }
                    break;
                case 27:
                    {
                    alt21=5;
                    }
                    break;

                }

                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1357:3: ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1357:3: ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1358:1: ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1358:1: ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1359:1: (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1359:1: (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' )
            	    int alt18=3;
            	    switch ( input.LA(1) ) {
            	    case 17:
            	        {
            	        alt18=1;
            	        }
            	        break;
            	    case 18:
            	        {
            	        alt18=2;
            	        }
            	        break;
            	    case 19:
            	        {
            	        alt18=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("1359:1: (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' )", 18, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt18) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1360:3: lv_visibility_0_1= 'public'
            	            {
            	            lv_visibility_0_1=(Token)input.LT(1);
            	            match(input,17,FollowSets000.FOLLOW_17_in_ruleLoopedAlternativeModel2767); 

            	                    createLeafNode(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityPublicKeyword_0_0_0_0(), "visibility"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getLoopedAlternativeModelRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		add(current, "visibility", lv_visibility_0_1, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1378:8: lv_visibility_0_2= 'private'
            	            {
            	            lv_visibility_0_2=(Token)input.LT(1);
            	            match(input,18,FollowSets000.FOLLOW_18_in_ruleLoopedAlternativeModel2796); 

            	                    createLeafNode(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityPrivateKeyword_0_0_0_1(), "visibility"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getLoopedAlternativeModelRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		add(current, "visibility", lv_visibility_0_2, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1396:8: lv_visibility_0_3= 'protected'
            	            {
            	            lv_visibility_0_3=(Token)input.LT(1);
            	            match(input,19,FollowSets000.FOLLOW_19_in_ruleLoopedAlternativeModel2825); 

            	                    createLeafNode(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityProtectedKeyword_0_0_0_2(), "visibility"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getLoopedAlternativeModelRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		add(current, "visibility", lv_visibility_0_3, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1418:6: ( (lv_static_1_0= 'static' ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1418:6: ( (lv_static_1_0= 'static' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1419:1: (lv_static_1_0= 'static' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1419:1: (lv_static_1_0= 'static' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1420:3: lv_static_1_0= 'static'
            	    {
            	    lv_static_1_0=(Token)input.LT(1);
            	    match(input,20,FollowSets000.FOLLOW_20_in_ruleLoopedAlternativeModel2865); 

            	            createLeafNode(grammarAccess.getLoopedAlternativeModelAccess().getStaticStaticKeyword_0_1_0(), "static"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getLoopedAlternativeModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "static", lv_static_1_0, "static", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1440:6: ( (lv_synchronized_2_0= 'synchronized' ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1440:6: ( (lv_synchronized_2_0= 'synchronized' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1441:1: (lv_synchronized_2_0= 'synchronized' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1441:1: (lv_synchronized_2_0= 'synchronized' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1442:3: lv_synchronized_2_0= 'synchronized'
            	    {
            	    lv_synchronized_2_0=(Token)input.LT(1);
            	    match(input,21,FollowSets000.FOLLOW_21_in_ruleLoopedAlternativeModel2902); 

            	            createLeafNode(grammarAccess.getLoopedAlternativeModelAccess().getSynchronizedSynchronizedKeyword_0_2_0(), "synchronized"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getLoopedAlternativeModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "synchronized", lv_synchronized_2_0, "synchronized", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1462:6: ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1462:6: ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) )
            	    int alt19=2;
            	    int LA19_0 = input.LA(1);

            	    if ( (LA19_0==22) ) {
            	        alt19=1;
            	    }
            	    else if ( (LA19_0==23) ) {
            	        alt19=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("1462:6: ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) )", 19, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt19) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1462:7: ( (lv_abstract_3_0= 'abstract' ) )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1462:7: ( (lv_abstract_3_0= 'abstract' ) )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1463:1: (lv_abstract_3_0= 'abstract' )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1463:1: (lv_abstract_3_0= 'abstract' )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1464:3: lv_abstract_3_0= 'abstract'
            	            {
            	            lv_abstract_3_0=(Token)input.LT(1);
            	            match(input,22,FollowSets000.FOLLOW_22_in_ruleLoopedAlternativeModel2940); 

            	                    createLeafNode(grammarAccess.getLoopedAlternativeModelAccess().getAbstractAbstractKeyword_0_3_0_0(), "abstract"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getLoopedAlternativeModelRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		add(current, "abstract", lv_abstract_3_0, "abstract", lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1484:6: ( (lv_final_4_0= 'final' ) )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1484:6: ( (lv_final_4_0= 'final' ) )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1485:1: (lv_final_4_0= 'final' )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1485:1: (lv_final_4_0= 'final' )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1486:3: lv_final_4_0= 'final'
            	            {
            	            lv_final_4_0=(Token)input.LT(1);
            	            match(input,23,FollowSets000.FOLLOW_23_in_ruleLoopedAlternativeModel2977); 

            	                    createLeafNode(grammarAccess.getLoopedAlternativeModelAccess().getFinalFinalKeyword_0_3_1_0(), "final"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getLoopedAlternativeModelRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		add(current, "final", lv_final_4_0, "final", lastConsumedNode);
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
            	case 5 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1506:6: ( 'before' ( 'after' )* )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1506:6: ( 'before' ( 'after' )* )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1506:8: 'before' ( 'after' )*
            	    {
            	    match(input,27,FollowSets000.FOLLOW_27_in_ruleLoopedAlternativeModel3008); 

            	            createLeafNode(grammarAccess.getLoopedAlternativeModelAccess().getBeforeKeyword_0_4_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1510:1: ( 'after' )*
            	    loop20:
            	    do {
            	        int alt20=2;
            	        int LA20_0 = input.LA(1);

            	        if ( (LA20_0==28) ) {
            	            alt20=1;
            	        }


            	        switch (alt20) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1510:3: 'after'
            	    	    {
            	    	    match(input,28,FollowSets000.FOLLOW_28_in_ruleLoopedAlternativeModel3019); 

            	    	            createLeafNode(grammarAccess.getLoopedAlternativeModelAccess().getAfterKeyword_0_4_1(), null); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop20;
            	        }
            	    } while (true);


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            match(input,24,FollowSets000.FOLLOW_24_in_ruleLoopedAlternativeModel3034); 

                    createLeafNode(grammarAccess.getLoopedAlternativeModelAccess().getClassKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1518:1: ( (lv_name_8_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1519:1: (lv_name_8_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1519:1: (lv_name_8_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1520:3: lv_name_8_0= RULE_ID
            {
            lv_name_8_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoopedAlternativeModel3051); 

            			createLeafNode(grammarAccess.getLoopedAlternativeModelAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLoopedAlternativeModelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_8_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,25,FollowSets000.FOLLOW_25_in_ruleLoopedAlternativeModel3066); 

                    createLeafNode(grammarAccess.getLoopedAlternativeModelAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            match(input,26,FollowSets000.FOLLOW_26_in_ruleLoopedAlternativeModel3076); 

                    createLeafNode(grammarAccess.getLoopedAlternativeModelAccess().getRightCurlyBracketKeyword_4(), null); 
                

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
    // $ANTLR end ruleLoopedAlternativeModel


    // $ANTLR start entryRuleBug304681Model
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1558:1: entryRuleBug304681Model returns [EObject current=null] : iv_ruleBug304681Model= ruleBug304681Model EOF ;
    public final EObject entryRuleBug304681Model() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug304681Model = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1559:2: (iv_ruleBug304681Model= ruleBug304681Model EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1560:2: iv_ruleBug304681Model= ruleBug304681Model EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBug304681ModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Model_in_entryRuleBug304681Model3112);
            iv_ruleBug304681Model=ruleBug304681Model();
            _fsp--;

             current =iv_ruleBug304681Model; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug304681Model3122); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleBug304681Model


    // $ANTLR start ruleBug304681Model
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1567:1: ruleBug304681Model returns [EObject current=null] : ( '{' ( ( ( ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )* ) ) ) '}' ) ;
    public final EObject ruleBug304681Model() throws RecognitionException {
        EObject current = null;

        Token lv_shortDescription_3_0=null;
        Token lv_longDescription_6_0=null;
        Token lv_uid_9_0=null;
        Token lv_flag_11_0=null;
        EObject lv_features_13_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1572:6: ( ( '{' ( ( ( ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )* ) ) ) '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1573:1: ( '{' ( ( ( ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )* ) ) ) '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1573:1: ( '{' ( ( ( ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )* ) ) ) '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1573:3: '{' ( ( ( ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )* ) ) ) '}'
            {
            match(input,25,FollowSets000.FOLLOW_25_in_ruleBug304681Model3157); 

                    createLeafNode(grammarAccess.getBug304681ModelAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1577:1: ( ( ( ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1579:1: ( ( ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1579:1: ( ( ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1580:2: ( ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1());
            	
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1583:2: ( ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1584:3: ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1584:3: ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )*
            loop23:
            do {
                int alt23=6;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==29) && (getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 0))) {
                    alt23=1;
                }
                else if ( (LA23_0==31) && (getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 1))) {
                    alt23=2;
                }
                else if ( (LA23_0==32) && (getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 2))) {
                    alt23=3;
                }
                else if ( (LA23_0==33) && (getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 3))) {
                    alt23=4;
                }
                else if ( ((LA23_0>=34 && LA23_0<=35)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4))) {
                    alt23=5;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1586:4: ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1586:4: ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1587:5: {...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 0)) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1587:111: ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1588:6: ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 0);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1591:6: ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1591:8: 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';'
            	    {
            	    match(input,29,FollowSets000.FOLLOW_29_in_ruleBug304681Model3210); 

            	            createLeafNode(grammarAccess.getBug304681ModelAccess().getShortKeyword_1_0_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1595:1: ( (lv_shortDescription_3_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1596:1: (lv_shortDescription_3_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1596:1: (lv_shortDescription_3_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1597:3: lv_shortDescription_3_0= RULE_STRING
            	    {
            	    lv_shortDescription_3_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleBug304681Model3227); 

            	    			createLeafNode(grammarAccess.getBug304681ModelAccess().getShortDescriptionSTRINGTerminalRuleCall_1_0_1_0(), "shortDescription"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getBug304681ModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"shortDescription",
            	    	        		lv_shortDescription_3_0, 
            	    	        		"STRING", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    match(input,30,FollowSets000.FOLLOW_30_in_ruleBug304681Model3242); 

            	            createLeafNode(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_1_0_2(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1630:4: ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1630:4: ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1631:5: {...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 1)) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1631:111: ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1632:6: ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 1);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1635:6: ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1635:8: 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';'
            	    {
            	    match(input,31,FollowSets000.FOLLOW_31_in_ruleBug304681Model3304); 

            	            createLeafNode(grammarAccess.getBug304681ModelAccess().getLongKeyword_1_1_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1639:1: ( (lv_longDescription_6_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1640:1: (lv_longDescription_6_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1640:1: (lv_longDescription_6_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1641:3: lv_longDescription_6_0= RULE_STRING
            	    {
            	    lv_longDescription_6_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleBug304681Model3321); 

            	    			createLeafNode(grammarAccess.getBug304681ModelAccess().getLongDescriptionSTRINGTerminalRuleCall_1_1_1_0(), "longDescription"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getBug304681ModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"longDescription",
            	    	        		lv_longDescription_6_0, 
            	    	        		"STRING", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    match(input,30,FollowSets000.FOLLOW_30_in_ruleBug304681Model3336); 

            	            createLeafNode(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_1_1_2(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1674:4: ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1674:4: ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1675:5: {...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 2)) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1675:111: ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1676:6: ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 2);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1679:6: ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1679:8: 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';'
            	    {
            	    match(input,32,FollowSets000.FOLLOW_32_in_ruleBug304681Model3398); 

            	            createLeafNode(grammarAccess.getBug304681ModelAccess().getUidKeyword_1_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1683:1: ( (lv_uid_9_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1684:1: (lv_uid_9_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1684:1: (lv_uid_9_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1685:3: lv_uid_9_0= RULE_STRING
            	    {
            	    lv_uid_9_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleBug304681Model3415); 

            	    			createLeafNode(grammarAccess.getBug304681ModelAccess().getUidSTRINGTerminalRuleCall_1_2_1_0(), "uid"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getBug304681ModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"uid",
            	    	        		lv_uid_9_0, 
            	    	        		"STRING", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    match(input,30,FollowSets000.FOLLOW_30_in_ruleBug304681Model3430); 

            	            createLeafNode(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_1_2_2(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1718:4: ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1718:4: ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1719:5: {...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 3)) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1719:111: ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1720:6: ( ( (lv_flag_11_0= 'flag' ) ) ';' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 3);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1723:6: ( ( (lv_flag_11_0= 'flag' ) ) ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1723:7: ( (lv_flag_11_0= 'flag' ) ) ';'
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1723:7: ( (lv_flag_11_0= 'flag' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1724:1: (lv_flag_11_0= 'flag' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1724:1: (lv_flag_11_0= 'flag' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1725:3: lv_flag_11_0= 'flag'
            	    {
            	    lv_flag_11_0=(Token)input.LT(1);
            	    match(input,33,FollowSets000.FOLLOW_33_in_ruleBug304681Model3500); 

            	            createLeafNode(grammarAccess.getBug304681ModelAccess().getFlagFlagKeyword_1_3_0_0(), "flag"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getBug304681ModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "flag", true, "flag", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    match(input,30,FollowSets000.FOLLOW_30_in_ruleBug304681Model3523); 

            	            createLeafNode(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_1_3_1(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1755:4: ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1755:4: ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1756:5: {...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4)) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1756:111: ( ( (lv_features_13_0= ruleBug304681Feature ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1757:6: ( (lv_features_13_0= ruleBug304681Feature ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1760:6: ( (lv_features_13_0= ruleBug304681Feature ) )+
            	    int cnt22=0;
            	    loop22:
            	    do {
            	        int alt22=2;
            	        int LA22_0 = input.LA(1);

            	        if ( (LA22_0==34) ) {
            	            int LA22_6 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4))) ) {
            	                alt22=1;
            	            }


            	        }
            	        else if ( (LA22_0==35) ) {
            	            int LA22_7 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4))) ) {
            	                alt22=1;
            	            }


            	        }


            	        switch (alt22) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1761:1: (lv_features_13_0= ruleBug304681Feature )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1761:1: (lv_features_13_0= ruleBug304681Feature )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1762:3: lv_features_13_0= ruleBug304681Feature
            	    	    {
            	    	     
            	    	    	        currentNode=createCompositeNode(grammarAccess.getBug304681ModelAccess().getFeaturesBug304681FeatureParserRuleCall_1_4_0(), currentNode); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleBug304681Feature_in_ruleBug304681Model3595);
            	    	    lv_features_13_0=ruleBug304681Feature();
            	    	    _fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = factory.create(grammarAccess.getBug304681ModelRule().getType().getClassifier());
            	    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	    	        }
            	    	    	        try {
            	    	    	       		add(
            	    	    	       			current, 
            	    	    	       			"features",
            	    	    	        		lv_features_13_0, 
            	    	    	        		"Bug304681Feature", 
            	    	    	        		currentNode);
            	    	    	        } catch (ValueConverterException vce) {
            	    	    				handleValueConverterException(vce);
            	    	    	        }
            	    	    	        currentNode = currentNode.getParent();
            	    	    	    

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1());
            	    	 				

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

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1());
            	

            }

            match(input,26,FollowSets000.FOLLOW_26_in_ruleBug304681Model3645); 

                    createLeafNode(grammarAccess.getBug304681ModelAccess().getRightCurlyBracketKeyword_2(), null); 
                

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
    // $ANTLR end ruleBug304681Model


    // $ANTLR start entryRuleBug304681Feature
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1810:1: entryRuleBug304681Feature returns [EObject current=null] : iv_ruleBug304681Feature= ruleBug304681Feature EOF ;
    public final EObject entryRuleBug304681Feature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug304681Feature = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1811:2: (iv_ruleBug304681Feature= ruleBug304681Feature EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1812:2: iv_ruleBug304681Feature= ruleBug304681Feature EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBug304681FeatureRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Feature_in_entryRuleBug304681Feature3681);
            iv_ruleBug304681Feature=ruleBug304681Feature();
            _fsp--;

             current =iv_ruleBug304681Feature; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug304681Feature3691); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleBug304681Feature


    // $ANTLR start ruleBug304681Feature
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1819:1: ruleBug304681Feature returns [EObject current=null] : (this_Bug304681Attribute_0= ruleBug304681Attribute | this_Bug304681Reference_1= ruleBug304681Reference ) ;
    public final EObject ruleBug304681Feature() throws RecognitionException {
        EObject current = null;

        EObject this_Bug304681Attribute_0 = null;

        EObject this_Bug304681Reference_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1824:6: ( (this_Bug304681Attribute_0= ruleBug304681Attribute | this_Bug304681Reference_1= ruleBug304681Reference ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1825:1: (this_Bug304681Attribute_0= ruleBug304681Attribute | this_Bug304681Reference_1= ruleBug304681Reference )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1825:1: (this_Bug304681Attribute_0= ruleBug304681Attribute | this_Bug304681Reference_1= ruleBug304681Reference )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==34) ) {
                alt24=1;
            }
            else if ( (LA24_0==35) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1825:1: (this_Bug304681Attribute_0= ruleBug304681Attribute | this_Bug304681Reference_1= ruleBug304681Reference )", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1826:5: this_Bug304681Attribute_0= ruleBug304681Attribute
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getBug304681FeatureAccess().getBug304681AttributeParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleBug304681Attribute_in_ruleBug304681Feature3738);
                    this_Bug304681Attribute_0=ruleBug304681Attribute();
                    _fsp--;

                     
                            current = this_Bug304681Attribute_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1836:5: this_Bug304681Reference_1= ruleBug304681Reference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getBug304681FeatureAccess().getBug304681ReferenceParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleBug304681Reference_in_ruleBug304681Feature3765);
                    this_Bug304681Reference_1=ruleBug304681Reference();
                    _fsp--;

                     
                            current = this_Bug304681Reference_1; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end ruleBug304681Feature


    // $ANTLR start entryRuleBug304681Attribute
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1852:1: entryRuleBug304681Attribute returns [EObject current=null] : iv_ruleBug304681Attribute= ruleBug304681Attribute EOF ;
    public final EObject entryRuleBug304681Attribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug304681Attribute = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1853:2: (iv_ruleBug304681Attribute= ruleBug304681Attribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1854:2: iv_ruleBug304681Attribute= ruleBug304681Attribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBug304681AttributeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Attribute_in_entryRuleBug304681Attribute3800);
            iv_ruleBug304681Attribute=ruleBug304681Attribute();
            _fsp--;

             current =iv_ruleBug304681Attribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug304681Attribute3810); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleBug304681Attribute


    // $ANTLR start ruleBug304681Attribute
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1861:1: ruleBug304681Attribute returns [EObject current=null] : ( 'attr' ( (lv_name_1_0= RULE_ID ) ) ';' ) ;
    public final EObject ruleBug304681Attribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1866:6: ( ( 'attr' ( (lv_name_1_0= RULE_ID ) ) ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1867:1: ( 'attr' ( (lv_name_1_0= RULE_ID ) ) ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1867:1: ( 'attr' ( (lv_name_1_0= RULE_ID ) ) ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1867:3: 'attr' ( (lv_name_1_0= RULE_ID ) ) ';'
            {
            match(input,34,FollowSets000.FOLLOW_34_in_ruleBug304681Attribute3845); 

                    createLeafNode(grammarAccess.getBug304681AttributeAccess().getAttrKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1871:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1872:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1872:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1873:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBug304681Attribute3862); 

            			createLeafNode(grammarAccess.getBug304681AttributeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBug304681AttributeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,30,FollowSets000.FOLLOW_30_in_ruleBug304681Attribute3877); 

                    createLeafNode(grammarAccess.getBug304681AttributeAccess().getSemicolonKeyword_2(), null); 
                

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
    // $ANTLR end ruleBug304681Attribute


    // $ANTLR start entryRuleBug304681Reference
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1907:1: entryRuleBug304681Reference returns [EObject current=null] : iv_ruleBug304681Reference= ruleBug304681Reference EOF ;
    public final EObject entryRuleBug304681Reference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug304681Reference = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1908:2: (iv_ruleBug304681Reference= ruleBug304681Reference EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1909:2: iv_ruleBug304681Reference= ruleBug304681Reference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBug304681ReferenceRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Reference_in_entryRuleBug304681Reference3913);
            iv_ruleBug304681Reference=ruleBug304681Reference();
            _fsp--;

             current =iv_ruleBug304681Reference; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug304681Reference3923); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleBug304681Reference


    // $ANTLR start ruleBug304681Reference
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1916:1: ruleBug304681Reference returns [EObject current=null] : ( 'ref' ( (lv_name_1_0= RULE_ID ) ) ';' ) ;
    public final EObject ruleBug304681Reference() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1921:6: ( ( 'ref' ( (lv_name_1_0= RULE_ID ) ) ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1922:1: ( 'ref' ( (lv_name_1_0= RULE_ID ) ) ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1922:1: ( 'ref' ( (lv_name_1_0= RULE_ID ) ) ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1922:3: 'ref' ( (lv_name_1_0= RULE_ID ) ) ';'
            {
            match(input,35,FollowSets000.FOLLOW_35_in_ruleBug304681Reference3958); 

                    createLeafNode(grammarAccess.getBug304681ReferenceAccess().getRefKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1926:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1927:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1927:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1928:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBug304681Reference3975); 

            			createLeafNode(grammarAccess.getBug304681ReferenceAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBug304681ReferenceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,30,FollowSets000.FOLLOW_30_in_ruleBug304681Reference3990); 

                    createLeafNode(grammarAccess.getBug304681ReferenceAccess().getSemicolonKeyword_2(), null); 
                

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
    // $ANTLR end ruleBug304681Reference


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel121 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_ruleSimpleModel_in_ruleModel142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleModel160 = new BitSet(new long[]{0x0000000000FE0000L});
        public static final BitSet FOLLOW_ruleMandatoryModel_in_ruleModel181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleModel199 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_ruleLoopedModel_in_ruleModel220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleModel238 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_ruleGroupLoopedModel_in_ruleModel259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleModel277 = new BitSet(new long[]{0x0000000009FE0000L});
        public static final BitSet FOLLOW_ruleLoopedAlternativeModel_in_ruleModel298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleModel316 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_ruleBug304681Model_in_ruleModel337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleModel_in_entryRuleSimpleModel374 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleModel384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleSimpleModel471 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_18_in_ruleSimpleModel500 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_19_in_ruleSimpleModel529 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_20_in_ruleSimpleModel613 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_21_in_ruleSimpleModel694 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_22_in_ruleSimpleModel776 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_23_in_ruleSimpleModel813 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_24_in_ruleSimpleModel876 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleModel893 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleSimpleModel908 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleSimpleModel918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryModel_in_entryRuleMandatoryModel954 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMandatoryModel964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleMandatoryModel1051 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_18_in_ruleMandatoryModel1080 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_19_in_ruleMandatoryModel1109 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_20_in_ruleMandatoryModel1193 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_21_in_ruleMandatoryModel1274 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_22_in_ruleMandatoryModel1356 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_23_in_ruleMandatoryModel1393 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_24_in_ruleMandatoryModel1462 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMandatoryModel1479 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleMandatoryModel1494 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleMandatoryModel1504 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoopedModel_in_entryRuleLoopedModel1540 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoopedModel1550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleLoopedModel1637 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_18_in_ruleLoopedModel1666 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_19_in_ruleLoopedModel1695 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_20_in_ruleLoopedModel1780 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_21_in_ruleLoopedModel1862 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_22_in_ruleLoopedModel1945 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_23_in_ruleLoopedModel1982 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_24_in_ruleLoopedModel2046 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoopedModel2063 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleLoopedModel2078 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleLoopedModel2088 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroupLoopedModel_in_entryRuleGroupLoopedModel2124 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroupLoopedModel2134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleGroupLoopedModel2221 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_18_in_ruleGroupLoopedModel2250 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_19_in_ruleGroupLoopedModel2279 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_20_in_ruleGroupLoopedModel2363 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_21_in_ruleGroupLoopedModel2444 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_22_in_ruleGroupLoopedModel2526 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_23_in_ruleGroupLoopedModel2563 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_24_in_ruleGroupLoopedModel2633 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupLoopedModel2650 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleGroupLoopedModel2665 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleGroupLoopedModel2675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoopedAlternativeModel_in_entryRuleLoopedAlternativeModel2711 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoopedAlternativeModel2721 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleLoopedAlternativeModel2767 = new BitSet(new long[]{0x0000000009FE0000L});
        public static final BitSet FOLLOW_18_in_ruleLoopedAlternativeModel2796 = new BitSet(new long[]{0x0000000009FE0000L});
        public static final BitSet FOLLOW_19_in_ruleLoopedAlternativeModel2825 = new BitSet(new long[]{0x0000000009FE0000L});
        public static final BitSet FOLLOW_20_in_ruleLoopedAlternativeModel2865 = new BitSet(new long[]{0x0000000009FE0000L});
        public static final BitSet FOLLOW_21_in_ruleLoopedAlternativeModel2902 = new BitSet(new long[]{0x0000000009FE0000L});
        public static final BitSet FOLLOW_22_in_ruleLoopedAlternativeModel2940 = new BitSet(new long[]{0x0000000009FE0000L});
        public static final BitSet FOLLOW_23_in_ruleLoopedAlternativeModel2977 = new BitSet(new long[]{0x0000000009FE0000L});
        public static final BitSet FOLLOW_27_in_ruleLoopedAlternativeModel3008 = new BitSet(new long[]{0x0000000019FE0000L});
        public static final BitSet FOLLOW_28_in_ruleLoopedAlternativeModel3019 = new BitSet(new long[]{0x0000000019FE0000L});
        public static final BitSet FOLLOW_24_in_ruleLoopedAlternativeModel3034 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoopedAlternativeModel3051 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleLoopedAlternativeModel3066 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleLoopedAlternativeModel3076 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Model_in_entryRuleBug304681Model3112 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug304681Model3122 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleBug304681Model3157 = new BitSet(new long[]{0x0000000FA4000000L});
        public static final BitSet FOLLOW_29_in_ruleBug304681Model3210 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleBug304681Model3227 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleBug304681Model3242 = new BitSet(new long[]{0x0000000FA4000000L});
        public static final BitSet FOLLOW_31_in_ruleBug304681Model3304 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleBug304681Model3321 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleBug304681Model3336 = new BitSet(new long[]{0x0000000FA4000000L});
        public static final BitSet FOLLOW_32_in_ruleBug304681Model3398 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleBug304681Model3415 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleBug304681Model3430 = new BitSet(new long[]{0x0000000FA4000000L});
        public static final BitSet FOLLOW_33_in_ruleBug304681Model3500 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleBug304681Model3523 = new BitSet(new long[]{0x0000000FA4000000L});
        public static final BitSet FOLLOW_ruleBug304681Feature_in_ruleBug304681Model3595 = new BitSet(new long[]{0x0000000FA4000000L});
        public static final BitSet FOLLOW_26_in_ruleBug304681Model3645 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Feature_in_entryRuleBug304681Feature3681 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug304681Feature3691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Attribute_in_ruleBug304681Feature3738 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Reference_in_ruleBug304681Feature3765 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Attribute_in_entryRuleBug304681Attribute3800 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug304681Attribute3810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleBug304681Attribute3845 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBug304681Attribute3862 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleBug304681Attribute3877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Reference_in_entryRuleBug304681Reference3913 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug304681Reference3923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleBug304681Reference3958 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBug304681Reference3975 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleBug304681Reference3990 = new BitSet(new long[]{0x0000000000000002L});
    }


}