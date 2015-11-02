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
    // PsiInternalRegionAccessTestLanguage.g:59:1: ruleRoot returns [Boolean current=false] : (this_Simple_0= ruleSimple | this_Delegation_1= ruleDelegation | this_Unassigned_2= ruleUnassigned | this_PrefixedUnassigned_3= rulePrefixedUnassigned | (otherlv_4= '5' this_Expression_5= ruleExpression ) | (otherlv_6= '6' this_Mixed_7= ruleMixed ) | (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) ) ) ;
    public final Boolean ruleRoot() throws RecognitionException {
        Boolean current = false;

        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Boolean this_Simple_0 = null;

        Boolean this_Delegation_1 = null;

        Boolean this_Unassigned_2 = null;

        Boolean this_PrefixedUnassigned_3 = null;

        Boolean this_Expression_5 = null;

        Boolean this_Mixed_7 = null;

        Boolean lv_mixed_9_0 = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:60:1: ( (this_Simple_0= ruleSimple | this_Delegation_1= ruleDelegation | this_Unassigned_2= ruleUnassigned | this_PrefixedUnassigned_3= rulePrefixedUnassigned | (otherlv_4= '5' this_Expression_5= ruleExpression ) | (otherlv_6= '6' this_Mixed_7= ruleMixed ) | (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) ) ) )
            // PsiInternalRegionAccessTestLanguage.g:61:2: (this_Simple_0= ruleSimple | this_Delegation_1= ruleDelegation | this_Unassigned_2= ruleUnassigned | this_PrefixedUnassigned_3= rulePrefixedUnassigned | (otherlv_4= '5' this_Expression_5= ruleExpression ) | (otherlv_6= '6' this_Mixed_7= ruleMixed ) | (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) ) )
            {
            // PsiInternalRegionAccessTestLanguage.g:61:2: (this_Simple_0= ruleSimple | this_Delegation_1= ruleDelegation | this_Unassigned_2= ruleUnassigned | this_PrefixedUnassigned_3= rulePrefixedUnassigned | (otherlv_4= '5' this_Expression_5= ruleExpression ) | (otherlv_6= '6' this_Mixed_7= ruleMixed ) | (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) ) )
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
                    // PsiInternalRegionAccessTestLanguage.g:134:3: (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:134:3: (otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) ) )
                    // PsiInternalRegionAccessTestLanguage.g:135:4: otherlv_8= '7' ( (lv_mixed_9_0= ruleMixed ) )
                    {

                    				markLeaf(elementTypeProvider.getRoot_DigitSevenKeyword_6_0ElementType());
                    			
                    otherlv_8=(Token)match(input,13,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_8);
                    			
                    // PsiInternalRegionAccessTestLanguage.g:142:4: ( (lv_mixed_9_0= ruleMixed ) )
                    // PsiInternalRegionAccessTestLanguage.g:143:5: (lv_mixed_9_0= ruleMixed )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:143:5: (lv_mixed_9_0= ruleMixed )
                    // PsiInternalRegionAccessTestLanguage.g:144:6: lv_mixed_9_0= ruleMixed
                    {

                    						markComposite(elementTypeProvider.getRoot_MixedMixedParserRuleCall_6_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_mixed_9_0=ruleMixed();

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
    // PsiInternalRegionAccessTestLanguage.g:162:1: entryRuleSimple returns [Boolean current=false] : iv_ruleSimple= ruleSimple EOF ;
    public final Boolean entryRuleSimple() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSimple = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:162:48: (iv_ruleSimple= ruleSimple EOF )
            // PsiInternalRegionAccessTestLanguage.g:163:2: iv_ruleSimple= ruleSimple EOF
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
    // PsiInternalRegionAccessTestLanguage.g:169:1: ruleSimple returns [Boolean current=false] : (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleSimple() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalRegionAccessTestLanguage.g:170:1: ( (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalRegionAccessTestLanguage.g:171:2: (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalRegionAccessTestLanguage.g:171:2: (otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalRegionAccessTestLanguage.g:172:3: otherlv_0= '1' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getSimple_DigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalRegionAccessTestLanguage.g:179:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalRegionAccessTestLanguage.g:180:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalRegionAccessTestLanguage.g:180:4: (lv_name_1_0= RULE_ID )
            // PsiInternalRegionAccessTestLanguage.g:181:5: lv_name_1_0= RULE_ID
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
    // PsiInternalRegionAccessTestLanguage.g:200:1: entryRuleDelegation returns [Boolean current=false] : iv_ruleDelegation= ruleDelegation EOF ;
    public final Boolean entryRuleDelegation() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDelegation = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:200:52: (iv_ruleDelegation= ruleDelegation EOF )
            // PsiInternalRegionAccessTestLanguage.g:201:2: iv_ruleDelegation= ruleDelegation EOF
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
    // PsiInternalRegionAccessTestLanguage.g:207:1: ruleDelegation returns [Boolean current=false] : (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) ) ;
    public final Boolean ruleDelegation() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_delegate_1_0 = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:208:1: ( (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) ) )
            // PsiInternalRegionAccessTestLanguage.g:209:2: (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) )
            {
            // PsiInternalRegionAccessTestLanguage.g:209:2: (otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) ) )
            // PsiInternalRegionAccessTestLanguage.g:210:3: otherlv_0= '2' ( (lv_delegate_1_0= ruleDelegate ) )
            {

            			markLeaf(elementTypeProvider.getDelegation_DigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalRegionAccessTestLanguage.g:217:3: ( (lv_delegate_1_0= ruleDelegate ) )
            // PsiInternalRegionAccessTestLanguage.g:218:4: (lv_delegate_1_0= ruleDelegate )
            {
            // PsiInternalRegionAccessTestLanguage.g:218:4: (lv_delegate_1_0= ruleDelegate )
            // PsiInternalRegionAccessTestLanguage.g:219:5: lv_delegate_1_0= ruleDelegate
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
    // PsiInternalRegionAccessTestLanguage.g:236:1: entryRuleUnassigned returns [Boolean current=false] : iv_ruleUnassigned= ruleUnassigned EOF ;
    public final Boolean entryRuleUnassigned() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnassigned = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:236:52: (iv_ruleUnassigned= ruleUnassigned EOF )
            // PsiInternalRegionAccessTestLanguage.g:237:2: iv_ruleUnassigned= ruleUnassigned EOF
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
    // PsiInternalRegionAccessTestLanguage.g:243:1: ruleUnassigned returns [Boolean current=false] : (otherlv_0= '3' this_Delegate_1= ruleDelegate ) ;
    public final Boolean ruleUnassigned() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean this_Delegate_1 = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:244:1: ( (otherlv_0= '3' this_Delegate_1= ruleDelegate ) )
            // PsiInternalRegionAccessTestLanguage.g:245:2: (otherlv_0= '3' this_Delegate_1= ruleDelegate )
            {
            // PsiInternalRegionAccessTestLanguage.g:245:2: (otherlv_0= '3' this_Delegate_1= ruleDelegate )
            // PsiInternalRegionAccessTestLanguage.g:246:3: otherlv_0= '3' this_Delegate_1= ruleDelegate
            {

            			markLeaf(elementTypeProvider.getUnassigned_DigitThreeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_5); 

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
    // PsiInternalRegionAccessTestLanguage.g:265:1: entryRulePrefixedUnassigned returns [Boolean current=false] : iv_rulePrefixedUnassigned= rulePrefixedUnassigned EOF ;
    public final Boolean entryRulePrefixedUnassigned() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePrefixedUnassigned = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:265:60: (iv_rulePrefixedUnassigned= rulePrefixedUnassigned EOF )
            // PsiInternalRegionAccessTestLanguage.g:266:2: iv_rulePrefixedUnassigned= rulePrefixedUnassigned EOF
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
    // PsiInternalRegionAccessTestLanguage.g:272:1: rulePrefixedUnassigned returns [Boolean current=false] : (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) ) ;
    public final Boolean rulePrefixedUnassigned() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_delegate_1_0 = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:273:1: ( (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) ) )
            // PsiInternalRegionAccessTestLanguage.g:274:2: (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) )
            {
            // PsiInternalRegionAccessTestLanguage.g:274:2: (otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) ) )
            // PsiInternalRegionAccessTestLanguage.g:275:3: otherlv_0= '4' ( (lv_delegate_1_0= rulePrefixedDelegate ) )
            {

            			markLeaf(elementTypeProvider.getPrefixedUnassigned_DigitFourKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalRegionAccessTestLanguage.g:282:3: ( (lv_delegate_1_0= rulePrefixedDelegate ) )
            // PsiInternalRegionAccessTestLanguage.g:283:4: (lv_delegate_1_0= rulePrefixedDelegate )
            {
            // PsiInternalRegionAccessTestLanguage.g:283:4: (lv_delegate_1_0= rulePrefixedDelegate )
            // PsiInternalRegionAccessTestLanguage.g:284:5: lv_delegate_1_0= rulePrefixedDelegate
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
    // PsiInternalRegionAccessTestLanguage.g:301:1: entryRulePrefixedDelegate returns [Boolean current=false] : iv_rulePrefixedDelegate= rulePrefixedDelegate EOF ;
    public final Boolean entryRulePrefixedDelegate() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePrefixedDelegate = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:301:58: (iv_rulePrefixedDelegate= rulePrefixedDelegate EOF )
            // PsiInternalRegionAccessTestLanguage.g:302:2: iv_rulePrefixedDelegate= rulePrefixedDelegate EOF
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
    // PsiInternalRegionAccessTestLanguage.g:308:1: rulePrefixedDelegate returns [Boolean current=false] : (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate ) ;
    public final Boolean rulePrefixedDelegate() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean this_Delegate_1 = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:309:1: ( (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate ) )
            // PsiInternalRegionAccessTestLanguage.g:310:2: (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate )
            {
            // PsiInternalRegionAccessTestLanguage.g:310:2: (otherlv_0= 'prefix' this_Delegate_1= ruleDelegate )
            // PsiInternalRegionAccessTestLanguage.g:311:3: otherlv_0= 'prefix' this_Delegate_1= ruleDelegate
            {

            			markLeaf(elementTypeProvider.getPrefixedDelegate_PrefixKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_5); 

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
    // PsiInternalRegionAccessTestLanguage.g:330:1: entryRuleDelegate returns [Boolean current=false] : iv_ruleDelegate= ruleDelegate EOF ;
    public final Boolean entryRuleDelegate() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDelegate = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:330:50: (iv_ruleDelegate= ruleDelegate EOF )
            // PsiInternalRegionAccessTestLanguage.g:331:2: iv_ruleDelegate= ruleDelegate EOF
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
    // PsiInternalRegionAccessTestLanguage.g:337:1: ruleDelegate returns [Boolean current=false] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final Boolean ruleDelegate() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;

        try {
            // PsiInternalRegionAccessTestLanguage.g:338:1: ( ( (lv_name_0_0= RULE_ID ) ) )
            // PsiInternalRegionAccessTestLanguage.g:339:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // PsiInternalRegionAccessTestLanguage.g:339:2: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalRegionAccessTestLanguage.g:340:3: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalRegionAccessTestLanguage.g:340:3: (lv_name_0_0= RULE_ID )
            // PsiInternalRegionAccessTestLanguage.g:341:4: lv_name_0_0= RULE_ID
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
    // PsiInternalRegionAccessTestLanguage.g:359:1: entryRuleExpression returns [Boolean current=false] : iv_ruleExpression= ruleExpression EOF ;
    public final Boolean entryRuleExpression() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleExpression = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:359:52: (iv_ruleExpression= ruleExpression EOF )
            // PsiInternalRegionAccessTestLanguage.g:360:2: iv_ruleExpression= ruleExpression EOF
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
    // PsiInternalRegionAccessTestLanguage.g:366:1: ruleExpression returns [Boolean current=false] : (this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final Boolean ruleExpression() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean this_Primary_0 = null;

        Boolean lv_right_3_0 = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:367:1: ( (this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // PsiInternalRegionAccessTestLanguage.g:368:2: (this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // PsiInternalRegionAccessTestLanguage.g:368:2: (this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )* )
            // PsiInternalRegionAccessTestLanguage.g:369:3: this_Primary_0= rulePrimary ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )*
            {

            			markComposite(elementTypeProvider.getExpression_PrimaryParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_7);
            this_Primary_0=rulePrimary();

            state._fsp--;


            			current = this_Primary_0;
            			doneComposite();
            		
            // PsiInternalRegionAccessTestLanguage.g:377:3: ( () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==19) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalRegionAccessTestLanguage.g:378:4: () otherlv_2= '+' ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // PsiInternalRegionAccessTestLanguage.g:378:4: ()
            	    // PsiInternalRegionAccessTestLanguage.g:379:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getExpression_AddLeftAction_1_0ElementType());
            	    					doneComposite();
            	    					associateWithSemanticElement();
            	    				

            	    }


            	    				markLeaf(elementTypeProvider.getExpression_PlusSignKeyword_1_1ElementType());
            	    			
            	    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalRegionAccessTestLanguage.g:392:4: ( (lv_right_3_0= rulePrimary ) )
            	    // PsiInternalRegionAccessTestLanguage.g:393:5: (lv_right_3_0= rulePrimary )
            	    {
            	    // PsiInternalRegionAccessTestLanguage.g:393:5: (lv_right_3_0= rulePrimary )
            	    // PsiInternalRegionAccessTestLanguage.g:394:6: lv_right_3_0= rulePrimary
            	    {

            	    						markComposite(elementTypeProvider.getExpression_RightPrimaryParserRuleCall_1_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_7);
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
            	    break loop2;
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
    // PsiInternalRegionAccessTestLanguage.g:412:1: entryRulePrimary returns [Boolean current=false] : iv_rulePrimary= rulePrimary EOF ;
    public final Boolean entryRulePrimary() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePrimary = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:412:49: (iv_rulePrimary= rulePrimary EOF )
            // PsiInternalRegionAccessTestLanguage.g:413:2: iv_rulePrimary= rulePrimary EOF
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
    // PsiInternalRegionAccessTestLanguage.g:419:1: rulePrimary returns [Boolean current=false] : ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | this_Parenthesized_2= ruleParenthesized ) ;
    public final Boolean rulePrimary() throws RecognitionException {
        Boolean current = false;

        Token lv_name_1_0=null;
        Boolean this_Parenthesized_2 = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:420:1: ( ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | this_Parenthesized_2= ruleParenthesized ) )
            // PsiInternalRegionAccessTestLanguage.g:421:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | this_Parenthesized_2= ruleParenthesized )
            {
            // PsiInternalRegionAccessTestLanguage.g:421:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) | this_Parenthesized_2= ruleParenthesized )
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
                    // PsiInternalRegionAccessTestLanguage.g:422:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:422:3: ( () ( (lv_name_1_0= RULE_ID ) ) )
                    // PsiInternalRegionAccessTestLanguage.g:423:4: () ( (lv_name_1_0= RULE_ID ) )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:423:4: ()
                    // PsiInternalRegionAccessTestLanguage.g:424:5: 
                    {

                    					precedeComposite(elementTypeProvider.getPrimary_NamedAction_0_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }

                    // PsiInternalRegionAccessTestLanguage.g:430:4: ( (lv_name_1_0= RULE_ID ) )
                    // PsiInternalRegionAccessTestLanguage.g:431:5: (lv_name_1_0= RULE_ID )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:431:5: (lv_name_1_0= RULE_ID )
                    // PsiInternalRegionAccessTestLanguage.g:432:6: lv_name_1_0= RULE_ID
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
                    // PsiInternalRegionAccessTestLanguage.g:449:3: this_Parenthesized_2= ruleParenthesized
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
    // PsiInternalRegionAccessTestLanguage.g:461:1: entryRuleParenthesized returns [Boolean current=false] : iv_ruleParenthesized= ruleParenthesized EOF ;
    public final Boolean entryRuleParenthesized() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParenthesized = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:461:55: (iv_ruleParenthesized= ruleParenthesized EOF )
            // PsiInternalRegionAccessTestLanguage.g:462:2: iv_ruleParenthesized= ruleParenthesized EOF
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
    // PsiInternalRegionAccessTestLanguage.g:468:1: ruleParenthesized returns [Boolean current=false] : (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) ;
    public final Boolean ruleParenthesized() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean this_Expression_1 = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:469:1: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) )
            // PsiInternalRegionAccessTestLanguage.g:470:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            {
            // PsiInternalRegionAccessTestLanguage.g:470:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            // PsiInternalRegionAccessTestLanguage.g:471:3: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParenthesized_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParenthesized_ExpressionParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_8);
            this_Expression_1=ruleExpression();

            state._fsp--;


            			current = this_Expression_1;
            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getParenthesized_RightParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_2); 

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
    // PsiInternalRegionAccessTestLanguage.g:497:1: entryRuleMixed returns [Boolean current=false] : iv_ruleMixed= ruleMixed EOF ;
    public final Boolean entryRuleMixed() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMixed = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:497:47: (iv_ruleMixed= ruleMixed EOF )
            // PsiInternalRegionAccessTestLanguage.g:498:2: iv_ruleMixed= ruleMixed EOF
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
    // PsiInternalRegionAccessTestLanguage.g:504:1: ruleMixed returns [Boolean current=false] : (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( () | this_Mixed_5= ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) ) otherlv_13= ')' ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )* ) ;
    public final Boolean ruleMixed() throws RecognitionException {
        Boolean current = false;

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
        Boolean this_Mixed_5 = null;

        Boolean lv_eobj_8_0 = null;

        Boolean lv_datatype_9_0 = null;

        Boolean lv_lit_12_0 = null;

        Boolean lv_body_16_0 = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:505:1: ( (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( () | this_Mixed_5= ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) ) otherlv_13= ')' ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )* ) )
            // PsiInternalRegionAccessTestLanguage.g:506:2: (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( () | this_Mixed_5= ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) ) otherlv_13= ')' ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )* )
            {
            // PsiInternalRegionAccessTestLanguage.g:506:2: (otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( () | this_Mixed_5= ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) ) otherlv_13= ')' ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )* )
            // PsiInternalRegionAccessTestLanguage.g:507:3: otherlv_0= '(' (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )? ( () | this_Mixed_5= ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) ) otherlv_13= ')' ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )*
            {

            			markLeaf(elementTypeProvider.getMixed_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalRegionAccessTestLanguage.g:514:3: (otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==22) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalRegionAccessTestLanguage.g:515:4: otherlv_1= 'unassigned' (this_ID_2= RULE_ID | ruleDatatype )
                    {

                    				markLeaf(elementTypeProvider.getMixed_UnassignedKeyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_10); 

                    				doneLeaf(otherlv_1);
                    			
                    // PsiInternalRegionAccessTestLanguage.g:522:4: (this_ID_2= RULE_ID | ruleDatatype )
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
                            // PsiInternalRegionAccessTestLanguage.g:523:5: this_ID_2= RULE_ID
                            {

                            					markLeaf(elementTypeProvider.getMixed_IDTerminalRuleCall_1_1_0ElementType());
                            				
                            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                            					doneLeaf(this_ID_2);
                            				

                            }
                            break;
                        case 2 :
                            // PsiInternalRegionAccessTestLanguage.g:531:5: ruleDatatype
                            {

                            					markComposite(elementTypeProvider.getMixed_DatatypeParserRuleCall_1_1_1ElementType());
                            				
                            pushFollow(FollowSets000.FOLLOW_9);
                            ruleDatatype();

                            state._fsp--;


                            					doneComposite();
                            				

                            }
                            break;

                    }


                    }
                    break;

            }

            // PsiInternalRegionAccessTestLanguage.g:540:3: ( () | this_Mixed_5= ruleMixed | ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) ) )
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
                    // PsiInternalRegionAccessTestLanguage.g:541:4: ()
                    {
                    // PsiInternalRegionAccessTestLanguage.g:541:4: ()
                    // PsiInternalRegionAccessTestLanguage.g:542:5: 
                    {

                    					precedeComposite(elementTypeProvider.getMixed_ActionAction_2_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalRegionAccessTestLanguage.g:549:4: this_Mixed_5= ruleMixed
                    {

                    				markComposite(elementTypeProvider.getMixed_MixedParserRuleCall_2_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_8);
                    this_Mixed_5=ruleMixed();

                    state._fsp--;


                    				current = this_Mixed_5;
                    				doneComposite();
                    			

                    }
                    break;
                case 3 :
                    // PsiInternalRegionAccessTestLanguage.g:558:4: ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:558:4: ( ( (lv_name_6_0= RULE_ID ) ) | (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) ) | ( (lv_datatype_9_0= ruleDatatype ) ) | (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) ) | ( (lv_lit_12_0= ruleEnum ) ) )
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
                            // PsiInternalRegionAccessTestLanguage.g:559:5: ( (lv_name_6_0= RULE_ID ) )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:559:5: ( (lv_name_6_0= RULE_ID ) )
                            // PsiInternalRegionAccessTestLanguage.g:560:6: (lv_name_6_0= RULE_ID )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:560:6: (lv_name_6_0= RULE_ID )
                            // PsiInternalRegionAccessTestLanguage.g:561:7: lv_name_6_0= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getMixed_NameIDTerminalRuleCall_2_2_0_0ElementType());
                            						
                            lv_name_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            							doneLeaf(lv_name_6_0);
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalRegionAccessTestLanguage.g:577:5: (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:577:5: (otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) ) )
                            // PsiInternalRegionAccessTestLanguage.g:578:6: otherlv_7= 'child' ( (lv_eobj_8_0= ruleMixed ) )
                            {

                            						markLeaf(elementTypeProvider.getMixed_ChildKeyword_2_2_1_0ElementType());
                            					
                            otherlv_7=(Token)match(input,23,FollowSets000.FOLLOW_4); 

                            						doneLeaf(otherlv_7);
                            					
                            // PsiInternalRegionAccessTestLanguage.g:585:6: ( (lv_eobj_8_0= ruleMixed ) )
                            // PsiInternalRegionAccessTestLanguage.g:586:7: (lv_eobj_8_0= ruleMixed )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:586:7: (lv_eobj_8_0= ruleMixed )
                            // PsiInternalRegionAccessTestLanguage.g:587:8: lv_eobj_8_0= ruleMixed
                            {

                            								markComposite(elementTypeProvider.getMixed_EobjMixedParserRuleCall_2_2_1_1_0ElementType());
                            							
                            pushFollow(FollowSets000.FOLLOW_8);
                            lv_eobj_8_0=ruleMixed();

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
                            // PsiInternalRegionAccessTestLanguage.g:602:5: ( (lv_datatype_9_0= ruleDatatype ) )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:602:5: ( (lv_datatype_9_0= ruleDatatype ) )
                            // PsiInternalRegionAccessTestLanguage.g:603:6: (lv_datatype_9_0= ruleDatatype )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:603:6: (lv_datatype_9_0= ruleDatatype )
                            // PsiInternalRegionAccessTestLanguage.g:604:7: lv_datatype_9_0= ruleDatatype
                            {

                            							markComposite(elementTypeProvider.getMixed_DatatypeDatatypeParserRuleCall_2_2_2_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_8);
                            lv_datatype_9_0=ruleDatatype();

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
                            // PsiInternalRegionAccessTestLanguage.g:618:5: (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:618:5: (otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) ) )
                            // PsiInternalRegionAccessTestLanguage.g:619:6: otherlv_10= 'ref' ( (otherlv_11= RULE_ID ) )
                            {

                            						markLeaf(elementTypeProvider.getMixed_RefKeyword_2_2_3_0ElementType());
                            					
                            otherlv_10=(Token)match(input,24,FollowSets000.FOLLOW_5); 

                            						doneLeaf(otherlv_10);
                            					
                            // PsiInternalRegionAccessTestLanguage.g:626:6: ( (otherlv_11= RULE_ID ) )
                            // PsiInternalRegionAccessTestLanguage.g:627:7: (otherlv_11= RULE_ID )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:627:7: (otherlv_11= RULE_ID )
                            // PsiInternalRegionAccessTestLanguage.g:628:8: otherlv_11= RULE_ID
                            {

                            								if (!current) {
                            									associateWithSemanticElement();
                            									current = true;
                            								}
                            							

                            								markLeaf(elementTypeProvider.getMixed_RefMixedCrossReference_2_2_3_1_0ElementType());
                            							
                            otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                            								doneLeaf(otherlv_11);
                            							

                            }


                            }


                            }


                            }
                            break;
                        case 5 :
                            // PsiInternalRegionAccessTestLanguage.g:645:5: ( (lv_lit_12_0= ruleEnum ) )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:645:5: ( (lv_lit_12_0= ruleEnum ) )
                            // PsiInternalRegionAccessTestLanguage.g:646:6: (lv_lit_12_0= ruleEnum )
                            {
                            // PsiInternalRegionAccessTestLanguage.g:646:6: (lv_lit_12_0= ruleEnum )
                            // PsiInternalRegionAccessTestLanguage.g:647:7: lv_lit_12_0= ruleEnum
                            {

                            							markComposite(elementTypeProvider.getMixed_LitEnumEnumRuleCall_2_2_4_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_8);
                            lv_lit_12_0=ruleEnum();

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
            		
            otherlv_13=(Token)match(input,21,FollowSets000.FOLLOW_11); 

            			doneLeaf(otherlv_13);
            		
            // PsiInternalRegionAccessTestLanguage.g:669:3: ( () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )? )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==25) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // PsiInternalRegionAccessTestLanguage.g:670:4: () otherlv_15= 'action' ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )?
            	    {
            	    // PsiInternalRegionAccessTestLanguage.g:670:4: ()
            	    // PsiInternalRegionAccessTestLanguage.g:671:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getMixed_AssignedActionChildAction_4_0ElementType());
            	    					doneComposite();
            	    					associateWithSemanticElement();
            	    				

            	    }


            	    				markLeaf(elementTypeProvider.getMixed_ActionKeyword_4_1ElementType());
            	    			
            	    otherlv_15=(Token)match(input,25,FollowSets000.FOLLOW_12); 

            	    				doneLeaf(otherlv_15);
            	    			
            	    // PsiInternalRegionAccessTestLanguage.g:684:4: ( ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end' )?
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==20) ) {
            	        alt8=1;
            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // PsiInternalRegionAccessTestLanguage.g:685:5: ( (lv_body_16_0= ruleMixed ) ) otherlv_17= 'end'
            	            {
            	            // PsiInternalRegionAccessTestLanguage.g:685:5: ( (lv_body_16_0= ruleMixed ) )
            	            // PsiInternalRegionAccessTestLanguage.g:686:6: (lv_body_16_0= ruleMixed )
            	            {
            	            // PsiInternalRegionAccessTestLanguage.g:686:6: (lv_body_16_0= ruleMixed )
            	            // PsiInternalRegionAccessTestLanguage.g:687:7: lv_body_16_0= ruleMixed
            	            {

            	            							markComposite(elementTypeProvider.getMixed_BodyMixedParserRuleCall_4_2_0_0ElementType());
            	            						
            	            pushFollow(FollowSets000.FOLLOW_13);
            	            lv_body_16_0=ruleMixed();

            	            state._fsp--;


            	            							doneComposite();
            	            							if(!current) {
            	            								associateWithSemanticElement();
            	            								current = true;
            	            							}
            	            						

            	            }


            	            }


            	            					markLeaf(elementTypeProvider.getMixed_EndKeyword_4_2_1ElementType());
            	            				
            	            otherlv_17=(Token)match(input,26,FollowSets000.FOLLOW_11); 

            	            					doneLeaf(otherlv_17);
            	            				

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
    // PsiInternalRegionAccessTestLanguage.g:713:1: entryRuleDatatype returns [Boolean current=false] : iv_ruleDatatype= ruleDatatype EOF ;
    public final Boolean entryRuleDatatype() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDatatype = null;


        try {
            // PsiInternalRegionAccessTestLanguage.g:713:50: (iv_ruleDatatype= ruleDatatype EOF )
            // PsiInternalRegionAccessTestLanguage.g:714:2: iv_ruleDatatype= ruleDatatype EOF
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
    // PsiInternalRegionAccessTestLanguage.g:720:1: ruleDatatype returns [Boolean current=false] : (kw= 'datatype' ( ruleDatatype | this_ID_2= RULE_ID ) ) ;
    public final Boolean ruleDatatype() throws RecognitionException {
        Boolean current = false;

        Token kw=null;
        Token this_ID_2=null;

        try {
            // PsiInternalRegionAccessTestLanguage.g:721:1: ( (kw= 'datatype' ( ruleDatatype | this_ID_2= RULE_ID ) ) )
            // PsiInternalRegionAccessTestLanguage.g:722:2: (kw= 'datatype' ( ruleDatatype | this_ID_2= RULE_ID ) )
            {
            // PsiInternalRegionAccessTestLanguage.g:722:2: (kw= 'datatype' ( ruleDatatype | this_ID_2= RULE_ID ) )
            // PsiInternalRegionAccessTestLanguage.g:723:3: kw= 'datatype' ( ruleDatatype | this_ID_2= RULE_ID )
            {

            			markLeaf(elementTypeProvider.getDatatype_DatatypeKeyword_0ElementType());
            		
            kw=(Token)match(input,27,FollowSets000.FOLLOW_10); 

            			doneLeaf(kw);
            		
            // PsiInternalRegionAccessTestLanguage.g:730:3: ( ruleDatatype | this_ID_2= RULE_ID )
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
                    // PsiInternalRegionAccessTestLanguage.g:731:4: ruleDatatype
                    {

                    				markComposite(elementTypeProvider.getDatatype_DatatypeParserRuleCall_1_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleDatatype();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalRegionAccessTestLanguage.g:739:4: this_ID_2= RULE_ID
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


    // $ANTLR start "ruleEnum"
    // PsiInternalRegionAccessTestLanguage.g:751:1: ruleEnum returns [Boolean current=false] : ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) ) ;
    public final Boolean ruleEnum() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

        try {
            // PsiInternalRegionAccessTestLanguage.g:752:1: ( ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) ) )
            // PsiInternalRegionAccessTestLanguage.g:753:2: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) )
            {
            // PsiInternalRegionAccessTestLanguage.g:753:2: ( (enumLiteral_0= 'lit1' ) | (enumLiteral_1= 'lit2' ) )
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
                    // PsiInternalRegionAccessTestLanguage.g:754:3: (enumLiteral_0= 'lit1' )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:754:3: (enumLiteral_0= 'lit1' )
                    // PsiInternalRegionAccessTestLanguage.g:755:4: enumLiteral_0= 'lit1'
                    {

                    				markLeaf(elementTypeProvider.getEnum_Lit1EnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,28,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalRegionAccessTestLanguage.g:764:3: (enumLiteral_1= 'lit2' )
                    {
                    // PsiInternalRegionAccessTestLanguage.g:764:3: (enumLiteral_1= 'lit2' )
                    // PsiInternalRegionAccessTestLanguage.g:765:4: enumLiteral_1= 'lit2'
                    {

                    				markLeaf(elementTypeProvider.getEnum_Lit2EnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,29,FollowSets000.FOLLOW_2); 

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
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000039F00010L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000008000010L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000002100002L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000004000000L});
    }


}