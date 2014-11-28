package org.eclipse.xtext.idea.common.types.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalRefactoringTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'.'", "'$'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalRefactoringTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalRefactoringTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalRefactoringTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g"; }



    public RefactoringTestLanguageElementTypeProvider elementTypeProvider;

    public PsiInternalRefactoringTestLanguageParser(PsiBuilder builder, TokenStream input, TokenTypeProvider tokenTypeProvider, RefactoringTestLanguageElementTypeProvider elementTypeProvider) {
    	super(builder, input, tokenTypeProvider);
    	this.elementTypeProvider = elementTypeProvider;
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
    }




    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:45:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:45:15: ( ruleModel EOF )
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:46:2: ruleModel EOF
            {
             markComposite(); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel54);
            ruleModel();

            state._fsp--;

             doneComposite(elementTypeProvider.getModelElementType()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel60); 

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
    // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:54:1: ruleModel : ( (lv_referenceHolder_0_0= ruleReferenceHolder ) )* ;
    public final void ruleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:54:10: ( ( (lv_referenceHolder_0_0= ruleReferenceHolder ) )* )
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:55:2: ( (lv_referenceHolder_0_0= ruleReferenceHolder ) )*
            {
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:55:2: ( (lv_referenceHolder_0_0= ruleReferenceHolder ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:56:3: (lv_referenceHolder_0_0= ruleReferenceHolder )
            	    {
            	    // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:56:3: (lv_referenceHolder_0_0= ruleReferenceHolder )
            	    // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:57:4: lv_referenceHolder_0_0= ruleReferenceHolder
            	    {

            	    				markComposite();
            	    			
            	    pushFollow(FOLLOW_ruleReferenceHolder_in_ruleModel89);
            	    ruleReferenceHolder();

            	    state._fsp--;


            	    				doneComposite(elementTypeProvider.getModel_ReferenceHolderReferenceHolderParserRuleCall_0ElementType());
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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


    // $ANTLR start "entryRuleReferenceHolder"
    // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:69:1: entryRuleReferenceHolder : ruleReferenceHolder EOF ;
    public final void entryRuleReferenceHolder() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:69:25: ( ruleReferenceHolder EOF )
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:70:2: ruleReferenceHolder EOF
            {
             markComposite(); 
            pushFollow(FOLLOW_ruleReferenceHolder_in_entryRuleReferenceHolder115);
            ruleReferenceHolder();

            state._fsp--;

             doneComposite(elementTypeProvider.getReferenceHolderElementType()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceHolder121); 

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
    // $ANTLR end "entryRuleReferenceHolder"


    // $ANTLR start "ruleReferenceHolder"
    // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:78:1: ruleReferenceHolder : ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleFQN ) ) ) ;
    public final void ruleReferenceHolder() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:78:20: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleFQN ) ) ) )
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:79:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleFQN ) ) )
            {
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:79:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleFQN ) ) )
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:80:3: ( (lv_name_0_0= RULE_ID ) ) ( ( ruleFQN ) )
            {
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:80:3: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:81:4: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:81:4: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:82:5: lv_name_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferenceHolder157); 

            					doneLeaf(lv_name_0_0, elementTypeProvider.getReferenceHolder_NameIDTerminalRuleCall_0_0ElementType());
            				

            }


            }

            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:91:3: ( ( ruleFQN ) )
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:92:4: ( ruleFQN )
            {
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:92:4: ( ruleFQN )
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:93:5: ruleFQN
            {

            					markComposite();
            				
            pushFollow(FOLLOW_ruleFQN_in_ruleReferenceHolder193);
            ruleFQN();

            state._fsp--;


            					doneComposite(elementTypeProvider.getReferenceHolder_DefaultReferenceJvmTypeCrossReference_1_0ElementType());
            				

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
    // $ANTLR end "ruleReferenceHolder"


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:106:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:106:13: ( ruleFQN EOF )
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:107:2: ruleFQN EOF
            {
             markComposite(); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN224);
            ruleFQN();

            state._fsp--;

             doneComposite(elementTypeProvider.getFQNElementType()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN230); 

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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:115:1: ruleFQN : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '$' this_ID_4= RULE_ID )* ) ;
    public final void ruleFQN() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

        try {
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:115:8: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '$' this_ID_4= RULE_ID )* ) )
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:116:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '$' this_ID_4= RULE_ID )* )
            {
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:116:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '$' this_ID_4= RULE_ID )* )
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:117:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '$' this_ID_4= RULE_ID )*
            {

            			markLeaf();
            		
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN253); 

            			doneLeaf(this_ID_0, elementTypeProvider.getFQN_IDTerminalRuleCall_0ElementType());
            		
            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:124:3: (kw= '.' this_ID_2= RULE_ID )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:125:4: kw= '.' this_ID_2= RULE_ID
            	    {

            	    				markLeaf();
            	    			
            	    kw=(Token)match(input,11,FOLLOW_11_in_ruleFQN273); 

            	    				doneLeaf(kw, elementTypeProvider.getFQN_FullStopKeyword_1_0ElementType());
            	    			

            	    				markLeaf();
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN290); 

            	    				doneLeaf(this_ID_2, elementTypeProvider.getFQN_IDTerminalRuleCall_1_1ElementType());
            	    			

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:140:3: (kw= '$' this_ID_4= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==12) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.idea.common.types.tests/src-gen/org/eclipse/xtext/idea/common/types/idea/parser/antlr/internal/PsiInternalRefactoringTestLanguage.g:141:4: kw= '$' this_ID_4= RULE_ID
            	    {

            	    				markLeaf();
            	    			
            	    kw=(Token)match(input,12,FOLLOW_12_in_ruleFQN316); 

            	    				doneLeaf(kw, elementTypeProvider.getFQN_DollarSignKeyword_2_0ElementType());
            	    			

            	    				markLeaf();
            	    			
            	    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN333); 

            	    				doneLeaf(this_ID_4, elementTypeProvider.getFQN_IDTerminalRuleCall_2_1ElementType());
            	    			

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


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
    // $ANTLR end "ruleFQN"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceHolder_in_ruleModel89 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleReferenceHolder_in_entryRuleReferenceHolder115 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceHolder121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceHolder157 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleReferenceHolder193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN224 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN253 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_11_in_ruleFQN273 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN290 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_12_in_ruleFQN316 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN333 = new BitSet(new long[]{0x0000000000001002L});

}