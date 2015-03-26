package org.eclipse.xtext.formatting2.regionaccess.internal.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.formatting2.regionaccess.internal.services.RegionAccessTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRegionAccessTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'test'", "'5'", "'1'", "'2'", "'3'", "'4'", "'prefix'", "'+'", "'('", "')'"
    };
    public static final int T__19=19;
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__20=20;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalRegionAccessTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRegionAccessTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRegionAccessTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g"; }



     	private RegionAccessTestLanguageGrammarAccess grammarAccess;
     	
        public InternalRegionAccessTestLanguageParser(TokenStream input, RegionAccessTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Root";	
       	}
       	
       	@Override
       	protected RegionAccessTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleRoot"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:67:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:68:2: (iv_ruleRoot= ruleRoot EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:69:2: iv_ruleRoot= ruleRoot EOF
            {
             newCompositeNode(grammarAccess.getRootRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRoot_in_entryRuleRoot75);
            iv_ruleRoot=ruleRoot();

            state._fsp--;

             current =iv_ruleRoot; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoot85); 

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
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:76:1: ruleRoot returns [EObject current=null] : (otherlv_0= 'test' (this_Simple_1= ruleSimple | this_Delegation_2= ruleDelegation | this_Unassigned_3= ruleUnassigned | this_PrefixedUnassigned_4= rulePrefixedUnassigned | (otherlv_5= '5' this_Expression_6= ruleExpression ) ) ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_5=null;
        EObject this_Simple_1 = null;

        EObject this_Delegation_2 = null;

        EObject this_Unassigned_3 = null;

        EObject this_PrefixedUnassigned_4 = null;

        EObject this_Expression_6 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:79:28: ( (otherlv_0= 'test' (this_Simple_1= ruleSimple | this_Delegation_2= ruleDelegation | this_Unassigned_3= ruleUnassigned | this_PrefixedUnassigned_4= rulePrefixedUnassigned | (otherlv_5= '5' this_Expression_6= ruleExpression ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:80:1: (otherlv_0= 'test' (this_Simple_1= ruleSimple | this_Delegation_2= ruleDelegation | this_Unassigned_3= ruleUnassigned | this_PrefixedUnassigned_4= rulePrefixedUnassigned | (otherlv_5= '5' this_Expression_6= ruleExpression ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:80:1: (otherlv_0= 'test' (this_Simple_1= ruleSimple | this_Delegation_2= ruleDelegation | this_Unassigned_3= ruleUnassigned | this_PrefixedUnassigned_4= rulePrefixedUnassigned | (otherlv_5= '5' this_Expression_6= ruleExpression ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:80:3: otherlv_0= 'test' (this_Simple_1= ruleSimple | this_Delegation_2= ruleDelegation | this_Unassigned_3= ruleUnassigned | this_PrefixedUnassigned_4= rulePrefixedUnassigned | (otherlv_5= '5' this_Expression_6= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleRoot122); 

                	newLeafNode(otherlv_0, grammarAccess.getRootAccess().getTestKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:84:1: (this_Simple_1= ruleSimple | this_Delegation_2= ruleDelegation | this_Unassigned_3= ruleUnassigned | this_PrefixedUnassigned_4= rulePrefixedUnassigned | (otherlv_5= '5' this_Expression_6= ruleExpression ) )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt1=1;
                }
                break;
            case 14:
                {
                alt1=2;
                }
                break;
            case 15:
                {
                alt1=3;
                }
                break;
            case 16:
                {
                alt1=4;
                }
                break;
            case 12:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:85:5: this_Simple_1= ruleSimple
                    {
                     
                            newCompositeNode(grammarAccess.getRootAccess().getSimpleParserRuleCall_1_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSimple_in_ruleRoot145);
                    this_Simple_1=ruleSimple();

                    state._fsp--;

                     
                            current = this_Simple_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:95:5: this_Delegation_2= ruleDelegation
                    {
                     
                            newCompositeNode(grammarAccess.getRootAccess().getDelegationParserRuleCall_1_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDelegation_in_ruleRoot172);
                    this_Delegation_2=ruleDelegation();

                    state._fsp--;

                     
                            current = this_Delegation_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:105:5: this_Unassigned_3= ruleUnassigned
                    {
                     
                            newCompositeNode(grammarAccess.getRootAccess().getUnassignedParserRuleCall_1_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleUnassigned_in_ruleRoot199);
                    this_Unassigned_3=ruleUnassigned();

                    state._fsp--;

                     
                            current = this_Unassigned_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:115:5: this_PrefixedUnassigned_4= rulePrefixedUnassigned
                    {
                     
                            newCompositeNode(grammarAccess.getRootAccess().getPrefixedUnassignedParserRuleCall_1_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedUnassigned_in_ruleRoot226);
                    this_PrefixedUnassigned_4=rulePrefixedUnassigned();

                    state._fsp--;

                     
                            current = this_PrefixedUnassigned_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:124:6: (otherlv_5= '5' this_Expression_6= ruleExpression )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:124:6: (otherlv_5= '5' this_Expression_6= ruleExpression )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:124:8: otherlv_5= '5' this_Expression_6= ruleExpression
                    {
                    otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleRoot244); 

                        	newLeafNode(otherlv_5, grammarAccess.getRootAccess().getDigitFiveKeyword_1_4_0());
                        
                     
                            newCompositeNode(grammarAccess.getRootAccess().getExpressionParserRuleCall_1_4_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleRoot266);
                    this_Expression_6=ruleExpression();

                    state._fsp--;

                     
                            current = this_Expression_6; 
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
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleSimple"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:145:1: entryRuleSimple returns [EObject current=null] : iv_ruleSimple= ruleSimple EOF ;
    public final EObject entryRuleSimple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimple = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:146:2: (iv_ruleSimple= ruleSimple EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:147:2: iv_ruleSimple= ruleSimple EOF
            {
             newCompositeNode(grammarAccess.getSimpleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimple_in_entryRuleSimple303);
            iv_ruleSimple=ruleSimple();

            state._fsp--;

             current =iv_ruleSimple; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimple313); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:154:1: ruleSimple returns [EObject current=null] : (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleSimple() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:157:28: ( (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:158:1: (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:158:1: (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:158:3: otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSimple350); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleAccess().getDigitOneKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:162:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:163:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:163:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:164:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimple367); 

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


    // $ANTLR start "entryRuleDelegation"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:188:1: entryRuleDelegation returns [EObject current=null] : iv_ruleDelegation= ruleDelegation EOF ;
    public final EObject entryRuleDelegation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDelegation = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:189:2: (iv_ruleDelegation= ruleDelegation EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:190:2: iv_ruleDelegation= ruleDelegation EOF
            {
             newCompositeNode(grammarAccess.getDelegationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDelegation_in_entryRuleDelegation408);
            iv_ruleDelegation=ruleDelegation();

            state._fsp--;

             current =iv_ruleDelegation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDelegation418); 

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
    // $ANTLR end "entryRuleDelegation"


    // $ANTLR start "ruleDelegation"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:197:1: ruleDelegation returns [EObject current=null] : (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) ) ;
    public final EObject ruleDelegation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_delegate_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:200:28: ( (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:201:1: (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:201:1: (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:201:3: otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) )
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleDelegation455); 

                	newLeafNode(otherlv_0, grammarAccess.getDelegationAccess().getDigitTwoKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:205:1: ( (lv_delegate_1_0= ruleDelegate ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:206:1: (lv_delegate_1_0= ruleDelegate )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:206:1: (lv_delegate_1_0= ruleDelegate )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:207:3: lv_delegate_1_0= ruleDelegate
            {
             
            	        newCompositeNode(grammarAccess.getDelegationAccess().getDelegateDelegateParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleDelegate_in_ruleDelegation476);
            lv_delegate_1_0=ruleDelegate();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDelegationRule());
            	        }
                   		set(
                   			current, 
                   			"delegate",
                    		lv_delegate_1_0, 
                    		"Delegate");
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
    // $ANTLR end "ruleDelegation"


    // $ANTLR start "entryRuleUnassigned"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:231:1: entryRuleUnassigned returns [EObject current=null] : iv_ruleUnassigned= ruleUnassigned EOF ;
    public final EObject entryRuleUnassigned() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassigned = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:232:2: (iv_ruleUnassigned= ruleUnassigned EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:233:2: iv_ruleUnassigned= ruleUnassigned EOF
            {
             newCompositeNode(grammarAccess.getUnassignedRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassigned_in_entryRuleUnassigned512);
            iv_ruleUnassigned=ruleUnassigned();

            state._fsp--;

             current =iv_ruleUnassigned; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassigned522); 

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
    // $ANTLR end "entryRuleUnassigned"


    // $ANTLR start "ruleUnassigned"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:240:1: ruleUnassigned returns [EObject current=null] : (otherlv_0= '3' this_Delegate_1= ruleDelegate ) ;
    public final EObject ruleUnassigned() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Delegate_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:243:28: ( (otherlv_0= '3' this_Delegate_1= ruleDelegate ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:244:1: (otherlv_0= '3' this_Delegate_1= ruleDelegate )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:244:1: (otherlv_0= '3' this_Delegate_1= ruleDelegate )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:244:3: otherlv_0= '3' this_Delegate_1= ruleDelegate
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleUnassigned559); 

                	newLeafNode(otherlv_0, grammarAccess.getUnassignedAccess().getDigitThreeKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getUnassignedAccess().getDelegateParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleDelegate_in_ruleUnassigned581);
            this_Delegate_1=ruleDelegate();

            state._fsp--;

             
                    current = this_Delegate_1; 
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
    // $ANTLR end "ruleUnassigned"


    // $ANTLR start "entryRulePrefixedUnassigned"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:265:1: entryRulePrefixedUnassigned returns [EObject current=null] : iv_rulePrefixedUnassigned= rulePrefixedUnassigned EOF ;
    public final EObject entryRulePrefixedUnassigned() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedUnassigned = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:266:2: (iv_rulePrefixedUnassigned= rulePrefixedUnassigned EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:267:2: iv_rulePrefixedUnassigned= rulePrefixedUnassigned EOF
            {
             newCompositeNode(grammarAccess.getPrefixedUnassignedRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePrefixedUnassigned_in_entryRulePrefixedUnassigned616);
            iv_rulePrefixedUnassigned=rulePrefixedUnassigned();

            state._fsp--;

             current =iv_rulePrefixedUnassigned; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedUnassigned626); 

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
    // $ANTLR end "entryRulePrefixedUnassigned"


    // $ANTLR start "rulePrefixedUnassigned"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:274:1: rulePrefixedUnassigned returns [EObject current=null] : (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) ) ;
    public final EObject rulePrefixedUnassigned() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_delegate_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:277:28: ( (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:278:1: (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:278:1: (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:278:3: otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) )
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_rulePrefixedUnassigned663); 

                	newLeafNode(otherlv_0, grammarAccess.getPrefixedUnassignedAccess().getDigitFourKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:282:1: ( (lv_delegate_1_0= rulePrefixedDelegate ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:283:1: (lv_delegate_1_0= rulePrefixedDelegate )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:283:1: (lv_delegate_1_0= rulePrefixedDelegate )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:284:3: lv_delegate_1_0= rulePrefixedDelegate
            {
             
            	        newCompositeNode(grammarAccess.getPrefixedUnassignedAccess().getDelegatePrefixedDelegateParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_rulePrefixedDelegate_in_rulePrefixedUnassigned684);
            lv_delegate_1_0=rulePrefixedDelegate();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPrefixedUnassignedRule());
            	        }
                   		set(
                   			current, 
                   			"delegate",
                    		lv_delegate_1_0, 
                    		"PrefixedDelegate");
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
    // $ANTLR end "rulePrefixedUnassigned"


    // $ANTLR start "entryRulePrefixedDelegate"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:308:1: entryRulePrefixedDelegate returns [EObject current=null] : iv_rulePrefixedDelegate= rulePrefixedDelegate EOF ;
    public final EObject entryRulePrefixedDelegate() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedDelegate = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:309:2: (iv_rulePrefixedDelegate= rulePrefixedDelegate EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:310:2: iv_rulePrefixedDelegate= rulePrefixedDelegate EOF
            {
             newCompositeNode(grammarAccess.getPrefixedDelegateRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePrefixedDelegate_in_entryRulePrefixedDelegate720);
            iv_rulePrefixedDelegate=rulePrefixedDelegate();

            state._fsp--;

             current =iv_rulePrefixedDelegate; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedDelegate730); 

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
    // $ANTLR end "entryRulePrefixedDelegate"


    // $ANTLR start "rulePrefixedDelegate"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:317:1: rulePrefixedDelegate returns [EObject current=null] : (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate ) ;
    public final EObject rulePrefixedDelegate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Delegate_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:320:28: ( (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:321:1: (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:321:1: (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:321:3: otherlv_0= 'prefix' this_Delegate_1= ruleDelegate
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_rulePrefixedDelegate767); 

                	newLeafNode(otherlv_0, grammarAccess.getPrefixedDelegateAccess().getPrefixKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getPrefixedDelegateAccess().getDelegateParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleDelegate_in_rulePrefixedDelegate789);
            this_Delegate_1=ruleDelegate();

            state._fsp--;

             
                    current = this_Delegate_1; 
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
    // $ANTLR end "rulePrefixedDelegate"


    // $ANTLR start "entryRuleDelegate"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:342:1: entryRuleDelegate returns [EObject current=null] : iv_ruleDelegate= ruleDelegate EOF ;
    public final EObject entryRuleDelegate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDelegate = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:343:2: (iv_ruleDelegate= ruleDelegate EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:344:2: iv_ruleDelegate= ruleDelegate EOF
            {
             newCompositeNode(grammarAccess.getDelegateRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDelegate_in_entryRuleDelegate824);
            iv_ruleDelegate=ruleDelegate();

            state._fsp--;

             current =iv_ruleDelegate; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDelegate834); 

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
    // $ANTLR end "entryRuleDelegate"


    // $ANTLR start "ruleDelegate"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:351:1: ruleDelegate returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleDelegate() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:354:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:355:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:355:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:356:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:356:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:357:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDelegate875); 

            			newLeafNode(lv_name_0_0, grammarAccess.getDelegateAccess().getNameIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDelegateRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

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
    // $ANTLR end "ruleDelegate"


    // $ANTLR start "entryRuleExpression"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:381:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:382:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:383:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_entryRuleExpression915);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression925); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:390:1: ruleExpression returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:393:28: ( (this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:394:1: (this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:394:1: (this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:395:5: this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getExpressionAccess().getPrimaryParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_rulePrimary_in_ruleExpression972);
            this_Primary_0=rulePrimary();

            state._fsp--;

             
                    current = this_Primary_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:403:1: ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==18) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:403:2: () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:403:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:404:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getExpressionAccess().getAddLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleExpression993); 

            	        	newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getPlusSignKeyword_1_1());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:413:1: ( (lv_right_3_0= rulePrimary ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:414:1: (lv_right_3_0= rulePrimary )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:414:1: (lv_right_3_0= rulePrimary )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:415:3: lv_right_3_0= rulePrimary
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExpressionAccess().getRightPrimaryParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_rulePrimary_in_ruleExpression1014);
            	    lv_right_3_0=rulePrimary();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getExpressionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"Primary");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRulePrimary"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:439:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:440:2: (iv_rulePrimary= rulePrimary EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:441:2: iv_rulePrimary= rulePrimary EOF
            {
             newCompositeNode(grammarAccess.getPrimaryRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePrimary_in_entryRulePrimary1052);
            iv_rulePrimary=rulePrimary();

            state._fsp--;

             current =iv_rulePrimary; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimary1062); 

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
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:448:1: rulePrimary returns [EObject current=null] : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | this_Parenthesized_2= ruleParenthesized ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject this_Parenthesized_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:451:28: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | this_Parenthesized_2= ruleParenthesized ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:452:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | this_Parenthesized_2= ruleParenthesized )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:452:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | this_Parenthesized_2= ruleParenthesized )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            else if ( (LA3_0==19) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:452:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:452:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:452:3: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:452:3: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:453:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrimaryAccess().getNamedAction_0_0(),
                                current);
                        

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:458:2: ( (lv_name_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:459:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:459:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:460:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePrimary1114); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getPrimaryAccess().getNameIDTerminalRuleCall_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPrimaryRule());
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
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:478:5: this_Parenthesized_2= ruleParenthesized
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryAccess().getParenthesizedParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesized_in_rulePrimary1148);
                    this_Parenthesized_2=ruleParenthesized();

                    state._fsp--;

                     
                            current = this_Parenthesized_2; 
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
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleParenthesized"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:494:1: entryRuleParenthesized returns [EObject current=null] : iv_ruleParenthesized= ruleParenthesized EOF ;
    public final EObject entryRuleParenthesized() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesized = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:495:2: (iv_ruleParenthesized= ruleParenthesized EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:496:2: iv_ruleParenthesized= ruleParenthesized EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesized_in_entryRuleParenthesized1183);
            iv_ruleParenthesized=ruleParenthesized();

            state._fsp--;

             current =iv_ruleParenthesized; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesized1193); 

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
    // $ANTLR end "entryRuleParenthesized"


    // $ANTLR start "ruleParenthesized"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:503:1: ruleParenthesized returns [EObject current=null] : (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) ;
    public final EObject ruleParenthesized() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Expression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:506:28: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:507:1: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:507:1: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:507:3: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleParenthesized1230); 

                	newLeafNode(otherlv_0, grammarAccess.getParenthesizedAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getParenthesizedAccess().getExpressionParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleParenthesized1252);
            this_Expression_1=ruleExpression();

            state._fsp--;

             
                    current = this_Expression_1; 
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleParenthesized1263); 

                	newLeafNode(otherlv_2, grammarAccess.getParenthesizedAccess().getRightParenthesisKeyword_2());
                

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
    // $ANTLR end "ruleParenthesized"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleRoot122 = new BitSet(new long[]{0x000000000001F000L});
        public static final BitSet FOLLOW_ruleSimple_in_ruleRoot145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDelegation_in_ruleRoot172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassigned_in_ruleRoot199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedUnassigned_in_ruleRoot226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleRoot244 = new BitSet(new long[]{0x0000000000080010L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleRoot266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimple_in_entryRuleSimple303 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimple313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleSimple350 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimple367 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDelegation_in_entryRuleDelegation408 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDelegation418 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleDelegation455 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDelegate_in_ruleDelegation476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassigned_in_entryRuleUnassigned512 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassigned522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleUnassigned559 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDelegate_in_ruleUnassigned581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedUnassigned_in_entryRulePrefixedUnassigned616 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedUnassigned626 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rulePrefixedUnassigned663 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rulePrefixedDelegate_in_rulePrefixedUnassigned684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedDelegate_in_entryRulePrefixedDelegate720 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedDelegate730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rulePrefixedDelegate767 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDelegate_in_rulePrefixedDelegate789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDelegate_in_entryRuleDelegate824 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDelegate834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDelegate875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression915 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimary_in_ruleExpression972 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_18_in_ruleExpression993 = new BitSet(new long[]{0x0000000000080010L});
        public static final BitSet FOLLOW_rulePrimary_in_ruleExpression1014 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_rulePrimary_in_entryRulePrimary1052 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimary1062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePrimary1114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesized_in_rulePrimary1148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesized_in_entryRuleParenthesized1183 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesized1193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleParenthesized1230 = new BitSet(new long[]{0x0000000000080010L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesized1252 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleParenthesized1263 = new BitSet(new long[]{0x0000000000000002L});
    }


}