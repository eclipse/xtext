package org.eclipse.xtext.metamodelreferencing.tests.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.metamodelreferencing.tests.services.EcoreReferenceTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEcoreReferenceTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'ExtendsNsURIEObject'", "'EObject'", "'ExtendsPluginEObject'", "'ExtendsResourceEObject'", "'MyEAttribute'", "'EAttribute'", "'object'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalEcoreReferenceTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEcoreReferenceTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEcoreReferenceTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g"; }



     	private EcoreReferenceTestLanguageGrammarAccess grammarAccess;
     	
        public InternalEcoreReferenceTestLanguageParser(TokenStream input, EcoreReferenceTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected EcoreReferenceTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel85); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_extends_0_0 = null;

        EObject lv_extends_1_0 = null;

        EObject lv_extends_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:79:28: ( ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:80:1: ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:80:1: ( ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:80:2: ( (lv_extends_0_0= ruleExtendsNsURIEObject ) ) ( (lv_extends_1_0= ruleExtendsPluginEObject ) ) ( (lv_extends_2_0= ruleExtendsResourceEObject ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:80:2: ( (lv_extends_0_0= ruleExtendsNsURIEObject ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:81:1: (lv_extends_0_0= ruleExtendsNsURIEObject )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:81:1: (lv_extends_0_0= ruleExtendsNsURIEObject )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:82:3: lv_extends_0_0= ruleExtendsNsURIEObject
            {
             
            	        newCompositeNode(grammarAccess.getModelAccess().getExtendsExtendsNsURIEObjectParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleExtendsNsURIEObject_in_ruleModel131);
            lv_extends_0_0=ruleExtendsNsURIEObject();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		add(
                   			current, 
                   			"extends",
                    		lv_extends_0_0, 
                    		"ExtendsNsURIEObject");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:98:2: ( (lv_extends_1_0= ruleExtendsPluginEObject ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:99:1: (lv_extends_1_0= ruleExtendsPluginEObject )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:99:1: (lv_extends_1_0= ruleExtendsPluginEObject )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:100:3: lv_extends_1_0= ruleExtendsPluginEObject
            {
             
            	        newCompositeNode(grammarAccess.getModelAccess().getExtendsExtendsPluginEObjectParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleExtendsPluginEObject_in_ruleModel152);
            lv_extends_1_0=ruleExtendsPluginEObject();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		add(
                   			current, 
                   			"extends",
                    		lv_extends_1_0, 
                    		"ExtendsPluginEObject");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:116:2: ( (lv_extends_2_0= ruleExtendsResourceEObject ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:117:1: (lv_extends_2_0= ruleExtendsResourceEObject )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:117:1: (lv_extends_2_0= ruleExtendsResourceEObject )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:118:3: lv_extends_2_0= ruleExtendsResourceEObject
            {
             
            	        newCompositeNode(grammarAccess.getModelAccess().getExtendsExtendsResourceEObjectParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleExtendsResourceEObject_in_ruleModel173);
            lv_extends_2_0=ruleExtendsResourceEObject();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		add(
                   			current, 
                   			"extends",
                    		lv_extends_2_0, 
                    		"ExtendsResourceEObject");
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleExtendsNsURIEObject"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:142:1: entryRuleExtendsNsURIEObject returns [EObject current=null] : iv_ruleExtendsNsURIEObject= ruleExtendsNsURIEObject EOF ;
    public final EObject entryRuleExtendsNsURIEObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendsNsURIEObject = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:143:2: (iv_ruleExtendsNsURIEObject= ruleExtendsNsURIEObject EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:144:2: iv_ruleExtendsNsURIEObject= ruleExtendsNsURIEObject EOF
            {
             newCompositeNode(grammarAccess.getExtendsNsURIEObjectRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExtendsNsURIEObject_in_entryRuleExtendsNsURIEObject209);
            iv_ruleExtendsNsURIEObject=ruleExtendsNsURIEObject();

            state._fsp--;

             current =iv_ruleExtendsNsURIEObject; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExtendsNsURIEObject219); 

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
    // $ANTLR end "entryRuleExtendsNsURIEObject"


    // $ANTLR start "ruleExtendsNsURIEObject"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:151:1: ruleExtendsNsURIEObject returns [EObject current=null] : (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? ) ;
    public final EObject ruleExtendsNsURIEObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_eObjectContainment_15_0 = null;

        EObject lv_eObjectContainment_16_0 = null;

        EObject lv_eObjectContainment_17_0 = null;

        EObject lv_eObjectContainment_18_0 = null;

        EObject lv_eObjectContainment_19_0 = null;

        EObject lv_eObjectContainment_20_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:154:28: ( (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:155:1: (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:155:1: (otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:155:3: otherlv_0= 'ExtendsNsURIEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )?
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleExtendsNsURIEObject256); 

                	newLeafNode(otherlv_0, grammarAccess.getExtendsNsURIEObjectAccess().getExtendsNsURIEObjectKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:159:1: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:160:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:160:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:161:3: lv_name_1_0= ruleValidID
            {
             
            	        newCompositeNode(grammarAccess.getExtendsNsURIEObjectAccess().getNameValidIDParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleValidID_in_ruleExtendsNsURIEObject277);
            lv_name_1_0=ruleValidID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExtendsNsURIEObjectRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ValidID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:177:2: ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt1=1;
                }
                break;
            case 11:
                {
                alt1=2;
                }
                break;
            case 13:
                {
                alt1=3;
                }
                break;
            case 14:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:177:3: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:177:3: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:177:5: otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleExtendsNsURIEObject291); 

                        	newLeafNode(otherlv_2, grammarAccess.getExtendsNsURIEObjectAccess().getEObjectKeyword_2_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:181:1: ( (otherlv_3= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:182:1: (otherlv_3= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:182:1: (otherlv_3= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:183:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getExtendsNsURIEObjectRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject311); 

                    		newLeafNode(otherlv_3, grammarAccess.getExtendsNsURIEObjectAccess().getEObjectReference1EObjectCrossReference_2_0_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:195:6: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:195:6: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:195:8: otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleExtendsNsURIEObject331); 

                        	newLeafNode(otherlv_4, grammarAccess.getExtendsNsURIEObjectAccess().getExtendsNsURIEObjectKeyword_2_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:199:1: ( (otherlv_5= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:200:1: (otherlv_5= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:200:1: (otherlv_5= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:201:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getExtendsNsURIEObjectRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject351); 

                    		newLeafNode(otherlv_5, grammarAccess.getExtendsNsURIEObjectAccess().getEObjectReference1ExtendsNsURIEObjectCrossReference_2_1_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:213:6: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:213:6: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:213:8: otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleExtendsNsURIEObject371); 

                        	newLeafNode(otherlv_6, grammarAccess.getExtendsNsURIEObjectAccess().getExtendsPluginEObjectKeyword_2_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:217:1: ( (otherlv_7= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:218:1: (otherlv_7= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:218:1: (otherlv_7= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:219:3: otherlv_7= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getExtendsNsURIEObjectRule());
                    	        }
                            
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject391); 

                    		newLeafNode(otherlv_7, grammarAccess.getExtendsNsURIEObjectAccess().getEObjectReference1ExtendsPluginEObjectCrossReference_2_2_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:231:6: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:231:6: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:231:8: otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleExtendsNsURIEObject411); 

                        	newLeafNode(otherlv_8, grammarAccess.getExtendsNsURIEObjectAccess().getExtendsResourceEObjectKeyword_2_3_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:235:1: ( (otherlv_9= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:236:1: (otherlv_9= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:236:1: (otherlv_9= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:237:3: otherlv_9= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getExtendsNsURIEObjectRule());
                    	        }
                            
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject431); 

                    		newLeafNode(otherlv_9, grammarAccess.getExtendsNsURIEObjectAccess().getEObjectReference1ExtendsResourceEObjectCrossReference_2_3_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:248:4: (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==RULE_ID) ) {
                    int LA5_3 = input.LA(3);

                    if ( (LA5_3==RULE_ID) ) {
                        alt5=1;
                    }
                }
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:248:6: otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (otherlv_14= RULE_ID ) ) ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_18_0= ruleEObject ) ) ( (lv_eObjectContainment_19_0= ruleEAttribute ) ) ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) )
                    {
                    otherlv_10=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleExtendsNsURIEObject446); 

                        	newLeafNode(otherlv_10, grammarAccess.getExtendsNsURIEObjectAccess().getExtendsPluginEObjectKeyword_3_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:252:1: ( (otherlv_11= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:253:1: (otherlv_11= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:253:1: (otherlv_11= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:254:3: otherlv_11= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getExtendsNsURIEObjectRule());
                    	        }
                            
                    otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject466); 

                    		newLeafNode(otherlv_11, grammarAccess.getExtendsNsURIEObjectAccess().getEAttributeReferenceMyEAttributeCrossReference_3_1_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:265:2: ( (otherlv_12= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:266:1: (otherlv_12= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:266:1: (otherlv_12= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:267:3: otherlv_12= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getExtendsNsURIEObjectRule());
                    	        }
                            
                    otherlv_12=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject486); 

                    		newLeafNode(otherlv_12, grammarAccess.getExtendsNsURIEObjectAccess().getEObjectReference2ExtendsNsURIEObjectCrossReference_3_2_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:278:2: ( (otherlv_13= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:279:1: (otherlv_13= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:279:1: (otherlv_13= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:280:3: otherlv_13= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getExtendsNsURIEObjectRule());
                    	        }
                            
                    otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject506); 

                    		newLeafNode(otherlv_13, grammarAccess.getExtendsNsURIEObjectAccess().getEObjectReference3ExtendsPluginEObjectCrossReference_3_3_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:291:2: ( (otherlv_14= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:292:1: (otherlv_14= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:292:1: (otherlv_14= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:293:3: otherlv_14= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getExtendsNsURIEObjectRule());
                    	        }
                            
                    otherlv_14=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject526); 

                    		newLeafNode(otherlv_14, grammarAccess.getExtendsNsURIEObjectAccess().getEObjectReference4ExtendsResourceEObjectCrossReference_3_4_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:304:2: ( (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject ) )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==11) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:305:1: (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:305:1: (lv_eObjectContainment_15_0= ruleExtendsNsURIEObject )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:306:3: lv_eObjectContainment_15_0= ruleExtendsNsURIEObject
                            {
                             
                            	        newCompositeNode(grammarAccess.getExtendsNsURIEObjectAccess().getEObjectContainmentExtendsNsURIEObjectParserRuleCall_3_5_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleExtendsNsURIEObject_in_ruleExtendsNsURIEObject547);
                            lv_eObjectContainment_15_0=ruleExtendsNsURIEObject();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getExtendsNsURIEObjectRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"eObjectContainment",
                                    		lv_eObjectContainment_15_0, 
                                    		"ExtendsNsURIEObject");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:322:3: ( (lv_eObjectContainment_16_0= ruleExtendsPluginEObject ) )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==13) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:323:1: (lv_eObjectContainment_16_0= ruleExtendsPluginEObject )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:323:1: (lv_eObjectContainment_16_0= ruleExtendsPluginEObject )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:324:3: lv_eObjectContainment_16_0= ruleExtendsPluginEObject
                            {
                             
                            	        newCompositeNode(grammarAccess.getExtendsNsURIEObjectAccess().getEObjectContainmentExtendsPluginEObjectParserRuleCall_3_6_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleExtendsPluginEObject_in_ruleExtendsNsURIEObject569);
                            lv_eObjectContainment_16_0=ruleExtendsPluginEObject();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getExtendsNsURIEObjectRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"eObjectContainment",
                                    		lv_eObjectContainment_16_0, 
                                    		"ExtendsPluginEObject");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:340:3: ( (lv_eObjectContainment_17_0= ruleExtendsResourceEObject ) )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==14) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:341:1: (lv_eObjectContainment_17_0= ruleExtendsResourceEObject )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:341:1: (lv_eObjectContainment_17_0= ruleExtendsResourceEObject )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:342:3: lv_eObjectContainment_17_0= ruleExtendsResourceEObject
                            {
                             
                            	        newCompositeNode(grammarAccess.getExtendsNsURIEObjectAccess().getEObjectContainmentExtendsResourceEObjectParserRuleCall_3_7_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleExtendsResourceEObject_in_ruleExtendsNsURIEObject591);
                            lv_eObjectContainment_17_0=ruleExtendsResourceEObject();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getExtendsNsURIEObjectRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"eObjectContainment",
                                    		lv_eObjectContainment_17_0, 
                                    		"ExtendsResourceEObject");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:358:3: ( (lv_eObjectContainment_18_0= ruleEObject ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:359:1: (lv_eObjectContainment_18_0= ruleEObject )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:359:1: (lv_eObjectContainment_18_0= ruleEObject )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:360:3: lv_eObjectContainment_18_0= ruleEObject
                    {
                     
                    	        newCompositeNode(grammarAccess.getExtendsNsURIEObjectAccess().getEObjectContainmentEObjectParserRuleCall_3_8_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEObject_in_ruleExtendsNsURIEObject613);
                    lv_eObjectContainment_18_0=ruleEObject();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExtendsNsURIEObjectRule());
                    	        }
                           		add(
                           			current, 
                           			"eObjectContainment",
                            		lv_eObjectContainment_18_0, 
                            		"EObject");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:376:2: ( (lv_eObjectContainment_19_0= ruleEAttribute ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:377:1: (lv_eObjectContainment_19_0= ruleEAttribute )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:377:1: (lv_eObjectContainment_19_0= ruleEAttribute )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:378:3: lv_eObjectContainment_19_0= ruleEAttribute
                    {
                     
                    	        newCompositeNode(grammarAccess.getExtendsNsURIEObjectAccess().getEObjectContainmentEAttributeParserRuleCall_3_9_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEAttribute_in_ruleExtendsNsURIEObject634);
                    lv_eObjectContainment_19_0=ruleEAttribute();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExtendsNsURIEObjectRule());
                    	        }
                           		add(
                           			current, 
                           			"eObjectContainment",
                            		lv_eObjectContainment_19_0, 
                            		"EAttribute");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:394:2: ( (lv_eObjectContainment_20_0= ruleMyEAttribute ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:395:1: (lv_eObjectContainment_20_0= ruleMyEAttribute )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:395:1: (lv_eObjectContainment_20_0= ruleMyEAttribute )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:396:3: lv_eObjectContainment_20_0= ruleMyEAttribute
                    {
                     
                    	        newCompositeNode(grammarAccess.getExtendsNsURIEObjectAccess().getEObjectContainmentMyEAttributeParserRuleCall_3_10_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMyEAttribute_in_ruleExtendsNsURIEObject655);
                    lv_eObjectContainment_20_0=ruleMyEAttribute();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExtendsNsURIEObjectRule());
                    	        }
                           		add(
                           			current, 
                           			"eObjectContainment",
                            		lv_eObjectContainment_20_0, 
                            		"MyEAttribute");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


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
    // $ANTLR end "ruleExtendsNsURIEObject"


    // $ANTLR start "entryRuleMyEAttribute"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:420:1: entryRuleMyEAttribute returns [EObject current=null] : iv_ruleMyEAttribute= ruleMyEAttribute EOF ;
    public final EObject entryRuleMyEAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMyEAttribute = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:421:2: (iv_ruleMyEAttribute= ruleMyEAttribute EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:422:2: iv_ruleMyEAttribute= ruleMyEAttribute EOF
            {
             newCompositeNode(grammarAccess.getMyEAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMyEAttribute_in_entryRuleMyEAttribute693);
            iv_ruleMyEAttribute=ruleMyEAttribute();

            state._fsp--;

             current =iv_ruleMyEAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMyEAttribute703); 

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
    // $ANTLR end "entryRuleMyEAttribute"


    // $ANTLR start "ruleMyEAttribute"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:429:1: ruleMyEAttribute returns [EObject current=null] : ( () otherlv_1= 'MyEAttribute' ) ;
    public final EObject ruleMyEAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:432:28: ( ( () otherlv_1= 'MyEAttribute' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:433:1: ( () otherlv_1= 'MyEAttribute' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:433:1: ( () otherlv_1= 'MyEAttribute' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:433:2: () otherlv_1= 'MyEAttribute'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:433:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:434:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getMyEAttributeAccess().getMyEAttributeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleMyEAttribute749); 

                	newLeafNode(otherlv_1, grammarAccess.getMyEAttributeAccess().getMyEAttributeKeyword_1());
                

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
    // $ANTLR end "ruleMyEAttribute"


    // $ANTLR start "entryRuleEAttribute"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:451:1: entryRuleEAttribute returns [EObject current=null] : iv_ruleEAttribute= ruleEAttribute EOF ;
    public final EObject entryRuleEAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEAttribute = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:452:2: (iv_ruleEAttribute= ruleEAttribute EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:453:2: iv_ruleEAttribute= ruleEAttribute EOF
            {
             newCompositeNode(grammarAccess.getEAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEAttribute_in_entryRuleEAttribute785);
            iv_ruleEAttribute=ruleEAttribute();

            state._fsp--;

             current =iv_ruleEAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEAttribute795); 

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
    // $ANTLR end "entryRuleEAttribute"


    // $ANTLR start "ruleEAttribute"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:460:1: ruleEAttribute returns [EObject current=null] : ( () otherlv_1= 'EAttribute' ) ;
    public final EObject ruleEAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:463:28: ( ( () otherlv_1= 'EAttribute' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:464:1: ( () otherlv_1= 'EAttribute' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:464:1: ( () otherlv_1= 'EAttribute' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:464:2: () otherlv_1= 'EAttribute'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:464:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:465:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEAttributeAccess().getEAttributeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleEAttribute841); 

                	newLeafNode(otherlv_1, grammarAccess.getEAttributeAccess().getEAttributeKeyword_1());
                

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
    // $ANTLR end "ruleEAttribute"


    // $ANTLR start "entryRuleExtendsPluginEObject"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:482:1: entryRuleExtendsPluginEObject returns [EObject current=null] : iv_ruleExtendsPluginEObject= ruleExtendsPluginEObject EOF ;
    public final EObject entryRuleExtendsPluginEObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendsPluginEObject = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:483:2: (iv_ruleExtendsPluginEObject= ruleExtendsPluginEObject EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:484:2: iv_ruleExtendsPluginEObject= ruleExtendsPluginEObject EOF
            {
             newCompositeNode(grammarAccess.getExtendsPluginEObjectRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExtendsPluginEObject_in_entryRuleExtendsPluginEObject877);
            iv_ruleExtendsPluginEObject=ruleExtendsPluginEObject();

            state._fsp--;

             current =iv_ruleExtendsPluginEObject; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExtendsPluginEObject887); 

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
    // $ANTLR end "entryRuleExtendsPluginEObject"


    // $ANTLR start "ruleExtendsPluginEObject"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:491:1: ruleExtendsPluginEObject returns [EObject current=null] : (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) ;
    public final EObject ruleExtendsPluginEObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_eObjectContainment_14_0 = null;

        EObject lv_eObjectContainment_15_0 = null;

        EObject lv_eObjectContainment_16_0 = null;

        EObject lv_eObjectContainment_17_0 = null;

        EObject lv_eObjectContainment_18_0 = null;

        EObject lv_eObjectContainment_19_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:494:28: ( (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:495:1: (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:495:1: (otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:495:3: otherlv_0= 'ExtendsPluginEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleExtendsPluginEObject924); 

                	newLeafNode(otherlv_0, grammarAccess.getExtendsPluginEObjectAccess().getExtendsPluginEObjectKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:499:1: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:500:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:500:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:501:3: lv_name_1_0= ruleValidID
            {
             
            	        newCompositeNode(grammarAccess.getExtendsPluginEObjectAccess().getNameValidIDParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleValidID_in_ruleExtendsPluginEObject945);
            lv_name_1_0=ruleValidID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExtendsPluginEObjectRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ValidID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:517:2: ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt6=1;
                }
                break;
            case 11:
                {
                alt6=2;
                }
                break;
            case 13:
                {
                alt6=3;
                }
                break;
            case 14:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:517:3: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:517:3: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:517:5: otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleExtendsPluginEObject959); 

                        	newLeafNode(otherlv_2, grammarAccess.getExtendsPluginEObjectAccess().getEObjectKeyword_2_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:521:1: ( (otherlv_3= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:522:1: (otherlv_3= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:522:1: (otherlv_3= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:523:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getExtendsPluginEObjectRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsPluginEObject979); 

                    		newLeafNode(otherlv_3, grammarAccess.getExtendsPluginEObjectAccess().getEObjectReference1EObjectCrossReference_2_0_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:535:6: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:535:6: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:535:8: otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleExtendsPluginEObject999); 

                        	newLeafNode(otherlv_4, grammarAccess.getExtendsPluginEObjectAccess().getExtendsNsURIEObjectKeyword_2_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:539:1: ( (otherlv_5= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:540:1: (otherlv_5= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:540:1: (otherlv_5= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:541:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getExtendsPluginEObjectRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1019); 

                    		newLeafNode(otherlv_5, grammarAccess.getExtendsPluginEObjectAccess().getEObjectReference1ExtendsNsURIEObjectCrossReference_2_1_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:553:6: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:553:6: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:553:8: otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleExtendsPluginEObject1039); 

                        	newLeafNode(otherlv_6, grammarAccess.getExtendsPluginEObjectAccess().getExtendsPluginEObjectKeyword_2_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:557:1: ( (otherlv_7= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:558:1: (otherlv_7= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:558:1: (otherlv_7= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:559:3: otherlv_7= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getExtendsPluginEObjectRule());
                    	        }
                            
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1059); 

                    		newLeafNode(otherlv_7, grammarAccess.getExtendsPluginEObjectAccess().getEObjectReference1ExtendsPluginEObjectCrossReference_2_2_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:571:6: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:571:6: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:571:8: otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleExtendsPluginEObject1079); 

                        	newLeafNode(otherlv_8, grammarAccess.getExtendsPluginEObjectAccess().getExtendsResourceEObjectKeyword_2_3_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:575:1: ( (otherlv_9= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:576:1: (otherlv_9= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:576:1: (otherlv_9= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:577:3: otherlv_9= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getExtendsPluginEObjectRule());
                    	        }
                            
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1099); 

                    		newLeafNode(otherlv_9, grammarAccess.getExtendsPluginEObjectAccess().getEObjectReference1ExtendsResourceEObjectCrossReference_2_3_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:588:4: (otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==13) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:588:6: otherlv_10= 'ExtendsPluginEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )? ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )? ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )? ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    {
                    otherlv_10=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleExtendsPluginEObject1114); 

                        	newLeafNode(otherlv_10, grammarAccess.getExtendsPluginEObjectAccess().getExtendsPluginEObjectKeyword_3_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:592:1: ( (otherlv_11= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:593:1: (otherlv_11= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:593:1: (otherlv_11= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:594:3: otherlv_11= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getExtendsPluginEObjectRule());
                    	        }
                            
                    otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1134); 

                    		newLeafNode(otherlv_11, grammarAccess.getExtendsPluginEObjectAccess().getEObjectReference2ExtendsNsURIEObjectCrossReference_3_1_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:605:2: ( (otherlv_12= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:606:1: (otherlv_12= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:606:1: (otherlv_12= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:607:3: otherlv_12= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getExtendsPluginEObjectRule());
                    	        }
                            
                    otherlv_12=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1154); 

                    		newLeafNode(otherlv_12, grammarAccess.getExtendsPluginEObjectAccess().getEObjectReference3ExtendsPluginEObjectCrossReference_3_2_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:618:2: ( (otherlv_13= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:619:1: (otherlv_13= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:619:1: (otherlv_13= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:620:3: otherlv_13= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getExtendsPluginEObjectRule());
                    	        }
                            
                    otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1174); 

                    		newLeafNode(otherlv_13, grammarAccess.getExtendsPluginEObjectAccess().getEObjectReference4ExtendsResourceEObjectCrossReference_3_3_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:631:2: ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==11) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:632:1: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:632:1: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:633:3: lv_eObjectContainment_14_0= ruleExtendsNsURIEObject
                            {
                             
                            	        newCompositeNode(grammarAccess.getExtendsPluginEObjectAccess().getEObjectContainmentExtendsNsURIEObjectParserRuleCall_3_4_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleExtendsNsURIEObject_in_ruleExtendsPluginEObject1195);
                            lv_eObjectContainment_14_0=ruleExtendsNsURIEObject();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getExtendsPluginEObjectRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"eObjectContainment",
                                    		lv_eObjectContainment_14_0, 
                                    		"ExtendsNsURIEObject");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:649:3: ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==13) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:650:1: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:650:1: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:651:3: lv_eObjectContainment_15_0= ruleExtendsPluginEObject
                            {
                             
                            	        newCompositeNode(grammarAccess.getExtendsPluginEObjectAccess().getEObjectContainmentExtendsPluginEObjectParserRuleCall_3_5_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleExtendsPluginEObject_in_ruleExtendsPluginEObject1217);
                            lv_eObjectContainment_15_0=ruleExtendsPluginEObject();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getExtendsPluginEObjectRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"eObjectContainment",
                                    		lv_eObjectContainment_15_0, 
                                    		"ExtendsPluginEObject");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:667:3: ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==14) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:668:1: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:668:1: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:669:3: lv_eObjectContainment_16_0= ruleExtendsResourceEObject
                            {
                             
                            	        newCompositeNode(grammarAccess.getExtendsPluginEObjectAccess().getEObjectContainmentExtendsResourceEObjectParserRuleCall_3_6_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleExtendsResourceEObject_in_ruleExtendsPluginEObject1239);
                            lv_eObjectContainment_16_0=ruleExtendsResourceEObject();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getExtendsPluginEObjectRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"eObjectContainment",
                                    		lv_eObjectContainment_16_0, 
                                    		"ExtendsResourceEObject");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:685:3: ( (lv_eObjectContainment_17_0= ruleEObject ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:686:1: (lv_eObjectContainment_17_0= ruleEObject )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:686:1: (lv_eObjectContainment_17_0= ruleEObject )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:687:3: lv_eObjectContainment_17_0= ruleEObject
                    {
                     
                    	        newCompositeNode(grammarAccess.getExtendsPluginEObjectAccess().getEObjectContainmentEObjectParserRuleCall_3_7_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEObject_in_ruleExtendsPluginEObject1261);
                    lv_eObjectContainment_17_0=ruleEObject();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExtendsPluginEObjectRule());
                    	        }
                           		add(
                           			current, 
                           			"eObjectContainment",
                            		lv_eObjectContainment_17_0, 
                            		"EObject");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:703:2: ( (lv_eObjectContainment_18_0= ruleEAttribute ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:704:1: (lv_eObjectContainment_18_0= ruleEAttribute )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:704:1: (lv_eObjectContainment_18_0= ruleEAttribute )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:705:3: lv_eObjectContainment_18_0= ruleEAttribute
                    {
                     
                    	        newCompositeNode(grammarAccess.getExtendsPluginEObjectAccess().getEObjectContainmentEAttributeParserRuleCall_3_8_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEAttribute_in_ruleExtendsPluginEObject1282);
                    lv_eObjectContainment_18_0=ruleEAttribute();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExtendsPluginEObjectRule());
                    	        }
                           		add(
                           			current, 
                           			"eObjectContainment",
                            		lv_eObjectContainment_18_0, 
                            		"EAttribute");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:721:2: ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:722:1: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:722:1: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:723:3: lv_eObjectContainment_19_0= ruleMyEAttribute
                    {
                     
                    	        newCompositeNode(grammarAccess.getExtendsPluginEObjectAccess().getEObjectContainmentMyEAttributeParserRuleCall_3_9_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMyEAttribute_in_ruleExtendsPluginEObject1303);
                    lv_eObjectContainment_19_0=ruleMyEAttribute();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExtendsPluginEObjectRule());
                    	        }
                           		add(
                           			current, 
                           			"eObjectContainment",
                            		lv_eObjectContainment_19_0, 
                            		"MyEAttribute");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


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
    // $ANTLR end "ruleExtendsPluginEObject"


    // $ANTLR start "entryRuleExtendsResourceEObject"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:747:1: entryRuleExtendsResourceEObject returns [EObject current=null] : iv_ruleExtendsResourceEObject= ruleExtendsResourceEObject EOF ;
    public final EObject entryRuleExtendsResourceEObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendsResourceEObject = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:748:2: (iv_ruleExtendsResourceEObject= ruleExtendsResourceEObject EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:749:2: iv_ruleExtendsResourceEObject= ruleExtendsResourceEObject EOF
            {
             newCompositeNode(grammarAccess.getExtendsResourceEObjectRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExtendsResourceEObject_in_entryRuleExtendsResourceEObject1341);
            iv_ruleExtendsResourceEObject=ruleExtendsResourceEObject();

            state._fsp--;

             current =iv_ruleExtendsResourceEObject; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExtendsResourceEObject1351); 

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
    // $ANTLR end "entryRuleExtendsResourceEObject"


    // $ANTLR start "ruleExtendsResourceEObject"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:756:1: ruleExtendsResourceEObject returns [EObject current=null] : (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) ;
    public final EObject ruleExtendsResourceEObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_eObjectContainment_14_0 = null;

        EObject lv_eObjectContainment_15_0 = null;

        EObject lv_eObjectContainment_16_0 = null;

        EObject lv_eObjectContainment_17_0 = null;

        EObject lv_eObjectContainment_18_0 = null;

        EObject lv_eObjectContainment_19_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:759:28: ( (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:760:1: (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:760:1: (otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:760:3: otherlv_0= 'ExtendsResourceEObject' ( (lv_name_1_0= ruleValidID ) ) ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) ) (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleExtendsResourceEObject1388); 

                	newLeafNode(otherlv_0, grammarAccess.getExtendsResourceEObjectAccess().getExtendsResourceEObjectKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:764:1: ( (lv_name_1_0= ruleValidID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:765:1: (lv_name_1_0= ruleValidID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:765:1: (lv_name_1_0= ruleValidID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:766:3: lv_name_1_0= ruleValidID
            {
             
            	        newCompositeNode(grammarAccess.getExtendsResourceEObjectAccess().getNameValidIDParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleValidID_in_ruleExtendsResourceEObject1409);
            lv_name_1_0=ruleValidID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExtendsResourceEObjectRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ValidID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:782:2: ( (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) ) | (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) ) | (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) ) )
            int alt11=4;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt11=1;
                }
                break;
            case 11:
                {
                alt11=2;
                }
                break;
            case 13:
                {
                alt11=3;
                }
                break;
            case 14:
                {
                alt11=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:782:3: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:782:3: (otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:782:5: otherlv_2= 'EObject' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleExtendsResourceEObject1423); 

                        	newLeafNode(otherlv_2, grammarAccess.getExtendsResourceEObjectAccess().getEObjectKeyword_2_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:786:1: ( (otherlv_3= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:787:1: (otherlv_3= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:787:1: (otherlv_3= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:788:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getExtendsResourceEObjectRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsResourceEObject1443); 

                    		newLeafNode(otherlv_3, grammarAccess.getExtendsResourceEObjectAccess().getEObjectReference1EObjectCrossReference_2_0_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:800:6: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:800:6: (otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:800:8: otherlv_4= 'ExtendsNsURIEObject' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleExtendsResourceEObject1463); 

                        	newLeafNode(otherlv_4, grammarAccess.getExtendsResourceEObjectAccess().getExtendsNsURIEObjectKeyword_2_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:804:1: ( (otherlv_5= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:805:1: (otherlv_5= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:805:1: (otherlv_5= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:806:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getExtendsResourceEObjectRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsResourceEObject1483); 

                    		newLeafNode(otherlv_5, grammarAccess.getExtendsResourceEObjectAccess().getEObjectReference1ExtendsNsURIEObjectCrossReference_2_1_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:818:6: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:818:6: (otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:818:8: otherlv_6= 'ExtendsPluginEObject' ( (otherlv_7= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleExtendsResourceEObject1503); 

                        	newLeafNode(otherlv_6, grammarAccess.getExtendsResourceEObjectAccess().getExtendsPluginEObjectKeyword_2_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:822:1: ( (otherlv_7= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:823:1: (otherlv_7= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:823:1: (otherlv_7= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:824:3: otherlv_7= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getExtendsResourceEObjectRule());
                    	        }
                            
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsResourceEObject1523); 

                    		newLeafNode(otherlv_7, grammarAccess.getExtendsResourceEObjectAccess().getEObjectReference1ExtendsPluginEObjectCrossReference_2_2_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:836:6: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:836:6: (otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:836:8: otherlv_8= 'ExtendsResourceEObject' ( (otherlv_9= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleExtendsResourceEObject1543); 

                        	newLeafNode(otherlv_8, grammarAccess.getExtendsResourceEObjectAccess().getExtendsResourceEObjectKeyword_2_3_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:840:1: ( (otherlv_9= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:841:1: (otherlv_9= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:841:1: (otherlv_9= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:842:3: otherlv_9= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getExtendsResourceEObjectRule());
                    	        }
                            
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsResourceEObject1563); 

                    		newLeafNode(otherlv_9, grammarAccess.getExtendsResourceEObjectAccess().getEObjectReference1ExtendsResourceEObjectCrossReference_2_3_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:853:4: (otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==14) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:853:6: otherlv_10= 'ExtendsResourceEObject' ( (otherlv_11= RULE_ID ) ) ( (otherlv_12= RULE_ID ) ) ( (otherlv_13= RULE_ID ) ) ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) ) ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) ) ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) ) ( (lv_eObjectContainment_17_0= ruleEObject ) ) ( (lv_eObjectContainment_18_0= ruleEAttribute ) ) ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    {
                    otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleExtendsResourceEObject1578); 

                        	newLeafNode(otherlv_10, grammarAccess.getExtendsResourceEObjectAccess().getExtendsResourceEObjectKeyword_3_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:857:1: ( (otherlv_11= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:858:1: (otherlv_11= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:858:1: (otherlv_11= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:859:3: otherlv_11= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getExtendsResourceEObjectRule());
                    	        }
                            
                    otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsResourceEObject1598); 

                    		newLeafNode(otherlv_11, grammarAccess.getExtendsResourceEObjectAccess().getEObjectReference2ExtendsNsURIEObjectCrossReference_3_1_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:870:2: ( (otherlv_12= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:871:1: (otherlv_12= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:871:1: (otherlv_12= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:872:3: otherlv_12= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getExtendsResourceEObjectRule());
                    	        }
                            
                    otherlv_12=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsResourceEObject1618); 

                    		newLeafNode(otherlv_12, grammarAccess.getExtendsResourceEObjectAccess().getEObjectReference3ExtendsPluginEObjectCrossReference_3_2_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:883:2: ( (otherlv_13= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:884:1: (otherlv_13= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:884:1: (otherlv_13= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:885:3: otherlv_13= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getExtendsResourceEObjectRule());
                    	        }
                            
                    otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtendsResourceEObject1638); 

                    		newLeafNode(otherlv_13, grammarAccess.getExtendsResourceEObjectAccess().getEObjectReference4ExtendsResourceEObjectCrossReference_3_3_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:896:2: ( (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:897:1: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:897:1: (lv_eObjectContainment_14_0= ruleExtendsNsURIEObject )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:898:3: lv_eObjectContainment_14_0= ruleExtendsNsURIEObject
                    {
                     
                    	        newCompositeNode(grammarAccess.getExtendsResourceEObjectAccess().getEObjectContainmentExtendsNsURIEObjectParserRuleCall_3_4_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExtendsNsURIEObject_in_ruleExtendsResourceEObject1659);
                    lv_eObjectContainment_14_0=ruleExtendsNsURIEObject();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExtendsResourceEObjectRule());
                    	        }
                           		add(
                           			current, 
                           			"eObjectContainment",
                            		lv_eObjectContainment_14_0, 
                            		"ExtendsNsURIEObject");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:914:2: ( (lv_eObjectContainment_15_0= ruleExtendsPluginEObject ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:915:1: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:915:1: (lv_eObjectContainment_15_0= ruleExtendsPluginEObject )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:916:3: lv_eObjectContainment_15_0= ruleExtendsPluginEObject
                    {
                     
                    	        newCompositeNode(grammarAccess.getExtendsResourceEObjectAccess().getEObjectContainmentExtendsPluginEObjectParserRuleCall_3_5_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExtendsPluginEObject_in_ruleExtendsResourceEObject1680);
                    lv_eObjectContainment_15_0=ruleExtendsPluginEObject();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExtendsResourceEObjectRule());
                    	        }
                           		add(
                           			current, 
                           			"eObjectContainment",
                            		lv_eObjectContainment_15_0, 
                            		"ExtendsPluginEObject");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:932:2: ( (lv_eObjectContainment_16_0= ruleExtendsResourceEObject ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:933:1: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:933:1: (lv_eObjectContainment_16_0= ruleExtendsResourceEObject )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:934:3: lv_eObjectContainment_16_0= ruleExtendsResourceEObject
                    {
                     
                    	        newCompositeNode(grammarAccess.getExtendsResourceEObjectAccess().getEObjectContainmentExtendsResourceEObjectParserRuleCall_3_6_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExtendsResourceEObject_in_ruleExtendsResourceEObject1701);
                    lv_eObjectContainment_16_0=ruleExtendsResourceEObject();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExtendsResourceEObjectRule());
                    	        }
                           		add(
                           			current, 
                           			"eObjectContainment",
                            		lv_eObjectContainment_16_0, 
                            		"ExtendsResourceEObject");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:950:2: ( (lv_eObjectContainment_17_0= ruleEObject ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:951:1: (lv_eObjectContainment_17_0= ruleEObject )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:951:1: (lv_eObjectContainment_17_0= ruleEObject )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:952:3: lv_eObjectContainment_17_0= ruleEObject
                    {
                     
                    	        newCompositeNode(grammarAccess.getExtendsResourceEObjectAccess().getEObjectContainmentEObjectParserRuleCall_3_7_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEObject_in_ruleExtendsResourceEObject1722);
                    lv_eObjectContainment_17_0=ruleEObject();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExtendsResourceEObjectRule());
                    	        }
                           		add(
                           			current, 
                           			"eObjectContainment",
                            		lv_eObjectContainment_17_0, 
                            		"EObject");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:968:2: ( (lv_eObjectContainment_18_0= ruleEAttribute ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:969:1: (lv_eObjectContainment_18_0= ruleEAttribute )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:969:1: (lv_eObjectContainment_18_0= ruleEAttribute )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:970:3: lv_eObjectContainment_18_0= ruleEAttribute
                    {
                     
                    	        newCompositeNode(grammarAccess.getExtendsResourceEObjectAccess().getEObjectContainmentEAttributeParserRuleCall_3_8_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEAttribute_in_ruleExtendsResourceEObject1743);
                    lv_eObjectContainment_18_0=ruleEAttribute();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExtendsResourceEObjectRule());
                    	        }
                           		add(
                           			current, 
                           			"eObjectContainment",
                            		lv_eObjectContainment_18_0, 
                            		"EAttribute");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:986:2: ( (lv_eObjectContainment_19_0= ruleMyEAttribute ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:987:1: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:987:1: (lv_eObjectContainment_19_0= ruleMyEAttribute )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:988:3: lv_eObjectContainment_19_0= ruleMyEAttribute
                    {
                     
                    	        newCompositeNode(grammarAccess.getExtendsResourceEObjectAccess().getEObjectContainmentMyEAttributeParserRuleCall_3_9_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMyEAttribute_in_ruleExtendsResourceEObject1764);
                    lv_eObjectContainment_19_0=ruleMyEAttribute();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExtendsResourceEObjectRule());
                    	        }
                           		add(
                           			current, 
                           			"eObjectContainment",
                            		lv_eObjectContainment_19_0, 
                            		"MyEAttribute");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


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
    // $ANTLR end "ruleExtendsResourceEObject"


    // $ANTLR start "entryRuleEObject"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:1012:1: entryRuleEObject returns [EObject current=null] : iv_ruleEObject= ruleEObject EOF ;
    public final EObject entryRuleEObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEObject = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:1013:2: (iv_ruleEObject= ruleEObject EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:1014:2: iv_ruleEObject= ruleEObject EOF
            {
             newCompositeNode(grammarAccess.getEObjectRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEObject_in_entryRuleEObject1802);
            iv_ruleEObject=ruleEObject();

            state._fsp--;

             current =iv_ruleEObject; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEObject1812); 

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
    // $ANTLR end "entryRuleEObject"


    // $ANTLR start "ruleEObject"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:1021:1: ruleEObject returns [EObject current=null] : ( () otherlv_1= 'object' ) ;
    public final EObject ruleEObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:1024:28: ( ( () otherlv_1= 'object' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:1025:1: ( () otherlv_1= 'object' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:1025:1: ( () otherlv_1= 'object' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:1025:2: () otherlv_1= 'object'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:1025:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:1026:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEObjectAccess().getEObjectAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleEObject1858); 

                	newLeafNode(otherlv_1, grammarAccess.getEObjectAccess().getObjectKeyword_1());
                

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
    // $ANTLR end "ruleEObject"


    // $ANTLR start "entryRuleValidID"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:1043:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:1044:2: (iv_ruleValidID= ruleValidID EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:1045:2: iv_ruleValidID= ruleValidID EOF
            {
             newCompositeNode(grammarAccess.getValidIDRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleValidID_in_entryRuleValidID1895);
            iv_ruleValidID=ruleValidID();

            state._fsp--;

             current =iv_ruleValidID.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValidID1906); 

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
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:1052:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:1055:28: (this_ID_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/metamodelreferencing/tests/parser/antlr/internal/InternalEcoreReferenceTestLanguage.g:1056:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleValidID1945); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall()); 
                

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
    // $ANTLR end "ruleValidID"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExtendsNsURIEObject_in_ruleModel131 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleExtendsPluginEObject_in_ruleModel152 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_ruleExtendsResourceEObject_in_ruleModel173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExtendsNsURIEObject_in_entryRuleExtendsNsURIEObject209 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExtendsNsURIEObject219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleExtendsNsURIEObject256 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleValidID_in_ruleExtendsNsURIEObject277 = new BitSet(new long[]{0x0000000000007800L});
        public static final BitSet FOLLOW_12_in_ruleExtendsNsURIEObject291 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject311 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_11_in_ruleExtendsNsURIEObject331 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject351 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleExtendsNsURIEObject371 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject391 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_14_in_ruleExtendsNsURIEObject411 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject431 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleExtendsNsURIEObject446 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject466 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject486 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject506 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsNsURIEObject526 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleExtendsNsURIEObject_in_ruleExtendsNsURIEObject547 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleExtendsPluginEObject_in_ruleExtendsNsURIEObject569 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleExtendsResourceEObject_in_ruleExtendsNsURIEObject591 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleEObject_in_ruleExtendsNsURIEObject613 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_ruleEAttribute_in_ruleExtendsNsURIEObject634 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleMyEAttribute_in_ruleExtendsNsURIEObject655 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMyEAttribute_in_entryRuleMyEAttribute693 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMyEAttribute703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleMyEAttribute749 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEAttribute_in_entryRuleEAttribute785 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEAttribute795 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleEAttribute841 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExtendsPluginEObject_in_entryRuleExtendsPluginEObject877 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExtendsPluginEObject887 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleExtendsPluginEObject924 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleValidID_in_ruleExtendsPluginEObject945 = new BitSet(new long[]{0x0000000000007800L});
        public static final BitSet FOLLOW_12_in_ruleExtendsPluginEObject959 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsPluginEObject979 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_11_in_ruleExtendsPluginEObject999 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1019 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleExtendsPluginEObject1039 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1059 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_14_in_ruleExtendsPluginEObject1079 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1099 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleExtendsPluginEObject1114 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1134 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1154 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsPluginEObject1174 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleExtendsNsURIEObject_in_ruleExtendsPluginEObject1195 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleExtendsPluginEObject_in_ruleExtendsPluginEObject1217 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleExtendsResourceEObject_in_ruleExtendsPluginEObject1239 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleEObject_in_ruleExtendsPluginEObject1261 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_ruleEAttribute_in_ruleExtendsPluginEObject1282 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleMyEAttribute_in_ruleExtendsPluginEObject1303 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExtendsResourceEObject_in_entryRuleExtendsResourceEObject1341 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExtendsResourceEObject1351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleExtendsResourceEObject1388 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleValidID_in_ruleExtendsResourceEObject1409 = new BitSet(new long[]{0x0000000000007800L});
        public static final BitSet FOLLOW_12_in_ruleExtendsResourceEObject1423 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsResourceEObject1443 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_11_in_ruleExtendsResourceEObject1463 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsResourceEObject1483 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_13_in_ruleExtendsResourceEObject1503 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsResourceEObject1523 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleExtendsResourceEObject1543 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsResourceEObject1563 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleExtendsResourceEObject1578 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsResourceEObject1598 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsResourceEObject1618 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtendsResourceEObject1638 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_ruleExtendsNsURIEObject_in_ruleExtendsResourceEObject1659 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleExtendsPluginEObject_in_ruleExtendsResourceEObject1680 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_ruleExtendsResourceEObject_in_ruleExtendsResourceEObject1701 = new BitSet(new long[]{0x0000000000026800L});
        public static final BitSet FOLLOW_ruleEObject_in_ruleExtendsResourceEObject1722 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_ruleEAttribute_in_ruleExtendsResourceEObject1743 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleMyEAttribute_in_ruleExtendsResourceEObject1764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEObject_in_entryRuleEObject1802 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEObject1812 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleEObject1858 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID1895 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValidID1906 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleValidID1945 = new BitSet(new long[]{0x0000000000000002L});
    }


}