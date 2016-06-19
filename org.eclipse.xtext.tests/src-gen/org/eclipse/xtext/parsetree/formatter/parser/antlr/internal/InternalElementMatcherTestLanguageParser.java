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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'kw1'", "'.'", "'#2'", "'sub'", "'ass1'", "'ass2'", "'#3'", "'sub2'", "'sub3'", "'#4'", "'{'", "'}'", "';'", "'#5'", "'gr'", "'#6'", "'+'", "'*'", "'('", "','", "')'", "'=>'", "'#7'", "'kw3'", "'kw2'", "'#8'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalElementMatcherTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalElementMatcherTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalElementMatcherTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalElementMatcherTestLanguage.g"; }



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
    // InternalElementMatcherTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalElementMatcherTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalElementMatcherTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:76:1: ruleModel returns [EObject current=null] : (this_Simple_0= ruleSimple | this_RuleCalls_1= ruleRuleCalls | this_OptionalCalls_2= ruleOptionalCalls | this_Recursion_3= ruleRecursion | this_Loop_4= ruleLoop | this_Expression_5= ruleExpression | this_RuleCalls12_6= ruleRuleCalls12 | this_NestedStart_7= ruleNestedStart ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_Simple_0 = null;

        EObject this_RuleCalls_1 = null;

        EObject this_OptionalCalls_2 = null;

        EObject this_Recursion_3 = null;

        EObject this_Loop_4 = null;

        EObject this_Expression_5 = null;

        EObject this_RuleCalls12_6 = null;

        EObject this_NestedStart_7 = null;


         enterRule(); 
            
        try {
            // InternalElementMatcherTestLanguage.g:79:28: ( (this_Simple_0= ruleSimple | this_RuleCalls_1= ruleRuleCalls | this_OptionalCalls_2= ruleOptionalCalls | this_Recursion_3= ruleRecursion | this_Loop_4= ruleLoop | this_Expression_5= ruleExpression | this_RuleCalls12_6= ruleRuleCalls12 | this_NestedStart_7= ruleNestedStart ) )
            // InternalElementMatcherTestLanguage.g:80:1: (this_Simple_0= ruleSimple | this_RuleCalls_1= ruleRuleCalls | this_OptionalCalls_2= ruleOptionalCalls | this_Recursion_3= ruleRecursion | this_Loop_4= ruleLoop | this_Expression_5= ruleExpression | this_RuleCalls12_6= ruleRuleCalls12 | this_NestedStart_7= ruleNestedStart )
            {
            // InternalElementMatcherTestLanguage.g:80:1: (this_Simple_0= ruleSimple | this_RuleCalls_1= ruleRuleCalls | this_OptionalCalls_2= ruleOptionalCalls | this_Recursion_3= ruleRecursion | this_Loop_4= ruleLoop | this_Expression_5= ruleExpression | this_RuleCalls12_6= ruleRuleCalls12 | this_NestedStart_7= ruleNestedStart )
            int alt1=8;
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
            case 37:
                {
                alt1=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalElementMatcherTestLanguage.g:81:5: this_Simple_0= ruleSimple
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getSimpleParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Simple_0=ruleSimple();

                    state._fsp--;

                     
                            current = this_Simple_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalElementMatcherTestLanguage.g:91:5: this_RuleCalls_1= ruleRuleCalls
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getRuleCallsParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RuleCalls_1=ruleRuleCalls();

                    state._fsp--;

                     
                            current = this_RuleCalls_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalElementMatcherTestLanguage.g:101:5: this_OptionalCalls_2= ruleOptionalCalls
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getOptionalCallsParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_OptionalCalls_2=ruleOptionalCalls();

                    state._fsp--;

                     
                            current = this_OptionalCalls_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalElementMatcherTestLanguage.g:111:5: this_Recursion_3= ruleRecursion
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getRecursionParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Recursion_3=ruleRecursion();

                    state._fsp--;

                     
                            current = this_Recursion_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // InternalElementMatcherTestLanguage.g:121:5: this_Loop_4= ruleLoop
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getLoopParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Loop_4=ruleLoop();

                    state._fsp--;

                     
                            current = this_Loop_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // InternalElementMatcherTestLanguage.g:131:5: this_Expression_5= ruleExpression
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getExpressionParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Expression_5=ruleExpression();

                    state._fsp--;

                     
                            current = this_Expression_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // InternalElementMatcherTestLanguage.g:141:5: this_RuleCalls12_6= ruleRuleCalls12
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getRuleCalls12ParserRuleCall_6()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RuleCalls12_6=ruleRuleCalls12();

                    state._fsp--;

                     
                            current = this_RuleCalls12_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // InternalElementMatcherTestLanguage.g:151:5: this_NestedStart_7= ruleNestedStart
                    {
                     
                            newCompositeNode(grammarAccess.getModelAccess().getNestedStartParserRuleCall_7()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NestedStart_7=ruleNestedStart();

                    state._fsp--;

                     
                            current = this_NestedStart_7; 
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
    // InternalElementMatcherTestLanguage.g:167:1: entryRuleSimple returns [EObject current=null] : iv_ruleSimple= ruleSimple EOF ;
    public final EObject entryRuleSimple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimple = null;


        try {
            // InternalElementMatcherTestLanguage.g:168:2: (iv_ruleSimple= ruleSimple EOF )
            // InternalElementMatcherTestLanguage.g:169:2: iv_ruleSimple= ruleSimple EOF
            {
             newCompositeNode(grammarAccess.getSimpleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSimple=ruleSimple();

            state._fsp--;

             current =iv_ruleSimple; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:176:1: ruleSimple returns [EObject current=null] : (otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) ) ;
    public final EObject ruleSimple() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_optional_3_0=null;
        AntlrDatatypeRuleToken lv_datatype_4_0 = null;


         enterRule(); 
            
        try {
            // InternalElementMatcherTestLanguage.g:179:28: ( (otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) ) )
            // InternalElementMatcherTestLanguage.g:180:1: (otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) )
            {
            // InternalElementMatcherTestLanguage.g:180:1: (otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) )
            // InternalElementMatcherTestLanguage.g:180:3: otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleAccess().getNumberSignDigitOneKeyword_0());
                
            // InternalElementMatcherTestLanguage.g:184:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalElementMatcherTestLanguage.g:185:1: (lv_name_1_0= RULE_ID )
            {
            // InternalElementMatcherTestLanguage.g:185:1: (lv_name_1_0= RULE_ID )
            // InternalElementMatcherTestLanguage.g:186:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSimpleAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalElementMatcherTestLanguage.g:202:2: (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalElementMatcherTestLanguage.g:202:4: otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_2, grammarAccess.getSimpleAccess().getKw1Keyword_2_0());
                        
                    // InternalElementMatcherTestLanguage.g:206:1: ( (lv_optional_3_0= RULE_ID ) )
                    // InternalElementMatcherTestLanguage.g:207:1: (lv_optional_3_0= RULE_ID )
                    {
                    // InternalElementMatcherTestLanguage.g:207:1: (lv_optional_3_0= RULE_ID )
                    // InternalElementMatcherTestLanguage.g:208:3: lv_optional_3_0= RULE_ID
                    {
                    lv_optional_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

                    			newLeafNode(lv_optional_3_0, grammarAccess.getSimpleAccess().getOptionalIDTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"optional",
                            		lv_optional_3_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalElementMatcherTestLanguage.g:224:4: ( (lv_datatype_4_0= ruleFQN ) )
            // InternalElementMatcherTestLanguage.g:225:1: (lv_datatype_4_0= ruleFQN )
            {
            // InternalElementMatcherTestLanguage.g:225:1: (lv_datatype_4_0= ruleFQN )
            // InternalElementMatcherTestLanguage.g:226:3: lv_datatype_4_0= ruleFQN
            {
             
            	        newCompositeNode(grammarAccess.getSimpleAccess().getDatatypeFQNParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            lv_datatype_4_0=ruleFQN();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSimpleRule());
            	        }
                   		set(
                   			current, 
                   			"datatype",
                    		lv_datatype_4_0, 
                    		"org.eclipse.xtext.parsetree.formatter.ElementMatcherTestLanguage.FQN");
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
    // InternalElementMatcherTestLanguage.g:250:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalElementMatcherTestLanguage.g:251:2: (iv_ruleFQN= ruleFQN EOF )
            // InternalElementMatcherTestLanguage.g:252:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:259:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalElementMatcherTestLanguage.g:262:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) ) )
            // InternalElementMatcherTestLanguage.g:263:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) )
            {
            // InternalElementMatcherTestLanguage.g:263:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) )
            // InternalElementMatcherTestLanguage.g:263:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // InternalElementMatcherTestLanguage.g:270:1: (kw= '.' this_ID_2= RULE_ID )
            // InternalElementMatcherTestLanguage.g:271:2: kw= '.' this_ID_2= RULE_ID
            {
            kw=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
                
            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:291:1: entryRuleRuleCalls returns [EObject current=null] : iv_ruleRuleCalls= ruleRuleCalls EOF ;
    public final EObject entryRuleRuleCalls() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCalls = null;


        try {
            // InternalElementMatcherTestLanguage.g:292:2: (iv_ruleRuleCalls= ruleRuleCalls EOF )
            // InternalElementMatcherTestLanguage.g:293:2: iv_ruleRuleCalls= ruleRuleCalls EOF
            {
             newCompositeNode(grammarAccess.getRuleCallsRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRuleCalls=ruleRuleCalls();

            state._fsp--;

             current =iv_ruleRuleCalls; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:300:1: ruleRuleCalls returns [EObject current=null] : (otherlv_0= '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? ) ;
    public final EObject ruleRuleCalls() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;
        EObject this_RuleCallsSub_1 = null;

        EObject lv_call1_3_0 = null;

        EObject lv_call2_4_0 = null;


         enterRule(); 
            
        try {
            // InternalElementMatcherTestLanguage.g:303:28: ( (otherlv_0= '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? ) )
            // InternalElementMatcherTestLanguage.g:304:1: (otherlv_0= '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? )
            {
            // InternalElementMatcherTestLanguage.g:304:1: (otherlv_0= '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? )
            // InternalElementMatcherTestLanguage.g:304:3: otherlv_0= '#2' this_RuleCallsSub_1= ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )?
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getRuleCallsAccess().getNumberSignDigitTwoKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getRuleCallsAccess().getRuleCallsSubParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_3);
            this_RuleCallsSub_1=ruleRuleCallsSub();

            state._fsp--;

             
                    current = this_RuleCallsSub_1; 
                    afterParserOrEnumRuleCall();
                
            // InternalElementMatcherTestLanguage.g:317:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalElementMatcherTestLanguage.g:318:1: (lv_name_2_0= RULE_ID )
            {
            // InternalElementMatcherTestLanguage.g:318:1: (lv_name_2_0= RULE_ID )
            // InternalElementMatcherTestLanguage.g:319:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            			newLeafNode(lv_name_2_0, grammarAccess.getRuleCallsAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleCallsRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalElementMatcherTestLanguage.g:335:2: ( (lv_call1_3_0= ruleRuleCallsAss1 ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalElementMatcherTestLanguage.g:336:1: (lv_call1_3_0= ruleRuleCallsAss1 )
                    {
                    // InternalElementMatcherTestLanguage.g:336:1: (lv_call1_3_0= ruleRuleCallsAss1 )
                    // InternalElementMatcherTestLanguage.g:337:3: lv_call1_3_0= ruleRuleCallsAss1
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuleCallsAccess().getCall1RuleCallsAss1ParserRuleCall_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_8);
                    lv_call1_3_0=ruleRuleCallsAss1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRuleCallsRule());
                    	        }
                           		set(
                           			current, 
                           			"call1",
                            		lv_call1_3_0, 
                            		"org.eclipse.xtext.parsetree.formatter.ElementMatcherTestLanguage.RuleCallsAss1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalElementMatcherTestLanguage.g:353:3: ( (lv_call2_4_0= ruleRuleCallsAss2 ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalElementMatcherTestLanguage.g:354:1: (lv_call2_4_0= ruleRuleCallsAss2 )
                    {
                    // InternalElementMatcherTestLanguage.g:354:1: (lv_call2_4_0= ruleRuleCallsAss2 )
                    // InternalElementMatcherTestLanguage.g:355:3: lv_call2_4_0= ruleRuleCallsAss2
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuleCallsAccess().getCall2RuleCallsAss2ParserRuleCall_4_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_call2_4_0=ruleRuleCallsAss2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRuleCallsRule());
                    	        }
                           		set(
                           			current, 
                           			"call2",
                            		lv_call2_4_0, 
                            		"org.eclipse.xtext.parsetree.formatter.ElementMatcherTestLanguage.RuleCallsAss2");
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
    // InternalElementMatcherTestLanguage.g:379:1: entryRuleRuleCallsSub returns [EObject current=null] : iv_ruleRuleCallsSub= ruleRuleCallsSub EOF ;
    public final EObject entryRuleRuleCallsSub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallsSub = null;


        try {
            // InternalElementMatcherTestLanguage.g:380:2: (iv_ruleRuleCallsSub= ruleRuleCallsSub EOF )
            // InternalElementMatcherTestLanguage.g:381:2: iv_ruleRuleCallsSub= ruleRuleCallsSub EOF
            {
             newCompositeNode(grammarAccess.getRuleCallsSubRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRuleCallsSub=ruleRuleCallsSub();

            state._fsp--;

             current =iv_ruleRuleCallsSub; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:388:1: ruleRuleCallsSub returns [EObject current=null] : ( (lv_sub_0_0= 'sub' ) ) ;
    public final EObject ruleRuleCallsSub() throws RecognitionException {
        EObject current = null;

        Token lv_sub_0_0=null;

         enterRule(); 
            
        try {
            // InternalElementMatcherTestLanguage.g:391:28: ( ( (lv_sub_0_0= 'sub' ) ) )
            // InternalElementMatcherTestLanguage.g:392:1: ( (lv_sub_0_0= 'sub' ) )
            {
            // InternalElementMatcherTestLanguage.g:392:1: ( (lv_sub_0_0= 'sub' ) )
            // InternalElementMatcherTestLanguage.g:393:1: (lv_sub_0_0= 'sub' )
            {
            // InternalElementMatcherTestLanguage.g:393:1: (lv_sub_0_0= 'sub' )
            // InternalElementMatcherTestLanguage.g:394:3: lv_sub_0_0= 'sub'
            {
            lv_sub_0_0=(Token)match(input,15,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:415:1: entryRuleRuleCallsAss1 returns [EObject current=null] : iv_ruleRuleCallsAss1= ruleRuleCallsAss1 EOF ;
    public final EObject entryRuleRuleCallsAss1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallsAss1 = null;


        try {
            // InternalElementMatcherTestLanguage.g:416:2: (iv_ruleRuleCallsAss1= ruleRuleCallsAss1 EOF )
            // InternalElementMatcherTestLanguage.g:417:2: iv_ruleRuleCallsAss1= ruleRuleCallsAss1 EOF
            {
             newCompositeNode(grammarAccess.getRuleCallsAss1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRuleCallsAss1=ruleRuleCallsAss1();

            state._fsp--;

             current =iv_ruleRuleCallsAss1; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:424:1: ruleRuleCallsAss1 returns [EObject current=null] : (otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleRuleCallsAss1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalElementMatcherTestLanguage.g:427:28: ( (otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalElementMatcherTestLanguage.g:428:1: (otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalElementMatcherTestLanguage.g:428:1: (otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalElementMatcherTestLanguage.g:428:3: otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRuleCallsAss1Access().getAss1Keyword_0());
                
            // InternalElementMatcherTestLanguage.g:432:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalElementMatcherTestLanguage.g:433:1: (lv_name_1_0= RULE_ID )
            {
            // InternalElementMatcherTestLanguage.g:433:1: (lv_name_1_0= RULE_ID )
            // InternalElementMatcherTestLanguage.g:434:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_1_0, grammarAccess.getRuleCallsAss1Access().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleCallsAss1Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // InternalElementMatcherTestLanguage.g:458:1: entryRuleRuleCallsAss2 returns [EObject current=null] : iv_ruleRuleCallsAss2= ruleRuleCallsAss2 EOF ;
    public final EObject entryRuleRuleCallsAss2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCallsAss2 = null;


        try {
            // InternalElementMatcherTestLanguage.g:459:2: (iv_ruleRuleCallsAss2= ruleRuleCallsAss2 EOF )
            // InternalElementMatcherTestLanguage.g:460:2: iv_ruleRuleCallsAss2= ruleRuleCallsAss2 EOF
            {
             newCompositeNode(grammarAccess.getRuleCallsAss2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRuleCallsAss2=ruleRuleCallsAss2();

            state._fsp--;

             current =iv_ruleRuleCallsAss2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:467:1: ruleRuleCallsAss2 returns [EObject current=null] : (otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleRuleCallsAss2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalElementMatcherTestLanguage.g:470:28: ( (otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalElementMatcherTestLanguage.g:471:1: (otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalElementMatcherTestLanguage.g:471:1: (otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalElementMatcherTestLanguage.g:471:3: otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRuleCallsAss2Access().getAss2Keyword_0());
                
            // InternalElementMatcherTestLanguage.g:475:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalElementMatcherTestLanguage.g:476:1: (lv_name_1_0= RULE_ID )
            {
            // InternalElementMatcherTestLanguage.g:476:1: (lv_name_1_0= RULE_ID )
            // InternalElementMatcherTestLanguage.g:477:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_1_0, grammarAccess.getRuleCallsAss2Access().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleCallsAss2Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // InternalElementMatcherTestLanguage.g:501:1: entryRuleOptionalCalls returns [EObject current=null] : iv_ruleOptionalCalls= ruleOptionalCalls EOF ;
    public final EObject entryRuleOptionalCalls() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalCalls = null;


        try {
            // InternalElementMatcherTestLanguage.g:502:2: (iv_ruleOptionalCalls= ruleOptionalCalls EOF )
            // InternalElementMatcherTestLanguage.g:503:2: iv_ruleOptionalCalls= ruleOptionalCalls EOF
            {
             newCompositeNode(grammarAccess.getOptionalCallsRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOptionalCalls=ruleOptionalCalls();

            state._fsp--;

             current =iv_ruleOptionalCalls; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:510:1: ruleOptionalCalls returns [EObject current=null] : (otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleOptionalCalls() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_3_0=null;
        EObject lv_opt1_2_0 = null;


         enterRule(); 
            
        try {
            // InternalElementMatcherTestLanguage.g:513:28: ( (otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalElementMatcherTestLanguage.g:514:1: (otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalElementMatcherTestLanguage.g:514:1: (otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) )
            // InternalElementMatcherTestLanguage.g:514:3: otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_9); 

                	newLeafNode(otherlv_0, grammarAccess.getOptionalCallsAccess().getNumberSignDigitThreeKeyword_0());
                
            // InternalElementMatcherTestLanguage.g:518:1: ()
            // InternalElementMatcherTestLanguage.g:519:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getOptionalCallsAccess().getOptionalCallsAction_1(),
                        current);
                

            }

            // InternalElementMatcherTestLanguage.g:524:2: ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15||LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalElementMatcherTestLanguage.g:525:1: (lv_opt1_2_0= ruleOptionalCallsSub1 )
                    {
                    // InternalElementMatcherTestLanguage.g:525:1: (lv_opt1_2_0= ruleOptionalCallsSub1 )
                    // InternalElementMatcherTestLanguage.g:526:3: lv_opt1_2_0= ruleOptionalCallsSub1
                    {
                     
                    	        newCompositeNode(grammarAccess.getOptionalCallsAccess().getOpt1OptionalCallsSub1ParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_3);
                    lv_opt1_2_0=ruleOptionalCallsSub1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOptionalCallsRule());
                    	        }
                           		set(
                           			current, 
                           			"opt1",
                            		lv_opt1_2_0, 
                            		"org.eclipse.xtext.parsetree.formatter.ElementMatcherTestLanguage.OptionalCallsSub1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalElementMatcherTestLanguage.g:542:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalElementMatcherTestLanguage.g:543:1: (lv_name_3_0= RULE_ID )
            {
            // InternalElementMatcherTestLanguage.g:543:1: (lv_name_3_0= RULE_ID )
            // InternalElementMatcherTestLanguage.g:544:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_3_0, grammarAccess.getOptionalCallsAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOptionalCallsRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // InternalElementMatcherTestLanguage.g:568:1: entryRuleOptionalCallsSub1 returns [EObject current=null] : iv_ruleOptionalCallsSub1= ruleOptionalCallsSub1 EOF ;
    public final EObject entryRuleOptionalCallsSub1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalCallsSub1 = null;


        try {
            // InternalElementMatcherTestLanguage.g:569:2: (iv_ruleOptionalCallsSub1= ruleOptionalCallsSub1 EOF )
            // InternalElementMatcherTestLanguage.g:570:2: iv_ruleOptionalCallsSub1= ruleOptionalCallsSub1 EOF
            {
             newCompositeNode(grammarAccess.getOptionalCallsSub1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOptionalCallsSub1=ruleOptionalCallsSub1();

            state._fsp--;

             current =iv_ruleOptionalCallsSub1; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:577:1: ruleOptionalCallsSub1 returns [EObject current=null] : ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? ) ;
    public final EObject ruleOptionalCallsSub1() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_opt2_1_0 = null;

        EObject lv_opt3_3_0 = null;


         enterRule(); 
            
        try {
            // InternalElementMatcherTestLanguage.g:580:28: ( ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? ) )
            // InternalElementMatcherTestLanguage.g:581:1: ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? )
            {
            // InternalElementMatcherTestLanguage.g:581:1: ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? )
            // InternalElementMatcherTestLanguage.g:581:2: () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )?
            {
            // InternalElementMatcherTestLanguage.g:581:2: ()
            // InternalElementMatcherTestLanguage.g:582:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getOptionalCallsSub1Access().getOptionalCallsSub1Action_0(),
                        current);
                

            }

            // InternalElementMatcherTestLanguage.g:587:2: ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalElementMatcherTestLanguage.g:588:1: (lv_opt2_1_0= ruleOptionalCallsSub2 )
                    {
                    // InternalElementMatcherTestLanguage.g:588:1: (lv_opt2_1_0= ruleOptionalCallsSub2 )
                    // InternalElementMatcherTestLanguage.g:589:3: lv_opt2_1_0= ruleOptionalCallsSub2
                    {
                     
                    	        newCompositeNode(grammarAccess.getOptionalCallsSub1Access().getOpt2OptionalCallsSub2ParserRuleCall_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_6);
                    lv_opt2_1_0=ruleOptionalCallsSub2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOptionalCallsSub1Rule());
                    	        }
                           		set(
                           			current, 
                           			"opt2",
                            		lv_opt2_1_0, 
                            		"org.eclipse.xtext.parsetree.formatter.ElementMatcherTestLanguage.OptionalCallsSub2");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_2, grammarAccess.getOptionalCallsSub1Access().getSubKeyword_2());
                
            // InternalElementMatcherTestLanguage.g:609:1: ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalElementMatcherTestLanguage.g:610:1: (lv_opt3_3_0= ruleOptionalCallsSub3 )
                    {
                    // InternalElementMatcherTestLanguage.g:610:1: (lv_opt3_3_0= ruleOptionalCallsSub3 )
                    // InternalElementMatcherTestLanguage.g:611:3: lv_opt3_3_0= ruleOptionalCallsSub3
                    {
                     
                    	        newCompositeNode(grammarAccess.getOptionalCallsSub1Access().getOpt3OptionalCallsSub3ParserRuleCall_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_opt3_3_0=ruleOptionalCallsSub3();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOptionalCallsSub1Rule());
                    	        }
                           		set(
                           			current, 
                           			"opt3",
                            		lv_opt3_3_0, 
                            		"org.eclipse.xtext.parsetree.formatter.ElementMatcherTestLanguage.OptionalCallsSub3");
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
    // InternalElementMatcherTestLanguage.g:635:1: entryRuleOptionalCallsSub2 returns [EObject current=null] : iv_ruleOptionalCallsSub2= ruleOptionalCallsSub2 EOF ;
    public final EObject entryRuleOptionalCallsSub2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalCallsSub2 = null;


        try {
            // InternalElementMatcherTestLanguage.g:636:2: (iv_ruleOptionalCallsSub2= ruleOptionalCallsSub2 EOF )
            // InternalElementMatcherTestLanguage.g:637:2: iv_ruleOptionalCallsSub2= ruleOptionalCallsSub2 EOF
            {
             newCompositeNode(grammarAccess.getOptionalCallsSub2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOptionalCallsSub2=ruleOptionalCallsSub2();

            state._fsp--;

             current =iv_ruleOptionalCallsSub2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:644:1: ruleOptionalCallsSub2 returns [EObject current=null] : (otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleOptionalCallsSub2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalElementMatcherTestLanguage.g:647:28: ( (otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalElementMatcherTestLanguage.g:648:1: (otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalElementMatcherTestLanguage.g:648:1: (otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalElementMatcherTestLanguage.g:648:3: otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getOptionalCallsSub2Access().getSub2Keyword_0());
                
            // InternalElementMatcherTestLanguage.g:652:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalElementMatcherTestLanguage.g:653:1: (lv_name_1_0= RULE_ID )
            {
            // InternalElementMatcherTestLanguage.g:653:1: (lv_name_1_0= RULE_ID )
            // InternalElementMatcherTestLanguage.g:654:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_1_0, grammarAccess.getOptionalCallsSub2Access().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOptionalCallsSub2Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // InternalElementMatcherTestLanguage.g:678:1: entryRuleOptionalCallsSub3 returns [EObject current=null] : iv_ruleOptionalCallsSub3= ruleOptionalCallsSub3 EOF ;
    public final EObject entryRuleOptionalCallsSub3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalCallsSub3 = null;


        try {
            // InternalElementMatcherTestLanguage.g:679:2: (iv_ruleOptionalCallsSub3= ruleOptionalCallsSub3 EOF )
            // InternalElementMatcherTestLanguage.g:680:2: iv_ruleOptionalCallsSub3= ruleOptionalCallsSub3 EOF
            {
             newCompositeNode(grammarAccess.getOptionalCallsSub3Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOptionalCallsSub3=ruleOptionalCallsSub3();

            state._fsp--;

             current =iv_ruleOptionalCallsSub3; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:687:1: ruleOptionalCallsSub3 returns [EObject current=null] : (otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleOptionalCallsSub3() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalElementMatcherTestLanguage.g:690:28: ( (otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalElementMatcherTestLanguage.g:691:1: (otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalElementMatcherTestLanguage.g:691:1: (otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalElementMatcherTestLanguage.g:691:3: otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getOptionalCallsSub3Access().getSub3Keyword_0());
                
            // InternalElementMatcherTestLanguage.g:695:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalElementMatcherTestLanguage.g:696:1: (lv_name_1_0= RULE_ID )
            {
            // InternalElementMatcherTestLanguage.g:696:1: (lv_name_1_0= RULE_ID )
            // InternalElementMatcherTestLanguage.g:697:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_1_0, grammarAccess.getOptionalCallsSub3Access().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOptionalCallsSub3Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // InternalElementMatcherTestLanguage.g:721:1: entryRuleRecursion returns [EObject current=null] : iv_ruleRecursion= ruleRecursion EOF ;
    public final EObject entryRuleRecursion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecursion = null;


        try {
            // InternalElementMatcherTestLanguage.g:722:2: (iv_ruleRecursion= ruleRecursion EOF )
            // InternalElementMatcherTestLanguage.g:723:2: iv_ruleRecursion= ruleRecursion EOF
            {
             newCompositeNode(grammarAccess.getRecursionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRecursion=ruleRecursion();

            state._fsp--;

             current =iv_ruleRecursion; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:730:1: ruleRecursion returns [EObject current=null] : (otherlv_0= '#4' this_RecursionSub_1= ruleRecursionSub ) ;
    public final EObject ruleRecursion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_RecursionSub_1 = null;


         enterRule(); 
            
        try {
            // InternalElementMatcherTestLanguage.g:733:28: ( (otherlv_0= '#4' this_RecursionSub_1= ruleRecursionSub ) )
            // InternalElementMatcherTestLanguage.g:734:1: (otherlv_0= '#4' this_RecursionSub_1= ruleRecursionSub )
            {
            // InternalElementMatcherTestLanguage.g:734:1: (otherlv_0= '#4' this_RecursionSub_1= ruleRecursionSub )
            // InternalElementMatcherTestLanguage.g:734:3: otherlv_0= '#4' this_RecursionSub_1= ruleRecursionSub
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_11); 

                	newLeafNode(otherlv_0, grammarAccess.getRecursionAccess().getNumberSignDigitFourKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getRecursionAccess().getRecursionSubParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalElementMatcherTestLanguage.g:755:1: entryRuleRecursionSub returns [EObject current=null] : iv_ruleRecursionSub= ruleRecursionSub EOF ;
    public final EObject entryRuleRecursionSub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecursionSub = null;


        try {
            // InternalElementMatcherTestLanguage.g:756:2: (iv_ruleRecursionSub= ruleRecursionSub EOF )
            // InternalElementMatcherTestLanguage.g:757:2: iv_ruleRecursionSub= ruleRecursionSub EOF
            {
             newCompositeNode(grammarAccess.getRecursionSubRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRecursionSub=ruleRecursionSub();

            state._fsp--;

             current =iv_ruleRecursionSub; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:764:1: ruleRecursionSub returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? ) ;
    public final EObject ruleRecursionSub() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_vals_3_0=null;
        Token otherlv_4=null;
        Token lv_semi_5_0=null;
        EObject lv_sub_2_0 = null;


         enterRule(); 
            
        try {
            // InternalElementMatcherTestLanguage.g:767:28: ( ( () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? ) )
            // InternalElementMatcherTestLanguage.g:768:1: ( () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? )
            {
            // InternalElementMatcherTestLanguage.g:768:1: ( () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? )
            // InternalElementMatcherTestLanguage.g:768:2: () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )?
            {
            // InternalElementMatcherTestLanguage.g:768:2: ()
            // InternalElementMatcherTestLanguage.g:769:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRecursionSubAccess().getRecursionSubAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_12); 

                	newLeafNode(otherlv_1, grammarAccess.getRecursionSubAccess().getLeftCurlyBracketKeyword_1());
                
            // InternalElementMatcherTestLanguage.g:778:1: ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )*
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
            	    // InternalElementMatcherTestLanguage.g:778:2: ( (lv_sub_2_0= ruleRecursionSub ) )
            	    {
            	    // InternalElementMatcherTestLanguage.g:778:2: ( (lv_sub_2_0= ruleRecursionSub ) )
            	    // InternalElementMatcherTestLanguage.g:779:1: (lv_sub_2_0= ruleRecursionSub )
            	    {
            	    // InternalElementMatcherTestLanguage.g:779:1: (lv_sub_2_0= ruleRecursionSub )
            	    // InternalElementMatcherTestLanguage.g:780:3: lv_sub_2_0= ruleRecursionSub
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRecursionSubAccess().getSubRecursionSubParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_12);
            	    lv_sub_2_0=ruleRecursionSub();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRecursionSubRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"sub",
            	            		lv_sub_2_0, 
            	            		"org.eclipse.xtext.parsetree.formatter.ElementMatcherTestLanguage.RecursionSub");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalElementMatcherTestLanguage.g:797:6: ( (lv_vals_3_0= RULE_ID ) )
            	    {
            	    // InternalElementMatcherTestLanguage.g:797:6: ( (lv_vals_3_0= RULE_ID ) )
            	    // InternalElementMatcherTestLanguage.g:798:1: (lv_vals_3_0= RULE_ID )
            	    {
            	    // InternalElementMatcherTestLanguage.g:798:1: (lv_vals_3_0= RULE_ID )
            	    // InternalElementMatcherTestLanguage.g:799:3: lv_vals_3_0= RULE_ID
            	    {
            	    lv_vals_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            	    			newLeafNode(lv_vals_3_0, grammarAccess.getRecursionSubAccess().getValsIDTerminalRuleCall_2_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRecursionSubRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"vals",
            	            		lv_vals_3_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_13); 

                	newLeafNode(otherlv_4, grammarAccess.getRecursionSubAccess().getRightCurlyBracketKeyword_3());
                
            // InternalElementMatcherTestLanguage.g:819:1: ( (lv_semi_5_0= ';' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalElementMatcherTestLanguage.g:820:1: (lv_semi_5_0= ';' )
                    {
                    // InternalElementMatcherTestLanguage.g:820:1: (lv_semi_5_0= ';' )
                    // InternalElementMatcherTestLanguage.g:821:3: lv_semi_5_0= ';'
                    {
                    lv_semi_5_0=(Token)match(input,24,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:842:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // InternalElementMatcherTestLanguage.g:843:2: (iv_ruleLoop= ruleLoop EOF )
            // InternalElementMatcherTestLanguage.g:844:2: iv_ruleLoop= ruleLoop EOF
            {
             newCompositeNode(grammarAccess.getLoopRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLoop=ruleLoop();

            state._fsp--;

             current =iv_ruleLoop; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:851:1: ruleLoop returns [EObject current=null] : (otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* ) ;
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
            // InternalElementMatcherTestLanguage.g:854:28: ( (otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* ) )
            // InternalElementMatcherTestLanguage.g:855:1: (otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* )
            {
            // InternalElementMatcherTestLanguage.g:855:1: (otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* )
            // InternalElementMatcherTestLanguage.g:855:3: otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )*
            {
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getLoopAccess().getNumberSignDigitFiveKeyword_0());
                
            // InternalElementMatcherTestLanguage.g:859:1: ( (lv_names_1_0= RULE_ID ) )+
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
            	    // InternalElementMatcherTestLanguage.g:860:1: (lv_names_1_0= RULE_ID )
            	    {
            	    // InternalElementMatcherTestLanguage.g:860:1: (lv_names_1_0= RULE_ID )
            	    // InternalElementMatcherTestLanguage.g:861:3: lv_names_1_0= RULE_ID
            	    {
            	    lv_names_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); 

            	    			newLeafNode(lv_names_1_0, grammarAccess.getLoopAccess().getNamesIDTerminalRuleCall_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getLoopRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"names",
            	            		lv_names_1_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

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

            // InternalElementMatcherTestLanguage.g:877:3: (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==26) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalElementMatcherTestLanguage.g:877:5: otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_3); 

            	        	newLeafNode(otherlv_2, grammarAccess.getLoopAccess().getGrKeyword_2_0());
            	        
            	    // InternalElementMatcherTestLanguage.g:881:1: ( (lv_gr_3_0= RULE_ID ) )
            	    // InternalElementMatcherTestLanguage.g:882:1: (lv_gr_3_0= RULE_ID )
            	    {
            	    // InternalElementMatcherTestLanguage.g:882:1: (lv_gr_3_0= RULE_ID )
            	    // InternalElementMatcherTestLanguage.g:883:3: lv_gr_3_0= RULE_ID
            	    {
            	    lv_gr_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); 

            	    			newLeafNode(lv_gr_3_0, grammarAccess.getLoopAccess().getGrIDTerminalRuleCall_2_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getLoopRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"gr",
            	            		lv_gr_3_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // InternalElementMatcherTestLanguage.g:899:4: ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )*
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
            	    // InternalElementMatcherTestLanguage.g:899:5: ( (lv_ints_4_0= RULE_INT ) )
            	    {
            	    // InternalElementMatcherTestLanguage.g:899:5: ( (lv_ints_4_0= RULE_INT ) )
            	    // InternalElementMatcherTestLanguage.g:900:1: (lv_ints_4_0= RULE_INT )
            	    {
            	    // InternalElementMatcherTestLanguage.g:900:1: (lv_ints_4_0= RULE_INT )
            	    // InternalElementMatcherTestLanguage.g:901:3: lv_ints_4_0= RULE_INT
            	    {
            	    lv_ints_4_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_16); 

            	    			newLeafNode(lv_ints_4_0, grammarAccess.getLoopAccess().getIntsINTTerminalRuleCall_3_0_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getLoopRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"ints",
            	            		lv_ints_4_0, 
            	            		"org.eclipse.xtext.common.Terminals.INT");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalElementMatcherTestLanguage.g:918:6: ( (lv_strings_5_0= RULE_STRING ) )
            	    {
            	    // InternalElementMatcherTestLanguage.g:918:6: ( (lv_strings_5_0= RULE_STRING ) )
            	    // InternalElementMatcherTestLanguage.g:919:1: (lv_strings_5_0= RULE_STRING )
            	    {
            	    // InternalElementMatcherTestLanguage.g:919:1: (lv_strings_5_0= RULE_STRING )
            	    // InternalElementMatcherTestLanguage.g:920:3: lv_strings_5_0= RULE_STRING
            	    {
            	    lv_strings_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_16); 

            	    			newLeafNode(lv_strings_5_0, grammarAccess.getLoopAccess().getStringsSTRINGTerminalRuleCall_3_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getLoopRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"strings",
            	            		lv_strings_5_0, 
            	            		"org.eclipse.xtext.common.Terminals.STRING");
            	    	    

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
    // InternalElementMatcherTestLanguage.g:944:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalElementMatcherTestLanguage.g:945:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalElementMatcherTestLanguage.g:946:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:953:1: ruleExpression returns [EObject current=null] : (otherlv_0= '#6' this_Add_1= ruleAdd ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Add_1 = null;


         enterRule(); 
            
        try {
            // InternalElementMatcherTestLanguage.g:956:28: ( (otherlv_0= '#6' this_Add_1= ruleAdd ) )
            // InternalElementMatcherTestLanguage.g:957:1: (otherlv_0= '#6' this_Add_1= ruleAdd )
            {
            // InternalElementMatcherTestLanguage.g:957:1: (otherlv_0= '#6' this_Add_1= ruleAdd )
            // InternalElementMatcherTestLanguage.g:957:3: otherlv_0= '#6' this_Add_1= ruleAdd
            {
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_17); 

                	newLeafNode(otherlv_0, grammarAccess.getExpressionAccess().getNumberSignDigitSixKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getExpressionAccess().getAddParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalElementMatcherTestLanguage.g:978:1: entryRuleAdd returns [EObject current=null] : iv_ruleAdd= ruleAdd EOF ;
    public final EObject entryRuleAdd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdd = null;


        try {
            // InternalElementMatcherTestLanguage.g:979:2: (iv_ruleAdd= ruleAdd EOF )
            // InternalElementMatcherTestLanguage.g:980:2: iv_ruleAdd= ruleAdd EOF
            {
             newCompositeNode(grammarAccess.getAddRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAdd=ruleAdd();

            state._fsp--;

             current =iv_ruleAdd; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:987:1: ruleAdd returns [EObject current=null] : (this_Mult_0= ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )* ) ;
    public final EObject ruleAdd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Mult_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalElementMatcherTestLanguage.g:990:28: ( (this_Mult_0= ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )* ) )
            // InternalElementMatcherTestLanguage.g:991:1: (this_Mult_0= ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )* )
            {
            // InternalElementMatcherTestLanguage.g:991:1: (this_Mult_0= ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )* )
            // InternalElementMatcherTestLanguage.g:992:5: this_Mult_0= ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAddAccess().getMultParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_18);
            this_Mult_0=ruleMult();

            state._fsp--;

             
                    current = this_Mult_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalElementMatcherTestLanguage.g:1000:1: ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==28) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalElementMatcherTestLanguage.g:1000:2: () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) )
            	    {
            	    // InternalElementMatcherTestLanguage.g:1000:2: ()
            	    // InternalElementMatcherTestLanguage.g:1001:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAddAccess().getAddLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,28,FollowSets000.FOLLOW_17); 

            	        	newLeafNode(otherlv_2, grammarAccess.getAddAccess().getPlusSignKeyword_1_1());
            	        
            	    // InternalElementMatcherTestLanguage.g:1010:1: ( (lv_right_3_0= ruleMult ) )
            	    // InternalElementMatcherTestLanguage.g:1011:1: (lv_right_3_0= ruleMult )
            	    {
            	    // InternalElementMatcherTestLanguage.g:1011:1: (lv_right_3_0= ruleMult )
            	    // InternalElementMatcherTestLanguage.g:1012:3: lv_right_3_0= ruleMult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAddAccess().getRightMultParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_18);
            	    lv_right_3_0=ruleMult();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAddRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"org.eclipse.xtext.parsetree.formatter.ElementMatcherTestLanguage.Mult");
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
    // InternalElementMatcherTestLanguage.g:1036:1: entryRuleMult returns [EObject current=null] : iv_ruleMult= ruleMult EOF ;
    public final EObject entryRuleMult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMult = null;


        try {
            // InternalElementMatcherTestLanguage.g:1037:2: (iv_ruleMult= ruleMult EOF )
            // InternalElementMatcherTestLanguage.g:1038:2: iv_ruleMult= ruleMult EOF
            {
             newCompositeNode(grammarAccess.getMultRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMult=ruleMult();

            state._fsp--;

             current =iv_ruleMult; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:1045:1: ruleMult returns [EObject current=null] : (this_Prim_0= rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )* ) ;
    public final EObject ruleMult() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Prim_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalElementMatcherTestLanguage.g:1048:28: ( (this_Prim_0= rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )* ) )
            // InternalElementMatcherTestLanguage.g:1049:1: (this_Prim_0= rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )* )
            {
            // InternalElementMatcherTestLanguage.g:1049:1: (this_Prim_0= rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )* )
            // InternalElementMatcherTestLanguage.g:1050:5: this_Prim_0= rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getMultAccess().getPrimParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_19);
            this_Prim_0=rulePrim();

            state._fsp--;

             
                    current = this_Prim_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalElementMatcherTestLanguage.g:1058:1: ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==29) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalElementMatcherTestLanguage.g:1058:2: () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) )
            	    {
            	    // InternalElementMatcherTestLanguage.g:1058:2: ()
            	    // InternalElementMatcherTestLanguage.g:1059:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getMultAccess().getMultLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_17); 

            	        	newLeafNode(otherlv_2, grammarAccess.getMultAccess().getAsteriskKeyword_1_1());
            	        
            	    // InternalElementMatcherTestLanguage.g:1068:1: ( (lv_right_3_0= rulePrim ) )
            	    // InternalElementMatcherTestLanguage.g:1069:1: (lv_right_3_0= rulePrim )
            	    {
            	    // InternalElementMatcherTestLanguage.g:1069:1: (lv_right_3_0= rulePrim )
            	    // InternalElementMatcherTestLanguage.g:1070:3: lv_right_3_0= rulePrim
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultAccess().getRightPrimParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_19);
            	    lv_right_3_0=rulePrim();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMultRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"org.eclipse.xtext.parsetree.formatter.ElementMatcherTestLanguage.Prim");
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
    // InternalElementMatcherTestLanguage.g:1094:1: entryRulePrim returns [EObject current=null] : iv_rulePrim= rulePrim EOF ;
    public final EObject entryRulePrim() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrim = null;


        try {
            // InternalElementMatcherTestLanguage.g:1095:2: (iv_rulePrim= rulePrim EOF )
            // InternalElementMatcherTestLanguage.g:1096:2: iv_rulePrim= rulePrim EOF
            {
             newCompositeNode(grammarAccess.getPrimRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrim=rulePrim();

            state._fsp--;

             current =iv_rulePrim; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:1103:1: rulePrim returns [EObject current=null] : ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' ) | ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) ) | (otherlv_12= '(' this_Add_13= ruleAdd otherlv_14= ')' ) ) ;
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
            // InternalElementMatcherTestLanguage.g:1106:28: ( ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' ) | ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) ) | (otherlv_12= '(' this_Add_13= ruleAdd otherlv_14= ')' ) ) )
            // InternalElementMatcherTestLanguage.g:1107:1: ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' ) | ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) ) | (otherlv_12= '(' this_Add_13= ruleAdd otherlv_14= ')' ) )
            {
            // InternalElementMatcherTestLanguage.g:1107:1: ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' ) | ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) ) | (otherlv_12= '(' this_Add_13= ruleAdd otherlv_14= ')' ) )
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
                    // InternalElementMatcherTestLanguage.g:1107:2: ( () ( (lv_val_1_0= RULE_INT ) ) )
                    {
                    // InternalElementMatcherTestLanguage.g:1107:2: ( () ( (lv_val_1_0= RULE_INT ) ) )
                    // InternalElementMatcherTestLanguage.g:1107:3: () ( (lv_val_1_0= RULE_INT ) )
                    {
                    // InternalElementMatcherTestLanguage.g:1107:3: ()
                    // InternalElementMatcherTestLanguage.g:1108:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrimAccess().getValueAction_0_0(),
                                current);
                        

                    }

                    // InternalElementMatcherTestLanguage.g:1113:2: ( (lv_val_1_0= RULE_INT ) )
                    // InternalElementMatcherTestLanguage.g:1114:1: (lv_val_1_0= RULE_INT )
                    {
                    // InternalElementMatcherTestLanguage.g:1114:1: (lv_val_1_0= RULE_INT )
                    // InternalElementMatcherTestLanguage.g:1115:3: lv_val_1_0= RULE_INT
                    {
                    lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_val_1_0, grammarAccess.getPrimAccess().getValINTTerminalRuleCall_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPrimRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"val",
                            		lv_val_1_0, 
                            		"org.eclipse.xtext.common.Terminals.INT");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalElementMatcherTestLanguage.g:1132:6: ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' )
                    {
                    // InternalElementMatcherTestLanguage.g:1132:6: ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' )
                    // InternalElementMatcherTestLanguage.g:1132:7: () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')'
                    {
                    // InternalElementMatcherTestLanguage.g:1132:7: ()
                    // InternalElementMatcherTestLanguage.g:1133:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrimAccess().getFunctionAction_1_0(),
                                current);
                        

                    }

                    // InternalElementMatcherTestLanguage.g:1138:2: ( (lv_func_3_0= RULE_ID ) )
                    // InternalElementMatcherTestLanguage.g:1139:1: (lv_func_3_0= RULE_ID )
                    {
                    // InternalElementMatcherTestLanguage.g:1139:1: (lv_func_3_0= RULE_ID )
                    // InternalElementMatcherTestLanguage.g:1140:3: lv_func_3_0= RULE_ID
                    {
                    lv_func_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_20); 

                    			newLeafNode(lv_func_3_0, grammarAccess.getPrimAccess().getFuncIDTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPrimRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"func",
                            		lv_func_3_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,30,FollowSets000.FOLLOW_17); 

                        	newLeafNode(otherlv_4, grammarAccess.getPrimAccess().getLeftParenthesisKeyword_1_2());
                        
                    // InternalElementMatcherTestLanguage.g:1160:1: ( (lv_param_5_0= ruleAdd ) )
                    // InternalElementMatcherTestLanguage.g:1161:1: (lv_param_5_0= ruleAdd )
                    {
                    // InternalElementMatcherTestLanguage.g:1161:1: (lv_param_5_0= ruleAdd )
                    // InternalElementMatcherTestLanguage.g:1162:3: lv_param_5_0= ruleAdd
                    {
                     
                    	        newCompositeNode(grammarAccess.getPrimAccess().getParamAddParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_21);
                    lv_param_5_0=ruleAdd();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPrimRule());
                    	        }
                           		add(
                           			current, 
                           			"param",
                            		lv_param_5_0, 
                            		"org.eclipse.xtext.parsetree.formatter.ElementMatcherTestLanguage.Add");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalElementMatcherTestLanguage.g:1178:2: (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==31) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalElementMatcherTestLanguage.g:1178:4: otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) )
                    	    {
                    	    otherlv_6=(Token)match(input,31,FollowSets000.FOLLOW_17); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getPrimAccess().getCommaKeyword_1_4_0());
                    	        
                    	    // InternalElementMatcherTestLanguage.g:1182:1: ( (lv_param_7_0= ruleAdd ) )
                    	    // InternalElementMatcherTestLanguage.g:1183:1: (lv_param_7_0= ruleAdd )
                    	    {
                    	    // InternalElementMatcherTestLanguage.g:1183:1: (lv_param_7_0= ruleAdd )
                    	    // InternalElementMatcherTestLanguage.g:1184:3: lv_param_7_0= ruleAdd
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getPrimAccess().getParamAddParserRuleCall_1_4_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_21);
                    	    lv_param_7_0=ruleAdd();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getPrimRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"param",
                    	            		lv_param_7_0, 
                    	            		"org.eclipse.xtext.parsetree.formatter.ElementMatcherTestLanguage.Add");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,32,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_8, grammarAccess.getPrimAccess().getRightParenthesisKeyword_1_5());
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalElementMatcherTestLanguage.g:1205:6: ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) )
                    {
                    // InternalElementMatcherTestLanguage.g:1205:6: ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) )
                    // InternalElementMatcherTestLanguage.g:1205:7: () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) )
                    {
                    // InternalElementMatcherTestLanguage.g:1205:7: ()
                    // InternalElementMatcherTestLanguage.g:1206:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrimAccess().getPointerAction_2_0(),
                                current);
                        

                    }

                    otherlv_10=(Token)match(input,33,FollowSets000.FOLLOW_17); 

                        	newLeafNode(otherlv_10, grammarAccess.getPrimAccess().getEqualsSignGreaterThanSignKeyword_2_1());
                        
                    // InternalElementMatcherTestLanguage.g:1215:1: ( (lv_target_11_0= rulePrim ) )
                    // InternalElementMatcherTestLanguage.g:1216:1: (lv_target_11_0= rulePrim )
                    {
                    // InternalElementMatcherTestLanguage.g:1216:1: (lv_target_11_0= rulePrim )
                    // InternalElementMatcherTestLanguage.g:1217:3: lv_target_11_0= rulePrim
                    {
                     
                    	        newCompositeNode(grammarAccess.getPrimAccess().getTargetPrimParserRuleCall_2_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_target_11_0=rulePrim();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPrimRule());
                    	        }
                           		set(
                           			current, 
                           			"target",
                            		lv_target_11_0, 
                            		"org.eclipse.xtext.parsetree.formatter.ElementMatcherTestLanguage.Prim");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalElementMatcherTestLanguage.g:1234:6: (otherlv_12= '(' this_Add_13= ruleAdd otherlv_14= ')' )
                    {
                    // InternalElementMatcherTestLanguage.g:1234:6: (otherlv_12= '(' this_Add_13= ruleAdd otherlv_14= ')' )
                    // InternalElementMatcherTestLanguage.g:1234:8: otherlv_12= '(' this_Add_13= ruleAdd otherlv_14= ')'
                    {
                    otherlv_12=(Token)match(input,30,FollowSets000.FOLLOW_17); 

                        	newLeafNode(otherlv_12, grammarAccess.getPrimAccess().getLeftParenthesisKeyword_3_0());
                        
                     
                            newCompositeNode(grammarAccess.getPrimAccess().getAddParserRuleCall_3_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_22);
                    this_Add_13=ruleAdd();

                    state._fsp--;

                     
                            current = this_Add_13; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_14=(Token)match(input,32,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:1259:1: entryRuleRuleCalls12 returns [EObject current=null] : iv_ruleRuleCalls12= ruleRuleCalls12 EOF ;
    public final EObject entryRuleRuleCalls12() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCalls12 = null;


        try {
            // InternalElementMatcherTestLanguage.g:1260:2: (iv_ruleRuleCalls12= ruleRuleCalls12 EOF )
            // InternalElementMatcherTestLanguage.g:1261:2: iv_ruleRuleCalls12= ruleRuleCalls12 EOF
            {
             newCompositeNode(grammarAccess.getRuleCalls12Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRuleCalls12=ruleRuleCalls12();

            state._fsp--;

             current =iv_ruleRuleCalls12; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:1268:1: ruleRuleCalls12 returns [EObject current=null] : (otherlv_0= '#7' ( (lv_constructor_1_0= ruleConstructor ) ) ( (lv_fields_2_0= ruleField ) ) otherlv_3= 'kw3' ) ;
    public final EObject ruleRuleCalls12() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_constructor_1_0 = null;

        EObject lv_fields_2_0 = null;


         enterRule(); 
            
        try {
            // InternalElementMatcherTestLanguage.g:1271:28: ( (otherlv_0= '#7' ( (lv_constructor_1_0= ruleConstructor ) ) ( (lv_fields_2_0= ruleField ) ) otherlv_3= 'kw3' ) )
            // InternalElementMatcherTestLanguage.g:1272:1: (otherlv_0= '#7' ( (lv_constructor_1_0= ruleConstructor ) ) ( (lv_fields_2_0= ruleField ) ) otherlv_3= 'kw3' )
            {
            // InternalElementMatcherTestLanguage.g:1272:1: (otherlv_0= '#7' ( (lv_constructor_1_0= ruleConstructor ) ) ( (lv_fields_2_0= ruleField ) ) otherlv_3= 'kw3' )
            // InternalElementMatcherTestLanguage.g:1272:3: otherlv_0= '#7' ( (lv_constructor_1_0= ruleConstructor ) ) ( (lv_fields_2_0= ruleField ) ) otherlv_3= 'kw3'
            {
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_4); 

                	newLeafNode(otherlv_0, grammarAccess.getRuleCalls12Access().getNumberSignDigitSevenKeyword_0());
                
            // InternalElementMatcherTestLanguage.g:1276:1: ( (lv_constructor_1_0= ruleConstructor ) )
            // InternalElementMatcherTestLanguage.g:1277:1: (lv_constructor_1_0= ruleConstructor )
            {
            // InternalElementMatcherTestLanguage.g:1277:1: (lv_constructor_1_0= ruleConstructor )
            // InternalElementMatcherTestLanguage.g:1278:3: lv_constructor_1_0= ruleConstructor
            {
             
            	        newCompositeNode(grammarAccess.getRuleCalls12Access().getConstructorConstructorParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_4);
            lv_constructor_1_0=ruleConstructor();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRuleCalls12Rule());
            	        }
                   		set(
                   			current, 
                   			"constructor",
                    		lv_constructor_1_0, 
                    		"org.eclipse.xtext.parsetree.formatter.ElementMatcherTestLanguage.Constructor");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalElementMatcherTestLanguage.g:1294:2: ( (lv_fields_2_0= ruleField ) )
            // InternalElementMatcherTestLanguage.g:1295:1: (lv_fields_2_0= ruleField )
            {
            // InternalElementMatcherTestLanguage.g:1295:1: (lv_fields_2_0= ruleField )
            // InternalElementMatcherTestLanguage.g:1296:3: lv_fields_2_0= ruleField
            {
             
            	        newCompositeNode(grammarAccess.getRuleCalls12Access().getFieldsFieldParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_23);
            lv_fields_2_0=ruleField();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRuleCalls12Rule());
            	        }
                   		add(
                   			current, 
                   			"fields",
                    		lv_fields_2_0, 
                    		"org.eclipse.xtext.parsetree.formatter.ElementMatcherTestLanguage.Field");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,35,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:1324:1: entryRuleConstructor returns [EObject current=null] : iv_ruleConstructor= ruleConstructor EOF ;
    public final EObject entryRuleConstructor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructor = null;


        try {
            // InternalElementMatcherTestLanguage.g:1325:2: (iv_ruleConstructor= ruleConstructor EOF )
            // InternalElementMatcherTestLanguage.g:1326:2: iv_ruleConstructor= ruleConstructor EOF
            {
             newCompositeNode(grammarAccess.getConstructorRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleConstructor=ruleConstructor();

            state._fsp--;

             current =iv_ruleConstructor; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:1333:1: ruleConstructor returns [EObject current=null] : ( () ( (lv_kw1_1_0= 'kw1' ) )? ) ;
    public final EObject ruleConstructor() throws RecognitionException {
        EObject current = null;

        Token lv_kw1_1_0=null;

         enterRule(); 
            
        try {
            // InternalElementMatcherTestLanguage.g:1336:28: ( ( () ( (lv_kw1_1_0= 'kw1' ) )? ) )
            // InternalElementMatcherTestLanguage.g:1337:1: ( () ( (lv_kw1_1_0= 'kw1' ) )? )
            {
            // InternalElementMatcherTestLanguage.g:1337:1: ( () ( (lv_kw1_1_0= 'kw1' ) )? )
            // InternalElementMatcherTestLanguage.g:1337:2: () ( (lv_kw1_1_0= 'kw1' ) )?
            {
            // InternalElementMatcherTestLanguage.g:1337:2: ()
            // InternalElementMatcherTestLanguage.g:1338:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getConstructorAccess().getConstructorAction_0(),
                        current);
                

            }

            // InternalElementMatcherTestLanguage.g:1343:2: ( (lv_kw1_1_0= 'kw1' ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==12) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalElementMatcherTestLanguage.g:1344:1: (lv_kw1_1_0= 'kw1' )
                    {
                    // InternalElementMatcherTestLanguage.g:1344:1: (lv_kw1_1_0= 'kw1' )
                    // InternalElementMatcherTestLanguage.g:1345:3: lv_kw1_1_0= 'kw1'
                    {
                    lv_kw1_1_0=(Token)match(input,12,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:1366:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // InternalElementMatcherTestLanguage.g:1367:2: (iv_ruleField= ruleField EOF )
            // InternalElementMatcherTestLanguage.g:1368:2: iv_ruleField= ruleField EOF
            {
             newCompositeNode(grammarAccess.getFieldRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleField=ruleField();

            state._fsp--;

             current =iv_ruleField; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:1375:1: ruleField returns [EObject current=null] : (this_ID_0= RULE_ID this_Parameter_1= ruleParameter ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        Token this_ID_0=null;
        EObject this_Parameter_1 = null;


         enterRule(); 
            
        try {
            // InternalElementMatcherTestLanguage.g:1378:28: ( (this_ID_0= RULE_ID this_Parameter_1= ruleParameter ) )
            // InternalElementMatcherTestLanguage.g:1379:1: (this_ID_0= RULE_ID this_Parameter_1= ruleParameter )
            {
            // InternalElementMatcherTestLanguage.g:1379:1: (this_ID_0= RULE_ID this_Parameter_1= ruleParameter )
            // InternalElementMatcherTestLanguage.g:1379:2: this_ID_0= RULE_ID this_Parameter_1= ruleParameter
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_24); 
             
                newLeafNode(this_ID_0, grammarAccess.getFieldAccess().getIDTerminalRuleCall_0()); 
                
             
                    newCompositeNode(grammarAccess.getFieldAccess().getParameterParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalElementMatcherTestLanguage.g:1400:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalElementMatcherTestLanguage.g:1401:2: (iv_ruleParameter= ruleParameter EOF )
            // InternalElementMatcherTestLanguage.g:1402:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalElementMatcherTestLanguage.g:1409:1: ruleParameter returns [EObject current=null] : ( () ( (lv_kw2_1_0= 'kw2' ) )? ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_kw2_1_0=null;

         enterRule(); 
            
        try {
            // InternalElementMatcherTestLanguage.g:1412:28: ( ( () ( (lv_kw2_1_0= 'kw2' ) )? ) )
            // InternalElementMatcherTestLanguage.g:1413:1: ( () ( (lv_kw2_1_0= 'kw2' ) )? )
            {
            // InternalElementMatcherTestLanguage.g:1413:1: ( () ( (lv_kw2_1_0= 'kw2' ) )? )
            // InternalElementMatcherTestLanguage.g:1413:2: () ( (lv_kw2_1_0= 'kw2' ) )?
            {
            // InternalElementMatcherTestLanguage.g:1413:2: ()
            // InternalElementMatcherTestLanguage.g:1414:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getParameterAccess().getParameterAction_0(),
                        current);
                

            }

            // InternalElementMatcherTestLanguage.g:1419:2: ( (lv_kw2_1_0= 'kw2' ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==36) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalElementMatcherTestLanguage.g:1420:1: (lv_kw2_1_0= 'kw2' )
                    {
                    // InternalElementMatcherTestLanguage.g:1420:1: (lv_kw2_1_0= 'kw2' )
                    // InternalElementMatcherTestLanguage.g:1421:3: lv_kw2_1_0= 'kw2'
                    {
                    lv_kw2_1_0=(Token)match(input,36,FollowSets000.FOLLOW_2); 

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


    // $ANTLR start "entryRuleNestedStart"
    // InternalElementMatcherTestLanguage.g:1442:1: entryRuleNestedStart returns [EObject current=null] : iv_ruleNestedStart= ruleNestedStart EOF ;
    public final EObject entryRuleNestedStart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedStart = null;


        try {
            // InternalElementMatcherTestLanguage.g:1443:2: (iv_ruleNestedStart= ruleNestedStart EOF )
            // InternalElementMatcherTestLanguage.g:1444:2: iv_ruleNestedStart= ruleNestedStart EOF
            {
             newCompositeNode(grammarAccess.getNestedStartRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNestedStart=ruleNestedStart();

            state._fsp--;

             current =iv_ruleNestedStart; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleNestedStart"


    // $ANTLR start "ruleNestedStart"
    // InternalElementMatcherTestLanguage.g:1451:1: ruleNestedStart returns [EObject current=null] : (this_NestedStartSub_0= ruleNestedStartSub ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleNestedStart() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject this_NestedStartSub_0 = null;


         enterRule(); 
            
        try {
            // InternalElementMatcherTestLanguage.g:1454:28: ( (this_NestedStartSub_0= ruleNestedStartSub ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalElementMatcherTestLanguage.g:1455:1: (this_NestedStartSub_0= ruleNestedStartSub ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalElementMatcherTestLanguage.g:1455:1: (this_NestedStartSub_0= ruleNestedStartSub ( (lv_name_1_0= RULE_ID ) ) )
            // InternalElementMatcherTestLanguage.g:1456:5: this_NestedStartSub_0= ruleNestedStartSub ( (lv_name_1_0= RULE_ID ) )
            {
             
                    newCompositeNode(grammarAccess.getNestedStartAccess().getNestedStartSubParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_3);
            this_NestedStartSub_0=ruleNestedStartSub();

            state._fsp--;

             
                    current = this_NestedStartSub_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalElementMatcherTestLanguage.g:1464:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalElementMatcherTestLanguage.g:1465:1: (lv_name_1_0= RULE_ID )
            {
            // InternalElementMatcherTestLanguage.g:1465:1: (lv_name_1_0= RULE_ID )
            // InternalElementMatcherTestLanguage.g:1466:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_1_0, grammarAccess.getNestedStartAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNestedStartRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // $ANTLR end "ruleNestedStart"


    // $ANTLR start "entryRuleNestedStartSub"
    // InternalElementMatcherTestLanguage.g:1490:1: entryRuleNestedStartSub returns [EObject current=null] : iv_ruleNestedStartSub= ruleNestedStartSub EOF ;
    public final EObject entryRuleNestedStartSub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedStartSub = null;


        try {
            // InternalElementMatcherTestLanguage.g:1491:2: (iv_ruleNestedStartSub= ruleNestedStartSub EOF )
            // InternalElementMatcherTestLanguage.g:1492:2: iv_ruleNestedStartSub= ruleNestedStartSub EOF
            {
             newCompositeNode(grammarAccess.getNestedStartSubRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNestedStartSub=ruleNestedStartSub();

            state._fsp--;

             current =iv_ruleNestedStartSub; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleNestedStartSub"


    // $ANTLR start "ruleNestedStartSub"
    // InternalElementMatcherTestLanguage.g:1499:1: ruleNestedStartSub returns [EObject current=null] : (otherlv_0= '#8' () ) ;
    public final EObject ruleNestedStartSub() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalElementMatcherTestLanguage.g:1502:28: ( (otherlv_0= '#8' () ) )
            // InternalElementMatcherTestLanguage.g:1503:1: (otherlv_0= '#8' () )
            {
            // InternalElementMatcherTestLanguage.g:1503:1: (otherlv_0= '#8' () )
            // InternalElementMatcherTestLanguage.g:1503:3: otherlv_0= '#8' ()
            {
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_0, grammarAccess.getNestedStartSubAccess().getNumberSignDigitEightKeyword_0());
                
            // InternalElementMatcherTestLanguage.g:1507:1: ()
            // InternalElementMatcherTestLanguage.g:1508:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNestedStartSubAccess().getNestedStartSubAction_1(),
                        current);
                

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
    // $ANTLR end "ruleNestedStartSub"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000030002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000088010L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000C00010L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004000072L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000004000062L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000062L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000180000000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000001000000000L});
    }


}