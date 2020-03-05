package org.eclipse.xtext.testlanguages.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.testlanguages.services.ActionTestLanguage3GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalActionTestLanguage3Parser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=6;
    public static final int RULE_ML_COMMENT=7;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalActionTestLanguage3Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalActionTestLanguage3Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalActionTestLanguage3Parser.tokenNames; }
    public String getGrammarFileName() { return "InternalActionTestLanguage3.g"; }



     	private ActionTestLanguage3GrammarAccess grammarAccess;

        public InternalActionTestLanguage3Parser(TokenStream input, ActionTestLanguage3GrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "ProductionRules";
       	}

       	@Override
       	protected ActionTestLanguage3GrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleProductionRules"
    // InternalActionTestLanguage3.g:64:1: entryRuleProductionRules returns [EObject current=null] : iv_ruleProductionRules= ruleProductionRules EOF ;
    public final EObject entryRuleProductionRules() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProductionRules = null;


        try {
            // InternalActionTestLanguage3.g:64:56: (iv_ruleProductionRules= ruleProductionRules EOF )
            // InternalActionTestLanguage3.g:65:2: iv_ruleProductionRules= ruleProductionRules EOF
            {
             newCompositeNode(grammarAccess.getProductionRulesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleProductionRules=ruleProductionRules();

            state._fsp--;

             current =iv_ruleProductionRules; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProductionRules"


    // $ANTLR start "ruleProductionRules"
    // InternalActionTestLanguage3.g:71:1: ruleProductionRules returns [EObject current=null] : (this_ProductionRule1_0= ruleProductionRule1 | this_ProductionRule2_1= ruleProductionRule2 ) ;
    public final EObject ruleProductionRules() throws RecognitionException {
        EObject current = null;

        EObject this_ProductionRule1_0 = null;

        EObject this_ProductionRule2_1 = null;



        	enterRule();

        try {
            // InternalActionTestLanguage3.g:77:2: ( (this_ProductionRule1_0= ruleProductionRule1 | this_ProductionRule2_1= ruleProductionRule2 ) )
            // InternalActionTestLanguage3.g:78:2: (this_ProductionRule1_0= ruleProductionRule1 | this_ProductionRule2_1= ruleProductionRule2 )
            {
            // InternalActionTestLanguage3.g:78:2: (this_ProductionRule1_0= ruleProductionRule1 | this_ProductionRule2_1= ruleProductionRule2 )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID||LA1_0==RULE_INT) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_STRING) ) {
                int LA1_2 = input.LA(2);

                if ( (LA1_2==RULE_INT) ) {
                    alt1=1;
                }
                else if ( (LA1_2==RULE_ID) ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalActionTestLanguage3.g:79:3: this_ProductionRule1_0= ruleProductionRule1
                    {

                    			newCompositeNode(grammarAccess.getProductionRulesAccess().getProductionRule1ParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ProductionRule1_0=ruleProductionRule1();

                    state._fsp--;


                    			current = this_ProductionRule1_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalActionTestLanguage3.g:88:3: this_ProductionRule2_1= ruleProductionRule2
                    {

                    			newCompositeNode(grammarAccess.getProductionRulesAccess().getProductionRule2ParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ProductionRule2_1=ruleProductionRule2();

                    state._fsp--;


                    			current = this_ProductionRule2_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProductionRules"


    // $ANTLR start "entryRuleProductionRule1"
    // InternalActionTestLanguage3.g:100:1: entryRuleProductionRule1 returns [EObject current=null] : iv_ruleProductionRule1= ruleProductionRule1 EOF ;
    public final EObject entryRuleProductionRule1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProductionRule1 = null;


        try {
            // InternalActionTestLanguage3.g:100:56: (iv_ruleProductionRule1= ruleProductionRule1 EOF )
            // InternalActionTestLanguage3.g:101:2: iv_ruleProductionRule1= ruleProductionRule1 EOF
            {
             newCompositeNode(grammarAccess.getProductionRule1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleProductionRule1=ruleProductionRule1();

            state._fsp--;

             current =iv_ruleProductionRule1; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProductionRule1"


    // $ANTLR start "ruleProductionRule1"
    // InternalActionTestLanguage3.g:107:1: ruleProductionRule1 returns [EObject current=null] : ( () ( (lv_id_1_0= RULE_ID ) )? () ( (lv_string_3_0= RULE_STRING ) )? () ( (lv_i_5_0= RULE_INT ) ) ) ;
    public final EObject ruleProductionRule1() throws RecognitionException {
        EObject current = null;

        Token lv_id_1_0=null;
        Token lv_string_3_0=null;
        Token lv_i_5_0=null;


        	enterRule();

        try {
            // InternalActionTestLanguage3.g:113:2: ( ( () ( (lv_id_1_0= RULE_ID ) )? () ( (lv_string_3_0= RULE_STRING ) )? () ( (lv_i_5_0= RULE_INT ) ) ) )
            // InternalActionTestLanguage3.g:114:2: ( () ( (lv_id_1_0= RULE_ID ) )? () ( (lv_string_3_0= RULE_STRING ) )? () ( (lv_i_5_0= RULE_INT ) ) )
            {
            // InternalActionTestLanguage3.g:114:2: ( () ( (lv_id_1_0= RULE_ID ) )? () ( (lv_string_3_0= RULE_STRING ) )? () ( (lv_i_5_0= RULE_INT ) ) )
            // InternalActionTestLanguage3.g:115:3: () ( (lv_id_1_0= RULE_ID ) )? () ( (lv_string_3_0= RULE_STRING ) )? () ( (lv_i_5_0= RULE_INT ) )
            {
            // InternalActionTestLanguage3.g:115:3: ()
            // InternalActionTestLanguage3.g:116:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getProductionRule1Access().getP1Action_0(),
            					current);
            			

            }

            // InternalActionTestLanguage3.g:122:3: ( (lv_id_1_0= RULE_ID ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalActionTestLanguage3.g:123:4: (lv_id_1_0= RULE_ID )
                    {
                    // InternalActionTestLanguage3.g:123:4: (lv_id_1_0= RULE_ID )
                    // InternalActionTestLanguage3.g:124:5: lv_id_1_0= RULE_ID
                    {
                    lv_id_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

                    					newLeafNode(lv_id_1_0, grammarAccess.getProductionRule1Access().getIdIDTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getProductionRule1Rule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"id",
                    						lv_id_1_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }
                    break;

            }

            // InternalActionTestLanguage3.g:140:3: ()
            // InternalActionTestLanguage3.g:141:4: 
            {

            				current = forceCreateModelElementAndSet(
            					grammarAccess.getProductionRule1Access().getP2PAction_2(),
            					current);
            			

            }

            // InternalActionTestLanguage3.g:147:3: ( (lv_string_3_0= RULE_STRING ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_STRING) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalActionTestLanguage3.g:148:4: (lv_string_3_0= RULE_STRING )
                    {
                    // InternalActionTestLanguage3.g:148:4: (lv_string_3_0= RULE_STRING )
                    // InternalActionTestLanguage3.g:149:5: lv_string_3_0= RULE_STRING
                    {
                    lv_string_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_4); 

                    					newLeafNode(lv_string_3_0, grammarAccess.getProductionRule1Access().getStringSTRINGTerminalRuleCall_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getProductionRule1Rule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"string",
                    						lv_string_3_0,
                    						"org.eclipse.xtext.common.Terminals.STRING");
                    				

                    }


                    }
                    break;

            }

            // InternalActionTestLanguage3.g:165:3: ()
            // InternalActionTestLanguage3.g:166:4: 
            {

            				current = forceCreateModelElementAndSet(
            					grammarAccess.getProductionRule1Access().getP3PAction_4(),
            					current);
            			

            }

            // InternalActionTestLanguage3.g:172:3: ( (lv_i_5_0= RULE_INT ) )
            // InternalActionTestLanguage3.g:173:4: (lv_i_5_0= RULE_INT )
            {
            // InternalActionTestLanguage3.g:173:4: (lv_i_5_0= RULE_INT )
            // InternalActionTestLanguage3.g:174:5: lv_i_5_0= RULE_INT
            {
            lv_i_5_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_i_5_0, grammarAccess.getProductionRule1Access().getIINTTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProductionRule1Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"i",
            						lv_i_5_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProductionRule1"


    // $ANTLR start "entryRuleProductionRule2"
    // InternalActionTestLanguage3.g:194:1: entryRuleProductionRule2 returns [EObject current=null] : iv_ruleProductionRule2= ruleProductionRule2 EOF ;
    public final EObject entryRuleProductionRule2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProductionRule2 = null;


        try {
            // InternalActionTestLanguage3.g:194:56: (iv_ruleProductionRule2= ruleProductionRule2 EOF )
            // InternalActionTestLanguage3.g:195:2: iv_ruleProductionRule2= ruleProductionRule2 EOF
            {
             newCompositeNode(grammarAccess.getProductionRule2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleProductionRule2=ruleProductionRule2();

            state._fsp--;

             current =iv_ruleProductionRule2; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProductionRule2"


    // $ANTLR start "ruleProductionRule2"
    // InternalActionTestLanguage3.g:201:1: ruleProductionRule2 returns [EObject current=null] : (this_STRING_0= RULE_STRING () ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleProductionRule2() throws RecognitionException {
        EObject current = null;

        Token this_STRING_0=null;
        Token lv_name_2_0=null;


        	enterRule();

        try {
            // InternalActionTestLanguage3.g:207:2: ( (this_STRING_0= RULE_STRING () ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalActionTestLanguage3.g:208:2: (this_STRING_0= RULE_STRING () ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalActionTestLanguage3.g:208:2: (this_STRING_0= RULE_STRING () ( (lv_name_2_0= RULE_ID ) ) )
            // InternalActionTestLanguage3.g:209:3: this_STRING_0= RULE_STRING () ( (lv_name_2_0= RULE_ID ) )
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_5); 

            			newLeafNode(this_STRING_0, grammarAccess.getProductionRule2Access().getSTRINGTerminalRuleCall_0());
            		
            // InternalActionTestLanguage3.g:213:3: ()
            // InternalActionTestLanguage3.g:214:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getProductionRule2Access().getEntryAction_1(),
            					current);
            			

            }

            // InternalActionTestLanguage3.g:220:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalActionTestLanguage3.g:221:4: (lv_name_2_0= RULE_ID )
            {
            // InternalActionTestLanguage3.g:221:4: (lv_name_2_0= RULE_ID )
            // InternalActionTestLanguage3.g:222:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_name_2_0, grammarAccess.getProductionRule2Access().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProductionRule2Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProductionRule2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    }


}