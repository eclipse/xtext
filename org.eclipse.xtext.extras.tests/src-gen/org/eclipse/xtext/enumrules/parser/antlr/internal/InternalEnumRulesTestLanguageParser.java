package org.eclipse.xtext.enumrules.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.enumrules.services.EnumRulesTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalEnumRulesTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'existing'", "'generated'", "'SameName'", "'overridden'", "'DifferentLiteral'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalEnumRulesTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEnumRulesTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEnumRulesTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalEnumRulesTestLanguage.g"; }



     	private EnumRulesTestLanguageGrammarAccess grammarAccess;

        public InternalEnumRulesTestLanguageParser(TokenStream input, EnumRulesTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected EnumRulesTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalEnumRulesTestLanguage.g:70:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalEnumRulesTestLanguage.g:70:46: (iv_ruleModel= ruleModel EOF )
            // InternalEnumRulesTestLanguage.g:71:2: iv_ruleModel= ruleModel EOF
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
    // InternalEnumRulesTestLanguage.g:77:1: ruleModel returns [EObject current=null] : ( (otherlv_0= 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? ) | (otherlv_4= 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_existing_1_0 = null;

        Enumerator lv_generated_3_0 = null;

        Enumerator lv_generated_5_0 = null;



        	enterRule();

        try {
            // InternalEnumRulesTestLanguage.g:83:2: ( ( (otherlv_0= 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? ) | (otherlv_4= 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) ) ) )
            // InternalEnumRulesTestLanguage.g:84:2: ( (otherlv_0= 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? ) | (otherlv_4= 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) ) )
            {
            // InternalEnumRulesTestLanguage.g:84:2: ( (otherlv_0= 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? ) | (otherlv_4= 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) ) )
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
                    // InternalEnumRulesTestLanguage.g:85:3: (otherlv_0= 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? )
                    {
                    // InternalEnumRulesTestLanguage.g:85:3: (otherlv_0= 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )? )
                    // InternalEnumRulesTestLanguage.g:86:4: otherlv_0= 'existing' ( (lv_existing_1_0= ruleExistingEnum ) ) (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )?
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getModelAccess().getExistingKeyword_0_0());
                    			
                    // InternalEnumRulesTestLanguage.g:90:4: ( (lv_existing_1_0= ruleExistingEnum ) )
                    // InternalEnumRulesTestLanguage.g:91:5: (lv_existing_1_0= ruleExistingEnum )
                    {
                    // InternalEnumRulesTestLanguage.g:91:5: (lv_existing_1_0= ruleExistingEnum )
                    // InternalEnumRulesTestLanguage.g:92:6: lv_existing_1_0= ruleExistingEnum
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getExistingExistingEnumEnumRuleCall_0_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_4);
                    lv_existing_1_0=ruleExistingEnum();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"existing",
                    							lv_existing_1_0,
                    							"org.eclipse.xtext.enumrules.EnumRulesTestLanguage.ExistingEnum");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalEnumRulesTestLanguage.g:109:4: (otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==12) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // InternalEnumRulesTestLanguage.g:110:5: otherlv_2= 'generated' ( (lv_generated_3_0= ruleGeneratedEnum ) )
                            {
                            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                            					newLeafNode(otherlv_2, grammarAccess.getModelAccess().getGeneratedKeyword_0_2_0());
                            				
                            // InternalEnumRulesTestLanguage.g:114:5: ( (lv_generated_3_0= ruleGeneratedEnum ) )
                            // InternalEnumRulesTestLanguage.g:115:6: (lv_generated_3_0= ruleGeneratedEnum )
                            {
                            // InternalEnumRulesTestLanguage.g:115:6: (lv_generated_3_0= ruleGeneratedEnum )
                            // InternalEnumRulesTestLanguage.g:116:7: lv_generated_3_0= ruleGeneratedEnum
                            {

                            							newCompositeNode(grammarAccess.getModelAccess().getGeneratedGeneratedEnumEnumRuleCall_0_2_1_0());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_generated_3_0=ruleGeneratedEnum();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getModelRule());
                            							}
                            							set(
                            								current,
                            								"generated",
                            								lv_generated_3_0,
                            								"org.eclipse.xtext.enumrules.EnumRulesTestLanguage.GeneratedEnum");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalEnumRulesTestLanguage.g:136:3: (otherlv_4= 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) )
                    {
                    // InternalEnumRulesTestLanguage.g:136:3: (otherlv_4= 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) ) )
                    // InternalEnumRulesTestLanguage.g:137:4: otherlv_4= 'generated' ( (lv_generated_5_0= ruleGeneratedEnum ) )
                    {
                    otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                    				newLeafNode(otherlv_4, grammarAccess.getModelAccess().getGeneratedKeyword_1_0());
                    			
                    // InternalEnumRulesTestLanguage.g:141:4: ( (lv_generated_5_0= ruleGeneratedEnum ) )
                    // InternalEnumRulesTestLanguage.g:142:5: (lv_generated_5_0= ruleGeneratedEnum )
                    {
                    // InternalEnumRulesTestLanguage.g:142:5: (lv_generated_5_0= ruleGeneratedEnum )
                    // InternalEnumRulesTestLanguage.g:143:6: lv_generated_5_0= ruleGeneratedEnum
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getGeneratedGeneratedEnumEnumRuleCall_1_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_generated_5_0=ruleGeneratedEnum();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"generated",
                    							lv_generated_5_0,
                    							"org.eclipse.xtext.enumrules.EnumRulesTestLanguage.GeneratedEnum");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


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


    // $ANTLR start "ruleExistingEnum"
    // InternalEnumRulesTestLanguage.g:165:1: ruleExistingEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'overridden' ) | (enumLiteral_2= 'DifferentLiteral' ) ) ;
    public final Enumerator ruleExistingEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalEnumRulesTestLanguage.g:171:2: ( ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'overridden' ) | (enumLiteral_2= 'DifferentLiteral' ) ) )
            // InternalEnumRulesTestLanguage.g:172:2: ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'overridden' ) | (enumLiteral_2= 'DifferentLiteral' ) )
            {
            // InternalEnumRulesTestLanguage.g:172:2: ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'overridden' ) | (enumLiteral_2= 'DifferentLiteral' ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt3=1;
                }
                break;
            case 14:
                {
                alt3=2;
                }
                break;
            case 15:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalEnumRulesTestLanguage.g:173:3: (enumLiteral_0= 'SameName' )
                    {
                    // InternalEnumRulesTestLanguage.g:173:3: (enumLiteral_0= 'SameName' )
                    // InternalEnumRulesTestLanguage.g:174:4: enumLiteral_0= 'SameName'
                    {
                    enumLiteral_0=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getExistingEnumAccess().getSameNameEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getExistingEnumAccess().getSameNameEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalEnumRulesTestLanguage.g:181:3: (enumLiteral_1= 'overridden' )
                    {
                    // InternalEnumRulesTestLanguage.g:181:3: (enumLiteral_1= 'overridden' )
                    // InternalEnumRulesTestLanguage.g:182:4: enumLiteral_1= 'overridden'
                    {
                    enumLiteral_1=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getExistingEnumAccess().getOverriddenLiteralEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getExistingEnumAccess().getOverriddenLiteralEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalEnumRulesTestLanguage.g:189:3: (enumLiteral_2= 'DifferentLiteral' )
                    {
                    // InternalEnumRulesTestLanguage.g:189:3: (enumLiteral_2= 'DifferentLiteral' )
                    // InternalEnumRulesTestLanguage.g:190:4: enumLiteral_2= 'DifferentLiteral'
                    {
                    enumLiteral_2=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getExistingEnumAccess().getDifferentNameEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getExistingEnumAccess().getDifferentNameEnumLiteralDeclaration_2());
                    			

                    }


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
    // $ANTLR end "ruleExistingEnum"


    // $ANTLR start "ruleGeneratedEnum"
    // InternalEnumRulesTestLanguage.g:200:1: ruleGeneratedEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'DifferentLiteral' ) ) ;
    public final Enumerator ruleGeneratedEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalEnumRulesTestLanguage.g:206:2: ( ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'DifferentLiteral' ) ) )
            // InternalEnumRulesTestLanguage.g:207:2: ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'DifferentLiteral' ) )
            {
            // InternalEnumRulesTestLanguage.g:207:2: ( (enumLiteral_0= 'SameName' ) | (enumLiteral_1= 'DifferentLiteral' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            else if ( (LA4_0==15) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalEnumRulesTestLanguage.g:208:3: (enumLiteral_0= 'SameName' )
                    {
                    // InternalEnumRulesTestLanguage.g:208:3: (enumLiteral_0= 'SameName' )
                    // InternalEnumRulesTestLanguage.g:209:4: enumLiteral_0= 'SameName'
                    {
                    enumLiteral_0=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getGeneratedEnumAccess().getSameNameEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getGeneratedEnumAccess().getSameNameEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalEnumRulesTestLanguage.g:216:3: (enumLiteral_1= 'DifferentLiteral' )
                    {
                    // InternalEnumRulesTestLanguage.g:216:3: (enumLiteral_1= 'DifferentLiteral' )
                    // InternalEnumRulesTestLanguage.g:217:4: enumLiteral_1= 'DifferentLiteral'
                    {
                    enumLiteral_1=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getGeneratedEnumAccess().getDifferentNameEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getGeneratedEnumAccess().getDifferentNameEnumLiteralDeclaration_1());
                    			

                    }


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
    // $ANTLR end "ruleGeneratedEnum"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000000000E000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000000A000L});
    }


}