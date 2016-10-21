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
import org.eclipse.xtext.parser.antlr.services.Bug406914TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug406914TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_WS", "RULE_ANY_OTHER", "'\\b'", "'\\f'", "'\\n'", "'lineFeed'", "'\\r'", "'\\t'", "'\\\\'"
    };
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int T__7=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=5;
    public static final int RULE_ANY_OTHER=6;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int EOF=-1;
    public static final int T__10=10;

    // delegates
    // delegators


        public InternalBug406914TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug406914TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug406914TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug406914TestLanguage.g"; }



     	private Bug406914TestLanguageGrammarAccess grammarAccess;

        public InternalBug406914TestLanguageParser(TokenStream input, Bug406914TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected Bug406914TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalBug406914TestLanguage.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalBug406914TestLanguage.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalBug406914TestLanguage.g:65:2: iv_ruleModel= ruleModel EOF
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
    // InternalBug406914TestLanguage.g:71:1: ruleModel returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ruleBS_ESCAPE ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalBug406914TestLanguage.g:77:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ruleBS_ESCAPE ) )
            // InternalBug406914TestLanguage.g:78:2: ( ( (lv_name_0_0= RULE_ID ) ) ruleBS_ESCAPE )
            {
            // InternalBug406914TestLanguage.g:78:2: ( ( (lv_name_0_0= RULE_ID ) ) ruleBS_ESCAPE )
            // InternalBug406914TestLanguage.g:79:3: ( (lv_name_0_0= RULE_ID ) ) ruleBS_ESCAPE
            {
            // InternalBug406914TestLanguage.g:79:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalBug406914TestLanguage.g:80:4: (lv_name_0_0= RULE_ID )
            {
            // InternalBug406914TestLanguage.g:80:4: (lv_name_0_0= RULE_ID )
            // InternalBug406914TestLanguage.g:81:5: lv_name_0_0= RULE_ID
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
            						"org.eclipse.xtext.parser.antlr.Bug406914TestLanguage.ID");
            				

            }


            }


            			newCompositeNode(grammarAccess.getModelAccess().getBS_ESCAPEParserRuleCall_1());
            		
            pushFollow(FollowSets000.FOLLOW_2);
            ruleBS_ESCAPE();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		

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


    // $ANTLR start "entryRuleBS_ESCAPE"
    // InternalBug406914TestLanguage.g:108:1: entryRuleBS_ESCAPE returns [String current=null] : iv_ruleBS_ESCAPE= ruleBS_ESCAPE EOF ;
    public final String entryRuleBS_ESCAPE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBS_ESCAPE = null;


        try {
            // InternalBug406914TestLanguage.g:108:49: (iv_ruleBS_ESCAPE= ruleBS_ESCAPE EOF )
            // InternalBug406914TestLanguage.g:109:2: iv_ruleBS_ESCAPE= ruleBS_ESCAPE EOF
            {
             newCompositeNode(grammarAccess.getBS_ESCAPERule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBS_ESCAPE=ruleBS_ESCAPE();

            state._fsp--;

             current =iv_ruleBS_ESCAPE.getText(); 
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
    // $ANTLR end "entryRuleBS_ESCAPE"


    // $ANTLR start "ruleBS_ESCAPE"
    // InternalBug406914TestLanguage.g:115:1: ruleBS_ESCAPE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '\\b' | kw= '\\f' | kw= '\\n' | kw= 'lineFeed' | kw= '\\r' | kw= '\\t' | kw= '\\\\' ) ;
    public final AntlrDatatypeRuleToken ruleBS_ESCAPE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBug406914TestLanguage.g:121:2: ( (kw= '\\b' | kw= '\\f' | kw= '\\n' | kw= 'lineFeed' | kw= '\\r' | kw= '\\t' | kw= '\\\\' ) )
            // InternalBug406914TestLanguage.g:122:2: (kw= '\\b' | kw= '\\f' | kw= '\\n' | kw= 'lineFeed' | kw= '\\r' | kw= '\\t' | kw= '\\\\' )
            {
            // InternalBug406914TestLanguage.g:122:2: (kw= '\\b' | kw= '\\f' | kw= '\\n' | kw= 'lineFeed' | kw= '\\r' | kw= '\\t' | kw= '\\\\' )
            int alt1=7;
            switch ( input.LA(1) ) {
            case 7:
                {
                alt1=1;
                }
                break;
            case 8:
                {
                alt1=2;
                }
                break;
            case 9:
                {
                alt1=3;
                }
                break;
            case 10:
                {
                alt1=4;
                }
                break;
            case 11:
                {
                alt1=5;
                }
                break;
            case 12:
                {
                alt1=6;
                }
                break;
            case 13:
                {
                alt1=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalBug406914TestLanguage.g:123:3: kw= '\\b'
                    {
                    kw=(Token)match(input,7,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBS_ESCAPEAccess().getBackspaceKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalBug406914TestLanguage.g:129:3: kw= '\\f'
                    {
                    kw=(Token)match(input,8,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBS_ESCAPEAccess().getFormFeedKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalBug406914TestLanguage.g:135:3: kw= '\\n'
                    {
                    kw=(Token)match(input,9,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBS_ESCAPEAccess().getLineFeedKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalBug406914TestLanguage.g:141:3: kw= 'lineFeed'
                    {
                    kw=(Token)match(input,10,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBS_ESCAPEAccess().getLineFeedKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalBug406914TestLanguage.g:147:3: kw= '\\r'
                    {
                    kw=(Token)match(input,11,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBS_ESCAPEAccess().getCarriageReturnKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalBug406914TestLanguage.g:153:3: kw= '\\t'
                    {
                    kw=(Token)match(input,12,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBS_ESCAPEAccess().getTabKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalBug406914TestLanguage.g:159:3: kw= '\\\\'
                    {
                    kw=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBS_ESCAPEAccess().getBackslashKeyword_6());
                    		

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
    // $ANTLR end "ruleBS_ESCAPE"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000003F80L});
    }


}