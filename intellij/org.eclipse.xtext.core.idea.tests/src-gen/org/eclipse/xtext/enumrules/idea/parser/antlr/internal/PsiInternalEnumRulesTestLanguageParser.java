package org.eclipse.xtext.enumrules.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.enumrules.idea.lang.EnumRulesTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g"; }



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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:50:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:50:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:51:2: ruleModel EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:59:1: ruleModel : ( (otherlv_0= 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? ) | (otherlv_4= 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) ) ) ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:59:10: ( ( (otherlv_0= 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? ) | (otherlv_4= 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:60:2: ( (otherlv_0= 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? ) | (otherlv_4= 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:60:2: ( (otherlv_0= 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? ) | (otherlv_4= 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:61:3: (otherlv_0= 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:61:3: (otherlv_0= 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:62:4: otherlv_0= 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )?
                    {

                    				markLeaf();
                    			
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel89); 

                    				doneLeaf(otherlv_0, elementTypeProvider.getModel_ExistingKeyword_0_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:69:4: ( (lv_existing_1_0= ruleExistingEnum ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:70:5: (lv_existing_1_0= ruleExistingEnum )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:70:5: (lv_existing_1_0= ruleExistingEnum )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:71:6: lv_existing_1_0= ruleExistingEnum
                    {

                    						markComposite(elementTypeProvider.getModel_ExistingExistingEnumEnumRuleCall_0_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleExistingEnum_in_ruleModel121);
                    ruleExistingEnum();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:80:4: (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==12) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:81:5: otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) )
                            {

                            					markLeaf();
                            				
                            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel158); 

                            					doneLeaf(otherlv_2, elementTypeProvider.getModel_GeneratedKeyword_0_2_0ElementType());
                            				
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:88:5: ( (lv_generated_3_0= ruleGeneratedEnum ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:89:6: (lv_generated_3_0= ruleGeneratedEnum )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:89:6: (lv_generated_3_0= ruleGeneratedEnum )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:90:7: lv_generated_3_0= ruleGeneratedEnum
                            {

                            							markComposite(elementTypeProvider.getModel_GeneratedGeneratedEnumEnumRuleCall_0_2_1_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleGeneratedEnum_in_ruleModel195);
                            ruleGeneratedEnum();

                            state._fsp--;


                            							doneComposite();
                            						

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:102:3: (otherlv_4= 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:102:3: (otherlv_4= 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:103:4: otherlv_4= 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) )
                    {

                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel250); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getModel_GeneratedKeyword_1_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:110:4: ( (lv_generated_5_0= ruleGeneratedEnum ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:111:5: (lv_generated_5_0= ruleGeneratedEnum )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:111:5: (lv_generated_5_0= ruleGeneratedEnum )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:112:6: lv_generated_5_0= ruleGeneratedEnum
                    {

                    						markComposite(elementTypeProvider.getModel_GeneratedGeneratedEnumEnumRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleGeneratedEnum_in_ruleModel282);
                    ruleGeneratedEnum();

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "ruleExistingEnum"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:126:1: ruleExistingEnum : ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'overridden' ) | (enumLiteral_2= 'DifferentLiteral' ) ) ;
    public final void ruleExistingEnum() throws RecognitionException {
        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:126:17: ( ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'overridden' ) | (enumLiteral_2= 'DifferentLiteral' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:127:2: ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'overridden' ) | (enumLiteral_2= 'DifferentLiteral' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:127:2: ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'overridden' ) | (enumLiteral_2= 'DifferentLiteral' ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:128:3: (enumLiteral_0= 'SameName' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:128:3: (enumLiteral_0= 'SameName' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:129:4: enumLiteral_0= 'SameName'
                    {

                    				markLeaf();
                    			
                    enumLiteral_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleExistingEnum333); 

                    				doneLeaf(enumLiteral_0, elementTypeProvider.getExistingEnum_SameNameEnumLiteralDeclaration_0ElementType());
                    			

                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:138:3: (enumLiteral_1= 'overridden' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:138:3: (enumLiteral_1= 'overridden' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:139:4: enumLiteral_1= 'overridden'
                    {

                    				markLeaf();
                    			
                    enumLiteral_1=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleExistingEnum366); 

                    				doneLeaf(enumLiteral_1, elementTypeProvider.getExistingEnum_OverriddenLiteralEnumLiteralDeclaration_1ElementType());
                    			

                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:148:3: (enumLiteral_2= 'DifferentLiteral' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:148:3: (enumLiteral_2= 'DifferentLiteral' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:149:4: enumLiteral_2= 'DifferentLiteral'
                    {

                    				markLeaf();
                    			
                    enumLiteral_2=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleExistingEnum399); 

                    				doneLeaf(enumLiteral_2, elementTypeProvider.getExistingEnum_DifferentNameEnumLiteralDeclaration_2ElementType());
                    			

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
    // $ANTLR end "ruleExistingEnum"


    // $ANTLR start "ruleGeneratedEnum"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:161:1: ruleGeneratedEnum : ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'DifferentLiteral' ) ) ;
    public final void ruleGeneratedEnum() throws RecognitionException {
        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:161:18: ( ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'DifferentLiteral' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:162:2: ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'DifferentLiteral' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:162:2: ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'DifferentLiteral' ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:163:3: (enumLiteral_0= 'SameName' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:163:3: (enumLiteral_0= 'SameName' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:164:4: enumLiteral_0= 'SameName'
                    {

                    				markLeaf();
                    			
                    enumLiteral_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleGeneratedEnum437); 

                    				doneLeaf(enumLiteral_0, elementTypeProvider.getGeneratedEnum_SameNameEnumLiteralDeclaration_0ElementType());
                    			

                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:173:3: (enumLiteral_1= 'DifferentLiteral' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:173:3: (enumLiteral_1= 'DifferentLiteral' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/enumrules/idea/parser/antlr/internal/PsiInternalEnumRulesTestLanguage.g:174:4: enumLiteral_1= 'DifferentLiteral'
                    {

                    				markLeaf();
                    			
                    enumLiteral_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleGeneratedEnum470); 

                    				doneLeaf(enumLiteral_1, elementTypeProvider.getGeneratedEnum_DifferentNameEnumLiteralDeclaration_1ElementType());
                    			

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
    // $ANTLR end "ruleGeneratedEnum"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel89 = new BitSet(new long[]{0x000000000000E000L});
        public static final BitSet FOLLOW_ruleExistingEnum_in_ruleModel121 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_12_in_ruleModel158 = new BitSet(new long[]{0x000000000000A000L});
        public static final BitSet FOLLOW_ruleGeneratedEnum_in_ruleModel195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleModel250 = new BitSet(new long[]{0x000000000000A000L});
        public static final BitSet FOLLOW_ruleGeneratedEnum_in_ruleModel282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleExistingEnum333 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleExistingEnum366 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleExistingEnum399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleGeneratedEnum437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleGeneratedEnum470 = new BitSet(new long[]{0x0000000000000002L});
    }


}