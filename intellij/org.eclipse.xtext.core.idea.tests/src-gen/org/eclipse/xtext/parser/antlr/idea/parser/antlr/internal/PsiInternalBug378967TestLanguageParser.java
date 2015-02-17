package org.eclipse.xtext.parser.antlr.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug378967TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.services.Bug378967TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalBug378967TestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'1'", "'2'", "'3'", "'4'", "'after'", "'s'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=4;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalBug378967TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug378967TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug378967TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g"; }



    private Bug378967TestLanguageGrammarAccess grammarAccess;

    private Bug378967TestLanguageElementTypeProvider elementTypeProvider;

    public PsiInternalBug378967TestLanguageParser(PsiBuilder builder, TokenStream input, TokenTypeProvider tokenTypeProvider, Bug378967TestLanguageElementTypeProvider elementTypeProvider, Bug378967TestLanguageGrammarAccess grammarAccess) {
    	super(builder, input, tokenTypeProvider);
        this.grammarAccess = grammarAccess;
    	this.elementTypeProvider = elementTypeProvider;
    }

    @Override
    protected String getFirstRuleName() {
    	return "Root";
    }




    // $ANTLR start "entryRuleRoot"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:49:1: entryRuleRoot : ruleRoot EOF ;
    public final void entryRuleRoot() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:49:14: ( ruleRoot EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:50:2: ruleRoot EOF
            {
             markComposite(elementTypeProvider.getRootElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRoot_in_entryRuleRoot54);
            ruleRoot();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoot60); 

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
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:58:1: ruleRoot : ( (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) ) | (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) ) | (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) ) | (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) ) ) ;
    public final void ruleRoot() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:58:9: ( ( (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) ) | (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) ) | (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) ) | (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:59:2: ( (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) ) | (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) ) | (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) ) | (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:59:2: ( (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) ) | (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) ) | (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) ) | (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) ) )
            int alt1=4;
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
            case 13:
                {
                alt1=3;
                }
                break;
            case 14:
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:60:3: (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:60:3: (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:61:4: otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) )
                    {

                    				markLeaf();
                    			
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleRoot89); 

                    				doneLeaf(otherlv_0, elementTypeProvider.getRoot_DigitOneKeyword_0_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:68:4: ( (lv_element_1_0= ruleRule1 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:69:5: (lv_element_1_0= ruleRule1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:69:5: (lv_element_1_0= ruleRule1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:70:6: lv_element_1_0= ruleRule1
                    {

                    						markComposite(elementTypeProvider.getRoot_ElementRule1ParserRuleCall_0_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleRule1_in_ruleRoot121);
                    ruleRule1();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:81:3: (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:81:3: (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:82:4: otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) )
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleRoot167); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getRoot_DigitTwoKeyword_1_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:89:4: ( (lv_element_3_0= ruleRule2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:90:5: (lv_element_3_0= ruleRule2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:90:5: (lv_element_3_0= ruleRule2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:91:6: lv_element_3_0= ruleRule2
                    {

                    						markComposite(elementTypeProvider.getRoot_ElementRule2ParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleRule2_in_ruleRoot199);
                    ruleRule2();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:102:3: (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:102:3: (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:103:4: otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) )
                    {

                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleRoot245); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getRoot_DigitThreeKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:110:4: ( (lv_element_5_0= ruleRule3 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:111:5: (lv_element_5_0= ruleRule3 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:111:5: (lv_element_5_0= ruleRule3 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:112:6: lv_element_5_0= ruleRule3
                    {

                    						markComposite(elementTypeProvider.getRoot_ElementRule3ParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleRule3_in_ruleRoot277);
                    ruleRule3();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:123:3: (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:123:3: (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:124:4: otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) )
                    {

                    				markLeaf();
                    			
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleRoot323); 

                    				doneLeaf(otherlv_6, elementTypeProvider.getRoot_DigitFourKeyword_3_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:131:4: ( (lv_element_7_0= ruleRule4 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:132:5: (lv_element_7_0= ruleRule4 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:132:5: (lv_element_7_0= ruleRule4 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:133:6: lv_element_7_0= ruleRule4
                    {

                    						markComposite(elementTypeProvider.getRoot_ElementRule4ParserRuleCall_3_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleRule4_in_ruleRoot355);
                    ruleRule4();

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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleRule1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:147:1: entryRuleRule1 : ruleRule1 EOF ;
    public final void entryRuleRule1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:147:15: ( ruleRule1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:148:2: ruleRule1 EOF
            {
             markComposite(elementTypeProvider.getRule1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRule1_in_entryRuleRule1393);
            ruleRule1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRule1399); 

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
    // $ANTLR end "entryRuleRule1"


    // $ANTLR start "ruleRule1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:156:1: ruleRule1 : ( ( (lv_type_0_0= ruleFirstEnum ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleSecondEnum ) ) ) ;
    public final void ruleRule1() throws RecognitionException {
        Token lv_value_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:156:10: ( ( ( (lv_type_0_0= ruleFirstEnum ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleSecondEnum ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:157:2: ( ( (lv_type_0_0= ruleFirstEnum ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleSecondEnum ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:157:2: ( ( (lv_type_0_0= ruleFirstEnum ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleSecondEnum ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:158:3: ( (lv_type_0_0= ruleFirstEnum ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleSecondEnum ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:158:3: ( (lv_type_0_0= ruleFirstEnum ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:159:4: (lv_type_0_0= ruleFirstEnum )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:159:4: (lv_type_0_0= ruleFirstEnum )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:160:5: lv_type_0_0= ruleFirstEnum
            {

            					markComposite(elementTypeProvider.getRule1_TypeFirstEnumEnumRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleFirstEnum_in_ruleRule1435);
            ruleFirstEnum();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:169:3: ( (lv_value_1_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:170:4: (lv_value_1_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:170:4: (lv_value_1_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:171:5: lv_value_1_0= RULE_INT
            {

            					markLeaf();
            				
            lv_value_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleRule1473); 

            					doneLeaf(lv_value_1_0, elementTypeProvider.getRule1_ValueINTTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:180:3: ( (lv_unit_2_0= ruleSecondEnum ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:181:4: (lv_unit_2_0= ruleSecondEnum )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:181:4: (lv_unit_2_0= ruleSecondEnum )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:182:5: lv_unit_2_0= ruleSecondEnum
            {

            					markComposite(elementTypeProvider.getRule1_UnitSecondEnumEnumRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleSecondEnum_in_ruleRule1511);
            ruleSecondEnum();

            state._fsp--;


            					doneComposite();
            				

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
        return ;
    }
    // $ANTLR end "ruleRule1"


    // $ANTLR start "entryRuleRule2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:195:1: entryRuleRule2 : ruleRule2 EOF ;
    public final void entryRuleRule2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:195:15: ( ruleRule2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:196:2: ruleRule2 EOF
            {
             markComposite(elementTypeProvider.getRule2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRule2_in_entryRuleRule2542);
            ruleRule2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRule2548); 

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
    // $ANTLR end "entryRuleRule2"


    // $ANTLR start "ruleRule2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:204:1: ruleRule2 : (otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= 's' ) ;
    public final void ruleRule2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:204:10: ( (otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= 's' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:205:2: (otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= 's' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:205:2: (otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= 's' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:206:3: otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= 's'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleRule2571); 

            			doneLeaf(otherlv_0, elementTypeProvider.getRule2_AfterKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:213:3: ( (lv_value_1_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:214:4: (lv_value_1_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:214:4: (lv_value_1_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:215:5: lv_value_1_0= RULE_INT
            {

            					markLeaf();
            				
            lv_value_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleRule2598); 

            					doneLeaf(lv_value_1_0, elementTypeProvider.getRule2_ValueINTTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleRule2623); 

            			doneLeaf(otherlv_2, elementTypeProvider.getRule2_SKeyword_2ElementType());
            		

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
    // $ANTLR end "ruleRule2"


    // $ANTLR start "entryRuleRule3"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:235:1: entryRuleRule3 : ruleRule3 EOF ;
    public final void entryRuleRule3() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:235:15: ( ruleRule3 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:236:2: ruleRule3 EOF
            {
             markComposite(elementTypeProvider.getRule3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRule3_in_entryRuleRule3643);
            ruleRule3();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRule3649); 

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
    // $ANTLR end "entryRuleRule3"


    // $ANTLR start "ruleRule3"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:244:1: ruleRule3 : ( ruleAfter ( (lv_value_1_0= RULE_INT ) ) ruleS ) ;
    public final void ruleRule3() throws RecognitionException {
        Token lv_value_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:244:10: ( ( ruleAfter ( (lv_value_1_0= RULE_INT ) ) ruleS ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:245:2: ( ruleAfter ( (lv_value_1_0= RULE_INT ) ) ruleS )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:245:2: ( ruleAfter ( (lv_value_1_0= RULE_INT ) ) ruleS )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:246:3: ruleAfter ( (lv_value_1_0= RULE_INT ) ) ruleS
            {

            			markComposite(elementTypeProvider.getRule3_AfterParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleAfter_in_ruleRule3670);
            ruleAfter();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:253:3: ( (lv_value_1_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:254:4: (lv_value_1_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:254:4: (lv_value_1_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:255:5: lv_value_1_0= RULE_INT
            {

            					markLeaf();
            				
            lv_value_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleRule3697); 

            					doneLeaf(lv_value_1_0, elementTypeProvider.getRule3_ValueINTTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markComposite(elementTypeProvider.getRule3_SParserRuleCall_2ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleS_in_ruleRule3720);
            ruleS();

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
    // $ANTLR end "ruleRule3"


    // $ANTLR start "entryRuleRule4"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:275:1: entryRuleRule4 : ruleRule4 EOF ;
    public final void entryRuleRule4() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:275:15: ( ruleRule4 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:276:2: ruleRule4 EOF
            {
             markComposite(elementTypeProvider.getRule4ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRule4_in_entryRuleRule4740);
            ruleRule4();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRule4746); 

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
    // $ANTLR end "entryRuleRule4"


    // $ANTLR start "ruleRule4"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:284:1: ruleRule4 : ( ( (lv_after_0_0= ruleAfterObj ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_s_2_0= ruleSObj ) ) ) ;
    public final void ruleRule4() throws RecognitionException {
        Token lv_value_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:284:10: ( ( ( (lv_after_0_0= ruleAfterObj ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_s_2_0= ruleSObj ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:285:2: ( ( (lv_after_0_0= ruleAfterObj ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_s_2_0= ruleSObj ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:285:2: ( ( (lv_after_0_0= ruleAfterObj ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_s_2_0= ruleSObj ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:286:3: ( (lv_after_0_0= ruleAfterObj ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_s_2_0= ruleSObj ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:286:3: ( (lv_after_0_0= ruleAfterObj ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:287:4: (lv_after_0_0= ruleAfterObj )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:287:4: (lv_after_0_0= ruleAfterObj )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:288:5: lv_after_0_0= ruleAfterObj
            {

            					markComposite(elementTypeProvider.getRule4_AfterAfterObjParserRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleAfterObj_in_ruleRule4782);
            ruleAfterObj();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:297:3: ( (lv_value_1_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:298:4: (lv_value_1_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:298:4: (lv_value_1_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:299:5: lv_value_1_0= RULE_INT
            {

            					markLeaf();
            				
            lv_value_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleRule4820); 

            					doneLeaf(lv_value_1_0, elementTypeProvider.getRule4_ValueINTTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:308:3: ( (lv_s_2_0= ruleSObj ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:309:4: (lv_s_2_0= ruleSObj )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:309:4: (lv_s_2_0= ruleSObj )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:310:5: lv_s_2_0= ruleSObj
            {

            					markComposite(elementTypeProvider.getRule4_SSObjParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleSObj_in_ruleRule4858);
            ruleSObj();

            state._fsp--;


            					doneComposite();
            				

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
        return ;
    }
    // $ANTLR end "ruleRule4"


    // $ANTLR start "entryRuleAfterObj"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:323:1: entryRuleAfterObj : ruleAfterObj EOF ;
    public final void entryRuleAfterObj() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:323:18: ( ruleAfterObj EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:324:2: ruleAfterObj EOF
            {
             markComposite(elementTypeProvider.getAfterObjElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAfterObj_in_entryRuleAfterObj889);
            ruleAfterObj();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAfterObj895); 

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
    // $ANTLR end "entryRuleAfterObj"


    // $ANTLR start "ruleAfterObj"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:332:1: ruleAfterObj : ( (lv_value_0_0= 'after' ) ) ;
    public final void ruleAfterObj() throws RecognitionException {
        Token lv_value_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:332:13: ( ( (lv_value_0_0= 'after' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:333:2: ( (lv_value_0_0= 'after' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:333:2: ( (lv_value_0_0= 'after' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:334:3: (lv_value_0_0= 'after' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:334:3: (lv_value_0_0= 'after' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:335:4: lv_value_0_0= 'after'
            {

            				markLeaf();
            			
            lv_value_0_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleAfterObj924); 

            				doneLeaf(lv_value_0_0, elementTypeProvider.getAfterObj_ValueAfterKeyword_0ElementType());
            			

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
    // $ANTLR end "ruleAfterObj"


    // $ANTLR start "entryRuleSObj"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:347:1: entryRuleSObj : ruleSObj EOF ;
    public final void entryRuleSObj() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:347:14: ( ruleSObj EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:348:2: ruleSObj EOF
            {
             markComposite(elementTypeProvider.getSObjElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSObj_in_entryRuleSObj949);
            ruleSObj();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSObj955); 

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
    // $ANTLR end "entryRuleSObj"


    // $ANTLR start "ruleSObj"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:356:1: ruleSObj : ( (lv_value_0_0= 's' ) ) ;
    public final void ruleSObj() throws RecognitionException {
        Token lv_value_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:356:9: ( ( (lv_value_0_0= 's' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:357:2: ( (lv_value_0_0= 's' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:357:2: ( (lv_value_0_0= 's' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:358:3: (lv_value_0_0= 's' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:358:3: (lv_value_0_0= 's' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:359:4: lv_value_0_0= 's'
            {

            				markLeaf();
            			
            lv_value_0_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSObj984); 

            				doneLeaf(lv_value_0_0, elementTypeProvider.getSObj_ValueSKeyword_0ElementType());
            			

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
    // $ANTLR end "ruleSObj"


    // $ANTLR start "entryRuleAfter"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:371:1: entryRuleAfter : ruleAfter EOF ;
    public final void entryRuleAfter() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:371:15: ( ruleAfter EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:372:2: ruleAfter EOF
            {
             markComposite(elementTypeProvider.getAfterElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAfter_in_entryRuleAfter1009);
            ruleAfter();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAfter1015); 

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
    // $ANTLR end "entryRuleAfter"


    // $ANTLR start "ruleAfter"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:380:1: ruleAfter : kw= 'after' ;
    public final void ruleAfter() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:380:10: (kw= 'after' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:381:2: kw= 'after'
            {

            		markLeaf();
            	
            kw=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleAfter1033); 

            		doneLeaf(kw, elementTypeProvider.getAfter_AfterKeywordElementType());
            	

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
    // $ANTLR end "ruleAfter"


    // $ANTLR start "entryRuleS"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:391:1: entryRuleS : ruleS EOF ;
    public final void entryRuleS() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:391:11: ( ruleS EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:392:2: ruleS EOF
            {
             markComposite(elementTypeProvider.getSElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleS_in_entryRuleS1049);
            ruleS();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleS1055); 

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
    // $ANTLR end "entryRuleS"


    // $ANTLR start "ruleS"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:400:1: ruleS : kw= 's' ;
    public final void ruleS() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:400:6: (kw= 's' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:401:2: kw= 's'
            {

            		markLeaf();
            	
            kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleS1073); 

            		doneLeaf(kw, elementTypeProvider.getS_SKeywordElementType());
            	

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
    // $ANTLR end "ruleS"


    // $ANTLR start "ruleFirstEnum"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:411:1: ruleFirstEnum : (enumLiteral_0= 'after' ) ;
    public final void ruleFirstEnum() throws RecognitionException {
        Token enumLiteral_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:411:14: ( (enumLiteral_0= 'after' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:412:2: (enumLiteral_0= 'after' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:412:2: (enumLiteral_0= 'after' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:413:3: enumLiteral_0= 'after'
            {

            			markLeaf();
            		
            enumLiteral_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleFirstEnum1096); 

            			doneLeaf(enumLiteral_0, elementTypeProvider.getFirstEnum_ValueEnumLiteralDeclarationElementType());
            		

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
    // $ANTLR end "ruleFirstEnum"


    // $ANTLR start "ruleSecondEnum"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:424:1: ruleSecondEnum : (enumLiteral_0= 's' ) ;
    public final void ruleSecondEnum() throws RecognitionException {
        Token enumLiteral_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:424:15: ( (enumLiteral_0= 's' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:425:2: (enumLiteral_0= 's' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:425:2: (enumLiteral_0= 's' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:426:3: enumLiteral_0= 's'
            {

            			markLeaf();
            		
            enumLiteral_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSecondEnum1123); 

            			doneLeaf(enumLiteral_0, elementTypeProvider.getSecondEnum_ValueEnumLiteralDeclarationElementType());
            		

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
    // $ANTLR end "ruleSecondEnum"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleRoot89 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleRule1_in_ruleRoot121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleRoot167 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleRule2_in_ruleRoot199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleRoot245 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleRule3_in_ruleRoot277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleRoot323 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleRule4_in_ruleRoot355 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRule1_in_entryRuleRule1393 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRule1399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstEnum_in_ruleRule1435 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleRule1473 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_ruleSecondEnum_in_ruleRule1511 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRule2_in_entryRuleRule2542 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRule2548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleRule2571 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleRule2598 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleRule2623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRule3_in_entryRuleRule3643 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRule3649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAfter_in_ruleRule3670 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleRule3697 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_ruleS_in_ruleRule3720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRule4_in_entryRuleRule4740 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRule4746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAfterObj_in_ruleRule4782 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleRule4820 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_ruleSObj_in_ruleRule4858 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAfterObj_in_entryRuleAfterObj889 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAfterObj895 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleAfterObj924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSObj_in_entryRuleSObj949 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSObj955 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleSObj984 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAfter_in_entryRuleAfter1009 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAfter1015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleAfter1033 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleS_in_entryRuleS1049 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleS1055 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleS1073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleFirstEnum1096 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleSecondEnum1123 = new BitSet(new long[]{0x0000000000000002L});
    }


}