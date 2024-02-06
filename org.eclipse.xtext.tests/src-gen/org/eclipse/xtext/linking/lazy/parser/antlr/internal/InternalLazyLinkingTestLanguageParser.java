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
import org.eclipse.xtext.linking.lazy.services.LazyLinkingTestLanguageGrammarAccess;



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
public class InternalLazyLinkingTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'type'", "'extends'", "'.'", "'for'", "'in'", "'{'", "'}'", "';'", "'unresolved'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
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
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalLazyLinkingTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalLazyLinkingTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalLazyLinkingTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalLazyLinkingTestLanguage.g"; }



     	private LazyLinkingTestLanguageGrammarAccess grammarAccess;

        public InternalLazyLinkingTestLanguageParser(TokenStream input, LazyLinkingTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected LazyLinkingTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalLazyLinkingTestLanguage.g:69:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalLazyLinkingTestLanguage.g:69:46: (iv_ruleModel= ruleModel EOF )
            // InternalLazyLinkingTestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
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
    // InternalLazyLinkingTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (lv_types_0_0= ruleType ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_types_0_0 = null;



        	enterRule();

        try {
            // InternalLazyLinkingTestLanguage.g:82:2: ( ( (lv_types_0_0= ruleType ) )* )
            // InternalLazyLinkingTestLanguage.g:83:2: ( (lv_types_0_0= ruleType ) )*
            {
            // InternalLazyLinkingTestLanguage.g:83:2: ( (lv_types_0_0= ruleType ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalLazyLinkingTestLanguage.g:84:3: (lv_types_0_0= ruleType )
            	    {
            	    // InternalLazyLinkingTestLanguage.g:84:3: (lv_types_0_0= ruleType )
            	    // InternalLazyLinkingTestLanguage.g:85:4: lv_types_0_0= ruleType
            	    {

            	    				newCompositeNode(grammarAccess.getModelAccess().getTypesTypeParserRuleCall_0());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_types_0_0=ruleType();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"types",
            	    					lv_types_0_0,
            	    					"org.eclipse.xtext.linking.lazy.LazyLinkingTestLanguage.Type");
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


    // $ANTLR start "entryRuleType"
    // InternalLazyLinkingTestLanguage.g:105:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalLazyLinkingTestLanguage.g:105:45: (iv_ruleType= ruleType EOF )
            // InternalLazyLinkingTestLanguage.g:106:2: iv_ruleType= ruleType EOF
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
    // InternalLazyLinkingTestLanguage.g:112:1: ruleType returns [EObject current=null] : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_13=null;
        EObject lv_properties_11_0 = null;

        EObject lv_unresolvedProxyProperty_12_0 = null;



        	enterRule();

        try {
            // InternalLazyLinkingTestLanguage.g:118:2: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' ) )
            // InternalLazyLinkingTestLanguage.g:119:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' )
            {
            // InternalLazyLinkingTestLanguage.g:119:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' )
            // InternalLazyLinkingTestLanguage.g:120:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getTypeAccess().getTypeKeyword_0());
            		
            // InternalLazyLinkingTestLanguage.g:124:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalLazyLinkingTestLanguage.g:125:4: (lv_name_1_0= RULE_ID )
            {
            // InternalLazyLinkingTestLanguage.g:125:4: (lv_name_1_0= RULE_ID )
            // InternalLazyLinkingTestLanguage.g:126:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTypeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalLazyLinkingTestLanguage.g:142:3: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalLazyLinkingTestLanguage.g:143:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getTypeAccess().getExtendsKeyword_2_0());
                    			
                    // InternalLazyLinkingTestLanguage.g:147:4: ( (otherlv_3= RULE_ID ) )
                    // InternalLazyLinkingTestLanguage.g:148:5: (otherlv_3= RULE_ID )
                    {
                    // InternalLazyLinkingTestLanguage.g:148:5: (otherlv_3= RULE_ID )
                    // InternalLazyLinkingTestLanguage.g:149:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTypeRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    						newLeafNode(otherlv_3, grammarAccess.getTypeAccess().getExtendsTypeCrossReference_2_1_0());
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_4); 

                    				newLeafNode(otherlv_4, grammarAccess.getTypeAccess().getFullStopKeyword_2_2());
                    			
                    // InternalLazyLinkingTestLanguage.g:164:4: ( (otherlv_5= RULE_ID ) )
                    // InternalLazyLinkingTestLanguage.g:165:5: (otherlv_5= RULE_ID )
                    {
                    // InternalLazyLinkingTestLanguage.g:165:5: (otherlv_5= RULE_ID )
                    // InternalLazyLinkingTestLanguage.g:166:6: otherlv_5= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTypeRule());
                    						}
                    					
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    						newLeafNode(otherlv_5, grammarAccess.getTypeAccess().getParentIdPropertyCrossReference_2_3_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalLazyLinkingTestLanguage.g:178:3: (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalLazyLinkingTestLanguage.g:179:4: otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_4); 

                    				newLeafNode(otherlv_6, grammarAccess.getTypeAccess().getForKeyword_3_0());
                    			
                    // InternalLazyLinkingTestLanguage.g:183:4: ( (otherlv_7= RULE_ID ) )
                    // InternalLazyLinkingTestLanguage.g:184:5: (otherlv_7= RULE_ID )
                    {
                    // InternalLazyLinkingTestLanguage.g:184:5: (otherlv_7= RULE_ID )
                    // InternalLazyLinkingTestLanguage.g:185:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTypeRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    						newLeafNode(otherlv_7, grammarAccess.getTypeAccess().getParentIdPropertyCrossReference_3_1_0());
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_4); 

                    				newLeafNode(otherlv_8, grammarAccess.getTypeAccess().getInKeyword_3_2());
                    			
                    // InternalLazyLinkingTestLanguage.g:200:4: ( (otherlv_9= RULE_ID ) )
                    // InternalLazyLinkingTestLanguage.g:201:5: (otherlv_9= RULE_ID )
                    {
                    // InternalLazyLinkingTestLanguage.g:201:5: (otherlv_9= RULE_ID )
                    // InternalLazyLinkingTestLanguage.g:202:6: otherlv_9= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTypeRule());
                    						}
                    					
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    						newLeafNode(otherlv_9, grammarAccess.getTypeAccess().getExtendsTypeCrossReference_3_3_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_10); 

            			newLeafNode(otherlv_10, grammarAccess.getTypeAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalLazyLinkingTestLanguage.g:218:3: ( (lv_properties_11_0= ruleProperty ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalLazyLinkingTestLanguage.g:219:4: (lv_properties_11_0= ruleProperty )
            	    {
            	    // InternalLazyLinkingTestLanguage.g:219:4: (lv_properties_11_0= ruleProperty )
            	    // InternalLazyLinkingTestLanguage.g:220:5: lv_properties_11_0= ruleProperty
            	    {

            	    					newCompositeNode(grammarAccess.getTypeAccess().getPropertiesPropertyParserRuleCall_5_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_10);
            	    lv_properties_11_0=ruleProperty();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTypeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"properties",
            	    						lv_properties_11_0,
            	    						"org.eclipse.xtext.linking.lazy.LazyLinkingTestLanguage.Property");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalLazyLinkingTestLanguage.g:237:3: ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalLazyLinkingTestLanguage.g:238:4: (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty )
            	    {
            	    // InternalLazyLinkingTestLanguage.g:238:4: (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty )
            	    // InternalLazyLinkingTestLanguage.g:239:5: lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty
            	    {

            	    					newCompositeNode(grammarAccess.getTypeAccess().getUnresolvedProxyPropertyUnresolvedProxyPropertyParserRuleCall_6_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_11);
            	    lv_unresolvedProxyProperty_12_0=ruleUnresolvedProxyProperty();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTypeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"unresolvedProxyProperty",
            	    						lv_unresolvedProxyProperty_12_0,
            	    						"org.eclipse.xtext.linking.lazy.LazyLinkingTestLanguage.UnresolvedProxyProperty");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getTypeAccess().getRightCurlyBracketKeyword_7());
            		

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


    // $ANTLR start "entryRuleProperty"
    // InternalLazyLinkingTestLanguage.g:264:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // InternalLazyLinkingTestLanguage.g:264:49: (iv_ruleProperty= ruleProperty EOF )
            // InternalLazyLinkingTestLanguage.g:265:2: iv_ruleProperty= ruleProperty EOF
            {
             newCompositeNode(grammarAccess.getPropertyRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleProperty=ruleProperty();

            state._fsp--;

             current =iv_ruleProperty; 
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
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // InternalLazyLinkingTestLanguage.g:271:1: ruleProperty returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalLazyLinkingTestLanguage.g:277:2: ( ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalLazyLinkingTestLanguage.g:278:2: ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalLazyLinkingTestLanguage.g:278:2: ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalLazyLinkingTestLanguage.g:279:3: ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            // InternalLazyLinkingTestLanguage.g:279:3: ( (otherlv_0= RULE_ID ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1==RULE_ID) ) {
                        alt6=1;
                    }


                }


                switch (alt6) {
            	case 1 :
            	    // InternalLazyLinkingTestLanguage.g:280:4: (otherlv_0= RULE_ID )
            	    {
            	    // InternalLazyLinkingTestLanguage.g:280:4: (otherlv_0= RULE_ID )
            	    // InternalLazyLinkingTestLanguage.g:281:5: otherlv_0= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getPropertyRule());
            	    					}
            	    				
            	    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

            	    					newLeafNode(otherlv_0, grammarAccess.getPropertyAccess().getTypeTypeCrossReference_0_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            // InternalLazyLinkingTestLanguage.g:292:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalLazyLinkingTestLanguage.g:293:4: (lv_name_1_0= RULE_ID )
            {
            // InternalLazyLinkingTestLanguage.g:293:4: (lv_name_1_0= RULE_ID )
            // InternalLazyLinkingTestLanguage.g:294:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getPropertyAccess().getSemicolonKeyword_2());
            		

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
    // $ANTLR end "ruleProperty"


    // $ANTLR start "entryRuleUnresolvedProxyProperty"
    // InternalLazyLinkingTestLanguage.g:318:1: entryRuleUnresolvedProxyProperty returns [EObject current=null] : iv_ruleUnresolvedProxyProperty= ruleUnresolvedProxyProperty EOF ;
    public final EObject entryRuleUnresolvedProxyProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnresolvedProxyProperty = null;


        try {
            // InternalLazyLinkingTestLanguage.g:318:64: (iv_ruleUnresolvedProxyProperty= ruleUnresolvedProxyProperty EOF )
            // InternalLazyLinkingTestLanguage.g:319:2: iv_ruleUnresolvedProxyProperty= ruleUnresolvedProxyProperty EOF
            {
             newCompositeNode(grammarAccess.getUnresolvedProxyPropertyRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnresolvedProxyProperty=ruleUnresolvedProxyProperty();

            state._fsp--;

             current =iv_ruleUnresolvedProxyProperty; 
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
    // $ANTLR end "entryRuleUnresolvedProxyProperty"


    // $ANTLR start "ruleUnresolvedProxyProperty"
    // InternalLazyLinkingTestLanguage.g:325:1: ruleUnresolvedProxyProperty returns [EObject current=null] : (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleUnresolvedProxyProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalLazyLinkingTestLanguage.g:331:2: ( (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalLazyLinkingTestLanguage.g:332:2: (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalLazyLinkingTestLanguage.g:332:2: (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // InternalLazyLinkingTestLanguage.g:333:3: otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getUnresolvedProxyPropertyAccess().getUnresolvedKeyword_0());
            		
            // InternalLazyLinkingTestLanguage.g:337:3: ( (otherlv_1= RULE_ID ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1==RULE_ID) ) {
                        alt7=1;
                    }


                }


                switch (alt7) {
            	case 1 :
            	    // InternalLazyLinkingTestLanguage.g:338:4: (otherlv_1= RULE_ID )
            	    {
            	    // InternalLazyLinkingTestLanguage.g:338:4: (otherlv_1= RULE_ID )
            	    // InternalLazyLinkingTestLanguage.g:339:5: otherlv_1= RULE_ID
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getUnresolvedProxyPropertyRule());
            	    					}
            	    				
            	    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

            	    					newLeafNode(otherlv_1, grammarAccess.getUnresolvedProxyPropertyAccess().getTypeTypeCrossReference_1_0());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            // InternalLazyLinkingTestLanguage.g:350:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalLazyLinkingTestLanguage.g:351:4: (lv_name_2_0= RULE_ID )
            {
            // InternalLazyLinkingTestLanguage.g:351:4: (lv_name_2_0= RULE_ID )
            // InternalLazyLinkingTestLanguage.g:352:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            					newLeafNode(lv_name_2_0, grammarAccess.getUnresolvedProxyPropertyAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnresolvedProxyPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getUnresolvedProxyPropertyAccess().getSemicolonKeyword_3());
            		

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
    // $ANTLR end "ruleUnresolvedProxyProperty"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000015000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000014000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000000A0010L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000000A0000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040000L});
    }


}