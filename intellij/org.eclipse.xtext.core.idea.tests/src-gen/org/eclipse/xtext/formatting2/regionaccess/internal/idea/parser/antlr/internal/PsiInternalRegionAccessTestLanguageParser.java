package org.eclipse.xtext.formatting2.regionaccess.internal.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.RegionAccessTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.formatting2.regionaccess.internal.services.RegionAccessTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalRegionAccessTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'5'", "'6'", "'7'", "'action'", "'1'", "'2'", "'3'", "'4'", "'prefix'", "'+'", "'('", "')'", "'unassigned'", "'fragment'", "'child'", "'ref'", "'end'", "'datatype'", "'recursion'", "'lit1'", "'lit2'"
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
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
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


        public PsiInternalRegionAccessTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalRegionAccessTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalRegionAccessTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalRegionAccessTestLanguage.g"; }



    	protected RegionAccessTestLanguageGrammarAccess grammarAccess;

    	protected RegionAccessTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalRegionAccessTestLanguageParser(PsiBuilder builder, TokenStream input, RegionAccessTestLanguageElementTypeProvider elementTypeProvider, RegionAccessTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Root";
    	}




    // $ANTLR start "entryRuleRoot"
    // PsiInternalRegionAccessTestLanguage.g:52:1: entryRuleRoot returns [Boolean current=false] : iv_ruleRoot= ruleRoot EOF ;
    public final Boolean entryRuleRoot() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRoot = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:52:46: (iv_ruleRoot= ruleRoot EOF )
            // PsiInternalRegionAccessTestLanguage.g:53:2: iv_ruleRoot= ruleRoot EOF
            {
             markComposite(elementTypeProvider.getRootElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRoot=ruleRoot();

            state._fsp--;

             current =iv_ruleRoot; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // PsiInternalRegionAccessTestLanguage.g:59:1: ruleRoot returns [Boolean current=false] : (this_Simple_0= ruleSimple | this_Delegation_1= ruleDelegation | this_Unassigned_2= ruleUnassigned | this_PrefixedUnassigned_3= rulePrefixedUnassigned | (otherlv_4= '5' this_Expression_5= ruleExpression ) | (otherlv_6= '6' this_Mixed_7= ruleMixed ) | (otherlv_8= '7' ( () otherlv_10= 'action' )? ( (lv_mixed_11_0= ruleMixed ) ) ) ) ;
    public final Boolean ruleRoot() throws RecognitionException {
        Boolean current = false;

        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Boolean this_Simple_0 = null;

        Boolean this_Delegation_1 = null;

        Boolean this_Unassigned_2 = null;

        Boolean this_PrefixedUnassigned_3 = null;

        Boolean this_Expression_5 = null;

        Boolean this_Mixed_7 = null;

        Boolean lv_mixed_11_0 = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:60:1: ( (this_Simple_0= ruleSimple | this_Delegation_1= ruleDelegation | this_Unassigned_2= ruleUnassigned | this_PrefixedUnassigned_3= rulePrefixedUnassigned | (otherlv_4= '5' this_Expression_5= ruleExpression ) | (otherlv_6= '6' this_Mixed_7= ruleMixed ) | (otherlv_8= '7' ( () otherlv_10= 'action' )? ( (lv_mixed_11_0= ruleMixed ) ) ) ) )
            // PsiInternalRegionAccessTestLanguage.g:61:2: (this_Simple_0= ruleSimple | this_Delegation_1= ruleDelegation | this_Unassigned_2= ruleUnassigned | this_PrefixedUnassigned_3= rulePrefixedUnassigned | (otherlv_4= '5' this_Expression_5= ruleExpression ) | (otherlv_6= '6' this_Mixed_7= ruleMixed ) | (otherlv_8= '7' ( () otherlv_10= 'action' )? ( (lv_mixed_11_0= ruleMixed ) ) ) )
            {
            // PsiInternalRegionAccessTestLanguage.g:61:2: (this_Simple_0= ruleSimple | this_Delegation_1= ruleDelegation | this_Unassigned_2= ruleUnassigned | this_PrefixedUnassigned_3= rulePrefixedUnassigned | (otherlv_4= '5' this_Expression_5= ruleExpression ) | (otherlv_6= '6' this_Mixed_7= ruleMixed ) | (otherlv_8= '7' ( () otherlv_10= 'action' )? ( (lv_mixed_11_0= ruleMixed ) ) ) )
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
                    // PsiInternalRegionAccessTestLanguage.g:62:3: this_Simple_0= ruleSimple
                    {

                    			markComposite(elementTypeProvider.getRoot_SimpleParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Simple_0=ruleSimple();

                    state._fsp--;


                    			current = this_Simple_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalRegionAccessTestLanguage.g:71:3: this_Delegation_1= ruleDelegation
                    {

                    			markComposite(elementTypeProvider.getRoot_DelegationParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Delegation_1=ruleDelegation();

                    state._fsp--;


                    			current = this_Delegation_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalRegionAccessTestLanguage.g:80:3: this_Unassigned_2= ruleUnassigned
                    {

                    			markComposite(elementTypeProvider.getRoot_UnassignedParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Unassigned_2=ruleUnassigned();

                    state._fsp--;


                    			current = this_Unassigned_2;
                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalRegionAccessTestLanguage.g:89:3: this_PrefixedUnassigned_3= rulePrefixedUnassigned
                    {

                    			markComposite(elementTypeProvider.getRoot_PrefixedUnassignedParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PrefixedUnassigned_3=rulePrefixedUnassigned();

                    state._fsp--;


                    			current = this_PrefixedUnassigned_3;
                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalRegionAccessTestLanguage.g:98:3: (otherlv_4= '5' this_Expression_5= ruleExpression )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:98:3: (otherlv_4= '5' this_Expression_5= ruleExpression )
                    // PsiInternalRegionAccessTestLanguage.g:99:4: otherlv_4= '5' this_Expression_5= ruleExpression
                    {

                    				markLeaf(elementTypeProvider.getRoot_DigitFiveKeyword_4_0ElementType());
                    			
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_4);
                    			

                    				markComposite(elementTypeProvider.getRoot_ExpressionParserRuleCall_4_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Expression_5=ruleExpression();

                    state._fsp--;


                    				current = this_Expression_5;
                    				doneComposite();
                    			

                    }


                    }
                    break;
                case 6 :
                    // PsiInternalRegionAccessTestLanguage.g:116:3: (otherlv_6= '6' this_Mixed_7= ruleMixed )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:116:3: (otherlv_6= '6' this_Mixed_7= ruleMixed )
                    // PsiInternalRegionAccessTestLanguage.g:117:4: otherlv_6= '6' this_Mixed_7= ruleMixed
                    {

                    				markLeaf(elementTypeProvider.getRoot_DigitSixKeyword_5_0ElementType());
                    			
                    otherlv_6=(Token)match(input,12,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_6);
                    			

                    				markComposite(elementTypeProvider.getRoot_MixedParserRuleCall_5_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Mixed_7=ruleMixed();

                    state._fsp--;


                    				current = this_Mixed_7;
                    				doneComposite();
                    			

                    }


                    }
                    break;
                case 7 :
                    // PsiInternalRegionAccessTestLanguage.g:134:3: (otherlv_8= '7' ( () otherlv_10= 'action' )? ( (lv_mixed_11_0= ruleMixed ) ) )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:134:3: (otherlv_8= '7' ( () otherlv_10= 'action' )? ( (lv_mixed_11_0= ruleMixed ) ) )
                    // PsiInternalRegionAccessTestLanguage.g:135:4: otherlv_8= '7' ( () otherlv_10= 'action' )? ( (lv_mixed_11_0= ruleMixed ) )
                    {

                    				markLeaf(elementTypeProvider.getRoot_DigitSevenKeyword_6_0ElementType());
                    			
                    otherlv_8=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_8);
                    			
                    // PsiInternalRegionAccessTestLanguage.g:142:4: ( () otherlv_10= 'action' )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==14) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // PsiInternalRegionAccessTestLanguage.g:143:5: () otherlv_10= 'action'
                            {
                            // PsiInternalRegionAccessTestLanguage.g:143:5: ()
                            // PsiInternalRegionAccessTestLanguage.g:144:6: 
                            {

                            						precedeComposite(elementTypeProvider.getRoot_RootActionAction_6_1_0ElementType());
                            						doneComposite();
                            						associateWithSemanticElement();
                            					

                            }


                            					markLeaf(elementTypeProvider.getRoot_ActionKeyword_6_1_1ElementType());
                            				
                            otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_4); 

                            					doneLeaf(otherlv_10);
                            				

                            }
                            break;

                    }

                    // PsiInternalRegionAccessTestLanguage.g:158:4: ( (lv_mixed_11_0= ruleMixed ) )
                    // PsiInternalRegionAccessTestLanguage.g:159:5: (lv_mixed_11_0= ruleMixed )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:159:5: (lv_mixed_11_0= ruleMixed )
                    // PsiInternalRegionAccessTestLanguage.g:160:6: lv_mixed_11_0= ruleMixed
                    {

                    						markComposite(elementTypeProvider.getRoot_MixedMixedParserRuleCall_6_2_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_mixed_11_0=ruleMixed();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleSimple"
    // PsiInternalRegionAccessTestLanguage.g:178:1: entryRuleSimple returns [Boolean current=false] : iv_ruleSimple= ruleSimple EOF ;
    public final Boolean entryRuleSimple() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSimple = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:178:48: (iv_ruleSimple= ruleSimple EOF )
            // PsiInternalRegionAccessTestLanguage.g:179:2: iv_ruleSimple= ruleSimple EOF
            {
             markComposite(elementTypeProvider.getSimpleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSimple=ruleSimple();

            state._fsp--;

             current =iv_ruleSimple; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimple"


    // $ANTLR start "ruleSimple"
    // PsiInternalRegionAccessTestLanguage.g:185:1: ruleSimple returns [Boolean current=false] : (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleSimple() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalRegionAccessTestLanguage.g:186:1: ( (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalRegionAccessTestLanguage.g:187:2: (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalRegionAccessTestLanguage.g:187:2: (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalRegionAccessTestLanguage.g:188:3: otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getSimple_DigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalRegionAccessTestLanguage.g:195:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalRegionAccessTestLanguage.g:196:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalRegionAccessTestLanguage.g:196:4: (lv_name_1_0= RULE_ID )
            // PsiInternalRegionAccessTestLanguage.g:197:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSimple_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimple"


    // $ANTLR start "entryRuleDelegation"
    // PsiInternalRegionAccessTestLanguage.g:216:1: entryRuleDelegation returns [Boolean current=false] : iv_ruleDelegation= ruleDelegation EOF ;
    public final Boolean entryRuleDelegation() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDelegation = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:216:52: (iv_ruleDelegation= ruleDelegation EOF )
            // PsiInternalRegionAccessTestLanguage.g:217:2: iv_ruleDelegation= ruleDelegation EOF
            {
             markComposite(elementTypeProvider.getDelegationElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDelegation=ruleDelegation();

            state._fsp--;

             current =iv_ruleDelegation; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDelegation"


    // $ANTLR start "ruleDelegation"
    // PsiInternalRegionAccessTestLanguage.g:223:1: ruleDelegation returns [Boolean current=false] : (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) ) ;
    public final Boolean ruleDelegation() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_delegate_1_0 = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:224:1: ( (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) ) )
            // PsiInternalRegionAccessTestLanguage.g:225:2: (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) )
            {
            // PsiInternalRegionAccessTestLanguage.g:225:2: (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) )
            // PsiInternalRegionAccessTestLanguage.g:226:3: otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) )
            {

            			markLeaf(elementTypeProvider.getDelegation_DigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalRegionAccessTestLanguage.g:233:3: ( (lv_delegate_1_0= ruleDelegate ) )
            // PsiInternalRegionAccessTestLanguage.g:234:4: (lv_delegate_1_0= ruleDelegate )
            {
            // PsiInternalRegionAccessTestLanguage.g:234:4: (lv_delegate_1_0= ruleDelegate )
            // PsiInternalRegionAccessTestLanguage.g:235:5: lv_delegate_1_0= ruleDelegate
            {

            					markComposite(elementTypeProvider.getDelegation_DelegateDelegateParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_delegate_1_0=ruleDelegate();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDelegation"


    // $ANTLR start "entryRuleUnassigned"
    // PsiInternalRegionAccessTestLanguage.g:252:1: entryRuleUnassigned returns [Boolean current=false] : iv_ruleUnassigned= ruleUnassigned EOF ;
    public final Boolean entryRuleUnassigned() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnassigned = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:252:52: (iv_ruleUnassigned= ruleUnassigned EOF )
            // PsiInternalRegionAccessTestLanguage.g:253:2: iv_ruleUnassigned= ruleUnassigned EOF
            {
             markComposite(elementTypeProvider.getUnassignedElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnassigned=ruleUnassigned();

            state._fsp--;

             current =iv_ruleUnassigned; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnassigned"


    // $ANTLR start "ruleUnassigned"
    // PsiInternalRegionAccessTestLanguage.g:259:1: ruleUnassigned returns [Boolean current=false] : (otherlv_0= '3' this_Delegate_1= ruleDelegate ) ;
    public final Boolean ruleUnassigned() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean this_Delegate_1 = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:260:1: ( (otherlv_0= '3' this_Delegate_1= ruleDelegate ) )
            // PsiInternalRegionAccessTestLanguage.g:261:2: (otherlv_0= '3' this_Delegate_1= ruleDelegate )
            {
            // PsiInternalRegionAccessTestLanguage.g:261:2: (otherlv_0= '3' this_Delegate_1= ruleDelegate )
            // PsiInternalRegionAccessTestLanguage.g:262:3: otherlv_0= '3' this_Delegate_1= ruleDelegate
            {

            			markLeaf(elementTypeProvider.getUnassigned_DigitThreeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getUnassigned_DelegateParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_2);
            this_Delegate_1=ruleDelegate();

            state._fsp--;


            			current = this_Delegate_1;
            			doneComposite();
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnassigned"


    // $ANTLR start "entryRulePrefixedUnassigned"
    // PsiInternalRegionAccessTestLanguage.g:281:1: entryRulePrefixedUnassigned returns [Boolean current=false] : iv_rulePrefixedUnassigned= rulePrefixedUnassigned EOF ;
    public final Boolean entryRulePrefixedUnassigned() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePrefixedUnassigned = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:281:60: (iv_rulePrefixedUnassigned= rulePrefixedUnassigned EOF )
            // PsiInternalRegionAccessTestLanguage.g:282:2: iv_rulePrefixedUnassigned= rulePrefixedUnassigned EOF
            {
             markComposite(elementTypeProvider.getPrefixedUnassignedElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrefixedUnassigned=rulePrefixedUnassigned();

            state._fsp--;

             current =iv_rulePrefixedUnassigned; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrefixedUnassigned"


    // $ANTLR start "rulePrefixedUnassigned"
    // PsiInternalRegionAccessTestLanguage.g:288:1: rulePrefixedUnassigned returns [Boolean current=false] : (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) ) ;
    public final Boolean rulePrefixedUnassigned() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_delegate_1_0 = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:289:1: ( (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) ) )
            // PsiInternalRegionAccessTestLanguage.g:290:2: (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) )
            {
            // PsiInternalRegionAccessTestLanguage.g:290:2: (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) )
            // PsiInternalRegionAccessTestLanguage.g:291:3: otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) )
            {

            			markLeaf(elementTypeProvider.getPrefixedUnassigned_DigitFourKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalRegionAccessTestLanguage.g:298:3: ( (lv_delegate_1_0= rulePrefixedDelegate ) )
            // PsiInternalRegionAccessTestLanguage.g:299:4: (lv_delegate_1_0= rulePrefixedDelegate )
            {
            // PsiInternalRegionAccessTestLanguage.g:299:4: (lv_delegate_1_0= rulePrefixedDelegate )
            // PsiInternalRegionAccessTestLanguage.g:300:5: lv_delegate_1_0= rulePrefixedDelegate
            {

            					markComposite(elementTypeProvider.getPrefixedUnassigned_DelegatePrefixedDelegateParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_delegate_1_0=rulePrefixedDelegate();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrefixedUnassigned"


    // $ANTLR start "entryRulePrefixedDelegate"
    // PsiInternalRegionAccessTestLanguage.g:317:1: entryRulePrefixedDelegate returns [Boolean current=false] : iv_rulePrefixedDelegate= rulePrefixedDelegate EOF ;
    public final Boolean entryRulePrefixedDelegate() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePrefixedDelegate = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:317:58: (iv_rulePrefixedDelegate= rulePrefixedDelegate EOF )
            // PsiInternalRegionAccessTestLanguage.g:318:2: iv_rulePrefixedDelegate= rulePrefixedDelegate EOF
            {
             markComposite(elementTypeProvider.getPrefixedDelegateElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrefixedDelegate=rulePrefixedDelegate();

            state._fsp--;

             current =iv_rulePrefixedDelegate; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrefixedDelegate"


    // $ANTLR start "rulePrefixedDelegate"
    // PsiInternalRegionAccessTestLanguage.g:324:1: rulePrefixedDelegate returns [Boolean current=false] : (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate ) ;
    public final Boolean rulePrefixedDelegate() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean this_Delegate_1 = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:325:1: ( (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate ) )
            // PsiInternalRegionAccessTestLanguage.g:326:2: (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate )
            {
            // PsiInternalRegionAccessTestLanguage.g:326:2: (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate )
            // PsiInternalRegionAccessTestLanguage.g:327:3: otherlv_0= 'prefix' this_Delegate_1= ruleDelegate
            {

            			markLeaf(elementTypeProvider.getPrefixedDelegate_PrefixKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getPrefixedDelegate_DelegateParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_2);
            this_Delegate_1=ruleDelegate();

            state._fsp--;


            			current = this_Delegate_1;
            			doneComposite();
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrefixedDelegate"


    // $ANTLR start "entryRuleDelegate"
    // PsiInternalRegionAccessTestLanguage.g:346:1: entryRuleDelegate returns [Boolean current=false] : iv_ruleDelegate= ruleDelegate EOF ;
    public final Boolean entryRuleDelegate() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDelegate = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:346:50: (iv_ruleDelegate= ruleDelegate EOF )
            // PsiInternalRegionAccessTestLanguage.g:347:2: iv_ruleDelegate= ruleDelegate EOF
            {
             markComposite(elementTypeProvider.getDelegateElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDelegate=ruleDelegate();

            state._fsp--;

             current =iv_ruleDelegate; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDelegate"


    // $ANTLR start "ruleDelegate"
    // PsiInternalRegionAccessTestLanguage.g:353:1: ruleDelegate returns [Boolean current=false] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final Boolean ruleDelegate() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;

        try {
            // PsiInternalRegionAccessTestLanguage.g:354:1: ( ( (lv_name_0_0= RULE_ID ) ) )
            // PsiInternalRegionAccessTestLanguage.g:355:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // PsiInternalRegionAccessTestLanguage.g:355:2: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalRegionAccessTestLanguage.g:356:3: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalRegionAccessTestLanguage.g:356:3: (lv_name_0_0= RULE_ID )
            // PsiInternalRegionAccessTestLanguage.g:357:4: lv_name_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getDelegate_NameIDTerminalRuleCall_0ElementType());
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			

            				doneLeaf(lv_name_0_0);
            			

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDelegate"


    // $ANTLR start "entryRuleExpression"
    // PsiInternalRegionAccessTestLanguage.g:375:1: entryRuleExpression returns [Boolean current=false] : iv_ruleExpression= ruleExpression EOF ;
    public final Boolean entryRuleExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleExpression = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:375:52: (iv_ruleExpression= ruleExpression EOF )
            // PsiInternalRegionAccessTestLanguage.g:376:2: iv_ruleExpression= ruleExpression EOF
            {
             markComposite(elementTypeProvider.getExpressionElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // PsiInternalRegionAccessTestLanguage.g:382:1: ruleExpression returns [Boolean current=false] : (this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final Boolean ruleExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean this_Primary_0 = null;

        Boolean lv_right_3_0 = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:383:1: ( (this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // PsiInternalRegionAccessTestLanguage.g:384:2: (this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // PsiInternalRegionAccessTestLanguage.g:384:2: (this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* )
            // PsiInternalRegionAccessTestLanguage.g:385:3: this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )*
            {

            			markComposite(elementTypeProvider.getExpression_PrimaryParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_8);
            this_Primary_0=rulePrimary();

            state._fsp--;


            			current = this_Primary_0;
            			doneComposite();
            		
            // PsiInternalRegionAccessTestLanguage.g:393:3: ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==20) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // PsiInternalRegionAccessTestLanguage.g:394:4: () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // PsiInternalRegionAccessTestLanguage.g:394:4: ()
            	    // PsiInternalRegionAccessTestLanguage.g:395:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getExpression_AddLeftAction_1_0ElementType());
            	    					doneComposite();
            	    					associateWithSemanticElement();
            	    				

            	    }


            	    				markLeaf(elementTypeProvider.getExpression_PlusSignKeyword_1_1ElementType());
            	    			
            	    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalRegionAccessTestLanguage.g:408:4: ( (lv_right_3_0= rulePrimary ) )
            	    // PsiInternalRegionAccessTestLanguage.g:409:5: (lv_right_3_0= rulePrimary )
            	    {
            	    // PsiInternalRegionAccessTestLanguage.g:409:5: (lv_right_3_0= rulePrimary )
            	    // PsiInternalRegionAccessTestLanguage.g:410:6: lv_right_3_0= rulePrimary
            	    {

            	    						markComposite(elementTypeProvider.getExpression_RightPrimaryParserRuleCall_1_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    lv_right_3_0=rulePrimary();

            	    state._fsp--;


            	    						doneComposite();
            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRulePrimary"
    // PsiInternalRegionAccessTestLanguage.g:428:1: entryRulePrimary returns [Boolean current=false] : iv_rulePrimary= rulePrimary EOF ;
    public final Boolean entryRulePrimary() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePrimary = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:428:49: (iv_rulePrimary= rulePrimary EOF )
            // PsiInternalRegionAccessTestLanguage.g:429:2: iv_rulePrimary= rulePrimary EOF
            {
             markComposite(elementTypeProvider.getPrimaryElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrimary=rulePrimary();

            state._fsp--;

             current =iv_rulePrimary; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // PsiInternalRegionAccessTestLanguage.g:435:1: rulePrimary returns [Boolean current=false] : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | this_Parenthesized_2= ruleParenthesized ) ;
    public final Boolean rulePrimary() throws RecognitionException {
        Boolean current = false;

        Token lv_name_1_0=null;
        Boolean this_Parenthesized_2 = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:436:1: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | this_Parenthesized_2= ruleParenthesized ) )
            // PsiInternalRegionAccessTestLanguage.g:437:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | this_Parenthesized_2= ruleParenthesized )
            {
            // PsiInternalRegionAccessTestLanguage.g:437:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | this_Parenthesized_2= ruleParenthesized )
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
                    // PsiInternalRegionAccessTestLanguage.g:438:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:438:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // PsiInternalRegionAccessTestLanguage.g:439:4: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:439:4: ()
                    // PsiInternalRegionAccessTestLanguage.g:440:5: 
                    {

                    					precedeComposite(elementTypeProvider.getPrimary_NamedAction_0_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }

                    // PsiInternalRegionAccessTestLanguage.g:446:4: ( (lv_name_1_0= RULE_ID ) )
                    // PsiInternalRegionAccessTestLanguage.g:447:5: (lv_name_1_0= RULE_ID )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:447:5: (lv_name_1_0= RULE_ID )
                    // PsiInternalRegionAccessTestLanguage.g:448:6: lv_name_1_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getPrimary_NameIDTerminalRuleCall_0_1_0ElementType());
                    					
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_name_1_0);
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalRegionAccessTestLanguage.g:465:3: this_Parenthesized_2= ruleParenthesized
                    {

                    			markComposite(elementTypeProvider.getPrimary_ParenthesizedParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Parenthesized_2=ruleParenthesized();

                    state._fsp--;


                    			current = this_Parenthesized_2;
                    			doneComposite();
                    		

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleParenthesized"
    // PsiInternalRegionAccessTestLanguage.g:477:1: entryRuleParenthesized returns [Boolean current=false] : iv_ruleParenthesized= ruleParenthesized EOF ;
    public final Boolean entryRuleParenthesized() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParenthesized = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:477:55: (iv_ruleParenthesized= ruleParenthesized EOF )
            // PsiInternalRegionAccessTestLanguage.g:478:2: iv_ruleParenthesized= ruleParenthesized EOF
            {
             markComposite(elementTypeProvider.getParenthesizedElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParenthesized=ruleParenthesized();

            state._fsp--;

             current =iv_ruleParenthesized; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParenthesized"


    // $ANTLR start "ruleParenthesized"
    // PsiInternalRegionAccessTestLanguage.g:484:1: ruleParenthesized returns [Boolean current=false] : (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) ;
    public final Boolean ruleParenthesized() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean this_Expression_1 = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:485:1: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) )
            // PsiInternalRegionAccessTestLanguage.g:486:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            {
            // PsiInternalRegionAccessTestLanguage.g:486:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            // PsiInternalRegionAccessTestLanguage.g:487:3: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParenthesized_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParenthesized_ExpressionParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_9);
            this_Expression_1=ruleExpression();

            state._fsp--;


            			current = this_Expression_1;
            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getParenthesized_RightParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,22,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_2);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParenthesized"


    // $ANTLR start "entryRuleMixed"
    // PsiInternalRegionAccessTestLanguage.g:513:1: entryRuleMixed returns [Boolean current=false] : iv_ruleMixed= ruleMixed EOF ;
    public final Boolean entryRuleMixed() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMixed = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:513:47: (iv_ruleMixed= ruleMixed EOF )
            // PsiInternalRegionAccessTestLanguage.g:514:2: iv_ruleMixed= ruleMixed EOF
            {
             markComposite(elementTypeProvider.getMixedElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMixed=ruleMixed();

            state._fsp--;

             current =iv_ruleMixed; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMixed"


    // $ANTLR start "ruleMixed"
    // PsiInternalRegionAccessTestLanguage.g:520:1: ruleMixed returns [Boolean current=false] : (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( ( () (otherlv_5= 'fragment' this_Fragment_6= ruleFragment[$current] )? ) | this_Mixed_7= ruleMixed | ( ( (lv_name_8_0= RULE_ID ) ) | (otherlv_9= 'child' ( (lv_eobj_10_0= ruleMixed ) ) ) | ( (lv_datatype_11_0= ruleDatatype ) ) | (otherlv_12= 'ref' ( (otherlv_13= RULE_ID ) ) ) | ( (lv_lit_14_0= ruleEnum ) ) ) ) otherlv_15= ')' ( () otherlv_17= 'action' ( ( (lv_body_18_0= ruleMixed ) ) otherlv_19= 'end' )? )* ) ;
    public final Boolean ruleMixed() throws RecognitionException {
        Boolean current = false;

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
        Boolean this_Fragment_6 = null;

        Boolean this_Mixed_7 = null;

        Boolean lv_eobj_10_0 = null;

        Boolean lv_datatype_11_0 = null;

        Boolean lv_lit_14_0 = null;

        Boolean lv_body_18_0 = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:521:1: ( (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( ( () (otherlv_5= 'fragment' this_Fragment_6= ruleFragment[$current] )? ) | this_Mixed_7= ruleMixed | ( ( (lv_name_8_0= RULE_ID ) ) | (otherlv_9= 'child' ( (lv_eobj_10_0= ruleMixed ) ) ) | ( (lv_datatype_11_0= ruleDatatype ) ) | (otherlv_12= 'ref' ( (otherlv_13= RULE_ID ) ) ) | ( (lv_lit_14_0= ruleEnum ) ) ) ) otherlv_15= ')' ( () otherlv_17= 'action' ( ( (lv_body_18_0= ruleMixed ) ) otherlv_19= 'end' )? )* ) )
            // PsiInternalRegionAccessTestLanguage.g:522:2: (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( ( () (otherlv_5= 'fragment' this_Fragment_6= ruleFragment[$current] )? ) | this_Mixed_7= ruleMixed | ( ( (lv_name_8_0= RULE_ID ) ) | (otherlv_9= 'child' ( (lv_eobj_10_0= ruleMixed ) ) ) | ( (lv_datatype_11_0= ruleDatatype ) ) | (otherlv_12= 'ref' ( (otherlv_13= RULE_ID ) ) ) | ( (lv_lit_14_0= ruleEnum ) ) ) ) otherlv_15= ')' ( () otherlv_17= 'action' ( ( (lv_body_18_0= ruleMixed ) ) otherlv_19= 'end' )? )* )
            {
            // PsiInternalRegionAccessTestLanguage.g:522:2: (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( ( () (otherlv_5= 'fragment' this_Fragment_6= ruleFragment[$current] )? ) | this_Mixed_7= ruleMixed | ( ( (lv_name_8_0= RULE_ID ) ) | (otherlv_9= 'child' ( (lv_eobj_10_0= ruleMixed ) ) ) | ( (lv_datatype_11_0= ruleDatatype ) ) | (otherlv_12= 'ref' ( (otherlv_13= RULE_ID ) ) ) | ( (lv_lit_14_0= ruleEnum ) ) ) ) otherlv_15= ')' ( () otherlv_17= 'action' ( ( (lv_body_18_0= ruleMixed ) ) otherlv_19= 'end' )? )* )
            // PsiInternalRegionAccessTestLanguage.g:523:3: otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( ( () (otherlv_5= 'fragment' this_Fragment_6= ruleFragment[$current] )? ) | this_Mixed_7= ruleMixed | ( ( (lv_name_8_0= RULE_ID ) ) | (otherlv_9= 'child' ( (lv_eobj_10_0= ruleMixed ) ) ) | ( (lv_datatype_11_0= ruleDatatype ) ) | (otherlv_12= 'ref' ( (otherlv_13= RULE_ID ) ) ) | ( (lv_lit_14_0= ruleEnum ) ) ) ) otherlv_15= ')' ( () otherlv_17= 'action' ( ( (lv_body_18_0= ruleMixed ) ) otherlv_19= 'end' )? )*
            {

            			markLeaf(elementTypeProvider.getMixed_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalRegionAccessTestLanguage.g:530:3: (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==23) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalRegionAccessTestLanguage.g:531:4: otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype )
                    {

                    				markLeaf(elementTypeProvider.getMixed_UnassignedKeyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_11); 

                    				doneLeaf(otherlv_1);
                    			
                    // PsiInternalRegionAccessTestLanguage.g:538:4: (this_ID_2= RULE_ID | ruleDatatype )
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
                            // PsiInternalRegionAccessTestLanguage.g:539:5: this_ID_2= RULE_ID
                            {

                            					markLeaf(elementTypeProvider.getMixed_IDTerminalRuleCall_1_1_0ElementType());
                            				
                            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

                            					doneLeaf(this_ID_2);
                            				

                            }
                            break;
                        case 2 :
                            // PsiInternalRegionAccessTestLanguage.g:547:5: ruleDatatype
                            {

                            					markComposite(elementTypeProvider.getMixed_DatatypeParserRuleCall_1_1_1ElementType());
                            				
                            pushFollow(FollowSets000.FOLLOW_10);
                            ruleDatatype();

                            state._fsp--;


                            					doneComposite();
                            				

                            }
                            break;

                    }


                    }
                    break;

            }

            // PsiInternalRegionAccessTestLanguage.g:556:3: ( ( () (otherlv_5= 'fragment' this_Fragment_6= ruleFragment[$current] )? ) | this_Mixed_7= ruleMixed | ( ( (lv_name_8_0= RULE_ID ) ) | (otherlv_9= 'child' ( (lv_eobj_10_0= ruleMixed ) ) ) | ( (lv_datatype_11_0= ruleDatatype ) ) | (otherlv_12= 'ref' ( (otherlv_13= RULE_ID ) ) ) | ( (lv_lit_14_0= ruleEnum ) ) ) )
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
                    // PsiInternalRegionAccessTestLanguage.g:557:4: ( () (otherlv_5= 'fragment' this_Fragment_6= ruleFragment[$current] )? )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:557:4: ( () (otherlv_5= 'fragment' this_Fragment_6= ruleFragment[$current] )? )
                    // PsiInternalRegionAccessTestLanguage.g:558:5: () (otherlv_5= 'fragment' this_Fragment_6= ruleFragment[$current] )?
                    {
                    // PsiInternalRegionAccessTestLanguage.g:558:5: ()
                    // PsiInternalRegionAccessTestLanguage.g:559:6: 
                    {

                    						precedeComposite(elementTypeProvider.getMixed_ActionAction_2_0_0ElementType());
                    						doneComposite();
                    						associateWithSemanticElement();
                    					

                    }

                    // PsiInternalRegionAccessTestLanguage.g:565:5: (otherlv_5= 'fragment' this_Fragment_6= ruleFragment[$current] )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==24) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // PsiInternalRegionAccessTestLanguage.g:566:6: otherlv_5= 'fragment' this_Fragment_6= ruleFragment[$current]
                            {

                            						markLeaf(elementTypeProvider.getMixed_FragmentKeyword_2_0_1_0ElementType());
                            					
                            otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_12); 

                            						doneLeaf(otherlv_5);
                            					

                            						if (!current) {
                            							associateWithSemanticElement();
                            							current = true;
                            						}
                            						markComposite(elementTypeProvider.getMixed_FragmentParserRuleCall_2_0_1_1ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_9);
                            this_Fragment_6=ruleFragment(current);

                            state._fsp--;


                            						current = this_Fragment_6;
                            						doneComposite();
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalRegionAccessTestLanguage.g:588:4: this_Mixed_7= ruleMixed
                    {

                    				markComposite(elementTypeProvider.getMixed_MixedParserRuleCall_2_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_9);
                    this_Mixed_7=ruleMixed();

                    state._fsp--;


                    				current = this_Mixed_7;
                    				doneComposite();
                    			

                    }
                    break;
                case 3 :
                    // PsiInternalRegionAccessTestLanguage.g:597:4: ( ( (lv_name_8_0= RULE_ID ) ) | (otherlv_9= 'child' ( (lv_eobj_10_0= ruleMixed ) ) ) | ( (lv_datatype_11_0= ruleDatatype ) ) | (otherlv_12= 'ref' ( (otherlv_13= RULE_ID ) ) ) | ( (lv_lit_14_0= ruleEnum ) ) )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:597:4: ( ( (lv_name_8_0= RULE_ID ) ) | (otherlv_9= 'child' ( (lv_eobj_10_0= ruleMixed ) ) ) | ( (lv_datatype_11_0= ruleDatatype ) ) | (otherlv_12= 'ref' ( (otherlv_13= RULE_ID ) ) ) | ( (lv_lit_14_0= ruleEnum ) ) )
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
                            // PsiInternalRegionAccessTestLanguage.g:598:5: ( (lv_name_8_0= RULE_ID ) )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:598:5: ( (lv_name_8_0= RULE_ID ) )
                            // PsiInternalRegionAccessTestLanguage.g:599:6: (lv_name_8_0= RULE_ID )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:599:6: (lv_name_8_0= RULE_ID )
                            // PsiInternalRegionAccessTestLanguage.g:600:7: lv_name_8_0= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getMixed_NameIDTerminalRuleCall_2_2_0_0ElementType());
                            						
                            lv_name_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            							doneLeaf(lv_name_8_0);
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalRegionAccessTestLanguage.g:616:5: (otherlv_9= 'child' ( (lv_eobj_10_0= ruleMixed ) ) )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:616:5: (otherlv_9= 'child' ( (lv_eobj_10_0= ruleMixed ) ) )
                            // PsiInternalRegionAccessTestLanguage.g:617:6: otherlv_9= 'child' ( (lv_eobj_10_0= ruleMixed ) )
                            {

                            						markLeaf(elementTypeProvider.getMixed_ChildKeyword_2_2_1_0ElementType());
                            					
                            otherlv_9=(Token)match(input,25,FollowSets000.FOLLOW_4); 

                            						doneLeaf(otherlv_9);
                            					
                            // PsiInternalRegionAccessTestLanguage.g:624:6: ( (lv_eobj_10_0= ruleMixed ) )
                            // PsiInternalRegionAccessTestLanguage.g:625:7: (lv_eobj_10_0= ruleMixed )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:625:7: (lv_eobj_10_0= ruleMixed )
                            // PsiInternalRegionAccessTestLanguage.g:626:8: lv_eobj_10_0= ruleMixed
                            {

                            								markComposite(elementTypeProvider.getMixed_EobjMixedParserRuleCall_2_2_1_1_0ElementType());
                            							
                            pushFollow(FollowSets000.FOLLOW_9);
                            lv_eobj_10_0=ruleMixed();

                            state._fsp--;


                            								doneComposite();
                            								if(!current) {
                            									associateWithSemanticElement();
                            									current = true;
                            								}
                            							

                            }


                            }


                            }


                            }
                            break;
                        case 3 :
                            // PsiInternalRegionAccessTestLanguage.g:641:5: ( (lv_datatype_11_0= ruleDatatype ) )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:641:5: ( (lv_datatype_11_0= ruleDatatype ) )
                            // PsiInternalRegionAccessTestLanguage.g:642:6: (lv_datatype_11_0= ruleDatatype )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:642:6: (lv_datatype_11_0= ruleDatatype )
                            // PsiInternalRegionAccessTestLanguage.g:643:7: lv_datatype_11_0= ruleDatatype
                            {

                            							markComposite(elementTypeProvider.getMixed_DatatypeDatatypeParserRuleCall_2_2_2_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_9);
                            lv_datatype_11_0=ruleDatatype();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }


                            }


                            }
                            break;
                        case 4 :
                            // PsiInternalRegionAccessTestLanguage.g:657:5: (otherlv_12= 'ref' ( (otherlv_13= RULE_ID ) ) )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:657:5: (otherlv_12= 'ref' ( (otherlv_13= RULE_ID ) ) )
                            // PsiInternalRegionAccessTestLanguage.g:658:6: otherlv_12= 'ref' ( (otherlv_13= RULE_ID ) )
                            {

                            						markLeaf(elementTypeProvider.getMixed_RefKeyword_2_2_3_0ElementType());
                            					
                            otherlv_12=(Token)match(input,26,FollowSets000.FOLLOW_6); 

                            						doneLeaf(otherlv_12);
                            					
                            // PsiInternalRegionAccessTestLanguage.g:665:6: ( (otherlv_13= RULE_ID ) )
                            // PsiInternalRegionAccessTestLanguage.g:666:7: (otherlv_13= RULE_ID )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:666:7: (otherlv_13= RULE_ID )
                            // PsiInternalRegionAccessTestLanguage.g:667:8: otherlv_13= RULE_ID
                            {

                            								if (!current) {
                            									associateWithSemanticElement();
                            									current = true;
                            								}
                            							

                            								markLeaf(elementTypeProvider.getMixed_RefMixedCrossReference_2_2_3_1_0ElementType());
                            							
                            otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                            								doneLeaf(otherlv_13);
                            							

                            }


                            }


                            }


                            }
                            break;
                        case 5 :
                            // PsiInternalRegionAccessTestLanguage.g:684:5: ( (lv_lit_14_0= ruleEnum ) )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:684:5: ( (lv_lit_14_0= ruleEnum ) )
                            // PsiInternalRegionAccessTestLanguage.g:685:6: (lv_lit_14_0= ruleEnum )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:685:6: (lv_lit_14_0= ruleEnum )
                            // PsiInternalRegionAccessTestLanguage.g:686:7: lv_lit_14_0= ruleEnum
                            {

                            							markComposite(elementTypeProvider.getMixed_LitEnumEnumRuleCall_2_2_4_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_9);
                            lv_lit_14_0=ruleEnum();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getMixed_RightParenthesisKeyword_3ElementType());
            		
            otherlv_15=(Token)match(input,22,FollowSets000.FOLLOW_13); 

            			doneLeaf(otherlv_15);
            		
            // PsiInternalRegionAccessTestLanguage.g:708:3: ( () otherlv_17= 'action' ( ( (lv_body_18_0= ruleMixed ) ) otherlv_19= 'end' )? )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==14) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // PsiInternalRegionAccessTestLanguage.g:709:4: () otherlv_17= 'action' ( ( (lv_body_18_0= ruleMixed ) ) otherlv_19= 'end' )?
            	    {
            	    // PsiInternalRegionAccessTestLanguage.g:709:4: ()
            	    // PsiInternalRegionAccessTestLanguage.g:710:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getMixed_AssignedActionChildAction_4_0ElementType());
            	    					doneComposite();
            	    					associateWithSemanticElement();
            	    				

            	    }


            	    				markLeaf(elementTypeProvider.getMixed_ActionKeyword_4_1ElementType());
            	    			
            	    otherlv_17=(Token)match(input,14,FollowSets000.FOLLOW_14); 

            	    				doneLeaf(otherlv_17);
            	    			
            	    // PsiInternalRegionAccessTestLanguage.g:723:4: ( ( (lv_body_18_0= ruleMixed ) ) otherlv_19= 'end' )?
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( (LA10_0==21) ) {
            	        alt10=1;
            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // PsiInternalRegionAccessTestLanguage.g:724:5: ( (lv_body_18_0= ruleMixed ) ) otherlv_19= 'end'
            	            {
            	            // PsiInternalRegionAccessTestLanguage.g:724:5: ( (lv_body_18_0= ruleMixed ) )
            	            // PsiInternalRegionAccessTestLanguage.g:725:6: (lv_body_18_0= ruleMixed )
            	            {
            	            // PsiInternalRegionAccessTestLanguage.g:725:6: (lv_body_18_0= ruleMixed )
            	            // PsiInternalRegionAccessTestLanguage.g:726:7: lv_body_18_0= ruleMixed
            	            {

            	            							markComposite(elementTypeProvider.getMixed_BodyMixedParserRuleCall_4_2_0_0ElementType());
            	            						
            	            pushFollow(FollowSets000.FOLLOW_15);
            	            lv_body_18_0=ruleMixed();

            	            state._fsp--;


            	            							doneComposite();
            	            							if(!current) {
            	            								associateWithSemanticElement();
            	            								current = true;
            	            							}
            	            						

            	            }


            	            }


            	            					markLeaf(elementTypeProvider.getMixed_EndKeyword_4_2_1ElementType());
            	            				
            	            otherlv_19=(Token)match(input,27,FollowSets000.FOLLOW_13); 

            	            					doneLeaf(otherlv_19);
            	            				

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMixed"


    // $ANTLR start "entryRuleDatatype"
    // PsiInternalRegionAccessTestLanguage.g:752:1: entryRuleDatatype returns [Boolean current=false] : iv_ruleDatatype= ruleDatatype EOF ;
    public final Boolean entryRuleDatatype() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDatatype = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:752:50: (iv_ruleDatatype= ruleDatatype EOF )
            // PsiInternalRegionAccessTestLanguage.g:753:2: iv_ruleDatatype= ruleDatatype EOF
            {
             markComposite(elementTypeProvider.getDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDatatype=ruleDatatype();

            state._fsp--;

             current =iv_ruleDatatype; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDatatype"


    // $ANTLR start "ruleDatatype"
    // PsiInternalRegionAccessTestLanguage.g:759:1: ruleDatatype returns [Boolean current=false] : (kw= 'datatype' ( ruleDatatype | this_ID_2= RULE_ID ) ) ;
    public final Boolean ruleDatatype() throws RecognitionException {
        Boolean current = false;

        Token kw=null;
        Token this_ID_2=null;

        try {
            // PsiInternalRegionAccessTestLanguage.g:760:1: ( (kw= 'datatype' ( ruleDatatype | this_ID_2= RULE_ID ) ) )
            // PsiInternalRegionAccessTestLanguage.g:761:2: (kw= 'datatype' ( ruleDatatype | this_ID_2= RULE_ID ) )
            {
            // PsiInternalRegionAccessTestLanguage.g:761:2: (kw= 'datatype' ( ruleDatatype | this_ID_2= RULE_ID ) )
            // PsiInternalRegionAccessTestLanguage.g:762:3: kw= 'datatype' ( ruleDatatype | this_ID_2= RULE_ID )
            {

            			markLeaf(elementTypeProvider.getDatatype_DatatypeKeyword_0ElementType());
            		
            kw=(Token)match(input,28,FollowSets000.FOLLOW_11); 

            			doneLeaf(kw);
            		
            // PsiInternalRegionAccessTestLanguage.g:769:3: ( ruleDatatype | this_ID_2= RULE_ID )
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
                    // PsiInternalRegionAccessTestLanguage.g:770:4: ruleDatatype
                    {

                    				markComposite(elementTypeProvider.getDatatype_DatatypeParserRuleCall_1_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleDatatype();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalRegionAccessTestLanguage.g:778:4: this_ID_2= RULE_ID
                    {

                    				markLeaf(elementTypeProvider.getDatatype_IDTerminalRuleCall_1_1ElementType());
                    			
                    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    				doneLeaf(this_ID_2);
                    			

                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDatatype"


    // $ANTLR start "ruleFragment"
    // PsiInternalRegionAccessTestLanguage.g:791:1: ruleFragment[Boolean in_current] returns [Boolean current=in_current] : ( ( (lv_fragName_0_0= RULE_ID ) ) | (otherlv_1= 'child' ( (lv_mixed_2_0= ruleMixed ) ) ) | (otherlv_3= 'recursion' this_Fragment_4= ruleFragment[$current] ) ) ;
    public final Boolean ruleFragment(Boolean in_current) throws RecognitionException {
        Boolean current = in_current;

        Token lv_fragName_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Boolean lv_mixed_2_0 = null;

        Boolean this_Fragment_4 = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:792:1: ( ( ( (lv_fragName_0_0= RULE_ID ) ) | (otherlv_1= 'child' ( (lv_mixed_2_0= ruleMixed ) ) ) | (otherlv_3= 'recursion' this_Fragment_4= ruleFragment[$current] ) ) )
            // PsiInternalRegionAccessTestLanguage.g:793:2: ( ( (lv_fragName_0_0= RULE_ID ) ) | (otherlv_1= 'child' ( (lv_mixed_2_0= ruleMixed ) ) ) | (otherlv_3= 'recursion' this_Fragment_4= ruleFragment[$current] ) )
            {
            // PsiInternalRegionAccessTestLanguage.g:793:2: ( ( (lv_fragName_0_0= RULE_ID ) ) | (otherlv_1= 'child' ( (lv_mixed_2_0= ruleMixed ) ) ) | (otherlv_3= 'recursion' this_Fragment_4= ruleFragment[$current] ) )
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
                    // PsiInternalRegionAccessTestLanguage.g:794:3: ( (lv_fragName_0_0= RULE_ID ) )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:794:3: ( (lv_fragName_0_0= RULE_ID ) )
                    // PsiInternalRegionAccessTestLanguage.g:795:4: (lv_fragName_0_0= RULE_ID )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:795:4: (lv_fragName_0_0= RULE_ID )
                    // PsiInternalRegionAccessTestLanguage.g:796:5: lv_fragName_0_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getFragment_FragNameIDTerminalRuleCall_0_0ElementType());
                    				
                    lv_fragName_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    					doneLeaf(lv_fragName_0_0);
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalRegionAccessTestLanguage.g:812:3: (otherlv_1= 'child' ( (lv_mixed_2_0= ruleMixed ) ) )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:812:3: (otherlv_1= 'child' ( (lv_mixed_2_0= ruleMixed ) ) )
                    // PsiInternalRegionAccessTestLanguage.g:813:4: otherlv_1= 'child' ( (lv_mixed_2_0= ruleMixed ) )
                    {

                    				markLeaf(elementTypeProvider.getFragment_ChildKeyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,25,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_1);
                    			
                    // PsiInternalRegionAccessTestLanguage.g:820:4: ( (lv_mixed_2_0= ruleMixed ) )
                    // PsiInternalRegionAccessTestLanguage.g:821:5: (lv_mixed_2_0= ruleMixed )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:821:5: (lv_mixed_2_0= ruleMixed )
                    // PsiInternalRegionAccessTestLanguage.g:822:6: lv_mixed_2_0= ruleMixed
                    {

                    						markComposite(elementTypeProvider.getFragment_MixedMixedParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_mixed_2_0=ruleMixed();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalRegionAccessTestLanguage.g:837:3: (otherlv_3= 'recursion' this_Fragment_4= ruleFragment[$current] )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:837:3: (otherlv_3= 'recursion' this_Fragment_4= ruleFragment[$current] )
                    // PsiInternalRegionAccessTestLanguage.g:838:4: otherlv_3= 'recursion' this_Fragment_4= ruleFragment[$current]
                    {

                    				markLeaf(elementTypeProvider.getFragment_RecursionKeyword_2_0ElementType());
                    			
                    otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_12); 

                    				doneLeaf(otherlv_3);
                    			

                    				if (!current) {
                    					associateWithSemanticElement();
                    					current = true;
                    				}
                    				markComposite(elementTypeProvider.getFragment_FragmentParserRuleCall_2_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Fragment_4=ruleFragment(current);

                    state._fsp--;


                    				current = this_Fragment_4;
                    				doneComposite();
                    			

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFragment"


    // $ANTLR start "ruleEnum"
    // PsiInternalRegionAccessTestLanguage.g:862:1: ruleEnum returns [Boolean current=false] : ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) ) ;
    public final Boolean ruleEnum() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

        try {
            // PsiInternalRegionAccessTestLanguage.g:863:1: ( ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) ) )
            // PsiInternalRegionAccessTestLanguage.g:864:2: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) )
            {
            // PsiInternalRegionAccessTestLanguage.g:864:2: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) )
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
                    // PsiInternalRegionAccessTestLanguage.g:865:3: (enumLiteral_0= 'lit1' )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:865:3: (enumLiteral_0= 'lit1' )
                    // PsiInternalRegionAccessTestLanguage.g:866:4: enumLiteral_0= 'lit1'
                    {

                    				markLeaf(elementTypeProvider.getEnum_Lit1EnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,30,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalRegionAccessTestLanguage.g:875:3: (enumLiteral_1= 'lit2' )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:875:3: (enumLiteral_1= 'lit2' )
                    // PsiInternalRegionAccessTestLanguage.g:876:4: enumLiteral_1= 'lit2'
                    {

                    				markLeaf(elementTypeProvider.getEnum_Lit2EnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,31,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_1);
                    			

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
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