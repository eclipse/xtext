package org.eclipse.xtext.enumrules.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.enumrules.idea.lang.EnumAndReferenceTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.enumrules.services.EnumAndReferenceTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalEnumAndReferenceTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'reference'", "'kindOfKeyword'", "'anotherEnumLiteral'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalEnumAndReferenceTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalEnumAndReferenceTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalEnumAndReferenceTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g"; }



    	protected EnumAndReferenceTestLanguageGrammarAccess grammarAccess;

    	protected EnumAndReferenceTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalEnumAndReferenceTestLanguageParser(PsiBuilder builder, TokenStream input, EnumAndReferenceTestLanguageElementTypeProvider elementTypeProvider, EnumAndReferenceTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "EntityWithEnumAndReference";
    	}




    // $ANTLR start "entryRuleEntityWithEnumAndReference"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:52:1: entryRuleEntityWithEnumAndReference : ruleEntityWithEnumAndReference EOF ;
    public final void entryRuleEntityWithEnumAndReference() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:52:36: ( ruleEntityWithEnumAndReference EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:53:2: ruleEntityWithEnumAndReference EOF
            {
             markComposite(elementTypeProvider.getEntityWithEnumAndReferenceElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEntityWithEnumAndReference_in_entryRuleEntityWithEnumAndReference54);
            ruleEntityWithEnumAndReference();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEntityWithEnumAndReference60); 

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
    // $ANTLR end "entryRuleEntityWithEnumAndReference"


    // $ANTLR start "ruleEntityWithEnumAndReference"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:59:1: ruleEntityWithEnumAndReference : ( ( (lv_type_0_0= ruleKindOfKeyword ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) ) ;
    public final void ruleEntityWithEnumAndReference() throws RecognitionException {
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:62:2: ( ( ( (lv_type_0_0= ruleKindOfKeyword ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:63:2: ( ( (lv_type_0_0= ruleKindOfKeyword ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:63:2: ( ( (lv_type_0_0= ruleKindOfKeyword ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:64:3: ( (lv_type_0_0= ruleKindOfKeyword ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:64:3: ( (lv_type_0_0= ruleKindOfKeyword ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:65:4: (lv_type_0_0= ruleKindOfKeyword )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:65:4: (lv_type_0_0= ruleKindOfKeyword )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:66:5: lv_type_0_0= ruleKindOfKeyword
            {

            					markComposite(elementTypeProvider.getEntityWithEnumAndReference_TypeKindOfKeywordEnumRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleKindOfKeyword_in_ruleEntityWithEnumAndReference101);
            ruleKindOfKeyword();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:75:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:76:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:76:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:77:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEntityWithEnumAndReference139); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getEntityWithEnumAndReference_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleEntityWithEnumAndReference164); 

            			doneLeaf(otherlv_2, elementTypeProvider.getEntityWithEnumAndReference_ReferenceKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:93:3: ( (otherlv_3= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:94:4: (otherlv_3= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:94:4: (otherlv_3= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:95:5: otherlv_3= RULE_ID
            {

            					markLeaf();
            				
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEntityWithEnumAndReference191); 

            					doneLeaf(otherlv_3, elementTypeProvider.getEntityWithEnumAndReference_RefEntityWithEnumAndReferenceCrossReference_3_0ElementType());
            				

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
    // $ANTLR end "ruleEntityWithEnumAndReference"


    // $ANTLR start "ruleKindOfKeyword"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:108:1: ruleKindOfKeyword : ( (enumLiteral_0= 'kindOfKeyword' ) | (enumLiteral_1= 'anotherEnumLiteral' ) ) ;
    public final void ruleKindOfKeyword() throws RecognitionException {
        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:108:18: ( ( (enumLiteral_0= 'kindOfKeyword' ) | (enumLiteral_1= 'anotherEnumLiteral' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:109:2: ( (enumLiteral_0= 'kindOfKeyword' ) | (enumLiteral_1= 'anotherEnumLiteral' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:109:2: ( (enumLiteral_0= 'kindOfKeyword' ) | (enumLiteral_1= 'anotherEnumLiteral' ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            else if ( (LA1_0==13) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:110:3: (enumLiteral_0= 'kindOfKeyword' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:110:3: (enumLiteral_0= 'kindOfKeyword' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:111:4: enumLiteral_0= 'kindOfKeyword'
                    {

                    				markLeaf();
                    			
                    enumLiteral_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleKindOfKeyword235); 

                    				doneLeaf(enumLiteral_0, elementTypeProvider.getKindOfKeyword_KindOfKeywordEnumLiteralDeclaration_0ElementType());
                    			

                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:120:3: (enumLiteral_1= 'anotherEnumLiteral' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:120:3: (enumLiteral_1= 'anotherEnumLiteral' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumAndReferenceTestLanguage.g:121:4: enumLiteral_1= 'anotherEnumLiteral'
                    {

                    				markLeaf();
                    			
                    enumLiteral_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleKindOfKeyword268); 

                    				doneLeaf(enumLiteral_1, elementTypeProvider.getKindOfKeyword_AnotherEnumLiteralEnumLiteralDeclaration_1ElementType());
                    			

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
    // $ANTLR end "ruleKindOfKeyword"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleEntityWithEnumAndReference_in_entryRuleEntityWithEnumAndReference54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEntityWithEnumAndReference60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleKindOfKeyword_in_ruleEntityWithEnumAndReference101 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEntityWithEnumAndReference139 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_11_in_ruleEntityWithEnumAndReference164 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEntityWithEnumAndReference191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleKindOfKeyword235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleKindOfKeyword268 = new BitSet(new long[]{0x0000000000000002L});
    }


}