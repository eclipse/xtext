package org.eclipse.xtext.enumrules.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.enumrules.idea.lang.MultiRuleEnumTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.enumrules.services.MultiRuleEnumTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalMultiRuleEnumTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'someEnum'", "'A'", "'B'", "'C'", "'D'", "'E'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
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


        public PsiInternalMultiRuleEnumTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalMultiRuleEnumTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalMultiRuleEnumTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalMultiRuleEnumTestLanguage.g"; }



    	protected MultiRuleEnumTestLanguageGrammarAccess grammarAccess;

    	protected MultiRuleEnumTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalMultiRuleEnumTestLanguageParser(PsiBuilder builder, TokenStream input, MultiRuleEnumTestLanguageElementTypeProvider elementTypeProvider, MultiRuleEnumTestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalMultiRuleEnumTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalMultiRuleEnumTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalMultiRuleEnumTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalMultiRuleEnumTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : (otherlv_0= 'someEnum' ( (lv_a_1_0= ruleEnumRuleA ) ) ( (lv_b_2_0= ruleEnumRuleB ) ) ( (lv_c_3_0= ruleEnumRuleC ) ) ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_a_1_0 = null;

        Boolean lv_b_2_0 = null;

        Boolean lv_c_3_0 = null;


        try {
            // PsiInternalMultiRuleEnumTestLanguage.g:60:1: ( (otherlv_0= 'someEnum' ( (lv_a_1_0= ruleEnumRuleA ) ) ( (lv_b_2_0= ruleEnumRuleB ) ) ( (lv_c_3_0= ruleEnumRuleC ) ) ) )
            // PsiInternalMultiRuleEnumTestLanguage.g:61:2: (otherlv_0= 'someEnum' ( (lv_a_1_0= ruleEnumRuleA ) ) ( (lv_b_2_0= ruleEnumRuleB ) ) ( (lv_c_3_0= ruleEnumRuleC ) ) )
            {
            // PsiInternalMultiRuleEnumTestLanguage.g:61:2: (otherlv_0= 'someEnum' ( (lv_a_1_0= ruleEnumRuleA ) ) ( (lv_b_2_0= ruleEnumRuleB ) ) ( (lv_c_3_0= ruleEnumRuleC ) ) )
            // PsiInternalMultiRuleEnumTestLanguage.g:62:3: otherlv_0= 'someEnum' ( (lv_a_1_0= ruleEnumRuleA ) ) ( (lv_b_2_0= ruleEnumRuleB ) ) ( (lv_c_3_0= ruleEnumRuleC ) )
            {

            			markLeaf(elementTypeProvider.getModel_SomeEnumKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalMultiRuleEnumTestLanguage.g:69:3: ( (lv_a_1_0= ruleEnumRuleA ) )
            // PsiInternalMultiRuleEnumTestLanguage.g:70:4: (lv_a_1_0= ruleEnumRuleA )
            {
            // PsiInternalMultiRuleEnumTestLanguage.g:70:4: (lv_a_1_0= ruleEnumRuleA )
            // PsiInternalMultiRuleEnumTestLanguage.g:71:5: lv_a_1_0= ruleEnumRuleA
            {

            					markComposite(elementTypeProvider.getModel_AEnumRuleAEnumRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_4);
            lv_a_1_0=ruleEnumRuleA();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalMultiRuleEnumTestLanguage.g:84:3: ( (lv_b_2_0= ruleEnumRuleB ) )
            // PsiInternalMultiRuleEnumTestLanguage.g:85:4: (lv_b_2_0= ruleEnumRuleB )
            {
            // PsiInternalMultiRuleEnumTestLanguage.g:85:4: (lv_b_2_0= ruleEnumRuleB )
            // PsiInternalMultiRuleEnumTestLanguage.g:86:5: lv_b_2_0= ruleEnumRuleB
            {

            					markComposite(elementTypeProvider.getModel_BEnumRuleBEnumRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_5);
            lv_b_2_0=ruleEnumRuleB();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalMultiRuleEnumTestLanguage.g:99:3: ( (lv_c_3_0= ruleEnumRuleC ) )
            // PsiInternalMultiRuleEnumTestLanguage.g:100:4: (lv_c_3_0= ruleEnumRuleC )
            {
            // PsiInternalMultiRuleEnumTestLanguage.g:100:4: (lv_c_3_0= ruleEnumRuleC )
            // PsiInternalMultiRuleEnumTestLanguage.g:101:5: lv_c_3_0= ruleEnumRuleC
            {

            					markComposite(elementTypeProvider.getModel_CEnumRuleCEnumRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_c_3_0=ruleEnumRuleC();

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "ruleEnumRuleA"
    // PsiInternalMultiRuleEnumTestLanguage.g:118:1: ruleEnumRuleA returns [Boolean current=false] : ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'C' ) ) ;
    public final Boolean ruleEnumRuleA() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

        try {
            // PsiInternalMultiRuleEnumTestLanguage.g:119:1: ( ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'C' ) ) )
            // PsiInternalMultiRuleEnumTestLanguage.g:120:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'C' ) )
            {
            // PsiInternalMultiRuleEnumTestLanguage.g:120:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'C' ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 12:
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // PsiInternalMultiRuleEnumTestLanguage.g:121:3: (enumLiteral_0= 'A' )
                    {
                    // PsiInternalMultiRuleEnumTestLanguage.g:121:3: (enumLiteral_0= 'A' )
                    // PsiInternalMultiRuleEnumTestLanguage.g:122:4: enumLiteral_0= 'A'
                    {

                    				markLeaf(elementTypeProvider.getEnumRuleA_AEnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,12,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalMultiRuleEnumTestLanguage.g:131:3: (enumLiteral_1= 'B' )
                    {
                    // PsiInternalMultiRuleEnumTestLanguage.g:131:3: (enumLiteral_1= 'B' )
                    // PsiInternalMultiRuleEnumTestLanguage.g:132:4: enumLiteral_1= 'B'
                    {

                    				markLeaf(elementTypeProvider.getEnumRuleA_BEnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_1);
                    			

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalMultiRuleEnumTestLanguage.g:141:3: (enumLiteral_2= 'C' )
                    {
                    // PsiInternalMultiRuleEnumTestLanguage.g:141:3: (enumLiteral_2= 'C' )
                    // PsiInternalMultiRuleEnumTestLanguage.g:142:4: enumLiteral_2= 'C'
                    {

                    				markLeaf(elementTypeProvider.getEnumRuleA_CEnumLiteralDeclaration_2ElementType());
                    			
                    enumLiteral_2=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_2);
                    			

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
    // $ANTLR end "ruleEnumRuleA"


    // $ANTLR start "ruleEnumRuleB"
    // PsiInternalMultiRuleEnumTestLanguage.g:154:1: ruleEnumRuleB returns [Boolean current=false] : ( (enumLiteral_0= 'C' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'E' ) ) ;
    public final Boolean ruleEnumRuleB() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

        try {
            // PsiInternalMultiRuleEnumTestLanguage.g:155:1: ( ( (enumLiteral_0= 'C' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'E' ) ) )
            // PsiInternalMultiRuleEnumTestLanguage.g:156:2: ( (enumLiteral_0= 'C' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'E' ) )
            {
            // PsiInternalMultiRuleEnumTestLanguage.g:156:2: ( (enumLiteral_0= 'C' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'E' ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt2=1;
                }
                break;
            case 15:
                {
                alt2=2;
                }
                break;
            case 16:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // PsiInternalMultiRuleEnumTestLanguage.g:157:3: (enumLiteral_0= 'C' )
                    {
                    // PsiInternalMultiRuleEnumTestLanguage.g:157:3: (enumLiteral_0= 'C' )
                    // PsiInternalMultiRuleEnumTestLanguage.g:158:4: enumLiteral_0= 'C'
                    {

                    				markLeaf(elementTypeProvider.getEnumRuleB_CEnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalMultiRuleEnumTestLanguage.g:167:3: (enumLiteral_1= 'D' )
                    {
                    // PsiInternalMultiRuleEnumTestLanguage.g:167:3: (enumLiteral_1= 'D' )
                    // PsiInternalMultiRuleEnumTestLanguage.g:168:4: enumLiteral_1= 'D'
                    {

                    				markLeaf(elementTypeProvider.getEnumRuleB_DEnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_1);
                    			

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalMultiRuleEnumTestLanguage.g:177:3: (enumLiteral_2= 'E' )
                    {
                    // PsiInternalMultiRuleEnumTestLanguage.g:177:3: (enumLiteral_2= 'E' )
                    // PsiInternalMultiRuleEnumTestLanguage.g:178:4: enumLiteral_2= 'E'
                    {

                    				markLeaf(elementTypeProvider.getEnumRuleB_EEnumLiteralDeclaration_2ElementType());
                    			
                    enumLiteral_2=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_2);
                    			

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
    // $ANTLR end "ruleEnumRuleB"


    // $ANTLR start "ruleEnumRuleC"
    // PsiInternalMultiRuleEnumTestLanguage.g:190:1: ruleEnumRuleC returns [Boolean current=false] : ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'B' ) ) ;
    public final Boolean ruleEnumRuleC() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

        try {
            // PsiInternalMultiRuleEnumTestLanguage.g:191:1: ( ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'B' ) ) )
            // PsiInternalMultiRuleEnumTestLanguage.g:192:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'B' ) )
            {
            // PsiInternalMultiRuleEnumTestLanguage.g:192:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'B' ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt3=1;
                }
                break;
            case 15:
                {
                alt3=2;
                }
                break;
            case 13:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // PsiInternalMultiRuleEnumTestLanguage.g:193:3: (enumLiteral_0= 'A' )
                    {
                    // PsiInternalMultiRuleEnumTestLanguage.g:193:3: (enumLiteral_0= 'A' )
                    // PsiInternalMultiRuleEnumTestLanguage.g:194:4: enumLiteral_0= 'A'
                    {

                    				markLeaf(elementTypeProvider.getEnumRuleC_AEnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,12,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalMultiRuleEnumTestLanguage.g:203:3: (enumLiteral_1= 'D' )
                    {
                    // PsiInternalMultiRuleEnumTestLanguage.g:203:3: (enumLiteral_1= 'D' )
                    // PsiInternalMultiRuleEnumTestLanguage.g:204:4: enumLiteral_1= 'D'
                    {

                    				markLeaf(elementTypeProvider.getEnumRuleC_DEnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_1);
                    			

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalMultiRuleEnumTestLanguage.g:213:3: (enumLiteral_2= 'B' )
                    {
                    // PsiInternalMultiRuleEnumTestLanguage.g:213:3: (enumLiteral_2= 'B' )
                    // PsiInternalMultiRuleEnumTestLanguage.g:214:4: enumLiteral_2= 'B'
                    {

                    				markLeaf(elementTypeProvider.getEnumRuleC_BEnumLiteralDeclaration_2ElementType());
                    			
                    enumLiteral_2=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_2);
                    			

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
    // $ANTLR end "ruleEnumRuleC"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000007000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000001C000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000000B000L});
    }


}