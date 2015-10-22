package org.eclipse.xtext.linking.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.linking.idea.lang.Bug362902ElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.linking.services.Bug362902GrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalBug362902Parser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'favourite'", "'Hello'", "'!'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalBug362902Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug362902Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug362902Parser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalBug362902.g"; }



    	protected Bug362902GrammarAccess grammarAccess;

    	protected Bug362902ElementTypeProvider elementTypeProvider;

    	public PsiInternalBug362902Parser(PsiBuilder builder, TokenStream input, Bug362902ElementTypeProvider elementTypeProvider, Bug362902GrammarAccess grammarAccess) {
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
    // PsiInternalBug362902.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalBug362902.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalBug362902.g:53:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalBug362902.g:59:1: ruleModel returns [Boolean current=false] : ( ( (lv_greetings_0_0= ruleGreeting ) )* otherlv_1= 'favourite' ( ( ruleMyId ) ) ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Boolean lv_greetings_0_0 = null;


        try {
            // PsiInternalBug362902.g:60:1: ( ( ( (lv_greetings_0_0= ruleGreeting ) )* otherlv_1= 'favourite' ( ( ruleMyId ) ) ) )
            // PsiInternalBug362902.g:61:2: ( ( (lv_greetings_0_0= ruleGreeting ) )* otherlv_1= 'favourite' ( ( ruleMyId ) ) )
            {
            // PsiInternalBug362902.g:61:2: ( ( (lv_greetings_0_0= ruleGreeting ) )* otherlv_1= 'favourite' ( ( ruleMyId ) ) )
            // PsiInternalBug362902.g:62:3: ( (lv_greetings_0_0= ruleGreeting ) )* otherlv_1= 'favourite' ( ( ruleMyId ) )
            {
            // PsiInternalBug362902.g:62:3: ( (lv_greetings_0_0= ruleGreeting ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalBug362902.g:63:4: (lv_greetings_0_0= ruleGreeting )
            	    {
            	    // PsiInternalBug362902.g:63:4: (lv_greetings_0_0= ruleGreeting )
            	    // PsiInternalBug362902.g:64:5: lv_greetings_0_0= ruleGreeting
            	    {

            	    					markComposite(elementTypeProvider.getModel_GreetingsGreetingParserRuleCall_0_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_greetings_0_0=ruleGreeting();

            	    state._fsp--;


            	    					doneComposite();
            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getModel_FavouriteKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalBug362902.g:84:3: ( ( ruleMyId ) )
            // PsiInternalBug362902.g:85:4: ( ruleMyId )
            {
            // PsiInternalBug362902.g:85:4: ( ruleMyId )
            // PsiInternalBug362902.g:86:5: ruleMyId
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markComposite(elementTypeProvider.getModel_FavouriteGreetingCrossReference_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMyId();

            state._fsp--;


            					doneComposite();
            				

            }


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
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleGreeting"
    // PsiInternalBug362902.g:105:1: entryRuleGreeting returns [Boolean current=false] : iv_ruleGreeting= ruleGreeting EOF ;
    public final Boolean entryRuleGreeting() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleGreeting = null;


        try {
            // PsiInternalBug362902.g:105:50: (iv_ruleGreeting= ruleGreeting EOF )
            // PsiInternalBug362902.g:106:2: iv_ruleGreeting= ruleGreeting EOF
            {
             markComposite(elementTypeProvider.getGreetingElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGreeting=ruleGreeting();

            state._fsp--;

             current =iv_ruleGreeting; 
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
    // $ANTLR end "entryRuleGreeting"


    // $ANTLR start "ruleGreeting"
    // PsiInternalBug362902.g:112:1: ruleGreeting returns [Boolean current=false] : (otherlv_0= 'Hello' ( (lv_name_1_0= ruleMyId ) ) otherlv_2= '!' ) ;
    public final Boolean ruleGreeting() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean lv_name_1_0 = null;


        try {
            // PsiInternalBug362902.g:113:1: ( (otherlv_0= 'Hello' ( (lv_name_1_0= ruleMyId ) ) otherlv_2= '!' ) )
            // PsiInternalBug362902.g:114:2: (otherlv_0= 'Hello' ( (lv_name_1_0= ruleMyId ) ) otherlv_2= '!' )
            {
            // PsiInternalBug362902.g:114:2: (otherlv_0= 'Hello' ( (lv_name_1_0= ruleMyId ) ) otherlv_2= '!' )
            // PsiInternalBug362902.g:115:3: otherlv_0= 'Hello' ( (lv_name_1_0= ruleMyId ) ) otherlv_2= '!'
            {

            			markLeaf(elementTypeProvider.getGreeting_HelloKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalBug362902.g:122:3: ( (lv_name_1_0= ruleMyId ) )
            // PsiInternalBug362902.g:123:4: (lv_name_1_0= ruleMyId )
            {
            // PsiInternalBug362902.g:123:4: (lv_name_1_0= ruleMyId )
            // PsiInternalBug362902.g:124:5: lv_name_1_0= ruleMyId
            {

            					markComposite(elementTypeProvider.getGreeting_NameMyIdParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_5);
            lv_name_1_0=ruleMyId();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            			markLeaf(elementTypeProvider.getGreeting_ExclamationMarkKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_2);
            		

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
    // $ANTLR end "ruleGreeting"


    // $ANTLR start "entryRuleMyId"
    // PsiInternalBug362902.g:148:1: entryRuleMyId returns [Boolean current=false] : iv_ruleMyId= ruleMyId EOF ;
    public final Boolean entryRuleMyId() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMyId = null;


        try {
            // PsiInternalBug362902.g:148:46: (iv_ruleMyId= ruleMyId EOF )
            // PsiInternalBug362902.g:149:2: iv_ruleMyId= ruleMyId EOF
            {
             markComposite(elementTypeProvider.getMyIdElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMyId=ruleMyId();

            state._fsp--;

             current =iv_ruleMyId; 
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
    // $ANTLR end "entryRuleMyId"


    // $ANTLR start "ruleMyId"
    // PsiInternalBug362902.g:155:1: ruleMyId returns [Boolean current=false] : this_ID_0= RULE_ID ;
    public final Boolean ruleMyId() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;

        try {
            // PsiInternalBug362902.g:156:1: (this_ID_0= RULE_ID )
            // PsiInternalBug362902.g:157:2: this_ID_0= RULE_ID
            {

            		markLeaf(elementTypeProvider.getMyId_IDTerminalRuleCallElementType());
            	
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            		doneLeaf(this_ID_0);
            	

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
    // $ANTLR end "ruleMyId"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    }


}