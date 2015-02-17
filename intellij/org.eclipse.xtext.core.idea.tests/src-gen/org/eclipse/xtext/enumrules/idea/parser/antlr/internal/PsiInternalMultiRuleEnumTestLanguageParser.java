package org.eclipse.xtext.enumrules.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.enumrules.idea.lang.MultiRuleEnumTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g"; }



    private MultiRuleEnumTestLanguageGrammarAccess grammarAccess;

    private MultiRuleEnumTestLanguageElementTypeProvider elementTypeProvider;

    public PsiInternalMultiRuleEnumTestLanguageParser(PsiBuilder builder, TokenStream input, TokenTypeProvider tokenTypeProvider, MultiRuleEnumTestLanguageElementTypeProvider elementTypeProvider, MultiRuleEnumTestLanguageGrammarAccess grammarAccess) {
    	super(builder, input, tokenTypeProvider);
        this.grammarAccess = grammarAccess;
    	this.elementTypeProvider = elementTypeProvider;
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
    }




    // $ANTLR start "entryRuleModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:49:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:49:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:50:2: ruleModel EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:58:1: ruleModel : (otherlv_0= 'someEnum' ( (lv_a_1_0= ruleEnumRuleA ) ) ( (lv_b_2_0= ruleEnumRuleB ) ) ( (lv_c_3_0= ruleEnumRuleC ) ) ) ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:58:10: ( (otherlv_0= 'someEnum' ( (lv_a_1_0= ruleEnumRuleA ) ) ( (lv_b_2_0= ruleEnumRuleB ) ) ( (lv_c_3_0= ruleEnumRuleC ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:59:2: (otherlv_0= 'someEnum' ( (lv_a_1_0= ruleEnumRuleA ) ) ( (lv_b_2_0= ruleEnumRuleB ) ) ( (lv_c_3_0= ruleEnumRuleC ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:59:2: (otherlv_0= 'someEnum' ( (lv_a_1_0= ruleEnumRuleA ) ) ( (lv_b_2_0= ruleEnumRuleB ) ) ( (lv_c_3_0= ruleEnumRuleC ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:60:3: otherlv_0= 'someEnum' ( (lv_a_1_0= ruleEnumRuleA ) ) ( (lv_b_2_0= ruleEnumRuleB ) ) ( (lv_c_3_0= ruleEnumRuleC ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel83); 

            			doneLeaf(otherlv_0, elementTypeProvider.getModel_SomeEnumKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:67:3: ( (lv_a_1_0= ruleEnumRuleA ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:68:4: (lv_a_1_0= ruleEnumRuleA )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:68:4: (lv_a_1_0= ruleEnumRuleA )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:69:5: lv_a_1_0= ruleEnumRuleA
            {

            					markComposite(elementTypeProvider.getModel_AEnumRuleAEnumRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleEnumRuleA_in_ruleModel110);
            ruleEnumRuleA();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:78:3: ( (lv_b_2_0= ruleEnumRuleB ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:79:4: (lv_b_2_0= ruleEnumRuleB )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:79:4: (lv_b_2_0= ruleEnumRuleB )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:80:5: lv_b_2_0= ruleEnumRuleB
            {

            					markComposite(elementTypeProvider.getModel_BEnumRuleBEnumRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleEnumRuleB_in_ruleModel148);
            ruleEnumRuleB();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:89:3: ( (lv_c_3_0= ruleEnumRuleC ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:90:4: (lv_c_3_0= ruleEnumRuleC )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:90:4: (lv_c_3_0= ruleEnumRuleC )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:91:5: lv_c_3_0= ruleEnumRuleC
            {

            					markComposite(elementTypeProvider.getModel_CEnumRuleCEnumRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleEnumRuleC_in_ruleModel186);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:104:1: ruleEnumRuleA : ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'C' ) ) ;
    public final void ruleEnumRuleA() throws RecognitionException {
        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:104:14: ( ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'C' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:105:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'C' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:105:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'B' ) | (enumLiteral_2= 'C' ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:106:3: (enumLiteral_0= 'A' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:106:3: (enumLiteral_0= 'A' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:107:4: enumLiteral_0= 'A'
                    {

                    				markLeaf();
                    			
                    enumLiteral_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEnumRuleA230); 

                    				doneLeaf(enumLiteral_0, elementTypeProvider.getEnumRuleA_AEnumLiteralDeclaration_0ElementType());
                    			

                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:116:3: (enumLiteral_1= 'B' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:116:3: (enumLiteral_1= 'B' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:117:4: enumLiteral_1= 'B'
                    {

                    				markLeaf();
                    			
                    enumLiteral_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleEnumRuleA263); 

                    				doneLeaf(enumLiteral_1, elementTypeProvider.getEnumRuleA_BEnumLiteralDeclaration_1ElementType());
                    			

                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:126:3: (enumLiteral_2= 'C' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:126:3: (enumLiteral_2= 'C' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:127:4: enumLiteral_2= 'C'
                    {

                    				markLeaf();
                    			
                    enumLiteral_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEnumRuleA296); 

                    				doneLeaf(enumLiteral_2, elementTypeProvider.getEnumRuleA_CEnumLiteralDeclaration_2ElementType());
                    			

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:139:1: ruleEnumRuleB : ( (enumLiteral_0= 'C' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'E' ) ) ;
    public final void ruleEnumRuleB() throws RecognitionException {
        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:139:14: ( ( (enumLiteral_0= 'C' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'E' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:140:2: ( (enumLiteral_0= 'C' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'E' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:140:2: ( (enumLiteral_0= 'C' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'E' ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:141:3: (enumLiteral_0= 'C' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:141:3: (enumLiteral_0= 'C' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:142:4: enumLiteral_0= 'C'
                    {

                    				markLeaf();
                    			
                    enumLiteral_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEnumRuleB334); 

                    				doneLeaf(enumLiteral_0, elementTypeProvider.getEnumRuleB_CEnumLiteralDeclaration_0ElementType());
                    			

                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:151:3: (enumLiteral_1= 'D' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:151:3: (enumLiteral_1= 'D' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:152:4: enumLiteral_1= 'D'
                    {

                    				markLeaf();
                    			
                    enumLiteral_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEnumRuleB367); 

                    				doneLeaf(enumLiteral_1, elementTypeProvider.getEnumRuleB_DEnumLiteralDeclaration_1ElementType());
                    			

                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:161:3: (enumLiteral_2= 'E' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:161:3: (enumLiteral_2= 'E' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:162:4: enumLiteral_2= 'E'
                    {

                    				markLeaf();
                    			
                    enumLiteral_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleEnumRuleB400); 

                    				doneLeaf(enumLiteral_2, elementTypeProvider.getEnumRuleB_EEnumLiteralDeclaration_2ElementType());
                    			

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:174:1: ruleEnumRuleC : ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'B' ) ) ;
    public final void ruleEnumRuleC() throws RecognitionException {
        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:174:14: ( ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'B' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:175:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'B' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:175:2: ( (enumLiteral_0= 'A' ) | (enumLiteral_1= 'D' ) | (enumLiteral_2= 'B' ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:176:3: (enumLiteral_0= 'A' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:176:3: (enumLiteral_0= 'A' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:177:4: enumLiteral_0= 'A'
                    {

                    				markLeaf();
                    			
                    enumLiteral_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEnumRuleC438); 

                    				doneLeaf(enumLiteral_0, elementTypeProvider.getEnumRuleC_AEnumLiteralDeclaration_0ElementType());
                    			

                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:186:3: (enumLiteral_1= 'D' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:186:3: (enumLiteral_1= 'D' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:187:4: enumLiteral_1= 'D'
                    {

                    				markLeaf();
                    			
                    enumLiteral_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEnumRuleC471); 

                    				doneLeaf(enumLiteral_1, elementTypeProvider.getEnumRuleC_DEnumLiteralDeclaration_1ElementType());
                    			

                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:196:3: (enumLiteral_2= 'B' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:196:3: (enumLiteral_2= 'B' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalMultiRuleEnumTestLanguage.g:197:4: enumLiteral_2= 'B'
                    {

                    				markLeaf();
                    			
                    enumLiteral_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleEnumRuleC504); 

                    				doneLeaf(enumLiteral_2, elementTypeProvider.getEnumRuleC_BEnumLiteralDeclaration_2ElementType());
                    			

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
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel83 = new BitSet(new long[]{0x0000000000007000L});
        public static final BitSet FOLLOW_ruleEnumRuleA_in_ruleModel110 = new BitSet(new long[]{0x000000000001C000L});
        public static final BitSet FOLLOW_ruleEnumRuleB_in_ruleModel148 = new BitSet(new long[]{0x000000000000B000L});
        public static final BitSet FOLLOW_ruleEnumRuleC_in_ruleModel186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleEnumRuleA230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleEnumRuleA263 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleEnumRuleA296 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleEnumRuleB334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleEnumRuleB367 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleEnumRuleB400 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleEnumRuleC438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleEnumRuleC471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleEnumRuleC504 = new BitSet(new long[]{0x0000000000000002L});
    }


}