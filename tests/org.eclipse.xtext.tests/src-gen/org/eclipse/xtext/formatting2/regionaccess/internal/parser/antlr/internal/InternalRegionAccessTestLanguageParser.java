package org.eclipse.xtext.formatting2.regionaccess.internal.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'5'", "'6'", "'7'", "'1'", "'2'", "'3'", "'4'", "'prefix'", "'+'", "'('", "')'", "'unassigned'", "'child'", "'ref'", "'action'", "'end'", "'datatype'", "'lit1'", "'lit2'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:68:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:69:2: (iv_ruleRoot= ruleRoot EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:70:2: iv_ruleRoot= ruleRoot EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:77:1: ruleRoot returns [EObject current=null] : (this_Simple_0= ruleSimple | this_Delegation_1= ruleDelegation | this_Unassigned_2= ruleUnassigned | this_PrefixedUnassigned_3= rulePrefixedUnassigned | (otherlv_4= '5' this_Expression_5= ruleExpression ) | (otherlv_6= '6' this_Mixed_7= ruleMixed ) | (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) ) ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject this_Simple_0 = null;

        EObject this_Delegation_1 = null;

        EObject this_Unassigned_2 = null;

        EObject this_PrefixedUnassigned_3 = null;

        EObject this_Expression_5 = null;

        EObject this_Mixed_7 = null;

        EObject lv_mixed_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:80:28: ( (this_Simple_0= ruleSimple | this_Delegation_1= ruleDelegation | this_Unassigned_2= ruleUnassigned | this_PrefixedUnassigned_3= rulePrefixedUnassigned | (otherlv_4= '5' this_Expression_5= ruleExpression ) | (otherlv_6= '6' this_Mixed_7= ruleMixed ) | (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:81:1: (this_Simple_0= ruleSimple | this_Delegation_1= ruleDelegation | this_Unassigned_2= ruleUnassigned | this_PrefixedUnassigned_3= rulePrefixedUnassigned | (otherlv_4= '5' this_Expression_5= ruleExpression ) | (otherlv_6= '6' this_Mixed_7= ruleMixed ) | (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:81:1: (this_Simple_0= ruleSimple | this_Delegation_1= ruleDelegation | this_Unassigned_2= ruleUnassigned | this_PrefixedUnassigned_3= rulePrefixedUnassigned | (otherlv_4= '5' this_Expression_5= ruleExpression ) | (otherlv_6= '6' this_Mixed_7= ruleMixed ) | (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) ) )
            int alt1=7;
            switch ( input.LA(1) ) {
            case 14:
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
            case 11:
                {
                alt1=5;
                }
                break;
            case 12:
                {
                alt1=6;
                }
                break;
            case 13:
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:82:5: this_Simple_0= ruleSimple
                    {
                     
                            newCompositeNode(grammarAccess.getRootAccess().getSimpleParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSimple_in_ruleRoot132);
                    this_Simple_0=ruleSimple();

                    state._fsp--;

                     
                            current = this_Simple_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:92:5: this_Delegation_1= ruleDelegation
                    {
                     
                            newCompositeNode(grammarAccess.getRootAccess().getDelegationParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDelegation_in_ruleRoot159);
                    this_Delegation_1=ruleDelegation();

                    state._fsp--;

                     
                            current = this_Delegation_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:102:5: this_Unassigned_2= ruleUnassigned
                    {
                     
                            newCompositeNode(grammarAccess.getRootAccess().getUnassignedParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleUnassigned_in_ruleRoot186);
                    this_Unassigned_2=ruleUnassigned();

                    state._fsp--;

                     
                            current = this_Unassigned_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:112:5: this_PrefixedUnassigned_3= rulePrefixedUnassigned
                    {
                     
                            newCompositeNode(grammarAccess.getRootAccess().getPrefixedUnassignedParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedUnassigned_in_ruleRoot213);
                    this_PrefixedUnassigned_3=rulePrefixedUnassigned();

                    state._fsp--;

                     
                            current = this_PrefixedUnassigned_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:121:6: (otherlv_4= '5' this_Expression_5= ruleExpression )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:121:6: (otherlv_4= '5' this_Expression_5= ruleExpression )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:121:8: otherlv_4= '5' this_Expression_5= ruleExpression
                    {
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleRoot231); 

                        	newLeafNode(otherlv_4, grammarAccess.getRootAccess().getDigitFiveKeyword_4_0());
                        
                     
                            newCompositeNode(grammarAccess.getRootAccess().getExpressionParserRuleCall_4_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleRoot253);
                    this_Expression_5=ruleExpression();

                    state._fsp--;

                     
                            current = this_Expression_5; 
                            afterParserOrEnumRuleCall();
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:135:6: (otherlv_6= '6' this_Mixed_7= ruleMixed )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:135:6: (otherlv_6= '6' this_Mixed_7= ruleMixed )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:135:8: otherlv_6= '6' this_Mixed_7= ruleMixed
                    {
                    otherlv_6=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleRoot272); 

                        	newLeafNode(otherlv_6, grammarAccess.getRootAccess().getDigitSixKeyword_5_0());
                        
                     
                            newCompositeNode(grammarAccess.getRootAccess().getMixedParserRuleCall_5_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleMixed_in_ruleRoot294);
                    this_Mixed_7=ruleMixed();

                    state._fsp--;

                     
                            current = this_Mixed_7; 
                            afterParserOrEnumRuleCall();
                        

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:149:6: (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:149:6: (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:149:8: otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) )
                    {
                    otherlv_8=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleRoot313); 

                        	newLeafNode(otherlv_8, grammarAccess.getRootAccess().getDigitSevenKeyword_6_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:153:1: ( (lv_mixed_9_0= ruleMixed ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:154:1: (lv_mixed_9_0= ruleMixed )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:154:1: (lv_mixed_9_0= ruleMixed )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:155:3: lv_mixed_9_0= ruleMixed
                    {
                     
                    	        newCompositeNode(grammarAccess.getRootAccess().getMixedMixedParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMixed_in_ruleRoot334);
                    lv_mixed_9_0=ruleMixed();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRootRule());
                    	        }
                           		set(
                           			current, 
                           			"mixed",
                            		lv_mixed_9_0, 
                            		"org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguage.Mixed");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


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
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleSimple"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:179:1: entryRuleSimple returns [EObject current=null] : iv_ruleSimple= ruleSimple EOF ;
    public final EObject entryRuleSimple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimple = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:180:2: (iv_ruleSimple= ruleSimple EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:181:2: iv_ruleSimple= ruleSimple EOF
            {
             newCompositeNode(grammarAccess.getSimpleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimple_in_entryRuleSimple371);
            iv_ruleSimple=ruleSimple();

            state._fsp--;

             current =iv_ruleSimple; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimple381); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:188:1: ruleSimple returns [EObject current=null] : (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleSimple() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:191:28: ( (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:192:1: (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:192:1: (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:192:3: otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSimple418); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleAccess().getDigitOneKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:196:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:197:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:197:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:198:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimple435); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:222:1: entryRuleDelegation returns [EObject current=null] : iv_ruleDelegation= ruleDelegation EOF ;
    public final EObject entryRuleDelegation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDelegation = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:223:2: (iv_ruleDelegation= ruleDelegation EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:224:2: iv_ruleDelegation= ruleDelegation EOF
            {
             newCompositeNode(grammarAccess.getDelegationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDelegation_in_entryRuleDelegation476);
            iv_ruleDelegation=ruleDelegation();

            state._fsp--;

             current =iv_ruleDelegation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDelegation486); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:231:1: ruleDelegation returns [EObject current=null] : (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) ) ;
    public final EObject ruleDelegation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_delegate_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:234:28: ( (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:235:1: (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:235:1: (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:235:3: otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleDelegation523); 

                	newLeafNode(otherlv_0, grammarAccess.getDelegationAccess().getDigitTwoKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:239:1: ( (lv_delegate_1_0= ruleDelegate ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:240:1: (lv_delegate_1_0= ruleDelegate )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:240:1: (lv_delegate_1_0= ruleDelegate )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:241:3: lv_delegate_1_0= ruleDelegate
            {
             
            	        newCompositeNode(grammarAccess.getDelegationAccess().getDelegateDelegateParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleDelegate_in_ruleDelegation544);
            lv_delegate_1_0=ruleDelegate();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDelegationRule());
            	        }
                   		set(
                   			current, 
                   			"delegate",
                    		lv_delegate_1_0, 
                    		"org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguage.Delegate");
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:265:1: entryRuleUnassigned returns [EObject current=null] : iv_ruleUnassigned= ruleUnassigned EOF ;
    public final EObject entryRuleUnassigned() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassigned = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:266:2: (iv_ruleUnassigned= ruleUnassigned EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:267:2: iv_ruleUnassigned= ruleUnassigned EOF
            {
             newCompositeNode(grammarAccess.getUnassignedRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnassigned_in_entryRuleUnassigned580);
            iv_ruleUnassigned=ruleUnassigned();

            state._fsp--;

             current =iv_ruleUnassigned; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnassigned590); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:274:1: ruleUnassigned returns [EObject current=null] : (otherlv_0= '3' this_Delegate_1= ruleDelegate ) ;
    public final EObject ruleUnassigned() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Delegate_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:277:28: ( (otherlv_0= '3' this_Delegate_1= ruleDelegate ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:278:1: (otherlv_0= '3' this_Delegate_1= ruleDelegate )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:278:1: (otherlv_0= '3' this_Delegate_1= ruleDelegate )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:278:3: otherlv_0= '3' this_Delegate_1= ruleDelegate
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleUnassigned627); 

                	newLeafNode(otherlv_0, grammarAccess.getUnassignedAccess().getDigitThreeKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getUnassignedAccess().getDelegateParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleDelegate_in_ruleUnassigned649);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:299:1: entryRulePrefixedUnassigned returns [EObject current=null] : iv_rulePrefixedUnassigned= rulePrefixedUnassigned EOF ;
    public final EObject entryRulePrefixedUnassigned() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedUnassigned = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:300:2: (iv_rulePrefixedUnassigned= rulePrefixedUnassigned EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:301:2: iv_rulePrefixedUnassigned= rulePrefixedUnassigned EOF
            {
             newCompositeNode(grammarAccess.getPrefixedUnassignedRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePrefixedUnassigned_in_entryRulePrefixedUnassigned684);
            iv_rulePrefixedUnassigned=rulePrefixedUnassigned();

            state._fsp--;

             current =iv_rulePrefixedUnassigned; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedUnassigned694); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:308:1: rulePrefixedUnassigned returns [EObject current=null] : (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) ) ;
    public final EObject rulePrefixedUnassigned() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_delegate_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:311:28: ( (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:312:1: (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:312:1: (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:312:3: otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) )
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_rulePrefixedUnassigned731); 

                	newLeafNode(otherlv_0, grammarAccess.getPrefixedUnassignedAccess().getDigitFourKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:316:1: ( (lv_delegate_1_0= rulePrefixedDelegate ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:317:1: (lv_delegate_1_0= rulePrefixedDelegate )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:317:1: (lv_delegate_1_0= rulePrefixedDelegate )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:318:3: lv_delegate_1_0= rulePrefixedDelegate
            {
             
            	        newCompositeNode(grammarAccess.getPrefixedUnassignedAccess().getDelegatePrefixedDelegateParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_rulePrefixedDelegate_in_rulePrefixedUnassigned752);
            lv_delegate_1_0=rulePrefixedDelegate();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPrefixedUnassignedRule());
            	        }
                   		set(
                   			current, 
                   			"delegate",
                    		lv_delegate_1_0, 
                    		"org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguage.PrefixedDelegate");
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:342:1: entryRulePrefixedDelegate returns [EObject current=null] : iv_rulePrefixedDelegate= rulePrefixedDelegate EOF ;
    public final EObject entryRulePrefixedDelegate() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedDelegate = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:343:2: (iv_rulePrefixedDelegate= rulePrefixedDelegate EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:344:2: iv_rulePrefixedDelegate= rulePrefixedDelegate EOF
            {
             newCompositeNode(grammarAccess.getPrefixedDelegateRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePrefixedDelegate_in_entryRulePrefixedDelegate788);
            iv_rulePrefixedDelegate=rulePrefixedDelegate();

            state._fsp--;

             current =iv_rulePrefixedDelegate; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedDelegate798); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:351:1: rulePrefixedDelegate returns [EObject current=null] : (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate ) ;
    public final EObject rulePrefixedDelegate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Delegate_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:354:28: ( (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:355:1: (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:355:1: (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:355:3: otherlv_0= 'prefix' this_Delegate_1= ruleDelegate
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_rulePrefixedDelegate835); 

                	newLeafNode(otherlv_0, grammarAccess.getPrefixedDelegateAccess().getPrefixKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getPrefixedDelegateAccess().getDelegateParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleDelegate_in_rulePrefixedDelegate857);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:376:1: entryRuleDelegate returns [EObject current=null] : iv_ruleDelegate= ruleDelegate EOF ;
    public final EObject entryRuleDelegate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDelegate = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:377:2: (iv_ruleDelegate= ruleDelegate EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:378:2: iv_ruleDelegate= ruleDelegate EOF
            {
             newCompositeNode(grammarAccess.getDelegateRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDelegate_in_entryRuleDelegate892);
            iv_ruleDelegate=ruleDelegate();

            state._fsp--;

             current =iv_ruleDelegate; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDelegate902); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:385:1: ruleDelegate returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleDelegate() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:388:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:389:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:389:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:390:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:390:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:391:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDelegate943); 

            			newLeafNode(lv_name_0_0, grammarAccess.getDelegateAccess().getNameIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDelegateRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:415:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:416:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:417:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_entryRuleExpression983);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression993); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:424:1: ruleExpression returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:427:28: ( (this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:428:1: (this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:428:1: (this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:429:5: this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getExpressionAccess().getPrimaryParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_rulePrimary_in_ruleExpression1040);
            this_Primary_0=rulePrimary();

            state._fsp--;

             
                    current = this_Primary_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:437:1: ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==19) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:437:2: () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:437:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:438:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getExpressionAccess().getAddLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleExpression1061); 

            	        	newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getPlusSignKeyword_1_1());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:447:1: ( (lv_right_3_0= rulePrimary ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:448:1: (lv_right_3_0= rulePrimary )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:448:1: (lv_right_3_0= rulePrimary )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:449:3: lv_right_3_0= rulePrimary
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExpressionAccess().getRightPrimaryParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_rulePrimary_in_ruleExpression1082);
            	    lv_right_3_0=rulePrimary();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getExpressionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguage.Primary");
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:473:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:474:2: (iv_rulePrimary= rulePrimary EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:475:2: iv_rulePrimary= rulePrimary EOF
            {
             newCompositeNode(grammarAccess.getPrimaryRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePrimary_in_entryRulePrimary1120);
            iv_rulePrimary=rulePrimary();

            state._fsp--;

             current =iv_rulePrimary; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimary1130); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:482:1: rulePrimary returns [EObject current=null] : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | this_Parenthesized_2= ruleParenthesized ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject this_Parenthesized_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:485:28: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | this_Parenthesized_2= ruleParenthesized ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:486:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | this_Parenthesized_2= ruleParenthesized )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:486:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | this_Parenthesized_2= ruleParenthesized )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            else if ( (LA3_0==20) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:486:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:486:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:486:3: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:486:3: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:487:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrimaryAccess().getNamedAction_0_0(),
                                current);
                        

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:492:2: ( (lv_name_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:493:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:493:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:494:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePrimary1182); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getPrimaryAccess().getNameIDTerminalRuleCall_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPrimaryRule());
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
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:512:5: this_Parenthesized_2= ruleParenthesized
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryAccess().getParenthesizedParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesized_in_rulePrimary1216);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:528:1: entryRuleParenthesized returns [EObject current=null] : iv_ruleParenthesized= ruleParenthesized EOF ;
    public final EObject entryRuleParenthesized() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesized = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:529:2: (iv_ruleParenthesized= ruleParenthesized EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:530:2: iv_ruleParenthesized= ruleParenthesized EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesized_in_entryRuleParenthesized1251);
            iv_ruleParenthesized=ruleParenthesized();

            state._fsp--;

             current =iv_ruleParenthesized; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesized1261); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:537:1: ruleParenthesized returns [EObject current=null] : (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) ;
    public final EObject ruleParenthesized() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Expression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:540:28: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:541:1: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:541:1: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:541:3: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleParenthesized1298); 

                	newLeafNode(otherlv_0, grammarAccess.getParenthesizedAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getParenthesizedAccess().getExpressionParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleParenthesized1320);
            this_Expression_1=ruleExpression();

            state._fsp--;

             
                    current = this_Expression_1; 
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleParenthesized1331); 

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


    // $ANTLR start "entryRuleMixed"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:566:1: entryRuleMixed returns [EObject current=null] : iv_ruleMixed= ruleMixed EOF ;
    public final EObject entryRuleMixed() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMixed = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:567:2: (iv_ruleMixed= ruleMixed EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:568:2: iv_ruleMixed= ruleMixed EOF
            {
             newCompositeNode(grammarAccess.getMixedRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMixed_in_entryRuleMixed1367);
            iv_ruleMixed=ruleMixed();

            state._fsp--;

             current =iv_ruleMixed; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMixed1377); 

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
    // $ANTLR end "entryRuleMixed"


    // $ANTLR start "ruleMixed"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:575:1: ruleMixed returns [EObject current=null] : (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( () | this_Mixed_5= ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) ) otherlv_13= ')' ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )* ) ;
    public final EObject ruleMixed() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_ID_2=null;
        Token lv_name_6_0=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        EObject this_Mixed_5 = null;

        EObject lv_eobj_8_0 = null;

        AntlrDatatypeRuleToken lv_datatype_9_0 = null;

        Enumerator lv_lit_12_0 = null;

        EObject lv_body_16_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:578:28: ( (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( () | this_Mixed_5= ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) ) otherlv_13= ')' ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:579:1: (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( () | this_Mixed_5= ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) ) otherlv_13= ')' ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:579:1: (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( () | this_Mixed_5= ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) ) otherlv_13= ')' ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:579:3: otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( () | this_Mixed_5= ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) ) otherlv_13= ')' ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )*
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleMixed1414); 

                	newLeafNode(otherlv_0, grammarAccess.getMixedAccess().getLeftParenthesisKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:583:1: (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==22) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:583:3: otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype )
                    {
                    otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleMixed1427); 

                        	newLeafNode(otherlv_1, grammarAccess.getMixedAccess().getUnassignedKeyword_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:587:1: (this_ID_2= RULE_ID | ruleDatatype )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID) ) {
                        alt4=1;
                    }
                    else if ( (LA4_0==27) ) {
                        alt4=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:587:2: this_ID_2= RULE_ID
                            {
                            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMixed1439); 
                             
                                newLeafNode(this_ID_2, grammarAccess.getMixedAccess().getIDTerminalRuleCall_1_1_0()); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:593:5: ruleDatatype
                            {
                             
                                    newCompositeNode(grammarAccess.getMixedAccess().getDatatypeParserRuleCall_1_1_1()); 
                                
                            pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleMixed1460);
                            ruleDatatype();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:600:4: ( () | this_Mixed_5= ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt7=1;
                }
                break;
            case 20:
                {
                alt7=2;
                }
                break;
            case RULE_ID:
            case 23:
            case 24:
            case 27:
            case 28:
            case 29:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:600:5: ()
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:600:5: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:601:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getMixedAccess().getActionAction_2_0(),
                                current);
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:608:5: this_Mixed_5= ruleMixed
                    {
                     
                            newCompositeNode(grammarAccess.getMixedAccess().getMixedParserRuleCall_2_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleMixed_in_ruleMixed1500);
                    this_Mixed_5=ruleMixed();

                    state._fsp--;

                     
                            current = this_Mixed_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:617:6: ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:617:6: ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) )
                    int alt6=5;
                    switch ( input.LA(1) ) {
                    case RULE_ID:
                        {
                        alt6=1;
                        }
                        break;
                    case 23:
                        {
                        alt6=2;
                        }
                        break;
                    case 27:
                        {
                        alt6=3;
                        }
                        break;
                    case 24:
                        {
                        alt6=4;
                        }
                        break;
                    case 28:
                    case 29:
                        {
                        alt6=5;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;
                    }

                    switch (alt6) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:617:7: ( (lv_name_6_0= RULE_ID ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:617:7: ( (lv_name_6_0= RULE_ID ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:618:1: (lv_name_6_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:618:1: (lv_name_6_0= RULE_ID )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:619:3: lv_name_6_0= RULE_ID
                            {
                            lv_name_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMixed1523); 

                            			newLeafNode(lv_name_6_0, grammarAccess.getMixedAccess().getNameIDTerminalRuleCall_2_2_0_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getMixedRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"name",
                                    		lv_name_6_0, 
                                    		"org.eclipse.xtext.common.Terminals.ID");
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:636:6: (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:636:6: (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:636:8: otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) )
                            {
                            otherlv_7=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleMixed1547); 

                                	newLeafNode(otherlv_7, grammarAccess.getMixedAccess().getChildKeyword_2_2_1_0());
                                
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:640:1: ( (lv_eobj_8_0= ruleMixed ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:641:1: (lv_eobj_8_0= ruleMixed )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:641:1: (lv_eobj_8_0= ruleMixed )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:642:3: lv_eobj_8_0= ruleMixed
                            {
                             
                            	        newCompositeNode(grammarAccess.getMixedAccess().getEobjMixedParserRuleCall_2_2_1_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleMixed_in_ruleMixed1568);
                            lv_eobj_8_0=ruleMixed();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getMixedRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"eobj",
                                    		lv_eobj_8_0, 
                                    		"org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguage.Mixed");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }


                            }
                            break;
                        case 3 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:659:6: ( (lv_datatype_9_0= ruleDatatype ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:659:6: ( (lv_datatype_9_0= ruleDatatype ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:660:1: (lv_datatype_9_0= ruleDatatype )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:660:1: (lv_datatype_9_0= ruleDatatype )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:661:3: lv_datatype_9_0= ruleDatatype
                            {
                             
                            	        newCompositeNode(grammarAccess.getMixedAccess().getDatatypeDatatypeParserRuleCall_2_2_2_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleMixed1596);
                            lv_datatype_9_0=ruleDatatype();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getMixedRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"datatype",
                                    		lv_datatype_9_0, 
                                    		"org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguage.Datatype");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 4 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:678:6: (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:678:6: (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:678:8: otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) )
                            {
                            otherlv_10=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleMixed1615); 

                                	newLeafNode(otherlv_10, grammarAccess.getMixedAccess().getRefKeyword_2_2_3_0());
                                
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:682:1: ( (otherlv_11= RULE_ID ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:683:1: (otherlv_11= RULE_ID )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:683:1: (otherlv_11= RULE_ID )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:684:3: otherlv_11= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getMixedRule());
                            	        }
                                    
                            otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMixed1635); 

                            		newLeafNode(otherlv_11, grammarAccess.getMixedAccess().getRefMixedCrossReference_2_2_3_1_0()); 
                            	

                            }


                            }


                            }


                            }
                            break;
                        case 5 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:696:6: ( (lv_lit_12_0= ruleEnum ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:696:6: ( (lv_lit_12_0= ruleEnum ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:697:1: (lv_lit_12_0= ruleEnum )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:697:1: (lv_lit_12_0= ruleEnum )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:698:3: lv_lit_12_0= ruleEnum
                            {
                             
                            	        newCompositeNode(grammarAccess.getMixedAccess().getLitEnumEnumRuleCall_2_2_4_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEnum_in_ruleMixed1663);
                            lv_lit_12_0=ruleEnum();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getMixedRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"lit",
                                    		lv_lit_12_0, 
                                    		"org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguage.Enum");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleMixed1677); 

                	newLeafNode(otherlv_13, grammarAccess.getMixedAccess().getRightParenthesisKeyword_3());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:718:1: ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==25) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:718:2: () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )?
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:718:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:719:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getMixedAccess().getAssignedActionChildAction_4_0(),
            	                current);
            	        

            	    }

            	    otherlv_15=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleMixed1699); 

            	        	newLeafNode(otherlv_15, grammarAccess.getMixedAccess().getActionKeyword_4_1());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:728:1: ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )?
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==20) ) {
            	        alt8=1;
            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:728:2: ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end'
            	            {
            	            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:728:2: ( (lv_body_16_0= ruleMixed ) )
            	            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:729:1: (lv_body_16_0= ruleMixed )
            	            {
            	            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:729:1: (lv_body_16_0= ruleMixed )
            	            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:730:3: lv_body_16_0= ruleMixed
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getMixedAccess().getBodyMixedParserRuleCall_4_2_0_0()); 
            	            	    
            	            pushFollow(FollowSets000.FOLLOW_ruleMixed_in_ruleMixed1721);
            	            lv_body_16_0=ruleMixed();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getMixedRule());
            	            	        }
            	                   		set(
            	                   			current, 
            	                   			"body",
            	                    		lv_body_16_0, 
            	                    		"org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguage.Mixed");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }


            	            }

            	            otherlv_17=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleMixed1733); 

            	                	newLeafNode(otherlv_17, grammarAccess.getMixedAccess().getEndKeyword_4_2_1());
            	                

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // $ANTLR end "ruleMixed"


    // $ANTLR start "entryRuleDatatype"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:758:1: entryRuleDatatype returns [String current=null] : iv_ruleDatatype= ruleDatatype EOF ;
    public final String entryRuleDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatype = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:759:2: (iv_ruleDatatype= ruleDatatype EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:760:2: iv_ruleDatatype= ruleDatatype EOF
            {
             newCompositeNode(grammarAccess.getDatatypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_entryRuleDatatype1774);
            iv_ruleDatatype=ruleDatatype();

            state._fsp--;

             current =iv_ruleDatatype.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatype1785); 

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
    // $ANTLR end "entryRuleDatatype"


    // $ANTLR start "ruleDatatype"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:767:1: ruleDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'datatype' (this_Datatype_1= ruleDatatype | this_ID_2= RULE_ID ) ) ;
    public final AntlrDatatypeRuleToken ruleDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_2=null;
        AntlrDatatypeRuleToken this_Datatype_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:770:28: ( (kw= 'datatype' (this_Datatype_1= ruleDatatype | this_ID_2= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:771:1: (kw= 'datatype' (this_Datatype_1= ruleDatatype | this_ID_2= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:771:1: (kw= 'datatype' (this_Datatype_1= ruleDatatype | this_ID_2= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:772:2: kw= 'datatype' (this_Datatype_1= ruleDatatype | this_ID_2= RULE_ID )
            {
            kw=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleDatatype1823); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDatatypeAccess().getDatatypeKeyword_0()); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:777:1: (this_Datatype_1= ruleDatatype | this_ID_2= RULE_ID )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==27) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_ID) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:778:5: this_Datatype_1= ruleDatatype
                    {
                     
                            newCompositeNode(grammarAccess.getDatatypeAccess().getDatatypeParserRuleCall_1_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleDatatype1846);
                    this_Datatype_1=ruleDatatype();

                    state._fsp--;


                    		current.merge(this_Datatype_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:789:10: this_ID_2= RULE_ID
                    {
                    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDatatype1872); 

                    		current.merge(this_ID_2);
                        
                     
                        newLeafNode(this_ID_2, grammarAccess.getDatatypeAccess().getIDTerminalRuleCall_1_1()); 
                        

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
    // $ANTLR end "ruleDatatype"


    // $ANTLR start "ruleEnum"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:804:1: ruleEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) ) ;
    public final Enumerator ruleEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:806:28: ( ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:807:1: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:807:1: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==28) ) {
                alt11=1;
            }
            else if ( (LA11_0==29) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:807:2: (enumLiteral_0= 'lit1' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:807:2: (enumLiteral_0= 'lit1' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:807:4: enumLiteral_0= 'lit1'
                    {
                    enumLiteral_0=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleEnum1932); 

                            current = grammarAccess.getEnumAccess().getLit1EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getEnumAccess().getLit1EnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:813:6: (enumLiteral_1= 'lit2' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:813:6: (enumLiteral_1= 'lit2' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/formatting2/regionaccess/internal/parser/antlr/internal/InternalRegionAccessTestLanguage.g:813:8: enumLiteral_1= 'lit2'
                    {
                    enumLiteral_1=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleEnum1949); 

                            current = grammarAccess.getEnumAccess().getLit2EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getEnumAccess().getLit2EnumLiteralDeclaration_1()); 
                        

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
    // $ANTLR end "ruleEnum"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimple_in_ruleRoot132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDelegation_in_ruleRoot159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassigned_in_ruleRoot186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedUnassigned_in_ruleRoot213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleRoot231 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleRoot253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleRoot272 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_ruleMixed_in_ruleRoot294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleRoot313 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_ruleMixed_in_ruleRoot334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimple_in_entryRuleSimple371 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimple381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleSimple418 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimple435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDelegation_in_entryRuleDelegation476 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDelegation486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleDelegation523 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDelegate_in_ruleDelegation544 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnassigned_in_entryRuleUnassigned580 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnassigned590 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleUnassigned627 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDelegate_in_ruleUnassigned649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedUnassigned_in_entryRulePrefixedUnassigned684 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedUnassigned694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rulePrefixedUnassigned731 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rulePrefixedDelegate_in_rulePrefixedUnassigned752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedDelegate_in_entryRulePrefixedDelegate788 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedDelegate798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rulePrefixedDelegate835 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDelegate_in_rulePrefixedDelegate857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDelegate_in_entryRuleDelegate892 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDelegate902 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDelegate943 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression983 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression993 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimary_in_ruleExpression1040 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleExpression1061 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_rulePrimary_in_ruleExpression1082 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rulePrimary_in_entryRulePrimary1120 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimary1130 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePrimary1182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesized_in_rulePrimary1216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesized_in_entryRuleParenthesized1251 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesized1261 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleParenthesized1298 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesized1320 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleParenthesized1331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMixed_in_entryRuleMixed1367 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMixed1377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleMixed1414 = new BitSet(new long[]{0x0000000039F00010L});
        public static final BitSet FOLLOW_22_in_ruleMixed1427 = new BitSet(new long[]{0x0000000008000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMixed1439 = new BitSet(new long[]{0x0000000039F00010L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleMixed1460 = new BitSet(new long[]{0x0000000039F00010L});
        public static final BitSet FOLLOW_ruleMixed_in_ruleMixed1500 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMixed1523 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_23_in_ruleMixed1547 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_ruleMixed_in_ruleMixed1568 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleMixed1596 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_24_in_ruleMixed1615 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMixed1635 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_ruleEnum_in_ruleMixed1663 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleMixed1677 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleMixed1699 = new BitSet(new long[]{0x0000000002100002L});
        public static final BitSet FOLLOW_ruleMixed_in_ruleMixed1721 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleMixed1733 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleDatatype_in_entryRuleDatatype1774 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatype1785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleDatatype1823 = new BitSet(new long[]{0x0000000008000010L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleDatatype1846 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDatatype1872 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleEnum1932 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleEnum1949 = new BitSet(new long[]{0x0000000000000002L});
    }


}