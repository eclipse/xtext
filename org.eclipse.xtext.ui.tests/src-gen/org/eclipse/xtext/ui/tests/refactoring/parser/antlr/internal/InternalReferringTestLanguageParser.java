package org.eclipse.xtext.ui.tests.refactoring.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.refactoring.services.ReferringTestLanguageGrammarAccess;



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
public class InternalReferringTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'ref'", "'='", "'.'"
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
    public static final int T__13=13;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalReferringTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalReferringTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalReferringTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalReferringTestLanguage.g"; }



     	private ReferringTestLanguageGrammarAccess grammarAccess;

        public InternalReferringTestLanguageParser(TokenStream input, ReferringTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Main";
       	}

       	@Override
       	protected ReferringTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleMain"
    // InternalReferringTestLanguage.g:69:1: entryRuleMain returns [EObject current=null] : iv_ruleMain= ruleMain EOF ;
    public final EObject entryRuleMain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMain = null;


        try {
            // InternalReferringTestLanguage.g:69:45: (iv_ruleMain= ruleMain EOF )
            // InternalReferringTestLanguage.g:70:2: iv_ruleMain= ruleMain EOF
            {
             newCompositeNode(grammarAccess.getMainRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMain=ruleMain();

            state._fsp--;

             current =iv_ruleMain; 
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
    // $ANTLR end "entryRuleMain"


    // $ANTLR start "ruleMain"
    // InternalReferringTestLanguage.g:76:1: ruleMain returns [EObject current=null] : ( (lv_referenced_0_0= ruleAbstractReference ) )* ;
    public final EObject ruleMain() throws RecognitionException {
        EObject current = null;

        EObject lv_referenced_0_0 = null;



        	enterRule();

        try {
            // InternalReferringTestLanguage.g:82:2: ( ( (lv_referenced_0_0= ruleAbstractReference ) )* )
            // InternalReferringTestLanguage.g:83:2: ( (lv_referenced_0_0= ruleAbstractReference ) )*
            {
            // InternalReferringTestLanguage.g:83:2: ( (lv_referenced_0_0= ruleAbstractReference ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalReferringTestLanguage.g:84:3: (lv_referenced_0_0= ruleAbstractReference )
            	    {
            	    // InternalReferringTestLanguage.g:84:3: (lv_referenced_0_0= ruleAbstractReference )
            	    // InternalReferringTestLanguage.g:85:4: lv_referenced_0_0= ruleAbstractReference
            	    {

            	    				newCompositeNode(grammarAccess.getMainAccess().getReferencedAbstractReferenceParserRuleCall_0());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_referenced_0_0=ruleAbstractReference();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getMainRule());
            	    				}
            	    				add(
            	    					current,
            	    					"referenced",
            	    					lv_referenced_0_0,
            	    					"org.eclipse.xtext.ui.tests.refactoring.ReferringTestLanguage.AbstractReference");
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
    // $ANTLR end "ruleMain"


    // $ANTLR start "entryRuleAbstractReference"
    // InternalReferringTestLanguage.g:105:1: entryRuleAbstractReference returns [EObject current=null] : iv_ruleAbstractReference= ruleAbstractReference EOF ;
    public final EObject entryRuleAbstractReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractReference = null;


        try {
            // InternalReferringTestLanguage.g:105:58: (iv_ruleAbstractReference= ruleAbstractReference EOF )
            // InternalReferringTestLanguage.g:106:2: iv_ruleAbstractReference= ruleAbstractReference EOF
            {
             newCompositeNode(grammarAccess.getAbstractReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractReference=ruleAbstractReference();

            state._fsp--;

             current =iv_ruleAbstractReference; 
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
    // $ANTLR end "entryRuleAbstractReference"


    // $ANTLR start "ruleAbstractReference"
    // InternalReferringTestLanguage.g:112:1: ruleAbstractReference returns [EObject current=null] : (this_Reference_0= ruleReference | this_Reference2_1= ruleReference2 ) ;
    public final EObject ruleAbstractReference() throws RecognitionException {
        EObject current = null;

        EObject this_Reference_0 = null;

        EObject this_Reference2_1 = null;



        	enterRule();

        try {
            // InternalReferringTestLanguage.g:118:2: ( (this_Reference_0= ruleReference | this_Reference2_1= ruleReference2 ) )
            // InternalReferringTestLanguage.g:119:2: (this_Reference_0= ruleReference | this_Reference2_1= ruleReference2 )
            {
            // InternalReferringTestLanguage.g:119:2: (this_Reference_0= ruleReference | this_Reference2_1= ruleReference2 )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalReferringTestLanguage.g:120:3: this_Reference_0= ruleReference
                    {

                    			newCompositeNode(grammarAccess.getAbstractReferenceAccess().getReferenceParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Reference_0=ruleReference();

                    state._fsp--;


                    			current = this_Reference_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalReferringTestLanguage.g:129:3: this_Reference2_1= ruleReference2
                    {

                    			newCompositeNode(grammarAccess.getAbstractReferenceAccess().getReference2ParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Reference2_1=ruleReference2();

                    state._fsp--;


                    			current = this_Reference2_1;
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
    // $ANTLR end "ruleAbstractReference"


    // $ANTLR start "entryRuleReference"
    // InternalReferringTestLanguage.g:141:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // InternalReferringTestLanguage.g:141:50: (iv_ruleReference= ruleReference EOF )
            // InternalReferringTestLanguage.g:142:2: iv_ruleReference= ruleReference EOF
            {
             newCompositeNode(grammarAccess.getReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleReference=ruleReference();

            state._fsp--;

             current =iv_ruleReference; 
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
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // InternalReferringTestLanguage.g:148:1: ruleReference returns [EObject current=null] : (otherlv_0= 'ref' ( ( ruleFQN ) ) ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalReferringTestLanguage.g:154:2: ( (otherlv_0= 'ref' ( ( ruleFQN ) ) ) )
            // InternalReferringTestLanguage.g:155:2: (otherlv_0= 'ref' ( ( ruleFQN ) ) )
            {
            // InternalReferringTestLanguage.g:155:2: (otherlv_0= 'ref' ( ( ruleFQN ) ) )
            // InternalReferringTestLanguage.g:156:3: otherlv_0= 'ref' ( ( ruleFQN ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getReferenceAccess().getRefKeyword_0());
            		
            // InternalReferringTestLanguage.g:160:3: ( ( ruleFQN ) )
            // InternalReferringTestLanguage.g:161:4: ( ruleFQN )
            {
            // InternalReferringTestLanguage.g:161:4: ( ruleFQN )
            // InternalReferringTestLanguage.g:162:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferenceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReferenceAccess().getReferencedEObjectCrossReference_1_0());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFQN();

            state._fsp--;


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
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRuleReference2"
    // InternalReferringTestLanguage.g:180:1: entryRuleReference2 returns [EObject current=null] : iv_ruleReference2= ruleReference2 EOF ;
    public final EObject entryRuleReference2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference2 = null;


        try {
            // InternalReferringTestLanguage.g:180:51: (iv_ruleReference2= ruleReference2 EOF )
            // InternalReferringTestLanguage.g:181:2: iv_ruleReference2= ruleReference2 EOF
            {
             newCompositeNode(grammarAccess.getReference2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleReference2=ruleReference2();

            state._fsp--;

             current =iv_ruleReference2; 
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
    // $ANTLR end "entryRuleReference2"


    // $ANTLR start "ruleReference2"
    // InternalReferringTestLanguage.g:187:1: ruleReference2 returns [EObject current=null] : (this_Named_0= ruleNamed otherlv_1= '=' ( ( ruleFQN ) ) ) ;
    public final EObject ruleReference2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_Named_0 = null;



        	enterRule();

        try {
            // InternalReferringTestLanguage.g:193:2: ( (this_Named_0= ruleNamed otherlv_1= '=' ( ( ruleFQN ) ) ) )
            // InternalReferringTestLanguage.g:194:2: (this_Named_0= ruleNamed otherlv_1= '=' ( ( ruleFQN ) ) )
            {
            // InternalReferringTestLanguage.g:194:2: (this_Named_0= ruleNamed otherlv_1= '=' ( ( ruleFQN ) ) )
            // InternalReferringTestLanguage.g:195:3: this_Named_0= ruleNamed otherlv_1= '=' ( ( ruleFQN ) )
            {

            			newCompositeNode(grammarAccess.getReference2Access().getNamedParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_5);
            this_Named_0=ruleNamed();

            state._fsp--;


            			current = this_Named_0;
            			afterParserOrEnumRuleCall();
            		
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getReference2Access().getEqualsSignKeyword_1());
            		
            // InternalReferringTestLanguage.g:207:3: ( ( ruleFQN ) )
            // InternalReferringTestLanguage.g:208:4: ( ruleFQN )
            {
            // InternalReferringTestLanguage.g:208:4: ( ruleFQN )
            // InternalReferringTestLanguage.g:209:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReference2Rule());
            					}
            				

            					newCompositeNode(grammarAccess.getReference2Access().getReferencedEObjectCrossReference_2_0());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFQN();

            state._fsp--;


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
    // $ANTLR end "ruleReference2"


    // $ANTLR start "entryRuleNamed"
    // InternalReferringTestLanguage.g:227:1: entryRuleNamed returns [EObject current=null] : iv_ruleNamed= ruleNamed EOF ;
    public final EObject entryRuleNamed() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamed = null;


        try {
            // InternalReferringTestLanguage.g:227:46: (iv_ruleNamed= ruleNamed EOF )
            // InternalReferringTestLanguage.g:228:2: iv_ruleNamed= ruleNamed EOF
            {
             newCompositeNode(grammarAccess.getNamedRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNamed=ruleNamed();

            state._fsp--;

             current =iv_ruleNamed; 
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
    // $ANTLR end "entryRuleNamed"


    // $ANTLR start "ruleNamed"
    // InternalReferringTestLanguage.g:234:1: ruleNamed returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleNamed() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalReferringTestLanguage.g:240:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalReferringTestLanguage.g:241:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalReferringTestLanguage.g:241:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalReferringTestLanguage.g:242:3: (lv_name_0_0= RULE_ID )
            {
            // InternalReferringTestLanguage.g:242:3: (lv_name_0_0= RULE_ID )
            // InternalReferringTestLanguage.g:243:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getNamedAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getNamedRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

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
    // $ANTLR end "ruleNamed"


    // $ANTLR start "entryRuleFQN"
    // InternalReferringTestLanguage.g:262:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalReferringTestLanguage.g:262:43: (iv_ruleFQN= ruleFQN EOF )
            // InternalReferringTestLanguage.g:263:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // InternalReferringTestLanguage.g:269:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalReferringTestLanguage.g:275:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalReferringTestLanguage.g:276:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalReferringTestLanguage.g:276:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalReferringTestLanguage.g:277:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0());
            		
            // InternalReferringTestLanguage.g:284:3: (kw= '.' this_ID_2= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalReferringTestLanguage.g:285:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,13,FollowSets000.FOLLOW_4); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1());
            	    			

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
    // $ANTLR end "ruleFQN"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000812L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002002L});
    }


}