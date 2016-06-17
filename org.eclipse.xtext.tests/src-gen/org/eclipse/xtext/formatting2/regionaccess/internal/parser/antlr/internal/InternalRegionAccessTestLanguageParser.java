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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'5'", "'6'", "'7'", "'action'", "'1'", "'2'", "'3'", "'4'", "'prefix'", "'+'", "'('", "')'", "'unassigned'", "'fragment'", "'child'", "'ref'", "'end'", "'datatype'", "'recursion'", "'lit1'", "'lit2'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
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


        public InternalRegionAccessTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRegionAccessTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRegionAccessTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalRegionAccessTestLanguage.g"; }



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
    // InternalRegionAccessTestLanguage.g:68:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // InternalRegionAccessTestLanguage.g:69:2: (iv_ruleRoot= ruleRoot EOF )
            // InternalRegionAccessTestLanguage.g:70:2: iv_ruleRoot= ruleRoot EOF
            {
             newCompositeNode(grammarAccess.getRootRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRoot=ruleRoot();

            state._fsp--;

             current =iv_ruleRoot; 
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
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // InternalRegionAccessTestLanguage.g:77:1: ruleRoot returns [EObject current=null] : (this_Simple_0= ruleSimple | this_Delegation_1= ruleDelegation | this_Unassigned_2= ruleUnassigned | this_PrefixedUnassigned_3= rulePrefixedUnassigned | (otherlv_4= '5' this_Expression_5= ruleExpression ) | (otherlv_6= '6' this_Mixed_7= ruleMixed ) | (otherlv_8= '7' ( () otherlv_10= 'action' )? ( (lv_mixed_11_0= ruleMixed ) ) ) ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject this_Simple_0 = null;

        EObject this_Delegation_1 = null;

        EObject this_Unassigned_2 = null;

        EObject this_PrefixedUnassigned_3 = null;

        EObject this_Expression_5 = null;

        EObject this_Mixed_7 = null;

        EObject lv_mixed_11_0 = null;


         enterRule(); 
            
        try {
            // InternalRegionAccessTestLanguage.g:80:28: ( (this_Simple_0= ruleSimple | this_Delegation_1= ruleDelegation | this_Unassigned_2= ruleUnassigned | this_PrefixedUnassigned_3= rulePrefixedUnassigned | (otherlv_4= '5' this_Expression_5= ruleExpression ) | (otherlv_6= '6' this_Mixed_7= ruleMixed ) | (otherlv_8= '7' ( () otherlv_10= 'action' )? ( (lv_mixed_11_0= ruleMixed ) ) ) ) )
            // InternalRegionAccessTestLanguage.g:81:1: (this_Simple_0= ruleSimple | this_Delegation_1= ruleDelegation | this_Unassigned_2= ruleUnassigned | this_PrefixedUnassigned_3= rulePrefixedUnassigned | (otherlv_4= '5' this_Expression_5= ruleExpression ) | (otherlv_6= '6' this_Mixed_7= ruleMixed ) | (otherlv_8= '7' ( () otherlv_10= 'action' )? ( (lv_mixed_11_0= ruleMixed ) ) ) )
            {
            // InternalRegionAccessTestLanguage.g:81:1: (this_Simple_0= ruleSimple | this_Delegation_1= ruleDelegation | this_Unassigned_2= ruleUnassigned | this_PrefixedUnassigned_3= rulePrefixedUnassigned | (otherlv_4= '5' this_Expression_5= ruleExpression ) | (otherlv_6= '6' this_Mixed_7= ruleMixed ) | (otherlv_8= '7' ( () otherlv_10= 'action' )? ( (lv_mixed_11_0= ruleMixed ) ) ) )
            int alt2=7;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt2=1;
                }
                break;
            case 16:
                {
                alt2=2;
                }
                break;
            case 17:
                {
                alt2=3;
                }
                break;
            case 18:
                {
                alt2=4;
                }
                break;
            case 11:
                {
                alt2=5;
                }
                break;
            case 12:
                {
                alt2=6;
                }
                break;
            case 13:
                {
                alt2=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalRegionAccessTestLanguage.g:82:5: this_Simple_0= ruleSimple
                    {
                     
                            newCompositeNode(grammarAccess.getRootAccess().getSimpleParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Simple_0=ruleSimple();

                    state._fsp--;

                     
                            current = this_Simple_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalRegionAccessTestLanguage.g:92:5: this_Delegation_1= ruleDelegation
                    {
                     
                            newCompositeNode(grammarAccess.getRootAccess().getDelegationParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Delegation_1=ruleDelegation();

                    state._fsp--;

                     
                            current = this_Delegation_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalRegionAccessTestLanguage.g:102:5: this_Unassigned_2= ruleUnassigned
                    {
                     
                            newCompositeNode(grammarAccess.getRootAccess().getUnassignedParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Unassigned_2=ruleUnassigned();

                    state._fsp--;

                     
                            current = this_Unassigned_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalRegionAccessTestLanguage.g:112:5: this_PrefixedUnassigned_3= rulePrefixedUnassigned
                    {
                     
                            newCompositeNode(grammarAccess.getRootAccess().getPrefixedUnassignedParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PrefixedUnassigned_3=rulePrefixedUnassigned();

                    state._fsp--;

                     
                            current = this_PrefixedUnassigned_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // InternalRegionAccessTestLanguage.g:121:6: (otherlv_4= '5' this_Expression_5= ruleExpression )
                    {
                    // InternalRegionAccessTestLanguage.g:121:6: (otherlv_4= '5' this_Expression_5= ruleExpression )
                    // InternalRegionAccessTestLanguage.g:121:8: otherlv_4= '5' this_Expression_5= ruleExpression
                    {
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_4, grammarAccess.getRootAccess().getDigitFiveKeyword_4_0());
                        
                     
                            newCompositeNode(grammarAccess.getRootAccess().getExpressionParserRuleCall_4_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Expression_5=ruleExpression();

                    state._fsp--;

                     
                            current = this_Expression_5; 
                            afterParserOrEnumRuleCall();
                        

                    }


                    }
                    break;
                case 6 :
                    // InternalRegionAccessTestLanguage.g:135:6: (otherlv_6= '6' this_Mixed_7= ruleMixed )
                    {
                    // InternalRegionAccessTestLanguage.g:135:6: (otherlv_6= '6' this_Mixed_7= ruleMixed )
                    // InternalRegionAccessTestLanguage.g:135:8: otherlv_6= '6' this_Mixed_7= ruleMixed
                    {
                    otherlv_6=(Token)match(input,12,FollowSets000.FOLLOW_4); 

                        	newLeafNode(otherlv_6, grammarAccess.getRootAccess().getDigitSixKeyword_5_0());
                        
                     
                            newCompositeNode(grammarAccess.getRootAccess().getMixedParserRuleCall_5_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Mixed_7=ruleMixed();

                    state._fsp--;

                     
                            current = this_Mixed_7; 
                            afterParserOrEnumRuleCall();
                        

                    }


                    }
                    break;
                case 7 :
                    // InternalRegionAccessTestLanguage.g:149:6: (otherlv_8= '7' ( () otherlv_10= 'action' )? ( (lv_mixed_11_0= ruleMixed ) ) )
                    {
                    // InternalRegionAccessTestLanguage.g:149:6: (otherlv_8= '7' ( () otherlv_10= 'action' )? ( (lv_mixed_11_0= ruleMixed ) ) )
                    // InternalRegionAccessTestLanguage.g:149:8: otherlv_8= '7' ( () otherlv_10= 'action' )? ( (lv_mixed_11_0= ruleMixed ) )
                    {
                    otherlv_8=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                        	newLeafNode(otherlv_8, grammarAccess.getRootAccess().getDigitSevenKeyword_6_0());
                        
                    // InternalRegionAccessTestLanguage.g:153:1: ( () otherlv_10= 'action' )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==14) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // InternalRegionAccessTestLanguage.g:153:2: () otherlv_10= 'action'
                            {
                            // InternalRegionAccessTestLanguage.g:153:2: ()
                            // InternalRegionAccessTestLanguage.g:154:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getRootAccess().getRootActionAction_6_1_0(),
                                        current);
                                

                            }

                            otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_4); 

                                	newLeafNode(otherlv_10, grammarAccess.getRootAccess().getActionKeyword_6_1_1());
                                

                            }
                            break;

                    }

                    // InternalRegionAccessTestLanguage.g:163:3: ( (lv_mixed_11_0= ruleMixed ) )
                    // InternalRegionAccessTestLanguage.g:164:1: (lv_mixed_11_0= ruleMixed )
                    {
                    // InternalRegionAccessTestLanguage.g:164:1: (lv_mixed_11_0= ruleMixed )
                    // InternalRegionAccessTestLanguage.g:165:3: lv_mixed_11_0= ruleMixed
                    {
                     
                    	        newCompositeNode(grammarAccess.getRootAccess().getMixedMixedParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_mixed_11_0=ruleMixed();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRootRule());
                    	        }
                           		set(
                           			current, 
                           			"mixed",
                            		lv_mixed_11_0, 
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
    // InternalRegionAccessTestLanguage.g:189:1: entryRuleSimple returns [EObject current=null] : iv_ruleSimple= ruleSimple EOF ;
    public final EObject entryRuleSimple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimple = null;


        try {
            // InternalRegionAccessTestLanguage.g:190:2: (iv_ruleSimple= ruleSimple EOF )
            // InternalRegionAccessTestLanguage.g:191:2: iv_ruleSimple= ruleSimple EOF
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
    // InternalRegionAccessTestLanguage.g:198:1: ruleSimple returns [EObject current=null] : (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleSimple() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalRegionAccessTestLanguage.g:201:28: ( (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalRegionAccessTestLanguage.g:202:1: (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalRegionAccessTestLanguage.g:202:1: (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalRegionAccessTestLanguage.g:202:3: otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleAccess().getDigitOneKeyword_0());
                
            // InternalRegionAccessTestLanguage.g:206:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalRegionAccessTestLanguage.g:207:1: (lv_name_1_0= RULE_ID )
            {
            // InternalRegionAccessTestLanguage.g:207:1: (lv_name_1_0= RULE_ID )
            // InternalRegionAccessTestLanguage.g:208:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
    // InternalRegionAccessTestLanguage.g:232:1: entryRuleDelegation returns [EObject current=null] : iv_ruleDelegation= ruleDelegation EOF ;
    public final EObject entryRuleDelegation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDelegation = null;


        try {
            // InternalRegionAccessTestLanguage.g:233:2: (iv_ruleDelegation= ruleDelegation EOF )
            // InternalRegionAccessTestLanguage.g:234:2: iv_ruleDelegation= ruleDelegation EOF
            {
             newCompositeNode(grammarAccess.getDelegationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDelegation=ruleDelegation();

            state._fsp--;

             current =iv_ruleDelegation; 
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
    // $ANTLR end "entryRuleDelegation"


    // $ANTLR start "ruleDelegation"
    // InternalRegionAccessTestLanguage.g:241:1: ruleDelegation returns [EObject current=null] : (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) ) ;
    public final EObject ruleDelegation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_delegate_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRegionAccessTestLanguage.g:244:28: ( (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) ) )
            // InternalRegionAccessTestLanguage.g:245:1: (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) )
            {
            // InternalRegionAccessTestLanguage.g:245:1: (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) )
            // InternalRegionAccessTestLanguage.g:245:3: otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) )
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getDelegationAccess().getDigitTwoKeyword_0());
                
            // InternalRegionAccessTestLanguage.g:249:1: ( (lv_delegate_1_0= ruleDelegate ) )
            // InternalRegionAccessTestLanguage.g:250:1: (lv_delegate_1_0= ruleDelegate )
            {
            // InternalRegionAccessTestLanguage.g:250:1: (lv_delegate_1_0= ruleDelegate )
            // InternalRegionAccessTestLanguage.g:251:3: lv_delegate_1_0= ruleDelegate
            {
             
            	        newCompositeNode(grammarAccess.getDelegationAccess().getDelegateDelegateParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRegionAccessTestLanguage.g:275:1: entryRuleUnassigned returns [EObject current=null] : iv_ruleUnassigned= ruleUnassigned EOF ;
    public final EObject entryRuleUnassigned() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnassigned = null;


        try {
            // InternalRegionAccessTestLanguage.g:276:2: (iv_ruleUnassigned= ruleUnassigned EOF )
            // InternalRegionAccessTestLanguage.g:277:2: iv_ruleUnassigned= ruleUnassigned EOF
            {
             newCompositeNode(grammarAccess.getUnassignedRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnassigned=ruleUnassigned();

            state._fsp--;

             current =iv_ruleUnassigned; 
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
    // $ANTLR end "entryRuleUnassigned"


    // $ANTLR start "ruleUnassigned"
    // InternalRegionAccessTestLanguage.g:284:1: ruleUnassigned returns [EObject current=null] : (otherlv_0= '3' this_Delegate_1= ruleDelegate ) ;
    public final EObject ruleUnassigned() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Delegate_1 = null;


         enterRule(); 
            
        try {
            // InternalRegionAccessTestLanguage.g:287:28: ( (otherlv_0= '3' this_Delegate_1= ruleDelegate ) )
            // InternalRegionAccessTestLanguage.g:288:1: (otherlv_0= '3' this_Delegate_1= ruleDelegate )
            {
            // InternalRegionAccessTestLanguage.g:288:1: (otherlv_0= '3' this_Delegate_1= ruleDelegate )
            // InternalRegionAccessTestLanguage.g:288:3: otherlv_0= '3' this_Delegate_1= ruleDelegate
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getUnassignedAccess().getDigitThreeKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getUnassignedAccess().getDelegateParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRegionAccessTestLanguage.g:309:1: entryRulePrefixedUnassigned returns [EObject current=null] : iv_rulePrefixedUnassigned= rulePrefixedUnassigned EOF ;
    public final EObject entryRulePrefixedUnassigned() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedUnassigned = null;


        try {
            // InternalRegionAccessTestLanguage.g:310:2: (iv_rulePrefixedUnassigned= rulePrefixedUnassigned EOF )
            // InternalRegionAccessTestLanguage.g:311:2: iv_rulePrefixedUnassigned= rulePrefixedUnassigned EOF
            {
             newCompositeNode(grammarAccess.getPrefixedUnassignedRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrefixedUnassigned=rulePrefixedUnassigned();

            state._fsp--;

             current =iv_rulePrefixedUnassigned; 
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
    // $ANTLR end "entryRulePrefixedUnassigned"


    // $ANTLR start "rulePrefixedUnassigned"
    // InternalRegionAccessTestLanguage.g:318:1: rulePrefixedUnassigned returns [EObject current=null] : (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) ) ;
    public final EObject rulePrefixedUnassigned() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_delegate_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRegionAccessTestLanguage.g:321:28: ( (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) ) )
            // InternalRegionAccessTestLanguage.g:322:1: (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) )
            {
            // InternalRegionAccessTestLanguage.g:322:1: (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) )
            // InternalRegionAccessTestLanguage.g:322:3: otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) )
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_7); 

                	newLeafNode(otherlv_0, grammarAccess.getPrefixedUnassignedAccess().getDigitFourKeyword_0());
                
            // InternalRegionAccessTestLanguage.g:326:1: ( (lv_delegate_1_0= rulePrefixedDelegate ) )
            // InternalRegionAccessTestLanguage.g:327:1: (lv_delegate_1_0= rulePrefixedDelegate )
            {
            // InternalRegionAccessTestLanguage.g:327:1: (lv_delegate_1_0= rulePrefixedDelegate )
            // InternalRegionAccessTestLanguage.g:328:3: lv_delegate_1_0= rulePrefixedDelegate
            {
             
            	        newCompositeNode(grammarAccess.getPrefixedUnassignedAccess().getDelegatePrefixedDelegateParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRegionAccessTestLanguage.g:352:1: entryRulePrefixedDelegate returns [EObject current=null] : iv_rulePrefixedDelegate= rulePrefixedDelegate EOF ;
    public final EObject entryRulePrefixedDelegate() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedDelegate = null;


        try {
            // InternalRegionAccessTestLanguage.g:353:2: (iv_rulePrefixedDelegate= rulePrefixedDelegate EOF )
            // InternalRegionAccessTestLanguage.g:354:2: iv_rulePrefixedDelegate= rulePrefixedDelegate EOF
            {
             newCompositeNode(grammarAccess.getPrefixedDelegateRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrefixedDelegate=rulePrefixedDelegate();

            state._fsp--;

             current =iv_rulePrefixedDelegate; 
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
    // $ANTLR end "entryRulePrefixedDelegate"


    // $ANTLR start "rulePrefixedDelegate"
    // InternalRegionAccessTestLanguage.g:361:1: rulePrefixedDelegate returns [EObject current=null] : (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate ) ;
    public final EObject rulePrefixedDelegate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Delegate_1 = null;


         enterRule(); 
            
        try {
            // InternalRegionAccessTestLanguage.g:364:28: ( (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate ) )
            // InternalRegionAccessTestLanguage.g:365:1: (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate )
            {
            // InternalRegionAccessTestLanguage.g:365:1: (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate )
            // InternalRegionAccessTestLanguage.g:365:3: otherlv_0= 'prefix' this_Delegate_1= ruleDelegate
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getPrefixedDelegateAccess().getPrefixKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getPrefixedDelegateAccess().getDelegateParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRegionAccessTestLanguage.g:386:1: entryRuleDelegate returns [EObject current=null] : iv_ruleDelegate= ruleDelegate EOF ;
    public final EObject entryRuleDelegate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDelegate = null;


        try {
            // InternalRegionAccessTestLanguage.g:387:2: (iv_ruleDelegate= ruleDelegate EOF )
            // InternalRegionAccessTestLanguage.g:388:2: iv_ruleDelegate= ruleDelegate EOF
            {
             newCompositeNode(grammarAccess.getDelegateRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDelegate=ruleDelegate();

            state._fsp--;

             current =iv_ruleDelegate; 
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
    // $ANTLR end "entryRuleDelegate"


    // $ANTLR start "ruleDelegate"
    // InternalRegionAccessTestLanguage.g:395:1: ruleDelegate returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleDelegate() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // InternalRegionAccessTestLanguage.g:398:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalRegionAccessTestLanguage.g:399:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalRegionAccessTestLanguage.g:399:1: ( (lv_name_0_0= RULE_ID ) )
            // InternalRegionAccessTestLanguage.g:400:1: (lv_name_0_0= RULE_ID )
            {
            // InternalRegionAccessTestLanguage.g:400:1: (lv_name_0_0= RULE_ID )
            // InternalRegionAccessTestLanguage.g:401:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
    // InternalRegionAccessTestLanguage.g:425:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalRegionAccessTestLanguage.g:426:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalRegionAccessTestLanguage.g:427:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalRegionAccessTestLanguage.g:434:1: ruleExpression returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRegionAccessTestLanguage.g:437:28: ( (this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // InternalRegionAccessTestLanguage.g:438:1: (this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // InternalRegionAccessTestLanguage.g:438:1: (this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* )
            // InternalRegionAccessTestLanguage.g:439:5: this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getExpressionAccess().getPrimaryParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_8);
            this_Primary_0=rulePrimary();

            state._fsp--;

             
                    current = this_Primary_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalRegionAccessTestLanguage.g:447:1: ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==20) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalRegionAccessTestLanguage.g:447:2: () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // InternalRegionAccessTestLanguage.g:447:2: ()
            	    // InternalRegionAccessTestLanguage.g:448:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getExpressionAccess().getAddLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_3); 

            	        	newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getPlusSignKeyword_1_1());
            	        
            	    // InternalRegionAccessTestLanguage.g:457:1: ( (lv_right_3_0= rulePrimary ) )
            	    // InternalRegionAccessTestLanguage.g:458:1: (lv_right_3_0= rulePrimary )
            	    {
            	    // InternalRegionAccessTestLanguage.g:458:1: (lv_right_3_0= rulePrimary )
            	    // InternalRegionAccessTestLanguage.g:459:3: lv_right_3_0= rulePrimary
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExpressionAccess().getRightPrimaryParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_8);
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
            	    break loop3;
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
    // InternalRegionAccessTestLanguage.g:483:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalRegionAccessTestLanguage.g:484:2: (iv_rulePrimary= rulePrimary EOF )
            // InternalRegionAccessTestLanguage.g:485:2: iv_rulePrimary= rulePrimary EOF
            {
             newCompositeNode(grammarAccess.getPrimaryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrimary=rulePrimary();

            state._fsp--;

             current =iv_rulePrimary; 
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
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // InternalRegionAccessTestLanguage.g:492:1: rulePrimary returns [EObject current=null] : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | this_Parenthesized_2= ruleParenthesized ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject this_Parenthesized_2 = null;


         enterRule(); 
            
        try {
            // InternalRegionAccessTestLanguage.g:495:28: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | this_Parenthesized_2= ruleParenthesized ) )
            // InternalRegionAccessTestLanguage.g:496:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | this_Parenthesized_2= ruleParenthesized )
            {
            // InternalRegionAccessTestLanguage.g:496:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | this_Parenthesized_2= ruleParenthesized )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==21) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalRegionAccessTestLanguage.g:496:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // InternalRegionAccessTestLanguage.g:496:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // InternalRegionAccessTestLanguage.g:496:3: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // InternalRegionAccessTestLanguage.g:496:3: ()
                    // InternalRegionAccessTestLanguage.g:497:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrimaryAccess().getNamedAction_0_0(),
                                current);
                        

                    }

                    // InternalRegionAccessTestLanguage.g:502:2: ( (lv_name_1_0= RULE_ID ) )
                    // InternalRegionAccessTestLanguage.g:503:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRegionAccessTestLanguage.g:503:1: (lv_name_1_0= RULE_ID )
                    // InternalRegionAccessTestLanguage.g:504:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
                    // InternalRegionAccessTestLanguage.g:522:5: this_Parenthesized_2= ruleParenthesized
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryAccess().getParenthesizedParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalRegionAccessTestLanguage.g:538:1: entryRuleParenthesized returns [EObject current=null] : iv_ruleParenthesized= ruleParenthesized EOF ;
    public final EObject entryRuleParenthesized() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesized = null;


        try {
            // InternalRegionAccessTestLanguage.g:539:2: (iv_ruleParenthesized= ruleParenthesized EOF )
            // InternalRegionAccessTestLanguage.g:540:2: iv_ruleParenthesized= ruleParenthesized EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParenthesized=ruleParenthesized();

            state._fsp--;

             current =iv_ruleParenthesized; 
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
    // $ANTLR end "entryRuleParenthesized"


    // $ANTLR start "ruleParenthesized"
    // InternalRegionAccessTestLanguage.g:547:1: ruleParenthesized returns [EObject current=null] : (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) ;
    public final EObject ruleParenthesized() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Expression_1 = null;


         enterRule(); 
            
        try {
            // InternalRegionAccessTestLanguage.g:550:28: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) )
            // InternalRegionAccessTestLanguage.g:551:1: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            {
            // InternalRegionAccessTestLanguage.g:551:1: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            // InternalRegionAccessTestLanguage.g:551:3: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getParenthesizedAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getParenthesizedAccess().getExpressionParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_9);
            this_Expression_1=ruleExpression();

            state._fsp--;

             
                    current = this_Expression_1; 
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,22,FollowSets000.FOLLOW_2); 

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
    // InternalRegionAccessTestLanguage.g:576:1: entryRuleMixed returns [EObject current=null] : iv_ruleMixed= ruleMixed EOF ;
    public final EObject entryRuleMixed() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMixed = null;


        try {
            // InternalRegionAccessTestLanguage.g:577:2: (iv_ruleMixed= ruleMixed EOF )
            // InternalRegionAccessTestLanguage.g:578:2: iv_ruleMixed= ruleMixed EOF
            {
             newCompositeNode(grammarAccess.getMixedRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMixed=ruleMixed();

            state._fsp--;

             current =iv_ruleMixed; 
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
    // $ANTLR end "entryRuleMixed"


    // $ANTLR start "ruleMixed"
    // InternalRegionAccessTestLanguage.g:585:1: ruleMixed returns [EObject current=null] : (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( ( () (otherlv_5= 'fragment' this_Fragment_6= ruleFragment[$current] )? ) | this_Mixed_7= ruleMixed | ( ( (lv_name_8_0= RULE_ID ) ) | (otherlv_9= 'child' ( (lv_eobj_10_0= ruleMixed ) ) ) | ( (lv_datatype_11_0= ruleDatatype ) ) | (otherlv_12= 'ref' ( (otherlv_13= RULE_ID ) ) ) | ( (lv_lit_14_0= ruleEnum ) ) ) ) otherlv_15= ')' ( () otherlv_17= 'action' ( ( (lv_body_18_0= ruleMixed ) ) otherlv_19= 'end' )? )* ) ;
    public final EObject ruleMixed() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_ID_2=null;
        Token otherlv_5=null;
        Token lv_name_8_0=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        EObject this_Fragment_6 = null;

        EObject this_Mixed_7 = null;

        EObject lv_eobj_10_0 = null;

        AntlrDatatypeRuleToken lv_datatype_11_0 = null;

        Enumerator lv_lit_14_0 = null;

        EObject lv_body_18_0 = null;


         enterRule(); 
            
        try {
            // InternalRegionAccessTestLanguage.g:588:28: ( (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( ( () (otherlv_5= 'fragment' this_Fragment_6= ruleFragment[$current] )? ) | this_Mixed_7= ruleMixed | ( ( (lv_name_8_0= RULE_ID ) ) | (otherlv_9= 'child' ( (lv_eobj_10_0= ruleMixed ) ) ) | ( (lv_datatype_11_0= ruleDatatype ) ) | (otherlv_12= 'ref' ( (otherlv_13= RULE_ID ) ) ) | ( (lv_lit_14_0= ruleEnum ) ) ) ) otherlv_15= ')' ( () otherlv_17= 'action' ( ( (lv_body_18_0= ruleMixed ) ) otherlv_19= 'end' )? )* ) )
            // InternalRegionAccessTestLanguage.g:589:1: (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( ( () (otherlv_5= 'fragment' this_Fragment_6= ruleFragment[$current] )? ) | this_Mixed_7= ruleMixed | ( ( (lv_name_8_0= RULE_ID ) ) | (otherlv_9= 'child' ( (lv_eobj_10_0= ruleMixed ) ) ) | ( (lv_datatype_11_0= ruleDatatype ) ) | (otherlv_12= 'ref' ( (otherlv_13= RULE_ID ) ) ) | ( (lv_lit_14_0= ruleEnum ) ) ) ) otherlv_15= ')' ( () otherlv_17= 'action' ( ( (lv_body_18_0= ruleMixed ) ) otherlv_19= 'end' )? )* )
            {
            // InternalRegionAccessTestLanguage.g:589:1: (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( ( () (otherlv_5= 'fragment' this_Fragment_6= ruleFragment[$current] )? ) | this_Mixed_7= ruleMixed | ( ( (lv_name_8_0= RULE_ID ) ) | (otherlv_9= 'child' ( (lv_eobj_10_0= ruleMixed ) ) ) | ( (lv_datatype_11_0= ruleDatatype ) ) | (otherlv_12= 'ref' ( (otherlv_13= RULE_ID ) ) ) | ( (lv_lit_14_0= ruleEnum ) ) ) ) otherlv_15= ')' ( () otherlv_17= 'action' ( ( (lv_body_18_0= ruleMixed ) ) otherlv_19= 'end' )? )* )
            // InternalRegionAccessTestLanguage.g:589:3: otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( ( () (otherlv_5= 'fragment' this_Fragment_6= ruleFragment[$current] )? ) | this_Mixed_7= ruleMixed | ( ( (lv_name_8_0= RULE_ID ) ) | (otherlv_9= 'child' ( (lv_eobj_10_0= ruleMixed ) ) ) | ( (lv_datatype_11_0= ruleDatatype ) ) | (otherlv_12= 'ref' ( (otherlv_13= RULE_ID ) ) ) | ( (lv_lit_14_0= ruleEnum ) ) ) ) otherlv_15= ')' ( () otherlv_17= 'action' ( ( (lv_body_18_0= ruleMixed ) ) otherlv_19= 'end' )? )*
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_0, grammarAccess.getMixedAccess().getLeftParenthesisKeyword_0());
                
            // InternalRegionAccessTestLanguage.g:593:1: (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==23) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalRegionAccessTestLanguage.g:593:3: otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype )
                    {
                    otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_11); 

                        	newLeafNode(otherlv_1, grammarAccess.getMixedAccess().getUnassignedKeyword_1_0());
                        
                    // InternalRegionAccessTestLanguage.g:597:1: (this_ID_2= RULE_ID | ruleDatatype )
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==RULE_ID) ) {
                        alt5=1;
                    }
                    else if ( (LA5_0==28) ) {
                        alt5=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 0, input);

                        throw nvae;
                    }
                    switch (alt5) {
                        case 1 :
                            // InternalRegionAccessTestLanguage.g:597:2: this_ID_2= RULE_ID
                            {
                            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 
                             
                                newLeafNode(this_ID_2, grammarAccess.getMixedAccess().getIDTerminalRuleCall_1_1_0()); 
                                

                            }
                            break;
                        case 2 :
                            // InternalRegionAccessTestLanguage.g:603:5: ruleDatatype
                            {
                             
                                    newCompositeNode(grammarAccess.getMixedAccess().getDatatypeParserRuleCall_1_1_1()); 
                                
                            pushFollow(FollowSets000.FOLLOW_10);
                            ruleDatatype();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalRegionAccessTestLanguage.g:610:4: ( ( () (otherlv_5= 'fragment' this_Fragment_6= ruleFragment[$current] )? ) | this_Mixed_7= ruleMixed | ( ( (lv_name_8_0= RULE_ID ) ) | (otherlv_9= 'child' ( (lv_eobj_10_0= ruleMixed ) ) ) | ( (lv_datatype_11_0= ruleDatatype ) ) | (otherlv_12= 'ref' ( (otherlv_13= RULE_ID ) ) ) | ( (lv_lit_14_0= ruleEnum ) ) ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 22:
            case 24:
                {
                alt9=1;
                }
                break;
            case 21:
                {
                alt9=2;
                }
                break;
            case RULE_ID:
            case 25:
            case 26:
            case 28:
            case 30:
            case 31:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalRegionAccessTestLanguage.g:610:5: ( () (otherlv_5= 'fragment' this_Fragment_6= ruleFragment[$current] )? )
                    {
                    // InternalRegionAccessTestLanguage.g:610:5: ( () (otherlv_5= 'fragment' this_Fragment_6= ruleFragment[$current] )? )
                    // InternalRegionAccessTestLanguage.g:610:6: () (otherlv_5= 'fragment' this_Fragment_6= ruleFragment[$current] )?
                    {
                    // InternalRegionAccessTestLanguage.g:610:6: ()
                    // InternalRegionAccessTestLanguage.g:611:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getMixedAccess().getActionAction_2_0_0(),
                                current);
                        

                    }

                    // InternalRegionAccessTestLanguage.g:616:2: (otherlv_5= 'fragment' this_Fragment_6= ruleFragment[$current] )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==24) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // InternalRegionAccessTestLanguage.g:616:4: otherlv_5= 'fragment' this_Fragment_6= ruleFragment[$current]
                            {
                            otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_12); 

                                	newLeafNode(otherlv_5, grammarAccess.getMixedAccess().getFragmentKeyword_2_0_1_0());
                                
                             
                            		if (current==null) {
                            			current = createModelElement(grammarAccess.getMixedRule());
                            		}
                                    newCompositeNode(grammarAccess.getMixedAccess().getFragmentParserRuleCall_2_0_1_1()); 
                                
                            pushFollow(FollowSets000.FOLLOW_9);
                            this_Fragment_6=ruleFragment(current);

                            state._fsp--;

                             
                                    current = this_Fragment_6; 
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRegionAccessTestLanguage.g:634:5: this_Mixed_7= ruleMixed
                    {
                     
                            newCompositeNode(grammarAccess.getMixedAccess().getMixedParserRuleCall_2_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_9);
                    this_Mixed_7=ruleMixed();

                    state._fsp--;

                     
                            current = this_Mixed_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalRegionAccessTestLanguage.g:643:6: ( ( (lv_name_8_0= RULE_ID ) ) | (otherlv_9= 'child' ( (lv_eobj_10_0= ruleMixed ) ) ) | ( (lv_datatype_11_0= ruleDatatype ) ) | (otherlv_12= 'ref' ( (otherlv_13= RULE_ID ) ) ) | ( (lv_lit_14_0= ruleEnum ) ) )
                    {
                    // InternalRegionAccessTestLanguage.g:643:6: ( ( (lv_name_8_0= RULE_ID ) ) | (otherlv_9= 'child' ( (lv_eobj_10_0= ruleMixed ) ) ) | ( (lv_datatype_11_0= ruleDatatype ) ) | (otherlv_12= 'ref' ( (otherlv_13= RULE_ID ) ) ) | ( (lv_lit_14_0= ruleEnum ) ) )
                    int alt8=5;
                    switch ( input.LA(1) ) {
                    case RULE_ID:
                        {
                        alt8=1;
                        }
                        break;
                    case 25:
                        {
                        alt8=2;
                        }
                        break;
                    case 28:
                        {
                        alt8=3;
                        }
                        break;
                    case 26:
                        {
                        alt8=4;
                        }
                        break;
                    case 30:
                    case 31:
                        {
                        alt8=5;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;
                    }

                    switch (alt8) {
                        case 1 :
                            // InternalRegionAccessTestLanguage.g:643:7: ( (lv_name_8_0= RULE_ID ) )
                            {
                            // InternalRegionAccessTestLanguage.g:643:7: ( (lv_name_8_0= RULE_ID ) )
                            // InternalRegionAccessTestLanguage.g:644:1: (lv_name_8_0= RULE_ID )
                            {
                            // InternalRegionAccessTestLanguage.g:644:1: (lv_name_8_0= RULE_ID )
                            // InternalRegionAccessTestLanguage.g:645:3: lv_name_8_0= RULE_ID
                            {
                            lv_name_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                            			newLeafNode(lv_name_8_0, grammarAccess.getMixedAccess().getNameIDTerminalRuleCall_2_2_0_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getMixedRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"name",
                                    		lv_name_8_0, 
                                    		"org.eclipse.xtext.common.Terminals.ID");
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalRegionAccessTestLanguage.g:662:6: (otherlv_9= 'child' ( (lv_eobj_10_0= ruleMixed ) ) )
                            {
                            // InternalRegionAccessTestLanguage.g:662:6: (otherlv_9= 'child' ( (lv_eobj_10_0= ruleMixed ) ) )
                            // InternalRegionAccessTestLanguage.g:662:8: otherlv_9= 'child' ( (lv_eobj_10_0= ruleMixed ) )
                            {
                            otherlv_9=(Token)match(input,25,FollowSets000.FOLLOW_4); 

                                	newLeafNode(otherlv_9, grammarAccess.getMixedAccess().getChildKeyword_2_2_1_0());
                                
                            // InternalRegionAccessTestLanguage.g:666:1: ( (lv_eobj_10_0= ruleMixed ) )
                            // InternalRegionAccessTestLanguage.g:667:1: (lv_eobj_10_0= ruleMixed )
                            {
                            // InternalRegionAccessTestLanguage.g:667:1: (lv_eobj_10_0= ruleMixed )
                            // InternalRegionAccessTestLanguage.g:668:3: lv_eobj_10_0= ruleMixed
                            {
                             
                            	        newCompositeNode(grammarAccess.getMixedAccess().getEobjMixedParserRuleCall_2_2_1_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_9);
                            lv_eobj_10_0=ruleMixed();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getMixedRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"eobj",
                                    		lv_eobj_10_0, 
                                    		"org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguage.Mixed");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }


                            }
                            break;
                        case 3 :
                            // InternalRegionAccessTestLanguage.g:685:6: ( (lv_datatype_11_0= ruleDatatype ) )
                            {
                            // InternalRegionAccessTestLanguage.g:685:6: ( (lv_datatype_11_0= ruleDatatype ) )
                            // InternalRegionAccessTestLanguage.g:686:1: (lv_datatype_11_0= ruleDatatype )
                            {
                            // InternalRegionAccessTestLanguage.g:686:1: (lv_datatype_11_0= ruleDatatype )
                            // InternalRegionAccessTestLanguage.g:687:3: lv_datatype_11_0= ruleDatatype
                            {
                             
                            	        newCompositeNode(grammarAccess.getMixedAccess().getDatatypeDatatypeParserRuleCall_2_2_2_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_9);
                            lv_datatype_11_0=ruleDatatype();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getMixedRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"datatype",
                                    		lv_datatype_11_0, 
                                    		"org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguage.Datatype");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 4 :
                            // InternalRegionAccessTestLanguage.g:704:6: (otherlv_12= 'ref' ( (otherlv_13= RULE_ID ) ) )
                            {
                            // InternalRegionAccessTestLanguage.g:704:6: (otherlv_12= 'ref' ( (otherlv_13= RULE_ID ) ) )
                            // InternalRegionAccessTestLanguage.g:704:8: otherlv_12= 'ref' ( (otherlv_13= RULE_ID ) )
                            {
                            otherlv_12=(Token)match(input,26,FollowSets000.FOLLOW_6); 

                                	newLeafNode(otherlv_12, grammarAccess.getMixedAccess().getRefKeyword_2_2_3_0());
                                
                            // InternalRegionAccessTestLanguage.g:708:1: ( (otherlv_13= RULE_ID ) )
                            // InternalRegionAccessTestLanguage.g:709:1: (otherlv_13= RULE_ID )
                            {
                            // InternalRegionAccessTestLanguage.g:709:1: (otherlv_13= RULE_ID )
                            // InternalRegionAccessTestLanguage.g:710:3: otherlv_13= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getMixedRule());
                            	        }
                                    
                            otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                            		newLeafNode(otherlv_13, grammarAccess.getMixedAccess().getRefMixedCrossReference_2_2_3_1_0()); 
                            	

                            }


                            }


                            }


                            }
                            break;
                        case 5 :
                            // InternalRegionAccessTestLanguage.g:722:6: ( (lv_lit_14_0= ruleEnum ) )
                            {
                            // InternalRegionAccessTestLanguage.g:722:6: ( (lv_lit_14_0= ruleEnum ) )
                            // InternalRegionAccessTestLanguage.g:723:1: (lv_lit_14_0= ruleEnum )
                            {
                            // InternalRegionAccessTestLanguage.g:723:1: (lv_lit_14_0= ruleEnum )
                            // InternalRegionAccessTestLanguage.g:724:3: lv_lit_14_0= ruleEnum
                            {
                             
                            	        newCompositeNode(grammarAccess.getMixedAccess().getLitEnumEnumRuleCall_2_2_4_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_9);
                            lv_lit_14_0=ruleEnum();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getMixedRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"lit",
                                    		lv_lit_14_0, 
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

            otherlv_15=(Token)match(input,22,FollowSets000.FOLLOW_13); 

                	newLeafNode(otherlv_15, grammarAccess.getMixedAccess().getRightParenthesisKeyword_3());
                
            // InternalRegionAccessTestLanguage.g:744:1: ( () otherlv_17= 'action' ( ( (lv_body_18_0= ruleMixed ) ) otherlv_19= 'end' )? )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==14) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalRegionAccessTestLanguage.g:744:2: () otherlv_17= 'action' ( ( (lv_body_18_0= ruleMixed ) ) otherlv_19= 'end' )?
            	    {
            	    // InternalRegionAccessTestLanguage.g:744:2: ()
            	    // InternalRegionAccessTestLanguage.g:745:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getMixedAccess().getAssignedActionChildAction_4_0(),
            	                current);
            	        

            	    }

            	    otherlv_17=(Token)match(input,14,FollowSets000.FOLLOW_14); 

            	        	newLeafNode(otherlv_17, grammarAccess.getMixedAccess().getActionKeyword_4_1());
            	        
            	    // InternalRegionAccessTestLanguage.g:754:1: ( ( (lv_body_18_0= ruleMixed ) ) otherlv_19= 'end' )?
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( (LA10_0==21) ) {
            	        alt10=1;
            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // InternalRegionAccessTestLanguage.g:754:2: ( (lv_body_18_0= ruleMixed ) ) otherlv_19= 'end'
            	            {
            	            // InternalRegionAccessTestLanguage.g:754:2: ( (lv_body_18_0= ruleMixed ) )
            	            // InternalRegionAccessTestLanguage.g:755:1: (lv_body_18_0= ruleMixed )
            	            {
            	            // InternalRegionAccessTestLanguage.g:755:1: (lv_body_18_0= ruleMixed )
            	            // InternalRegionAccessTestLanguage.g:756:3: lv_body_18_0= ruleMixed
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getMixedAccess().getBodyMixedParserRuleCall_4_2_0_0()); 
            	            	    
            	            pushFollow(FollowSets000.FOLLOW_15);
            	            lv_body_18_0=ruleMixed();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getMixedRule());
            	            	        }
            	                   		set(
            	                   			current, 
            	                   			"body",
            	                    		lv_body_18_0, 
            	                    		"org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguage.Mixed");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }


            	            }

            	            otherlv_19=(Token)match(input,27,FollowSets000.FOLLOW_13); 

            	                	newLeafNode(otherlv_19, grammarAccess.getMixedAccess().getEndKeyword_4_2_1());
            	                

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // InternalRegionAccessTestLanguage.g:784:1: entryRuleDatatype returns [String current=null] : iv_ruleDatatype= ruleDatatype EOF ;
    public final String entryRuleDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatype = null;


        try {
            // InternalRegionAccessTestLanguage.g:785:2: (iv_ruleDatatype= ruleDatatype EOF )
            // InternalRegionAccessTestLanguage.g:786:2: iv_ruleDatatype= ruleDatatype EOF
            {
             newCompositeNode(grammarAccess.getDatatypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDatatype=ruleDatatype();

            state._fsp--;

             current =iv_ruleDatatype.getText(); 
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
    // $ANTLR end "entryRuleDatatype"


    // $ANTLR start "ruleDatatype"
    // InternalRegionAccessTestLanguage.g:793:1: ruleDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'datatype' (this_Datatype_1= ruleDatatype | this_ID_2= RULE_ID ) ) ;
    public final AntlrDatatypeRuleToken ruleDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_2=null;
        AntlrDatatypeRuleToken this_Datatype_1 = null;


         enterRule(); 
            
        try {
            // InternalRegionAccessTestLanguage.g:796:28: ( (kw= 'datatype' (this_Datatype_1= ruleDatatype | this_ID_2= RULE_ID ) ) )
            // InternalRegionAccessTestLanguage.g:797:1: (kw= 'datatype' (this_Datatype_1= ruleDatatype | this_ID_2= RULE_ID ) )
            {
            // InternalRegionAccessTestLanguage.g:797:1: (kw= 'datatype' (this_Datatype_1= ruleDatatype | this_ID_2= RULE_ID ) )
            // InternalRegionAccessTestLanguage.g:798:2: kw= 'datatype' (this_Datatype_1= ruleDatatype | this_ID_2= RULE_ID )
            {
            kw=(Token)match(input,28,FollowSets000.FOLLOW_11); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDatatypeAccess().getDatatypeKeyword_0()); 
                
            // InternalRegionAccessTestLanguage.g:803:1: (this_Datatype_1= ruleDatatype | this_ID_2= RULE_ID )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==28) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ID) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalRegionAccessTestLanguage.g:804:5: this_Datatype_1= ruleDatatype
                    {
                     
                            newCompositeNode(grammarAccess.getDatatypeAccess().getDatatypeParserRuleCall_1_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Datatype_1=ruleDatatype();

                    state._fsp--;


                    		current.merge(this_Datatype_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalRegionAccessTestLanguage.g:815:10: this_ID_2= RULE_ID
                    {
                    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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


    // $ANTLR start "ruleFragment"
    // InternalRegionAccessTestLanguage.g:831:1: ruleFragment[EObject in_current] returns [EObject current=in_current] : ( ( (lv_fragName_0_0= RULE_ID ) ) | (otherlv_1= 'child' ( (lv_mixed_2_0= ruleMixed ) ) ) | (otherlv_3= 'recursion' this_Fragment_4= ruleFragment[$current] ) ) ;
    public final EObject ruleFragment(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_fragName_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_mixed_2_0 = null;

        EObject this_Fragment_4 = null;


         enterRule(); 
            
        try {
            // InternalRegionAccessTestLanguage.g:834:28: ( ( ( (lv_fragName_0_0= RULE_ID ) ) | (otherlv_1= 'child' ( (lv_mixed_2_0= ruleMixed ) ) ) | (otherlv_3= 'recursion' this_Fragment_4= ruleFragment[$current] ) ) )
            // InternalRegionAccessTestLanguage.g:835:1: ( ( (lv_fragName_0_0= RULE_ID ) ) | (otherlv_1= 'child' ( (lv_mixed_2_0= ruleMixed ) ) ) | (otherlv_3= 'recursion' this_Fragment_4= ruleFragment[$current] ) )
            {
            // InternalRegionAccessTestLanguage.g:835:1: ( ( (lv_fragName_0_0= RULE_ID ) ) | (otherlv_1= 'child' ( (lv_mixed_2_0= ruleMixed ) ) ) | (otherlv_3= 'recursion' this_Fragment_4= ruleFragment[$current] ) )
            int alt13=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt13=1;
                }
                break;
            case 25:
                {
                alt13=2;
                }
                break;
            case 29:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalRegionAccessTestLanguage.g:835:2: ( (lv_fragName_0_0= RULE_ID ) )
                    {
                    // InternalRegionAccessTestLanguage.g:835:2: ( (lv_fragName_0_0= RULE_ID ) )
                    // InternalRegionAccessTestLanguage.g:836:1: (lv_fragName_0_0= RULE_ID )
                    {
                    // InternalRegionAccessTestLanguage.g:836:1: (lv_fragName_0_0= RULE_ID )
                    // InternalRegionAccessTestLanguage.g:837:3: lv_fragName_0_0= RULE_ID
                    {
                    lv_fragName_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_fragName_0_0, grammarAccess.getFragmentAccess().getFragNameIDTerminalRuleCall_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFragmentRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"fragName",
                            		lv_fragName_0_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRegionAccessTestLanguage.g:854:6: (otherlv_1= 'child' ( (lv_mixed_2_0= ruleMixed ) ) )
                    {
                    // InternalRegionAccessTestLanguage.g:854:6: (otherlv_1= 'child' ( (lv_mixed_2_0= ruleMixed ) ) )
                    // InternalRegionAccessTestLanguage.g:854:8: otherlv_1= 'child' ( (lv_mixed_2_0= ruleMixed ) )
                    {
                    otherlv_1=(Token)match(input,25,FollowSets000.FOLLOW_4); 

                        	newLeafNode(otherlv_1, grammarAccess.getFragmentAccess().getChildKeyword_1_0());
                        
                    // InternalRegionAccessTestLanguage.g:858:1: ( (lv_mixed_2_0= ruleMixed ) )
                    // InternalRegionAccessTestLanguage.g:859:1: (lv_mixed_2_0= ruleMixed )
                    {
                    // InternalRegionAccessTestLanguage.g:859:1: (lv_mixed_2_0= ruleMixed )
                    // InternalRegionAccessTestLanguage.g:860:3: lv_mixed_2_0= ruleMixed
                    {
                     
                    	        newCompositeNode(grammarAccess.getFragmentAccess().getMixedMixedParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_mixed_2_0=ruleMixed();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFragmentRule());
                    	        }
                           		set(
                           			current, 
                           			"mixed",
                            		lv_mixed_2_0, 
                            		"org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguage.Mixed");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalRegionAccessTestLanguage.g:877:6: (otherlv_3= 'recursion' this_Fragment_4= ruleFragment[$current] )
                    {
                    // InternalRegionAccessTestLanguage.g:877:6: (otherlv_3= 'recursion' this_Fragment_4= ruleFragment[$current] )
                    // InternalRegionAccessTestLanguage.g:877:8: otherlv_3= 'recursion' this_Fragment_4= ruleFragment[$current]
                    {
                    otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_12); 

                        	newLeafNode(otherlv_3, grammarAccess.getFragmentAccess().getRecursionKeyword_2_0());
                        
                     
                    		if (current==null) {
                    			current = createModelElement(grammarAccess.getFragmentRule());
                    		}
                            newCompositeNode(grammarAccess.getFragmentAccess().getFragmentParserRuleCall_2_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Fragment_4=ruleFragment(current);

                    state._fsp--;

                     
                            current = this_Fragment_4; 
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleFragment"


    // $ANTLR start "ruleEnum"
    // InternalRegionAccessTestLanguage.g:901:1: ruleEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) ) ;
    public final Enumerator ruleEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // InternalRegionAccessTestLanguage.g:903:28: ( ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) ) )
            // InternalRegionAccessTestLanguage.g:904:1: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) )
            {
            // InternalRegionAccessTestLanguage.g:904:1: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==30) ) {
                alt14=1;
            }
            else if ( (LA14_0==31) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalRegionAccessTestLanguage.g:904:2: (enumLiteral_0= 'lit1' )
                    {
                    // InternalRegionAccessTestLanguage.g:904:2: (enumLiteral_0= 'lit1' )
                    // InternalRegionAccessTestLanguage.g:904:4: enumLiteral_0= 'lit1'
                    {
                    enumLiteral_0=(Token)match(input,30,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getEnumAccess().getLit1EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getEnumAccess().getLit1EnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalRegionAccessTestLanguage.g:910:6: (enumLiteral_1= 'lit2' )
                    {
                    // InternalRegionAccessTestLanguage.g:910:6: (enumLiteral_1= 'lit2' )
                    // InternalRegionAccessTestLanguage.g:910:8: enumLiteral_1= 'lit2'
                    {
                    enumLiteral_1=(Token)match(input,31,FollowSets000.FOLLOW_2); 

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
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000204000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000D7E00010L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000010000010L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000022000010L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000204002L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000008000000L});
    }


}