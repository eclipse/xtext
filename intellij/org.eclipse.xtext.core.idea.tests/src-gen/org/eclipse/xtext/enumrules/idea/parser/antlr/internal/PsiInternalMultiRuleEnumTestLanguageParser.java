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
    // PsiInternalMultiRuleEnumTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalMultiRuleEnumTestLanguage.g:52:15: ( ruleModel EOF )
            // PsiInternalMultiRuleEnumTestLanguage.g:53:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalMultiRuleEnumTestLanguage.g:58:1: ruleModel : (otherlv_0= 'someEnum' ( (lv_a_1_0= ruleEnumRuleA ) ) ( (lv_b_2_0= ruleEnumRuleB ) ) ( (lv_c_3_0= ruleEnumRuleC ) ) ) ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalMultiRuleEnumTestLanguage.g:58:10: ( (otherlv_0= 'someEnum' ( (lv_a_1_0= ruleEnumRuleA ) ) ( (lv_b_2_0= ruleEnumRuleB ) ) ( (lv_c_3_0= ruleEnumRuleC ) ) ) )
            // PsiInternalMultiRuleEnumTestLanguage.g:59:2: (otherlv_0= 'someEnum' ( (lv_a_1_0= ruleEnumRuleA ) ) ( (lv_b_2_0= ruleEnumRuleB ) ) ( (lv_c_3_0= ruleEnumRuleC ) ) )
            {
            // PsiInternalMultiRuleEnumTestLanguage.g:59:2: (otherlv_0= 'someEnum' ( (lv_a_1_0= ruleEnumRuleA ) ) ( (lv_b_2_0= ruleEnumRuleB ) ) ( (lv_c_3_0= ruleEnumRuleC ) ) )
            // PsiInternalMultiRuleEnumTestLanguage.g:60:3: otherlv_0= 'someEnum' ( (lv_a_1_0= ruleEnumRuleA ) ) ( (lv_b_2_0= ruleEnumRuleB ) ) ( (lv_c_3_0= ruleEnumRuleC ) )
            {

            			markLeaf(elementTypeProvider.getModel_SomeEnumKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalMultiRuleEnumTestLanguage.g:67:3: ( (lv_a_1_0= ruleEnumRuleA ) )
            // PsiInternalMultiRuleEnumTestLanguage.g:68:4: (lv_a_1_0= ruleEnumRuleA )
            {
            // PsiInternalMultiRuleEnumTestLanguage.g:68:4: (lv_a_1_0= ruleEnumRuleA )
            // PsiInternalMultiRuleEnumTestLanguage.g:69:5: lv_a_1_0= ruleEnumRuleA
            {

            					markComposite(elementTypeProvider.getModel_AEnumRuleAEnumRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_4);
            ruleEnumRuleA();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalMultiRuleEnumTestLanguage.g:78:3: ( (lv_b_2_0= ruleEnumRuleB ) )
            // PsiInternalMultiRuleEnumTestLanguage.g:79:4: (lv_b_2_0= ruleEnumRuleB )
            {
            // PsiInternalMultiRuleEnumTestLanguage.g:79:4: (lv_b_2_0= ruleEnumRuleB )
            // PsiInternalMultiRuleEnumTestLanguage.g:80:5: lv_b_2_0= ruleEnumRuleB
            {

            					markComposite(elementTypeProvider.getModel_BEnumRuleBEnumRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_5);
            ruleEnumRuleB();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalMultiRuleEnumTestLanguage.g:89:3: ( (lv_c_3_0= ruleEnumRuleC ) )
            // PsiInternalMultiRuleEnumTestLanguage.g:90:4: (lv_c_3_0= ruleEnumRuleC )
            {
            // PsiInternalMultiRuleEnumTestLanguage.g:90:4: (lv_c_3_0= ruleEnumRuleC )
            // PsiInternalMultiRuleEnumTestLanguage.g:91:5: lv_c_3_0= ruleEnumRuleC
            {

            					markComposite(elementTypeProvider.getModel_CEnumRuleCEnumRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEnumRuleC();

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "ruleEnumRuleA"
    // PsiInternalMultiRuleEnumTestLanguage.g:104:1: ruleEnumRuleA : ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'C' ) ) ;
    public final void ruleEnumRuleA() throws RecognitionException {
        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

        try {
            // PsiInternalMultiRuleEnumTestLanguage.g:104:14: ( ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'C' ) ) )
            // PsiInternalMultiRuleEnumTestLanguage.g:105:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'C' ) )
            {
            // PsiInternalMultiRuleEnumTestLanguage.g:105:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'C' ) )
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
                    // PsiInternalMultiRuleEnumTestLanguage.g:106:3: (enumLiteral_0= 'A' )
                    {
                    // PsiInternalMultiRuleEnumTestLanguage.g:106:3: (enumLiteral_0= 'A' )
                    // PsiInternalMultiRuleEnumTestLanguage.g:107:4: enumLiteral_0= 'A'
                    {

                    				markLeaf(elementTypeProvider.getEnumRuleA_AEnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,12,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalMultiRuleEnumTestLanguage.g:116:3: (enumLiteral_1= 'B' )
                    {
                    // PsiInternalMultiRuleEnumTestLanguage.g:116:3: (enumLiteral_1= 'B' )
                    // PsiInternalMultiRuleEnumTestLanguage.g:117:4: enumLiteral_1= 'B'
                    {

                    				markLeaf(elementTypeProvider.getEnumRuleA_BEnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_1);
                    			

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalMultiRuleEnumTestLanguage.g:126:3: (enumLiteral_2= 'C' )
                    {
                    // PsiInternalMultiRuleEnumTestLanguage.g:126:3: (enumLiteral_2= 'C' )
                    // PsiInternalMultiRuleEnumTestLanguage.g:127:4: enumLiteral_2= 'C'
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
        return ;
    }
    // $ANTLR end "ruleEnumRuleA"


    // $ANTLR start "ruleEnumRuleB"
    // PsiInternalMultiRuleEnumTestLanguage.g:139:1: ruleEnumRuleB : ( (enumLiteral_0= 'C' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'E' ) ) ;
    public final void ruleEnumRuleB() throws RecognitionException {
        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

        try {
            // PsiInternalMultiRuleEnumTestLanguage.g:139:14: ( ( (enumLiteral_0= 'C' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'E' ) ) )
            // PsiInternalMultiRuleEnumTestLanguage.g:140:2: ( (enumLiteral_0= 'C' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'E' ) )
            {
            // PsiInternalMultiRuleEnumTestLanguage.g:140:2: ( (enumLiteral_0= 'C' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'E' ) )
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
                    // PsiInternalMultiRuleEnumTestLanguage.g:141:3: (enumLiteral_0= 'C' )
                    {
                    // PsiInternalMultiRuleEnumTestLanguage.g:141:3: (enumLiteral_0= 'C' )
                    // PsiInternalMultiRuleEnumTestLanguage.g:142:4: enumLiteral_0= 'C'
                    {

                    				markLeaf(elementTypeProvider.getEnumRuleB_CEnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalMultiRuleEnumTestLanguage.g:151:3: (enumLiteral_1= 'D' )
                    {
                    // PsiInternalMultiRuleEnumTestLanguage.g:151:3: (enumLiteral_1= 'D' )
                    // PsiInternalMultiRuleEnumTestLanguage.g:152:4: enumLiteral_1= 'D'
                    {

                    				markLeaf(elementTypeProvider.getEnumRuleB_DEnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_1);
                    			

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalMultiRuleEnumTestLanguage.g:161:3: (enumLiteral_2= 'E' )
                    {
                    // PsiInternalMultiRuleEnumTestLanguage.g:161:3: (enumLiteral_2= 'E' )
                    // PsiInternalMultiRuleEnumTestLanguage.g:162:4: enumLiteral_2= 'E'
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
        return ;
    }
    // $ANTLR end "ruleEnumRuleB"


    // $ANTLR start "ruleEnumRuleC"
    // PsiInternalMultiRuleEnumTestLanguage.g:174:1: ruleEnumRuleC : ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'B' ) ) ;
    public final void ruleEnumRuleC() throws RecognitionException {
        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

        try {
            // PsiInternalMultiRuleEnumTestLanguage.g:174:14: ( ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'B' ) ) )
            // PsiInternalMultiRuleEnumTestLanguage.g:175:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'B' ) )
            {
            // PsiInternalMultiRuleEnumTestLanguage.g:175:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'B' ) )
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
                    // PsiInternalMultiRuleEnumTestLanguage.g:176:3: (enumLiteral_0= 'A' )
                    {
                    // PsiInternalMultiRuleEnumTestLanguage.g:176:3: (enumLiteral_0= 'A' )
                    // PsiInternalMultiRuleEnumTestLanguage.g:177:4: enumLiteral_0= 'A'
                    {

                    				markLeaf(elementTypeProvider.getEnumRuleC_AEnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,12,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalMultiRuleEnumTestLanguage.g:186:3: (enumLiteral_1= 'D' )
                    {
                    // PsiInternalMultiRuleEnumTestLanguage.g:186:3: (enumLiteral_1= 'D' )
                    // PsiInternalMultiRuleEnumTestLanguage.g:187:4: enumLiteral_1= 'D'
                    {

                    				markLeaf(elementTypeProvider.getEnumRuleC_DEnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_1);
                    			

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalMultiRuleEnumTestLanguage.g:196:3: (enumLiteral_2= 'B' )
                    {
                    // PsiInternalMultiRuleEnumTestLanguage.g:196:3: (enumLiteral_2= 'B' )
                    // PsiInternalMultiRuleEnumTestLanguage.g:197:4: enumLiteral_2= 'B'
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
        return ;
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