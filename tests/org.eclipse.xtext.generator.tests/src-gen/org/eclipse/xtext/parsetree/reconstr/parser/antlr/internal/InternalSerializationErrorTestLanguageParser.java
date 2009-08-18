package org.eclipse.xtext.parsetree.reconstr.parser.antlr.internal; 

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
import org.eclipse.xtext.parsetree.reconstr.services.SerializationErrorTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalSerializationErrorTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'tworequired'", "'twooptions'", "'one'", "'two'", "'{'", "'}'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalSerializationErrorTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g"; }


     
     	private SerializationErrorTestLanguageGrammarAccess grammarAccess;
     	
        public InternalSerializationErrorTestLanguageParser(TokenStream input, IAstFactory factory, SerializationErrorTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:72:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel73);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel83); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( (lv_test_0= ruleTest ) | (lv_test_1= ruleParenthesis ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_test_0 = null;

        EObject lv_test_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:85:6: ( ( (lv_test_0= ruleTest ) | (lv_test_1= ruleParenthesis ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:86:1: ( (lv_test_0= ruleTest ) | (lv_test_1= ruleParenthesis ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:86:1: ( (lv_test_0= ruleTest ) | (lv_test_1= ruleParenthesis ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=13 && LA1_0<=14)||LA1_0==17) ) {
                alt1=1;
            }
            else if ( (LA1_0==11) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("86:1: ( (lv_test_0= ruleTest ) | (lv_test_1= ruleParenthesis ) )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:86:2: (lv_test_0= ruleTest )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:86:2: (lv_test_0= ruleTest )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:89:6: lv_test_0= ruleTest
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getTestTestParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTest_in_ruleModel142);
                    lv_test_0=ruleTest();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "test", lv_test_0, "Test", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:108:6: (lv_test_1= ruleParenthesis )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:108:6: (lv_test_1= ruleParenthesis )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:111:6: lv_test_1= ruleParenthesis
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getTestParenthesisParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleParenthesis_in_ruleModel186);
                    lv_test_1=ruleParenthesis();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "test", lv_test_1, "Parenthesis", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

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


    // $ANTLR start entryRuleParenthesis
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:136:1: entryRuleParenthesis returns [EObject current=null] : iv_ruleParenthesis= ruleParenthesis EOF ;
    public final EObject entryRuleParenthesis() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesis = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:136:53: (iv_ruleParenthesis= ruleParenthesis EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:137:2: iv_ruleParenthesis= ruleParenthesis EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesisRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesis_in_entryRuleParenthesis223);
            iv_ruleParenthesis=ruleParenthesis();
            _fsp--;

             current =iv_ruleParenthesis; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesis233); 

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
    // $ANTLR end entryRuleParenthesis


    // $ANTLR start ruleParenthesis
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:144:1: ruleParenthesis returns [EObject current=null] : ( '(' this_Test_1= ruleTest ')' ) ;
    public final EObject ruleParenthesis() throws RecognitionException {
        EObject current = null;

        EObject this_Test_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:149:6: ( ( '(' this_Test_1= ruleTest ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:150:1: ( '(' this_Test_1= ruleTest ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:150:1: ( '(' this_Test_1= ruleTest ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:150:2: '(' this_Test_1= ruleTest ')'
            {
            match(input,11,FOLLOW_11_in_ruleParenthesis267); 

                    createLeafNode(grammarAccess.getParenthesisAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParenthesisAccess().getTestParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleTest_in_ruleParenthesis289);
            this_Test_1=ruleTest();
            _fsp--;

             
                    current = this_Test_1; 
                    currentNode = currentNode.getParent();
                
            match(input,12,FOLLOW_12_in_ruleParenthesis297); 

                    createLeafNode(grammarAccess.getParenthesisAccess().getRightParenthesisKeyword_2(), null); 
                

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
    // $ANTLR end ruleParenthesis


    // $ANTLR start entryRuleTest
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:174:1: entryRuleTest returns [EObject current=null] : iv_ruleTest= ruleTest EOF ;
    public final EObject entryRuleTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTest = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:174:46: (iv_ruleTest= ruleTest EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:175:2: iv_ruleTest= ruleTest EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTestRule(), currentNode); 
            pushFollow(FOLLOW_ruleTest_in_entryRuleTest330);
            iv_ruleTest=ruleTest();
            _fsp--;

             current =iv_ruleTest; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTest340); 

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
    // $ANTLR end entryRuleTest


    // $ANTLR start ruleTest
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:182:1: ruleTest returns [EObject current=null] : (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions | this_Indent_2= ruleIndent ) ;
    public final EObject ruleTest() throws RecognitionException {
        EObject current = null;

        EObject this_TwoRequired_0 = null;

        EObject this_TwoOptions_1 = null;

        EObject this_Indent_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:187:6: ( (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions | this_Indent_2= ruleIndent ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:188:1: (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions | this_Indent_2= ruleIndent )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:188:1: (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions | this_Indent_2= ruleIndent )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt2=1;
                }
                break;
            case 14:
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
                    new NoViableAltException("188:1: (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions | this_Indent_2= ruleIndent )", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:189:5: this_TwoRequired_0= ruleTwoRequired
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTestAccess().getTwoRequiredParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTwoRequired_in_ruleTest387);
                    this_TwoRequired_0=ruleTwoRequired();
                    _fsp--;

                     
                            current = this_TwoRequired_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:199:5: this_TwoOptions_1= ruleTwoOptions
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTestAccess().getTwoOptionsParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTwoOptions_in_ruleTest414);
                    this_TwoOptions_1=ruleTwoOptions();
                    _fsp--;

                     
                            current = this_TwoOptions_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:209:5: this_Indent_2= ruleIndent
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTestAccess().getIndentParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIndent_in_ruleTest441);
                    this_Indent_2=ruleIndent();
                    _fsp--;

                     
                            current = this_Indent_2; 
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
    // $ANTLR end ruleTest


    // $ANTLR start entryRuleTwoRequired
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:224:1: entryRuleTwoRequired returns [EObject current=null] : iv_ruleTwoRequired= ruleTwoRequired EOF ;
    public final EObject entryRuleTwoRequired() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoRequired = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:224:53: (iv_ruleTwoRequired= ruleTwoRequired EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:225:2: iv_ruleTwoRequired= ruleTwoRequired EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTwoRequiredRule(), currentNode); 
            pushFollow(FOLLOW_ruleTwoRequired_in_entryRuleTwoRequired473);
            iv_ruleTwoRequired=ruleTwoRequired();
            _fsp--;

             current =iv_ruleTwoRequired; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTwoRequired483); 

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
    // $ANTLR end entryRuleTwoRequired


    // $ANTLR start ruleTwoRequired
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:232:1: ruleTwoRequired returns [EObject current=null] : ( 'tworequired' (lv_one_1= RULE_ID ) (lv_two_2= RULE_ID ) ) ;
    public final EObject ruleTwoRequired() throws RecognitionException {
        EObject current = null;

        Token lv_one_1=null;
        Token lv_two_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:237:6: ( ( 'tworequired' (lv_one_1= RULE_ID ) (lv_two_2= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:238:1: ( 'tworequired' (lv_one_1= RULE_ID ) (lv_two_2= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:238:1: ( 'tworequired' (lv_one_1= RULE_ID ) (lv_two_2= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:238:2: 'tworequired' (lv_one_1= RULE_ID ) (lv_two_2= RULE_ID )
            {
            match(input,13,FOLLOW_13_in_ruleTwoRequired517); 

                    createLeafNode(grammarAccess.getTwoRequiredAccess().getTworequiredKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:242:1: (lv_one_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:244:6: lv_one_1= RULE_ID
            {
            lv_one_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTwoRequired539); 

            		createLeafNode(grammarAccess.getTwoRequiredAccess().getOneIDTerminalRuleCall_1_0(), "one"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTwoRequiredRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "one", lv_one_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:262:2: (lv_two_2= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:264:6: lv_two_2= RULE_ID
            {
            lv_two_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTwoRequired569); 

            		createLeafNode(grammarAccess.getTwoRequiredAccess().getTwoIDTerminalRuleCall_2_0(), "two"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTwoRequiredRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "two", lv_two_2, "ID", lastConsumedNode);
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
    // $ANTLR end ruleTwoRequired


    // $ANTLR start entryRuleTwoOptions
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:289:1: entryRuleTwoOptions returns [EObject current=null] : iv_ruleTwoOptions= ruleTwoOptions EOF ;
    public final EObject entryRuleTwoOptions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoOptions = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:289:52: (iv_ruleTwoOptions= ruleTwoOptions EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:290:2: iv_ruleTwoOptions= ruleTwoOptions EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTwoOptionsRule(), currentNode); 
            pushFollow(FOLLOW_ruleTwoOptions_in_entryRuleTwoOptions610);
            iv_ruleTwoOptions=ruleTwoOptions();
            _fsp--;

             current =iv_ruleTwoOptions; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTwoOptions620); 

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
    // $ANTLR end entryRuleTwoOptions


    // $ANTLR start ruleTwoOptions
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:297:1: ruleTwoOptions returns [EObject current=null] : ( 'twooptions' ( ( 'one' (lv_one_2= RULE_ID ) ) | ( 'two' (lv_two_4= RULE_ID ) ) ) ) ;
    public final EObject ruleTwoOptions() throws RecognitionException {
        EObject current = null;

        Token lv_one_2=null;
        Token lv_two_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:302:6: ( ( 'twooptions' ( ( 'one' (lv_one_2= RULE_ID ) ) | ( 'two' (lv_two_4= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:303:1: ( 'twooptions' ( ( 'one' (lv_one_2= RULE_ID ) ) | ( 'two' (lv_two_4= RULE_ID ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:303:1: ( 'twooptions' ( ( 'one' (lv_one_2= RULE_ID ) ) | ( 'two' (lv_two_4= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:303:2: 'twooptions' ( ( 'one' (lv_one_2= RULE_ID ) ) | ( 'two' (lv_two_4= RULE_ID ) ) )
            {
            match(input,14,FOLLOW_14_in_ruleTwoOptions654); 

                    createLeafNode(grammarAccess.getTwoOptionsAccess().getTwooptionsKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:307:1: ( ( 'one' (lv_one_2= RULE_ID ) ) | ( 'two' (lv_two_4= RULE_ID ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            else if ( (LA3_0==16) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("307:1: ( ( 'one' (lv_one_2= RULE_ID ) ) | ( 'two' (lv_two_4= RULE_ID ) ) )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:307:2: ( 'one' (lv_one_2= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:307:2: ( 'one' (lv_one_2= RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:307:3: 'one' (lv_one_2= RULE_ID )
                    {
                    match(input,15,FOLLOW_15_in_ruleTwoOptions665); 

                            createLeafNode(grammarAccess.getTwoOptionsAccess().getOneKeyword_1_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:311:1: (lv_one_2= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:313:6: lv_one_2= RULE_ID
                    {
                    lv_one_2=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTwoOptions687); 

                    		createLeafNode(grammarAccess.getTwoOptionsAccess().getOneIDTerminalRuleCall_1_0_1_0(), "one"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTwoOptionsRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "one", lv_one_2, "ID", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:332:6: ( 'two' (lv_two_4= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:332:6: ( 'two' (lv_two_4= RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:332:7: 'two' (lv_two_4= RULE_ID )
                    {
                    match(input,16,FOLLOW_16_in_ruleTwoOptions712); 

                            createLeafNode(grammarAccess.getTwoOptionsAccess().getTwoKeyword_1_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:336:1: (lv_two_4= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:338:6: lv_two_4= RULE_ID
                    {
                    lv_two_4=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTwoOptions734); 

                    		createLeafNode(grammarAccess.getTwoOptionsAccess().getTwoIDTerminalRuleCall_1_1_1_0(), "two"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTwoOptionsRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "two", lv_two_4, "ID", lastConsumedNode);
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
    // $ANTLR end ruleTwoOptions


    // $ANTLR start entryRuleIndent
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:363:1: entryRuleIndent returns [EObject current=null] : iv_ruleIndent= ruleIndent EOF ;
    public final EObject entryRuleIndent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndent = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:363:48: (iv_ruleIndent= ruleIndent EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:364:2: iv_ruleIndent= ruleIndent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIndentRule(), currentNode); 
            pushFollow(FOLLOW_ruleIndent_in_entryRuleIndent777);
            iv_ruleIndent=ruleIndent();
            _fsp--;

             current =iv_ruleIndent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIndent787); 

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
    // $ANTLR end entryRuleIndent


    // $ANTLR start ruleIndent
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:371:1: ruleIndent returns [EObject current=null] : ( '{' (lv_req_1= ruleTwoRequired )? (lv_opt_2= ruleTwoOptions )? (lv_indent_3= ruleIndent )* '}' ) ;
    public final EObject ruleIndent() throws RecognitionException {
        EObject current = null;

        EObject lv_req_1 = null;

        EObject lv_opt_2 = null;

        EObject lv_indent_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:376:6: ( ( '{' (lv_req_1= ruleTwoRequired )? (lv_opt_2= ruleTwoOptions )? (lv_indent_3= ruleIndent )* '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:377:1: ( '{' (lv_req_1= ruleTwoRequired )? (lv_opt_2= ruleTwoOptions )? (lv_indent_3= ruleIndent )* '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:377:1: ( '{' (lv_req_1= ruleTwoRequired )? (lv_opt_2= ruleTwoOptions )? (lv_indent_3= ruleIndent )* '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:377:2: '{' (lv_req_1= ruleTwoRequired )? (lv_opt_2= ruleTwoOptions )? (lv_indent_3= ruleIndent )* '}'
            {
            match(input,17,FOLLOW_17_in_ruleIndent821); 

                    createLeafNode(grammarAccess.getIndentAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:381:1: (lv_req_1= ruleTwoRequired )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:384:6: lv_req_1= ruleTwoRequired
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIndentAccess().getReqTwoRequiredParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTwoRequired_in_ruleIndent855);
                    lv_req_1=ruleTwoRequired();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getIndentRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "req", lv_req_1, "TwoRequired", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:402:3: (lv_opt_2= ruleTwoOptions )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:405:6: lv_opt_2= ruleTwoOptions
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIndentAccess().getOptTwoOptionsParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTwoOptions_in_ruleIndent894);
                    lv_opt_2=ruleTwoOptions();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getIndentRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "opt", lv_opt_2, "TwoOptions", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:423:3: (lv_indent_3= ruleIndent )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:426:6: lv_indent_3= ruleIndent
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getIndentAccess().getIndentIndentParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleIndent_in_ruleIndent933);
            	    lv_indent_3=ruleIndent();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getIndentRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "indent", lv_indent_3, "Indent", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match(input,18,FOLLOW_18_in_ruleIndent947); 

                    createLeafNode(grammarAccess.getIndentAccess().getRightCurlyBracketKeyword_4(), null); 
                

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
    // $ANTLR end ruleIndent


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTest_in_ruleModel142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesis_in_ruleModel186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesis_in_entryRuleParenthesis223 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesis233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleParenthesis267 = new BitSet(new long[]{0x0000000000026000L});
    public static final BitSet FOLLOW_ruleTest_in_ruleParenthesis289 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleParenthesis297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTest_in_entryRuleTest330 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTest340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTwoRequired_in_ruleTest387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTwoOptions_in_ruleTest414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndent_in_ruleTest441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTwoRequired_in_entryRuleTwoRequired473 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTwoRequired483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleTwoRequired517 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTwoRequired539 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTwoRequired569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTwoOptions_in_entryRuleTwoOptions610 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTwoOptions620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleTwoOptions654 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_ruleTwoOptions665 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTwoOptions687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleTwoOptions712 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTwoOptions734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndent_in_entryRuleIndent777 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIndent787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleIndent821 = new BitSet(new long[]{0x0000000000066000L});
    public static final BitSet FOLLOW_ruleTwoRequired_in_ruleIndent855 = new BitSet(new long[]{0x0000000000064000L});
    public static final BitSet FOLLOW_ruleTwoOptions_in_ruleIndent894 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_ruleIndent_in_ruleIndent933 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleIndent947 = new BitSet(new long[]{0x0000000000000002L});

}