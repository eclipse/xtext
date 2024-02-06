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
import org.eclipse.xtext.parser.terminalrules.services.UnicodeTestLanguageGrammarAccess;



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
public class InternalUnicodeTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_GERMAN_STRING", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_GERMAN_STRING=4;
    public static final int RULE_ID=6;
    public static final int RULE_WS=10;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_INT=7;
    public static final int RULE_ML_COMMENT=8;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalUnicodeTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUnicodeTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUnicodeTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalUnicodeTestLanguage.g"; }



     	private UnicodeTestLanguageGrammarAccess grammarAccess;

        public InternalUnicodeTestLanguageParser(TokenStream input, UnicodeTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected UnicodeTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalUnicodeTestLanguage.g:69:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalUnicodeTestLanguage.g:69:46: (iv_ruleModel= ruleModel EOF )
            // InternalUnicodeTestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
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
    // InternalUnicodeTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (lv_strings_0_0= ruleAbstractString ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_strings_0_0 = null;



        	enterRule();

        try {
            // InternalUnicodeTestLanguage.g:82:2: ( ( (lv_strings_0_0= ruleAbstractString ) )* )
            // InternalUnicodeTestLanguage.g:83:2: ( (lv_strings_0_0= ruleAbstractString ) )*
            {
            // InternalUnicodeTestLanguage.g:83:2: ( (lv_strings_0_0= ruleAbstractString ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_GERMAN_STRING && LA1_0<=RULE_STRING)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalUnicodeTestLanguage.g:84:3: (lv_strings_0_0= ruleAbstractString )
            	    {
            	    // InternalUnicodeTestLanguage.g:84:3: (lv_strings_0_0= ruleAbstractString )
            	    // InternalUnicodeTestLanguage.g:85:4: lv_strings_0_0= ruleAbstractString
            	    {

            	    				newCompositeNode(grammarAccess.getModelAccess().getStringsAbstractStringParserRuleCall_0());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_strings_0_0=ruleAbstractString();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"strings",
            	    					lv_strings_0_0,
            	    					"org.eclipse.xtext.parser.terminalrules.UnicodeTestLanguage.AbstractString");
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleAbstractString"
    // InternalUnicodeTestLanguage.g:105:1: entryRuleAbstractString returns [EObject current=null] : iv_ruleAbstractString= ruleAbstractString EOF ;
    public final EObject entryRuleAbstractString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractString = null;


        try {
            // InternalUnicodeTestLanguage.g:105:55: (iv_ruleAbstractString= ruleAbstractString EOF )
            // InternalUnicodeTestLanguage.g:106:2: iv_ruleAbstractString= ruleAbstractString EOF
            {
             newCompositeNode(grammarAccess.getAbstractStringRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractString=ruleAbstractString();

            state._fsp--;

             current =iv_ruleAbstractString; 
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
    // $ANTLR end "entryRuleAbstractString"


    // $ANTLR start "ruleAbstractString"
    // InternalUnicodeTestLanguage.g:112:1: ruleAbstractString returns [EObject current=null] : (this_GString_0= ruleGString | this_QuotedString_1= ruleQuotedString ) ;
    public final EObject ruleAbstractString() throws RecognitionException {
        EObject current = null;

        EObject this_GString_0 = null;

        EObject this_QuotedString_1 = null;



        	enterRule();

        try {
            // InternalUnicodeTestLanguage.g:118:2: ( (this_GString_0= ruleGString | this_QuotedString_1= ruleQuotedString ) )
            // InternalUnicodeTestLanguage.g:119:2: (this_GString_0= ruleGString | this_QuotedString_1= ruleQuotedString )
            {
            // InternalUnicodeTestLanguage.g:119:2: (this_GString_0= ruleGString | this_QuotedString_1= ruleQuotedString )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_GERMAN_STRING) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_STRING) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalUnicodeTestLanguage.g:120:3: this_GString_0= ruleGString
                    {

                    			newCompositeNode(grammarAccess.getAbstractStringAccess().getGStringParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_GString_0=ruleGString();

                    state._fsp--;


                    			current = this_GString_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalUnicodeTestLanguage.g:129:3: this_QuotedString_1= ruleQuotedString
                    {

                    			newCompositeNode(grammarAccess.getAbstractStringAccess().getQuotedStringParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_QuotedString_1=ruleQuotedString();

                    state._fsp--;


                    			current = this_QuotedString_1;
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
    // $ANTLR end "ruleAbstractString"


    // $ANTLR start "entryRuleGString"
    // InternalUnicodeTestLanguage.g:141:1: entryRuleGString returns [EObject current=null] : iv_ruleGString= ruleGString EOF ;
    public final EObject entryRuleGString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGString = null;


        try {
            // InternalUnicodeTestLanguage.g:141:48: (iv_ruleGString= ruleGString EOF )
            // InternalUnicodeTestLanguage.g:142:2: iv_ruleGString= ruleGString EOF
            {
             newCompositeNode(grammarAccess.getGStringRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGString=ruleGString();

            state._fsp--;

             current =iv_ruleGString; 
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
    // $ANTLR end "entryRuleGString"


    // $ANTLR start "ruleGString"
    // InternalUnicodeTestLanguage.g:148:1: ruleGString returns [EObject current=null] : ( (lv_name_0_0= RULE_GERMAN_STRING ) ) ;
    public final EObject ruleGString() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalUnicodeTestLanguage.g:154:2: ( ( (lv_name_0_0= RULE_GERMAN_STRING ) ) )
            // InternalUnicodeTestLanguage.g:155:2: ( (lv_name_0_0= RULE_GERMAN_STRING ) )
            {
            // InternalUnicodeTestLanguage.g:155:2: ( (lv_name_0_0= RULE_GERMAN_STRING ) )
            // InternalUnicodeTestLanguage.g:156:3: (lv_name_0_0= RULE_GERMAN_STRING )
            {
            // InternalUnicodeTestLanguage.g:156:3: (lv_name_0_0= RULE_GERMAN_STRING )
            // InternalUnicodeTestLanguage.g:157:4: lv_name_0_0= RULE_GERMAN_STRING
            {
            lv_name_0_0=(Token)match(input,RULE_GERMAN_STRING,FollowSets000.FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getGStringAccess().getNameGERMAN_STRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getGStringRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.parser.terminalrules.UnicodeTestLanguage.GERMAN_STRING");
            			

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
    // $ANTLR end "ruleGString"


    // $ANTLR start "entryRuleQuotedString"
    // InternalUnicodeTestLanguage.g:176:1: entryRuleQuotedString returns [EObject current=null] : iv_ruleQuotedString= ruleQuotedString EOF ;
    public final EObject entryRuleQuotedString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuotedString = null;


        try {
            // InternalUnicodeTestLanguage.g:176:53: (iv_ruleQuotedString= ruleQuotedString EOF )
            // InternalUnicodeTestLanguage.g:177:2: iv_ruleQuotedString= ruleQuotedString EOF
            {
             newCompositeNode(grammarAccess.getQuotedStringRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQuotedString=ruleQuotedString();

            state._fsp--;

             current =iv_ruleQuotedString; 
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
    // $ANTLR end "entryRuleQuotedString"


    // $ANTLR start "ruleQuotedString"
    // InternalUnicodeTestLanguage.g:183:1: ruleQuotedString returns [EObject current=null] : ( (lv_name_0_0= RULE_STRING ) ) ;
    public final EObject ruleQuotedString() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalUnicodeTestLanguage.g:189:2: ( ( (lv_name_0_0= RULE_STRING ) ) )
            // InternalUnicodeTestLanguage.g:190:2: ( (lv_name_0_0= RULE_STRING ) )
            {
            // InternalUnicodeTestLanguage.g:190:2: ( (lv_name_0_0= RULE_STRING ) )
            // InternalUnicodeTestLanguage.g:191:3: (lv_name_0_0= RULE_STRING )
            {
            // InternalUnicodeTestLanguage.g:191:3: (lv_name_0_0= RULE_STRING )
            // InternalUnicodeTestLanguage.g:192:4: lv_name_0_0= RULE_STRING
            {
            lv_name_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getQuotedStringAccess().getNameSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getQuotedStringRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.STRING");
            			

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
    // $ANTLR end "ruleQuotedString"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000032L});
    }


}