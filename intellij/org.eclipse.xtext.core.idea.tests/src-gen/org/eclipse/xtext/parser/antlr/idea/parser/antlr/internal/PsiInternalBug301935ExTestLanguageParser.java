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
    // PsiInternalBug301935ExTestLanguage.g:52:1: entryRuleDelegateModel returns [Boolean current=false] : iv_ruleDelegateModel= ruleDelegateModel EOF ;
    public final Boolean entryRuleDelegateModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDelegateModel = null;


        try {
            // PsiInternalBug301935ExTestLanguage.g:52:55: (iv_ruleDelegateModel= ruleDelegateModel EOF )
            // PsiInternalBug301935ExTestLanguage.g:53:2: iv_ruleDelegateModel= ruleDelegateModel EOF
            {
             markComposite(elementTypeProvider.getDelegateModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDelegateModel=ruleDelegateModel();

            state._fsp--;

             current =iv_ruleDelegateModel; 
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
    // $ANTLR end "entryRuleDelegateModel"


    // $ANTLR start "ruleDelegateModel"
    // PsiInternalBug301935ExTestLanguage.g:59:1: ruleDelegateModel returns [Boolean current=false] : this_Model_0= ruleModel ;
    public final Boolean ruleDelegateModel() throws RecognitionException {
        Boolean current = false;

        Boolean this_Model_0 = null;


        try {
            // PsiInternalBug301935ExTestLanguage.g:60:1: (this_Model_0= ruleModel )
            // PsiInternalBug301935ExTestLanguage.g:61:2: this_Model_0= ruleModel
            {

            		markComposite(elementTypeProvider.getDelegateModel_ModelParserRuleCallElementType());
            	
            pushFollow(FollowSets000.FOLLOW_2);
            this_Model_0=ruleModel();

            state._fsp--;


            		current = this_Model_0;
            		doneComposite();
            	

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
    // $ANTLR end "ruleDelegateModel"


    // $ANTLR start "entryRuleModel"
    // PsiInternalBug301935ExTestLanguage.g:72:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalBug301935ExTestLanguage.g:72:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalBug301935ExTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalBug301935ExTestLanguage.g:79:1: ruleModel returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token this_WS_1=null;
        Token lv_value_2_0=null;
        Token lv_value2_4_0=null;
        Token this_WS_5=null;

        try {
            // PsiInternalBug301935ExTestLanguage.g:80:1: ( ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS ) )
            // PsiInternalBug301935ExTestLanguage.g:81:2: ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS )
            {
            // PsiInternalBug301935ExTestLanguage.g:81:2: ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS )
            // PsiInternalBug301935ExTestLanguage.g:82:3: ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS
            {
            // PsiInternalBug301935ExTestLanguage.g:82:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalBug301935ExTestLanguage.g:83:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalBug301935ExTestLanguage.g:83:4: (lv_name_0_0= RULE_ID )
            // PsiInternalBug301935ExTestLanguage.g:84:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getModel_NameIDTerminalRuleCall_0_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getModel_WSTerminalRuleCall_1ElementType());
            		
            this_WS_1=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_4); 

            			doneLeaf(this_WS_1);
            		
            // PsiInternalBug301935ExTestLanguage.g:106:3: ( (lv_value_2_0= RULE_ID ) )
            // PsiInternalBug301935ExTestLanguage.g:107:4: (lv_value_2_0= RULE_ID )
            {
            // PsiInternalBug301935ExTestLanguage.g:107:4: (lv_value_2_0= RULE_ID )
            // PsiInternalBug301935ExTestLanguage.g:108:5: lv_value_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getModel_ValueIDTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_value_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            			markComposite(elementTypeProvider.getModel_NLParserRuleCall_3ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_4);
            ruleNL();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalBug301935ExTestLanguage.g:130:3: ( (lv_value2_4_0= RULE_ID ) )
            // PsiInternalBug301935ExTestLanguage.g:131:4: (lv_value2_4_0= RULE_ID )
            {
            // PsiInternalBug301935ExTestLanguage.g:131:4: (lv_value2_4_0= RULE_ID )
            // PsiInternalBug301935ExTestLanguage.g:132:5: lv_value2_4_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getModel_Value2IDTerminalRuleCall_4_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
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
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleNL"
    // PsiInternalBug301935ExTestLanguage.g:158:1: entryRuleNL returns [Boolean current=false] : iv_ruleNL= ruleNL EOF ;
    public final Boolean entryRuleNL() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNL = null;


        try {
            // PsiInternalBug301935ExTestLanguage.g:158:44: (iv_ruleNL= ruleNL EOF )
            // PsiInternalBug301935ExTestLanguage.g:159:2: iv_ruleNL= ruleNL EOF
            {
             markComposite(elementTypeProvider.getNLElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNL=ruleNL();

            state._fsp--;

             current =iv_ruleNL; 
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
    // $ANTLR end "entryRuleNL"


    // $ANTLR start "ruleNL"
    // PsiInternalBug301935ExTestLanguage.g:165:1: ruleNL returns [Boolean current=false] : ( (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )* ) ;
    public final Boolean ruleNL() throws RecognitionException {
        Boolean current = false;

        Token this_WS_0=null;
        Token kw=null;
        Token this_WS_3=null;

        try {
            // PsiInternalBug301935ExTestLanguage.g:166:1: ( ( (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )* ) )
            // PsiInternalBug301935ExTestLanguage.g:167:2: ( (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )* )
            {
            // PsiInternalBug301935ExTestLanguage.g:167:2: ( (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )* )
            // PsiInternalBug301935ExTestLanguage.g:168:3: (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )*
            {
            // PsiInternalBug301935ExTestLanguage.g:168:3: (this_WS_0= RULE_WS )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_WS) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalBug301935ExTestLanguage.g:169:4: this_WS_0= RULE_WS
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

            // PsiInternalBug301935ExTestLanguage.g:177:3: ( (kw= '\\r' )? kw= '\\n' )
            // PsiInternalBug301935ExTestLanguage.g:178:4: (kw= '\\r' )? kw= '\\n'
            {
            // PsiInternalBug301935ExTestLanguage.g:178:4: (kw= '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==7) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalBug301935ExTestLanguage.g:179:5: kw= '\\r'
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

            // PsiInternalBug301935ExTestLanguage.g:195:3: (this_WS_3= RULE_WS )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_WS) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // PsiInternalBug301935ExTestLanguage.g:196:4: this_WS_3= RULE_WS
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
        return current;
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