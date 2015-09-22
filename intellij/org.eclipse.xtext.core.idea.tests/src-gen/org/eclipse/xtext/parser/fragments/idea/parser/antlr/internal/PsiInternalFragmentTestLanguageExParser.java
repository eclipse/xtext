package org.eclipse.xtext.parser.fragments.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageExElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.fragments.services.FragmentTestLanguageExGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalFragmentTestLanguageExParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'#2'", "'->'", "'#3'", "'#4'", "'#8'", "':'", "'-'", "'<-'", "'.'"
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


        public PsiInternalFragmentTestLanguageExParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalFragmentTestLanguageExParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalFragmentTestLanguageExParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalFragmentTestLanguageEx.g"; }



    	protected FragmentTestLanguageExGrammarAccess grammarAccess;

    	protected FragmentTestLanguageExElementTypeProvider elementTypeProvider;

    	public PsiInternalFragmentTestLanguageExParser(PsiBuilder builder, TokenStream input, FragmentTestLanguageExElementTypeProvider elementTypeProvider, FragmentTestLanguageExGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "ParserRuleFragmentsEx";
    	}




    // $ANTLR start "entryRuleParserRuleFragmentsEx"
    // PsiInternalFragmentTestLanguageEx.g:52:1: entryRuleParserRuleFragmentsEx : ruleParserRuleFragmentsEx EOF ;
    public final void entryRuleParserRuleFragmentsEx() throws RecognitionException {
        try {
            // PsiInternalFragmentTestLanguageEx.g:52:31: ( ruleParserRuleFragmentsEx EOF )
            // PsiInternalFragmentTestLanguageEx.g:53:2: ruleParserRuleFragmentsEx EOF
            {
             markComposite(elementTypeProvider.getParserRuleFragmentsExElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParserRuleFragmentsEx();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParserRuleFragmentsEx"


    // $ANTLR start "ruleParserRuleFragmentsEx"
    // PsiInternalFragmentTestLanguageEx.g:58:1: ruleParserRuleFragmentsEx : ruleParserRuleFragments ;
    public final void ruleParserRuleFragmentsEx() throws RecognitionException {
        try {
            // PsiInternalFragmentTestLanguageEx.g:58:26: ( ruleParserRuleFragments )
            // PsiInternalFragmentTestLanguageEx.g:59:2: ruleParserRuleFragments
            {

            		markComposite(elementTypeProvider.getParserRuleFragmentsEx_ParserRuleFragmentsParserRuleCallElementType());
            	
            pushFollow(FollowSets000.FOLLOW_2);
            ruleParserRuleFragments();

            state._fsp--;


            		doneComposite();
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleParserRuleFragmentsEx"


    // $ANTLR start "entryRuleParserRuleFragments"
    // PsiInternalFragmentTestLanguageEx.g:69:1: entryRuleParserRuleFragments : ruleParserRuleFragments EOF ;
    public final void entryRuleParserRuleFragments() throws RecognitionException {
        try {
            // PsiInternalFragmentTestLanguageEx.g:69:29: ( ruleParserRuleFragments EOF )
            // PsiInternalFragmentTestLanguageEx.g:70:2: ruleParserRuleFragments EOF
            {
             markComposite(elementTypeProvider.getParserRuleFragmentsElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParserRuleFragments();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParserRuleFragments"


    // $ANTLR start "ruleParserRuleFragments"
    // PsiInternalFragmentTestLanguageEx.g:75:1: ruleParserRuleFragments : ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) ) ) ;
    public final void ruleParserRuleFragments() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;

        try {
            // PsiInternalFragmentTestLanguageEx.g:75:24: ( ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) ) ) )
            // PsiInternalFragmentTestLanguageEx.g:76:2: ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) ) )
            {
            // PsiInternalFragmentTestLanguageEx.g:76:2: ( () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) ) )
            // PsiInternalFragmentTestLanguageEx.g:77:3: () ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) )
            {
            // PsiInternalFragmentTestLanguageEx.g:77:3: ()
            // PsiInternalFragmentTestLanguageEx.g:78:4: 
            {

            				precedeComposite(elementTypeProvider.getParserRuleFragments_ParserRuleFragmentsAction_0ElementType());
            				doneComposite();
            			

            }

            // PsiInternalFragmentTestLanguageEx.g:83:3: ( (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) ) | (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) | (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) ) | (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) ) | (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) ) )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 12:
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
            case 16:
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
                    // PsiInternalFragmentTestLanguageEx.g:84:4: (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:84:4: (otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) ) )
                    // PsiInternalFragmentTestLanguageEx.g:85:5: otherlv_1= '#1' ( (lv_element_2_0= rulePRFNamed ) )
                    {

                    					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitOneKeyword_1_0_0ElementType());
                    				
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_1);
                    				
                    // PsiInternalFragmentTestLanguageEx.g:92:5: ( (lv_element_2_0= rulePRFNamed ) )
                    // PsiInternalFragmentTestLanguageEx.g:93:6: (lv_element_2_0= rulePRFNamed )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:93:6: (lv_element_2_0= rulePRFNamed )
                    // PsiInternalFragmentTestLanguageEx.g:94:7: lv_element_2_0= rulePRFNamed
                    {

                    							markComposite(elementTypeProvider.getParserRuleFragments_ElementPRFNamedParserRuleCall_1_0_1_0ElementType());
                    						
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePRFNamed();

                    state._fsp--;


                    							doneComposite();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalFragmentTestLanguageEx.g:105:4: (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:105:4: (otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) )
                    // PsiInternalFragmentTestLanguageEx.g:106:5: otherlv_3= '#2' ( (lv_element_4_0= rulePRFNamed ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitTwoKeyword_1_1_0ElementType());
                    				
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_3);
                    				
                    // PsiInternalFragmentTestLanguageEx.g:113:5: ( (lv_element_4_0= rulePRFNamed ) )
                    // PsiInternalFragmentTestLanguageEx.g:114:6: (lv_element_4_0= rulePRFNamed )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:114:6: (lv_element_4_0= rulePRFNamed )
                    // PsiInternalFragmentTestLanguageEx.g:115:7: lv_element_4_0= rulePRFNamed
                    {

                    							markComposite(elementTypeProvider.getParserRuleFragments_ElementPRFNamedParserRuleCall_1_1_1_0ElementType());
                    						
                    pushFollow(FollowSets000.FOLLOW_4);
                    rulePRFNamed();

                    state._fsp--;


                    							doneComposite();
                    						

                    }


                    }


                    					markLeaf(elementTypeProvider.getParserRuleFragments_HyphenMinusGreaterThanSignKeyword_1_1_2ElementType());
                    				
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_5);
                    				
                    // PsiInternalFragmentTestLanguageEx.g:131:5: ( (otherlv_6= RULE_ID ) )
                    // PsiInternalFragmentTestLanguageEx.g:132:6: (otherlv_6= RULE_ID )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:132:6: (otherlv_6= RULE_ID )
                    // PsiInternalFragmentTestLanguageEx.g:133:7: otherlv_6= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getParserRuleFragments_RefPRFNamedCrossReference_1_1_3_0ElementType());
                    						
                    otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							doneLeaf(otherlv_6);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalFragmentTestLanguageEx.g:144:4: (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:144:4: (otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) ) )
                    // PsiInternalFragmentTestLanguageEx.g:145:5: otherlv_7= '#3' ( (lv_element_8_0= rulePRFNamedRefFirst ) )
                    {

                    					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitThreeKeyword_1_2_0ElementType());
                    				
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_7);
                    				
                    // PsiInternalFragmentTestLanguageEx.g:152:5: ( (lv_element_8_0= rulePRFNamedRefFirst ) )
                    // PsiInternalFragmentTestLanguageEx.g:153:6: (lv_element_8_0= rulePRFNamedRefFirst )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:153:6: (lv_element_8_0= rulePRFNamedRefFirst )
                    // PsiInternalFragmentTestLanguageEx.g:154:7: lv_element_8_0= rulePRFNamedRefFirst
                    {

                    							markComposite(elementTypeProvider.getParserRuleFragments_ElementPRFNamedRefFirstParserRuleCall_1_2_1_0ElementType());
                    						
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePRFNamedRefFirst();

                    state._fsp--;


                    							doneComposite();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // PsiInternalFragmentTestLanguageEx.g:165:4: (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:165:4: (otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) ) )
                    // PsiInternalFragmentTestLanguageEx.g:166:5: otherlv_9= '#4' ( (lv_element_10_0= rulePRFNamedWithAction ) )
                    {

                    					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitFourKeyword_1_3_0ElementType());
                    				
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_9);
                    				
                    // PsiInternalFragmentTestLanguageEx.g:173:5: ( (lv_element_10_0= rulePRFNamedWithAction ) )
                    // PsiInternalFragmentTestLanguageEx.g:174:6: (lv_element_10_0= rulePRFNamedWithAction )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:174:6: (lv_element_10_0= rulePRFNamedWithAction )
                    // PsiInternalFragmentTestLanguageEx.g:175:7: lv_element_10_0= rulePRFNamedWithAction
                    {

                    							markComposite(elementTypeProvider.getParserRuleFragments_ElementPRFNamedWithActionParserRuleCall_1_3_1_0ElementType());
                    						
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePRFNamedWithAction();

                    state._fsp--;


                    							doneComposite();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // PsiInternalFragmentTestLanguageEx.g:186:4: (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:186:4: (otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) ) )
                    // PsiInternalFragmentTestLanguageEx.g:187:5: otherlv_11= '#8' ( (lv_element_12_0= rulePRFNamedWithFQN ) )
                    {

                    					markLeaf(elementTypeProvider.getParserRuleFragments_NumberSignDigitEightKeyword_1_4_0ElementType());
                    				
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_11);
                    				
                    // PsiInternalFragmentTestLanguageEx.g:194:5: ( (lv_element_12_0= rulePRFNamedWithFQN ) )
                    // PsiInternalFragmentTestLanguageEx.g:195:6: (lv_element_12_0= rulePRFNamedWithFQN )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:195:6: (lv_element_12_0= rulePRFNamedWithFQN )
                    // PsiInternalFragmentTestLanguageEx.g:196:7: lv_element_12_0= rulePRFNamedWithFQN
                    {

                    							markComposite(elementTypeProvider.getParserRuleFragments_ElementPRFNamedWithFQNParserRuleCall_1_4_1_0ElementType());
                    						
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePRFNamedWithFQN();

                    state._fsp--;


                    							doneComposite();
                    						

                    }


                    }


                    }


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
        return ;
    }
    // $ANTLR end "ruleParserRuleFragments"


    // $ANTLR start "entryRulePRFNamed"
    // PsiInternalFragmentTestLanguageEx.g:211:1: entryRulePRFNamed : rulePRFNamed EOF ;
    public final void entryRulePRFNamed() throws RecognitionException {
        try {
            // PsiInternalFragmentTestLanguageEx.g:211:18: ( rulePRFNamed EOF )
            // PsiInternalFragmentTestLanguageEx.g:212:2: rulePRFNamed EOF
            {
             markComposite(elementTypeProvider.getPRFNamedElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            rulePRFNamed();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePRFNamed"


    // $ANTLR start "rulePRFNamed"
    // PsiInternalFragmentTestLanguageEx.g:217:1: rulePRFNamed : ( rulePRFNamedFragment ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' rulePRFNamedRef ) )? ) ;
    public final void rulePRFNamed() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

        try {
            // PsiInternalFragmentTestLanguageEx.g:217:13: ( ( rulePRFNamedFragment ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' rulePRFNamedRef ) )? ) )
            // PsiInternalFragmentTestLanguageEx.g:218:2: ( rulePRFNamedFragment ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' rulePRFNamedRef ) )? )
            {
            // PsiInternalFragmentTestLanguageEx.g:218:2: ( rulePRFNamedFragment ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' rulePRFNamedRef ) )? )
            // PsiInternalFragmentTestLanguageEx.g:219:3: rulePRFNamedFragment ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' rulePRFNamedRef ) )?
            {

            			markComposite(elementTypeProvider.getPRFNamed_PRFNamedFragmentParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_5);
            rulePRFNamedFragment();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalFragmentTestLanguageEx.g:226:3: ( (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '-' rulePRFNamedRef ) )?
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==17) ) {
                alt2=1;
            }
            else if ( (LA2_0==18) ) {
                alt2=2;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalFragmentTestLanguageEx.g:227:4: (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:227:4: (otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
                    // PsiInternalFragmentTestLanguageEx.g:228:5: otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getPRFNamed_ColonKeyword_1_0_0ElementType());
                    				
                    otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_1);
                    				
                    // PsiInternalFragmentTestLanguageEx.g:235:5: ( (otherlv_2= RULE_ID ) )
                    // PsiInternalFragmentTestLanguageEx.g:236:6: (otherlv_2= RULE_ID )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:236:6: (otherlv_2= RULE_ID )
                    // PsiInternalFragmentTestLanguageEx.g:237:7: otherlv_2= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getPRFNamed_RefPRFNamedCrossReference_1_0_1_0ElementType());
                    						
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							doneLeaf(otherlv_2);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalFragmentTestLanguageEx.g:248:4: (otherlv_3= '-' rulePRFNamedRef )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:248:4: (otherlv_3= '-' rulePRFNamedRef )
                    // PsiInternalFragmentTestLanguageEx.g:249:5: otherlv_3= '-' rulePRFNamedRef
                    {

                    					markLeaf(elementTypeProvider.getPRFNamed_HyphenMinusKeyword_1_1_0ElementType());
                    				
                    otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_3);
                    				

                    					markComposite(elementTypeProvider.getPRFNamed_PRFNamedRefParserRuleCall_1_1_1ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePRFNamedRef();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


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
        return ;
    }
    // $ANTLR end "rulePRFNamed"


    // $ANTLR start "entryRulePRFNamedRefFirst"
    // PsiInternalFragmentTestLanguageEx.g:269:1: entryRulePRFNamedRefFirst : rulePRFNamedRefFirst EOF ;
    public final void entryRulePRFNamedRefFirst() throws RecognitionException {
        try {
            // PsiInternalFragmentTestLanguageEx.g:269:26: ( rulePRFNamedRefFirst EOF )
            // PsiInternalFragmentTestLanguageEx.g:270:2: rulePRFNamedRefFirst EOF
            {
             markComposite(elementTypeProvider.getPRFNamedRefFirstElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            rulePRFNamedRefFirst();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePRFNamedRefFirst"


    // $ANTLR start "rulePRFNamedRefFirst"
    // PsiInternalFragmentTestLanguageEx.g:275:1: rulePRFNamedRefFirst : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' rulePRFNamedFragment ) ;
    public final void rulePRFNamedRefFirst() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;

        try {
            // PsiInternalFragmentTestLanguageEx.g:275:21: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' rulePRFNamedFragment ) )
            // PsiInternalFragmentTestLanguageEx.g:276:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' rulePRFNamedFragment )
            {
            // PsiInternalFragmentTestLanguageEx.g:276:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' rulePRFNamedFragment )
            // PsiInternalFragmentTestLanguageEx.g:277:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '<-' rulePRFNamedFragment
            {
            // PsiInternalFragmentTestLanguageEx.g:277:3: ( (otherlv_0= RULE_ID ) )
            // PsiInternalFragmentTestLanguageEx.g:278:4: (otherlv_0= RULE_ID )
            {
            // PsiInternalFragmentTestLanguageEx.g:278:4: (otherlv_0= RULE_ID )
            // PsiInternalFragmentTestLanguageEx.g:279:5: otherlv_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getPRFNamedRefFirst_RefPRFNamedCrossReference_0_0ElementType());
            				
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            					doneLeaf(otherlv_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getPRFNamedRefFirst_LessThanSignHyphenMinusKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_1);
            		

            			markComposite(elementTypeProvider.getPRFNamedRefFirst_PRFNamedFragmentParserRuleCall_2ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_2);
            rulePRFNamedFragment();

            state._fsp--;


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
        return ;
    }
    // $ANTLR end "rulePRFNamedRefFirst"


    // $ANTLR start "entryRulePRFNamedWithAction"
    // PsiInternalFragmentTestLanguageEx.g:306:1: entryRulePRFNamedWithAction : rulePRFNamedWithAction EOF ;
    public final void entryRulePRFNamedWithAction() throws RecognitionException {
        try {
            // PsiInternalFragmentTestLanguageEx.g:306:28: ( rulePRFNamedWithAction EOF )
            // PsiInternalFragmentTestLanguageEx.g:307:2: rulePRFNamedWithAction EOF
            {
             markComposite(elementTypeProvider.getPRFNamedWithActionElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            rulePRFNamedWithAction();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePRFNamedWithAction"


    // $ANTLR start "rulePRFNamedWithAction"
    // PsiInternalFragmentTestLanguageEx.g:312:1: rulePRFNamedWithAction : ( rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final void rulePRFNamedWithAction() throws RecognitionException {
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

        try {
            // PsiInternalFragmentTestLanguageEx.g:312:23: ( ( rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? ) )
            // PsiInternalFragmentTestLanguageEx.g:313:2: ( rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? )
            {
            // PsiInternalFragmentTestLanguageEx.g:313:2: ( rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )? )
            // PsiInternalFragmentTestLanguageEx.g:314:3: rulePRFNamed () ( (lv_name_2_0= RULE_ID ) ) ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )?
            {

            			markComposite(elementTypeProvider.getPRFNamedWithAction_PRFNamedParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_3);
            rulePRFNamed();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalFragmentTestLanguageEx.g:321:3: ()
            // PsiInternalFragmentTestLanguageEx.g:322:4: 
            {

            				precedeComposite(elementTypeProvider.getPRFNamedWithAction_PRFNamedWithActionPrevAction_1ElementType());
            				doneComposite();
            			

            }

            // PsiInternalFragmentTestLanguageEx.g:327:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalFragmentTestLanguageEx.g:328:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalFragmentTestLanguageEx.g:328:4: (lv_name_2_0= RULE_ID )
            // PsiInternalFragmentTestLanguageEx.g:329:5: lv_name_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getPRFNamedWithAction_NameIDTerminalRuleCall_2_0ElementType());
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            					doneLeaf(lv_name_2_0);
            				

            }


            }

            // PsiInternalFragmentTestLanguageEx.g:338:3: ( ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalFragmentTestLanguageEx.g:339:4: ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= RULE_ID ) )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:339:4: ( (otherlv_3= RULE_ID ) )
                    // PsiInternalFragmentTestLanguageEx.g:340:5: (otherlv_3= RULE_ID )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:340:5: (otherlv_3= RULE_ID )
                    // PsiInternalFragmentTestLanguageEx.g:341:6: otherlv_3= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getPRFNamedWithAction_RefPRFNamedCrossReference_3_0_0ElementType());
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    						doneLeaf(otherlv_3);
                    					

                    }


                    }

                    // PsiInternalFragmentTestLanguageEx.g:350:4: ( (otherlv_4= RULE_ID ) )
                    // PsiInternalFragmentTestLanguageEx.g:351:5: (otherlv_4= RULE_ID )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:351:5: (otherlv_4= RULE_ID )
                    // PsiInternalFragmentTestLanguageEx.g:352:6: otherlv_4= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getPRFNamedWithAction_Ref2PRFNamedCrossReference_3_1_0ElementType());
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						doneLeaf(otherlv_4);
                    					

                    }


                    }


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
        return ;
    }
    // $ANTLR end "rulePRFNamedWithAction"


    // $ANTLR start "entryRulePRFNamedWithFQN"
    // PsiInternalFragmentTestLanguageEx.g:366:1: entryRulePRFNamedWithFQN : rulePRFNamedWithFQN EOF ;
    public final void entryRulePRFNamedWithFQN() throws RecognitionException {
        try {
            // PsiInternalFragmentTestLanguageEx.g:366:25: ( rulePRFNamedWithFQN EOF )
            // PsiInternalFragmentTestLanguageEx.g:367:2: rulePRFNamedWithFQN EOF
            {
             markComposite(elementTypeProvider.getPRFNamedWithFQNElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            rulePRFNamedWithFQN();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePRFNamedWithFQN"


    // $ANTLR start "rulePRFNamedWithFQN"
    // PsiInternalFragmentTestLanguageEx.g:372:1: rulePRFNamedWithFQN : ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? ) ;
    public final void rulePRFNamedWithFQN() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // PsiInternalFragmentTestLanguageEx.g:372:20: ( ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? ) )
            // PsiInternalFragmentTestLanguageEx.g:373:2: ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? )
            {
            // PsiInternalFragmentTestLanguageEx.g:373:2: ( ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )? )
            // PsiInternalFragmentTestLanguageEx.g:374:3: ( (lv_name_0_0= ruleFQN ) ) (otherlv_1= '-' ( ( ruleFQN2 ) ) )?
            {
            // PsiInternalFragmentTestLanguageEx.g:374:3: ( (lv_name_0_0= ruleFQN ) )
            // PsiInternalFragmentTestLanguageEx.g:375:4: (lv_name_0_0= ruleFQN )
            {
            // PsiInternalFragmentTestLanguageEx.g:375:4: (lv_name_0_0= ruleFQN )
            // PsiInternalFragmentTestLanguageEx.g:376:5: lv_name_0_0= ruleFQN
            {

            					markComposite(elementTypeProvider.getPRFNamedWithFQN_NameFQNParserRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_8);
            ruleFQN();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalFragmentTestLanguageEx.g:385:3: (otherlv_1= '-' ( ( ruleFQN2 ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalFragmentTestLanguageEx.g:386:4: otherlv_1= '-' ( ( ruleFQN2 ) )
                    {

                    				markLeaf(elementTypeProvider.getPRFNamedWithFQN_HyphenMinusKeyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_1);
                    			
                    // PsiInternalFragmentTestLanguageEx.g:393:4: ( ( ruleFQN2 ) )
                    // PsiInternalFragmentTestLanguageEx.g:394:5: ( ruleFQN2 )
                    {
                    // PsiInternalFragmentTestLanguageEx.g:394:5: ( ruleFQN2 )
                    // PsiInternalFragmentTestLanguageEx.g:395:6: ruleFQN2
                    {

                    						markComposite(elementTypeProvider.getPRFNamedWithFQN_RefPRFNamedCrossReference_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleFQN2();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


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
        return ;
    }
    // $ANTLR end "rulePRFNamedWithFQN"


    // $ANTLR start "entryRuleFQN"
    // PsiInternalFragmentTestLanguageEx.g:409:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // PsiInternalFragmentTestLanguageEx.g:409:13: ( ruleFQN EOF )
            // PsiInternalFragmentTestLanguageEx.g:410:2: ruleFQN EOF
            {
             markComposite(elementTypeProvider.getFQNElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFQN();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // PsiInternalFragmentTestLanguageEx.g:415:1: ruleFQN : (this_ID_0= RULE_ID ( ruleSuffix )? ) ;
    public final void ruleFQN() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // PsiInternalFragmentTestLanguageEx.g:415:8: ( (this_ID_0= RULE_ID ( ruleSuffix )? ) )
            // PsiInternalFragmentTestLanguageEx.g:416:2: (this_ID_0= RULE_ID ( ruleSuffix )? )
            {
            // PsiInternalFragmentTestLanguageEx.g:416:2: (this_ID_0= RULE_ID ( ruleSuffix )? )
            // PsiInternalFragmentTestLanguageEx.g:417:3: this_ID_0= RULE_ID ( ruleSuffix )?
            {

            			markLeaf(elementTypeProvider.getFQN_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            			doneLeaf(this_ID_0);
            		
            // PsiInternalFragmentTestLanguageEx.g:424:3: ( ruleSuffix )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==20) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalFragmentTestLanguageEx.g:425:4: ruleSuffix
                    {

                    				markComposite(elementTypeProvider.getFQN_SuffixParserRuleCall_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleSuffix();

                    state._fsp--;


                    				doneComposite();
                    			

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
        return ;
    }
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleFQN2"
    // PsiInternalFragmentTestLanguageEx.g:437:1: entryRuleFQN2 : ruleFQN2 EOF ;
    public final void entryRuleFQN2() throws RecognitionException {
        try {
            // PsiInternalFragmentTestLanguageEx.g:437:14: ( ruleFQN2 EOF )
            // PsiInternalFragmentTestLanguageEx.g:438:2: ruleFQN2 EOF
            {
             markComposite(elementTypeProvider.getFQN2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFQN2();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFQN2"


    // $ANTLR start "ruleFQN2"
    // PsiInternalFragmentTestLanguageEx.g:443:1: ruleFQN2 : (this_ID_0= RULE_ID ( ruleSuffix2 )* ) ;
    public final void ruleFQN2() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // PsiInternalFragmentTestLanguageEx.g:443:9: ( (this_ID_0= RULE_ID ( ruleSuffix2 )* ) )
            // PsiInternalFragmentTestLanguageEx.g:444:2: (this_ID_0= RULE_ID ( ruleSuffix2 )* )
            {
            // PsiInternalFragmentTestLanguageEx.g:444:2: (this_ID_0= RULE_ID ( ruleSuffix2 )* )
            // PsiInternalFragmentTestLanguageEx.g:445:3: this_ID_0= RULE_ID ( ruleSuffix2 )*
            {

            			markLeaf(elementTypeProvider.getFQN2_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            			doneLeaf(this_ID_0);
            		
            // PsiInternalFragmentTestLanguageEx.g:452:3: ( ruleSuffix2 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // PsiInternalFragmentTestLanguageEx.g:453:4: ruleSuffix2
            	    {

            	    				markComposite(elementTypeProvider.getFQN2_Suffix2ParserRuleCall_1ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_9);
            	    ruleSuffix2();

            	    state._fsp--;


            	    				doneComposite();
            	    			

            	    }
            	    break;

            	default :
            	    break loop6;
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
        return ;
    }
    // $ANTLR end "ruleFQN2"


    // $ANTLR start "ruleSuffix"
    // PsiInternalFragmentTestLanguageEx.g:466:1: ruleSuffix : (kw= '.' this_ID_1= RULE_ID ( ruleSuffix )? ) ;
    public final void ruleSuffix() throws RecognitionException {
        Token kw=null;
        Token this_ID_1=null;

        try {
            // PsiInternalFragmentTestLanguageEx.g:466:11: ( (kw= '.' this_ID_1= RULE_ID ( ruleSuffix )? ) )
            // PsiInternalFragmentTestLanguageEx.g:467:2: (kw= '.' this_ID_1= RULE_ID ( ruleSuffix )? )
            {
            // PsiInternalFragmentTestLanguageEx.g:467:2: (kw= '.' this_ID_1= RULE_ID ( ruleSuffix )? )
            // PsiInternalFragmentTestLanguageEx.g:468:3: kw= '.' this_ID_1= RULE_ID ( ruleSuffix )?
            {

            			markLeaf(elementTypeProvider.getSuffix_FullStopKeyword_0ElementType());
            		
            kw=(Token)match(input,20,FollowSets000.FOLLOW_3); 

            			doneLeaf(kw);
            		

            			markLeaf(elementTypeProvider.getSuffix_IDTerminalRuleCall_1ElementType());
            		
            this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            			doneLeaf(this_ID_1);
            		
            // PsiInternalFragmentTestLanguageEx.g:482:3: ( ruleSuffix )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // PsiInternalFragmentTestLanguageEx.g:483:4: ruleSuffix
                    {

                    				markComposite(elementTypeProvider.getSuffix_SuffixParserRuleCall_2ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleSuffix();

                    state._fsp--;


                    				doneComposite();
                    			

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
        return ;
    }
    // $ANTLR end "ruleSuffix"


    // $ANTLR start "ruleSuffix2"
    // PsiInternalFragmentTestLanguageEx.g:496:1: ruleSuffix2 : (kw= '.' this_ID_1= RULE_ID ) ;
    public final void ruleSuffix2() throws RecognitionException {
        Token kw=null;
        Token this_ID_1=null;

        try {
            // PsiInternalFragmentTestLanguageEx.g:496:12: ( (kw= '.' this_ID_1= RULE_ID ) )
            // PsiInternalFragmentTestLanguageEx.g:497:2: (kw= '.' this_ID_1= RULE_ID )
            {
            // PsiInternalFragmentTestLanguageEx.g:497:2: (kw= '.' this_ID_1= RULE_ID )
            // PsiInternalFragmentTestLanguageEx.g:498:3: kw= '.' this_ID_1= RULE_ID
            {

            			markLeaf(elementTypeProvider.getSuffix2_FullStopKeyword_0ElementType());
            		
            kw=(Token)match(input,20,FollowSets000.FOLLOW_3); 

            			doneLeaf(kw);
            		

            			markLeaf(elementTypeProvider.getSuffix2_IDTerminalRuleCall_1ElementType());
            		
            this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			doneLeaf(this_ID_1);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleSuffix2"


    // $ANTLR start "rulePRFNamedFragment"
    // PsiInternalFragmentTestLanguageEx.g:517:1: rulePRFNamedFragment : ( (lv_name_0_0= RULE_ID ) ) ;
    public final void rulePRFNamedFragment() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // PsiInternalFragmentTestLanguageEx.g:517:21: ( ( (lv_name_0_0= RULE_ID ) ) )
            // PsiInternalFragmentTestLanguageEx.g:518:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // PsiInternalFragmentTestLanguageEx.g:518:2: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalFragmentTestLanguageEx.g:519:3: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalFragmentTestLanguageEx.g:519:3: (lv_name_0_0= RULE_ID )
            // PsiInternalFragmentTestLanguageEx.g:520:4: lv_name_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getPRFNamedFragment_NameIDTerminalRuleCall_0ElementType());
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

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
        return ;
    }
    // $ANTLR end "rulePRFNamedFragment"


    // $ANTLR start "rulePRFNamedRef"
    // PsiInternalFragmentTestLanguageEx.g:533:1: rulePRFNamedRef : ( (otherlv_0= RULE_ID ) ) ;
    public final void rulePRFNamedRef() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalFragmentTestLanguageEx.g:533:16: ( ( (otherlv_0= RULE_ID ) ) )
            // PsiInternalFragmentTestLanguageEx.g:534:2: ( (otherlv_0= RULE_ID ) )
            {
            // PsiInternalFragmentTestLanguageEx.g:534:2: ( (otherlv_0= RULE_ID ) )
            // PsiInternalFragmentTestLanguageEx.g:535:3: (otherlv_0= RULE_ID )
            {
            // PsiInternalFragmentTestLanguageEx.g:535:3: (otherlv_0= RULE_ID )
            // PsiInternalFragmentTestLanguageEx.g:536:4: otherlv_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getPRFNamedRef_RefPRFNamedCrossReference_0ElementType());
            			
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				doneLeaf(otherlv_0);
            			

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
        return ;
    }
    // $ANTLR end "rulePRFNamedRef"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000060002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000100002L});
    }


}