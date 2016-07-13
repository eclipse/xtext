package org.eclipse.xtext.generator.grammarAccess.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.generator.grammarAccess.services.GrammarAccessTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalGrammarAccessTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'foo'", "'bar'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalGrammarAccessTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalGrammarAccessTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalGrammarAccessTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalGrammarAccessTestLanguage.g"; }



     	private GrammarAccessTestLanguageGrammarAccess grammarAccess;

        public InternalGrammarAccessTestLanguageParser(TokenStream input, GrammarAccessTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Root";
       	}

       	@Override
       	protected GrammarAccessTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleRoot"
    // InternalGrammarAccessTestLanguage.g:64:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // InternalGrammarAccessTestLanguage.g:64:45: (iv_ruleRoot= ruleRoot EOF )
            // InternalGrammarAccessTestLanguage.g:65:2: iv_ruleRoot= ruleRoot EOF
            {
             newCompositeNode(grammarAccess.getRootRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRoot=ruleRoot();

            state._fsp--;

             current =iv_ruleRoot; 
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
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // InternalGrammarAccessTestLanguage.g:71:1: ruleRoot returns [EObject current=null] : ( (lv_elements_0_0= ruleType ) )* ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;



        	enterRule();

        try {
            // InternalGrammarAccessTestLanguage.g:77:2: ( ( (lv_elements_0_0= ruleType ) )* )
            // InternalGrammarAccessTestLanguage.g:78:2: ( (lv_elements_0_0= ruleType ) )*
            {
            // InternalGrammarAccessTestLanguage.g:78:2: ( (lv_elements_0_0= ruleType ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=11 && LA1_0<=12)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalGrammarAccessTestLanguage.g:79:3: (lv_elements_0_0= ruleType )
            	    {
            	    // InternalGrammarAccessTestLanguage.g:79:3: (lv_elements_0_0= ruleType )
            	    // InternalGrammarAccessTestLanguage.g:80:4: lv_elements_0_0= ruleType
            	    {

            	    				newCompositeNode(grammarAccess.getRootAccess().getElementsTypeParserRuleCall_0());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_elements_0_0=ruleType();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getRootRule());
            	    				}
            	    				add(
            	    					current,
            	    					"elements",
            	    					lv_elements_0_0,
            	    					"org.eclipse.xtext.generator.grammarAccess.GrammarAccessTestLanguage.Type");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleType"
    // InternalGrammarAccessTestLanguage.g:100:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalGrammarAccessTestLanguage.g:100:45: (iv_ruleType= ruleType EOF )
            // InternalGrammarAccessTestLanguage.g:101:2: iv_ruleType= ruleType EOF
            {
             newCompositeNode(grammarAccess.getTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalGrammarAccessTestLanguage.g:107:1: ruleType returns [EObject current=null] : (this_AType_0= ruleAType | this_AnotherType_1= ruleAnotherType ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_AType_0 = null;

        EObject this_AnotherType_1 = null;



        	enterRule();

        try {
            // InternalGrammarAccessTestLanguage.g:113:2: ( (this_AType_0= ruleAType | this_AnotherType_1= ruleAnotherType ) )
            // InternalGrammarAccessTestLanguage.g:114:2: (this_AType_0= ruleAType | this_AnotherType_1= ruleAnotherType )
            {
            // InternalGrammarAccessTestLanguage.g:114:2: (this_AType_0= ruleAType | this_AnotherType_1= ruleAnotherType )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalGrammarAccessTestLanguage.g:115:3: this_AType_0= ruleAType
                    {

                    			newCompositeNode(grammarAccess.getTypeAccess().getATypeParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_AType_0=ruleAType();

                    state._fsp--;


                    			current = this_AType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalGrammarAccessTestLanguage.g:124:3: this_AnotherType_1= ruleAnotherType
                    {

                    			newCompositeNode(grammarAccess.getTypeAccess().getAnotherTypeParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_AnotherType_1=ruleAnotherType();

                    state._fsp--;


                    			current = this_AnotherType_1;
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
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleAType"
    // InternalGrammarAccessTestLanguage.g:136:1: entryRuleAType returns [EObject current=null] : iv_ruleAType= ruleAType EOF ;
    public final EObject entryRuleAType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAType = null;


        try {
            // InternalGrammarAccessTestLanguage.g:136:46: (iv_ruleAType= ruleAType EOF )
            // InternalGrammarAccessTestLanguage.g:137:2: iv_ruleAType= ruleAType EOF
            {
             newCompositeNode(grammarAccess.getATypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAType=ruleAType();

            state._fsp--;

             current =iv_ruleAType; 
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
    // $ANTLR end "entryRuleAType"


    // $ANTLR start "ruleAType"
    // InternalGrammarAccessTestLanguage.g:143:1: ruleAType returns [EObject current=null] : (otherlv_0= 'foo' () ) ;
    public final EObject ruleAType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalGrammarAccessTestLanguage.g:149:2: ( (otherlv_0= 'foo' () ) )
            // InternalGrammarAccessTestLanguage.g:150:2: (otherlv_0= 'foo' () )
            {
            // InternalGrammarAccessTestLanguage.g:150:2: (otherlv_0= 'foo' () )
            // InternalGrammarAccessTestLanguage.g:151:3: otherlv_0= 'foo' ()
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_0, grammarAccess.getATypeAccess().getFooKeyword_0());
            		
            // InternalGrammarAccessTestLanguage.g:155:3: ()
            // InternalGrammarAccessTestLanguage.g:156:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getATypeAccess().getATypeAction_1(),
            					current);
            			

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
    // $ANTLR end "ruleAType"


    // $ANTLR start "entryRuleAnotherType"
    // InternalGrammarAccessTestLanguage.g:166:1: entryRuleAnotherType returns [EObject current=null] : iv_ruleAnotherType= ruleAnotherType EOF ;
    public final EObject entryRuleAnotherType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnotherType = null;


        try {
            // InternalGrammarAccessTestLanguage.g:166:52: (iv_ruleAnotherType= ruleAnotherType EOF )
            // InternalGrammarAccessTestLanguage.g:167:2: iv_ruleAnotherType= ruleAnotherType EOF
            {
             newCompositeNode(grammarAccess.getAnotherTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAnotherType=ruleAnotherType();

            state._fsp--;

             current =iv_ruleAnotherType; 
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
    // $ANTLR end "entryRuleAnotherType"


    // $ANTLR start "ruleAnotherType"
    // InternalGrammarAccessTestLanguage.g:173:1: ruleAnotherType returns [EObject current=null] : (otherlv_0= 'bar' () ) ;
    public final EObject ruleAnotherType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalGrammarAccessTestLanguage.g:179:2: ( (otherlv_0= 'bar' () ) )
            // InternalGrammarAccessTestLanguage.g:180:2: (otherlv_0= 'bar' () )
            {
            // InternalGrammarAccessTestLanguage.g:180:2: (otherlv_0= 'bar' () )
            // InternalGrammarAccessTestLanguage.g:181:3: otherlv_0= 'bar' ()
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_0, grammarAccess.getAnotherTypeAccess().getBarKeyword_0());
            		
            // InternalGrammarAccessTestLanguage.g:185:3: ()
            // InternalGrammarAccessTestLanguage.g:186:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAnotherTypeAccess().getAnotherTypeAction_1(),
            					current);
            			

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
    // $ANTLR end "ruleAnotherType"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001802L});
    }


}