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
    public String getGrammarFileName() { return "PsiInternalBug289515TestLanguage.g"; }



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
    // PsiInternalBug289515TestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalBug289515TestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalBug289515TestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalBug289515TestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( (otherlv_0= '1' ( (lv_value_1_0= '%' ) ) ) | (otherlv_2= '2' ( (lv_value_3_0= '%' ) ) ) | (otherlv_4= '3' ( (lv_value_5_0= '\\\\%' ) ) ) | (otherlv_6= '4' ( (lv_value_7_0= '\\\\%' ) ) ) | (otherlv_8= '5' ( (lv_value_9_0= '%%' ) ) ) | (otherlv_10= '6' ( (lv_value_11_0= '%%' ) ) ) ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

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
            // PsiInternalBug289515TestLanguage.g:60:1: ( ( (otherlv_0= '1' ( (lv_value_1_0= '%' ) ) ) | (otherlv_2= '2' ( (lv_value_3_0= '%' ) ) ) | (otherlv_4= '3' ( (lv_value_5_0= '\\\\%' ) ) ) | (otherlv_6= '4' ( (lv_value_7_0= '\\\\%' ) ) ) | (otherlv_8= '5' ( (lv_value_9_0= '%%' ) ) ) | (otherlv_10= '6' ( (lv_value_11_0= '%%' ) ) ) ) )
            // PsiInternalBug289515TestLanguage.g:61:2: ( (otherlv_0= '1' ( (lv_value_1_0= '%' ) ) ) | (otherlv_2= '2' ( (lv_value_3_0= '%' ) ) ) | (otherlv_4= '3' ( (lv_value_5_0= '\\\\%' ) ) ) | (otherlv_6= '4' ( (lv_value_7_0= '\\\\%' ) ) ) | (otherlv_8= '5' ( (lv_value_9_0= '%%' ) ) ) | (otherlv_10= '6' ( (lv_value_11_0= '%%' ) ) ) )
            {
            // PsiInternalBug289515TestLanguage.g:61:2: ( (otherlv_0= '1' ( (lv_value_1_0= '%' ) ) ) | (otherlv_2= '2' ( (lv_value_3_0= '%' ) ) ) | (otherlv_4= '3' ( (lv_value_5_0= '\\\\%' ) ) ) | (otherlv_6= '4' ( (lv_value_7_0= '\\\\%' ) ) ) | (otherlv_8= '5' ( (lv_value_9_0= '%%' ) ) ) | (otherlv_10= '6' ( (lv_value_11_0= '%%' ) ) ) )
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
                    // PsiInternalBug289515TestLanguage.g:62:3: (otherlv_0= '1' ( (lv_value_1_0= '%' ) ) )
                    {
                    // PsiInternalBug289515TestLanguage.g:62:3: (otherlv_0= '1' ( (lv_value_1_0= '%' ) ) )
                    // PsiInternalBug289515TestLanguage.g:63:4: otherlv_0= '1' ( (lv_value_1_0= '%' ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_DigitOneKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalBug289515TestLanguage.g:70:4: ( (lv_value_1_0= '%' ) )
                    // PsiInternalBug289515TestLanguage.g:71:5: (lv_value_1_0= '%' )
                    {
                    // PsiInternalBug289515TestLanguage.g:71:5: (lv_value_1_0= '%' )
                    // PsiInternalBug289515TestLanguage.g:72:6: lv_value_1_0= '%'
                    {

                    						markLeaf(elementTypeProvider.getModel_ValuePercentSignKeyword_0_1_0ElementType());
                    					
                    lv_value_1_0=(Token)match(input,12,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_value_1_0);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBug289515TestLanguage.g:89:3: (otherlv_2= '2' ( (lv_value_3_0= '%' ) ) )
                    {
                    // PsiInternalBug289515TestLanguage.g:89:3: (otherlv_2= '2' ( (lv_value_3_0= '%' ) ) )
                    // PsiInternalBug289515TestLanguage.g:90:4: otherlv_2= '2' ( (lv_value_3_0= '%' ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_DigitTwoKeyword_1_0ElementType());
                    			
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalBug289515TestLanguage.g:97:4: ( (lv_value_3_0= '%' ) )
                    // PsiInternalBug289515TestLanguage.g:98:5: (lv_value_3_0= '%' )
                    {
                    // PsiInternalBug289515TestLanguage.g:98:5: (lv_value_3_0= '%' )
                    // PsiInternalBug289515TestLanguage.g:99:6: lv_value_3_0= '%'
                    {

                    						markLeaf(elementTypeProvider.getModel_ValuePercentSignKeyword_1_1_0ElementType());
                    					
                    lv_value_3_0=(Token)match(input,12,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_value_3_0);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalBug289515TestLanguage.g:116:3: (otherlv_4= '3' ( (lv_value_5_0= '\\\\%' ) ) )
                    {
                    // PsiInternalBug289515TestLanguage.g:116:3: (otherlv_4= '3' ( (lv_value_5_0= '\\\\%' ) ) )
                    // PsiInternalBug289515TestLanguage.g:117:4: otherlv_4= '3' ( (lv_value_5_0= '\\\\%' ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_DigitThreeKeyword_2_0ElementType());
                    			
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalBug289515TestLanguage.g:124:4: ( (lv_value_5_0= '\\\\%' ) )
                    // PsiInternalBug289515TestLanguage.g:125:5: (lv_value_5_0= '\\\\%' )
                    {
                    // PsiInternalBug289515TestLanguage.g:125:5: (lv_value_5_0= '\\\\%' )
                    // PsiInternalBug289515TestLanguage.g:126:6: lv_value_5_0= '\\\\%'
                    {

                    						markLeaf(elementTypeProvider.getModel_ValueReverseSolidusPercentSignKeyword_2_1_0ElementType());
                    					
                    lv_value_5_0=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_value_5_0);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // PsiInternalBug289515TestLanguage.g:143:3: (otherlv_6= '4' ( (lv_value_7_0= '\\\\%' ) ) )
                    {
                    // PsiInternalBug289515TestLanguage.g:143:3: (otherlv_6= '4' ( (lv_value_7_0= '\\\\%' ) ) )
                    // PsiInternalBug289515TestLanguage.g:144:4: otherlv_6= '4' ( (lv_value_7_0= '\\\\%' ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_DigitFourKeyword_3_0ElementType());
                    			
                    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_6);
                    			
                    // PsiInternalBug289515TestLanguage.g:151:4: ( (lv_value_7_0= '\\\\%' ) )
                    // PsiInternalBug289515TestLanguage.g:152:5: (lv_value_7_0= '\\\\%' )
                    {
                    // PsiInternalBug289515TestLanguage.g:152:5: (lv_value_7_0= '\\\\%' )
                    // PsiInternalBug289515TestLanguage.g:153:6: lv_value_7_0= '\\\\%'
                    {

                    						markLeaf(elementTypeProvider.getModel_ValueReverseSolidusPercentSignKeyword_3_1_0ElementType());
                    					
                    lv_value_7_0=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_value_7_0);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // PsiInternalBug289515TestLanguage.g:170:3: (otherlv_8= '5' ( (lv_value_9_0= '%%' ) ) )
                    {
                    // PsiInternalBug289515TestLanguage.g:170:3: (otherlv_8= '5' ( (lv_value_9_0= '%%' ) ) )
                    // PsiInternalBug289515TestLanguage.g:171:4: otherlv_8= '5' ( (lv_value_9_0= '%%' ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_DigitFiveKeyword_4_0ElementType());
                    			
                    otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_8);
                    			
                    // PsiInternalBug289515TestLanguage.g:178:4: ( (lv_value_9_0= '%%' ) )
                    // PsiInternalBug289515TestLanguage.g:179:5: (lv_value_9_0= '%%' )
                    {
                    // PsiInternalBug289515TestLanguage.g:179:5: (lv_value_9_0= '%%' )
                    // PsiInternalBug289515TestLanguage.g:180:6: lv_value_9_0= '%%'
                    {

                    						markLeaf(elementTypeProvider.getModel_ValuePercentSignPercentSignKeyword_4_1_0ElementType());
                    					
                    lv_value_9_0=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_value_9_0);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // PsiInternalBug289515TestLanguage.g:197:3: (otherlv_10= '6' ( (lv_value_11_0= '%%' ) ) )
                    {
                    // PsiInternalBug289515TestLanguage.g:197:3: (otherlv_10= '6' ( (lv_value_11_0= '%%' ) ) )
                    // PsiInternalBug289515TestLanguage.g:198:4: otherlv_10= '6' ( (lv_value_11_0= '%%' ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_DigitSixKeyword_5_0ElementType());
                    			
                    otherlv_10=(Token)match(input,19,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_10);
                    			
                    // PsiInternalBug289515TestLanguage.g:205:4: ( (lv_value_11_0= '%%' ) )
                    // PsiInternalBug289515TestLanguage.g:206:5: (lv_value_11_0= '%%' )
                    {
                    // PsiInternalBug289515TestLanguage.g:206:5: (lv_value_11_0= '%%' )
                    // PsiInternalBug289515TestLanguage.g:207:6: lv_value_11_0= '%%'
                    {

                    						markLeaf(elementTypeProvider.getModel_ValuePercentSignPercentSignKeyword_5_1_0ElementType());
                    					
                    lv_value_11_0=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_value_11_0);
                    					

                    						if (!current) {
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
    // $ANTLR end "ruleModel"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000040000L});
    }


}