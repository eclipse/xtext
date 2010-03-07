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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'1'", "'2'", "'3'", "'4'", "'bug304681'", "'public'", "'private'", "'protected'", "'static'", "'synchronized'", "'abstract'", "'final'", "'class'", "'{'", "'}'", "'short'", "';'", "'long'", "'uid'", "'flag'", "'attr'", "'ref'"
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:81:1: ruleModel returns [EObject current=null] : ( ( '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | ( '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | ( '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | ( '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) | ( 'bug304681' ( (lv_model_9_0= ruleBug304681Model ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_first_1_0 = null;

        EObject lv_second_3_0 = null;

        EObject lv_thrird_5_0 = null;

        EObject lv_forth_7_0 = null;

        EObject lv_model_9_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:86:6: ( ( ( '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | ( '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | ( '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | ( '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) | ( 'bug304681' ( (lv_model_9_0= ruleBug304681Model ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:87:1: ( ( '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | ( '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | ( '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | ( '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) | ( 'bug304681' ( (lv_model_9_0= ruleBug304681Model ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:87:1: ( ( '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | ( '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | ( '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | ( '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) | ( 'bug304681' ( (lv_model_9_0= ruleBug304681Model ) ) ) )
            int alt1=5;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("87:1: ( ( '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | ( '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | ( '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | ( '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) | ( 'bug304681' ( (lv_model_9_0= ruleBug304681Model ) ) ) )", 1, 0, input);

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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:203:6: ( 'bug304681' ( (lv_model_9_0= ruleBug304681Model ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:203:6: ( 'bug304681' ( (lv_model_9_0= ruleBug304681Model ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:203:8: 'bug304681' ( (lv_model_9_0= ruleBug304681Model ) )
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleModel277); 

                            createLeafNode(grammarAccess.getModelAccess().getBug304681Keyword_4_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:207:1: ( (lv_model_9_0= ruleBug304681Model ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:208:1: (lv_model_9_0= ruleBug304681Model )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:208:1: (lv_model_9_0= ruleBug304681Model )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:209:3: lv_model_9_0= ruleBug304681Model
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getModelBug304681ModelParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleBug304681Model_in_ruleModel298);
                    lv_model_9_0=ruleBug304681Model();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"model",
                    	        		lv_model_9_0, 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:239:1: entryRuleSimpleModel returns [EObject current=null] : iv_ruleSimpleModel= ruleSimpleModel EOF ;
    public final EObject entryRuleSimpleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:240:2: (iv_ruleSimpleModel= ruleSimpleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:241:2: iv_ruleSimpleModel= ruleSimpleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleModel_in_entryRuleSimpleModel335);
            iv_ruleSimpleModel=ruleSimpleModel();
            _fsp--;

             current =iv_ruleSimpleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleModel345); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:248:1: ruleSimpleModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) ;
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:253:6: ( ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:254:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:254:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:254:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:254:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:256:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:256:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:257:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            	
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:260:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:261:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:261:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )*
            loop4:
            do {
                int alt4=5;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=16 && LA4_0<=18)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0))) {
                    alt4=1;
                }
                else if ( (LA4_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1))) {
                    alt4=2;
                }
                else if ( (LA4_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2))) {
                    alt4=3;
                }
                else if ( ((LA4_0>=21 && LA4_0<=22)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3))) {
                    alt4=4;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:263:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:263:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:264:5: {...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0)) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:264:108: ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:265:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:268:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:269:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:269:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:270:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:270:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    int alt2=3;
            	    switch ( input.LA(1) ) {
            	    case 16:
            	        {
            	        alt2=1;
            	        }
            	        break;
            	    case 17:
            	        {
            	        alt2=2;
            	        }
            	        break;
            	    case 18:
            	        {
            	        alt2=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("270:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )", 2, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt2) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:271:3: lv_visibility_1_1= 'public'
            	            {
            	            lv_visibility_1_1=(Token)input.LT(1);
            	            match(input,16,FollowSets000.FOLLOW_16_in_ruleSimpleModel432); 

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
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:289:8: lv_visibility_1_2= 'private'
            	            {
            	            lv_visibility_1_2=(Token)input.LT(1);
            	            match(input,17,FollowSets000.FOLLOW_17_in_ruleSimpleModel461); 

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
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:307:8: lv_visibility_1_3= 'protected'
            	            {
            	            lv_visibility_1_3=(Token)input.LT(1);
            	            match(input,18,FollowSets000.FOLLOW_18_in_ruleSimpleModel490); 

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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:335:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:335:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:336:5: {...}? => ( ( (lv_static_2_0= 'static' ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1)) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:336:108: ( ( (lv_static_2_0= 'static' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:337:6: ( (lv_static_2_0= 'static' ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:340:6: ( (lv_static_2_0= 'static' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:341:1: (lv_static_2_0= 'static' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:341:1: (lv_static_2_0= 'static' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:342:3: lv_static_2_0= 'static'
            	    {
            	    lv_static_2_0=(Token)input.LT(1);
            	    match(input,19,FollowSets000.FOLLOW_19_in_ruleSimpleModel574); 

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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:368:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:368:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:369:5: {...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2)) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:369:108: ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:370:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:373:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:374:1: (lv_synchronized_3_0= 'synchronized' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:374:1: (lv_synchronized_3_0= 'synchronized' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:375:3: lv_synchronized_3_0= 'synchronized'
            	    {
            	    lv_synchronized_3_0=(Token)input.LT(1);
            	    match(input,20,FollowSets000.FOLLOW_20_in_ruleSimpleModel655); 

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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:401:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:401:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:402:5: {...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3)) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:402:108: ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:403:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:406:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0==21) ) {
            	        alt3=1;
            	    }
            	    else if ( (LA3_0==22) ) {
            	        alt3=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("406:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )", 3, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:406:7: ( (lv_abstract_4_0= 'abstract' ) )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:406:7: ( (lv_abstract_4_0= 'abstract' ) )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:407:1: (lv_abstract_4_0= 'abstract' )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:407:1: (lv_abstract_4_0= 'abstract' )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:408:3: lv_abstract_4_0= 'abstract'
            	            {
            	            lv_abstract_4_0=(Token)input.LT(1);
            	            match(input,21,FollowSets000.FOLLOW_21_in_ruleSimpleModel737); 

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
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:428:6: ( (lv_final_5_0= 'final' ) )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:428:6: ( (lv_final_5_0= 'final' ) )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:429:1: (lv_final_5_0= 'final' )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:429:1: (lv_final_5_0= 'final' )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:430:3: lv_final_5_0= 'final'
            	            {
            	            lv_final_5_0=(Token)input.LT(1);
            	            match(input,22,FollowSets000.FOLLOW_22_in_ruleSimpleModel774); 

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

            match(input,23,FollowSets000.FOLLOW_23_in_ruleSimpleModel837); 

                    createLeafNode(grammarAccess.getSimpleModelAccess().getClassKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:467:1: ( (lv_name_7_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:468:1: (lv_name_7_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:468:1: (lv_name_7_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:469:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleModel854); 

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

            match(input,24,FollowSets000.FOLLOW_24_in_ruleSimpleModel869); 

                    createLeafNode(grammarAccess.getSimpleModelAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            match(input,25,FollowSets000.FOLLOW_25_in_ruleSimpleModel879); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:507:1: entryRuleMandatoryModel returns [EObject current=null] : iv_ruleMandatoryModel= ruleMandatoryModel EOF ;
    public final EObject entryRuleMandatoryModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMandatoryModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:508:2: (iv_ruleMandatoryModel= ruleMandatoryModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:509:2: iv_ruleMandatoryModel= ruleMandatoryModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMandatoryModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMandatoryModel_in_entryRuleMandatoryModel915);
            iv_ruleMandatoryModel=ruleMandatoryModel();
            _fsp--;

             current =iv_ruleMandatoryModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMandatoryModel925); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:516:1: ruleMandatoryModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) ;
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:521:6: ( ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:522:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:522:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:522:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:522:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:524:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:524:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:525:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            	
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:528:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?)
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:529:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:529:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=5;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=16 && LA7_0<=18)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0))) {
                    alt7=1;
                }
                else if ( (LA7_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1))) {
                    alt7=2;
                }
                else if ( (LA7_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2))) {
                    alt7=3;
                }
                else if ( ((LA7_0>=21 && LA7_0<=22)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3))) {
                    alt7=4;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:531:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:531:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:532:5: {...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0)) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:532:111: ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:533:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:536:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:537:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:537:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:538:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:538:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    int alt5=3;
            	    switch ( input.LA(1) ) {
            	    case 16:
            	        {
            	        alt5=1;
            	        }
            	        break;
            	    case 17:
            	        {
            	        alt5=2;
            	        }
            	        break;
            	    case 18:
            	        {
            	        alt5=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("538:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )", 5, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt5) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:539:3: lv_visibility_1_1= 'public'
            	            {
            	            lv_visibility_1_1=(Token)input.LT(1);
            	            match(input,16,FollowSets000.FOLLOW_16_in_ruleMandatoryModel1012); 

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
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:557:8: lv_visibility_1_2= 'private'
            	            {
            	            lv_visibility_1_2=(Token)input.LT(1);
            	            match(input,17,FollowSets000.FOLLOW_17_in_ruleMandatoryModel1041); 

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
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:575:8: lv_visibility_1_3= 'protected'
            	            {
            	            lv_visibility_1_3=(Token)input.LT(1);
            	            match(input,18,FollowSets000.FOLLOW_18_in_ruleMandatoryModel1070); 

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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:603:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:603:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:604:5: {...}? => ( ( (lv_static_2_0= 'static' ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1)) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:604:111: ( ( (lv_static_2_0= 'static' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:605:6: ( (lv_static_2_0= 'static' ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:608:6: ( (lv_static_2_0= 'static' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:609:1: (lv_static_2_0= 'static' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:609:1: (lv_static_2_0= 'static' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:610:3: lv_static_2_0= 'static'
            	    {
            	    lv_static_2_0=(Token)input.LT(1);
            	    match(input,19,FollowSets000.FOLLOW_19_in_ruleMandatoryModel1154); 

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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:636:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:636:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:637:5: {...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2)) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:637:111: ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:638:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:641:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:642:1: (lv_synchronized_3_0= 'synchronized' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:642:1: (lv_synchronized_3_0= 'synchronized' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:643:3: lv_synchronized_3_0= 'synchronized'
            	    {
            	    lv_synchronized_3_0=(Token)input.LT(1);
            	    match(input,20,FollowSets000.FOLLOW_20_in_ruleMandatoryModel1235); 

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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:669:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:669:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:670:5: {...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3)) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:670:111: ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:671:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:674:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==21) ) {
            	        alt6=1;
            	    }
            	    else if ( (LA6_0==22) ) {
            	        alt6=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("674:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )", 6, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:674:7: ( (lv_abstract_4_0= 'abstract' ) )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:674:7: ( (lv_abstract_4_0= 'abstract' ) )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:675:1: (lv_abstract_4_0= 'abstract' )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:675:1: (lv_abstract_4_0= 'abstract' )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:676:3: lv_abstract_4_0= 'abstract'
            	            {
            	            lv_abstract_4_0=(Token)input.LT(1);
            	            match(input,21,FollowSets000.FOLLOW_21_in_ruleMandatoryModel1317); 

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
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:696:6: ( (lv_final_5_0= 'final' ) )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:696:6: ( (lv_final_5_0= 'final' ) )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:697:1: (lv_final_5_0= 'final' )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:697:1: (lv_final_5_0= 'final' )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:698:3: lv_final_5_0= 'final'
            	            {
            	            lv_final_5_0=(Token)input.LT(1);
            	            match(input,22,FollowSets000.FOLLOW_22_in_ruleMandatoryModel1354); 

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

            match(input,23,FollowSets000.FOLLOW_23_in_ruleMandatoryModel1423); 

                    createLeafNode(grammarAccess.getMandatoryModelAccess().getClassKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:736:1: ( (lv_name_7_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:737:1: (lv_name_7_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:737:1: (lv_name_7_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:738:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMandatoryModel1440); 

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

            match(input,24,FollowSets000.FOLLOW_24_in_ruleMandatoryModel1455); 

                    createLeafNode(grammarAccess.getMandatoryModelAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            match(input,25,FollowSets000.FOLLOW_25_in_ruleMandatoryModel1465); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:776:1: entryRuleLoopedModel returns [EObject current=null] : iv_ruleLoopedModel= ruleLoopedModel EOF ;
    public final EObject entryRuleLoopedModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopedModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:777:2: (iv_ruleLoopedModel= ruleLoopedModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:778:2: iv_ruleLoopedModel= ruleLoopedModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLoopedModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLoopedModel_in_entryRuleLoopedModel1501);
            iv_ruleLoopedModel=ruleLoopedModel();
            _fsp--;

             current =iv_ruleLoopedModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoopedModel1511); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:785:1: ruleLoopedModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) ;
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:790:6: ( ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:791:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:791:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:791:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:791:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:793:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:793:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:794:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            	
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:797:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:798:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:798:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )*
            loop13:
            do {
                int alt13=5;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=16 && LA13_0<=18)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0))) {
                    alt13=1;
                }
                else if ( (LA13_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1))) {
                    alt13=2;
                }
                else if ( (LA13_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2))) {
                    alt13=3;
                }
                else if ( ((LA13_0>=21 && LA13_0<=22)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3))) {
                    alt13=4;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:800:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:800:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:801:5: {...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0)) ) {
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:801:108: ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:802:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:805:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        switch ( input.LA(1) ) {
            	        case 16:
            	            {
            	            int LA9_2 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0))) ) {
            	                alt9=1;
            	            }


            	            }
            	            break;
            	        case 17:
            	            {
            	            int LA9_3 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0))) ) {
            	                alt9=1;
            	            }


            	            }
            	            break;
            	        case 18:
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
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:806:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:806:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:807:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:807:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    	    int alt8=3;
            	    	    switch ( input.LA(1) ) {
            	    	    case 16:
            	    	        {
            	    	        alt8=1;
            	    	        }
            	    	        break;
            	    	    case 17:
            	    	        {
            	    	        alt8=2;
            	    	        }
            	    	        break;
            	    	    case 18:
            	    	        {
            	    	        alt8=3;
            	    	        }
            	    	        break;
            	    	    default:
            	    	        NoViableAltException nvae =
            	    	            new NoViableAltException("807:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )", 8, 0, input);

            	    	        throw nvae;
            	    	    }

            	    	    switch (alt8) {
            	    	        case 1 :
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:808:3: lv_visibility_1_1= 'public'
            	    	            {
            	    	            lv_visibility_1_1=(Token)input.LT(1);
            	    	            match(input,16,FollowSets000.FOLLOW_16_in_ruleLoopedModel1598); 

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
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:826:8: lv_visibility_1_2= 'private'
            	    	            {
            	    	            lv_visibility_1_2=(Token)input.LT(1);
            	    	            match(input,17,FollowSets000.FOLLOW_17_in_ruleLoopedModel1627); 

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
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:844:8: lv_visibility_1_3= 'protected'
            	    	            {
            	    	            lv_visibility_1_3=(Token)input.LT(1);
            	    	            match(input,18,FollowSets000.FOLLOW_18_in_ruleLoopedModel1656); 

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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:872:4: ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:872:4: ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:873:5: {...}? => ( ( (lv_static_2_0= 'static' ) )+ )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1)) ) {
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:873:108: ( ( (lv_static_2_0= 'static' ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:874:6: ( (lv_static_2_0= 'static' ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:877:6: ( (lv_static_2_0= 'static' ) )+
            	    int cnt10=0;
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==19) ) {
            	            int LA10_3 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1))) ) {
            	                alt10=1;
            	            }


            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:878:1: (lv_static_2_0= 'static' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:878:1: (lv_static_2_0= 'static' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:879:3: lv_static_2_0= 'static'
            	    	    {
            	    	    lv_static_2_0=(Token)input.LT(1);
            	    	    match(input,19,FollowSets000.FOLLOW_19_in_ruleLoopedModel1741); 

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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:905:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:905:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:906:5: {...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2)) ) {
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:906:108: ( ( (lv_synchronized_3_0= 'synchronized' ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:907:6: ( (lv_synchronized_3_0= 'synchronized' ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:910:6: ( (lv_synchronized_3_0= 'synchronized' ) )+
            	    int cnt11=0;
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( (LA11_0==20) ) {
            	            int LA11_4 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2))) ) {
            	                alt11=1;
            	            }


            	        }


            	        switch (alt11) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:911:1: (lv_synchronized_3_0= 'synchronized' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:911:1: (lv_synchronized_3_0= 'synchronized' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:912:3: lv_synchronized_3_0= 'synchronized'
            	    	    {
            	    	    lv_synchronized_3_0=(Token)input.LT(1);
            	    	    match(input,20,FollowSets000.FOLLOW_20_in_ruleLoopedModel1823); 

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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:938:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:938:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:939:5: {...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3)) ) {
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:939:108: ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:940:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:943:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+
            	    int cnt12=0;
            	    loop12:
            	    do {
            	        int alt12=3;
            	        int LA12_0 = input.LA(1);

            	        if ( (LA12_0==21) ) {
            	            int LA12_5 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3))) ) {
            	                alt12=1;
            	            }


            	        }
            	        else if ( (LA12_0==22) ) {
            	            int LA12_6 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3))) ) {
            	                alt12=2;
            	            }


            	        }


            	        switch (alt12) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:943:7: ( (lv_abstract_4_0= 'abstract' ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:943:7: ( (lv_abstract_4_0= 'abstract' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:944:1: (lv_abstract_4_0= 'abstract' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:944:1: (lv_abstract_4_0= 'abstract' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:945:3: lv_abstract_4_0= 'abstract'
            	    	    {
            	    	    lv_abstract_4_0=(Token)input.LT(1);
            	    	    match(input,21,FollowSets000.FOLLOW_21_in_ruleLoopedModel1906); 

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
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:965:6: ( (lv_final_5_0= 'final' ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:965:6: ( (lv_final_5_0= 'final' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:966:1: (lv_final_5_0= 'final' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:966:1: (lv_final_5_0= 'final' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:967:3: lv_final_5_0= 'final'
            	    	    {
            	    	    lv_final_5_0=(Token)input.LT(1);
            	    	    match(input,22,FollowSets000.FOLLOW_22_in_ruleLoopedModel1943); 

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

            match(input,23,FollowSets000.FOLLOW_23_in_ruleLoopedModel2007); 

                    createLeafNode(grammarAccess.getLoopedModelAccess().getClassKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1004:1: ( (lv_name_7_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1005:1: (lv_name_7_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1005:1: (lv_name_7_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1006:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoopedModel2024); 

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

            match(input,24,FollowSets000.FOLLOW_24_in_ruleLoopedModel2039); 

                    createLeafNode(grammarAccess.getLoopedModelAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            match(input,25,FollowSets000.FOLLOW_25_in_ruleLoopedModel2049); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1044:1: entryRuleGroupLoopedModel returns [EObject current=null] : iv_ruleGroupLoopedModel= ruleGroupLoopedModel EOF ;
    public final EObject entryRuleGroupLoopedModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupLoopedModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1045:2: (iv_ruleGroupLoopedModel= ruleGroupLoopedModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1046:2: iv_ruleGroupLoopedModel= ruleGroupLoopedModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGroupLoopedModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleGroupLoopedModel_in_entryRuleGroupLoopedModel2085);
            iv_ruleGroupLoopedModel=ruleGroupLoopedModel();
            _fsp--;

             current =iv_ruleGroupLoopedModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroupLoopedModel2095); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1053:1: ruleGroupLoopedModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )* 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) ;
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
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1058:6: ( ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )* 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1059:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )* 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1059:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )* 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1059:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )* 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1059:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=16 && LA17_0<=18)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0))) {
                    alt17=1;
                }
                else if ( (LA17_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1))) {
                    alt17=1;
                }
                else if ( (LA17_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2))) {
                    alt17=1;
                }
                else if ( ((LA17_0>=21 && LA17_0<=22)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3))) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1061:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1061:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1062:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?)
            	    {
            	     
            	    	  getUnorderedGroupHelper().enter(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	    	
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1065:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?)
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1066:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1066:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+
            	    int cnt16=0;
            	    loop16:
            	    do {
            	        int alt16=5;
            	        int LA16_0 = input.LA(1);

            	        if ( (LA16_0==16) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0))) {
            	            int LA16_2 = input.LA(2);

            	            if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)) ) {
            	                alt16=1;
            	            }


            	        }
            	        else if ( (LA16_0==17) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0))) {
            	            int LA16_3 = input.LA(2);

            	            if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)) ) {
            	                alt16=1;
            	            }


            	        }
            	        else if ( (LA16_0==18) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0))) {
            	            int LA16_4 = input.LA(2);

            	            if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)) ) {
            	                alt16=1;
            	            }


            	        }
            	        else if ( (LA16_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1))) {
            	            int LA16_5 = input.LA(2);

            	            if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1)) ) {
            	                alt16=2;
            	            }


            	        }
            	        else if ( (LA16_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2))) {
            	            int LA16_6 = input.LA(2);

            	            if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2)) ) {
            	                alt16=3;
            	            }


            	        }
            	        else if ( (LA16_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3))) {
            	            int LA16_7 = input.LA(2);

            	            if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3)) ) {
            	                alt16=4;
            	            }


            	        }
            	        else if ( (LA16_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3))) {
            	            int LA16_8 = input.LA(2);

            	            if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3)) ) {
            	                alt16=4;
            	            }


            	        }


            	        switch (alt16) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1068:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1068:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1069:5: {...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    	    {
            	    	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)");
            	    	    }
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1069:113: ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1070:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    	    {
            	    	     
            	    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0);
            	    	    	 				
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1073:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1074:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1074:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1075:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1075:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    	    int alt14=3;
            	    	    switch ( input.LA(1) ) {
            	    	    case 16:
            	    	        {
            	    	        alt14=1;
            	    	        }
            	    	        break;
            	    	    case 17:
            	    	        {
            	    	        alt14=2;
            	    	        }
            	    	        break;
            	    	    case 18:
            	    	        {
            	    	        alt14=3;
            	    	        }
            	    	        break;
            	    	    default:
            	    	        NoViableAltException nvae =
            	    	            new NoViableAltException("1075:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )", 14, 0, input);

            	    	        throw nvae;
            	    	    }

            	    	    switch (alt14) {
            	    	        case 1 :
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1076:3: lv_visibility_1_1= 'public'
            	    	            {
            	    	            lv_visibility_1_1=(Token)input.LT(1);
            	    	            match(input,16,FollowSets000.FOLLOW_16_in_ruleGroupLoopedModel2182); 

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
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1094:8: lv_visibility_1_2= 'private'
            	    	            {
            	    	            lv_visibility_1_2=(Token)input.LT(1);
            	    	            match(input,17,FollowSets000.FOLLOW_17_in_ruleGroupLoopedModel2211); 

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
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1112:8: lv_visibility_1_3= 'protected'
            	    	            {
            	    	            lv_visibility_1_3=(Token)input.LT(1);
            	    	            match(input,18,FollowSets000.FOLLOW_18_in_ruleGroupLoopedModel2240); 

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
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1140:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1140:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1141:5: {...}? => ( ( (lv_static_2_0= 'static' ) ) )
            	    	    {
            	    	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1)) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1)");
            	    	    }
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1141:113: ( ( (lv_static_2_0= 'static' ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1142:6: ( (lv_static_2_0= 'static' ) )
            	    	    {
            	    	     
            	    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1);
            	    	    	 				
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1145:6: ( (lv_static_2_0= 'static' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1146:1: (lv_static_2_0= 'static' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1146:1: (lv_static_2_0= 'static' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1147:3: lv_static_2_0= 'static'
            	    	    {
            	    	    lv_static_2_0=(Token)input.LT(1);
            	    	    match(input,19,FollowSets000.FOLLOW_19_in_ruleGroupLoopedModel2324); 

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
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1173:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1173:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1174:5: {...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    	    {
            	    	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2)) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2)");
            	    	    }
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1174:113: ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1175:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    	    {
            	    	     
            	    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2);
            	    	    	 				
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1178:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1179:1: (lv_synchronized_3_0= 'synchronized' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1179:1: (lv_synchronized_3_0= 'synchronized' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1180:3: lv_synchronized_3_0= 'synchronized'
            	    	    {
            	    	    lv_synchronized_3_0=(Token)input.LT(1);
            	    	    match(input,20,FollowSets000.FOLLOW_20_in_ruleGroupLoopedModel2405); 

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
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1206:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1206:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1207:5: {...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    	    {
            	    	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3)) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3)");
            	    	    }
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1207:113: ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1208:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    	    {
            	    	     
            	    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3);
            	    	    	 				
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1211:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    	    int alt15=2;
            	    	    int LA15_0 = input.LA(1);

            	    	    if ( (LA15_0==21) ) {
            	    	        alt15=1;
            	    	    }
            	    	    else if ( (LA15_0==22) ) {
            	    	        alt15=2;
            	    	    }
            	    	    else {
            	    	        NoViableAltException nvae =
            	    	            new NoViableAltException("1211:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )", 15, 0, input);

            	    	        throw nvae;
            	    	    }
            	    	    switch (alt15) {
            	    	        case 1 :
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1211:7: ( (lv_abstract_4_0= 'abstract' ) )
            	    	            {
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1211:7: ( (lv_abstract_4_0= 'abstract' ) )
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1212:1: (lv_abstract_4_0= 'abstract' )
            	    	            {
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1212:1: (lv_abstract_4_0= 'abstract' )
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1213:3: lv_abstract_4_0= 'abstract'
            	    	            {
            	    	            lv_abstract_4_0=(Token)input.LT(1);
            	    	            match(input,21,FollowSets000.FOLLOW_21_in_ruleGroupLoopedModel2487); 

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
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1233:6: ( (lv_final_5_0= 'final' ) )
            	    	            {
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1233:6: ( (lv_final_5_0= 'final' ) )
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1234:1: (lv_final_5_0= 'final' )
            	    	            {
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1234:1: (lv_final_5_0= 'final' )
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1235:3: lv_final_5_0= 'final'
            	    	            {
            	    	            lv_final_5_0=(Token)input.LT(1);
            	    	            match(input,22,FollowSets000.FOLLOW_22_in_ruleGroupLoopedModel2524); 

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

            match(input,23,FollowSets000.FOLLOW_23_in_ruleGroupLoopedModel2594); 

                    createLeafNode(grammarAccess.getGroupLoopedModelAccess().getClassKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1273:1: ( (lv_name_7_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1274:1: (lv_name_7_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1274:1: (lv_name_7_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1275:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupLoopedModel2611); 

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

            match(input,24,FollowSets000.FOLLOW_24_in_ruleGroupLoopedModel2626); 

                    createLeafNode(grammarAccess.getGroupLoopedModelAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            match(input,25,FollowSets000.FOLLOW_25_in_ruleGroupLoopedModel2636); 

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


    // $ANTLR start entryRuleBug304681Model
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1313:1: entryRuleBug304681Model returns [EObject current=null] : iv_ruleBug304681Model= ruleBug304681Model EOF ;
    public final EObject entryRuleBug304681Model() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug304681Model = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1314:2: (iv_ruleBug304681Model= ruleBug304681Model EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1315:2: iv_ruleBug304681Model= ruleBug304681Model EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBug304681ModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Model_in_entryRuleBug304681Model2672);
            iv_ruleBug304681Model=ruleBug304681Model();
            _fsp--;

             current =iv_ruleBug304681Model; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug304681Model2682); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1322:1: ruleBug304681Model returns [EObject current=null] : ( '{' ( ( ( ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )* ) ) ) '}' ) ;
    public final EObject ruleBug304681Model() throws RecognitionException {
        EObject current = null;

        Token lv_shortDescription_3_0=null;
        Token lv_longDescription_6_0=null;
        Token lv_uid_9_0=null;
        Token lv_flag_11_0=null;
        EObject lv_features_13_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1327:6: ( ( '{' ( ( ( ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )* ) ) ) '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1328:1: ( '{' ( ( ( ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )* ) ) ) '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1328:1: ( '{' ( ( ( ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )* ) ) ) '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1328:3: '{' ( ( ( ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )* ) ) ) '}'
            {
            match(input,24,FollowSets000.FOLLOW_24_in_ruleBug304681Model2717); 

                    createLeafNode(grammarAccess.getBug304681ModelAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1332:1: ( ( ( ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1334:1: ( ( ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1334:1: ( ( ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1335:2: ( ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1());
            	
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1338:2: ( ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1339:3: ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1339:3: ( ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) ) )*
            loop19:
            do {
                int alt19=6;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==26) && (getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 0))) {
                    alt19=1;
                }
                else if ( (LA19_0==28) && (getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 1))) {
                    alt19=2;
                }
                else if ( (LA19_0==29) && (getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 2))) {
                    alt19=3;
                }
                else if ( (LA19_0==30) && (getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 3))) {
                    alt19=4;
                }
                else if ( ((LA19_0>=31 && LA19_0<=32)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4))) {
                    alt19=5;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1341:4: ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1341:4: ({...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1342:5: {...}? => ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 0)) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1342:111: ( ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1343:6: ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 0);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1346:6: ( 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1346:8: 'short' ( (lv_shortDescription_3_0= RULE_STRING ) ) ';'
            	    {
            	    match(input,26,FollowSets000.FOLLOW_26_in_ruleBug304681Model2770); 

            	            createLeafNode(grammarAccess.getBug304681ModelAccess().getShortKeyword_1_0_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1350:1: ( (lv_shortDescription_3_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1351:1: (lv_shortDescription_3_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1351:1: (lv_shortDescription_3_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1352:3: lv_shortDescription_3_0= RULE_STRING
            	    {
            	    lv_shortDescription_3_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleBug304681Model2787); 

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

            	    match(input,27,FollowSets000.FOLLOW_27_in_ruleBug304681Model2802); 

            	            createLeafNode(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_1_0_2(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1385:4: ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1385:4: ({...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1386:5: {...}? => ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 1)) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1386:111: ( ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1387:6: ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 1);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1390:6: ( 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1390:8: 'long' ( (lv_longDescription_6_0= RULE_STRING ) ) ';'
            	    {
            	    match(input,28,FollowSets000.FOLLOW_28_in_ruleBug304681Model2864); 

            	            createLeafNode(grammarAccess.getBug304681ModelAccess().getLongKeyword_1_1_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1394:1: ( (lv_longDescription_6_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1395:1: (lv_longDescription_6_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1395:1: (lv_longDescription_6_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1396:3: lv_longDescription_6_0= RULE_STRING
            	    {
            	    lv_longDescription_6_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleBug304681Model2881); 

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

            	    match(input,27,FollowSets000.FOLLOW_27_in_ruleBug304681Model2896); 

            	            createLeafNode(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_1_1_2(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1429:4: ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1429:4: ({...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1430:5: {...}? => ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 2)) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1430:111: ( ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1431:6: ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 2);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1434:6: ( 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1434:8: 'uid' ( (lv_uid_9_0= RULE_STRING ) ) ';'
            	    {
            	    match(input,29,FollowSets000.FOLLOW_29_in_ruleBug304681Model2958); 

            	            createLeafNode(grammarAccess.getBug304681ModelAccess().getUidKeyword_1_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1438:1: ( (lv_uid_9_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1439:1: (lv_uid_9_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1439:1: (lv_uid_9_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1440:3: lv_uid_9_0= RULE_STRING
            	    {
            	    lv_uid_9_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleBug304681Model2975); 

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

            	    match(input,27,FollowSets000.FOLLOW_27_in_ruleBug304681Model2990); 

            	            createLeafNode(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_1_2_2(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1473:4: ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1473:4: ({...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1474:5: {...}? => ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 3)) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1474:111: ( ( ( (lv_flag_11_0= 'flag' ) ) ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1475:6: ( ( (lv_flag_11_0= 'flag' ) ) ';' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 3);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1478:6: ( ( (lv_flag_11_0= 'flag' ) ) ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1478:7: ( (lv_flag_11_0= 'flag' ) ) ';'
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1478:7: ( (lv_flag_11_0= 'flag' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1479:1: (lv_flag_11_0= 'flag' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1479:1: (lv_flag_11_0= 'flag' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1480:3: lv_flag_11_0= 'flag'
            	    {
            	    lv_flag_11_0=(Token)input.LT(1);
            	    match(input,30,FollowSets000.FOLLOW_30_in_ruleBug304681Model3060); 

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

            	    match(input,27,FollowSets000.FOLLOW_27_in_ruleBug304681Model3083); 

            	            createLeafNode(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_1_3_1(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1510:4: ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1510:4: ({...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1511:5: {...}? => ( ( (lv_features_13_0= ruleBug304681Feature ) )+ )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4)) ) {
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1511:111: ( ( (lv_features_13_0= ruleBug304681Feature ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1512:6: ( (lv_features_13_0= ruleBug304681Feature ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1515:6: ( (lv_features_13_0= ruleBug304681Feature ) )+
            	    int cnt18=0;
            	    loop18:
            	    do {
            	        int alt18=2;
            	        int LA18_0 = input.LA(1);

            	        if ( (LA18_0==31) ) {
            	            int LA18_6 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4))) ) {
            	                alt18=1;
            	            }


            	        }
            	        else if ( (LA18_0==32) ) {
            	            int LA18_7 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4))) ) {
            	                alt18=1;
            	            }


            	        }


            	        switch (alt18) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1516:1: (lv_features_13_0= ruleBug304681Feature )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1516:1: (lv_features_13_0= ruleBug304681Feature )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1517:3: lv_features_13_0= ruleBug304681Feature
            	    	    {
            	    	     
            	    	    	        currentNode=createCompositeNode(grammarAccess.getBug304681ModelAccess().getFeaturesBug304681FeatureParserRuleCall_1_4_0(), currentNode); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleBug304681Feature_in_ruleBug304681Model3155);
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
            	    	    if ( cnt18 >= 1 ) break loop18;
            	                EarlyExitException eee =
            	                    new EarlyExitException(18, input);
            	                throw eee;
            	        }
            	        cnt18++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1());
            	

            }

            match(input,25,FollowSets000.FOLLOW_25_in_ruleBug304681Model3205); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1565:1: entryRuleBug304681Feature returns [EObject current=null] : iv_ruleBug304681Feature= ruleBug304681Feature EOF ;
    public final EObject entryRuleBug304681Feature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug304681Feature = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1566:2: (iv_ruleBug304681Feature= ruleBug304681Feature EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1567:2: iv_ruleBug304681Feature= ruleBug304681Feature EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBug304681FeatureRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Feature_in_entryRuleBug304681Feature3241);
            iv_ruleBug304681Feature=ruleBug304681Feature();
            _fsp--;

             current =iv_ruleBug304681Feature; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug304681Feature3251); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1574:1: ruleBug304681Feature returns [EObject current=null] : (this_Bug304681Attribute_0= ruleBug304681Attribute | this_Bug304681Reference_1= ruleBug304681Reference ) ;
    public final EObject ruleBug304681Feature() throws RecognitionException {
        EObject current = null;

        EObject this_Bug304681Attribute_0 = null;

        EObject this_Bug304681Reference_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1579:6: ( (this_Bug304681Attribute_0= ruleBug304681Attribute | this_Bug304681Reference_1= ruleBug304681Reference ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1580:1: (this_Bug304681Attribute_0= ruleBug304681Attribute | this_Bug304681Reference_1= ruleBug304681Reference )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1580:1: (this_Bug304681Attribute_0= ruleBug304681Attribute | this_Bug304681Reference_1= ruleBug304681Reference )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==31) ) {
                alt20=1;
            }
            else if ( (LA20_0==32) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1580:1: (this_Bug304681Attribute_0= ruleBug304681Attribute | this_Bug304681Reference_1= ruleBug304681Reference )", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1581:5: this_Bug304681Attribute_0= ruleBug304681Attribute
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getBug304681FeatureAccess().getBug304681AttributeParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleBug304681Attribute_in_ruleBug304681Feature3298);
                    this_Bug304681Attribute_0=ruleBug304681Attribute();
                    _fsp--;

                     
                            current = this_Bug304681Attribute_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1591:5: this_Bug304681Reference_1= ruleBug304681Reference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getBug304681FeatureAccess().getBug304681ReferenceParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleBug304681Reference_in_ruleBug304681Feature3325);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1607:1: entryRuleBug304681Attribute returns [EObject current=null] : iv_ruleBug304681Attribute= ruleBug304681Attribute EOF ;
    public final EObject entryRuleBug304681Attribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug304681Attribute = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1608:2: (iv_ruleBug304681Attribute= ruleBug304681Attribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1609:2: iv_ruleBug304681Attribute= ruleBug304681Attribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBug304681AttributeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Attribute_in_entryRuleBug304681Attribute3360);
            iv_ruleBug304681Attribute=ruleBug304681Attribute();
            _fsp--;

             current =iv_ruleBug304681Attribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug304681Attribute3370); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1616:1: ruleBug304681Attribute returns [EObject current=null] : ( 'attr' ( (lv_name_1_0= RULE_ID ) ) ';' ) ;
    public final EObject ruleBug304681Attribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1621:6: ( ( 'attr' ( (lv_name_1_0= RULE_ID ) ) ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1622:1: ( 'attr' ( (lv_name_1_0= RULE_ID ) ) ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1622:1: ( 'attr' ( (lv_name_1_0= RULE_ID ) ) ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1622:3: 'attr' ( (lv_name_1_0= RULE_ID ) ) ';'
            {
            match(input,31,FollowSets000.FOLLOW_31_in_ruleBug304681Attribute3405); 

                    createLeafNode(grammarAccess.getBug304681AttributeAccess().getAttrKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1626:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1627:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1627:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1628:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBug304681Attribute3422); 

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

            match(input,27,FollowSets000.FOLLOW_27_in_ruleBug304681Attribute3437); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1662:1: entryRuleBug304681Reference returns [EObject current=null] : iv_ruleBug304681Reference= ruleBug304681Reference EOF ;
    public final EObject entryRuleBug304681Reference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug304681Reference = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1663:2: (iv_ruleBug304681Reference= ruleBug304681Reference EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1664:2: iv_ruleBug304681Reference= ruleBug304681Reference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBug304681ReferenceRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Reference_in_entryRuleBug304681Reference3473);
            iv_ruleBug304681Reference=ruleBug304681Reference();
            _fsp--;

             current =iv_ruleBug304681Reference; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug304681Reference3483); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1671:1: ruleBug304681Reference returns [EObject current=null] : ( 'ref' ( (lv_name_1_0= RULE_ID ) ) ';' ) ;
    public final EObject ruleBug304681Reference() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1676:6: ( ( 'ref' ( (lv_name_1_0= RULE_ID ) ) ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1677:1: ( 'ref' ( (lv_name_1_0= RULE_ID ) ) ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1677:1: ( 'ref' ( (lv_name_1_0= RULE_ID ) ) ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1677:3: 'ref' ( (lv_name_1_0= RULE_ID ) ) ';'
            {
            match(input,32,FollowSets000.FOLLOW_32_in_ruleBug304681Reference3518); 

                    createLeafNode(grammarAccess.getBug304681ReferenceAccess().getRefKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1681:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1682:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1682:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1683:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBug304681Reference3535); 

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

            match(input,27,FollowSets000.FOLLOW_27_in_ruleBug304681Reference3550); 

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
        public static final BitSet FOLLOW_11_in_ruleModel121 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_ruleSimpleModel_in_ruleModel142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleModel160 = new BitSet(new long[]{0x00000000007F0000L});
        public static final BitSet FOLLOW_ruleMandatoryModel_in_ruleModel181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleModel199 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_ruleLoopedModel_in_ruleModel220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleModel238 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_ruleGroupLoopedModel_in_ruleModel259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleModel277 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_ruleBug304681Model_in_ruleModel298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleModel_in_entryRuleSimpleModel335 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleModel345 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleSimpleModel432 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_17_in_ruleSimpleModel461 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_18_in_ruleSimpleModel490 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_19_in_ruleSimpleModel574 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_20_in_ruleSimpleModel655 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_21_in_ruleSimpleModel737 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_22_in_ruleSimpleModel774 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_23_in_ruleSimpleModel837 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleModel854 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleSimpleModel869 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleSimpleModel879 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryModel_in_entryRuleMandatoryModel915 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMandatoryModel925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleMandatoryModel1012 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_17_in_ruleMandatoryModel1041 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_18_in_ruleMandatoryModel1070 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_19_in_ruleMandatoryModel1154 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_20_in_ruleMandatoryModel1235 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_21_in_ruleMandatoryModel1317 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_22_in_ruleMandatoryModel1354 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_23_in_ruleMandatoryModel1423 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMandatoryModel1440 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleMandatoryModel1455 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleMandatoryModel1465 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoopedModel_in_entryRuleLoopedModel1501 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoopedModel1511 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleLoopedModel1598 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_17_in_ruleLoopedModel1627 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_18_in_ruleLoopedModel1656 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_19_in_ruleLoopedModel1741 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_20_in_ruleLoopedModel1823 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_21_in_ruleLoopedModel1906 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_22_in_ruleLoopedModel1943 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_23_in_ruleLoopedModel2007 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoopedModel2024 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleLoopedModel2039 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleLoopedModel2049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroupLoopedModel_in_entryRuleGroupLoopedModel2085 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroupLoopedModel2095 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleGroupLoopedModel2182 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_17_in_ruleGroupLoopedModel2211 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_18_in_ruleGroupLoopedModel2240 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_19_in_ruleGroupLoopedModel2324 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_20_in_ruleGroupLoopedModel2405 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_21_in_ruleGroupLoopedModel2487 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_22_in_ruleGroupLoopedModel2524 = new BitSet(new long[]{0x0000000000FF0000L});
        public static final BitSet FOLLOW_23_in_ruleGroupLoopedModel2594 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupLoopedModel2611 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleGroupLoopedModel2626 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleGroupLoopedModel2636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Model_in_entryRuleBug304681Model2672 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug304681Model2682 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleBug304681Model2717 = new BitSet(new long[]{0x00000001F6000000L});
        public static final BitSet FOLLOW_26_in_ruleBug304681Model2770 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleBug304681Model2787 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleBug304681Model2802 = new BitSet(new long[]{0x00000001F6000000L});
        public static final BitSet FOLLOW_28_in_ruleBug304681Model2864 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleBug304681Model2881 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleBug304681Model2896 = new BitSet(new long[]{0x00000001F6000000L});
        public static final BitSet FOLLOW_29_in_ruleBug304681Model2958 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleBug304681Model2975 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleBug304681Model2990 = new BitSet(new long[]{0x00000001F6000000L});
        public static final BitSet FOLLOW_30_in_ruleBug304681Model3060 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleBug304681Model3083 = new BitSet(new long[]{0x00000001F6000000L});
        public static final BitSet FOLLOW_ruleBug304681Feature_in_ruleBug304681Model3155 = new BitSet(new long[]{0x00000001F6000000L});
        public static final BitSet FOLLOW_25_in_ruleBug304681Model3205 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Feature_in_entryRuleBug304681Feature3241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug304681Feature3251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Attribute_in_ruleBug304681Feature3298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Reference_in_ruleBug304681Feature3325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Attribute_in_entryRuleBug304681Attribute3360 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug304681Attribute3370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleBug304681Attribute3405 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBug304681Attribute3422 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleBug304681Attribute3437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Reference_in_entryRuleBug304681Reference3473 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug304681Reference3483 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleBug304681Reference3518 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBug304681Reference3535 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleBug304681Reference3550 = new BitSet(new long[]{0x0000000000000002L});
    }


}