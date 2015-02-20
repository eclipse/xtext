package org.eclipse.xtext.parser.antlr.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289515TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.services.Bug289515TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalBug289515TestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'1'", "'%'", "'2'", "'3'", "'\\\\%'", "'4'", "'5'", "'%%'", "'6'"
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
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalBug289515TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug289515TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug289515TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g"; }



    	protected Bug289515TestLanguageGrammarAccess grammarAccess;

    	protected Bug289515TestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalBug289515TestLanguageParser(PsiBuilder builder, TokenStream input, Bug289515TestLanguageElementTypeProvider elementTypeProvider, Bug289515TestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Model";
    	}




    // $ANTLR start "entryRuleModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:52:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:53:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel54);
            ruleModel();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel60); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:59:1: ruleModel : ( (otherlv_0= '1' ( (lv_value_1_0= '%' ) ) ) | (otherlv_2= '2' ( (lv_value_3_0= '%' ) ) ) | (otherlv_4= '3' ( (lv_value_5_0= '\\\\%' ) ) ) | (otherlv_6= '4' ( (lv_value_7_0= '\\\\%' ) ) ) | (otherlv_8= '5' ( (lv_value_9_0= '%%' ) ) ) | (otherlv_10= '6' ( (lv_value_11_0= '%%' ) ) ) ) ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;
        Token otherlv_4=null;
        Token lv_value_5_0=null;
        Token otherlv_6=null;
        Token lv_value_7_0=null;
        Token otherlv_8=null;
        Token lv_value_9_0=null;
        Token otherlv_10=null;
        Token lv_value_11_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:59:10: ( ( (otherlv_0= '1' ( (lv_value_1_0= '%' ) ) ) | (otherlv_2= '2' ( (lv_value_3_0= '%' ) ) ) | (otherlv_4= '3' ( (lv_value_5_0= '\\\\%' ) ) ) | (otherlv_6= '4' ( (lv_value_7_0= '\\\\%' ) ) ) | (otherlv_8= '5' ( (lv_value_9_0= '%%' ) ) ) | (otherlv_10= '6' ( (lv_value_11_0= '%%' ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:60:2: ( (otherlv_0= '1' ( (lv_value_1_0= '%' ) ) ) | (otherlv_2= '2' ( (lv_value_3_0= '%' ) ) ) | (otherlv_4= '3' ( (lv_value_5_0= '\\\\%' ) ) ) | (otherlv_6= '4' ( (lv_value_7_0= '\\\\%' ) ) ) | (otherlv_8= '5' ( (lv_value_9_0= '%%' ) ) ) | (otherlv_10= '6' ( (lv_value_11_0= '%%' ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:60:2: ( (otherlv_0= '1' ( (lv_value_1_0= '%' ) ) ) | (otherlv_2= '2' ( (lv_value_3_0= '%' ) ) ) | (otherlv_4= '3' ( (lv_value_5_0= '\\\\%' ) ) ) | (otherlv_6= '4' ( (lv_value_7_0= '\\\\%' ) ) ) | (otherlv_8= '5' ( (lv_value_9_0= '%%' ) ) ) | (otherlv_10= '6' ( (lv_value_11_0= '%%' ) ) ) )
            int alt1=6;
            switch ( input.LA(1) ) {
            case 11:
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
            case 16:
                {
                alt1=4;
                }
                break;
            case 17:
                {
                alt1=5;
                }
                break;
            case 19:
                {
                alt1=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:61:3: (otherlv_0= '1' ( (lv_value_1_0= '%' ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:61:3: (otherlv_0= '1' ( (lv_value_1_0= '%' ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:62:4: otherlv_0= '1' ( (lv_value_1_0= '%' ) )
                    {

                    				markLeaf();
                    			
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel85); 

                    				doneLeaf(otherlv_0, elementTypeProvider.getModel_DigitOneKeyword_0_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:69:4: ( (lv_value_1_0= '%' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:70:5: (lv_value_1_0= '%' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:70:5: (lv_value_1_0= '%' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:71:6: lv_value_1_0= '%'
                    {

                    						markLeaf();
                    					
                    lv_value_1_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel117); 

                    						doneLeaf(lv_value_1_0, elementTypeProvider.getModel_ValuePercentSignKeyword_0_1_0ElementType());
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:82:3: (otherlv_2= '2' ( (lv_value_3_0= '%' ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:82:3: (otherlv_2= '2' ( (lv_value_3_0= '%' ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:83:4: otherlv_2= '2' ( (lv_value_3_0= '%' ) )
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel163); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getModel_DigitTwoKeyword_1_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:90:4: ( (lv_value_3_0= '%' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:91:5: (lv_value_3_0= '%' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:91:5: (lv_value_3_0= '%' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:92:6: lv_value_3_0= '%'
                    {

                    						markLeaf();
                    					
                    lv_value_3_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel195); 

                    						doneLeaf(lv_value_3_0, elementTypeProvider.getModel_ValuePercentSignKeyword_1_1_0ElementType());
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:103:3: (otherlv_4= '3' ( (lv_value_5_0= '\\\\%' ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:103:3: (otherlv_4= '3' ( (lv_value_5_0= '\\\\%' ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:104:4: otherlv_4= '3' ( (lv_value_5_0= '\\\\%' ) )
                    {

                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModel241); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getModel_DigitThreeKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:111:4: ( (lv_value_5_0= '\\\\%' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:112:5: (lv_value_5_0= '\\\\%' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:112:5: (lv_value_5_0= '\\\\%' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:113:6: lv_value_5_0= '\\\\%'
                    {

                    						markLeaf();
                    					
                    lv_value_5_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModel273); 

                    						doneLeaf(lv_value_5_0, elementTypeProvider.getModel_ValueReverseSolidusPercentSignKeyword_2_1_0ElementType());
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:124:3: (otherlv_6= '4' ( (lv_value_7_0= '\\\\%' ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:124:3: (otherlv_6= '4' ( (lv_value_7_0= '\\\\%' ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:125:4: otherlv_6= '4' ( (lv_value_7_0= '\\\\%' ) )
                    {

                    				markLeaf();
                    			
                    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleModel319); 

                    				doneLeaf(otherlv_6, elementTypeProvider.getModel_DigitFourKeyword_3_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:132:4: ( (lv_value_7_0= '\\\\%' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:133:5: (lv_value_7_0= '\\\\%' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:133:5: (lv_value_7_0= '\\\\%' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:134:6: lv_value_7_0= '\\\\%'
                    {

                    						markLeaf();
                    					
                    lv_value_7_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModel351); 

                    						doneLeaf(lv_value_7_0, elementTypeProvider.getModel_ValueReverseSolidusPercentSignKeyword_3_1_0ElementType());
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:145:3: (otherlv_8= '5' ( (lv_value_9_0= '%%' ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:145:3: (otherlv_8= '5' ( (lv_value_9_0= '%%' ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:146:4: otherlv_8= '5' ( (lv_value_9_0= '%%' ) )
                    {

                    				markLeaf();
                    			
                    otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModel397); 

                    				doneLeaf(otherlv_8, elementTypeProvider.getModel_DigitFiveKeyword_4_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:153:4: ( (lv_value_9_0= '%%' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:154:5: (lv_value_9_0= '%%' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:154:5: (lv_value_9_0= '%%' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:155:6: lv_value_9_0= '%%'
                    {

                    						markLeaf();
                    					
                    lv_value_9_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleModel429); 

                    						doneLeaf(lv_value_9_0, elementTypeProvider.getModel_ValuePercentSignPercentSignKeyword_4_1_0ElementType());
                    					

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:166:3: (otherlv_10= '6' ( (lv_value_11_0= '%%' ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:166:3: (otherlv_10= '6' ( (lv_value_11_0= '%%' ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:167:4: otherlv_10= '6' ( (lv_value_11_0= '%%' ) )
                    {

                    				markLeaf();
                    			
                    otherlv_10=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleModel475); 

                    				doneLeaf(otherlv_10, elementTypeProvider.getModel_DigitSixKeyword_5_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:174:4: ( (lv_value_11_0= '%%' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:175:5: (lv_value_11_0= '%%' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:175:5: (lv_value_11_0= '%%' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug289515TestLanguage.g:176:6: lv_value_11_0= '%%'
                    {

                    						markLeaf();
                    					
                    lv_value_11_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleModel507); 

                    						doneLeaf(lv_value_11_0, elementTypeProvider.getModel_ValuePercentSignPercentSignKeyword_5_1_0ElementType());
                    					

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
    // $ANTLR end "ruleModel"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel85 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel117 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleModel163 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModel195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleModel241 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleModel273 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleModel319 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleModel351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleModel397 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleModel429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleModel475 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleModel507 = new BitSet(new long[]{0x0000000000000002L});
    }


}