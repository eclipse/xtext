package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.CrossReferenceProposalTestLanguageGrammarAccess;



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
public class InternalCrossReferenceProposalTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Object'", "'<-'", "'{'", "'}'", "'::'"
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


        public InternalCrossReferenceProposalTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCrossReferenceProposalTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCrossReferenceProposalTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalCrossReferenceProposalTestLanguage.g"; }



     	private CrossReferenceProposalTestLanguageGrammarAccess grammarAccess;

        public InternalCrossReferenceProposalTestLanguageParser(TokenStream input, CrossReferenceProposalTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected CrossReferenceProposalTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalCrossReferenceProposalTestLanguage.g:69:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalCrossReferenceProposalTestLanguage.g:69:46: (iv_ruleModel= ruleModel EOF )
            // InternalCrossReferenceProposalTestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
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
    // InternalCrossReferenceProposalTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (lv_elements_0_0= ruleClass ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;



        	enterRule();

        try {
            // InternalCrossReferenceProposalTestLanguage.g:82:2: ( ( (lv_elements_0_0= ruleClass ) )* )
            // InternalCrossReferenceProposalTestLanguage.g:83:2: ( (lv_elements_0_0= ruleClass ) )*
            {
            // InternalCrossReferenceProposalTestLanguage.g:83:2: ( (lv_elements_0_0= ruleClass ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==11||LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalCrossReferenceProposalTestLanguage.g:84:3: (lv_elements_0_0= ruleClass )
            	    {
            	    // InternalCrossReferenceProposalTestLanguage.g:84:3: (lv_elements_0_0= ruleClass )
            	    // InternalCrossReferenceProposalTestLanguage.g:85:4: lv_elements_0_0= ruleClass
            	    {

            	    				newCompositeNode(grammarAccess.getModelAccess().getElementsClassParserRuleCall_0());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_elements_0_0=ruleClass();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"elements",
            	    					lv_elements_0_0,
            	    					"org.eclipse.xtext.ui.tests.editor.contentassist.CrossReferenceProposalTestLanguage.Class");
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


    // $ANTLR start "entryRuleClass"
    // InternalCrossReferenceProposalTestLanguage.g:105:1: entryRuleClass returns [EObject current=null] : iv_ruleClass= ruleClass EOF ;
    public final EObject entryRuleClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClass = null;


        try {
            // InternalCrossReferenceProposalTestLanguage.g:105:46: (iv_ruleClass= ruleClass EOF )
            // InternalCrossReferenceProposalTestLanguage.g:106:2: iv_ruleClass= ruleClass EOF
            {
             newCompositeNode(grammarAccess.getClassRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleClass=ruleClass();

            state._fsp--;

             current =iv_ruleClass; 
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
    // $ANTLR end "entryRuleClass"


    // $ANTLR start "ruleClass"
    // InternalCrossReferenceProposalTestLanguage.g:112:1: ruleClass returns [EObject current=null] : ( ( ( ( (otherlv_0= 'Object' ) ) | ( (otherlv_1= RULE_ID ) ) | ( ( ruleComplexName ) ) ) otherlv_3= '<-' )? ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= ruleComplexName ) ) ) otherlv_5= '{' otherlv_6= '}' ) ;
    public final EObject ruleClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_name_4_1=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_4_2 = null;



        	enterRule();

        try {
            // InternalCrossReferenceProposalTestLanguage.g:118:2: ( ( ( ( ( (otherlv_0= 'Object' ) ) | ( (otherlv_1= RULE_ID ) ) | ( ( ruleComplexName ) ) ) otherlv_3= '<-' )? ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= ruleComplexName ) ) ) otherlv_5= '{' otherlv_6= '}' ) )
            // InternalCrossReferenceProposalTestLanguage.g:119:2: ( ( ( ( (otherlv_0= 'Object' ) ) | ( (otherlv_1= RULE_ID ) ) | ( ( ruleComplexName ) ) ) otherlv_3= '<-' )? ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= ruleComplexName ) ) ) otherlv_5= '{' otherlv_6= '}' )
            {
            // InternalCrossReferenceProposalTestLanguage.g:119:2: ( ( ( ( (otherlv_0= 'Object' ) ) | ( (otherlv_1= RULE_ID ) ) | ( ( ruleComplexName ) ) ) otherlv_3= '<-' )? ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= ruleComplexName ) ) ) otherlv_5= '{' otherlv_6= '}' )
            // InternalCrossReferenceProposalTestLanguage.g:120:3: ( ( ( (otherlv_0= 'Object' ) ) | ( (otherlv_1= RULE_ID ) ) | ( ( ruleComplexName ) ) ) otherlv_3= '<-' )? ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= ruleComplexName ) ) ) otherlv_5= '{' otherlv_6= '}'
            {
            // InternalCrossReferenceProposalTestLanguage.g:120:3: ( ( ( (otherlv_0= 'Object' ) ) | ( (otherlv_1= RULE_ID ) ) | ( ( ruleComplexName ) ) ) otherlv_3= '<-' )?
            int alt3=2;
            switch ( input.LA(1) ) {
                case 11:
                    {
                    alt3=1;
                    }
                    break;
                case RULE_ID:
                    {
                    int LA3_2 = input.LA(2);

                    if ( (LA3_2==12) ) {
                        alt3=1;
                    }
                    }
                    break;
                case 15:
                    {
                    int LA3_3 = input.LA(2);

                    if ( (LA3_3==RULE_ID) ) {
                        int LA3_5 = input.LA(3);

                        if ( (LA3_5==12) ) {
                            alt3=1;
                        }
                    }
                    }
                    break;
            }

            switch (alt3) {
                case 1 :
                    // InternalCrossReferenceProposalTestLanguage.g:121:4: ( ( (otherlv_0= 'Object' ) ) | ( (otherlv_1= RULE_ID ) ) | ( ( ruleComplexName ) ) ) otherlv_3= '<-'
                    {
                    // InternalCrossReferenceProposalTestLanguage.g:121:4: ( ( (otherlv_0= 'Object' ) ) | ( (otherlv_1= RULE_ID ) ) | ( ( ruleComplexName ) ) )
                    int alt2=3;
                    switch ( input.LA(1) ) {
                    case 11:
                        {
                        alt2=1;
                        }
                        break;
                    case RULE_ID:
                        {
                        alt2=2;
                        }
                        break;
                    case 15:
                        {
                        alt2=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 0, input);

                        throw nvae;
                    }

                    switch (alt2) {
                        case 1 :
                            // InternalCrossReferenceProposalTestLanguage.g:122:5: ( (otherlv_0= 'Object' ) )
                            {
                            // InternalCrossReferenceProposalTestLanguage.g:122:5: ( (otherlv_0= 'Object' ) )
                            // InternalCrossReferenceProposalTestLanguage.g:123:6: (otherlv_0= 'Object' )
                            {
                            // InternalCrossReferenceProposalTestLanguage.g:123:6: (otherlv_0= 'Object' )
                            // InternalCrossReferenceProposalTestLanguage.g:124:7: otherlv_0= 'Object'
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getClassRule());
                            							}
                            						
                            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

                            							newLeafNode(otherlv_0, grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_0_0());
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalCrossReferenceProposalTestLanguage.g:136:5: ( (otherlv_1= RULE_ID ) )
                            {
                            // InternalCrossReferenceProposalTestLanguage.g:136:5: ( (otherlv_1= RULE_ID ) )
                            // InternalCrossReferenceProposalTestLanguage.g:137:6: (otherlv_1= RULE_ID )
                            {
                            // InternalCrossReferenceProposalTestLanguage.g:137:6: (otherlv_1= RULE_ID )
                            // InternalCrossReferenceProposalTestLanguage.g:138:7: otherlv_1= RULE_ID
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getClassRule());
                            							}
                            						
                            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

                            							newLeafNode(otherlv_1, grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_1_0());
                            						

                            }


                            }


                            }
                            break;
                        case 3 :
                            // InternalCrossReferenceProposalTestLanguage.g:150:5: ( ( ruleComplexName ) )
                            {
                            // InternalCrossReferenceProposalTestLanguage.g:150:5: ( ( ruleComplexName ) )
                            // InternalCrossReferenceProposalTestLanguage.g:151:6: ( ruleComplexName )
                            {
                            // InternalCrossReferenceProposalTestLanguage.g:151:6: ( ruleComplexName )
                            // InternalCrossReferenceProposalTestLanguage.g:152:7: ruleComplexName
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getClassRule());
                            							}
                            						

                            							newCompositeNode(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_2_0());
                            						
                            pushFollow(FollowSets000.FOLLOW_4);
                            ruleComplexName();

                            state._fsp--;


                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }

                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                    				newLeafNode(otherlv_3, grammarAccess.getClassAccess().getLessThanSignHyphenMinusKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalCrossReferenceProposalTestLanguage.g:172:3: ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= ruleComplexName ) ) )
            // InternalCrossReferenceProposalTestLanguage.g:173:4: ( (lv_name_4_1= RULE_ID | lv_name_4_2= ruleComplexName ) )
            {
            // InternalCrossReferenceProposalTestLanguage.g:173:4: ( (lv_name_4_1= RULE_ID | lv_name_4_2= ruleComplexName ) )
            // InternalCrossReferenceProposalTestLanguage.g:174:5: (lv_name_4_1= RULE_ID | lv_name_4_2= ruleComplexName )
            {
            // InternalCrossReferenceProposalTestLanguage.g:174:5: (lv_name_4_1= RULE_ID | lv_name_4_2= ruleComplexName )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
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
                    // InternalCrossReferenceProposalTestLanguage.g:175:6: lv_name_4_1= RULE_ID
                    {
                    lv_name_4_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    						newLeafNode(lv_name_4_1, grammarAccess.getClassAccess().getNameIDTerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getClassRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_4_1,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }
                    break;
                case 2 :
                    // InternalCrossReferenceProposalTestLanguage.g:190:6: lv_name_4_2= ruleComplexName
                    {

                    						newCompositeNode(grammarAccess.getClassAccess().getNameComplexNameParserRuleCall_1_0_1());
                    					
                    pushFollow(FollowSets000.FOLLOW_6);
                    lv_name_4_2=ruleComplexName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getClassRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_4_2,
                    							"org.eclipse.xtext.ui.tests.editor.contentassist.CrossReferenceProposalTestLanguage.ComplexName");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;

            }


            }


            }

            otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getClassAccess().getRightCurlyBracketKeyword_3());
            		

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
    // $ANTLR end "ruleClass"


    // $ANTLR start "entryRuleComplexName"
    // InternalCrossReferenceProposalTestLanguage.g:220:1: entryRuleComplexName returns [String current=null] : iv_ruleComplexName= ruleComplexName EOF ;
    public final String entryRuleComplexName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComplexName = null;


        try {
            // InternalCrossReferenceProposalTestLanguage.g:220:51: (iv_ruleComplexName= ruleComplexName EOF )
            // InternalCrossReferenceProposalTestLanguage.g:221:2: iv_ruleComplexName= ruleComplexName EOF
            {
             newCompositeNode(grammarAccess.getComplexNameRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleComplexName=ruleComplexName();

            state._fsp--;

             current =iv_ruleComplexName.getText(); 
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
    // $ANTLR end "entryRuleComplexName"


    // $ANTLR start "ruleComplexName"
    // InternalCrossReferenceProposalTestLanguage.g:227:1: ruleComplexName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '::' this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleComplexName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalCrossReferenceProposalTestLanguage.g:233:2: ( (kw= '::' this_ID_1= RULE_ID ) )
            // InternalCrossReferenceProposalTestLanguage.g:234:2: (kw= '::' this_ID_1= RULE_ID )
            {
            // InternalCrossReferenceProposalTestLanguage.g:234:2: (kw= '::' this_ID_1= RULE_ID )
            // InternalCrossReferenceProposalTestLanguage.g:235:3: kw= '::' this_ID_1= RULE_ID
            {
            kw=(Token)match(input,15,FollowSets000.FOLLOW_8); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getComplexNameAccess().getColonColonKeyword_0());
            		
            this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			current.merge(this_ID_1);
            		

            			newLeafNode(this_ID_1, grammarAccess.getComplexNameAccess().getIDTerminalRuleCall_1());
            		

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
    // $ANTLR end "ruleComplexName"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000008812L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000008810L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
    }


}