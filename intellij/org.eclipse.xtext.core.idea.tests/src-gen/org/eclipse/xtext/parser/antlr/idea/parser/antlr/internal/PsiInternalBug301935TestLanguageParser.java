package org.eclipse.xtext.parser.antlr.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.services.Bug301935TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalBug301935TestLanguageParser extends AbstractPsiAntlrParser {
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


        public PsiInternalBug301935TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug301935TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug301935TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g"; }



    	protected Bug301935TestLanguageGrammarAccess grammarAccess;

    	protected Bug301935TestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalBug301935TestLanguageParser(PsiBuilder builder, TokenStream input, Bug301935TestLanguageElementTypeProvider elementTypeProvider, Bug301935TestLanguageGrammarAccess grammarAccess) {
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:50:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:50:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:51:2: ruleModel EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:59:1: ruleModel : ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS ) ;
    public final void ruleModel() throws RecognitionException {
        Token lv_name_0_0=null;
        Token this_WS_1=null;
        Token lv_value_2_0=null;
        Token lv_value2_4_0=null;
        Token this_WS_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:59:10: ( ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:60:2: ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:60:2: ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:61:3: ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:61:3: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:62:4: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:62:4: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:63:5: lv_name_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel96); 

            					doneLeaf(lv_name_0_0, elementTypeProvider.getModel_NameIDTerminalRuleCall_0_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            this_WS_1=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleModel121); 

            			doneLeaf(this_WS_1, elementTypeProvider.getModel_WSTerminalRuleCall_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:79:3: ( (lv_value_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:80:4: (lv_value_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:80:4: (lv_value_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:81:5: lv_value_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_value_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel148); 

            					doneLeaf(lv_value_2_0, elementTypeProvider.getModel_ValueIDTerminalRuleCall_2_0ElementType());
            				

            }


            }


            			markComposite(elementTypeProvider.getModel_NLParserRuleCall_3ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleNL_in_ruleModel171);
            ruleNL();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:97:3: ( (lv_value2_4_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:98:4: (lv_value2_4_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:98:4: (lv_value2_4_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:99:5: lv_value2_4_0= RULE_ID
            {

            					markLeaf();
            				
            lv_value2_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel198); 

            					doneLeaf(lv_value2_4_0, elementTypeProvider.getModel_Value2IDTerminalRuleCall_4_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            this_WS_5=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleModel223); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:119:1: entryRuleNL : ruleNL EOF ;
    public final void entryRuleNL() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:119:12: ( ruleNL EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:120:2: ruleNL EOF
            {
             markComposite(elementTypeProvider.getNLElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNL_in_entryRuleNL243);
            ruleNL();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNL249); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:128:1: ruleNL : ( (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )* ) ;
    public final void ruleNL() throws RecognitionException {
        Token this_WS_0=null;
        Token kw=null;
        Token this_WS_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:128:7: ( ( (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:129:2: ( (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:129:2: ( (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:130:3: (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:130:3: (this_WS_0= RULE_WS )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_WS) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:131:4: this_WS_0= RULE_WS
            	    {

            	    				markLeaf();
            	    			
            	    this_WS_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleNL278); 

            	    				doneLeaf(this_WS_0, elementTypeProvider.getNL_WSTerminalRuleCall_0ElementType());
            	    			

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:139:3: ( (kw= '\\r' )? kw= '\\n' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:140:4: (kw= '\\r' )? kw= '\\n'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:140:4: (kw= '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==7) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:141:5: kw= '\\r'
                    {

                    					markLeaf();
                    				
                    kw=(Token)match(input,7,FollowSets000.FOLLOW_7_in_ruleNL311); 

                    					doneLeaf(kw, elementTypeProvider.getNL_CarriageReturnCrKeyword_1_0ElementType());
                    				

                    }
                    break;

            }


            				markLeaf();
            			
            kw=(Token)match(input,8,FollowSets000.FOLLOW_8_in_ruleNL335); 

            				doneLeaf(kw, elementTypeProvider.getNL_LineFeedLfKeyword_1_1ElementType());
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:157:3: (this_WS_3= RULE_WS )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_WS) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/antlr/idea/parser/antlr/internal/PsiInternalBug301935TestLanguage.g:158:4: this_WS_3= RULE_WS
            	    {

            	    				markLeaf();
            	    			
            	    this_WS_3=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleNL360); 

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
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel96 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleModel121 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel148 = new BitSet(new long[]{0x00000000000001A0L});
        public static final BitSet FOLLOW_ruleNL_in_ruleModel171 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel198 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleModel223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNL_in_entryRuleNL243 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNL249 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleNL278 = new BitSet(new long[]{0x00000000000001A0L});
        public static final BitSet FOLLOW_7_in_ruleNL311 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_8_in_ruleNL335 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleNL360 = new BitSet(new long[]{0x0000000000000022L});
    }


}