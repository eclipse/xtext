package org.eclipse.xtext.parser.antlr.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935ExTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.services.Bug301935ExTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalBug301935ExTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_WS", "RULE_ANY_OTHER", "'\\r'", "'\\n'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_ANY_OTHER=6;
    public static final int RULE_WS=5;
    public static final int EOF=-1;
    public static final int T__8=8;
    public static final int T__7=7;

    // delegates
    // delegators


        public PsiInternalBug301935ExTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug301935ExTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug301935ExTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g"; }



    	protected Bug301935ExTestLanguageGrammarAccess grammarAccess;

    	protected Bug301935ExTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalBug301935ExTestLanguageParser(PsiBuilder builder, TokenStream input, Bug301935ExTestLanguageElementTypeProvider elementTypeProvider, Bug301935ExTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "DelegateModel";
    	}




    // $ANTLR start "entryRuleDelegateModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:50:1: entryRuleDelegateModel : ruleDelegateModel EOF ;
    public final void entryRuleDelegateModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:50:23: ( ruleDelegateModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:51:2: ruleDelegateModel EOF
            {
             markComposite(elementTypeProvider.getDelegateModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDelegateModel_in_entryRuleDelegateModel54);
            ruleDelegateModel();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDelegateModel60); 

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
    // $ANTLR end "entryRuleDelegateModel"


    // $ANTLR start "ruleDelegateModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:59:1: ruleDelegateModel : ruleModel ;
    public final void ruleDelegateModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:59:18: ( ruleModel )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:60:2: ruleModel
            {

            		markComposite(elementTypeProvider.getDelegateModel_ModelParserRuleCallElementType());
            	
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_ruleDelegateModel76);
            ruleModel();

            state._fsp--;


            		doneComposite();
            	

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
    // $ANTLR end "ruleDelegateModel"


    // $ANTLR start "entryRuleModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:70:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:70:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:71:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel92);
            ruleModel();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel98); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:79:1: ruleModel : ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS ) ;
    public final void ruleModel() throws RecognitionException {
        Token lv_name_0_0=null;
        Token this_WS_1=null;
        Token lv_value_2_0=null;
        Token lv_value2_4_0=null;
        Token this_WS_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:79:10: ( ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:80:2: ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:80:2: ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:81:3: ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:81:3: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:82:4: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:82:4: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:83:5: lv_name_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel134); 

            					doneLeaf(lv_name_0_0, elementTypeProvider.getModel_NameIDTerminalRuleCall_0_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            this_WS_1=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleModel159); 

            			doneLeaf(this_WS_1, elementTypeProvider.getModel_WSTerminalRuleCall_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:99:3: ( (lv_value_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:100:4: (lv_value_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:100:4: (lv_value_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:101:5: lv_value_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_value_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel186); 

            					doneLeaf(lv_value_2_0, elementTypeProvider.getModel_ValueIDTerminalRuleCall_2_0ElementType());
            				

            }


            }


            			markComposite(elementTypeProvider.getModel_NLParserRuleCall_3ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleNL_in_ruleModel209);
            ruleNL();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:117:3: ( (lv_value2_4_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:118:4: (lv_value2_4_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:118:4: (lv_value2_4_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:119:5: lv_value2_4_0= RULE_ID
            {

            					markLeaf();
            				
            lv_value2_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel236); 

            					doneLeaf(lv_value2_4_0, elementTypeProvider.getModel_Value2IDTerminalRuleCall_4_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            this_WS_5=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleModel261); 

            			doneLeaf(this_WS_5, elementTypeProvider.getModel_WSTerminalRuleCall_5ElementType());
            		

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


    // $ANTLR start "entryRuleNL"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:139:1: entryRuleNL : ruleNL EOF ;
    public final void entryRuleNL() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:139:12: ( ruleNL EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:140:2: ruleNL EOF
            {
             markComposite(elementTypeProvider.getNLElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNL_in_entryRuleNL281);
            ruleNL();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNL287); 

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
    // $ANTLR end "entryRuleNL"


    // $ANTLR start "ruleNL"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:148:1: ruleNL : ( (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )* ) ;
    public final void ruleNL() throws RecognitionException {
        Token this_WS_0=null;
        Token kw=null;
        Token this_WS_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:148:7: ( ( (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:149:2: ( (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:149:2: ( (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:150:3: (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:150:3: (this_WS_0= RULE_WS )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_WS) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:151:4: this_WS_0= RULE_WS
            	    {

            	    				markLeaf();
            	    			
            	    this_WS_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleNL316); 

            	    				doneLeaf(this_WS_0, elementTypeProvider.getNL_WSTerminalRuleCall_0ElementType());
            	    			

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:159:3: ( (kw= '\\r' )? kw= '\\n' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:160:4: (kw= '\\r' )? kw= '\\n'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:160:4: (kw= '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==7) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:161:5: kw= '\\r'
                    {

                    					markLeaf();
                    				
                    kw=(Token)match(input,7,FollowSets000.FOLLOW_7_in_ruleNL349); 

                    					doneLeaf(kw, elementTypeProvider.getNL_CarriageReturnCrKeyword_1_0ElementType());
                    				

                    }
                    break;

            }


            				markLeaf();
            			
            kw=(Token)match(input,8,FollowSets000.FOLLOW_8_in_ruleNL373); 

            				doneLeaf(kw, elementTypeProvider.getNL_LineFeedLfKeyword_1_1ElementType());
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:177:3: (this_WS_3= RULE_WS )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_WS) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935ExTestLanguage.g:178:4: this_WS_3= RULE_WS
            	    {

            	    				markLeaf();
            	    			
            	    this_WS_3=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleNL398); 

            	    				doneLeaf(this_WS_3, elementTypeProvider.getNL_WSTerminalRuleCall_2ElementType());
            	    			

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
    // $ANTLR end "ruleNL"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleDelegateModel_in_entryRuleDelegateModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDelegateModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModel_in_ruleDelegateModel76 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel92 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel98 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel134 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleModel159 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel186 = new BitSet(new long[]{0x00000000000001A0L});
        public static final BitSet FOLLOW_ruleNL_in_ruleModel209 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel236 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleModel261 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNL_in_entryRuleNL281 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNL287 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleNL316 = new BitSet(new long[]{0x00000000000001A0L});
        public static final BitSet FOLLOW_7_in_ruleNL349 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_8_in_ruleNL373 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleNL398 = new BitSet(new long[]{0x0000000000000022L});
    }


}