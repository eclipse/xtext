package org.eclipse.xtext.parser.keywords.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.keywords.idea.lang.KeywordsTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.keywords.services.KeywordsTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalKeywordsTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'foo\\\\bar'", "'foo\\\\'", "'\\\\bar'", "'\\\\'", "'\"a\"'", "'\\'b\\''", "'\\'c\\''", "'\"d\"'"
    };
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


        public PsiInternalKeywordsTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalKeywordsTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalKeywordsTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalKeywordsTestLanguage.g"; }



    	protected KeywordsTestLanguageGrammarAccess grammarAccess;

    	protected KeywordsTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalKeywordsTestLanguageParser(PsiBuilder builder, TokenStream input, KeywordsTestLanguageElementTypeProvider elementTypeProvider, KeywordsTestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalKeywordsTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalKeywordsTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalKeywordsTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalKeywordsTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( ( (lv_first_0_0= 'foo\\\\bar' ) ) | ( (lv_second_1_0= 'foo\\\\' ) ) | ( (lv_third_2_0= '\\\\bar' ) ) | ( (lv_forth_3_0= '\\\\' ) ) | ( (lv_fifth_4_0= '\"a\"' ) ) | ( (lv_sixth_5_0= '\\'b\\'' ) ) | ( (lv_seventh_6_0= '\\'c\\'' ) ) | ( (lv_eighth_7_0= '\"d\"' ) ) ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Token lv_first_0_0=null;
        Token lv_second_1_0=null;
        Token lv_third_2_0=null;
        Token lv_forth_3_0=null;
        Token lv_fifth_4_0=null;
        Token lv_sixth_5_0=null;
        Token lv_seventh_6_0=null;
        Token lv_eighth_7_0=null;

        try {
            // PsiInternalKeywordsTestLanguage.g:60:1: ( ( ( (lv_first_0_0= 'foo\\\\bar' ) ) | ( (lv_second_1_0= 'foo\\\\' ) ) | ( (lv_third_2_0= '\\\\bar' ) ) | ( (lv_forth_3_0= '\\\\' ) ) | ( (lv_fifth_4_0= '\"a\"' ) ) | ( (lv_sixth_5_0= '\\'b\\'' ) ) | ( (lv_seventh_6_0= '\\'c\\'' ) ) | ( (lv_eighth_7_0= '\"d\"' ) ) ) )
            // PsiInternalKeywordsTestLanguage.g:61:2: ( ( (lv_first_0_0= 'foo\\\\bar' ) ) | ( (lv_second_1_0= 'foo\\\\' ) ) | ( (lv_third_2_0= '\\\\bar' ) ) | ( (lv_forth_3_0= '\\\\' ) ) | ( (lv_fifth_4_0= '\"a\"' ) ) | ( (lv_sixth_5_0= '\\'b\\'' ) ) | ( (lv_seventh_6_0= '\\'c\\'' ) ) | ( (lv_eighth_7_0= '\"d\"' ) ) )
            {
            // PsiInternalKeywordsTestLanguage.g:61:2: ( ( (lv_first_0_0= 'foo\\\\bar' ) ) | ( (lv_second_1_0= 'foo\\\\' ) ) | ( (lv_third_2_0= '\\\\bar' ) ) | ( (lv_forth_3_0= '\\\\' ) ) | ( (lv_fifth_4_0= '\"a\"' ) ) | ( (lv_sixth_5_0= '\\'b\\'' ) ) | ( (lv_seventh_6_0= '\\'c\\'' ) ) | ( (lv_eighth_7_0= '\"d\"' ) ) )
            int alt1=8;
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
            case 15:
                {
                alt1=5;
                }
                break;
            case 16:
                {
                alt1=6;
                }
                break;
            case 17:
                {
                alt1=7;
                }
                break;
            case 18:
                {
                alt1=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // PsiInternalKeywordsTestLanguage.g:62:3: ( (lv_first_0_0= 'foo\\\\bar' ) )
                    {
                    // PsiInternalKeywordsTestLanguage.g:62:3: ( (lv_first_0_0= 'foo\\\\bar' ) )
                    // PsiInternalKeywordsTestLanguage.g:63:4: (lv_first_0_0= 'foo\\\\bar' )
                    {
                    // PsiInternalKeywordsTestLanguage.g:63:4: (lv_first_0_0= 'foo\\\\bar' )
                    // PsiInternalKeywordsTestLanguage.g:64:5: lv_first_0_0= 'foo\\\\bar'
                    {

                    					markLeaf(elementTypeProvider.getModel_FirstFooBarKeyword_0_0ElementType());
                    				
                    lv_first_0_0=(Token)match(input,11,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_first_0_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalKeywordsTestLanguage.g:80:3: ( (lv_second_1_0= 'foo\\\\' ) )
                    {
                    // PsiInternalKeywordsTestLanguage.g:80:3: ( (lv_second_1_0= 'foo\\\\' ) )
                    // PsiInternalKeywordsTestLanguage.g:81:4: (lv_second_1_0= 'foo\\\\' )
                    {
                    // PsiInternalKeywordsTestLanguage.g:81:4: (lv_second_1_0= 'foo\\\\' )
                    // PsiInternalKeywordsTestLanguage.g:82:5: lv_second_1_0= 'foo\\\\'
                    {

                    					markLeaf(elementTypeProvider.getModel_SecondFooKeyword_1_0ElementType());
                    				
                    lv_second_1_0=(Token)match(input,12,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_second_1_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalKeywordsTestLanguage.g:98:3: ( (lv_third_2_0= '\\\\bar' ) )
                    {
                    // PsiInternalKeywordsTestLanguage.g:98:3: ( (lv_third_2_0= '\\\\bar' ) )
                    // PsiInternalKeywordsTestLanguage.g:99:4: (lv_third_2_0= '\\\\bar' )
                    {
                    // PsiInternalKeywordsTestLanguage.g:99:4: (lv_third_2_0= '\\\\bar' )
                    // PsiInternalKeywordsTestLanguage.g:100:5: lv_third_2_0= '\\\\bar'
                    {

                    					markLeaf(elementTypeProvider.getModel_ThirdBarKeyword_2_0ElementType());
                    				
                    lv_third_2_0=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_third_2_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // PsiInternalKeywordsTestLanguage.g:116:3: ( (lv_forth_3_0= '\\\\' ) )
                    {
                    // PsiInternalKeywordsTestLanguage.g:116:3: ( (lv_forth_3_0= '\\\\' ) )
                    // PsiInternalKeywordsTestLanguage.g:117:4: (lv_forth_3_0= '\\\\' )
                    {
                    // PsiInternalKeywordsTestLanguage.g:117:4: (lv_forth_3_0= '\\\\' )
                    // PsiInternalKeywordsTestLanguage.g:118:5: lv_forth_3_0= '\\\\'
                    {

                    					markLeaf(elementTypeProvider.getModel_ForthReverseSolidusKeyword_3_0ElementType());
                    				
                    lv_forth_3_0=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_forth_3_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // PsiInternalKeywordsTestLanguage.g:134:3: ( (lv_fifth_4_0= '\"a\"' ) )
                    {
                    // PsiInternalKeywordsTestLanguage.g:134:3: ( (lv_fifth_4_0= '\"a\"' ) )
                    // PsiInternalKeywordsTestLanguage.g:135:4: (lv_fifth_4_0= '\"a\"' )
                    {
                    // PsiInternalKeywordsTestLanguage.g:135:4: (lv_fifth_4_0= '\"a\"' )
                    // PsiInternalKeywordsTestLanguage.g:136:5: lv_fifth_4_0= '\"a\"'
                    {

                    					markLeaf(elementTypeProvider.getModel_FifthAKeyword_4_0ElementType());
                    				
                    lv_fifth_4_0=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_fifth_4_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 6 :
                    // PsiInternalKeywordsTestLanguage.g:152:3: ( (lv_sixth_5_0= '\\'b\\'' ) )
                    {
                    // PsiInternalKeywordsTestLanguage.g:152:3: ( (lv_sixth_5_0= '\\'b\\'' ) )
                    // PsiInternalKeywordsTestLanguage.g:153:4: (lv_sixth_5_0= '\\'b\\'' )
                    {
                    // PsiInternalKeywordsTestLanguage.g:153:4: (lv_sixth_5_0= '\\'b\\'' )
                    // PsiInternalKeywordsTestLanguage.g:154:5: lv_sixth_5_0= '\\'b\\''
                    {

                    					markLeaf(elementTypeProvider.getModel_SixthBKeyword_5_0ElementType());
                    				
                    lv_sixth_5_0=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_sixth_5_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 7 :
                    // PsiInternalKeywordsTestLanguage.g:170:3: ( (lv_seventh_6_0= '\\'c\\'' ) )
                    {
                    // PsiInternalKeywordsTestLanguage.g:170:3: ( (lv_seventh_6_0= '\\'c\\'' ) )
                    // PsiInternalKeywordsTestLanguage.g:171:4: (lv_seventh_6_0= '\\'c\\'' )
                    {
                    // PsiInternalKeywordsTestLanguage.g:171:4: (lv_seventh_6_0= '\\'c\\'' )
                    // PsiInternalKeywordsTestLanguage.g:172:5: lv_seventh_6_0= '\\'c\\''
                    {

                    					markLeaf(elementTypeProvider.getModel_SeventhCKeyword_6_0ElementType());
                    				
                    lv_seventh_6_0=(Token)match(input,17,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_seventh_6_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 8 :
                    // PsiInternalKeywordsTestLanguage.g:188:3: ( (lv_eighth_7_0= '\"d\"' ) )
                    {
                    // PsiInternalKeywordsTestLanguage.g:188:3: ( (lv_eighth_7_0= '\"d\"' ) )
                    // PsiInternalKeywordsTestLanguage.g:189:4: (lv_eighth_7_0= '\"d\"' )
                    {
                    // PsiInternalKeywordsTestLanguage.g:189:4: (lv_eighth_7_0= '\"d\"' )
                    // PsiInternalKeywordsTestLanguage.g:190:5: lv_eighth_7_0= '\"d\"'
                    {

                    					markLeaf(elementTypeProvider.getModel_EighthDKeyword_7_0ElementType());
                    				
                    lv_eighth_7_0=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_eighth_7_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
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
    }


}