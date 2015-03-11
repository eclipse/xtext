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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'test'", "'1'", "'2'", "'3'", "'4'", "'prefix'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:76:1: ruleRoot returns [EObject current=null] : (otherlv_0= 'test' (this_Simple_1= ruleSimple | this_Delegation_2= ruleDelegation | this_Unassigned_3= ruleUnassigned | this_PrefixedUnassigned_4= rulePrefixedUnassigned ) ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Simple_1 = null;

        EObject this_Delegation_2 = null;

        EObject this_Unassigned_3 = null;

        EObject this_PrefixedUnassigned_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:79:28: ( (otherlv_0= 'test' (this_Simple_1= ruleSimple | this_Delegation_2= ruleDelegation | this_Unassigned_3= ruleUnassigned | this_PrefixedUnassigned_4= rulePrefixedUnassigned ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:80:1: (otherlv_0= 'test' (this_Simple_1= ruleSimple | this_Delegation_2= ruleDelegation | this_Unassigned_3= ruleUnassigned | this_PrefixedUnassigned_4= rulePrefixedUnassigned ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:80:1: (otherlv_0= 'test' (this_Simple_1= ruleSimple | this_Delegation_2= ruleDelegation | this_Unassigned_3= ruleUnassigned | this_PrefixedUnassigned_4= rulePrefixedUnassigned ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:80:3: otherlv_0= 'test' (this_Simple_1= ruleSimple | this_Delegation_2= ruleDelegation | this_Unassigned_3= ruleUnassigned | this_PrefixedUnassigned_4= rulePrefixedUnassigned )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleRoot122); 

                	newLeafNode(otherlv_0, grammarAccess.getRootAccess().getTestKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:84:1: (this_Simple_1= ruleSimple | this_Delegation_2= ruleDelegation | this_Unassigned_3= ruleUnassigned | this_PrefixedUnassigned_4= rulePrefixedUnassigned )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt1=1;
                }
                break;
            case 13:
                {
                alt1=2;
                }
                break;
            case 14:
                {
                alt1=3;
                }
                break;
            case 15:
                {
                alt1=4;
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:131:1: entryRuleSimple returns [EObject current=null] : iv_ruleSimple= ruleSimple EOF ;
    public final EObject entryRuleSimple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimple = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:132:2: (iv_ruleSimple= ruleSimple EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:133:2: iv_ruleSimple= ruleSimple EOF
            {
             newCompositeNode(grammarAccess.getSimpleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimple_in_entryRuleSimple262);
            iv_ruleSimple=ruleSimple();

            state._fsp--;

             current =iv_ruleSimple; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimple272); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:140:1: ruleSimple returns [EObject current=null] : (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleSimple() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:143:28: ( (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:144:1: (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:144:1: (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:144:3: otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSimple309); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleAccess().getDigitOneKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:148:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:149:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:149:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:150:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimple326); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:174:1: entryRuleDelegation returns [EObject current=null] : iv_ruleDelegation= ruleDelegation EOF ;
    public final EObject entryRuleDelegation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDelegation = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:175:2: (iv_ruleDelegation= ruleDelegation EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:176:2: iv_ruleDelegation= ruleDelegation EOF
            {
             newCompositeNode(grammarAccess.getDelegationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDelegation_in_entryRuleDelegation367);
            iv_ruleDelegation=ruleDelegation();

            state._fsp--;

             current =iv_ruleDelegation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDelegation377); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:183:1: ruleDelegation returns [EObject current=null] : (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) ) ;
    public final EObject ruleDelegation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_delegate_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:186:28: ( (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:187:1: (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:187:1: (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:187:3: otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) )
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleDelegation414); 

                	newLeafNode(otherlv_0, grammarAccess.getDelegationAccess().getDigitTwoKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:191:1: ( (lv_delegate_1_0= ruleDelegate ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:192:1: (lv_delegate_1_0= ruleDelegate )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:192:1: (lv_delegate_1_0= ruleDelegate )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:193:3: lv_delegate_1_0= ruleDelegate
            {
             
            	        newCompositeNode(grammarAccess.getDelegationAccess().getDelegateDelegateParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleDelegate_in_ruleDelegation435);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:217:1: entryRuleUnassigned returns [EObject current=null] : iv_ruleUnassigned= ruleUnassigned EOF ;
    public final EObject entryRuleUnassigned() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassigned = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:218:2: (iv_ruleUnassigned= ruleUnassigned EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:219:2: iv_ruleUnassigned= ruleUnassigned EOF
            {
             newCompositeNode(grammarAccess.getUnassignedRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassigned_in_entryRuleUnassigned471);
            iv_ruleUnassigned=ruleUnassigned();

            state._fsp--;

             current =iv_ruleUnassigned; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassigned481); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:226:1: ruleUnassigned returns [EObject current=null] : (otherlv_0= '3' this_Delegate_1= ruleDelegate ) ;
    public final EObject ruleUnassigned() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Delegate_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:229:28: ( (otherlv_0= '3' this_Delegate_1= ruleDelegate ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:230:1: (otherlv_0= '3' this_Delegate_1= ruleDelegate )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:230:1: (otherlv_0= '3' this_Delegate_1= ruleDelegate )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:230:3: otherlv_0= '3' this_Delegate_1= ruleDelegate
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleUnassigned518); 

                	newLeafNode(otherlv_0, grammarAccess.getUnassignedAccess().getDigitThreeKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getUnassignedAccess().getDelegateParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleDelegate_in_ruleUnassigned540);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:251:1: entryRulePrefixedUnassigned returns [EObject current=null] : iv_rulePrefixedUnassigned= rulePrefixedUnassigned EOF ;
    public final EObject entryRulePrefixedUnassigned() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedUnassigned = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:252:2: (iv_rulePrefixedUnassigned= rulePrefixedUnassigned EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:253:2: iv_rulePrefixedUnassigned= rulePrefixedUnassigned EOF
            {
             newCompositeNode(grammarAccess.getPrefixedUnassignedRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePrefixedUnassigned_in_entryRulePrefixedUnassigned575);
            iv_rulePrefixedUnassigned=rulePrefixedUnassigned();

            state._fsp--;

             current =iv_rulePrefixedUnassigned; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedUnassigned585); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:260:1: rulePrefixedUnassigned returns [EObject current=null] : (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) ) ;
    public final EObject rulePrefixedUnassigned() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_delegate_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:263:28: ( (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:264:1: (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:264:1: (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:264:3: otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_rulePrefixedUnassigned622); 

                	newLeafNode(otherlv_0, grammarAccess.getPrefixedUnassignedAccess().getDigitFourKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:268:1: ( (lv_delegate_1_0= rulePrefixedDelegate ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:269:1: (lv_delegate_1_0= rulePrefixedDelegate )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:269:1: (lv_delegate_1_0= rulePrefixedDelegate )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:270:3: lv_delegate_1_0= rulePrefixedDelegate
            {
             
            	        newCompositeNode(grammarAccess.getPrefixedUnassignedAccess().getDelegatePrefixedDelegateParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_rulePrefixedDelegate_in_rulePrefixedUnassigned643);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:294:1: entryRulePrefixedDelegate returns [EObject current=null] : iv_rulePrefixedDelegate= rulePrefixedDelegate EOF ;
    public final EObject entryRulePrefixedDelegate() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedDelegate = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:295:2: (iv_rulePrefixedDelegate= rulePrefixedDelegate EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:296:2: iv_rulePrefixedDelegate= rulePrefixedDelegate EOF
            {
             newCompositeNode(grammarAccess.getPrefixedDelegateRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePrefixedDelegate_in_entryRulePrefixedDelegate679);
            iv_rulePrefixedDelegate=rulePrefixedDelegate();

            state._fsp--;

             current =iv_rulePrefixedDelegate; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedDelegate689); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:303:1: rulePrefixedDelegate returns [EObject current=null] : (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate ) ;
    public final EObject rulePrefixedDelegate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Delegate_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:306:28: ( (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:307:1: (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:307:1: (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:307:3: otherlv_0= 'prefix' this_Delegate_1= ruleDelegate
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_rulePrefixedDelegate726); 

                	newLeafNode(otherlv_0, grammarAccess.getPrefixedDelegateAccess().getPrefixKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getPrefixedDelegateAccess().getDelegateParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleDelegate_in_rulePrefixedDelegate748);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:328:1: entryRuleDelegate returns [EObject current=null] : iv_ruleDelegate= ruleDelegate EOF ;
    public final EObject entryRuleDelegate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDelegate = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:329:2: (iv_ruleDelegate= ruleDelegate EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:330:2: iv_ruleDelegate= ruleDelegate EOF
            {
             newCompositeNode(grammarAccess.getDelegateRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDelegate_in_entryRuleDelegate783);
            iv_ruleDelegate=ruleDelegate();

            state._fsp--;

             current =iv_ruleDelegate; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDelegate793); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:337:1: ruleDelegate returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleDelegate() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:340:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:341:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:341:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:342:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:342:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:343:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDelegate834); 

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

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleRoot122 = new BitSet(new long[]{0x000000000000F000L});
        public static final BitSet FOLLOW_ruleSimple_in_ruleRoot145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDelegation_in_ruleRoot172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassigned_in_ruleRoot199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedUnassigned_in_ruleRoot226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimple_in_entryRuleSimple262 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimple272 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleSimple309 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimple326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDelegation_in_entryRuleDelegation367 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDelegation377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleDelegation414 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDelegate_in_ruleDelegation435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassigned_in_entryRuleUnassigned471 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassigned481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleUnassigned518 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDelegate_in_ruleUnassigned540 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedUnassigned_in_entryRulePrefixedUnassigned575 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedUnassigned585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rulePrefixedUnassigned622 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rulePrefixedDelegate_in_rulePrefixedUnassigned643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedDelegate_in_entryRulePrefixedDelegate679 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedDelegate689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rulePrefixedDelegate726 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDelegate_in_rulePrefixedDelegate748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDelegate_in_entryRuleDelegate783 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDelegate793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDelegate834 = new BitSet(new long[]{0x0000000000000002L});
    }


}