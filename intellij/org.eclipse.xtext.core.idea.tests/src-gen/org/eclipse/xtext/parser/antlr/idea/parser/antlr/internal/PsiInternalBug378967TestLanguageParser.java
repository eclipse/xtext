package org.eclipse.xtext.parser.antlr.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug378967TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
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



    	protected Bug378967TestLanguageGrammarAccess grammarAccess;

    	protected Bug378967TestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalBug378967TestLanguageParser(PsiBuilder builder, TokenStream input, Bug378967TestLanguageElementTypeProvider elementTypeProvider, Bug378967TestLanguageGrammarAccess grammarAccess) {
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:52:1: entryRuleRoot : ruleRoot EOF ;
    public final void entryRuleRoot() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:52:14: ( ruleRoot EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:53:2: ruleRoot EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:59:1: ruleRoot : ( (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) ) | (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) ) | (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) ) | (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) ) ) ;
    public final void ruleRoot() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:59:9: ( ( (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) ) | (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) ) | (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) ) | (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:60:2: ( (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) ) | (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) ) | (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) ) | (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:60:2: ( (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) ) | (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) ) | (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) ) | (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:61:3: (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:61:3: (otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:62:4: otherlv_0= '1' ( (lv_element_1_0= ruleRule1 ) )
                    {

                    				markLeaf();
                    			
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleRoot85); 

                    				doneLeaf(otherlv_0, elementTypeProvider.getRoot_DigitOneKeyword_0_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:69:4: ( (lv_element_1_0= ruleRule1 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:70:5: (lv_element_1_0= ruleRule1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:70:5: (lv_element_1_0= ruleRule1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:71:6: lv_element_1_0= ruleRule1
                    {

                    						markComposite(elementTypeProvider.getRoot_ElementRule1ParserRuleCall_0_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleRule1_in_ruleRoot117);
                    ruleRule1();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:82:3: (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:82:3: (otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:83:4: otherlv_2= '2' ( (lv_element_3_0= ruleRule2 ) )
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleRoot163); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getRoot_DigitTwoKeyword_1_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:90:4: ( (lv_element_3_0= ruleRule2 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:91:5: (lv_element_3_0= ruleRule2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:91:5: (lv_element_3_0= ruleRule2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:92:6: lv_element_3_0= ruleRule2
                    {

                    						markComposite(elementTypeProvider.getRoot_ElementRule2ParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleRule2_in_ruleRoot195);
                    ruleRule2();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:103:3: (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:103:3: (otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:104:4: otherlv_4= '3' ( (lv_element_5_0= ruleRule3 ) )
                    {

                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleRoot241); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getRoot_DigitThreeKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:111:4: ( (lv_element_5_0= ruleRule3 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:112:5: (lv_element_5_0= ruleRule3 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:112:5: (lv_element_5_0= ruleRule3 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:113:6: lv_element_5_0= ruleRule3
                    {

                    						markComposite(elementTypeProvider.getRoot_ElementRule3ParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleRule3_in_ruleRoot273);
                    ruleRule3();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:124:3: (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:124:3: (otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:125:4: otherlv_6= '4' ( (lv_element_7_0= ruleRule4 ) )
                    {

                    				markLeaf();
                    			
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleRoot319); 

                    				doneLeaf(otherlv_6, elementTypeProvider.getRoot_DigitFourKeyword_3_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:132:4: ( (lv_element_7_0= ruleRule4 ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:133:5: (lv_element_7_0= ruleRule4 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:133:5: (lv_element_7_0= ruleRule4 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:134:6: lv_element_7_0= ruleRule4
                    {

                    						markComposite(elementTypeProvider.getRoot_ElementRule4ParserRuleCall_3_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleRule4_in_ruleRoot351);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:148:1: entryRuleRule1 : ruleRule1 EOF ;
    public final void entryRuleRule1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:148:15: ( ruleRule1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:149:2: ruleRule1 EOF
            {
             markComposite(elementTypeProvider.getRule1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRule1_in_entryRuleRule1389);
            ruleRule1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRule1395); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:155:1: ruleRule1 : ( ( (lv_type_0_0= ruleFirstEnum ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleSecondEnum ) ) ) ;
    public final void ruleRule1() throws RecognitionException {
        Token lv_value_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:155:10: ( ( ( (lv_type_0_0= ruleFirstEnum ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleSecondEnum ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:156:2: ( ( (lv_type_0_0= ruleFirstEnum ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleSecondEnum ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:156:2: ( ( (lv_type_0_0= ruleFirstEnum ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleSecondEnum ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:157:3: ( (lv_type_0_0= ruleFirstEnum ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_unit_2_0= ruleSecondEnum ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:157:3: ( (lv_type_0_0= ruleFirstEnum ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:158:4: (lv_type_0_0= ruleFirstEnum )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:158:4: (lv_type_0_0= ruleFirstEnum )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:159:5: lv_type_0_0= ruleFirstEnum
            {

            					markComposite(elementTypeProvider.getRule1_TypeFirstEnumEnumRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleFirstEnum_in_ruleRule1427);
            ruleFirstEnum();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:168:3: ( (lv_value_1_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:169:4: (lv_value_1_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:169:4: (lv_value_1_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:170:5: lv_value_1_0= RULE_INT
            {

            					markLeaf();
            				
            lv_value_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleRule1465); 

            					doneLeaf(lv_value_1_0, elementTypeProvider.getRule1_ValueINTTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:179:3: ( (lv_unit_2_0= ruleSecondEnum ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:180:4: (lv_unit_2_0= ruleSecondEnum )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:180:4: (lv_unit_2_0= ruleSecondEnum )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:181:5: lv_unit_2_0= ruleSecondEnum
            {

            					markComposite(elementTypeProvider.getRule1_UnitSecondEnumEnumRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleSecondEnum_in_ruleRule1503);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:194:1: entryRuleRule2 : ruleRule2 EOF ;
    public final void entryRuleRule2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:194:15: ( ruleRule2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:195:2: ruleRule2 EOF
            {
             markComposite(elementTypeProvider.getRule2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRule2_in_entryRuleRule2534);
            ruleRule2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRule2540); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:201:1: ruleRule2 : (otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= 's' ) ;
    public final void ruleRule2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:201:10: ( (otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= 's' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:202:2: (otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= 's' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:202:2: (otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= 's' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:203:3: otherlv_0= 'after' ( (lv_value_1_0= RULE_INT ) ) otherlv_2= 's'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleRule2559); 

            			doneLeaf(otherlv_0, elementTypeProvider.getRule2_AfterKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:210:3: ( (lv_value_1_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:211:4: (lv_value_1_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:211:4: (lv_value_1_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:212:5: lv_value_1_0= RULE_INT
            {

            					markLeaf();
            				
            lv_value_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleRule2586); 

            					doneLeaf(lv_value_1_0, elementTypeProvider.getRule2_ValueINTTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleRule2611); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:232:1: entryRuleRule3 : ruleRule3 EOF ;
    public final void entryRuleRule3() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:232:15: ( ruleRule3 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:233:2: ruleRule3 EOF
            {
             markComposite(elementTypeProvider.getRule3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRule3_in_entryRuleRule3631);
            ruleRule3();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRule3637); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:239:1: ruleRule3 : ( ruleAfter ( (lv_value_1_0= RULE_INT ) ) ruleS ) ;
    public final void ruleRule3() throws RecognitionException {
        Token lv_value_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:239:10: ( ( ruleAfter ( (lv_value_1_0= RULE_INT ) ) ruleS ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:240:2: ( ruleAfter ( (lv_value_1_0= RULE_INT ) ) ruleS )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:240:2: ( ruleAfter ( (lv_value_1_0= RULE_INT ) ) ruleS )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:241:3: ruleAfter ( (lv_value_1_0= RULE_INT ) ) ruleS
            {

            			markComposite(elementTypeProvider.getRule3_AfterParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleAfter_in_ruleRule3654);
            ruleAfter();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:248:3: ( (lv_value_1_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:249:4: (lv_value_1_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:249:4: (lv_value_1_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:250:5: lv_value_1_0= RULE_INT
            {

            					markLeaf();
            				
            lv_value_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleRule3681); 

            					doneLeaf(lv_value_1_0, elementTypeProvider.getRule3_ValueINTTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markComposite(elementTypeProvider.getRule3_SParserRuleCall_2ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleS_in_ruleRule3704);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:270:1: entryRuleRule4 : ruleRule4 EOF ;
    public final void entryRuleRule4() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:270:15: ( ruleRule4 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:271:2: ruleRule4 EOF
            {
             markComposite(elementTypeProvider.getRule4ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRule4_in_entryRuleRule4724);
            ruleRule4();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRule4730); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:277:1: ruleRule4 : ( ( (lv_after_0_0= ruleAfterObj ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_s_2_0= ruleSObj ) ) ) ;
    public final void ruleRule4() throws RecognitionException {
        Token lv_value_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:277:10: ( ( ( (lv_after_0_0= ruleAfterObj ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_s_2_0= ruleSObj ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:278:2: ( ( (lv_after_0_0= ruleAfterObj ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_s_2_0= ruleSObj ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:278:2: ( ( (lv_after_0_0= ruleAfterObj ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_s_2_0= ruleSObj ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:279:3: ( (lv_after_0_0= ruleAfterObj ) ) ( (lv_value_1_0= RULE_INT ) ) ( (lv_s_2_0= ruleSObj ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:279:3: ( (lv_after_0_0= ruleAfterObj ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:280:4: (lv_after_0_0= ruleAfterObj )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:280:4: (lv_after_0_0= ruleAfterObj )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:281:5: lv_after_0_0= ruleAfterObj
            {

            					markComposite(elementTypeProvider.getRule4_AfterAfterObjParserRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleAfterObj_in_ruleRule4762);
            ruleAfterObj();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:290:3: ( (lv_value_1_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:291:4: (lv_value_1_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:291:4: (lv_value_1_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:292:5: lv_value_1_0= RULE_INT
            {

            					markLeaf();
            				
            lv_value_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleRule4800); 

            					doneLeaf(lv_value_1_0, elementTypeProvider.getRule4_ValueINTTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:301:3: ( (lv_s_2_0= ruleSObj ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:302:4: (lv_s_2_0= ruleSObj )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:302:4: (lv_s_2_0= ruleSObj )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:303:5: lv_s_2_0= ruleSObj
            {

            					markComposite(elementTypeProvider.getRule4_SSObjParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleSObj_in_ruleRule4838);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:316:1: entryRuleAfterObj : ruleAfterObj EOF ;
    public final void entryRuleAfterObj() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:316:18: ( ruleAfterObj EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:317:2: ruleAfterObj EOF
            {
             markComposite(elementTypeProvider.getAfterObjElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAfterObj_in_entryRuleAfterObj869);
            ruleAfterObj();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAfterObj875); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:323:1: ruleAfterObj : ( (lv_value_0_0= 'after' ) ) ;
    public final void ruleAfterObj() throws RecognitionException {
        Token lv_value_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:323:13: ( ( (lv_value_0_0= 'after' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:324:2: ( (lv_value_0_0= 'after' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:324:2: ( (lv_value_0_0= 'after' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:325:3: (lv_value_0_0= 'after' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:325:3: (lv_value_0_0= 'after' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:326:4: lv_value_0_0= 'after'
            {

            				markLeaf();
            			
            lv_value_0_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleAfterObj900); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:338:1: entryRuleSObj : ruleSObj EOF ;
    public final void entryRuleSObj() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:338:14: ( ruleSObj EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:339:2: ruleSObj EOF
            {
             markComposite(elementTypeProvider.getSObjElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSObj_in_entryRuleSObj925);
            ruleSObj();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSObj931); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:345:1: ruleSObj : ( (lv_value_0_0= 's' ) ) ;
    public final void ruleSObj() throws RecognitionException {
        Token lv_value_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:345:9: ( ( (lv_value_0_0= 's' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:346:2: ( (lv_value_0_0= 's' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:346:2: ( (lv_value_0_0= 's' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:347:3: (lv_value_0_0= 's' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:347:3: (lv_value_0_0= 's' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:348:4: lv_value_0_0= 's'
            {

            				markLeaf();
            			
            lv_value_0_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSObj956); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:360:1: entryRuleAfter : ruleAfter EOF ;
    public final void entryRuleAfter() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:360:15: ( ruleAfter EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:361:2: ruleAfter EOF
            {
             markComposite(elementTypeProvider.getAfterElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAfter_in_entryRuleAfter981);
            ruleAfter();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAfter987); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:367:1: ruleAfter : kw= 'after' ;
    public final void ruleAfter() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:367:10: (kw= 'after' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:368:2: kw= 'after'
            {

            		markLeaf();
            	
            kw=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleAfter1001); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:378:1: entryRuleS : ruleS EOF ;
    public final void entryRuleS() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:378:11: ( ruleS EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:379:2: ruleS EOF
            {
             markComposite(elementTypeProvider.getSElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleS_in_entryRuleS1017);
            ruleS();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleS1023); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:385:1: ruleS : kw= 's' ;
    public final void ruleS() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:385:6: (kw= 's' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:386:2: kw= 's'
            {

            		markLeaf();
            	
            kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleS1037); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:396:1: ruleFirstEnum : (enumLiteral_0= 'after' ) ;
    public final void ruleFirstEnum() throws RecognitionException {
        Token enumLiteral_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:396:14: ( (enumLiteral_0= 'after' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:397:2: (enumLiteral_0= 'after' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:397:2: (enumLiteral_0= 'after' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:398:3: enumLiteral_0= 'after'
            {

            			markLeaf();
            		
            enumLiteral_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleFirstEnum1060); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:409:1: ruleSecondEnum : (enumLiteral_0= 's' ) ;
    public final void ruleSecondEnum() throws RecognitionException {
        Token enumLiteral_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:409:15: ( (enumLiteral_0= 's' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:410:2: (enumLiteral_0= 's' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:410:2: (enumLiteral_0= 's' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug378967TestLanguage.g:411:3: enumLiteral_0= 's'
            {

            			markLeaf();
            		
            enumLiteral_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSecondEnum1087); 

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
        public static final BitSet FOLLOW_11_in_ruleRoot85 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleRule1_in_ruleRoot117 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleRoot163 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleRule2_in_ruleRoot195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleRoot241 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleRule3_in_ruleRoot273 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleRoot319 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleRule4_in_ruleRoot351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRule1_in_entryRuleRule1389 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRule1395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstEnum_in_ruleRule1427 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleRule1465 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_ruleSecondEnum_in_ruleRule1503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRule2_in_entryRuleRule2534 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRule2540 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleRule2559 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleRule2586 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleRule2611 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRule3_in_entryRuleRule3631 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRule3637 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAfter_in_ruleRule3654 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleRule3681 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_ruleS_in_ruleRule3704 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRule4_in_entryRuleRule4724 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRule4730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAfterObj_in_ruleRule4762 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleRule4800 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_ruleSObj_in_ruleRule4838 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAfterObj_in_entryRuleAfterObj869 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAfterObj875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleAfterObj900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSObj_in_entryRuleSObj925 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSObj931 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleSObj956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAfter_in_entryRuleAfter981 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAfter987 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleAfter1001 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleS_in_entryRuleS1017 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleS1023 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleS1037 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleFirstEnum1060 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleSecondEnum1087 = new BitSet(new long[]{0x0000000000000002L});
    }


}