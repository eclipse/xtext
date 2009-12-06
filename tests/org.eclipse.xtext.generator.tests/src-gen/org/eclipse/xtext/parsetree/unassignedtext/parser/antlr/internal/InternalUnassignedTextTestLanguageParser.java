package org.eclipse.xtext.parsetree.unassignedtext.parser.antlr.internal; 

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
import org.eclipse.xtext.parsetree.unassignedtext.services.UnassignedTextTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalUnassignedTextTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_CASEINSENSITIVEKEYWORD", "RULE_INT", "RULE_PLURAL", "RULE_MULTI", "RULE_STRING", "RULE_ID", "RULE_MULTI2", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'contents:'", "'multi'", "'datatype'", "'str'", "'terminals'"
    };
    public static final int RULE_ML_COMMENT=11;
    public static final int RULE_ID=9;
    public static final int RULE_PLURAL=6;
    public static final int RULE_WS=13;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=8;
    public static final int RULE_MULTI=7;
    public static final int RULE_ANY_OTHER=14;
    public static final int RULE_MULTI2=10;
    public static final int RULE_CASEINSENSITIVEKEYWORD=4;
    public static final int RULE_SL_COMMENT=12;

        public InternalUnassignedTextTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g"; }



     	private UnassignedTextTestLanguageGrammarAccess grammarAccess;
     	
        public InternalUnassignedTextTestLanguageParser(TokenStream input, IAstFactory factory, UnassignedTextTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:72:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:80:1: ruleModel returns [EObject current=null] : (this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule | this_PluralRule_1= rulePluralRule | this_MultiRule_2= ruleMultiRule | this_DatatypeRule_3= ruleDatatypeRule | this_CommonTerminalsRule_4= ruleCommonTerminalsRule ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_CaseInsensitiveKeywordRule_0 = null;

        EObject this_PluralRule_1 = null;

        EObject this_MultiRule_2 = null;

        EObject this_DatatypeRule_3 = null;

        EObject this_CommonTerminalsRule_4 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:85:6: ( (this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule | this_PluralRule_1= rulePluralRule | this_MultiRule_2= ruleMultiRule | this_DatatypeRule_3= ruleDatatypeRule | this_CommonTerminalsRule_4= ruleCommonTerminalsRule ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:86:1: (this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule | this_PluralRule_1= rulePluralRule | this_MultiRule_2= ruleMultiRule | this_DatatypeRule_3= ruleDatatypeRule | this_CommonTerminalsRule_4= ruleCommonTerminalsRule )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:86:1: (this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule | this_PluralRule_1= rulePluralRule | this_MultiRule_2= ruleMultiRule | this_DatatypeRule_3= ruleDatatypeRule | this_CommonTerminalsRule_4= ruleCommonTerminalsRule )
            int alt1=5;
            switch ( input.LA(1) ) {
            case RULE_CASEINSENSITIVEKEYWORD:
                {
                alt1=1;
                }
                break;
            case 15:
                {
                alt1=2;
                }
                break;
            case 16:
                {
                alt1=3;
                }
                break;
            case 17:
                {
                alt1=4;
                }
                break;
            case 19:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("86:1: (this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule | this_PluralRule_1= rulePluralRule | this_MultiRule_2= ruleMultiRule | this_DatatypeRule_3= ruleDatatypeRule | this_CommonTerminalsRule_4= ruleCommonTerminalsRule )", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:87:5: this_CaseInsensitiveKeywordRule_0= ruleCaseInsensitiveKeywordRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getCaseInsensitiveKeywordRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCaseInsensitiveKeywordRule_in_ruleModel130);
                    this_CaseInsensitiveKeywordRule_0=ruleCaseInsensitiveKeywordRule();
                    _fsp--;

                     
                            current = this_CaseInsensitiveKeywordRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:97:5: this_PluralRule_1= rulePluralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getPluralRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePluralRule_in_ruleModel157);
                    this_PluralRule_1=rulePluralRule();
                    _fsp--;

                     
                            current = this_PluralRule_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:107:5: this_MultiRule_2= ruleMultiRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getMultiRuleParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleMultiRule_in_ruleModel184);
                    this_MultiRule_2=ruleMultiRule();
                    _fsp--;

                     
                            current = this_MultiRule_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:117:5: this_DatatypeRule_3= ruleDatatypeRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getDatatypeRuleParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDatatypeRule_in_ruleModel211);
                    this_DatatypeRule_3=ruleDatatypeRule();
                    _fsp--;

                     
                            current = this_DatatypeRule_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:127:5: this_CommonTerminalsRule_4= ruleCommonTerminalsRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getCommonTerminalsRuleParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCommonTerminalsRule_in_ruleModel238);
                    this_CommonTerminalsRule_4=ruleCommonTerminalsRule();
                    _fsp--;

                     
                            current = this_CommonTerminalsRule_4; 
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


    // $ANTLR start entryRuleCaseInsensitiveKeywordRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:142:1: entryRuleCaseInsensitiveKeywordRule returns [EObject current=null] : iv_ruleCaseInsensitiveKeywordRule= ruleCaseInsensitiveKeywordRule EOF ;
    public final EObject entryRuleCaseInsensitiveKeywordRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseInsensitiveKeywordRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:142:68: (iv_ruleCaseInsensitiveKeywordRule= ruleCaseInsensitiveKeywordRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:143:2: iv_ruleCaseInsensitiveKeywordRule= ruleCaseInsensitiveKeywordRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCaseInsensitiveKeywordRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleCaseInsensitiveKeywordRule_in_entryRuleCaseInsensitiveKeywordRule270);
            iv_ruleCaseInsensitiveKeywordRule=ruleCaseInsensitiveKeywordRule();
            _fsp--;

             current =iv_ruleCaseInsensitiveKeywordRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCaseInsensitiveKeywordRule280); 

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
    // $ANTLR end entryRuleCaseInsensitiveKeywordRule


    // $ANTLR start ruleCaseInsensitiveKeywordRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:150:1: ruleCaseInsensitiveKeywordRule returns [EObject current=null] : ( RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) ) ;
    public final EObject ruleCaseInsensitiveKeywordRule() throws RecognitionException {
        EObject current = null;

        Token lv_val_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:155:6: ( ( RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:156:1: ( RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:156:1: ( RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:156:2: RULE_CASEINSENSITIVEKEYWORD ( (lv_val_1_0= RULE_INT ) )
            {
            match(input,RULE_CASEINSENSITIVEKEYWORD,FOLLOW_RULE_CASEINSENSITIVEKEYWORD_in_ruleCaseInsensitiveKeywordRule314); 
             
                createLeafNode(grammarAccess.getCaseInsensitiveKeywordRuleAccess().getCaseInsensitiveKeywordTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:160:1: ( (lv_val_1_0= RULE_INT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:161:1: (lv_val_1_0= RULE_INT )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:161:1: (lv_val_1_0= RULE_INT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:162:3: lv_val_1_0= RULE_INT
            {
            lv_val_1_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleCaseInsensitiveKeywordRule330); 

            			createLeafNode(grammarAccess.getCaseInsensitiveKeywordRuleAccess().getValINTTerminalRuleCall_1_0(), "val"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCaseInsensitiveKeywordRuleRule().getType().getClassifier());
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
    // $ANTLR end ruleCaseInsensitiveKeywordRule


    // $ANTLR start entryRulePluralRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:191:1: entryRulePluralRule returns [EObject current=null] : iv_rulePluralRule= rulePluralRule EOF ;
    public final EObject entryRulePluralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePluralRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:191:52: (iv_rulePluralRule= rulePluralRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:192:2: iv_rulePluralRule= rulePluralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPluralRuleRule(), currentNode); 
            pushFollow(FOLLOW_rulePluralRule_in_entryRulePluralRule368);
            iv_rulePluralRule=rulePluralRule();
            _fsp--;

             current =iv_rulePluralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePluralRule378); 

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
    // $ANTLR end entryRulePluralRule


    // $ANTLR start rulePluralRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:199:1: rulePluralRule returns [EObject current=null] : ( 'contents:' ( (lv_count_1_0= RULE_INT ) ) RULE_PLURAL ) ;
    public final EObject rulePluralRule() throws RecognitionException {
        EObject current = null;

        Token lv_count_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:204:6: ( ( 'contents:' ( (lv_count_1_0= RULE_INT ) ) RULE_PLURAL ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:205:1: ( 'contents:' ( (lv_count_1_0= RULE_INT ) ) RULE_PLURAL )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:205:1: ( 'contents:' ( (lv_count_1_0= RULE_INT ) ) RULE_PLURAL )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:205:3: 'contents:' ( (lv_count_1_0= RULE_INT ) ) RULE_PLURAL
            {
            match(input,15,FOLLOW_15_in_rulePluralRule413); 

                    createLeafNode(grammarAccess.getPluralRuleAccess().getContentsKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:209:1: ( (lv_count_1_0= RULE_INT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:210:1: (lv_count_1_0= RULE_INT )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:210:1: (lv_count_1_0= RULE_INT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:211:3: lv_count_1_0= RULE_INT
            {
            lv_count_1_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rulePluralRule430); 

            			createLeafNode(grammarAccess.getPluralRuleAccess().getCountINTTerminalRuleCall_1_0(), "count"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getPluralRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"count",
            	        		lv_count_1_0, 
            	        		"INT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,RULE_PLURAL,FOLLOW_RULE_PLURAL_in_rulePluralRule444); 
             
                createLeafNode(grammarAccess.getPluralRuleAccess().getPluralTerminalRuleCall_2(), null); 
                

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
    // $ANTLR end rulePluralRule


    // $ANTLR start entryRuleMultiRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:244:1: entryRuleMultiRule returns [EObject current=null] : iv_ruleMultiRule= ruleMultiRule EOF ;
    public final EObject entryRuleMultiRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:244:51: (iv_ruleMultiRule= ruleMultiRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:245:2: iv_ruleMultiRule= ruleMultiRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiRule_in_entryRuleMultiRule476);
            iv_ruleMultiRule=ruleMultiRule();
            _fsp--;

             current =iv_ruleMultiRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiRule486); 

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
    // $ANTLR end entryRuleMultiRule


    // $ANTLR start ruleMultiRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:252:1: ruleMultiRule returns [EObject current=null] : ( 'multi' ( (lv_val_1_0= RULE_INT ) ) RULE_MULTI RULE_MULTI RULE_MULTI ) ;
    public final EObject ruleMultiRule() throws RecognitionException {
        EObject current = null;

        Token lv_val_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:257:6: ( ( 'multi' ( (lv_val_1_0= RULE_INT ) ) RULE_MULTI RULE_MULTI RULE_MULTI ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:258:1: ( 'multi' ( (lv_val_1_0= RULE_INT ) ) RULE_MULTI RULE_MULTI RULE_MULTI )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:258:1: ( 'multi' ( (lv_val_1_0= RULE_INT ) ) RULE_MULTI RULE_MULTI RULE_MULTI )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:258:3: 'multi' ( (lv_val_1_0= RULE_INT ) ) RULE_MULTI RULE_MULTI RULE_MULTI
            {
            match(input,16,FOLLOW_16_in_ruleMultiRule521); 

                    createLeafNode(grammarAccess.getMultiRuleAccess().getMultiKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:262:1: ( (lv_val_1_0= RULE_INT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:263:1: (lv_val_1_0= RULE_INT )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:263:1: (lv_val_1_0= RULE_INT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:264:3: lv_val_1_0= RULE_INT
            {
            lv_val_1_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleMultiRule538); 

            			createLeafNode(grammarAccess.getMultiRuleAccess().getValINTTerminalRuleCall_1_0(), "val"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMultiRuleRule().getType().getClassifier());
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

            match(input,RULE_MULTI,FOLLOW_RULE_MULTI_in_ruleMultiRule552); 
             
                createLeafNode(grammarAccess.getMultiRuleAccess().getMultiTerminalRuleCall_2(), null); 
                
            match(input,RULE_MULTI,FOLLOW_RULE_MULTI_in_ruleMultiRule560); 
             
                createLeafNode(grammarAccess.getMultiRuleAccess().getMultiTerminalRuleCall_3(), null); 
                
            match(input,RULE_MULTI,FOLLOW_RULE_MULTI_in_ruleMultiRule568); 
             
                createLeafNode(grammarAccess.getMultiRuleAccess().getMultiTerminalRuleCall_4(), null); 
                

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
    // $ANTLR end ruleMultiRule


    // $ANTLR start entryRuleDatatypeRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:305:1: entryRuleDatatypeRule returns [EObject current=null] : iv_ruleDatatypeRule= ruleDatatypeRule EOF ;
    public final EObject entryRuleDatatypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatypeRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:305:54: (iv_ruleDatatypeRule= ruleDatatypeRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:306:2: iv_ruleDatatypeRule= ruleDatatypeRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDatatypeRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleDatatypeRule_in_entryRuleDatatypeRule600);
            iv_ruleDatatypeRule=ruleDatatypeRule();
            _fsp--;

             current =iv_ruleDatatypeRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDatatypeRule610); 

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
    // $ANTLR end entryRuleDatatypeRule


    // $ANTLR start ruleDatatypeRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:313:1: ruleDatatypeRule returns [EObject current=null] : ( 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype ) ;
    public final EObject ruleDatatypeRule() throws RecognitionException {
        EObject current = null;

        Token lv_val_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:318:6: ( ( 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:319:1: ( 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:319:1: ( 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:319:3: 'datatype' ( (lv_val_1_0= RULE_INT ) ) ruleDatatype
            {
            match(input,17,FOLLOW_17_in_ruleDatatypeRule645); 

                    createLeafNode(grammarAccess.getDatatypeRuleAccess().getDatatypeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:323:1: ( (lv_val_1_0= RULE_INT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:324:1: (lv_val_1_0= RULE_INT )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:324:1: (lv_val_1_0= RULE_INT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:325:3: lv_val_1_0= RULE_INT
            {
            lv_val_1_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDatatypeRule662); 

            			createLeafNode(grammarAccess.getDatatypeRuleAccess().getValINTTerminalRuleCall_1_0(), "val"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDatatypeRuleRule().getType().getClassifier());
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

            pushFollow(FOLLOW_ruleDatatype_in_ruleDatatypeRule676);
            ruleDatatype();
            _fsp--;


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
    // $ANTLR end ruleDatatypeRule


    // $ANTLR start entryRuleDatatype
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:354:1: entryRuleDatatype returns [String current=null] : iv_ruleDatatype= ruleDatatype EOF ;
    public final String entryRuleDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatype = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:354:49: (iv_ruleDatatype= ruleDatatype EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:355:2: iv_ruleDatatype= ruleDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDatatypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleDatatype_in_entryRuleDatatype702);
            iv_ruleDatatype=ruleDatatype();
            _fsp--;

             current =iv_ruleDatatype.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDatatype713); 

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
    // $ANTLR end entryRuleDatatype


    // $ANTLR start ruleDatatype
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:362:1: ruleDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'str' | this_INT_1= RULE_INT | this_Datatype2_2= ruleDatatype2 ) ;
    public final AntlrDatatypeRuleToken ruleDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        AntlrDatatypeRuleToken this_Datatype2_2 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:367:6: ( (kw= 'str' | this_INT_1= RULE_INT | this_Datatype2_2= ruleDatatype2 ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:368:1: (kw= 'str' | this_INT_1= RULE_INT | this_Datatype2_2= ruleDatatype2 )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:368:1: (kw= 'str' | this_INT_1= RULE_INT | this_Datatype2_2= ruleDatatype2 )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt2=1;
                }
                break;
            case RULE_INT:
                {
                alt2=2;
                }
                break;
            case RULE_STRING:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("368:1: (kw= 'str' | this_INT_1= RULE_INT | this_Datatype2_2= ruleDatatype2 )", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:369:2: kw= 'str'
                    {
                    kw=(Token)input.LT(1);
                    match(input,18,FOLLOW_18_in_ruleDatatype751); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getDatatypeAccess().getStrKeyword_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:375:10: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDatatype772); 

                    		current.merge(this_INT_1);
                        
                     
                        createLeafNode(grammarAccess.getDatatypeAccess().getINTTerminalRuleCall_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:384:5: this_Datatype2_2= ruleDatatype2
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDatatypeAccess().getDatatype2ParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDatatype2_in_ruleDatatype805);
                    this_Datatype2_2=ruleDatatype2();
                    _fsp--;


                    		current.merge(this_Datatype2_2);
                        
                     
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
    // $ANTLR end ruleDatatype


    // $ANTLR start entryRuleDatatype2
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:402:1: entryRuleDatatype2 returns [String current=null] : iv_ruleDatatype2= ruleDatatype2 EOF ;
    public final String entryRuleDatatype2() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatype2 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:402:50: (iv_ruleDatatype2= ruleDatatype2 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:403:2: iv_ruleDatatype2= ruleDatatype2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDatatype2Rule(), currentNode); 
            pushFollow(FOLLOW_ruleDatatype2_in_entryRuleDatatype2849);
            iv_ruleDatatype2=ruleDatatype2();
            _fsp--;

             current =iv_ruleDatatype2.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDatatype2860); 

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
    // $ANTLR end entryRuleDatatype2


    // $ANTLR start ruleDatatype2
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:410:1: ruleDatatype2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleDatatype2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:415:6: (this_STRING_0= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:416:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDatatype2899); 

            		current.merge(this_STRING_0);
                
             
                createLeafNode(grammarAccess.getDatatype2Access().getSTRINGTerminalRuleCall(), null); 
                

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
    // $ANTLR end ruleDatatype2


    // $ANTLR start entryRuleCommonTerminalsRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:431:1: entryRuleCommonTerminalsRule returns [EObject current=null] : iv_ruleCommonTerminalsRule= ruleCommonTerminalsRule EOF ;
    public final EObject entryRuleCommonTerminalsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommonTerminalsRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:431:61: (iv_ruleCommonTerminalsRule= ruleCommonTerminalsRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:432:2: iv_ruleCommonTerminalsRule= ruleCommonTerminalsRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCommonTerminalsRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleCommonTerminalsRule_in_entryRuleCommonTerminalsRule941);
            iv_ruleCommonTerminalsRule=ruleCommonTerminalsRule();
            _fsp--;

             current =iv_ruleCommonTerminalsRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommonTerminalsRule951); 

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
    // $ANTLR end entryRuleCommonTerminalsRule


    // $ANTLR start ruleCommonTerminalsRule
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:439:1: ruleCommonTerminalsRule returns [EObject current=null] : ( 'terminals' RULE_ID RULE_INT RULE_STRING ( (lv_val_4_0= RULE_ID ) ) ) ;
    public final EObject ruleCommonTerminalsRule() throws RecognitionException {
        EObject current = null;

        Token lv_val_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:444:6: ( ( 'terminals' RULE_ID RULE_INT RULE_STRING ( (lv_val_4_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:445:1: ( 'terminals' RULE_ID RULE_INT RULE_STRING ( (lv_val_4_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:445:1: ( 'terminals' RULE_ID RULE_INT RULE_STRING ( (lv_val_4_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:445:3: 'terminals' RULE_ID RULE_INT RULE_STRING ( (lv_val_4_0= RULE_ID ) )
            {
            match(input,19,FOLLOW_19_in_ruleCommonTerminalsRule986); 

                    createLeafNode(grammarAccess.getCommonTerminalsRuleAccess().getTerminalsKeyword_0(), null); 
                
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommonTerminalsRule995); 
             
                createLeafNode(grammarAccess.getCommonTerminalsRuleAccess().getIDTerminalRuleCall_1(), null); 
                
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleCommonTerminalsRule1003); 
             
                createLeafNode(grammarAccess.getCommonTerminalsRuleAccess().getINTTerminalRuleCall_2(), null); 
                
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCommonTerminalsRule1011); 
             
                createLeafNode(grammarAccess.getCommonTerminalsRuleAccess().getSTRINGTerminalRuleCall_3(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:461:1: ( (lv_val_4_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:462:1: (lv_val_4_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:462:1: (lv_val_4_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parsetree/unassignedtext/parser/antlr/internal/InternalUnassignedTextTestLanguage.g:463:3: lv_val_4_0= RULE_ID
            {
            lv_val_4_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommonTerminalsRule1027); 

            			createLeafNode(grammarAccess.getCommonTerminalsRuleAccess().getValIDTerminalRuleCall_4_0(), "val"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCommonTerminalsRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"val",
            	        		lv_val_4_0, 
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
    // $ANTLR end ruleCommonTerminalsRule


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseInsensitiveKeywordRule_in_ruleModel130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePluralRule_in_ruleModel157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiRule_in_ruleModel184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatypeRule_in_ruleModel211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommonTerminalsRule_in_ruleModel238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseInsensitiveKeywordRule_in_entryRuleCaseInsensitiveKeywordRule270 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCaseInsensitiveKeywordRule280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CASEINSENSITIVEKEYWORD_in_ruleCaseInsensitiveKeywordRule314 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleCaseInsensitiveKeywordRule330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePluralRule_in_entryRulePluralRule368 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePluralRule378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rulePluralRule413 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_rulePluralRule430 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_PLURAL_in_rulePluralRule444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiRule_in_entryRuleMultiRule476 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiRule486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleMultiRule521 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleMultiRule538 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_MULTI_in_ruleMultiRule552 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_MULTI_in_ruleMultiRule560 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_MULTI_in_ruleMultiRule568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatypeRule_in_entryRuleDatatypeRule600 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeRule610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleDatatypeRule645 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDatatypeRule662 = new BitSet(new long[]{0x0000000000040120L});
    public static final BitSet FOLLOW_ruleDatatype_in_ruleDatatypeRule676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_entryRuleDatatype702 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDatatype713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleDatatype751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDatatype772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype2_in_ruleDatatype805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype2_in_entryRuleDatatype2849 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDatatype2860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDatatype2899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommonTerminalsRule_in_entryRuleCommonTerminalsRule941 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommonTerminalsRule951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleCommonTerminalsRule986 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCommonTerminalsRule995 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleCommonTerminalsRule1003 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCommonTerminalsRule1011 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCommonTerminalsRule1027 = new BitSet(new long[]{0x0000000000000002L});

}