package org.eclipse.xtext.parsetree.formatter.parser.antlr.internal; 

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
import org.eclipse.xtext.parsetree.formatter.services.ElementMatcherTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalElementMatcherTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'kw1'", "'.'", "'#2'", "'sub'", "'ass1'", "'ass2'", "'#3'", "'sub2'", "'sub3'", "'#4'", "'{'", "'}'", "';'", "'#5'", "'gr'", "'#6'", "'+'", "'*'", "'('", "','", "')'", "'=>'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalElementMatcherTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g"; }



     	private ElementMatcherTestLanguageGrammarAccess grammarAccess;
     	
        public InternalElementMatcherTestLanguageParser(TokenStream input, IAstFactory factory, ElementMatcherTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected ElementMatcherTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:77:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:78:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:79:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:86:1: ruleModel returns [EObject current=null] : (this_Simple_0= ruleSimple | this_RuleCalls_1= ruleRuleCalls | this_OptionalCalls_2= ruleOptionalCalls | this_Recursion_3= ruleRecursion | this_Loop_4= ruleLoop | this_Expression_5= ruleExpression ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_Simple_0 = null;

        EObject this_RuleCalls_1 = null;

        EObject this_OptionalCalls_2 = null;

        EObject this_Recursion_3 = null;

        EObject this_Loop_4 = null;

        EObject this_Expression_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:91:6: ( (this_Simple_0= ruleSimple | this_RuleCalls_1= ruleRuleCalls | this_OptionalCalls_2= ruleOptionalCalls | this_Recursion_3= ruleRecursion | this_Loop_4= ruleLoop | this_Expression_5= ruleExpression ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:92:1: (this_Simple_0= ruleSimple | this_RuleCalls_1= ruleRuleCalls | this_OptionalCalls_2= ruleOptionalCalls | this_Recursion_3= ruleRecursion | this_Loop_4= ruleLoop | this_Expression_5= ruleExpression )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:92:1: (this_Simple_0= ruleSimple | this_RuleCalls_1= ruleRuleCalls | this_OptionalCalls_2= ruleOptionalCalls | this_Recursion_3= ruleRecursion | this_Loop_4= ruleLoop | this_Expression_5= ruleExpression )
            int alt1=6;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 14:
                {
                alt1=2;
                }
                break;
            case 18:
                {
                alt1=3;
                }
                break;
            case 21:
                {
                alt1=4;
                }
                break;
            case 25:
                {
                alt1=5;
                }
                break;
            case 27:
                {
                alt1=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("92:1: (this_Simple_0= ruleSimple | this_RuleCalls_1= ruleRuleCalls | this_OptionalCalls_2= ruleOptionalCalls | this_Recursion_3= ruleRecursion | this_Loop_4= ruleLoop | this_Expression_5= ruleExpression )", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:93:5: this_Simple_0= ruleSimple
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getSimpleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSimple_in_ruleModel132);
                    this_Simple_0=ruleSimple();
                    _fsp--;

                     
                            current = this_Simple_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:103:5: this_RuleCalls_1= ruleRuleCalls
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getRuleCallsParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCalls_in_ruleModel159);
                    this_RuleCalls_1=ruleRuleCalls();
                    _fsp--;

                     
                            current = this_RuleCalls_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:113:5: this_OptionalCalls_2= ruleOptionalCalls
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getOptionalCallsParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalCalls_in_ruleModel186);
                    this_OptionalCalls_2=ruleOptionalCalls();
                    _fsp--;

                     
                            current = this_OptionalCalls_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:123:5: this_Recursion_3= ruleRecursion
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getRecursionParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRecursion_in_ruleModel213);
                    this_Recursion_3=ruleRecursion();
                    _fsp--;

                     
                            current = this_Recursion_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:133:5: this_Loop_4= ruleLoop
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getLoopParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLoop_in_ruleModel240);
                    this_Loop_4=ruleLoop();
                    _fsp--;

                     
                            current = this_Loop_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:143:5: this_Expression_5= ruleExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getExpressionParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleModel267);
                    this_Expression_5=ruleExpression();
                    _fsp--;

                     
                            current = this_Expression_5; 
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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleSimple
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:159:1: entryRuleSimple returns [EObject current=null] : iv_ruleSimple= ruleSimple EOF ;
    public final EObject entryRuleSimple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimple = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:160:2: (iv_ruleSimple= ruleSimple EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:161:2: iv_ruleSimple= ruleSimple EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSimple_in_entryRuleSimple302);
            iv_ruleSimple=ruleSimple();
            _fsp--;

             current =iv_ruleSimple; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimple312); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSimple


    // $ANTLR start ruleSimple
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:168:1: ruleSimple returns [EObject current=null] : ( '#1' ( (lv_name_1_0= RULE_ID ) ) ( 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) ) ;
    public final EObject ruleSimple() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_optional_3_0=null;
        AntlrDatatypeRuleToken lv_datatype_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:173:6: ( ( '#1' ( (lv_name_1_0= RULE_ID ) ) ( 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:174:1: ( '#1' ( (lv_name_1_0= RULE_ID ) ) ( 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:174:1: ( '#1' ( (lv_name_1_0= RULE_ID ) ) ( 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:174:3: '#1' ( (lv_name_1_0= RULE_ID ) ) ( 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) )
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleSimple347); 

                    createLeafNode(grammarAccess.getSimpleAccess().getNumberSignDigitOneKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:178:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:179:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:179:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:180:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimple364); 

            			createLeafNode(grammarAccess.getSimpleAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSimpleRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:202:2: ( 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:202:4: 'kw1' ( (lv_optional_3_0= RULE_ID ) )
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleSimple380); 

                            createLeafNode(grammarAccess.getSimpleAccess().getKw1Keyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:206:1: ( (lv_optional_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:207:1: (lv_optional_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:207:1: (lv_optional_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:208:3: lv_optional_3_0= RULE_ID
                    {
                    lv_optional_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimple397); 

                    			createLeafNode(grammarAccess.getSimpleAccess().getOptionalIDTerminalRuleCall_2_1_0(), "optional"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSimpleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"optional",
                    	        		lv_optional_3_0, 
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:230:4: ( (lv_datatype_4_0= ruleFQN ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:231:1: (lv_datatype_4_0= ruleFQN )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:231:1: (lv_datatype_4_0= ruleFQN )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:232:3: lv_datatype_4_0= ruleFQN
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSimpleAccess().getDatatypeFQNParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleSimple425);
            lv_datatype_4_0=ruleFQN();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSimpleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"datatype",
            	        		lv_datatype_4_0, 
            	        		"FQN", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleSimple


    // $ANTLR start entryRuleFQN
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:262:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:263:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:264:2: iv_ruleFQN= ruleFQN EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFQNRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN462);
            iv_ruleFQN=ruleFQN();
            _fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN473); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleFQN


    // $ANTLR start ruleFQN
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:271:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:276:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:277:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:277:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:277:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN513); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:284:1: (kw= '.' this_ID_2= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:285:2: kw= '.' this_ID_2= RULE_ID
            {
            kw=(Token)input.LT(1);
            match(input,13,FollowSets000.FOLLOW_13_in_ruleFQN532); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getFQNAccess().getFullStopKeyword_1_0(), null); 
                
            this_ID_2=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN547); 

            		current.merge(this_ID_2);
                
             
                createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1(), null); 
                

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
    // $ANTLR end ruleFQN


    // $ANTLR start entryRuleRuleCalls
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:305:1: entryRuleRuleCalls returns [EObject current=null] : iv_ruleRuleCalls= ruleRuleCalls EOF ;
    public final EObject entryRuleRuleCalls() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCalls = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:306:2: (iv_ruleRuleCalls= ruleRuleCalls EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:307:2: iv_ruleRuleCalls= ruleRuleCalls EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallsRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCalls_in_entryRuleRuleCalls593);
            iv_ruleRuleCalls=ruleRuleCalls();
            _fsp--;

             current =iv_ruleRuleCalls; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCalls603); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleRuleCalls


    // $ANTLR start ruleRuleCalls
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:314:1: ruleRuleCalls returns [EObject current=null] : ( '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? ) ;
    public final EObject ruleRuleCalls() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject this_RuleCallsSub_1 = null;

        EObject lv_call1_3_0 = null;

        EObject lv_call2_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:319:6: ( ( '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:320:1: ( '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:320:1: ( '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:320:3: '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )?
            {
            match(input,14,FollowSets000.FOLLOW_14_in_ruleRuleCalls638); 

                    createLeafNode(grammarAccess.getRuleCallsAccess().getNumberSignDigitTwoKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getRuleCallsAccess().getRuleCallsSubParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsSub_in_ruleRuleCalls660);
            this_RuleCallsSub_1=ruleRuleCallsSub();
            _fsp--;

             
                    current = this_RuleCallsSub_1; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:333:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:334:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:334:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:335:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCalls676); 

            			createLeafNode(grammarAccess.getRuleCallsAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRuleCallsRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:357:2: ( (lv_call1_3_0= ruleRuleCallsAss1 ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:358:1: (lv_call1_3_0= ruleRuleCallsAss1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:358:1: (lv_call1_3_0= ruleRuleCallsAss1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:359:3: lv_call1_3_0= ruleRuleCallsAss1
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRuleCallsAccess().getCall1RuleCallsAss1ParserRuleCall_3_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss1_in_ruleRuleCalls702);
                    lv_call1_3_0=ruleRuleCallsAss1();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRuleCallsRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"call1",
                    	        		lv_call1_3_0, 
                    	        		"RuleCallsAss1", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:381:3: ( (lv_call2_4_0= ruleRuleCallsAss2 ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:382:1: (lv_call2_4_0= ruleRuleCallsAss2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:382:1: (lv_call2_4_0= ruleRuleCallsAss2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:383:3: lv_call2_4_0= ruleRuleCallsAss2
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRuleCallsAccess().getCall2RuleCallsAss2ParserRuleCall_4_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss2_in_ruleRuleCalls724);
                    lv_call2_4_0=ruleRuleCallsAss2();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRuleCallsRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"call2",
                    	        		lv_call2_4_0, 
                    	        		"RuleCallsAss2", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

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
    // $ANTLR end ruleRuleCalls


    // $ANTLR start entryRuleRuleCallsSub
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:413:1: entryRuleRuleCallsSub returns [EObject current=null] : iv_ruleRuleCallsSub= ruleRuleCallsSub EOF ;
    public final EObject entryRuleRuleCallsSub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallsSub = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:414:2: (iv_ruleRuleCallsSub= ruleRuleCallsSub EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:415:2: iv_ruleRuleCallsSub= ruleRuleCallsSub EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallsSubRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsSub_in_entryRuleRuleCallsSub761);
            iv_ruleRuleCallsSub=ruleRuleCallsSub();
            _fsp--;

             current =iv_ruleRuleCallsSub; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallsSub771); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleRuleCallsSub


    // $ANTLR start ruleRuleCallsSub
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:422:1: ruleRuleCallsSub returns [EObject current=null] : ( (lv_sub_0_0= 'sub' ) ) ;
    public final EObject ruleRuleCallsSub() throws RecognitionException {
        EObject current = null;

        Token lv_sub_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:427:6: ( ( (lv_sub_0_0= 'sub' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:428:1: ( (lv_sub_0_0= 'sub' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:428:1: ( (lv_sub_0_0= 'sub' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:429:1: (lv_sub_0_0= 'sub' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:429:1: (lv_sub_0_0= 'sub' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:430:3: lv_sub_0_0= 'sub'
            {
            lv_sub_0_0=(Token)input.LT(1);
            match(input,15,FollowSets000.FOLLOW_15_in_ruleRuleCallsSub813); 

                    createLeafNode(grammarAccess.getRuleCallsSubAccess().getSubSubKeyword_0(), "sub"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRuleCallsSubRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "sub", lv_sub_0_0, "sub", lastConsumedNode);
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
    // $ANTLR end ruleRuleCallsSub


    // $ANTLR start entryRuleRuleCallsAss1
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:457:1: entryRuleRuleCallsAss1 returns [EObject current=null] : iv_ruleRuleCallsAss1= ruleRuleCallsAss1 EOF ;
    public final EObject entryRuleRuleCallsAss1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallsAss1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:458:2: (iv_ruleRuleCallsAss1= ruleRuleCallsAss1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:459:2: iv_ruleRuleCallsAss1= ruleRuleCallsAss1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallsAss1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss1_in_entryRuleRuleCallsAss1861);
            iv_ruleRuleCallsAss1=ruleRuleCallsAss1();
            _fsp--;

             current =iv_ruleRuleCallsAss1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallsAss1871); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleRuleCallsAss1


    // $ANTLR start ruleRuleCallsAss1
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:466:1: ruleRuleCallsAss1 returns [EObject current=null] : ( 'ass1' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleRuleCallsAss1() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:471:6: ( ( 'ass1' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:472:1: ( 'ass1' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:472:1: ( 'ass1' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:472:3: 'ass1' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,16,FollowSets000.FOLLOW_16_in_ruleRuleCallsAss1906); 

                    createLeafNode(grammarAccess.getRuleCallsAss1Access().getAss1Keyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:476:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:477:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:477:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:478:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCallsAss1923); 

            			createLeafNode(grammarAccess.getRuleCallsAss1Access().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRuleCallsAss1Rule().getType().getClassifier());
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
    // $ANTLR end ruleRuleCallsAss1


    // $ANTLR start entryRuleRuleCallsAss2
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:508:1: entryRuleRuleCallsAss2 returns [EObject current=null] : iv_ruleRuleCallsAss2= ruleRuleCallsAss2 EOF ;
    public final EObject entryRuleRuleCallsAss2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallsAss2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:509:2: (iv_ruleRuleCallsAss2= ruleRuleCallsAss2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:510:2: iv_ruleRuleCallsAss2= ruleRuleCallsAss2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallsAss2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss2_in_entryRuleRuleCallsAss2964);
            iv_ruleRuleCallsAss2=ruleRuleCallsAss2();
            _fsp--;

             current =iv_ruleRuleCallsAss2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallsAss2974); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleRuleCallsAss2


    // $ANTLR start ruleRuleCallsAss2
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:517:1: ruleRuleCallsAss2 returns [EObject current=null] : ( 'ass2' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleRuleCallsAss2() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:522:6: ( ( 'ass2' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:523:1: ( 'ass2' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:523:1: ( 'ass2' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:523:3: 'ass2' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,17,FollowSets000.FOLLOW_17_in_ruleRuleCallsAss21009); 

                    createLeafNode(grammarAccess.getRuleCallsAss2Access().getAss2Keyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:527:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:528:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:528:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:529:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCallsAss21026); 

            			createLeafNode(grammarAccess.getRuleCallsAss2Access().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRuleCallsAss2Rule().getType().getClassifier());
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
    // $ANTLR end ruleRuleCallsAss2


    // $ANTLR start entryRuleOptionalCalls
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:559:1: entryRuleOptionalCalls returns [EObject current=null] : iv_ruleOptionalCalls= ruleOptionalCalls EOF ;
    public final EObject entryRuleOptionalCalls() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalCalls = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:560:2: (iv_ruleOptionalCalls= ruleOptionalCalls EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:561:2: iv_ruleOptionalCalls= ruleOptionalCalls EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOptionalCallsRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCalls_in_entryRuleOptionalCalls1067);
            iv_ruleOptionalCalls=ruleOptionalCalls();
            _fsp--;

             current =iv_ruleOptionalCalls; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCalls1077); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleOptionalCalls


    // $ANTLR start ruleOptionalCalls
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:568:1: ruleOptionalCalls returns [EObject current=null] : ( '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleOptionalCalls() throws RecognitionException {
        EObject current = null;

        Token lv_name_3_0=null;
        EObject lv_opt1_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:573:6: ( ( '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:574:1: ( '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:574:1: ( '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:574:3: '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) )
            {
            match(input,18,FollowSets000.FOLLOW_18_in_ruleOptionalCalls1112); 

                    createLeafNode(grammarAccess.getOptionalCallsAccess().getNumberSignDigitThreeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:578:1: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:579:5: 
            {
             
                    temp=factory.create(grammarAccess.getOptionalCallsAccess().getOptionalCallsAction_1().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getOptionalCallsAccess().getOptionalCallsAction_1(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:589:2: ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15||LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:590:1: (lv_opt1_2_0= ruleOptionalCallsSub1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:590:1: (lv_opt1_2_0= ruleOptionalCallsSub1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:591:3: lv_opt1_2_0= ruleOptionalCallsSub1
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOptionalCallsAccess().getOpt1OptionalCallsSub1ParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub1_in_ruleOptionalCalls1142);
                    lv_opt1_2_0=ruleOptionalCallsSub1();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getOptionalCallsRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"opt1",
                    	        		lv_opt1_2_0, 
                    	        		"OptionalCallsSub1", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:613:3: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:614:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:614:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:615:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalCalls1160); 

            			createLeafNode(grammarAccess.getOptionalCallsAccess().getNameIDTerminalRuleCall_3_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOptionalCallsRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_3_0, 
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
    // $ANTLR end ruleOptionalCalls


    // $ANTLR start entryRuleOptionalCallsSub1
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:645:1: entryRuleOptionalCallsSub1 returns [EObject current=null] : iv_ruleOptionalCallsSub1= ruleOptionalCallsSub1 EOF ;
    public final EObject entryRuleOptionalCallsSub1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalCallsSub1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:646:2: (iv_ruleOptionalCallsSub1= ruleOptionalCallsSub1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:647:2: iv_ruleOptionalCallsSub1= ruleOptionalCallsSub1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOptionalCallsSub1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub1_in_entryRuleOptionalCallsSub11201);
            iv_ruleOptionalCallsSub1=ruleOptionalCallsSub1();
            _fsp--;

             current =iv_ruleOptionalCallsSub1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCallsSub11211); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleOptionalCallsSub1


    // $ANTLR start ruleOptionalCallsSub1
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:654:1: ruleOptionalCallsSub1 returns [EObject current=null] : ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? ) ;
    public final EObject ruleOptionalCallsSub1() throws RecognitionException {
        EObject current = null;

        EObject lv_opt2_1_0 = null;

        EObject lv_opt3_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:659:6: ( ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:660:1: ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:660:1: ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:660:2: () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:660:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:661:5: 
            {
             
                    temp=factory.create(grammarAccess.getOptionalCallsSub1Access().getOptionalCallsSub1Action_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getOptionalCallsSub1Access().getOptionalCallsSub1Action_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:671:2: ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:672:1: (lv_opt2_1_0= ruleOptionalCallsSub2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:672:1: (lv_opt2_1_0= ruleOptionalCallsSub2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:673:3: lv_opt2_1_0= ruleOptionalCallsSub2
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOptionalCallsSub1Access().getOpt2OptionalCallsSub2ParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub2_in_ruleOptionalCallsSub11266);
                    lv_opt2_1_0=ruleOptionalCallsSub2();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getOptionalCallsSub1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"opt2",
                    	        		lv_opt2_1_0, 
                    	        		"OptionalCallsSub2", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,15,FollowSets000.FOLLOW_15_in_ruleOptionalCallsSub11277); 

                    createLeafNode(grammarAccess.getOptionalCallsSub1Access().getSubKeyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:699:1: ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:700:1: (lv_opt3_3_0= ruleOptionalCallsSub3 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:700:1: (lv_opt3_3_0= ruleOptionalCallsSub3 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:701:3: lv_opt3_3_0= ruleOptionalCallsSub3
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOptionalCallsSub1Access().getOpt3OptionalCallsSub3ParserRuleCall_3_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub3_in_ruleOptionalCallsSub11298);
                    lv_opt3_3_0=ruleOptionalCallsSub3();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getOptionalCallsSub1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"opt3",
                    	        		lv_opt3_3_0, 
                    	        		"OptionalCallsSub3", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

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
    // $ANTLR end ruleOptionalCallsSub1


    // $ANTLR start entryRuleOptionalCallsSub2
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:731:1: entryRuleOptionalCallsSub2 returns [EObject current=null] : iv_ruleOptionalCallsSub2= ruleOptionalCallsSub2 EOF ;
    public final EObject entryRuleOptionalCallsSub2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalCallsSub2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:732:2: (iv_ruleOptionalCallsSub2= ruleOptionalCallsSub2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:733:2: iv_ruleOptionalCallsSub2= ruleOptionalCallsSub2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOptionalCallsSub2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub2_in_entryRuleOptionalCallsSub21335);
            iv_ruleOptionalCallsSub2=ruleOptionalCallsSub2();
            _fsp--;

             current =iv_ruleOptionalCallsSub2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCallsSub21345); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleOptionalCallsSub2


    // $ANTLR start ruleOptionalCallsSub2
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:740:1: ruleOptionalCallsSub2 returns [EObject current=null] : ( 'sub2' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleOptionalCallsSub2() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:745:6: ( ( 'sub2' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:746:1: ( 'sub2' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:746:1: ( 'sub2' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:746:3: 'sub2' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,19,FollowSets000.FOLLOW_19_in_ruleOptionalCallsSub21380); 

                    createLeafNode(grammarAccess.getOptionalCallsSub2Access().getSub2Keyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:750:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:751:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:751:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:752:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalCallsSub21397); 

            			createLeafNode(grammarAccess.getOptionalCallsSub2Access().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOptionalCallsSub2Rule().getType().getClassifier());
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
    // $ANTLR end ruleOptionalCallsSub2


    // $ANTLR start entryRuleOptionalCallsSub3
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:782:1: entryRuleOptionalCallsSub3 returns [EObject current=null] : iv_ruleOptionalCallsSub3= ruleOptionalCallsSub3 EOF ;
    public final EObject entryRuleOptionalCallsSub3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalCallsSub3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:783:2: (iv_ruleOptionalCallsSub3= ruleOptionalCallsSub3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:784:2: iv_ruleOptionalCallsSub3= ruleOptionalCallsSub3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOptionalCallsSub3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub3_in_entryRuleOptionalCallsSub31438);
            iv_ruleOptionalCallsSub3=ruleOptionalCallsSub3();
            _fsp--;

             current =iv_ruleOptionalCallsSub3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCallsSub31448); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleOptionalCallsSub3


    // $ANTLR start ruleOptionalCallsSub3
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:791:1: ruleOptionalCallsSub3 returns [EObject current=null] : ( 'sub3' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleOptionalCallsSub3() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:796:6: ( ( 'sub3' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:797:1: ( 'sub3' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:797:1: ( 'sub3' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:797:3: 'sub3' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,20,FollowSets000.FOLLOW_20_in_ruleOptionalCallsSub31483); 

                    createLeafNode(grammarAccess.getOptionalCallsSub3Access().getSub3Keyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:801:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:802:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:802:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:803:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalCallsSub31500); 

            			createLeafNode(grammarAccess.getOptionalCallsSub3Access().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOptionalCallsSub3Rule().getType().getClassifier());
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
    // $ANTLR end ruleOptionalCallsSub3


    // $ANTLR start entryRuleRecursion
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:833:1: entryRuleRecursion returns [EObject current=null] : iv_ruleRecursion= ruleRecursion EOF ;
    public final EObject entryRuleRecursion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecursion = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:834:2: (iv_ruleRecursion= ruleRecursion EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:835:2: iv_ruleRecursion= ruleRecursion EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRecursionRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRecursion_in_entryRuleRecursion1541);
            iv_ruleRecursion=ruleRecursion();
            _fsp--;

             current =iv_ruleRecursion; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRecursion1551); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleRecursion


    // $ANTLR start ruleRecursion
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:842:1: ruleRecursion returns [EObject current=null] : ( '#4' this_RecursionSub_1= ruleRecursionSub ) ;
    public final EObject ruleRecursion() throws RecognitionException {
        EObject current = null;

        EObject this_RecursionSub_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:847:6: ( ( '#4' this_RecursionSub_1= ruleRecursionSub ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:848:1: ( '#4' this_RecursionSub_1= ruleRecursionSub )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:848:1: ( '#4' this_RecursionSub_1= ruleRecursionSub )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:848:3: '#4' this_RecursionSub_1= ruleRecursionSub
            {
            match(input,21,FollowSets000.FOLLOW_21_in_ruleRecursion1586); 

                    createLeafNode(grammarAccess.getRecursionAccess().getNumberSignDigitFourKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getRecursionAccess().getRecursionSubParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRecursionSub_in_ruleRecursion1608);
            this_RecursionSub_1=ruleRecursionSub();
            _fsp--;

             
                    current = this_RecursionSub_1; 
                    currentNode = currentNode.getParent();
                

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
    // $ANTLR end ruleRecursion


    // $ANTLR start entryRuleRecursionSub
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:869:1: entryRuleRecursionSub returns [EObject current=null] : iv_ruleRecursionSub= ruleRecursionSub EOF ;
    public final EObject entryRuleRecursionSub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecursionSub = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:870:2: (iv_ruleRecursionSub= ruleRecursionSub EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:871:2: iv_ruleRecursionSub= ruleRecursionSub EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRecursionSubRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRecursionSub_in_entryRuleRecursionSub1643);
            iv_ruleRecursionSub=ruleRecursionSub();
            _fsp--;

             current =iv_ruleRecursionSub; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRecursionSub1653); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleRecursionSub


    // $ANTLR start ruleRecursionSub
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:878:1: ruleRecursionSub returns [EObject current=null] : ( () '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* '}' ( (lv_semi_5_0= ';' ) )? ) ;
    public final EObject ruleRecursionSub() throws RecognitionException {
        EObject current = null;

        Token lv_vals_3_0=null;
        Token lv_semi_5_0=null;
        EObject lv_sub_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:883:6: ( ( () '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* '}' ( (lv_semi_5_0= ';' ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:884:1: ( () '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* '}' ( (lv_semi_5_0= ';' ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:884:1: ( () '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* '}' ( (lv_semi_5_0= ';' ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:884:2: () '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* '}' ( (lv_semi_5_0= ';' ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:884:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:885:5: 
            {
             
                    temp=factory.create(grammarAccess.getRecursionSubAccess().getRecursionSubAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getRecursionSubAccess().getRecursionSubAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,22,FollowSets000.FOLLOW_22_in_ruleRecursionSub1697); 

                    createLeafNode(grammarAccess.getRecursionSubAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:899:1: ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==22) ) {
                    alt8=1;
                }
                else if ( (LA8_0==RULE_ID) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:899:2: ( (lv_sub_2_0= ruleRecursionSub ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:899:2: ( (lv_sub_2_0= ruleRecursionSub ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:900:1: (lv_sub_2_0= ruleRecursionSub )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:900:1: (lv_sub_2_0= ruleRecursionSub )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:901:3: lv_sub_2_0= ruleRecursionSub
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRecursionSubAccess().getSubRecursionSubParserRuleCall_2_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRecursionSub_in_ruleRecursionSub1719);
            	    lv_sub_2_0=ruleRecursionSub();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRecursionSubRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"sub",
            	    	        		lv_sub_2_0, 
            	    	        		"RecursionSub", 
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:924:6: ( (lv_vals_3_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:924:6: ( (lv_vals_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:925:1: (lv_vals_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:925:1: (lv_vals_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:926:3: lv_vals_3_0= RULE_ID
            	    {
            	    lv_vals_3_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRecursionSub1742); 

            	    			createLeafNode(grammarAccess.getRecursionSubAccess().getValsIDTerminalRuleCall_2_1_0(), "vals"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRecursionSubRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"vals",
            	    	        		lv_vals_3_0, 
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

            match(input,23,FollowSets000.FOLLOW_23_in_ruleRecursionSub1759); 

                    createLeafNode(grammarAccess.getRecursionSubAccess().getRightCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:952:1: ( (lv_semi_5_0= ';' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:953:1: (lv_semi_5_0= ';' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:953:1: (lv_semi_5_0= ';' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:954:3: lv_semi_5_0= ';'
                    {
                    lv_semi_5_0=(Token)input.LT(1);
                    match(input,24,FollowSets000.FOLLOW_24_in_ruleRecursionSub1777); 

                            createLeafNode(grammarAccess.getRecursionSubAccess().getSemiSemicolonKeyword_4_0(), "semi"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRecursionSubRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "semi", true, ";", lastConsumedNode);
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
    // $ANTLR end ruleRecursionSub


    // $ANTLR start entryRuleLoop
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:981:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:982:2: (iv_ruleLoop= ruleLoop EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:983:2: iv_ruleLoop= ruleLoop EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLoopRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLoop_in_entryRuleLoop1827);
            iv_ruleLoop=ruleLoop();
            _fsp--;

             current =iv_ruleLoop; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoop1837); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLoop


    // $ANTLR start ruleLoop
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:990:1: ruleLoop returns [EObject current=null] : ( '#5' ( (lv_names_1_0= RULE_ID ) )+ ( 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* ) ;
    public final EObject ruleLoop() throws RecognitionException {
        EObject current = null;

        Token lv_names_1_0=null;
        Token lv_gr_3_0=null;
        Token lv_ints_4_0=null;
        Token lv_strings_5_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:995:6: ( ( '#5' ( (lv_names_1_0= RULE_ID ) )+ ( 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:996:1: ( '#5' ( (lv_names_1_0= RULE_ID ) )+ ( 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:996:1: ( '#5' ( (lv_names_1_0= RULE_ID ) )+ ( 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:996:3: '#5' ( (lv_names_1_0= RULE_ID ) )+ ( 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )*
            {
            match(input,25,FollowSets000.FOLLOW_25_in_ruleLoop1872); 

                    createLeafNode(grammarAccess.getLoopAccess().getNumberSignDigitFiveKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1000:1: ( (lv_names_1_0= RULE_ID ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1001:1: (lv_names_1_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1001:1: (lv_names_1_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1002:3: lv_names_1_0= RULE_ID
            	    {
            	    lv_names_1_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop1889); 

            	    			createLeafNode(grammarAccess.getLoopAccess().getNamesIDTerminalRuleCall_1_0(), "names"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getLoopRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"names",
            	    	        		lv_names_1_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1024:3: ( 'gr' ( (lv_gr_3_0= RULE_ID ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==26) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1024:5: 'gr' ( (lv_gr_3_0= RULE_ID ) )
            	    {
            	    match(input,26,FollowSets000.FOLLOW_26_in_ruleLoop1906); 

            	            createLeafNode(grammarAccess.getLoopAccess().getGrKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1028:1: ( (lv_gr_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1029:1: (lv_gr_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1029:1: (lv_gr_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1030:3: lv_gr_3_0= RULE_ID
            	    {
            	    lv_gr_3_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop1923); 

            	    			createLeafNode(grammarAccess.getLoopAccess().getGrIDTerminalRuleCall_2_1_0(), "gr"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getLoopRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"gr",
            	    	        		lv_gr_3_0, 
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
            	    break loop11;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1052:4: ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )*
            loop12:
            do {
                int alt12=3;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_INT) ) {
                    alt12=1;
                }
                else if ( (LA12_0==RULE_STRING) ) {
                    alt12=2;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1052:5: ( (lv_ints_4_0= RULE_INT ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1052:5: ( (lv_ints_4_0= RULE_INT ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1053:1: (lv_ints_4_0= RULE_INT )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1053:1: (lv_ints_4_0= RULE_INT )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1054:3: lv_ints_4_0= RULE_INT
            	    {
            	    lv_ints_4_0=(Token)input.LT(1);
            	    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLoop1948); 

            	    			createLeafNode(grammarAccess.getLoopAccess().getIntsINTTerminalRuleCall_3_0_0(), "ints"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getLoopRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"ints",
            	    	        		lv_ints_4_0, 
            	    	        		"INT", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1077:6: ( (lv_strings_5_0= RULE_STRING ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1077:6: ( (lv_strings_5_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1078:1: (lv_strings_5_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1078:1: (lv_strings_5_0= RULE_STRING )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1079:3: lv_strings_5_0= RULE_STRING
            	    {
            	    lv_strings_5_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleLoop1976); 

            	    			createLeafNode(grammarAccess.getLoopAccess().getStringsSTRINGTerminalRuleCall_3_1_0(), "strings"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getLoopRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"strings",
            	    	        		lv_strings_5_0, 
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
            	    break loop12;
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
    // $ANTLR end ruleLoop


    // $ANTLR start entryRuleExpression
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1109:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1110:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1111:2: iv_ruleExpression= ruleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_entryRuleExpression2019);
            iv_ruleExpression=ruleExpression();
            _fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression2029); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleExpression


    // $ANTLR start ruleExpression
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1118:1: ruleExpression returns [EObject current=null] : ( '#6' this_Add_1= ruleAdd ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Add_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1123:6: ( ( '#6' this_Add_1= ruleAdd ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1124:1: ( '#6' this_Add_1= ruleAdd )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1124:1: ( '#6' this_Add_1= ruleAdd )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1124:3: '#6' this_Add_1= ruleAdd
            {
            match(input,27,FollowSets000.FOLLOW_27_in_ruleExpression2064); 

                    createLeafNode(grammarAccess.getExpressionAccess().getNumberSignDigitSixKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getAddParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAdd_in_ruleExpression2086);
            this_Add_1=ruleAdd();
            _fsp--;

             
                    current = this_Add_1; 
                    currentNode = currentNode.getParent();
                

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
    // $ANTLR end ruleExpression


    // $ANTLR start entryRuleAdd
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1145:1: entryRuleAdd returns [EObject current=null] : iv_ruleAdd= ruleAdd EOF ;
    public final EObject entryRuleAdd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdd = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1146:2: (iv_ruleAdd= ruleAdd EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1147:2: iv_ruleAdd= ruleAdd EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAddRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAdd_in_entryRuleAdd2121);
            iv_ruleAdd=ruleAdd();
            _fsp--;

             current =iv_ruleAdd; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAdd2131); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAdd


    // $ANTLR start ruleAdd
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1154:1: ruleAdd returns [EObject current=null] : (this_Mult_0= ruleMult ( () '+' ( (lv_right_3_0= ruleMult ) ) )* ) ;
    public final EObject ruleAdd() throws RecognitionException {
        EObject current = null;

        EObject this_Mult_0 = null;

        EObject lv_right_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1159:6: ( (this_Mult_0= ruleMult ( () '+' ( (lv_right_3_0= ruleMult ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1160:1: (this_Mult_0= ruleMult ( () '+' ( (lv_right_3_0= ruleMult ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1160:1: (this_Mult_0= ruleMult ( () '+' ( (lv_right_3_0= ruleMult ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1161:5: this_Mult_0= ruleMult ( () '+' ( (lv_right_3_0= ruleMult ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAddAccess().getMultParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleMult_in_ruleAdd2178);
            this_Mult_0=ruleMult();
            _fsp--;

             
                    current = this_Mult_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1169:1: ( () '+' ( (lv_right_3_0= ruleMult ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==28) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1169:2: () '+' ( (lv_right_3_0= ruleMult ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1169:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1170:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.getAddAccess().getAddLeftAction_1_0().getType().getClassifier());
            	            try {
            	            	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.getAddAccess().getAddLeftAction_1_0(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    match(input,28,FollowSets000.FOLLOW_28_in_ruleAdd2197); 

            	            createLeafNode(grammarAccess.getAddAccess().getPlusSignKeyword_1_1(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1189:1: ( (lv_right_3_0= ruleMult ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1190:1: (lv_right_3_0= ruleMult )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1190:1: (lv_right_3_0= ruleMult )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1191:3: lv_right_3_0= ruleMult
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAddAccess().getRightMultParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleMult_in_ruleAdd2218);
            	    lv_right_3_0=ruleMult();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getAddRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"right",
            	    	        		lv_right_3_0, 
            	    	        		"Mult", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

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
    // $ANTLR end ruleAdd


    // $ANTLR start entryRuleMult
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1221:1: entryRuleMult returns [EObject current=null] : iv_ruleMult= ruleMult EOF ;
    public final EObject entryRuleMult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMult = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1222:2: (iv_ruleMult= ruleMult EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1223:2: iv_ruleMult= ruleMult EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMult_in_entryRuleMult2256);
            iv_ruleMult=ruleMult();
            _fsp--;

             current =iv_ruleMult; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMult2266); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleMult


    // $ANTLR start ruleMult
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1230:1: ruleMult returns [EObject current=null] : (this_Prim_0= rulePrim ( () '*' ( (lv_right_3_0= rulePrim ) ) )* ) ;
    public final EObject ruleMult() throws RecognitionException {
        EObject current = null;

        EObject this_Prim_0 = null;

        EObject lv_right_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1235:6: ( (this_Prim_0= rulePrim ( () '*' ( (lv_right_3_0= rulePrim ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1236:1: (this_Prim_0= rulePrim ( () '*' ( (lv_right_3_0= rulePrim ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1236:1: (this_Prim_0= rulePrim ( () '*' ( (lv_right_3_0= rulePrim ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1237:5: this_Prim_0= rulePrim ( () '*' ( (lv_right_3_0= rulePrim ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getMultAccess().getPrimParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_rulePrim_in_ruleMult2313);
            this_Prim_0=rulePrim();
            _fsp--;

             
                    current = this_Prim_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1245:1: ( () '*' ( (lv_right_3_0= rulePrim ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==29) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1245:2: () '*' ( (lv_right_3_0= rulePrim ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1245:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1246:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.getMultAccess().getMultLeftAction_1_0().getType().getClassifier());
            	            try {
            	            	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.getMultAccess().getMultLeftAction_1_0(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    match(input,29,FollowSets000.FOLLOW_29_in_ruleMult2332); 

            	            createLeafNode(grammarAccess.getMultAccess().getAsteriskKeyword_1_1(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1265:1: ( (lv_right_3_0= rulePrim ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1266:1: (lv_right_3_0= rulePrim )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1266:1: (lv_right_3_0= rulePrim )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1267:3: lv_right_3_0= rulePrim
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMultAccess().getRightPrimParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_rulePrim_in_ruleMult2353);
            	    lv_right_3_0=rulePrim();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMultRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"right",
            	    	        		lv_right_3_0, 
            	    	        		"Prim", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // $ANTLR end ruleMult


    // $ANTLR start entryRulePrim
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1297:1: entryRulePrim returns [EObject current=null] : iv_rulePrim= rulePrim EOF ;
    public final EObject entryRulePrim() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrim = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1298:2: (iv_rulePrim= rulePrim EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1299:2: iv_rulePrim= rulePrim EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_rulePrim_in_entryRulePrim2391);
            iv_rulePrim=rulePrim();
            _fsp--;

             current =iv_rulePrim; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrim2401); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRulePrim


    // $ANTLR start rulePrim
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1306:1: rulePrim returns [EObject current=null] : ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) '(' ( (lv_param_5_0= ruleAdd ) ) ( ',' ( (lv_param_7_0= ruleAdd ) ) )* ')' ) | ( () '=>' ( (lv_target_11_0= rulePrim ) ) ) | ( '(' this_Add_13= ruleAdd ')' ) ) ;
    public final EObject rulePrim() throws RecognitionException {
        EObject current = null;

        Token lv_val_1_0=null;
        Token lv_func_3_0=null;
        EObject lv_param_5_0 = null;

        EObject lv_param_7_0 = null;

        EObject lv_target_11_0 = null;

        EObject this_Add_13 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1311:6: ( ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) '(' ( (lv_param_5_0= ruleAdd ) ) ( ',' ( (lv_param_7_0= ruleAdd ) ) )* ')' ) | ( () '=>' ( (lv_target_11_0= rulePrim ) ) ) | ( '(' this_Add_13= ruleAdd ')' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1312:1: ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) '(' ( (lv_param_5_0= ruleAdd ) ) ( ',' ( (lv_param_7_0= ruleAdd ) ) )* ')' ) | ( () '=>' ( (lv_target_11_0= rulePrim ) ) ) | ( '(' this_Add_13= ruleAdd ')' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1312:1: ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) '(' ( (lv_param_5_0= ruleAdd ) ) ( ',' ( (lv_param_7_0= ruleAdd ) ) )* ')' ) | ( () '=>' ( (lv_target_11_0= rulePrim ) ) ) | ( '(' this_Add_13= ruleAdd ')' ) )
            int alt16=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt16=1;
                }
                break;
            case RULE_ID:
                {
                alt16=2;
                }
                break;
            case 33:
                {
                alt16=3;
                }
                break;
            case 30:
                {
                alt16=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1312:1: ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) '(' ( (lv_param_5_0= ruleAdd ) ) ( ',' ( (lv_param_7_0= ruleAdd ) ) )* ')' ) | ( () '=>' ( (lv_target_11_0= rulePrim ) ) ) | ( '(' this_Add_13= ruleAdd ')' ) )", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1312:2: ( () ( (lv_val_1_0= RULE_INT ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1312:2: ( () ( (lv_val_1_0= RULE_INT ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1312:3: () ( (lv_val_1_0= RULE_INT ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1312:3: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1313:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getPrimAccess().getValueAction_0_0().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getPrimAccess().getValueAction_0_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1323:2: ( (lv_val_1_0= RULE_INT ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1324:1: (lv_val_1_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1324:1: (lv_val_1_0= RULE_INT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1325:3: lv_val_1_0= RULE_INT
                    {
                    lv_val_1_0=(Token)input.LT(1);
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rulePrim2453); 

                    			createLeafNode(grammarAccess.getPrimAccess().getValINTTerminalRuleCall_0_1_0(), "val"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPrimRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"val",
                    	        		lv_val_1_0, 
                    	        		"INT", 
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1348:6: ( () ( (lv_func_3_0= RULE_ID ) ) '(' ( (lv_param_5_0= ruleAdd ) ) ( ',' ( (lv_param_7_0= ruleAdd ) ) )* ')' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1348:6: ( () ( (lv_func_3_0= RULE_ID ) ) '(' ( (lv_param_5_0= ruleAdd ) ) ( ',' ( (lv_param_7_0= ruleAdd ) ) )* ')' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1348:7: () ( (lv_func_3_0= RULE_ID ) ) '(' ( (lv_param_5_0= ruleAdd ) ) ( ',' ( (lv_param_7_0= ruleAdd ) ) )* ')'
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1348:7: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1349:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getPrimAccess().getFunctionAction_1_0().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getPrimAccess().getFunctionAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1359:2: ( (lv_func_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1360:1: (lv_func_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1360:1: (lv_func_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1361:3: lv_func_3_0= RULE_ID
                    {
                    lv_func_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePrim2492); 

                    			createLeafNode(grammarAccess.getPrimAccess().getFuncIDTerminalRuleCall_1_1_0(), "func"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPrimRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"func",
                    	        		lv_func_3_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    match(input,30,FollowSets000.FOLLOW_30_in_rulePrim2507); 

                            createLeafNode(grammarAccess.getPrimAccess().getLeftParenthesisKeyword_1_2(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1387:1: ( (lv_param_5_0= ruleAdd ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1388:1: (lv_param_5_0= ruleAdd )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1388:1: (lv_param_5_0= ruleAdd )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1389:3: lv_param_5_0= ruleAdd
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPrimAccess().getParamAddParserRuleCall_1_3_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAdd_in_rulePrim2528);
                    lv_param_5_0=ruleAdd();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPrimRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"param",
                    	        		lv_param_5_0, 
                    	        		"Add", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1411:2: ( ',' ( (lv_param_7_0= ruleAdd ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==31) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1411:4: ',' ( (lv_param_7_0= ruleAdd ) )
                    	    {
                    	    match(input,31,FollowSets000.FOLLOW_31_in_rulePrim2539); 

                    	            createLeafNode(grammarAccess.getPrimAccess().getCommaKeyword_1_4_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1415:1: ( (lv_param_7_0= ruleAdd ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1416:1: (lv_param_7_0= ruleAdd )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1416:1: (lv_param_7_0= ruleAdd )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1417:3: lv_param_7_0= ruleAdd
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getPrimAccess().getParamAddParserRuleCall_1_4_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAdd_in_rulePrim2560);
                    	    lv_param_7_0=ruleAdd();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getPrimRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"param",
                    	    	        		lv_param_7_0, 
                    	    	        		"Add", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    match(input,32,FollowSets000.FOLLOW_32_in_rulePrim2572); 

                            createLeafNode(grammarAccess.getPrimAccess().getRightParenthesisKeyword_1_5(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1444:6: ( () '=>' ( (lv_target_11_0= rulePrim ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1444:6: ( () '=>' ( (lv_target_11_0= rulePrim ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1444:7: () '=>' ( (lv_target_11_0= rulePrim ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1444:7: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1445:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getPrimAccess().getPointerAction_2_0().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getPrimAccess().getPointerAction_2_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    match(input,33,FollowSets000.FOLLOW_33_in_rulePrim2599); 

                            createLeafNode(grammarAccess.getPrimAccess().getEqualsSignGreaterThanSignKeyword_2_1(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1459:1: ( (lv_target_11_0= rulePrim ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1460:1: (lv_target_11_0= rulePrim )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1460:1: (lv_target_11_0= rulePrim )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1461:3: lv_target_11_0= rulePrim
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPrimAccess().getTargetPrimParserRuleCall_2_2_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_rulePrim_in_rulePrim2620);
                    lv_target_11_0=rulePrim();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPrimRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"target",
                    	        		lv_target_11_0, 
                    	        		"Prim", 
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1484:6: ( '(' this_Add_13= ruleAdd ')' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1484:6: ( '(' this_Add_13= ruleAdd ')' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1484:8: '(' this_Add_13= ruleAdd ')'
                    {
                    match(input,30,FollowSets000.FOLLOW_30_in_rulePrim2638); 

                            createLeafNode(grammarAccess.getPrimAccess().getLeftParenthesisKeyword_3_0(), null); 
                        
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimAccess().getAddParserRuleCall_3_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAdd_in_rulePrim2660);
                    this_Add_13=ruleAdd();
                    _fsp--;

                     
                            current = this_Add_13; 
                            currentNode = currentNode.getParent();
                        
                    match(input,32,FollowSets000.FOLLOW_32_in_rulePrim2669); 

                            createLeafNode(grammarAccess.getPrimAccess().getRightParenthesisKeyword_3_2(), null); 
                        

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
    // $ANTLR end rulePrim


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimple_in_ruleModel132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCalls_in_ruleModel159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCalls_in_ruleModel186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecursion_in_ruleModel213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop_in_ruleModel240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleModel267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimple_in_entryRuleSimple302 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimple312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleSimple347 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimple364 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleSimple380 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimple397 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleSimple425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN462 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN473 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN513 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleFQN532 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCalls_in_entryRuleRuleCalls593 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCalls603 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleRuleCalls638 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleRuleCallsSub_in_ruleRuleCalls660 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCalls676 = new BitSet(new long[]{0x0000000000030002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss1_in_ruleRuleCalls702 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss2_in_ruleRuleCalls724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallsSub_in_entryRuleRuleCallsSub761 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallsSub771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleRuleCallsSub813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss1_in_entryRuleRuleCallsAss1861 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallsAss1871 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleRuleCallsAss1906 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallsAss1923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss2_in_entryRuleRuleCallsAss2964 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallsAss2974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleRuleCallsAss21009 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallsAss21026 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCalls_in_entryRuleOptionalCalls1067 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCalls1077 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleOptionalCalls1112 = new BitSet(new long[]{0x0000000000088010L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub1_in_ruleOptionalCalls1142 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalCalls1160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub1_in_entryRuleOptionalCallsSub11201 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCallsSub11211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub2_in_ruleOptionalCallsSub11266 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleOptionalCallsSub11277 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub3_in_ruleOptionalCallsSub11298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub2_in_entryRuleOptionalCallsSub21335 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCallsSub21345 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleOptionalCallsSub21380 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalCallsSub21397 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub3_in_entryRuleOptionalCallsSub31438 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCallsSub31448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleOptionalCallsSub31483 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalCallsSub31500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecursion_in_entryRuleRecursion1541 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRecursion1551 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleRecursion1586 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_ruleRecursionSub_in_ruleRecursion1608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecursionSub_in_entryRuleRecursionSub1643 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRecursionSub1653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleRecursionSub1697 = new BitSet(new long[]{0x0000000000C00010L});
        public static final BitSet FOLLOW_ruleRecursionSub_in_ruleRecursionSub1719 = new BitSet(new long[]{0x0000000000C00010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRecursionSub1742 = new BitSet(new long[]{0x0000000000C00010L});
        public static final BitSet FOLLOW_23_in_ruleRecursionSub1759 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_24_in_ruleRecursionSub1777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop_in_entryRuleLoop1827 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoop1837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleLoop1872 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop1889 = new BitSet(new long[]{0x0000000004000072L});
        public static final BitSet FOLLOW_26_in_ruleLoop1906 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop1923 = new BitSet(new long[]{0x0000000004000062L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLoop1948 = new BitSet(new long[]{0x0000000000000062L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleLoop1976 = new BitSet(new long[]{0x0000000000000062L});
        public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression2019 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression2029 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleExpression2064 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleAdd_in_ruleExpression2086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAdd_in_entryRuleAdd2121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAdd2131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMult_in_ruleAdd2178 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_28_in_ruleAdd2197 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleMult_in_ruleAdd2218 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_ruleMult_in_entryRuleMult2256 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMult2266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrim_in_ruleMult2313 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleMult2332 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_rulePrim_in_ruleMult2353 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rulePrim_in_entryRulePrim2391 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrim2401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rulePrim2453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePrim2492 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_rulePrim2507 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleAdd_in_rulePrim2528 = new BitSet(new long[]{0x0000000180000000L});
        public static final BitSet FOLLOW_31_in_rulePrim2539 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleAdd_in_rulePrim2560 = new BitSet(new long[]{0x0000000180000000L});
        public static final BitSet FOLLOW_32_in_rulePrim2572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rulePrim2599 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_rulePrim_in_rulePrim2620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rulePrim2638 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleAdd_in_rulePrim2660 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_rulePrim2669 = new BitSet(new long[]{0x0000000000000002L});
    }


}