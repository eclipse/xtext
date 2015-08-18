package org.eclipse.xtext.parser.antlr.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935ExTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
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
    public String getGrammarFileName() { return "PsiInternalBug301935ExTestLanguage.g"; }



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
    // PsiInternalBug301935ExTestLanguage.g:52:1: entryRuleDelegateModel : ruleDelegateModel EOF ;
    public final void entryRuleDelegateModel() throws RecognitionException {
        try {
            // PsiInternalBug301935ExTestLanguage.g:52:23: ( ruleDelegateModel EOF )
            // PsiInternalBug301935ExTestLanguage.g:53:2: ruleDelegateModel EOF
            {
             markComposite(elementTypeProvider.getDelegateModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDelegateModel();

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
    // $ANTLR end "entryRuleDelegateModel"


    // $ANTLR start "ruleDelegateModel"
    // PsiInternalBug301935ExTestLanguage.g:58:1: ruleDelegateModel : ruleModel ;
    public final void ruleDelegateModel() throws RecognitionException {
        try {
            // PsiInternalBug301935ExTestLanguage.g:58:18: ( ruleModel )
            // PsiInternalBug301935ExTestLanguage.g:59:2: ruleModel
            {

            		markComposite(elementTypeProvider.getDelegateModel_ModelParserRuleCallElementType());
            	
            pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalBug301935ExTestLanguage.g:69:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalBug301935ExTestLanguage.g:69:15: ( ruleModel EOF )
            // PsiInternalBug301935ExTestLanguage.g:70:2: ruleModel EOF
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
    // PsiInternalBug301935ExTestLanguage.g:75:1: ruleModel : ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS ) ;
    public final void ruleModel() throws RecognitionException {
        Token lv_name_0_0=null;
        Token this_WS_1=null;
        Token lv_value_2_0=null;
        Token lv_value2_4_0=null;
        Token this_WS_5=null;

        try {
            // PsiInternalBug301935ExTestLanguage.g:75:10: ( ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS ) )
            // PsiInternalBug301935ExTestLanguage.g:76:2: ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS )
            {
            // PsiInternalBug301935ExTestLanguage.g:76:2: ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS )
            // PsiInternalBug301935ExTestLanguage.g:77:3: ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS
            {
            // PsiInternalBug301935ExTestLanguage.g:77:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalBug301935ExTestLanguage.g:78:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalBug301935ExTestLanguage.g:78:4: (lv_name_0_0= RULE_ID )
            // PsiInternalBug301935ExTestLanguage.g:79:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getModel_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getModel_WSTerminalRuleCall_1ElementType());
            		
            this_WS_1=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_4); 

            			doneLeaf(this_WS_1);
            		
            // PsiInternalBug301935ExTestLanguage.g:95:3: ( (lv_value_2_0= RULE_ID ) )
            // PsiInternalBug301935ExTestLanguage.g:96:4: (lv_value_2_0= RULE_ID )
            {
            // PsiInternalBug301935ExTestLanguage.g:96:4: (lv_value_2_0= RULE_ID )
            // PsiInternalBug301935ExTestLanguage.g:97:5: lv_value_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getModel_ValueIDTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            			markComposite(elementTypeProvider.getModel_NLParserRuleCall_3ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_4);
            ruleNL();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalBug301935ExTestLanguage.g:113:3: ( (lv_value2_4_0= RULE_ID ) )
            // PsiInternalBug301935ExTestLanguage.g:114:4: (lv_value2_4_0= RULE_ID )
            {
            // PsiInternalBug301935ExTestLanguage.g:114:4: (lv_value2_4_0= RULE_ID )
            // PsiInternalBug301935ExTestLanguage.g:115:5: lv_value2_4_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getModel_Value2IDTerminalRuleCall_4_0ElementType());
            				
            lv_value2_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					doneLeaf(lv_value2_4_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getModel_WSTerminalRuleCall_5ElementType());
            		
            this_WS_5=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_2); 

            			doneLeaf(this_WS_5);
            		

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
    // PsiInternalBug301935ExTestLanguage.g:135:1: entryRuleNL : ruleNL EOF ;
    public final void entryRuleNL() throws RecognitionException {
        try {
            // PsiInternalBug301935ExTestLanguage.g:135:12: ( ruleNL EOF )
            // PsiInternalBug301935ExTestLanguage.g:136:2: ruleNL EOF
            {
             markComposite(elementTypeProvider.getNLElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNL();

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
    // $ANTLR end "entryRuleNL"


    // $ANTLR start "ruleNL"
    // PsiInternalBug301935ExTestLanguage.g:141:1: ruleNL : ( (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )* ) ;
    public final void ruleNL() throws RecognitionException {
        Token this_WS_0=null;
        Token kw=null;
        Token this_WS_3=null;

        try {
            // PsiInternalBug301935ExTestLanguage.g:141:7: ( ( (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )* ) )
            // PsiInternalBug301935ExTestLanguage.g:142:2: ( (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )* )
            {
            // PsiInternalBug301935ExTestLanguage.g:142:2: ( (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )* )
            // PsiInternalBug301935ExTestLanguage.g:143:3: (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )*
            {
            // PsiInternalBug301935ExTestLanguage.g:143:3: (this_WS_0= RULE_WS )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_WS) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalBug301935ExTestLanguage.g:144:4: this_WS_0= RULE_WS
            	    {

            	    				markLeaf(elementTypeProvider.getNL_WSTerminalRuleCall_0ElementType());
            	    			
            	    this_WS_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_5); 

            	    				doneLeaf(this_WS_0);
            	    			

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // PsiInternalBug301935ExTestLanguage.g:152:3: ( (kw= '\\r' )? kw= '\\n' )
            // PsiInternalBug301935ExTestLanguage.g:153:4: (kw= '\\r' )? kw= '\\n'
            {
            // PsiInternalBug301935ExTestLanguage.g:153:4: (kw= '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==7) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalBug301935ExTestLanguage.g:154:5: kw= '\\r'
                    {

                    					markLeaf(elementTypeProvider.getNL_Control000dKeyword_1_0ElementType());
                    				
                    kw=(Token)match(input,7,FollowSets000.FOLLOW_6); 

                    					doneLeaf(kw);
                    				

                    }
                    break;

            }


            				markLeaf(elementTypeProvider.getNL_Control000aKeyword_1_1ElementType());
            			
            kw=(Token)match(input,8,FollowSets000.FOLLOW_7); 

            				doneLeaf(kw);
            			

            }

            // PsiInternalBug301935ExTestLanguage.g:170:3: (this_WS_3= RULE_WS )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_WS) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // PsiInternalBug301935ExTestLanguage.g:171:4: this_WS_3= RULE_WS
            	    {

            	    				markLeaf(elementTypeProvider.getNL_WSTerminalRuleCall_2ElementType());
            	    			
            	    this_WS_3=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_7); 

            	    				doneLeaf(this_WS_3);
            	    			

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
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000000001A0L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000022L});
    }


}