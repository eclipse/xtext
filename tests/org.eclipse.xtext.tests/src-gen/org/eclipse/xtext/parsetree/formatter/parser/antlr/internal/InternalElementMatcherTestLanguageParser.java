package org.eclipse.xtext.parsetree.formatter.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parsetree.formatter.services.ElementMatcherTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalElementMatcherTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'kw1'", "'.'", "'#2'", "'sub'", "'ass1'", "'ass2'", "'#3'", "'sub2'", "'sub3'", "'#4'", "'{'", "'}'", "';'", "'#5'", "'gr'", "'#6'", "'+'", "'*'", "'('", "','", "')'", "'=>'", "'#7'", "'kw3'", "'kw2'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__35=35;
    public static final int RULE_ID=4;
    public static final int T__12=12;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int T__36=36;
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
    public static final int T__34=34;
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
     	
        public InternalElementMatcherTestLanguageParser(TokenStream input, ElementMatcherTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:76:1: ruleModel returns [EObject current=null] : (this_Simple_0= ruleSimple | this_RuleCalls_1= ruleRuleCalls | this_OptionalCalls_2= ruleOptionalCalls | this_Recursion_3= ruleRecursion | this_Loop_4= ruleLoop | this_Expression_5= ruleExpression | this_RuleCalls12_6= ruleRuleCalls12 ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_Simple_0 = null;

        EObject this_RuleCalls_1 = null;

        EObject this_OptionalCalls_2 = null;

        EObject this_Recursion_3 = null;

        EObject this_Loop_4 = null;

        EObject this_Expression_5 = null;

        EObject this_RuleCalls12_6 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:79:28: ( (this_Simple_0= ruleSimple | this_RuleCalls_1= ruleRuleCalls | this_OptionalCalls_2= ruleOptionalCalls | this_Recursion_3= ruleRecursion | this_Loop_4= ruleLoop | this_Expression_5= ruleExpression | this_RuleCalls12_6= ruleRuleCalls12 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:80:1: (this_Simple_0= ruleSimple | this_RuleCalls_1= ruleRuleCalls | this_OptionalCalls_2= ruleOptionalCalls | this_Recursion_3= ruleRecursion | this_Loop_4= ruleLoop | this_Expression_5= ruleExpression | this_RuleCalls12_6= ruleRuleCalls12 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:80:1: (this_Simple_0= ruleSimple | this_RuleCalls_1= ruleRuleCalls | this_OptionalCalls_2= ruleOptionalCalls | this_Recursion_3= ruleRecursion | this_Loop_4= ruleLoop | this_Expression_5= ruleExpression | this_RuleCalls12_6= ruleRuleCalls12 )
            int alt1=7;
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
            case 34:
                {
                alt1=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:81:5: this_Simple_0= ruleSimple
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getSimpleParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSimple_in_ruleModel132);
                    this_Simple_0=ruleSimple();

                    state._fsp--;

                     
                            current = this_Simple_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:91:5: this_RuleCalls_1= ruleRuleCalls
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getRuleCallsParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCalls_in_ruleModel159);
                    this_RuleCalls_1=ruleRuleCalls();

                    state._fsp--;

                     
                            current = this_RuleCalls_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:101:5: this_OptionalCalls_2= ruleOptionalCalls
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getOptionalCallsParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalCalls_in_ruleModel186);
                    this_OptionalCalls_2=ruleOptionalCalls();

                    state._fsp--;

                     
                            current = this_OptionalCalls_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:111:5: this_Recursion_3= ruleRecursion
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getRecursionParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRecursion_in_ruleModel213);
                    this_Recursion_3=ruleRecursion();

                    state._fsp--;

                     
                            current = this_Recursion_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:121:5: this_Loop_4= ruleLoop
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getLoopParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLoop_in_ruleModel240);
                    this_Loop_4=ruleLoop();

                    state._fsp--;

                     
                            current = this_Loop_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:131:5: this_Expression_5= ruleExpression
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getExpressionParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleModel267);
                    this_Expression_5=ruleExpression();

                    state._fsp--;

                     
                            current = this_Expression_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:141:5: this_RuleCalls12_6= ruleRuleCalls12
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getRuleCalls12ParserRuleCall_6()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCalls12_in_ruleModel294);
                    this_RuleCalls12_6=ruleRuleCalls12();

                    state._fsp--;

                     
                            current = this_RuleCalls12_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:157:1: entryRuleSimple returns [EObject current=null] : iv_ruleSimple= ruleSimple EOF ;
    public final EObject entryRuleSimple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimple = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:158:2: (iv_ruleSimple= ruleSimple EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:159:2: iv_ruleSimple= ruleSimple EOF
            {
             newCompositeNode(grammarAccess.getSimpleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimple_in_entryRuleSimple329);
            iv_ruleSimple=ruleSimple();

            state._fsp--;

             current =iv_ruleSimple; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimple339); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:166:1: ruleSimple returns [EObject current=null] : (otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) ) ;
    public final EObject ruleSimple() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_optional_3_0=null;
        AntlrDatatypeRuleToken lv_datatype_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:169:28: ( (otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:170:1: (otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:170:1: (otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:170:3: otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleSimple376); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleAccess().getNumberSignDigitOneKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:174:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:175:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:175:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:176:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimple393); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSimpleAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:192:2: (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:192:4: otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSimple411); 

                        	newLeafNode(otherlv_2, grammarAccess.getSimpleAccess().getKw1Keyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:196:1: ( (lv_optional_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:197:1: (lv_optional_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:197:1: (lv_optional_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:198:3: lv_optional_3_0= RULE_ID
                    {
                    lv_optional_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimple428); 

                    			newLeafNode(lv_optional_3_0, grammarAccess.getSimpleAccess().getOptionalIDTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"optional",
                            		lv_optional_3_0, 
                            		"ID");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:214:4: ( (lv_datatype_4_0= ruleFQN ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:215:1: (lv_datatype_4_0= ruleFQN )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:215:1: (lv_datatype_4_0= ruleFQN )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:216:3: lv_datatype_4_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getSimpleAccess().getDatatypeFQNParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleSimple456);
            lv_datatype_4_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSimpleRule());
            	        }
                   		set(
                   			current, 
                   			"datatype",
                    		lv_datatype_4_0, 
                    		"FQN");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:240:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:241:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:242:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN493);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN504); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:249:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:252:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:253:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:253:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:253:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN544); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:260:1: (kw= '.' this_ID_2= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:261:2: kw= '.' this_ID_2= RULE_ID
            {
            kw=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleFQN563); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
                
            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN578); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
                

            }


            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:281:1: entryRuleRuleCalls returns [EObject current=null] : iv_ruleRuleCalls= ruleRuleCalls EOF ;
    public final EObject entryRuleRuleCalls() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCalls = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:282:2: (iv_ruleRuleCalls= ruleRuleCalls EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:283:2: iv_ruleRuleCalls= ruleRuleCalls EOF
            {
             newCompositeNode(grammarAccess.getRuleCallsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCalls_in_entryRuleRuleCalls624);
            iv_ruleRuleCalls=ruleRuleCalls();

            state._fsp--;

             current =iv_ruleRuleCalls; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCalls634); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:290:1: ruleRuleCalls returns [EObject current=null] : (otherlv_0= '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? ) ;
    public final EObject ruleRuleCalls() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;
        EObject this_RuleCallsSub_1 = null;

        EObject lv_call1_3_0 = null;

        EObject lv_call2_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:293:28: ( (otherlv_0= '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:294:1: (otherlv_0= '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:294:1: (otherlv_0= '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:294:3: otherlv_0= '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )?
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleRuleCalls671); 

                	newLeafNode(otherlv_0, grammarAccess.getRuleCallsAccess().getNumberSignDigitTwoKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getRuleCallsAccess().getRuleCallsSubParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsSub_in_ruleRuleCalls693);
            this_RuleCallsSub_1=ruleRuleCallsSub();

            state._fsp--;

             
                    current = this_RuleCallsSub_1; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:307:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:308:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:308:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:309:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCalls709); 

            			newLeafNode(lv_name_2_0, grammarAccess.getRuleCallsAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleCallsRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:325:2: ( (lv_call1_3_0= ruleRuleCallsAss1 ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:326:1: (lv_call1_3_0= ruleRuleCallsAss1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:326:1: (lv_call1_3_0= ruleRuleCallsAss1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:327:3: lv_call1_3_0= ruleRuleCallsAss1
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuleCallsAccess().getCall1RuleCallsAss1ParserRuleCall_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss1_in_ruleRuleCalls735);
                    lv_call1_3_0=ruleRuleCallsAss1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRuleCallsRule());
                    	        }
                           		set(
                           			current, 
                           			"call1",
                            		lv_call1_3_0, 
                            		"RuleCallsAss1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:343:3: ( (lv_call2_4_0= ruleRuleCallsAss2 ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:344:1: (lv_call2_4_0= ruleRuleCallsAss2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:344:1: (lv_call2_4_0= ruleRuleCallsAss2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:345:3: lv_call2_4_0= ruleRuleCallsAss2
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuleCallsAccess().getCall2RuleCallsAss2ParserRuleCall_4_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss2_in_ruleRuleCalls757);
                    lv_call2_4_0=ruleRuleCallsAss2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRuleCallsRule());
                    	        }
                           		set(
                           			current, 
                           			"call2",
                            		lv_call2_4_0, 
                            		"RuleCallsAss2");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:369:1: entryRuleRuleCallsSub returns [EObject current=null] : iv_ruleRuleCallsSub= ruleRuleCallsSub EOF ;
    public final EObject entryRuleRuleCallsSub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallsSub = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:370:2: (iv_ruleRuleCallsSub= ruleRuleCallsSub EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:371:2: iv_ruleRuleCallsSub= ruleRuleCallsSub EOF
            {
             newCompositeNode(grammarAccess.getRuleCallsSubRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsSub_in_entryRuleRuleCallsSub794);
            iv_ruleRuleCallsSub=ruleRuleCallsSub();

            state._fsp--;

             current =iv_ruleRuleCallsSub; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallsSub804); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:378:1: ruleRuleCallsSub returns [EObject current=null] : ( (lv_sub_0_0= 'sub' ) ) ;
    public final EObject ruleRuleCallsSub() throws RecognitionException {
        EObject current = null;

        Token lv_sub_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:381:28: ( ( (lv_sub_0_0= 'sub' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:382:1: ( (lv_sub_0_0= 'sub' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:382:1: ( (lv_sub_0_0= 'sub' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:383:1: (lv_sub_0_0= 'sub' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:383:1: (lv_sub_0_0= 'sub' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:384:3: lv_sub_0_0= 'sub'
            {
            lv_sub_0_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleRuleCallsSub846); 

                    newLeafNode(lv_sub_0_0, grammarAccess.getRuleCallsSubAccess().getSubSubKeyword_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleCallsSubRule());
            	        }
                   		setWithLastConsumed(current, "sub", lv_sub_0_0, "sub");
            	    

            }


            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:405:1: entryRuleRuleCallsAss1 returns [EObject current=null] : iv_ruleRuleCallsAss1= ruleRuleCallsAss1 EOF ;
    public final EObject entryRuleRuleCallsAss1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallsAss1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:406:2: (iv_ruleRuleCallsAss1= ruleRuleCallsAss1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:407:2: iv_ruleRuleCallsAss1= ruleRuleCallsAss1 EOF
            {
             newCompositeNode(grammarAccess.getRuleCallsAss1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss1_in_entryRuleRuleCallsAss1894);
            iv_ruleRuleCallsAss1=ruleRuleCallsAss1();

            state._fsp--;

             current =iv_ruleRuleCallsAss1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallsAss1904); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:414:1: ruleRuleCallsAss1 returns [EObject current=null] : (otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleRuleCallsAss1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:417:28: ( (otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:418:1: (otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:418:1: (otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:418:3: otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleRuleCallsAss1941); 

                	newLeafNode(otherlv_0, grammarAccess.getRuleCallsAss1Access().getAss1Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:422:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:423:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:423:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:424:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCallsAss1958); 

            			newLeafNode(lv_name_1_0, grammarAccess.getRuleCallsAss1Access().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleCallsAss1Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:448:1: entryRuleRuleCallsAss2 returns [EObject current=null] : iv_ruleRuleCallsAss2= ruleRuleCallsAss2 EOF ;
    public final EObject entryRuleRuleCallsAss2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallsAss2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:449:2: (iv_ruleRuleCallsAss2= ruleRuleCallsAss2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:450:2: iv_ruleRuleCallsAss2= ruleRuleCallsAss2 EOF
            {
             newCompositeNode(grammarAccess.getRuleCallsAss2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss2_in_entryRuleRuleCallsAss2999);
            iv_ruleRuleCallsAss2=ruleRuleCallsAss2();

            state._fsp--;

             current =iv_ruleRuleCallsAss2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallsAss21009); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:457:1: ruleRuleCallsAss2 returns [EObject current=null] : (otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleRuleCallsAss2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:460:28: ( (otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:461:1: (otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:461:1: (otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:461:3: otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleRuleCallsAss21046); 

                	newLeafNode(otherlv_0, grammarAccess.getRuleCallsAss2Access().getAss2Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:465:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:466:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:466:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:467:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCallsAss21063); 

            			newLeafNode(lv_name_1_0, grammarAccess.getRuleCallsAss2Access().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleCallsAss2Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:491:1: entryRuleOptionalCalls returns [EObject current=null] : iv_ruleOptionalCalls= ruleOptionalCalls EOF ;
    public final EObject entryRuleOptionalCalls() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalCalls = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:492:2: (iv_ruleOptionalCalls= ruleOptionalCalls EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:493:2: iv_ruleOptionalCalls= ruleOptionalCalls EOF
            {
             newCompositeNode(grammarAccess.getOptionalCallsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCalls_in_entryRuleOptionalCalls1104);
            iv_ruleOptionalCalls=ruleOptionalCalls();

            state._fsp--;

             current =iv_ruleOptionalCalls; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCalls1114); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:500:1: ruleOptionalCalls returns [EObject current=null] : (otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleOptionalCalls() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_3_0=null;
        EObject lv_opt1_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:503:28: ( (otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:504:1: (otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:504:1: (otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:504:3: otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOptionalCalls1151); 

                	newLeafNode(otherlv_0, grammarAccess.getOptionalCallsAccess().getNumberSignDigitThreeKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:508:1: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:509:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getOptionalCallsAccess().getOptionalCallsAction_1(),
                        current);
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:514:2: ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15||LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:515:1: (lv_opt1_2_0= ruleOptionalCallsSub1 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:515:1: (lv_opt1_2_0= ruleOptionalCallsSub1 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:516:3: lv_opt1_2_0= ruleOptionalCallsSub1
                    {
                     
                    	        newCompositeNode(grammarAccess.getOptionalCallsAccess().getOpt1OptionalCallsSub1ParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub1_in_ruleOptionalCalls1181);
                    lv_opt1_2_0=ruleOptionalCallsSub1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOptionalCallsRule());
                    	        }
                           		set(
                           			current, 
                           			"opt1",
                            		lv_opt1_2_0, 
                            		"OptionalCallsSub1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:532:3: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:533:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:533:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:534:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalCalls1199); 

            			newLeafNode(lv_name_3_0, grammarAccess.getOptionalCallsAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOptionalCallsRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:558:1: entryRuleOptionalCallsSub1 returns [EObject current=null] : iv_ruleOptionalCallsSub1= ruleOptionalCallsSub1 EOF ;
    public final EObject entryRuleOptionalCallsSub1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalCallsSub1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:559:2: (iv_ruleOptionalCallsSub1= ruleOptionalCallsSub1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:560:2: iv_ruleOptionalCallsSub1= ruleOptionalCallsSub1 EOF
            {
             newCompositeNode(grammarAccess.getOptionalCallsSub1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub1_in_entryRuleOptionalCallsSub11240);
            iv_ruleOptionalCallsSub1=ruleOptionalCallsSub1();

            state._fsp--;

             current =iv_ruleOptionalCallsSub1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCallsSub11250); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:567:1: ruleOptionalCallsSub1 returns [EObject current=null] : ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? ) ;
    public final EObject ruleOptionalCallsSub1() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_opt2_1_0 = null;

        EObject lv_opt3_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:570:28: ( ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:571:1: ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:571:1: ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:571:2: () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:571:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:572:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getOptionalCallsSub1Access().getOptionalCallsSub1Action_0(),
                        current);
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:577:2: ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:578:1: (lv_opt2_1_0= ruleOptionalCallsSub2 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:578:1: (lv_opt2_1_0= ruleOptionalCallsSub2 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:579:3: lv_opt2_1_0= ruleOptionalCallsSub2
                    {
                     
                    	        newCompositeNode(grammarAccess.getOptionalCallsSub1Access().getOpt2OptionalCallsSub2ParserRuleCall_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub2_in_ruleOptionalCallsSub11305);
                    lv_opt2_1_0=ruleOptionalCallsSub2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOptionalCallsSub1Rule());
                    	        }
                           		set(
                           			current, 
                           			"opt2",
                            		lv_opt2_1_0, 
                            		"OptionalCallsSub2");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOptionalCallsSub11318); 

                	newLeafNode(otherlv_2, grammarAccess.getOptionalCallsSub1Access().getSubKeyword_2());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:599:1: ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:600:1: (lv_opt3_3_0= ruleOptionalCallsSub3 )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:600:1: (lv_opt3_3_0= ruleOptionalCallsSub3 )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:601:3: lv_opt3_3_0= ruleOptionalCallsSub3
                    {
                     
                    	        newCompositeNode(grammarAccess.getOptionalCallsSub1Access().getOpt3OptionalCallsSub3ParserRuleCall_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub3_in_ruleOptionalCallsSub11339);
                    lv_opt3_3_0=ruleOptionalCallsSub3();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOptionalCallsSub1Rule());
                    	        }
                           		set(
                           			current, 
                           			"opt3",
                            		lv_opt3_3_0, 
                            		"OptionalCallsSub3");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:625:1: entryRuleOptionalCallsSub2 returns [EObject current=null] : iv_ruleOptionalCallsSub2= ruleOptionalCallsSub2 EOF ;
    public final EObject entryRuleOptionalCallsSub2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalCallsSub2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:626:2: (iv_ruleOptionalCallsSub2= ruleOptionalCallsSub2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:627:2: iv_ruleOptionalCallsSub2= ruleOptionalCallsSub2 EOF
            {
             newCompositeNode(grammarAccess.getOptionalCallsSub2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub2_in_entryRuleOptionalCallsSub21376);
            iv_ruleOptionalCallsSub2=ruleOptionalCallsSub2();

            state._fsp--;

             current =iv_ruleOptionalCallsSub2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCallsSub21386); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:634:1: ruleOptionalCallsSub2 returns [EObject current=null] : (otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleOptionalCallsSub2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:637:28: ( (otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:638:1: (otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:638:1: (otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:638:3: otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleOptionalCallsSub21423); 

                	newLeafNode(otherlv_0, grammarAccess.getOptionalCallsSub2Access().getSub2Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:642:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:643:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:643:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:644:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalCallsSub21440); 

            			newLeafNode(lv_name_1_0, grammarAccess.getOptionalCallsSub2Access().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOptionalCallsSub2Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:668:1: entryRuleOptionalCallsSub3 returns [EObject current=null] : iv_ruleOptionalCallsSub3= ruleOptionalCallsSub3 EOF ;
    public final EObject entryRuleOptionalCallsSub3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalCallsSub3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:669:2: (iv_ruleOptionalCallsSub3= ruleOptionalCallsSub3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:670:2: iv_ruleOptionalCallsSub3= ruleOptionalCallsSub3 EOF
            {
             newCompositeNode(grammarAccess.getOptionalCallsSub3Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub3_in_entryRuleOptionalCallsSub31481);
            iv_ruleOptionalCallsSub3=ruleOptionalCallsSub3();

            state._fsp--;

             current =iv_ruleOptionalCallsSub3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCallsSub31491); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:677:1: ruleOptionalCallsSub3 returns [EObject current=null] : (otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleOptionalCallsSub3() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:680:28: ( (otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:681:1: (otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:681:1: (otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:681:3: otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleOptionalCallsSub31528); 

                	newLeafNode(otherlv_0, grammarAccess.getOptionalCallsSub3Access().getSub3Keyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:685:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:686:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:686:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:687:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalCallsSub31545); 

            			newLeafNode(lv_name_1_0, grammarAccess.getOptionalCallsSub3Access().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOptionalCallsSub3Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:711:1: entryRuleRecursion returns [EObject current=null] : iv_ruleRecursion= ruleRecursion EOF ;
    public final EObject entryRuleRecursion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecursion = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:712:2: (iv_ruleRecursion= ruleRecursion EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:713:2: iv_ruleRecursion= ruleRecursion EOF
            {
             newCompositeNode(grammarAccess.getRecursionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRecursion_in_entryRuleRecursion1586);
            iv_ruleRecursion=ruleRecursion();

            state._fsp--;

             current =iv_ruleRecursion; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRecursion1596); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:720:1: ruleRecursion returns [EObject current=null] : (otherlv_0= '#4' this_RecursionSub_1= ruleRecursionSub ) ;
    public final EObject ruleRecursion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_RecursionSub_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:723:28: ( (otherlv_0= '#4' this_RecursionSub_1= ruleRecursionSub ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:724:1: (otherlv_0= '#4' this_RecursionSub_1= ruleRecursionSub )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:724:1: (otherlv_0= '#4' this_RecursionSub_1= ruleRecursionSub )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:724:3: otherlv_0= '#4' this_RecursionSub_1= ruleRecursionSub
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleRecursion1633); 

                	newLeafNode(otherlv_0, grammarAccess.getRecursionAccess().getNumberSignDigitFourKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getRecursionAccess().getRecursionSubParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRecursionSub_in_ruleRecursion1655);
            this_RecursionSub_1=ruleRecursionSub();

            state._fsp--;

             
                    current = this_RecursionSub_1; 
                    afterParserOrEnumRuleCall();
                

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:745:1: entryRuleRecursionSub returns [EObject current=null] : iv_ruleRecursionSub= ruleRecursionSub EOF ;
    public final EObject entryRuleRecursionSub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecursionSub = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:746:2: (iv_ruleRecursionSub= ruleRecursionSub EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:747:2: iv_ruleRecursionSub= ruleRecursionSub EOF
            {
             newCompositeNode(grammarAccess.getRecursionSubRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRecursionSub_in_entryRuleRecursionSub1690);
            iv_ruleRecursionSub=ruleRecursionSub();

            state._fsp--;

             current =iv_ruleRecursionSub; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRecursionSub1700); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:754:1: ruleRecursionSub returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? ) ;
    public final EObject ruleRecursionSub() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_vals_3_0=null;
        Token otherlv_4=null;
        Token lv_semi_5_0=null;
        EObject lv_sub_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:757:28: ( ( () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:758:1: ( () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:758:1: ( () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:758:2: () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:758:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:759:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRecursionSubAccess().getRecursionSubAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleRecursionSub1746); 

                	newLeafNode(otherlv_1, grammarAccess.getRecursionSubAccess().getLeftCurlyBracketKeyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:768:1: ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:768:2: ( (lv_sub_2_0= ruleRecursionSub ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:768:2: ( (lv_sub_2_0= ruleRecursionSub ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:769:1: (lv_sub_2_0= ruleRecursionSub )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:769:1: (lv_sub_2_0= ruleRecursionSub )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:770:3: lv_sub_2_0= ruleRecursionSub
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRecursionSubAccess().getSubRecursionSubParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRecursionSub_in_ruleRecursionSub1768);
            	    lv_sub_2_0=ruleRecursionSub();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRecursionSubRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"sub",
            	            		lv_sub_2_0, 
            	            		"RecursionSub");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:787:6: ( (lv_vals_3_0= RULE_ID ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:787:6: ( (lv_vals_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:788:1: (lv_vals_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:788:1: (lv_vals_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:789:3: lv_vals_3_0= RULE_ID
            	    {
            	    lv_vals_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRecursionSub1791); 

            	    			newLeafNode(lv_vals_3_0, grammarAccess.getRecursionSubAccess().getValsIDTerminalRuleCall_2_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRecursionSubRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"vals",
            	            		lv_vals_3_0, 
            	            		"ID");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleRecursionSub1810); 

                	newLeafNode(otherlv_4, grammarAccess.getRecursionSubAccess().getRightCurlyBracketKeyword_3());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:809:1: ( (lv_semi_5_0= ';' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:810:1: (lv_semi_5_0= ';' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:810:1: (lv_semi_5_0= ';' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:811:3: lv_semi_5_0= ';'
                    {
                    lv_semi_5_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleRecursionSub1828); 

                            newLeafNode(lv_semi_5_0, grammarAccess.getRecursionSubAccess().getSemiSemicolonKeyword_4_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getRecursionSubRule());
                    	        }
                           		setWithLastConsumed(current, "semi", true, ";");
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:832:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:833:2: (iv_ruleLoop= ruleLoop EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:834:2: iv_ruleLoop= ruleLoop EOF
            {
             newCompositeNode(grammarAccess.getLoopRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleLoop_in_entryRuleLoop1878);
            iv_ruleLoop=ruleLoop();

            state._fsp--;

             current =iv_ruleLoop; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoop1888); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:841:1: ruleLoop returns [EObject current=null] : (otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* ) ;
    public final EObject ruleLoop() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_names_1_0=null;
        Token otherlv_2=null;
        Token lv_gr_3_0=null;
        Token lv_ints_4_0=null;
        Token lv_strings_5_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:844:28: ( (otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:845:1: (otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:845:1: (otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:845:3: otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )*
            {
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleLoop1925); 

                	newLeafNode(otherlv_0, grammarAccess.getLoopAccess().getNumberSignDigitFiveKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:849:1: ( (lv_names_1_0= RULE_ID ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:850:1: (lv_names_1_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:850:1: (lv_names_1_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:851:3: lv_names_1_0= RULE_ID
            	    {
            	    lv_names_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop1942); 

            	    			newLeafNode(lv_names_1_0, grammarAccess.getLoopAccess().getNamesIDTerminalRuleCall_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getLoopRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"names",
            	            		lv_names_1_0, 
            	            		"ID");
            	    	    

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:867:3: (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==26) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:867:5: otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleLoop1961); 

            	        	newLeafNode(otherlv_2, grammarAccess.getLoopAccess().getGrKeyword_2_0());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:871:1: ( (lv_gr_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:872:1: (lv_gr_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:872:1: (lv_gr_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:873:3: lv_gr_3_0= RULE_ID
            	    {
            	    lv_gr_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop1978); 

            	    			newLeafNode(lv_gr_3_0, grammarAccess.getLoopAccess().getGrIDTerminalRuleCall_2_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getLoopRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"gr",
            	            		lv_gr_3_0, 
            	            		"ID");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:889:4: ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:889:5: ( (lv_ints_4_0= RULE_INT ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:889:5: ( (lv_ints_4_0= RULE_INT ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:890:1: (lv_ints_4_0= RULE_INT )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:890:1: (lv_ints_4_0= RULE_INT )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:891:3: lv_ints_4_0= RULE_INT
            	    {
            	    lv_ints_4_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLoop2003); 

            	    			newLeafNode(lv_ints_4_0, grammarAccess.getLoopAccess().getIntsINTTerminalRuleCall_3_0_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getLoopRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"ints",
            	            		lv_ints_4_0, 
            	            		"INT");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:908:6: ( (lv_strings_5_0= RULE_STRING ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:908:6: ( (lv_strings_5_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:909:1: (lv_strings_5_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:909:1: (lv_strings_5_0= RULE_STRING )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:910:3: lv_strings_5_0= RULE_STRING
            	    {
            	    lv_strings_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleLoop2031); 

            	    			newLeafNode(lv_strings_5_0, grammarAccess.getLoopAccess().getStringsSTRINGTerminalRuleCall_3_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getLoopRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"strings",
            	            		lv_strings_5_0, 
            	            		"STRING");
            	    	    

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

             leaveRule(); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:934:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:935:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:936:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_entryRuleExpression2074);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression2084); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:943:1: ruleExpression returns [EObject current=null] : (otherlv_0= '#6' this_Add_1= ruleAdd ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Add_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:946:28: ( (otherlv_0= '#6' this_Add_1= ruleAdd ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:947:1: (otherlv_0= '#6' this_Add_1= ruleAdd )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:947:1: (otherlv_0= '#6' this_Add_1= ruleAdd )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:947:3: otherlv_0= '#6' this_Add_1= ruleAdd
            {
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleExpression2121); 

                	newLeafNode(otherlv_0, grammarAccess.getExpressionAccess().getNumberSignDigitSixKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getExpressionAccess().getAddParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAdd_in_ruleExpression2143);
            this_Add_1=ruleAdd();

            state._fsp--;

             
                    current = this_Add_1; 
                    afterParserOrEnumRuleCall();
                

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:968:1: entryRuleAdd returns [EObject current=null] : iv_ruleAdd= ruleAdd EOF ;
    public final EObject entryRuleAdd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdd = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:969:2: (iv_ruleAdd= ruleAdd EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:970:2: iv_ruleAdd= ruleAdd EOF
            {
             newCompositeNode(grammarAccess.getAddRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAdd_in_entryRuleAdd2178);
            iv_ruleAdd=ruleAdd();

            state._fsp--;

             current =iv_ruleAdd; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAdd2188); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:977:1: ruleAdd returns [EObject current=null] : (this_Mult_0= ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )* ) ;
    public final EObject ruleAdd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Mult_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:980:28: ( (this_Mult_0= ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:981:1: (this_Mult_0= ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:981:1: (this_Mult_0= ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:982:5: this_Mult_0= ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAddAccess().getMultParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleMult_in_ruleAdd2235);
            this_Mult_0=ruleMult();

            state._fsp--;

             
                    current = this_Mult_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:990:1: ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==28) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:990:2: () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:990:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:991:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAddAccess().getAddLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleAdd2256); 

            	        	newLeafNode(otherlv_2, grammarAccess.getAddAccess().getPlusSignKeyword_1_1());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1000:1: ( (lv_right_3_0= ruleMult ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1001:1: (lv_right_3_0= ruleMult )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1001:1: (lv_right_3_0= ruleMult )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1002:3: lv_right_3_0= ruleMult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAddAccess().getRightMultParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleMult_in_ruleAdd2277);
            	    lv_right_3_0=ruleMult();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAddRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"Mult");
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

             leaveRule(); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1026:1: entryRuleMult returns [EObject current=null] : iv_ruleMult= ruleMult EOF ;
    public final EObject entryRuleMult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMult = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1027:2: (iv_ruleMult= ruleMult EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1028:2: iv_ruleMult= ruleMult EOF
            {
             newCompositeNode(grammarAccess.getMultRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMult_in_entryRuleMult2315);
            iv_ruleMult=ruleMult();

            state._fsp--;

             current =iv_ruleMult; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMult2325); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1035:1: ruleMult returns [EObject current=null] : (this_Prim_0= rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )* ) ;
    public final EObject ruleMult() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Prim_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1038:28: ( (this_Prim_0= rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1039:1: (this_Prim_0= rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1039:1: (this_Prim_0= rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1040:5: this_Prim_0= rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getMultAccess().getPrimParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_rulePrim_in_ruleMult2372);
            this_Prim_0=rulePrim();

            state._fsp--;

             
                    current = this_Prim_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1048:1: ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==29) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1048:2: () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1048:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1049:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getMultAccess().getMultLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleMult2393); 

            	        	newLeafNode(otherlv_2, grammarAccess.getMultAccess().getAsteriskKeyword_1_1());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1058:1: ( (lv_right_3_0= rulePrim ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1059:1: (lv_right_3_0= rulePrim )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1059:1: (lv_right_3_0= rulePrim )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1060:3: lv_right_3_0= rulePrim
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultAccess().getRightPrimParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_rulePrim_in_ruleMult2414);
            	    lv_right_3_0=rulePrim();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMultRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"Prim");
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

             leaveRule(); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1084:1: entryRulePrim returns [EObject current=null] : iv_rulePrim= rulePrim EOF ;
    public final EObject entryRulePrim() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrim = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1085:2: (iv_rulePrim= rulePrim EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1086:2: iv_rulePrim= rulePrim EOF
            {
             newCompositeNode(grammarAccess.getPrimRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePrim_in_entryRulePrim2452);
            iv_rulePrim=rulePrim();

            state._fsp--;

             current =iv_rulePrim; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrim2462); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1093:1: rulePrim returns [EObject current=null] : ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' ) | ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) ) | (otherlv_12= '(' this_Add_13= ruleAdd otherlv_14= ')' ) ) ;
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


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1096:28: ( ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' ) | ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) ) | (otherlv_12= '(' this_Add_13= ruleAdd otherlv_14= ')' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1097:1: ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' ) | ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) ) | (otherlv_12= '(' this_Add_13= ruleAdd otherlv_14= ')' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1097:1: ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' ) | ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) ) | (otherlv_12= '(' this_Add_13= ruleAdd otherlv_14= ')' ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1097:2: ( () ( (lv_val_1_0= RULE_INT ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1097:2: ( () ( (lv_val_1_0= RULE_INT ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1097:3: () ( (lv_val_1_0= RULE_INT ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1097:3: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1098:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrimAccess().getValueAction_0_0(),
                                current);
                        

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1103:2: ( (lv_val_1_0= RULE_INT ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1104:1: (lv_val_1_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1104:1: (lv_val_1_0= RULE_INT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1105:3: lv_val_1_0= RULE_INT
                    {
                    lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rulePrim2514); 

                    			newLeafNode(lv_val_1_0, grammarAccess.getPrimAccess().getValINTTerminalRuleCall_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPrimRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val",
                            		lv_val_1_0, 
                            		"INT");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1122:6: ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1122:6: ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1122:7: () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')'
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1122:7: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1123:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrimAccess().getFunctionAction_1_0(),
                                current);
                        

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1128:2: ( (lv_func_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1129:1: (lv_func_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1129:1: (lv_func_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1130:3: lv_func_3_0= RULE_ID
                    {
                    lv_func_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePrim2553); 

                    			newLeafNode(lv_func_3_0, grammarAccess.getPrimAccess().getFuncIDTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPrimRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"func",
                            		lv_func_3_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,30,FollowSets000.FOLLOW_30_in_rulePrim2570); 

                        	newLeafNode(otherlv_4, grammarAccess.getPrimAccess().getLeftParenthesisKeyword_1_2());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1150:1: ( (lv_param_5_0= ruleAdd ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1151:1: (lv_param_5_0= ruleAdd )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1151:1: (lv_param_5_0= ruleAdd )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1152:3: lv_param_5_0= ruleAdd
                    {
                     
                    	        newCompositeNode(grammarAccess.getPrimAccess().getParamAddParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAdd_in_rulePrim2591);
                    lv_param_5_0=ruleAdd();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPrimRule());
                    	        }
                           		add(
                           			current, 
                           			"param",
                            		lv_param_5_0, 
                            		"Add");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1168:2: (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==31) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1168:4: otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) )
                    	    {
                    	    otherlv_6=(Token)match(input,31,FollowSets000.FOLLOW_31_in_rulePrim2604); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getPrimAccess().getCommaKeyword_1_4_0());
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1172:1: ( (lv_param_7_0= ruleAdd ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1173:1: (lv_param_7_0= ruleAdd )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1173:1: (lv_param_7_0= ruleAdd )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1174:3: lv_param_7_0= ruleAdd
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getPrimAccess().getParamAddParserRuleCall_1_4_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAdd_in_rulePrim2625);
                    	    lv_param_7_0=ruleAdd();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getPrimRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"param",
                    	            		lv_param_7_0, 
                    	            		"Add");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,32,FollowSets000.FOLLOW_32_in_rulePrim2639); 

                        	newLeafNode(otherlv_8, grammarAccess.getPrimAccess().getRightParenthesisKeyword_1_5());
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1195:6: ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1195:6: ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1195:7: () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1195:7: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1196:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrimAccess().getPointerAction_2_0(),
                                current);
                        

                    }

                    otherlv_10=(Token)match(input,33,FollowSets000.FOLLOW_33_in_rulePrim2668); 

                        	newLeafNode(otherlv_10, grammarAccess.getPrimAccess().getEqualsSignGreaterThanSignKeyword_2_1());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1205:1: ( (lv_target_11_0= rulePrim ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1206:1: (lv_target_11_0= rulePrim )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1206:1: (lv_target_11_0= rulePrim )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1207:3: lv_target_11_0= rulePrim
                    {
                     
                    	        newCompositeNode(grammarAccess.getPrimAccess().getTargetPrimParserRuleCall_2_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_rulePrim_in_rulePrim2689);
                    lv_target_11_0=rulePrim();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPrimRule());
                    	        }
                           		set(
                           			current, 
                           			"target",
                            		lv_target_11_0, 
                            		"Prim");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1224:6: (otherlv_12= '(' this_Add_13= ruleAdd otherlv_14= ')' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1224:6: (otherlv_12= '(' this_Add_13= ruleAdd otherlv_14= ')' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1224:8: otherlv_12= '(' this_Add_13= ruleAdd otherlv_14= ')'
                    {
                    otherlv_12=(Token)match(input,30,FollowSets000.FOLLOW_30_in_rulePrim2709); 

                        	newLeafNode(otherlv_12, grammarAccess.getPrimAccess().getLeftParenthesisKeyword_3_0());
                        
                     
                            newCompositeNode(grammarAccess.getPrimAccess().getAddParserRuleCall_3_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAdd_in_rulePrim2731);
                    this_Add_13=ruleAdd();

                    state._fsp--;

                     
                            current = this_Add_13; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_14=(Token)match(input,32,FollowSets000.FOLLOW_32_in_rulePrim2742); 

                        	newLeafNode(otherlv_14, grammarAccess.getPrimAccess().getRightParenthesisKeyword_3_2());
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleRuleCalls12"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1249:1: entryRuleRuleCalls12 returns [EObject current=null] : iv_ruleRuleCalls12= ruleRuleCalls12 EOF ;
    public final EObject entryRuleRuleCalls12() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCalls12 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1250:2: (iv_ruleRuleCalls12= ruleRuleCalls12 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1251:2: iv_ruleRuleCalls12= ruleRuleCalls12 EOF
            {
             newCompositeNode(grammarAccess.getRuleCalls12Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCalls12_in_entryRuleRuleCalls122779);
            iv_ruleRuleCalls12=ruleRuleCalls12();

            state._fsp--;

             current =iv_ruleRuleCalls12; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCalls122789); 

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
    // $ANTLR end "entryRuleRuleCalls12"


    // $ANTLR start "ruleRuleCalls12"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1258:1: ruleRuleCalls12 returns [EObject current=null] : (otherlv_0= '#7' ( (lv_constructor_1_0= ruleConstructor ) ) ( (lv_fields_2_0= ruleField ) ) otherlv_3= 'kw3' ) ;
    public final EObject ruleRuleCalls12() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_constructor_1_0 = null;

        EObject lv_fields_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1261:28: ( (otherlv_0= '#7' ( (lv_constructor_1_0= ruleConstructor ) ) ( (lv_fields_2_0= ruleField ) ) otherlv_3= 'kw3' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1262:1: (otherlv_0= '#7' ( (lv_constructor_1_0= ruleConstructor ) ) ( (lv_fields_2_0= ruleField ) ) otherlv_3= 'kw3' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1262:1: (otherlv_0= '#7' ( (lv_constructor_1_0= ruleConstructor ) ) ( (lv_fields_2_0= ruleField ) ) otherlv_3= 'kw3' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1262:3: otherlv_0= '#7' ( (lv_constructor_1_0= ruleConstructor ) ) ( (lv_fields_2_0= ruleField ) ) otherlv_3= 'kw3'
            {
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleRuleCalls122826); 

                	newLeafNode(otherlv_0, grammarAccess.getRuleCalls12Access().getNumberSignDigitSevenKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1266:1: ( (lv_constructor_1_0= ruleConstructor ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1267:1: (lv_constructor_1_0= ruleConstructor )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1267:1: (lv_constructor_1_0= ruleConstructor )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1268:3: lv_constructor_1_0= ruleConstructor
            {
             
            	        newCompositeNode(grammarAccess.getRuleCalls12Access().getConstructorConstructorParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleConstructor_in_ruleRuleCalls122847);
            lv_constructor_1_0=ruleConstructor();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRuleCalls12Rule());
            	        }
                   		set(
                   			current, 
                   			"constructor",
                    		lv_constructor_1_0, 
                    		"Constructor");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1284:2: ( (lv_fields_2_0= ruleField ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1285:1: (lv_fields_2_0= ruleField )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1285:1: (lv_fields_2_0= ruleField )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1286:3: lv_fields_2_0= ruleField
            {
             
            	        newCompositeNode(grammarAccess.getRuleCalls12Access().getFieldsFieldParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleField_in_ruleRuleCalls122868);
            lv_fields_2_0=ruleField();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRuleCalls12Rule());
            	        }
                   		add(
                   			current, 
                   			"fields",
                    		lv_fields_2_0, 
                    		"Field");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleRuleCalls122880); 

                	newLeafNode(otherlv_3, grammarAccess.getRuleCalls12Access().getKw3Keyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleCalls12"


    // $ANTLR start "entryRuleConstructor"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1314:1: entryRuleConstructor returns [EObject current=null] : iv_ruleConstructor= ruleConstructor EOF ;
    public final EObject entryRuleConstructor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructor = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1315:2: (iv_ruleConstructor= ruleConstructor EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1316:2: iv_ruleConstructor= ruleConstructor EOF
            {
             newCompositeNode(grammarAccess.getConstructorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConstructor_in_entryRuleConstructor2916);
            iv_ruleConstructor=ruleConstructor();

            state._fsp--;

             current =iv_ruleConstructor; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstructor2926); 

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
    // $ANTLR end "entryRuleConstructor"


    // $ANTLR start "ruleConstructor"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1323:1: ruleConstructor returns [EObject current=null] : ( () ( (lv_kw1_1_0= 'kw1' ) )? ) ;
    public final EObject ruleConstructor() throws RecognitionException {
        EObject current = null;

        Token lv_kw1_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1326:28: ( ( () ( (lv_kw1_1_0= 'kw1' ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1327:1: ( () ( (lv_kw1_1_0= 'kw1' ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1327:1: ( () ( (lv_kw1_1_0= 'kw1' ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1327:2: () ( (lv_kw1_1_0= 'kw1' ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1327:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1328:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getConstructorAccess().getConstructorAction_0(),
                        current);
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1333:2: ( (lv_kw1_1_0= 'kw1' ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==12) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1334:1: (lv_kw1_1_0= 'kw1' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1334:1: (lv_kw1_1_0= 'kw1' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1335:3: lv_kw1_1_0= 'kw1'
                    {
                    lv_kw1_1_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleConstructor2978); 

                            newLeafNode(lv_kw1_1_0, grammarAccess.getConstructorAccess().getKw1Kw1Keyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConstructorRule());
                    	        }
                           		setWithLastConsumed(current, "kw1", true, "kw1");
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstructor"


    // $ANTLR start "entryRuleField"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1356:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1357:2: (iv_ruleField= ruleField EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1358:2: iv_ruleField= ruleField EOF
            {
             newCompositeNode(grammarAccess.getFieldRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleField_in_entryRuleField3028);
            iv_ruleField=ruleField();

            state._fsp--;

             current =iv_ruleField; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleField3038); 

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
    // $ANTLR end "entryRuleField"


    // $ANTLR start "ruleField"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1365:1: ruleField returns [EObject current=null] : (this_ID_0= RULE_ID this_Parameter_1= ruleParameter ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        Token this_ID_0=null;
        EObject this_Parameter_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1368:28: ( (this_ID_0= RULE_ID this_Parameter_1= ruleParameter ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1369:1: (this_ID_0= RULE_ID this_Parameter_1= ruleParameter )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1369:1: (this_ID_0= RULE_ID this_Parameter_1= ruleParameter )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1369:2: this_ID_0= RULE_ID this_Parameter_1= ruleParameter
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleField3074); 
             
                newLeafNode(this_ID_0, grammarAccess.getFieldAccess().getIDTerminalRuleCall_0()); 
                
             
                    newCompositeNode(grammarAccess.getFieldAccess().getParameterParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleField3095);
            this_Parameter_1=ruleParameter();

            state._fsp--;

             
                    current = this_Parameter_1; 
                    afterParserOrEnumRuleCall();
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleField"


    // $ANTLR start "entryRuleParameter"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1390:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1391:2: (iv_ruleParameter= ruleParameter EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1392:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_entryRuleParameter3130);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameter3140); 

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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1399:1: ruleParameter returns [EObject current=null] : ( () ( (lv_kw2_1_0= 'kw2' ) )? ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_kw2_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1402:28: ( ( () ( (lv_kw2_1_0= 'kw2' ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1403:1: ( () ( (lv_kw2_1_0= 'kw2' ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1403:1: ( () ( (lv_kw2_1_0= 'kw2' ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1403:2: () ( (lv_kw2_1_0= 'kw2' ) )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1403:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1404:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getParameterAccess().getParameterAction_0(),
                        current);
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1409:2: ( (lv_kw2_1_0= 'kw2' ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==36) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1410:1: (lv_kw2_1_0= 'kw2' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1410:1: (lv_kw2_1_0= 'kw2' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/formatter/parser/antlr/internal/InternalElementMatcherTestLanguage.g:1411:3: lv_kw2_1_0= 'kw2'
                    {
                    lv_kw2_1_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleParameter3192); 

                            newLeafNode(lv_kw2_1_0, grammarAccess.getParameterAccess().getKw2Kw2Keyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getParameterRule());
                    	        }
                           		setWithLastConsumed(current, "kw2", true, "kw2");
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"

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
        public static final BitSet FOLLOW_ruleRuleCalls12_in_ruleModel294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimple_in_entryRuleSimple329 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimple339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleSimple376 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimple393 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleSimple411 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimple428 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleSimple456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN493 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN504 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN544 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleFQN563 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN578 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCalls_in_entryRuleRuleCalls624 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCalls634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleRuleCalls671 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleRuleCallsSub_in_ruleRuleCalls693 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCalls709 = new BitSet(new long[]{0x0000000000030002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss1_in_ruleRuleCalls735 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss2_in_ruleRuleCalls757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallsSub_in_entryRuleRuleCallsSub794 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallsSub804 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleRuleCallsSub846 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss1_in_entryRuleRuleCallsAss1894 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallsAss1904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleRuleCallsAss1941 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallsAss1958 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss2_in_entryRuleRuleCallsAss2999 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallsAss21009 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleRuleCallsAss21046 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallsAss21063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCalls_in_entryRuleOptionalCalls1104 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCalls1114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleOptionalCalls1151 = new BitSet(new long[]{0x0000000000088010L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub1_in_ruleOptionalCalls1181 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalCalls1199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub1_in_entryRuleOptionalCallsSub11240 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCallsSub11250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub2_in_ruleOptionalCallsSub11305 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleOptionalCallsSub11318 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub3_in_ruleOptionalCallsSub11339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub2_in_entryRuleOptionalCallsSub21376 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCallsSub21386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleOptionalCallsSub21423 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalCallsSub21440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub3_in_entryRuleOptionalCallsSub31481 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCallsSub31491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleOptionalCallsSub31528 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalCallsSub31545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecursion_in_entryRuleRecursion1586 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRecursion1596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleRecursion1633 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_ruleRecursionSub_in_ruleRecursion1655 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecursionSub_in_entryRuleRecursionSub1690 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRecursionSub1700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleRecursionSub1746 = new BitSet(new long[]{0x0000000000C00010L});
        public static final BitSet FOLLOW_ruleRecursionSub_in_ruleRecursionSub1768 = new BitSet(new long[]{0x0000000000C00010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRecursionSub1791 = new BitSet(new long[]{0x0000000000C00010L});
        public static final BitSet FOLLOW_23_in_ruleRecursionSub1810 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_24_in_ruleRecursionSub1828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop_in_entryRuleLoop1878 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoop1888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleLoop1925 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop1942 = new BitSet(new long[]{0x0000000004000072L});
        public static final BitSet FOLLOW_26_in_ruleLoop1961 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop1978 = new BitSet(new long[]{0x0000000004000062L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLoop2003 = new BitSet(new long[]{0x0000000000000062L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleLoop2031 = new BitSet(new long[]{0x0000000000000062L});
        public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression2074 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression2084 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleExpression2121 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleAdd_in_ruleExpression2143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAdd_in_entryRuleAdd2178 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAdd2188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMult_in_ruleAdd2235 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_28_in_ruleAdd2256 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleMult_in_ruleAdd2277 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_ruleMult_in_entryRuleMult2315 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMult2325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrim_in_ruleMult2372 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleMult2393 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_rulePrim_in_ruleMult2414 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rulePrim_in_entryRulePrim2452 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrim2462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rulePrim2514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePrim2553 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_rulePrim2570 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleAdd_in_rulePrim2591 = new BitSet(new long[]{0x0000000180000000L});
        public static final BitSet FOLLOW_31_in_rulePrim2604 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleAdd_in_rulePrim2625 = new BitSet(new long[]{0x0000000180000000L});
        public static final BitSet FOLLOW_32_in_rulePrim2639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rulePrim2668 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_rulePrim_in_rulePrim2689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rulePrim2709 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleAdd_in_rulePrim2731 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_rulePrim2742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCalls12_in_entryRuleRuleCalls122779 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCalls122789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleRuleCalls122826 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleConstructor_in_ruleRuleCalls122847 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleField_in_ruleRuleCalls122868 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_35_in_ruleRuleCalls122880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstructor_in_entryRuleConstructor2916 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstructor2926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleConstructor2978 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleField_in_entryRuleField3028 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleField3038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleField3074 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleField3095 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter3130 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameter3140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleParameter3192 = new BitSet(new long[]{0x0000000000000002L});
    }


}