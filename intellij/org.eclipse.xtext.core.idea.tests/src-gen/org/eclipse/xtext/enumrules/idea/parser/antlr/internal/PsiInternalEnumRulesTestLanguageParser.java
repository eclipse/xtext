package org.eclipse.xtext.enumrules.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.enumrules.idea.lang.EnumRulesTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.enumrules.services.EnumRulesTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalEnumRulesTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'existing'", "'generated'", "'SameName'", "'overridden'", "'DifferentLiteral'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
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


        public PsiInternalEnumRulesTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalEnumRulesTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalEnumRulesTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalEnumRulesTestLanguage.g"; }



    	protected EnumRulesTestLanguageGrammarAccess grammarAccess;

    	protected EnumRulesTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalEnumRulesTestLanguageParser(PsiBuilder builder, TokenStream input, EnumRulesTestLanguageElementTypeProvider elementTypeProvider, EnumRulesTestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalEnumRulesTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalEnumRulesTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalEnumRulesTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalEnumRulesTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( (otherlv_0= 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? ) | (otherlv_4= 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) ) ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean lv_existing_1_0 = null;

        Boolean lv_generated_3_0 = null;

        Boolean lv_generated_5_0 = null;


        try {
            // PsiInternalEnumRulesTestLanguage.g:60:1: ( ( (otherlv_0= 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? ) | (otherlv_4= 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) ) ) )
            // PsiInternalEnumRulesTestLanguage.g:61:2: ( (otherlv_0= 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? ) | (otherlv_4= 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) ) )
            {
            // PsiInternalEnumRulesTestLanguage.g:61:2: ( (otherlv_0= 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? ) | (otherlv_4= 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalEnumRulesTestLanguage.g:62:3: (otherlv_0= 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? )
                    {
                    // PsiInternalEnumRulesTestLanguage.g:62:3: (otherlv_0= 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? )
                    // PsiInternalEnumRulesTestLanguage.g:63:4: otherlv_0= 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )?
                    {

                    				markLeaf(elementTypeProvider.getModel_ExistingKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalEnumRulesTestLanguage.g:70:4: ( (lv_existing_1_0= ruleExistingEnum ) )
                    // PsiInternalEnumRulesTestLanguage.g:71:5: (lv_existing_1_0= ruleExistingEnum )
                    {
                    // PsiInternalEnumRulesTestLanguage.g:71:5: (lv_existing_1_0= ruleExistingEnum )
                    // PsiInternalEnumRulesTestLanguage.g:72:6: lv_existing_1_0= ruleExistingEnum
                    {

                    						markComposite(elementTypeProvider.getModel_ExistingExistingEnumEnumRuleCall_0_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_4);
                    lv_existing_1_0=ruleExistingEnum();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }

                    // PsiInternalEnumRulesTestLanguage.g:85:4: (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==12) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // PsiInternalEnumRulesTestLanguage.g:86:5: otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) )
                            {

                            					markLeaf(elementTypeProvider.getModel_GeneratedKeyword_0_2_0ElementType());
                            				
                            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                            					doneLeaf(otherlv_2);
                            				
                            // PsiInternalEnumRulesTestLanguage.g:93:5: ( (lv_generated_3_0= ruleGeneratedEnum ) )
                            // PsiInternalEnumRulesTestLanguage.g:94:6: (lv_generated_3_0= ruleGeneratedEnum )
                            {
                            // PsiInternalEnumRulesTestLanguage.g:94:6: (lv_generated_3_0= ruleGeneratedEnum )
                            // PsiInternalEnumRulesTestLanguage.g:95:7: lv_generated_3_0= ruleGeneratedEnum
                            {

                            							markComposite(elementTypeProvider.getModel_GeneratedGeneratedEnumEnumRuleCall_0_2_1_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_generated_3_0=ruleGeneratedEnum();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
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
                    break;
                case 2 :
                    // PsiInternalEnumRulesTestLanguage.g:111:3: (otherlv_4= 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) )
                    {
                    // PsiInternalEnumRulesTestLanguage.g:111:3: (otherlv_4= 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) )
                    // PsiInternalEnumRulesTestLanguage.g:112:4: otherlv_4= 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_GeneratedKeyword_1_0ElementType());
                    			
                    otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalEnumRulesTestLanguage.g:119:4: ( (lv_generated_5_0= ruleGeneratedEnum ) )
                    // PsiInternalEnumRulesTestLanguage.g:120:5: (lv_generated_5_0= ruleGeneratedEnum )
                    {
                    // PsiInternalEnumRulesTestLanguage.g:120:5: (lv_generated_5_0= ruleGeneratedEnum )
                    // PsiInternalEnumRulesTestLanguage.g:121:6: lv_generated_5_0= ruleGeneratedEnum
                    {

                    						markComposite(elementTypeProvider.getModel_GeneratedGeneratedEnumEnumRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_generated_5_0=ruleGeneratedEnum();

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


    // $ANTLR start "ruleExistingEnum"
    // PsiInternalEnumRulesTestLanguage.g:139:1: ruleExistingEnum returns [Boolean current=false] : ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'overridden' ) | (enumLiteral_2= 'DifferentLiteral' ) ) ;
    public final Boolean ruleExistingEnum() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

        try {
            // PsiInternalEnumRulesTestLanguage.g:140:1: ( ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'overridden' ) | (enumLiteral_2= 'DifferentLiteral' ) ) )
            // PsiInternalEnumRulesTestLanguage.g:141:2: ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'overridden' ) | (enumLiteral_2= 'DifferentLiteral' ) )
            {
            // PsiInternalEnumRulesTestLanguage.g:141:2: ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'overridden' ) | (enumLiteral_2= 'DifferentLiteral' ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt3=1;
                }
                break;
            case 14:
                {
                alt3=2;
                }
                break;
            case 15:
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
                    // PsiInternalEnumRulesTestLanguage.g:142:3: (enumLiteral_0= 'SameName' )
                    {
                    // PsiInternalEnumRulesTestLanguage.g:142:3: (enumLiteral_0= 'SameName' )
                    // PsiInternalEnumRulesTestLanguage.g:143:4: enumLiteral_0= 'SameName'
                    {

                    				markLeaf(elementTypeProvider.getExistingEnum_SameNameEnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEnumRulesTestLanguage.g:152:3: (enumLiteral_1= 'overridden' )
                    {
                    // PsiInternalEnumRulesTestLanguage.g:152:3: (enumLiteral_1= 'overridden' )
                    // PsiInternalEnumRulesTestLanguage.g:153:4: enumLiteral_1= 'overridden'
                    {

                    				markLeaf(elementTypeProvider.getExistingEnum_OverriddenLiteralEnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_1);
                    			

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalEnumRulesTestLanguage.g:162:3: (enumLiteral_2= 'DifferentLiteral' )
                    {
                    // PsiInternalEnumRulesTestLanguage.g:162:3: (enumLiteral_2= 'DifferentLiteral' )
                    // PsiInternalEnumRulesTestLanguage.g:163:4: enumLiteral_2= 'DifferentLiteral'
                    {

                    				markLeaf(elementTypeProvider.getExistingEnum_DifferentNameEnumLiteralDeclaration_2ElementType());
                    			
                    enumLiteral_2=(Token)match(input,15,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleExistingEnum"


    // $ANTLR start "ruleGeneratedEnum"
    // PsiInternalEnumRulesTestLanguage.g:175:1: ruleGeneratedEnum returns [Boolean current=false] : ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'DifferentLiteral' ) ) ;
    public final Boolean ruleGeneratedEnum() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

        try {
            // PsiInternalEnumRulesTestLanguage.g:176:1: ( ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'DifferentLiteral' ) ) )
            // PsiInternalEnumRulesTestLanguage.g:177:2: ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'DifferentLiteral' ) )
            {
            // PsiInternalEnumRulesTestLanguage.g:177:2: ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'DifferentLiteral' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            else if ( (LA4_0==15) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalEnumRulesTestLanguage.g:178:3: (enumLiteral_0= 'SameName' )
                    {
                    // PsiInternalEnumRulesTestLanguage.g:178:3: (enumLiteral_0= 'SameName' )
                    // PsiInternalEnumRulesTestLanguage.g:179:4: enumLiteral_0= 'SameName'
                    {

                    				markLeaf(elementTypeProvider.getGeneratedEnum_SameNameEnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEnumRulesTestLanguage.g:188:3: (enumLiteral_1= 'DifferentLiteral' )
                    {
                    // PsiInternalEnumRulesTestLanguage.g:188:3: (enumLiteral_1= 'DifferentLiteral' )
                    // PsiInternalEnumRulesTestLanguage.g:189:4: enumLiteral_1= 'DifferentLiteral'
                    {

                    				markLeaf(elementTypeProvider.getGeneratedEnum_DifferentNameEnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,15,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleGeneratedEnum"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000000000E000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000000A000L});
    }


}