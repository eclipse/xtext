package org.eclipse.xtext.parser.antlr.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.antlr.services.Bug301935ExTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalBug301935ExTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LineFeed", "CarriageReturn", "RULE_ID", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=6;
    public static final int RULE_WS=7;
    public static final int RULE_ANY_OTHER=8;
    public static final int CarriageReturn=5;
    public static final int EOF=-1;
    public static final int LineFeed=4;

    // delegates
    // delegators


        public InternalBug301935ExTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug301935ExTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug301935ExTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug301935ExTestLanguageParser.g"; }



     	private Bug301935ExTestLanguageGrammarAccess grammarAccess;

        public InternalBug301935ExTestLanguageParser(TokenStream input, Bug301935ExTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "DelegateModel";
       	}

       	@Override
       	protected Bug301935ExTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleDelegateModel"
    // InternalBug301935ExTestLanguageParser.g:62:1: entryRuleDelegateModel returns [EObject current=null] : iv_ruleDelegateModel= ruleDelegateModel EOF ;
    public final EObject entryRuleDelegateModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDelegateModel = null;


        try {
            // InternalBug301935ExTestLanguageParser.g:62:54: (iv_ruleDelegateModel= ruleDelegateModel EOF )
            // InternalBug301935ExTestLanguageParser.g:63:2: iv_ruleDelegateModel= ruleDelegateModel EOF
            {
             newCompositeNode(grammarAccess.getDelegateModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDelegateModel=ruleDelegateModel();

            state._fsp--;

             current =iv_ruleDelegateModel; 
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
    // $ANTLR end "entryRuleDelegateModel"


    // $ANTLR start "ruleDelegateModel"
    // InternalBug301935ExTestLanguageParser.g:69:1: ruleDelegateModel returns [EObject current=null] : this_Model_0= ruleModel ;
    public final EObject ruleDelegateModel() throws RecognitionException {
        EObject current = null;

        EObject this_Model_0 = null;



        	enterRule();

        try {
            // InternalBug301935ExTestLanguageParser.g:75:2: (this_Model_0= ruleModel )
            // InternalBug301935ExTestLanguageParser.g:76:2: this_Model_0= ruleModel
            {

            		newCompositeNode(grammarAccess.getDelegateModelAccess().getModelParserRuleCall());
            	
            pushFollow(FollowSets000.FOLLOW_2);
            this_Model_0=ruleModel();

            state._fsp--;


            		current = this_Model_0;
            		afterParserOrEnumRuleCall();
            	

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
    // $ANTLR end "ruleDelegateModel"


    // $ANTLR start "entryRuleModel"
    // InternalBug301935ExTestLanguageParser.g:87:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalBug301935ExTestLanguageParser.g:87:46: (iv_ruleModel= ruleModel EOF )
            // InternalBug301935ExTestLanguageParser.g:88:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalBug301935ExTestLanguageParser.g:94:1: ruleModel returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_WS_1=null;
        Token lv_value_2_0=null;
        Token lv_value2_4_0=null;
        Token this_WS_5=null;


        	enterRule();

        try {
            // InternalBug301935ExTestLanguageParser.g:100:2: ( ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS ) )
            // InternalBug301935ExTestLanguageParser.g:101:2: ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS )
            {
            // InternalBug301935ExTestLanguageParser.g:101:2: ( ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS )
            // InternalBug301935ExTestLanguageParser.g:102:3: ( (lv_name_0_0= RULE_ID ) ) this_WS_1= RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) this_WS_5= RULE_WS
            {
            // InternalBug301935ExTestLanguageParser.g:102:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalBug301935ExTestLanguageParser.g:103:4: (lv_name_0_0= RULE_ID )
            {
            // InternalBug301935ExTestLanguageParser.g:103:4: (lv_name_0_0= RULE_ID )
            // InternalBug301935ExTestLanguageParser.g:104:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					newLeafNode(lv_name_0_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.parser.antlr.Bug301935TestLanguage.ID");
            				

            }


            }

            this_WS_1=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_4); 

            			newLeafNode(this_WS_1, grammarAccess.getModelAccess().getWSTerminalRuleCall_1());
            		
            // InternalBug301935ExTestLanguageParser.g:124:3: ( (lv_value_2_0= RULE_ID ) )
            // InternalBug301935ExTestLanguageParser.g:125:4: (lv_value_2_0= RULE_ID )
            {
            // InternalBug301935ExTestLanguageParser.g:125:4: (lv_value_2_0= RULE_ID )
            // InternalBug301935ExTestLanguageParser.g:126:5: lv_value_2_0= RULE_ID
            {
            lv_value_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					newLeafNode(lv_value_2_0, grammarAccess.getModelAccess().getValueIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.parser.antlr.Bug301935TestLanguage.ID");
            				

            }


            }


            			newCompositeNode(grammarAccess.getModelAccess().getNLParserRuleCall_3());
            		
            pushFollow(FollowSets000.FOLLOW_4);
            ruleNL();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            // InternalBug301935ExTestLanguageParser.g:149:3: ( (lv_value2_4_0= RULE_ID ) )
            // InternalBug301935ExTestLanguageParser.g:150:4: (lv_value2_4_0= RULE_ID )
            {
            // InternalBug301935ExTestLanguageParser.g:150:4: (lv_value2_4_0= RULE_ID )
            // InternalBug301935ExTestLanguageParser.g:151:5: lv_value2_4_0= RULE_ID
            {
            lv_value2_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					newLeafNode(lv_value2_4_0, grammarAccess.getModelAccess().getValue2IDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value2",
            						lv_value2_4_0,
            						"org.eclipse.xtext.parser.antlr.Bug301935TestLanguage.ID");
            				

            }


            }

            this_WS_5=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_2); 

            			newLeafNode(this_WS_5, grammarAccess.getModelAccess().getWSTerminalRuleCall_5());
            		

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleNL"
    // InternalBug301935ExTestLanguageParser.g:175:1: entryRuleNL returns [String current=null] : iv_ruleNL= ruleNL EOF ;
    public final String entryRuleNL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNL = null;


        try {
            // InternalBug301935ExTestLanguageParser.g:175:42: (iv_ruleNL= ruleNL EOF )
            // InternalBug301935ExTestLanguageParser.g:176:2: iv_ruleNL= ruleNL EOF
            {
             newCompositeNode(grammarAccess.getNLRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNL=ruleNL();

            state._fsp--;

             current =iv_ruleNL.getText(); 
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
    // $ANTLR end "entryRuleNL"


    // $ANTLR start "ruleNL"
    // InternalBug301935ExTestLanguageParser.g:182:1: ruleNL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_WS_0= RULE_WS )* ( (kw= CarriageReturn )? kw= LineFeed ) (this_WS_3= RULE_WS )* ) ;
    public final AntlrDatatypeRuleToken ruleNL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_0=null;
        Token kw=null;
        Token this_WS_3=null;


        	enterRule();

        try {
            // InternalBug301935ExTestLanguageParser.g:188:2: ( ( (this_WS_0= RULE_WS )* ( (kw= CarriageReturn )? kw= LineFeed ) (this_WS_3= RULE_WS )* ) )
            // InternalBug301935ExTestLanguageParser.g:189:2: ( (this_WS_0= RULE_WS )* ( (kw= CarriageReturn )? kw= LineFeed ) (this_WS_3= RULE_WS )* )
            {
            // InternalBug301935ExTestLanguageParser.g:189:2: ( (this_WS_0= RULE_WS )* ( (kw= CarriageReturn )? kw= LineFeed ) (this_WS_3= RULE_WS )* )
            // InternalBug301935ExTestLanguageParser.g:190:3: (this_WS_0= RULE_WS )* ( (kw= CarriageReturn )? kw= LineFeed ) (this_WS_3= RULE_WS )*
            {
            // InternalBug301935ExTestLanguageParser.g:190:3: (this_WS_0= RULE_WS )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_WS) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBug301935ExTestLanguageParser.g:191:4: this_WS_0= RULE_WS
            	    {
            	    this_WS_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_5); 

            	    				current.merge(this_WS_0);
            	    			

            	    				newLeafNode(this_WS_0, grammarAccess.getNLAccess().getWSTerminalRuleCall_0());
            	    			

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalBug301935ExTestLanguageParser.g:199:3: ( (kw= CarriageReturn )? kw= LineFeed )
            // InternalBug301935ExTestLanguageParser.g:200:4: (kw= CarriageReturn )? kw= LineFeed
            {
            // InternalBug301935ExTestLanguageParser.g:200:4: (kw= CarriageReturn )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==CarriageReturn) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalBug301935ExTestLanguageParser.g:201:5: kw= CarriageReturn
                    {
                    kw=(Token)match(input,CarriageReturn,FollowSets000.FOLLOW_6); 

                    					current.merge(kw);
                    					newLeafNode(kw, grammarAccess.getNLAccess().getCarriageReturnKeyword_1_0());
                    				

                    }
                    break;

            }

            kw=(Token)match(input,LineFeed,FollowSets000.FOLLOW_7); 

            				current.merge(kw);
            				newLeafNode(kw, grammarAccess.getNLAccess().getLineFeedKeyword_1_1());
            			

            }

            // InternalBug301935ExTestLanguageParser.g:213:3: (this_WS_3= RULE_WS )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_WS) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBug301935ExTestLanguageParser.g:214:4: this_WS_3= RULE_WS
            	    {
            	    this_WS_3=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_7); 

            	    				current.merge(this_WS_3);
            	    			

            	    				newLeafNode(this_WS_3, grammarAccess.getNLAccess().getWSTerminalRuleCall_2());
            	    			

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


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
    // $ANTLR end "ruleNL"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000000000B0L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000082L});
    }


}