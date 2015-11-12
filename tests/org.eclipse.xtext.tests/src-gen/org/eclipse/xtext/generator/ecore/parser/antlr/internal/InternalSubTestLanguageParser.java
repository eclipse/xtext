package org.eclipse.xtext.generator.ecore.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.generator.ecore.services.SubTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSubTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "'ups'", "'super'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
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


        public InternalSubTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSubTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSubTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSubTestLanguage.g"; }



     	private SubTestLanguageGrammarAccess grammarAccess;

        public InternalSubTestLanguageParser(TokenStream input, SubTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "SubMain";
       	}

       	@Override
       	protected SubTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleSubMain"
    // InternalSubTestLanguage.g:64:1: entryRuleSubMain returns [EObject current=null] : iv_ruleSubMain= ruleSubMain EOF ;
    public final EObject entryRuleSubMain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubMain = null;


        try {
            // InternalSubTestLanguage.g:64:48: (iv_ruleSubMain= ruleSubMain EOF )
            // InternalSubTestLanguage.g:65:2: iv_ruleSubMain= ruleSubMain EOF
            {
             newCompositeNode(grammarAccess.getSubMainRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSubMain=ruleSubMain();

            state._fsp--;

             current =iv_ruleSubMain; 
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
    // $ANTLR end "entryRuleSubMain"


    // $ANTLR start "ruleSubMain"
    // InternalSubTestLanguage.g:71:1: ruleSubMain returns [EObject current=null] : (otherlv_0= '{' ( (lv_superMains_1_0= ruleSuperMain ) ) otherlv_2= '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )? ) ;
    public final EObject ruleSubMain() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_superMains_1_0 = null;

        EObject lv_another_3_0 = null;



        	enterRule();

        try {
            // InternalSubTestLanguage.g:77:2: ( (otherlv_0= '{' ( (lv_superMains_1_0= ruleSuperMain ) ) otherlv_2= '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )? ) )
            // InternalSubTestLanguage.g:78:2: (otherlv_0= '{' ( (lv_superMains_1_0= ruleSuperMain ) ) otherlv_2= '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )? )
            {
            // InternalSubTestLanguage.g:78:2: (otherlv_0= '{' ( (lv_superMains_1_0= ruleSuperMain ) ) otherlv_2= '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )? )
            // InternalSubTestLanguage.g:79:3: otherlv_0= '{' ( (lv_superMains_1_0= ruleSuperMain ) ) otherlv_2= '}' ( (lv_another_3_0= ruleAnotherSuperMain ) )?
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSubMainAccess().getLeftCurlyBracketKeyword_0());
            		
            // InternalSubTestLanguage.g:83:3: ( (lv_superMains_1_0= ruleSuperMain ) )
            // InternalSubTestLanguage.g:84:4: (lv_superMains_1_0= ruleSuperMain )
            {
            // InternalSubTestLanguage.g:84:4: (lv_superMains_1_0= ruleSuperMain )
            // InternalSubTestLanguage.g:85:5: lv_superMains_1_0= ruleSuperMain
            {

            					newCompositeNode(grammarAccess.getSubMainAccess().getSuperMainsSuperMainParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_4);
            lv_superMains_1_0=ruleSuperMain();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSubMainRule());
            					}
            					add(
            						current,
            						"superMains",
            						lv_superMains_1_0,
            						"org.eclipse.xtext.generator.ecore.SuperTestLanguage.SuperMain");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getSubMainAccess().getRightCurlyBracketKeyword_2());
            		
            // InternalSubTestLanguage.g:106:3: ( (lv_another_3_0= ruleAnotherSuperMain ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalSubTestLanguage.g:107:4: (lv_another_3_0= ruleAnotherSuperMain )
                    {
                    // InternalSubTestLanguage.g:107:4: (lv_another_3_0= ruleAnotherSuperMain )
                    // InternalSubTestLanguage.g:108:5: lv_another_3_0= ruleAnotherSuperMain
                    {

                    					newCompositeNode(grammarAccess.getSubMainAccess().getAnotherAnotherSuperMainParserRuleCall_3_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_another_3_0=ruleAnotherSuperMain();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSubMainRule());
                    					}
                    					set(
                    						current,
                    						"another",
                    						lv_another_3_0,
                    						"org.eclipse.xtext.generator.ecore.SubTestLanguage.AnotherSuperMain");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

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
    // $ANTLR end "ruleSubMain"


    // $ANTLR start "entryRuleAnotherSuperMain"
    // InternalSubTestLanguage.g:129:1: entryRuleAnotherSuperMain returns [EObject current=null] : iv_ruleAnotherSuperMain= ruleAnotherSuperMain EOF ;
    public final EObject entryRuleAnotherSuperMain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnotherSuperMain = null;


        try {
            // InternalSubTestLanguage.g:129:57: (iv_ruleAnotherSuperMain= ruleAnotherSuperMain EOF )
            // InternalSubTestLanguage.g:130:2: iv_ruleAnotherSuperMain= ruleAnotherSuperMain EOF
            {
             newCompositeNode(grammarAccess.getAnotherSuperMainRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAnotherSuperMain=ruleAnotherSuperMain();

            state._fsp--;

             current =iv_ruleAnotherSuperMain; 
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
    // $ANTLR end "entryRuleAnotherSuperMain"


    // $ANTLR start "ruleAnotherSuperMain"
    // InternalSubTestLanguage.g:136:1: ruleAnotherSuperMain returns [EObject current=null] : (otherlv_0= 'ups' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAnotherSuperMain() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalSubTestLanguage.g:142:2: ( (otherlv_0= 'ups' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalSubTestLanguage.g:143:2: (otherlv_0= 'ups' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalSubTestLanguage.g:143:2: (otherlv_0= 'ups' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalSubTestLanguage.g:144:3: otherlv_0= 'ups' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getAnotherSuperMainAccess().getUpsKeyword_0());
            		
            // InternalSubTestLanguage.g:148:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSubTestLanguage.g:149:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSubTestLanguage.g:149:4: (lv_name_1_0= RULE_ID )
            // InternalSubTestLanguage.g:150:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getAnotherSuperMainAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAnotherSuperMainRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
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
    // $ANTLR end "ruleAnotherSuperMain"


    // $ANTLR start "entryRuleSuperMain"
    // InternalSubTestLanguage.g:170:1: entryRuleSuperMain returns [EObject current=null] : iv_ruleSuperMain= ruleSuperMain EOF ;
    public final EObject entryRuleSuperMain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperMain = null;


        try {
            // InternalSubTestLanguage.g:170:50: (iv_ruleSuperMain= ruleSuperMain EOF )
            // InternalSubTestLanguage.g:171:2: iv_ruleSuperMain= ruleSuperMain EOF
            {
             newCompositeNode(grammarAccess.getSuperMainRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSuperMain=ruleSuperMain();

            state._fsp--;

             current =iv_ruleSuperMain; 
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
    // $ANTLR end "entryRuleSuperMain"


    // $ANTLR start "ruleSuperMain"
    // InternalSubTestLanguage.g:177:1: ruleSuperMain returns [EObject current=null] : (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleSuperMain() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalSubTestLanguage.g:183:2: ( (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalSubTestLanguage.g:184:2: (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalSubTestLanguage.g:184:2: (otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalSubTestLanguage.g:185:3: otherlv_0= 'super' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getSuperMainAccess().getSuperKeyword_0());
            		
            // InternalSubTestLanguage.g:189:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSubTestLanguage.g:190:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSubTestLanguage.g:190:4: (lv_name_1_0= RULE_ID )
            // InternalSubTestLanguage.g:191:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSuperMainAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSuperMainRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
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
    // $ANTLR end "ruleSuperMain"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    }


}