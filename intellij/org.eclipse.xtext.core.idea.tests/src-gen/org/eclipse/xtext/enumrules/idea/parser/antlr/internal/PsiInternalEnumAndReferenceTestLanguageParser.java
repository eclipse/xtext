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
    public String getGrammarFileName() { return "PsiInternalEnumAndReferenceTestLanguage.g"; }



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
    // PsiInternalEnumAndReferenceTestLanguage.g:52:1: entryRuleEntityWithEnumAndReference returns [Boolean current=false] : iv_ruleEntityWithEnumAndReference= ruleEntityWithEnumAndReference EOF ;
    public final Boolean entryRuleEntityWithEnumAndReference() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEntityWithEnumAndReference = null;


        try {
            // PsiInternalEnumAndReferenceTestLanguage.g:52:68: (iv_ruleEntityWithEnumAndReference= ruleEntityWithEnumAndReference EOF )
            // PsiInternalEnumAndReferenceTestLanguage.g:53:2: iv_ruleEntityWithEnumAndReference= ruleEntityWithEnumAndReference EOF
            {
             markComposite(elementTypeProvider.getEntityWithEnumAndReferenceElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEntityWithEnumAndReference=ruleEntityWithEnumAndReference();

            state._fsp--;

             current =iv_ruleEntityWithEnumAndReference; 
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
    // $ANTLR end "entryRuleEntityWithEnumAndReference"


    // $ANTLR start "ruleEntityWithEnumAndReference"
    // PsiInternalEnumAndReferenceTestLanguage.g:59:1: ruleEntityWithEnumAndReference returns [Boolean current=false] : ( ( (lv_type_0_0= ruleKindOfKeyword ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) ) ;
    public final Boolean ruleEntityWithEnumAndReference() throws RecognitionException {
        Boolean current = false;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Boolean lv_type_0_0 = null;


        try {
            // PsiInternalEnumAndReferenceTestLanguage.g:60:1: ( ( ( (lv_type_0_0= ruleKindOfKeyword ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) ) )
            // PsiInternalEnumAndReferenceTestLanguage.g:61:2: ( ( (lv_type_0_0= ruleKindOfKeyword ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) )
            {
            // PsiInternalEnumAndReferenceTestLanguage.g:61:2: ( ( (lv_type_0_0= ruleKindOfKeyword ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) )
            // PsiInternalEnumAndReferenceTestLanguage.g:62:3: ( (lv_type_0_0= ruleKindOfKeyword ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) )
            {
            // PsiInternalEnumAndReferenceTestLanguage.g:62:3: ( (lv_type_0_0= ruleKindOfKeyword ) )
            // PsiInternalEnumAndReferenceTestLanguage.g:63:4: (lv_type_0_0= ruleKindOfKeyword )
            {
            // PsiInternalEnumAndReferenceTestLanguage.g:63:4: (lv_type_0_0= ruleKindOfKeyword )
            // PsiInternalEnumAndReferenceTestLanguage.g:64:5: lv_type_0_0= ruleKindOfKeyword
            {

            					markComposite(elementTypeProvider.getEntityWithEnumAndReference_TypeKindOfKeywordEnumRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_3);
            lv_type_0_0=ruleKindOfKeyword();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalEnumAndReferenceTestLanguage.g:77:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalEnumAndReferenceTestLanguage.g:78:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalEnumAndReferenceTestLanguage.g:78:4: (lv_name_1_0= RULE_ID )
            // PsiInternalEnumAndReferenceTestLanguage.g:79:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEntityWithEnumAndReference_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getEntityWithEnumAndReference_ReferenceKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalEnumAndReferenceTestLanguage.g:101:3: ( (otherlv_3= RULE_ID ) )
            // PsiInternalEnumAndReferenceTestLanguage.g:102:4: (otherlv_3= RULE_ID )
            {
            // PsiInternalEnumAndReferenceTestLanguage.g:102:4: (otherlv_3= RULE_ID )
            // PsiInternalEnumAndReferenceTestLanguage.g:103:5: otherlv_3= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getEntityWithEnumAndReference_RefEntityWithEnumAndReferenceCrossReference_3_0ElementType());
            				
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(otherlv_3);
            				

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
    // $ANTLR end "ruleEntityWithEnumAndReference"


    // $ANTLR start "ruleKindOfKeyword"
    // PsiInternalEnumAndReferenceTestLanguage.g:122:1: ruleKindOfKeyword returns [Boolean current=false] : ( (enumLiteral_0= 'kindOfKeyword' ) | (enumLiteral_1= 'anotherEnumLiteral' ) ) ;
    public final Boolean ruleKindOfKeyword() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

        try {
            // PsiInternalEnumAndReferenceTestLanguage.g:123:1: ( ( (enumLiteral_0= 'kindOfKeyword' ) | (enumLiteral_1= 'anotherEnumLiteral' ) ) )
            // PsiInternalEnumAndReferenceTestLanguage.g:124:2: ( (enumLiteral_0= 'kindOfKeyword' ) | (enumLiteral_1= 'anotherEnumLiteral' ) )
            {
            // PsiInternalEnumAndReferenceTestLanguage.g:124:2: ( (enumLiteral_0= 'kindOfKeyword' ) | (enumLiteral_1= 'anotherEnumLiteral' ) )
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
                    // PsiInternalEnumAndReferenceTestLanguage.g:125:3: (enumLiteral_0= 'kindOfKeyword' )
                    {
                    // PsiInternalEnumAndReferenceTestLanguage.g:125:3: (enumLiteral_0= 'kindOfKeyword' )
                    // PsiInternalEnumAndReferenceTestLanguage.g:126:4: enumLiteral_0= 'kindOfKeyword'
                    {

                    				markLeaf(elementTypeProvider.getKindOfKeyword_KindOfKeywordEnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,12,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEnumAndReferenceTestLanguage.g:135:3: (enumLiteral_1= 'anotherEnumLiteral' )
                    {
                    // PsiInternalEnumAndReferenceTestLanguage.g:135:3: (enumLiteral_1= 'anotherEnumLiteral' )
                    // PsiInternalEnumAndReferenceTestLanguage.g:136:4: enumLiteral_1= 'anotherEnumLiteral'
                    {

                    				markLeaf(elementTypeProvider.getKindOfKeyword_AnotherEnumLiteralEnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_1);
                    			

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
    // $ANTLR end "ruleKindOfKeyword"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000800L});
    }


}