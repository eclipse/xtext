package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug286935TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug286935TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'init'", "'final'", "'state'", "'NORMAL'", "'cond'", "'reference'", "'textual'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalBug286935TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug286935TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug286935TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug286935TestLanguage.g"; }



     	private Bug286935TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug286935TestLanguageParser(TokenStream input, Bug286935TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "State";	
       	}
       	
       	@Override
       	protected Bug286935TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleState"
    // InternalBug286935TestLanguage.g:68:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalBug286935TestLanguage.g:69:2: (iv_ruleState= ruleState EOF )
            // InternalBug286935TestLanguage.g:70:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
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
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalBug286935TestLanguage.g:77:1: ruleState returns [EObject current=null] : ( () ( ( (lv_isInitial_1_0= 'init' ) ) | ( (lv_isFinal_2_0= 'final' ) ) | ( (lv_stateKind_3_0= ruleStateType ) ) | ( ( (lv_isInitial_4_0= 'init' ) ) ( (lv_stateKind_5_0= ruleStateType ) ) ) | ( ( (lv_isInitial_6_0= 'init' ) ) ( (lv_stateKind_7_0= ruleStateType ) ) ( (lv_isFinal_8_0= 'final' ) ) ) )? (otherlv_9= 'state' )? ( (lv_stateName_10_0= RULE_ID ) )? ( (lv_label_11_0= RULE_STRING ) )? ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token lv_isInitial_1_0=null;
        Token lv_isFinal_2_0=null;
        Token lv_isInitial_4_0=null;
        Token lv_isInitial_6_0=null;
        Token lv_isFinal_8_0=null;
        Token otherlv_9=null;
        Token lv_stateName_10_0=null;
        Token lv_label_11_0=null;
        Enumerator lv_stateKind_3_0 = null;

        Enumerator lv_stateKind_5_0 = null;

        Enumerator lv_stateKind_7_0 = null;


         enterRule(); 
            
        try {
            // InternalBug286935TestLanguage.g:80:28: ( ( () ( ( (lv_isInitial_1_0= 'init' ) ) | ( (lv_isFinal_2_0= 'final' ) ) | ( (lv_stateKind_3_0= ruleStateType ) ) | ( ( (lv_isInitial_4_0= 'init' ) ) ( (lv_stateKind_5_0= ruleStateType ) ) ) | ( ( (lv_isInitial_6_0= 'init' ) ) ( (lv_stateKind_7_0= ruleStateType ) ) ( (lv_isFinal_8_0= 'final' ) ) ) )? (otherlv_9= 'state' )? ( (lv_stateName_10_0= RULE_ID ) )? ( (lv_label_11_0= RULE_STRING ) )? ) )
            // InternalBug286935TestLanguage.g:81:1: ( () ( ( (lv_isInitial_1_0= 'init' ) ) | ( (lv_isFinal_2_0= 'final' ) ) | ( (lv_stateKind_3_0= ruleStateType ) ) | ( ( (lv_isInitial_4_0= 'init' ) ) ( (lv_stateKind_5_0= ruleStateType ) ) ) | ( ( (lv_isInitial_6_0= 'init' ) ) ( (lv_stateKind_7_0= ruleStateType ) ) ( (lv_isFinal_8_0= 'final' ) ) ) )? (otherlv_9= 'state' )? ( (lv_stateName_10_0= RULE_ID ) )? ( (lv_label_11_0= RULE_STRING ) )? )
            {
            // InternalBug286935TestLanguage.g:81:1: ( () ( ( (lv_isInitial_1_0= 'init' ) ) | ( (lv_isFinal_2_0= 'final' ) ) | ( (lv_stateKind_3_0= ruleStateType ) ) | ( ( (lv_isInitial_4_0= 'init' ) ) ( (lv_stateKind_5_0= ruleStateType ) ) ) | ( ( (lv_isInitial_6_0= 'init' ) ) ( (lv_stateKind_7_0= ruleStateType ) ) ( (lv_isFinal_8_0= 'final' ) ) ) )? (otherlv_9= 'state' )? ( (lv_stateName_10_0= RULE_ID ) )? ( (lv_label_11_0= RULE_STRING ) )? )
            // InternalBug286935TestLanguage.g:81:2: () ( ( (lv_isInitial_1_0= 'init' ) ) | ( (lv_isFinal_2_0= 'final' ) ) | ( (lv_stateKind_3_0= ruleStateType ) ) | ( ( (lv_isInitial_4_0= 'init' ) ) ( (lv_stateKind_5_0= ruleStateType ) ) ) | ( ( (lv_isInitial_6_0= 'init' ) ) ( (lv_stateKind_7_0= ruleStateType ) ) ( (lv_isFinal_8_0= 'final' ) ) ) )? (otherlv_9= 'state' )? ( (lv_stateName_10_0= RULE_ID ) )? ( (lv_label_11_0= RULE_STRING ) )?
            {
            // InternalBug286935TestLanguage.g:81:2: ()
            // InternalBug286935TestLanguage.g:82:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStateAccess().getStateAction_0(),
                        current);
                

            }

            // InternalBug286935TestLanguage.g:87:2: ( ( (lv_isInitial_1_0= 'init' ) ) | ( (lv_isFinal_2_0= 'final' ) ) | ( (lv_stateKind_3_0= ruleStateType ) ) | ( ( (lv_isInitial_4_0= 'init' ) ) ( (lv_stateKind_5_0= ruleStateType ) ) ) | ( ( (lv_isInitial_6_0= 'init' ) ) ( (lv_stateKind_7_0= ruleStateType ) ) ( (lv_isFinal_8_0= 'final' ) ) ) )?
            int alt1=6;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalBug286935TestLanguage.g:87:3: ( (lv_isInitial_1_0= 'init' ) )
                    {
                    // InternalBug286935TestLanguage.g:87:3: ( (lv_isInitial_1_0= 'init' ) )
                    // InternalBug286935TestLanguage.g:88:1: (lv_isInitial_1_0= 'init' )
                    {
                    // InternalBug286935TestLanguage.g:88:1: (lv_isInitial_1_0= 'init' )
                    // InternalBug286935TestLanguage.g:89:3: lv_isInitial_1_0= 'init'
                    {
                    lv_isInitial_1_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                            newLeafNode(lv_isInitial_1_0, grammarAccess.getStateAccess().getIsInitialInitKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getStateRule());
                    	        }
                           		setWithLastConsumed(current, "isInitial", true, "init");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug286935TestLanguage.g:103:6: ( (lv_isFinal_2_0= 'final' ) )
                    {
                    // InternalBug286935TestLanguage.g:103:6: ( (lv_isFinal_2_0= 'final' ) )
                    // InternalBug286935TestLanguage.g:104:1: (lv_isFinal_2_0= 'final' )
                    {
                    // InternalBug286935TestLanguage.g:104:1: (lv_isFinal_2_0= 'final' )
                    // InternalBug286935TestLanguage.g:105:3: lv_isFinal_2_0= 'final'
                    {
                    lv_isFinal_2_0=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                            newLeafNode(lv_isFinal_2_0, grammarAccess.getStateAccess().getIsFinalFinalKeyword_1_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getStateRule());
                    	        }
                           		setWithLastConsumed(current, "isFinal", true, "final");
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalBug286935TestLanguage.g:119:6: ( (lv_stateKind_3_0= ruleStateType ) )
                    {
                    // InternalBug286935TestLanguage.g:119:6: ( (lv_stateKind_3_0= ruleStateType ) )
                    // InternalBug286935TestLanguage.g:120:1: (lv_stateKind_3_0= ruleStateType )
                    {
                    // InternalBug286935TestLanguage.g:120:1: (lv_stateKind_3_0= ruleStateType )
                    // InternalBug286935TestLanguage.g:121:3: lv_stateKind_3_0= ruleStateType
                    {
                     
                    	        newCompositeNode(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_1_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_3);
                    lv_stateKind_3_0=ruleStateType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStateRule());
                    	        }
                           		set(
                           			current, 
                           			"stateKind",
                            		lv_stateKind_3_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug286935TestLanguage.StateType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalBug286935TestLanguage.g:138:6: ( ( (lv_isInitial_4_0= 'init' ) ) ( (lv_stateKind_5_0= ruleStateType ) ) )
                    {
                    // InternalBug286935TestLanguage.g:138:6: ( ( (lv_isInitial_4_0= 'init' ) ) ( (lv_stateKind_5_0= ruleStateType ) ) )
                    // InternalBug286935TestLanguage.g:138:7: ( (lv_isInitial_4_0= 'init' ) ) ( (lv_stateKind_5_0= ruleStateType ) )
                    {
                    // InternalBug286935TestLanguage.g:138:7: ( (lv_isInitial_4_0= 'init' ) )
                    // InternalBug286935TestLanguage.g:139:1: (lv_isInitial_4_0= 'init' )
                    {
                    // InternalBug286935TestLanguage.g:139:1: (lv_isInitial_4_0= 'init' )
                    // InternalBug286935TestLanguage.g:140:3: lv_isInitial_4_0= 'init'
                    {
                    lv_isInitial_4_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

                            newLeafNode(lv_isInitial_4_0, grammarAccess.getStateAccess().getIsInitialInitKeyword_1_3_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getStateRule());
                    	        }
                           		setWithLastConsumed(current, "isInitial", true, "init");
                    	    

                    }


                    }

                    // InternalBug286935TestLanguage.g:153:2: ( (lv_stateKind_5_0= ruleStateType ) )
                    // InternalBug286935TestLanguage.g:154:1: (lv_stateKind_5_0= ruleStateType )
                    {
                    // InternalBug286935TestLanguage.g:154:1: (lv_stateKind_5_0= ruleStateType )
                    // InternalBug286935TestLanguage.g:155:3: lv_stateKind_5_0= ruleStateType
                    {
                     
                    	        newCompositeNode(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_1_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_3);
                    lv_stateKind_5_0=ruleStateType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStateRule());
                    	        }
                           		set(
                           			current, 
                           			"stateKind",
                            		lv_stateKind_5_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug286935TestLanguage.StateType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalBug286935TestLanguage.g:172:6: ( ( (lv_isInitial_6_0= 'init' ) ) ( (lv_stateKind_7_0= ruleStateType ) ) ( (lv_isFinal_8_0= 'final' ) ) )
                    {
                    // InternalBug286935TestLanguage.g:172:6: ( ( (lv_isInitial_6_0= 'init' ) ) ( (lv_stateKind_7_0= ruleStateType ) ) ( (lv_isFinal_8_0= 'final' ) ) )
                    // InternalBug286935TestLanguage.g:172:7: ( (lv_isInitial_6_0= 'init' ) ) ( (lv_stateKind_7_0= ruleStateType ) ) ( (lv_isFinal_8_0= 'final' ) )
                    {
                    // InternalBug286935TestLanguage.g:172:7: ( (lv_isInitial_6_0= 'init' ) )
                    // InternalBug286935TestLanguage.g:173:1: (lv_isInitial_6_0= 'init' )
                    {
                    // InternalBug286935TestLanguage.g:173:1: (lv_isInitial_6_0= 'init' )
                    // InternalBug286935TestLanguage.g:174:3: lv_isInitial_6_0= 'init'
                    {
                    lv_isInitial_6_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

                            newLeafNode(lv_isInitial_6_0, grammarAccess.getStateAccess().getIsInitialInitKeyword_1_4_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getStateRule());
                    	        }
                           		setWithLastConsumed(current, "isInitial", true, "init");
                    	    

                    }


                    }

                    // InternalBug286935TestLanguage.g:187:2: ( (lv_stateKind_7_0= ruleStateType ) )
                    // InternalBug286935TestLanguage.g:188:1: (lv_stateKind_7_0= ruleStateType )
                    {
                    // InternalBug286935TestLanguage.g:188:1: (lv_stateKind_7_0= ruleStateType )
                    // InternalBug286935TestLanguage.g:189:3: lv_stateKind_7_0= ruleStateType
                    {
                     
                    	        newCompositeNode(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_1_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_5);
                    lv_stateKind_7_0=ruleStateType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStateRule());
                    	        }
                           		set(
                           			current, 
                           			"stateKind",
                            		lv_stateKind_7_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug286935TestLanguage.StateType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalBug286935TestLanguage.g:205:2: ( (lv_isFinal_8_0= 'final' ) )
                    // InternalBug286935TestLanguage.g:206:1: (lv_isFinal_8_0= 'final' )
                    {
                    // InternalBug286935TestLanguage.g:206:1: (lv_isFinal_8_0= 'final' )
                    // InternalBug286935TestLanguage.g:207:3: lv_isFinal_8_0= 'final'
                    {
                    lv_isFinal_8_0=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                            newLeafNode(lv_isFinal_8_0, grammarAccess.getStateAccess().getIsFinalFinalKeyword_1_4_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getStateRule());
                    	        }
                           		setWithLastConsumed(current, "isFinal", true, "final");
                    	    

                    }


                    }


                    }


                    }
                    break;

            }

            // InternalBug286935TestLanguage.g:220:5: (otherlv_9= 'state' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalBug286935TestLanguage.g:220:7: otherlv_9= 'state'
                    {
                    otherlv_9=(Token)match(input,13,FollowSets000.FOLLOW_6); 

                        	newLeafNode(otherlv_9, grammarAccess.getStateAccess().getStateKeyword_2());
                        

                    }
                    break;

            }

            // InternalBug286935TestLanguage.g:224:3: ( (lv_stateName_10_0= RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalBug286935TestLanguage.g:225:1: (lv_stateName_10_0= RULE_ID )
                    {
                    // InternalBug286935TestLanguage.g:225:1: (lv_stateName_10_0= RULE_ID )
                    // InternalBug286935TestLanguage.g:226:3: lv_stateName_10_0= RULE_ID
                    {
                    lv_stateName_10_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

                    			newLeafNode(lv_stateName_10_0, grammarAccess.getStateAccess().getStateNameIDTerminalRuleCall_3_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getStateRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"stateName",
                            		lv_stateName_10_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }
                    break;

            }

            // InternalBug286935TestLanguage.g:242:3: ( (lv_label_11_0= RULE_STRING ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalBug286935TestLanguage.g:243:1: (lv_label_11_0= RULE_STRING )
                    {
                    // InternalBug286935TestLanguage.g:243:1: (lv_label_11_0= RULE_STRING )
                    // InternalBug286935TestLanguage.g:244:3: lv_label_11_0= RULE_STRING
                    {
                    lv_label_11_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_label_11_0, grammarAccess.getStateAccess().getLabelSTRINGTerminalRuleCall_4_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getStateRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"label",
                            		lv_label_11_0, 
                            		"org.eclipse.xtext.common.Terminals.STRING");
                    	    

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
    // $ANTLR end "ruleState"


    // $ANTLR start "ruleStateType"
    // InternalBug286935TestLanguage.g:268:1: ruleStateType returns [Enumerator current=null] : ( (enumLiteral_0= 'NORMAL' ) | (enumLiteral_1= 'cond' ) | (enumLiteral_2= 'reference' ) | (enumLiteral_3= 'textual' ) ) ;
    public final Enumerator ruleStateType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // InternalBug286935TestLanguage.g:270:28: ( ( (enumLiteral_0= 'NORMAL' ) | (enumLiteral_1= 'cond' ) | (enumLiteral_2= 'reference' ) | (enumLiteral_3= 'textual' ) ) )
            // InternalBug286935TestLanguage.g:271:1: ( (enumLiteral_0= 'NORMAL' ) | (enumLiteral_1= 'cond' ) | (enumLiteral_2= 'reference' ) | (enumLiteral_3= 'textual' ) )
            {
            // InternalBug286935TestLanguage.g:271:1: ( (enumLiteral_0= 'NORMAL' ) | (enumLiteral_1= 'cond' ) | (enumLiteral_2= 'reference' ) | (enumLiteral_3= 'textual' ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt5=1;
                }
                break;
            case 15:
                {
                alt5=2;
                }
                break;
            case 16:
                {
                alt5=3;
                }
                break;
            case 17:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalBug286935TestLanguage.g:271:2: (enumLiteral_0= 'NORMAL' )
                    {
                    // InternalBug286935TestLanguage.g:271:2: (enumLiteral_0= 'NORMAL' )
                    // InternalBug286935TestLanguage.g:271:4: enumLiteral_0= 'NORMAL'
                    {
                    enumLiteral_0=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getStateTypeAccess().getNORMALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getStateTypeAccess().getNORMALEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalBug286935TestLanguage.g:277:6: (enumLiteral_1= 'cond' )
                    {
                    // InternalBug286935TestLanguage.g:277:6: (enumLiteral_1= 'cond' )
                    // InternalBug286935TestLanguage.g:277:8: enumLiteral_1= 'cond'
                    {
                    enumLiteral_1=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getStateTypeAccess().getPSEUDOEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getStateTypeAccess().getPSEUDOEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalBug286935TestLanguage.g:283:6: (enumLiteral_2= 'reference' )
                    {
                    // InternalBug286935TestLanguage.g:283:6: (enumLiteral_2= 'reference' )
                    // InternalBug286935TestLanguage.g:283:8: enumLiteral_2= 'reference'
                    {
                    enumLiteral_2=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getStateTypeAccess().getREFERENCEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getStateTypeAccess().getREFERENCEEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalBug286935TestLanguage.g:289:6: (enumLiteral_3= 'textual' )
                    {
                    // InternalBug286935TestLanguage.g:289:6: (enumLiteral_3= 'textual' )
                    // InternalBug286935TestLanguage.g:289:8: enumLiteral_3= 'textual'
                    {
                    enumLiteral_3=(Token)match(input,17,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getStateTypeAccess().getTEXTUALEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getStateTypeAccess().getTEXTUALEnumLiteralDeclaration_3()); 
                        

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
    // $ANTLR end "ruleStateType"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\14\uffff";
    static final String DFA1_eofS =
        "\1\4\1\5\4\uffff\4\12\2\uffff";
    static final String DFA1_minS =
        "\2\4\4\uffff\4\4\2\uffff";
    static final String DFA1_maxS =
        "\2\21\4\uffff\4\15\2\uffff";
    static final String DFA1_acceptS =
        "\2\uffff\1\2\1\3\1\6\1\1\4\uffff\1\4\1\5";
    static final String DFA1_specialS =
        "\14\uffff}>";
    static final String[] DFA1_transitionS = {
            "\2\4\5\uffff\1\1\1\2\1\4\4\3",
            "\2\5\7\uffff\1\5\1\6\1\7\1\10\1\11",
            "",
            "",
            "",
            "",
            "\2\12\6\uffff\1\13\1\12",
            "\2\12\6\uffff\1\13\1\12",
            "\2\12\6\uffff\1\13\1\12",
            "\2\12\6\uffff\1\13\1\12",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "87:2: ( ( (lv_isInitial_1_0= 'init' ) ) | ( (lv_isFinal_2_0= 'final' ) ) | ( (lv_stateKind_3_0= ruleStateType ) ) | ( ( (lv_isInitial_4_0= 'init' ) ) ( (lv_stateKind_5_0= ruleStateType ) ) ) | ( ( (lv_isInitial_6_0= 'init' ) ) ( (lv_stateKind_7_0= ruleStateType ) ) ( (lv_isFinal_8_0= 'final' ) ) ) )?";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002032L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000003C000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000032L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000022L});
    }


}