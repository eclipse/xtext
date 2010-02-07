package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug286935TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug286935TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'init'", "'final'", "'state'", "'NORMAL'", "'cond'", "'reference'", "'textual'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBug286935TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g"; }



     	private Bug286935TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug286935TestLanguageParser(TokenStream input, IAstFactory factory, Bug286935TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "State";	
       	} 



    // $ANTLR start entryRuleState
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:73:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:74:2: (iv_ruleState= ruleState EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:75:2: iv_ruleState= ruleState EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleState_in_entryRuleState75);
            iv_ruleState=ruleState();
            _fsp--;

             current =iv_ruleState; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleState85); 

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
    // $ANTLR end entryRuleState


    // $ANTLR start ruleState
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:82:1: ruleState returns [EObject current=null] : ( ( ( (lv_isInitial_0_0= 'init' ) ) | ( (lv_isFinal_1_0= 'final' ) ) | ( (lv_stateKind_2_0= ruleStateType ) ) | ( ( (lv_isInitial_3_0= 'init' ) ) ( (lv_stateKind_4_0= ruleStateType ) ) ) | ( ( (lv_isInitial_5_0= 'init' ) ) ( (lv_stateKind_6_0= ruleStateType ) ) ( (lv_isFinal_7_0= 'final' ) ) ) )? ( 'state' )? ( (lv_stateName_9_0= RULE_ID ) )? ( (lv_label_10_0= RULE_STRING ) )? ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token lv_isInitial_0_0=null;
        Token lv_isFinal_1_0=null;
        Token lv_isInitial_3_0=null;
        Token lv_isInitial_5_0=null;
        Token lv_isFinal_7_0=null;
        Token lv_stateName_9_0=null;
        Token lv_label_10_0=null;
        Enumerator lv_stateKind_2_0 = null;

        Enumerator lv_stateKind_4_0 = null;

        Enumerator lv_stateKind_6_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:88:6: ( ( ( ( (lv_isInitial_0_0= 'init' ) ) | ( (lv_isFinal_1_0= 'final' ) ) | ( (lv_stateKind_2_0= ruleStateType ) ) | ( ( (lv_isInitial_3_0= 'init' ) ) ( (lv_stateKind_4_0= ruleStateType ) ) ) | ( ( (lv_isInitial_5_0= 'init' ) ) ( (lv_stateKind_6_0= ruleStateType ) ) ( (lv_isFinal_7_0= 'final' ) ) ) )? ( 'state' )? ( (lv_stateName_9_0= RULE_ID ) )? ( (lv_label_10_0= RULE_STRING ) )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:89:1: ( ( ( (lv_isInitial_0_0= 'init' ) ) | ( (lv_isFinal_1_0= 'final' ) ) | ( (lv_stateKind_2_0= ruleStateType ) ) | ( ( (lv_isInitial_3_0= 'init' ) ) ( (lv_stateKind_4_0= ruleStateType ) ) ) | ( ( (lv_isInitial_5_0= 'init' ) ) ( (lv_stateKind_6_0= ruleStateType ) ) ( (lv_isFinal_7_0= 'final' ) ) ) )? ( 'state' )? ( (lv_stateName_9_0= RULE_ID ) )? ( (lv_label_10_0= RULE_STRING ) )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:89:1: ( ( ( (lv_isInitial_0_0= 'init' ) ) | ( (lv_isFinal_1_0= 'final' ) ) | ( (lv_stateKind_2_0= ruleStateType ) ) | ( ( (lv_isInitial_3_0= 'init' ) ) ( (lv_stateKind_4_0= ruleStateType ) ) ) | ( ( (lv_isInitial_5_0= 'init' ) ) ( (lv_stateKind_6_0= ruleStateType ) ) ( (lv_isFinal_7_0= 'final' ) ) ) )? ( 'state' )? ( (lv_stateName_9_0= RULE_ID ) )? ( (lv_label_10_0= RULE_STRING ) )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:89:2: ( ( (lv_isInitial_0_0= 'init' ) ) | ( (lv_isFinal_1_0= 'final' ) ) | ( (lv_stateKind_2_0= ruleStateType ) ) | ( ( (lv_isInitial_3_0= 'init' ) ) ( (lv_stateKind_4_0= ruleStateType ) ) ) | ( ( (lv_isInitial_5_0= 'init' ) ) ( (lv_stateKind_6_0= ruleStateType ) ) ( (lv_isFinal_7_0= 'final' ) ) ) )? ( 'state' )? ( (lv_stateName_9_0= RULE_ID ) )? ( (lv_label_10_0= RULE_STRING ) )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:89:2: ( ( (lv_isInitial_0_0= 'init' ) ) | ( (lv_isFinal_1_0= 'final' ) ) | ( (lv_stateKind_2_0= ruleStateType ) ) | ( ( (lv_isInitial_3_0= 'init' ) ) ( (lv_stateKind_4_0= ruleStateType ) ) ) | ( ( (lv_isInitial_5_0= 'init' ) ) ( (lv_stateKind_6_0= ruleStateType ) ) ( (lv_isFinal_7_0= 'final' ) ) ) )?
            int alt1=6;
            switch ( input.LA(1) ) {
                case 11:
                    {
                    switch ( input.LA(2) ) {
                        case EOF:
                        case RULE_ID:
                        case RULE_STRING:
                        case 13:
                            {
                            alt1=1;
                            }
                            break;
                        case 14:
                            {
                            int LA1_6 = input.LA(3);

                            if ( (LA1_6==EOF||(LA1_6>=RULE_ID && LA1_6<=RULE_STRING)||LA1_6==13) ) {
                                alt1=4;
                            }
                            else if ( (LA1_6==12) ) {
                                alt1=5;
                            }
                            }
                            break;
                        case 15:
                            {
                            int LA1_7 = input.LA(3);

                            if ( (LA1_7==EOF||(LA1_7>=RULE_ID && LA1_7<=RULE_STRING)||LA1_7==13) ) {
                                alt1=4;
                            }
                            else if ( (LA1_7==12) ) {
                                alt1=5;
                            }
                            }
                            break;
                        case 16:
                            {
                            int LA1_8 = input.LA(3);

                            if ( (LA1_8==12) ) {
                                alt1=5;
                            }
                            else if ( (LA1_8==EOF||(LA1_8>=RULE_ID && LA1_8<=RULE_STRING)||LA1_8==13) ) {
                                alt1=4;
                            }
                            }
                            break;
                        case 17:
                            {
                            int LA1_9 = input.LA(3);

                            if ( (LA1_9==12) ) {
                                alt1=5;
                            }
                            else if ( (LA1_9==EOF||(LA1_9>=RULE_ID && LA1_9<=RULE_STRING)||LA1_9==13) ) {
                                alt1=4;
                            }
                            }
                            break;
                    }

                    }
                    break;
                case 12:
                    {
                    alt1=2;
                    }
                    break;
                case 14:
                case 15:
                case 16:
                case 17:
                    {
                    alt1=3;
                    }
                    break;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:89:3: ( (lv_isInitial_0_0= 'init' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:89:3: ( (lv_isInitial_0_0= 'init' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:90:1: (lv_isInitial_0_0= 'init' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:90:1: (lv_isInitial_0_0= 'init' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:91:3: lv_isInitial_0_0= 'init'
                    {
                    lv_isInitial_0_0=(Token)input.LT(1);
                    match(input,11,FollowSets000.FOLLOW_11_in_ruleState129); 

                            createLeafNode(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_0_0(), "isInitial"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "isInitial", true, "init", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:111:6: ( (lv_isFinal_1_0= 'final' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:111:6: ( (lv_isFinal_1_0= 'final' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:112:1: (lv_isFinal_1_0= 'final' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:112:1: (lv_isFinal_1_0= 'final' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:113:3: lv_isFinal_1_0= 'final'
                    {
                    lv_isFinal_1_0=(Token)input.LT(1);
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleState166); 

                            createLeafNode(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_1_0(), "isFinal"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "isFinal", true, "final", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:133:6: ( (lv_stateKind_2_0= ruleStateType ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:133:6: ( (lv_stateKind_2_0= ruleStateType ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:134:1: (lv_stateKind_2_0= ruleStateType )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:134:1: (lv_stateKind_2_0= ruleStateType )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:135:3: lv_stateKind_2_0= ruleStateType
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_2_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleStateType_in_ruleState206);
                    lv_stateKind_2_0=ruleStateType();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"stateKind",
                    	        		lv_stateKind_2_0, 
                    	        		"StateType", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:158:6: ( ( (lv_isInitial_3_0= 'init' ) ) ( (lv_stateKind_4_0= ruleStateType ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:158:6: ( ( (lv_isInitial_3_0= 'init' ) ) ( (lv_stateKind_4_0= ruleStateType ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:158:7: ( (lv_isInitial_3_0= 'init' ) ) ( (lv_stateKind_4_0= ruleStateType ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:158:7: ( (lv_isInitial_3_0= 'init' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:159:1: (lv_isInitial_3_0= 'init' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:159:1: (lv_isInitial_3_0= 'init' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:160:3: lv_isInitial_3_0= 'init'
                    {
                    lv_isInitial_3_0=(Token)input.LT(1);
                    match(input,11,FollowSets000.FOLLOW_11_in_ruleState231); 

                            createLeafNode(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_3_0_0(), "isInitial"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "isInitial", true, "init", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:179:2: ( (lv_stateKind_4_0= ruleStateType ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:180:1: (lv_stateKind_4_0= ruleStateType )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:180:1: (lv_stateKind_4_0= ruleStateType )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:181:3: lv_stateKind_4_0= ruleStateType
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_3_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleStateType_in_ruleState265);
                    lv_stateKind_4_0=ruleStateType();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"stateKind",
                    	        		lv_stateKind_4_0, 
                    	        		"StateType", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:204:6: ( ( (lv_isInitial_5_0= 'init' ) ) ( (lv_stateKind_6_0= ruleStateType ) ) ( (lv_isFinal_7_0= 'final' ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:204:6: ( ( (lv_isInitial_5_0= 'init' ) ) ( (lv_stateKind_6_0= ruleStateType ) ) ( (lv_isFinal_7_0= 'final' ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:204:7: ( (lv_isInitial_5_0= 'init' ) ) ( (lv_stateKind_6_0= ruleStateType ) ) ( (lv_isFinal_7_0= 'final' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:204:7: ( (lv_isInitial_5_0= 'init' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:205:1: (lv_isInitial_5_0= 'init' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:205:1: (lv_isInitial_5_0= 'init' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:206:3: lv_isInitial_5_0= 'init'
                    {
                    lv_isInitial_5_0=(Token)input.LT(1);
                    match(input,11,FollowSets000.FOLLOW_11_in_ruleState291); 

                            createLeafNode(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_4_0_0(), "isInitial"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "isInitial", true, "init", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:225:2: ( (lv_stateKind_6_0= ruleStateType ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:226:1: (lv_stateKind_6_0= ruleStateType )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:226:1: (lv_stateKind_6_0= ruleStateType )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:227:3: lv_stateKind_6_0= ruleStateType
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_4_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleStateType_in_ruleState325);
                    lv_stateKind_6_0=ruleStateType();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"stateKind",
                    	        		lv_stateKind_6_0, 
                    	        		"StateType", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:249:2: ( (lv_isFinal_7_0= 'final' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:250:1: (lv_isFinal_7_0= 'final' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:250:1: (lv_isFinal_7_0= 'final' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:251:3: lv_isFinal_7_0= 'final'
                    {
                    lv_isFinal_7_0=(Token)input.LT(1);
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleState343); 

                            createLeafNode(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_4_2_0(), "isFinal"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "isFinal", true, "final", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:270:5: ( 'state' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:270:7: 'state'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleState370); 

                            createLeafNode(grammarAccess.getStateAccess().getStateKeyword_1(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:274:3: ( (lv_stateName_9_0= RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:275:1: (lv_stateName_9_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:275:1: (lv_stateName_9_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:276:3: lv_stateName_9_0= RULE_ID
                    {
                    lv_stateName_9_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleState389); 

                    			createLeafNode(grammarAccess.getStateAccess().getStateNameIDTerminalRuleCall_2_0(), "stateName"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"stateName",
                    	        		lv_stateName_9_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:298:3: ( (lv_label_10_0= RULE_STRING ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:299:1: (lv_label_10_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:299:1: (lv_label_10_0= RULE_STRING )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:300:3: lv_label_10_0= RULE_STRING
                    {
                    lv_label_10_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleState412); 

                    			createLeafNode(grammarAccess.getStateAccess().getLabelSTRINGTerminalRuleCall_3_0(), "label"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"label",
                    	        		lv_label_10_0, 
                    	        		"STRING", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleState


    // $ANTLR start ruleStateType
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:330:1: ruleStateType returns [Enumerator current=null] : ( ( 'NORMAL' ) | ( 'cond' ) | ( 'reference' ) | ( 'textual' ) ) ;
    public final Enumerator ruleStateType() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:334:6: ( ( ( 'NORMAL' ) | ( 'cond' ) | ( 'reference' ) | ( 'textual' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:335:1: ( ( 'NORMAL' ) | ( 'cond' ) | ( 'reference' ) | ( 'textual' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:335:1: ( ( 'NORMAL' ) | ( 'cond' ) | ( 'reference' ) | ( 'textual' ) )
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
                    new NoViableAltException("335:1: ( ( 'NORMAL' ) | ( 'cond' ) | ( 'reference' ) | ( 'textual' ) )", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:335:2: ( 'NORMAL' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:335:2: ( 'NORMAL' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:335:4: 'NORMAL'
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleStateType466); 

                            current = grammarAccess.getStateTypeAccess().getNORMALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStateTypeAccess().getNORMALEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:341:6: ( 'cond' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:341:6: ( 'cond' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:341:8: 'cond'
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleStateType481); 

                            current = grammarAccess.getStateTypeAccess().getPSEUDOEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStateTypeAccess().getPSEUDOEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:347:6: ( 'reference' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:347:6: ( 'reference' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:347:8: 'reference'
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleStateType496); 

                            current = grammarAccess.getStateTypeAccess().getREFERENCEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStateTypeAccess().getREFERENCEEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:353:6: ( 'textual' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:353:6: ( 'textual' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug286935TestLanguage.g:353:8: 'textual'
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_ruleStateType511); 

                            current = grammarAccess.getStateTypeAccess().getTEXTUALEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStateTypeAccess().getTEXTUALEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleStateType


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleState_in_entryRuleState75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleState85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleState129 = new BitSet(new long[]{0x0000000000002032L});
        public static final BitSet FOLLOW_12_in_ruleState166 = new BitSet(new long[]{0x0000000000002032L});
        public static final BitSet FOLLOW_ruleStateType_in_ruleState206 = new BitSet(new long[]{0x0000000000002032L});
        public static final BitSet FOLLOW_11_in_ruleState231 = new BitSet(new long[]{0x000000000003C000L});
        public static final BitSet FOLLOW_ruleStateType_in_ruleState265 = new BitSet(new long[]{0x0000000000002032L});
        public static final BitSet FOLLOW_11_in_ruleState291 = new BitSet(new long[]{0x000000000003C000L});
        public static final BitSet FOLLOW_ruleStateType_in_ruleState325 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleState343 = new BitSet(new long[]{0x0000000000002032L});
        public static final BitSet FOLLOW_13_in_ruleState370 = new BitSet(new long[]{0x0000000000000032L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleState389 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleState412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleStateType466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleStateType481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleStateType496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleStateType511 = new BitSet(new long[]{0x0000000000000002L});
    }


}