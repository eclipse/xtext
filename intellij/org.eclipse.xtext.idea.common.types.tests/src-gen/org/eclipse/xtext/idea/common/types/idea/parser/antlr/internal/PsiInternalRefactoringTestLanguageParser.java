package org.eclipse.xtext.idea.common.types.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.idea.common.types.services.RefactoringTestLanguageGrammarAccess;

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
    public String getGrammarFileName() { return "PsiInternalRefactoringTestLanguage.g"; }



    	protected RefactoringTestLanguageGrammarAccess grammarAccess;

    	protected RefactoringTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalRefactoringTestLanguageParser(PsiBuilder builder, TokenStream input, RefactoringTestLanguageElementTypeProvider elementTypeProvider, RefactoringTestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalRefactoringTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalRefactoringTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalRefactoringTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

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
    // PsiInternalRefactoringTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( (lv_referenceHolder_0_0= ruleReferenceHolder ) )* ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean lv_referenceHolder_0_0 = null;


        try {
            // PsiInternalRefactoringTestLanguage.g:60:1: ( ( (lv_referenceHolder_0_0= ruleReferenceHolder ) )* )
            // PsiInternalRefactoringTestLanguage.g:61:2: ( (lv_referenceHolder_0_0= ruleReferenceHolder ) )*
            {
            // PsiInternalRefactoringTestLanguage.g:61:2: ( (lv_referenceHolder_0_0= ruleReferenceHolder ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalRefactoringTestLanguage.g:62:3: (lv_referenceHolder_0_0= ruleReferenceHolder )
            	    {
            	    // PsiInternalRefactoringTestLanguage.g:62:3: (lv_referenceHolder_0_0= ruleReferenceHolder )
            	    // PsiInternalRefactoringTestLanguage.g:63:4: lv_referenceHolder_0_0= ruleReferenceHolder
            	    {

            	    				markComposite(elementTypeProvider.getModel_ReferenceHolderReferenceHolderParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_referenceHolder_0_0=ruleReferenceHolder();

            	    state._fsp--;


            	    				doneComposite();
            	    				if(!current) {
            	    					associateWithSemanticElement();
            	    					current = true;
            	    				}
            	    			

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
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleReferenceHolder"
    // PsiInternalRefactoringTestLanguage.g:79:1: entryRuleReferenceHolder returns [Boolean current=false] : iv_ruleReferenceHolder= ruleReferenceHolder EOF ;
    public final Boolean entryRuleReferenceHolder() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleReferenceHolder = null;


        try {
            // PsiInternalRefactoringTestLanguage.g:79:57: (iv_ruleReferenceHolder= ruleReferenceHolder EOF )
            // PsiInternalRefactoringTestLanguage.g:80:2: iv_ruleReferenceHolder= ruleReferenceHolder EOF
            {
             markComposite(elementTypeProvider.getReferenceHolderElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleReferenceHolder=ruleReferenceHolder();

            state._fsp--;

             current =iv_ruleReferenceHolder; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleReferenceHolder"


    // $ANTLR start "ruleReferenceHolder"
    // PsiInternalRefactoringTestLanguage.g:86:1: ruleReferenceHolder returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleFQN ) ) ) ;
    public final Boolean ruleReferenceHolder() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;

        try {
            // PsiInternalRefactoringTestLanguage.g:87:1: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleFQN ) ) ) )
            // PsiInternalRefactoringTestLanguage.g:88:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleFQN ) ) )
            {
            // PsiInternalRefactoringTestLanguage.g:88:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleFQN ) ) )
            // PsiInternalRefactoringTestLanguage.g:89:3: ( (lv_name_0_0= RULE_ID ) ) ( ( ruleFQN ) )
            {
            // PsiInternalRefactoringTestLanguage.g:89:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalRefactoringTestLanguage.g:90:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalRefactoringTestLanguage.g:90:4: (lv_name_0_0= RULE_ID )
            // PsiInternalRefactoringTestLanguage.g:91:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getReferenceHolder_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }

            // PsiInternalRefactoringTestLanguage.g:106:3: ( ( ruleFQN ) )
            // PsiInternalRefactoringTestLanguage.g:107:4: ( ruleFQN )
            {
            // PsiInternalRefactoringTestLanguage.g:107:4: ( ruleFQN )
            // PsiInternalRefactoringTestLanguage.g:108:5: ruleFQN
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markComposite(elementTypeProvider.getReferenceHolder_DefaultReferenceJvmTypeCrossReference_1_0ElementType());
            				
            pushFollow(FOLLOW_2);
            ruleFQN();

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
        return current;
    }
    // $ANTLR end "ruleReferenceHolder"


    // $ANTLR start "entryRuleFQN"
    // PsiInternalRefactoringTestLanguage.g:127:1: entryRuleFQN returns [Boolean current=false] : iv_ruleFQN= ruleFQN EOF ;
    public final Boolean entryRuleFQN() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFQN = null;


        try {
            // PsiInternalRefactoringTestLanguage.g:127:45: (iv_ruleFQN= ruleFQN EOF )
            // PsiInternalRefactoringTestLanguage.g:128:2: iv_ruleFQN= ruleFQN EOF
            {
             markComposite(elementTypeProvider.getFQNElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // PsiInternalRefactoringTestLanguage.g:134:1: ruleFQN returns [Boolean current=false] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '$' this_ID_4= RULE_ID )* ) ;
    public final Boolean ruleFQN() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

        try {
            // PsiInternalRefactoringTestLanguage.g:135:1: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '$' this_ID_4= RULE_ID )* ) )
            // PsiInternalRefactoringTestLanguage.g:136:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '$' this_ID_4= RULE_ID )* )
            {
            // PsiInternalRefactoringTestLanguage.g:136:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '$' this_ID_4= RULE_ID )* )
            // PsiInternalRefactoringTestLanguage.g:137:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '$' this_ID_4= RULE_ID )*
            {

            			markLeaf(elementTypeProvider.getFQN_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            			doneLeaf(this_ID_0);
            		
            // PsiInternalRefactoringTestLanguage.g:144:3: (kw= '.' this_ID_2= RULE_ID )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalRefactoringTestLanguage.g:145:4: kw= '.' this_ID_2= RULE_ID
            	    {

            	    				markLeaf(elementTypeProvider.getFQN_FullStopKeyword_1_0ElementType());
            	    			
            	    kw=(Token)match(input,11,FOLLOW_4); 

            	    				doneLeaf(kw);
            	    			

            	    				markLeaf(elementTypeProvider.getFQN_IDTerminalRuleCall_1_1ElementType());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_5); 

            	    				doneLeaf(this_ID_2);
            	    			

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // PsiInternalRefactoringTestLanguage.g:160:3: (kw= '$' this_ID_4= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==12) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // PsiInternalRefactoringTestLanguage.g:161:4: kw= '$' this_ID_4= RULE_ID
            	    {

            	    				markLeaf(elementTypeProvider.getFQN_DollarSignKeyword_2_0ElementType());
            	    			
            	    kw=(Token)match(input,12,FOLLOW_4); 

            	    				doneLeaf(kw);
            	    			

            	    				markLeaf(elementTypeProvider.getFQN_IDTerminalRuleCall_2_1ElementType());
            	    			
            	    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_6); 

            	    				doneLeaf(this_ID_4);
            	    			

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
        return current;
    }
    // $ANTLR end "ruleFQN"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001002L});

}