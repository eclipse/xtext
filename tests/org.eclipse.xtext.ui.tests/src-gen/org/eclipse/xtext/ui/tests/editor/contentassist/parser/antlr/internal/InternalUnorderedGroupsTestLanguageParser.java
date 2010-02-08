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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'1'", "'2'", "'3'", "'4'", "'public'", "'private'", "'protected'", "'static'", "'synchronized'", "'abstract'", "'final'", "'class'", "'{'", "'}'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:81:1: ruleModel returns [EObject current=null] : ( ( '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | ( '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | ( '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | ( '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_first_1_0 = null;

        EObject lv_second_3_0 = null;

        EObject lv_thrird_5_0 = null;

        EObject lv_forth_7_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:86:6: ( ( ( '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | ( '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | ( '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | ( '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:87:1: ( ( '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | ( '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | ( '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | ( '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:87:1: ( ( '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | ( '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | ( '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | ( '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) )
            int alt1=4;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("87:1: ( ( '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | ( '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | ( '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | ( '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) )", 1, 0, input);

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:210:1: entryRuleSimpleModel returns [EObject current=null] : iv_ruleSimpleModel= ruleSimpleModel EOF ;
    public final EObject entryRuleSimpleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:211:2: (iv_ruleSimpleModel= ruleSimpleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:212:2: iv_ruleSimpleModel= ruleSimpleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleModel_in_entryRuleSimpleModel296);
            iv_ruleSimpleModel=ruleSimpleModel();
            _fsp--;

             current =iv_ruleSimpleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleModel306); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:219:1: ruleSimpleModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) ;
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
        	  boolean[] pred_0 = new boolean[4];
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:225:6: ( ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:226:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:226:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:226:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:226:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:228:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:228:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:229:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* )
            {
             
            	  pred_0 = new boolean[4];
            	
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:232:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:233:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:233:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )*
            loop4:
            do {
                int alt4=5;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=15 && LA4_0<=17)) && (!pred_0[0])) {
                    alt4=1;
                }
                else if ( (LA4_0==18) && (!pred_0[1])) {
                    alt4=2;
                }
                else if ( (LA4_0==19) && (!pred_0[2])) {
                    alt4=3;
                }
                else if ( ((LA4_0>=20 && LA4_0<=21)) && (!pred_0[3])) {
                    alt4=4;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:235:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:235:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:236:5: {...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    {
            	    if ( !(!pred_0[0]) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "!pred_0[0]");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:236:20: ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:237:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    {
            	     
            	    	 				  pred_0[0] = true;
            	    	 				  
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:241:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:242:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:242:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:243:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:243:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    int alt2=3;
            	    switch ( input.LA(1) ) {
            	    case 15:
            	        {
            	        alt2=1;
            	        }
            	        break;
            	    case 16:
            	        {
            	        alt2=2;
            	        }
            	        break;
            	    case 17:
            	        {
            	        alt2=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("243:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )", 2, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt2) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:244:3: lv_visibility_1_1= 'public'
            	            {
            	            lv_visibility_1_1=(Token)input.LT(1);
            	            match(input,15,FollowSets000.FOLLOW_15_in_ruleSimpleModel393); 

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
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:262:8: lv_visibility_1_2= 'private'
            	            {
            	            lv_visibility_1_2=(Token)input.LT(1);
            	            match(input,16,FollowSets000.FOLLOW_16_in_ruleSimpleModel422); 

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
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:280:8: lv_visibility_1_3= 'protected'
            	            {
            	            lv_visibility_1_3=(Token)input.LT(1);
            	            match(input,17,FollowSets000.FOLLOW_17_in_ruleSimpleModel451); 

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


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:305:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:305:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:306:5: {...}? => ( ( (lv_static_2_0= 'static' ) ) )
            	    {
            	    if ( !(!pred_0[1]) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "!pred_0[1]");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:306:20: ( ( (lv_static_2_0= 'static' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:307:6: ( (lv_static_2_0= 'static' ) )
            	    {
            	     
            	    	 				  pred_0[1] = true;
            	    	 				  
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:311:6: ( (lv_static_2_0= 'static' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:312:1: (lv_static_2_0= 'static' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:312:1: (lv_static_2_0= 'static' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:313:3: lv_static_2_0= 'static'
            	    {
            	    lv_static_2_0=(Token)input.LT(1);
            	    match(input,18,FollowSets000.FOLLOW_18_in_ruleSimpleModel528); 

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


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:336:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:336:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:337:5: {...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    {
            	    if ( !(!pred_0[2]) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "!pred_0[2]");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:337:20: ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:338:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    {
            	     
            	    	 				  pred_0[2] = true;
            	    	 				  
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:342:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:343:1: (lv_synchronized_3_0= 'synchronized' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:343:1: (lv_synchronized_3_0= 'synchronized' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:344:3: lv_synchronized_3_0= 'synchronized'
            	    {
            	    lv_synchronized_3_0=(Token)input.LT(1);
            	    match(input,19,FollowSets000.FOLLOW_19_in_ruleSimpleModel602); 

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


            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:367:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:367:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:368:5: {...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    {
            	    if ( !(!pred_0[3]) ) {
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "!pred_0[3]");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:368:20: ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:369:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    {
            	     
            	    	 				  pred_0[3] = true;
            	    	 				  
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:373:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0==20) ) {
            	        alt3=1;
            	    }
            	    else if ( (LA3_0==21) ) {
            	        alt3=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("373:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )", 3, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:373:7: ( (lv_abstract_4_0= 'abstract' ) )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:373:7: ( (lv_abstract_4_0= 'abstract' ) )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:374:1: (lv_abstract_4_0= 'abstract' )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:374:1: (lv_abstract_4_0= 'abstract' )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:375:3: lv_abstract_4_0= 'abstract'
            	            {
            	            lv_abstract_4_0=(Token)input.LT(1);
            	            match(input,20,FollowSets000.FOLLOW_20_in_ruleSimpleModel677); 

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
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:395:6: ( (lv_final_5_0= 'final' ) )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:395:6: ( (lv_final_5_0= 'final' ) )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:396:1: (lv_final_5_0= 'final' )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:396:1: (lv_final_5_0= 'final' )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:397:3: lv_final_5_0= 'final'
            	            {
            	            lv_final_5_0=(Token)input.LT(1);
            	            match(input,21,FollowSets000.FOLLOW_21_in_ruleSimpleModel714); 

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

             
            	  pred_0 = new boolean[4];
            	

            }

            match(input,22,FollowSets000.FOLLOW_22_in_ruleSimpleModel770); 

                    createLeafNode(grammarAccess.getSimpleModelAccess().getClassKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:431:1: ( (lv_name_7_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:432:1: (lv_name_7_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:432:1: (lv_name_7_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:433:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleModel787); 

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

            match(input,23,FollowSets000.FOLLOW_23_in_ruleSimpleModel802); 

                    createLeafNode(grammarAccess.getSimpleModelAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            match(input,24,FollowSets000.FOLLOW_24_in_ruleSimpleModel812); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:471:1: entryRuleMandatoryModel returns [EObject current=null] : iv_ruleMandatoryModel= ruleMandatoryModel EOF ;
    public final EObject entryRuleMandatoryModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMandatoryModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:472:2: (iv_ruleMandatoryModel= ruleMandatoryModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:473:2: iv_ruleMandatoryModel= ruleMandatoryModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMandatoryModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMandatoryModel_in_entryRuleMandatoryModel848);
            iv_ruleMandatoryModel=ruleMandatoryModel();
            _fsp--;

             current =iv_ruleMandatoryModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMandatoryModel858); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:480:1: ruleMandatoryModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) ;
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
        	  boolean[] pred_0 = new boolean[4];
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:486:6: ( ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:487:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:487:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:487:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:487:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:489:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:489:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:490:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?)
            {
             
            	  pred_0 = new boolean[4];
            	  int remaining_pred_0 = 3;
            	
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:494:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?)
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:495:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:495:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=5;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=15 && LA7_0<=17)) && (!pred_0[0])) {
                    alt7=1;
                }
                else if ( (LA7_0==18) && (!pred_0[1])) {
                    alt7=2;
                }
                else if ( (LA7_0==19) && (!pred_0[2])) {
                    alt7=3;
                }
                else if ( ((LA7_0>=20 && LA7_0<=21)) && (!pred_0[3])) {
                    alt7=4;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:497:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:497:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:498:5: {...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    {
            	    if ( !(!pred_0[0]) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "!pred_0[0]");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:498:20: ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:499:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    {
            	     
            	    	 				  pred_0[0] = true;
            	    	 				  remaining_pred_0--;
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:503:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:504:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:504:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:505:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:505:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    int alt5=3;
            	    switch ( input.LA(1) ) {
            	    case 15:
            	        {
            	        alt5=1;
            	        }
            	        break;
            	    case 16:
            	        {
            	        alt5=2;
            	        }
            	        break;
            	    case 17:
            	        {
            	        alt5=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("505:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )", 5, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt5) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:506:3: lv_visibility_1_1= 'public'
            	            {
            	            lv_visibility_1_1=(Token)input.LT(1);
            	            match(input,15,FollowSets000.FOLLOW_15_in_ruleMandatoryModel945); 

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
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:524:8: lv_visibility_1_2= 'private'
            	            {
            	            lv_visibility_1_2=(Token)input.LT(1);
            	            match(input,16,FollowSets000.FOLLOW_16_in_ruleMandatoryModel974); 

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
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:542:8: lv_visibility_1_3= 'protected'
            	            {
            	            lv_visibility_1_3=(Token)input.LT(1);
            	            match(input,17,FollowSets000.FOLLOW_17_in_ruleMandatoryModel1003); 

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


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:567:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:567:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:568:5: {...}? => ( ( (lv_static_2_0= 'static' ) ) )
            	    {
            	    if ( !(!pred_0[1]) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "!pred_0[1]");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:568:20: ( ( (lv_static_2_0= 'static' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:569:6: ( (lv_static_2_0= 'static' ) )
            	    {
            	     
            	    	 				  pred_0[1] = true;
            	    	 				  remaining_pred_0--;
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:573:6: ( (lv_static_2_0= 'static' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:574:1: (lv_static_2_0= 'static' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:574:1: (lv_static_2_0= 'static' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:575:3: lv_static_2_0= 'static'
            	    {
            	    lv_static_2_0=(Token)input.LT(1);
            	    match(input,18,FollowSets000.FOLLOW_18_in_ruleMandatoryModel1080); 

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


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:598:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:598:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:599:5: {...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    {
            	    if ( !(!pred_0[2]) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "!pred_0[2]");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:599:20: ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:600:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    {
            	     
            	    	 				  pred_0[2] = true;
            	    	 				  remaining_pred_0--;
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:604:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:605:1: (lv_synchronized_3_0= 'synchronized' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:605:1: (lv_synchronized_3_0= 'synchronized' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:606:3: lv_synchronized_3_0= 'synchronized'
            	    {
            	    lv_synchronized_3_0=(Token)input.LT(1);
            	    match(input,19,FollowSets000.FOLLOW_19_in_ruleMandatoryModel1154); 

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


            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:629:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:629:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:630:5: {...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    {
            	    if ( !(!pred_0[3]) ) {
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "!pred_0[3]");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:630:20: ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:631:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    {
            	     
            	    	 				  pred_0[3] = true;
            	    	 				  
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:635:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==20) ) {
            	        alt6=1;
            	    }
            	    else if ( (LA6_0==21) ) {
            	        alt6=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("635:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )", 6, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:635:7: ( (lv_abstract_4_0= 'abstract' ) )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:635:7: ( (lv_abstract_4_0= 'abstract' ) )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:636:1: (lv_abstract_4_0= 'abstract' )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:636:1: (lv_abstract_4_0= 'abstract' )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:637:3: lv_abstract_4_0= 'abstract'
            	            {
            	            lv_abstract_4_0=(Token)input.LT(1);
            	            match(input,20,FollowSets000.FOLLOW_20_in_ruleMandatoryModel1229); 

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
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:657:6: ( (lv_final_5_0= 'final' ) )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:657:6: ( (lv_final_5_0= 'final' ) )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:658:1: (lv_final_5_0= 'final' )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:658:1: (lv_final_5_0= 'final' )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:659:3: lv_final_5_0= 'final'
            	            {
            	            lv_final_5_0=(Token)input.LT(1);
            	            match(input,21,FollowSets000.FOLLOW_21_in_ruleMandatoryModel1266); 

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

            if ( !(remaining_pred_0==0) ) {
                throw new FailedPredicateException(input, "ruleMandatoryModel", "remaining_pred_0==0");
            }

            }


            }

             
            	  pred_0 = new boolean[4];
            	

            }

            match(input,22,FollowSets000.FOLLOW_22_in_ruleMandatoryModel1328); 

                    createLeafNode(grammarAccess.getMandatoryModelAccess().getClassKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:694:1: ( (lv_name_7_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:695:1: (lv_name_7_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:695:1: (lv_name_7_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:696:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMandatoryModel1345); 

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

            match(input,23,FollowSets000.FOLLOW_23_in_ruleMandatoryModel1360); 

                    createLeafNode(grammarAccess.getMandatoryModelAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            match(input,24,FollowSets000.FOLLOW_24_in_ruleMandatoryModel1370); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:734:1: entryRuleLoopedModel returns [EObject current=null] : iv_ruleLoopedModel= ruleLoopedModel EOF ;
    public final EObject entryRuleLoopedModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopedModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:735:2: (iv_ruleLoopedModel= ruleLoopedModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:736:2: iv_ruleLoopedModel= ruleLoopedModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLoopedModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLoopedModel_in_entryRuleLoopedModel1406);
            iv_ruleLoopedModel=ruleLoopedModel();
            _fsp--;

             current =iv_ruleLoopedModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoopedModel1416); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:743:1: ruleLoopedModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) ;
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
        	  boolean[] pred_0 = new boolean[4];
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:749:6: ( ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:750:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:750:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:750:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) ) 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:750:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:752:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:752:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:753:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* )
            {
             
            	  pred_0 = new boolean[4];
            	
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:756:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:757:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:757:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )*
            loop13:
            do {
                int alt13=5;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=15 && LA13_0<=17)) && (!pred_0[0])) {
                    alt13=1;
                }
                else if ( (LA13_0==18) && (!pred_0[1])) {
                    alt13=2;
                }
                else if ( (LA13_0==19) && (!pred_0[2])) {
                    alt13=3;
                }
                else if ( ((LA13_0>=20 && LA13_0<=21)) && (!pred_0[3])) {
                    alt13=4;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:759:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:759:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:760:5: {...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ )
            	    {
            	    if ( !(!pred_0[0]) ) {
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "!pred_0[0]");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:760:20: ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:761:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+
            	    {
            	     
            	    	 				  pred_0[0] = true;
            	    	 				  
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:765:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        switch ( input.LA(1) ) {
            	        case 15:
            	            {
            	            int LA9_2 = input.LA(2);

            	            if ( (!(!pred_0[0])) ) {
            	                alt9=1;
            	            }


            	            }
            	            break;
            	        case 16:
            	            {
            	            int LA9_3 = input.LA(2);

            	            if ( (!(!pred_0[0])) ) {
            	                alt9=1;
            	            }


            	            }
            	            break;
            	        case 17:
            	            {
            	            int LA9_4 = input.LA(2);

            	            if ( (!(!pred_0[0])) ) {
            	                alt9=1;
            	            }


            	            }
            	            break;

            	        }

            	        switch (alt9) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:766:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:766:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:767:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:767:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    	    int alt8=3;
            	    	    switch ( input.LA(1) ) {
            	    	    case 15:
            	    	        {
            	    	        alt8=1;
            	    	        }
            	    	        break;
            	    	    case 16:
            	    	        {
            	    	        alt8=2;
            	    	        }
            	    	        break;
            	    	    case 17:
            	    	        {
            	    	        alt8=3;
            	    	        }
            	    	        break;
            	    	    default:
            	    	        NoViableAltException nvae =
            	    	            new NoViableAltException("767:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )", 8, 0, input);

            	    	        throw nvae;
            	    	    }

            	    	    switch (alt8) {
            	    	        case 1 :
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:768:3: lv_visibility_1_1= 'public'
            	    	            {
            	    	            lv_visibility_1_1=(Token)input.LT(1);
            	    	            match(input,15,FollowSets000.FOLLOW_15_in_ruleLoopedModel1503); 

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
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:786:8: lv_visibility_1_2= 'private'
            	    	            {
            	    	            lv_visibility_1_2=(Token)input.LT(1);
            	    	            match(input,16,FollowSets000.FOLLOW_16_in_ruleLoopedModel1532); 

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
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:804:8: lv_visibility_1_3= 'protected'
            	    	            {
            	    	            lv_visibility_1_3=(Token)input.LT(1);
            	    	            match(input,17,FollowSets000.FOLLOW_17_in_ruleLoopedModel1561); 

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


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:829:4: ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:829:4: ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:830:5: {...}? => ( ( (lv_static_2_0= 'static' ) )+ )
            	    {
            	    if ( !(!pred_0[1]) ) {
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "!pred_0[1]");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:830:20: ( ( (lv_static_2_0= 'static' ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:831:6: ( (lv_static_2_0= 'static' ) )+
            	    {
            	     
            	    	 				  pred_0[1] = true;
            	    	 				  
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:835:6: ( (lv_static_2_0= 'static' ) )+
            	    int cnt10=0;
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==18) ) {
            	            int LA10_3 = input.LA(2);

            	            if ( (!(!pred_0[1])) ) {
            	                alt10=1;
            	            }


            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:836:1: (lv_static_2_0= 'static' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:836:1: (lv_static_2_0= 'static' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:837:3: lv_static_2_0= 'static'
            	    	    {
            	    	    lv_static_2_0=(Token)input.LT(1);
            	    	    match(input,18,FollowSets000.FOLLOW_18_in_ruleLoopedModel1639); 

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


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:860:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:860:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:861:5: {...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ )
            	    {
            	    if ( !(!pred_0[2]) ) {
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "!pred_0[2]");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:861:20: ( ( (lv_synchronized_3_0= 'synchronized' ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:862:6: ( (lv_synchronized_3_0= 'synchronized' ) )+
            	    {
            	     
            	    	 				  pred_0[2] = true;
            	    	 				  
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:866:6: ( (lv_synchronized_3_0= 'synchronized' ) )+
            	    int cnt11=0;
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( (LA11_0==19) ) {
            	            int LA11_4 = input.LA(2);

            	            if ( (!(!pred_0[2])) ) {
            	                alt11=1;
            	            }


            	        }


            	        switch (alt11) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:867:1: (lv_synchronized_3_0= 'synchronized' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:867:1: (lv_synchronized_3_0= 'synchronized' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:868:3: lv_synchronized_3_0= 'synchronized'
            	    	    {
            	    	    lv_synchronized_3_0=(Token)input.LT(1);
            	    	    match(input,19,FollowSets000.FOLLOW_19_in_ruleLoopedModel1714); 

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


            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:891:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:891:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:892:5: {...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ )
            	    {
            	    if ( !(!pred_0[3]) ) {
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "!pred_0[3]");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:892:20: ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:893:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+
            	    {
            	     
            	    	 				  pred_0[3] = true;
            	    	 				  
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:897:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+
            	    int cnt12=0;
            	    loop12:
            	    do {
            	        int alt12=3;
            	        int LA12_0 = input.LA(1);

            	        if ( (LA12_0==20) ) {
            	            int LA12_5 = input.LA(2);

            	            if ( (!(!pred_0[3])) ) {
            	                alt12=1;
            	            }


            	        }
            	        else if ( (LA12_0==21) ) {
            	            int LA12_6 = input.LA(2);

            	            if ( (!(!pred_0[3])) ) {
            	                alt12=2;
            	            }


            	        }


            	        switch (alt12) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:897:7: ( (lv_abstract_4_0= 'abstract' ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:897:7: ( (lv_abstract_4_0= 'abstract' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:898:1: (lv_abstract_4_0= 'abstract' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:898:1: (lv_abstract_4_0= 'abstract' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:899:3: lv_abstract_4_0= 'abstract'
            	    	    {
            	    	    lv_abstract_4_0=(Token)input.LT(1);
            	    	    match(input,20,FollowSets000.FOLLOW_20_in_ruleLoopedModel1790); 

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
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:919:6: ( (lv_final_5_0= 'final' ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:919:6: ( (lv_final_5_0= 'final' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:920:1: (lv_final_5_0= 'final' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:920:1: (lv_final_5_0= 'final' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:921:3: lv_final_5_0= 'final'
            	    	    {
            	    	    lv_final_5_0=(Token)input.LT(1);
            	    	    match(input,21,FollowSets000.FOLLOW_21_in_ruleLoopedModel1827); 

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

             
            	  pred_0 = new boolean[4];
            	

            }

            match(input,22,FollowSets000.FOLLOW_22_in_ruleLoopedModel1884); 

                    createLeafNode(grammarAccess.getLoopedModelAccess().getClassKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:955:1: ( (lv_name_7_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:956:1: (lv_name_7_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:956:1: (lv_name_7_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:957:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoopedModel1901); 

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

            match(input,23,FollowSets000.FOLLOW_23_in_ruleLoopedModel1916); 

                    createLeafNode(grammarAccess.getLoopedModelAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            match(input,24,FollowSets000.FOLLOW_24_in_ruleLoopedModel1926); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:995:1: entryRuleGroupLoopedModel returns [EObject current=null] : iv_ruleGroupLoopedModel= ruleGroupLoopedModel EOF ;
    public final EObject entryRuleGroupLoopedModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupLoopedModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:996:2: (iv_ruleGroupLoopedModel= ruleGroupLoopedModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:997:2: iv_ruleGroupLoopedModel= ruleGroupLoopedModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGroupLoopedModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleGroupLoopedModel_in_entryRuleGroupLoopedModel1962);
            iv_ruleGroupLoopedModel=ruleGroupLoopedModel();
            _fsp--;

             current =iv_ruleGroupLoopedModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroupLoopedModel1972); 

            }

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1004:1: ruleGroupLoopedModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )* 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) ;
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
        	  boolean[] pred_0 = new boolean[4];
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1010:6: ( ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )* 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1011:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )* 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1011:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )* 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1011:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )* 'class' ( (lv_name_7_0= RULE_ID ) ) '{' '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1011:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=15 && LA17_0<=17)) && (!pred_0[0])) {
                    alt17=1;
                }
                else if ( (LA17_0==18) && (!pred_0[1])) {
                    alt17=1;
                }
                else if ( (LA17_0==19) && (!pred_0[2])) {
                    alt17=1;
                }
                else if ( ((LA17_0>=20 && LA17_0<=21)) && (!pred_0[3])) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1013:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1013:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1014:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?)
            	    {
            	     
            	    	  pred_0 = new boolean[4];
            	    	  int remaining_pred_0 = 4;
            	    	
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1018:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?)
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1019:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1019:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+
            	    int cnt16=0;
            	    loop16:
            	    do {
            	        int alt16=5;
            	        int LA16_0 = input.LA(1);

            	        if ( (LA16_0==15) && (!pred_0[0])) {
            	            int LA16_2 = input.LA(2);

            	            if ( (!pred_0[0]) ) {
            	                alt16=1;
            	            }


            	        }
            	        else if ( (LA16_0==16) && (!pred_0[0])) {
            	            int LA16_3 = input.LA(2);

            	            if ( (!pred_0[0]) ) {
            	                alt16=1;
            	            }


            	        }
            	        else if ( (LA16_0==17) && (!pred_0[0])) {
            	            int LA16_4 = input.LA(2);

            	            if ( (!pred_0[0]) ) {
            	                alt16=1;
            	            }


            	        }
            	        else if ( (LA16_0==18) && (!pred_0[1])) {
            	            int LA16_5 = input.LA(2);

            	            if ( (!pred_0[1]) ) {
            	                alt16=2;
            	            }


            	        }
            	        else if ( (LA16_0==19) && (!pred_0[2])) {
            	            int LA16_6 = input.LA(2);

            	            if ( (!pred_0[2]) ) {
            	                alt16=3;
            	            }


            	        }
            	        else if ( (LA16_0==20) && (!pred_0[3])) {
            	            int LA16_7 = input.LA(2);

            	            if ( (!pred_0[3]) ) {
            	                alt16=4;
            	            }


            	        }
            	        else if ( (LA16_0==21) && (!pred_0[3])) {
            	            int LA16_8 = input.LA(2);

            	            if ( (!pred_0[3]) ) {
            	                alt16=4;
            	            }


            	        }


            	        switch (alt16) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1021:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1021:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1022:5: {...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    	    {
            	    	    if ( !(!pred_0[0]) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "!pred_0[0]");
            	    	    }
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1022:20: ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1023:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    	    {
            	    	     
            	    	    	 				  pred_0[0] = true;
            	    	    	 				  remaining_pred_0--;
            	    	    	 				
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1027:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1028:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1028:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1029:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1029:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    	    int alt14=3;
            	    	    switch ( input.LA(1) ) {
            	    	    case 15:
            	    	        {
            	    	        alt14=1;
            	    	        }
            	    	        break;
            	    	    case 16:
            	    	        {
            	    	        alt14=2;
            	    	        }
            	    	        break;
            	    	    case 17:
            	    	        {
            	    	        alt14=3;
            	    	        }
            	    	        break;
            	    	    default:
            	    	        NoViableAltException nvae =
            	    	            new NoViableAltException("1029:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )", 14, 0, input);

            	    	        throw nvae;
            	    	    }

            	    	    switch (alt14) {
            	    	        case 1 :
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1030:3: lv_visibility_1_1= 'public'
            	    	            {
            	    	            lv_visibility_1_1=(Token)input.LT(1);
            	    	            match(input,15,FollowSets000.FOLLOW_15_in_ruleGroupLoopedModel2059); 

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
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1048:8: lv_visibility_1_2= 'private'
            	    	            {
            	    	            lv_visibility_1_2=(Token)input.LT(1);
            	    	            match(input,16,FollowSets000.FOLLOW_16_in_ruleGroupLoopedModel2088); 

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
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1066:8: lv_visibility_1_3= 'protected'
            	    	            {
            	    	            lv_visibility_1_3=(Token)input.LT(1);
            	    	            match(input,17,FollowSets000.FOLLOW_17_in_ruleGroupLoopedModel2117); 

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


            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1091:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1091:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1092:5: {...}? => ( ( (lv_static_2_0= 'static' ) ) )
            	    	    {
            	    	    if ( !(!pred_0[1]) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "!pred_0[1]");
            	    	    }
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1092:20: ( ( (lv_static_2_0= 'static' ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1093:6: ( (lv_static_2_0= 'static' ) )
            	    	    {
            	    	     
            	    	    	 				  pred_0[1] = true;
            	    	    	 				  remaining_pred_0--;
            	    	    	 				
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1097:6: ( (lv_static_2_0= 'static' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1098:1: (lv_static_2_0= 'static' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1098:1: (lv_static_2_0= 'static' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1099:3: lv_static_2_0= 'static'
            	    	    {
            	    	    lv_static_2_0=(Token)input.LT(1);
            	    	    match(input,18,FollowSets000.FOLLOW_18_in_ruleGroupLoopedModel2194); 

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


            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 3 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1122:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1122:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1123:5: {...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    	    {
            	    	    if ( !(!pred_0[2]) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "!pred_0[2]");
            	    	    }
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1123:20: ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1124:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    	    {
            	    	     
            	    	    	 				  pred_0[2] = true;
            	    	    	 				  remaining_pred_0--;
            	    	    	 				
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1128:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1129:1: (lv_synchronized_3_0= 'synchronized' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1129:1: (lv_synchronized_3_0= 'synchronized' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1130:3: lv_synchronized_3_0= 'synchronized'
            	    	    {
            	    	    lv_synchronized_3_0=(Token)input.LT(1);
            	    	    match(input,19,FollowSets000.FOLLOW_19_in_ruleGroupLoopedModel2268); 

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


            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 4 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1153:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1153:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1154:5: {...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    	    {
            	    	    if ( !(!pred_0[3]) ) {
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "!pred_0[3]");
            	    	    }
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1154:20: ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1155:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    	    {
            	    	     
            	    	    	 				  pred_0[3] = true;
            	    	    	 				  remaining_pred_0--;
            	    	    	 				
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1159:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    	    int alt15=2;
            	    	    int LA15_0 = input.LA(1);

            	    	    if ( (LA15_0==20) ) {
            	    	        alt15=1;
            	    	    }
            	    	    else if ( (LA15_0==21) ) {
            	    	        alt15=2;
            	    	    }
            	    	    else {
            	    	        NoViableAltException nvae =
            	    	            new NoViableAltException("1159:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )", 15, 0, input);

            	    	        throw nvae;
            	    	    }
            	    	    switch (alt15) {
            	    	        case 1 :
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1159:7: ( (lv_abstract_4_0= 'abstract' ) )
            	    	            {
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1159:7: ( (lv_abstract_4_0= 'abstract' ) )
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1160:1: (lv_abstract_4_0= 'abstract' )
            	    	            {
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1160:1: (lv_abstract_4_0= 'abstract' )
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1161:3: lv_abstract_4_0= 'abstract'
            	    	            {
            	    	            lv_abstract_4_0=(Token)input.LT(1);
            	    	            match(input,20,FollowSets000.FOLLOW_20_in_ruleGroupLoopedModel2343); 

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
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1181:6: ( (lv_final_5_0= 'final' ) )
            	    	            {
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1181:6: ( (lv_final_5_0= 'final' ) )
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1182:1: (lv_final_5_0= 'final' )
            	    	            {
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1182:1: (lv_final_5_0= 'final' )
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1183:3: lv_final_5_0= 'final'
            	    	            {
            	    	            lv_final_5_0=(Token)input.LT(1);
            	    	            match(input,21,FollowSets000.FOLLOW_21_in_ruleGroupLoopedModel2380); 

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

            	    if ( !(remaining_pred_0==0) ) {
            	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "remaining_pred_0==0");
            	    }

            	    }


            	    }

            	     
            	    	  pred_0 = new boolean[4];
            	    	

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            match(input,22,FollowSets000.FOLLOW_22_in_ruleGroupLoopedModel2443); 

                    createLeafNode(grammarAccess.getGroupLoopedModelAccess().getClassKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1218:1: ( (lv_name_7_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1219:1: (lv_name_7_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1219:1: (lv_name_7_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1220:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupLoopedModel2460); 

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

            match(input,23,FollowSets000.FOLLOW_23_in_ruleGroupLoopedModel2475); 

                    createLeafNode(grammarAccess.getGroupLoopedModelAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            match(input,24,FollowSets000.FOLLOW_24_in_ruleGroupLoopedModel2485); 

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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel121 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_ruleSimpleModel_in_ruleModel142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleModel160 = new BitSet(new long[]{0x00000000003F8000L});
        public static final BitSet FOLLOW_ruleMandatoryModel_in_ruleModel181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleModel199 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_ruleLoopedModel_in_ruleModel220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleModel238 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_ruleGroupLoopedModel_in_ruleModel259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleModel_in_entryRuleSimpleModel296 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleModel306 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleSimpleModel393 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_16_in_ruleSimpleModel422 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_17_in_ruleSimpleModel451 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_18_in_ruleSimpleModel528 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_19_in_ruleSimpleModel602 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_20_in_ruleSimpleModel677 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_21_in_ruleSimpleModel714 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_22_in_ruleSimpleModel770 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleModel787 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleSimpleModel802 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleSimpleModel812 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryModel_in_entryRuleMandatoryModel848 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMandatoryModel858 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleMandatoryModel945 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_16_in_ruleMandatoryModel974 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_17_in_ruleMandatoryModel1003 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_18_in_ruleMandatoryModel1080 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_19_in_ruleMandatoryModel1154 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_20_in_ruleMandatoryModel1229 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_21_in_ruleMandatoryModel1266 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_22_in_ruleMandatoryModel1328 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMandatoryModel1345 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleMandatoryModel1360 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleMandatoryModel1370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoopedModel_in_entryRuleLoopedModel1406 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoopedModel1416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleLoopedModel1503 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_16_in_ruleLoopedModel1532 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_17_in_ruleLoopedModel1561 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_18_in_ruleLoopedModel1639 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_19_in_ruleLoopedModel1714 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_20_in_ruleLoopedModel1790 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_21_in_ruleLoopedModel1827 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_22_in_ruleLoopedModel1884 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoopedModel1901 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleLoopedModel1916 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleLoopedModel1926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroupLoopedModel_in_entryRuleGroupLoopedModel1962 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroupLoopedModel1972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleGroupLoopedModel2059 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_16_in_ruleGroupLoopedModel2088 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_17_in_ruleGroupLoopedModel2117 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_18_in_ruleGroupLoopedModel2194 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_19_in_ruleGroupLoopedModel2268 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_20_in_ruleGroupLoopedModel2343 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_21_in_ruleGroupLoopedModel2380 = new BitSet(new long[]{0x00000000007F8000L});
        public static final BitSet FOLLOW_22_in_ruleGroupLoopedModel2443 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupLoopedModel2460 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleGroupLoopedModel2475 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleGroupLoopedModel2485 = new BitSet(new long[]{0x0000000000000002L});
    }


}