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
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalSerializationErrorTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g"; }



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
       	
       	@Override
       	protected SerializationErrorTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:77:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:78:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:79:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:86:1: ruleModel returns [EObject current=null] : ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_test_0_0 = null;

        EObject lv_test_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:91:6: ( ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:92:1: ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:92:1: ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) )
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
                    new NoViableAltException("92:1: ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:92:2: ( (lv_test_0_0= ruleTest ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:92:2: ( (lv_test_0_0= ruleTest ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:93:1: (lv_test_0_0= ruleTest )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:93:1: (lv_test_0_0= ruleTest )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:94:3: lv_test_0_0= ruleTest
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getTestTestParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTest_in_ruleModel131);
                    lv_test_0_0=ruleTest();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"test",
                    	        		lv_test_0_0, 
                    	        		"Test", 
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:117:6: ( (lv_test_1_0= ruleParenthesis ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:117:6: ( (lv_test_1_0= ruleParenthesis ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:118:1: (lv_test_1_0= ruleParenthesis )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:118:1: (lv_test_1_0= ruleParenthesis )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:119:3: lv_test_1_0= ruleParenthesis
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getTestParenthesisParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesis_in_ruleModel158);
                    lv_test_1_0=ruleParenthesis();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"test",
                    	        		lv_test_1_0, 
                    	        		"Parenthesis", 
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


    // $ANTLR start entryRuleParenthesis
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:149:1: entryRuleParenthesis returns [EObject current=null] : iv_ruleParenthesis= ruleParenthesis EOF ;
    public final EObject entryRuleParenthesis() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesis = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:150:2: (iv_ruleParenthesis= ruleParenthesis EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:151:2: iv_ruleParenthesis= ruleParenthesis EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesisRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesis_in_entryRuleParenthesis194);
            iv_ruleParenthesis=ruleParenthesis();
            _fsp--;

             current =iv_ruleParenthesis; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesis204); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:158:1: ruleParenthesis returns [EObject current=null] : ( '(' this_Test_1= ruleTest ')' ) ;
    public final EObject ruleParenthesis() throws RecognitionException {
        EObject current = null;

        EObject this_Test_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:163:6: ( ( '(' this_Test_1= ruleTest ')' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:164:1: ( '(' this_Test_1= ruleTest ')' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:164:1: ( '(' this_Test_1= ruleTest ')' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:164:3: '(' this_Test_1= ruleTest ')'
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleParenthesis239); 

                    createLeafNode(grammarAccess.getParenthesisAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParenthesisAccess().getTestParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleTest_in_ruleParenthesis261);
            this_Test_1=ruleTest();
            _fsp--;

             
                    current = this_Test_1; 
                    currentNode = currentNode.getParent();
                
            match(input,12,FollowSets000.FOLLOW_12_in_ruleParenthesis270); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:189:1: entryRuleTest returns [EObject current=null] : iv_ruleTest= ruleTest EOF ;
    public final EObject entryRuleTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTest = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:190:2: (iv_ruleTest= ruleTest EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:191:2: iv_ruleTest= ruleTest EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTestRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTest_in_entryRuleTest306);
            iv_ruleTest=ruleTest();
            _fsp--;

             current =iv_ruleTest; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTest316); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:198:1: ruleTest returns [EObject current=null] : (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions | this_Indent_2= ruleIndent ) ;
    public final EObject ruleTest() throws RecognitionException {
        EObject current = null;

        EObject this_TwoRequired_0 = null;

        EObject this_TwoOptions_1 = null;

        EObject this_Indent_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:203:6: ( (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions | this_Indent_2= ruleIndent ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:204:1: (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions | this_Indent_2= ruleIndent )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:204:1: (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions | this_Indent_2= ruleIndent )
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
                    new NoViableAltException("204:1: (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions | this_Indent_2= ruleIndent )", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:205:5: this_TwoRequired_0= ruleTwoRequired
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTestAccess().getTwoRequiredParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTwoRequired_in_ruleTest363);
                    this_TwoRequired_0=ruleTwoRequired();
                    _fsp--;

                     
                            current = this_TwoRequired_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:215:5: this_TwoOptions_1= ruleTwoOptions
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTestAccess().getTwoOptionsParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTwoOptions_in_ruleTest390);
                    this_TwoOptions_1=ruleTwoOptions();
                    _fsp--;

                     
                            current = this_TwoOptions_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:225:5: this_Indent_2= ruleIndent
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTestAccess().getIndentParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleIndent_in_ruleTest417);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:241:1: entryRuleTwoRequired returns [EObject current=null] : iv_ruleTwoRequired= ruleTwoRequired EOF ;
    public final EObject entryRuleTwoRequired() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoRequired = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:242:2: (iv_ruleTwoRequired= ruleTwoRequired EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:243:2: iv_ruleTwoRequired= ruleTwoRequired EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTwoRequiredRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTwoRequired_in_entryRuleTwoRequired452);
            iv_ruleTwoRequired=ruleTwoRequired();
            _fsp--;

             current =iv_ruleTwoRequired; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTwoRequired462); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:250:1: ruleTwoRequired returns [EObject current=null] : ( 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTwoRequired() throws RecognitionException {
        EObject current = null;

        Token lv_one_1_0=null;
        Token lv_two_2_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:255:6: ( ( 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:256:1: ( 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:256:1: ( 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:256:3: 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) )
            {
            match(input,13,FollowSets000.FOLLOW_13_in_ruleTwoRequired497); 

                    createLeafNode(grammarAccess.getTwoRequiredAccess().getTworequiredKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:260:1: ( (lv_one_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:261:1: (lv_one_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:261:1: (lv_one_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:262:3: lv_one_1_0= RULE_ID
            {
            lv_one_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoRequired514); 

            			createLeafNode(grammarAccess.getTwoRequiredAccess().getOneIDTerminalRuleCall_1_0(), "one"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTwoRequiredRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"one",
            	        		lv_one_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:284:2: ( (lv_two_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:285:1: (lv_two_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:285:1: (lv_two_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:286:3: lv_two_2_0= RULE_ID
            {
            lv_two_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoRequired536); 

            			createLeafNode(grammarAccess.getTwoRequiredAccess().getTwoIDTerminalRuleCall_2_0(), "two"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTwoRequiredRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"two",
            	        		lv_two_2_0, 
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
    // $ANTLR end ruleTwoRequired


    // $ANTLR start entryRuleTwoOptions
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:316:1: entryRuleTwoOptions returns [EObject current=null] : iv_ruleTwoOptions= ruleTwoOptions EOF ;
    public final EObject entryRuleTwoOptions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoOptions = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:317:2: (iv_ruleTwoOptions= ruleTwoOptions EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:318:2: iv_ruleTwoOptions= ruleTwoOptions EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTwoOptionsRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTwoOptions_in_entryRuleTwoOptions577);
            iv_ruleTwoOptions=ruleTwoOptions();
            _fsp--;

             current =iv_ruleTwoOptions; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTwoOptions587); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:325:1: ruleTwoOptions returns [EObject current=null] : ( 'twooptions' ( ( 'one' ( (lv_one_2_0= RULE_ID ) ) ) | ( 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) ) ;
    public final EObject ruleTwoOptions() throws RecognitionException {
        EObject current = null;

        Token lv_one_2_0=null;
        Token lv_two_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:330:6: ( ( 'twooptions' ( ( 'one' ( (lv_one_2_0= RULE_ID ) ) ) | ( 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:331:1: ( 'twooptions' ( ( 'one' ( (lv_one_2_0= RULE_ID ) ) ) | ( 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:331:1: ( 'twooptions' ( ( 'one' ( (lv_one_2_0= RULE_ID ) ) ) | ( 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:331:3: 'twooptions' ( ( 'one' ( (lv_one_2_0= RULE_ID ) ) ) | ( 'two' ( (lv_two_4_0= RULE_ID ) ) ) )
            {
            match(input,14,FollowSets000.FOLLOW_14_in_ruleTwoOptions622); 

                    createLeafNode(grammarAccess.getTwoOptionsAccess().getTwooptionsKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:335:1: ( ( 'one' ( (lv_one_2_0= RULE_ID ) ) ) | ( 'two' ( (lv_two_4_0= RULE_ID ) ) ) )
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
                    new NoViableAltException("335:1: ( ( 'one' ( (lv_one_2_0= RULE_ID ) ) ) | ( 'two' ( (lv_two_4_0= RULE_ID ) ) ) )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:335:2: ( 'one' ( (lv_one_2_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:335:2: ( 'one' ( (lv_one_2_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:335:4: 'one' ( (lv_one_2_0= RULE_ID ) )
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleTwoOptions634); 

                            createLeafNode(grammarAccess.getTwoOptionsAccess().getOneKeyword_1_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:339:1: ( (lv_one_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:340:1: (lv_one_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:340:1: (lv_one_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:341:3: lv_one_2_0= RULE_ID
                    {
                    lv_one_2_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoOptions651); 

                    			createLeafNode(grammarAccess.getTwoOptionsAccess().getOneIDTerminalRuleCall_1_0_1_0(), "one"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTwoOptionsRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"one",
                    	        		lv_one_2_0, 
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:364:6: ( 'two' ( (lv_two_4_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:364:6: ( 'two' ( (lv_two_4_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:364:8: 'two' ( (lv_two_4_0= RULE_ID ) )
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleTwoOptions674); 

                            createLeafNode(grammarAccess.getTwoOptionsAccess().getTwoKeyword_1_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:368:1: ( (lv_two_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:369:1: (lv_two_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:369:1: (lv_two_4_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:370:3: lv_two_4_0= RULE_ID
                    {
                    lv_two_4_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoOptions691); 

                    			createLeafNode(grammarAccess.getTwoOptionsAccess().getTwoIDTerminalRuleCall_1_1_1_0(), "two"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTwoOptionsRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"two",
                    	        		lv_two_4_0, 
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
    // $ANTLR end ruleTwoOptions


    // $ANTLR start entryRuleIndent
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:400:1: entryRuleIndent returns [EObject current=null] : iv_ruleIndent= ruleIndent EOF ;
    public final EObject entryRuleIndent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndent = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:401:2: (iv_ruleIndent= ruleIndent EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:402:2: iv_ruleIndent= ruleIndent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIndentRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleIndent_in_entryRuleIndent734);
            iv_ruleIndent=ruleIndent();
            _fsp--;

             current =iv_ruleIndent; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIndent744); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:409:1: ruleIndent returns [EObject current=null] : ( '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* '}' ) ;
    public final EObject ruleIndent() throws RecognitionException {
        EObject current = null;

        EObject lv_req_1_0 = null;

        EObject lv_opt_2_0 = null;

        EObject lv_indent_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:414:6: ( ( '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* '}' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:415:1: ( '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* '}' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:415:1: ( '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* '}' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:415:3: '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* '}'
            {
            match(input,17,FollowSets000.FOLLOW_17_in_ruleIndent779); 

                    createLeafNode(grammarAccess.getIndentAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:419:1: ( (lv_req_1_0= ruleTwoRequired ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:420:1: (lv_req_1_0= ruleTwoRequired )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:420:1: (lv_req_1_0= ruleTwoRequired )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:421:3: lv_req_1_0= ruleTwoRequired
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIndentAccess().getReqTwoRequiredParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTwoRequired_in_ruleIndent800);
                    lv_req_1_0=ruleTwoRequired();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getIndentRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"req",
                    	        		lv_req_1_0, 
                    	        		"TwoRequired", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:443:3: ( (lv_opt_2_0= ruleTwoOptions ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:444:1: (lv_opt_2_0= ruleTwoOptions )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:444:1: (lv_opt_2_0= ruleTwoOptions )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:445:3: lv_opt_2_0= ruleTwoOptions
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIndentAccess().getOptTwoOptionsParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTwoOptions_in_ruleIndent822);
                    lv_opt_2_0=ruleTwoOptions();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getIndentRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"opt",
                    	        		lv_opt_2_0, 
                    	        		"TwoOptions", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:467:3: ( (lv_indent_3_0= ruleIndent ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:468:1: (lv_indent_3_0= ruleIndent )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:468:1: (lv_indent_3_0= ruleIndent )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:469:3: lv_indent_3_0= ruleIndent
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getIndentAccess().getIndentIndentParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleIndent_in_ruleIndent844);
            	    lv_indent_3_0=ruleIndent();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getIndentRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"indent",
            	    	        		lv_indent_3_0, 
            	    	        		"Indent", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match(input,18,FollowSets000.FOLLOW_18_in_ruleIndent855); 

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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTest_in_ruleModel131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesis_in_ruleModel158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesis_in_entryRuleParenthesis194 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesis204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleParenthesis239 = new BitSet(new long[]{0x0000000000026000L});
        public static final BitSet FOLLOW_ruleTest_in_ruleParenthesis261 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleParenthesis270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTest_in_entryRuleTest306 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTest316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoRequired_in_ruleTest363 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoOptions_in_ruleTest390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIndent_in_ruleTest417 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoRequired_in_entryRuleTwoRequired452 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTwoRequired462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleTwoRequired497 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoRequired514 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoRequired536 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoOptions_in_entryRuleTwoOptions577 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTwoOptions587 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleTwoOptions622 = new BitSet(new long[]{0x0000000000018000L});
        public static final BitSet FOLLOW_15_in_ruleTwoOptions634 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoOptions651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleTwoOptions674 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoOptions691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIndent_in_entryRuleIndent734 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIndent744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleIndent779 = new BitSet(new long[]{0x0000000000066000L});
        public static final BitSet FOLLOW_ruleTwoRequired_in_ruleIndent800 = new BitSet(new long[]{0x0000000000064000L});
        public static final BitSet FOLLOW_ruleTwoOptions_in_ruleIndent822 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_ruleIndent_in_ruleIndent844 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_18_in_ruleIndent855 = new BitSet(new long[]{0x0000000000000002L});
    }


}