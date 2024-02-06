package org.eclipse.xtext.linking.lazy.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.linking.lazy.services.Bug311337TestLanguageGrammarAccess;



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
public class InternalBug311337TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'(def)'", "':'", "'(child)'", "'(ref)'"
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
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalBug311337TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug311337TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug311337TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug311337TestLanguage.g"; }



     	private Bug311337TestLanguageGrammarAccess grammarAccess;

        public InternalBug311337TestLanguageParser(TokenStream input, Bug311337TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected Bug311337TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalBug311337TestLanguage.g:69:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalBug311337TestLanguage.g:69:46: (iv_ruleModel= ruleModel EOF )
            // InternalBug311337TestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
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
    // InternalBug311337TestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (lv_def_0_0= ruleDefinition ) )+ ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_def_0_0 = null;



        	enterRule();

        try {
            // InternalBug311337TestLanguage.g:82:2: ( ( (lv_def_0_0= ruleDefinition ) )+ )
            // InternalBug311337TestLanguage.g:83:2: ( (lv_def_0_0= ruleDefinition ) )+
            {
            // InternalBug311337TestLanguage.g:83:2: ( (lv_def_0_0= ruleDefinition ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBug311337TestLanguage.g:84:3: (lv_def_0_0= ruleDefinition )
            	    {
            	    // InternalBug311337TestLanguage.g:84:3: (lv_def_0_0= ruleDefinition )
            	    // InternalBug311337TestLanguage.g:85:4: lv_def_0_0= ruleDefinition
            	    {

            	    				newCompositeNode(grammarAccess.getModelAccess().getDefDefinitionParserRuleCall_0());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_def_0_0=ruleDefinition();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"def",
            	    					lv_def_0_0,
            	    					"org.eclipse.xtext.linking.lazy.Bug311337TestLanguage.Definition");
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


    // $ANTLR start "entryRuleDefinition"
    // InternalBug311337TestLanguage.g:105:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // InternalBug311337TestLanguage.g:105:51: (iv_ruleDefinition= ruleDefinition EOF )
            // InternalBug311337TestLanguage.g:106:2: iv_ruleDefinition= ruleDefinition EOF
            {
             newCompositeNode(grammarAccess.getDefinitionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDefinition=ruleDefinition();

            state._fsp--;

             current =iv_ruleDefinition; 
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
    // $ANTLR end "entryRuleDefinition"


    // $ANTLR start "ruleDefinition"
    // InternalBug311337TestLanguage.g:112:1: ruleDefinition returns [EObject current=null] : (otherlv_0= '(def)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_child_3_0= ruleChild ) ) ( (lv_ref_4_0= ruleReference ) )? ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_child_3_0 = null;

        EObject lv_ref_4_0 = null;



        	enterRule();

        try {
            // InternalBug311337TestLanguage.g:118:2: ( (otherlv_0= '(def)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_child_3_0= ruleChild ) ) ( (lv_ref_4_0= ruleReference ) )? ) )
            // InternalBug311337TestLanguage.g:119:2: (otherlv_0= '(def)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_child_3_0= ruleChild ) ) ( (lv_ref_4_0= ruleReference ) )? )
            {
            // InternalBug311337TestLanguage.g:119:2: (otherlv_0= '(def)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_child_3_0= ruleChild ) ) ( (lv_ref_4_0= ruleReference ) )? )
            // InternalBug311337TestLanguage.g:120:3: otherlv_0= '(def)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_child_3_0= ruleChild ) ) ( (lv_ref_4_0= ruleReference ) )?
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getDefinitionAccess().getDefKeyword_0());
            		
            // InternalBug311337TestLanguage.g:124:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalBug311337TestLanguage.g:125:4: (lv_name_1_0= RULE_ID )
            {
            // InternalBug311337TestLanguage.g:125:4: (lv_name_1_0= RULE_ID )
            // InternalBug311337TestLanguage.g:126:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDefinitionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getDefinitionAccess().getColonKeyword_2());
            		
            // InternalBug311337TestLanguage.g:146:3: ( (lv_child_3_0= ruleChild ) )
            // InternalBug311337TestLanguage.g:147:4: (lv_child_3_0= ruleChild )
            {
            // InternalBug311337TestLanguage.g:147:4: (lv_child_3_0= ruleChild )
            // InternalBug311337TestLanguage.g:148:5: lv_child_3_0= ruleChild
            {

            					newCompositeNode(grammarAccess.getDefinitionAccess().getChildChildParserRuleCall_3_0());
            				
            pushFollow(FollowSets000.FOLLOW_7);
            lv_child_3_0=ruleChild();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDefinitionRule());
            					}
            					add(
            						current,
            						"child",
            						lv_child_3_0,
            						"org.eclipse.xtext.linking.lazy.Bug311337TestLanguage.Child");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBug311337TestLanguage.g:165:3: ( (lv_ref_4_0= ruleReference ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==14) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalBug311337TestLanguage.g:166:4: (lv_ref_4_0= ruleReference )
                    {
                    // InternalBug311337TestLanguage.g:166:4: (lv_ref_4_0= ruleReference )
                    // InternalBug311337TestLanguage.g:167:5: lv_ref_4_0= ruleReference
                    {

                    					newCompositeNode(grammarAccess.getDefinitionAccess().getRefReferenceParserRuleCall_4_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_ref_4_0=ruleReference();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getDefinitionRule());
                    					}
                    					add(
                    						current,
                    						"ref",
                    						lv_ref_4_0,
                    						"org.eclipse.xtext.linking.lazy.Bug311337TestLanguage.Reference");
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
    // $ANTLR end "ruleDefinition"


    // $ANTLR start "entryRuleChild"
    // InternalBug311337TestLanguage.g:188:1: entryRuleChild returns [EObject current=null] : iv_ruleChild= ruleChild EOF ;
    public final EObject entryRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild = null;


        try {
            // InternalBug311337TestLanguage.g:188:46: (iv_ruleChild= ruleChild EOF )
            // InternalBug311337TestLanguage.g:189:2: iv_ruleChild= ruleChild EOF
            {
             newCompositeNode(grammarAccess.getChildRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleChild=ruleChild();

            state._fsp--;

             current =iv_ruleChild; 
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
    // $ANTLR end "entryRuleChild"


    // $ANTLR start "ruleChild"
    // InternalBug311337TestLanguage.g:195:1: ruleChild returns [EObject current=null] : (otherlv_0= '(child)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) )? ) ;
    public final EObject ruleChild() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalBug311337TestLanguage.g:201:2: ( (otherlv_0= '(child)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) )? ) )
            // InternalBug311337TestLanguage.g:202:2: (otherlv_0= '(child)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) )? )
            {
            // InternalBug311337TestLanguage.g:202:2: (otherlv_0= '(child)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) )? )
            // InternalBug311337TestLanguage.g:203:3: otherlv_0= '(child)' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) )?
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getChildAccess().getChildKeyword_0());
            		
            // InternalBug311337TestLanguage.g:207:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalBug311337TestLanguage.g:208:4: (lv_name_1_0= RULE_ID )
            {
            // InternalBug311337TestLanguage.g:208:4: (lv_name_1_0= RULE_ID )
            // InternalBug311337TestLanguage.g:209:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getChildAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getChildRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getChildAccess().getColonKeyword_2());
            		
            // InternalBug311337TestLanguage.g:229:3: ( (otherlv_3= RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalBug311337TestLanguage.g:230:4: (otherlv_3= RULE_ID )
                    {
                    // InternalBug311337TestLanguage.g:230:4: (otherlv_3= RULE_ID )
                    // InternalBug311337TestLanguage.g:231:5: otherlv_3= RULE_ID
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getChildRule());
                    					}
                    				
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					newLeafNode(otherlv_3, grammarAccess.getChildAccess().getLinkDefinitionCrossReference_3_0());
                    				

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
    // $ANTLR end "ruleChild"


    // $ANTLR start "entryRuleReference"
    // InternalBug311337TestLanguage.g:246:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // InternalBug311337TestLanguage.g:246:50: (iv_ruleReference= ruleReference EOF )
            // InternalBug311337TestLanguage.g:247:2: iv_ruleReference= ruleReference EOF
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
    // InternalBug311337TestLanguage.g:253:1: ruleReference returns [EObject current=null] : (otherlv_0= '(ref)' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' () ( (otherlv_4= RULE_ID ) ) )* ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalBug311337TestLanguage.g:259:2: ( (otherlv_0= '(ref)' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' () ( (otherlv_4= RULE_ID ) ) )* ) )
            // InternalBug311337TestLanguage.g:260:2: (otherlv_0= '(ref)' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' () ( (otherlv_4= RULE_ID ) ) )* )
            {
            // InternalBug311337TestLanguage.g:260:2: (otherlv_0= '(ref)' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' () ( (otherlv_4= RULE_ID ) ) )* )
            // InternalBug311337TestLanguage.g:261:3: otherlv_0= '(ref)' ( (otherlv_1= RULE_ID ) ) (otherlv_2= ':' () ( (otherlv_4= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getReferenceAccess().getRefKeyword_0());
            		
            // InternalBug311337TestLanguage.g:265:3: ( (otherlv_1= RULE_ID ) )
            // InternalBug311337TestLanguage.g:266:4: (otherlv_1= RULE_ID )
            {
            // InternalBug311337TestLanguage.g:266:4: (otherlv_1= RULE_ID )
            // InternalBug311337TestLanguage.g:267:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReferenceRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            					newLeafNode(otherlv_1, grammarAccess.getReferenceAccess().getRefChildChildCrossReference_1_0());
            				

            }


            }

            // InternalBug311337TestLanguage.g:278:3: (otherlv_2= ':' () ( (otherlv_4= RULE_ID ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalBug311337TestLanguage.g:279:4: otherlv_2= ':' () ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            	    				newLeafNode(otherlv_2, grammarAccess.getReferenceAccess().getColonKeyword_2_0());
            	    			
            	    // InternalBug311337TestLanguage.g:283:4: ()
            	    // InternalBug311337TestLanguage.g:284:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getReferenceAccess().getNestedRefLeftAction_2_1(),
            	    						current);
            	    				

            	    }

            	    // InternalBug311337TestLanguage.g:290:4: ( (otherlv_4= RULE_ID ) )
            	    // InternalBug311337TestLanguage.g:291:5: (otherlv_4= RULE_ID )
            	    {
            	    // InternalBug311337TestLanguage.g:291:5: (otherlv_4= RULE_ID )
            	    // InternalBug311337TestLanguage.g:292:6: otherlv_4= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getReferenceRule());
            	    						}
            	    					
            	    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            	    						newLeafNode(otherlv_4, grammarAccess.getReferenceAccess().getRefChildChildCrossReference_2_2_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
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
    // $ANTLR end "ruleReference"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000001002L});
    }


}