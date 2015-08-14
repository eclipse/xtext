package org.eclipse.xtext.ui.tests.testlanguages.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.testlanguages.services.ContentAssistTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalContentAssistTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'abstract rules'", "'end'", "'('", "')'", "';'", "'rule'", "':'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__17=17;
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


        public InternalContentAssistTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalContentAssistTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalContentAssistTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalContentAssistTestLanguage.g"; }



     	private ContentAssistTestLanguageGrammarAccess grammarAccess;
     	
        public InternalContentAssistTestLanguageParser(TokenStream input, ContentAssistTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Start";	
       	}
       	
       	@Override
       	protected ContentAssistTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleStart"
    // InternalContentAssistTestLanguage.g:67:1: entryRuleStart returns [EObject current=null] : iv_ruleStart= ruleStart EOF ;
    public final EObject entryRuleStart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStart = null;


        try {
            // InternalContentAssistTestLanguage.g:68:2: (iv_ruleStart= ruleStart EOF )
            // InternalContentAssistTestLanguage.g:69:2: iv_ruleStart= ruleStart EOF
            {
             newCompositeNode(grammarAccess.getStartRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStart=ruleStart();

            state._fsp--;

             current =iv_ruleStart; 
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
    // $ANTLR end "entryRuleStart"


    // $ANTLR start "ruleStart"
    // InternalContentAssistTestLanguage.g:76:1: ruleStart returns [EObject current=null] : (otherlv_0= 'abstract rules' ( (lv_rules_1_0= ruleAbstractRule ) )+ otherlv_2= 'end' ) ;
    public final EObject ruleStart() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_rules_1_0 = null;


         enterRule(); 
            
        try {
            // InternalContentAssistTestLanguage.g:79:28: ( (otherlv_0= 'abstract rules' ( (lv_rules_1_0= ruleAbstractRule ) )+ otherlv_2= 'end' ) )
            // InternalContentAssistTestLanguage.g:80:1: (otherlv_0= 'abstract rules' ( (lv_rules_1_0= ruleAbstractRule ) )+ otherlv_2= 'end' )
            {
            // InternalContentAssistTestLanguage.g:80:1: (otherlv_0= 'abstract rules' ( (lv_rules_1_0= ruleAbstractRule ) )+ otherlv_2= 'end' )
            // InternalContentAssistTestLanguage.g:80:3: otherlv_0= 'abstract rules' ( (lv_rules_1_0= ruleAbstractRule ) )+ otherlv_2= 'end'
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getStartAccess().getAbstractRulesKeyword_0());
                
            // InternalContentAssistTestLanguage.g:84:1: ( (lv_rules_1_0= ruleAbstractRule ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalContentAssistTestLanguage.g:85:1: (lv_rules_1_0= ruleAbstractRule )
            	    {
            	    // InternalContentAssistTestLanguage.g:85:1: (lv_rules_1_0= ruleAbstractRule )
            	    // InternalContentAssistTestLanguage.g:86:3: lv_rules_1_0= ruleAbstractRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStartAccess().getRulesAbstractRuleParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_rules_1_0=ruleAbstractRule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStartRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"rules",
            	            		lv_rules_1_0, 
            	            		"org.eclipse.xtext.ui.tests.testlanguages.ContentAssistTestLanguage.AbstractRule");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_2, grammarAccess.getStartAccess().getEndKeyword_2());
                

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
    // $ANTLR end "ruleStart"


    // $ANTLR start "entryRuleAbstractRule"
    // InternalContentAssistTestLanguage.g:114:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // InternalContentAssistTestLanguage.g:115:2: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // InternalContentAssistTestLanguage.g:116:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             newCompositeNode(grammarAccess.getAbstractRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractRule=ruleAbstractRule();

            state._fsp--;

             current =iv_ruleAbstractRule; 
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
    // $ANTLR end "entryRuleAbstractRule"


    // $ANTLR start "ruleAbstractRule"
    // InternalContentAssistTestLanguage.g:123:1: ruleAbstractRule returns [EObject current=null] : (this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_FirstAbstractRuleChild_0 = null;

        EObject this_SecondAbstractRuleChild_1 = null;


         enterRule(); 
            
        try {
            // InternalContentAssistTestLanguage.g:126:28: ( (this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild ) )
            // InternalContentAssistTestLanguage.g:127:1: (this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild )
            {
            // InternalContentAssistTestLanguage.g:127:1: (this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==16) ) {
                    alt2=2;
                }
                else if ( (LA2_1==13) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalContentAssistTestLanguage.g:128:5: this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractRuleAccess().getFirstAbstractRuleChildParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_FirstAbstractRuleChild_0=ruleFirstAbstractRuleChild();

                    state._fsp--;

                     
                            current = this_FirstAbstractRuleChild_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalContentAssistTestLanguage.g:138:5: this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractRuleAccess().getSecondAbstractRuleChildParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SecondAbstractRuleChild_1=ruleSecondAbstractRuleChild();

                    state._fsp--;

                     
                            current = this_SecondAbstractRuleChild_1; 
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
    // $ANTLR end "ruleAbstractRule"


    // $ANTLR start "entryRuleFirstAbstractRuleChild"
    // InternalContentAssistTestLanguage.g:154:1: entryRuleFirstAbstractRuleChild returns [EObject current=null] : iv_ruleFirstAbstractRuleChild= ruleFirstAbstractRuleChild EOF ;
    public final EObject entryRuleFirstAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstAbstractRuleChild = null;


        try {
            // InternalContentAssistTestLanguage.g:155:2: (iv_ruleFirstAbstractRuleChild= ruleFirstAbstractRuleChild EOF )
            // InternalContentAssistTestLanguage.g:156:2: iv_ruleFirstAbstractRuleChild= ruleFirstAbstractRuleChild EOF
            {
             newCompositeNode(grammarAccess.getFirstAbstractRuleChildRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFirstAbstractRuleChild=ruleFirstAbstractRuleChild();

            state._fsp--;

             current =iv_ruleFirstAbstractRuleChild; 
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
    // $ANTLR end "entryRuleFirstAbstractRuleChild"


    // $ANTLR start "ruleFirstAbstractRuleChild"
    // InternalContentAssistTestLanguage.g:163:1: ruleFirstAbstractRuleChild returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_elements_2_0= ruleAbstractRule ) )+ otherlv_3= ')' otherlv_4= ';' ) ;
    public final EObject ruleFirstAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_elements_2_0 = null;


         enterRule(); 
            
        try {
            // InternalContentAssistTestLanguage.g:166:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_elements_2_0= ruleAbstractRule ) )+ otherlv_3= ')' otherlv_4= ';' ) )
            // InternalContentAssistTestLanguage.g:167:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_elements_2_0= ruleAbstractRule ) )+ otherlv_3= ')' otherlv_4= ';' )
            {
            // InternalContentAssistTestLanguage.g:167:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_elements_2_0= ruleAbstractRule ) )+ otherlv_3= ')' otherlv_4= ';' )
            // InternalContentAssistTestLanguage.g:167:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_elements_2_0= ruleAbstractRule ) )+ otherlv_3= ')' otherlv_4= ';'
            {
            // InternalContentAssistTestLanguage.g:167:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalContentAssistTestLanguage.g:168:1: (lv_name_0_0= RULE_ID )
            {
            // InternalContentAssistTestLanguage.g:168:1: (lv_name_0_0= RULE_ID )
            // InternalContentAssistTestLanguage.g:169:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            			newLeafNode(lv_name_0_0, grammarAccess.getFirstAbstractRuleChildAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFirstAbstractRuleChildRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getFirstAbstractRuleChildAccess().getLeftParenthesisKeyword_1());
                
            // InternalContentAssistTestLanguage.g:189:1: ( (lv_elements_2_0= ruleAbstractRule ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalContentAssistTestLanguage.g:190:1: (lv_elements_2_0= ruleAbstractRule )
            	    {
            	    // InternalContentAssistTestLanguage.g:190:1: (lv_elements_2_0= ruleAbstractRule )
            	    // InternalContentAssistTestLanguage.g:191:3: lv_elements_2_0= ruleAbstractRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAbstractRuleParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    lv_elements_2_0=ruleAbstractRule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFirstAbstractRuleChildRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_2_0, 
            	            		"org.eclipse.xtext.ui.tests.testlanguages.ContentAssistTestLanguage.AbstractRule");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_7); 

                	newLeafNode(otherlv_3, grammarAccess.getFirstAbstractRuleChildAccess().getRightParenthesisKeyword_3());
                
            otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getFirstAbstractRuleChildAccess().getSemicolonKeyword_4());
                

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
    // $ANTLR end "ruleFirstAbstractRuleChild"


    // $ANTLR start "entryRuleSecondAbstractRuleChild"
    // InternalContentAssistTestLanguage.g:223:1: entryRuleSecondAbstractRuleChild returns [EObject current=null] : iv_ruleSecondAbstractRuleChild= ruleSecondAbstractRuleChild EOF ;
    public final EObject entryRuleSecondAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecondAbstractRuleChild = null;


        try {
            // InternalContentAssistTestLanguage.g:224:2: (iv_ruleSecondAbstractRuleChild= ruleSecondAbstractRuleChild EOF )
            // InternalContentAssistTestLanguage.g:225:2: iv_ruleSecondAbstractRuleChild= ruleSecondAbstractRuleChild EOF
            {
             newCompositeNode(grammarAccess.getSecondAbstractRuleChildRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSecondAbstractRuleChild=ruleSecondAbstractRuleChild();

            state._fsp--;

             current =iv_ruleSecondAbstractRuleChild; 
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
    // $ANTLR end "entryRuleSecondAbstractRuleChild"


    // $ANTLR start "ruleSecondAbstractRuleChild"
    // InternalContentAssistTestLanguage.g:232:1: ruleSecondAbstractRuleChild returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'rule' otherlv_2= ':' ( (lv_rule_3_0= ruleAbstractRuleCall ) ) otherlv_4= ';' ) ;
    public final EObject ruleSecondAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_rule_3_0 = null;


         enterRule(); 
            
        try {
            // InternalContentAssistTestLanguage.g:235:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'rule' otherlv_2= ':' ( (lv_rule_3_0= ruleAbstractRuleCall ) ) otherlv_4= ';' ) )
            // InternalContentAssistTestLanguage.g:236:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'rule' otherlv_2= ':' ( (lv_rule_3_0= ruleAbstractRuleCall ) ) otherlv_4= ';' )
            {
            // InternalContentAssistTestLanguage.g:236:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'rule' otherlv_2= ':' ( (lv_rule_3_0= ruleAbstractRuleCall ) ) otherlv_4= ';' )
            // InternalContentAssistTestLanguage.g:236:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'rule' otherlv_2= ':' ( (lv_rule_3_0= ruleAbstractRuleCall ) ) otherlv_4= ';'
            {
            // InternalContentAssistTestLanguage.g:236:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalContentAssistTestLanguage.g:237:1: (lv_name_0_0= RULE_ID )
            {
            // InternalContentAssistTestLanguage.g:237:1: (lv_name_0_0= RULE_ID )
            // InternalContentAssistTestLanguage.g:238:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            			newLeafNode(lv_name_0_0, grammarAccess.getSecondAbstractRuleChildAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSecondAbstractRuleChildRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_9); 

                	newLeafNode(otherlv_1, grammarAccess.getSecondAbstractRuleChildAccess().getRuleKeyword_1());
                
            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getSecondAbstractRuleChildAccess().getColonKeyword_2());
                
            // InternalContentAssistTestLanguage.g:262:1: ( (lv_rule_3_0= ruleAbstractRuleCall ) )
            // InternalContentAssistTestLanguage.g:263:1: (lv_rule_3_0= ruleAbstractRuleCall )
            {
            // InternalContentAssistTestLanguage.g:263:1: (lv_rule_3_0= ruleAbstractRuleCall )
            // InternalContentAssistTestLanguage.g:264:3: lv_rule_3_0= ruleAbstractRuleCall
            {
             
            	        newCompositeNode(grammarAccess.getSecondAbstractRuleChildAccess().getRuleAbstractRuleCallParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_7);
            lv_rule_3_0=ruleAbstractRuleCall();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSecondAbstractRuleChildRule());
            	        }
                   		set(
                   			current, 
                   			"rule",
                    		lv_rule_3_0, 
                    		"org.eclipse.xtext.ui.tests.testlanguages.ContentAssistTestLanguage.AbstractRuleCall");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getSecondAbstractRuleChildAccess().getSemicolonKeyword_4());
                

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
    // $ANTLR end "ruleSecondAbstractRuleChild"


    // $ANTLR start "entryRuleAbstractRuleCall"
    // InternalContentAssistTestLanguage.g:292:1: entryRuleAbstractRuleCall returns [EObject current=null] : iv_ruleAbstractRuleCall= ruleAbstractRuleCall EOF ;
    public final EObject entryRuleAbstractRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRuleCall = null;


        try {
            // InternalContentAssistTestLanguage.g:293:2: (iv_ruleAbstractRuleCall= ruleAbstractRuleCall EOF )
            // InternalContentAssistTestLanguage.g:294:2: iv_ruleAbstractRuleCall= ruleAbstractRuleCall EOF
            {
             newCompositeNode(grammarAccess.getAbstractRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractRuleCall=ruleAbstractRuleCall();

            state._fsp--;

             current =iv_ruleAbstractRuleCall; 
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
    // $ANTLR end "entryRuleAbstractRuleCall"


    // $ANTLR start "ruleAbstractRuleCall"
    // InternalContentAssistTestLanguage.g:301:1: ruleAbstractRuleCall returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleAbstractRuleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalContentAssistTestLanguage.g:304:28: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalContentAssistTestLanguage.g:305:1: ( (otherlv_0= RULE_ID ) )
            {
            // InternalContentAssistTestLanguage.g:305:1: ( (otherlv_0= RULE_ID ) )
            // InternalContentAssistTestLanguage.g:306:1: (otherlv_0= RULE_ID )
            {
            // InternalContentAssistTestLanguage.g:306:1: (otherlv_0= RULE_ID )
            // InternalContentAssistTestLanguage.g:307:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAbstractRuleCallRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            		newLeafNode(otherlv_0, grammarAccess.getAbstractRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 
            	

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
    // $ANTLR end "ruleAbstractRuleCall"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    }


}