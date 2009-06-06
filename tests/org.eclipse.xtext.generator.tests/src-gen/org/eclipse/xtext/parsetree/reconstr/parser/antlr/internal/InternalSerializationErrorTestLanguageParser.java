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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'tworequired'", "'twooptions'", "'one'", "'two'"
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

            if ( ((LA1_0>=13 && LA1_0<=14)) ) {
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:182:1: ruleTest returns [EObject current=null] : (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions ) ;
    public final EObject ruleTest() throws RecognitionException {
        EObject current = null;

        EObject this_TwoRequired_0 = null;

        EObject this_TwoOptions_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:187:6: ( (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:188:1: (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:188:1: (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions )
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
                    new NoViableAltException("188:1: (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions )", 2, 0, input);

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:214:1: entryRuleTwoRequired returns [EObject current=null] : iv_ruleTwoRequired= ruleTwoRequired EOF ;
    public final EObject entryRuleTwoRequired() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoRequired = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:214:53: (iv_ruleTwoRequired= ruleTwoRequired EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:215:2: iv_ruleTwoRequired= ruleTwoRequired EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTwoRequiredRule(), currentNode); 
            pushFollow(FOLLOW_ruleTwoRequired_in_entryRuleTwoRequired446);
            iv_ruleTwoRequired=ruleTwoRequired();
            _fsp--;

             current =iv_ruleTwoRequired; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTwoRequired456); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:222:1: ruleTwoRequired returns [EObject current=null] : ( 'tworequired' (lv_one_1= RULE_ID ) (lv_two_2= RULE_ID ) ) ;
    public final EObject ruleTwoRequired() throws RecognitionException {
        EObject current = null;

        Token lv_one_1=null;
        Token lv_two_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:227:6: ( ( 'tworequired' (lv_one_1= RULE_ID ) (lv_two_2= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:228:1: ( 'tworequired' (lv_one_1= RULE_ID ) (lv_two_2= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:228:1: ( 'tworequired' (lv_one_1= RULE_ID ) (lv_two_2= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:228:2: 'tworequired' (lv_one_1= RULE_ID ) (lv_two_2= RULE_ID )
            {
            match(input,13,FOLLOW_13_in_ruleTwoRequired490); 

                    createLeafNode(grammarAccess.getTwoRequiredAccess().getTworequiredKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:232:1: (lv_one_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:234:6: lv_one_1= RULE_ID
            {
            lv_one_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTwoRequired512); 

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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:252:2: (lv_two_2= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:254:6: lv_two_2= RULE_ID
            {
            lv_two_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTwoRequired542); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:279:1: entryRuleTwoOptions returns [EObject current=null] : iv_ruleTwoOptions= ruleTwoOptions EOF ;
    public final EObject entryRuleTwoOptions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoOptions = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:279:52: (iv_ruleTwoOptions= ruleTwoOptions EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:280:2: iv_ruleTwoOptions= ruleTwoOptions EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTwoOptionsRule(), currentNode); 
            pushFollow(FOLLOW_ruleTwoOptions_in_entryRuleTwoOptions583);
            iv_ruleTwoOptions=ruleTwoOptions();
            _fsp--;

             current =iv_ruleTwoOptions; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTwoOptions593); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:287:1: ruleTwoOptions returns [EObject current=null] : ( 'twooptions' ( ( 'one' (lv_one_2= RULE_ID ) ) | ( 'two' (lv_two_4= RULE_ID ) ) ) ) ;
    public final EObject ruleTwoOptions() throws RecognitionException {
        EObject current = null;

        Token lv_one_2=null;
        Token lv_two_4=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:292:6: ( ( 'twooptions' ( ( 'one' (lv_one_2= RULE_ID ) ) | ( 'two' (lv_two_4= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:293:1: ( 'twooptions' ( ( 'one' (lv_one_2= RULE_ID ) ) | ( 'two' (lv_two_4= RULE_ID ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:293:1: ( 'twooptions' ( ( 'one' (lv_one_2= RULE_ID ) ) | ( 'two' (lv_two_4= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:293:2: 'twooptions' ( ( 'one' (lv_one_2= RULE_ID ) ) | ( 'two' (lv_two_4= RULE_ID ) ) )
            {
            match(input,14,FOLLOW_14_in_ruleTwoOptions627); 

                    createLeafNode(grammarAccess.getTwoOptionsAccess().getTwooptionsKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:297:1: ( ( 'one' (lv_one_2= RULE_ID ) ) | ( 'two' (lv_two_4= RULE_ID ) ) )
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
                    new NoViableAltException("297:1: ( ( 'one' (lv_one_2= RULE_ID ) ) | ( 'two' (lv_two_4= RULE_ID ) ) )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:297:2: ( 'one' (lv_one_2= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:297:2: ( 'one' (lv_one_2= RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:297:3: 'one' (lv_one_2= RULE_ID )
                    {
                    match(input,15,FOLLOW_15_in_ruleTwoOptions638); 

                            createLeafNode(grammarAccess.getTwoOptionsAccess().getOneKeyword_1_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:301:1: (lv_one_2= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:303:6: lv_one_2= RULE_ID
                    {
                    lv_one_2=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTwoOptions660); 

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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:322:6: ( 'two' (lv_two_4= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:322:6: ( 'two' (lv_two_4= RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:322:7: 'two' (lv_two_4= RULE_ID )
                    {
                    match(input,16,FOLLOW_16_in_ruleTwoOptions685); 

                            createLeafNode(grammarAccess.getTwoOptionsAccess().getTwoKeyword_1_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:326:1: (lv_two_4= RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:328:6: lv_two_4= RULE_ID
                    {
                    lv_two_4=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTwoOptions707); 

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


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTest_in_ruleModel142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesis_in_ruleModel186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesis_in_entryRuleParenthesis223 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesis233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleParenthesis267 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_ruleTest_in_ruleParenthesis289 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleParenthesis297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTest_in_entryRuleTest330 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTest340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTwoRequired_in_ruleTest387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTwoOptions_in_ruleTest414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTwoRequired_in_entryRuleTwoRequired446 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTwoRequired456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleTwoRequired490 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTwoRequired512 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTwoRequired542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTwoOptions_in_entryRuleTwoOptions583 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTwoOptions593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleTwoOptions627 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_ruleTwoOptions638 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTwoOptions660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleTwoOptions685 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTwoOptions707 = new BitSet(new long[]{0x0000000000000002L});

}