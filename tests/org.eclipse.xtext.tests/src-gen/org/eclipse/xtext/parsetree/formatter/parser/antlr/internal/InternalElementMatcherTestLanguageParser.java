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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'kw1'", "'.'", "'#2'", "'sub'", "'ass1'", "'ass2'", "'#3'", "'sub2'", "'sub3'", "'#4'", "'{'", "'}'", "';'", "'#5'", "'gr'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:86:1: ruleModel returns [EObject current=null] : (this_Simple_0= ruleSimple | this_RuleCalls_1= ruleRuleCalls | this_OptionalCalls_2= ruleOptionalCalls | this_Recursion_3= ruleRecursion | this_Loop_4= ruleLoop ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_Simple_0 = null;

        EObject this_RuleCalls_1 = null;

        EObject this_OptionalCalls_2 = null;

        EObject this_Recursion_3 = null;

        EObject this_Loop_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:91:6: ( (this_Simple_0= ruleSimple | this_RuleCalls_1= ruleRuleCalls | this_OptionalCalls_2= ruleOptionalCalls | this_Recursion_3= ruleRecursion | this_Loop_4= ruleLoop ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:92:1: (this_Simple_0= ruleSimple | this_RuleCalls_1= ruleRuleCalls | this_OptionalCalls_2= ruleOptionalCalls | this_Recursion_3= ruleRecursion | this_Loop_4= ruleLoop )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:92:1: (this_Simple_0= ruleSimple | this_RuleCalls_1= ruleRuleCalls | this_OptionalCalls_2= ruleOptionalCalls | this_Recursion_3= ruleRecursion | this_Loop_4= ruleLoop )
            int alt1=5;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("92:1: (this_Simple_0= ruleSimple | this_RuleCalls_1= ruleRuleCalls | this_OptionalCalls_2= ruleOptionalCalls | this_Recursion_3= ruleRecursion | this_Loop_4= ruleLoop )", 1, 0, input);

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:149:1: entryRuleSimple returns [EObject current=null] : iv_ruleSimple= ruleSimple EOF ;
    public final EObject entryRuleSimple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimple = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:150:2: (iv_ruleSimple= ruleSimple EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:151:2: iv_ruleSimple= ruleSimple EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSimple_in_entryRuleSimple275);
            iv_ruleSimple=ruleSimple();
            _fsp--;

             current =iv_ruleSimple; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimple285); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:158:1: ruleSimple returns [EObject current=null] : ( '#1' ( (lv_name_1_0= RULE_ID ) ) ( 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) ) ;
    public final EObject ruleSimple() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_optional_3_0=null;
        AntlrDatatypeRuleToken lv_datatype_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:163:6: ( ( '#1' ( (lv_name_1_0= RULE_ID ) ) ( 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:164:1: ( '#1' ( (lv_name_1_0= RULE_ID ) ) ( 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:164:1: ( '#1' ( (lv_name_1_0= RULE_ID ) ) ( 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:164:3: '#1' ( (lv_name_1_0= RULE_ID ) ) ( 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) )
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleSimple320); 

                    createLeafNode(grammarAccess.getSimpleAccess().getNumberSignDigitOneKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:168:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:169:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:169:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:170:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimple337); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:192:2: ( 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:192:4: 'kw1' ( (lv_optional_3_0= RULE_ID ) )
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleSimple353); 

                            createLeafNode(grammarAccess.getSimpleAccess().getKw1Keyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:196:1: ( (lv_optional_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:197:1: (lv_optional_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:197:1: (lv_optional_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:198:3: lv_optional_3_0= RULE_ID
                    {
                    lv_optional_3_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimple370); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:220:4: ( (lv_datatype_4_0= ruleFQN ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:221:1: (lv_datatype_4_0= ruleFQN )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:221:1: (lv_datatype_4_0= ruleFQN )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:222:3: lv_datatype_4_0= ruleFQN
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSimpleAccess().getDatatypeFQNParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleSimple398);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:252:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:253:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:254:2: iv_ruleFQN= ruleFQN EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFQNRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN435);
            iv_ruleFQN=ruleFQN();
            _fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN446); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:261:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:266:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:267:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:267:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:267:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN486); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:274:1: (kw= '.' this_ID_2= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:275:2: kw= '.' this_ID_2= RULE_ID
            {
            kw=(Token)input.LT(1);
            match(input,13,FollowSets000.FOLLOW_13_in_ruleFQN505); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getFQNAccess().getFullStopKeyword_1_0(), null); 
                
            this_ID_2=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN520); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:295:1: entryRuleRuleCalls returns [EObject current=null] : iv_ruleRuleCalls= ruleRuleCalls EOF ;
    public final EObject entryRuleRuleCalls() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCalls = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:296:2: (iv_ruleRuleCalls= ruleRuleCalls EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:297:2: iv_ruleRuleCalls= ruleRuleCalls EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallsRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCalls_in_entryRuleRuleCalls566);
            iv_ruleRuleCalls=ruleRuleCalls();
            _fsp--;

             current =iv_ruleRuleCalls; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCalls576); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:304:1: ruleRuleCalls returns [EObject current=null] : ( '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? ) ;
    public final EObject ruleRuleCalls() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject this_RuleCallsSub_1 = null;

        EObject lv_call1_3_0 = null;

        EObject lv_call2_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:309:6: ( ( '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:310:1: ( '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:310:1: ( '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:310:3: '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )?
            {
            match(input,14,FollowSets000.FOLLOW_14_in_ruleRuleCalls611); 

                    createLeafNode(grammarAccess.getRuleCallsAccess().getNumberSignDigitTwoKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getRuleCallsAccess().getRuleCallsSubParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsSub_in_ruleRuleCalls633);
            this_RuleCallsSub_1=ruleRuleCallsSub();
            _fsp--;

             
                    current = this_RuleCallsSub_1; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:323:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:324:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:324:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:325:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCalls649); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:347:2: ( (lv_call1_3_0= ruleRuleCallsAss1 ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:348:1: (lv_call1_3_0= ruleRuleCallsAss1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:348:1: (lv_call1_3_0= ruleRuleCallsAss1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:349:3: lv_call1_3_0= ruleRuleCallsAss1
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRuleCallsAccess().getCall1RuleCallsAss1ParserRuleCall_3_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss1_in_ruleRuleCalls675);
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:371:3: ( (lv_call2_4_0= ruleRuleCallsAss2 ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:372:1: (lv_call2_4_0= ruleRuleCallsAss2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:372:1: (lv_call2_4_0= ruleRuleCallsAss2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:373:3: lv_call2_4_0= ruleRuleCallsAss2
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRuleCallsAccess().getCall2RuleCallsAss2ParserRuleCall_4_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss2_in_ruleRuleCalls697);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:403:1: entryRuleRuleCallsSub returns [EObject current=null] : iv_ruleRuleCallsSub= ruleRuleCallsSub EOF ;
    public final EObject entryRuleRuleCallsSub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallsSub = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:404:2: (iv_ruleRuleCallsSub= ruleRuleCallsSub EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:405:2: iv_ruleRuleCallsSub= ruleRuleCallsSub EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallsSubRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsSub_in_entryRuleRuleCallsSub734);
            iv_ruleRuleCallsSub=ruleRuleCallsSub();
            _fsp--;

             current =iv_ruleRuleCallsSub; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallsSub744); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:412:1: ruleRuleCallsSub returns [EObject current=null] : ( (lv_sub_0_0= 'sub' ) ) ;
    public final EObject ruleRuleCallsSub() throws RecognitionException {
        EObject current = null;

        Token lv_sub_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:417:6: ( ( (lv_sub_0_0= 'sub' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:418:1: ( (lv_sub_0_0= 'sub' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:418:1: ( (lv_sub_0_0= 'sub' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:419:1: (lv_sub_0_0= 'sub' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:419:1: (lv_sub_0_0= 'sub' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:420:3: lv_sub_0_0= 'sub'
            {
            lv_sub_0_0=(Token)input.LT(1);
            match(input,15,FollowSets000.FOLLOW_15_in_ruleRuleCallsSub786); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:447:1: entryRuleRuleCallsAss1 returns [EObject current=null] : iv_ruleRuleCallsAss1= ruleRuleCallsAss1 EOF ;
    public final EObject entryRuleRuleCallsAss1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallsAss1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:448:2: (iv_ruleRuleCallsAss1= ruleRuleCallsAss1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:449:2: iv_ruleRuleCallsAss1= ruleRuleCallsAss1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallsAss1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss1_in_entryRuleRuleCallsAss1834);
            iv_ruleRuleCallsAss1=ruleRuleCallsAss1();
            _fsp--;

             current =iv_ruleRuleCallsAss1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallsAss1844); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:456:1: ruleRuleCallsAss1 returns [EObject current=null] : ( 'ass1' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleRuleCallsAss1() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:461:6: ( ( 'ass1' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:462:1: ( 'ass1' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:462:1: ( 'ass1' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:462:3: 'ass1' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,16,FollowSets000.FOLLOW_16_in_ruleRuleCallsAss1879); 

                    createLeafNode(grammarAccess.getRuleCallsAss1Access().getAss1Keyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:466:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:467:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:467:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:468:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCallsAss1896); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:498:1: entryRuleRuleCallsAss2 returns [EObject current=null] : iv_ruleRuleCallsAss2= ruleRuleCallsAss2 EOF ;
    public final EObject entryRuleRuleCallsAss2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallsAss2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:499:2: (iv_ruleRuleCallsAss2= ruleRuleCallsAss2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:500:2: iv_ruleRuleCallsAss2= ruleRuleCallsAss2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallsAss2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss2_in_entryRuleRuleCallsAss2937);
            iv_ruleRuleCallsAss2=ruleRuleCallsAss2();
            _fsp--;

             current =iv_ruleRuleCallsAss2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallsAss2947); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:507:1: ruleRuleCallsAss2 returns [EObject current=null] : ( 'ass2' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleRuleCallsAss2() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:512:6: ( ( 'ass2' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:513:1: ( 'ass2' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:513:1: ( 'ass2' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:513:3: 'ass2' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,17,FollowSets000.FOLLOW_17_in_ruleRuleCallsAss2982); 

                    createLeafNode(grammarAccess.getRuleCallsAss2Access().getAss2Keyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:517:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:518:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:518:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:519:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCallsAss2999); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:549:1: entryRuleOptionalCalls returns [EObject current=null] : iv_ruleOptionalCalls= ruleOptionalCalls EOF ;
    public final EObject entryRuleOptionalCalls() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalCalls = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:550:2: (iv_ruleOptionalCalls= ruleOptionalCalls EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:551:2: iv_ruleOptionalCalls= ruleOptionalCalls EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOptionalCallsRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCalls_in_entryRuleOptionalCalls1040);
            iv_ruleOptionalCalls=ruleOptionalCalls();
            _fsp--;

             current =iv_ruleOptionalCalls; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCalls1050); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:558:1: ruleOptionalCalls returns [EObject current=null] : ( '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleOptionalCalls() throws RecognitionException {
        EObject current = null;

        Token lv_name_3_0=null;
        EObject lv_opt1_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:563:6: ( ( '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:564:1: ( '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:564:1: ( '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:564:3: '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) )
            {
            match(input,18,FollowSets000.FOLLOW_18_in_ruleOptionalCalls1085); 

                    createLeafNode(grammarAccess.getOptionalCallsAccess().getNumberSignDigitThreeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:568:1: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:569:5: 
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:579:2: ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15||LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:580:1: (lv_opt1_2_0= ruleOptionalCallsSub1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:580:1: (lv_opt1_2_0= ruleOptionalCallsSub1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:581:3: lv_opt1_2_0= ruleOptionalCallsSub1
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOptionalCallsAccess().getOpt1OptionalCallsSub1ParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub1_in_ruleOptionalCalls1115);
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:603:3: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:604:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:604:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:605:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalCalls1133); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:635:1: entryRuleOptionalCallsSub1 returns [EObject current=null] : iv_ruleOptionalCallsSub1= ruleOptionalCallsSub1 EOF ;
    public final EObject entryRuleOptionalCallsSub1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalCallsSub1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:636:2: (iv_ruleOptionalCallsSub1= ruleOptionalCallsSub1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:637:2: iv_ruleOptionalCallsSub1= ruleOptionalCallsSub1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOptionalCallsSub1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub1_in_entryRuleOptionalCallsSub11174);
            iv_ruleOptionalCallsSub1=ruleOptionalCallsSub1();
            _fsp--;

             current =iv_ruleOptionalCallsSub1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCallsSub11184); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:644:1: ruleOptionalCallsSub1 returns [EObject current=null] : ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? ) ;
    public final EObject ruleOptionalCallsSub1() throws RecognitionException {
        EObject current = null;

        EObject lv_opt2_1_0 = null;

        EObject lv_opt3_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:649:6: ( ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:650:1: ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:650:1: ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:650:2: () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:650:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:651:5: 
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:661:2: ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:662:1: (lv_opt2_1_0= ruleOptionalCallsSub2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:662:1: (lv_opt2_1_0= ruleOptionalCallsSub2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:663:3: lv_opt2_1_0= ruleOptionalCallsSub2
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOptionalCallsSub1Access().getOpt2OptionalCallsSub2ParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub2_in_ruleOptionalCallsSub11239);
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

            match(input,15,FollowSets000.FOLLOW_15_in_ruleOptionalCallsSub11250); 

                    createLeafNode(grammarAccess.getOptionalCallsSub1Access().getSubKeyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:689:1: ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:690:1: (lv_opt3_3_0= ruleOptionalCallsSub3 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:690:1: (lv_opt3_3_0= ruleOptionalCallsSub3 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:691:3: lv_opt3_3_0= ruleOptionalCallsSub3
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOptionalCallsSub1Access().getOpt3OptionalCallsSub3ParserRuleCall_3_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub3_in_ruleOptionalCallsSub11271);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:721:1: entryRuleOptionalCallsSub2 returns [EObject current=null] : iv_ruleOptionalCallsSub2= ruleOptionalCallsSub2 EOF ;
    public final EObject entryRuleOptionalCallsSub2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalCallsSub2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:722:2: (iv_ruleOptionalCallsSub2= ruleOptionalCallsSub2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:723:2: iv_ruleOptionalCallsSub2= ruleOptionalCallsSub2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOptionalCallsSub2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub2_in_entryRuleOptionalCallsSub21308);
            iv_ruleOptionalCallsSub2=ruleOptionalCallsSub2();
            _fsp--;

             current =iv_ruleOptionalCallsSub2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCallsSub21318); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:730:1: ruleOptionalCallsSub2 returns [EObject current=null] : ( 'sub2' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleOptionalCallsSub2() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:735:6: ( ( 'sub2' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:736:1: ( 'sub2' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:736:1: ( 'sub2' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:736:3: 'sub2' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,19,FollowSets000.FOLLOW_19_in_ruleOptionalCallsSub21353); 

                    createLeafNode(grammarAccess.getOptionalCallsSub2Access().getSub2Keyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:740:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:741:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:741:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:742:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalCallsSub21370); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:772:1: entryRuleOptionalCallsSub3 returns [EObject current=null] : iv_ruleOptionalCallsSub3= ruleOptionalCallsSub3 EOF ;
    public final EObject entryRuleOptionalCallsSub3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalCallsSub3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:773:2: (iv_ruleOptionalCallsSub3= ruleOptionalCallsSub3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:774:2: iv_ruleOptionalCallsSub3= ruleOptionalCallsSub3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOptionalCallsSub3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub3_in_entryRuleOptionalCallsSub31411);
            iv_ruleOptionalCallsSub3=ruleOptionalCallsSub3();
            _fsp--;

             current =iv_ruleOptionalCallsSub3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCallsSub31421); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:781:1: ruleOptionalCallsSub3 returns [EObject current=null] : ( 'sub3' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleOptionalCallsSub3() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:786:6: ( ( 'sub3' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:787:1: ( 'sub3' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:787:1: ( 'sub3' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:787:3: 'sub3' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,20,FollowSets000.FOLLOW_20_in_ruleOptionalCallsSub31456); 

                    createLeafNode(grammarAccess.getOptionalCallsSub3Access().getSub3Keyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:791:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:792:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:792:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:793:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalCallsSub31473); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:823:1: entryRuleRecursion returns [EObject current=null] : iv_ruleRecursion= ruleRecursion EOF ;
    public final EObject entryRuleRecursion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecursion = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:824:2: (iv_ruleRecursion= ruleRecursion EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:825:2: iv_ruleRecursion= ruleRecursion EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRecursionRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRecursion_in_entryRuleRecursion1514);
            iv_ruleRecursion=ruleRecursion();
            _fsp--;

             current =iv_ruleRecursion; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRecursion1524); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:832:1: ruleRecursion returns [EObject current=null] : ( '#4' this_RecursionSub_1= ruleRecursionSub ) ;
    public final EObject ruleRecursion() throws RecognitionException {
        EObject current = null;

        EObject this_RecursionSub_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:837:6: ( ( '#4' this_RecursionSub_1= ruleRecursionSub ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:838:1: ( '#4' this_RecursionSub_1= ruleRecursionSub )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:838:1: ( '#4' this_RecursionSub_1= ruleRecursionSub )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:838:3: '#4' this_RecursionSub_1= ruleRecursionSub
            {
            match(input,21,FollowSets000.FOLLOW_21_in_ruleRecursion1559); 

                    createLeafNode(grammarAccess.getRecursionAccess().getNumberSignDigitFourKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getRecursionAccess().getRecursionSubParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRecursionSub_in_ruleRecursion1581);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:859:1: entryRuleRecursionSub returns [EObject current=null] : iv_ruleRecursionSub= ruleRecursionSub EOF ;
    public final EObject entryRuleRecursionSub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecursionSub = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:860:2: (iv_ruleRecursionSub= ruleRecursionSub EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:861:2: iv_ruleRecursionSub= ruleRecursionSub EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRecursionSubRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRecursionSub_in_entryRuleRecursionSub1616);
            iv_ruleRecursionSub=ruleRecursionSub();
            _fsp--;

             current =iv_ruleRecursionSub; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRecursionSub1626); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:868:1: ruleRecursionSub returns [EObject current=null] : ( () '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* '}' ( (lv_semi_5_0= ';' ) )? ) ;
    public final EObject ruleRecursionSub() throws RecognitionException {
        EObject current = null;

        Token lv_vals_3_0=null;
        Token lv_semi_5_0=null;
        EObject lv_sub_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:873:6: ( ( () '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* '}' ( (lv_semi_5_0= ';' ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:874:1: ( () '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* '}' ( (lv_semi_5_0= ';' ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:874:1: ( () '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* '}' ( (lv_semi_5_0= ';' ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:874:2: () '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* '}' ( (lv_semi_5_0= ';' ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:874:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:875:5: 
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

            match(input,22,FollowSets000.FOLLOW_22_in_ruleRecursionSub1670); 

                    createLeafNode(grammarAccess.getRecursionSubAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:889:1: ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:889:2: ( (lv_sub_2_0= ruleRecursionSub ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:889:2: ( (lv_sub_2_0= ruleRecursionSub ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:890:1: (lv_sub_2_0= ruleRecursionSub )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:890:1: (lv_sub_2_0= ruleRecursionSub )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:891:3: lv_sub_2_0= ruleRecursionSub
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRecursionSubAccess().getSubRecursionSubParserRuleCall_2_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRecursionSub_in_ruleRecursionSub1692);
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:914:6: ( (lv_vals_3_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:914:6: ( (lv_vals_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:915:1: (lv_vals_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:915:1: (lv_vals_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:916:3: lv_vals_3_0= RULE_ID
            	    {
            	    lv_vals_3_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRecursionSub1715); 

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

            match(input,23,FollowSets000.FOLLOW_23_in_ruleRecursionSub1732); 

                    createLeafNode(grammarAccess.getRecursionSubAccess().getRightCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:942:1: ( (lv_semi_5_0= ';' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:943:1: (lv_semi_5_0= ';' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:943:1: (lv_semi_5_0= ';' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:944:3: lv_semi_5_0= ';'
                    {
                    lv_semi_5_0=(Token)input.LT(1);
                    match(input,24,FollowSets000.FOLLOW_24_in_ruleRecursionSub1750); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:971:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:972:2: (iv_ruleLoop= ruleLoop EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:973:2: iv_ruleLoop= ruleLoop EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLoopRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLoop_in_entryRuleLoop1800);
            iv_ruleLoop=ruleLoop();
            _fsp--;

             current =iv_ruleLoop; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoop1810); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:980:1: ruleLoop returns [EObject current=null] : ( '#5' ( (lv_names_1_0= RULE_ID ) )+ ( 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* ) ;
    public final EObject ruleLoop() throws RecognitionException {
        EObject current = null;

        Token lv_names_1_0=null;
        Token lv_gr_3_0=null;
        Token lv_ints_4_0=null;
        Token lv_strings_5_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:985:6: ( ( '#5' ( (lv_names_1_0= RULE_ID ) )+ ( 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:986:1: ( '#5' ( (lv_names_1_0= RULE_ID ) )+ ( 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:986:1: ( '#5' ( (lv_names_1_0= RULE_ID ) )+ ( 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:986:3: '#5' ( (lv_names_1_0= RULE_ID ) )+ ( 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )*
            {
            match(input,25,FollowSets000.FOLLOW_25_in_ruleLoop1845); 

                    createLeafNode(grammarAccess.getLoopAccess().getNumberSignDigitFiveKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:990:1: ( (lv_names_1_0= RULE_ID ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:991:1: (lv_names_1_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:991:1: (lv_names_1_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:992:3: lv_names_1_0= RULE_ID
            	    {
            	    lv_names_1_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop1862); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1014:3: ( 'gr' ( (lv_gr_3_0= RULE_ID ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==26) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1014:5: 'gr' ( (lv_gr_3_0= RULE_ID ) )
            	    {
            	    match(input,26,FollowSets000.FOLLOW_26_in_ruleLoop1879); 

            	            createLeafNode(grammarAccess.getLoopAccess().getGrKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1018:1: ( (lv_gr_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1019:1: (lv_gr_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1019:1: (lv_gr_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1020:3: lv_gr_3_0= RULE_ID
            	    {
            	    lv_gr_3_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop1896); 

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1042:4: ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1042:5: ( (lv_ints_4_0= RULE_INT ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1042:5: ( (lv_ints_4_0= RULE_INT ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1043:1: (lv_ints_4_0= RULE_INT )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1043:1: (lv_ints_4_0= RULE_INT )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1044:3: lv_ints_4_0= RULE_INT
            	    {
            	    lv_ints_4_0=(Token)input.LT(1);
            	    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLoop1921); 

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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1067:6: ( (lv_strings_5_0= RULE_STRING ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1067:6: ( (lv_strings_5_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1068:1: (lv_strings_5_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1068:1: (lv_strings_5_0= RULE_STRING )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1069:3: lv_strings_5_0= RULE_STRING
            	    {
            	    lv_strings_5_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleLoop1949); 

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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimple_in_ruleModel132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCalls_in_ruleModel159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCalls_in_ruleModel186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecursion_in_ruleModel213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop_in_ruleModel240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimple_in_entryRuleSimple275 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimple285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleSimple320 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimple337 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleSimple353 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimple370 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleSimple398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN435 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN446 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN486 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleFQN505 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN520 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCalls_in_entryRuleRuleCalls566 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCalls576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleRuleCalls611 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleRuleCallsSub_in_ruleRuleCalls633 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCalls649 = new BitSet(new long[]{0x0000000000030002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss1_in_ruleRuleCalls675 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss2_in_ruleRuleCalls697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallsSub_in_entryRuleRuleCallsSub734 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallsSub744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleRuleCallsSub786 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss1_in_entryRuleRuleCallsAss1834 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallsAss1844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleRuleCallsAss1879 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallsAss1896 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss2_in_entryRuleRuleCallsAss2937 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallsAss2947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleRuleCallsAss2982 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallsAss2999 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCalls_in_entryRuleOptionalCalls1040 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCalls1050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleOptionalCalls1085 = new BitSet(new long[]{0x0000000000088010L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub1_in_ruleOptionalCalls1115 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalCalls1133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub1_in_entryRuleOptionalCallsSub11174 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCallsSub11184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub2_in_ruleOptionalCallsSub11239 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleOptionalCallsSub11250 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub3_in_ruleOptionalCallsSub11271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub2_in_entryRuleOptionalCallsSub21308 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCallsSub21318 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleOptionalCallsSub21353 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalCallsSub21370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub3_in_entryRuleOptionalCallsSub31411 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCallsSub31421 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleOptionalCallsSub31456 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalCallsSub31473 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecursion_in_entryRuleRecursion1514 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRecursion1524 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleRecursion1559 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_ruleRecursionSub_in_ruleRecursion1581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecursionSub_in_entryRuleRecursionSub1616 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRecursionSub1626 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleRecursionSub1670 = new BitSet(new long[]{0x0000000000C00010L});
        public static final BitSet FOLLOW_ruleRecursionSub_in_ruleRecursionSub1692 = new BitSet(new long[]{0x0000000000C00010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRecursionSub1715 = new BitSet(new long[]{0x0000000000C00010L});
        public static final BitSet FOLLOW_23_in_ruleRecursionSub1732 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_24_in_ruleRecursionSub1750 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop_in_entryRuleLoop1800 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoop1810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleLoop1845 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop1862 = new BitSet(new long[]{0x0000000004000072L});
        public static final BitSet FOLLOW_26_in_ruleLoop1879 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop1896 = new BitSet(new long[]{0x0000000004000062L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLoop1921 = new BitSet(new long[]{0x0000000000000062L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleLoop1949 = new BitSet(new long[]{0x0000000000000062L});
    }


}