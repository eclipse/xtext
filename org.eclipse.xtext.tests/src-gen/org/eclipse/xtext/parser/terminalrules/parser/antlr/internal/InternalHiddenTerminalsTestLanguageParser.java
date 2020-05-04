package org.eclipse.xtext.parser.terminalrules.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.terminalrules.services.HiddenTerminalsTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalHiddenTerminalsTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'without'", "'hiddens'", "';'", "'with'", "'overriding'", "'('", "')'", "'call'", "'inheriting'", "'datatype'", "'rule'", "'hiding'"
    };
    public static final int RULE_SL_COMMENT=6;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__10=10;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int RULE_WS=4;
    public static final int RULE_ANY_OTHER=7;
    public static final int RULE_ML_COMMENT=5;

    // delegates
    // delegators


        public InternalHiddenTerminalsTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalHiddenTerminalsTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalHiddenTerminalsTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalHiddenTerminalsTestLanguage.g"; }



     	private HiddenTerminalsTestLanguageGrammarAccess grammarAccess;

        public InternalHiddenTerminalsTestLanguageParser(TokenStream input, HiddenTerminalsTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected HiddenTerminalsTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalHiddenTerminalsTestLanguage.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalHiddenTerminalsTestLanguage.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalHiddenTerminalsTestLanguage.g:65:2: iv_ruleModel= ruleModel EOF
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
    // InternalHiddenTerminalsTestLanguage.g:71:1: ruleModel returns [EObject current=null] : (this_WithoutHiddens_0= ruleWithoutHiddens | this_WithHiddens_1= ruleWithHiddens | this_OverridingHiddens_2= ruleOverridingHiddens | this_InheritingHiddens_3= ruleInheritingHiddens | this_DatatypeHiddens_4= ruleDatatypeHiddens ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_WithoutHiddens_0 = null;

        EObject this_WithHiddens_1 = null;

        EObject this_OverridingHiddens_2 = null;

        EObject this_InheritingHiddens_3 = null;

        EObject this_DatatypeHiddens_4 = null;



        	enterRule();

        try {
            // InternalHiddenTerminalsTestLanguage.g:77:2: ( (this_WithoutHiddens_0= ruleWithoutHiddens | this_WithHiddens_1= ruleWithHiddens | this_OverridingHiddens_2= ruleOverridingHiddens | this_InheritingHiddens_3= ruleInheritingHiddens | this_DatatypeHiddens_4= ruleDatatypeHiddens ) )
            // InternalHiddenTerminalsTestLanguage.g:78:2: (this_WithoutHiddens_0= ruleWithoutHiddens | this_WithHiddens_1= ruleWithHiddens | this_OverridingHiddens_2= ruleOverridingHiddens | this_InheritingHiddens_3= ruleInheritingHiddens | this_DatatypeHiddens_4= ruleDatatypeHiddens )
            {
            // InternalHiddenTerminalsTestLanguage.g:78:2: (this_WithoutHiddens_0= ruleWithoutHiddens | this_WithHiddens_1= ruleWithHiddens | this_OverridingHiddens_2= ruleOverridingHiddens | this_InheritingHiddens_3= ruleInheritingHiddens | this_DatatypeHiddens_4= ruleDatatypeHiddens )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 8:
                {
                alt1=1;
                }
                break;
            case 11:
                {
                alt1=2;
                }
                break;
            case 12:
                {
                alt1=3;
                }
                break;
            case 16:
                {
                alt1=4;
                }
                break;
            case 17:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalHiddenTerminalsTestLanguage.g:79:3: this_WithoutHiddens_0= ruleWithoutHiddens
                    {

                    			newCompositeNode(grammarAccess.getModelAccess().getWithoutHiddensParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_WithoutHiddens_0=ruleWithoutHiddens();

                    state._fsp--;


                    			current = this_WithoutHiddens_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalHiddenTerminalsTestLanguage.g:88:3: this_WithHiddens_1= ruleWithHiddens
                    {

                    			newCompositeNode(grammarAccess.getModelAccess().getWithHiddensParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_WithHiddens_1=ruleWithHiddens();

                    state._fsp--;


                    			current = this_WithHiddens_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalHiddenTerminalsTestLanguage.g:97:3: this_OverridingHiddens_2= ruleOverridingHiddens
                    {

                    			newCompositeNode(grammarAccess.getModelAccess().getOverridingHiddensParserRuleCall_2());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_OverridingHiddens_2=ruleOverridingHiddens();

                    state._fsp--;


                    			current = this_OverridingHiddens_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalHiddenTerminalsTestLanguage.g:106:3: this_InheritingHiddens_3= ruleInheritingHiddens
                    {

                    			newCompositeNode(grammarAccess.getModelAccess().getInheritingHiddensParserRuleCall_3());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_InheritingHiddens_3=ruleInheritingHiddens();

                    state._fsp--;


                    			current = this_InheritingHiddens_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalHiddenTerminalsTestLanguage.g:115:3: this_DatatypeHiddens_4= ruleDatatypeHiddens
                    {

                    			newCompositeNode(grammarAccess.getModelAccess().getDatatypeHiddensParserRuleCall_4());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_DatatypeHiddens_4=ruleDatatypeHiddens();

                    state._fsp--;


                    			current = this_DatatypeHiddens_4;
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleWithoutHiddens"
    // InternalHiddenTerminalsTestLanguage.g:127:1: entryRuleWithoutHiddens returns [EObject current=null] : iv_ruleWithoutHiddens= ruleWithoutHiddens EOF ;
    public final EObject entryRuleWithoutHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWithoutHiddens = null;


        try {
            // InternalHiddenTerminalsTestLanguage.g:127:55: (iv_ruleWithoutHiddens= ruleWithoutHiddens EOF )
            // InternalHiddenTerminalsTestLanguage.g:128:2: iv_ruleWithoutHiddens= ruleWithoutHiddens EOF
            {
             newCompositeNode(grammarAccess.getWithoutHiddensRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleWithoutHiddens=ruleWithoutHiddens();

            state._fsp--;

             current =iv_ruleWithoutHiddens; 
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
    // $ANTLR end "entryRuleWithoutHiddens"


    // $ANTLR start "ruleWithoutHiddens"
    // InternalHiddenTerminalsTestLanguage.g:134:1: ruleWithoutHiddens returns [EObject current=null] : (otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) ) ;
    public final EObject ruleWithoutHiddens() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_spaces_1_0=null;
        Token otherlv_2=null;
        Token lv_spaces_3_0=null;
        Token lv_valid_4_0=null;


        	enterRule();

        try {
            // InternalHiddenTerminalsTestLanguage.g:140:2: ( (otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) ) )
            // InternalHiddenTerminalsTestLanguage.g:141:2: (otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) )
            {
            // InternalHiddenTerminalsTestLanguage.g:141:2: (otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) )
            // InternalHiddenTerminalsTestLanguage.g:142:3: otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) )
            {
            otherlv_0=(Token)match(input,8,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getWithoutHiddensAccess().getWithoutKeyword_0());
            		
            // InternalHiddenTerminalsTestLanguage.g:146:3: ( (lv_spaces_1_0= RULE_WS ) )
            // InternalHiddenTerminalsTestLanguage.g:147:4: (lv_spaces_1_0= RULE_WS )
            {
            // InternalHiddenTerminalsTestLanguage.g:147:4: (lv_spaces_1_0= RULE_WS )
            // InternalHiddenTerminalsTestLanguage.g:148:5: lv_spaces_1_0= RULE_WS
            {
            lv_spaces_1_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_4); 

            					newLeafNode(lv_spaces_1_0, grammarAccess.getWithoutHiddensAccess().getSpacesWSTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWithoutHiddensRule());
            					}
            					addWithLastConsumed(
            						current,
            						"spaces",
            						lv_spaces_1_0,
            						"org.eclipse.xtext.parser.terminalrules.HiddenTerminalsTestLanguage.WS");
            				

            }


            }

            otherlv_2=(Token)match(input,9,FollowSets000.FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getWithoutHiddensAccess().getHiddensKeyword_2());
            		
            // InternalHiddenTerminalsTestLanguage.g:168:3: ( (lv_spaces_3_0= RULE_WS ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_WS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalHiddenTerminalsTestLanguage.g:169:4: (lv_spaces_3_0= RULE_WS )
                    {
                    // InternalHiddenTerminalsTestLanguage.g:169:4: (lv_spaces_3_0= RULE_WS )
                    // InternalHiddenTerminalsTestLanguage.g:170:5: lv_spaces_3_0= RULE_WS
                    {
                    lv_spaces_3_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_6); 

                    					newLeafNode(lv_spaces_3_0, grammarAccess.getWithoutHiddensAccess().getSpacesWSTerminalRuleCall_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getWithoutHiddensRule());
                    					}
                    					addWithLastConsumed(
                    						current,
                    						"spaces",
                    						lv_spaces_3_0,
                    						"org.eclipse.xtext.parser.terminalrules.HiddenTerminalsTestLanguage.WS");
                    				

                    }


                    }
                    break;

            }

            // InternalHiddenTerminalsTestLanguage.g:186:3: ( (lv_valid_4_0= ';' ) )
            // InternalHiddenTerminalsTestLanguage.g:187:4: (lv_valid_4_0= ';' )
            {
            // InternalHiddenTerminalsTestLanguage.g:187:4: (lv_valid_4_0= ';' )
            // InternalHiddenTerminalsTestLanguage.g:188:5: lv_valid_4_0= ';'
            {
            lv_valid_4_0=(Token)match(input,10,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_valid_4_0, grammarAccess.getWithoutHiddensAccess().getValidSemicolonKeyword_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWithoutHiddensRule());
            					}
            					setWithLastConsumed(current, "valid", lv_valid_4_0 != null, ";");
            				

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
    // $ANTLR end "ruleWithoutHiddens"


    // $ANTLR start "entryRuleWithHiddens"
    // InternalHiddenTerminalsTestLanguage.g:204:1: entryRuleWithHiddens returns [EObject current=null] : iv_ruleWithHiddens= ruleWithHiddens EOF ;
    public final EObject entryRuleWithHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWithHiddens = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // InternalHiddenTerminalsTestLanguage.g:206:2: (iv_ruleWithHiddens= ruleWithHiddens EOF )
            // InternalHiddenTerminalsTestLanguage.g:207:2: iv_ruleWithHiddens= ruleWithHiddens EOF
            {
             newCompositeNode(grammarAccess.getWithHiddensRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleWithHiddens=ruleWithHiddens();

            state._fsp--;

             current =iv_ruleWithHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleWithHiddens"


    // $ANTLR start "ruleWithHiddens"
    // InternalHiddenTerminalsTestLanguage.g:216:1: ruleWithHiddens returns [EObject current=null] : (otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) ) ) ;
    public final EObject ruleWithHiddens() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_valid_2_0=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // InternalHiddenTerminalsTestLanguage.g:223:2: ( (otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) ) ) )
            // InternalHiddenTerminalsTestLanguage.g:224:2: (otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) ) )
            {
            // InternalHiddenTerminalsTestLanguage.g:224:2: (otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) ) )
            // InternalHiddenTerminalsTestLanguage.g:225:3: otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getWithHiddensAccess().getWithKeyword_0());
            		
            otherlv_1=(Token)match(input,9,FollowSets000.FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getWithHiddensAccess().getHiddensKeyword_1());
            		
            // InternalHiddenTerminalsTestLanguage.g:233:3: ( (lv_valid_2_0= ';' ) )
            // InternalHiddenTerminalsTestLanguage.g:234:4: (lv_valid_2_0= ';' )
            {
            // InternalHiddenTerminalsTestLanguage.g:234:4: (lv_valid_2_0= ';' )
            // InternalHiddenTerminalsTestLanguage.g:235:5: lv_valid_2_0= ';'
            {
            lv_valid_2_0=(Token)match(input,10,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_valid_2_0, grammarAccess.getWithHiddensAccess().getValidSemicolonKeyword_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWithHiddensRule());
            					}
            					setWithLastConsumed(current, "valid", lv_valid_2_0 != null, ";");
            				

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleWithHiddens"


    // $ANTLR start "entryRuleOverridingHiddens"
    // InternalHiddenTerminalsTestLanguage.g:254:1: entryRuleOverridingHiddens returns [EObject current=null] : iv_ruleOverridingHiddens= ruleOverridingHiddens EOF ;
    public final EObject entryRuleOverridingHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridingHiddens = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // InternalHiddenTerminalsTestLanguage.g:256:2: (iv_ruleOverridingHiddens= ruleOverridingHiddens EOF )
            // InternalHiddenTerminalsTestLanguage.g:257:2: iv_ruleOverridingHiddens= ruleOverridingHiddens EOF
            {
             newCompositeNode(grammarAccess.getOverridingHiddensRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOverridingHiddens=ruleOverridingHiddens();

            state._fsp--;

             current =iv_ruleOverridingHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleOverridingHiddens"


    // $ANTLR start "ruleOverridingHiddens"
    // InternalHiddenTerminalsTestLanguage.g:266:1: ruleOverridingHiddens returns [EObject current=null] : (otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) ) ) ;
    public final EObject ruleOverridingHiddens() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_valid_5_0=null;
        EObject lv_called_3_0 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // InternalHiddenTerminalsTestLanguage.g:273:2: ( (otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) ) ) )
            // InternalHiddenTerminalsTestLanguage.g:274:2: (otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) ) )
            {
            // InternalHiddenTerminalsTestLanguage.g:274:2: (otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) ) )
            // InternalHiddenTerminalsTestLanguage.g:275:3: otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) )
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getOverridingHiddensAccess().getOverridingKeyword_0());
            		
            otherlv_1=(Token)match(input,9,FollowSets000.FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getOverridingHiddensAccess().getHiddensKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getOverridingHiddensAccess().getLeftParenthesisKeyword_2());
            		
            // InternalHiddenTerminalsTestLanguage.g:287:3: ( (lv_called_3_0= ruleOverridingHiddensCall ) )
            // InternalHiddenTerminalsTestLanguage.g:288:4: (lv_called_3_0= ruleOverridingHiddensCall )
            {
            // InternalHiddenTerminalsTestLanguage.g:288:4: (lv_called_3_0= ruleOverridingHiddensCall )
            // InternalHiddenTerminalsTestLanguage.g:289:5: lv_called_3_0= ruleOverridingHiddensCall
            {

            					newCompositeNode(grammarAccess.getOverridingHiddensAccess().getCalledOverridingHiddensCallParserRuleCall_3_0());
            				
            pushFollow(FollowSets000.FOLLOW_9);
            lv_called_3_0=ruleOverridingHiddensCall();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOverridingHiddensRule());
            					}
            					set(
            						current,
            						"called",
            						lv_called_3_0,
            						"org.eclipse.xtext.parser.terminalrules.HiddenTerminalsTestLanguage.OverridingHiddensCall");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getOverridingHiddensAccess().getRightParenthesisKeyword_4());
            		
            // InternalHiddenTerminalsTestLanguage.g:310:3: ( (lv_valid_5_0= ';' ) )
            // InternalHiddenTerminalsTestLanguage.g:311:4: (lv_valid_5_0= ';' )
            {
            // InternalHiddenTerminalsTestLanguage.g:311:4: (lv_valid_5_0= ';' )
            // InternalHiddenTerminalsTestLanguage.g:312:5: lv_valid_5_0= ';'
            {
            lv_valid_5_0=(Token)match(input,10,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_valid_5_0, grammarAccess.getOverridingHiddensAccess().getValidSemicolonKeyword_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOverridingHiddensRule());
            					}
            					setWithLastConsumed(current, "valid", lv_valid_5_0 != null, ";");
            				

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleOverridingHiddens"


    // $ANTLR start "entryRuleOverridingHiddensCall"
    // InternalHiddenTerminalsTestLanguage.g:331:1: entryRuleOverridingHiddensCall returns [EObject current=null] : iv_ruleOverridingHiddensCall= ruleOverridingHiddensCall EOF ;
    public final EObject entryRuleOverridingHiddensCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridingHiddensCall = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalHiddenTerminalsTestLanguage.g:333:2: (iv_ruleOverridingHiddensCall= ruleOverridingHiddensCall EOF )
            // InternalHiddenTerminalsTestLanguage.g:334:2: iv_ruleOverridingHiddensCall= ruleOverridingHiddensCall EOF
            {
             newCompositeNode(grammarAccess.getOverridingHiddensCallRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOverridingHiddensCall=ruleOverridingHiddensCall();

            state._fsp--;

             current =iv_ruleOverridingHiddensCall; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleOverridingHiddensCall"


    // $ANTLR start "ruleOverridingHiddensCall"
    // InternalHiddenTerminalsTestLanguage.g:343:1: ruleOverridingHiddensCall returns [EObject current=null] : (otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) ) ;
    public final EObject ruleOverridingHiddensCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_spaces_1_0=null;
        Token lv_valid_2_0=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalHiddenTerminalsTestLanguage.g:350:2: ( (otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) ) )
            // InternalHiddenTerminalsTestLanguage.g:351:2: (otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) )
            {
            // InternalHiddenTerminalsTestLanguage.g:351:2: (otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) )
            // InternalHiddenTerminalsTestLanguage.g:352:3: otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getOverridingHiddensCallAccess().getCallKeyword_0());
            		
            // InternalHiddenTerminalsTestLanguage.g:356:3: ( (lv_spaces_1_0= RULE_WS ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_WS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalHiddenTerminalsTestLanguage.g:357:4: (lv_spaces_1_0= RULE_WS )
                    {
                    // InternalHiddenTerminalsTestLanguage.g:357:4: (lv_spaces_1_0= RULE_WS )
                    // InternalHiddenTerminalsTestLanguage.g:358:5: lv_spaces_1_0= RULE_WS
                    {
                    lv_spaces_1_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_6); 

                    					newLeafNode(lv_spaces_1_0, grammarAccess.getOverridingHiddensCallAccess().getSpacesWSTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOverridingHiddensCallRule());
                    					}
                    					addWithLastConsumed(
                    						current,
                    						"spaces",
                    						lv_spaces_1_0,
                    						"org.eclipse.xtext.parser.terminalrules.HiddenTerminalsTestLanguage.WS");
                    				

                    }


                    }
                    break;

            }

            // InternalHiddenTerminalsTestLanguage.g:374:3: ( (lv_valid_2_0= ';' ) )
            // InternalHiddenTerminalsTestLanguage.g:375:4: (lv_valid_2_0= ';' )
            {
            // InternalHiddenTerminalsTestLanguage.g:375:4: (lv_valid_2_0= ';' )
            // InternalHiddenTerminalsTestLanguage.g:376:5: lv_valid_2_0= ';'
            {
            lv_valid_2_0=(Token)match(input,10,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_valid_2_0, grammarAccess.getOverridingHiddensCallAccess().getValidSemicolonKeyword_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOverridingHiddensCallRule());
            					}
            					setWithLastConsumed(current, "valid", lv_valid_2_0 != null, ";");
            				

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleOverridingHiddensCall"


    // $ANTLR start "entryRuleInheritingHiddens"
    // InternalHiddenTerminalsTestLanguage.g:395:1: entryRuleInheritingHiddens returns [EObject current=null] : iv_ruleInheritingHiddens= ruleInheritingHiddens EOF ;
    public final EObject entryRuleInheritingHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInheritingHiddens = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // InternalHiddenTerminalsTestLanguage.g:397:2: (iv_ruleInheritingHiddens= ruleInheritingHiddens EOF )
            // InternalHiddenTerminalsTestLanguage.g:398:2: iv_ruleInheritingHiddens= ruleInheritingHiddens EOF
            {
             newCompositeNode(grammarAccess.getInheritingHiddensRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInheritingHiddens=ruleInheritingHiddens();

            state._fsp--;

             current =iv_ruleInheritingHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleInheritingHiddens"


    // $ANTLR start "ruleInheritingHiddens"
    // InternalHiddenTerminalsTestLanguage.g:407:1: ruleInheritingHiddens returns [EObject current=null] : (otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) ) ) ;
    public final EObject ruleInheritingHiddens() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token lv_valid_6_0=null;
        EObject lv_called_3_0 = null;

        EObject lv_hidingCalled_4_0 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // InternalHiddenTerminalsTestLanguage.g:414:2: ( (otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) ) ) )
            // InternalHiddenTerminalsTestLanguage.g:415:2: (otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) ) )
            {
            // InternalHiddenTerminalsTestLanguage.g:415:2: (otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) ) )
            // InternalHiddenTerminalsTestLanguage.g:416:3: otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) )
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getInheritingHiddensAccess().getInheritingKeyword_0());
            		
            otherlv_1=(Token)match(input,9,FollowSets000.FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getInheritingHiddensAccess().getHiddensKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getInheritingHiddensAccess().getLeftParenthesisKeyword_2());
            		
            // InternalHiddenTerminalsTestLanguage.g:428:3: ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            else if ( (LA4_0==19) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalHiddenTerminalsTestLanguage.g:429:4: ( (lv_called_3_0= ruleInheritingHiddensCall ) )
                    {
                    // InternalHiddenTerminalsTestLanguage.g:429:4: ( (lv_called_3_0= ruleInheritingHiddensCall ) )
                    // InternalHiddenTerminalsTestLanguage.g:430:5: (lv_called_3_0= ruleInheritingHiddensCall )
                    {
                    // InternalHiddenTerminalsTestLanguage.g:430:5: (lv_called_3_0= ruleInheritingHiddensCall )
                    // InternalHiddenTerminalsTestLanguage.g:431:6: lv_called_3_0= ruleInheritingHiddensCall
                    {

                    						newCompositeNode(grammarAccess.getInheritingHiddensAccess().getCalledInheritingHiddensCallParserRuleCall_3_0_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_called_3_0=ruleInheritingHiddensCall();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getInheritingHiddensRule());
                    						}
                    						set(
                    							current,
                    							"called",
                    							lv_called_3_0,
                    							"org.eclipse.xtext.parser.terminalrules.HiddenTerminalsTestLanguage.InheritingHiddensCall");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalHiddenTerminalsTestLanguage.g:449:4: ( (lv_hidingCalled_4_0= ruleHidingHiddens ) )
                    {
                    // InternalHiddenTerminalsTestLanguage.g:449:4: ( (lv_hidingCalled_4_0= ruleHidingHiddens ) )
                    // InternalHiddenTerminalsTestLanguage.g:450:5: (lv_hidingCalled_4_0= ruleHidingHiddens )
                    {
                    // InternalHiddenTerminalsTestLanguage.g:450:5: (lv_hidingCalled_4_0= ruleHidingHiddens )
                    // InternalHiddenTerminalsTestLanguage.g:451:6: lv_hidingCalled_4_0= ruleHidingHiddens
                    {

                    						newCompositeNode(grammarAccess.getInheritingHiddensAccess().getHidingCalledHidingHiddensParserRuleCall_3_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_hidingCalled_4_0=ruleHidingHiddens();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getInheritingHiddensRule());
                    						}
                    						set(
                    							current,
                    							"hidingCalled",
                    							lv_hidingCalled_4_0,
                    							"org.eclipse.xtext.parser.terminalrules.HiddenTerminalsTestLanguage.HidingHiddens");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getInheritingHiddensAccess().getRightParenthesisKeyword_4());
            		
            // InternalHiddenTerminalsTestLanguage.g:473:3: ( (lv_valid_6_0= ';' ) )
            // InternalHiddenTerminalsTestLanguage.g:474:4: (lv_valid_6_0= ';' )
            {
            // InternalHiddenTerminalsTestLanguage.g:474:4: (lv_valid_6_0= ';' )
            // InternalHiddenTerminalsTestLanguage.g:475:5: lv_valid_6_0= ';'
            {
            lv_valid_6_0=(Token)match(input,10,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_valid_6_0, grammarAccess.getInheritingHiddensAccess().getValidSemicolonKeyword_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInheritingHiddensRule());
            					}
            					setWithLastConsumed(current, "valid", lv_valid_6_0 != null, ";");
            				

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleInheritingHiddens"


    // $ANTLR start "entryRuleDatatypeHiddens"
    // InternalHiddenTerminalsTestLanguage.g:494:1: entryRuleDatatypeHiddens returns [EObject current=null] : iv_ruleDatatypeHiddens= ruleDatatypeHiddens EOF ;
    public final EObject entryRuleDatatypeHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatypeHiddens = null;


        try {
            // InternalHiddenTerminalsTestLanguage.g:494:56: (iv_ruleDatatypeHiddens= ruleDatatypeHiddens EOF )
            // InternalHiddenTerminalsTestLanguage.g:495:2: iv_ruleDatatypeHiddens= ruleDatatypeHiddens EOF
            {
             newCompositeNode(grammarAccess.getDatatypeHiddensRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDatatypeHiddens=ruleDatatypeHiddens();

            state._fsp--;

             current =iv_ruleDatatypeHiddens; 
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
    // $ANTLR end "entryRuleDatatypeHiddens"


    // $ANTLR start "ruleDatatypeHiddens"
    // InternalHiddenTerminalsTestLanguage.g:501:1: ruleDatatypeHiddens returns [EObject current=null] : (otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) ) ;
    public final EObject ruleDatatypeHiddens() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_valid_1_0 = null;



        	enterRule();

        try {
            // InternalHiddenTerminalsTestLanguage.g:507:2: ( (otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) ) )
            // InternalHiddenTerminalsTestLanguage.g:508:2: (otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) )
            {
            // InternalHiddenTerminalsTestLanguage.g:508:2: (otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) )
            // InternalHiddenTerminalsTestLanguage.g:509:3: otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) )
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getDatatypeHiddensAccess().getDatatypeKeyword_0());
            		
            // InternalHiddenTerminalsTestLanguage.g:513:3: ( (lv_valid_1_0= ruleDatatypeRule ) )
            // InternalHiddenTerminalsTestLanguage.g:514:4: (lv_valid_1_0= ruleDatatypeRule )
            {
            // InternalHiddenTerminalsTestLanguage.g:514:4: (lv_valid_1_0= ruleDatatypeRule )
            // InternalHiddenTerminalsTestLanguage.g:515:5: lv_valid_1_0= ruleDatatypeRule
            {

            					newCompositeNode(grammarAccess.getDatatypeHiddensAccess().getValidDatatypeRuleParserRuleCall_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_valid_1_0=ruleDatatypeRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDatatypeHiddensRule());
            					}
            					set(
            						current,
            						"valid",
            						lv_valid_1_0 != null,
            						"org.eclipse.xtext.parser.terminalrules.HiddenTerminalsTestLanguage.DatatypeRule");
            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "ruleDatatypeHiddens"


    // $ANTLR start "entryRuleDatatypeRule"
    // InternalHiddenTerminalsTestLanguage.g:536:1: entryRuleDatatypeRule returns [String current=null] : iv_ruleDatatypeRule= ruleDatatypeRule EOF ;
    public final String entryRuleDatatypeRule() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatypeRule = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // InternalHiddenTerminalsTestLanguage.g:538:2: (iv_ruleDatatypeRule= ruleDatatypeRule EOF )
            // InternalHiddenTerminalsTestLanguage.g:539:2: iv_ruleDatatypeRule= ruleDatatypeRule EOF
            {
             newCompositeNode(grammarAccess.getDatatypeRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDatatypeRule=ruleDatatypeRule();

            state._fsp--;

             current =iv_ruleDatatypeRule.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleDatatypeRule"


    // $ANTLR start "ruleDatatypeRule"
    // InternalHiddenTerminalsTestLanguage.g:548:1: ruleDatatypeRule returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'rule' kw= ';' ) ;
    public final AntlrDatatypeRuleToken ruleDatatypeRule() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // InternalHiddenTerminalsTestLanguage.g:555:2: ( (kw= 'rule' kw= ';' ) )
            // InternalHiddenTerminalsTestLanguage.g:556:2: (kw= 'rule' kw= ';' )
            {
            // InternalHiddenTerminalsTestLanguage.g:556:2: (kw= 'rule' kw= ';' )
            // InternalHiddenTerminalsTestLanguage.g:557:3: kw= 'rule' kw= ';'
            {
            kw=(Token)match(input,18,FollowSets000.FOLLOW_6); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDatatypeRuleAccess().getRuleKeyword_0());
            		
            kw=(Token)match(input,10,FollowSets000.FOLLOW_2); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDatatypeRuleAccess().getSemicolonKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleDatatypeRule"


    // $ANTLR start "entryRuleHidingHiddens"
    // InternalHiddenTerminalsTestLanguage.g:574:1: entryRuleHidingHiddens returns [EObject current=null] : iv_ruleHidingHiddens= ruleHidingHiddens EOF ;
    public final EObject entryRuleHidingHiddens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHidingHiddens = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalHiddenTerminalsTestLanguage.g:576:2: (iv_ruleHidingHiddens= ruleHidingHiddens EOF )
            // InternalHiddenTerminalsTestLanguage.g:577:2: iv_ruleHidingHiddens= ruleHidingHiddens EOF
            {
             newCompositeNode(grammarAccess.getHidingHiddensRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleHidingHiddens=ruleHidingHiddens();

            state._fsp--;

             current =iv_ruleHidingHiddens; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleHidingHiddens"


    // $ANTLR start "ruleHidingHiddens"
    // InternalHiddenTerminalsTestLanguage.g:586:1: ruleHidingHiddens returns [EObject current=null] : (otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) ) ;
    public final EObject ruleHidingHiddens() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_space_1_0=null;
        EObject lv_called_2_0 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalHiddenTerminalsTestLanguage.g:593:2: ( (otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) ) )
            // InternalHiddenTerminalsTestLanguage.g:594:2: (otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) )
            {
            // InternalHiddenTerminalsTestLanguage.g:594:2: (otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) )
            // InternalHiddenTerminalsTestLanguage.g:595:3: otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) )
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getHidingHiddensAccess().getHidingKeyword_0());
            		
            // InternalHiddenTerminalsTestLanguage.g:599:3: ( (lv_space_1_0= RULE_WS ) )
            // InternalHiddenTerminalsTestLanguage.g:600:4: (lv_space_1_0= RULE_WS )
            {
            // InternalHiddenTerminalsTestLanguage.g:600:4: (lv_space_1_0= RULE_WS )
            // InternalHiddenTerminalsTestLanguage.g:601:5: lv_space_1_0= RULE_WS
            {
            lv_space_1_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_8); 

            					newLeafNode(lv_space_1_0, grammarAccess.getHidingHiddensAccess().getSpaceWSTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHidingHiddensRule());
            					}
            					setWithLastConsumed(
            						current,
            						"space",
            						lv_space_1_0,
            						"org.eclipse.xtext.parser.terminalrules.HiddenTerminalsTestLanguage.WS");
            				

            }


            }

            // InternalHiddenTerminalsTestLanguage.g:617:3: ( (lv_called_2_0= ruleInheritingHiddensCall ) )
            // InternalHiddenTerminalsTestLanguage.g:618:4: (lv_called_2_0= ruleInheritingHiddensCall )
            {
            // InternalHiddenTerminalsTestLanguage.g:618:4: (lv_called_2_0= ruleInheritingHiddensCall )
            // InternalHiddenTerminalsTestLanguage.g:619:5: lv_called_2_0= ruleInheritingHiddensCall
            {

            					newCompositeNode(grammarAccess.getHidingHiddensAccess().getCalledInheritingHiddensCallParserRuleCall_2_0());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_called_2_0=ruleInheritingHiddensCall();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHidingHiddensRule());
            					}
            					set(
            						current,
            						"called",
            						lv_called_2_0,
            						"org.eclipse.xtext.parser.terminalrules.HiddenTerminalsTestLanguage.InheritingHiddensCall");
            					afterParserOrEnumRuleCall();
            				

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleHidingHiddens"


    // $ANTLR start "entryRuleInheritingHiddensCall"
    // InternalHiddenTerminalsTestLanguage.g:643:1: entryRuleInheritingHiddensCall returns [EObject current=null] : iv_ruleInheritingHiddensCall= ruleInheritingHiddensCall EOF ;
    public final EObject entryRuleInheritingHiddensCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInheritingHiddensCall = null;


        try {
            // InternalHiddenTerminalsTestLanguage.g:643:62: (iv_ruleInheritingHiddensCall= ruleInheritingHiddensCall EOF )
            // InternalHiddenTerminalsTestLanguage.g:644:2: iv_ruleInheritingHiddensCall= ruleInheritingHiddensCall EOF
            {
             newCompositeNode(grammarAccess.getInheritingHiddensCallRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInheritingHiddensCall=ruleInheritingHiddensCall();

            state._fsp--;

             current =iv_ruleInheritingHiddensCall; 
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
    // $ANTLR end "entryRuleInheritingHiddensCall"


    // $ANTLR start "ruleInheritingHiddensCall"
    // InternalHiddenTerminalsTestLanguage.g:650:1: ruleInheritingHiddensCall returns [EObject current=null] : (otherlv_0= 'call' ( (lv_valid_1_0= ';' ) ) ) ;
    public final EObject ruleInheritingHiddensCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_valid_1_0=null;


        	enterRule();

        try {
            // InternalHiddenTerminalsTestLanguage.g:656:2: ( (otherlv_0= 'call' ( (lv_valid_1_0= ';' ) ) ) )
            // InternalHiddenTerminalsTestLanguage.g:657:2: (otherlv_0= 'call' ( (lv_valid_1_0= ';' ) ) )
            {
            // InternalHiddenTerminalsTestLanguage.g:657:2: (otherlv_0= 'call' ( (lv_valid_1_0= ';' ) ) )
            // InternalHiddenTerminalsTestLanguage.g:658:3: otherlv_0= 'call' ( (lv_valid_1_0= ';' ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getInheritingHiddensCallAccess().getCallKeyword_0());
            		
            // InternalHiddenTerminalsTestLanguage.g:662:3: ( (lv_valid_1_0= ';' ) )
            // InternalHiddenTerminalsTestLanguage.g:663:4: (lv_valid_1_0= ';' )
            {
            // InternalHiddenTerminalsTestLanguage.g:663:4: (lv_valid_1_0= ';' )
            // InternalHiddenTerminalsTestLanguage.g:664:5: lv_valid_1_0= ';'
            {
            lv_valid_1_0=(Token)match(input,10,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_valid_1_0, grammarAccess.getInheritingHiddensCallAccess().getValidSemicolonKeyword_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInheritingHiddensCallRule());
            					}
            					setWithLastConsumed(current, "valid", lv_valid_1_0 != null, ";");
            				

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
    // $ANTLR end "ruleInheritingHiddensCall"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000410L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    }


}