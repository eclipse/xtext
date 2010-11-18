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
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int T__12=12;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__33=33;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__22=22;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int T__31=31;
    public static final int RULE_INT=5;
    public static final int EOF=-1;
    public static final int T__27=27;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int T__24=24;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalElementMatcherTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalElementMatcherTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalElementMatcherTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g"; }



     	private ElementMatcherTestLanguageGrammarAccess grammarAccess;
     	
        public InternalElementMatcherTestLanguageParser(TokenStream input, IAstFactory factory, ElementMatcherTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected ElementMatcherTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:71:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:72:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:80:1: ruleModel returns [EObject current=null] : (this_Simple_0= ruleSimple | this_RuleCalls_1= ruleRuleCalls | this_OptionalCalls_2= ruleOptionalCalls | this_Recursion_3= ruleRecursion | this_Loop_4= ruleLoop | this_Expression_5= ruleExpression ) ;
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
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:85:6: ( (this_Simple_0= ruleSimple | this_RuleCalls_1= ruleRuleCalls | this_OptionalCalls_2= ruleOptionalCalls | this_Recursion_3= ruleRecursion | this_Loop_4= ruleLoop | this_Expression_5= ruleExpression ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:86:1: (this_Simple_0= ruleSimple | this_RuleCalls_1= ruleRuleCalls | this_OptionalCalls_2= ruleOptionalCalls | this_Recursion_3= ruleRecursion | this_Loop_4= ruleLoop | this_Expression_5= ruleExpression )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:86:1: (this_Simple_0= ruleSimple | this_RuleCalls_1= ruleRuleCalls | this_OptionalCalls_2= ruleOptionalCalls | this_Recursion_3= ruleRecursion | this_Loop_4= ruleLoop | this_Expression_5= ruleExpression )
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
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:87:5: this_Simple_0= ruleSimple
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getSimpleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSimple_in_ruleModel132);
                    this_Simple_0=ruleSimple();

                    state._fsp--;

                     
                            current = this_Simple_0; 
                            // currentNode = currentNode.getParent();
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:98:5: this_RuleCalls_1= ruleRuleCalls
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getRuleCallsParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCalls_in_ruleModel159);
                    this_RuleCalls_1=ruleRuleCalls();

                    state._fsp--;

                     
                            current = this_RuleCalls_1; 
                            // currentNode = currentNode.getParent();
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:109:5: this_OptionalCalls_2= ruleOptionalCalls
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getOptionalCallsParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalCalls_in_ruleModel186);
                    this_OptionalCalls_2=ruleOptionalCalls();

                    state._fsp--;

                     
                            current = this_OptionalCalls_2; 
                            // currentNode = currentNode.getParent();
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:120:5: this_Recursion_3= ruleRecursion
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getRecursionParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRecursion_in_ruleModel213);
                    this_Recursion_3=ruleRecursion();

                    state._fsp--;

                     
                            current = this_Recursion_3; 
                            // currentNode = currentNode.getParent();
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:131:5: this_Loop_4= ruleLoop
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getLoopParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLoop_in_ruleModel240);
                    this_Loop_4=ruleLoop();

                    state._fsp--;

                     
                            current = this_Loop_4; 
                            // currentNode = currentNode.getParent();
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:142:5: this_Expression_5= ruleExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getExpressionParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleModel267);
                    this_Expression_5=ruleExpression();

                    state._fsp--;

                     
                            current = this_Expression_5; 
                            // currentNode = currentNode.getParent();
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleSimple"
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

            state._fsp--;

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
    // $ANTLR end "entryRuleSimple"


    // $ANTLR start "ruleSimple"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:168:1: ruleSimple returns [EObject current=null] : (otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) ) ;
    public final EObject ruleSimple() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_optional_3_0=null;
        AntlrDatatypeRuleToken lv_datatype_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:173:6: ( (otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:174:1: (otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:174:1: (otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:174:3: otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleSimple349); 

                	createLeafNode(otherlv_0, grammarAccess.getSimpleAccess().getNumberSignDigitOneKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:178:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:179:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:179:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:180:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimple366); 

            			createLeafNode(lv_name_1_0, grammarAccess.getSimpleAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID", 
                    		lastConsumedNode);
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:197:2: (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:197:4: otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSimple384); 

                        	createLeafNode(otherlv_2, grammarAccess.getSimpleAccess().getKw1Keyword_2_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:201:1: ( (lv_optional_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:202:1: (lv_optional_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:202:1: (lv_optional_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:203:3: lv_optional_3_0= RULE_ID
                    {
                    lv_optional_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimple401); 

                    			createLeafNode(lv_optional_3_0, grammarAccess.getSimpleAccess().getOptionalIDTerminalRuleCall_2_1_0(), "optional"); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleRule());
                    	        }
                           		set(
                           			current, 
                           			"optional",
                            		lv_optional_3_0, 
                            		"ID", 
                            		lastConsumedNode);
                    	    

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
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleSimple429);
            lv_datatype_4_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSimpleRule());
            	        }
                   		set(
                   			current, 
                   			"datatype",
                    		lv_datatype_4_0, 
                    		"FQN", 
                    		currentNode);
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleSimple"


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:247:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:248:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:249:2: iv_ruleFQN= ruleFQN EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFQNRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN466);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN477); 

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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:256:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:261:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:262:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:262:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:262:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN517); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:269:1: (kw= '.' this_ID_2= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:270:2: kw= '.' this_ID_2= RULE_ID
            {
            kw=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleFQN536); 

                    current.merge(kw);
                    createLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0(), null); 
                
            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN551); 

            		current.merge(this_ID_2);
                
             
                createLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1(), null); 
                

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
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleRuleCalls"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:290:1: entryRuleRuleCalls returns [EObject current=null] : iv_ruleRuleCalls= ruleRuleCalls EOF ;
    public final EObject entryRuleRuleCalls() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCalls = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:291:2: (iv_ruleRuleCalls= ruleRuleCalls EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:292:2: iv_ruleRuleCalls= ruleRuleCalls EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallsRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCalls_in_entryRuleRuleCalls597);
            iv_ruleRuleCalls=ruleRuleCalls();

            state._fsp--;

             current =iv_ruleRuleCalls; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCalls607); 

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
    // $ANTLR end "entryRuleRuleCalls"


    // $ANTLR start "ruleRuleCalls"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:299:1: ruleRuleCalls returns [EObject current=null] : (otherlv_0= '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? ) ;
    public final EObject ruleRuleCalls() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;
        EObject this_RuleCallsSub_1 = null;

        EObject lv_call1_3_0 = null;

        EObject lv_call2_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:304:6: ( (otherlv_0= '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:305:1: (otherlv_0= '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:305:1: (otherlv_0= '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:305:3: otherlv_0= '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )?
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleRuleCalls644); 

                	createLeafNode(otherlv_0, grammarAccess.getRuleCallsAccess().getNumberSignDigitTwoKeyword_0(), null);
                
             
                    currentNode=createCompositeNode(grammarAccess.getRuleCallsAccess().getRuleCallsSubParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsSub_in_ruleRuleCalls666);
            this_RuleCallsSub_1=ruleRuleCallsSub();

            state._fsp--;

             
                    current = this_RuleCallsSub_1; 
                    // currentNode = currentNode.getParent();
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:319:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:320:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:320:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:321:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCalls682); 

            			createLeafNode(lv_name_2_0, grammarAccess.getRuleCallsAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleCallsRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID", 
                    		lastConsumedNode);
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:338:2: ( (lv_call1_3_0= ruleRuleCallsAss1 ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:339:1: (lv_call1_3_0= ruleRuleCallsAss1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:339:1: (lv_call1_3_0= ruleRuleCallsAss1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:340:3: lv_call1_3_0= ruleRuleCallsAss1
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRuleCallsAccess().getCall1RuleCallsAss1ParserRuleCall_3_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss1_in_ruleRuleCalls708);
                    lv_call1_3_0=ruleRuleCallsAss1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRuleCallsRule());
                    	        }
                           		set(
                           			current, 
                           			"call1",
                            		lv_call1_3_0, 
                            		"RuleCallsAss1", 
                            		currentNode);
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:357:3: ( (lv_call2_4_0= ruleRuleCallsAss2 ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:358:1: (lv_call2_4_0= ruleRuleCallsAss2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:358:1: (lv_call2_4_0= ruleRuleCallsAss2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:359:3: lv_call2_4_0= ruleRuleCallsAss2
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRuleCallsAccess().getCall2RuleCallsAss2ParserRuleCall_4_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss2_in_ruleRuleCalls730);
                    lv_call2_4_0=ruleRuleCallsAss2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRuleCallsRule());
                    	        }
                           		set(
                           			current, 
                           			"call2",
                            		lv_call2_4_0, 
                            		"RuleCallsAss2", 
                            		currentNode);
                    	        afterParserOrEnumRuleCall();
                    	    

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
    // $ANTLR end "ruleRuleCalls"


    // $ANTLR start "entryRuleRuleCallsSub"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:384:1: entryRuleRuleCallsSub returns [EObject current=null] : iv_ruleRuleCallsSub= ruleRuleCallsSub EOF ;
    public final EObject entryRuleRuleCallsSub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallsSub = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:385:2: (iv_ruleRuleCallsSub= ruleRuleCallsSub EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:386:2: iv_ruleRuleCallsSub= ruleRuleCallsSub EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallsSubRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsSub_in_entryRuleRuleCallsSub767);
            iv_ruleRuleCallsSub=ruleRuleCallsSub();

            state._fsp--;

             current =iv_ruleRuleCallsSub; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallsSub777); 

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
    // $ANTLR end "entryRuleRuleCallsSub"


    // $ANTLR start "ruleRuleCallsSub"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:393:1: ruleRuleCallsSub returns [EObject current=null] : ( (lv_sub_0_0= 'sub' ) ) ;
    public final EObject ruleRuleCallsSub() throws RecognitionException {
        EObject current = null;

        Token lv_sub_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:398:6: ( ( (lv_sub_0_0= 'sub' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:399:1: ( (lv_sub_0_0= 'sub' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:399:1: ( (lv_sub_0_0= 'sub' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:400:1: (lv_sub_0_0= 'sub' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:400:1: (lv_sub_0_0= 'sub' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:401:3: lv_sub_0_0= 'sub'
            {
            lv_sub_0_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleRuleCallsSub819); 

                    createLeafNode(lv_sub_0_0, grammarAccess.getRuleCallsSubAccess().getSubSubKeyword_0(), "sub");
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleCallsSubRule());
            	        }
                   		set(current, "sub", lv_sub_0_0, "sub", lastConsumedNode);
            	    

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
    // $ANTLR end "ruleRuleCallsSub"


    // $ANTLR start "entryRuleRuleCallsAss1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:422:1: entryRuleRuleCallsAss1 returns [EObject current=null] : iv_ruleRuleCallsAss1= ruleRuleCallsAss1 EOF ;
    public final EObject entryRuleRuleCallsAss1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallsAss1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:423:2: (iv_ruleRuleCallsAss1= ruleRuleCallsAss1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:424:2: iv_ruleRuleCallsAss1= ruleRuleCallsAss1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallsAss1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss1_in_entryRuleRuleCallsAss1867);
            iv_ruleRuleCallsAss1=ruleRuleCallsAss1();

            state._fsp--;

             current =iv_ruleRuleCallsAss1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallsAss1877); 

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
    // $ANTLR end "entryRuleRuleCallsAss1"


    // $ANTLR start "ruleRuleCallsAss1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:431:1: ruleRuleCallsAss1 returns [EObject current=null] : (otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleRuleCallsAss1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:436:6: ( (otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:437:1: (otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:437:1: (otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:437:3: otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleRuleCallsAss1914); 

                	createLeafNode(otherlv_0, grammarAccess.getRuleCallsAss1Access().getAss1Keyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:441:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:442:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:442:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:443:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCallsAss1931); 

            			createLeafNode(lv_name_1_0, grammarAccess.getRuleCallsAss1Access().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleCallsAss1Rule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID", 
                    		lastConsumedNode);
            	    

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
    // $ANTLR end "ruleRuleCallsAss1"


    // $ANTLR start "entryRuleRuleCallsAss2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:468:1: entryRuleRuleCallsAss2 returns [EObject current=null] : iv_ruleRuleCallsAss2= ruleRuleCallsAss2 EOF ;
    public final EObject entryRuleRuleCallsAss2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallsAss2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:469:2: (iv_ruleRuleCallsAss2= ruleRuleCallsAss2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:470:2: iv_ruleRuleCallsAss2= ruleRuleCallsAss2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRuleCallsAss2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss2_in_entryRuleRuleCallsAss2972);
            iv_ruleRuleCallsAss2=ruleRuleCallsAss2();

            state._fsp--;

             current =iv_ruleRuleCallsAss2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallsAss2982); 

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
    // $ANTLR end "entryRuleRuleCallsAss2"


    // $ANTLR start "ruleRuleCallsAss2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:477:1: ruleRuleCallsAss2 returns [EObject current=null] : (otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleRuleCallsAss2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:482:6: ( (otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:483:1: (otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:483:1: (otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:483:3: otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleRuleCallsAss21019); 

                	createLeafNode(otherlv_0, grammarAccess.getRuleCallsAss2Access().getAss2Keyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:487:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:488:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:488:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:489:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCallsAss21036); 

            			createLeafNode(lv_name_1_0, grammarAccess.getRuleCallsAss2Access().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleCallsAss2Rule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID", 
                    		lastConsumedNode);
            	    

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
    // $ANTLR end "ruleRuleCallsAss2"


    // $ANTLR start "entryRuleOptionalCalls"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:514:1: entryRuleOptionalCalls returns [EObject current=null] : iv_ruleOptionalCalls= ruleOptionalCalls EOF ;
    public final EObject entryRuleOptionalCalls() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalCalls = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:515:2: (iv_ruleOptionalCalls= ruleOptionalCalls EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:516:2: iv_ruleOptionalCalls= ruleOptionalCalls EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOptionalCallsRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCalls_in_entryRuleOptionalCalls1077);
            iv_ruleOptionalCalls=ruleOptionalCalls();

            state._fsp--;

             current =iv_ruleOptionalCalls; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCalls1087); 

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
    // $ANTLR end "entryRuleOptionalCalls"


    // $ANTLR start "ruleOptionalCalls"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:523:1: ruleOptionalCalls returns [EObject current=null] : (otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleOptionalCalls() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_3_0=null;
        EObject lv_opt1_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:528:6: ( (otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:529:1: (otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:529:1: (otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:529:3: otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOptionalCalls1124); 

                	createLeafNode(otherlv_0, grammarAccess.getOptionalCallsAccess().getNumberSignDigitThreeKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:533:1: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:534:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getOptionalCallsAccess().getOptionalCallsAction_1(),
                        current);
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:539:2: ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15||LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:540:1: (lv_opt1_2_0= ruleOptionalCallsSub1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:540:1: (lv_opt1_2_0= ruleOptionalCallsSub1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:541:3: lv_opt1_2_0= ruleOptionalCallsSub1
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOptionalCallsAccess().getOpt1OptionalCallsSub1ParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub1_in_ruleOptionalCalls1154);
                    lv_opt1_2_0=ruleOptionalCallsSub1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOptionalCallsRule());
                    	        }
                           		set(
                           			current, 
                           			"opt1",
                            		lv_opt1_2_0, 
                            		"OptionalCallsSub1", 
                            		currentNode);
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:558:3: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:559:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:559:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:560:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalCalls1172); 

            			createLeafNode(lv_name_3_0, grammarAccess.getOptionalCallsAccess().getNameIDTerminalRuleCall_3_0(), "name"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOptionalCallsRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"ID", 
                    		lastConsumedNode);
            	    

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
    // $ANTLR end "ruleOptionalCalls"


    // $ANTLR start "entryRuleOptionalCallsSub1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:585:1: entryRuleOptionalCallsSub1 returns [EObject current=null] : iv_ruleOptionalCallsSub1= ruleOptionalCallsSub1 EOF ;
    public final EObject entryRuleOptionalCallsSub1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalCallsSub1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:586:2: (iv_ruleOptionalCallsSub1= ruleOptionalCallsSub1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:587:2: iv_ruleOptionalCallsSub1= ruleOptionalCallsSub1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOptionalCallsSub1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub1_in_entryRuleOptionalCallsSub11213);
            iv_ruleOptionalCallsSub1=ruleOptionalCallsSub1();

            state._fsp--;

             current =iv_ruleOptionalCallsSub1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCallsSub11223); 

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
    // $ANTLR end "entryRuleOptionalCallsSub1"


    // $ANTLR start "ruleOptionalCallsSub1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:594:1: ruleOptionalCallsSub1 returns [EObject current=null] : ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? ) ;
    public final EObject ruleOptionalCallsSub1() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_opt2_1_0 = null;

        EObject lv_opt3_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:599:6: ( ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:600:1: ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:600:1: ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:600:2: () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:600:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:601:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getOptionalCallsSub1Access().getOptionalCallsSub1Action_0(),
                        current);
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:606:2: ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:607:1: (lv_opt2_1_0= ruleOptionalCallsSub2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:607:1: (lv_opt2_1_0= ruleOptionalCallsSub2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:608:3: lv_opt2_1_0= ruleOptionalCallsSub2
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOptionalCallsSub1Access().getOpt2OptionalCallsSub2ParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub2_in_ruleOptionalCallsSub11278);
                    lv_opt2_1_0=ruleOptionalCallsSub2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOptionalCallsSub1Rule());
                    	        }
                           		set(
                           			current, 
                           			"opt2",
                            		lv_opt2_1_0, 
                            		"OptionalCallsSub2", 
                            		currentNode);
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOptionalCallsSub11291); 

                	createLeafNode(otherlv_2, grammarAccess.getOptionalCallsSub1Access().getSubKeyword_2(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:629:1: ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:630:1: (lv_opt3_3_0= ruleOptionalCallsSub3 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:630:1: (lv_opt3_3_0= ruleOptionalCallsSub3 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:631:3: lv_opt3_3_0= ruleOptionalCallsSub3
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOptionalCallsSub1Access().getOpt3OptionalCallsSub3ParserRuleCall_3_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub3_in_ruleOptionalCallsSub11312);
                    lv_opt3_3_0=ruleOptionalCallsSub3();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOptionalCallsSub1Rule());
                    	        }
                           		set(
                           			current, 
                           			"opt3",
                            		lv_opt3_3_0, 
                            		"OptionalCallsSub3", 
                            		currentNode);
                    	        afterParserOrEnumRuleCall();
                    	    

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
    // $ANTLR end "ruleOptionalCallsSub1"


    // $ANTLR start "entryRuleOptionalCallsSub2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:656:1: entryRuleOptionalCallsSub2 returns [EObject current=null] : iv_ruleOptionalCallsSub2= ruleOptionalCallsSub2 EOF ;
    public final EObject entryRuleOptionalCallsSub2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalCallsSub2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:657:2: (iv_ruleOptionalCallsSub2= ruleOptionalCallsSub2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:658:2: iv_ruleOptionalCallsSub2= ruleOptionalCallsSub2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOptionalCallsSub2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub2_in_entryRuleOptionalCallsSub21349);
            iv_ruleOptionalCallsSub2=ruleOptionalCallsSub2();

            state._fsp--;

             current =iv_ruleOptionalCallsSub2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCallsSub21359); 

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
    // $ANTLR end "entryRuleOptionalCallsSub2"


    // $ANTLR start "ruleOptionalCallsSub2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:665:1: ruleOptionalCallsSub2 returns [EObject current=null] : (otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleOptionalCallsSub2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:670:6: ( (otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:671:1: (otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:671:1: (otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:671:3: otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleOptionalCallsSub21396); 

                	createLeafNode(otherlv_0, grammarAccess.getOptionalCallsSub2Access().getSub2Keyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:675:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:676:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:676:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:677:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalCallsSub21413); 

            			createLeafNode(lv_name_1_0, grammarAccess.getOptionalCallsSub2Access().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOptionalCallsSub2Rule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID", 
                    		lastConsumedNode);
            	    

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
    // $ANTLR end "ruleOptionalCallsSub2"


    // $ANTLR start "entryRuleOptionalCallsSub3"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:702:1: entryRuleOptionalCallsSub3 returns [EObject current=null] : iv_ruleOptionalCallsSub3= ruleOptionalCallsSub3 EOF ;
    public final EObject entryRuleOptionalCallsSub3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalCallsSub3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:703:2: (iv_ruleOptionalCallsSub3= ruleOptionalCallsSub3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:704:2: iv_ruleOptionalCallsSub3= ruleOptionalCallsSub3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOptionalCallsSub3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub3_in_entryRuleOptionalCallsSub31454);
            iv_ruleOptionalCallsSub3=ruleOptionalCallsSub3();

            state._fsp--;

             current =iv_ruleOptionalCallsSub3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCallsSub31464); 

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
    // $ANTLR end "entryRuleOptionalCallsSub3"


    // $ANTLR start "ruleOptionalCallsSub3"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:711:1: ruleOptionalCallsSub3 returns [EObject current=null] : (otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleOptionalCallsSub3() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:716:6: ( (otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:717:1: (otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:717:1: (otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:717:3: otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleOptionalCallsSub31501); 

                	createLeafNode(otherlv_0, grammarAccess.getOptionalCallsSub3Access().getSub3Keyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:721:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:722:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:722:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:723:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalCallsSub31518); 

            			createLeafNode(lv_name_1_0, grammarAccess.getOptionalCallsSub3Access().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOptionalCallsSub3Rule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID", 
                    		lastConsumedNode);
            	    

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
    // $ANTLR end "ruleOptionalCallsSub3"


    // $ANTLR start "entryRuleRecursion"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:748:1: entryRuleRecursion returns [EObject current=null] : iv_ruleRecursion= ruleRecursion EOF ;
    public final EObject entryRuleRecursion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecursion = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:749:2: (iv_ruleRecursion= ruleRecursion EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:750:2: iv_ruleRecursion= ruleRecursion EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRecursionRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRecursion_in_entryRuleRecursion1559);
            iv_ruleRecursion=ruleRecursion();

            state._fsp--;

             current =iv_ruleRecursion; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRecursion1569); 

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
    // $ANTLR end "entryRuleRecursion"


    // $ANTLR start "ruleRecursion"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:757:1: ruleRecursion returns [EObject current=null] : (otherlv_0= '#4' this_RecursionSub_1= ruleRecursionSub ) ;
    public final EObject ruleRecursion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_RecursionSub_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:762:6: ( (otherlv_0= '#4' this_RecursionSub_1= ruleRecursionSub ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:763:1: (otherlv_0= '#4' this_RecursionSub_1= ruleRecursionSub )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:763:1: (otherlv_0= '#4' this_RecursionSub_1= ruleRecursionSub )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:763:3: otherlv_0= '#4' this_RecursionSub_1= ruleRecursionSub
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleRecursion1606); 

                	createLeafNode(otherlv_0, grammarAccess.getRecursionAccess().getNumberSignDigitFourKeyword_0(), null);
                
             
                    currentNode=createCompositeNode(grammarAccess.getRecursionAccess().getRecursionSubParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRecursionSub_in_ruleRecursion1628);
            this_RecursionSub_1=ruleRecursionSub();

            state._fsp--;

             
                    current = this_RecursionSub_1; 
                    // currentNode = currentNode.getParent();
                    afterParserOrEnumRuleCall();
                

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
    // $ANTLR end "ruleRecursion"


    // $ANTLR start "entryRuleRecursionSub"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:785:1: entryRuleRecursionSub returns [EObject current=null] : iv_ruleRecursionSub= ruleRecursionSub EOF ;
    public final EObject entryRuleRecursionSub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecursionSub = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:786:2: (iv_ruleRecursionSub= ruleRecursionSub EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:787:2: iv_ruleRecursionSub= ruleRecursionSub EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRecursionSubRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRecursionSub_in_entryRuleRecursionSub1663);
            iv_ruleRecursionSub=ruleRecursionSub();

            state._fsp--;

             current =iv_ruleRecursionSub; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRecursionSub1673); 

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
    // $ANTLR end "entryRuleRecursionSub"


    // $ANTLR start "ruleRecursionSub"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:794:1: ruleRecursionSub returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? ) ;
    public final EObject ruleRecursionSub() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_vals_3_0=null;
        Token otherlv_4=null;
        Token lv_semi_5_0=null;
        EObject lv_sub_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:799:6: ( ( () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:800:1: ( () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:800:1: ( () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:800:2: () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:800:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:801:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRecursionSubAccess().getRecursionSubAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleRecursionSub1719); 

                	createLeafNode(otherlv_1, grammarAccess.getRecursionSubAccess().getLeftCurlyBracketKeyword_1(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:810:1: ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:810:2: ( (lv_sub_2_0= ruleRecursionSub ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:810:2: ( (lv_sub_2_0= ruleRecursionSub ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:811:1: (lv_sub_2_0= ruleRecursionSub )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:811:1: (lv_sub_2_0= ruleRecursionSub )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:812:3: lv_sub_2_0= ruleRecursionSub
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRecursionSubAccess().getSubRecursionSubParserRuleCall_2_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRecursionSub_in_ruleRecursionSub1741);
            	    lv_sub_2_0=ruleRecursionSub();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRecursionSubRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"sub",
            	            		lv_sub_2_0, 
            	            		"RecursionSub", 
            	            		currentNode);
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:830:6: ( (lv_vals_3_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:830:6: ( (lv_vals_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:831:1: (lv_vals_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:831:1: (lv_vals_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:832:3: lv_vals_3_0= RULE_ID
            	    {
            	    lv_vals_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRecursionSub1764); 

            	    			createLeafNode(lv_vals_3_0, grammarAccess.getRecursionSubAccess().getValsIDTerminalRuleCall_2_1_0(), "vals"); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRecursionSubRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"vals",
            	            		lv_vals_3_0, 
            	            		"ID", 
            	            		lastConsumedNode);
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleRecursionSub1783); 

                	createLeafNode(otherlv_4, grammarAccess.getRecursionSubAccess().getRightCurlyBracketKeyword_3(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:853:1: ( (lv_semi_5_0= ';' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:854:1: (lv_semi_5_0= ';' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:854:1: (lv_semi_5_0= ';' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:855:3: lv_semi_5_0= ';'
                    {
                    lv_semi_5_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleRecursionSub1801); 

                            createLeafNode(lv_semi_5_0, grammarAccess.getRecursionSubAccess().getSemiSemicolonKeyword_4_0(), "semi");
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getRecursionSubRule());
                    	        }
                           		set(current, "semi", true, ";", lastConsumedNode);
                    	    

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
    // $ANTLR end "ruleRecursionSub"


    // $ANTLR start "entryRuleLoop"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:876:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:877:2: (iv_ruleLoop= ruleLoop EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:878:2: iv_ruleLoop= ruleLoop EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLoopRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLoop_in_entryRuleLoop1851);
            iv_ruleLoop=ruleLoop();

            state._fsp--;

             current =iv_ruleLoop; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoop1861); 

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
    // $ANTLR end "entryRuleLoop"


    // $ANTLR start "ruleLoop"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:885:1: ruleLoop returns [EObject current=null] : (otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* ) ;
    public final EObject ruleLoop() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_names_1_0=null;
        Token otherlv_2=null;
        Token lv_gr_3_0=null;
        Token lv_ints_4_0=null;
        Token lv_strings_5_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:890:6: ( (otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:891:1: (otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:891:1: (otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:891:3: otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )*
            {
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleLoop1898); 

                	createLeafNode(otherlv_0, grammarAccess.getLoopAccess().getNumberSignDigitFiveKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:895:1: ( (lv_names_1_0= RULE_ID ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:896:1: (lv_names_1_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:896:1: (lv_names_1_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:897:3: lv_names_1_0= RULE_ID
            	    {
            	    lv_names_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop1915); 

            	    			createLeafNode(lv_names_1_0, grammarAccess.getLoopAccess().getNamesIDTerminalRuleCall_1_0(), "names"); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getLoopRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"names",
            	            		lv_names_1_0, 
            	            		"ID", 
            	            		lastConsumedNode);
            	    	    

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:914:3: (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==26) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:914:5: otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleLoop1934); 

            	        	createLeafNode(otherlv_2, grammarAccess.getLoopAccess().getGrKeyword_2_0(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:918:1: ( (lv_gr_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:919:1: (lv_gr_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:919:1: (lv_gr_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:920:3: lv_gr_3_0= RULE_ID
            	    {
            	    lv_gr_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop1951); 

            	    			createLeafNode(lv_gr_3_0, grammarAccess.getLoopAccess().getGrIDTerminalRuleCall_2_1_0(), "gr"); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getLoopRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"gr",
            	            		lv_gr_3_0, 
            	            		"ID", 
            	            		lastConsumedNode);
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:937:4: ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:937:5: ( (lv_ints_4_0= RULE_INT ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:937:5: ( (lv_ints_4_0= RULE_INT ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:938:1: (lv_ints_4_0= RULE_INT )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:938:1: (lv_ints_4_0= RULE_INT )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:939:3: lv_ints_4_0= RULE_INT
            	    {
            	    lv_ints_4_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLoop1976); 

            	    			createLeafNode(lv_ints_4_0, grammarAccess.getLoopAccess().getIntsINTTerminalRuleCall_3_0_0(), "ints"); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getLoopRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"ints",
            	            		lv_ints_4_0, 
            	            		"INT", 
            	            		lastConsumedNode);
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:957:6: ( (lv_strings_5_0= RULE_STRING ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:957:6: ( (lv_strings_5_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:958:1: (lv_strings_5_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:958:1: (lv_strings_5_0= RULE_STRING )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:959:3: lv_strings_5_0= RULE_STRING
            	    {
            	    lv_strings_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleLoop2004); 

            	    			createLeafNode(lv_strings_5_0, grammarAccess.getLoopAccess().getStringsSTRINGTerminalRuleCall_3_1_0(), "strings"); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getLoopRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"strings",
            	            		lv_strings_5_0, 
            	            		"STRING", 
            	            		lastConsumedNode);
            	    	    

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
    // $ANTLR end "ruleLoop"


    // $ANTLR start "entryRuleExpression"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:984:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:985:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:986:2: iv_ruleExpression= ruleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_entryRuleExpression2047);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression2057); 

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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:993:1: ruleExpression returns [EObject current=null] : (otherlv_0= '#6' this_Add_1= ruleAdd ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Add_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:998:6: ( (otherlv_0= '#6' this_Add_1= ruleAdd ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:999:1: (otherlv_0= '#6' this_Add_1= ruleAdd )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:999:1: (otherlv_0= '#6' this_Add_1= ruleAdd )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:999:3: otherlv_0= '#6' this_Add_1= ruleAdd
            {
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleExpression2094); 

                	createLeafNode(otherlv_0, grammarAccess.getExpressionAccess().getNumberSignDigitSixKeyword_0(), null);
                
             
                    currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getAddParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAdd_in_ruleExpression2116);
            this_Add_1=ruleAdd();

            state._fsp--;

             
                    current = this_Add_1; 
                    // currentNode = currentNode.getParent();
                    afterParserOrEnumRuleCall();
                

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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAdd"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1021:1: entryRuleAdd returns [EObject current=null] : iv_ruleAdd= ruleAdd EOF ;
    public final EObject entryRuleAdd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdd = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1022:2: (iv_ruleAdd= ruleAdd EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1023:2: iv_ruleAdd= ruleAdd EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAddRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAdd_in_entryRuleAdd2151);
            iv_ruleAdd=ruleAdd();

            state._fsp--;

             current =iv_ruleAdd; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAdd2161); 

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
    // $ANTLR end "entryRuleAdd"


    // $ANTLR start "ruleAdd"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1030:1: ruleAdd returns [EObject current=null] : (this_Mult_0= ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )* ) ;
    public final EObject ruleAdd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Mult_0 = null;

        EObject lv_right_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1035:6: ( (this_Mult_0= ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1036:1: (this_Mult_0= ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1036:1: (this_Mult_0= ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1037:5: this_Mult_0= ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAddAccess().getMultParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleMult_in_ruleAdd2208);
            this_Mult_0=ruleMult();

            state._fsp--;

             
                    current = this_Mult_0; 
                    // currentNode = currentNode.getParent();
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1046:1: ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==28) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1046:2: () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1046:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1047:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAddAccess().getAddLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleAdd2229); 

            	        	createLeafNode(otherlv_2, grammarAccess.getAddAccess().getPlusSignKeyword_1_1(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1056:1: ( (lv_right_3_0= ruleMult ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1057:1: (lv_right_3_0= ruleMult )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1057:1: (lv_right_3_0= ruleMult )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1058:3: lv_right_3_0= ruleMult
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAddAccess().getRightMultParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleMult_in_ruleAdd2250);
            	    lv_right_3_0=ruleMult();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAddRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"Mult", 
            	            		currentNode);
            	    	        afterParserOrEnumRuleCall();
            	    	    

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
    // $ANTLR end "ruleAdd"


    // $ANTLR start "entryRuleMult"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1083:1: entryRuleMult returns [EObject current=null] : iv_ruleMult= ruleMult EOF ;
    public final EObject entryRuleMult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMult = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1084:2: (iv_ruleMult= ruleMult EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1085:2: iv_ruleMult= ruleMult EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMult_in_entryRuleMult2288);
            iv_ruleMult=ruleMult();

            state._fsp--;

             current =iv_ruleMult; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMult2298); 

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
    // $ANTLR end "entryRuleMult"


    // $ANTLR start "ruleMult"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1092:1: ruleMult returns [EObject current=null] : (this_Prim_0= rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )* ) ;
    public final EObject ruleMult() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Prim_0 = null;

        EObject lv_right_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1097:6: ( (this_Prim_0= rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1098:1: (this_Prim_0= rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1098:1: (this_Prim_0= rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1099:5: this_Prim_0= rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getMultAccess().getPrimParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_rulePrim_in_ruleMult2345);
            this_Prim_0=rulePrim();

            state._fsp--;

             
                    current = this_Prim_0; 
                    // currentNode = currentNode.getParent();
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1108:1: ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==29) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1108:2: () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1108:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1109:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getMultAccess().getMultLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleMult2366); 

            	        	createLeafNode(otherlv_2, grammarAccess.getMultAccess().getAsteriskKeyword_1_1(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1118:1: ( (lv_right_3_0= rulePrim ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1119:1: (lv_right_3_0= rulePrim )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1119:1: (lv_right_3_0= rulePrim )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1120:3: lv_right_3_0= rulePrim
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMultAccess().getRightPrimParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_rulePrim_in_ruleMult2387);
            	    lv_right_3_0=rulePrim();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMultRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"Prim", 
            	            		currentNode);
            	    	        afterParserOrEnumRuleCall();
            	    	    

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
    // $ANTLR end "ruleMult"


    // $ANTLR start "entryRulePrim"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1145:1: entryRulePrim returns [EObject current=null] : iv_rulePrim= rulePrim EOF ;
    public final EObject entryRulePrim() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrim = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1146:2: (iv_rulePrim= rulePrim EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1147:2: iv_rulePrim= rulePrim EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_rulePrim_in_entryRulePrim2425);
            iv_rulePrim=rulePrim();

            state._fsp--;

             current =iv_rulePrim; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrim2435); 

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
    // $ANTLR end "entryRulePrim"


    // $ANTLR start "rulePrim"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1154:1: rulePrim returns [EObject current=null] : ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' ) | ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) ) | (otherlv_12= '(' this_Add_13= ruleAdd otherlv_14= ')' ) ) ;
    public final EObject rulePrim() throws RecognitionException {
        EObject current = null;

        Token lv_val_1_0=null;
        Token lv_func_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        EObject lv_param_5_0 = null;

        EObject lv_param_7_0 = null;

        EObject lv_target_11_0 = null;

        EObject this_Add_13 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1159:6: ( ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' ) | ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) ) | (otherlv_12= '(' this_Add_13= ruleAdd otherlv_14= ')' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1160:1: ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' ) | ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) ) | (otherlv_12= '(' this_Add_13= ruleAdd otherlv_14= ')' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1160:1: ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' ) | ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) ) | (otherlv_12= '(' this_Add_13= ruleAdd otherlv_14= ')' ) )
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
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1160:2: ( () ( (lv_val_1_0= RULE_INT ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1160:2: ( () ( (lv_val_1_0= RULE_INT ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1160:3: () ( (lv_val_1_0= RULE_INT ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1160:3: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1161:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrimAccess().getValueAction_0_0(),
                                current);
                        

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1166:2: ( (lv_val_1_0= RULE_INT ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1167:1: (lv_val_1_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1167:1: (lv_val_1_0= RULE_INT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1168:3: lv_val_1_0= RULE_INT
                    {
                    lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rulePrim2487); 

                    			createLeafNode(lv_val_1_0, grammarAccess.getPrimAccess().getValINTTerminalRuleCall_0_1_0(), "val"); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPrimRule());
                    	        }
                           		set(
                           			current, 
                           			"val",
                            		lv_val_1_0, 
                            		"INT", 
                            		lastConsumedNode);
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1186:6: ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1186:6: ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1186:7: () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')'
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1186:7: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1187:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrimAccess().getFunctionAction_1_0(),
                                current);
                        

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1192:2: ( (lv_func_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1193:1: (lv_func_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1193:1: (lv_func_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1194:3: lv_func_3_0= RULE_ID
                    {
                    lv_func_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePrim2526); 

                    			createLeafNode(lv_func_3_0, grammarAccess.getPrimAccess().getFuncIDTerminalRuleCall_1_1_0(), "func"); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPrimRule());
                    	        }
                           		set(
                           			current, 
                           			"func",
                            		lv_func_3_0, 
                            		"ID", 
                            		lastConsumedNode);
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,30,FollowSets000.FOLLOW_30_in_rulePrim2543); 

                        	createLeafNode(otherlv_4, grammarAccess.getPrimAccess().getLeftParenthesisKeyword_1_2(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1215:1: ( (lv_param_5_0= ruleAdd ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1216:1: (lv_param_5_0= ruleAdd )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1216:1: (lv_param_5_0= ruleAdd )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1217:3: lv_param_5_0= ruleAdd
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPrimAccess().getParamAddParserRuleCall_1_3_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAdd_in_rulePrim2564);
                    lv_param_5_0=ruleAdd();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPrimRule());
                    	        }
                           		add(
                           			current, 
                           			"param",
                            		lv_param_5_0, 
                            		"Add", 
                            		currentNode);
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1234:2: (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==31) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1234:4: otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) )
                    	    {
                    	    otherlv_6=(Token)match(input,31,FollowSets000.FOLLOW_31_in_rulePrim2577); 

                    	        	createLeafNode(otherlv_6, grammarAccess.getPrimAccess().getCommaKeyword_1_4_0(), null);
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1238:1: ( (lv_param_7_0= ruleAdd ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1239:1: (lv_param_7_0= ruleAdd )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1239:1: (lv_param_7_0= ruleAdd )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1240:3: lv_param_7_0= ruleAdd
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getPrimAccess().getParamAddParserRuleCall_1_4_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAdd_in_rulePrim2598);
                    	    lv_param_7_0=ruleAdd();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getPrimRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"param",
                    	            		lv_param_7_0, 
                    	            		"Add", 
                    	            		currentNode);
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,32,FollowSets000.FOLLOW_32_in_rulePrim2612); 

                        	createLeafNode(otherlv_8, grammarAccess.getPrimAccess().getRightParenthesisKeyword_1_5(), null);
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1262:6: ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1262:6: ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1262:7: () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1262:7: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1263:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrimAccess().getPointerAction_2_0(),
                                current);
                        

                    }

                    otherlv_10=(Token)match(input,33,FollowSets000.FOLLOW_33_in_rulePrim2641); 

                        	createLeafNode(otherlv_10, grammarAccess.getPrimAccess().getEqualsSignGreaterThanSignKeyword_2_1(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1272:1: ( (lv_target_11_0= rulePrim ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1273:1: (lv_target_11_0= rulePrim )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1273:1: (lv_target_11_0= rulePrim )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1274:3: lv_target_11_0= rulePrim
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPrimAccess().getTargetPrimParserRuleCall_2_2_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_rulePrim_in_rulePrim2662);
                    lv_target_11_0=rulePrim();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPrimRule());
                    	        }
                           		set(
                           			current, 
                           			"target",
                            		lv_target_11_0, 
                            		"Prim", 
                            		currentNode);
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1292:6: (otherlv_12= '(' this_Add_13= ruleAdd otherlv_14= ')' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1292:6: (otherlv_12= '(' this_Add_13= ruleAdd otherlv_14= ')' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1292:8: otherlv_12= '(' this_Add_13= ruleAdd otherlv_14= ')'
                    {
                    otherlv_12=(Token)match(input,30,FollowSets000.FOLLOW_30_in_rulePrim2682); 

                        	createLeafNode(otherlv_12, grammarAccess.getPrimAccess().getLeftParenthesisKeyword_3_0(), null);
                        
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimAccess().getAddParserRuleCall_3_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAdd_in_rulePrim2704);
                    this_Add_13=ruleAdd();

                    state._fsp--;

                     
                            current = this_Add_13; 
                            // currentNode = currentNode.getParent();
                            afterParserOrEnumRuleCall();
                        
                    otherlv_14=(Token)match(input,32,FollowSets000.FOLLOW_32_in_rulePrim2715); 

                        	createLeafNode(otherlv_14, grammarAccess.getPrimAccess().getRightParenthesisKeyword_3_2(), null);
                        

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
    // $ANTLR end "rulePrim"

    // Delegated rules


 

    
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
        public static final BitSet FOLLOW_11_in_ruleSimple349 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimple366 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleSimple384 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimple401 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleSimple429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN466 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN517 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleFQN536 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN551 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCalls_in_entryRuleRuleCalls597 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCalls607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleRuleCalls644 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleRuleCallsSub_in_ruleRuleCalls666 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCalls682 = new BitSet(new long[]{0x0000000000030002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss1_in_ruleRuleCalls708 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss2_in_ruleRuleCalls730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallsSub_in_entryRuleRuleCallsSub767 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallsSub777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleRuleCallsSub819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss1_in_entryRuleRuleCallsAss1867 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallsAss1877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleRuleCallsAss1914 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallsAss1931 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss2_in_entryRuleRuleCallsAss2972 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallsAss2982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleRuleCallsAss21019 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallsAss21036 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCalls_in_entryRuleOptionalCalls1077 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCalls1087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleOptionalCalls1124 = new BitSet(new long[]{0x0000000000088010L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub1_in_ruleOptionalCalls1154 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalCalls1172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub1_in_entryRuleOptionalCallsSub11213 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCallsSub11223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub2_in_ruleOptionalCallsSub11278 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleOptionalCallsSub11291 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub3_in_ruleOptionalCallsSub11312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub2_in_entryRuleOptionalCallsSub21349 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCallsSub21359 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleOptionalCallsSub21396 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalCallsSub21413 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub3_in_entryRuleOptionalCallsSub31454 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCallsSub31464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleOptionalCallsSub31501 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalCallsSub31518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecursion_in_entryRuleRecursion1559 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRecursion1569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleRecursion1606 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_ruleRecursionSub_in_ruleRecursion1628 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecursionSub_in_entryRuleRecursionSub1663 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRecursionSub1673 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleRecursionSub1719 = new BitSet(new long[]{0x0000000000C00010L});
        public static final BitSet FOLLOW_ruleRecursionSub_in_ruleRecursionSub1741 = new BitSet(new long[]{0x0000000000C00010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRecursionSub1764 = new BitSet(new long[]{0x0000000000C00010L});
        public static final BitSet FOLLOW_23_in_ruleRecursionSub1783 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_24_in_ruleRecursionSub1801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop_in_entryRuleLoop1851 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoop1861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleLoop1898 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop1915 = new BitSet(new long[]{0x0000000004000072L});
        public static final BitSet FOLLOW_26_in_ruleLoop1934 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop1951 = new BitSet(new long[]{0x0000000004000062L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLoop1976 = new BitSet(new long[]{0x0000000000000062L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleLoop2004 = new BitSet(new long[]{0x0000000000000062L});
        public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression2047 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression2057 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleExpression2094 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleAdd_in_ruleExpression2116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAdd_in_entryRuleAdd2151 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAdd2161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMult_in_ruleAdd2208 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_28_in_ruleAdd2229 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleMult_in_ruleAdd2250 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_ruleMult_in_entryRuleMult2288 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMult2298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrim_in_ruleMult2345 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleMult2366 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_rulePrim_in_ruleMult2387 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rulePrim_in_entryRulePrim2425 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrim2435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rulePrim2487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePrim2526 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_rulePrim2543 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleAdd_in_rulePrim2564 = new BitSet(new long[]{0x0000000180000000L});
        public static final BitSet FOLLOW_31_in_rulePrim2577 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleAdd_in_rulePrim2598 = new BitSet(new long[]{0x0000000180000000L});
        public static final BitSet FOLLOW_32_in_rulePrim2612 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rulePrim2641 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_rulePrim_in_rulePrim2662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rulePrim2682 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleAdd_in_rulePrim2704 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_rulePrim2715 = new BitSet(new long[]{0x0000000000000002L});
    }


}