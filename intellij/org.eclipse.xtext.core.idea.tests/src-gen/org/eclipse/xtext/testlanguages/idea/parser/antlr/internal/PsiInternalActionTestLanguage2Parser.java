package org.eclipse.xtext.testlanguages.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguage2ElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.testlanguages.services.ActionTestLanguage2GrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalActionTestLanguage2Parser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'|'", "'a'"
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


        public PsiInternalActionTestLanguage2Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalActionTestLanguage2Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalActionTestLanguage2Parser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalActionTestLanguage2.g"; }



    	protected ActionTestLanguage2GrammarAccess grammarAccess;

    	protected ActionTestLanguage2ElementTypeProvider elementTypeProvider;

    	public PsiInternalActionTestLanguage2Parser(PsiBuilder builder, TokenStream input, ActionTestLanguage2ElementTypeProvider elementTypeProvider, ActionTestLanguage2GrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "ORing";
    	}




    // $ANTLR start "entryRuleORing"
    // PsiInternalActionTestLanguage2.g:52:1: entryRuleORing : ruleORing EOF ;
    public final void entryRuleORing() throws RecognitionException {
        try {
            // PsiInternalActionTestLanguage2.g:52:15: ( ruleORing EOF )
            // PsiInternalActionTestLanguage2.g:53:2: ruleORing EOF
            {
             markComposite(elementTypeProvider.getORingElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleORing();

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
    // $ANTLR end "entryRuleORing"


    // $ANTLR start "ruleORing"
    // PsiInternalActionTestLanguage2.g:58:1: ruleORing : ( ruleValue ( () otherlv_2= '|' ( (lv_disjuncts_3_0= ruleValue ) ) )* ) ;
    public final void ruleORing() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // PsiInternalActionTestLanguage2.g:58:10: ( ( ruleValue ( () otherlv_2= '|' ( (lv_disjuncts_3_0= ruleValue ) ) )* ) )
            // PsiInternalActionTestLanguage2.g:59:2: ( ruleValue ( () otherlv_2= '|' ( (lv_disjuncts_3_0= ruleValue ) ) )* )
            {
            // PsiInternalActionTestLanguage2.g:59:2: ( ruleValue ( () otherlv_2= '|' ( (lv_disjuncts_3_0= ruleValue ) ) )* )
            // PsiInternalActionTestLanguage2.g:60:3: ruleValue ( () otherlv_2= '|' ( (lv_disjuncts_3_0= ruleValue ) ) )*
            {

            			markComposite(elementTypeProvider.getORing_ValueParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_3);
            ruleValue();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalActionTestLanguage2.g:67:3: ( () otherlv_2= '|' ( (lv_disjuncts_3_0= ruleValue ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalActionTestLanguage2.g:68:4: () otherlv_2= '|' ( (lv_disjuncts_3_0= ruleValue ) )
            	    {
            	    // PsiInternalActionTestLanguage2.g:68:4: ()
            	    // PsiInternalActionTestLanguage2.g:69:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getORing_ORingDisjunctsAction_1_0ElementType());
            	    					doneComposite();
            	    				

            	    }


            	    				markLeaf(elementTypeProvider.getORing_VerticalLineKeyword_1_1ElementType());
            	    			
            	    otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalActionTestLanguage2.g:81:4: ( (lv_disjuncts_3_0= ruleValue ) )
            	    // PsiInternalActionTestLanguage2.g:82:5: (lv_disjuncts_3_0= ruleValue )
            	    {
            	    // PsiInternalActionTestLanguage2.g:82:5: (lv_disjuncts_3_0= ruleValue )
            	    // PsiInternalActionTestLanguage2.g:83:6: lv_disjuncts_3_0= ruleValue
            	    {

            	    						markComposite(elementTypeProvider.getORing_DisjunctsValueParserRuleCall_1_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    ruleValue();

            	    state._fsp--;


            	    						doneComposite();
            	    					

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleORing"


    // $ANTLR start "entryRuleValue"
    // PsiInternalActionTestLanguage2.g:97:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        try {
            // PsiInternalActionTestLanguage2.g:97:15: ( ruleValue EOF )
            // PsiInternalActionTestLanguage2.g:98:2: ruleValue EOF
            {
             markComposite(elementTypeProvider.getValueElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleValue();

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
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // PsiInternalActionTestLanguage2.g:103:1: ruleValue : ( (lv_value_0_0= 'a' ) ) ;
    public final void ruleValue() throws RecognitionException {
        Token lv_value_0_0=null;

        try {
            // PsiInternalActionTestLanguage2.g:103:10: ( ( (lv_value_0_0= 'a' ) ) )
            // PsiInternalActionTestLanguage2.g:104:2: ( (lv_value_0_0= 'a' ) )
            {
            // PsiInternalActionTestLanguage2.g:104:2: ( (lv_value_0_0= 'a' ) )
            // PsiInternalActionTestLanguage2.g:105:3: (lv_value_0_0= 'a' )
            {
            // PsiInternalActionTestLanguage2.g:105:3: (lv_value_0_0= 'a' )
            // PsiInternalActionTestLanguage2.g:106:4: lv_value_0_0= 'a'
            {

            				markLeaf(elementTypeProvider.getValue_ValueAKeyword_0ElementType());
            			
            lv_value_0_0=(Token)match(input,12,FollowSets000.FOLLOW_2); 

            				doneLeaf(lv_value_0_0);
            			

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
    // $ANTLR end "ruleValue"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    }


}